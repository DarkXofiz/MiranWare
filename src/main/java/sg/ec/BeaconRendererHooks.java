// Original binary: sg/ec/G8P2s0fpajz9z56T
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.entity.BeaconBeamOwner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BeaconBeamOwner.Section;

// $VF: Compiled from s
public final class BeaconRendererHooks {
   public static List<net.minecraft.client.renderer.blockentity.state.BeaconRenderState.Section> method03514(BlockEntity var0) {
      var var1 = ((BeaconBeamOwner)var0).getBeamSections();
      if (var0 instanceof BeaconBeamCacheAccess sx) {
         var sxx = sx.hex$beamSections();
         if (sxx != null && method03516(sxx, var1)) {
            return sxx;
         }

         var sxxx = method03515(var1);
         sx.hex$beamSections(sxxx);
         return sxxx;
      } else {
         return method03515(var1);
      }
   }

   private static List<net.minecraft.client.renderer.blockentity.state.BeaconRenderState.Section> method03515(List<Section> var0) {
      var var1 = new ArrayList(var0.size());

      for (int var2 = 0; var2 < var0.size(); var2++) {
         Section var3 = (Section)var0.get(var2);
         var1.add(new net.minecraft.client.renderer.blockentity.state.BeaconRenderState.Section(var3.getColor(), var3.getHeight()));
      }

      return var1;
   }

   private static boolean method03516(List<net.minecraft.client.renderer.blockentity.state.BeaconRenderState.Section> var0, List<Section> var1) {
      if (var0.size() != var1.size()) {
         return false;
      }

      for (int var2 = 0; var2 < var0.size(); var2++) {
         net.minecraft.client.renderer.blockentity.state.BeaconRenderState.Section var3 = (net.minecraft.client.renderer.blockentity.state.BeaconRenderState.Section)var0.get(
            var2
         );
         Section var4 = (Section)var1.get(var2);
         if (var3.color() != var4.getColor() || var3.height() != var4.getHeight()) {
            return false;
         }
      }

      return true;
   }

   private BeaconRendererHooks() {
   }
}
