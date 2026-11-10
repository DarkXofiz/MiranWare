// Original binary: sg/mx/Af21grwO3pCbTYoX
package sg.mx;

import java.util.List;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ClientboundContainerSetContentPacket.class)
public interface ClientboundContainerSetContentPacketMixin {
   @Mutable
   @Accessor("items")
   void setItems(List<ItemStack> var1);
}
