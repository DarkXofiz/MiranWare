package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FirstPersonHandsAndItemsRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.FirstPersonHandsAndItemsRenderState;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.HandGlowRenderer;
import sg.ec.HeldItemRenderHooks;
import sg.ec.ItemInHandRendererHooks;
import sg.ec.SwingTransformEvent;
import sg.ec.ViewModelOffsetEvent;

@Mixin(FirstPersonHandsAndItemsRenderer.class)
public abstract class ItemInHandRendererMixin {
   @Shadow
   @Final
   private Minecraft minecraft;

   @Shadow
   protected abstract void applyItemArmAttackTransform(PoseStack var1, HumanoidArm var2, float var3);

   @Inject(method = "submitArmWithItem", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;pushPose()V", shift = Shift.AFTER, ordinal = 0))
   private void renderFirst(
      PlayerRenderState var1,
      FirstPersonHandsAndItemsRenderState var2,
      float var3,
      float var4,
      InteractionHand var5,
      float var6,
      ItemStack var7,
      float var8,
      PoseStack var9,
      SubmitNodeCollector var10,
      int var11,
      CallbackInfo var12
   ) {
      if (this.minecraft.player != null) {
         ViewModelOffsetEvent.field09348.method04141(this.minecraft.player, var5, var9);
      }
   }

   @ModifyVariable(method = "submitArmWithItem", at = @At("HEAD"), argsOnly = true, ordinal = 0)
   private ItemStack renderFirstPersonItem(
      ItemStack var1, PlayerRenderState var2, FirstPersonHandsAndItemsRenderState var3, float var4, float var5, InteractionHand var6
   ) {
      return ItemInHandRendererHooks.field11293 ? var1 : HeldItemRenderHooks.method05665(var6, this.minecraft, var1);
   }

   @Redirect(method = "swingArm", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V"))
   private void swingArmTranslate(PoseStack var1, float var2, float var3, float var4) {
      SwingTransformEvent.field01060.method00536(var1, var2, var3, var4);
   }

   @Redirect(
      method = "swingArm",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/FirstPersonHandsAndItemsRenderer;applyItemArmAttackTransform(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/entity/HumanoidArm;F)V"
      )
   )
   private void swingArm(FirstPersonHandsAndItemsRenderer var1, PoseStack var2, HumanoidArm var3, float var4) {
      SwingTransformEvent.field01060.method00534(var2, var3, var4, () -> this.applyItemArmAttackTransform(var2, var3, var4));
   }

   @Redirect(method = "applyItemArmTransform", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V"))
   private void applyEquipOffset(PoseStack var1, float var2, float var3, float var4, @Local(ordinal = 0) int var5, @Local(argsOnly = true) float var6) {
      SwingTransformEvent.field01060.method00535(var1, var2, var3, var4, var5, var6);
   }

   @ModifyArg(
      method = "submitArmWithItem",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/item/ItemStackRenderState;submit(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;III)V"
      ),
      index = 4
   )
   private int hexHandGlowColor(int var1) {
      return HandGlowRenderer.method01239(var1);
   }

   @Inject(method = "submitHandsWithItems", at = @At("HEAD"))
   private void hexHandGlowSnapshot(float var1, PoseStack var2, SubmitNodeCollector var3, PlayerRenderState var4, FirstPersonHandsAndItemsRenderState var5, CallbackInfo var6) {
      HeldItemRenderHooks.method05667(var5.mainHandItem, var5.offHandItem);
   }

   @ModifyExpressionValue(
      method = {"submitArmWithItem", "renderOneHandedMap", "renderTwoHandedMap"},
      at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;isInvisible:Z")
   )
   private boolean renderInvisibleArm(boolean var1) {
      return var1 && !HeldItemRenderHooks.method05662();
   }
}
