// Original binary: sg/mx/fHq6K983X3rPWMo3
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.HeldItemRenderEvent;

// $VF: Compiled from s
@Mixin(ArmedEntityRenderState.class)
public class ArmedEntityRenderStateMixin {
   @ModifyExpressionValue(
      method = "extractArmedEntityRenderState",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/entity/LivingEntity;getItemHeldByArm(Lnet/minecraft/world/entity/HumanoidArm;)Lnet/minecraft/world/item/ItemStack;",
         ordinal = 0
      )
   )
   private static ItemStack updateRenderStateRightArmStack(ItemStack var0, LivingEntity var1) {
      return HeldItemRenderEvent.field00682.method00308(var1, HumanoidArm.RIGHT, var0);
   }

   @ModifyExpressionValue(
      method = "extractArmedEntityRenderState",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/entity/LivingEntity;getItemHeldByArm(Lnet/minecraft/world/entity/HumanoidArm;)Lnet/minecraft/world/item/ItemStack;",
         ordinal = 1
      )
   )
   private static ItemStack updateRenderStateLeftArmStack(ItemStack var0, LivingEntity var1) {
      return HeldItemRenderEvent.field00682.method00308(var1, HumanoidArm.LEFT, var0);
   }
}
