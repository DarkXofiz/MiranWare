// Original binary: sg/ec/pGMlaaIbsviwQmhN
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelType;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class ElytraTargetRenderer implements MinecraftAccess {
   private static final int field22718 = 15728880;
   private static final float field22719 = 0;
   private static final float field22720 = 0;
   private static final float field22721 = 0;
   private static final float[][] field22722 = new float[][]{
      {1.0F, ElytraTargetRenderer.field22756},
      {ElytraTargetRenderer.field22757, ElytraTargetRenderer.field22758},
      {ElytraTargetRenderer.field22759, ElytraTargetRenderer.field22760}
   };
   private static final long field22723 = 0;
   private static final long field22724 = 0;
   private static final float field22725 = 0;
   private static final float field22726 = 0;
   private static final double field22727 = 0;
   private final AnimationUtils field22728;
   private PlayerModel field22729;
   private PlayerModel field22730;
   private AvatarRenderState field22731;
   private Identifier field22732;
   private Vec3 field22733;
   private Vec3 field22734;
   private int field22735;
   private boolean field22736;
   private static final long field22737 = 1000L;
   private static final int field22738 = Integer.MIN_VALUE;
   private static final long field22739 = 120L;
   private static final long field22740 = 1000L;
   private static final float field22741 = 0.02F;
   private static final int field22742 = Integer.MIN_VALUE;
   private static final double field22743 = 64.0;
   private static final float field22744 = 0.4F;
   private static final float field22745 = -1.0F;
   private static final float field22746 = -1.0F;
   private static final float field22747 = 0.9375F;
   private static final float field22748 = 0.9375F;
   private static final float field22749 = 0.9375F;
   private static final float field22750 = -1.501F;
   private static final int field22751 = 15728880;
   private static final float field22752 = 0.5F;
   private static final float field22753 = -0.5F;
   private static final float field22754 = 180.0F;
   private static final float field22755 = -90.0F;
   private static final float field22756 = 0.5F;
   private static final float field22757 = 1.05F;
   private static final float field22758 = 0.25F;
   private static final float field22759 = 1.11F;
   private static final float field22760 = 0.125F;

   public ElytraTargetRenderer() {
      this.field22728 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field22737);
      this.field22734 = Vec3.ZERO;
      this.field22735 = field22738;
   }

   public void method10074() {
      this.field22731 = null;
      this.field22732 = null;
      this.field22733 = null;
      this.field22734 = Vec3.ZERO;
      this.field22735 = field22742;
      this.field22728.method03366(0.0);
      this.field22728.method03369(0.0);
      this.field22728.method03374(0.0);
   }

   private void method10075(Render3DEvent var1, int var2, float var3) {
      PlayerModel var4 = this.method10082();
      var4.setupAnim(this.field22731);
      Vec3 var5 = var1.method00994().position();
      PoseStack var6 = var1.method00996();
      var6.pushPose();
      var6.translate(this.field22733.x - var5.x, this.field22733.y - var5.y, this.field22733.z - var5.z);
      var6.scale(this.field22731.scale, this.field22731.scale, this.field22731.scale);
      this.method10077(var6);
      var6.scale(field22745, field22746, 1.0F);
      var6.scale(field22747, field22748, field22749);
      var6.translate(0.0F, field22750, 0.0F);
      VertexConsumer var7 = var1.method00985().method07407(EffectRenderPipelines.method05535(this.field22732));

      for (float[] var11 : field22722) {
         var6.pushPose();
         this.method10076(var6, var11[0]);
         var4.renderToBuffer(var6, var7, field22751, OverlayTexture.NO_OVERLAY, ColorUtils.method04605(var2, var3 * var11[1]));
         var6.popPose();
      }

      var6.popPose();
   }

   private void method10076(PoseStack var1, float var2) {
      if (var2 != 1.0F) {
         var1.translate(0.0F, field22752, 0.0F);
         var1.scale(var2, var2, var2);
         var1.translate(0.0F, field22753, 0.0F);
      }
   }

   private void method10077(PoseStack var1) {
      var1.mulPose(Axis.YP.rotationDegrees(field22754 - this.field22731.bodyRot));
      if (this.field22731.isFallFlying) {
         if (!this.field22731.isAutoSpinAttack) {
            var1.mulPose(Axis.XP.rotationDegrees(this.field22731.fallFlyingScale() * (field22755 - this.field22731.xRot)));
         }

         if (this.field22731.shouldApplyFlyingYRot) {
            var1.mulPose(Axis.YP.rotation(this.field22731.flyingYRot));
         }
      }
   }

   private static EntityRenderer<Entity, EntityRenderState> method10078(AbstractClientPlayer var0) {
      return (EntityRenderer<Entity, EntityRenderState>)mc.getEntityRenderDispatcher().getRenderer(var0);
   }

   private boolean method10079(LivingEntity var1, Vec3 var2, float var3, float var4) {
      if (var1 instanceof AbstractClientPlayer var5 && var2 != null && !(var2.lengthSqr() <= 0.0)) {
         EntityRenderer var6 = method10078(var5);
         if (this.field22731 == null) {
            if (!(var6.createRenderState() instanceof AvatarRenderState var7)) {
               return false;
            }

            this.field22731 = var7;
         }

         var6.extractRenderState(var5, this.field22731, var3);
         this.field22732 = this.field22731.skin.body().texturePath();
         this.field22736 = this.field22731.skin.model() == PlayerModelType.SLIM;
         this.field22733 = var5.getPosition(var3).add(this.method10081(var5, var2, var4));
         return true;
      } else {
         return false;
      }
   }

   public void method10080(Render3DEvent var1, LivingEntity var2, Vec3 var3, int var4) {
      DeltaTracker var5 = var1.method00984();
      boolean var6 = this.method10079(var2, var3, var5.getGameTimeDeltaPartialTick(true), var5.getRealtimeDeltaTicks());
      this.field22728.method03368(var6 ? field22739 : field22740);
      this.field22728.method03375(var6 ? 1.0 : 0.0);
      float var7 = this.field22728.method03377();
      if (var7 <= field22741) {
         if (!var6) {
            this.method10074();
         }
      } else if (this.field22731 != null && this.field22732 != null && this.field22733 != null) {
         this.method10075(var1, var4, var7);
      }
   }

   private Vec3 method10081(AbstractClientPlayer var1, Vec3 var2, float var3) {
      Vec3 var4 = var2.subtract(var1.getEyePosition());
      if (this.field22735 == var1.getId() && !(this.field22734.distanceToSqr(var4) > field22743)) {
         this.field22734 = GuiHitTestUtils.method05607(var4, this.field22734, GuiHitTestUtils.method05621(var3 * field22744));
         return this.field22734;
      } else {
         this.field22735 = var1.getId();
         this.field22734 = var4;
         return this.field22734;
      }
   }

   private PlayerModel method10082() {
      if (this.field22736) {
         if (this.field22730 == null) {
            this.field22730 = new PlayerModel(mc.getEntityModels().bakeLayer(ModelLayers.PLAYER_SLIM), true);
         }

         return this.field22730;
      } else {
         if (this.field22729 == null) {
            this.field22729 = new PlayerModel(mc.getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
         }

         return this.field22729;
      }
   }
}
