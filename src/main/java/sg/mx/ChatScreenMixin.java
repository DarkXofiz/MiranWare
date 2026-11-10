// Original binary: sg/mx/kCDhzpL5vydAe3us
package sg.mx;

import sg.ec.InputCompat;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ChatClosedEvent;
import sg.ec.Render2DEvent;
import sg.ec.InputAction;
import sg.ec.ChatMouseButtonEvent;
import sg.ec.ChatMouseScrollEvent;
import sg.ec.ChatKeyEvent;

// $VF: Compiled from s
@Mixin(ChatScreen.class)
public abstract class ChatScreenMixin extends Screen {
   @Shadow
   protected EditBox input;

   protected ChatScreenMixin(Component var1) {
      super(var1);
   }

   @Inject(method = "init", at = @At("TAIL"))
   private void expandInput(CallbackInfo var1) {
      int var2 = 0;
      if (var2 > 0 && this.input != null) {
         this.input.setMaxLength(var2);
      }
   }

   @Inject(method = "normalizeChatMessage", at = @At("HEAD"), cancellable = true)
   private void keepRawCommand(String var1, CallbackInfoReturnable<String> var2) {
      String var3 = null;
      if (var3 != null) {
         var2.setReturnValue(var3);
      }
   }

   @Inject(
      method = "mouseClicked",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/screens/Screen;mouseClicked(Lnet/minecraft/client/input/MouseButtonEvent;Z)Z",
         shift = Shift.BEFORE
      )
   )
   private void mouseClicked(MouseButtonEvent var1, boolean var2, CallbackInfoReturnable<Boolean> var3) {
      double var4 = var1.x();
      double var6 = var1.y();
      int var8 = InputCompat.glfwButton(var1.button());
      ChatMouseButtonEvent.field14699.method06506((float)var4, (float)var6, var8, InputAction.PRESS);
   }

   @Inject(method = "onClose", at = @At("RETURN"))
   public void close(CallbackInfo var1) {
      ChatClosedEvent.field06848.method03208();
      super.onClose();
   }

   @Override
   public boolean mouseReleased(MouseButtonEvent var1) {
      double var2 = var1.x();
      double var4 = var1.y();
      int var6 = InputCompat.glfwButton(var1.button());
      ChatMouseButtonEvent.field14699.method06506((float)var2, (float)var4, var6, InputAction.RELEASE);
      return super.mouseReleased(var1);
   }

   @Inject(
      method = "extractRenderState",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/components/CommandSuggestions;extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;II)V"
      )
   )
   public void render(GuiGraphicsExtractor var1, int var2, int var3, float var4, CallbackInfo var5) {
      Render2DEvent.field07060.method03223(var1, this.minecraft.getWindow(), var2, var3);
   }

   @Inject(method = "mouseScrolled", at = @At("TAIL"))
   private void onMouseScroll(double var1, double var3, double var5, double var7, CallbackInfoReturnable<Boolean> var9) {
      ChatMouseScrollEvent.field14704.method06514(var1, var3, var5, var7);
   }

   @Inject(method = "keyPressed", at = @At("TAIL"))
   private void onKey(KeyEvent var1, CallbackInfoReturnable<Boolean> var2) {
      int var3 = InputCompat.glfwKey(var1.key());
      int var4 = var1.keycode();
      int var5 = var1.modifiers();
      ChatKeyEvent.field21313.method09379(var3, var4, var5);
   }
}
