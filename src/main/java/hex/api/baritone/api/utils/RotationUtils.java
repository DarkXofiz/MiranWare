// Original binary: hex/api/baritone/api/utils/RotationUtils
package hex.api.baritone.api.utils;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import java.util.Optional;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public final class RotationUtils {
   public static final double DEG_TO_RAD = Math.PI / 180.0;
   public static final float DEG_TO_RAD_F = (float) (Math.PI / 180.0);
   public static final double RAD_TO_DEG = 180.0 / Math.PI;
   public static final float RAD_TO_DEG_F = (float) (180.0 / Math.PI);
   private static final Vec3[] BLOCK_SIDE_MULTIPLIERS = new Vec3[]{
      new Vec3(RotationUtils.бГр, 0.0, RotationUtils.бГй),
      new Vec3(RotationUtils.бГк, 1.0, RotationUtils.бГп),
      new Vec3(RotationUtils.бГ2, RotationUtils.бГ西, 0.0),
      new Vec3(RotationUtils.бГт, RotationUtils.бГд, 1.0),
      new Vec3(0.0, RotationUtils.бГе, RotationUtils.бГ6),
      new Vec3(1.0, RotationUtils.бГl, RotationUtils.бГ必)
   };
   private static final double бГы = 0;
   private static final double бГу = 0;
   private static final float бГг = 0;
   private static final float бГю = 0;
   private static final float бГ4 = 0;
   private static final float бГС = 0;
   private static final float бГъ = 0;
   private static final float бГБ = 0;
   private static final float бГв = 0;
   private static final double бГр = 0;
   private static final double бГй = 0;
   private static final double бГк = 0;
   private static final double бГп = 0;
   private static final double бГ2 = 0;
   private static final double бГ西 = 0;
   private static final double бГт = 0;
   private static final double бГд = 0;
   private static final double бГе = 0;
   private static final double бГ6 = 0;
   private static final double бГl = 0;
   private static final double бГ必 = 0;

   @Deprecated
   public static Optional<Rotation> reachableOffset(Entity var0, BlockPos var1, Vec3 var2, double var3, boolean var5) {
      Vec3 var6 = var5 ? RayTraceUtils.inferSneakingEyePosition(var0) : var0.getEyePosition(1.0F);
      Rotation sx = calcRotationFromVec3d(var6, var2, new Rotation(var0.getYRot(), var0.getXRot()));
      HitResult sxx = RayTraceUtils.rayTraceTowards(var0, sx, var3, var5);
      if (sxx != null && sxx.getType() == Type.BLOCK) {
         if (((BlockHitResult)sxx).getBlockPos().equals(var1)) {
            return Optional.of(sx);
         }

         if (var0.level().getBlockState(var1).getBlock() instanceof BaseFireBlock && ((BlockHitResult)sxx).getBlockPos().equals(var1.below())) {
            return Optional.of(sx);
         }
      }

      return Optional.empty();
   }

   public static Optional<Rotation> reachableCenter(IPlayerContext var0, BlockPos var1, double var2, boolean var4) {
      return reachableOffset(var0, var1, VecUtils.calculateBlockCenter(var0.world(), var1), var2, var4);
   }

   public static Optional<Rotation> reachable(IPlayerContext var0, BlockPos var1, boolean var2) {
      return reachable(var0, var1, var0.playerController().getBlockReachDistance(), var2);
   }

   @Deprecated
   public static Vec3 calcVec3dFromRotation(Rotation var0) {
      return calcLookDirectionFromRotation(var0);
   }

   public static Rotation calcRotationFromCoords(BlockPos var0, BlockPos var1) {
      return calcRotationFromVec3d(new Vec3(var0.getX(), var0.getY(), var0.getZ()), new Vec3(var1.getX(), var1.getY(), var1.getZ()));
   }

   public static Rotation calcRotationFromVec3d(Vec3 var0, Vec3 var1, Rotation var2) {
      return wrapAnglesToRelative(var2, calcRotationFromVec3d(var0, var1));
   }

   public static Optional<Rotation> reachableOffset(IPlayerContext var0, BlockPos var1, Vec3 var2, double var3, boolean var5) {
      Vec3 var6 = var5 ? RayTraceUtils.inferSneakingEyePosition(var0.player()) : var0.player().getEyePosition(1.0F);
      Rotation sx = calcRotationFromVec3d(var6, var2, var0.playerRotations());
      Rotation sxx = BaritoneAPI.getProvider().getBaritoneForPlayer(var0.player()).getLookBehavior().getAimProcessor().peekRotation(sx);
      HitResult sxxx = RayTraceUtils.rayTraceTowards(var0.player(), sxx, var3, var5);
      if (sxxx != null && sxxx.getType() == Type.BLOCK) {
         if (((BlockHitResult)sxxx).getBlockPos().equals(var1)) {
            return Optional.of(sx);
         }

         if (var0.world().getBlockState(var1).getBlock() instanceof BaseFireBlock && ((BlockHitResult)sxxx).getBlockPos().equals(var1.below())) {
            return Optional.of(sx);
         }
      }

      return Optional.empty();
   }

   public static Optional<Rotation> reachable(IPlayerContext var0, BlockPos var1, double var2) {
      return reachable(var0, var1, var2, false);
   }

   @Deprecated
   public static Optional<Rotation> reachable(LocalPlayer var0, BlockPos var1, double var2, boolean var4) {
      IBaritone var5 = BaritoneAPI.getProvider().getBaritoneForPlayer(var0);
      IPlayerContext sx = var5.getPlayerContext();
      return reachable(sx, var1, var2, var4);
   }

   @Deprecated
   public static Optional<Rotation> reachableCenter(Entity var0, BlockPos var1, double var2, boolean var4) {
      return reachableOffset(var0, var1, VecUtils.calculateBlockCenter(var0.level(), var1), var2, var4);
   }

   public static Vec3 calcLookDirectionFromRotation(Rotation var0) {
      float var1 = Mth.cos(-var0.getYaw() * бГг - бГю);
      float sx = Mth.sin(-var0.getYaw() * бГ4 - бГС);
      float sxx = -Mth.cos(-var0.getPitch() * бГъ);
      float sxxx = Mth.sin(-var0.getPitch() * бГБ);
      return new Vec3(sx * sxx, sxxx, var1 * sxx);
   }

   public static Optional<Rotation> reachable(IPlayerContext var0, BlockPos var1, double var2, boolean var4) {
      if (var1 instanceof BetterBlockPos) {
         var1 = new BlockPos(var1.getX(), var1.getY(), var1.getZ());
      }

      if (BaritoneAPI.getSettings().remainWithExistingLookDirection.value && var0.isLookingAt(var1)) {
         Rotation var5 = var0.playerRotations().add(new Rotation(0.0F, бГв));
         if (!var4) {
            return Optional.of(var5);
         }

         HitResult sx = RayTraceUtils.rayTraceTowards(var0.player(), var5, var2, true);
         if (sx != null && sx.getType() == Type.BLOCK && ((BlockHitResult)sx).getBlockPos().equals(var1)) {
            return Optional.of(var5);
         }
      }

      var var18 = reachableCenter(var0, var1, var2, var4);
      if (var18.isPresent()) {
         return var18;
      }

      BlockState sx = var0.world().getBlockState(var1);
      VoxelShape sxx = sx.getShape(var0.world(), var1);
      if (sxx.isEmpty()) {
         sxx = Shapes.block();
      }

      for (Vec3 sxxx : BLOCK_SIDE_MULTIPLIERS) {
         double sxxxx = sxx.min(Axis.X) * sxxx.x + sxx.max(Axis.X) * (1.0 - sxxx.x);
         double sxxxxx = sxx.min(Axis.Y) * sxxx.y + sxx.max(Axis.Y) * (1.0 - sxxx.y);
         double sxxxxxx = sxx.min(Axis.Z) * sxxx.z + sxx.max(Axis.Z) * (1.0 - sxxx.z);
         var18 = reachableOffset(var0, var1, new Vec3(var1.getX(), var1.getY(), var1.getZ()).add(sxxxx, sxxxxx, sxxxxxx), var2, var4);
         if (var18.isPresent()) {
            return var18;
         }
      }

      return Optional.empty();
   }

   @Deprecated
   public static Optional<Rotation> reachable(LocalPlayer var0, BlockPos var1, double var2) {
      return reachable(var0, var1, var2, false);
   }

   public static Rotation wrapAnglesToRelative(Rotation var0, Rotation var1) {
      return var0.yawIsReallyClose(var1) ? new Rotation(var0.getYaw(), var1.getPitch()) : var1.subtract(var0).normalize().add(var0);
   }

   private static Rotation calcRotationFromVec3d(Vec3 var0, Vec3 var1) {
      double[] var2 = new double[]{var0.x - var1.x, var0.y - var1.y, var0.z - var1.z};
      double sx = Mth.atan2(var2[0], -var2[2]);
      double sxx = Math.sqrt(var2[0] * var2[0] + var2[2] * var2[2]);
      double sxxx = Mth.atan2(var2[1], sxx);
      return new Rotation((float)(sx * бГы), (float)(sxxx * бГу));
   }


   private RotationUtils() {
   }

   public static Optional<Rotation> reachable(IPlayerContext var0, BlockPos var1) {
      return reachable(var0, var1, false);
   }
}
