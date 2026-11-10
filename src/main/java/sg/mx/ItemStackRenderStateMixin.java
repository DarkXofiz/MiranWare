// Original binary: sg/mx/XwtO5QAqWKipAmIZ
package sg.mx;

import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState.LayerRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(ItemStackRenderState.class)
public interface ItemStackRenderStateMixin {
   @Invoker("firstLayer")
   LayerRenderState callFirstLayer();
}
