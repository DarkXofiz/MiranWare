// Original binary: sg/mx/1VCj2245EuPOJqe8
package sg.mx;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.HelmetStackCache;

// $VF: Compiled from s
@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
   @Redirect(
      method = "getBoundingBoxForCulling",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/entity/LivingEntity;getItemBySlot(Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;"
      )
   )
   private ItemStack hex$cachedHelmet(LivingEntity var1, EquipmentSlot var2) {
      return HelmetStackCache.method05653(var1, var2);
   }
}
