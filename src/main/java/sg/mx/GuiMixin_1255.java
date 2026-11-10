// Original binary: sg/mx/ffU9s0UpJajV7TIx
package sg.mx;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.KeyboardInputUtils;
import sg.ec.ScreenChangeEvent;
import sg.ec.HudRenderEvent;
import sg.ec.ScriptRuntime;
import sg.ec.GuiRenderEvent;

// $VF: Compiled from s
@Mixin(Gui.class)
public class GuiMixin_1255 {
   @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
   private void hex$onSetScreen(Screen var1, CallbackInfo var2) {
      ScreenChangeEvent.field07239.method03321(var1, var2);
   }

   @Inject(method = "setScreen", at = @At("TAIL"))
   private void hex$afterSetScreen(Screen var1, CallbackInfo var2) {
      KeyboardInputUtils.method00914();
      ScriptRuntime.INSTANCE.method06199(var1 != null);
   }

   @Inject(
      method = "extractRenderState",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;applyCursor(Lcom/mojang/blaze3d/platform/Window;)V")
   )
   private void hex$renderClientScreen(DeltaTracker var1, boolean var2, boolean var3, CallbackInfo var4, @Local GuiGraphicsExtractor var5) {
      KeyboardInputUtils.method00910(var5, var1.getGameTimeDeltaTicks());
   }

   @Inject(
      method = "extractRenderState",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/Hud;extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;Lnet/minecraft/client/DeltaTracker;)V",
         shift = Shift.AFTER
      )
   )
   private void renderHud(DeltaTracker var1, boolean var2, boolean var3, CallbackInfo var4, @Local GuiGraphicsExtractor var5) {
      HudRenderEvent.field11740.method05422(var5, var1);
   }

   @Inject(
      method = "extractRenderState",
      at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/Gui;overlay:Lnet/minecraft/client/gui/screens/Overlay;", opcode = 180, ordinal = 0)
   )
   private void render(
      DeltaTracker var1,
      boolean var2,
      boolean var3,
      CallbackInfo var4,
      @Local GuiGraphicsExtractor var5,
      @Local(ordinal = 0) int var6,
      @Local(ordinal = 1) int var7
   ) {
      GuiRenderEvent.field19167.method08308(var1, var5, var6, var7);
   }
}
