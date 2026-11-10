// Original binary: sg/ec/QsRCVDHGvuYa2qlK
package sg.ec;

import net.minecraft.util.Mth;

// $VF: Compiled from s
public final class LegitAuraRotation implements AuraRotationStrategy {
   private static final float field11367 = 100.0F;
   private float field11368;
   private static final String field11369 = "Legit";
   private static final float field11370 = 0.62F;
   private static final float field11371 = 0.38F;
   private static final float field11372 = 0.08F;
   private static final float field11373 = 0.05F;
   private static final float field11374 = 0.007F;
   private static final float field11375 = 0.03F;
   private static final float field11376 = 0.007F;
   private static final float field11377 = 0.007F;
   private static final float field11378 = 0.65F;
   private static final float field11379 = 0.1F;
   private static final float field11380 = 100.0F;
   private static final float field11381 = 0.1F;
   private static final float field11382 = 100.0F;

   @Override
   public void method02268() {
      this.field11368 = 0.0F;
   }

   private float method05246(AuraRotationController.Nested160 var1) {
      return var1.rayTrace() ? field11379 : (var1.isGliding() ? var1.aura().method00449() : var1.aura().method00448()) / field11380;
   }

   private void method05247(boolean var1) {
      if (!var1) {
         this.field11368 = this.field11368 + field11374;
      } else if (this.field11368 > 0.0F) {
         this.field11368 = this.field11368 - ((mc.player.isFallFlying() ? field11375 : field11376) + RandomUtils.method10442() * field11377);
      }

      this.field11368 = Mth.clamp(this.field11368, 0.0F, 1.0F);
   }

   @Override
   public void method02266(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2) {
      if (mc.player != null) {
         float var3 = mc.player.getYRot();
         float var4 = mc.player.getXRot();
         this.method05247(var1.rayTrace());
         if (var1.rayTrace()) {
            var2.method05332(var3);
            var2.method05339(var4);
            var2.method05325(this.method05246(var1), this.method05249(var1));
            var2.method05335(true);
         } else {
            float var5 = Mth.wrapDegrees(var1.rawYaw() - var3);
            float var6 = var1.rawPitch() - var4;
            float var7 = Mth.clamp(field11370 + this.field11368 * field11371, 0.0F, 1.0F);
            float var8 = this.method05248(field11372);
            float var9 = this.method05248(field11373);
            var2.method05332(var3 + var5 * var7 + var8);
            var2.method05339(var4 + var6 * var7 + var9);
            var2.method05325(this.method05246(var1), this.method05249(var1));
            var2.method05335(true);
         }
      }
   }

   private float method05248(float var1) {
      float var2 = var1 * (1.0F - this.field11368 * field11378);
      return var2 > 0.0F ? RandomUtils.method10454(-var2, var2) : 0.0F;
   }

   private float method05249(AuraRotationController.Nested160 var1) {
      return var1.rayTrace() ? field11381 : (var1.isGliding() ? var1.aura().method00416() : var1.aura().method00417()) / field11382;
   }

   @Override
   public String method02258() {
      return field11369;
   }
}
