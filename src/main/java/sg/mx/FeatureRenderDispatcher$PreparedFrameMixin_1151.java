// Original binary: sg/mx/E5sYCNRbQSLAkyS4
package sg.mx;

import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.feature.FeatureFrameContext;
import net.minecraft.client.renderer.feature.FeatureRenderDispatcher.PreparedFrame;
import net.minecraft.client.renderer.feature.phase.FeatureRenderPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.RenderSubmissionAccess;
import sg.ec.TargetScanRenderer;
import sg.ec.GuiBeforeClearAccess;
import sg.ec.FeatureRenderDispatcherPreparedFrameHooks;

// $VF: Compiled from s
@Mixin(PreparedFrame.class)
public abstract class FeatureRenderDispatcher$PreparedFrameMixin_1151 implements GuiBeforeClearAccess {
   @Shadow
   private FeatureFrameContext context;
   @Shadow
   private SubmitNodeStorage submitNodeStorage;
   @Shadow
   private Map<FeatureRenderPhase<?>, List<?>> groupsByPhase;

   @Shadow
   private void executePhase(FeatureRenderPhase<?> var1, FeatureFrameContext var2, com.mojang.renderpearl.api.commands.RenderPass var3) {
      throw new AssertionError();
   }

   @Inject(method = "executeOutline", at = @At("RETURN"))
   private void hexCaptureSilhouette(com.mojang.renderpearl.api.commands.RenderPass var0, CallbackInfo var1) {
      TargetScanRenderer.method05982();
   }

   @Override
   public boolean hexHasBeforeClear() {
      return FeatureRenderDispatcherPreparedFrameHooks.method11599(this.submitNodeStorage, this.groupsByPhase);
   }

   @Override
   public void hexExecuteBeforeClear() {
      FeatureFrameContext var1 = this.context;
      SubmitNodeStorage var2 = this.submitNodeStorage;
      if (var1 != null && var2 != null) {
         com.mojang.blaze3d.pipeline.RenderTarget var5 = net.minecraft.client.Minecraft.getInstance().gameRenderer.mainRenderTarget();
         try (com.mojang.renderpearl.api.commands.RenderPass var6 = com.mojang.blaze3d.systems.RenderSystem.getDevice()
               .createCommandEncoder()
               .createRenderPass(
                  () -> "hex before clear", var5.getColorTextureView(), java.util.Optional.empty(), var5.getDepthTextureView(), java.util.OptionalDouble.empty()
               )) {
            com.mojang.blaze3d.systems.RenderSystem.bindDefaultUniforms(var6);
            ObjectIterator var3 = var2.getSubmitsPerOrder().values().iterator();

            while (var3.hasNext()) {
               SubmitNodeCollection var4 = (SubmitNodeCollection)var3.next();
               this.executePhase(((RenderSubmissionAccess)var4).hexBeforeClear(), var1, var6);
            }
         }
      }
   }
}
