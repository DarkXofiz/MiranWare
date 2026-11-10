// Original binary: sg/mx/IK90SqFsuBMowSAX
package sg.mx;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(AbstractContainerScreen.class)
public interface AbstractContainerScreenMixin {
   @Invoker("isHovering")
   boolean IisPointOverSlot(Slot var1, double var2, double var4);

   @Invoker("slotClicked")
   void IonMouseClick(Slot var1, int var2, int var3, ContainerInput var4);

   @Accessor("hoveredSlot")
   Slot getFocusedSlot();
}
