// Original binary: sg/ec/AZoQS9muxNk9AN78
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public enum PlayerVelocityTracker implements MinecraftAccess {
   INSTANCE;

   private boolean field06126;
   private boolean field06127;
   private int field06128;
   private Vec3 field06129 = Vec3.ZERO;

   public void method02568() {
      EventBus.method00263(this);
   }

   public Vec3 method02569() {
      return this.field06129;
   }

   public boolean method02570() {
      return this.field06127;
   }

   public void method02571(boolean var1) {
      if (this.field06127 != var1) {
         this.field06127 = var1;
         if (!var1 && mc.player != null) {
            mc.player.setDeltaMovement(this.field06129);
         }
      }
   }

   public boolean method02572() {
      if (mc.player != null && mc.level != null) {
         AirStake var1 = ModuleManager.INSTANCE.method08256();
         FreeCam var2 = ModuleManager.INSTANCE.method08258();
         if (this.field06127) {
            return true;
         } else {
            return var1.method03937() ? true : var2.method03937() && var2.field22032.method05999();
         }
      } else {
         return false;
      }
   }

   @Subscribe
   public void method02573(EntityVelocityEvent var1) {
      if (this.field06127 && var1.method02128() instanceof LocalPlayer) {
         var1.method02129(Vec3.ZERO);
         var1.method05695(true);
      }
   }

   @Subscribe
   public void method02574(PreMovementPacketEvent var1) {
      if (this.field06127) {
         var1.method05696();
      }
   }

   @Subscribe(4)
   public void method02575(PlayerInputEvent var1) {
      boolean var2 = this.method02572();
      if (!var2 && mc.player != null) {
         this.field06129 = mc.player.getDeltaMovement();
      }

      if (this.field06126 && !var2) {
         this.field06128 = 1;
      }

      this.field06126 = var2;
      if (this.field06127) {
         var1.method11167(0.0F);
         var1.method11158(0.0F);
         var1.method11173(false);
      }

      if (this.field06128 > 0) {
         this.field06128--;
         var1.method11167(0.0F);
         var1.method11158(0.0F);
         var1.method11173(false);
         var1.method11169(false);
         var1.method11174(false);
      }
   }
}
