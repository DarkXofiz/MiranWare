// Original binary: sg/ec/1vduQjfVBKRt7XrU
package sg.ec;

import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Matrix4f;

// $VF: Compiled from s
public interface ExtendedVertexConsumer extends VertexConsumer {
   ExtendedVertexConsumer thickness(float var1);

   ExtendedVertexConsumer vec2f(float var1, float var2);

   ExtendedVertexConsumer smooth(float var1);

   void coloredVertex(Matrix4f var1, float var2, float var3, float var4, int var5);

   ExtendedVertexConsumer range(float var1);

   void lineVertex(Matrix4f var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9);

   void glyphVertex(float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8);

   ExtendedVertexConsumer coord(float var1, float var2);

   ExtendedVertexConsumer radius(float var1, float var2, float var3, float var4);

   ExtendedVertexConsumer size(float var1, float var2);
}
