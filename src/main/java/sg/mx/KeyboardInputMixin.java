// Original binary: sg/mx/AcCniwYYmHgo23q2
package sg.mx;

import net.minecraft.client.Options;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.world.entity.player.Input;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.PlayerInputEvent;

// $VF: Compiled from s
@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin {
   @Shadow
   @Final
   private Options options;

   @Inject(method = "tick", at = @At("HEAD"))
   public void tick(CallbackInfo var1) {
      PlayerInputEvent.field06252.method02727(this.options);
   }

   @Redirect(method = "tick", at = @At(value = "NEW", target = "Lnet/minecraft/world/entity/player/Input;"))
   public Input redirectInput(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      return PlayerInputEvent.field06252.method11171();
   }

   @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/KeyboardInput;calculateImpulse(ZZ)F", ordinal = 0))
   public float forward(boolean var1, boolean var2) {
      return PlayerInputEvent.field06252.method11161();
   }

   @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/KeyboardInput;calculateImpulse(ZZ)F", ordinal = 1))
   public float strafe(boolean var1, boolean var2) {
      return PlayerInputEvent.field06252.method11166();
   }
}
