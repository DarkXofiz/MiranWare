// Original binary: sg/mx/jO694GssL4mkzZxb
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.FireworkBoostEvent;

// $VF: Compiled from s
@Mixin(FireworkRocketEntity.class)
public class FireworkRocketEntityMixin {
   @WrapOperation(
      method = "tick",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V")
   )
   private void tick(LivingEntity var1, Vec3 var2, Operation<Void> hex$original) {
      FireworkBoostEvent.field09279.method04094(var1);
   }
}
