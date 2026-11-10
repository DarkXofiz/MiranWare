// Original binary: sg/ec/6UGELtQUxtLDX9hV
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class ElytraBooster extends ClientModule {
   private static final double field03195 = 0.1;
   private static final double field03196 = 0;
   private static final double field03197 = 0;
   private static final double field03198 = 0;
   private static final double field03199 = 0;
   private static final double field03200 = 0;
   private static final double field03201 = 0;
   private static final double field03202 = 0;
   private static final double field03203 = 0;
   private static final double field03204 = 0;
   private static final double field03205 = 0;
   private static final double field03206 = 0;
   private static final double field03207 = 0;
   private static final double field03208 = 0;
   private static final double field03209 = 0;
   private static final double field03210 = 0;
   private static final double field03211 = 0;
   private static final double field03212 = 0;
   private static final int field03213 = 0;
   private static final int field03214 = 0;
   private static final double field03215 = 0;
   private static final double field03216 = 0;
   private static final double field03217 = 0;
   private static final double field03218 = 0;
   private static final double field03219 = 0;
   private final NumberSetting<Float>[] field03220 = new NumberSetting[9];
   private final NumberSetting<Float>[] field03221 = new NumberSetting[9];
   private final ModeSetting field03222;
   private final ModeSetting field03223;
   private final ModeSetting field03224;
   private final ToggleSetting field03225;
   private final NumberSetting<Float> field03226;
   private final NumberSetting<Float> field03227;
   private double field03228;
   private int field03229;
   private Vec3 field03230;
   private int field03231;
   private float field03232;
   private float field03233;
   private float field03234;
   private float field03235;
   private int field03236;
   private Vec3 field03237;
   private int field03238;
   private final NumberSetting<Float> field03239;
   private final NumberSetting<Float> field03240;
   private final ActionListSetting field03241;
   private static final String field03242 = "Режим";
   private static final String field03243 = "Обычный";
   private static final String field03244 = "Кастомный";
   private static final String field03245 = "Клиентский";
   private static final String field03246 = "Обычный";
   private static final String field03247 = "Античит";
   private static final String field03248 = "ReallyWorld";
   private static final String field03249 = "Grim";
   private static final String field03250 = "ReallyWorld";
   private static final String field03251 = "Версия";
   private static final String field03252 = "1.17.1";
   private static final String field03253 = "1.18.1";
   private static final String field03254 = "1.18.1";
   private static final String field03255 = "Адаптация скорости";
   private static final String field03256 = "Дистанция от вектора";
   private static final float field03257 = 8.0F;
   private static final float field03258 = 0.5F;
   private static final float field03259 = 6.0F;
   private static final String field03260 = "Сила замедления";
   private static final float field03261 = 0.1F;
   private static final float field03262 = 0.05F;
   private static final String field03263 = "speedX";
   private static final float field03264 = 1.5F;
   private static final float field03265 = 2.5F;
   private static final float field03266 = 0.01F;
   private static final float field03267 = 1.5F;
   private static final String field03268 = "speedY";
   private static final float field03269 = 1.5F;
   private static final float field03270 = 2.5F;
   private static final float field03271 = 0.01F;
   private static final float field03272 = 1.5F;
   private static final String field03273 = "Пресеты";
   private static final String field03274 = "Default";
   private static final String field03275 = "Default Grim";
   private static final String field03276 = "ReallyWorld Rage";
   private static final String field03277 = "Elytra Booster";
   private static final String field03278 = "0 - 5";
   private static final String field03279 = "5 - 10";
   private static final String field03280 = "10 - 15";
   private static final String field03281 = "15 - 20";
   private static final String field03282 = "20 - 25";
   private static final String field03283 = "25 - 30";
   private static final String field03284 = "30 - 35";
   private static final String field03285 = "35 - 40";
   private static final String field03286 = "40 - 45";
   private static final float field03287 = 1.5F;
   private static final float field03288 = 2.5F;
   private static final float field03289 = 0.01F;
   private static final float field03290 = 1.5F;
   private static final float field03291 = 1.5F;
   private static final float field03292 = 2.5F;
   private static final float field03293 = 0.01F;
   private static final float field03294 = 1.5F;
   private static final String field03295 = "Кастомный";
   private static final String field03296 = "Клиентский";
   private static final String field03297 = "Обычный";
   private static final float field03298 = 1.5F;
   private static final float field03299 = 1.5F;
   private static final double field03300 = 5.0;
   private static final double field03301 = 1.0E-6;
   private static final double field03302 = -1.0;
   private static final double field03303 = 0.05;
   private static final double field03304 = 0.05;
   private static final double field03305 = 35.0;
   private static final double field03306 = 5.0;
   private static final double field03307 = 15.0;
   private static final double field03308 = 75.0;
   private static final double field03309 = 0.8;
   private static final double field03310 = 0.3;
   private static final double field03311 = -1.0;
   private static final double field03312 = 25.0;
   private static final double field03313 = 0.5;
   private static final double field03314 = -0.3;
   private static final double field03315 = 0.25;
   private static final double field03316 = 0.001;
   private static final double field03317 = 1.0E-6;
   private static final double field03318 = 0.6;
   private static final double field03319 = -1.7;
   private static final double field03320 = -0.05;
   private static final double field03321 = -0.05;
   private static final double field03322 = 1.7;
   private static final double field03323 = 0.9;
   private static final double field03324 = 1.7;
   private static final double field03325 = 0.05;
   private static final double field03326 = 0.05;
   private static final double field03327 = 1.7;
   private static final double field03328 = 0.9;
   private static final double field03329 = 0.1;
   private static final double field03330 = 0.5;
   private static final double field03331 = 0.5;
   private static final double field03332 = 0.5;
   private static final float field03333 = 1.5F;
   private static final float field03334 = 1.5F;
   private static final float field03335 = 1.5F;
   private static final float field03336 = 1.5F;
   private static final String field03337 = "Grim";
   private static final String field03338 = "1.17.1";
   private static final double field03339 = 1.7;
   private static final double field03340 = 1.68;
   private static final double field03341 = 1.93;
   private static final double field03342 = 1.9;
   private static final double field03343 = 2.5;
   private static final double field03344 = 2.5;
   private static final double field03345 = 0.5;
   private static final double field03346 = 0.1;
   private static final double field03347 = 0.5;
   private static final double field03348 = 0.45;
   private static final float field03349 = 0.5F;
   private static final float field03350 = -90.0F;
   private static final float field03351 = 90.0F;
   private static final float field03352 = -90.0F;
   private static final float field03353 = 90.0F;
   private static final float field03354 = 0.5F;
   private static final double field03355 = 16.0;
   private static final double field03356 = Double.MAX_VALUE;
   private static final double field03357 = 0.5;
   private static final double field03358 = 0.04;
   private static final double field03359 = 0.02;
   private static final double field03360 = 0.1;
   private static final double field03361 = 0.5;
   private static final double field03362 = 0.1;
   private static final double field03363 = 0.5;
   private static final double field03364 = 0.1;
   private static final double field03365 = 0.5;
   private static final float field03366 = (float) (Math.PI / 180.0);
   private static final double field03367 = 0.003;
   private static final double field03368 = 0.003;
   private static final double field03369 = 0.003;
   private static final double field03370 = 0.01;
   private static final double field03371 = -1.0;
   private static final double field03372 = 0.75;
   private static final double field03373 = -0.1;
   private static final double field03374 = 0.04;
   private static final double field03375 = 3.2;
   private static final double field03376 = 0.1;
   private static final double field03377 = 0.1;
   private static final double field03378 = 0.99;
   private static final double field03379 = 0.98;
   private static final double field03380 = 0.99;
   private static final double field03381 = -1.0;
   private static final double field03382 = 1.3;
   private static final double field03383 = 8.0;
   private static final double field03384 = 40.0;
   private static final double field03385 = -1.0;
   private static final double field03386 = -1.0;
   private static final double field03387 = -0.05;
   private static final double field03388 = -0.05;
   private static final double field03389 = 1.7;
   private static final double field03390 = 0.05;
   private static final double field03391 = 0.05;
   private static final double field03392 = 1.7;
   private static final double field03393 = 0.001;
   private static final double field03394 = 2.5;
   private static final double field03395 = 0.05;
   private static final double field03396 = 0.05;
   private static final double field03397 = 1.7;
   private static final double field03398 = -0.05;
   private static final double field03399 = -0.05;
   private static final double field03400 = 1.7;
   private static final double field03401 = 0.5;
   private static final double field03402 = 0.1;
   private static final double field03403 = 0.5;
   private static final double field03404 = 0.5;
   private static final double field03405 = 0.5;
   private static final double field03406 = 1.0E-9;
   private static final double field03407 = 2.5;
   private static final double field03408 = 0.5;
   private static final double field03409 = 0.1;
   private static final double field03410 = 0.5;
   private static final double field03411 = 0.1;
   private static final double field03412 = 2.0;
   private static final double field03413 = 4.0;
   private static final double field03414 = 2.0;
   private static final double field03415 = 2.0;
   private static final float field03416 = 5.0F;
   private static final float field03417 = 5.0F;
   private static final float field03418 = 90.0F;
   private static final float field03419 = 180.0F;
   private static final float field03420 = 45.0F;
   private static final float field03421 = 90.0F;
   private static final String field03422 = "Кастомный";
   private static final String field03423 = "Кастомный";
   private static final String field03424 = "Кастомный";
   private static final float field03425 = 1.58F;
   private static final float field03426 = 1.62F;
   private static final float field03427 = 1.65F;
   private static final float field03428 = 1.69F;
   private static final float field03429 = 1.73F;
   private static final float field03430 = 1.79F;
   private static final float field03431 = 1.79F;
   private static final float field03432 = 1.79F;
   private static final float field03433 = 1.81F;
   private static final float field03434 = 1.54F;
   private static final float field03435 = 1.57F;
   private static final float field03436 = 1.58F;
   private static final float field03437 = 1.6F;
   private static final float field03438 = 1.63F;
   private static final float field03439 = 1.7F;
   private static final float field03440 = 1.89F;
   private static final float field03441 = 2.01F;
   private static final float field03442 = 2.24F;
   private static final float field03443 = 1.58F;
   private static final float field03444 = 1.62F;
   private static final float field03445 = 1.65F;
   private static final float field03446 = 1.69F;
   private static final float field03447 = 1.73F;
   private static final float field03448 = 1.81F;
   private static final float field03449 = 1.97F;
   private static final float field03450 = 2.09F;
   private static final float field03451 = 2.19F;
   private static final float field03452 = 1.56F;
   private static final float field03453 = 1.61F;
   private static final float field03454 = 1.74F;
   private static final float field03455 = 1.76F;
   private static final float field03456 = 1.77F;
   private static final float field03457 = 1.88F;
   private static final float field03458 = 1.9F;
   private static final float field03459 = 2.01F;
   private static final float field03460 = 2.24F;
   private static final float field03461 = 1.5F;
   private static final float field03462 = 1.5F;
   private static final float field03463 = 1.5F;
   private static final float field03464 = 1.5F;
   private static final float field03465 = 1.5F;
   private static final float field03466 = 1.5F;
   private static final float field03467 = 1.5F;
   private static final float field03468 = 1.5F;
   private static final float field03469 = 1.5F;
   private static final float field03470 = 1.5F;
   private static final float field03471 = 1.5F;
   private static final float field03472 = 1.5F;
   private static final float field03473 = 1.5F;
   private static final float field03474 = 1.5F;
   private static final float field03475 = 1.5F;
   private static final float field03476 = 1.5F;
   private static final float field03477 = 1.5F;
   private static final float field03478 = 1.5F;
   private static final String field03479 = "Обычный";
   private static final String field03480 = "Обычный";
   private static final String field03481 = "Клиентский";
   private static final String field03482 = "Клиентский";

   public Vec3 method01351() {
      return this.field03230;
   }

   public ElytraBooster() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field03222 = new ModeSetting(field03242).method05597(field03243, field03244, field03245).method03017(field03246).method03023(this);
      this.field03223 = new ModeSetting(field03247)
         .method05597(field03248, field03249)
         .method03017(field03250)
         .method03025(() -> this.field03222.method05600(field03482))
         .method03023(this);
      this.field03224 = new ModeSetting(field03251)
         .method05597(field03252, field03253)
         .method03017(field03254)
         .method03025(() -> this.field03222.method05600(field03481))
         .method03023(this);
      this.field03225 = new ToggleSetting(field03255).method03017(false).method03023(this);
      this.field03226 = new NumberSetting<Float>(field03256)
         .method10835(1.0F)
         .method10838(field03257)
         .method10834(field03258)
         .method03017(field03259)
         .method03025(this.field03225::method05999)
         .method03023(this);
      this.field03227 = new NumberSetting<Float>(field03260)
         .method10835(field03261)
         .method10838(1.0F)
         .method10834(field03262)
         .method03017(1.0F)
         .method03025(this.field03225::method05999)
         .method03023(this);
      this.field03232 = Float.NaN;
      this.field03233 = Float.NaN;
      this.field03234 = Float.NaN;
      this.field03235 = Float.NaN;
      this.field03236 = -1;
      this.field03238 = -1;
      this.field03239 = new NumberSetting<Float>(field03263)
         .method10835(field03264)
         .method10838(field03265)
         .method10834(field03266)
         .method03017(field03267)
         .method03025(() -> this.field03222.method05600(field03480))
         .method03023(this);
      this.field03240 = new NumberSetting<Float>(field03268)
         .method10835(field03269)
         .method10838(field03270)
         .method10834(field03271)
         .method03017(field03272)
         .method03025(() -> this.field03222.method05600(field03479))
         .method03023(this);
      this.field03241 = new ActionListSetting(field03273).method02723(field03274, () -> {
         this.field03220[0].method03014(field03461);
         this.field03220[1].method03014(field03462);
         this.field03220[2].method03014(field03463);
         this.field03220[3].method03014(field03464);
         this.field03220[4].method03014(field03465);
         this.field03220[5].method03014(field03466);
         this.field03220[6].method03014(field03467);
         this.field03220[7].method03014(field03468);
         this.field03220[8].method03014(field03469);
         this.field03221[0].method03014(field03470);
         this.field03221[1].method03014(field03471);
         this.field03221[2].method03014(field03472);
         this.field03221[3].method03014(field03473);
         this.field03221[4].method03014(field03474);
         this.field03221[5].method03014(field03475);
         this.field03221[6].method03014(field03476);
         this.field03221[7].method03014(field03477);
         this.field03221[8].method03014(field03478);
      }).method02723(field03275, () -> {
         this.field03220[0].method03014(field03443);
         this.field03220[1].method03014(field03444);
         this.field03220[2].method03014(field03445);
         this.field03220[3].method03014(field03446);
         this.field03220[4].method03014(field03447);
         this.field03220[5].method03014(field03448);
         this.field03220[6].method03014(field03449);
         this.field03220[7].method03014(field03450);
         this.field03220[8].method03014(field03451);
         this.field03221[0].method03014(field03452);
         this.field03221[1].method03014(field03453);
         this.field03221[2].method03014(field03454);
         this.field03221[3].method03014(field03455);
         this.field03221[4].method03014(field03456);
         this.field03221[5].method03014(field03457);
         this.field03221[6].method03014(field03458);
         this.field03221[7].method03014(field03459);
         this.field03221[8].method03014(field03460);
      }).method02723(field03276, () -> {
         this.field03220[0].method03014(field03425);
         this.field03220[1].method03014(field03426);
         this.field03220[2].method03014(field03427);
         this.field03220[3].method03014(field03428);
         this.field03220[4].method03014(field03429);
         this.field03220[5].method03014(field03430);
         this.field03220[6].method03014(field03431);
         this.field03220[7].method03014(field03432);
         this.field03220[8].method03014(field03433);
         this.field03221[0].method03014(field03434);
         this.field03221[1].method03014(field03435);
         this.field03221[2].method03014(field03436);
         this.field03221[3].method03014(field03437);
         this.field03221[4].method03014(field03438);
         this.field03221[5].method03014(field03439);
         this.field03221[6].method03014(field03440);
         this.field03221[7].method03014(field03441);
         this.field03221[8].method03014(field03442);
      }).method03025(() -> this.field03222.method05600(field03424)).method03023(this);
      Object var10001 = null;
      var10001 = null;
      var10001 = -1;
      this.method03935(field03277);
      String[] var1 = new String[]{field03278, field03279, field03280, field03281, field03282, field03283, field03284, field03285, field03286};

      for (int var2 = 0; var2 < this.field03220.length; var2++) {
         this.field03220[var2] = new NumberSetting<Float>("yaw " + var1[var2])
            .method10835(field03287)
            .method10838(field03288)
            .method10834(field03289)
            .method03017(field03290)
            .method03025(() -> this.field03222.method05600(field03423))
            .method03023(this);
      }

      for (int var3 = 0; var3 < this.field03221.length; var3++) {
         this.field03221[var3] = new NumberSetting<Float>("pitch " + var1[var3])
            .method10835(field03291)
            .method10838(field03292)
            .method10834(field03293)
            .method03017(field03294)
            .method03025(() -> this.field03222.method05600(field03422))
            .method03023(this);
      }
   }

   private Vec2 method01352(Vec3 var1, Vec3 var2, Vec3 var3, double var4, double var6, double var8) {
      float var10 = mc.player.getYRot();
      float var11 = mc.player.getXRot();
      float var12 = Mth.wrapDegrees(var10 - this.method01373(var10));
      float var13 = var11 - this.method01412(var11);
      float[] var14 = new float[]{var11, Mth.clamp(var11 + var13 * field03349, field03350, field03351), Mth.clamp(var11 + var13, field03352, field03353)};
      Vec3[] var15 = new Vec3[]{var1, Vec3.directionFromRotation(var14[1], var10 + var12 * field03354), Vec3.directionFromRotation(var14[2], var10 + var12)};
      Vec3[] var16 = new Vec3[var15.length];
      Vec3[] var17 = new Vec3[var15.length];
      double var18 = this.method01411(var1);
      Vec3 var20 = new Vec3(
         method01382(method01367(var1.x, var18), var1.x, var8),
         method01382(method01367(var1.y, var18), var1.y, var8),
         method01382(method01367(var1.z, var18), var1.z, var8)
      );
      Vec3 var21 = new Vec3(
         method01372(method01364(var1.x, var18), var1.x, var8),
         method01372(method01364(var1.y, var18), var1.y, var8),
         method01372(method01364(var1.z, var18), var1.z, var8)
      );

      for (int var22 = 0; var22 < var15.length; var22++) {
         Vec3 var23 = this.method01390(var2, var15[var22], var14[var22]);
         var16[var22] = new Vec3(
            var23.x + Math.min(0.0, var20.x - var2.x), var23.y + Math.min(0.0, var20.y - var2.y), var23.z + Math.min(0.0, var20.z - var2.z)
         );
         var17[var22] = new Vec3(
            var23.x + Math.max(0.0, var21.x - var2.x), var23.y + Math.max(0.0, var21.y - var2.y), var23.z + Math.max(0.0, var21.z - var2.z)
         );
      }

      double var26 = this.method01386(var1, var15, var14, var16, var17, var3, var4, var6, true);
      double var24 = this.method01386(var1, var15, var14, var16, var17, var3, var4, var26, false);
      var26 = this.method01386(var1, var15, var14, var16, var17, var3, var24, var6, true);
      var24 = this.method01386(var1, var15, var14, var16, var17, var3, var4, var26, false);
      return new Vec2((float)var24, (float)var26);
   }

   private boolean method01353(double var1, double var3, double var5, double var7, float var9) {
      return method01371(var1, var3, var5, var7, var9);
   }

   private Vec2 method01354() {
      if (mc.player == null) {
         return new Vec2(field03333, field03334);
      }

      float var1 = Mth.wrapDegrees(mc.player.getYRot());
      float var2 = Math.abs(Mth.wrapDegrees(mc.player.getXRot()));
      AttackAura var3 = ModuleManager.INSTANCE.method08219();
      ElytraTarget var4 = ModuleManager.INSTANCE.method08186();
      var1 = this.method01389(var1);
      var2 = this.method01389(var2);
      float var5 = this.method01409(var1);
      float var6 = this.method01360(var2);
      if (var6 > var5) {
         var5 = var6;
      }

      return new Vec2(var5, var6);
   }

   public ModeSetting method01355() {
      return this.field03224;
   }

   public ToggleSetting method01356() {
      return this.field03225;
   }

   public NumberSetting<Float>[] method01357() {
      return this.field03220;
   }

   public int method01358() {
      return this.field03231;
   }

   public float method01359() {
      return this.field03235;
   }

   private float method01360(float var1) {
      int var2 = (int)(var1 / field03417);
      if (var2 >= this.field03221.length) {
         var2 = this.field03221.length - 1;
      }

      return this.field03221[var2].method03022();
   }

   public int method01361() {
      return this.field03238;
   }

   private double method01362(
      Vec3 var1, Vec3[] var2, float[] var3, Vec3[] var4, Vec3[] var5, Vec3 var6, double var7, double var9, double var11, double var13, boolean var15
   ) {
      for (int var16 = 0; var16 < 8; var16++) {
         double var17 = (var11 + var13) * field03357;
         if (this.method01384(var1, var2, var3, var4, var5, var6, var7, var9, var17, var15) <= 0.0) {
            var11 = var17;
         } else {
            var13 = var17;
         }
      }

      return var11;
   }

   private static double method01364(double var0, double var2) {
      double var4 = Math.sqrt(Math.max(0.0, 1.0 - var0 * var0));
      return Mth.clamp(Math.cos(var2) * var0 - Math.sin(var2) * var4, field03385, 1.0);
   }

   public Vec3 method01365() {
      return this.field03237;
   }

   public double method01366() {
      return this.field03228;
   }

   private static double method01367(double var0, double var2) {
      double var4 = Math.sqrt(Math.max(0.0, 1.0 - var0 * var0));
      return Mth.clamp(Math.cos(var2) * var0 + Math.sin(var2) * var4, field03386, 1.0);
   }

   public NumberSetting<Float> method01368() {
      return this.field03240;
   }

   private Vec3 method01370(Vec3 var1, Vec3 var2, double var3, double var5) {
      return var2.add(
         var1.x * field03360 + (var1.x * var3 - var2.x) * field03361,
         var1.y * field03362 + (var1.y * var5 - var2.y) * field03363,
         var1.z * field03364 + (var1.z * var3 - var2.z) * field03365
      );
   }

   private static boolean method01371(double var0, double var2, double var4, double var6, float var8) {
      double var9 = Math.max(field03319, (Math.min(field03320, var2) + Math.min(field03321, var4)) * field03322) * field03323;
      double var11 = Math.min(field03324, (Math.max(field03325, var2) + Math.max(field03326, var4)) * field03327) * field03328;
      double var13 = field03329 + var8 * field03330;
      double var15 = var6 * field03331 + var2 * var13;
      double var17 = var6 * field03332 + var0 * var13;
      return var17 >= Math.min(var15, var9) && var17 <= Math.max(var15, var11);
   }

   private static double method01372(double var0, double var2, double var4) {
      return Math.min(var4, (Math.max(field03390, var0) + Math.max(field03391, var2)) * field03392);
   }

   private float method01373(float var1) {
      if (mc.player != null && this.field03236 >= 0 && mc.player.tickCount - this.field03236 <= 1) {
         float var2 = this.field03236 == mc.player.tickCount ? this.field03234 : this.field03232;
         return Float.isNaN(var2) ? var1 : var2;
      } else {
         return var1;
      }
   }

   public NumberSetting<Float> method01374() {
      return this.field03239;
   }

   private Vec3 method01375(Vec3 var1) {
      float var2 = this.method01373(Float.NaN);
      float var3 = this.method01412(Float.NaN);
      return !Float.isNaN(var2) && !Float.isNaN(var3) ? Vec3.directionFromRotation(var3, var2) : var1;
   }

   private boolean method01377(Vec3 var1, Vec3 var2, Vec3 var3, Vec3 var4, float var5, float var6) {
      return this.method01353(var1.x, var2.x, var3.x, var4.x, var5)
         && this.method01353(var1.y, var2.y, var3.y, var4.y, var6)
         && this.method01353(var1.z, var2.z, var3.z, var4.z, var5);
   }

   public ModeSetting method01378() {
      return this.field03223;
   }

   private static double method01379(double var0, double var2, double var4) {
      double var6 = var4 - var2 <= field03358 ? 0.0 : field03359;
      if (var0 < var2 + var6) {
         return var2 + var6 - var0;
      } else {
         return var0 > var4 - var6 ? var0 - (var4 - var6) : 0.0;
      }
   }

   public NumberSetting<Float>[] method01380() {
      return this.field03221;
   }

   private static double method01382(double var0, double var2, double var4) {
      return Math.max(-var4, (Math.min(field03387, var0) + Math.min(field03388, var2)) * field03389);
   }

   public NumberSetting<Float> method01383() {
      return this.field03226;
   }

   private double method01384(Vec3 var1, Vec3[] var2, float[] var3, Vec3[] var4, Vec3[] var5, Vec3 var6, double var7, double var9, double var11, boolean var13) {
      Vec3 var14 = this.method01370(var1, var6, var13 ? var7 : var11, var13 ? var11 : var9);
      double var15 = 0.0;

      for (int var17 = 0; var17 < var2.length; var17++) {
         Vec3 var18 = this.method01390(var14, var2[var17], var3[var17]);
         double var19 = var13
            ? method01379(var18.y, var4[var17].y, var5[var17].y)
            : method01379(var18.x, var4[var17].x, var5[var17].x) + method01379(var18.z, var4[var17].z, var5[var17].z);
         if (var19 > var15) {
            var15 = var19;
         }
      }

      return var15;
   }

   public NumberSetting<Float> method01385() {
      return this.field03227;
   }

   private double method01386(Vec3 var1, Vec3[] var2, float[] var3, Vec3[] var4, Vec3[] var5, Vec3 var6, double var7, double var9, boolean var11) {
      double var12 = var11 ? var9 : var7;
      if (var12 <= 0.0) {
         return var12;
      }

      if (this.method01384(var1, var2, var3, var4, var5, var6, var7, var9, var12, var11) <= 0.0) {
         return var12;
      }

      double var14 = (var12 - 0.0) / field03355;
      double var16 = var12;
      double var18 = field03356;

      for (int var20 = 1; var20 <= 16; var20++) {
         double var21 = var12 - var14 * var20;
         double var23 = this.method01384(var1, var2, var3, var4, var5, var6, var7, var9, var21, var11);
         if (var23 < var18) {
            var18 = var23;
            var16 = var21;
         }

         if (var23 <= 0.0) {
            return this.method01362(var1, var2, var3, var4, var5, var6, var7, var9, var21, var21 + var14, var11);
         }
      }

      return var16;
   }

   private Vec3 method01387(Vec3 var1, float var2, float var3) {
      AttackAura var4 = ModuleManager.INSTANCE.method08219();
      ElytraTarget var5 = ModuleManager.INSTANCE.method08186();
      LivingEntity var6 = AttackAura.field00785;
      if (mc.player == null || var6 == null) {
         return this.method01400(var1);
      }

      if (!mc.player.isFallFlying()) {
         return this.method01400(var1);
      }

      if (!var4.method03937() || !var4.field00787 || !var5.method03937()) {
         return this.method01400(var1);
      }

      if (var4.field00788 == null) {
         return this.method01400(var1);
      }

      double var7 = mc.player.distanceTo(var6);
      if (var7 > field03300) {
         return this.method01400(var1);
      }

      Vec3 var9 = var4.field00788.subtract(mc.player.getEyePosition());
      if (var9.lengthSqr() < field03301) {
         return this.method01400(var1);
      }

      Vec3 var10 = var9.normalize();
      double var11 = Mth.clamp(var1.dot(var10), field03302, 1.0);
      double var13 = Math.toDegrees(Math.acos(var11));
      if (var13 < 1.0) {
         return this.method01400(var1);
      }

      int var15 = mc.player.tickCount;
      if (var15 - this.field03229 > 2) {
         this.field03228 = 0.0;
      }

      if (var15 != this.field03229 && this.field03231 > 0) {
         this.field03231--;
      }

      this.field03229 = var15;
      Vec3 var16 = var6.getDeltaMovement();
      if (this.field03230 != null) {
         double var17 = var16.horizontalDistance();
         double var19 = this.field03230.horizontalDistance();
         if (var17 > field03303 && var19 > field03304) {
            double var21 = (var16.x * this.field03230.x + var16.z * this.field03230.z) / (var17 * var19);
            if (var21 < Math.cos(Math.toRadians(field03305))) {
               this.field03231 = 6;
            }
         }
      }

      this.field03230 = var16;
      Vec3 var35 = mc.player.getDeltaMovement();
      double var18 = 1.0 - Mth.clamp(var7 / field03306, 0.0, 1.0);
      double var20 = 1.0 - Mth.clamp((var13 - field03307) / field03308, 0.0, 1.0);
      double var22 = Mth.clamp(1.0 - var35.length() / field03309, 0.0, 1.0);
      double var24 = Math.max(var18, Math.max(var20, var22));
      if (this.field03231 > 0) {
         var24 *= field03310;
      }

      Vec3 var26 = Vec3.directionFromRotation(mc.player.xRotO, mc.player.yRotO);
      double var27 = Mth.clamp(var1.dot(var26), field03311, 1.0);
      double var29 = Math.toDegrees(Math.acos(var27));
      var24 *= 1.0 - Mth.clamp(var29 / field03312, 0.0, field03313);
      this.field03228 = this.field03228 + Mth.clamp(var24 - this.field03228, field03314, field03315);
      double var31 = this.field03228;
      if (var31 < field03316) {
         return var1;
      }

      for (int var33 = 0; var33 < 6; var33++) {
         Vec3 var34 = var1.lerp(var10, var31);
         if (var34.lengthSqr() < field03317) {
            break;
         }

         var34 = var34.normalize();
         if (this.method01377(var34, var1, var26, var35, var2, var3)) {
            return var34;
         }

         var31 *= field03318;
      }

      return var1;
   }

   private float method01389(float var1) {
      return method01393(var1);
   }

   private Vec3 method01390(Vec3 var1, Vec3 var2, float var3) {
      float var4 = var3 * field03366;
      double var5 = Math.sqrt(var2.x * var2.x + var2.z * var2.z);
      double var7 = Math.abs(var1.x) < field03367 ? 0.0 : var1.x;
      double var9 = Math.abs(var1.y) < field03368 ? 0.0 : var1.y;
      double var11 = Math.abs(var1.z) < field03369 ? 0.0 : var1.z;
      double var13 = Math.sqrt(var7 * var7 + var11 * var11);
      double var15 = mc.player.getAttributeValue(Attributes.GRAVITY);
      if (var9 <= 0.0 && mc.player.hasEffect(MobEffects.SLOW_FALLING)) {
         var15 = Math.min(var15, field03370);
      }

      double var17 = Mth.square(Math.cos(var4));
      double var19 = var7;
      double var21 = var9 + var15 * (field03371 + var17 * field03372);
      double var23 = var11;
      if (var21 < 0.0 && var5 > 0.0) {
         double var25 = var21 * field03373 * var17;
         var19 += var2.x * var25 / var5;
         var21 += var25;
         var23 += var2.z * var25 / var5;
      }

      if (var4 < 0.0F && var5 > 0.0) {
         double var27 = var13 * -Mth.sin(var4) * field03374;
         var19 += -var2.x * var27 / var5;
         var21 += var27 * field03375;
         var23 += -var2.z * var27 / var5;
      }

      if (var5 > 0.0) {
         var19 += (var2.x / var5 * var13 - var19) * field03376;
         var23 += (var2.z / var5 * var13 - var23) * field03377;
      }

      return new Vec3(var19 * field03378, var21 * field03379, var23 * field03380);
   }

   public int method01391() {
      return this.field03229;
   }

   private double method01392(Vec3 var1, Vec3 var2, double var3) {
      double var5 = field03404 * var1.x;
      double var7 = field03405 * var1.z;
      double var9 = var5 * var5 + var7 * var7;
      if (var9 < field03406) {
         return field03407;
      }

      double var11 = field03408 * var2.x + field03409 * var1.x;
      double var13 = field03410 * var2.z + field03411 * var1.z;
      double var15 = field03412 * (var5 * var11 + var7 * var13);
      double var17 = var11 * var11 + var13 * var13 - var3 * var3;
      double var19 = var15 * var15 - field03413 * var9 * var17;
      return var19 < 0.0 ? -var15 / (field03414 * var9) : (-var15 + Math.sqrt(var19)) / (field03415 * var9);
   }

   private static float method01393(float var0) {
      float var1 = Math.abs(var0);
      if (var1 > field03418) {
         var1 = field03419 - var1;
      }

      if (var1 > field03420) {
         var1 = field03421 - var1;
      }

      return var1;
   }

   private Vec2 method01394() {
      return new Vec2(this.field03239.method03022(), this.field03240.method03022());
   }

   public int method01395() {
      return this.field03236;
   }

   public ActionListSetting method01396() {
      return this.field03241;
   }

   public float method01397() {
      return this.field03234;
   }

   public ModeSetting method01398() {
      return this.field03222;
   }

   private Vec3 method01400(Vec3 var1) {
      this.field03228 = 0.0;
      return var1;
   }

   private double method01402(double var1, double var3, double var5, double var7, double var9) {
      if (Math.abs(var1) < field03393) {
         return field03394;
      }

      double var11 = Math.min(var7, (Math.max(field03395, var1) + Math.max(field03396, var3)) * field03397);
      double var13 = Math.max(-var7, (Math.min(field03398, var1) + Math.min(field03399, var3)) * field03400);
      double var15 = (var1 > 0.0 ? var11 : -var13) - var9;
      if (var15 < 0.0) {
         var15 = 0.0;
      }

      double var17 = var1 > 0.0 ? var15 : -var15;
      double var19 = (var17 - field03401 * var5) / var1;
      return (var19 - field03402) / field03403;
   }

   public float method01403() {
      return this.field03233;
   }

   private Vec3 method01404(Vec3 var1) {
      return this.field03237 != null && mc.player != null && mc.player.tickCount - this.field03238 <= 1 ? this.field03237 : var1;
   }

   private float method01406() {
      if (!this.field03225.method05999()) {
         return 1.0F;
      }

      AttackAura var1 = ModuleManager.INSTANCE.method08219();
      LivingEntity var2 = AttackAura.field00785;
      if (mc.player == null || var2 == null || !var1.method03937()) {
         return 1.0F;
      }

      if (!mc.player.isFallFlying()) {
         return 1.0F;
      }

      Vec3 var3 = mc.player.getEyePosition();
      Vec3 var4 = var1.field00788 != null ? var1.field00788 : var2.getBoundingBox().getCenter();
      double var5 = var3.distanceTo(var4);
      double var7 = this.field03226.method03022().floatValue();
      if (var5 >= var7) {
         return 1.0F;
      }

      float var9 = this.field03227.method03022();
      return (float)(1.0 - var9 * (1.0 - var5 / var7));
   }

   @Subscribe(4)
   private void method01407(PostMovementPacketEvent var1) {
      if (mc.player == null) {
         this.field03236 = -1;
         this.field03232 = Float.NaN;
         this.field03233 = Float.NaN;
         this.field03234 = Float.NaN;
         this.field03235 = Float.NaN;
         this.field03237 = null;
         this.field03238 = -1;
      } else {
         this.field03237 = mc.player.getDeltaMovement();
         this.field03238 = mc.player.tickCount;
         this.field03234 = this.field03232;
         this.field03235 = this.field03233;
         this.field03232 = mc.player.getYRot();
         this.field03233 = mc.player.getXRot();
         this.field03236 = mc.player.tickCount;
      }
   }

   @Subscribe
   private void method01408(FireworkBoostEvent var1) {
      if (var1.method04089() instanceof LocalPlayer) {
         Vec2 var2 = switch ((String)this.field03222.method03022()) {
            case field03295 -> this.method01354();
            case field03296 -> this.method01414();
            case field03297 -> this.method01394();
            default -> new Vec2(field03298, field03299);
         };
         float var5 = this.method01406();
         if (var5 < 1.0F) {
            var2 = new Vec2(var2.x * var5, var2.y * var5);
         }

         var1.method04093(var2.x);
         var1.method04091(var2.y);
         var1.method04090();
         var1.method04092();
      }
   }

   private float method01409(float var1) {
      int var2 = (int)(var1 / field03416);
      if (var2 >= this.field03220.length) {
         var2 = this.field03220.length - 1;
      }

      return this.field03220[var2].method03022();
   }

   private double method01411(Vec3 var1) {
      Vec3 var2 = this.method01375(var1);
      double var3 = Math.toDegrees(Math.acos(Mth.clamp(var1.dot(var2), field03381, 1.0)));
      return Math.toRadians(Mth.clamp(var3 * field03382, field03383, field03384));
   }

   private float method01412(float var1) {
      if (mc.player != null && this.field03236 >= 0 && mc.player.tickCount - this.field03236 <= 1) {
         float var2 = this.field03236 == mc.player.tickCount ? this.field03235 : this.field03233;
         return Float.isNaN(var2) ? var1 : var2;
      } else {
         return var1;
      }
   }

   private Vec2 method01414() {
      LocalPlayer var1 = mc.player;
      if (var1 == null) {
         return new Vec2(field03335, field03336);
      }

      boolean var2 = this.field03223.method05600(field03337);
      boolean var3 = this.field03224.method05600(field03338);
      double var4 = var3 ? field03339 : field03340;
      double var6 = var3 ? field03341 : field03342;
      Vec3 var8 = var1.getLookAngle();
      Vec3 var9 = this.method01375(Vec3.directionFromRotation(var1.xRotO, var1.yRotO));
      Vec3 var10 = var1.getDeltaMovement();
      Vec3 var11 = this.method01404(var10);
      Vec2 var12 = this.method01352(var8, var11, var10, field03343, field03344, var4);
      if (!var2) {
         double var13 = field03345 * var10.y + var8.y * (field03346 + field03347 * var12.y);
         double var15 = var13 < 0.0 ? var6 - field03348 * -var13 : var6;
         double var17 = this.method01392(var8, var10, var15);
         if (var17 < var12.x) {
            var12 = this.method01352(var8, var11, var10, var17, var12.y, var4);
         }
      }

      double var10004 = var12.x;
      double var10005 = var12.y;
      return var12;
   }

   public float method01415() {
      return this.field03232;
   }
}
