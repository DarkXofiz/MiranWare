// Original binary: sg/ec/SFe0bLad8Ibxl0Ul
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class HudRenderEvent extends Event {
   public static final HudRenderEvent field11740 = new HudRenderEvent();
   private PoseStack field11741;
   private GuiGraphicsExtractor field11742;
   private DeltaTracker field11743;

   public DeltaTracker method05421() {
      return this.field11743;
   }

   public void method05422(GuiGraphicsExtractor var1, DeltaTracker var2) {
      this.field11741 = new PoseStack();
      this.field11742 = var1;
      this.field11743 = var2;
      GuiScaleUtils.method06750(var1);

      try {
         super.method03208();
      } finally {
         GuiScaleUtils.method06748(var1);
      }
   }

   public void method05423(GuiGraphicsExtractor var1) {
      this.field11742 = var1;
   }

   public GuiGraphicsExtractor method05424() {
      return this.field11742;
   }

   public PoseStack method05425() {
      return this.field11741;
   }

   public void method05426(DeltaTracker var1) {
      this.field11743 = var1;
   }

   public void method05427(PoseStack var1) {
      this.field11741 = var1;
   }
}
