// Original binary: sg/ec/CH7xOSrHteA3FQE2
package sg.ec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Plane;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class CrystalPlacementEvaluator implements MinecraftAccess {
   private static List<CrystalPlacementEvaluator.Nested78> field06710 = List.of();
   private static final float field06711 = 400.0F;
   private static final float field06712 = 0;
   private static final CrystalPlacementEvaluator.Nested85 field06713 = new CrystalPlacementEvaluator.Nested85(
      CrystalPlacementEvaluator.Nested84.AWAIT, null, null, null, 0.0F, 0.0F, null
   );
   private static final ExplosionDamageUtils.Nested132 field06714 = new ExplosionDamageUtils.Nested132(true, null);
   private static final float field06715 = 0;
   private static final int field06716 = 0;
   private static final float field06717 = 0;
   private static final int field06718 = 0;
   private static final float field06719 = 0;
   private static final float field06720 = 0;
   private static final float field06721 = 0;
   private static final float field06722 = 0;
   private static final float field06723 = 0;
   private static final float field06724 = 0;
   private static final float field06725 = 0;
   private static final float field06726 = 0;
   private static final float field06727 = 0;
   private static final double field06728 = 0;
   private static final float field06729 = 0;
   private static final int field06730 = 0;
   private static final float field06731 = -Float.MAX_VALUE;
   private static final float field06732 = 3.0F;
   private static final float field06733 = 1000.0F;
   private static final double field06734 = 0.08;
   private static final double field06735 = 0.5;
   private static final float field06736 = 1.15F;

   public static CrystalPlacementEvaluator.Nested85 method02906(Player var0, AABB var1, Vec3 var2, CrystalPlacementEvaluator.Nested86 var3) {
      return method02924(var0, var1, var2, var3, null);
   }

   public static boolean method02907(float var0, float var1, CrystalPlacementEvaluator.Nested86 var2, BlockPos var3) {
      boolean var4 = var3 != null && var3.equals(var2.committedBase());
      return method02913(var0, var4 ? var1 * field06736 : var1, var2);
   }

   private static CrystalPlacementEvaluator.Nested82 method02908(BlockPos var0) {
      CrystalPlacementEvaluator.Nested82 var1 = CrystalPlacementEvaluator.Nested82.FREE;

      for (Entity var3 : mc.level.getEntitiesOfClass(Entity.class, ExplosionDamageUtils.method04396(var0), ExplosionDamageUtils::method04380)) {
         if (!(var3 instanceof ItemEntity var4) || var4.onGround()) {
            return CrystalPlacementEvaluator.Nested82.BLOCKED;
         }

         var1 = CrystalPlacementEvaluator.Nested82.FALLING_ITEM;
      }

      return var1;
   }

   private static ItemEntity method02909(BlockPos var0) {
      return method02911(ExplosionDamageUtils.method04396(var0));
   }

   public static float method02910(float var0, float var1, LivingEntity var2, AABB var3, Vec3 var4) {
      float var5 = var0 - 2.0F * var1;
      if (method02919(var4, var2, var3)) {
         var5 -= field06732;
      }

      return method02925(var0, var2) ? var5 + field06733 : var5;
   }

   private static ItemEntity method02911(AABB var0) {
      ItemEntity var1 = null;

      for (Entity var3 : mc.level.getEntitiesOfClass(Entity.class, var0, ExplosionDamageUtils::method04380)) {
         if (!(var3 instanceof ItemEntity var4)) {
            return null;
         }

         if (var4.onGround()) {
            var1 = var4;
         }
      }

      return var1;
   }

   public static boolean method02913(float var0, float var1, CrystalPlacementEvaluator.Nested86 var2) {
      return var0 >= var2.selfHealthLimit() ? false : var0 <= var2.maxSelfDamage() || var0 < var1;
   }

   private static int method02914(BlockPos var0) {
      return mc.level.getFluidState(var0).getAmount();
   }

   private static void method02915(List<CrystalPlacementEvaluator.Nested79> var0, BlockPos var1, CrystalPlacementEvaluator.Nested76 var2, float var3, float var4, float var5) {
      if (var0 != null) {
         var0.add(new CrystalPlacementEvaluator.Nested79(var1, CrystalPlacementEvaluator.Nested84.EXPLODE, var2, var3, var4, var5));
      }
   }

   private static boolean method02916(BlockPos var0, List<BlockPos> var1, BlockPos var2, boolean var3) {
      return var1.contains(var0) || var3 && var0.equals(var2);
   }

   private static CrystalPlacementEvaluator.Nested74 method02917(BlockPos var0, List<BlockPos> var1) {
      BlockPos var2 = var0.above();
      boolean var3 = !var1.contains(var2) && mc.level.getBlockState(var2).isAir();
      HashMap var4 = null;
      ArrayDeque var5 = null;

      for (int var6 = 0; var6 < var1.size(); var6++) {
         BlockPos var7 = (BlockPos)var1.get(var6);
         int var8 = method02914(var7);
         BlockPos var9 = var7.above();
         if (!var1.contains(var9) && method02914(var9) > 0) {
            var8 = 8;
         }

         for (Direction var11 : Plane.HORIZONTAL) {
            BlockPos var12 = var7.relative(var11);
            if (!var1.contains(var12)) {
               var8 = Math.max(var8, method02914(var12) - 1);
            }
         }

         if (var8 > 0) {
            if (var4 == null) {
               var4 = new HashMap();
               var5 = new ArrayDeque();
            }

            method02922(var4, var5, var7, var8);
         }
      }

      if (var4 == null) {
         return CrystalPlacementEvaluator.Nested74.DRY;
      }

      while (!var5.isEmpty()) {
         BlockPos var13 = (BlockPos)var5.poll();
         int var14 = (Integer)var4.get(var13);
         BlockPos var15 = var13.below();
         boolean var16 = method02916(var15, var1, var2, var3);
         if (var16) {
            method02922(var4, var5, var15, 8);
         }

         if (!var16 && var14 > 1) {
            for (Direction var18 : Plane.HORIZONTAL) {
               BlockPos var19 = var13.relative(var18);
               if (method02916(var19, var1, var2, var3)) {
                  method02922(var4, var5, var19, var14 - 1);
               }
            }
         }
      }

      return var4.containsKey(var2) ? CrystalPlacementEvaluator.Nested74.CELL : CrystalPlacementEvaluator.Nested74.STREAM;
   }

   private static boolean method02918(BlockPos var0) {
      return !mc.level
         .getEntitiesOfClass(
            Entity.class, ExplosionDamageUtils.method04396(var0), var0x -> ExplosionDamageUtils.method04380(var0x) && !(var0x instanceof ItemEntity)
         )
         .isEmpty();
   }

   private static boolean method02919(Vec3 var0, LivingEntity var1, AABB var2) {
      boolean var3 = !var1.onGround() && var1.getDeltaMovement().y > field06734;
      return var0.y > var2.minY + field06735 && !var3;
   }

   private CrystalPlacementEvaluator() {
   }

   public static CrystalPlacementEvaluator.Nested85 method02920(Player var0, AABB var1, Vec3 var2, CrystalPlacementEvaluator.Nested86 var3, CrystalPlacementEvaluator.Nested80 var4) {
      return method02926(var0, var1, var2, var3, var4, null);
   }

   public static CrystalPlacementEvaluator.Nested85 method02921(
      Player var0, AABB var1, Vec3 var2, CrystalPlacementEvaluator.Nested86 var3, List<CrystalPlacementEvaluator.Nested79> var4, boolean var5
   ) {
      if (mc.player != null && mc.level != null && var0 != null) {
         CrystalPlacementEvaluator.Nested85 var6 = null;
         float var7 = field06731;
         int var8 = -1;
         double var9 = var3.explodeRange() * var3.explodeRange();
         AABB var11 = mc.player.getBoundingBox();

         for (Entity var13 : mc.level.entitiesForRendering()) {
            if (var13 instanceof EndCrystal var14) {
               BlockPos var15 = var14.blockPosition();
               if (ExplosionDamageUtils.method04418(var2, var14.getBoundingBox()) > var9) {
                  method02915(var4, var15, CrystalPlacementEvaluator.Nested76.OUT_OF_REACH, 0.0F, 0.0F, 0.0F);
               } else {
                  boolean var16 = var3.matrixSearch();
                  if (var16 && !BlockPlacementManager.method07896(var14.position())) {
                     method02915(var4, var15, CrystalPlacementEvaluator.Nested76.OUT_OF_REACH, 0.0F, 0.0F, 0.0F);
                  } else if ((var5 || var16) && ExplosionDamageUtils.method04371(var14, var2, var3.explodeRange(), var16) == null) {
                     method02915(var4, var15, CrystalPlacementEvaluator.Nested76.NOT_VISIBLE, 0.0F, 0.0F, 0.0F);
                  } else {
                     Vec3 var17 = var14.position();
                     float var18 = ExplosionDamageUtils.method04421(var17, var0, var1);
                     float var19 = ExplosionDamageUtils.method04421(var17, mc.player, var11);
                     if (var18 < var3.minEnemyDamage()) {
                        method02915(var4, var15, CrystalPlacementEvaluator.Nested76.LOW_DAMAGE, var18, var19, var18 - var19);
                     } else if (!method02907(var19, var18, var3, var15.below())) {
                        method02915(var4, var15, CrystalPlacementEvaluator.Nested76.SELF_DAMAGE, var18, var19, var18 - var19);
                     } else if (ExplosionDamageUtils.method04399(var17, var3.friends()) > var3.maxSelfDamage()) {
                        method02915(var4, var15, CrystalPlacementEvaluator.Nested76.FRIEND_DAMAGE, var18, var19, var18 - var19);
                     } else {
                        float var20 = method02910(var18, var19, var0, var1, var17);
                        method02915(var4, var15, CrystalPlacementEvaluator.Nested76.CANDIDATE, var18, var19, var20);
                        if (!(var20 <= var7)) {
                           var7 = var20;
                           var6 = new CrystalPlacementEvaluator.Nested85(CrystalPlacementEvaluator.Nested84.EXPLODE, var15, null, var14, var18, var19, null);
                           if (var4 != null) {
                              var8 = var4.size() - 1;
                           }
                        }
                     }
                  }
               }
            }
         }

         if (var4 != null && var8 >= 0) {
            CrystalPlacementEvaluator.Nested79 var21 = (CrystalPlacementEvaluator.Nested79)var4.get(var8);
            var4.set(
               var8,
               new CrystalPlacementEvaluator.Nested79(
                  var21.pos(), CrystalPlacementEvaluator.Nested84.EXPLODE, CrystalPlacementEvaluator.Nested76.CHOSEN, var21.enemyDamage(), var21.selfDamage(), var21.score()
               )
            );
         }

         return var6;
      } else {
         return null;
      }
   }

   private static void method02922(Map<BlockPos, Integer> var0, ArrayDeque<BlockPos> var1, BlockPos var2, int var3) {
      Integer var4 = (Integer)var0.get(var2);
      if (var4 == null || var4 < var3) {
         var0.put(var2, var3);
         var1.add(var2);
      }
   }

   public static List<CrystalPlacementEvaluator.Nested78> method02923() {
      return field06710;
   }

   public static CrystalPlacementEvaluator.Nested85 method02924(
      Player var0, AABB var1, Vec3 var2, CrystalPlacementEvaluator.Nested86 var3, List<CrystalPlacementEvaluator.Nested79> var4
   ) {
      return method02921(var0, var1, var2, var3, var4, !var3.explodeThroughWalls());
   }

   private static boolean method02925(float var0, LivingEntity var1) {
      return var0 >= var1.getHealth() + var1.getAbsorptionAmount();
   }

   public static CrystalPlacementEvaluator.Nested85 method02926(
      Player var0, AABB var1, Vec3 var2, CrystalPlacementEvaluator.Nested86 var3, CrystalPlacementEvaluator.Nested80 var4, List<CrystalPlacementEvaluator.Nested79> var5
   ) {
      if (mc.player != null && mc.level != null && var0 != null) {
         CrystalPlacementEvaluator.Nested77 var6 = new CrystalPlacementEvaluator.Nested77(var0, var1, var2, var3, var4, var5);
         int var7 = Mth.ceil(var3.placeRange());
         BlockPos var8 = mc.player.blockPosition();
         MutableBlockPos var9 = new MutableBlockPos();

         for (int var10 = -var7; var10 <= var7; var10++) {
            for (int var11 = -var7; var11 <= var7; var11++) {
               for (int var12 = -var7; var12 <= var7; var12++) {
                  var9.set(var8.getX() + var10, var8.getY() + var12, var8.getZ() + var11);
                  var6.method02940(var9);
               }
            }
         }

         return var6.method02938();
      } else {
         return null;
      }
   }

   // $VF: Compiled from s
   private enum Nested74 {
      DRY,
      STREAM,
      CELL;
   }

   // $VF: Compiled from s
   private static final class Nested75 {
      private final List<BlockPos> field06737;
      private final BlockPos field06738;
      private final float field06739;
      private final boolean field06740;
      private final float field06741;
      private final float field06742;
      private final float field06743;
      private final boolean field06744;
      private final boolean field06745;
      private static final float field06746 = 0.25F;
      private static final float field06747 = 3.0F;
      private static final float field06748 = 3.0F;
      private static final float field06749 = 6.0F;
      private static final float field06750 = 8.0F;

      private float method02927() {
         return this.field06743
            - this.field06739 * field06746
            - field06747 * (this.field06737.size() - 1)
            - (this.field06744 ? field06748 : 0.0F)
            - (this.field06745 ? field06749 : 0.0F)
            + (this.field06740 ? field06750 : 0.0F);
      }

      private Nested75(List<BlockPos> var1, BlockPos var2, float var3, boolean var4, float var5, float var6, float var7, boolean var8, boolean var9) {
         this.field06745 = var9;
         this.field06737 = var1;
         this.field06738 = var2;
         this.field06739 = var3;
         this.field06740 = var4;
         this.field06741 = var5;
         this.field06742 = var6;
         this.field06743 = var7;
         this.field06744 = var8;
      }

      private boolean method02928(CrystalPlacementEvaluator.Nested75 var1) {
         return var1 == null || this.method02927() > var1.method02927();
      }

      private CrystalPlacementEvaluator.Nested78 method02929(boolean var1) {
         return new CrystalPlacementEvaluator.Nested78(this.field06737, this.field06738, this.field06739, this.field06740, this.field06741, this.field06742, var1);
      }

      private CrystalPlacementEvaluator.Nested85 method02930() {
         return new CrystalPlacementEvaluator.Nested85(
            CrystalPlacementEvaluator.Nested84.DIG, this.field06737.get(0), this.field06738, null, this.field06741, this.field06742, null
         );
      }

      private boolean method02931(CrystalPlacementEvaluator.Nested85 var1) {
         return this.field06742 + 2.0F < var1.selfDamage();
      }
   }

   // $VF: Compiled from s
   public enum Nested76 {
      CHOSEN("выбрано"),
      CANDIDATE("кандидат"),
      AWAIT("ждём дроп"),
      OUT_OF_REACH("вне дальности взрыва"),
      LOW_CEILING("потолок урона"),
      NO_SUPPORT("нет опоры"),
      CELL_NOT_AIR("клетка занята блоком"),
      BLOCKED("сущность мешает"),
      NOT_VISIBLE("не видно"),
      NO_FACE("нет грани"),
      CANT_DIG("не выкопать"),
      STALLED("постановка не удалась"),
      UNCONFIRMED("ждём сервер"),
      TARGET_MOVING("цель убежит"),
      ENTITY_ABOVE("кто-то стоит"),
      LOW_DAMAGE("мало урона"),
      SELF_DAMAGE("много себе"),
      FRIEND_DAMAGE("заденет друга"),
      RESERVED("занято другим модулем"),
      FLOODS("зальёт водой");

      public final String field06751;

      Nested76(String var3) {
         this.field06751 = var3;
      }

      public boolean method02932() {
         return this != CHOSEN && this != CANDIDATE && this != AWAIT;
      }
   }

   // $VF: Compiled from s
   private static final class Nested77 {
      private final Player field06752;
      private final AABB field06753;
      private final AABB field06754;
      private final Vec3 field06755;
      private final CrystalPlacementEvaluator.Nested86 field06756;
      private final CrystalPlacementEvaluator.Nested80 field06757;
      private final List<CrystalPlacementEvaluator.Nested79> field06758;
      private final int field06759;
      private final double field06760;
      private final double field06761;
      private final CrystalPlacementEvaluator.Nested81 field06762 = new CrystalPlacementEvaluator.Nested81();
      private final CrystalPlacementEvaluator.Nested81 field06763 = new CrystalPlacementEvaluator.Nested81();
      private final CrystalPlacementEvaluator.Nested81 field06764 = new CrystalPlacementEvaluator.Nested81();
      private final CrystalPlacementEvaluator.Nested81 field06765 = new CrystalPlacementEvaluator.Nested81();
      private final CrystalPlacementEvaluator.Nested81 field06766 = new CrystalPlacementEvaluator.Nested81();
      private final CrystalPlacementEvaluator.Nested83 field06767 = new CrystalPlacementEvaluator.Nested83();
      private ItemEntity field06768;
      private BlockPos field06769;
      private float field06770;
      private boolean field06771;
      private float field06772;
      private CrystalPlacementEvaluator.Nested75 field06773;
      private CrystalPlacementEvaluator.Nested75 field06774;
      private final List<CrystalPlacementEvaluator.Nested75> field06775;
      private static final float field06776 = -Float.MAX_VALUE;
      private static final float field06777 = -Float.MAX_VALUE;
      private static final float field06778 = -Float.MAX_VALUE;
      private static final float field06779 = -Float.MAX_VALUE;
      private static final float field06780 = -Float.MAX_VALUE;
      private static final float field06781 = 3.0F;
      private static final float field06782 = 5.0F;
      private static final float field06783 = 400.0F;

      private void method02933(BlockPos var1, Vec3 var2, boolean var3) {
         if (this.field06756.canPlaceObsidian()) {
            BlockPos var4 = var1.above();
            if (!MinecraftAccess.mc.level.getBlockState(var4).isAir()) {
               this.method02954(var1, CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN, CrystalPlacementEvaluator.Nested76.CELL_NOT_AIR, 0.0F, 0.0F, 0.0F);
            } else if (ExplosionDamageUtils.method04374(var1)) {
               this.method02954(var1, CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN, CrystalPlacementEvaluator.Nested76.BLOCKED, 0.0F, 0.0F, 0.0F);
            } else {
               CrystalPlacementEvaluator.Nested82 sx = CrystalPlacementEvaluator.method02908(var4);
               if (sx == CrystalPlacementEvaluator.Nested82.BLOCKED) {
                  this.method02947(var1, CrystalPlacementEvaluator.method02909(var4), CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN, var2);
               } else {
                  ExplosionDamageUtils.Nested132 sxx = this.method02951(var1);
                  if (!sxx.visible()) {
                     this.method02954(var1, CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN, CrystalPlacementEvaluator.Nested76.NOT_VISIBLE, 0.0F, 0.0F, 0.0F);
                     if (var3) {
                        this.method02949(var1, var2, true, sxx);
                     }
                  } else if (ExplosionDamageUtils.method04385(var1, this.field06755, this.field06756.placeRange(), this.field06756.placeThroughWalls()) == null) {
                     this.method02954(var1, CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN, CrystalPlacementEvaluator.Nested76.NO_FACE, 0.0F, 0.0F, 0.0F);
                     if (var3) {
                        this.method02949(var1, var2, true, sxx);
                     }
                  } else {
                     float sxxx = ExplosionDamageUtils.method04423(var2, this.field06752, this.field06753, var1, null);
                     this.method02955(
                        CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN,
                        var1,
                        var2,
                        sxxx,
                        ExplosionDamageUtils.method04423(var2, MinecraftAccess.mc.player, this.field06754, var1, null),
                        sx,
                        var3
                     );
                  }
               }
            }
         }
      }

      private CrystalPlacementEvaluator.Nested81 method02934(CrystalPlacementEvaluator.Nested84 var1, boolean var2) {
         if (var1 == CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL) {
            return var2 ? this.field06762 : this.field06764;
         } else {
            return var2 ? this.field06763 : this.field06765;
         }
      }

      private void method02935(CrystalPlacementEvaluator.Nested85 var1) {
         if (var1 != null && var1.pos() != null && this.field06758 != null) {
            for (int var2 = 0; var2 < this.field06758.size(); var2++) {
               CrystalPlacementEvaluator.Nested79 var3 = this.field06758.get(var2);
               if (!var3.verdict().method02932() && var3.action() == var1.action() && var3.pos().equals(var1.pos())) {
                  this.field06758
                     .set(
                        var2,
                        new CrystalPlacementEvaluator.Nested79(
                           var3.pos(), var3.action(), CrystalPlacementEvaluator.Nested76.CHOSEN, var3.enemyDamage(), var3.selfDamage(), var3.score()
                        )
                     );
                  return;
               }
            }
         }
      }

      private boolean method02936(CrystalPlacementEvaluator.Nested85 var1) {
         if (this.field06768 == null) {
            return false;
         } else if (!this.field06771 && var1 != null) {
            return var1.action() != CrystalPlacementEvaluator.Nested84.DIG && var1.action() != CrystalPlacementEvaluator.Nested84.AWAIT
               ? this.field06770 > this.field06772 + field06782
               : true;
         } else {
            return true;
         }
      }

      private boolean method02937(BlockPos var1) {
         return this.field06756.reservationOwner() != null && BlockPlacementTracker.method05646(this.field06756.reservationOwner(), var1);
      }

      private CrystalPlacementEvaluator.Nested85 method02938() {
         CrystalPlacementEvaluator.Nested85 var1 = this.method02950();
         if (var1 == null) {
            var1 = this.field06764.method02958();
         }

         if (var1 == null) {
            var1 = this.field06765.method02958();
         }

         if (this.method02936(var1)) {
            CrystalPlacementEvaluator.Nested85 var2 = this.method02952();
            if (var2 != null) {
               var1 = var2;
            }
         }

         this.method02935(var1);
         if (this.field06775 != null) {
            var var5 = new ArrayList(this.field06775.size());

            for (int var3 = 0; var3 < this.field06775.size(); var3++) {
               CrystalPlacementEvaluator.Nested75 var4 = this.field06775.get(var3);
               var5.add(
                  var4.method02929(
                     var1 != null
                        && var1.action() == CrystalPlacementEvaluator.Nested84.DIG
                        && var4.field06737.get(0).equals(var1.pos())
                        && var4.field06738.equals(var1.base())
                  )
               );
            }

            CrystalPlacementEvaluator.field06710 = var5;
         }

         return var1;
      }

      private boolean method02939(CrystalPlacementEvaluator.Nested84 var1, BlockPos var2, BlockPos var3, Vec3 var4, float var5, float var6, float var7) {
         if (var5 < this.field06756.minEnemyDamage()) {
            this.method02954(var2, var1, CrystalPlacementEvaluator.Nested76.LOW_DAMAGE, var5, var6, var7);
            return true;
         } else if (!CrystalPlacementEvaluator.method02907(var6, var5, this.field06756, var3)) {
            this.method02954(var2, var1, CrystalPlacementEvaluator.Nested76.SELF_DAMAGE, var5, var6, var7);
            return true;
         } else if (ExplosionDamageUtils.method04399(var4, this.field06756.friends()) > this.field06756.maxSelfDamage()) {
            this.method02954(var2, var1, CrystalPlacementEvaluator.Nested76.FRIEND_DAMAGE, var5, var6, var7);
            return true;
         } else {
            return false;
         }
      }

      private void method02940(MutableBlockPos var1) {
         if (this.field06756.canPlaceCrystal()) {
            if (!(ExplosionDamageUtils.method04381(this.field06755, var1) > this.field06760)) {
               if (this.field06757 != null && this.field06757.blacklist() != null && this.field06757.blacklist().contains(var1)) {
                  this.method02954(var1, null, CrystalPlacementEvaluator.Nested76.STALLED, 0.0F, 0.0F, 0.0F);
               } else if (this.field06757 == null
                  || this.field06757.pending() == null
                  || !this.field06757.pending().contains(var1) && !this.field06757.pending().contains(var1.above())) {
                  if (!this.method02937(var1) && !this.method02937(var1.above())) {
                     Vec3 var2 = ExplosionDamageUtils.method04377(var1);
                     float var3 = ExplosionDamageUtils.method04390(var2, this.field06752, this.field06753, 1.0F);
                     if (var3 < this.field06756.minEnemyDamage()) {
                        this.method02954(var1, null, CrystalPlacementEvaluator.Nested76.LOW_CEILING, var3, 0.0F, 0.0F);
                     } else {
                        boolean var4 = ExplosionDamageUtils.method04394(this.field06755, var2) <= this.field06761
                           && (!this.field06756.matrixSearch() || BlockPlacementManager.method07896(var2));
                        boolean var5 = var4 && var1.getY() < this.field06759;
                        BlockState var6 = MinecraftAccess.mc.level.getBlockState(var1);
                        if (ExplosionDamageUtils.method04406(var6)) {
                           BlockPos var7 = var1.immutable();
                           this.method02946(var7, var2, var4);
                           if (var5) {
                              this.method02948(var7, var6, var2);
                           }
                        } else if (var6.canBeReplaced()) {
                           BlockPos var8 = var1.immutable();
                           this.method02933(var8, var2, var4);
                           if (var5) {
                              this.method02948(var8, var6, var2);
                           }
                        } else if (!var4) {
                           this.method02954(var1, null, CrystalPlacementEvaluator.Nested76.OUT_OF_REACH, var3, 0.0F, 0.0F);
                        } else {
                           if (!var5) {
                              return;
                           }

                           if (this.field06756.canPlaceObsidian() && ExplosionDamageUtils.method04366(var6)) {
                              this.method02948(var1.immutable(), var6, var2);
                           } else {
                              this.method02954(var1, null, CrystalPlacementEvaluator.Nested76.NO_SUPPORT, var3, 0.0F, 0.0F);
                           }
                        }
                     }
                  } else {
                     this.method02954(var1, null, CrystalPlacementEvaluator.Nested76.RESERVED, 0.0F, 0.0F, 0.0F);
                  }
               } else {
                  this.method02954(var1, null, CrystalPlacementEvaluator.Nested76.UNCONFIRMED, 0.0F, 0.0F, 0.0F);
               }
            }
         }
      }

      private CrystalPlacementEvaluator.Nested85 method02941() {
         float var1 = this.field06766.method02957();
         if (var1 != field06778) {
            this.field06772 = var1;
            return this.field06766.method02958();
         }

         float var2 = this.field06762.method02957();
         float var3 = this.field06763.method02957();
         if (var2 == field06779 && var3 == field06780) {
            return null;
         }

         float var4 = var3 - field06781;
         this.field06772 = Math.max(var2, var4);
         return var2 >= var4 ? this.field06762.method02958() : this.field06763.method02958();
      }

      private boolean method02942(BlockPos var1) {
         return this.field06757 != null && var1.equals(this.field06757.preferredBase());
      }

      private void method02943(List<BlockPos> var1, BlockPos var2, float var3, boolean var4, Vec3 var5, BlockPos var6, BlockPos var7, boolean var8) {
         BlockPos var9 = (BlockPos)var1.get(0);
         if (var3 * this.field06757.targetStep() > 1.0F) {
            this.method02954(var9, CrystalPlacementEvaluator.Nested84.DIG, CrystalPlacementEvaluator.Nested76.TARGET_MOVING, 0.0F, 0.0F, 0.0F);
         } else {
            float var10 = ExplosionDamageUtils.method04423(var5, this.field06752, this.field06753, var6, var7);
            float var11 = ExplosionDamageUtils.method04423(var5, MinecraftAccess.mc.player, this.field06754, var6, var7);
            float var12 = CrystalPlacementEvaluator.method02910(var10, var11, this.field06752, this.field06753, var5);
            if (!this.method02939(CrystalPlacementEvaluator.Nested84.DIG, var9, var2, var5, var10, var11, var12)) {
               CrystalPlacementEvaluator.Nested75 var13 = new CrystalPlacementEvaluator.Nested75(var1, var2, var3, var4, var10, var11, var12, var6 != null, var8);
               this.method02954(var9, CrystalPlacementEvaluator.Nested84.DIG, CrystalPlacementEvaluator.Nested76.CANDIDATE, var10, var11, var13.method02927());
               if (this.field06775 != null) {
                  this.field06775.add(var13);
               }

               if (this.method02942(var2)) {
                  if (var13.method02928(this.field06773)) {
                     this.field06773 = var13;
                  }
               } else {
                  if (var13.method02928(this.field06774)) {
                     this.field06774 = var13;
                  }
               }
            }
         }
      }

      private CrystalPlacementEvaluator.Nested76 method02944(BlockPos var1, BlockState var2, List<BlockPos> var3) {
         if (this.field06757 != null && this.field06757.allowed()) {
            if (this.field06757.pending() != null && this.field06757.pending().contains(var1)) {
               return CrystalPlacementEvaluator.Nested76.UNCONFIRMED;
            } else if (this.method02937(var1)) {
               return CrystalPlacementEvaluator.Nested76.RESERVED;
            } else if (!ExplosionDamageUtils.method04366(var2)) {
               return CrystalPlacementEvaluator.Nested76.CANT_DIG;
            } else if (ExplosionDamageUtils.method04388(var1, var2)) {
               return CrystalPlacementEvaluator.Nested76.CANT_DIG;
            } else if (this.field06757.blacklist() != null && this.field06757.blacklist().contains(var1)) {
               return CrystalPlacementEvaluator.Nested76.CANT_DIG;
            } else if (this.field06757.keep() != null && this.field06757.keep().contains(var1)) {
               return CrystalPlacementEvaluator.Nested76.CANT_DIG;
            } else if (BlockBreakSpeedUtils.method04457(var2, var1) > field06783) {
               return CrystalPlacementEvaluator.Nested76.CANT_DIG;
            } else if (this.field06756.digThroughWalls()) {
               return ExplosionDamageUtils.method04381(this.field06755, var1) <= this.field06760 ? null : CrystalPlacementEvaluator.Nested76.OUT_OF_REACH;
            } else {
               return ExplosionDamageUtils.method04407(var1, this.field06755, this.field06756.placeRange(), var3)
                  ? null
                  : CrystalPlacementEvaluator.Nested76.NOT_VISIBLE;
            }
         } else {
            return CrystalPlacementEvaluator.Nested76.CANT_DIG;
         }
      }

      private boolean method02945(BlockPos var1, List<BlockPos> var2) {
         return !this.field06756.matrixSearch() || ExplosionDamageUtils.method04378(var1, this.field06755, this.field06756.placeRange(), var2);
      }

      private void method02946(BlockPos var1, Vec3 var2, boolean var3) {
         BlockPos var4 = var1.above();
         if (MinecraftAccess.mc.level.getBlockState(var4).isAir()) {
            CrystalPlacementEvaluator.Nested82 var5 = CrystalPlacementEvaluator.method02908(var4);
            if (var5 == CrystalPlacementEvaluator.Nested82.BLOCKED) {
               this.method02947(var1, CrystalPlacementEvaluator.method02909(var4), CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL, var2);
            } else {
               boolean var6 = !this.field06756.placeThroughWalls() && !ExplosionDamageUtils.method04411(var1, this.field06755, this.field06756.placeRange());
               ExplosionDamageUtils.Nested132 var7 = var6 ? null : this.method02951(var1);
               if (var7 != null && var7.visible()) {
                  float var8 = ExplosionDamageUtils.method04421(var2, this.field06752, this.field06753);
                  this.method02955(
                     CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL,
                     var1,
                     var2,
                     var8,
                     ExplosionDamageUtils.method04421(var2, MinecraftAccess.mc.player, this.field06754),
                     var5,
                     var3
                  );
               } else {
                  this.method02954(var1, CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL, CrystalPlacementEvaluator.Nested76.NOT_VISIBLE, 0.0F, 0.0F, 0.0F);
                  if (var3) {
                     this.method02949(var1, var2, false, var7);
                  }
               }
            }
         }
      }

      private void method02947(BlockPos var1, ItemEntity var2, CrystalPlacementEvaluator.Nested84 var3, Vec3 var4) {
         this.method02954(var1, var3, CrystalPlacementEvaluator.Nested76.BLOCKED, 0.0F, 0.0F, 0.0F);
         if (var2 != null) {
            float var5 = ExplosionDamageUtils.method04421(var4, this.field06752, this.field06753);
            float var6 = ExplosionDamageUtils.method04421(var4, MinecraftAccess.mc.player, this.field06754);
            if (CrystalPlacementEvaluator.method02913(var6, var5, this.field06756) && !(var5 < this.field06756.minEnemyDamage())) {
               float var7 = CrystalPlacementEvaluator.method02910(var5, var6, this.field06752, this.field06753, var4);
               boolean var8 = this.method02942(var1);
               if (this.field06768 == null || !this.field06771 || var8) {
                  if (this.field06768 == null || this.field06771 != var8 || !(var7 <= this.field06770)) {
                     this.field06768 = var2;
                     this.field06769 = var1;
                     this.field06770 = var7;
                     this.field06771 = var8;
                  }
               }
            }
         }
      }

      private void method02948(BlockPos var1, BlockState var2, Vec3 var3) {
         BlockPos var4 = var1.above();
         BlockState var5 = MinecraftAccess.mc.level.getBlockState(var4);
         boolean var6 = !ExplosionDamageUtils.method04406(var2);
         if (!var6 || this.field06756.canPlaceObsidian()) {
            var var7 = new ArrayList(2);
            if (!var5.isAir()) {
               var7.add(var4);
            }

            if (var6 && !var2.canBeReplaced()) {
               var7.add(var1);
            }

            if (!var7.isEmpty()) {
               BlockPos var8 = (BlockPos)var7.get(0);
               if (CrystalPlacementEvaluator.method02918(var4)) {
                  this.method02954(var8, CrystalPlacementEvaluator.Nested84.DIG, CrystalPlacementEvaluator.Nested76.ENTITY_ABOVE, 0.0F, 0.0F, 0.0F);
               } else {
                  float var9 = 0.0F;
                  boolean var10 = false;

                  for (int var11 = 0; var11 < var7.size(); var11++) {
                     BlockPos var12 = (BlockPos)var7.get(var11);
                     BlockState var13 = var12.equals(var4) ? var5 : var2;
                     CrystalPlacementEvaluator.Nested76 var14 = this.method02944(var12, var13, var7.subList(0, var11));
                     if (var14 != null) {
                        this.method02954(var8, CrystalPlacementEvaluator.Nested84.DIG, var14, 0.0F, 0.0F, 0.0F);
                        return;
                     }

                     var9 += this.method02953(var12, var13);
                     if (var12.equals(this.field06757.activeBlock())) {
                        var10 = true;
                     }
                  }

                  CrystalPlacementEvaluator.Nested74 var15 = CrystalPlacementEvaluator.method02917(var1, var7);
                  if (var15 == CrystalPlacementEvaluator.Nested74.CELL) {
                     this.method02954(var8, CrystalPlacementEvaluator.Nested84.DIG, CrystalPlacementEvaluator.Nested76.FLOODS, 0.0F, 0.0F, 0.0F);
                  } else if (var6
                     && ExplosionDamageUtils.method04373(var1, this.field06755, this.field06756.placeRange(), this.field06756.placeThroughWalls(), var7) == null) {
                     this.method02954(var8, CrystalPlacementEvaluator.Nested84.DIG, CrystalPlacementEvaluator.Nested76.NO_FACE, 0.0F, 0.0F, 0.0F);
                  } else {
                     boolean var16 = !var6
                        && !this.field06756.placeThroughWalls()
                        && !ExplosionDamageUtils.method04407(var1, this.field06755, this.field06756.placeRange(), var7);
                     if (!var16 && this.method02945(var1, var7)) {
                        BlockPos var17 = var6 ? var1 : null;
                        BlockPos var18 = var5.isAir() ? null : var4;
                        this.method02943(var7, var1, var9, var10, var3, var17, var18, var15 == CrystalPlacementEvaluator.Nested74.STREAM);
                     } else {
                        this.method02954(var8, CrystalPlacementEvaluator.Nested84.DIG, CrystalPlacementEvaluator.Nested76.NOT_VISIBLE, 0.0F, 0.0F, 0.0F);
                     }
                  }
               }
            }
         }
      }

      private void method02949(BlockPos var1, Vec3 var2, boolean var3, ExplosionDamageUtils.Nested132 var4) {
         if (this.field06756.matrixSearch() && this.field06757 != null && this.field06757.allowed()) {
            float var5 = this.field06756.placeRange();
            BlockPos var6 = null;
            if (var3) {
               var6 = ExplosionDamageUtils.method04387(var1, this.field06755, var5, this.field06756.placeThroughWalls());
            } else if (!this.field06756.placeThroughWalls()) {
               var6 = ExplosionDamageUtils.method04379(var1, this.field06755, var5);
            }

            if (var6 == null) {
               var6 = (var4 != null ? var4 : this.method02951(var1)).occluder();
            }

            if (var6 != null && !var6.equals(var1) && !var6.equals(var1.above())) {
               BlockState var7 = MinecraftAccess.mc.level.getBlockState(var6);
               CrystalPlacementEvaluator.Nested76 var8 = this.method02944(var6, var7, List.of());
               if (var8 != null) {
                  this.method02954(var6, CrystalPlacementEvaluator.Nested84.DIG, var8, 0.0F, 0.0F, 0.0F);
               } else {
                  var var9 = List.of(var6);
                  CrystalPlacementEvaluator.Nested74 var10 = CrystalPlacementEvaluator.method02917(var1, var9);
                  if (var10 == CrystalPlacementEvaluator.Nested74.CELL) {
                     this.method02954(var6, CrystalPlacementEvaluator.Nested84.DIG, CrystalPlacementEvaluator.Nested76.FLOODS, 0.0F, 0.0F, 0.0F);
                  } else {
                     boolean var11 = ExplosionDamageUtils.method04378(var1, this.field06755, var5, var9)
                        && (
                           var3
                              ? ExplosionDamageUtils.method04373(var1, this.field06755, var5, this.field06756.placeThroughWalls(), var9) != null
                              : this.field06756.placeThroughWalls() || ExplosionDamageUtils.method04407(var1, this.field06755, var5, var9)
                        );
                     if (!var11) {
                        this.method02954(
                           var6,
                           CrystalPlacementEvaluator.Nested84.DIG,
                           var3 ? CrystalPlacementEvaluator.Nested76.NO_FACE : CrystalPlacementEvaluator.Nested76.NOT_VISIBLE,
                           0.0F,
                           0.0F,
                           0.0F
                        );
                     } else {
                        this.method02943(
                           var9,
                           var1,
                           this.method02953(var6, var7),
                           var6.equals(this.field06757.activeBlock()),
                           var2,
                           var3 ? var1 : null,
                           var6,
                           var10 == CrystalPlacementEvaluator.Nested74.STREAM
                        );
                     }
                  }
               }
            }
         }
      }

      private CrystalPlacementEvaluator.Nested85 method02950() {
         CrystalPlacementEvaluator.Nested85 var1 = this.method02941();
         CrystalPlacementEvaluator.Nested75 var2 = this.field06773 != null ? this.field06773 : this.field06774;
         if (var2 == null) {
            return var1;
         }

         if (var1 != null && !var2.method02931(var1)) {
            return var1;
         }

         this.field06772 = var2.method02927();
         return var2.method02930();
      }

      private ExplosionDamageUtils.Nested132 method02951(BlockPos var1) {
         return this.field06756.matrixSearch()
            ? ExplosionDamageUtils.method04398(var1, this.field06755, this.field06756.placeRange(), List.of())
            : CrystalPlacementEvaluator.field06714;
      }

      private CrystalPlacementEvaluator.Nested85 method02952() {
         CrystalPlacementEvaluator.Nested85 var1 = this.field06767.method02960(this.field06768, this.field06769);
         return var1 == null
            ? null
            : new CrystalPlacementEvaluator.Nested85(var1.action(), var1.pos(), var1.base(), null, var1.enemyDamage(), var1.selfDamage(), this.field06769);
      }

      private float method02953(BlockPos var1, BlockState var2) {
         float var3 = BlockBreakSpeedUtils.method04457(var2, var1);
         if (var1.equals(this.field06757.activeBlock())) {
            var3 *= 1.0F - Mth.clamp(this.field06757.activeProgress(), 0.0F, 1.0F);
         }

         return var3;
      }

      private void method02954(BlockPos var1, CrystalPlacementEvaluator.Nested84 var2, CrystalPlacementEvaluator.Nested76 var3, float var4, float var5, float var6) {
         if (this.field06758 != null) {
            this.field06758.add(new CrystalPlacementEvaluator.Nested79(var1.immutable(), var2, var3, var4, var5, var6));
         }
      }

      private Nested77(
         Player var1, AABB var2, Vec3 var3, CrystalPlacementEvaluator.Nested86 var4, CrystalPlacementEvaluator.Nested80 var5, List<CrystalPlacementEvaluator.Nested79> var6
      ) {
         this.field06770 = field06776;
         this.field06772 = field06777;
         this.field06752 = var1;
         this.field06753 = var2;
         this.field06754 = MinecraftAccess.mc.player.getBoundingBox();
         this.field06755 = var3;
         this.field06756 = var4;
         this.field06757 = var5;
         this.field06758 = var6;
         this.field06759 = Mth.floor(var2.minY);
         this.field06760 = var4.placeRange() * var4.placeRange();
         this.field06761 = var4.explodeRange() * var4.explodeRange();
         this.field06775 = var6 == null ? null : new ArrayList<>();
      }

      private void method02955(
         CrystalPlacementEvaluator.Nested84 var1, BlockPos var2, Vec3 var3, float var4, float var5, CrystalPlacementEvaluator.Nested82 var6, boolean var7
      ) {
         float var8 = CrystalPlacementEvaluator.method02910(var4, var5, this.field06752, this.field06753, var3);
         CrystalPlacementEvaluator.Nested85 var9 = new CrystalPlacementEvaluator.Nested85(var1, var2, var2, null, var4, var5, null);
         boolean var10 = var7 && var6 == CrystalPlacementEvaluator.Nested82.FREE;
         if (!this.method02939(var1, var2, var2, var3, var4, var5, var8)) {
            CrystalPlacementEvaluator.Nested81 var11 = this.method02942(var2) ? this.field06766 : this.method02934(var1, var7);
            if (var6 == CrystalPlacementEvaluator.Nested82.FALLING_ITEM) {
               if (this.field06757 != null && this.field06757.awaitTicks() >= 2) {
                  this.method02954(var2, var1, CrystalPlacementEvaluator.Nested76.BLOCKED, var4, var5, var8);
               } else {
                  this.method02954(var2, var1, CrystalPlacementEvaluator.Nested76.AWAIT, var4, var5, var8);
                  var11.method02956(var8);
               }
            } else {
               this.method02954(var2, var1, CrystalPlacementEvaluator.Nested76.CANDIDATE, var4, var5, var8);
               if (var10) {
                  this.field06767.method02962(var9, var3, var8);
               }

               var11.method02959(var9, var8);
            }
         }
      }
   }

   // $VF: Compiled from s
   public record Nested78(List<BlockPos> blocks, BlockPos base, float ticks, boolean active, float enemyDamage, float selfDamage, boolean chosen) {
   }

   // $VF: Compiled from s
   public record Nested79(
      BlockPos pos, CrystalPlacementEvaluator.Nested84 action, CrystalPlacementEvaluator.Nested76 verdict, float enemyDamage, float selfDamage, float score
   ) {
   }

   // $VF: Compiled from s
   public record Nested80(
      boolean allowed,
      Set<BlockPos> blacklist,
      Set<BlockPos> keep,
      BlockPos activeBlock,
      float activeProgress,
      float targetStep,
      BlockPos preferredBase,
      Set<BlockPos> pending,
      int awaitTicks
   ) {
   }

   // $VF: Compiled from s
   private static final class Nested81 {
      private CrystalPlacementEvaluator.Nested85 field06784;
      private float field06785;
      private float field06786;
      private static final float field06787 = -Float.MAX_VALUE;
      private static final float field06788 = -Float.MAX_VALUE;

      private Nested81() {
         this.field06785 = field06787;
         this.field06786 = field06788;
      }

      private void method02956(float var1) {
         if (var1 > this.field06786) {
            this.field06786 = var1;
         }
      }

      private float method02957() {
         return Math.max(this.field06785, this.field06786);
      }

      private CrystalPlacementEvaluator.Nested85 method02958() {
         return this.field06786 > this.field06785 ? CrystalPlacementEvaluator.field06713 : this.field06784;
      }

      private void method02959(CrystalPlacementEvaluator.Nested85 var1, float var2) {
         if (!(var2 <= this.field06785)) {
            this.field06785 = var2;
            this.field06784 = var1;
         }
      }
   }

   // $VF: Compiled from s
   private enum Nested82 {
      FREE,
      FALLING_ITEM,
      BLOCKED;
   }

   // $VF: Compiled from s
   private static final class Nested83 {
      private final List<CrystalPlacementEvaluator.Nested85> field06789 = new ArrayList<>(9);
      private final List<Vec3> field06790 = new ArrayList<>(9);
      private final List<Float> field06791 = new ArrayList<>(9);
      private static final double field06792 = 3.0;
      private static final float field06793 = 5.0F;

      private CrystalPlacementEvaluator.Nested85 method02960(ItemEntity var1, BlockPos var2) {
         CrystalPlacementEvaluator.Nested85 var3 = this.method02961(var1, var2, CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL);
         return var3 != null ? var3 : this.method02961(var1, var2, CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN);
      }

      private CrystalPlacementEvaluator.Nested85 method02961(ItemEntity var1, BlockPos var2, CrystalPlacementEvaluator.Nested84 var3) {
         AABB var4 = var1.getBoundingBox();

         for (int var5 = 0; var5 < this.field06789.size(); var5++) {
            CrystalPlacementEvaluator.Nested85 var6 = this.field06789.get(var5);
            if (var6.action() == var3) {
               BlockPos var7 = var6.pos();
               if (var7.getX() != var2.getX() || var7.getZ() != var2.getZ() || Math.abs(var7.getY() - var2.getY()) > 2) {
                  AABB var8 = new AABB(var7.getX(), var7.getY(), var7.getZ(), var7.getX() + 1.0, var7.getY() + field06792, var7.getZ() + 1.0);
                  if (!var8.intersects(var4)) {
                     BlockPos var9 = var3 == CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN ? var7 : null;
                     if (ExplosionDamageUtils.method04405(this.field06790.get(var5), var1, var9) >= field06793) {
                        return var6;
                     }
                  }
               }
            }
         }

         return null;
      }

      private void method02962(CrystalPlacementEvaluator.Nested85 var1, Vec3 var2, float var3) {
         int var4 = 0;

         while (var4 < this.field06791.size() && this.field06791.get(var4) >= var3) {
            var4++;
         }

         if (var4 < 8) {
            this.field06789.add(var4, var1);
            this.field06790.add(var4, var2);
            this.field06791.add(var4, var3);
            if (this.field06789.size() > 8) {
               this.field06789.remove(8);
               this.field06790.remove(8);
               this.field06791.remove(8);
            }
         }
      }
   }

   // $VF: Compiled from s
   public enum Nested84 {
      EXPLODE,
      PLACE_CRYSTAL,
      PLACE_OBSIDIAN,
      DIG,
      AWAIT;
   }

   // $VF: Compiled from s
   public record Nested85(
      CrystalPlacementEvaluator.Nested84 action, BlockPos pos, BlockPos base, EndCrystal crystal, float enemyDamage, float selfDamage, BlockPos clears
   ) {
   }

   // $VF: Compiled from s
   public record Nested86(
      float placeRange,
      float explodeRange,
      float minEnemyDamage,
      float maxSelfDamage,
      float selfHealthLimit,
      boolean canPlaceCrystal,
      boolean canPlaceObsidian,
      boolean placeThroughWalls,
      boolean digThroughWalls,
      boolean explodeThroughWalls,
      List<? extends LivingEntity> friends,
      boolean matrixSearch,
      BlockPos committedBase,
      Object reservationOwner
   ) {
   }
}
