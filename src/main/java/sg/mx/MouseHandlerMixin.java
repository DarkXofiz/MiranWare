// Original binary: sg/mx/YgvJLGLwsCDSikbH
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.input.MouseButtonInfo;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.KeyboardInputUtils;
import sg.ec.MouseTurnEvent;
import sg.ec.ScriptRuntime;
import sg.ec.MouseHandlerHooks;
import sg.ec.ClientScreenManager;

// $VF: Compiled from s
@Mixin(MouseHandler.class)
public abstract class MouseHandlerMixin {
   @Shadow
   @Final
   private Minecraft minecraft;
   @Shadow
   private double xpos;
   @Shadow
   private double ypos;

   @Inject(method = "grabMouse", at = @At("HEAD"), cancellable = true)
   private void keepClickGuiCursorFree(CallbackInfo var1) {
      if (ClientScreenManager.INSTANCE.method08316()) {
         var1.cancel();
      }
   }

   @Inject(method = "onButton", at = @At("HEAD"), cancellable = true)
   private void onMouseButton(long var1, MouseButtonInfo var3, int var4, CallbackInfo var5) {
      if (KeyboardInputUtils.method00913(this.minecraft, var1, var3, var4)) {
         var5.cancel();
      } else {
         if (MouseHandlerHooks.method06578(this.minecraft, this.xpos, this.ypos, var1, var3, var4)) {
            var5.cancel();
         }
      }
   }

   @Inject(method = "onScroll", at = @At("HEAD"), cancellable = true)
   private void onMouseScroll(long var1, double var3, double var5, CallbackInfo var7) {
      if (KeyboardInputUtils.method00908(this.minecraft, var1, var3, var5) || ScriptRuntime.INSTANCE.method06197(var5, var3)) {
         var7.cancel();
      }
   }

   @Redirect(method = "turnPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;turn(DD)V"))
   private void onMouse(LocalPlayer var1, double var2, double var4) {
      MouseTurnEvent.field09721.method04332(var1, var2, var4);
   }

   @Redirect(method = "onScroll", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;setSelectedSlot(I)V"))
   private void onScrollSelectSlot(Inventory var1, int var2) {
      MouseHandlerHooks.method06579(var1, var2);
   }
}
