// Original binary: sg/mx/HUmqD1mR0qlyTLAw
package sg.mx;

import net.minecraft.client.gui.render.GuiItemAtlas;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.GuiItemAtlasHooks;

// $VF: Compiled from s
@Mixin(GuiItemAtlas.class)
public class GuiItemAtlasMixin {
   @Unique
   private GuiItemAtlasHooks hex$ticker;

   @Inject(method = "endFrame", at = @At("HEAD"), cancellable = true)
   private void hex$throttleAnimated(CallbackInfo var1) {
      GuiItemAtlasHooks var2 = this.hex$ticker;
      if (var2 == null) {
         var2 = new GuiItemAtlasHooks(30);
         this.hex$ticker = var2;
      }

      if (!var2.method06043()) {
         var1.cancel();
      }
   }
}
