// Original binary: sg/mx/MIsEDljlbFc7w18q
package sg.mx;

import java.util.List;
import net.minecraft.client.renderer.blockentity.state.BeaconRenderState.Section;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.BeaconBeamCacheAccess;

// $VF: Compiled from s
@Mixin(BeaconBlockEntity.class)
public class BeaconBlockEntityMixin implements BeaconBeamCacheAccess {
   @Unique
   private List<Section> hex$sections;

   @Override
   public List<Section> hex$beamSections() {
      return this.hex$sections;
   }

   @Override
   public void hex$beamSections(List<Section> var1) {
      this.hex$sections = var1;
   }
}
