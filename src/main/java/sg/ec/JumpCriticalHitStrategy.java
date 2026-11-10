// Original binary: sg/ec/cZOAocExiiJi0g5X
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Input;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public final class JumpCriticalHitStrategy implements CriticalHitStrategy, MinecraftAccess {
   private static final int field17758 = 30;
   private static final int field17759 = 0;
   private static final int field17760 = 0;
   private static final double field17761 = 0;
   private static final double field17762 = 0;
   private static final double field17763 = 0;
   private boolean field17764;
   private int field17765;
   private int field17766;
   private int field17767;
   private int field17768;
   private int field17769;
   private static final int field17770 = Integer.MIN_VALUE;
   private static final int field17771 = Integer.MIN_VALUE;
   private static final float field17772 = 0.5F;
   private static final double field17773 = 0.01;
   private static final double field17774 = 0.3;
   private static final double field17775 = 0.06;

   @Override
   public boolean method03149(AttackAura var1) {
      return var1.method00438() || ModuleManager.INSTANCE.method08233().method08150();
   }

   @Override
   public boolean method03148(AttackAura var1) {
      if (this.method07286(var1) && var1.method00378()) {
         this.method07284();
         int var2 = this.method07287();
         if (var2 < 0) {
            return true;
         }

         if (var1.method00465() > 0) {
            return false;
         }

         int var3 = method07282();
         return var2 > var3 || this.field17766 > var3;
      } else {
         return false;
      }
   }

   @Override
   public void method03154(AttackAura var1) {
      if (!this.method07286(var1)) {
         this.method03155();
      } else {
         this.field17766 = var1.method00465() > 0 ? 0 : this.field17766 + 1;
         this.method07284();
         boolean var2 = this.field17769 < 0 && (this.field17768 < 0 || var1.method00465() <= this.field17768) && !this.method07281();
         this.field17765 = var2 ? 0 : this.field17765 + 1;
         this.field17764 = !var2 && this.field17765 <= 20;
      }
   }

   @Override
   public int method03152(AttackAura var1) {
      if (!this.method07286(var1)) {
         return -1;
      }

      this.method07284();
      int var2 = this.method07287();
      return var2 < 0 ? -1 : Math.max(var2, var1.method00465());
   }

   private static Input method07280(Input var0, boolean var1) {
      return new Input(var0.forward(), var0.backward(), var0.left(), var0.right(), var1, var0.shift(), var0.sprint());
   }

   private boolean method07281() {
      return mc.player.onGround()
         && mc.player.getFluidHeight(FluidTags.WATER) <= mc.player.getFluidJumpThreshold()
         && ((LivingEntityMixin_1248)(Object)mc.player).getJumpDelay() > 1;
   }

   @Override
   public void method03155() {
      this.field17767 = field17771;
      this.field17768 = -1;
      this.field17769 = -1;
      this.field17764 = false;
      this.field17765 = 0;
      this.field17766 = 0;
   }

   @Override
   public void method03163(PlayerInputEvent var1) {
      if (this.field17764 && mc.options.keyJump.isDown()) {
         var1.method11173(false);
      }
   }

   private static int method07282() {
      float var0 = mc.player.getCurrentItemAttackStrengthDelay();
      if (Float.isFinite(var0) && !(var0 <= 0.0F)) {
         float var1 = ModuleManager.INSTANCE.method08233().method08150() ? 1.0F : field17772;
         return Math.max(2, (int)(var0 * var1));
      } else {
         return 5;
      }
   }

   private static boolean method07283(SimulatedPlayerInput var0) {
      return var0.method08911(FluidTags.WATER) > field17774 || var0.field20219.y < field17775;
   }

   public JumpCriticalHitStrategy() {
      this.field17767 = field17770;
      this.field17768 = -1;
      this.field17769 = -1;
   }

   private void method07284() {
      int var1 = TickEvent.method03209();
      if (this.field17767 != var1) {
         this.field17767 = var1;
         this.field17768 = this.method07285(true, 30);
         this.field17769 = this.method07285(false, 8);
      }
   }

   private int method07285(boolean var1, int var2) {
      Input var3 = mc.player.input.keyPresses;
      SimulatedPlayerInput.Nested248 var4 = SimulatedPlayerInput.Nested248.fromClientPlayer(method07280(var3, var1));
      SimulatedPlayerInput var5 = SimulatedPlayerInput.method08894(var4);
      var5.field20226 = 0;

      for (int var6 = 1; var6 <= var2; var6++) {
         if (var6 > 1) {
            var4.field20335 = method07280(var3, var1 && method07283(var5));
         }

         var5.method08897();
         if (!var5.field20232 && !var5.field20229 && !(var5.field20225 <= 0.0F)) {
            double var7 = WorldCollisionUtils.method02834(var5.field20220);
            if (Double.isNaN(var7) || var5.field20220.minY - var7 >= field17773) {
               return var6;
            }
         }
      }

      return -1;
   }

   private boolean method07286(AttackAura var1) {
      LocalPlayer var2 = mc.player;
      if (var2 == null || mc.level == null || var2.input == null) {
         return false;
      } else if (!mc.options.keyJump.isDown() || AttackAura.method00456() == null) {
         return false;
      } else if (var2.isPassenger() || var2.getAbilities().flying || var2.isFallFlying()) {
         return false;
      } else {
         return var2.isInWater() && !var2.isUnderWater() && !var2.isInLava() ? Math.abs(var1.field00813) <= var1.method00403() : false;
      }
   }

   private int method07287() {
      return this.field17769 < 0 ? this.field17768 : this.field17769;
   }
}
