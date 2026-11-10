// Original binary: sg/ec/CEWKc0wSPYJtAeKy
package sg.ec;

import hex.script.api.FontFace;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import java.util.zip.CRC32;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class FontRegistry implements MinecraftAccess {
   private static final String field06682 = FontRegistry.field06699.toLowerCase(Locale.ROOT);
   private static final String field06683 = "script_";
   private static final int field06684 = 0;
   private static final Map<String, String> field06685 = new LinkedHashMap<>();
   private static final Map<String, FontRenderer> field06686 = new LinkedHashMap<>();
   private static final Map<String, String> field06687 = new LinkedHashMap<>();
   private static final Set<String> field06688 = new LinkedHashSet<>();
   private static final Reference2ObjectOpenHashMap<String, FontRenderer> field06689 = new Reference2ObjectOpenHashMap();
   private static boolean field06690;
   private static final String field06691 = "нет такого шрифта";
   private static final String field06692 = "пустой путь к шрифту";
   private static final String field06693 = "пак скриптов ещё не перезагрузился";
   private static final String field06694 = "в раскладке нет atlas, metrics или glyphs";
   private static final String field06695 = ".json";
   private static final String field06696 = ".png";
   private static final String field06697 = "font";
   private static final String field06698 = "This is a utility class and cannot be instantiated";
   private static final String field06699 = "Hex";

   private static String method02877(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int sx = 0; sx < var0.length(); sx++) {
            char sxx = Character.toLowerCase(var0.charAt(sx));
            var1.append(!Character.isLetterOrDigit(sxx) && sxx != '_' ? '_' : sxx);
         }

         return var1.toString();
      } else {
         return field06697;
      }
   }

   private static boolean method02878(String var0) {
      for (String var4 : DefaultFontLoader.method05393()) {
         if (var4.equals(var0)) {
            return true;
         }
      }

      return false;
   }

   public static String[] method02879() {
      var var0 = new LinkedHashSet<>(Arrays.asList(DefaultFontLoader.method05393()));
      var0.addAll(field06685.keySet());
      return var0.toArray(new String[0]);
   }

   public static float method02880(String var0, float var1) {
      return method02886(var0).method09485(var1);
   }

   public static FontRenderer method02881(String var0) {
      return method02893(method02877(var0));
   }

   private static String method02882(byte[] var0, byte[] var1) {
      CRC32 var2 = new CRC32();
      var2.update(var0);
      var2.update(var1);
      return Long.toHexString(var2.getValue());
   }

   private FontRegistry() {
      throw new UnsupportedOperationException(field06698);
   }

   private static void method02883(Path var0, byte[] var1) throws IOException {
      if (!Files.isRegularFile(var0) || !Arrays.equals(Files.readAllBytes(var0), var1)) {
         Files.write(var0, var1);
      }
   }

   public static String method02884(String var0) {
      String var1 = method02877(var0);
      if (!field06685.containsKey(var1)) {
         return method02878(var1) ? null : field06691;
      }

      method02893(var1);
      return field06687.get(var1);
   }

   private static String method02885(String var0) {
      if (var0 == null) {
         return null;
      }

      String var1 = var0.trim();
      String var2 = var1.toLowerCase(Locale.ROOT);
      if (var2.endsWith(field06695) || var2.endsWith(field06696)) {
         var1 = var1.substring(0, var1.lastIndexOf(46));
      }

      return var1.isEmpty() ? null : var1;
   }

   public static FontRenderer method02886(String var0) {
      FontRenderer var1 = (FontRenderer)field06689.get(var0);
      if (var1 != null) {
         return var1;
      }

      String var2 = method02877(var0);
      FontRenderer var3 = method02893(var2);
      if (var3 == null && field06685.containsKey(var2)) {
         return DefaultFontLoader.method05391(var0);
      }

      FontRenderer var4 = var3 == null ? DefaultFontLoader.method05391(var0) : var3;
      if (field06689.size() >= 64) {
         field06689.clear();
      }

      field06689.put(var0, var4);
      return var4;
   }

   private static Identifier method02887(String var0) {
      return Identifier.fromNamespaceAndPath(field06682, "fonts/" + var0 + ".json");
   }

   private static FontFace method02888(String var0) {
      return new FontFace(var0, FontRegistry::method02890, FontRegistry::method02880, FontRegistry::method02884);
   }

   public static FontFace method02889(String var0) {
      return method02888(method02877(var0));
   }

   public static float method02890(String var0, String var1, float var2) {
      return method02886(var0).method09486(var1, var2);
   }

   public static boolean method02891() {
      boolean var0 = field06690;
      field06690 = false;
      return var0;
   }

   public static FontFace method02892(String var0, String var1) {
      String var2 = method02877(var0);
      method02895(var2, var1);
      return method02888(var2);
   }

   private static FontRenderer method02893(String var0) {
      FontRenderer var1 = field06686.get(var0);
      if (var1 != null) {
         return var1;
      }

      String var2 = field06685.get(var0);
      if (var2 != null && !field06688.contains(var0)) {
         if (mc != null && mc.getResourceManager() != null && !mc.getResourceManager().getResource(method02887(var2)).isEmpty()) {
            try {
               FontRenderer var3 = new FontRenderer(var2);
               if (var3.field21527.method06997() != null && var3.field21527.method07006() != null && !var3.field21527.field16573.isEmpty()) {
                  field06686.put(var0, var3);
                  field06687.remove(var0);
                  return var3;
               } else {
                  field06688.add(var0);
                  field06687.put(var0, field06694);
                  return null;
               }
            } catch (Throwable var4) {
               field06688.add(var0);
               field06687.put(var0, String.valueOf(var4));
               return null;
            }
         } else {
            field06687.put(var0, field06693);
            field06690 = true;
            return null;
         }
      } else {
         return null;
      }
   }

   public static void method02894() {
      field06689.clear();
      field06685.clear();
      field06686.clear();
      field06687.clear();
      field06688.clear();
   }

   private static void method02895(String var0, String var1) {
      String var2 = method02885(var1);
      if (var2 == null) {
         field06687.put(var0, field06692);
      } else {
         byte[] var3 = ResourcePathUtils.method11309(var2 + ".json");
         byte[] var4 = ResourcePathUtils.method11309(var2 + ".png");
         if (var3 != null && var4 != null) {
            ScriptSourceLoader var5 = ScriptLifecycle.method03300();
            String var6 = var5 == null ? "" : var5.method08400() + "_";
            String var7 = "script_" + var6 + var0 + "_" + method02882(var3, var4);

            try {
               Path var8 = new File(ScriptManager.method01286(), "assets/" + field06682 + "/fonts").toPath();
               Files.createDirectories(var8);
               method02896(var8, var0, var7);
               method02883(var8.resolve(var7 + ".json"), var3);
               method02883(var8.resolve(var7 + ".png"), var4);
            } catch (IOException var9) {
               field06687.put(var0, "не записался в пак: " + var9.getMessage());
               return;
            }

            if (!var7.equals(field06685.put(var0, var7))) {
               field06686.remove(var0);
               field06688.remove(var0);
               field06689.clear();
            }

            field06687.remove(var0);
         } else {
            field06687.put(var0, "в scripts/assets нет пары " + var2 + ".png и " + var2 + ".json");
         }
      }
   }

   private static void method02896(Path var0, String var1, String var2) throws IOException {
      String var3 = var2.substring(0, var2.lastIndexOf(95) + 1);

      try (Stream<Path> var4 = Files.list(var0)) {
         for (Path var6 : (Iterable<Path>) (Iterable) var4.toList()) {
            String var7 = var6.getFileName().toString();
            int var8 = var7.lastIndexOf(46);
            if (var8 > 0) {
               String var9 = var7.substring(0, var8);
               if (var9.startsWith(var3) && !var9.equals(var2) && var9.indexOf(95, var3.length()) < 0) {
                  Files.deleteIfExists(var6);
               }
            }
         }
      }
   }
}
