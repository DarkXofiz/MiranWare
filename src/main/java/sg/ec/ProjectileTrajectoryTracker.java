// Original binary: sg/ec/0jlUdmLppgFIDuk3
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.EnderpearlItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.item.ThrowablePotionItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.WindChargeItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public class ProjectileTrajectoryTracker implements MinecraftAccess {
   public static final ProjectileTrajectoryTracker field00265 = new ProjectileTrajectoryTracker();
   public static final int field00266 = 300;
   private static final int field00267 = 0;
   private static final double field00268 = 0;
   private final Map<Integer, ProjectileTrajectoryTracker.Nested5> field00269 = new HashMap<>();
   private final List<ProjectileTrajectoryTracker.Nested6> field00270 = new ArrayList<>();
   private final List<ProjectileTrajectoryTracker.Nested6> field00271 = new ArrayList<>();
   private long field00272;
   private double field00273;
   private double field00274;
   private double field00275;
   private double field00276;
   private double field00277;
   private double field00278;
   private float field00279;
   private float field00280;
   private ItemStack field00281;
   private ItemStack field00282;
   private long field00283;
   private boolean field00284;
   private static final long field00285 = Long.MIN_VALUE;
   private static final long field00286 = Long.MIN_VALUE;
   private static final long field00287 = Long.MIN_VALUE;
   private static final double field00288 = 0.02;
   private static final double field00289 = 0.05;
   private static final String field00290 = "Эндер жемчуг";
   private static final double field00291 = 0.03;
   private static final double field00292 = 0.99;
   private static final double field00293 = 0.8;
   private static final String field00294 = "Стрела";
   private static final double field00295 = 0.05;
   private static final double field00296 = 0.99;
   private static final double field00297 = 0.6;
   private static final String field00298 = "Трезубец";
   private static final double field00299 = 0.05;
   private static final double field00300 = 0.99;
   private static final double field00301 = 0.99;
   private static final String field00302 = "Предмет";
   private static final double field00303 = 0.04;
   private static final double field00304 = 0.98;
   private static final double field00305 = 0.9702;
   private static final long field00306 = Long.MIN_VALUE;
   private static final double field00307 = 0.05;
   private static final double field00308 = Double.MAX_VALUE;
   private static final double field00309 = Double.MAX_VALUE;
   private static final double field00310 = 0.125;
   private static final double field00311 = 3.15;
   private static final float field00312 = -10.0F;
   private static final float field00313 = 10.0F;
   private static final double field00314 = -0.1F;
   private static final String field00315 = "Эндер жемчуг";
   private static final String field00316 = "Эндер жемчуг";
   private static final double field00317 = 1.5;
   private static final double field00318 = 0.03;
   private static final double field00319 = 0.99;
   private static final double field00320 = 0.8;
   private static final String field00321 = "Снежок";
   private static final String field00322 = "Снежок";
   private static final double field00323 = 1.5;
   private static final double field00324 = 0.03;
   private static final double field00325 = 0.99;
   private static final double field00326 = 0.8;
   private static final String field00327 = "Заряд ветра";
   private static final String field00328 = "Заряд ветра";
   private static final double field00329 = 1.5;
   private static final String field00330 = "Взрывное зелье";
   private static final float field00331 = -20.0F;
   private static final String field00332 = "Взрывное зелье";
   private static final double field00333 = 0.5;
   private static final double field00334 = 0.05;
   private static final double field00335 = 0.99;
   private static final double field00336 = 0.8;
   private static final String field00337 = "Стрела";
   private static final float field00338 = 0.1F;
   private static final double field00339 = 3.0;
   private static final double field00340 = 3.15;
   private static final String field00341 = "Стрела";
   private static final double field00342 = 0.05;
   private static final double field00343 = 0.99;
   private static final double field00344 = 0.6;
   private static final String field00345 = "Трезубец";
   private static final String field00346 = "Трезубец";
   private static final double field00347 = 2.5;
   private static final double field00348 = 0.05;
   private static final double field00349 = 0.99;
   private static final double field00350 = 0.99;
   private static final String field00351 = "Предмет";
   private static final double field00352 = 0.3F;
   private static final String field00353 = "Предмет";
   private static final double field00354 = 0.04;
   private static final double field00355 = 0.98;
   private static final double field00356 = 0.9702;
   private static final float field00357 = 20.0F;
   private static final float field00358 = 3.0F;
   private static final float field00359 = (float) (Math.PI / 180.0);
   private static final float field00360 = (float) (Math.PI / 180.0);
   private static final float field00361 = (float) (Math.PI / 180.0);
   private static final float field00362 = (float) (Math.PI / 180.0);
   private static final float field00363 = (float) (Math.PI / 180.0);
   private static final float field00364 = (float) Math.PI;
   private static final float field00365 = 0.01F;
   private static final float field00366 = 0.3F;
   private static final float field00367 = 0.3F;
   private static final float field00368 = 0.1F;
   private static final float field00369 = 0.3F;
   private static final double field00370 = Double.MAX_VALUE;
   private static final double field00371 = 0.001;
   private static final double field00372 = -1.0;
   private static final double field00373 = -1.0;
   private static final double field00374 = -1.0;

   private ProjectileTrajectoryTracker.Nested3 method00186(ProjectileHelper var1, Player var2, ItemStack var3, InteractionHand var4, float var5) {
      if (var3.isEmpty()) {
         return null;
      }

      Item var6 = var3.getItem();
      Vec3 sx = var2.getEyePosition(var5);
      Vec3 sxx = sx.add(0.0, field00314, 0.0);
      if (var6 instanceof EnderpearlItem && var1.method04773(field00315)) {
         return new ProjectileTrajectoryTracker.Nested3(
            field00316, var3, sxx, var2.getViewVector(var5).scale(field00317), field00318, field00319, field00320, ColorUtils.Nested138.method04638(20)
         );
      }

      if (var6 instanceof SnowballItem && var1.method04773(field00321)) {
         return new ProjectileTrajectoryTracker.Nested3(
            field00322, var3, sxx, var2.getViewVector(var5).scale(field00323), field00324, field00325, field00326, ColorUtils.Nested138.method04638(90)
         );
      }

      if (var6 instanceof WindChargeItem && var1.method04773(field00327)) {
         return new ProjectileTrajectoryTracker.Nested3(
            field00328, var3, sxx, var2.getViewVector(var5).scale(field00329), 0.0, 1.0, 1.0, ColorUtils.Nested138.method04638(120)
         );
      }

      if (var6 instanceof ThrowablePotionItem && var1.method04773(field00330)) {
         Vec3 sxxx = this.method00188(var2.getViewXRot(var5), var2.getViewYRot(var5), field00331);
         return new ProjectileTrajectoryTracker.Nested3(
            field00332, var3, sxx, sxxx.scale(field00333), field00334, field00335, field00336, ColorUtils.Nested138.method04638(150)
         );
      }

      if (var1.method04773(field00337) && (var6 instanceof BowItem || var6 instanceof CrossbowItem)) {
         double sxxx;
         if (var6 instanceof BowItem) {
            if (!var2.isUsingItem() || var2.getUsedItemHand() != var4) {
               return null;
            }

            float sxxxx = this.method00194(var2, var5);
            if (sxxxx < field00338) {
               return null;
            }

            sxxx = field00339 * sxxxx;
         } else {
            if (!CrossbowItem.isCharged(var3)) {
               return null;
            }

            sxxx = field00340;
         }

         return new ProjectileTrajectoryTracker.Nested3(
            field00341,
            Items.ARROW.getDefaultInstance(),
            sxx,
            var2.getViewVector(var5).scale(sxxx),
            field00342,
            field00343,
            field00344,
            ColorUtils.Nested138.method04638(210)
         );
      } else if (var6 instanceof TridentItem && var1.method04773(field00345)) {
         return var2.isUsingItem() && var2.getUsedItemHand() == var4 && var2.getTicksUsingItem() >= 10
            ? new ProjectileTrajectoryTracker.Nested3(
               field00346,
               Items.TRIDENT.getDefaultInstance(),
               sxx,
               var2.getViewVector(var5).scale(field00347),
               field00348,
               field00349,
               field00350,
               ColorUtils.Nested138.method04638(280)
            )
            : null;
      } else if (var1.method04773(field00351)) {
         Vec3 sxxx = new Vec3(sx.x, sx.y - field00352, sx.z);
         return new ProjectileTrajectoryTracker.Nested3(
            field00353, var3, sxxx, this.method00203(var2, var5), field00354, field00355, field00356, ColorUtils.Nested138.method04638(330)
         );
      } else {
         return null;
      }
   }

   private List<ProjectileTrajectoryTracker.Nested3> method00187(ProjectileHelper var1, Player var2, ItemStack var3, InteractionHand var4, float var5) {
      ArrayList var6 = new ArrayList();
      ProjectileTrajectoryTracker.Nested3 var7 = this.method00186(var1, var2, var3, var4, var5);
      if (var7 == null) {
         return var6;
      }

      if (var3.getItem() instanceof CrossbowItem && this.method00198(var3)) {
         Vec3 var8 = var2.getViewVector(var5).normalize();
         Vec3 var9 = this.method00190(var2, var5).normalize();
         Vec3 var10 = var8.scale(field00311);
         var6.add(
            new ProjectileTrajectoryTracker.Nested3(
               var7.field00375,
               var3,
               var7.field00377,
               this.method00191(var10, var9, field00312),
               var7.field00379,
               var7.field00380,
               var7.field00381,
               var7.field00382
            )
         );
         var6.add(var7);
         var6.add(
            new ProjectileTrajectoryTracker.Nested3(
               var7.field00375,
               var3,
               var7.field00377,
               this.method00191(var10, var9, field00313),
               var7.field00379,
               var7.field00380,
               var7.field00381,
               var7.field00382
            )
         );
      } else {
         var6.add(var7);
      }

      return var6;
   }

   private Vec3 method00188(float var1, float var2, float var3) {
      float var4 = var2 * field00359;
      float var5 = var1 * field00360;
      float var6 = (var1 + var3) * field00361;
      double var7 = -Mth.sin(var4) * Mth.cos(var5);
      double var9 = -Mth.sin(var6);
      double var11 = Mth.cos(var4) * Mth.cos(var5);
      return new Vec3(var7, var9, var11).normalize();
   }

   private Vec3 method00189(Player var1, Vec3 var2) {
      return new Vec3(var2.x, var1.onGround() ? 0.0 : var2.y, var2.z);
   }

   private Vec3 method00190(Player var1, float var2) {
      float var3 = (float)Math.toRadians(-var1.getViewYRot(var2));
      float var4 = (float)Math.toRadians(-var1.getViewXRot(var2));
      return new Vec3(-Math.sin(var4) * Math.sin(var3), Math.cos(var4), -Math.sin(var4) * Math.cos(var3)).normalize();
   }

   private Vec3 method00191(Vec3 var1, Vec3 var2, float var3) {
      double var4 = Math.toRadians(var3);
      Vec3 var6 = var2.normalize();
      double var7 = Math.cos(var4);
      double var9 = Math.sin(var4);
      return var1.scale(var7).add(var6.cross(var1).scale(var9)).add(var6.scale(var6.dot(var1) * (1.0 - var7)));
   }

   public ProjectileTrajectoryTracker.Nested6 method00192(
      Vec3 var1, Vec3 var2, double var3, double var5, double var7, boolean var9, double var10, boolean var12, Entity var13
   ) {
      return this.method00200(var1, var2, var3, var5, var7, var9, var10, var12, var13, 300);
   }

   private ProjectileTrajectoryTracker.Nested5 method00193(ProjectileHelper var1, Entity var2) {
      ProjectileTrajectoryTracker.Nested5 var3 = new ProjectileTrajectoryTracker.Nested5();
      if (var2 instanceof ThrownEnderpearl) {
         var3.field00383 = field00290;
         var3.field00384 = field00291;
         var3.field00385 = field00292;
         var3.field00386 = field00293;
         var3.field00387 = 20;
         var3.field00388 = Items.ENDER_PEARL.getDefaultInstance();
      } else if (var2 instanceof Arrow) {
         var3.field00383 = field00294;
         var3.field00384 = field00295;
         var3.field00385 = field00296;
         var3.field00386 = field00297;
         var3.field00387 = 210;
         var3.field00388 = Items.ARROW.getDefaultInstance();
      } else if (var2 instanceof ThrownTrident) {
         var3.field00383 = field00298;
         var3.field00384 = field00299;
         var3.field00385 = field00300;
         var3.field00386 = field00301;
         var3.field00387 = 280;
         var3.field00388 = Items.TRIDENT.getDefaultInstance();
      } else {
         if (!(var2 instanceof ItemEntity var4)) {
            return null;
         }

         var3.field00383 = field00302;
         var3.field00384 = field00303;
         var3.field00385 = field00304;
         var3.field00386 = field00305;
         var3.field00387 = 330;
         var3.field00388 = var4.getItem();
      }

      return !var1.method04779(var3.field00383) ? null : var3;
   }

   private float method00194(Player var1, float var2) {
      float var3 = (var1.getTicksUsingItem() + var2) / field00357;
      var3 = (var3 * var3 + var3 * 2.0F) / field00358;
      return var3 > 1.0F ? 1.0F : var3;
   }

   private ProjectileTrajectoryTracker() {
      this.field00272 = field00285;
      this.field00283 = field00286;
   }

   public void method00195(ProjectileHelper var1) {
      if (mc.level != null && mc.player != null) {
         for (ProjectileTrajectoryTracker.Nested5 var3 : this.field00269.values()) {
            var3.field00392 = false;
         }

         for (Entity var9 : mc.level.entitiesForRendering()) {
            ProjectileTrajectoryTracker.Nested5 var4 = this.method00193(var1, var9);
            if (var4 != null) {
               int var5 = var9.getId();
               if (var9.getDeltaMovement().lengthSqr() <= field00288) {
                  this.field00269.remove(var5);
               } else {
                  ProjectileTrajectoryTracker.Nested5 var6 = this.field00269.get(var5);
                  if (var6 == null || !var6.field00383.equals(var4.field00383)) {
                     var6 = var4;
                     this.field00269.put(var5, var6);
                  }

                  var6.field00389 = var9.position();
                  var6.field00390 = var9.getDeltaMovement();
                  var6.field00391 = 0;
                  var6.field00392 = true;
               }
            }
         }

         var var8 = this.field00269.entrySet().iterator();

         while (var8.hasNext()) {
            ProjectileTrajectoryTracker.Nested5 var10 = (ProjectileTrajectoryTracker.Nested5)((Entry)var8.next()).getValue();
            if (!var10.field00392) {
               if (!var1.method04779(var10.field00383)) {
                  var8.remove();
               } else {
                  var10.field00391++;
                  if (var10.field00391 > 120) {
                     var8.remove();
                  }
               }
            }
         }

         this.field00270.clear();

         for (ProjectileTrajectoryTracker.Nested5 var12 : this.field00269.values()) {
            ProjectileTrajectoryTracker.Nested6 var13 = this.method00192(
               var12.field00389, var12.field00390, var12.field00384, var12.field00385, var12.field00386, false, 0.0, false, mc.player
            );
            int var14 = var12.field00391;
            if (var14 > 0) {
               if (var14 >= var13.field00393.size() - 1) {
                  continue;
               }

               var13.field00393.subList(0, var14).clear();
               var13.field00395 = Math.max(0.0, var13.field00395 - var14 * field00289);
            }

            if (var13.field00393.size() >= 2) {
               var13.field00394 = var12.field00383;
               var13.field00402 = ColorUtils.Nested138.method04638(var12.field00387);
               var13.field00404 = var12.field00388;
               this.field00270.add(var13);
            }
         }
      } else {
         this.field00269.clear();
         this.field00270.clear();
      }
   }

   public boolean method00196(Vec3 var1) {
      BlockPos var2 = BlockPos.containing(var1.x, var1.y, var1.z);
      long var3 = var2.asLong();
      if (var3 == this.field00283) {
         return this.field00284;
      }

      this.field00283 = var3;
      this.field00284 = !mc.level.getFluidState(var2).isEmpty() || mc.level.getBlockState(var2).is(Blocks.WATER);
      return this.field00284;
   }

   private void method00197(List<ProjectileTrajectoryTracker.Nested6> var1, ProjectileHelper var2, InteractionHand var3, float var4, Vec3 var5) {
      ItemStack var6 = mc.player.getItemInHand(var3);
      var var7 = this.method00187(var2, mc.player, var6, var3, var4);

      for (int var8 = 0; var8 < var7.size(); var8++) {
         ProjectileTrajectoryTracker.Nested3 var9 = (ProjectileTrajectoryTracker.Nested3)var7.get(var8);
         boolean var10 = var9.field00376.getItem() instanceof ThrowablePotionItem;
         Vec3 var11 = var9.field00378.add(this.method00189(mc.player, var5));
         ProjectileTrajectoryTracker.Nested6 var12 = this.method00192(
            var9.field00377, var11, var9.field00379, var9.field00380, var9.field00381, var10, var10 ? field00310 : 0.0, true, mc.player
         );
         if (var12.method00206() > 1) {
            var12.field00394 = var9.field00375;
            var12.field00402 = var9.field00382;
            var12.field00403 = var10;
            var12.field00404 = var9.field00376;
            var1.add(var12);
         }
      }
   }

   private boolean method00198(ItemStack var1) {
      return EnchantmentUtils.method06757(var1, Enchantments.MULTISHOT) > 0;
   }

   public List<ProjectileTrajectoryTracker.Nested6> method00199() {
      return this.field00270;
   }

   public ProjectileTrajectoryTracker.Nested6 method00200(
      Vec3 var1, Vec3 var2, double var3, double var5, double var7, boolean var9, double var10, boolean var12, Entity var13, int var14
   ) {
      ProjectileTrajectoryTracker.Nested6 var15 = new ProjectileTrajectoryTracker.Nested6();
      Vec3 var16 = var1;
      Vec3 var17 = var2;
      this.field00283 = field00306;
      var15.method00207(var16);

      for (int var18 = 0; var18 < var14; var18++) {
         Vec3 var19 = var16;
         if (var9) {
            double var20 = this.method00196(var19) ? var7 : var5;
            var17 = var17.add(0.0, -var3, 0.0).scale(var20);
         }

         Vec3 var32 = var19.add(var17);
         BlockHitResult var21 = mc.level.clip(new ClipContext(var19, var32, Block.COLLIDER, Fluid.NONE, var13));
         var15.field00395 = var15.field00395 + field00307;
         Vec3 var22 = var21.getType() == Type.BLOCK ? var21.getLocation() : null;
         double var23 = var22 != null ? var19.distanceToSqr(var22) : field00308;
         ProjectileTrajectoryTracker.Nested4 var25 = var12 ? this.method00205(var13, var19, var32, var10) : null;
         double var26 = var25 != null ? var19.distanceToSqr(var25.hitPos()) : field00309;
         if (var25 != null && var26 <= var23) {
            var16 = var25.hitPos();
            var15.method00207(var16);
            var15.field00396 = true;
            var15.field00397 = var16;
            var15.field00398 = var25.normal();
            var15.field00400 = var25.entityBox();
            var15.field00401 = var25.entityId();
            break;
         }

         if (var22 != null) {
            var16 = var22;
            var15.method00207(var16);
            var15.field00396 = true;
            var15.field00397 = var16;
            var15.field00399 = var21.getBlockPos();
            Direction var33 = var21.getDirection();
            var15.field00398 = new Vec3(var33.getStepX(), var33.getStepY(), var33.getStepZ());
            break;
         }

         var16 = var32;
         var15.method00207(var16);
         if (!var9) {
            double var28 = this.method00196(var16) ? var7 : var5;
            var17 = var17.scale(var28).add(0.0, -var3, 0.0);
         }

         if (var16.y < mc.level.getMinY() - 8) {
            break;
         }
      }

      return var15;
   }

   public List<ProjectileTrajectoryTracker.Nested6> method00201(ProjectileHelper var1, float var2, Vec3 var3) {
      if (mc.player != null && mc.level != null) {
         Vec3 var4 = mc.player.getEyePosition(var2);
         float var5 = mc.player.getViewXRot(var2);
         float var6 = mc.player.getViewYRot(var2);
         long var7 = mc.level.getGameTime();
         ItemStack var9 = mc.player.getItemInHand(InteractionHand.MAIN_HAND);
         ItemStack var10 = mc.player.getItemInHand(InteractionHand.OFF_HAND);
         if (var7 == this.field00272
            && var9 == this.field00281
            && var10 == this.field00282
            && var4.x == this.field00273
            && var4.y == this.field00274
            && var4.z == this.field00275
            && var5 == this.field00279
            && var6 == this.field00280
            && var3.x == this.field00276
            && var3.y == this.field00277
            && var3.z == this.field00278) {
            return this.field00271;
         }

         this.field00272 = var7;
         this.field00281 = var9;
         this.field00282 = var10;
         this.field00273 = var4.x;
         this.field00274 = var4.y;
         this.field00275 = var4.z;
         this.field00279 = var5;
         this.field00280 = var6;
         this.field00276 = var3.x;
         this.field00277 = var3.y;
         this.field00278 = var3.z;
         this.field00271.clear();
         this.method00197(this.field00271, var1, InteractionHand.MAIN_HAND, var2, var3);
         this.method00197(this.field00271, var1, InteractionHand.OFF_HAND, var2, var3);
         return this.field00271;
      } else {
         this.field00271.clear();
         this.field00272 = field00287;
         this.field00281 = null;
         this.field00282 = null;
         return this.field00271;
      }
   }

   private boolean method00202(Entity var1) {
      return var1.isAlive() && !var1.isSpectator() && !(var1 instanceof Projectile) && !(var1 instanceof ItemEntity) && !(var1 instanceof ExperienceOrb);
   }

   private Vec3 method00203(Player var1, float var2) {
      float var3 = var1.getViewXRot(var2) * field00362;
      float var4 = var1.getViewYRot(var2) * field00363;
      float var5 = Mth.sin(var3);
      float var6 = Mth.cos(var3);
      float var7 = Mth.sin(var4);
      float var8 = Mth.cos(var4);
      float var9 = field00364;
      float var10 = field00365;
      return new Vec3(-var7 * var6 * field00366 + Math.cos(var9) * var10, -var5 * field00367 + field00368, var8 * var6 * field00369 + Math.sin(var9) * var10);
   }

   private Vec3 method00204(AABB var1, Vec3 var2) {
      double var3 = field00371;
      if (Math.abs(var2.x - var1.minX) < var3) {
         return new Vec3(field00372, 0.0, 0.0);
      } else if (Math.abs(var2.x - var1.maxX) < var3) {
         return new Vec3(1.0, 0.0, 0.0);
      } else if (Math.abs(var2.y - var1.minY) < var3) {
         return new Vec3(0.0, field00373, 0.0);
      } else if (Math.abs(var2.y - var1.maxY) < var3) {
         return new Vec3(0.0, 1.0, 0.0);
      } else if (Math.abs(var2.z - var1.minZ) < var3) {
         return new Vec3(0.0, 0.0, field00374);
      } else {
         return Math.abs(var2.z - var1.maxZ) < var3 ? new Vec3(0.0, 0.0, 1.0) : null;
      }
   }

   private ProjectileTrajectoryTracker.Nested4 method00205(Entity var1, Vec3 var2, Vec3 var3, double var4) {
      AABB var6 = new AABB(var2, var3).inflate(1.0 + var4);
      var var7 = mc.level.getEntities(var1, var6, this::method00202);
      Entity var8 = null;
      Vec3 var9 = null;
      AABB var10 = null;
      double var11 = field00370;

      for (Entity var14 : var7) {
         AABB var15 = var14.getBoundingBox().inflate(var14.getPickRadius() + var4);
         var var16 = var15.clip(var2, var3);
         if (!var16.isEmpty()) {
            double var17 = var2.distanceToSqr((Vec3)var16.get());
            if (var17 < var11) {
               var11 = var17;
               var8 = var14;
               var9 = (Vec3)var16.get();
               var10 = var15;
            }
         }
      }

      return var8 != null && var9 != null ? new ProjectileTrajectoryTracker.Nested4(var9, var10, var8.getId(), this.method00204(var10, var9)) : null;
   }

   // $VF: Compiled from s
   private static final class Nested3 {
      private final String field00375;
      private final ItemStack field00376;
      private final Vec3 field00377;
      private final Vec3 field00378;
      private final double field00379;
      private final double field00380;
      private final double field00381;
      private final int field00382;

      private Nested3(String var1, ItemStack var2, Vec3 var3, Vec3 var4, double var5, double var7, double var9, int var11) {
         this.field00375 = var1;
         this.field00376 = var2;
         this.field00377 = var3;
         this.field00378 = var4;
         this.field00379 = var5;
         this.field00380 = var7;
         this.field00381 = var9;
         this.field00382 = var11;
      }
   }

   // $VF: Compiled from s
   private record Nested4(Vec3 hitPos, AABB entityBox, int entityId, Vec3 normal) {
   }

   // $VF: Compiled from s
   private static final class Nested5 {
      private String field00383;
      private double field00384;
      private double field00385;
      private double field00386;
      private int field00387;
      private ItemStack field00388;
      private Vec3 field00389 = Vec3.ZERO;
      private Vec3 field00390 = Vec3.ZERO;
      private int field00391;
      private boolean field00392;
   }

   // $VF: Compiled from s
   public static final class Nested6 {
      public final List<Vec3> field00393 = new ArrayList<>(64);
      public String field00394;
      public double field00395;
      public boolean field00396;
      public Vec3 field00397;
      public Vec3 field00398;
      public BlockPos field00399;
      public AABB field00400;
      public int field00401 = -1;
      public int field00402;
      public boolean field00403;
      public ItemStack field00404;

      public int method00206() {
         return this.field00393.size();
      }

      private void method00207(Vec3 var1) {
         this.field00393.add(var1);
      }
   }
}
