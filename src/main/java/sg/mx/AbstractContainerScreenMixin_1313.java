// Original binary: sg/mx/yRshU9Ak0LFuEmSO
package sg.mx;

import sg.ec.InputCompat;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.AnimationUtils;
import sg.ec.ContainerAnimationEvent;
import sg.ec.ContainerMouseEvent;
import sg.ec.ContainerRenderEvent;
import sg.ec.ContainerKeyEvent;

// $VF: Compiled from s
@Mixin(AbstractContainerScreen.class)
public abstract class AbstractContainerScreenMixin_1313 {
   @Shadow
   protected int leftPos;
   @Shadow
   protected int topPos;
   @Shadow
   @Final
   protected int imageWidth;
   @Shadow
   @Final
   protected int imageHeight;
   @Unique
   private AnimationUtils anim;
   private static final long field28041 = 250L;

   @Unique
   private AnimationUtils anim() {
      AnimationUtils var1 = this.anim;
      if (var1 == null) {
         var1 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_EXPO, field28041);
         this.anim = var1;
      }

      return var1;
   }

   @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
   public void keyPressed(KeyEvent var1, CallbackInfoReturnable<Boolean> var2) {
      ContainerKeyEvent.field26473.method11627((AbstractContainerScreen<?>)(Object)this, InputCompat.glfwKey(var1.key()), var1.scancode(), var1.modifiers(), var2);
   }

   @Inject(method = "mouseClicked", at = @At("HEAD"), cancellable = true)
   private void mouseClicked(MouseButtonEvent var1, boolean var2, CallbackInfoReturnable<Boolean> var3) {
      ContainerMouseEvent.field22761
         .method10085((AbstractContainerScreen<?>)(Object)this, ContainerMouseEvent.Nested281.CLICK, var1.x(), var1.y(), InputCompat.glfwButton(var1.button()), 0.0, var3);
   }

   @Inject(method = "mouseDragged", at = @At("HEAD"), cancellable = true)
   private void mouseDragged(MouseButtonEvent var1, double var2, double var4, CallbackInfoReturnable<Boolean> var6) {
      ContainerMouseEvent.field22761
         .method10085((AbstractContainerScreen<?>)(Object)this, ContainerMouseEvent.Nested281.DRAG, var1.x(), var1.y(), InputCompat.glfwButton(var1.button()), 0.0, var6);
   }

   @Inject(method = "mouseReleased", at = @At("HEAD"), cancellable = true)
   private void mouseReleased(MouseButtonEvent var1, CallbackInfoReturnable<Boolean> var2) {
      ContainerMouseEvent.field22761
         .method10085((AbstractContainerScreen<?>)(Object)this, ContainerMouseEvent.Nested281.RELEASE, var1.x(), var1.y(), InputCompat.glfwButton(var1.button()), 0.0, var2);
   }

   @Inject(method = "mouseScrolled", at = @At("HEAD"), cancellable = true)
   private void mouseScrolled(double var1, double var3, double var5, double var7, CallbackInfoReturnable<Boolean> var9) {
      ContainerMouseEvent.field22761.method10085((AbstractContainerScreen<?>)(Object)this, ContainerMouseEvent.Nested281.SCROLL, var1, var3, -1, var7, var9);
   }

   @Inject(method = "extractContents", at = @At("TAIL"))
   public void render(GuiGraphicsExtractor var1, int var2, int var3, float var4, CallbackInfo var5) {
      ContainerRenderEvent.field22775
         .method10113((AbstractContainerScreen<?>)(Object)this, var1, this.leftPos, this.topPos, var2, var3, this.imageWidth, this.imageHeight);
   }

   @Inject(
      method = "extractContents",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/screens/Screen;extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IIF)V",
         shift = Shift.AFTER
      )
   )
   private void renderStart(
      GuiGraphicsExtractor var1, int var2, int var3, float var4, CallbackInfo var5, @Local(ordinal = 2) int var6, @Local(ordinal = 3) int var7
   ) {
      ContainerAnimationEvent.field11706.method05385(var6, var7, (AbstractContainerScreen)(Object)this, var1, this.anim());
   }

   @Inject(method = "extractContents", at = @At("TAIL"))
   private void renderEnd(GuiGraphicsExtractor var1, int var2, int var3, float var4, CallbackInfo var5) {
      ContainerAnimationEvent.field11706.method05382((AbstractContainerScreen)(Object)this, var1, this.anim());
   }

}
