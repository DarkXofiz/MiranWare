// Original binary: sg/mx/jlOI7w8pL2Ks62tB
package sg.mx;

import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.MinecraftAccess;
import sg.ec.PotionHitEvent;

// $VF: Compiled from s
@Mixin(AbstractThrownPotion.class)
public class AbstractThrownPotionMixin implements MinecraftAccess {
   @Inject(method = "onHit", at = @At("HEAD"))
   private void onCollision(HitResult var1, CallbackInfo var2) {
      AbstractThrownPotion var3 = (AbstractThrownPotion)(Object)this;
      if (var3.level().isClientSide()) {
         PotionHitEvent.field21912.method09605(var3, var1);
      }
   }
}
