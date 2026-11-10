// Original binary: sg/ec/mdoK3M6JxcsEbxmR
package sg.ec;

import java.util.EnumSet;
import java.util.Set;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public final class MatrixAuraRotation implements AuraRotationStrategy {
   private static final float field21671 = 1000.0F;
   private static final float field21672 = 0;
   private static final float field21673 = 0;
   private static final float field21674 = 0;
   private static final float field21675 = 0;
   private static final float field21676 = 0;
   private static final int field21677 = 0;
   private static final int field21678 = 0;
   private static final int field21679 = 0;
   private static final float field21680 = 0;
   private static final float field21681 = 0;
   private static final float field21682 = 0;
   private static final float field21683 = 0;
   private static final float field21684 = 0;
   private static final float field21685 = 0;
   private static final float field21686 = 0;
   private static final float field21687 = 0;
   private static final float field21688 = 0;
   private static final float field21689 = 0;
   private static final int field21690 = 0;
   private static final float field21691 = 0;
   private int field21692 = GuiHitTestUtils.field11989.nextInt(1024);
   private static final String field21693 = "Matrix";
   private static final float field21694 = 1000.0F;
   private static final float field21695 = 1000.0F;
   private static final float field21696 = 90.0F;
   private static final float field21697 = 0.55F;
   private static final float field21698 = 0.85F;
   private static final float field21699 = 0.25F;
   private static final float field21700 = 0.15F;
   private static final float field21701 = 3.0F;
   private static final float field21702 = -1.0F;
   private static final float field21703 = 0.3F;
   private static final float field21704 = 0.5F;
   private static final float field21705 = 22.0F;
   private static final float field21706 = 13.0F;
   private static final float field21707 = 18.0F;
   private static final double field21708 = 0.5;
   private static final double field21709 = 0.5;
   private static final float field21710 = 1.8F;
   private static final float field21711 = 0.35F;
   private static final float field21712 = 0.85F;
   private static final float field21713 = 3.2F;
   private static final float field21714 = 0.3F;
   private static final float field21715 = 0.85F;
   private static final float field21716 = 4.5F;
   private static final float field21717 = 0.2F;
   private static final float field21718 = 1.5F;
   private static final float field21719 = -1.0F;
   private static final long field21720 = 4L;
   private static final long field21721 = 4L;
   private static final long field21722 = 4L;
   private static final float field21723 = 4.0F;
   private static final float field21724 = 4.0F;
   private static final float field21725 = 0.5F;
   private static final float field21726 = 0.5F;
   private static final float field21727 = 1.2F;
   private static final float field21728 = 0.37F;
   private static final double field21729 = 2.0;
   private static final float field21730 = 0.25F;
   private static final float field21731 = -89.9F;
   private static final float field21732 = 89.9F;
   private static final float field21733 = 0.375F;
   private static final float field21734 = 0.3F;
   private static final float field21735 = -89.9F;
   private static final float field21736 = 89.9F;
   private static final float field21737 = 0.35F;
   private static final long field21738 = -7046029254386353131L;
   private static final long field21739 = -4658895280553007687L;
   private static final float field21740 = 1.6777216E7F;

   @Override
   public void method02268() {
      this.field21692 = GuiHitTestUtils.field11989.nextInt(1024);
   }

   @Override
   public Set<AuraRotationUpdateMode> method02264() {
      return EnumSet.of(AuraRotationUpdateMode.TICK);
   }

   @Override
   public void method02266(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2) {
      this.method09546(var1, var2);
      float var3 = Math.abs(var1.yawDelta()) + Math.abs(var1.pitchDelta());
      int var4 = AttackCooldownUtils.method00006(mc.player);
      int var5 = var1.isGliding() ? 2 : 1;
      boolean var6 = this.method09549(var1);
      var2.method05337(field21694, field21695);
      float var7;
      float var8;
      if (var6 && var4 <= var5) {
         var7 = var3;
         var8 = var3;
      } else {
         float var9 = GuiHitTestUtils.method05621(var3 / field21696);
         float var10 = Mth.lerp(var9 * var9, field21697, field21698 + (float)Math.random() * field21699);
         float var11 = Math.max(field21700, var3 * var10);
         if (var6 && var4 <= 3 && !this.method09547(var1)) {
            var11 = Math.max(var11, var3 / ((var4 - var5) * field21701));
         }

         var7 = var11;
         var8 = var11 / 2.0F;
      }

      float var15 = (mc.player.tickCount + this.field21692 & 1L) == 0L ? 1.0F : field21702;
      var7 *= 1.0F + var15 * field21703;
      var8 = Math.max(var8, Math.max(2.0F, field21704 * var3));
      var8 = Math.min(var8, var1.isGliding() ? field21705 : field21706);
      if (((LivingEntityMixin_1248)(Object)mc.player).getAttackStrengthTicker() <= 1) {
         var7 = Math.min(var7, field21707);
      }

      var2.method05325(var7, var8);
   }

   private static float method09545(long var0) {
      long var2 = var0 * field21738;
      var2 ^= var2 >>> 29;
      var2 *= field21739;
      var2 ^= var2 >>> 32;
      return (float)(var2 >>> 40) / field21740;
   }

   private void method09546(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2) {
      double var3 = Math.max(1.0, var1.aura().method00419(var1.target()));
      AABB var5 = var1.targetBox();
      float var6 = (float)Math.toDegrees(Math.atan(var5.getXsize() * field21708 / var3));
      float var7 = (float)Math.toDegrees(Math.atan(var5.getYsize() * field21709 / var3));
      if (!(var6 <= 0.0F) || !(var7 <= 0.0F)) {
         float var8 = RotationMath.method11345();
         float var9 = Mth.clamp(Math.max(field21710, var6 * field21711), 0.0F, var6 * field21712);
         float var10 = Mth.clamp(Math.max(field21713 * var8, var7 * field21714), 0.0F, Math.min(var7 * field21715, field21716));
         float var11 = Math.min(var6 * field21717, field21718);
         long var12 = mc.player.tickCount + this.field21692;
         float var14 = (var12 & 1L) == 0L ? 1.0F : field21719;
         float var15 = (float)((var12 % field21720 + field21721) % field21722) / field21723;
         float var16 = field21724 * Math.abs(var15 - field21725) - 1.0F;
         float var17 = (method09545(var12) - field21726) * 2.0F * var9 * field21727;
         float var18 = var9 * var14 + var17 + var11 * (float)Math.sin((float)var12 * field21728);
         float var19 = var10 * var16;
         this.method09548(var1, var2, var18, var19, var3);
      }
   }

   private boolean method09547(AuraRotationController.Nested160 var1) {
      return RaycastUtils.method09500(var1.currentYaw(), var1.currentPitch(), var1.aura().method00403(), var1.target(), false, var1.targetBox());
   }

   private void method09548(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2, float var3, float var4, double var5) {
      float var7 = var2.method05326();
      float var8 = var2.method05328();
      double var9 = var5 + field21729;

      for (float var11 = 1.0F; var11 >= field21730; var11 -= field21733) {
         float var12 = var7 + var3 * var11;
         float var13 = Mth.clamp(var8 + var4 * var11, field21731, field21732);
         if (RaycastUtils.method09500(var12, var13, var9, var1.target(), false, var1.targetBox())) {
            var2.method05332(var12);
            var2.method05339(var13);
            return;
         }
      }

      for (float var14 = 1.0F; var14 >= field21734; var14 -= field21737) {
         float var15 = Mth.clamp(var8 + var4 * var14, field21735, field21736);
         if (RaycastUtils.method09500(var7, var15, var9, var1.target(), false, var1.targetBox())) {
            var2.method05339(var15);
            return;
         }
      }
   }

   @Override
   public String method02258() {
      return field21693;
   }

   private boolean method09549(AuraRotationController.Nested160 var1) {
      AttackAura var2 = var1.aura();
      return var2.method00419(var1.target()) <= var2.method00454() + 1.0F;
   }
}
