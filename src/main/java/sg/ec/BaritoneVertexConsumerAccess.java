// Original binary: sg/ec/IlWIDfWI3sCQujH4
package sg.ec;

import org.joml.Matrix4f;

// $VF: Compiled from s
public interface BaritoneVertexConsumerAccess {
   void lineVertexPre(float var1, float var2, float var3, int var4, float var5, float var6, float var7, float var8);

   void lineVertex(Matrix4f var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9);

   void coloredVertexPre(float var1, float var2, float var3, int var4);

   void coloredVertexF(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

   void lineVertexF(
      Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12
   );

   void coloredVertexFPre(float var1, float var2, float var3, float var4, float var5, float var6, float var7);

   void texturedVertex(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, int var7);

   void coloredVertex(Matrix4f var1, float var2, float var3, float var4, int var5);

   void texturedVertexPre(float var1, float var2, float var3, float var4, float var5, int var6);
}
