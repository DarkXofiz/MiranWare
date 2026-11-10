// Original binary: sg/ec/tO3CB0qaWempxEFd
package sg.ec;

import org.joml.FrustumIntersection;

// $VF: Compiled from s
public final class FrustumHooks {
   public static int method10821(
      FrustumIntersection var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17
   ) {
      boolean var19 = var0.testAab(
         (float)(var7 - var1), (float)(var9 - var3), (float)(var11 - var5), (float)(var13 - var1), (float)(var15 - var3), (float)(var17 - var5)
      );
      return var19 ? -2 : 0;
   }

   private FrustumHooks() {
   }
}
