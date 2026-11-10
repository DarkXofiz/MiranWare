// Original binary: sg/ec/yDBFOE55NuwAdqMQ
package sg.ec;

import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.feature.phase.FeatureRenderPhase;
import net.minecraft.client.renderer.feature.phase.SimpleFeatureRenderPhase;

// $VF: Compiled from s
public final class FeatureRenderDispatcherPreparedFrameHooks {
   private FeatureRenderDispatcherPreparedFrameHooks() {
   }

   public static boolean method11599(SubmitNodeStorage var0, Map<FeatureRenderPhase<?>, List<?>> var1) {
      if (var0 == null) {
         return false;
      }

      ObjectIterator var2 = var0.getSubmitsPerOrder().values().iterator();

      while (var2.hasNext()) {
         SubmitNodeCollection var3 = (SubmitNodeCollection)var2.next();
         SimpleFeatureRenderPhase var4 = ((RenderSubmissionAccess)var3).hexBeforeClear();
         if (!var1.getOrDefault(var4, List.of()).isEmpty()) {
            return true;
         }
      }

      return false;
   }
}
