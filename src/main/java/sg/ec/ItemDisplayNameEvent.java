// Original binary: sg/ec/sRFT3VHk6XfMHgZ4
package sg.ec;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class ItemDisplayNameEvent extends Event {
   public static ItemDisplayNameEvent field23595 = new ItemDisplayNameEvent();
   private ItemStack field23596;
   private Component field23597;

   public void method10663(ItemStack var1) {
      this.field23596 = var1;
   }

   public Component method10664(ItemStack var1, Component var2) {
      this.field23596 = var1;
      this.field23597 = var2;
      super.method03208();
      return this.field23597;
   }

   public ItemStack method10665() {
      return this.field23596;
   }

   public Component method10666() {
      return this.field23597;
   }

   public void method10667(Component var1) {
      this.field23597 = var1;
   }
}
