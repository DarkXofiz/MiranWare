// Original binary: sg/ec/BKzzDMHxBasFVNlr
package sg.ec;

import net.minecraft.client.Options;

// $VF: Compiled from s
public class PlayerInputEvent extends PlayerMovementEvent {
   public static final PlayerInputEvent field06252 = new PlayerInputEvent();

   public void method02724(float var1, float var2, boolean var3, boolean var4, boolean var5) {
      this.method11163(var1, var2, var3, var4, var5);
      super.method03208();
   }

   @Override
   public boolean method02725() {
      return true;
   }

   @Override
   public boolean method02726() {
      return false;
   }

   public void method02727(Options var1) {
      this.method11170(var1);
      super.method03208();
   }
}
