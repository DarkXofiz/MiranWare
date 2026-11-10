// Original binary: sg/ec/8a7hPNbK56CYKsdL
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public final class PearlTrajectoryAimer implements MinecraftAccess {
   private static final int field04616 = 160;
   private static final double field04617 = 0;
   private static final double field04618 = 0;
   private static final double field04619 = 0;
   private static final double field04620 = 0;
   private static final double field04621 = 0;
   private static final long field04622 = 0;
   private static final long field04623 = 0;
   private static final double field04624 = 0;
   private static final double field04625 = 0;
   private static final double field04626 = 0;
   private long field04627 = 0L;
   private ThrownEnderpearl field04628 = null;
   private Vec3 field04629 = null;
   private Entity field04630 = null;
   private long field04631 = 0L;
   private static final double field04632 = 5.0;
   private static final double field04633 = 6.0;
   private static final double field04634 = 3.75;
   private static final double field04635 = 4.5;
   private static final double field04636 = 60.0;
   private static final double field04637 = 3.0;
   private static final double field04638 = 2.25;
   private static final long field04639 = 70L;
   private static final double field04640 = Double.MAX_VALUE;
   private static final double field04641 = 130.0;
   private static final double field04642 = 120.0;
   private static final long field04643 = 10000L;
   private static final double field04644 = 0.03;
   private static final double field04645 = 0.99;
   private static final double field04646 = 0.03;
   private static final double field04647 = 0.99;
   private static final double field04648 = 5.0;
   private static final float field04649 = 89.0F;
   private static final float field04650 = 85.0F;
   private static final float field04651 = -80.0F;
   private static final double field04652 = 60.0;
   private static final float field04653 = -50.0F;
   private static final float field04654 = -30.0F;
   private static final float field04655 = 0.3F;
   private static final double field04656 = 60.0;
   private static final float field04657 = 0.5F;
   private static final float field04658 = 0.42F;
   private static final double field04659 = 4.0;
   private static final double field04660 = 2.0;
   private static final double field04661 = Double.MAX_VALUE;
   private static final double field04662 = Double.MAX_VALUE;
   private static final double field04663 = Double.MAX_VALUE;
   private static final double field04664 = 5.0;
   private static final double field04665 = 60.0;
   private static final float field04666 = 89.0F;
   private static final float field04667 = 85.0F;
   private static final float field04668 = -85.0F;
   private static final float field04669 = -70.0F;
   private static final float field04670 = -50.0F;
   private static final float field04671 = 1.2F;
   private static final float field04672 = 1.5F;
   private static final float field04673 = 40.0F;
   private static final float field04674 = 30.0F;
   private static final float field04675 = 20.0F;
   private static final float field04676 = 3.0F;
   private static final float field04677 = 2.5F;
   private static final double field04678 = 4.5;
   private static final double field04679 = 3.0;
   private static final double field04680 = 2.25;
   private static final float field04681 = 89.0F;
   private static final float field04682 = 75.0F;
   private static final float field04683 = 1.5F;
   private static final double field04684 = 1.5;
   private static final float field04685 = 70.0F;
   private static final double field04686 = 6.0;
   private static final double field04687 = 3.75;
   private static final double field04688 = 0.1;
   private static final double field04689 = 1.5;
   private static final double field04690 = 1.5;
   private static final double field04691 = 1.5;
   private static final float field04692 = 90.0F;
   private static final float field04693 = -90.0F;
   private static final float field04694 = 90.0F;

   private Vec3 method01916(float var1, float var2) {
      Vec3 var3 = this.method01918(this.method01922(), this.method01930(var1, var2));
      return var3 != null && !PearlTarget.method07359(var3) ? var3 : null;
   }

   private boolean method01917(Vec3 var1, Vec3 var2) {
      return this.method01926(var1, var2).getType() == Type.BLOCK;
   }

   private Vec3 method01918(Vec3 var1, Vec3 var2) {
      double var3 = mc.level.getMinY();

      for (int var5 = 0; var5 < 160; var5++) {
         var2 = var2.subtract(0.0, field04644, 0.0).scale(field04645);
         Vec3 var6 = var1.add(var2);
         BlockHitResult var7 = this.method01926(var1, var6);
         if (var7.getType() == Type.BLOCK) {
            return var7.getLocation();
         }

         if (var6.y <= var3) {
            return new Vec3(var6.x, var3, var6.z);
         }

         var1 = var6;
      }

      return null;
   }

   private float[] method01919(Vec3 var1, float var2, float var3, float var4, float var5, double var6) {
      float var8 = var3;

      while (var8 >= var4) {
         Vec3 var9 = this.method01916(var2, var8);
         if (var9 != null && var1.distanceTo(var9) <= var6) {
            return new float[]{var2, method01923(var8)};
         }

         var8 -= var5;
      }

      return null;
   }

   private void method01920(double var1, boolean var3) {
      long var4 = System.currentTimeMillis();
      if (var4 - this.field04627 >= field04639) {
         this.field04627 = var4;
         this.field04629 = null;
         this.field04628 = this.method01932(var1, var3);
         if (this.field04628 != null && this.field04628.isAlive()) {
            Vec3 var6 = this.method01937(this.field04628);
            if (var6 != null && !this.method01935(var6)) {
               this.field04629 = var6;
            }
         }
      }
   }

   private boolean method01921(BlockPos var1) {
      return mc.level.getBlockState(var1).getCollisionShape(mc.level, var1).isEmpty();
   }

   private Vec3 method01922() {
      return new Vec3(mc.player.getX(), mc.player.getEyeY() - field04688, mc.player.getZ());
   }

   private static float method01923(float var0) {
      return Mth.clamp(var0, field04693, field04694);
   }

   private double method01924() {
      Vec3 var1 = mc.player.getEyePosition(1.0F);
      double var2 = var1.distanceTo(this.field04629);
      boolean var4 = this.field04629.y - var1.y > field04632;
      if (this.method01917(var1, this.field04629)) {
         return var4 ? field04633 : field04634;
      } else if (var4) {
         return field04635;
      } else {
         return var2 > field04636 ? field04637 : field04638;
      }
   }

   private Entity method01925() {
      long var1 = System.currentTimeMillis();
      LivingEntity var3 = AttackAura.method00456();
      if (var3 != null && var3.isAlive()) {
         this.field04630 = var3;
         this.field04631 = var1;
         return var3;
      }

      if (this.field04630 == null) {
         return null;
      }

      if (this.field04630.isAlive() && !this.field04630.isRemoved() && var1 - this.field04631 < field04643) {
         return this.field04630;
      }

      this.field04630 = null;
      this.field04631 = 0L;
      return null;
   }

   private BlockHitResult method01926(Vec3 var1, Vec3 var2) {
      return mc.level.clip(new ClipContext(var1, var2, Block.COLLIDER, Fluid.NONE, mc.player));
   }

   public PearlTrajectoryAimer.Nested52 method01927(double var1, boolean var3) {
      this.method01920(var1, var3);
      if (this.field04629 == null) {
         return null;
      }

      float[] var4 = this.method01931(this.field04629);
      if (var4 == null) {
         var4 = this.method01933(this.field04629);
         if (var4 == null) {
            return null;
         }
      }

      Vec3 var5 = this.method01916(var4[0], var4[1]);
      if (var5 != null && var5.distanceTo(this.field04629) > this.method01924()) {
         var4 = this.method01933(this.field04629);
         if (var4 == null) {
            return null;
         }
      }

      return new PearlTrajectoryAimer.Nested52(var4[0], var4[1]);
   }

   private float[] method01928(Vec3 var1, float var2, float var3, float var4, float var5, float var6, float var7, double var8) {
      float var10 = var5;

      while (var10 >= var6) {
         float var11 = -var3;

         while (var11 <= var3) {
            float var12 = var2 + var11;
            Vec3 var13 = this.method01916(var12, var10);
            if (var13 != null && var1.distanceTo(var13) <= var8) {
               return new float[]{var12, method01923(var10)};
            }

            var11 += var4;
         }

         var10 -= var7;
      }

      return null;
   }

   private double[] method01929(float var1, float var2, Vec3 var3) {
      Vec3 var4 = this.method01922();
      Vec3 var5 = this.method01930(var1, var2);
      double var6 = mc.level.getMinY();

      for (int var8 = 0; var8 < 160; var8++) {
         var5 = var5.subtract(0.0, field04646, 0.0).scale(field04647);
         Vec3 var9 = var4.add(var5);
         BlockHitResult var10 = this.method01926(var4, var9);
         Vec3 var11 = null;
         if (var10.getType() == Type.BLOCK) {
            var11 = var10.getLocation();
         } else if (var9.y <= var6) {
            var11 = new Vec3(var9.x, var6, var9.z);
         }

         if (var11 != null) {
            if (PearlTarget.method07359(var11)) {
               return null;
            }

            return new double[]{var11.distanceTo(var3), var8 + 1};
         }

         var4 = var9;
      }

      return null;
   }

   private Vec3 method01930(float var1, float var2) {
      double var3 = Math.toRadians(var1);
      double var5 = Math.toRadians(var2);
      double var7 = Math.cos(var5);
      return new Vec3(-Math.sin(var3) * var7 * field04689, -Math.sin(var5) * field04690 + mc.player.getDeltaMovement().y, Math.cos(var3) * var7 * field04691);
   }

   private float[] method01931(Vec3 var1) {
      Vec3 var2 = mc.player.getEyePosition(1.0F);
      float var3 = method01936(var2, var1);
      double var4 = var2.distanceTo(var1);
      boolean var6 = var1.y - var2.y > field04648;
      float var7 = var6 ? field04649 : field04650;
      float var8 = var6 ? field04651 : (var4 > field04652 ? field04653 : field04654);
      float var9 = var6 ? field04655 : (var4 > field04656 ? field04657 : field04658);
      double var10 = var6 ? field04659 : field04660;
      float var12 = 0.0F;
      double var13 = field04661;
      double var15 = field04662;

      for (float var17 = var7; var17 >= var8; var17 -= var9) {
         double[] var18 = this.method01929(var3, var17, var1);
         if (var18 != null && !(var18[0] > var10)) {
            boolean var19 = var18[1] < var13 || var18[1] == var13 && var18[0] < var15;
            if (var19) {
               var13 = var18[1];
               var12 = var17;
               var15 = var18[0];
            }
         }
      }

      return var13 == field04663 ? null : new float[]{var3, method01923(var12)};
   }

   private ThrownEnderpearl method01932(double var1, boolean var3) {
      Entity var4 = var3 ? this.method01925() : null;
      Vec3 var5 = mc.player.position();
      ThrownEnderpearl var6 = null;
      double var7 = field04640;

      for (Entity var10 : mc.level.getEntities(mc.player, mc.player.getBoundingBox().inflate(field04641))) {
         if (var10 instanceof ThrownEnderpearl var11 && var11.isAlive()) {
            Entity var12 = var11.getOwner();
            if ((!var3 || var4 != null && var12 != null && var12.getId() == var4.getId())
               && !(var12 instanceof Player var13 && FriendManager.INSTANCE.method00172(var13))) {
               Vec3 var16 = this.method01937(var11);
               if (var16 != null) {
                  double var14 = var5.distanceTo(var16);
                  if (!(var14 < var1) && !(var14 > field04642) && !(var14 >= var7)) {
                     var6 = var11;
                     var7 = var14;
                  }
               }
            }
         }
      }

      return var6;
   }

   private float[] method01933(Vec3 var1) {
      Vec3 var2 = mc.player.getEyePosition(1.0F);
      float var3 = method01936(var2, var1);
      double var4 = var2.distanceTo(var1);
      boolean var6 = var1.y - var2.y > field04664;
      boolean var7 = var4 > field04665;
      float var8 = var6 ? field04666 : field04667;
      float var9 = var6 ? field04668 : (var7 ? field04669 : field04670);
      float var10 = var6 ? 1.0F : (var7 ? field04671 : field04672);
      float var11 = var6 ? field04673 : (var7 ? field04674 : field04675);
      float var12 = var6 ? 2.0F : (var7 ? field04676 : field04677);
      double var13 = var6 ? field04678 : (var7 ? field04679 : field04680);
      float[] var15 = this.method01919(var1, var3, var8, var9, var10, var13);
      if (var15 != null) {
         return var15;
      }

      for (float var16 = -var11; var16 <= var11; var16 += var12) {
         if (var16 != 0.0F) {
            float[] var17 = this.method01919(var1, var3 + var16, var8, var9, var10, var13);
            if (var17 != null) {
               return var17;
            }
         }
      }

      if (var6) {
         float[] var18 = this.method01928(var1, var3, var11, var12, field04681, field04682, field04683, var13 * field04684);
         if (var18 != null) {
            return var18;
         }
      }

      return this.method01928(var1, var3, var11, var12 * 2.0F, var8, field04685, 2.0F, var6 ? field04686 : field04687);
   }

   public void method01934() {
      this.method01938();
      this.field04630 = null;
      this.field04631 = 0L;
   }

   private boolean method01935(Vec3 var1) {
      BlockPos var2 = BlockPos.containing(var1);
      return this.method01921(var2.below()) && this.method01921(var2.below(2));
   }

   private static float method01936(Vec3 var0, Vec3 var1) {
      return (float)Math.toDegrees(Math.atan2(var1.z - var0.z, var1.x - var0.x)) - field04692;
   }

   private Vec3 method01937(ThrownEnderpearl var1) {
      return this.method01918(var1.position(), var1.getDeltaMovement());
   }

   public void method01938() {
      this.field04627 = 0L;
      this.field04628 = null;
      this.field04629 = null;
   }

   // $VF: Compiled from s
   public record Nested52(float yaw, float pitch) {
   }
}
