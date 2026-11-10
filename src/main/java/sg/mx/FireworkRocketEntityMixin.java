// Original binary: sg/mx/jO694GssL4mkzZxb
package sg.mx;

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
   @Redirect(
      method = "tick",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V")
   )
   private void tick(LivingEntity var1, Vec3 var2) {
      FireworkBoostEvent.field09279.method04094(var1);
   }
}
