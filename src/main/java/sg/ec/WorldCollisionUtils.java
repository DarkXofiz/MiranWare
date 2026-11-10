// Original binary: sg/ec/Boa59WPu4faSRfrl
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class WorldCollisionUtils implements MinecraftAccess {
   private static final double field06547 = 0.005;
   private static final double field06548 = 0.2F;
   private static final double field06549 = 0.005;
   private static final double field06550 = 0.005;
   private static final double field06551 = 0.03;
   private static final double field06552 = 0.001;
   private static final double field06553 = 0.001;
   private static final double field06554 = -1.0;
   private static final double field06555 = 2.0;
   private static final String field06556 = "This is a utility class and cannot be instantiated";

   public static List<BlockPos> method02816(BlockPos var0, float var1, float var2, boolean var3) {
      List<BlockPos> var4 = new ArrayList<>();
      int sx = var0.getX();
      int sxx = var0.getY();
      int sxxx = var0.getZ();
      int sxxxx = var3 ? sxx - (int)var2 : sxx;

      for (int sxxxxx = sx - (int)var1; sxxxxx <= sx + var1; sxxxxx++) {
         for (int sxxxxxx = sxxx - (int)var1; sxxxxxx <= sxxx + var1; sxxxxxx++) {
            for (int sxxxxxxx = sxxxx; sxxxxxxx <= sxx + var2; sxxxxxxx++) {
               var4.add(new BlockPos(sxxxxx, sxxxxxxx, sxxxxxx));
            }
         }
      }

      return var4;
   }

   public static boolean method02817(Class<? extends Entity> var0, AABB var1) {
      return mc.level == null ? false : !mc.level.getEntitiesOfClass(var0, var1, var0x -> true).isEmpty();
   }

   public static boolean method02818(Class<? extends Entity> var0, Vec3 var1, double var2) {
      double var4 = var2 * field06555;
      return method02817(var0, AABB.ofSize(var1, var4, var4, var4));
   }

   public static boolean method02820(boolean var0, double var1) {
      if (mc.player != null && mc.level != null && var0) {
         AABB var3 = mc.player.getBoundingBox();
         double var4 = var3.minY;
         BlockPos var6 = BlockPos.containing(mc.player.getX(), var4, mc.player.getZ());
         int var7 = var6.getX();
         int var8 = var6.getZ();

         for (int var9 = var6.getY() - 1; var9 >= mc.level.getMinY(); var9--) {
            BlockState var10 = mc.level.getBlockState(new BlockPos(var7, var9, var8));
            if (!var10.isAir()) {
               if (var10.is(Blocks.COBWEB)) {
                  return false;
               }

               double var11 = var4 - (var9 + 1.0);
               return var11 <= var1;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean method02821(AABB var0, Block var1) {
      int var2 = Mth.floor(var0.minX);
      int var3 = Mth.floor(var0.minY);
      int var4 = Mth.floor(var0.minZ);
      int var5 = Mth.floor(var0.maxX);
      int var6 = Mth.floor(var0.maxY);
      int var7 = Mth.floor(var0.maxZ);

      for (int var8 = var2; var8 <= var5; var8++) {
         for (int var9 = var3; var9 <= var6; var9++) {
            for (int var10 = var4; var10 <= var7; var10++) {
               Block var11 = mc.level.getBlockState(new BlockPos(var8, var9, var10)).getBlock();
               if (var11 == var1) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean method02822(AABB var0) {
      return method02823(var0, FluidTags.LAVA);
   }

   public static boolean method02823(AABB var0, TagKey<Fluid> var1) {
      if (mc.level == null) {
         return false;
      }

      AABB var2 = var0.deflate(field06552);
      MutableBlockPos var3 = new MutableBlockPos();

      for (int var4 = Mth.floor(var2.minX); var4 < Mth.ceil(var2.maxX); var4++) {
         for (int var5 = Mth.floor(var2.minY); var5 < Mth.ceil(var2.maxY); var5++) {
            for (int var6 = Mth.floor(var2.minZ); var6 < Mth.ceil(var2.maxZ); var6++) {
               var3.set(var4, var5, var6);
               FluidState var7 = mc.level.getFluidState(var3);
               if (var7.is(var1) && var5 + var7.getHeight(mc.level, var3) >= var2.minY) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean method02824() {
      return mc.player != null && mc.level != null && method02821(mc.player.getBoundingBox().deflate(field06549, 0.0, field06550), Blocks.COBWEB);
   }

   public static List<BlockPos> method02825(BlockPos var0, BlockPos var1) {
      ArrayList<BlockPos> var2 = new ArrayList<>();

      for (int var3 = var0.getX(); var3 <= var1.getX(); var3++) {
         for (int var4 = var0.getZ(); var4 <= var1.getZ(); var4++) {
            for (int var5 = var0.getY(); var5 <= var1.getY(); var5++) {
               var2.add(new BlockPos(var3, var5, var4));
            }
         }
      }

      return var2;
   }

   public static boolean method02826(Class<? extends Entity> var0, double var1) {
      return mc.player != null && mc.level != null ? method02817(var0, mc.player.getBoundingBox().inflate(var1)) : false;
   }

   public static boolean method02827() {
      if (mc.player != null && mc.level != null) {
         double var0 = mc.player.getBoundingBox().minY - field06551;
         BlockPos var2 = BlockPos.containing(mc.player.getX(), var0, mc.player.getZ());
         BlockState var3 = mc.level.getBlockState(var2);
         return var3.is(BlockTags.SLABS) || var3.is(Blocks.SNOW);
      } else {
         return false;
      }
   }

   public static List<BlockPos> method02828(BlockPos var0, float var1) {
      return method02816(var0, var1, var1, true);
   }

   public static boolean method02829(AABB var0) {
      return method02823(var0, FluidTags.WATER);
   }

   private WorldCollisionUtils() {
      throw new UnsupportedOperationException(field06556);
   }

   public static boolean method02830(AABB var0) {
      MutableBlockPos var1 = new MutableBlockPos();

      for (int var2 = Mth.floor(var0.minX); var2 <= Mth.floor(var0.maxX); var2++) {
         for (int var3 = Mth.floor(var0.minY); var3 <= Mth.floor(var0.maxY); var3++) {
            for (int var4 = Mth.floor(var0.minZ); var4 <= Mth.floor(var0.maxZ); var4++) {
               var1.set(var2, var3, var4);
               BlockState var5 = mc.level.getBlockState(var1);
               if (!var5.getCollisionShape(mc.level, var1).isEmpty() && !var5.isCollisionShapeFullBlock(mc.level, var1)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean method02831() {
      float var0 = mc.player.getBbWidth() / 2.0F;
      AABB var1 = new AABB(
         mc.player.getX() - var0,
         mc.player.getY() + mc.player.getEyeHeight(),
         mc.player.getZ() + var0,
         mc.player.getX() + var0,
         mc.player.getY() + mc.player.getBbHeight() + field06548,
         mc.player.getZ() - var0
      );
      return mc.level.noCollision(mc.player, var1);
   }

   public static List<BlockPos> method02832(BlockPos var0, float var1, float var2) {
      return method02816(var0, var1, var2, true);
   }

   public static boolean method02833() {
      if (mc.player != null && mc.level != null) {
         boolean var0 = mc.player.isInWater() || mc.player.getFluidHeight(FluidTags.WATER) > 0.0;
         return var0 && !mc.player.isUnderWater();
      } else {
         return false;
      }
   }

   public static double method02834(AABB var0) {
      if (mc.level == null) {
         return Double.NaN;
      }

      AABB var1 = var0.deflate(field06553).expandTowards(0.0, field06554, 0.0);
      MutableBlockPos var2 = new MutableBlockPos();
      double var3 = Double.NaN;

      for (int var5 = Mth.floor(var1.minX); var5 < Mth.ceil(var1.maxX); var5++) {
         for (int var6 = Mth.floor(var1.minY); var6 < Mth.ceil(var1.maxY); var6++) {
            for (int var7 = Mth.floor(var1.minZ); var7 < Mth.ceil(var1.maxZ); var7++) {
               var2.set(var5, var6, var7);
               FluidState var8 = mc.level.getFluidState(var2);
               if (var8.is(FluidTags.WATER)) {
                  double var9 = var6 + var8.getHeight(mc.level, var2);
                  if (Double.isNaN(var3) || var9 > var3) {
                     var3 = var9;
                  }
               }
            }
         }
      }

      return var3;
   }
}
