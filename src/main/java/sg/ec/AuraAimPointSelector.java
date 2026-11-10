// Original binary: sg/ec/65HVAeJkb2guQ02s
package sg.ec;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class AuraAimPointSelector implements MinecraftAccess {
   private static final double field02682 = 0.1;
   private volatile AuraAimPointSelector.Nested38 field02683 = AuraAimPointSelector.Nested38.NONE;
   private volatile Vec3 field02684 = null;
   private final EntityAimPointSampler field02685 = new EntityAimPointSampler();
   private static final String field02686 = "Matrix";
   private static final float field02687 = 3.0F;
   private static final float field02688 = 3.0F;
   private static final double field02689 = 0.1;
   private static final float field02690 = 0.25F;

   public void method01257(ElytraTarget var1, AttackAura var2, LivingEntity var3) {
      if (var3 == null) {
         this.field02683 = AuraAimPointSelector.Nested38.NONE;
         this.field02684 = null;
      } else if (mc.player != null) {
         boolean var4 = mc.player.isFallFlying();
         if (var4 && var1.method03937() && var1.field11504.method03022() && var1.field11515 != null) {
            this.field02684 = var1.field11515;
            this.field02683 = AuraAimPointSelector.Nested38.ELYTRA_RESOLVE;
         } else {
            boolean sx = var4
               && var3.isFallFlying()
               && var1.method03937()
               && var1.field11506.method03022()
               && var2.field00794
               && !ModuleManager.INSTANCE.method08258().method03937();
            var2.field00787 = sx;
            if (sx) {
               this.field02683 = AuraAimPointSelector.Nested38.ELYTRA_CHASE;
            } else if (var4) {
               this.field02683 = AuraAimPointSelector.Nested38.GLIDING_UP;
            } else {
               if (!GuiHitTestUtils.method05608(var3.getEyePosition())) {
                  Vec3 sxx = this.field02685.method01266();
                  if (sxx != null) {
                     this.field02683 = AuraAimPointSelector.Nested38.BEST_POINT;
                     return;
                  }
               }

               this.field02683 = var2.method00429().method05600(field02686) ? AuraAimPointSelector.Nested38.RANDOM_POINT : AuraAimPointSelector.Nested38.STANDARD;
            }
         }
      }
   }

   public void method01258(LivingEntity var1) {
      if (var1 == null) {
         this.field02683 = AuraAimPointSelector.Nested38.NONE;
         this.field02684 = null;
      } else {
         if (var1.getBbWidth() < field02687 && var1.getBbHeight() < field02688) {
            this.field02685.method01268(var1);
         }
      }
   }

   private Vec3 method01259(LivingEntity var1, Vec3 var2) {
      return var2.add(0.0, var1.getBbHeight() / 2.0F, 0.0);
   }

   public Vec3 method01260(AttackAura var1, LivingEntity var2) {
      if (this.field02683 == AuraAimPointSelector.Nested38.NONE) {
         return Vec3.ZERO;
      }

      Vec3 var3 = mc.player.getEyePosition();
      Vec3 var4 = var2.position();

      return switch (this.field02683) {
         case NONE -> Vec3.ZERO;
         case STANDARD -> this.method01259(var2, var4).subtract(var3);
         case BEST_POINT -> {
            Vec3 var10 = this.field02685.method01266();
            yield var10 == null ? var2.getEyePosition().subtract(var3) : var10.subtract(var3);
         }
         case RANDOM_POINT -> {
            Vec3 var9 = this.field02685.method01270(var2, var3, var1.method00403());
            yield var9 == null ? this.method01259(var2, var4).subtract(var3) : var9.subtract(var3);
         }
         case ELYTRA_RESOLVE -> this.field02684.subtract(var3);
         case ELYTRA_CHASE -> var1.field00788.subtract(var3);
         case GLIDING_UP -> {
            float var5 = var2.getBbHeight();
            double var6 = Math.max(field02689, var5 * field02690);
            boolean var8 = mc.player.isFallFlying();
            yield var8 && var2.isFallFlying() ? new Vec3(var4.x, var4.y, var4.z).subtract(var3) : new Vec3(var4.x, var4.y + var5 - var6, var4.z).subtract(var3);
         }
      };
   }

   public String method01261() {
      return this.field02683.name();
   }

   // $VF: Compiled from s
   private enum Nested38 {
      NONE,
      STANDARD,
      BEST_POINT,
      RANDOM_POINT,
      ELYTRA_RESOLVE,
      ELYTRA_CHASE,
      GLIDING_UP;
   }
}
