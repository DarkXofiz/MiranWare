// Original binary: sg/mx/gbIkCZtwMPc0NVDH
package sg.mx;

import java.util.List;
import java.util.stream.Stream;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.client.renderer.blockentity.state.BeaconRenderState;
import net.minecraft.client.renderer.blockentity.state.BeaconRenderState.Section;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.BeaconRendererHooks;

// $VF: Compiled from s
@Mixin(BeaconRenderer.class)
public class BeaconRendererMixin {
   @Redirect(method = "extract", at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;toList()Ljava/util/List;"))
   private static List<Section> hex$cachedSections(Stream<?> var0, BlockEntity var1, BeaconRenderState var2, float var3, Vec3 var4) {
      return BeaconRendererHooks.method03514(var1);
   }
}
