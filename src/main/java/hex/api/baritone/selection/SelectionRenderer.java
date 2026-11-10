// Original binary: hex/api/baritone/selection/SelectionRenderer
package hex.api.baritone.selection;

import com.mojang.blaze3d.vertex.PoseStack;
import hex.api.baritone.Baritone;
import hex.api.baritone.api.event.events.RenderEvent;
import hex.api.baritone.api.event.listener.AbstractGameEventListener;
import hex.api.baritone.api.selection.ISelection;
import hex.api.baritone.utils.IRenderer;
import net.minecraft.world.phys.AABB;
import sg.ec.BaritoneVertexConsumerAccess;

// $VF: Compiled from s
public class SelectionRenderer implements AbstractGameEventListener, IRenderer {
   public static final double SELECTION_BOX_EXPANSION = 0.005;
   private final SelectionManager manager;
   private static final double А7й = 0;

   SelectionRenderer(Baritone var1, SelectionManager var2) {
      this.manager = var2;
      var1.getGameEventHandler().registerEventListener(this);
   }

   @Override
   public void onRenderPass(RenderEvent var1) {
      renderSelections(var1.getModelViewStack(), this.manager.getSelections());
   }


   public static void renderSelections(PoseStack var0, ISelection[] var1) {
      float var2 = settings.selectionOpacity.value;
      boolean sx = settings.renderSelectionIgnoreDepth.value;
      float sxx = settings.selectionLineWidth.value;
      if (settings.renderSelection.value && var1.length != 0) {
         BaritoneVertexConsumerAccess sxxx = IRenderer.startLines(settings.colorSelection.value, var2);

         for (ISelection sxxxx : var1) {
            IRenderer.emitAABB(sxxx, var0, sxxxx.aabb(), А7й, sxx);
         }

         if (settings.renderSelectionCorners.value) {
            IRenderer.glColor(settings.colorSelectionPos1.value, var2);

            for (ISelection sxxxx : var1) {
               IRenderer.emitAABB(sxxx, var0, new AABB(sxxxx.pos1()), sxx);
            }

            IRenderer.glColor(settings.colorSelectionPos2.value, var2);

            for (ISelection sxxxx : var1) {
               IRenderer.emitAABB(sxxx, var0, new AABB(sxxxx.pos2()), sxx);
            }
         }

         IRenderer.endLines(sxxx, sx);
      }
   }
}
