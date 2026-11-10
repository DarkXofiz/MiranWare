package sg.mx;

import net.minecraft.client.player.FirstPersonHandsAndItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FirstPersonHandsAndItems.class)
public interface ItemInHandRendererMixin_1191 {
   @Accessor("mainHandHeight")
   float getMainHandHeight();
}
