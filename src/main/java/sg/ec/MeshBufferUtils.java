// Original binary: sg/ec/eeSfroNt3OEQqKCh
package sg.ec;

import hex.script.api.Gpu;
import hex.script.api.MeshBuilder;
import java.util.LinkedHashMap;
import java.util.Map;

// $VF: Compiled from s
public final class MeshBufferUtils {
   public static final int field18672 = 11;
   private static final Map<String, float[]> field18673 = new LinkedHashMap<>();
   private static final Map<String, Boolean> field18674 = new LinkedHashMap<>();
   private static final Gpu field18675 = new Gpu(MeshBufferUtils::method07835, MeshBufferUtils::method07838, MeshBufferUtils::method07834);
   private static final String field18676 = "mesh";
   private static final String field18677 = "This is a utility class and cannot be instantiated";

   private MeshBufferUtils() {
      throw new UnsupportedOperationException(field18677);
   }

   public static boolean method07831(String var0) {
      return var0 != null && Boolean.TRUE.equals(field18674.get(var0));
   }

   public static void method07832() {
      field18673.clear();
      field18674.clear();
      ScriptRenderResources.method08790();
   }

   public static Gpu method07833() {
      return field18675;
   }

   private static boolean method07834(String var0) {
      field18674.remove(var0);
      return field18673.remove(var0) != null;
   }

   private static MeshBuilder method07835(String var0) {
      return new MeshBuilder(var0 != null && !var0.isEmpty() ? var0 : field18676, MeshBufferUtils::method07840);
   }

   public static int method07836(int var0, int var1) {
      if (var1 == -1) {
         return var0;
      }

      int var2 = (var0 >>> 24) * (var1 >>> 24) / 255;
      int var3 = (var0 >> 16 & 0xFF) * (var1 >> 16 & 0xFF) / 255;
      int var4 = (var0 >> 8 & 0xFF) * (var1 >> 8 & 0xFF) / 255;
      int var5 = (var0 & 0xFF) * (var1 & 0xFF) / 255;
      return var2 << 24 | var3 << 16 | var4 << 8 | var5;
   }

   public static int method07837(float[] var0) {
      return var0 == null ? 0 : var0.length / 11 / 3 * 3;
   }

   private static String[] method07838() {
      return field18673.keySet().toArray(new String[0]);
   }

   public static float[] method07839(String var0) {
      return var0 == null ? null : field18673.get(var0);
   }

   private static int method07840(String var0, float[] var1, boolean var2) {
      if (var1 != null && var1.length >= 33) {
         field18673.put(var0, var1);
         field18674.put(var0, var2);
         return var1.length / 11;
      } else {
         field18673.remove(var0);
         field18674.remove(var0);
         return 0;
      }
   }
}
