// Original binary: sg/ec/jELsCCqnE0xMj7os
package sg.ec;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.feature.FeatureRenderDispatcher.PreparedFrame;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class LevelRendererHooks {
   private static final Logger field20375 = LoggerFactory.getLogger(LevelRendererHooks.field20377);
   private static long field20376;
   private static final String field20377 = "MiranWare";

   private LevelRendererHooks() {
   }

   public static void method08951(SubmitNodeStorage var0, DeltaTracker var1, Matrix4fc var2, Matrix4f var3, Frustum var4) {
      WorldVertexCollector var5 = new WorldVertexCollector(var0);
      Matrix4f var6 = var3.set(var2);
      Render3DEvent.field02241.method00988(var5, var1, new PoseStack(), var6, var4, Minecraft.getInstance().gameRenderer.mainCamera());
   }

   public static void method08952(CallbackInfoReturnable<RenderTarget> var0) {
      RenderTarget var1 = HandGlowRenderer.method01216();
      if (var1 != null) {
         var0.setReturnValue(var1);
      }
   }

   public static void method08953(RenderTarget var0, GpuTextureView var1, GpuTextureView var2) {
      boolean var3 = EntityGlowRenderer.method07036();
      if (!RenderTargetEvent.field00066.method00001(var0, var1)) {
         if (var3) {
            var0.blitAndBlendToTexture(var1, var2);
         }
      }
   }

   public static void method08954(PreparedFrame var0) {
      ((GuiBeforeClearAccess)var0).hexExecuteBeforeClear();
      JumpCircleRenderer.method03200();
      BlockEspOutlineRenderer.method09156();
   }

   public static boolean method08955(boolean var0, PreparedFrame var1) {
      return var0 || ((GuiBeforeClearAccess)var1).hexHasBeforeClear() || JumpCircleRenderer.method03197() || BlockEspOutlineRenderer.method09154();
   }
}
