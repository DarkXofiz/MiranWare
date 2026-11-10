// Original binary: sg/ec/5UUYBkZbJ8UYZr0z
package sg.ec;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Vec3i;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public class ClientParticle implements MinecraftAccess {
   private static final AABB field02253 = new AABB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
   private static final double field02254 = Mth.square(ClientParticle.field02382);
   private static final double field02255 = 1.0E-5;
   private static final float field02256 = 0;
   private static final double field02257 = 0;
   private static final double field02258 = 0;
   private static final double field02259 = 0;
   private static final float field02260 = 0;
   private static final double field02261 = 0;
   private static final float field02262 = 0;
   private static final double field02263 = 0;
   private static final float field02264 = 0;
   private static final double field02265 = 0;
   private static final double field02266 = 0;
   private static final double field02267 = 0;
   private static final double field02268 = 0;
   private static final double field02269 = 0;
   private static final double field02270 = 0;
   private static final double field02271 = 0;
   private static final double field02272 = 0;
   private double field02273;
   private double field02274;
   private double field02275;
   private double field02276;
   private double field02277;
   private double field02278;
   private double field02279;
   private double field02280;
   private double field02281;
   private AABB field02282 = field02253;
   private boolean field02283;
   private boolean field02284 = true;
   private boolean field02285;
   private boolean field02286;
   private float field02287;
   private float field02288;
   private int field02289;
   private int field02290;
   private int field02291;
   private float field02292;
   private float field02293;
   private float field02294;
   private float field02295;
   private double field02296;
   private boolean field02297;
   private boolean field02298;
   private float field02299;
   private float field02300;
   private float field02301;
   private float field02302;
   private float field02303;
   private float field02304;
   private float field02305;
   private ParticleCollisionMode field02306;
   private ParticleInterpolationMode field02307;
   private double field02308;
   private static final float field02309 = 0.6F;
   private static final float field02310 = 1.8F;
   private static final float field02311 = 0.98F;
   private static final float field02312 = 0.2F;
   private static final String field02313 = "args";
   private static final float field02314 = 1.95F;
   private static final float field02315 = 0.6F;
   private static final float field02316 = 1.8F;
   private static final double field02317 = 0.04;
   private static final double field02318 = 1.1;
   private static final double field02319 = 1.1;
   private static final double field02320 = 0.7;
   private static final double field02321 = 0.7;
   private static final double field02322 = -0.04;
   private static final double field02323 = 0.986F;
   private static final double field02324 = 0.986F;
   private static final double field02325 = 4.0E-5;
   private static final double field02326 = 0.999F;
   private static final double field02327 = 0.999F;
   private static final double field02328 = 0.999F;
   private static final double field02329 = 0.9998F;
   private static final double field02330 = 0.015F;
   private static final double field02331 = 0.9998F;
   private static final double field02332 = 2.0;
   private static final double field02333 = 0.1;
   private static final double field02334 = 0.1;
   private static final double field02335 = 2.0;
   private static final double field02336 = 0.4;
   private static final double field02337 = 2.0;
   private static final double field02338 = 0.4;
   private static final double field02339 = 2.0;
   private static final double field02340 = 0.4;
   private static final double field02341 = 0.15;
   private static final double field02342 = 1.0E-8;
   private static final double field02343 = 0.4;
   private static final double field02344 = 0.4;
   private static final double field02345 = 0.1;
   private static final double field02346 = 0.4;
   private static final float field02347 = 0.9F;
   private static final double field02348 = 0.1F;
   private static final double field02349 = 2.0;
   private static final double field02350 = 0.5;
   private static final float field02351 = 0.9F;
   private static final double field02352 = 0.1F;
   private static final double field02353 = 2.0;
   private static final double field02354 = 0.5;
   private static final double field02355 = 0.01;
   private static final double field02356 = 0.2;
   private static final float field02357 = 0.9F;
   private static final double field02358 = 0.055;
   private static final double field02359 = 0.1F;
   private static final double field02360 = 2.0;
   private static final double field02361 = 2.0;
   private static final double field02362 = 0.01;
   private static final double field02363 = Math.PI;
   private static final double field02364 = 2.0;
   private static final double field02365 = 0.5;
   private static final double field02366 = 0.5;
   private static final float field02367 = 0.9F;
   private static final double field02368 = 1.0E-5;
   private static final double field02369 = 1.0E-5;
   private static final double field02370 = 2.25E-4;
   private static final double field02371 = 2.25E-4;
   private static final double field02372 = 2.0;
   private static final double field02373 = 2.0;
   private static final double field02374 = 2.0;
   private static final double field02375 = 2.0;
   private static final float field02376 = 1.0E-4F;
   private static final float field02377 = 1.0E-4F;
   private static final float field02378 = 3.0F;
   private static final float field02379 = 4.0F;
   private static final float field02380 = 0.9F;
   private static final float field02381 = 0.1F;
   private static final double field02382 = 100.0;

   public void method00998(boolean var1) {
      this.field02285 = var1;
   }

   public float method00999() {
      return this.field02304;
   }

   public float method01000() {
      return this.field02292;
   }

   private void method01001() {
      this.field02280 = field02322 * this.field02292;
      this.method01023(this.field02279, this.field02280, this.field02281);
      if (this.field02283) {
         this.field02280 = 0.0;
      }

      this.field02279 = this.field02279 * field02323;
      this.field02281 = this.field02281 * field02324;
      double var1 = this.field02279 * this.field02279 + this.field02281 * this.field02281;
      if (var1 < field02325) {
         this.field02285 = true;
         this.method01020();
      }
   }

   public float method01002() {
      return this.field02294;
   }

   public void method01003(double var1) {
      this.field02275 = var1;
   }

   public void method01004(boolean var1) {
      this.field02297 = var1;
   }

   public void method01005(int var1) {
      this.field02291 = var1;
   }

   private void method01006() {
      if (this.field02297) {
         this.method01001();
      } else {
         this.field02280 = this.field02280 - field02317 * this.field02292;
         this.method01023(this.field02279, this.field02280, this.field02281);
         if (!this.field02283 && this.field02277 > this.field02296) {
            this.field02296 = this.field02277;
         }

         if (this.field02298 && this.field02277 == this.field02274) {
            this.field02279 = this.field02279 * field02318;
            this.field02281 = this.field02281 * field02319;
         }

         this.field02279 = this.field02279 * this.field02293;
         this.field02280 = this.field02280 * this.field02293;
         this.field02281 = this.field02281 * this.field02293;
         if (this.field02283) {
            this.field02279 = this.field02279 * field02320;
            this.field02281 = this.field02281 * field02321;
         }
      }
   }

   public double method01007() {
      return this.field02275;
   }

   public boolean method01008() {
      return this.field02297;
   }

   private static float method01009(float var0) {
      float var1 = Math.clamp(var0, 0.0F, 1.0F);
      return var1 * var1 * (field02378 - 2.0F * var1);
   }

   public void method01010(float var1) {
      this.field02303 = var1;
   }

   public int method01011() {
      return this.field02290;
   }

   public void method01012(double var1) {
      this.field02279 = var1;
   }

   public double method01013(float var1) {
      return this.field02275 + (this.field02278 - this.field02275) * var1;
   }

   public float method01014(float var1) {
      return this.field02300 + (this.field02299 - this.field02300) * var1;
   }

   public void method01015() {
      this.field02286 = true;
   }

   public void method01016(float var1) {
      this.field02302 = var1;
   }

   public void method01017(float var1) {
      this.field02300 = var1;
   }

   public void method01018(double var1, double var3, double var5) {
      this.field02279 = var1;
      this.field02280 = var3;
      this.field02281 = var5;
   }

   public ParticleCollisionMode method01019() {
      return this.field02306;
   }

   private void method01020() {
      this.field02279 = 0.0;
      this.field02280 = 0.0;
      this.field02281 = 0.0;
   }

   public double method01021() {
      return this.field02281;
   }

   public ClientParticle(ClientParticle.Nested35 var1) {
      this.field02287 = field02309;
      this.field02288 = field02310;
      this.field02293 = field02311;
      this.field02302 = 1.0F;
      this.field02303 = 1.0F;
      this.field02304 = 1.0F;
      this.field02305 = field02312;
      this.field02306 = ParticleCollisionMode.SWEPT;
      this.field02307 = ParticleInterpolationMode.SMOOTH;
      this.method01036(var1);
   }

   public void method01022(double var1, double var3, double var5) {
      this.field02276 = var1;
      this.field02277 = var3;
      this.field02278 = var5;
      float var7 = this.field02287 / 2.0F;
      float var8 = this.field02288;
      this.method01078(new AABB(var1 - var7, var3, var5 - var7, var1 + var7, var3 + var8, var5 + var7));
   }

   public void method01023(double var1, double var3, double var5) {
      if (!this.field02285) {
         double var7 = var1;
         double var9 = var3;
         double var11 = var5;
         ClientLevel var13 = mc.level;
         if (this.field02284 && var13 != null && (var1 != 0.0 || var3 != 0.0 || var5 != 0.0)) {
            double var14 = var1 * var1 + var3 * var3 + var5 * var5;
            if (var14 < field02254) {
               Vec3 var16 = new Vec3(var1, var3, var5);
               AABB var17 = this.method01092();
               if (!CollisionUtils.method02657(var13, var17, var16)) {
                  Vec3 var18 = Entity.collideBoundingBox((Entity)null, var16, var17, var13, Collections.emptyList());
                  var1 = var18.x;
                  var3 = var18.y;
                  var5 = var18.z;
               }
            }
         }

         if (var1 != 0.0 || var3 != 0.0 || var5 != 0.0) {
            this.method01078(this.method01092().move(var1, var3, var5));
            this.method01057();
         }

         boolean var24 = var9 != var3;
         boolean var15 = var7 != var1 || var11 != var5;
         boolean var25 = var24 && var9 > 0.0;
         this.field02283 = var24 && var9 < 0.0;
         if (var7 != var1) {
            if (this.field02295 > 0.0F) {
               this.field02279 = -var7 * this.field02295;
               this.field02295 = this.field02295 * field02347;
               ThreadLocalRandom var26 = ThreadLocalRandom.current();
               double var30 = Math.abs(var7) * field02348;
               this.field02281 = this.field02281 + (var26.nextDouble() * field02349 - 1.0) * var30;
               this.field02280 = this.field02280 + var26.nextDouble() * var30 * field02350;
            } else {
               this.field02279 = 0.0;
            }
         }

         if (var11 != var5) {
            if (this.field02295 > 0.0F) {
               this.field02281 = -var11 * this.field02295;
               this.field02295 = this.field02295 * field02351;
               ThreadLocalRandom var27 = ThreadLocalRandom.current();
               double var31 = Math.abs(var11) * field02352;
               this.field02279 = this.field02279 + (var27.nextDouble() * field02353 - 1.0) * var31;
               this.field02280 = this.field02280 + var27.nextDouble() * var31 * field02354;
            } else {
               this.field02281 = 0.0;
            }
         }

         if (var24) {
            if (this.field02295 <= 0.0F) {
               this.field02280 = 0.0;
            } else if (this.field02283) {
               double var28 = Math.max(0.0, this.field02296 - this.field02277);
               double var19 = Math.sqrt(Math.max(var28, field02355)) * field02356 * this.field02295;
               this.field02295 = this.field02295 * field02357;
               this.field02296 = this.field02277;
               if (var19 > field02358) {
                  this.field02280 = var19;
                  ThreadLocalRandom var21 = ThreadLocalRandom.current();
                  double var22 = var19 * field02359;
                  this.field02279 = this.field02279 + (var21.nextDouble() * field02360 - 1.0) * var22;
                  this.field02281 = this.field02281 + (var21.nextDouble() * field02361 - 1.0) * var22;
               } else {
                  this.field02280 = 0.0;
                  if (var19 > field02362) {
                     ThreadLocalRandom var32 = ThreadLocalRandom.current();
                     double var33 = var32.nextDouble() * field02363 * field02364;
                     this.field02279 = this.field02279 + Math.cos(var33) * var19 * field02365;
                     this.field02281 = this.field02281 + Math.sin(var33) * var19 * field02366;
                  }

                  this.field02297 = true;
               }
            } else if (var25) {
               this.field02280 = -Math.abs(var9) * this.field02295;
               this.field02295 = this.field02295 * field02367;
            }
         }

         if (!this.field02297) {
            double var29 = this.field02279 * this.field02279 + this.field02280 * this.field02280 + this.field02281 * this.field02281;
            if (this.field02283 && !var15 && Math.abs(var9) >= field02368 && Math.abs(var3) < field02369 && var29 <= field02370) {
               this.field02285 = true;
               this.field02279 = 0.0;
               this.field02280 = 0.0;
               this.field02281 = 0.0;
            } else if (var29 > field02371) {
               this.field02285 = false;
            }
         }
      }
   }

   public float method01024() {
      return this.field02299;
   }

   public double method01025() {
      return this.field02273;
   }

   public float method01026() {
      return this.field02287;
   }

   public boolean method01027() {
      return this.field02298;
   }

   public void method01028(ParticleInterpolationMode var1) {
      this.field02307 = var1;
   }

   private void method01029() {
      this.method01090();
      this.field02279 = this.field02279 * field02326;
      this.field02280 = this.field02280 * field02327;
      this.field02281 = this.field02281 * field02328;
      this.method01022(this.field02276 + this.field02279, this.field02277 + this.field02280, this.field02278 + this.field02281);
      this.field02279 = this.field02279 * field02329;
      this.field02280 = this.field02280 - field02330 * this.field02292;
      this.field02281 = this.field02281 * field02331;
   }

   public boolean method01030() {
      return this.field02283;
   }

   public float method01031() {
      return this.field02302;
   }

   public void method01032(int var1) {
      this.field02290 = var1;
   }

   public float method01033() {
      return this.field02288;
   }

   public ClientParticle(double var1, double var3, double var5, double var7, double var9, double var11) {
      this(new ClientParticle.Nested35(var1, var3, var5).method01117(var7, var9, var11));
   }

   public float method01034() {
      return this.field02295;
   }

   private static int method01035() {
      return (int)(field02379 / (ThreadLocalRandom.current().nextFloat() * field02380 + field02381));
   }

   public void method01036(ClientParticle.Nested35 var1) {
      Objects.requireNonNull(var1, field02313);
      this.field02286 = false;
      this.field02289 = 0;
      this.field02285 = false;
      this.field02283 = false;
      this.field02284 = var1.field02394;
      this.field02292 = var1.field02391;
      this.field02293 = var1.field02392;
      this.field02294 = Mth.clamp(var1.field02393, 0.0F, field02314);
      this.field02295 = this.field02294;
      this.field02296 = var1.field02385;
      this.field02297 = false;
      this.field02298 = var1.field02395;
      this.field02299 = 0.0F;
      this.field02300 = 0.0F;
      this.field02301 = var1.field02400;
      this.field02302 = var1.field02401;
      this.field02303 = var1.field02402;
      this.field02304 = var1.field02403;
      this.field02305 = var1.field02404;
      this.field02291 = Math.max(0, var1.field02398);
      this.field02306 = var1.field02405;
      this.field02307 = var1.field02406;
      this.field02308 = var1.field02407 <= 0.0 ? 0.0 : var1.field02407 * var1.field02407;
      this.field02287 = field02315;
      this.field02288 = field02316;
      this.field02282 = field02253;
      this.method01054(var1.field02396, var1.field02397);
      this.method01022(var1.field02384, var1.field02385, var1.field02386);
      this.field02273 = this.field02276;
      this.field02274 = this.field02277;
      this.field02275 = this.field02278;
      if (var1.field02399) {
         this.method01068(var1.field02387, var1.field02388, var1.field02389);
      } else {
         this.method01018(var1.field02387, var1.field02388, var1.field02389);
      }

      if (var1.field02390 <= 0) {
         this.field02290 = method01035();
      } else {
         this.field02290 = var1.field02390;
      }
   }

   public void method01037(double var1) {
      this.field02281 = var1;
   }

   public void method01038(float var1) {
      this.field02288 = var1;
   }

   public double method01039() {
      return this.field02296;
   }

   public int method01040() {
      return this.field02291;
   }

   public void method01041(boolean var1) {
      this.field02298 = var1;
   }

   public void method01042(double var1) {
      this.field02277 = var1;
   }

   public void method01043(double var1) {
      this.field02308 = var1;
   }

   public void method01044(float var1) {
      this.field02294 = var1;
   }

   public void method01045(float var1) {
      this.field02295 = var1;
   }

   public void method01046(double var1) {
      this.field02273 = var1;
   }

   public void method01047(double var1) {
      this.field02296 = var1;
   }

   public void method01048(boolean var1) {
      this.field02284 = var1;
   }

   public void method01049(float var1) {
      this.field02279 *= var1;
      this.field02280 = (this.field02280 - field02333) * var1 + field02334;
      this.field02281 *= var1;
   }

   public void method01050(int var1) {
      this.field02289 = var1;
   }

   public boolean method01051() {
      return !this.field02286;
   }

   public void method01052() {
      try {
         this.method01083();
      } catch (Throwable var2) {
         this.method01015();
      }
   }

   public double method01053() {
      return this.field02280;
   }

   protected void method01054(float var1, float var2) {
      if (var1 != this.field02287 || var2 != this.field02288) {
         this.field02287 = var1;
         this.field02288 = var2;
         AABB var3 = this.method01092();
         double var4 = (var3.minX + var3.maxX - var1) / field02372;
         double var6 = (var3.minZ + var3.maxZ - var1) / field02373;
         this.method01078(new AABB(var4, var3.minY, var6, var4 + this.field02287, var3.minY + this.field02288, var6 + this.field02287));
      }
   }

   public float method01055() {
      return this.field02305;
   }

   public void method01056(float var1) {
      this.field02304 = var1;
   }

   protected void method01057() {
      AABB var1 = this.method01092();
      this.field02276 = (var1.minX + var1.maxX) / field02374;
      this.field02277 = var1.minY;
      this.field02278 = (var1.minZ + var1.maxZ) / field02375;
   }

   public float method01058() {
      return this.field02301;
   }

   public void method01059(float var1) {
      this.field02292 = var1;
   }

   public void method01060(float var1) {
      this.field02301 = var1;
   }

   public void method01061(ParticleCollisionMode var1) {
      this.field02306 = var1;
   }

   public void method01062(double var1) {
      this.field02278 = var1;
   }

   public ClientParticle(double var1, double var3, double var5) {
      this(new ClientParticle.Nested35(var1, var3, var5));
   }

   public void method01063(float var1) {
      this.field02305 = var1;
   }

   public int method01064() {
      return this.field02289;
   }

   public float method01065() {
      return this.field02303;
   }

   public double method01066() {
      return this.field02278;
   }

   public double method01067(float var1) {
      return this.field02273 + (this.field02276 - this.field02273) * var1;
   }

   public void method01068(double var1, double var3, double var5) {
      ThreadLocalRandom var7 = ThreadLocalRandom.current();
      this.field02279 = var1 + (var7.nextDouble() * field02335 - 1.0) * field02336;
      this.field02280 = var3 + (var7.nextDouble() * field02337 - 1.0) * field02338;
      this.field02281 = var5 + (var7.nextDouble() * field02339 - 1.0) * field02340;
      double var8 = (var7.nextDouble() + var7.nextDouble() + 1.0) * field02341;
      double var10 = Math.sqrt(this.field02279 * this.field02279 + this.field02280 * this.field02280 + this.field02281 * this.field02281);
      if (!(var10 < field02342)) {
         this.field02279 = this.field02279 / var10 * var8 * field02343;
         this.field02280 = this.field02280 / var10 * var8 * field02344 + field02345;
         this.field02281 = this.field02281 / var10 * var8 * field02346;
      }
   }

   public double method01069(float var1) {
      return this.field02274 + (this.field02277 - this.field02274) * var1;
   }

   public boolean method01070() {
      return this.field02285;
   }

   public double method01071() {
      return this.field02277;
   }

   public void method01072(double var1) {
      this.field02276 = var1;
   }

   public void method01073(double var1) {
      this.field02274 = var1;
   }

   public void method01074(float var1) {
      this.field02293 = var1;
   }

   public void method01075(boolean var1) {
      this.field02286 = var1;
   }

   public boolean method01076() {
      return this.field02284;
   }

   public float method01077(float var1) {
      int var2 = Math.max(1, this.field02290);
      float var3 = Math.max(0.0F, this.field02289 - 1 + var1);
      float var4 = Math.min(1.0F, var3 / var2);
      if (var4 < this.field02305) {
         float var6 = var4 / Math.max(field02376, this.field02305);
         return this.field02302 + (this.field02303 - this.field02302) * method01009(var6);
      } else {
         float var5 = (var4 - this.field02305) / Math.max(field02377, 1.0F - this.field02305);
         return this.field02303 + (this.field02304 - this.field02303) * method01009(var5);
      }
   }

   public void method01078(AABB var1) {
      this.field02282 = var1;
   }

   public ParticleInterpolationMode method01079() {
      return this.field02307;
   }

   public void method01080(float var1) {
      this.field02287 = var1;
   }

   public double method01081() {
      return this.field02274;
   }

   public float method01082() {
      return this.field02300;
   }

   public void method01083() {
      if (!this.field02286) {
         this.field02273 = this.field02276;
         this.field02274 = this.field02277;
         this.field02275 = this.field02278;
         this.field02300 = this.field02299;
         this.field02299 = this.field02299 + this.field02301;
         int var1 = this.field02289++;
         if (var1 >= this.field02290) {
            this.method01015();
         } else if (var1 >= this.field02291) {
            if (this.field02285) {
               this.method01020();
            } else {
               switch (this.field02306) {
                  case SWEPT:
                     this.method01006();
                     break;
                  case RICOCHET:
                     this.method01029();
               }
            }
         }
      }
   }

   public void method01084(double var1) {
      this.field02280 = var1;
   }

   public double method01085() {
      return this.field02279;
   }

   public void method01086(boolean var1) {
      this.field02283 = var1;
   }

   public float method01087() {
      return this.field02293;
   }

   public boolean method01088() {
      return this.field02286;
   }

   public double method01089() {
      return this.field02308;
   }

   private void method01090() {
      if (this.field02284) {
         ClientLevel var1 = mc.level;
         if (var1 != null && mc.player != null) {
            if (this.field02279 != 0.0 || this.field02280 != 0.0 || this.field02281 != 0.0) {
               Vec3 var2 = new Vec3(this.field02276, this.field02277, this.field02278);
               Vec3 var3 = var2.add(this.field02279, this.field02280, this.field02281);
               BlockHitResult var4 = var1.clip(new ClipContext(var2, var3, Block.COLLIDER, Fluid.NONE, mc.player));
               if (var4.getType() == Type.BLOCK) {
                  Vec3i var5 = var4.getDirection().getUnitVec3i();
                  double var6 = field02332 * (this.field02279 * var5.getX() + this.field02280 * var5.getY() + this.field02281 * var5.getZ());
                  this.field02279 = this.field02279 - var5.getX() * var6;
                  this.field02280 = this.field02280 - var5.getY() * var6;
                  this.field02281 = this.field02281 - var5.getZ() * var6;
               }
            }
         }
      }
   }

   public void method01091(float var1) {
      this.field02299 = var1;
   }

   public AABB method01092() {
      return this.field02282;
   }

   public double method01093() {
      return this.field02276;
   }

   // $VF: Compiled from s
   public static class Nested35 {
      private final double field02384;
      private final double field02385;
      private final double field02386;
      private double field02387;
      private double field02388;
      private double field02389;
      private int field02390;
      private float field02391;
      private float field02392;
      private float field02393;
      private boolean field02394;
      private boolean field02395;
      private float field02396;
      private float field02397;
      private int field02398;
      private boolean field02399;
      private float field02400;
      private float field02401;
      private float field02402;
      private float field02403;
      private float field02404;
      private ParticleCollisionMode field02405;
      private ParticleInterpolationMode field02406;
      private double field02407;
      private static final float field02408 = 0.98F;
      private static final float field02409 = 0.2F;
      private static final float field02410 = 0.2F;
      private static final float field02411 = 0.2F;
      private static final float field02412 = 1.95F;

      public ClientParticle.Nested35 method01094(float var1, float var2, float var3, float var4) {
         this.field02401 = var1;
         this.field02402 = var2;
         this.field02403 = var3;
         this.field02404 = var4;
         return this;
      }

      public double method01095() {
         return this.field02388;
      }

      public float method01096() {
         return this.field02397;
      }

      public ClientParticle.Nested35 method01097(double var1) {
         this.field02407 = var1;
         return this;
      }

      public double method01098() {
         return this.field02384;
      }

      public float method01099() {
         return this.field02396;
      }

      public ClientParticle.Nested35 method01100(float var1) {
         this.field02393 = Mth.clamp(var1, 0.0F, field02412);
         return this;
      }

      public float method01101() {
         return this.field02404;
      }

      public float method01102() {
         return this.field02400;
      }

      public float method01103() {
         return this.field02402;
      }

      public ParticleCollisionMode method01104() {
         return this.field02405;
      }

      public ClientParticle.Nested35 method01105(ParticleInterpolationMode var1) {
         this.field02406 = var1 == null ? ParticleInterpolationMode.SMOOTH : var1;
         return this;
      }

      public ClientParticle.Nested35 method01106(boolean var1) {
         this.field02399 = var1;
         return this;
      }

      public double method01107() {
         return this.field02387;
      }

      public float method01108() {
         return this.field02403;
      }

      public ClientParticle.Nested35 method01109(boolean var1) {
         this.field02394 = var1;
         return this;
      }

      public ClientParticle.Nested35 method01110(float var1) {
         this.field02392 = var1;
         return this;
      }

      public double method01111() {
         return this.field02385;
      }

      public ClientParticle.Nested35 method01112(float var1) {
         this.field02391 = var1;
         return this;
      }

      public ClientParticle.Nested35 method01113(boolean var1) {
         this.field02395 = var1;
         return this;
      }

      public ParticleInterpolationMode method01114() {
         return this.field02406;
      }

      public ClientParticle.Nested35 method01115(int var1) {
         this.field02398 = Math.max(0, var1);
         return this;
      }

      public int method01116() {
         return this.field02398;
      }

      public ClientParticle.Nested35 method01117(double var1, double var3, double var5) {
         this.field02387 = var1;
         this.field02388 = var3;
         this.field02389 = var5;
         return this;
      }

      public int method01118() {
         return this.field02390;
      }

      public Nested35(double var1, double var3, double var5) {
         this.field02392 = field02408;
         this.field02394 = true;
         this.field02396 = field02409;
         this.field02397 = field02410;
         this.field02401 = 1.0F;
         this.field02402 = 1.0F;
         this.field02403 = 1.0F;
         this.field02404 = field02411;
         this.field02405 = ParticleCollisionMode.SWEPT;
         this.field02406 = ParticleInterpolationMode.SMOOTH;
         this.field02384 = var1;
         this.field02385 = var3;
         this.field02386 = var5;
      }

      public boolean method01119() {
         return this.field02395;
      }

      public ClientParticle.Nested35 method01120(float var1, float var2) {
         this.field02396 = var1;
         this.field02397 = var2;
         return this;
      }

      public boolean method01121() {
         return this.field02399;
      }

      public float method01122() {
         return this.field02393;
      }

      public float method01123() {
         return this.field02391;
      }

      public double method01124() {
         return this.field02407;
      }

      public float method01125() {
         return this.field02392;
      }

      public double method01126() {
         return this.field02389;
      }

      public ClientParticle.Nested35 method01127(int var1) {
         this.field02390 = var1;
         return this;
      }

      public ClientParticle.Nested35 method01128(float var1) {
         this.field02400 = var1;
         return this;
      }

      public ClientParticle.Nested35 method01129(ParticleCollisionMode var1) {
         this.field02405 = var1 == null ? ParticleCollisionMode.SWEPT : var1;
         return this;
      }

      public double method01130() {
         return this.field02386;
      }

      public float method01131() {
         return this.field02401;
      }

      public boolean method01132() {
         return this.field02394;
      }
   }
}
