// Original binary: sg/ec/dFnpyXibCjo8YQjH
package sg.ec;

import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public class TooltipRenderEvent extends Event {
   public static final TooltipRenderEvent field18101 = new TooltipRenderEvent();
   private GuiGraphicsExtractor field18102;
   private List<Component> field18103;

   public void method07397(int var1, Component var2) {
      this.field18103.add(var1, var2);
   }

   public void method07398(Component var1) {
      this.field18103.add(var1);
   }

   public void method07399(GuiGraphicsExtractor var1, List<Component> var2) {
      this.field18102 = var1;
      this.field18103 = var2;
      super.method03208();
   }

   public GuiGraphicsExtractor method07400() {
      return this.field18102;
   }

   public List<Component> method07401() {
      return this.field18103;
   }
}
