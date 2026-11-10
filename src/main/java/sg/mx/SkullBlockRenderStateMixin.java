// Original binary: sg/mx/Tn59HLlytfMjZI0p
package sg.mx;

import net.minecraft.client.renderer.blockentity.state.SkullBlockRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.SkullTextureAccess;

// $VF: Compiled from s
@Mixin(SkullBlockRenderState.class)
public class SkullBlockRenderStateMixin implements SkullTextureAccess {
   @Unique
   private int hex$slot;

   @Override
   public int hex$headSlot() {
      return this.hex$slot;
   }

   @Override
   public void hex$headSlot(int var1) {
      this.hex$slot = var1;
   }
}
