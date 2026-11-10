// Original binary: sg/ec/Dr24FrkBtPl449oV
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Input;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public final class PoseCriticalHitStrategy implements CriticalHitStrategy, MinecraftAccess {
   private static final int field06979 = 20;
   private static final int field06980 = 0;
   private static final int field06981 = 0;
   private boolean field06982;
   private int field06983;
   private int field06984;
   private PoseCriticalHitStrategy.Nested88 field06985;
   private PoseCriticalHitStrategy.Nested88 field06986;
   private static final int field06987 = Integer.MIN_VALUE;
   private static final int field06988 = Integer.MIN_VALUE;

   private boolean method03147() {
      return this.method03156() == mc.player.getPose() && ((LivingEntityMixin_1248)(Object)mc.player).getJumpDelay() <= 1;
   }

   @Override
   public boolean method03148(AttackAura var1) {
      return this.method03157(var1) && !this.method03151();
   }

   @Override
   public boolean method03149(AttackAura var1) {
      return var1.method00398();
   }

   private boolean method03150(int var1) {
      int var2 = this.field06985.critIn(var1);
      int var3 = this.field06986.critIn(var1);
      return var2 < 0 && var3 < 0 ? this.field06985.landsNoLaterThan(this.field06986) : var2 >= 0 && (var3 < 0 || var2 <= var3);
   }

   private boolean method03151() {
      int var1 = TickEvent.method03209();
      if (this.field06984 != var1) {
         this.field06984 = var1;
         Pose var2 = this.method03156();
         this.field06985 = this.method03153(var2, true);
         this.field06986 = this.method03161() ? this.method03153(var2, false) : PoseCriticalHitStrategy.Nested88.NONE;
      }

      return this.field06985.exists() || this.field06986.exists();
   }

   @Override
   public int method03152(AttackAura var1) {
      if (this.method03157(var1) && this.method03160(var1)) {
         int var2 = var1.method00465();
         if (this.field06986.exists()) {
            return this.method03150(var2) ? this.field06985.critIn(var2) : this.field06986.critIn(var2);
         } else {
            return this.method03162(var1) + this.field06985.start();
         }
      } else {
         return -1;
      }
   }

   private PoseCriticalHitStrategy.Nested88 method03153(Pose var1, boolean var2) {
      Input var3 = mc.player.input.keyPresses;
      boolean var4 = var1 == Pose.CROUCHING;
      SimulatedPlayerInput var5 = SimulatedPlayerInput.method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(method03159(var3, var2, var4)));
      var5.method08934(mc.player.getDimensions(var1));
      var5.field20226 = 0;
      int var6 = -1;
      int var7 = -1;

      for (int var8 = 1; var8 <= 20; var8++) {
         var5.method08897();
         if (var8 == 1) {
            var5.field20216.field20335 = method03159(var3, false, var4);
         }

         if (var5.field20229) {
            return new PoseCriticalHitStrategy.Nested88(var6, var7, var8);
         }

         if (!var5.field20232 && var5.field20225 > 0.0F) {
            if (var6 < 0) {
               var6 = var8;
            }

            var7 = var8;
         } else if (var6 > 0) {
            break;
         }
      }

      return new PoseCriticalHitStrategy.Nested88(var6, var7, -1);
   }

   @Override
   public void method03154(AttackAura var1) {
      if (!this.method03157(var1)) {
         this.method03155();
      } else if (this.method03160(var1) && this.method03162(var1) != 0) {
         this.field06983++;
         this.field06982 = this.field06983 <= 12;
      } else {
         this.method03164();
      }
   }

   @Override
   public void method03155() {
      this.field06984 = field06988;
      this.field06985 = PoseCriticalHitStrategy.Nested88.NONE;
      this.field06986 = PoseCriticalHitStrategy.Nested88.NONE;
      this.method03164();
   }

   private Pose method03156() {
      Pose var1 = mc.player.getPose();
      return var1 == Pose.STANDING && mc.options.keyShift.isDown() ? Pose.CROUCHING : var1;
   }

   public PoseCriticalHitStrategy() {
      this.field06984 = field06987;
      this.field06985 = PoseCriticalHitStrategy.Nested88.NONE;
      this.field06986 = PoseCriticalHitStrategy.Nested88.NONE;
   }

   private boolean method03157(AttackAura var1) {
      LocalPlayer var2 = mc.player;
      if (var2 == null || mc.level == null || var2.input == null) {
         return false;
      } else if (!mc.options.keyJump.isDown() || AttackAura.method00456() == null) {
         return false;
      } else if (var2.isPassenger() || var2.getAbilities().flying || var2.isFallFlying()) {
         return false;
      } else {
         return !var2.isInWater() && !var2.isInLava() ? Math.abs(var1.field00813) <= var1.method00403() : false;
      }
   }

   private int method03158() {
      return Math.max(this.field06985.start(), this.field06985.end() - 1);
   }

   private static Input method03159(Input var0, boolean var1, boolean var2) {
      return new Input(var0.forward(), var0.backward(), var0.left(), var0.right(), var1, var2, var0.sprint());
   }

   private boolean method03160(AttackAura var1) {
      return mc.player.onGround() && !var1.method00375() && this.method03151();
   }

   private boolean method03161() {
      return mc.player.onGround() && mc.player.getDeltaMovement().y > 0.0;
   }

   private int method03162(AttackAura var1) {
      int var2 = var1.method00465();
      if (this.field06986.exists()) {
         return this.method03150(var2) ? 0 : 1;
      }

      int var3 = Math.max(0, var2 - this.method03158());
      return var3 == 0 && !this.method03147() ? 1 : var3;
   }

   @Override
   public void method03163(PlayerInputEvent var1) {
      if (this.field06982 && mc.options.keyJump.isDown()) {
         var1.method11173(false);
      }
   }

   private void method03164() {
      this.field06982 = false;
      this.field06983 = 0;
   }

   // $VF: Compiled from s
   private record Nested88(int start, int end, int land) {
      private static final PoseCriticalHitStrategy.Nested88 NONE = new PoseCriticalHitStrategy.Nested88(-1, -1, -1);

      private boolean exists() {
         return this.start > 0;
      }

      private int critIn(int var1) {
         return this.exists() && this.end >= var1 ? Math.max(this.start, var1) : -1;
      }

      private boolean landsNoLaterThan(PoseCriticalHitStrategy.Nested88 var1) {
         return this.land > 0 && (var1.land < 0 || this.land <= var1.land);
      }
   }
}
