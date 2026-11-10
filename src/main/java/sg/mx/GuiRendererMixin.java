// Original binary: sg/mx/A29TaMbnSAWtRkh6
package sg.mx;

import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.renderpearl.api.commands.RenderPass;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.GuiRenderer;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.gui.render.GuiItemAtlas.SlotView;
import net.minecraft.client.renderer.StagedVertexBuffer.Draw;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.client.renderer.state.gui.GuiItemRenderState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.CustomAlphaAccess;
import sg.ec.GuiBlurBarrierHooks;
import sg.ec.GuiScreenRenderHooks;

// $VF: Compiled from s
@Mixin(GuiRenderer.class)
public class GuiRendererMixin {
   @Unique
   private float hex_currentItemAlpha;
   @Shadow
   @Final
   private List<?> draws;
   @Shadow
   private ScreenRectangle previousScissorArea;
   @Shadow
   private RenderPipeline previousPipeline;
   @Shadow
   private TextureSetup previousTextureSetup;
   @Shadow
   private Draw previousDraw;
   @Unique
   private boolean hex_emptyScissor;

   @Inject(method = "submitBlitFromItemAtlas", at = @At("HEAD"))
   private void hex_captureItemAlpha(GuiItemRenderState var1, SlotView var2, CallbackInfo var3) {
      this.hex_currentItemAlpha = ((CustomAlphaAccess)(Object)var1).getCustomAlpha();
   }

   @ModifyConstant(method = "submitBlitFromItemAtlas", constant = @Constant(intValue = -1))
   private int hex_applyItemAlpha(int var1) {
      return GuiScreenRenderHooks.method04725(this.hex_currentItemAlpha, var1);
   }

   @Inject(method = "render", at = @At("HEAD"))
   private void hex_overlayBegin(CallbackInfo var1) {
      GuiScreenRenderHooks.method04727();
   }

   @Shadow
   private void executeDrawRange(Supplier<String> var1, RenderTarget var2, GpuBufferSlice var3, int var4, int var5) {
      throw new AssertionError();
   }

   @Inject(method = "prepare", at = @At("HEAD"))
   private void hex_resetCaptureIndex(CallbackInfo var1) {
      GuiBlurBarrierHooks.method03412();
   }

   @Inject(method = "addElementToMesh", at = @At("HEAD"), cancellable = true)
   private void hex_markCapture(GuiElementRenderState var1, CallbackInfo var2) {
      if (GuiBlurBarrierHooks.method03408(var1)) {
         GuiBlurBarrierHooks.method03411(this.draws.size());
         this.previousDraw = null;
         this.previousPipeline = null;
         this.previousTextureSetup = null;
         this.previousScissorArea = null;
         var2.cancel();
      }
   }

   @Inject(method = "enableScissor", at = @At("HEAD"), cancellable = true)
   private void hex_guardEmptyScissor(ScreenRectangle var1, RenderPass var2, CallbackInfo var3) {
      if (GuiScreenRenderHooks.method04726(var1)) {
         this.hex_emptyScissor = true;
         var3.cancel();
      }
   }

   @Redirect(method = "executeDraw", at = @At(value = "INVOKE", target = "Lcom/mojang/renderpearl/api/commands/RenderPass;drawIndexed(IIIII)V"))
   private void hex_skipEmptyScissorDraw(RenderPass var1, int var2, int var3, int var4, int var5, int var6) {
      if (this.hex_emptyScissor) {
         this.hex_emptyScissor = false;
      } else {
         var1.drawIndexed(var2, var3, var4, var5, var6);
      }
   }

   @Redirect(
      method = "draw",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/render/GuiRenderer;executeDrawRange(Ljava/util/function/Supplier;Lcom/mojang/blaze3d/pipeline/RenderTarget;Lcom/mojang/renderpearl/api/buffers/GpuBufferSlice;II)V"
      )
   )
   private void hex_captureBeforeClientScreen(GuiRenderer var1, Supplier<String> var2, RenderTarget var3, GpuBufferSlice var4, int var5, int var6) {
      int var7 = var5;
      int var8 = 0;

      for (int var9 = GuiBlurBarrierHooks.method03414(); var8 < var9; var8++) {
         int var10 = GuiBlurBarrierHooks.method03409(var8);
         if (var10 >= var5 && var10 < var6) {
            if (var10 > var7) {
               this.executeDrawRange(var2, var3, var4, var7, var10);
            }

            GuiBlurBarrierHooks.method03413(var3);
            var7 = var10;
         }
      }

      if (var7 < var6) {
         this.executeDrawRange(var2, var3, var4, var7, var6);
      }
   }
}
