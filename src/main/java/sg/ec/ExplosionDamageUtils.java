// Original binary: sg/ec/L7y31lb3AFkj7GEq
package sg.ec;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.Plane;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public final class ExplosionDamageUtils implements MinecraftAccess {
   private static final double field09762 = 6.0;
   private static final double field09763 = 0;
   private static final double[] field09764 = new double[]{ExplosionDamageUtils.field09840, ExplosionDamageUtils.field09841, ExplosionDamageUtils.field09842};
   private static final float field09765 = 0;
   private static final double field09766 = 0;
   private static final float field09767 = 0;
   private static final double field09768 = 0;
   private static final CollisionContext field09769 = CollisionContext.empty();
   private static final double field09770 = 0;
   private static final double field09771 = 0;
   private static final double[] field09772 = new double[]{
      ExplosionDamageUtils.field09843, ExplosionDamageUtils.field09844, ExplosionDamageUtils.field09845, ExplosionDamageUtils.field09846, ExplosionDamageUtils.field09847
   };
   private static final AABB field09773 = new AABB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
   public static final double field09774 = 0;
   private static final EquipmentSlot[] field09775 = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   private static final Int2IntOpenHashMap field09776 = new Int2IntOpenHashMap();
   private static int field09777 = ExplosionDamageUtils.field09848;
   private static final Map<ExplosionDamageUtils.Nested133, Float> field09778 = new HashMap<>();
   private static int field09779 = ExplosionDamageUtils.field09849;
   private static boolean field09780;
   private static final double field09781 = 0.5;
   private static final double field09782 = 0.5;
   private static final double field09783 = 0.5;
   private static final double field09784 = 0.5;
   private static final double field09785 = 1.5;
   private static final double field09786 = 3.0;
   private static final double field09787 = 1.5;
   private static final double field09788 = 2.0;
   private static final double field09789 = 0.5;
   private static final double field09790 = 0.5;
   private static final double field09791 = Double.MAX_VALUE;
   private static final double field09792 = 0.04;
   private static final double field09793 = 0.04;
   private static final double field09794 = 0.04;
   private static final double field09795 = 0.04;
   private static final double field09796 = 0.04;
   private static final double field09797 = 0.04;
   private static final float field09798 = -0.03F;
   private static final float field09799 = 0.03F;
   private static final float field09800 = -0.04F;
   private static final float field09801 = 0.04F;
   private static final double field09802 = 2.0;
   private static final double field09803 = 2.0;
   private static final double field09804 = 2.0;
   private static final double field09805 = 0.5;
   private static final double field09806 = 0.5;
   private static final double field09807 = 0.5;
   private static final double field09808 = Double.MAX_VALUE;
   private static final double field09809 = Double.MAX_VALUE;
   private static final double field09810 = 1.0E-6;
   private static final double field09811 = 0.2;
   private static final double field09812 = 0.05;
   private static final double field09813 = Double.MAX_VALUE;
   private static final double field09814 = Double.MAX_VALUE;
   private static final float field09815 = -1.0F;
   private static final double field09816 = 12.0;
   private static final double field09817 = 1.0E-4;
   private static final int field09818 = Integer.MIN_VALUE;
   private static final double field09819 = 2.0;
   private static final double field09820 = 2.0;
   private static final double field09821 = 2.0;
   private static final double field09822 = 2.0;
   private static final double field09823 = 2.0;
   private static final double field09824 = 1.0E-4;
   private static final double field09825 = 1.0E-8;
   private static final double field09826 = -1.0E-8;
   private static final float field09827 = -1.0F;
   private static final double field09828 = 1.0E-4;
   private static final double field09829 = 12.0;
   private static final double field09830 = 2.0;
   private static final double field09831 = 7.0;
   private static final float field09832 = 1.5F;
   private static final float field09833 = 4.0F;
   private static final float field09834 = 0.2F;
   private static final float field09835 = 20.0F;
   private static final float field09836 = 25.0F;
   private static final float field09837 = 25.0F;
   private static final int field09838 = Integer.MIN_VALUE;
   private static final float field09839 = 0.2F;
   private static final double field09840 = 0.5;
   private static final double field09841 = 0.05;
   private static final double field09842 = 0.95;
   private static final double field09843 = 0.5;
   private static final double field09844 = 0.1;
   private static final double field09845 = 0.9;
   private static final double field09846 = 0.3;
   private static final double field09847 = 0.7;
   private static final int field09848 = Integer.MIN_VALUE;
   private static final int field09849 = Integer.MIN_VALUE;

   public static Vec3 method04364(Entity var0, Vec3 var1, float var2) {
      return method04371(var0, var1, var2, false);
   }

   public static Vec3 method04365(BlockPos var0) {
      return Vec3.atCenterOf(var0).add(method04413(), method04413(), method04413());
   }

   public static boolean method04366(BlockState var0) {
      return method04376(var0) && !var0.is(Blocks.SWEET_BERRY_BUSH);
   }

   public static boolean method04367(BlockPos var0) {
      if (mc.level.getFluidState(var0).isEmpty() && mc.level.getFluidState(var0.above()).isEmpty()) {
         for (Direction var2 : Plane.HORIZONTAL) {
            if (!mc.level.getFluidState(var0.relative(var2)).isEmpty()) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public static float method04368(Vec3 var0, LivingEntity var1) {
      return var1 == null ? 0.0F : method04421(var0, var1, var1.getBoundingBox());
   }

   public static boolean method04369(BlockState var0, BlockPos var1, Direction var2) {
      return Block.isFaceFull(var0.getCollisionShape(mc.level, var1), var2);
   }

   private static float method04370(float var0) {
      return switch (mc.level.getDifficulty()) {
         case PEACEFUL -> 0.0F;
         case EASY -> Math.min(var0 / 2.0F + 1.0F, var0);
         case NORMAL -> var0;
         case HARD -> var0 * field09832;
      };
   }

   public static Vec3 method04371(Entity var0, Vec3 var1, float var2, boolean var3) {
      double var4 = var2 * var2;
      Vec3 var6 = var0.position().add(method04413(), field09790 + method04413(), method04413());
      if (var1.distanceToSqr(var6) <= var4 && method04414(var6, var3)) {
         return var6;
      }

      AABB var7 = var0.getBoundingBox();
      Vec3 var8 = null;
      double var9 = field09791;

      for (double var14 : field09764) {
         double var16 = Mth.lerp(var14 + method04375(), var7.minX, var7.maxX);

         for (double var21 : field09764) {
            double var23 = Mth.lerp(var21 + method04375(), var7.minY, var7.maxY);

            for (double var28 : field09764) {
               Vec3 var30 = new Vec3(var16, var23, Mth.lerp(var28 + method04375(), var7.minZ, var7.maxZ));
               if (!(var1.distanceToSqr(var30) > var4)) {
                  double var31 = var30.distanceToSqr(var6);
                  if (!(var31 >= var9) && method04414(var30, var3)) {
                     var9 = var31;
                     var8 = var30;
                  }
               }
            }
         }
      }

      return var8;
   }

   static {
      field09776.defaultReturnValue(-1);
   }

   private static int method04372(LivingEntity var0) {
      int var1 = mc.player == null ? field09838 : mc.player.tickCount;
      if (var1 != field09777) {
         field09776.clear();
         field09777 = var1;
      }

      int var2 = field09776.get(var0.getId());
      if (var2 != -1) {
         return var2;
      }

      int var3 = 0;

      for (EquipmentSlot var7 : field09775) {
         ItemStack var8 = var0.getItemBySlot(var7);
         if (!var8.isEmpty()) {
            var3 += EnchantmentUtils.method06757(var8, Enchantments.PROTECTION);
            var3 += EnchantmentUtils.method06757(var8, Enchantments.BLAST_PROTECTION) * 2;
         }
      }

      var3 = Mth.clamp(var3, 0, 20);
      field09776.put(var0.getId(), var3);
      return var3;
   }

   public static ExplosionDamageUtils.Nested134 method04373(BlockPos var0, Vec3 var1, float var2, boolean var3, List<BlockPos> var4) {
      return method04386(var0, var1, var2, var3, var4).face();
   }

   public static boolean method04374(BlockPos var0) {
      return !mc.level.isUnobstructed(Blocks.OBSIDIAN.defaultBlockState(), var0, CollisionContext.empty());
   }

   private static double method04375() {
      return GuiHitTestUtils.method05613(field09800, field09801);
   }

   public static boolean method04376(BlockState var0) {
      if (var0.isAir()) {
         return false;
      } else {
         return var0.getBlock() instanceof LiquidBlock ? false : var0.getBlock().defaultDestroyTime() >= 0.0F;
      }
   }

   public static Vec3 method04377(BlockPos var0) {
      return new Vec3(var0.getX() + field09781, var0.getY() + 1.0, var0.getZ() + field09782);
   }

   public static boolean method04378(BlockPos var0, Vec3 var1, float var2, List<BlockPos> var3) {
      return method04398(var0, var1, var2, var3).visible();
   }

   private ExplosionDamageUtils() {
   }

   public static BlockPos method04379(BlockPos var0, Vec3 var1, float var2) {
      ExplosionDamageUtils.Nested131 var3 = method04417(var0, var1, var2, List.of());
      return var3.aim() != null ? null : var3.occluder();
   }

   public static boolean method04380(Entity var0) {
      return var0.isAlive() && !var0.isSpectator();
   }

   public static double method04381(Vec3 var0, BlockPos var1) {
      return method04418(var0, new AABB(var1.getX(), var1.getY(), var1.getZ(), var1.getX() + 1.0, var1.getY() + 1.0, var1.getZ() + 1.0));
   }

   public static boolean method04382(BlockPos var0, AABB var1) {
      return method04406(mc.level.getBlockState(var0.below())) && !var1.intersects(method04396(var0));
   }

   static Vec3 method04383(Vec3 var0, Vec3 var1, BlockPos var2) {
      Vec3 var3 = var1.subtract(var0);
      double var4 = Double.POSITIVE_INFINITY;
      var4 = method04415(var4, var3.x, var2.getX() - var0.x, var2.getX() + 1.0 - var0.x);
      var4 = method04415(var4, var3.y, var2.getY() - var0.y, var2.getY() + 1.0 - var0.y);
      var4 = method04415(var4, var3.z, var2.getZ() - var0.z, var2.getZ() + 1.0 - var0.z);
      if (!Double.isFinite(var4)) {
         return null;
      }

      double var6 = var4 + field09824;
      return var6 >= 1.0 ? null : var0.add(var3.scale(var6));
   }

   public static Vec3 method04384(BlockPos var0, Vec3 var1, float var2) {
      return method04417(var0, var1, var2, List.of()).aim();
   }

   public static ExplosionDamageUtils.Nested134 method04385(BlockPos var0, Vec3 var1, float var2, boolean var3) {
      return method04373(var0, var1, var2, var3, List.of());
   }

   private static ExplosionDamageUtils.Nested135 method04386(BlockPos var0, Vec3 var1, float var2, boolean var3, List<BlockPos> var4) {
      ExplosionDamageUtils.Nested134 var5 = null;
      double var6 = field09808;
      BlockPos var8 = null;
      double var9 = field09809;

      label71:
      for (Direction var14 : Direction.values()) {
         BlockPos var15 = var0.relative(var14.getOpposite());
         if (!var4.contains(var15)) {
            BlockState var16 = mc.level.getBlockState(var15);
            if (!var16.canBeReplaced() && method04369(var16, var15, var14)) {
               VoxelShape var17 = var16.getCollisionShape(mc.level, var15);
               AABB var18 = var17.isEmpty() ? field09773 : var17.bounds();

               for (double var22 : field09772) {
                  for (double var27 : field09772) {
                     Vec3 var29 = method04391(var18, var15, var14, var22, var27);
                     if (method04422(var1, var29, var14)) {
                        double var30 = var1.distanceToSqr(var29);
                        if (!(var30 > var2 * var2) && !(var30 >= var6)) {
                           BlockPos var32 = var3 ? null : method04389(var1, var29, var15, var4);
                           if (var32 == null) {
                              var6 = var30;
                              var5 = new ExplosionDamageUtils.Nested134(var15, var14, var29);
                              continue label71;
                           }

                           if (var30 < var9) {
                              var9 = var30;
                              var8 = var32;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return new ExplosionDamageUtils.Nested135(var5, var5 == null ? var8 : null);
   }

   public static BlockPos method04387(BlockPos var0, Vec3 var1, float var2, boolean var3) {
      return method04386(var0, var1, var2, var3, List.of()).occluder();
   }

   public static boolean method04388(BlockPos var0, BlockState var1) {
      return mc.level != null && var1.getBlock() instanceof FallingBlock ? mc.level.getBlockState(var0.below()).canBeReplaced() : false;
   }

   private static BlockPos method04389(Vec3 var0, Vec3 var1, BlockPos var2, List<BlockPos> var3) {
      Vec3 var4 = var0;
      BlockPos var5 = null;

      for (int var6 = 0; var6 <= var3.size(); var6++) {
         var5 = CollisionBlockView.field25700.rayBlock(var4, var1, field09769, var6 == 0);
         if (var5 == null || var5.equals(var2)) {
            return null;
         }

         if (!var3.contains(var5)) {
            return var5;
         }

         Vec3 var7 = method04383(var4, var1, var5);
         if (var7 == null) {
            return null;
         }

         var4 = var7;
      }

      return var5;
   }

   public static float method04390(Vec3 var0, LivingEntity var1, AABB var2, float var3) {
      return method04416(var0, var1, var2, var3, field09816);
   }

   private static Vec3 method04391(AABB var0, BlockPos var1, Direction var2, double var3, double var5) {
      double var7 = var1.getX() + Mth.lerp(var2.getAxis() == Axis.X ? field09805 : var3, var0.minX, var0.maxX);
      double var9 = var1.getY() + Mth.lerp(var2.getAxis() == Axis.Y ? field09806 : (var2.getAxis() == Axis.X ? var3 : var5), var0.minY, var0.maxY);
      double var11 = var1.getZ() + Mth.lerp(var2.getAxis() == Axis.Z ? field09807 : var5, var0.minZ, var0.maxZ);
      switch (var2) {
         case UP:
            var9 = var1.getY() + var0.maxY;
            break;
         case DOWN:
            var9 = var1.getY() + var0.minY;
            break;
         case NORTH:
            var11 = var1.getZ() + var0.minZ;
            break;
         case SOUTH:
            var11 = var1.getZ() + var0.maxZ;
            break;
         case WEST:
            var7 = var1.getX() + var0.minX;
            break;
         case EAST:
            var7 = var1.getX() + var0.maxX;
      }

      return method04395(new Vec3(var7, var9, var11), var2);
   }

   private static float method04392(LivingEntity var0, float var1) {
      MobEffectInstance var2 = var0.getEffect(MobEffects.RESISTANCE);
      if (var2 == null) {
         return var1;
      }

      float var3 = Mth.clamp((var2.getAmplifier() + 1) * field09839, 0.0F, 1.0F);
      return var1 * (1.0F - var3);
   }

   public static boolean method04393(BlockPos var0) {
      return !mc.level.getEntitiesOfClass(Entity.class, method04396(var0), ExplosionDamageUtils::method04380).isEmpty();
   }

   public static double method04394(Vec3 var0, Vec3 var1) {
      return method04418(var0, new AABB(var1.x - 1.0, var1.y, var1.z - 1.0, var1.x + 1.0, var1.y + field09802, var1.z + 1.0));
   }

   public static Vec3 method04395(Vec3 var0, Direction var1) {
      Axis var2 = var1.getAxis();
      return new Vec3(
         var2 == Axis.X ? var0.x : var0.x + method04413(), var2 == Axis.Y ? var0.y : var0.y + method04413(), var2 == Axis.Z ? var0.z : var0.z + method04413()
      );
   }

   public static AABB method04396(BlockPos var0) {
      return new AABB(var0.getX(), var0.getY(), var0.getZ(), var0.getX() + 1.0, var0.getY() + field09788, var0.getZ() + 1.0);
   }

   private static float method04397(LivingEntity var0, float var1) {
      float var2 = var0.getArmorValue();
      if (var2 <= 0.0F) {
         return var1;
      }

      float var3 = (float)var0.getAttributeValue(Attributes.ARMOR_TOUGHNESS);
      float var4 = 2.0F + var3 / field09833;
      float var5 = Mth.clamp(var2 - var1 / var4, var2 * field09834, field09835);
      return var1 * (1.0F - var5 / field09836);
   }

   public static ExplosionDamageUtils.Nested132 method04398(BlockPos var0, Vec3 var1, float var2, List<BlockPos> var3) {
      double var4 = var2 * var2;
      AABB var6 = method04400(var0).deflate(field09812);
      var var7 = BlockPlacementManager.method07895();
      BlockPos var8 = null;
      double var9 = field09813;

      for (double var14 : field09764) {
         double var16 = Mth.lerp(var14, var6.minX, var6.maxX);

         for (double var21 : field09764) {
            double var23 = Mth.lerp(var21, var6.minY, var6.maxY);

            for (double var28 : field09764) {
               Vec3 var30 = new Vec3(var16, var23, Mth.lerp(var28, var6.minZ, var6.maxZ));
               double var31 = var1.distanceToSqr(var30);
               if (!(var31 > var4)) {
                  for (int var33 = 0; var33 < var7.size(); var33++) {
                     BlockPos var34 = method04389((Vec3)var7.get(var33), var30, null, var3);
                     if (var34 == null) {
                        return new ExplosionDamageUtils.Nested132(true, null);
                     }

                     if (var31 < var9) {
                        var9 = var31;
                        var8 = var34;
                     }
                  }
               }
            }
         }
      }

      return new ExplosionDamageUtils.Nested132(false, var8);
   }

   public static float method04399(Vec3 var0, List<? extends LivingEntity> var1) {
      if (var1 != null && !var1.isEmpty()) {
         float var2 = 0.0F;

         for (LivingEntity var4 : var1) {
            if (var4 != null && var4 != mc.player) {
               var2 = Math.max(var2, method04421(var0, var4, var4.getBoundingBox()));
            }
         }

         return var2;
      } else {
         return 0.0F;
      }
   }

   public static AABB method04400(BlockPos var0) {
      return new AABB(
         var0.getX() - field09783, var0.getY() + 1.0, var0.getZ() - field09784, var0.getX() + field09785, var0.getY() + field09786, var0.getZ() + field09787
      );
   }

   private static float method04401(Vec3 var0, Entity var1, AABB var2, float var3, double var4) {
      double var6 = method04410(var2).distanceTo(var0);
      if (var6 > var4) {
         return 0.0F;
      }

      double var8 = var3 >= 0.0F ? var3 : method04403(var0, var2, var1);
      double var10 = (1.0 - var6 / var4) * var8;
      return (float)((var10 * var10 + var10) / field09830 * field09831 * var4 + 1.0);
   }

   private static boolean method04402(Vec3 var0, Vec3 var1, AABB var2, List<BlockPos> var3) {
      if (var2 != null && var2.clip(var0, var1).isPresent()) {
         return false;
      }

      Vec3 var4 = var0;

      for (int var5 = 0; var5 <= var3.size(); var5++) {
         BlockPos var6 = CollisionBlockView.field25700.rayBlock(var4, var1, field09769);
         if (var6 == null) {
            return true;
         }

         if (!var3.contains(var6)) {
            return false;
         }

         Vec3 var7 = method04383(var4, var1, var6);
         if (var7 == null) {
            return true;
         }

         var4 = var7;
      }

      return false;
   }

   public static float method04403(Vec3 var0, AABB var1, Entity var2) {
      int var3 = mc.player == null ? field09818 : mc.player.tickCount;
      if (var3 != field09779) {
         field09778.clear();
         field09779 = var3;
      }

      ExplosionDamageUtils.Nested133 var4 = new ExplosionDamageUtils.Nested133(
         var2.getId(), (long)Math.floor(var0.x / 1.0), (long)Math.floor(var0.y / 1.0), (long)Math.floor(var0.z / 1.0), var1
      );
      Float var5 = field09778.get(var4);
      if (var5 != null) {
         return var5;
      }

      float var6 = method04419(var0, var1, null, List.of());
      field09778.put(var4, var6);
      return var6;
   }

   public static Vec3 method04404(Entity var0, Vec3 var1, float var2) {
      Vec3 var3 = method04364(var0, var1, var2);
      return var3 != null ? var3 : var0.position().add(method04413(), field09789 + method04413(), method04413());
   }

   public static float method04405(Vec3 var0, Entity var1, BlockPos var2) {
      AABB var3 = var1.getBoundingBox();
      float var4 = var2 == null ? field09827 : method04419(var0, var3, new AABB(var2).deflate(field09828), List.of());
      return method04401(var0, var1, var3, var4, field09829);
   }

   public static boolean method04406(BlockState var0) {
      return var0.is(Blocks.OBSIDIAN) || var0.is(Blocks.BEDROCK);
   }

   public static boolean method04407(BlockPos var0, Vec3 var1, float var2, List<BlockPos> var3) {
      return method04417(var0, var1, var2, var3).aim() != null;
   }

   private static float method04408(LivingEntity var0, float var1) {
      return var1 * (1.0F - method04372(var0) / field09837);
   }

   public static void method04409(boolean var0) {
      field09780 = var0;
   }

   public static Vec3 method04410(AABB var0) {
      return new Vec3((var0.minX + var0.maxX) / field09803, var0.minY, (var0.minZ + var0.maxZ) / field09804);
   }

   public static boolean method04411(BlockPos var0, Vec3 var1, float var2) {
      return method04407(var0, var1, var2, List.of());
   }

   public static Vec3 method04412(BlockPos var0, Vec3 var1) {
      return new Vec3(
         Mth.clamp(var1.x, var0.getX() + field09792, var0.getX() + 1.0 - field09793) + method04413(),
         Mth.clamp(var1.y, var0.getY() + field09794, var0.getY() + 1.0 - field09795) + method04413(),
         Mth.clamp(var1.z, var0.getZ() + field09796, var0.getZ() + 1.0 - field09797) + method04413()
      );
   }

   private static double method04413() {
      return GuiHitTestUtils.method05613(field09798, field09799);
   }

   private static boolean method04414(Vec3 var0, boolean var1) {
      return var1 ? BlockPlacementManager.method07907(var0) : GuiHitTestUtils.method05608(var0);
   }

   private static double method04415(double var0, double var2, double var4, double var6) {
      if (var2 > field09825) {
         double var8 = var6 / var2;
         if (var8 >= 0.0 && var8 < var0) {
            return var8;
         }
      } else if (var2 < field09826) {
         double var10 = var4 / var2;
         if (var10 >= 0.0 && var10 < var0) {
            return var10;
         }
      }

      return var0;
   }

   public static float method04416(Vec3 var0, LivingEntity var1, AABB var2, float var3, double var4) {
      if (var1 == null || var2 == null || mc.level == null) {
         return 0.0F;
      }

      if (var1.isDeadOrDying()) {
         return 0.0F;
      }

      float var6 = method04401(var0, var1, var2, var3, var4);
      if (var6 <= 0.0F) {
         return 0.0F;
      }

      if (var1 instanceof Player && !field09780) {
         var6 = method04370(var6);
      }

      var6 = method04397(var1, var6);
      var6 = method04408(var1, var6);
      var6 = method04392(var1, var6);
      return Math.max(0.0F, var6);
   }

   private static ExplosionDamageUtils.Nested131 method04417(BlockPos var0, Vec3 var1, float var2, List<BlockPos> var3) {
      double var4 = var2 * var2;
      BlockPos var6 = null;
      double var7 = field09814;

      for (Direction var12 : Direction.values()) {
         BlockPos var13 = var0.relative(var12);
         if (var3.contains(var13) || mc.level.getBlockState(var13).canBeReplaced()) {
            for (double var17 : field09772) {
               for (double var22 : field09772) {
                  Vec3 var24 = method04391(field09773, var0, var12, var17, var22);
                  double var25 = var1.distanceToSqr(var24);
                  if (!(var25 > var4)) {
                     BlockPos var27 = method04389(var1, var24, var0, var3);
                     if (var27 == null) {
                        return new ExplosionDamageUtils.Nested131(var24, null);
                     }

                     if (var25 < var7) {
                        var7 = var25;
                        var6 = var27;
                     }
                  }
               }
            }
         }
      }

      return new ExplosionDamageUtils.Nested131(null, var6);
   }

   public static double method04418(Vec3 var0, AABB var1) {
      return var0.distanceToSqr(Mth.clamp(var0.x, var1.minX, var1.maxX), Mth.clamp(var0.y, var1.minY, var1.maxY), Mth.clamp(var0.z, var1.minZ, var1.maxZ));
   }

   private static float method04419(Vec3 var0, AABB var1, AABB var2, List<BlockPos> var3) {
      double var4 = 1.0 / ((var1.maxX - var1.minX) * field09819 + 1.0);
      double var6 = 1.0 / ((var1.maxY - var1.minY) * field09820 + 1.0);
      double var8 = 1.0 / ((var1.maxZ - var1.minZ) * field09821 + 1.0);
      double var10 = (1.0 - Math.floor(1.0 / var4) * var4) / field09822;
      double var12 = (1.0 - Math.floor(1.0 / var8) * var8) / field09823;
      if (!(var4 < 0.0) && !(var6 < 0.0) && !(var8 < 0.0)) {
         int var14 = 0;
         int var15 = 0;

         for (double var16 = 0.0; var16 <= 1.0; var16 += var4) {
            for (double var18 = 0.0; var18 <= 1.0; var18 += var6) {
               for (double var20 = 0.0; var20 <= 1.0; var20 += var8) {
                  Vec3 var22 = new Vec3(
                     Mth.lerp(var16, var1.minX, var1.maxX) + var10, Mth.lerp(var18, var1.minY, var1.maxY), Mth.lerp(var20, var1.minZ, var1.maxZ) + var12
                  );
                  if (method04402(var22, var0, var2, var3)) {
                     var14++;
                  }

                  var15++;
               }
            }
         }

         return var15 == 0 ? 0.0F : (float)var14 / var15;
      } else {
         return 0.0F;
      }
   }

   public static ExplosionDamageUtils.Nested134 method04420(BlockPos var0, Vec3 var1, float var2) {
      return method04385(var0, var1, var2, false);
   }

   public static float method04421(Vec3 var0, LivingEntity var1, AABB var2) {
      return method04390(var0, var1, var2, field09815);
   }

   public static boolean method04422(Vec3 var0, Vec3 var1, Direction var2) {
      Vec3 var3 = var0.subtract(var1);
      double var4 = var3.length();
      return var4 < field09810 ? false : var3.dot(new Vec3(var2.getStepX(), var2.getStepY(), var2.getStepZ())) / var4 >= field09811;
   }

   public static float method04423(Vec3 var0, LivingEntity var1, AABB var2, BlockPos var3, BlockPos var4) {
      if (var3 == null && var4 == null) {
         return method04421(var0, var1, var2);
      }

      AABB var5 = var3 == null ? null : new AABB(var3).deflate(field09817);
      List<BlockPos> var6 = var4 == null ? List.of() : List.of(var4);
      return method04390(var0, var1, var2, method04419(var0, var2, var5, var6));
   }

   // $VF: Compiled from s
   private record Nested131(Vec3 aim, BlockPos occluder) {
   }

   // $VF: Compiled from s
   public record Nested132(boolean visible, BlockPos occluder) {
   }

   // $VF: Compiled from s
   private record Nested133(int entityId, long field09850, long field09851, long field09852, AABB box) {
   }

   // $VF: Compiled from s
   public record Nested134(BlockPos neighbor, Direction side, Vec3 aim) {
   }

   // $VF: Compiled from s
   private record Nested135(ExplosionDamageUtils.Nested134 face, BlockPos occluder) {
   }
}
