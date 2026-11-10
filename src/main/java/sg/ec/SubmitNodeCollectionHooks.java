// Original binary: sg/ec/tACI1CYquVz7OORf
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.feature.phase.FeatureRenderPhase;

// $VF: Compiled from s
public final class SubmitNodeCollectionHooks {
   private SubmitNodeCollectionHooks() {
   }

   public static List<FeatureRenderPhase<?>> method10798(List<FeatureRenderPhase<?>> var0, FeatureRenderPhase<?> var1) {
      var var2 = new ArrayList<>(var0);
      var2.add(var1);
      return List.copyOf(var2);
   }
}
