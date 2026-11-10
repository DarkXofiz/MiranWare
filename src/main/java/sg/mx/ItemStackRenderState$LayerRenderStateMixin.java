// Original binary: sg/mx/4NJnlEJcq9v4dld1
package sg.mx;

import net.minecraft.client.renderer.item.ItemStackRenderState.LayerRenderState;
import net.minecraft.client.resources.model.cuboid.ItemTransform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(LayerRenderState.class)
public interface ItemStackRenderState$LayerRenderStateMixin {
   @Accessor("itemTransform")
   ItemTransform getItemTransform();
}
