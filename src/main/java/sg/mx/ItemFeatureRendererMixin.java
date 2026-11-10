// Original binary: sg/mx/aGlrUVWTOuHAQ6Pg
package sg.mx;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.QuadInstance;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.feature.FeatureFrameContext;
import net.minecraft.client.renderer.feature.ItemFeatureRenderer;
import net.minecraft.client.renderer.feature.ItemFeatureRenderer.Submit;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.world.item.ItemDisplayContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ItemFeatureRendererHooks;
import sg.ec.ItemFeatureContextStack;

// $VF: Compiled from s
@Mixin(ItemFeatureRenderer.class)
public abstract class ItemFeatureRendererMixin {
   @Unique
   private boolean hmi$animating;
   @Unique
   private int hmi$index;
   @Unique
   private PoseStack hmi$scratch;

   @Unique
   private PoseStack hmi$scratch() {
      PoseStack var1 = this.hmi$scratch;
      if (var1 == null) {
         var1 = new PoseStack();
         this.hmi$scratch = var1;
      }

      return var1;
   }

   @Inject(method = "prepareMainSubmit", at = @At("HEAD"))
   private void hmi$prepareMainHead(Submit var1, CallbackInfo var2) {
      ItemDisplayContext var3 = var1.displayContext();
      if (var3.firstPerson() && Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
         ItemFeatureRendererHooks.method03349(ItemFeatureContextStack.method10966());
         this.hmi$index = 0;
         this.hmi$animating = true;
      } else {
         this.hmi$animating = false;
      }
   }

   @Redirect(
      method = "prepareMainSubmit",
      at = @At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;putBakedQuad(Lcom/mojang/blaze3d/vertex/PoseStack$Pose;Lnet/minecraft/client/resources/model/geometry/BakedQuad;Lcom/mojang/blaze3d/vertex/QuadInstance;)V"
      )
   )
   private void hmi$putBakedQuad(VertexConsumer var1, Pose var2, BakedQuad var3, QuadInstance var4) {
      if (this.hmi$animating) {
         this.hmi$scratch().last().set(var2);
         ItemFeatureRendererHooks.field07286.method11237(this.hmi$index, this.hmi$scratch());
         var1.putBakedQuad(this.hmi$scratch().last(), var3, var4);
         this.hmi$index++;
      } else {
         var1.putBakedQuad(var2, var3, var4);
      }
   }

   @Inject(method = "prepareMainSubmit", at = @At("RETURN"))
   private void hmi$prepareMainReturn(Submit var1, CallbackInfo var2) {
      if (this.hmi$animating) {
         ItemFeatureRendererHooks.field07286.method11246();
         this.hmi$animating = false;
      }
   }

   @Inject(method = "buildGroup", at = @At("RETURN"))
   private void hmi$buildGroupReturn(FeatureFrameContext var1, List<Submit> var2, CallbackInfo var3) {
      ItemFeatureContextStack.method10964();
      ItemFeatureRendererHooks.field07286.method11246();
   }
}
