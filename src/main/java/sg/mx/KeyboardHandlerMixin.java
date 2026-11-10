// Original binary: sg/mx/I3tTqkr8IWt0795f
package sg.mx;

import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.input.CharacterEvent;
import net.minecraft.client.input.KeyEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.KeyboardInputUtils;
import sg.ec.KeyboardHandlerHooks;

// $VF: Compiled from s
@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {
   @Shadow
   @Final
   private Minecraft minecraft;

   @Inject(method = "keyPress", at = @At("HEAD"), cancellable = true)
   public void onClientScreenKey(long var1, int var3, KeyEvent var4, CallbackInfo var5) {
      if (KeyboardInputUtils.method00915(this.minecraft, var1, var3, var4)) {
         var5.cancel();
      }
   }

   @Inject(method = "charTyped", at = @At("HEAD"), cancellable = true)
   public void onClientScreenChar(long var1, CharacterEvent var3, CallbackInfo var4) {
      if (KeyboardInputUtils.method00911(this.minecraft, var1, var3)) {
         var4.cancel();
      }
   }

   @Inject(
      method = "keyPress",
      at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/FramerateLimitTracker;onInputReceived()V", shift = Shift.AFTER)
   )
   public void onKey(long var1, int var3, KeyEvent var4, CallbackInfo var5) {
      if (KeyboardHandlerHooks.method05137(this.minecraft, var3, var4)) {
         var5.cancel();
      }
   }
}
