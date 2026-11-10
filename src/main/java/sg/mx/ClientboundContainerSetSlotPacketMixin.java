// Original binary: sg/mx/QbwtctygVQmy9xps
package sg.mx;

import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ClientboundContainerSetSlotPacket.class)
public interface ClientboundContainerSetSlotPacketMixin {
   @Mutable
   @Accessor("itemStack")
   void setItem(ItemStack var1);
}
