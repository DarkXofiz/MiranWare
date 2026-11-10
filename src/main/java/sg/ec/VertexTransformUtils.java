// Original binary: sg/ec/1WJHzVQ3gxxV9HBJ
package sg.ec;

import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Matrix4fc;

// $VF: Compiled from s
public final class VertexTransformUtils {
   private VertexTransformUtils() {
   }

   public static VertexConsumer method00301(VertexConsumer var0, Matrix4fc var1, float var2, float var3, float var4) {
      return var0.addVertex(
         var1.m00() * var2 + var1.m10() * var3 + var1.m20() * var4 + var1.m30(),
         var1.m01() * var2 + var1.m11() * var3 + var1.m21() * var4 + var1.m31(),
         var1.m02() * var2 + var1.m12() * var3 + var1.m22() * var4 + var1.m32()
      );
   }

   public static void method00302(VertexConsumer var0, Matrix4fc var1, float var2, float var3, float var4, int var5) {
      method00301(var0, var1, var2, var3, var4).setColor(var5);
   }

   public static void method00303(
      VertexConsumer var0, Matrix4fc var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9
   ) {
      method00301(var0, var1, var2, var3, var4)
         .setColor(var5)
         .setNormal(
            var1.m00() * var6 + var1.m10() * var7 + var1.m20() * var8,
            var1.m01() * var6 + var1.m11() * var7 + var1.m21() * var8,
            var1.m02() * var6 + var1.m12() * var7 + var1.m22() * var8
         )
         .setLineWidth(var9);
   }
}
