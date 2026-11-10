// Original binary: sg/mx/VxHEGfySgQr7s9YY
package sg.mx;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import sg.ec.EquipmentLayerRendererHooks;

// $VF: Compiled from s
@Mixin(EquipmentLayerRenderer.class)
public class EquipmentLayerRendererMixin {
   @ModifyArg(
      method = "renderLayers(Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lnet/minecraft/world/item/ItemStack;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/resources/Identifier;II)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/OrderedSubmitNodeCollector;submitModel(Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/rendertype/RenderType;IIILnet/minecraft/client/renderer/texture/UvMapping;I)V"
      ),
      index = 6
   )
   private int renderColor(int var1, @Local(argsOnly = true) ItemStack var2) {
      return EquipmentLayerRendererHooks.method04735(var1, var2);
   }
}
