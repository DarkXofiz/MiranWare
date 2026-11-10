// Original binary: sg/ec/kLDi4HT8hJOMRrke
package sg.ec;

import java.util.List;
import net.minecraft.client.multiplayer.PlayerInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class PlayerTabOverlayHooks {
   private List<PlayerInfo> field20790;
   private int field20791 = -1;
   private int field20792 = -1;

   public void method09161(int var1, int var2, CallbackInfoReturnable<List<PlayerInfo>> var3) {
      if (this.field20790 != null && this.field20791 == var1 && this.field20792 == var2) {
         var3.setReturnValue(this.field20790);
      }
   }

   public void method09162(int var1, int var2, List<PlayerInfo> var3) {
      this.field20790 = var3;
      this.field20791 = var1;
      this.field20792 = var2;
   }
}
