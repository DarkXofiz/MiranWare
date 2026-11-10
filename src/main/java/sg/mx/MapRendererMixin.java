// Original binary: sg/mx/P6oMAUc34urGyNXI
package sg.mx;

import net.minecraft.client.renderer.MapRenderer;
import net.minecraft.client.renderer.state.MapRenderState;
import net.minecraft.world.level.saveddata.maps.MapId;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.VisualRemovalEvent;

// $VF: Compiled from s
@Mixin(MapRenderer.class)
public abstract class MapRendererMixin {
   @Inject(method = "extractRenderState", at = @At("TAIL"))
   private void hex$onExtractRenderState(MapId var1, MapItemSavedData var2, MapRenderState var3, CallbackInfo var4) {
      VisualRemovalEvent.field19883.method08693(VisualRemovalEvent.Nested242.LAG_MACHINE, var3.decorations);
   }
}
