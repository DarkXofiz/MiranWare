// Original binary: sg/ec/Dn3GGXbhL9ArER0H
package sg.ec;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.RemotePlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public class CapturedPlayer extends RemotePlayer implements MinecraftAccess {
   public float field06960;
   public float field06961;
   public float field06962;
   public PlayerModel field06963;
   public AvatarRenderState field06964;
   public final Identifier field06965;
   private static int field06966 = CapturedPlayer.field06968;
   private static final String field06967 = "Captured Player";
   private static final int field06968 = -2000000;

   @Override
   public boolean canCollideWith(Entity var1) {
      return false;
   }

   @Override
   public boolean isPushable() {
      return false;
   }

   @Override
   public boolean isCreative() {
      return false;
   }

   @Override
   protected void doPush(Entity var1) {
   }

   @Override
   public boolean isSpectator() {
      return false;
   }

   public void tickAge() {
      this.tickCount++;
      if (this.tickCount >= 30) {
         this.remove(RemovalReason.DISCARDED);
         CapturedPlayerManager.method03887().remove(this);
      }
   }

   public CapturedPlayer(AbstractClientPlayer var1) {
      super(mc.level, new GameProfile(UUID.randomUUID(), field06967));
      this.setId(field06966--);
      this.copyPosition(var1);
      this.setPos(var1.getX(), var1.getY(), var1.getZ());
      this.setYRot(var1.getYRot());
      this.setXRot(var1.getXRot());
      this.field06965 = var1.getSkin().body().texturePath();
      this.walkAnimation.setSpeed(var1.walkAnimation.speed());
      this.field06964 = (AvatarRenderState)mc.getEntityRenderDispatcher().getRenderer(this).createRenderState(this, 0.0F);
      this.field06964.attackTime = var1.getAttackAnim(0.0F);
      this.field06964.isDiscrete = var1.isShiftKeyDown();
      this.field06964.fallFlyingTimeInTicks = var1.getFallFlyingTicks();
      this.field06962 = this.field06964.flyingYRot;
      this.field06960 = this.field06964.xRot;
      this.field06961 = this.field06964.fallFlyingScale();
      PlayerModel var2 = (PlayerModel)((LivingEntityRenderer)mc.getEntityRenderDispatcher().<AbstractClientPlayer>getRenderer(var1)).getModel();
      this.field06963 = new PlayerModel(mc.getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
      this.field06963.head.loadPose(var2.head.storePose());
      this.field06963.hat.loadPose(var2.hat.storePose());
      this.field06963.body.loadPose(var2.body.storePose());
      this.field06963.leftArm.loadPose(var2.leftArm.storePose());
      this.field06963.rightArm.loadPose(var2.rightArm.storePose());
      this.field06963.leftLeg.loadPose(var2.leftLeg.storePose());
      this.field06963.rightLeg.loadPose(var2.rightLeg.storePose());
      this.yBodyRot = var1.yBodyRot;
      this.yHeadRot = var1.yHeadRot;
      this.setShiftKeyDown(var1.isShiftKeyDown());
      this.setPose(var1.getPose());
   }

   @Override
   public boolean canBeCollidedWith(@Nullable Entity var1) {
      return false;
   }
}
