// Original binary: sg/ec/xJfILt3e0Gv2Izre
package sg.ec;

import java.nio.charset.StandardCharsets;
import java.util.List;

// $VF: Compiled from s
public final class ResourcePathUtils {
   private static final String field25739 = "/";
   private static final String field25740 = "..";

   private ResourcePathUtils() {
   }

   static String[] method11305(String var0) {
      ScriptSourceLoader var1 = ScriptLifecycle.method03300();
      if (var1 == null) {
         return new String[0];
      }

      var var2 = var1.method08391(method11308(var0));
      return var2.toArray(new String[0]);
   }

   static boolean method11306(String var0) {
      String var1 = method11308(var0);
      ScriptSourceLoader var2 = ScriptLifecycle.method03301(var1);
      return var2 != null && var2.method08388(var1);
   }

   static String method11307(String var0) {
      byte[] var1 = method11309(var0);
      return var1 == null ? null : new String(var1, StandardCharsets.UTF_8);
   }

   private static String method11308(String var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.replace('\\', '/');

      while (var1.startsWith(field25739)) {
         var1 = var1.substring(1);
      }

      return var1.contains(field25740) ? "" : var1;
   }

   static byte[] method11309(String var0) {
      String var1 = method11308(var0);
      ScriptSourceLoader var2 = ScriptLifecycle.method03301(var1);
      return var2 == null ? null : var2.method08397(var1);
   }
}
