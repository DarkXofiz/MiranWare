// Original binary: sg/ec/U8imPwBi87kjwCnT
package sg.ec;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public class JumpCircle extends ClientModule {
   private static final float field12388 = 0.01F;
   private static final int field12389 = 0;
   private static final long field12390 = 0;
   private static final int field12391 = 0;
   private static final int field12392 = 0;
   private static final int field12393 = 0;
   private static final int field12394 = 0;
   private static final float field12395 = 0;
   private static final Direction[] field12396 = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
   private static final float field12397 = 0;
   private final NumberSetting<Integer> field12398;
   private final NumberSetting<Float> field12399;
   private final ToggleSetting field12400;
   private final NumberSetting<Float> field12401;
   private static ByteBuffer field12402 = ByteBuffer.allocateDirect(JumpCircle.field12467).order(ByteOrder.nativeOrder());
   private final List<JumpCircle.Nested175> field12403;
   private static final String field12404 = "Время жизни";
   private static final String field12405 = "Радиус";
   private static final float field12406 = 0.5F;
   private static final float field12407 = 2.5F;
   private static final float field12408 = 0.1F;
   private static final float field12409 = 1.25F;
   private static final String field12410 = "Искажение";
   private static final String field12411 = "Сила искажения";
   private static final float field12412 = 0.1F;
   private static final float field12413 = 0.05F;
   private static final float field12414 = 0.4F;
   private static final String field12415 = "Jump Circle";
   private static final long field12416 = 100L;
   private static final float field12417 = 0.5F;
   private static final double field12418 = 0.125;
   private static final double field12419 = 8.0;
   private static final double field12420 = 8.0;
   private static final double field12421 = 2.0;
   private static final double field12422 = 8.0;
   private static final double field12423 = 0.5;
   private static final double field12424 = 0.5;
   private static final float field12425 = -2.55F;
   private static final float field12426 = 5.8F;
   private static final double field12427 = 2.55F;
   private static final double field12428 = 2.8F;
   private static final float field12429 = 4.0F;
   private static final double field12430 = 0.2;
   private static final double field12431 = 0.5;
   private static final double field12432 = 0.5;
   private static final double field12433 = 5.8F;
   private static final double field12434 = 0.5;
   private static final double field12435 = 0.5;
   private static final double field12436 = 0.5;
   private static final double field12437 = 0.5;
   private static final double field12438 = 0.02;
   private static final double field12439 = 0.02;
   private static final double field12440 = 2.8F;
   private static final double field12441 = 0.6;
   private static final double field12442 = 4.0;
   private static final double field12443 = 4.0;
   private static final double field12444 = 0.05;
   private static final double field12445 = 0.5;
   private static final double field12446 = 2.8F;
   private static final double field12447 = 4.0;
   private static final double field12448 = 0.6;
   private static final double field12449 = 0.05;
   private static final double field12450 = 0.999;
   private static final double field12451 = 0.999;
   private static final double field12452 = 0.3;
   private static final long field12453 = 100L;
   private static final long field12454 = 4L;
   private static final long field12455 = 360L;
   private static final double field12456 = Math.PI;
   private static final float field12457 = 0.001F;
   private static final float field12458 = 0.001F;
   private static final float field12459 = 1000.0F;
   private static final double field12460 = 0.5;
   private static final double field12461 = 0.5;
   private static final float field12462 = 0.01F;
   private static final float field12463 = 4.0F;
   private static final float field12464 = 4.0F;
   private static final float field12465 = 6.0F;
   private static final float field12466 = 6.0F;
   private static final int field12467 = 65536;

   private BlockHitResult method05831(Entity var1, double var2, double var4, double var6, double var8) {
      Vec3 var10 = new Vec3(var2, var6, var4);
      Vec3 sx = new Vec3(var2, var8, var4);
      return mc.level.clip(new JumpCircle.Nested176(var10, sx, var1));
   }

   private JumpCircle.Nested175 method05832(Entity var1, double var2, double var4, double var6, float var8) {
      float var9 = var8 + field12417;
      double var10 = field12418;
      double var12 = Math.floor((var2 - var9) * field12419) * var10;
      double var14 = Math.floor((var6 - var9) * field12420) * var10;
      int var16 = Math.min(64, (int)Math.ceil(field12421 * var9 * field12422) + 1);
      float[] var17 = new float[var16 * var16];
      float[] var18 = new float[var16 * var16];
      boolean[] var19 = new boolean[var16 * var16];

      for (int var20 = 0; var20 < var16; var20++) {
         for (int var21 = 0; var21 < var16; var21++) {
            double var22 = var12 + (var20 + field12423) * var10;
            double var24 = var14 + (var21 + field12424) * var10;
            float var26 = this.method05842(var1, var22, var24, var4);
            boolean var27 = !Float.isNaN(var26);
            if (!var27) {
               var26 = (float)var4;
            }

            float var28 = var26 - (float)var4;
            int var29 = var20 * var16 + var21;
            var18[var29] = var27 && var28 >= field12425 ? 1.0F : 0.0F;
            var19[var29] = var27 && var28 > field12426;
            var17[var29] = Mth.clamp(var26, (float)(var4 - field12427), (float)(var4 + field12428));
         }
      }

      method05834(var18, var16);
      var var30 = this.method05850(var1, var2, var4, var6, var8);
      return new JumpCircle.Nested175(
         new Vec3(var2, var4, var6), var8, method05836(var2, var4, var6, var12, var14, var10, var16, var17, var18, var19, var30, var8)
      );
   }

   private static int method05833(double var0, double var2, double var4, float[] var6) {
      byte var7 = 4;
      byte var8 = 6;

      for (int var9 = 0; var9 < 4; var9++) {
         float var10 = var9 / field12463;
         float var11 = (var9 + 1) / field12464;

         for (int var12 = 0; var12 < 6; var12++) {
            float var13 = var12 / field12465;
            float var14 = (var12 + 1) / field12466;
            method05845(var0, var2, var4, var6, var10, var13);
            method05845(var0, var2, var4, var6, var11, var13);
            method05845(var0, var2, var4, var6, var11, var14);
            method05845(var0, var2, var4, var6, var10, var14);
         }
      }

      return 96;
   }

   private static void method05834(float[] var0, int var1) {
      int var2 = var1 * var1;
      int[] var3 = new int[var2];

      for (int var4 = 0; var4 < var2; var4++) {
         var3[var4] = var0[var4] > 0.0F ? 4 : 0;
      }

      for (int var8 = 0; var8 < var1; var8++) {
         for (int var5 = 0; var5 < var1; var5++) {
            int var6 = var8 * var1 + var5;
            if (var3[var6] != 0) {
               int var7 = var8 > 0 ? var3[(var8 - 1) * var1 + var5] + 1 : 1;
               var7 = Math.min(var7, var5 > 0 ? var3[var6 - 1] + 1 : 1);
               var3[var6] = Math.min(var3[var6], var7);
            }
         }
      }

      for (int var9 = var1 - 1; var9 >= 0; var9--) {
         for (int var11 = var1 - 1; var11 >= 0; var11--) {
            int var12 = var9 * var1 + var11;
            if (var3[var12] != 0) {
               int var14 = var9 + 1 < var1 ? var3[(var9 + 1) * var1 + var11] + 1 : 1;
               var14 = Math.min(var14, var11 + 1 < var1 ? var3[var12 + 1] + 1 : 1);
               var3[var12] = Math.min(var3[var12], var14);
            }
         }
      }

      for (int var10 = 0; var10 < var2; var10++) {
         var0[var10] = Math.min(var0[var10], var3[var10] / field12429);
      }
   }

   private static void method05835(double var0, double var2, double var4, double var6, float var8, double var9, float var11) {
      method05841((float)(var6 - var0), var8 + field12462 - (float)var2, (float)(var9 - var4), var11, 0.0F);
   }

   private static JumpCircleRenderer.Nested89 method05836(
      double var0,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      int var12,
      float[] var13,
      float[] var14,
      boolean[] var15,
      List<float[]> var16,
      float var17
   ) {
      byte var18 = 24;
      double var19 = (double)var18 / var17;
      int var21 = var12 * var12;
      int[] var22 = new int[var21];

      for (int var23 = 0; var23 < var12; var23++) {
         for (int var24 = 0; var24 < var12; var24++) {
            double var25 = var6 + (var23 + field12460) * var10 - var0;
            double var27 = var8 + (var24 + field12461) * var10 - var4;
            var22[var23 * var12 + var24] = method05840(Math.sqrt(var25 * var25 + var27 * var27), var19, var18);
         }
      }

      int[] var49 = new int[var21];
      int[] var50 = new int[var21];
      int[] var51 = new int[var21];
      int[] var26 = new int[var21];
      int[] var52 = new int[var21];
      int var28 = 0;
      boolean[] var29 = new boolean[var21];

      for (int var30 = 0; var30 < var12; var30++) {
         for (int var31 = 0; var31 < var12; var31++) {
            int var32 = var30 * var12 + var31;
            if (!var29[var32] && !var15[var32]) {
               float var33 = var13[var32];
               float var34 = var14[var32];
               int var35 = 1;

               while (var35 < 8 && var31 + var35 < var12 && method05849(var30, var31 + var35, var12, var13, var14, var15, var29, var33, var34)) {
                  var35++;
               }

               int var36 = 1;

               while (var36 < 8 && var30 + var36 < var12 && method05848(var30 + var36, var31, var35, var12, var13, var14, var15, var29, var33, var34)) {
                  var36++;
               }

               for (int var37 = 0; var37 < var36; var37++) {
                  for (int var38 = 0; var38 < var35; var38++) {
                     var29[(var30 + var37) * var12 + var31 + var38] = true;
                  }
               }

               double var68 = var6 + var30 * var10;
               double var39 = var6 + (var30 + var36) * var10;
               double var41 = var8 + var31 * var10;
               double var43 = var8 + (var31 + var35) * var10;
               double var45 = Math.max(0.0, Math.max(var68 - var0, var0 - var39));
               double var47 = Math.max(0.0, Math.max(var41 - var4, var4 - var43));
               var49[var28] = var30;
               var50[var28] = var31;
               var51[var28] = var35;
               var26[var28] = var36;
               var52[var28] = method05840(Math.sqrt(var45 * var45 + var47 * var47), var19, var18);
               var28++;
            }
         }
      }

      int[] var53 = new int[var16.size()];

      for (int var54 = 0; var54 < var53.length; var54++) {
         float[] var56 = (float[])var16.get(var54);
         double var58 = Mth.clamp(var0, Math.min(var56[0], var56[2]), Math.max(var56[0], var56[2])) - var0;
         double var63 = Mth.clamp(var4, Math.min(var56[1], var56[3]), Math.max(var56[1], var56[3])) - var4;
         var53[var54] = method05840(Math.sqrt(var58 * var58 + var63 * var63), var19, var18);
      }

      field12402.clear();
      int[] var55 = new int[var18 + 1];
      int var57 = 0;

      for (int var59 = 0; var59 < var18; var59++) {
         for (int var60 = 0; var60 < var28; var60++) {
            if (var52[var60] == var59) {
               int var64 = var49[var60] * var12 + var50[var60];
               float var66 = var13[var64];
               float var69 = var14[var64];
               double var71 = var6 + var49[var60] * var10;
               double var40 = var6 + (var49[var60] + var26[var60]) * var10;
               double var42 = var8 + var50[var60] * var10;
               double var44 = var8 + (var50[var60] + var51[var60]) * var10;
               method05835(var0, var2, var4, var71, var66, var42, var69);
               method05835(var0, var2, var4, var71, var66, var44, var69);
               method05835(var0, var2, var4, var40, var66, var44, var69);
               method05835(var0, var2, var4, var40, var66, var42, var69);
               var57 += 4;
            }
         }

         for (int var61 = 0; var61 < var12; var61++) {
            for (int var65 = 0; var65 < var12; var65++) {
               int var67 = var61 * var12 + var65;
               if (!var15[var67] && var22[var67] == var59) {
                  double var70 = var6 + var61 * var10;
                  double var72 = var8 + var65 * var10;
                  double var73 = var70 + var10;
                  double var74 = var72 + var10;
                  if (var61 + 1 < var12) {
                     var57 += method05843(var0, var2, var4, var67, (var61 + 1) * var12 + var65, var13, var14, var15, var73, var72, var73, var74);
                  }

                  if (var65 + 1 < var12) {
                     var57 += method05843(var0, var2, var4, var67, var61 * var12 + var65 + 1, var13, var14, var15, var70, var74, var73, var74);
                  }
               }
            }
         }

         for (int var62 = 0; var62 < var53.length; var62++) {
            if (var53[var62] == var59) {
               var57 += method05833(var0, var2, var4, (float[])var16.get(var62));
            }
         }

         var55[var59 + 1] = var57;
      }

      field12402.flip();
      return JumpCircleRenderer.method03202(field12402, var57, var55);
   }

   private float method05837(BlockPos var1, double var2, double var4, float var6) {
      double var7 = Mth.clamp(var2 - var1.getX(), 0.0, field12450);
      double var9 = Mth.clamp(var4 - var1.getZ(), 0.0, field12451);

      for (BlockPos var14 : new BlockPos[]{var1, var1.above()}) {
         VoxelShape var15 = mc.level.getBlockState(var14).getShape(mc.level, var14);
         if (!var15.isEmpty()) {
            double var16 = var14.getY() + var15.max(Axis.Y, var9, var7);
            if (var16 > var6 && var16 - var6 <= field12452) {
               var6 = (float)var16;
            }
         }
      }

      return var6;
   }

   @Subscribe
   private void method05838(EntityJumpEvent var1) {
      if (mc.level != null) {
         if (var1.method03779() instanceof LocalPlayer var2) {
            Vec3 var4 = var2.position();
            this.method05839();
            this.field12403.add(this.method05832(var2, var4.x(), var4.y(), var4.z(), this.field12399.method03022()));
         }
      }
   }

   private void method05839() {
      int var1 = 0;

      for (JumpCircle.Nested175 var3 : this.field12403) {
         if (!var3.method05852()) {
            var1++;
         }
      }

      for (JumpCircle.Nested175 var5 : this.field12403) {
         if (var1 < 8) {
            break;
         }

         if (!var5.method05852()) {
            var5.method05861();
            var1--;
         }
      }
   }

   private static int method05840(double var0, double var2, int var4) {
      return Mth.clamp((int)(var0 * var2), 0, var4 - 1);
   }

   private static void method05841(float var0, float var1, float var2, float var3, float var4) {
      if (field12402.remaining() < 20) {
         ByteBuffer var5 = ByteBuffer.allocateDirect(field12402.capacity() << 1).order(ByteOrder.nativeOrder());
         field12402.flip();
         var5.put(field12402);
         field12402 = var5;
      }

      field12402.putFloat(var0).putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4);
   }

   private float method05842(Entity var1, double var2, double var4, double var6) {
      double var8 = var6 + field12440 + field12441;

      for (int var10 = 0; var10 < 4; var10++) {
         BlockHitResult var11 = this.method05831(var1, var2, var4, var8, var6 - field12442);
         if (var11.getType() != Type.BLOCK) {
            return Float.NaN;
         }

         float var12 = (float)var11.getLocation().y;
         if (var11.isInside()) {
            double var13 = var6 + 1.0;
            BlockHitResult var15 = this.method05831(var1, var2, var4, var13, var6 - field12443);
            if (var15.getType() != Type.BLOCK) {
               return Float.NaN;
            }

            float var16 = (float)var15.getLocation().y;
            boolean var17 = var15.isInside();
            if (!var17 && var16 > var13 - field12444) {
               BlockPos var18 = BlockPos.containing(var2, var13 + field12445, var4);
               var17 = !mc.level.getBlockState(var18).getCollisionShape(mc.level, var18).isEmpty();
            }

            if (var17) {
               return (float)(var6 + field12446 + field12447);
            }

            var11 = var15;
            var12 = var16;
         }

         BlockPos var19 = var11.getBlockPos().below();
         if (!(var12 - var6 > field12448) || !mc.level.getBlockState(var19).getCollisionShape(mc.level, var19).isEmpty()) {
            return this.method05837(var11.getBlockPos(), var2, var4, var12);
         }

         var8 = var12 - field12449;
      }

      return Float.NaN;
   }

   private static int method05843(
      double var0,
      double var2,
      double var4,
      int var6,
      int var7,
      float[] var8,
      float[] var9,
      boolean[] var10,
      double var11,
      double var13,
      double var15,
      double var17
   ) {
      if (var10[var7]) {
         return 0;
      }

      float var19 = var8[var6];
      float var20 = var8[var7];
      if (var19 == var20) {
         return 0;
      }

      float var21 = var9[var6];
      float var22 = var9[var7];
      method05835(var0, var2, var4, var11, var19, var13, var21);
      method05835(var0, var2, var4, var11, var20, var13, var22);
      method05835(var0, var2, var4, var15, var20, var17, var22);
      method05835(var0, var2, var4, var15, var19, var17, var21);
      return 4;
   }

   private static float method05844(float var0) {
      float var1 = 1.0F - var0;
      return 1.0F - var1 * var1 * var1;
   }

   @Override
   public void method00245() {
      super.method00245();

      for (JumpCircle.Nested175 var2 : this.field12403) {
         var2.method05854();
      }

      this.field12403.clear();
      JumpCircleRenderer.method03194(false);
      JumpCircleRenderer.method03201();
   }

   private static void method05845(double var0, double var2, double var4, float[] var6, float var7, float var8) {
      float var9 = Mth.lerp(var7, var6[0], var6[2]);
      float var10 = Mth.lerp(var7, var6[1], var6[3]);
      float var11 = var6[4] + var8;
      method05841(var9 - (float)var0, var11 - (float)var2, var10 - (float)var4, 0.0F, 1.0F);
   }

   @Subscribe
   private void method05846(TickEvent var1) {
      long var2 = this.field12398.method03022().intValue() * field12416;
      this.field12403.removeIf(var2x -> {
         if (var2x.method05860().method04693() < var2 && !var2x.method05855()) {
            return false;
         }

         var2x.method05854();
         return true;
      });
   }

   @Subscribe
   private void method05847(Render3DEvent var1) {
      boolean var2 = this.field12400.method05999();
      JumpCircleRenderer.method03194(var2);
      if (!this.field12403.isEmpty()) {
         long var3 = this.field12398.method03022().intValue() * field12453;
         Vec3 var5 = var1.method00994().position();
         int var6 = ColorUtils.Nested138.method04636();
         int var7 = ColorUtils.Nested138.method04637();
         float var8 = (float)(System.currentTimeMillis() / field12454 % field12455);
         float var9 = var2 ? this.field12401.method03022() : 0.0F;

         for (JumpCircle.Nested175 var11 : this.field12403) {
            JumpCircleRenderer.Nested89 var12 = var11.method05853();
            if (var12 != null) {
               float var13 = Mth.clamp((float)var11.method05860().method04693() / (float)var3, 0.0F, 1.0F);
               float var14 = method05844(var13) * var11.method05857();
               float var15 = (float)Math.sin(var13 * field12456) * var11.method05859();
               if (!(var15 <= field12457) && !(var14 <= field12458)) {
                  Vec3 var16 = var11.method05858();
                  JumpCircleRenderer.method03203(
                     var12,
                     (float)(var16.x() - var5.x()),
                     (float)(var16.y() - var5.y()),
                     (float)(var16.z() - var5.z()),
                     var14,
                     (float)var16.x(),
                     (float)var16.y(),
                     (float)var16.z(),
                     var15,
                     var6,
                     var7,
                     var8,
                     (float)var11.method05860().method04693() / field12459,
                     var9,
                     var14 / var11.method05857()
                  );
               }
            }
         }
      }
   }

   private static boolean method05848(
      int var0, int var1, int var2, int var3, float[] var4, float[] var5, boolean[] var6, boolean[] var7, float var8, float var9
   ) {
      for (int var10 = 0; var10 < var2; var10++) {
         if (!method05849(var0, var1 + var10, var3, var4, var5, var6, var7, var8, var9)) {
            return false;
         }
      }

      return true;
   }

   private static boolean method05849(int var0, int var1, int var2, float[] var3, float[] var4, boolean[] var5, boolean[] var6, float var7, float var8) {
      int var9 = var0 * var2 + var1;
      return !var6[var9] && !var5[var9] && var3[var9] == var7 && var4[var9] == var8;
   }

   private List<float[]> method05850(Entity var1, double var2, double var4, double var6, float var8) {
      ArrayList var9 = new ArrayList();
      double var10 = var8 + field12430;
      int var12 = Mth.floor(var2 - var10);
      int var13 = Mth.floor(var2 + var10);
      int var14 = Mth.floor(var6 - var10);
      int var15 = Mth.floor(var6 + var10);
      int var16 = Mth.floor(var4) - 1;
      int var17 = Mth.floor(var4) + 2;
      MutableBlockPos var18 = new MutableBlockPos();

      for (int var19 = var12; var19 <= var13; var19++) {
         for (int var20 = var14; var20 <= var15; var20++) {
            float var21 = this.method05842(var1, var19 + field12431, var20 + field12432, var4);
            if (!Float.isNaN(var21) && !(var21 - var4 <= field12433)) {
               for (int var22 = var16; var22 <= var17; var22++) {
                  var18.set(var19, var22, var20);
                  if (Block.isShapeFullBlock(mc.level.getBlockState(var18).getCollisionShape(mc.level, var18))) {
                     for (Direction var26 : field12396) {
                        var18.set(var19 + var26.getStepX(), var22, var20 + var26.getStepZ());
                        VoxelShape var27 = mc.level.getBlockState(var18).getCollisionShape(mc.level, var18);
                        boolean var28 = var27.isEmpty() || !Block.isShapeFullBlock(var27);
                        var18.set(var19, var22, var20);
                        if (var28) {
                           double var29 = var19 + field12434 + var26.getStepX() * field12435;
                           double var31 = var20 + field12436 + var26.getStepZ() * field12437;
                           if (!((var2 - var29) * var26.getStepX() + (var6 - var31) * var26.getStepZ() <= 0.0)) {
                              float var33;
                              float var34;
                              float var35;
                              float var36;
                              if (var26.getStepZ() != 0) {
                                 var33 = var19;
                                 var35 = var19 + 1;
                                 var34 = var36 = (float)(var20 + (var26 == Direction.SOUTH ? 1.0 : 0.0) + var26.getStepZ() * field12438);
                              } else {
                                 var34 = var20;
                                 var36 = var20 + 1;
                                 var33 = var35 = (float)(var19 + (var26 == Direction.EAST ? 1.0 : 0.0) + var26.getStepX() * field12439);
                              }

                              double var37 = Mth.clamp(var2, Math.min(var33, var35), Math.max(var33, var35)) - var2;
                              double var39 = Mth.clamp(var6, Math.min(var34, var36), Math.max(var34, var36)) - var6;
                              if (!(var37 * var37 + var39 * var39 > var10 * var10)) {
                                 var9.add(new float[]{var33, var34, var35, var36, var22});
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var9;
   }

   public JumpCircle() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field12398 = new NumberSetting<Integer>(field12404).method10835(15).method10838(50).method10834(1).method03017(15).method03023(this);
      this.field12399 = new NumberSetting<Float>(field12405)
         .method10835(field12406)
         .method10838(field12407)
         .method10834(field12408)
         .method03017(field12409)
         .method03023(this);
      this.field12400 = new ToggleSetting(field12410).method03017(false).method03023(this);
      this.field12401 = new NumberSetting<Float>(field12411)
         .method10835(field12412)
         .method10838(1.0F)
         .method10834(field12413)
         .method03017(field12414)
         .method03023(this)
         .method03025(this.field12400::method05999);
      this.field12403 = new ArrayList<>();
      this.method03935(field12415);
   }

   // $VF: Compiled from s
   public static class Nested175 {
      private final Vec3 field12468;
      private final float field12469;
      private final ElapsedTimer field12470 = new ElapsedTimer();
      private JumpCircleRenderer.Nested89 field12471;
      private boolean field12472;
      private final ElapsedTimer field12473 = new ElapsedTimer();
      private static final float field12474 = 300.0F;
      private static final long field12475 = 300L;

      public boolean method05852() {
         return this.field12472;
      }

      public JumpCircleRenderer.Nested89 method05853() {
         return this.field12471;
      }

      public void method05854() {
         if (this.field12471 != null) {
            this.field12471.method03204();
            this.field12471 = null;
         }
      }

      public boolean method05855() {
         return this.field12472 && this.field12473.method04693() >= field12475;
      }

      public ElapsedTimer method05856() {
         return this.field12473;
      }

      public float method05857() {
         return this.field12469;
      }

      public Vec3 method05858() {
         return this.field12468;
      }

      public float method05859() {
         return !this.field12472 ? 1.0F : Mth.clamp(1.0F - (float)this.field12473.method04693() / field12474, 0.0F, 1.0F);
      }

      public ElapsedTimer method05860() {
         return this.field12470;
      }

      public Nested175(Vec3 var1, float var2, JumpCircleRenderer.Nested89 var3) {
         this.field12468 = var1;
         this.field12469 = var2;
         this.field12471 = var3;
      }

      public void method05861() {
         if (!this.field12472) {
            this.field12472 = true;
            this.field12473.method04694();
         }
      }
   }

   // $VF: Compiled from s
   private static class Nested176 extends ClipContext {
      private static final double field12476 = 0.5;

      Nested176(Vec3 var1, Vec3 var2, Entity var3) {
         super(var1, var2, net.minecraft.world.level.ClipContext.Block.COLLIDER, Fluid.NONE, var3);
      }

      @Override
      public VoxelShape getBlockShape(BlockState var1, BlockGetter var2, BlockPos var3) {
         VoxelShape var4 = super.getBlockShape(var1, var2, var3);
         if (var4.isEmpty()) {
            return var4;
         }

         AABB var5 = var4.bounds();
         return (var5.maxX - var5.minX) * (var5.maxZ - var5.minZ) < field12476 ? Shapes.empty() : var4;
      }
   }
}
