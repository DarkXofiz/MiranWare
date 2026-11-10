// Original binary: sg/ec/QcEuBOghm1UUayfL
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.List;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;

// $VF: Compiled from s
public final class ItemInHandRendererHooks {
   public static boolean field11293 = false;
   public static volatile ItemInHandRendererHooks.Nested156 field11294;
   public static volatile ItemInHandRendererHooks.Nested157 field11295;
   private static final float field11296 = (float) Math.PI;
   private static final float field11297 = 0;
   private static final String field11298 = "SCREEN";
   private static final double field11299 = -0.35;
   private static final double field11300 = 0.2;
   private static final double field11301 = 1.5;
   private static final double field11302 = -0.3;
   private static final double field11303 = -0.6;
   private static final double field11304 = 15.0;
   private static final float field11305 = 0.5F;
   private static final double field11306 = 0.5;
   private static final double field11307 = 0.5;
   private static final float field11308 = 35.0F;
   private static final float field11309 = 0.5F;
   private static final double field11310 = 0.5;
   private static final double field11311 = 0.5;
   private static final float field11312 = -65.0F;
   private static final float field11313 = 0.5F;
   private static final double field11314 = 0.5;
   private static final double field11315 = 0.5;
   private static final float field11316 = 0.9F;
   private static final float field11317 = 0.9F;
   private static final float field11318 = 0.9F;
   private static final double field11319 = 0.5;
   private static final double field11320 = -0.15;
   private static final double field11321 = -0.85;
   private static final double field11322 = 15.0;
   private static final double field11323 = 0.5;
   private static final double field11324 = 0.5;
   private static final double field11325 = 0.5;
   private static final float field11326 = 0.9F;
   private static final float field11327 = 0.9F;
   private static final float field11328 = 0.9F;
   private static final float field11329 = -0.05F;
   private static final float field11330 = 0.2F;
   private static final float field11331 = 0.1F;
   private static final float field11332 = -12.0F;
   private static final String field11333 = "ITEM";
   private static final float field11334 = -1.0F;
   private static final float field11335 = -0.3F;
   private static final float field11336 = (float) Math.PI;
   private static final float field11337 = 0.4F;
   private static final float field11338 = (float) (Math.PI * 2);
   private static final float field11339 = -0.4F;
   private static final float field11340 = (float) Math.PI;
   private static final float field11341 = 0.64000005F;
   private static final float field11342 = -0.6F;
   private static final float field11343 = -0.6F;
   private static final float field11344 = -0.71999997F;
   private static final float field11345 = 45.0F;
   private static final float field11346 = (float) Math.PI;
   private static final float field11347 = (float) Math.PI;
   private static final float field11348 = 70.0F;
   private static final float field11349 = -20.0F;
   private static final float field11350 = -1.0F;
   private static final float field11351 = 3.6F;
   private static final float field11352 = 3.5F;
   private static final float field11353 = 120.0F;
   private static final float field11354 = 200.0F;
   private static final float field11355 = -135.0F;
   private static final float field11356 = 5.6F;

   private static void method05208(AbstractClientPlayer var0, InteractionHand var1, PoseStack var2) {
      ViewModelOffsetEvent.field09348.method04141(var0, var1, var2);
   }

   public static void method05209(
      PlayerArmRenderAccess var0,
      AbstractClientPlayer var1,
      float var2,
      float var3,
      InteractionHand var4,
      float var5,
      ItemStack var6,
      float var7,
      PoseStack var8,
      SubmitNodeCollector var9,
      int var10
   ) {
      if (!var1.isScoping()) {
         ItemAnimationState var11 = ItemAnimationState.INSTANCE;
         boolean var12 = var4 == InteractionHand.MAIN_HAND;
         HumanoidArm var13 = var12 ? var1.getMainArm() : var1.getMainArm().getOpposite();
         boolean var14 = var13 == HumanoidArm.RIGHT;
         int var15 = var14 ? 1 : -1;
         ItemAnimationContext var16 = var11.method03497(var12);
         var11.method03499(var16, var1, var6, var4, var12, var14, var15, var5, var7, var2, var3, var8, var9, var10);
         var8.pushPose();
         method05208(var1, var4, var8);
         var8.pushPose();
         method05214(var16);
         var8.pushPose();
         method05213(var16);
         if (var1.isInvisible() && !HeldItemRenderHooks.method05662()) {
            method05215(var8, var10, 0.0F, 0.0F, var13);
         } else {
            ((PlayerArmRenderAccess)var0).hmi$renderPlayerArm(var8, var9, var10, 0.0F, 0.0F, var13);
         }

         var8.popPose();
         var8.pushPose();
         var16.field19845 = var5;
         method05212(var0, var16, var15, var14);
         var8.popPose();
         var8.popPose();
         var11.method03500(var16);
         ItemInHandRendererHooks.Nested157 var17 = field11295;
         if (var17 != null) {
            var8.pushPose();
            var17.method05217(var16.field19861, var8, var9, field11298, var4, var10, var1, var2);
            var8.popPose();
         }

         var8.popPose();
         var11.field07833 = var2;
      }
   }

   private static void method05210(PlayerArmRenderAccess var0, ItemAnimationContext var1, boolean var2) {
      ItemInHandRendererHooks.Nested156 var3 = field11294;
      if (var3 == null || !var3.method05216(var1, var0)) {
         ItemDisplayContext var4 = var2 ? ItemDisplayContext.THIRD_PERSON_RIGHT_HAND : ItemDisplayContext.THIRD_PERSON_LEFT_HAND;
         var0.hmi$renderItem(var1.field19837, var1.field19838, var4, var1.field19839, var1.field19840, var1.field19850);
      }
   }

   private static void method05211(ItemAnimationContext var0) {
      int var1 = var0.field19843 ? 1 : -1;
      PoseStack var2 = var0.field19839;
      var2.translate(field11319 * var1, field11320, field11321);
      ItemAnimationMath.method00511(var2, field11322, field11323, field11324, field11325);
      var2.scale(field11326, field11327, field11328);
      ParticleConfigCodec.method05963(var0);
   }

   private static void method05212(PlayerArmRenderAccess var0, ItemAnimationContext var1, int var2, boolean var3) {
      ItemStack var4 = var1.field19838;
      if (!var4.isEmpty()) {
         ItemUseAnimation var5 = var4.getUseAnimation();
         boolean var6 = var5 == ItemUseAnimation.EAT || var5 == ItemUseAnimation.DRINK || var5 == ItemUseAnimation.SPEAR;
         method05211(var1);
         if (var6) {
            method05210(var0, var1, var3);
         } else {
            PoseStack var7 = var1.field19839;
            if (var4.has(DataComponents.MAP_ID)) {
               var7.pushPose();
               var7.translate(field11329 * var2, field11330, field11331);
               var7.mulPose(Axis.YP.rotationDegrees(field11332 * var2));
               ((PlayerArmRenderAccess)var0).hmi$renderMap(var7, var1.field19840, var1.field19850, var4);
               var7.popPose();
            } else {
               method05210(var0, var1, var3);
            }

            if (var3) {
               ItemAnimationState.INSTANCE.field07844.set(var7.last().pose());
            } else {
               ItemAnimationState.INSTANCE.field07845.set(var7.last().pose());
            }

            ItemInHandRendererHooks.Nested157 var8 = field11295;
            if (var8 != null) {
               var7.pushPose();
               var8.method05217(var1.field19861, var7, var1.field19840, field11333, var1.field19841, var1.field19850, var1.field19837, var1.field19848);
               var7.popPose();
            }
         }
      }
   }

   private static void method05213(ItemAnimationContext var0) {
      TridentItemUtils.method09512(var0);
      if (!var0.field19838.isEmpty()) {
         int var1 = var0.field19843 ? 1 : -1;
         PoseStack var2 = var0.field19839;
         var2.translate(field11301 * var1, field11302, field11303);
         ItemAnimationMath.method00511(var2, field11304, field11305 * var1, field11306, field11307);
         ItemAnimationMath.method00508(var2, field11308 * var1, field11309 * var1, field11310, field11311);
         ItemAnimationMath.method00509(var2, field11312 * var1, field11313 * var1, field11314, field11315);
         var2.scale(field11316, field11317, field11318);
      }
   }

   private ItemInHandRendererHooks() {
   }

   private static void method05214(ItemAnimationContext var0) {
      WeaponItemTypes.method11659(var0);
      if (!var0.field19838.isEmpty()) {
         var0.field19839.translate(0.0, field11299, field11300);
      }
   }

   private static void method05215(PoseStack var0, int var1, float var2, float var3, HumanoidArm var4) {
      boolean var5 = var4 != HumanoidArm.LEFT;
      float var6 = var5 ? 1.0F : field11334;
      float var7 = Mth.sqrt(var3);
      float var8 = field11335 * Mth.sin(var7 * field11336);
      float var9 = field11337 * Mth.sin(var7 * field11338);
      float var10 = field11339 * Mth.sin(var3 * field11340);
      var0.translate(var6 * (var8 + field11341), var9 + field11342 + var2 * field11343, var10 + field11344);
      var0.mulPose(Axis.YP.rotationDegrees(var6 * field11345));
      float var11 = Mth.sin(var3 * var3 * field11346);
      float var12 = Mth.sin(var7 * field11347);
      var0.mulPose(Axis.YP.rotationDegrees(var6 * var12 * field11348));
      var0.mulPose(Axis.ZP.rotationDegrees(var6 * var11 * field11349));
      var0.translate(var6 * field11350, field11351, field11352);
      var0.mulPose(Axis.ZP.rotationDegrees(var6 * field11353));
      var0.mulPose(Axis.XP.rotationDegrees(field11354));
      var0.mulPose(Axis.YP.rotationDegrees(var6 * field11355));
      var0.translate(var6 * field11356, 0.0F, 0.0F);
   }

   // $VF: Compiled from s
   public interface Nested156 {
      boolean method05216(ItemAnimationContext var1, PlayerArmRenderAccess var2);
   }

   // $VF: Compiled from s
   public interface Nested157 {
      void method05217(
         List<ParticleAnimationConfig> var1,
         PoseStack var2,
         SubmitNodeCollector var3,
         String var4,
         InteractionHand var5,
         int var6,
         AbstractClientPlayer var7,
         float var8
      );
   }
}
