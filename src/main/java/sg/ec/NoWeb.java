// Original binary: sg/ec/1K24lDxUtGPP1IFU
package sg.ec;

import net.minecraft.client.multiplayer.prediction.BlockStatePredictionHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sg.mx.ClientLevelMixin_1241;
import sg.mx.EntityMixin_1159;

// $VF: Compiled from s
public class NoWeb extends ClientModule {
   private static final Logger field00558 = LoggerFactory.getLogger(NoWeb.field00597);
   private static final String field00559 = "1.17.1";
   private static final String field00560 = "field00560";
   private static final String field00561 = "field00561";
   private static final String field00562 = "field00562";
   private static final String field00563 = "field00563";
   private static final NoWeb.Nested12 field00564 = new NoWeb.Nested12(
      NoWeb.field00598,
      NoWeb.field00599,
      NoWeb.field00600,
      NoWeb.field00601,
      NoWeb.field00602,
      NoWeb.field00603,
      NoWeb.field00604
   );
   private static final NoWeb.Nested12 field00565 = new NoWeb.Nested12(
      NoWeb.field00605,
      NoWeb.field00606,
      NoWeb.field00607,
      NoWeb.field00608,
      NoWeb.field00609,
      NoWeb.field00610,
      NoWeb.field00611
   );
   private static final NoWeb.Nested11 field00566 = new NoWeb.Nested11(
      NoWeb.field00612, NoWeb.field00613, NoWeb.field00614, NoWeb.field00615
   );
   private static final Vec3 field00567 = new Vec3(NoWeb.field00616, NoWeb.field00617, NoWeb.field00618);
   private static final double field00568 = 0;
   private static final double field00569 = 0;
   private static final double field00570 = 0;
   private static final double field00571 = 0;
   private final ModeSetting field00572;
   private boolean field00573;
   private boolean field00574;
   private boolean field00575;
   private Vec3 field00576;
   private boolean field00577;
   private boolean field00578;
   private static final String field00579 = "Мод";
   private static final String field00580 = "1.21.11";
   private static final String field00581 = "GrimCollision";
   private static final String field00582 = "NoCollision";
   private static final String field00583 = "1.18.2";
   private static final String field00584 = "1.17.1";
   private static final String field00585 = "1.21.11";
   private static final String field00586 = "No Web";
   private static final String field00587 = "GrimCollision";
   private static final String field00588 = "1.21.11";
   private static final String field00589 = "GrimCollision";
   private static final String field00590 = "NoCollision";
   private static final String field00591 = "1.21.11";
   private static final String field00592 = "1.17.1";
   private static final double field00593 = 0.015;
   private static final double field00594 = 0.001;
   private static final double field00595 = 0.6;
   private static final double field00596 = 0.001;
   private static final String field00597 = "MiranWare";
   private static final double field00598 = 0.078;
   private static final double field00599 = 0.058;
   private static final double field00600 = 0.056;
   private static final double field00601 = 0.046;
   private static final double field00602 = 0.054;
   private static final double field00603 = 0.0499;
   private static final double field00604 = 0.072;
   private static final double field00605 = 0.115;
   private static final double field00606 = 0.1;
   private static final double field00607 = 0.068;
   private static final double field00608 = 0.058;
   private static final double field00609 = 0.064;
   private static final double field00610 = 0.068;
   private static final double field00611 = 0.085;
   private static final double field00612 = 0.15;
   private static final double field00613 = 0.0599;
   private static final double field00614 = 0.1599;
   private static final double field00615 = 0.0108;
   private static final double field00616 = 0.25;
   private static final double field00617 = 0.05F;
   private static final double field00618 = 0.25;

   private NoWeb.Nested12 method00274() {
      return this.field00572.method05600(field00592) ? field00564 : field00565;
   }

   private boolean method00275() {
      return this.field00572.method05600(field00589) || this.field00572.method05600(field00590);
   }

   @Override
   public void method00276() {
      this.field00573 = false;
      this.field00574 = false;
      this.field00575 = false;
      super.method00276();
   }

   @Subscribe
   private void method00277(CobwebCollisionEvent var1) {
      if (this.method00275()) {
         if (this.field00572.method05600(field00587)) {
            this.method00288(var1.method11724().immutable());
         }

         var1.method05696();
      }
   }

   private double method00278(double var1, double[] var3, double var4) {
      if (!(var1 <= 0.0) && mc.player != null && mc.level != null) {
         AABB var6 = mc.player.getBoundingBox().move(var3[0] * var4, 0.0, var3[1] * var4);
         double var7 = this.method00286(var6, var1) - field00594 - var6.minY;
         if (var7 >= var1) {
            return var1;
         } else {
            return var7 >= -this.field00576.y ? var7 : Math.min(var1, this.field00576.y);
         }
      } else {
         return var1;
      }
   }

   private double method00279(NoWeb.Nested12 var1) {
      if (!this.field00574 && !this.method00282()) {
         return this.method00293() ? var1.airborneHorizontal() : var1.groundHorizontal();
      } else {
         return var1.descendHorizontal();
      }
   }

   private double method00280(AABB var1, double var2, double var4) {
      double var6 = var1.minY;
      double var8 = Double.NEGATIVE_INFINITY;
      MutableBlockPos var10 = new MutableBlockPos();
      int var11 = Mth.floor(var6 + field00595);

      for (int var12 = Mth.floor(var1.minX); var12 <= Mth.floor(var1.maxX); var12++) {
         for (int var13 = Mth.floor(var1.minZ); var13 <= Mth.floor(var1.maxZ); var13++) {
            for (int var14 = Mth.floor(var6); var14 <= var11; var14++) {
               var10.set(var12, var14, var13);
               VoxelShape var15 = mc.level.getBlockState(var10).getCollisionShape(mc.level, var10);
               if (!var15.isEmpty()) {
                  var8 = Math.max(var8, var14 + var15.max(Axis.Y));
               }
            }
         }
      }

      double var16 = var8 - var6 + field00596;
      if (!(var16 <= 0.0) && !(var16 > var2 + var4)) {
         var16 = Math.max(var16, var2);
         return mc.level.noCollision(mc.player, var1.move(0.0, var16, 0.0)) ? var16 : 0.0;
      } else {
         return 0.0;
      }
   }

   private AABB method00281(double[] var1, double var2) {
      if (var2 != 0.0 && (this.field00573 || this.field00574)) {
         if (mc.player != null && mc.level != null) {
            AABB var4 = mc.player.getBoundingBox().move(var1[0] * var2, 0.0, var1[1] * var2);
            return mc.level.noCollision(mc.player, var4) ? null : var4;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public NoWeb() {
      super(ModuleCategory.Movement, ModuleSubCategory.Other);
      this.field00572 = new ModeSetting(field00579)
         .method05597(field00580, field00581, field00582, field00583, field00584)
         .method03017(field00585)
         .method03023(this);
      this.field00576 = Vec3.ZERO;
      Object var10001 = null;
      this.method03935(field00586);
   }

   private boolean method00282() {
      return ModuleManager.INSTANCE.method08233().method08139();
   }

   private Vec3 method00283(NoWeb.Nested12 var1) {
      double[] var2 = MovementUtils.method05708();
      boolean var3 = var2[0] != 0.0 || var2[1] != 0.0;
      double var4 = var3 ? this.method00279(var1) : 0.0;
      AABB var6 = var3 ? this.method00281(var2, var4) : null;
      this.field00577 = !var3 || var6 != null;
      double var7 = this.field00577 ? var1.idleAscend() : var1.ascend();
      double var9 = this.field00577 ? var1.idleDescend() : var1.descend();
      double var11 = MovementUtils.method05724(this.field00573, this.field00574, var7, var9);
      double var13 = var6 != null && var11 > 0.0 && this.method00293() ? this.method00280(var6, var11, field00593) : 0.0;
      this.field00578 = var13 > 0.0;
      if (this.field00578) {
         var11 = var13;
      } else if (this.field00577) {
         var4 = 0.0;
      }

      return new Vec3(var2[0] * var4, var11, var2[1] * var4);
   }

   private Direction method00284(BlockPos var1) {
      Vec3 var2 = mc.player.getEyePosition();
      if (var2.y >= var1.getY() + 1) {
         return Direction.UP;
      } else if (var2.y <= var1.getY()) {
         return Direction.DOWN;
      } else if (var2.x <= var1.getX()) {
         return Direction.WEST;
      } else if (var2.x >= var1.getX() + 1) {
         return Direction.EAST;
      } else {
         return var2.z <= var1.getZ() ? Direction.NORTH : Direction.SOUTH;
      }
   }

   private double method00285(double var1, double var3) {
      if (!(var1 >= var3) && mc.player != null && mc.level != null) {
         return mc.level.noCollision(mc.player, mc.player.getBoundingBox().move(0.0, var1, 0.0)) ? var1 : var3;
      } else {
         return var1;
      }
   }

   private double method00286(AABB var1, double var2) {
      double var4 = Double.NEGATIVE_INFINITY;
      MutableBlockPos var6 = new MutableBlockPos();
      int var7 = Mth.floor(var1.maxY + var2);

      for (int var8 = Mth.floor(var1.minX); var8 <= Mth.floor(var1.maxX); var8++) {
         for (int var9 = Mth.floor(var1.minZ); var9 <= Mth.floor(var1.maxZ); var9++) {
            for (int var10 = Mth.floor(var1.minY); var10 <= var7; var10++) {
               if (mc.level.getBlockState(var6.set(var8, var10, var9)).is(Blocks.COBWEB)) {
                  var4 = Math.max(var4, var10 + 1.0);
               }
            }
         }
      }

      return var4;
   }

   private void method00287(Action var1, BlockPos var2, Direction var3) {
      try (BlockStatePredictionHandler var4 = ((ClientLevelMixin_1241)(Object)mc.level).predictionHandler().startPredicting()) {
         mc.player.connection.send(new ServerboundPlayerActionPacket(var1, var2, var3, var4.currentSequence()));
      }
   }

   private void method00288(BlockPos var1) {
      Direction var2 = this.method00284(var1);
      this.method00287(Action.STOP_DESTROY_BLOCK, var1, var2);
   }

   @Subscribe(4)
   private void method00289(PlayerInputEvent var1) {
      if (!this.method00275()) {
         this.field00573 = var1.method11162();
         this.field00574 = var1.method11160();
         this.field00575 = mc.player != null && field00567.equals(((EntityMixin_1159)(Object)mc.player).getStuckSpeedMultiplier());
         if (this.field00575) {
            this.field00576 = mc.player.getDeltaMovement().multiply(field00567);
         }

         if (this.method00294()) {
            var1.method11169(false);
         }
      }
   }

   @Subscribe
   private void method00290(EntityMoveEvent var1) {
      if (!this.method00275() && this.method00294()) {
         Vec3 var2 = this.field00572.method05600(field00588) ? this.method00292(field00566) : this.method00283(this.method00274());
         this.field00575 = false;
         var1.method10060(var2);
      }
   }

   private double method00291(double[] var1, double var2, double var4) {
      double var6 = Math.abs(var1[0]);
      double var8 = Math.abs(var1[1]);
      double var10 = Math.max(0.0, var2 + Math.signum(var1[0]) * this.field00576.x);
      double var12 = Math.max(0.0, var2 + Math.signum(var1[1]) * this.field00576.z);
      double var14 = Math.min((var10 + var4) / var6, (var12 + var4) / var8);
      if (!(var14 * var6 <= var10) && !(var14 * var8 <= var12)) {
         double var16 = var6 * var10 + var8 * var12;
         return var16 + Math.sqrt(Math.max(0.0, var16 * var16 - var10 * var10 - var12 * var12 + var4 * var4));
      } else {
         return var14;
      }
   }

   private Vec3 method00292(NoWeb.Nested11 var1) {
      double[] var2 = MovementUtils.method05708();
      boolean var3 = var2[0] != 0.0 || var2[1] != 0.0;
      double var4 = this.field00576.y + var1.above();
      double var6 = this.field00576.y - var1.below();
      double var8 = var3 ? this.method00291(var2, var1.half(), var1.budget()) : 0.0;
      AABB var10 = var3 ? this.method00281(var2, var8) : null;
      this.field00577 = !var3 || var10 != null;
      double var11 = this.field00577 ? var1.budget() : 0.0;
      double var13 = !this.field00573 && !this.field00574
         ? Mth.clamp(0.0, var6, var4)
         : MovementUtils.method05724(this.field00573, this.field00574, var4 + var11, var11 - var6);
      double var15 = var10 != null && var13 > 0.0 && this.method00293() ? this.method00280(var10, var13, 0.0) : 0.0;
      this.field00578 = var15 > 0.0;
      if (this.field00578) {
         var13 = var15;
         double var17 = var15 - var4;
         var8 = this.method00291(var2, var1.half(), Math.sqrt(Math.max(0.0, var1.budget() * var1.budget() - var17 * var17)));
      } else {
         if (this.field00577) {
            var8 = 0.0;
         }

         var13 = this.method00285(this.method00278(var13, var2, var8), var6);
      }

      return new Vec3(var2[0] * var8, var13, var2[1] * var8);
   }

   private boolean method00293() {
      return mc.player != null && !mc.player.onGround();
   }

   private boolean method00294() {
      return this.field00572.method05600(field00591) ? this.field00575 : WorldCollisionUtils.method02824();
   }

   // $VF: Compiled from s
   private record Nested11(double half, double above, double below, double budget) {
   }

   // $VF: Compiled from s
   private record Nested12(
      double groundHorizontal, double airborneHorizontal, double descendHorizontal, double ascend, double descend, double idleAscend, double idleDescend
   ) {
   }
}
