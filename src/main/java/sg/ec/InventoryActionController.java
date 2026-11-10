// Original binary: sg/ec/jV5AQaloyxB108gC
package sg.ec;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;

// $VF: Compiled from s
public interface InventoryActionController {
   void method09002(InteractionHand var1, Item var2);

   void method09003(Item var1);

   void method09004(InteractionHand var1, Object var2, float var3, float var4);

   void method09005(Slot var1, float var2, float var3);

   void method09006(Item var1, float var2, float var3);

   InventoryActionSequence method09007(int var1, int var2);

   void method09008(Slot var1);

   void method09009();

   void method09010(PlayerUpdateEvent var1);

   void method09011(InteractionHand var1, Slot var2);
}
