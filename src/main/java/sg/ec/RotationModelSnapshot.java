// Original binary: sg/ec/tEPUb33I8e94DoXK
package sg.ec;

import java.util.Optional;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public record RotationModelSnapshot(
   long sessionId,
   float currentYaw,
   float currentPitch,
   float targetYaw,
   float targetPitch,
   float deltaYaw,
   float deltaPitch,
   float distance,
   float playerVelX,
   float playerVelY,
   float playerVelZ,
   float targetVelX,
   float targetVelY,
   float targetVelZ,
   float cooldown,
   boolean onGround,
   boolean inAir,
   boolean isGliding,
   boolean rayTrace,
   boolean isSprinting,
   boolean usingItem,
   boolean jumping,
   boolean targetInAir,
   float targetHealth,
   float targetMaxHealth,
   float targetArmor,
   float targetHurtTime,
   float fallDistance,
   double playerX,
   double playerY,
   double playerZ,
   double targetX,
   double targetY,
   double targetZ,
   double aimPointX,
   double aimPointY,
   double aimPointZ,
   float hitboxOffsetX,
   float hitboxOffsetY,
   float hitboxOffsetZ,
   boolean aimHit,
   int sampleTick
) implements MinecraftAccess {
   public static RotationModelSnapshot from(long var0, AuraRotationController.Nested160 var2) {
      AttackAura var3 = var2.aura();
      LivingEntity var4 = var2.target();
      Vec3 var5 = mc.player.getDeltaMovement();
      Vec3 var6 = var4.getDeltaMovement();
      Vec3 var7 = mc.player.position();
      Vec3 var8 = var4.position();
      RotationModelSnapshot.Nested314 var9 = resolveAimPoint(var3, var2);
      float var10 = mc.player.getAttackStrengthScale(1.5F);
      return new RotationModelSnapshot(
         var0,
         Mth.wrapDegrees(mc.player.getYRot()),
         mc.player.getXRot(),
         Mth.wrapDegrees(var2.rawYaw()),
         var2.rawPitch(),
         var2.yawDelta(),
         var2.pitchDelta(),
         (float)Mth.clamp(var3.field00813, 0.0, 128.0),
         (float)var5.x,
         (float)var5.y,
         (float)var5.z,
         (float)var6.x,
         (float)var6.y,
         (float)var6.z,
         Mth.clamp(var10, 0.0F, 1.0F),
         mc.player.onGround(),
         !mc.player.onGround(),
         mc.player.isFallFlying(),
         var2.rayTrace(),
         mc.player.isSprinting(),
         mc.player.isUsingItem(),
         mc.options.keyJump.isDown(),
         !var4.onGround(),
         var4.getHealth(),
         var4.getMaxHealth(),
         var4.getArmorValue(),
         var4.hurtTime,
         (float)mc.player.fallDistance,
         var7.x,
         var7.y,
         var7.z,
         var8.x,
         var8.y,
         var8.z,
         var9.point().x,
         var9.point().y,
         var9.point().z,
         var9.offsetX(),
         var9.offsetY(),
         var9.offsetZ(),
         var9.hit(),
         mc.player.tickCount
      );
   }

   private static RotationModelSnapshot.Nested314 resolveAimPoint(AttackAura var0, AuraRotationController.Nested160 var1) {
      Vec3 var2 = mc.player.getEyePosition();
      double var3 = Math.max(1.0, Math.min(12.0, var0.field00813 + 2.0));
      Vec3 var5 = var2.add(mc.player.getViewVector(1.0F).scale(var3));
      return aimPointFrom(var1.targetBox(), var2, var5);
   }

   private static float normalizePitch(float var0) {
      return Mth.clamp(var0 / 90.0F, -1.0F, 1.0F);
   }

   private static float normalizeVelocity(float var0, float var1) {
      return Mth.clamp(var0 / var1, -2.0F, 2.0F);
   }

   public static RotationModelSnapshot fallbackReset(
      Player var0,
      float var1,
      float var2,
      float var3,
      float var4,
      Vec3 var5,
      Vec3 var6,
      float var7,
      boolean var8,
      boolean var9,
      boolean var10,
      boolean var11,
      boolean var12,
      float var13,
      int var14
   ) {
      double var15 = Math.toRadians(var3);
      double var17 = Math.toRadians(var4);
      double var19 = Math.cos(var17);
      Vec3 var21 = new Vec3(-Math.sin(var15) * var19, -Math.sin(var17), Math.cos(var15) * var19);
      Vec3 var22 = var5.add(var21);
      AABB var23 = new AABB(var22.x - 0.3, var22.y, var22.z - 0.3, var22.x + 0.3, var22.y + 1.8, var22.z + 0.3);
      Vec3 var24 = var0.getEyePosition();
      Vec3 var25 = var24.add(var0.getViewVector(1.0F).scale(3.0));
      RotationModelSnapshot.Nested314 var26 = aimPointFrom(var23, var24, var25);
      float var27 = Mth.wrapDegrees(var3 - var1);
      float var28 = var4 - var2;
      return new RotationModelSnapshot(
         0L,
         Mth.wrapDegrees(var1),
         var2,
         Mth.wrapDegrees(var3),
         var4,
         var27,
         var28,
         1.0F,
         (float)var6.x,
         (float)var6.y,
         (float)var6.z,
         0.0F,
         0.0F,
         0.0F,
         Mth.clamp(var7, 0.0F, 1.0F),
         var8,
         !var8,
         var9,
         false,
         var10,
         var11,
         var12,
         false,
         20.0F,
         20.0F,
         0.0F,
         0.0F,
         var13,
         var5.x,
         var5.y,
         var5.z,
         var22.x,
         var22.y,
         var22.z,
         var26.point().x,
         var26.point().y,
         var26.point().z,
         var26.offsetX(),
         var26.offsetY(),
         var26.offsetZ(),
         var26.hit(),
         var14
      );
   }

   public float[] toFeatureVector() {
      float var1 = (float)Math.sqrt(this.playerVelX * this.playerVelX + this.playerVelZ * this.playerVelZ);
      float var2 = (float)Math.sqrt(this.targetVelX * this.targetVelX + this.targetVelZ * this.targetVelZ);
      float var3 = (float)(this.targetX - this.playerX);
      float var4 = (float)(this.targetY - this.playerY);
      float var5 = (float)(this.targetZ - this.playerZ);
      float var6 = (float)Math.sqrt(var3 * var3 + var5 * var5);
      float var7 = var6 > 1.0E-4F ? 1.0F / var6 : 0.0F;
      float var8 = var3 * var7;
      float var9 = var5 * var7;
      float var10 = this.playerVelX - this.targetVelX;
      float var11 = this.playerVelZ - this.targetVelZ;
      float var12 = var10 * var8 + var11 * var9;
      float var13 = this.playerVelZ * var8 - this.playerVelX * var9;
      float var14 = this.targetVelZ * var8 - this.targetVelX * var9;
      float var15 = var11 * var8 - var10 * var9;
      float var16 = Math.max(0.0F, var12) * Math.max(0.0F, 1.0F - var6 / 3.0F);
      float var17 = Math.max(0.0F, 1.0F - var6 / 1.5F);
      float var18 = Math.max(0.0F, 1.0F - var6 / 0.85F);
      float var19 = Math.max(0.0F, 1.0F - var6 / 0.25F);
      float var20 = Mth.clamp(this.targetHealth / Math.max(this.targetMaxHealth, 1.0F), 0.0F, 1.0F);
      float var21 = Mth.wrapDegrees(this.deltaYaw);
      return new float[]{
         normalizeYaw(this.currentYaw),
         normalizePitch(this.currentPitch),
         RotationModelFeatures.method01549(var21),
         RotationModelFeatures.method01551(this.deltaPitch),
         RotationModelFeatures.method01549(Math.abs(var21)),
         RotationModelFeatures.method01551(Math.abs(this.deltaPitch)),
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         Mth.clamp(this.distance / 8.0F, 0.0F, 2.0F),
         normalizeVelocity(this.playerVelX, 1.5F),
         normalizeVelocity(this.playerVelY, 1.5F),
         normalizeVelocity(this.playerVelZ, 1.5F),
         Mth.clamp(var1 / 1.5F, 0.0F, 2.0F),
         normalizeVelocity(this.targetVelX, 1.5F),
         normalizeVelocity(this.targetVelY, 1.5F),
         normalizeVelocity(this.targetVelZ, 1.5F),
         Mth.clamp(var2 / 1.5F, 0.0F, 2.0F),
         Mth.clamp(this.cooldown, 0.0F, 1.0F),
         this.onGround ? 1.0F : 0.0F,
         this.inAir ? 1.0F : 0.0F,
         this.isGliding ? 1.0F : 0.0F,
         this.rayTrace ? 1.0F : 0.0F,
         this.isSprinting ? 1.0F : 0.0F,
         this.usingItem ? 1.0F : 0.0F,
         this.jumping ? 1.0F : 0.0F,
         this.targetInAir ? 1.0F : 0.0F,
         var20,
         Mth.clamp(this.targetArmor / 20.0F, 0.0F, 1.0F),
         Mth.clamp(this.targetHurtTime / 10.0F, 0.0F, 1.0F),
         Mth.clamp(this.fallDistance / 4.0F, 0.0F, 1.5F),
         Mth.clamp(var3 / 8.0F, -2.0F, 2.0F),
         Mth.clamp(var4 / 4.0F, -2.0F, 2.0F),
         Mth.clamp(var5 / 8.0F, -2.0F, 2.0F),
         Mth.clamp(var6 / 8.0F, 0.0F, 2.0F),
         normalizeVelocity(var12, 1.5F),
         normalizeVelocity(var13, 1.5F),
         normalizeVelocity(var14, 1.5F),
         normalizeVelocity(var15, 1.5F),
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         Mth.clamp(var16 / 1.5F, 0.0F, 2.0F),
         Mth.clamp(Math.abs(var15) / 1.5F, 0.0F, 2.0F),
         Mth.clamp(var3 / 1.5F, -2.0F, 2.0F),
         Mth.clamp(var4 / 1.5F, -2.0F, 2.0F),
         Mth.clamp(var5 / 1.5F, -2.0F, 2.0F),
         Mth.clamp(var6 / 1.5F, 0.0F, 2.0F),
         Mth.clamp(var17, 0.0F, 1.0F),
         Mth.clamp(var18, 0.0F, 1.0F),
         normalizeVelocity(var12, 0.6F),
         normalizeVelocity(var15, 0.6F),
         Mth.clamp(var8, -1.0F, 1.0F),
         Mth.clamp(var9, -1.0F, 1.0F),
         var6 <= 1.5F ? 1.0F : 0.0F,
         Mth.clamp(var19, 0.0F, 1.0F),
         normalizeYaw(this.targetYaw),
         normalizePitch(this.targetPitch),
         0.0F,
         0.0F,
         this.aimHit ? 1.0F : 0.0F,
         Mth.clamp(this.hitboxOffsetX, -1.0F, 1.0F),
         Mth.clamp(this.hitboxOffsetY, -1.0F, 1.0F),
         Mth.clamp(this.hitboxOffsetZ, -1.0F, 1.0F),
         normalizeWrappedYawDelta(this.currentYaw - this.targetYaw),
         RotationModelFeatures.method01551(this.currentPitch - this.targetPitch)
      };
   }

   private static float normalizeWrappedYawDelta(float var0) {
      return RotationModelFeatures.method01549(Mth.wrapDegrees(var0));
   }

   private static RotationModelSnapshot.Nested314 aimPointFrom(AABB var0, Vec3 var1, Vec3 var2) {
      var var3 = var0.clip(var1, var2);
      Vec3 var4 = var3.orElse(var2);
      Vec3 var5 = var0.getCenter();
      double var6 = Math.max(1.0E-4, var0.getXsize() * 0.5);
      double var8 = Math.max(1.0E-4, var0.getYsize() * 0.5);
      double var10 = Math.max(1.0E-4, var0.getZsize() * 0.5);
      return new RotationModelSnapshot.Nested314(
         var4,
         (float)Mth.clamp((var4.x - var5.x) / var6, -1.0, 1.0),
         (float)Mth.clamp((var4.y - var5.y) / var8, -1.0, 1.0),
         (float)Mth.clamp((var4.z - var5.z) / var10, -1.0, 1.0),
         var3.isPresent()
      );
   }

   private static float normalizeYaw(float var0) {
      return Mth.wrapDegrees(var0) / 180.0F;
   }

   // $VF: Compiled from s
   private record Nested314(Vec3 point, float offsetX, float offsetY, float offsetZ, boolean hit) {
   }
}
