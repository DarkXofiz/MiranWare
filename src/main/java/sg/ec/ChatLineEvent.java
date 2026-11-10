// Original binary: sg/ec/TbCHfmX45QdO3EYj
package sg.ec;

import net.minecraft.client.GuiMessage.Line;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public class ChatLineEvent extends Event {
   public static final ChatLineEvent field12024 = new ChatLineEvent();
   private Line field12025;
   private Component field12026;
   private int field12027;

   public void method05654(Line var1) {
      this.field12025 = var1;
   }

   public Line method05655() {
      return this.field12025;
   }

   public void method05656(Component var1) {
      this.field12026 = var1;
   }

   public int method05657() {
      return this.field12027;
   }

   public void method05658(int var1) {
      this.field12027 = var1;
   }

   public Component method05659() {
      return this.field12026;
   }

   public int method05660(Line var1, int var2, Component var3) {
      this.field12025 = var1;
      this.field12026 = var3;
      this.field12027 = var2;
      super.method03208();
      return this.method05694() ? this.field12027 : var2;
   }
}
