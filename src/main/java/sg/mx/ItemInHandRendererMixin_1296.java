package sg.mx;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FirstPersonHandsAndItemsRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.FirstPersonHandsAndItemsRenderState;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.HeldItemRenderHooks;
import sg.ec.ItemAnimationState;
import sg.ec.ItemInHandRendererHooks;
import sg.ec.PlayerArmRenderAccess;

@Mixin(FirstPersonHandsAndItemsRenderer.class)
public abstract class ItemInHandRendererMixin_1296 implements PlayerArmRenderAccess {
   @Shadow
   @Final
   private Minecraft minecraft;
   @Unique
   private PlayerRenderState hmi$playerState;
   @Unique
   private FirstPersonHandsAndItemsRenderState hmi$state;
   @Unique
   private final ItemStackRenderState hmi$itemState = new ItemStackRenderState();

   @Shadow
   protected abstract void renderPlayerArm(PoseStack var1, SubmitNodeCollector var2, int var3, float var4, float var5, HumanoidArm var6, PlayerRenderState var7);

   @Shadow
   protected abstract void renderMap(PoseStack var1, SubmitNodeCollector var2, int var3, ItemStack var4, boolean var5, FirstPersonHandsAndItemsRenderState var6);

   @Override
   public void hmi$renderPlayerArm(PoseStack var1, SubmitNodeCollector var2, int var3, float var4, float var5, HumanoidArm var6) {
      if (this.hmi$playerState != null) {
         this.renderPlayerArm(var1, var2, var3, var4, var5, var6, this.hmi$playerState);
      }
   }

   @Override
   public void hmi$renderMap(PoseStack var1, SubmitNodeCollector var2, int var3, ItemStack var4) {
      if (this.hmi$state != null) {
         this.renderMap(var1, var2, var3, var4, var4 == this.hmi$state.mainHandItem, this.hmi$state);
      }
   }

   @Override
   public void hmi$renderItem(LivingEntity var1, ItemStack var2, ItemDisplayContext var3, PoseStack var4, SubmitNodeCollector var5, int var6) {
      if (!var2.isEmpty()) {
         this.minecraft.getItemModelResolver().updateForLiving(this.hmi$itemState, var2, var3, var1);
         this.hmi$itemState.submit(var4, var5, var6, OverlayTexture.NO_OVERLAY, 0);
      }
   }

   @Inject(method = "submitHandsWithItems", at = @At("HEAD"))
   private void hmi$beginFrame(float var1, PoseStack var2, SubmitNodeCollector var3, PlayerRenderState var4, FirstPersonHandsAndItemsRenderState var5, CallbackInfo var6) {
      this.hmi$playerState = var4;
      this.hmi$state = var5;
      if (ItemInHandRendererHooks.field11293) {
         ItemAnimationState.INSTANCE.method03498();
      }
   }

   @Inject(method = "submitArmWithItem", at = @At("HEAD"), cancellable = true)
   private void hmi$overhaul(
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
      if (ItemInHandRendererHooks.field11293 && this.minecraft.player != null) {
         ItemStack var13 = HeldItemRenderHooks.method05665(var5, this.minecraft, var7);
         ItemInHandRendererHooks.method05209(this, this.minecraft.player, var3, var4, var5, var6, var13, var8, var9, var10, var11);
         var12.cancel();
      }
   }
}
