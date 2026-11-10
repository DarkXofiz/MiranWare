// Original binary: sg/ec/j5jO7h9dzmndCaRq
package sg.ec;

import net.minecraft.world.phys.shapes.VoxelShape;

import it.unimi.dsi.fastutil.objects.Object2DoubleArrayMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import net.minecraft.client.player.ClientInput;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import sg.mx.EntityMixin_1159;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public class SimulatedPlayerInput implements MinecraftAccess {
   public final Player field20215;
   public final SimulatedPlayerInput.Nested248 field20216;
   public float field20217 = Float.NaN;
   public Vec3 field20218;
   public Vec3 field20219;
   public AABB field20220;
   public EntityDimensions field20221;
   public float field20222;
   public float field20223;
   public boolean field20224;
   public float field20225;
   public int field20226;
   public boolean field20227;
   public boolean field20228;
   public boolean field20229;
   public boolean field20230;
   public boolean field20231;
   public boolean field20232;
   public boolean field20233;
   public boolean field20234;
   private final Object2DoubleMap<TagKey<Fluid>> field20235;
   private final HashSet<TagKey<Fluid>> field20236;
   private int field20237 = 0;
   private boolean field20238 = false;
   private static final double field20239 = 0.5;
   private static final double field20240 = -70.0;
   private static final double field20241 = 0.003;
   private static final double field20242 = 0.003;
   private static final double field20243 = 0.003;
   private static final float field20244 = 0.98F;
   private static final float field20245 = 0.98F;
   private static final double field20246 = -0.2;
   private static final double field20247 = 0.085;
   private static final double field20248 = 0.06;
   private static final double field20249 = 0.1;
   private static final double field20250 = 0.08;
   private static final double field20251 = 0.01;
   private static final float field20252 = 0.9F;
   private static final float field20253 = 0.8F;
   private static final float field20254 = 0.02F;
   private static final float field20255 = 0.5F;
   private static final float field20256 = 0.54600006F;
   private static final float field20257 = 3.0F;
   private static final float field20258 = 3.0F;
   private static final float field20259 = 0.96F;
   private static final double field20260 = 0.2;
   private static final double field20261 = 0.8;
   private static final double field20262 = 0.6;
   private static final double field20263 = 0.3;
   private static final float field20264 = 0.02F;
   private static final double field20265 = 0.5;
   private static final double field20266 = 0.8;
   private static final double field20267 = 0.5;
   private static final double field20268 = 0.5;
   private static final double field20269 = 4.0;
   private static final double field20270 = 0.6;
   private static final double field20271 = 0.3;
   private static final float field20272 = (float) (Math.PI / 180.0);
   private static final double field20273 = 0.4;
   private static final double field20274 = -1.0;
   private static final double field20275 = 0.75;
   private static final double field20276 = -0.1;
   private static final double field20277 = 0.04;
   private static final double field20278 = 3.2;
   private static final double field20279 = 0.1;
   private static final double field20280 = 0.1;
   private static final double field20281 = 0.99;
   private static final double field20282 = 0.98;
   private static final double field20283 = 0.99;
   private static final float field20284 = 0.91F;
   private static final float field20285 = 0.91F;
   private static final double field20286 = 0.05;
   private static final double field20287 = 0.2;
   private static final double field20288 = -0.1;
   private static final double field20289 = 0.98F;
   private static final double field20290 = 0.6;
   private static final double field20291 = 0.2;
   private static final double field20292 = 1.0E-7;
   private static final float field20293 = (float) (Math.PI / 180.0);
   private static final float field20294 = (float) (Math.PI / 180.0);
   private static final float field20295 = 0.21600002F;
   private static final float field20296 = 0.02F;
   private static final float field20297 = 0.006F;
   private static final float field20298 = 0.1F;
   private static final double field20299 = 1.0E-7;
   private static final double field20300 = 0.2;
   private static final double field20301 = 0.2;
   private static final double field20302 = -0.15F;
   private static final double field20303 = 0.15F;
   private static final double field20304 = -0.15F;
   private static final double field20305 = 0.15F;
   private static final double field20306 = -0.15F;
   private static final double field20307 = 0.05;
   private static final double field20308 = -0.5;
   private static final double field20309 = -0.5;
   private static final double field20310 = -0.5;
   private static final double field20311 = 0.5;
   private static final double field20312 = 0.5;
   private static final float field20313 = 0.42F;
   private static final float field20314 = 0.1F;
   private static final double field20315 = 0.04F;
   private static final double field20316 = 0.5000001;
   private static final double field20317 = 0.4;
   private static final double field20318 = 0.4;
   private static final double field20319 = 0.014;
   private static final float field20320 = 0.8F;
   private static final double field20321 = 0.11111111F;
   private static final double field20322 = 0.001;
   private static final double field20323 = 0.4;
   private static final double field20324 = 0.003;
   private static final double field20325 = 0.003;
   private static final double field20326 = 0.0045;
   private static final double field20327 = 0.0045;
   private static final double field20328 = Math.PI;
   private static final double field20329 = 180.0;
   private static final double field20330 = Math.PI;
   private static final double field20331 = 180.0;

   private void method08883(Vec3 var1) {
      Vec3 var2 = var1;
      var2 = this.method08887(var2);
      Vec3 sx = this.method08902(var2);
      if (sx.lengthSqr() > field20299) {
         this.field20218 = this.field20218.add(sx);
         this.field20220 = this.field20221.makeBoundingBox(this.field20218);
      }

      boolean sxx = !Mth.equal(var1.x, sx.x);
      boolean sxxx = !Mth.equal(var1.z, sx.z);
      this.field20230 = sxx || sxxx;
      this.field20231 = var1.y != sx.y;
      this.field20229 = this.field20231 && var1.y < 0.0;
      if (!this.method08930()) {
         this.method08908();
      }

      if (this.field20229) {
         this.method08895();
      } else if (var1.y < 0.0) {
         this.field20225 = this.field20225 - (float)var1.y;
      }

      Vec3 sxxxx = this.field20219;
      if (this.field20230 || this.field20231) {
         this.field20219 = new Vec3(sxx ? 0.0 : sxxxx.x, this.field20231 ? 0.0 : sxxxx.y, sxxx ? 0.0 : sxxxx.z);
      }
   }

   protected boolean method08884() {
      return this.field20216.field20335.shift() || this.field20216.field20332;
   }

   private void method08885(float var1, Vec3 var2) {
      Vec3 var3 = this.method08907(var2, var1, this.field20222);
      this.field20219 = this.field20219.add(var3);
   }

   public static SimulatedPlayerInput method08886(Player var0, SimulatedPlayerInput.Nested248 var1) {
      return new SimulatedPlayerInput(
         var0,
         var1,
         var0.position(),
         var0.position().subtract(new Vec3(var0.xo, var0.yo, var0.zo)),
         var0.getBoundingBox(),
         var0.getYRot(),
         var0.getXRot(),
         var0.isSprinting(),
         (float)var0.fallDistance,
         ((LivingEntityMixin_1248)(Object)var0).getJumpDelay(),
         ((LivingEntityMixin_1248)(Object)var0).isJumping_(),
         var0.isFallFlying(),
         var0.onGround(),
         var0.horizontalCollision,
         var0.verticalCollision,
         var0.isInWater(),
         var0.isSwimming(),
         var0.isUnderWater(),
         method08918(var0),
         method08914(var0)
      );
   }

   private Vec3 method08887(Vec3 var1) {
      if (var1.y <= 0.0 && this.method08889()) {
         double var2 = var1.x;
         double var4 = var1.z;

         double var6;
         for (var6 = field20307;
            var2 != 0.0 && this.field20215.level().noCollision(this.field20215, this.field20220.move(var2, field20308, 0.0));
            var2 += var2 > 0.0 ? -var6 : var6
         ) {
            if (var2 < var6 && var2 >= -var6) {
               var2 = 0.0;
               break;
            }
         }

         while (var4 != 0.0 && this.field20215.level().noCollision(this.field20215, this.field20220.move(0.0, field20309, var4))) {
            if (var4 < var6 && var4 >= -var6) {
               var4 = 0.0;
               break;
            }

            var4 += var4 > 0.0 ? -var6 : var6;
         }

         while (var2 != 0.0 && var4 != 0.0 && this.field20215.level().noCollision(this.field20215, this.field20220.move(var2, field20310, var4))) {
            var2 = var2 < var6 && var2 >= -var6 ? 0.0 : (var2 > 0.0 ? var2 - var6 : var2 + var6);
            if (var4 < var6 && var4 >= -var6) {
               var4 = 0.0;
               break;
            }

            var4 += var4 > 0.0 ? -var6 : var6;
         }

         if (var1.x != var2 || var1.z != var4) {
            this.field20238 = true;
         }

         if (this.method08884()) {
            var1 = new Vec3(var2, var1.y, var4);
         }
      }

      return var1;
   }

   public SimulatedPlayerInput method08888() {
      SimulatedPlayerInput var1 = new SimulatedPlayerInput(
         this.field20215,
         this.field20216,
         this.field20218,
         this.field20219,
         this.field20220,
         this.field20222,
         this.field20223,
         this.field20224,
         this.field20225,
         this.field20226,
         this.field20227,
         this.field20228,
         this.field20229,
         this.field20230,
         this.field20231,
         this.field20232,
         this.field20233,
         this.field20234,
         new Object2DoubleArrayMap(this.field20235),
         new HashSet<>(this.field20236)
      );
      var1.field20217 = this.field20217;
      var1.field20221 = this.field20221;
      var1.field20237 = this.field20237;
      return var1;
   }

   private boolean method08889() {
      return this.field20229
         || this.field20225 < field20311 && !this.field20215.level().noCollision(this.field20215, this.field20220.move(0.0, this.field20225 - field20312, 0.0));
   }

   public BlockPos method08890(Vec3 var1) {
      return new BlockPos(Mth.floor(var1.x), Mth.floor(var1.y), Mth.floor(var1.z));
   }

   public BlockState method08891(BlockPos var1) {
      return this.field20215.level().getBlockState(var1);
   }

   private Vec3 method08892(float var1, float var2) {
      float var3 = (float)(var1 * field20328 / field20329);
      float var4 = (float)(-var2 * field20330 / field20331);
      float var5 = Mth.cos(var4);
      float var6 = Mth.sin(var4);
      float var7 = Mth.cos(var3);
      float var8 = Mth.sin(var3);
      return new Vec3(var6 * var7, -var8, var5 * var7);
   }

   private void method08893() {
      this.field20234 = this.field20236.contains(FluidTags.WATER);
      this.field20236.clear();
      double var1 = this.method08901() - field20321;
      if (!(
         this.field20215.getVehicle() instanceof Boat var4 && !var4.isUnderWater() && var4.getBoundingBox().maxY >= var1 && var4.getBoundingBox().minY <= var1
      )) {
         BlockPos var8 = BlockPos.containing(this.field20218.x, var1, this.field20218.z);
         FluidState var5 = this.field20215.level().getFluidState(var8);
         double var6 = var8.getY() + var5.getHeight(this.field20215.level(), var8);
         if (var6 > var1) {
            this.field20236.addAll(var5.typeHolder().tags().toList());
         }
      }
   }

   public static SimulatedPlayerInput method08894(SimulatedPlayerInput.Nested248 var0) {
      LocalPlayer var1 = mc.player;
      return new SimulatedPlayerInput(
         var1,
         var0,
         var1.position(),
         var1.getDeltaMovement(),
         var1.getBoundingBox(),
         var1.getYRot(),
         var1.getXRot(),
         var1.isSprinting(),
         (float)var1.fallDistance,
         ((LivingEntityMixin_1248)(Object)var1).getJumpDelay(),
         ((LivingEntityMixin_1248)(Object)var1).isJumping_(),
         var1.isFallFlying(),
         var1.onGround(),
         var1.horizontalCollision,
         var1.verticalCollision,
         var1.isInWater(),
         var1.isSwimming(),
         var1.isUnderWater(),
         method08918(var1),
         method08914(var1)
      );
   }

   private void method08895() {
      this.field20225 = 0.0F;
   }

   private boolean method08896() {
      return this.field20216.field20333 <= 0.0F || this.field20216.field20335.shift() || this.field20230 || this.method08930() && !this.method08926();
   }

   public void method08897() {
      this.field20237++;
      this.field20238 = false;
      if (!(this.field20218.y <= field20240)) {
         this.field20216.update();
         this.method08908();
         this.method08893();
         this.method08912();
         this.method08925();
         if (this.field20226 > 0) {
            this.field20226--;
         }

         this.field20227 = this.field20216.field20335.jump();
         double var1 = this.field20219.x;
         double var3 = this.field20219.y;
         double var5 = this.field20219.z;
         if (Math.abs(this.field20219.x) < field20241) {
            var1 = 0.0;
         }

         if (Math.abs(this.field20219.y) < field20242) {
            var3 = 0.0;
         }

         if (Math.abs(this.field20219.z) < field20243) {
            var5 = 0.0;
         }

         if (this.field20229) {
            this.field20228 = false;
         }

         this.field20219 = new Vec3(var1, var3, var5);
         if (this.field20227) {
            double var7 = this.method08917() ? this.method08911(FluidTags.LAVA) : this.method08911(FluidTags.WATER);
            boolean var9 = this.method08930() && var7 > 0.0;
            double var10 = this.method08937();
            if (!var9 || this.field20229 && !(var7 > var10)) {
               if (!this.method08917() || this.field20229 && !(var7 > var10)) {
                  if ((this.field20229 || var9 && var7 <= var10) && this.field20226 == 0) {
                     this.method08932();
                     this.field20226 = 10;
                  }
               } else {
                  this.method08909(FluidTags.LAVA);
               }
            } else {
               this.method08909(FluidTags.WATER);
            }
         }

         float var12 = this.field20216.field20334 * field20244;
         float var8 = this.field20216.field20333 * field20245;
         float var13 = 0.0F;
         if (this.method08921(MobEffects.SLOW_FALLING) || this.method08921(MobEffects.LEVITATION)) {
            this.method08895();
         }

         this.method08928(new Vec3(var12, var13, var8));
      }
   }

   public Vec3 method08898() {
      return this.field20215.position();
   }

   private boolean method08899(BlockPos var1, BlockState var2) {
      if (!var2.getValue(TrapDoorBlock.OPEN)) {
         return false;
      }

      BlockState var3 = this.field20215.level().getBlockState(var1.below());
      return var3.is(Blocks.LADDER) && var3.getValue(LadderBlock.FACING).equals(var2.getValue(TrapDoorBlock.FACING));
   }

   private Vec3 method08900() {
      return this.method08892(this.field20223, this.field20222);
   }

   private double method08901() {
      return this.field20218.y + this.field20215.getEyeHeight();
   }

   private Vec3 method08902(Vec3 var1) {
      AABB var2 = this.field20221.makeBoundingBox(this.field20218);
      List<VoxelShape> var3 = Collections.emptyList();
      Vec3 var4;
      if (var1.lengthSqr() == 0.0) {
         var4 = var1;
      } else {
         var4 = Entity.collideBoundingBox(this.field20215, var1, var2, this.field20215.level(), var3);
      }

      boolean var5 = var1.x != var4.x;
      boolean var6 = var1.y != var4.y;
      boolean var7 = var1.z != var4.z;
      boolean var8 = this.field20229 || var6 && var1.y < 0.0;
      if (this.field20215.maxUpStep() > 0.0F && var8 && (var5 || var7)) {
         Vec3 var9 = Entity.collideBoundingBox(this.field20215, new Vec3(var1.x, this.field20215.maxUpStep(), var1.z), var2, this.field20215.level(), var3);
         Vec3 var10 = Entity.collideBoundingBox(
            this.field20215, new Vec3(0.0, this.field20215.maxUpStep(), 0.0), var2.expandTowards(var1.x, 0.0, var1.z), this.field20215.level(), var3
         );
         Vec3 var11 = Entity.collideBoundingBox(this.field20215, new Vec3(var1.x, 0.0, var1.z), var2.move(var10), this.field20215.level(), var3).add(var10);
         if (var10.y < this.field20215.maxUpStep() && var11.horizontalDistanceSqr() > var9.horizontalDistanceSqr()) {
            var9 = var11;
         }

         if (var9.horizontalDistanceSqr() > var4.horizontalDistanceSqr()) {
            return var9.add(Entity.collideBoundingBox(this.field20215, new Vec3(0.0, -var9.y + var1.y, 0.0), var2.move(var9), this.field20215.level(), var3));
         }
      }

      return var4;
   }

   public static SimulatedPlayerInput method08903(Player var0, int var1) {
      SimulatedPlayerInput var2 = method08886(var0, SimulatedPlayerInput.Nested248.guessInput(var0));

      for (int var3 = 0; var3 < var1; var3++) {
         var2.method08897();
      }

      return var2;
   }

   private float method08904(float var1) {
      return this.field20229 ? this.method08922() * (field20295 / (var1 * var1 * var1)) : this.method08906();
   }

   private Vec3 method08905(Vec3 var1, float var2) {
      this.method08885(this.method08904(var2), var1);
      this.field20219 = this.method08924(this.field20219);
      this.method08883(this.field20219);
      Vec3 var3 = this.field20219;
      BlockPos var4 = this.method08890(this.field20218);
      BlockState var5 = this.method08891(var4);
      if ((this.field20230 || this.field20227)
         && (this.method08941() || var5 != null && var5.is(Blocks.POWDER_SNOW) && PowderSnowBlock.canEntityWalkOnPowderSnow(this.field20215))) {
         var3 = new Vec3(var3.x, field20291, var3.z);
      }

      return var3;
   }

   private float method08906() {
      float var1 = field20296;
      return this.field20216.field20335.sprint() ? var1 + field20297 : var1;
   }

   private Vec3 method08907(Vec3 var1, float var2, float var3) {
      double var4 = var1.lengthSqr();
      if (var4 < field20292) {
         return Vec3.ZERO;
      }

      Vec3 var6 = (var4 > 1.0 ? var1.normalize() : var1).scale(var2);
      float var7 = Mth.sin(var3 * field20293);
      float var8 = Mth.cos(var3 * field20294);
      return new Vec3(var6.x * var8 - var6.z * var7, var6.y, var6.z * var8 + var6.x * var7);
   }

   private void method08908() {
      if (this.field20215.getVehicle() instanceof Boat) {
         Boat var1 = (Boat)this.field20215.getVehicle();
         if (!var1.isUnderWater()) {
            this.field20232 = false;
            return;
         }
      }

      if (this.method08940(FluidTags.WATER, field20319)) {
         this.method08895();
         this.field20232 = true;
      } else {
         this.field20232 = false;
      }
   }

   private void method08909(TagKey<Fluid> var1) {
      this.field20219 = this.field20219.add(0.0, field20315, 0.0);
   }

   public SimulatedPlayerInput method08910() {
      SimulatedPlayerInput var1 = new SimulatedPlayerInput(
         this.field20215,
         this.field20216,
         this.field20218,
         this.field20219,
         this.field20220,
         this.field20222,
         this.field20223,
         this.field20224,
         this.field20225,
         this.field20226,
         this.field20227,
         this.field20228,
         this.field20229,
         this.field20230,
         this.field20231,
         this.field20232,
         this.field20233,
         this.field20234,
         new Object2DoubleArrayMap(this.field20235),
         new HashSet<>(this.field20236)
      );
      var1.field20221 = this.field20221;
      return var1;
   }

   public double method08911(TagKey<Fluid> var1) {
      return this.field20235.getDouble(var1);
   }

   private void method08912() {
      if (this.field20224 && this.method08896()) {
         this.field20224 = false;
      }

      if (!this.field20224 && this.method08913()) {
         this.field20224 = true;
      }
   }

   private boolean method08913() {
      return this.field20216.field20335.sprint()
         && this.field20216.field20333 > field20320
         && !this.field20216.field20335.shift()
         && !this.field20230
         && !this.field20215.isUsingItem()
         && !this.field20215.isPassenger()
         && (!this.method08930() || this.method08926());
   }

   private static HashSet<TagKey<Fluid>> method08914(Player var0) {
      HashSet var1 = new HashSet();
      if (var0.isEyeInFluid(FluidTags.WATER)) {
         var1.add(FluidTags.WATER);
      }

      if (var0.isEyeInFluid(FluidTags.LAVA)) {
         var1.add(FluidTags.LAVA);
      }

      return var1;
   }

   private boolean method08915() {
      return this.field20224;
   }

   private boolean method08916(AABB var1) {
      return this.field20215.level().noCollision(this.field20215, var1) && !this.field20215.level().containsAnyLiquid(var1);
   }

   public boolean method08917() {
      return this.field20235.getDouble(FluidTags.LAVA) > 0.0;
   }

   private static Object2DoubleMap<TagKey<Fluid>> method08918(Player var0) {
      Object2DoubleArrayMap var1 = new Object2DoubleArrayMap();
      double var2 = var0.getFluidHeight(FluidTags.WATER);
      if (var2 > 0.0) {
         var1.put(FluidTags.WATER, var2);
      }

      double var4 = var0.getFluidHeight(FluidTags.LAVA);
      if (var4 > 0.0) {
         var1.put(FluidTags.LAVA, var4);
      }

      return var1;
   }

   public static boolean method08919(int var0) {
      if (mc.player != null && mc.player.input != null && var0 > 0) {
         SimulatedPlayerInput var1 = method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(mc.player.input.keyPresses));
         if (!var1.field20224) {
            return true;
         }

         for (int var2 = 0; var2 < var0; var2++) {
            var1.method08897();
            if (!var1.field20224) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private BlockPos method08920() {
      return BlockPos.containing(this.field20218.x, this.field20220.minY - field20316, this.field20218.z);
   }

   public boolean method08921(Holder<MobEffect> var1) {
      MobEffectInstance var2 = this.field20215.getEffect(var1);
      return var2 != null && var2.getDuration() >= this.field20237;
   }

   private float method08922() {
      return Float.isNaN(this.field20217) ? field20298 : this.field20217;
   }

   private boolean method08923(double var1, double var3, double var5) {
      return this.method08916(this.field20220.move(var1, var3, var5));
   }

   private Vec3 method08924(Vec3 var1) {
      if (!this.method08941()) {
         return var1;
      }

      this.method08895();
      double var2 = Mth.clamp(var1.x, field20302, field20303);
      double var4 = Mth.clamp(var1.z, field20304, field20305);
      double var6 = Math.max(var1.y, field20306);
      if (var6 < 0.0 && !this.method08891(this.method08890(this.field20218)).is(Blocks.SCAFFOLDING) && this.field20215.isSuppressingSlidingDownLadder()) {
         var6 = 0.0;
      }

      return new Vec3(var2, var6, var4);
   }

   private void method08925() {
      if (this.field20233) {
         this.field20233 = this.method08915() && this.method08930() && !this.field20215.isPassenger();
      } else {
         this.field20233 = this.method08915()
            && this.method08926()
            && !this.field20215.isPassenger()
            && this.field20215.level().getFluidState(this.method08890(this.field20218)).is(FluidTags.WATER);
      }
   }

   public boolean method08926() {
      return this.field20234 && this.method08930();
   }

   private float method08927() {
      float var1 = 0.0F;
      Block var2 = this.method08891(this.method08890(this.field20218)).getBlock();
      if (var2 != null) {
         var1 = var2.getJumpFactor();
      }

      float var3 = 0.0F;
      Block var4 = this.method08891(this.method08920()).getBlock();
      if (var4 != null) {
         var3 = var4.getJumpFactor();
      }

      return var1 == 1.0F ? var3 : var1;
   }

   private void method08928(Vec3 var1) {
      if (this.field20233 && !this.field20215.isPassenger()) {
         double var2 = this.method08900().y;
         double var4 = var2 < field20246 ? field20247 : field20248;
         BlockPos var6 = new BlockPos(Mth.floor(this.field20218.x), Mth.floor(this.field20218.y + 1.0 - field20249), Mth.floor(this.field20218.z));
         if (var2 <= 0.0 || this.field20216.field20335.jump() || !this.field20215.level().getBlockState(var6).getFluidState().isEmpty()) {
            this.field20219 = this.field20219.add(0.0, (var2 - this.field20219.y) * var4, 0.0);
         }
      }

      double var19 = this.field20219.y;
      double var20 = field20250;
      boolean var21 = this.field20219.y <= 0.0;
      if (this.field20219.y <= 0.0 && this.method08921(MobEffects.SLOW_FALLING)) {
         var20 = field20251;
         this.method08895();
      }

      if (this.method08930() && this.field20215.isAffectedByFluids()) {
         double var25 = this.field20218.y;
         float var28 = this.method08915() ? field20252 : field20253;
         float var30 = field20254;
         float var32 = (float)this.method08938(Attributes.WATER_MOVEMENT_EFFICIENCY);
         if (!this.field20229) {
            var32 *= field20255;
         }

         if (var32 > 0.0F) {
            var28 += (field20256 - var28) * var32 / field20257;
            var30 += (this.method08922() - var30) * var32 / field20258;
         }

         if (this.method08921(MobEffects.DOLPHINS_GRACE)) {
            var28 = field20259;
         }

         this.method08885(var30, var1);
         this.method08883(this.field20219);
         Vec3 var33 = this.field20219;
         if (this.field20230 && this.method08941()) {
            var33 = new Vec3(var33.x, field20260, var33.z);
         }

         this.field20219 = var33.multiply(var28, field20261, var28);
         Vec3 var34 = this.field20215.getFluidFallingAdjustedMovement(var20, var21, this.field20219);
         this.field20219 = var34;
         if (this.field20230 && this.method08923(var34.x, var34.y + field20262 - this.field20218.y + var25, var34.z)) {
            this.field20219 = new Vec3(var34.x, field20263, var34.z);
         }
      } else if (this.method08917() && this.field20215.isAffectedByFluids()) {
         double var24 = this.field20218.y;
         this.method08885(field20264, var1);
         this.method08883(this.field20219);
         if (this.method08911(FluidTags.LAVA) <= this.method08937()) {
            this.field20219 = this.field20219.multiply(field20265, field20266, field20267);
            this.field20219 = this.field20215.getFluidFallingAdjustedMovement(var20, var21, this.field20219);
         } else {
            this.field20219 = this.field20219.scale(field20268);
         }

         if (!this.field20215.isNoGravity()) {
            this.field20219 = this.field20219.add(0.0, -var20 / field20269, 0.0);
         }

         if (this.field20230 && this.method08923(this.field20219.x, this.field20219.y + field20270 - this.field20218.y + var24, this.field20219.z)) {
            this.field20219 = new Vec3(this.field20219.x, field20271, this.field20219.z);
         }
      } else if (this.field20228) {
         Vec3 var9 = this.field20219;
         Vec3 var10 = this.method08900();
         float var11 = this.field20223 * field20272;
         double var12 = Math.sqrt(var10.x * var10.x + var10.z * var10.z);
         double var14 = this.field20219.horizontalDistance();
         double var16 = var10.length();
         float var18 = Mth.cos(var11);
         var18 = (float)(var18 * (var18 * Math.min(1.0, var16 / field20273)));
         var9 = this.field20219.add(0.0, var20 * (field20274 + var18 * field20275), 0.0);
         if (var9.y < 0.0 && var12 > 0.0) {
            double var7 = var9.y * field20276 * var18;
            var9 = var9.add(var10.x * var7 / var12, var7, var10.z * var7 / var12);
         }

         if (var11 < 0.0F && var12 > 0.0) {
            double var22 = var14 * -Mth.sin(var11) * field20277;
            var9 = var9.add(-var10.x * var22 / var12, var22 * field20278, -var10.z * var22 / var12);
         }

         if (var12 > 0.0) {
            var9 = var9.add((var10.x / var12 * var14 - var9.x) * field20279, 0.0, (var10.z / var12 * var14 - var9.z) * field20280);
         }

         this.field20219 = var9.multiply(field20281, field20282, field20283);
         this.method08883(this.field20219);
      } else {
         BlockPos var23 = this.method08920();
         float var8 = this.field20215.level().getBlockState(var23).getBlock().getFriction();
         float var27 = this.field20229 ? var8 * field20284 : field20285;
         Vec3 var29 = this.method08905(var1, var8);
         double var31 = var29.y;
         if (this.method08921(MobEffects.LEVITATION)) {
            MobEffectInstance var13 = this.method08933(MobEffects.LEVITATION);
            if (var13 != null) {
               var31 += (field20286 * (var13.getAmplifier() + 1) - var29.y) * field20287;
            }
         } else if (this.field20215.level().isClientSide() && !this.field20215.level().isLoaded(var23)) {
            var31 = this.field20218.y > this.field20215.level().getMaxY() ? field20288 : 0.0;
         } else if (!this.field20215.isNoGravity()) {
            var31 -= var20;
         }

         if (this.field20215.shouldDiscardFriction()) {
            this.field20219 = new Vec3(var29.x, var31, var29.z);
         } else {
            this.field20219 = new Vec3(var29.x * var27, var31 * field20289, var29.z * var27);
         }
      }

      if (this.field20215.getAbilities().flying && !this.field20215.isPassenger()) {
         this.field20219 = new Vec3(this.field20219.x, var19 * field20290, this.field20219.z);
         this.method08895();
      }
   }

   public static boolean method08929(int var0) {
      if (mc.player != null && mc.player.input != null) {
         SimulatedPlayerInput var1 = method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(mc.player.input.keyPresses));
         Input var2 = var1.field20216.field20335;
         var1.field20216.field20335 = new Input(false, false, false, false, var2.jump(), var2.shift(), false);

         for (int var3 = 0; var3 < var0; var3++) {
            var1.method08897();
         }

         return var1.field20224;
      } else {
         return false;
      }
   }

   private boolean method08930() {
      return this.field20232;
   }

   public static SimulatedPlayerInput method08931(int var0) {
      SimulatedPlayerInput var1 = method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(mc.player.input.keyPresses));

      for (int var2 = 0; var2 < var0; var2++) {
         var1.method08897();
      }

      return var1;
   }

   public void method08932() {
      this.field20219 = this.field20219.add(0.0, this.method08936() - this.field20219.y, 0.0);
      if (this.method08915()) {
         float var1 = (float)Math.toRadians(this.field20222);
         this.field20219 = this.field20219.add(-Mth.sin(var1) * field20300, 0.0, Mth.cos(var1) * field20301);
      }
   }

   public SimulatedPlayerInput(
      Player var1,
      SimulatedPlayerInput.Nested248 var2,
      Vec3 var3,
      Vec3 var4,
      AABB var5,
      float var6,
      float var7,
      boolean var8,
      float var9,
      int var10,
      boolean var11,
      boolean var12,
      boolean var13,
      boolean var14,
      boolean var15,
      boolean var16,
      boolean var17,
      boolean var18,
      Object2DoubleMap<TagKey<Fluid>> var19,
      HashSet<TagKey<Fluid>> var20
   ) {
      this.field20215 = var1;
      this.field20216 = var2;
      this.field20218 = var3;
      this.field20219 = var4;
      this.field20220 = var5;
      this.field20222 = var6;
      this.field20223 = var7;
      this.field20224 = var8;
      this.field20225 = var9;
      this.field20226 = var10;
      this.field20227 = var11;
      this.field20228 = var12;
      this.field20229 = var13;
      this.field20230 = var14;
      this.field20231 = var15;
      this.field20232 = var16;
      this.field20233 = var17;
      this.field20234 = var18;
      this.field20235 = var19;
      this.field20236 = var20;
      this.field20221 = ((EntityMixin_1159)(Object)var1).getDimensions_();
   }

   private MobEffectInstance method08933(Holder<MobEffect> var1) {
      MobEffectInstance var2 = this.field20215.getEffect(var1);
      return var2 != null && var2.getDuration() >= this.field20237 ? var2 : null;
   }

   public void method08934(EntityDimensions var1) {
      this.field20221 = var1;
      this.field20220 = var1.makeBoundingBox(this.field20218);
   }

   private boolean method08935() {
      AABB var1 = this.field20220.inflate(1.0);
      int var2 = Mth.floor(var1.minX);
      int var3 = Mth.ceil(var1.maxX);
      int var4 = Mth.floor(var1.minZ);
      int var5 = Mth.ceil(var1.maxZ);
      return !this.field20215.level().hasChunksAt(var2, var4, var3, var5);
   }

   private float method08936() {
      return field20313 * this.method08927() + this.method08939();
   }

   private double method08937() {
      return this.field20215.getEyeHeight() < field20317 ? 0.0 : field20318;
   }

   public double method08938(Holder<Attribute> var1) {
      return this.field20215.getAttributes().getValue(var1);
   }

   private float method08939() {
      if (this.method08921(MobEffects.JUMP_BOOST)) {
         MobEffectInstance var1 = this.method08933(MobEffects.JUMP_BOOST);
         return field20314 * (var1.getAmplifier() + 1);
      } else {
         return 0.0F;
      }
   }

   private boolean method08940(TagKey<Fluid> var1, double var2) {
      if (this.method08935()) {
         return false;
      }

      AABB var4 = this.field20220.deflate(field20322);
      int var5 = Mth.floor(var4.minX);
      int var6 = Mth.ceil(var4.maxX);
      int var7 = Mth.floor(var4.minY);
      int var8 = Mth.ceil(var4.maxY);
      int var9 = Mth.floor(var4.minZ);
      int var10 = Mth.ceil(var4.maxZ);
      double var11 = 0.0;
      boolean var13 = true;
      boolean var14 = false;
      Vec3 var15 = Vec3.ZERO;
      int var16 = 0;
      MutableBlockPos var17 = new MutableBlockPos();

      for (int var18 = var5; var18 < var6; var18++) {
         for (int var19 = var7; var19 < var8; var19++) {
            for (int var20 = var9; var20 < var10; var20++) {
               var17.set(var18, var19, var20);
               FluidState var21 = this.field20215.level().getFluidState(var17);
               if (var21.is(var1)) {
                  double var22 = var19 + var21.getHeight(this.field20215.level(), var17);
                  if (var22 >= var4.minY) {
                     var14 = true;
                     var11 = Math.max(var22 - var4.minY, var11);
                     if (var13) {
                        Vec3 var24 = var21.getFlow(this.field20215.level(), var17);
                        if (var11 < field20323) {
                           var24 = var24.scale(var11);
                        }

                        var15 = var15.add(var24);
                        var16++;
                     }
                  }
               }
            }
         }
      }

      if (var15.length() > 0.0) {
         if (var16 > 0) {
            var15 = var15.scale(1.0 / var16);
         }

         var15 = var15.scale(var2);
         if (Math.abs(this.field20219.x) < field20324 && Math.abs(this.field20219.z) < field20325 && var15.length() < field20326) {
            var15 = var15.normalize().scale(field20327);
         }

         this.field20219 = this.field20219.add(var15);
      }

      this.field20235.put(var1, var11);
      return var14;
   }

   public boolean method08941() {
      BlockPos var1 = this.method08890(this.field20218);
      BlockState var2 = this.method08891(var1);
      return var2.is(BlockTags.CLIMBABLE) ? true : var2.getBlock() instanceof TrapDoorBlock && this.method08899(var1, var2);
   }

   // $VF: Compiled from s
   public static class Nested248 extends ClientInput {
      public boolean field20332 = false;
      public float field20333;
      public float field20334;
      public Input field20335;
      public static final double field20336 = 0.121;
      private static final float field20337 = -1.0F;
      private static final float field20338 = -1.0F;
      private static final float field20339 = 0.3F;
      private static final float field20340 = 0.3F;
      private static final double field20341 = 0.014641;
      private static final double field20342 = 0.0025000000000000005;
      private static final float field20343 = 20.0F;

      public static SimulatedPlayerInput.Nested248 guessInput(Player var0) {
         Vec3 var1 = var0.position().subtract(new Vec3(var0.xo, var0.yo, var0.zo));
         double sx = var1.horizontalDistanceSqr();
         Input sxx = new Input(false, false, false, false, !var0.onGround(), var0.isShiftKeyDown(), sx >= field20341);
         if (sx > field20342) {
            double sxxx = MovementUtils.method05711(var1, var0.getYRot());
            double sxxxx = Mth.wrapDegrees(sxxx);
            sxx = MovementUtils.method05710(sxx, sxxxx, field20343);
         }

         return new SimulatedPlayerInput.Nested248(sxx);
      }

      public static SimulatedPlayerInput.Nested248 fromClientPlayer(Input var0) {
         return new SimulatedPlayerInput.Nested248(var0);
      }

      public void update() {
         if (this.field20335.forward() != this.field20335.backward()) {
            this.field20333 = this.field20335.forward() ? 1.0F : field20337;
         } else {
            this.field20333 = 0.0F;
         }

         if (this.field20335.left() == this.field20335.right()) {
            this.field20334 = 0.0F;
         } else {
            this.field20334 = this.field20335.left() ? 1.0F : field20338;
         }

         if (this.field20335.shift()) {
            this.field20334 = this.field20334 * field20339;
            this.field20333 = this.field20333 * field20340;
         }
      }

      @Override
      public String toString() {
         return "SimulatedPlayerInput(forwards={"
            + this.field20335.forward()
            + "}, backwards={"
            + this.field20335.backward()
            + "}, left={"
            + this.field20335.left()
            + "}, right={"
            + this.field20335.right()
            + "}, jumping={"
            + this.field20335.jump()
            + "}, sprinting="
            + this.field20335.sprint()
            + ", slowDown="
            + this.field20335.shift()
            + ")";
      }

      public Nested248(Input var1) {
         this.field20335 = var1;
      }
   }
}
