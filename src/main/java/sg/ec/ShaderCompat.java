package sg.ec;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 26.3 compiles GLSL to SPIR-V: {@code #moj_import} is gone and every stage input/output needs an explicit location.
 * Upgrades the client's pre-26.3 shader sources when they are loaded.
 */
public final class ShaderCompat {
   private static final Pattern IO = Pattern.compile("^(\\s*)((?:flat|smooth|noperspective|centroid)\\s+)?(in|out)\\s+(\\w+)\\s+(\\w+)\\s*(\\[[^\\]]*\\])?\\s*;");
   private static final Map<String, Integer> VARYING_LOCATIONS = new ConcurrentHashMap<>();

   private ShaderCompat() {
   }

   public static String upgrade(String source, boolean vertex, boolean include) {
      if (source == null) {
         return null;
      }

      boolean legacy = source.contains("#moj_import") || source.contains("gl_VertexID") || include && source.contains("#version");
      if (!legacy && !hasUnlocatedIo(source)) {
         return source;
      }

      String text = source.replace("#moj_import", "#include").replace("gl_VertexID", "gl_VertexIndex").replace("gl_InstanceID", "gl_InstanceIndex");
      if (include) {
         text = text.replaceAll("(?m)^\\s*#version[^\\n]*\\n?", "");
      }
      StringBuilder out = new StringBuilder(text.length() + 256);
      int depth = 0;
      int attributeIndex = 0;
      int fragmentOutIndex = 0;
      boolean extensionPresent = text.contains("GL_ARB_separate_shader_objects");

      for (String line : text.split("\n", -1)) {
         String trimmed = line.trim();
         if (depth == 0 && !trimmed.startsWith("//") && !line.contains("layout(")) {
            Matcher m = IO.matcher(line);
            if (m.find()) {
               boolean isIn = m.group(3).equals("in");
               int location;
               if (vertex && isIn) {
                  location = attributeIndex++;
               } else if (!vertex && !isIn && !include) {
                  location = fragmentOutIndex++;
               } else {
                  location = VARYING_LOCATIONS.computeIfAbsent(m.group(5), k -> VARYING_LOCATIONS.size());
               }

               line = m.group(1) + "layout(location = " + location + ") " + line.substring(m.group(1).length());
            }
         }

         for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '{') {
               depth++;
            } else if (c == '}') {
               depth = Math.max(0, depth - 1);
            }
         }

         out.append(line).append('\n');
         if (!include && !extensionPresent && trimmed.startsWith("#version")) {
            out.append("#extension GL_ARB_separate_shader_objects : require\n");
            extensionPresent = true;
         }
      }

      out.setLength(out.length() - 1);
      return out.toString();
   }

   private static boolean hasUnlocatedIo(String source) {
      int depth = 0;
      for (String line : source.split("\n")) {
         if (depth == 0 && !line.contains("layout(") && IO.matcher(line).find()) {
            return true;
         }
         for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '{') {
               depth++;
            } else if (c == '}') {
               depth = Math.max(0, depth - 1);
            }
         }
      }
      return false;
   }

   private static final Pattern LOCATED = Pattern.compile("layout\\(location\\s*=\\s*(\\d+)\\)\\s*((?:flat|smooth|noperspective|centroid)\\s+)?(in|out)\\s+(\\w+)\\s+(\\w+)");

   /** Rewrites fragment input locations so they match the vertex outputs with the same names. */
   public static String matchFragmentInputs(String vertex, String fragment) {
      Map<String, Integer> outs = new java.util.HashMap<>();
      Matcher vm = LOCATED.matcher(vertex);
      while (vm.find()) {
         if (vm.group(3).equals("out")) {
            outs.put(vm.group(5), Integer.parseInt(vm.group(1)));
         }
      }
      if (outs.isEmpty()) {
         return fragment;
      }
      Matcher fm = LOCATED.matcher(fragment);
      StringBuilder sb = new StringBuilder();
      while (fm.find()) {
         Integer loc = fm.group(3).equals("in") ? outs.get(fm.group(5)) : null;
         String rep = loc == null ? fm.group(0) : fm.group(0).replaceFirst("location\\s*=\\s*\\d+", "location = " + loc);
         fm.appendReplacement(sb, Matcher.quoteReplacement(rep));
      }
      fm.appendTail(sb);
      return sb.toString();
   }
}
