// Original binary: sg/ec/bL6ldJVUJyZGr7ZF
package sg.ec;

import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.util.Mth;
import org.joml.Matrix3x2fc;

// $VF: Compiled from s
public final class ScreenRectangleHooks {
   private ScreenRectangleHooks() {
   }

   public static ScreenRectangle method07115(ScreenRectangle var0, Matrix3x2fc var1) {
      float var2 = var1.m00();
      float var3 = var1.m01();
      float var4 = var1.m10();
      float var5 = var1.m11();
      float var6 = var1.m20();
      float var7 = var1.m21();
      int var8 = var0.left();
      int var9 = var0.top();
      int var10 = var0.right();
      int var11 = var0.bottom();
      float var12 = var2 * var8 + var4 * var9 + var6;
      float var13 = var3 * var8 + var5 * var9 + var7;
      float var14 = var2 * var10 + var4 * var9 + var6;
      float var15 = var3 * var10 + var5 * var9 + var7;
      float var16 = var2 * var8 + var4 * var11 + var6;
      float var17 = var3 * var8 + var5 * var11 + var7;
      float var18 = var2 * var10 + var4 * var11 + var6;
      float var19 = var3 * var10 + var5 * var11 + var7;
      float var20 = Math.min(Math.min(var12, var16), Math.min(var14, var18));
      float var21 = Math.max(Math.max(var12, var16), Math.max(var14, var18));
      float var22 = Math.min(Math.min(var13, var17), Math.min(var15, var19));
      float var23 = Math.max(Math.max(var13, var17), Math.max(var15, var19));
      return new ScreenRectangle(Mth.floor(var20), Mth.floor(var22), Mth.ceil(var21 - var20), Mth.ceil(var23 - var22));
   }
}
