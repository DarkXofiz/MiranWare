// Original binary: sg/ec/f2H9KrMkuQsXXj65
package sg.ec;

import java.util.Arrays;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import org.joml.Vector2f;

// $VF: Compiled from s
public enum BlockPlacementManager implements MinecraftAccess {
   INSTANCE;

   public static final double[] field18776 = new double[]{1.62, 1.27, 0.4};
   private static final double[] field18777 = new double[0];
   public static final double field18778 = 6.0;
   public static final double field18779 = 0;
   private static final int field18780 = 0;
   public static final double field18781 = 0;
   public static final double field18782 = 0;
   public static final float field18783 = 0;
   public static final double field18784 = 0;
   private static final double field18785 = 0;
   private static final double[] field18786 = new double[]{0.5, 0.1, 0.9, 0.3, 0.7};
   private static final int field18787 = 0;
   private static final int field18788 = 0;
   private static final Vec3 field18789 = new Vec3(0.0, 1.0, 0.0);
   private final Vec3[] field18790 = new Vec3[4];
   private final Vec3[] field18791 = new Vec3[4];
   private final Vec3[] field18792 = new Vec3[4];
   private int field18793 = Integer.MIN_VALUE;
   private boolean field18794;
   private final BlockPlacementManager.Nested231 field18795 = new BlockPlacementManager.Nested231();

   public void method07887() {
      EventBus.method00263(this);
   }

   public static boolean method07888() {
      return INSTANCE.method07911();
   }

   @Subscribe
   private void method07889(PostMovementPacketEvent var1) {
      if (mc.player != null) {
         this.field18795.method07942(mc.player.getYRot(), mc.player.getXRot());
      }
   }

   @Subscribe
   private void method07890(AttackEntityEvent var1) {
      if (var1.method09431() == AttackEntityEvent.Nested264.POST) {
         this.field18795.method07941();
      }
   }

   public static float method07891(float var0) {
      return method07888() ? INSTANCE.field18795.method07939(var0) : RandomUtils.method10442();
   }

   public static float method07892() {
      return method07888() ? 0.0F : RandomUtils.method10442();
   }

   public static boolean method07893() {
      return INSTANCE.field18795.method07940();
   }

   public static boolean method07894() {
      CrystalAura var0 = ModuleManager.INSTANCE.method08206();
      return var0 != null && var0.method03937() && var0.method07473();
   }

   public static List<Vec3> method07895() {
      if (mc.player == null) {
         return List.of();
      }

      int var0 = INSTANCE.method07913(INSTANCE.field18792, field18776);
      return Arrays.asList(INSTANCE.field18792).subList(0, var0);
   }

   public static boolean method07896(Vec3 var0) {
      return mc.player != null && var0 != null ? mc.player.position().distanceToSqr(var0) <= 22.090000000000003 : false;
   }

   public static boolean method07897() {
      return mc.player == null
         ? false
         : EnchantmentUtils.method06757(AutoTool.method08998(Blocks.OBSIDIAN.defaultBlockState()), Enchantments.EFFICIENCY) >= 4;
   }

   public static BlockHitResult method07898(BlockPos var0, Direction var1) {
      return INSTANCE.method07920(var0, var1);
   }

   public static BlockHitResult method07899(BlockPos var0) {
      return INSTANCE.method07914(var0, null);
   }

   public static BlockHitResult method07900(BlockPos var0, Direction var1) {
      return INSTANCE.method07914(var0, var1);
   }

   public static Vector2f method07901(BlockPos var0, Direction var1, Vec3 var2) {
      return INSTANCE.method07921(var0, var1, var2);
   }

   public static Vector2f method07902(BlockPos var0, double var1) {
      return INSTANCE.method07925(var0, var1, false);
   }

   public static Vector2f method07903(BlockPos var0, double var1, boolean var3) {
      return INSTANCE.method07925(var0, var1, var3);
   }

   public static BlockPlacementManager.Nested232 method07904(BlockPos var0, double var1) {
      return INSTANCE.method07922(var0, var1, false);
   }

   public static BlockPlacementManager.Nested232 method07905(BlockPos var0, double var1, boolean var3) {
      return INSTANCE.method07922(var0, var1, var3);
   }

   public static Vec3 method07906(BlockPos var0) {
      return INSTANCE.method07929(var0);
   }

   public static boolean method07907(Vec3 var0) {
      return mc.player != null && mc.level != null && var0 != null ? INSTANCE.method07930(var0) : false;
   }

   public static Vector2f method07908(Entity var0, Vec3 var1, double var2) {
      return INSTANCE.method07932(var0, var1, var2);
   }

   public static boolean method07909(Entity var0, double var1) {
      return mc.player != null && var0 != null ? INSTANCE.method07931(var0, mc.player.getYRot(), mc.player.getXRot(), var1) : false;
   }

   public static Vector2f method07910(Vector2f var0) {
      if (var0 == null) {
         return null;
      } else {
         float var1 = RotationMath.method11345();
         float var2 = RotationManager.method06563();
         float var3 = RotationManager.method06557();
         if (!(var1 <= 0.0F) && !Float.isNaN(var2) && !Float.isNaN(var3)) {
            var0.x = var2 + Math.round(Mth.wrapDegrees(var0.x - var2) / var1) * var1;
            var0.y = Mth.clamp(var3 + Math.round((var0.y - var3) / var1) * var1, -90.0F, 90.0F);
            return var0;
         } else {
            return var0;
         }
      }
   }

   private boolean method07911() {
      this.method07912();
      return this.field18794;
   }

   private void method07912() {
      if (mc.player == null) {
         this.field18794 = false;
      } else {
         int var1 = mc.player.tickCount;
         if (var1 != this.field18793) {
            this.field18793 = var1;
            CrystalAura var2 = ModuleManager.INSTANCE.method08206();
            this.field18794 = var2 != null && var2.method03937() && var2.method07458();
         }
      }
   }

   private int method07913(Vec3[] var1, double[] var2) {
      Vec3 var3 = mc.player.getEyePosition();
      var1[0] = var3;
      Vec3 var4 = mc.player.position();
      int var5 = 1;

      for (double var9 : var2) {
         if (!(Math.abs(var4.y + var9 - var3.y) < 1.0E-4)) {
            var1[var5++] = new Vec3(var4.x, var4.y + var9, var4.z);
         }
      }

      return var5;
   }

   private BlockHitResult method07914(BlockPos var1, Direction var2) {
      if (mc.player != null && mc.level != null && var1 != null) {
         Vec3 var3 = mc.player.getEyePosition();
         Vec3 var4 = RaycastUtils.method09509(mc.player.getXRot(), mc.player.getYRot()).scale(6.0);
         BlockHitResult var5 = this.method07934(var3, var3.add(var4));
         if (var5.getType() != Type.BLOCK) {
            return null;
         } else if (!var5.getBlockPos().equals(var1)) {
            return null;
         } else {
            return var2 != null && var5.getDirection() != var2 ? null : var5;
         }
      } else {
         return null;
      }
   }

   public static boolean method07915(BlockPos var0) {
      return INSTANCE.method07914(var0, null) != null;
   }

   public static boolean method07916(BlockPos var0, double var1) {
      if (mc.player != null && mc.level != null && var0 != null) {
         Vec3 var3 = mc.player.getEyePosition();
         Vec3 var4 = Vec3.atCenterOf(var0);
         if (var3.distanceToSqr(var4) > var1 * var1) {
            return false;
         }

         BlockHitResult var5 = INSTANCE.method07934(var3, var4);
         return var5.getType() == Type.BLOCK && var5.getBlockPos().equals(var0);
      } else {
         return false;
      }
   }

   public static boolean method07917(BlockPos var0, double var1) {
      if (mc.player != null && mc.level != null && var0 != null) {
         Vec3 var3 = mc.player.getEyePosition();
         double var4 = var1 * var1;

         for (Direction var9 : Direction.values()) {
            Vec3 var10 = new Vec3(
               var0.getX() + 0.5 + var9.getStepX() * 0.5, var0.getY() + 0.5 + var9.getStepY() * 0.5, var0.getZ() + 0.5 + var9.getStepZ() * 0.5
            );
            if (!(var3.distanceToSqr(var10) > var4)) {
               BlockHitResult var11 = INSTANCE.method07934(var3, var10);
               if (var11.getType() == Type.BLOCK && var11.getBlockPos().equals(var0)) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean method07918(BlockPos var0, Direction var1) {
      return INSTANCE.method07914(var0, var1) != null;
   }

   public static String method07919(BlockPos var0, Direction var1) {
      if (mc.player != null && mc.level != null) {
         Vec3 var2 = mc.player.getEyePosition();
         Vec3 var3 = RaycastUtils.method09509(mc.player.getXRot(), mc.player.getYRot()).scale(6.0);
         BlockHitResult var4 = INSTANCE.method07934(var2, var2.add(var3));
         String var5 = var4.getType() != Type.BLOCK ? "воздух" : var4.getBlockPos().toShortString() + "/" + var4.getDirection();
         return "лучВ[" + var5 + "] надо[" + var0.toShortString() + "/" + var1 + "]";
      } else {
         return "нетИгрока";
      }
   }

   private BlockHitResult method07920(BlockPos var1, Direction var2) {
      if (mc.player != null && mc.level != null && var1 != null) {
         Vec3 var3 = RaycastUtils.method09509(mc.player.getXRot(), mc.player.getYRot()).scale(6.0);
         int var4 = this.method07913(this.field18790, field18777);

         for (int var5 = 0; var5 < var4; var5++) {
            Vec3 var6 = this.field18790[var5];
            BlockHitResult var7 = this.method07934(var6, var6.add(var3));
            if (var7.getType() == Type.BLOCK && var7.getBlockPos().equals(var1) && (var2 == null || var7.getDirection() == var2)) {
               return var7;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private Vector2f method07921(BlockPos var1, Direction var2, Vec3 var3) {
      if (mc.player != null && mc.level != null && var1 != null && var3 != null) {
         int var4 = this.method07913(this.field18791, field18777);

         for (int var5 = 0; var5 < var4; var5++) {
            Vec3 var6 = this.field18791[var5];
            Vector2f var7 = method07910(PlayerUtils.method11816(var6, var3));
            Vec3 var8 = RaycastUtils.method09509(var7.y, var7.x);
            BlockHitResult var9 = this.method07934(var6, var6.add(var8.scale(6.0)));
            if (var9.getType() == Type.BLOCK && var9.getBlockPos().equals(var1) && (var2 == null || var9.getDirection() == var2)) {
               return var7;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private BlockPlacementManager.Nested232 method07922(BlockPos var1, double var2, boolean var4) {
      if (mc.player != null && mc.level != null && var1 != null) {
         Vec3 var5 = mc.player.getEyePosition();
         int var6 = this.method07913(this.field18790, field18777);
         BlockPlacementManager.Nested232 var7 = null;
         BlockPlacementManager.Nested232 var8 = null;
         double var9 = Double.MAX_VALUE;
         double var11 = Double.MAX_VALUE;

         for (Direction var16 : Direction.values()) {
            BlockPos var17 = var1.relative(var16.getOpposite());
            BlockState var18 = mc.level.getBlockState(var17);
            if (!var18.canBeReplaced() && ExplosionDamageUtils.method04369(var18, var17, var16)) {
               Vec3 var19 = this.method07926(var17, var16);
               double var20 = var5.distanceToSqr(var19);
               if (!(var20 > var2 * var2)) {
                  BlockPlacementManager.Nested232 var22 = var20 < var9 ? this.method07923(var17, var16, var6, var2) : null;
                  if (var22 != null) {
                     var9 = var20;
                     var7 = var22;
                  } else if (var20 < var11 && var4 && ExplosionDamageUtils.method04422(var5, var19, var16)) {
                     var11 = var20;
                     var8 = new BlockPlacementManager.Nested232(method07910(PlayerUtils.method11816(var5, var19)), var17, var16, var19);
                  }
               }
            }
         }

         return var7 != null ? var7 : var8;
      } else {
         return null;
      }
   }

   private BlockPlacementManager.Nested232 method07923(BlockPos var1, Direction var2, int var3, double var4) {
      Vec3 var6 = mc.player.getEyePosition();

      for (double var10 : field18786) {
         for (double var15 : field18786) {
            Vec3 var17 = this.method07927(var1, var2, var10, var15);
            if (!(var6.distanceToSqr(var17) > var4 * var4)) {
               for (int var18 = 0; var18 < var3; var18++) {
                  Vec3 var19 = this.field18790[var18];
                  Vector2f var20 = method07910(PlayerUtils.method11816(var19, var17));
                  Vec3 var21 = RaycastUtils.method09509(var20.y, var20.x);
                  BlockHitResult var22 = this.method07934(var19, var19.add(var21.scale(6.0)));
                  if (var22.getType() == Type.BLOCK && var22.getBlockPos().equals(var1) && var22.getDirection() == var2) {
                     return new BlockPlacementManager.Nested232(var20, var1, var2, var22.getLocation());
                  }
               }
            }
         }
      }

      return null;
   }

   private Vector2f method07924(BlockPos var1, Direction var2, double var3) {
      Vec3 var5 = mc.player.getEyePosition();

      for (double var9 : field18786) {
         for (double var14 : field18786) {
            Vec3 var16 = this.method07927(var1, var2, var9, var14);
            if (!(var5.distanceToSqr(var16) > var3 * var3)) {
               Vector2f var17 = this.method07921(var1, var2, var16);
               if (var17 != null) {
                  return var17;
               }
            }
         }
      }

      return null;
   }

   private Vector2f method07925(BlockPos var1, double var2, boolean var4) {
      if (mc.player != null && mc.level != null && var1 != null) {
         Vec3 var5 = mc.player.getEyePosition();
         Vector2f var6 = null;
         Vector2f var7 = null;
         double var8 = Double.MAX_VALUE;
         double var10 = Double.MAX_VALUE;

         for (Direction var15 : Direction.values()) {
            Vec3 var16 = this.method07926(var1, var15);
            double var17 = var5.distanceToSqr(var16);
            if (!(var17 > var2 * var2)) {
               Vector2f var19 = var17 < var8 ? this.method07924(var1, var15, var2) : null;
               if (var19 != null) {
                  var8 = var17;
                  var6 = var19;
               } else if (var17 < var10 && var4 && ExplosionDamageUtils.method04422(var5, var16, var15)) {
                  var10 = var17;
                  var7 = method07910(PlayerUtils.method11816(var5, var16));
               }
            }
         }

         return var6 != null ? var6 : var7;
      } else {
         return null;
      }
   }

   private Vec3 method07926(BlockPos var1, Direction var2) {
      return this.method07927(var1, var2, 0.5, 0.5);
   }

   private Vec3 method07927(BlockPos var1, Direction var2, double var3, double var5) {
      Axis var7 = var2.getAxis();
      double var8 = var1.getX() + 0.5 + var2.getStepX() * 0.5;
      double var10 = var1.getY() + 0.5 + var2.getStepY() * 0.5;
      double var12 = var1.getZ() + 0.5 + var2.getStepZ() * 0.5;
      if (var7 != Axis.X) {
         var8 += method07928(var3);
      }

      if (var7 != Axis.Y) {
         var10 += method07928(var7 == Axis.X ? var3 : var5);
      }

      if (var7 != Axis.Z) {
         var12 += method07928(var5);
      }

      return new Vec3(var8, var10, var12);
   }

   private static double method07928(double var0) {
      float var2 = (float)Math.min(0.2F, 0.5 - Math.abs(var0 - 0.5) - 0.05);
      return var0 - 0.5 + GuiHitTestUtils.method05613(-var2, var2);
   }

   private Vec3 method07929(BlockPos var1) {
      Vec3 var2 = mc.player.getEyePosition();
      Vec3 var3 = Vec3.atCenterOf(var1);
      Vec3 var4 = var3.subtract(var2);
      double var5 = var4.length();
      if (var5 < 1.0E-4) {
         return var3;
      }

      var4 = var4.scale(1.0 / var5);
      Vec3 var7 = var4.cross(field18789);
      if (var7.lengthSqr() < 1.0E-6) {
         var7 = new Vec3(1.0, 0.0, 0.0);
      }

      var7 = var7.normalize();
      Vec3 var8 = var7.cross(var4).normalize();
      double var9 = Math.min(0.36, Math.tan(Math.toRadians(3.0)) * var5);
      double var11 = GuiHitTestUtils.method05613(0.0F, (float) (Math.PI * 2));
      return var3.add(var7.scale(Math.cos(var11) * var9)).add(var8.scale(Math.sin(var11) * var9));
   }

   private boolean method07930(Vec3 var1) {
      int var2 = this.method07913(this.field18792, field18776);

      for (int var3 = 0; var3 < var2; var3++) {
         if (this.method07933(this.field18792[var3], var1)) {
            return true;
         }
      }

      return false;
   }

   private boolean method07931(Entity var1, float var2, float var3, double var4) {
      int var6 = this.method07913(this.field18792, field18776);

      for (int var7 = 0; var7 < var6; var7++) {
         if (RaycastUtils.method09499(this.field18792[var7], var2, var3, var4, true, var1.getBoundingBox())) {
            return true;
         }
      }

      return false;
   }

   private Vector2f method07932(Entity var1, Vec3 var2, double var3) {
      if (mc.player != null && mc.level != null && var1 != null && var2 != null) {
         int var5 = this.method07913(this.field18792, field18776);

         for (int var6 = 0; var6 < var5; var6++) {
            Vec3 var7 = this.field18792[var6];
            Vector2f var8 = method07910(PlayerUtils.method11816(var7, var2));
            if (RaycastUtils.method09499(var7, var8.x, var8.y, var3, true, var1.getBoundingBox())) {
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private boolean method07933(Vec3 var1, Vec3 var2) {
      return this.method07934(var1, var2).getType() == Type.MISS;
   }

   private BlockHitResult method07934(Vec3 var1, Vec3 var2) {
      BlockHitResult var3 = this.method07935(var1, var2);

      for (int var4 = 0; var4 < 4 && var3.getType() == Type.BLOCK && var3.isInside(); var4++) {
         Vec3 var5 = ExplosionDamageUtils.method04383(var1, var2, var3.getBlockPos());
         if (var5 == null) {
            break;
         }

         var1 = var5;
         var3 = this.method07935(var1, var2);
      }

      return var3;
   }

   private BlockHitResult method07935(Vec3 var1, Vec3 var2) {
      return mc.level.clip(new ClipContext(var1, var2, Block.OUTLINE, Fluid.NONE, mc.player));
   }

   // $VF: Compiled from s
   private static final class Nested231 {
      private static final int field18796 = 20;
      private static final int field18797 = 0;
      private static final float field18798 = 0;
      private static final float field18799 = 0;
      private static final float field18800 = 0;
      private static final int field18801 = 0;
      private static final float field18802 = 0;
      private static final float field18803 = 0;
      private static final float field18804 = 0;
      private static final long field18805 = 0;
      private static final float field18806 = 0;
      private static final float field18807 = 0;
      private static final float field18808 = 0;
      private final float[] field18809 = new float[20];
      private final float[] field18810 = new float[20];
      private int field18811;
      private float field18812 = Float.NaN;
      private float field18813;
      private float field18814;
      private float field18815;
      private int field18816;
      private int field18817;
      private long field18818;
      private float field18819;
      private static final long field18820 = -4611686018427387904L;
      private static final float field18821 = 20.0F;
      private static final float field18822 = 1.5F;
      private static final float field18823 = 5.0F;
      private static final float field18824 = 5.0F;
      private static final long field18825 = 350L;
      private static final float field18826 = 8.0F;
      private static final float field18827 = 50.0F;
      private static final float field18828 = 6.0F;
      private static final float field18829 = 45.0F;
      private static final float field18830 = 30.0F;
      private static final float field18831 = 8.0F;
      private static final float field18832 = 40.0F;
      private static final float field18833 = -12.3F;
      private static final float field18834 = 12.3F;
      private static final float field18835 = 24.6F;
      private static final float field18836 = 6.0F;

      private static float method07936(float[] var0) {
         float var1 = method07937(var0);
         float sx = 0.0F;

         for (float sxx : var0) {
            sx += (sxx - var1) * (sxx - var1);
         }

         return (float)Math.sqrt(sx);
      }

      private static float method07937(float[] var0) {
         float var1 = 0.0F;

         for (float var5 : var0) {
            var1 += var5;
         }

         return var1 / var0.length;
      }

      private static void method07938(float[] var0, float var1) {
         System.arraycopy(var0, 1, var0, 0, var0.length - 1);
         var0[var0.length - 1] = var1;
      }

      private Nested231() {
         this.field18818 = field18820;
      }

      float method07939(float var1) {
         if (this.field18816 >= 5 && !Float.isNaN(this.field18812)) {
            float var2 = 0.0F;
            float var3 = 0.0F;

            for (float var4 = field18833; var4 <= field18834; var4 += field18835) {
               float var5 = Math.abs(Mth.wrapDegrees(var1 + var4 - this.field18812));
               float var6 = Math.abs(var5 - this.field18814);
               if (var6 > var3) {
                  var3 = var6;
                  var2 = var4;
               }
            }

            return var3 >= field18836 ? var2 : 0.0F;
         } else {
            return 0.0F;
         }
      }

      boolean method07940() {
         return this.field18819 + field18831 <= field18832;
      }

      void method07941() {
         this.field18817 = 15;
         long var1 = System.currentTimeMillis() - this.field18818;
         if (var1 <= field18825) {
            this.field18819 = this.field18819 + (field18826 - Math.round((float)var1 / field18827));
         } else {
            this.field18819 = Math.max(0.0F, this.field18819 - field18828);
         }

         if (this.field18819 > field18829) {
            this.field18819 = Math.max(0.0F, this.field18819 - field18830);
         }
      }

      void method07942(float var1, float var2) {
         if (Float.isNaN(this.field18812)) {
            this.field18812 = var1;
            this.field18813 = var2;
         } else {
            if (this.field18817 > 0) {
               this.field18817--;
            }

            if (var1 != this.field18812 || var2 != this.field18813) {
               float var3 = Math.abs(Mth.wrapDegrees(var1 - this.field18812));
               float var4 = Math.abs(var2 - this.field18813);
               if (var4 > field18821) {
                  this.field18818 = System.currentTimeMillis();
               }

               method07938(this.field18809, Math.abs(var3 - this.field18814));
               method07938(this.field18810, Math.abs(var4 - this.field18815));
               if (this.field18811 < 20) {
                  this.field18811++;
               }

               if (this.field18811 >= 20 && this.field18817 > 0) {
                  boolean var5 = var3 < field18822;
                  boolean var6 = method07937(this.field18809) < 1.0F || method07937(this.field18810) < 1.0F && !var5;
                  boolean var7 = method07936(this.field18809) < field18823 && method07936(this.field18810) > field18824 && !var5;
                  this.field18816 = var6 && var7 ? this.field18816 + 1 : Math.max(0, this.field18816 - 1);
               }

               this.field18814 = var3;
               this.field18815 = var4;
               this.field18812 = var1;
               this.field18813 = var2;
            }
         }
      }
   }

   // $VF: Compiled from s
   public record Nested232(Vector2f rotation, BlockPos neighbor, Direction side, Vec3 aim) {
   }
}
