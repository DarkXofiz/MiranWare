// Original binary: sg/mx/3FrpJAf944tBtYnz
package sg.mx;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.EntityNameHooks;

// $VF: Compiled from s
@Mixin(Entity.class)
public abstract class EntityMixin {
   @Unique
   private volatile Object[] hex$strippedName;

   @Shadow
   public abstract Component getCustomName();

   @Inject(method = "getName", at = @At("HEAD"), cancellable = true)
   private void hex$cachedName(CallbackInfoReturnable<Component> var1) {
      EntityNameHooks.method09469(this.getCustomName(), this.hex$strippedName, var1);
   }

   @Inject(method = "getName", at = @At("RETURN"))
   private void hex$storeName(CallbackInfoReturnable<Component> var1) {
      this.hex$strippedName = EntityNameHooks.method09470(this.getCustomName(), this.hex$strippedName, (Component)var1.getReturnValue());
   }
}
