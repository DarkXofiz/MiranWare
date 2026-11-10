// Original binary: sg/ec/BPIc6DzdwqMz0OtA
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.Set;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.HumanoidArm;
import org.joml.Quaternionf;

// $VF: Compiled from s
public class SwingAnimations extends ClientModule {
   private static final Set<String> field06256 = Set.of(
      SwingAnimations.field06527, SwingAnimations.field06528, SwingAnimations.field06529, SwingAnimations.field06530, SwingAnimations.field06531
   );
   private static final float field06257 = 0.56F;
   private static final float field06258 = 0;
   private static final float field06259 = 0;
   private static final float field06260 = 0;
   private static final double field06261 = 0;
   private static final double field06262 = 0;
   private static final double field06263 = 0;
   private static final double field06264 = 0;
   private static final double field06265 = 0;
   private static final double field06266 = 0;
   private static final double field06267 = 0;
   private static final double field06268 = 0;
   private static final double field06269 = 0;
   private static final double field06270 = 0;
   private static final double field06271 = 0;
   private static final double field06272 = 0;
   private static final double field06273 = 0;
   private static final double field06274 = 0;
   private static final double field06275 = 0;
   private static final float field06276 = 0;
   private static final float field06277 = 0;
   private static final float field06278 = 0;
   private static final float field06279 = 0;
   private static final float field06280 = 0;
   private static final float field06281 = 0;
   private static final float field06282 = 0;
   private static final float field06283 = 0;
   private static final float field06284 = 0;
   private static final float field06285 = 0;
   private static final float field06286 = 0;
   private static final float field06287 = 0;
   private static final float field06288 = 0;
   private static final float field06289 = 0;
   private static final float field06290 = 0;
   private static final float field06291 = 0;
   private static final float field06292 = 0;
   private final ModeSetting field06293;
   private final NumberSetting<Float> field06294;
   private final NumberSetting<Integer> field06295;
   private final NumberSetting<Integer> field06296;
   private final ToggleSetting field06297;
   private final NumberSetting<Float> field06298;
   private final NumberSetting<Integer> field06299;
   private final NumberSetting<Integer> field06300;
   private final ToggleSetting field06301;
   private final ModeSetting field06302;
   private final NumberSetting<Integer> field06303;
   private final ModeSetting field06304;
   private final ToggleSetting field06305;
   private final NumberSetting<Integer> field06306;
   private final NumberSetting<Integer> field06307;
   private final NumberSetting<Integer> field06308;
   private boolean field06309;
   private float field06310;
   private static final String field06311 = "Свинги";
   private static final String field06312 = "Обычный";
   private static final String field06313 = "Мод 1";
   private static final String field06314 = "Мод 2";
   private static final String field06315 = "Мод 3";
   private static final String field06316 = "Мод 4";
   private static final String field06317 = "Мод 5";
   private static final String field06318 = "Мод 6";
   private static final String field06319 = "Мод 7";
   private static final String field06320 = "Мод 8";
   private static final String field06321 = "Мод 9";
   private static final String field06322 = "Мод 10";
   private static final String field06323 = "Мод 11";
   private static final String field06324 = "Мод 12";
   private static final String field06325 = "Мод 13";
   private static final String field06326 = "Мод 14";
   private static final String field06327 = "Мод 15";
   private static final String field06328 = "Мод 16";
   private static final String field06329 = "Мод 17";
   private static final String field06330 = "HoldMyItems";
   private static final String field06331 = "Обычный";
   private static final String field06332 = "Размер предмета";
   private static final float field06333 = 0.5F;
   private static final float field06334 = 1.5F;
   private static final float field06335 = 0.1F;
   private static final String field06336 = "nurItemScale";
   private static final String field06337 = "Сила наклона";
   private static final String field06338 = "nurTilt";
   private static final String field06339 = "Скорость удара";
   private static final String field06340 = "nurSwingSpeed";
   private static final String field06341 = "Только с аурой";
   private static final String field06342 = "nurOnlyWithAura";
   private static final String field06343 = "Размер предмета";
   private static final float field06344 = 0.5F;
   private static final float field06345 = 1.5F;
   private static final float field06346 = 0.01F;
   private static final String field06347 = "Сила наклона";
   private static final String field06348 = "Плавность взмаха";
   private static final String field06349 = "Менять скорость свинга";
   private static final String field06350 = "Режим скорости";
   private static final String field06351 = "Динамический";
   private static final String field06352 = "Статичный";
   private static final String field06353 = "Динамический";
   private static final String field06354 = "Скорость";
   private static final String field06355 = "Работать";
   private static final String field06356 = "С аурой";
   private static final String field06357 = "При взмахе";
   private static final String field06358 = "Всегда";
   private static final String field06359 = "Всегда";
   private static final String field06360 = "Кастомизация";
   private static final String field06361 = "Разворот по X";
   private static final String field06362 = "Разворот по Y";
   private static final String field06363 = "Разворот по Z";
   private static final String field06364 = "Swing Animations";
   private static final String field06365 = "Обычный";
   private static final String field06366 = "HoldMyItems";
   private static final String field06367 = "HoldMyItems";
   private static final String field06368 = "Всегда";
   private static final String field06369 = "При взмахе";
   private static final String field06370 = "С аурой";
   private static final String field06371 = "Статичный";
   private static final float field06372 = 21.0F;
   private static final float field06373 = -1.0F;
   private static final float field06374 = -1.0F;
   private static final float field06375 = 0.56F;
   private static final float field06376 = -0.52F;
   private static final float field06377 = -0.72F;
   private static final float field06378 = -0.56F;
   private static final float field06379 = 0.52F;
   private static final float field06380 = 0.72F;
   private static final float field06381 = 10.0F;
   private static final float field06382 = (float) Math.PI;
   private static final String field06383 = "Мод 1";
   private static final String field06384 = "Мод 2";
   private static final String field06385 = "Мод 3";
   private static final String field06386 = "Мод 4";
   private static final String field06387 = "Мод 5";
   private static final double field06388 = 0.1;
   private static final double field06389 = -0.2;
   private static final double field06390 = 0.5;
   private static final double field06391 = -0.4;
   private static final double field06392 = -0.82;
   private static final float field06393 = 90.0F;
   private static final float field06394 = -60.0F;
   private static final float field06395 = -80.0F;
   private static final float field06396 = 0.56F;
   private static final float field06397 = -0.52F;
   private static final float field06398 = -0.72F;
   private static final float field06399 = 45.0F;
   private static final float field06400 = (float) Math.PI;
   private static final float field06401 = 4.0F;
   private static final float field06402 = -20.0F;
   private static final float field06403 = (float) Math.PI;
   private static final float field06404 = -20.0F;
   private static final float field06405 = -45.0F;
   private static final float field06406 = 30.0F;
   private static final float field06407 = 90.0F;
   private static final float field06408 = 90.0F;
   private static final double field06409 = 0.1;
   private static final double field06410 = -0.2;
   private static final double field06411 = 0.5;
   private static final double field06412 = -0.4;
   private static final double field06413 = -0.82;
   private static final float field06414 = -120.0F;
   private static final float field06415 = 10.0F;
   private static final float field06416 = 10.0F;
   private static final float field06417 = 40.0F;
   private static final double field06418 = 0.3;
   private static final double field06419 = -0.3;
   private static final double field06420 = 0.6;
   private static final double field06421 = -0.6;
   private static final double field06422 = -0.9;
   private static final float field06423 = 45.0F;
   private static final double field06424 = -0.5;
   private static final double field06425 = 0.2F;
   private static final float field06426 = 30.0F;
   private static final float field06427 = -80.0F;
   private static final float field06428 = 60.0F;
   private static final float field06429 = 0.2F;
   private static final float field06430 = 60.0F;
   private static final float field06431 = -60.0F;
   private static final float field06432 = -5.0F;
   private static final float field06433 = 3.0F;
   private static final float field06434 = 3.0F;
   private static final float field06435 = 0.5F;
   private static final float field06436 = (float) Math.PI;
   private static final float field06437 = 0.5F;
   private static final double field06438 = Math.PI;
   private static final double field06439 = Math.PI;
   private static final double field06440 = Math.PI;
   private static final float field06441 = 0.5F;
   private static final float field06442 = 6.0F;
   private static final String field06443 = "Мод 15";
   private static final String field06444 = "Мод 6";
   private static final String field06445 = "Мод 7";
   private static final String field06446 = "Мод 8";
   private static final String field06447 = "Мод 9";
   private static final String field06448 = "Мод 10";
   private static final String field06449 = "Мод 11";
   private static final String field06450 = "Мод 12";
   private static final String field06451 = "Мод 13";
   private static final String field06452 = "Мод 14";
   private static final String field06453 = "Мод 15";
   private static final String field06454 = "Мод 16";
   private static final String field06455 = "Мод 17";
   private static final float field06456 = -0.52F;
   private static final float field06457 = 0.1F;
   private static final float field06458 = -20.0F;
   private static final float field06459 = 0.1F;
   private static final float field06460 = -0.1F;
   private static final float field06461 = -50.0F;
   private static final float field06462 = 75.0F;
   private static final float field06463 = 10.0F;
   private static final float field06464 = 50.0F;
   private static final float field06465 = 10.0F;
   private static final float field06466 = -120.0F;
   private static final float field06467 = -60.0F;
   private static final float field06468 = 120.0F;
   private static final float field06469 = -60.0F;
   private static final float field06470 = 0.2F;
   private static final float field06471 = 76.0F;
   private static final float field06472 = -5.0F;
   private static final float field06473 = -100.0F;
   private static final float field06474 = -155.0F;
   private static final float field06475 = -100.0F;
   private static final float field06476 = 0.1F;
   private static final float field06477 = -80.0F;
   private static final float field06478 = 45.0F;
   private static final float field06479 = 15.0F;
   private static final float field06480 = -0.1F;
   private static final float field06481 = 0.2F;
   private static final float field06482 = 61.0F;
   private static final float field06483 = -5.0F;
   private static final float field06484 = -30.0F;
   private static final float field06485 = -60.0F;
   private static final float field06486 = -60.0F;
   private static final float field06487 = 0.2F;
   private static final float field06488 = 30.0F;
   private static final float field06489 = 75.0F;
   private static final float field06490 = -45.0F;
   private static final float field06491 = 30.0F;
   private static final float field06492 = -80.0F;
   private static final float field06493 = 35.0F;
   private static final float field06494 = 0.1F;
   private static final float field06495 = -20.0F;
   private static final float field06496 = -20.0F;
   private static final float field06497 = -75.0F;
   private static final float field06498 = 10.0F;
   private static final float field06499 = -40.0F;
   private static final float field06500 = 40.0F;
   private static final float field06501 = 50.0F;
   private static final float field06502 = 0.8F;
   private static final float field06503 = 0.3F;
   private static final float field06504 = -0.8F;
   private static final float field06505 = 0.56F;
   private static final float field06506 = -1.0F;
   private static final float field06507 = -0.82F;
   private static final float field06508 = 90.0F;
   private static final float field06509 = 60.0F;
   private static final float field06510 = -40.0F;
   private static final float field06511 = -0.5F;
   private static final float field06512 = 0.08F;
   private static final float field06513 = 3.0F;
   private static final float field06514 = 45.0F;
   private static final float field06515 = -5.0F;
   private static final float field06516 = -8.0F;
   private static final float field06517 = -15.0F;
   private static final float field06518 = -45.0F;
   private static final float field06519 = -0.18F;
   private static final float field06520 = 45.0F;
   private static final float field06521 = 12.0F;
   private static final float field06522 = -8.0F;
   private static final float field06523 = -25.0F;
   private static final float field06524 = -45.0F;
   private static final float field06525 = -0.15F;
   private static final String field06526 = "HoldMyItems";
   private static final String field06527 = "Мод 1";
   private static final String field06528 = "Мод 2";
   private static final String field06529 = "Мод 3";
   private static final String field06530 = "Мод 4";
   private static final String field06531 = "Мод 5";

   public float method02738() {
      return this.method02757() ? this.field06294.method03022() : this.field06298.method03022();
   }

   private static void method02739(PoseStack var0, float var1, float var2) {
      var0.translate(field06388, 0.0, field06389);
      var0.translate(field06390, field06391, field06392);
      var0.rotate(Axis.YP.rotationDegrees(field06393));
      var0.rotate(Axis.ZP.rotationDegrees(field06394));
      var0.rotate(Axis.XP.rotationDegrees(field06395 - var1 * var2));
   }

   public NumberSetting<Integer> method02740() {
      return this.field06300;
   }

   @Subscribe
   private void method02741(SwingDurationEvent var1) {
      if (var1.method05150() != null) {
         if (var1.method05148() instanceof LocalPlayer var2) {
            if (this.method02757()) {
               if (this.method03937()) {
                  var1.method05150().setReturnValue(this.method02761(var2));
               }
            } else if (!this.field06309) {
               int var5 = this.method02764(var2);
               if (!this.field06301.method05999()) {
                  var1.method05150().setReturnValue(var5);
               } else {
                  int var4 = method02787(this.field06303.method03022());
                  if (this.field06302.method05600(field06371)) {
                     var1.method05150().setReturnValue(var4);
                  } else {
                     var1.method05150().setReturnValue(Math.min(var4, var5));
                  }
               }
            }
         }
      }
   }

   private static void method02742(PoseStack var0) {
      var0.translate(field06409, 0.0, field06410);
      var0.translate(field06411, field06412, field06413);
      var0.rotate(Axis.XP.rotationDegrees(field06414));
   }

   public NumberSetting<Integer> method02743() {
      return this.field06303;
   }

   public NumberSetting<Float> method02744() {
      return this.field06294;
   }

   public NumberSetting<Integer> method02745() {
      return this.field06299;
   }

   private static void method02746(PoseStack var0, float var1, float var2) {
      float var3 = var1 / field06415 / field06416 * field06417;
      var0.translate(field06418, 0.0, field06419);
      var0.translate(field06420, field06421, field06422);
      var0.rotate(Axis.YP.rotationDegrees(field06423));
      var0.rotate(Axis.YP.rotationDegrees(var2 * -(var3 / 2.0F)));
      var0.rotate(Axis.ZP.rotationDegrees(var2 * -(var3 / 2.0F)));
      var0.rotate(Axis.XP.rotationDegrees(var2 * -var3));
      var0.translate(field06424, field06425, 0.0);
      var0.rotate(Axis.YP.rotationDegrees(field06426));
      var0.rotate(Axis.XP.rotationDegrees(field06427));
      var0.rotate(Axis.YP.rotationDegrees(field06428));
   }

   private float method02748(float var1) {
      int var2 = Mth.clamp(2 + this.field06300.method03022(), 3, 6);
      if (var2 == 3) {
         return var1;
      }

      float var3 = (var2 - field06433) / field06434;
      float var4 = field06435 - Mth.cos(var1 * field06436) * field06437;
      return Mth.clamp(Mth.lerp(var3, var1, var4), 0.0F, 1.0F);
   }

   private static int method02749(float var0) {
      if (Float.isFinite(var0) && !(var0 <= 0.0F)) {
         int var1 = (int)var0;
         int var2 = var0 < var1 ? var1 - 1 : var1;
         return Math.max(1, var2);
      } else {
         return 20;
      }
   }

   public NumberSetting<Integer> method02752() {
      return this.field06306;
   }

   public ModeSetting method02754() {
      return this.field06302;
   }

   private static void method02755(PoseStack var0, float var1, float var2, float var3) {
      var0.translate(field06396, field06397, field06398);
      var0.rotate(Axis.YP.rotationDegrees(field06399 + Mth.sin(var3 * var3 * field06400) / field06401 * field06402));
      var0.rotate(Axis.ZP.rotationDegrees(Mth.sin(Mth.sqrt(var3) * field06403) * field06404));
      var0.rotate(Axis.XP.rotationDegrees(var2 * -var1));
      var0.rotate(Axis.YP.rotationDegrees(field06405));
   }

   @Subscribe
   private void method02756(TickEvent var1) {
      this.field06309 = this.method02771();
      this.method02769();
   }

   private boolean method02757() {
      return field06256.contains(this.field06293.method03022());
   }

   public void method02758(float var1) {
      this.field06310 = var1;
   }

   public ToggleSetting method02759() {
      return this.field06301;
   }

   private static void method02760(PoseStack var0, float var1, float var2) {
      method02742(var0);
      var0.rotate(Axis.YP.rotationDegrees(-var2 * var1 + field06406));
      var0.rotate(Axis.ZP.rotationDegrees(field06407));
   }

   private int method02761(LocalPlayer var1) {
      int var2 = this.field06296.method03022();
      if (MobEffectUtil.hasDigSpeed(var1)) {
         return var2 - (1 + MobEffectUtil.getDigSpeedAmplification(var1));
      }

      MobEffectInstance var3 = var1.getEffect(MobEffects.MINING_FATIGUE);
      return var3 == null ? var2 : var2 + (1 + var3.getAmplifier()) * 2;
   }

   public boolean method02762() {
      return !this.method03937() || this.field06309;
   }

   private static void method02763(PoseStack var0, float var1, float var2) {
      method02742(var0);
      var0.rotate(Axis.YP.rotationDegrees(-var2 * var1));
      var0.rotate(Axis.ZP.rotationDegrees(field06408));
   }

   public SwingAnimations() {
      super(ModuleCategory.Render, ModuleSubCategory.Interface);
      this.field06293 = new ModeSetting(field06311)
         .method05597(
            field06312,
            field06313,
            field06314,
            field06315,
            field06316,
            field06317,
            field06318,
            field06319,
            field06320,
            field06321,
            field06322,
            field06323,
            field06324,
            field06325,
            field06326,
            field06327,
            field06328,
            field06329,
            field06330
         )
         .method03017(field06331)
         .method03023(this);
      this.field06294 = new NumberSetting<Float>(field06332)
         .method10835(field06333)
         .method10838(field06334)
         .method10834(field06335)
         .method03017(1.0F)
         .method03016(field06336)
         .method03025(this::method02757)
         .method03023(this);
      this.field06295 = new NumberSetting<Integer>(field06337)
         .method10835(1)
         .method10838(10)
         .method10834(1)
         .method03017(3)
         .method03016(field06338)
         .method03025(this::method02757)
         .method03023(this);
      this.field06296 = new NumberSetting<Integer>(field06339)
         .method10835(3)
         .method10838(10)
         .method10834(1)
         .method03017(6)
         .method03016(field06340)
         .method03025(this::method02757)
         .method03023(this);
      this.field06297 = new ToggleSetting(field06341).method03017(false).method03016(field06342).method03025(this::method02757).method03023(this);
      this.field06298 = new NumberSetting<Float>(field06343)
         .method10835(field06344)
         .method10838(field06345)
         .method10834(field06346)
         .method03017(1.0F)
         .method03025(() -> !this.field06293.method05600(field06526) && !this.method02757())
         .method03023(this);
      this.field06299 = new NumberSetting<Integer>(field06347)
         .method10835(1)
         .method10838(10)
         .method10834(1)
         .method03017(6)
         .method03025(this::method02786)
         .method03023(this);
      this.field06300 = new NumberSetting<Integer>(field06348)
         .method10835(1)
         .method10838(4)
         .method10834(1)
         .method03017(1)
         .method03025(this::method02786)
         .method03023(this);
      this.field06301 = new ToggleSetting(field06349).method03017(false).method03025(() -> !this.method02757()).method03023(this);
      this.field06302 = new ModeSetting(field06350)
         .method05597(field06351, field06352)
         .method03017(field06353)
         .method03025(() -> this.field06301.method05999() && !this.method02757())
         .method03023(this);
      this.field06303 = new NumberSetting<Integer>(field06354)
         .method10835(1)
         .method10838(20)
         .method10834(1)
         .method03017(10)
         .method03025(() -> this.field06301.method05999() && !this.method02757())
         .method03023(this);
      this.field06304 = new ModeSetting(field06355)
         .method05597(field06356, field06357, field06358)
         .method03017(field06359)
         .method03025(this::method02786)
         .method03023(this);
      this.field06305 = new ToggleSetting(field06360).method03017(false).method03025(this::method02786).method03023(this);
      this.field06306 = new NumberSetting<Integer>(field06361)
         .method10835(-180)
         .method10838(180)
         .method10834(1)
         .method03017(0)
         .method03025(() -> this.field06305.method03022() && this.method02786())
         .method03023(this);
      this.field06307 = new NumberSetting<Integer>(field06362)
         .method10835(-180)
         .method10838(180)
         .method10834(1)
         .method03017(0)
         .method03025(() -> this.field06305.method03022() && this.method02786())
         .method03023(this);
      this.field06308 = new NumberSetting<Integer>(field06363)
         .method10835(-180)
         .method10838(180)
         .method10834(1)
         .method03017(0)
         .method03025(() -> this.field06305.method03022() && this.method02786())
         .method03023(this);
      this.field06309 = true;
      this.method03935(field06364);
      ItemInHandRendererHooks.field11295 = ParticleRenderer::method11149;
   }

   private int method02764(LocalPlayer var1) {
      return method02749(var1.getCurrentItemAttackStrengthDelay());
   }

   private void method02765(PoseStack var1, float var2, float var3, float var4) {
      var1.translate(0.0F, field06429, 0.0F);
      var1.rotate(Axis.YP.rotationDegrees(field06430));
      var1.rotate(Axis.ZP.rotationDegrees(field06431));
      var1.rotate(Axis.YP.rotationDegrees(var2 * var3 * field06432 * var4));
   }

   public ModeSetting method02766() {
      return this.field06304;
   }

   private void method02768(PoseStack var1, float var2) {
      var1.translate(field06378, field06379, field06380);
      float var3 = this.field06295.method03022().intValue() * field06381;
      float var4 = Mth.sin(var2 * field06382);
      switch ((String)this.field06293.method03022()) {
         case field06383:
            method02739(var1, var3, var4);
            break;
         case field06384:
            method02755(var1, var3, var4, var2);
            break;
         case field06385:
            method02760(var1, var3, var4);
            break;
         case field06386:
            method02763(var1, var3, var4);
            break;
         case field06387:
            method02746(var1, var3, var4);
            break;
         default:
            return;
      }

      float var7 = this.field06294.method03022();
      var1.scale(var7, var7, var7);
   }

   @Override
   public void method00245() {
      super.method00245();
      ItemInHandRendererHooks.field11293 = false;
   }

   private void method02769() {
      ItemInHandRendererHooks.field11293 = this.method03937() && this.field06293.method05600(field06367);
   }

   public void method02770(PoseStack var1, float var2, Runnable var3) {
      if (this.field06309) {
         var3.run();
      } else if (this.method02757()) {
         this.method02768(var1, Mth.clamp(var2, 0.0F, 1.0F));
      } else {
         float var4 = this.method02748(Mth.clamp(var2, 0.0F, 1.0F));
         float var5 = (float)Math.sin(var4 * field06438);
         float var6 = (float)Math.sin(Mth.sqrt(var4) * field06439);
         float var7 = (float)Math.sin(var4 * var4 * field06440);
         float var8 = var5 * field06441;
         float var9 = this.field06299.method03022().intValue() / field06442;
         float var10 = this.field06298.method03022();
         if (!this.field06293.method05600(field06443)) {
            var1.scale(var10, var10, var10);
         }

         this.method02788(var1);
         switch ((String)this.field06293.method03022()) {
            case field06444:
               var1.translate(0.0F, var6 * field06456 * var9 + field06457, 0.0F);
               var1.rotate(Axis.YP.rotationDegrees(field06458));
               break;
            case field06445:
               var1.translate(0.0F, field06459, field06460);
               var1.rotate(Axis.XP.rotationDegrees(field06461));
               var1.rotate(Axis.ZP.rotationDegrees(field06462 + var5 * field06463 * this.field06299.method03022().intValue()));
               var1.rotate(Axis.YP.rotationDegrees(field06464 + var5 * field06465 * this.field06299.method03022().intValue()));
               break;
            case field06446:
               this.method02765(var1, var6, var7, var9);
               var1.rotate(Axis.XP.rotationDegrees(var6 * var7 * field06466 * var9));
               var1.rotate(Axis.XP.rotationDegrees(field06467));
               break;
            case field06447:
               this.method02765(var1, var6, var7, var9);
               var1.rotate(Axis.XP.rotationDegrees(var6 * var7 * field06468 * var9));
               var1.rotate(Axis.XP.rotationDegrees(field06469));
               break;
            case field06448:
               var1.translate(0.0F, field06470, 0.0F);
               var1.rotate(Axis.YP.rotationDegrees(field06471));
               var1.rotate(Axis.YP.rotationDegrees(var6 * field06472 * var9));
               var1.rotate(Axis.XN.rotationDegrees(var6 * field06473 * var9));
               var1.rotate(Axis.XP.rotationDegrees(var6 * field06474 * var9));
               var1.rotate(Axis.XP.rotationDegrees(field06475));
               break;
            case field06449:
               var1.translate(0.0F, field06476, 0.0F);
               var1.rotate(Axis.XP.rotationDegrees(var6 * field06477 * var9));
               var1.rotate(Axis.ZP.rotationDegrees(var6 * field06478 * var9));
               var1.rotate(Axis.YP.rotationDegrees(var6 * field06479 * var9));
               var1.translate(0.0F, field06480, 0.0F);
               break;
            case field06450:
               var1.translate(0.0F, field06481, 0.0F);
               var1.translate(-var8 * var8 * var7 * var9, 0.0F, 0.0F);
               var1.rotate(Axis.YP.rotationDegrees(field06482));
               var1.rotate(Axis.ZP.rotationDegrees(var6 * var9));
               var1.rotate(Axis.YP.rotationDegrees(var6 * var7 * field06483 * var9));
               var1.rotate(Axis.XP.rotationDegrees(var6 * var7 * field06484 * var9));
               var1.rotate(Axis.XP.rotationDegrees(field06485));
               var1.rotate(Axis.XP.rotationDegrees(var8 * field06486 * var9));
               break;
            case field06451:
               var1.translate(0.0F, field06487, 0.0F);
               var1.rotate(Axis.YP.rotationDegrees(field06488));
               var1.rotate(Axis.YP.rotationDegrees(var6 * field06489 * var9));
               var1.rotate(Axis.XP.rotationDegrees(var6 * field06490 * var9));
               var1.rotate(Axis.YP.rotationDegrees(field06491));
               var1.rotate(Axis.XP.rotationDegrees(field06492));
               var1.rotate(Axis.YP.rotationDegrees(field06493));
               break;
            case field06452:
               var1.translate(0.0F, field06494, 0.0F);
               this.method02765(var1, var6, var7, var9);
               var1.rotate(Axis.YP.rotationDegrees(var6 * var7 * field06495 * var9));
               var1.rotate(Axis.ZP.rotationDegrees(var6 * var7 * field06496 * var9));
               var1.rotate(Axis.XP.rotationDegrees(field06497));
               break;
            case field06453:
               float var13 = this.field06299.method03022().intValue() * field06498;
               float var14 = field06499 - field06500 * var5 * var13 / field06501;
               float var15 = this.field06310;
               var1.translate(field06502, field06503, field06504);
               var1.translate(field06505, field06506, field06507);
               var1.rotate(Axis.YP.rotationDegrees(field06508));
               var1.rotate(Axis.ZN.rotationDegrees(field06509));
               var1.rotate(new Quaternionf().fromAxisAngleDeg(1.0F, var15, 0.0F, var14));
               var1.rotate(Axis.XP.rotationDegrees(field06510));
               var1.translate(field06511, field06512, 0.0F);
               var10 *= field06513;
               var1.scale(var10, var10, var10);
               break;
            case field06454:
               var1.rotate(Axis.YP.rotationDegrees(field06514 + var5 * field06515 * var9));
               var1.rotate(Axis.ZP.rotationDegrees(var6 * field06516 * var9));
               var1.rotate(Axis.XP.rotationDegrees(var6 * field06517 * var9));
               var1.rotate(Axis.YP.rotationDegrees(field06518));
               var1.translate(0.0F, var6 * field06519 * var9, 0.0F);
               break;
            case field06455:
               var1.rotate(Axis.YP.rotationDegrees(field06520 + var5 * field06521 * var9));
               var1.rotate(Axis.ZP.rotationDegrees(var6 * field06522 * var9));
               var1.rotate(Axis.XP.rotationDegrees(var6 * field06523 * var9));
               var1.rotate(Axis.YP.rotationDegrees(field06524));
               var1.translate(0.0F, 0.0F, var6 * field06525 * var9);
               break;
            default:
               var3.run();
         }
      }
   }

   public boolean method02771() {
      if (this.method02774()) {
         return false;
      } else if (this.method02757()) {
         return !this.method03937() ? true : this.field06297.method05999() && AttackAura.method00456() == null;
      } else if (this.field06304.method05600(field06368)) {
         return false;
      } else if (!this.method03937()) {
         return true;
      } else if (!this.field06304.method05600(field06369)) {
         return !this.field06304.method05600(field06370) ? false : AttackAura.method00456() == null;
      } else {
         return mc.player == null || mc.player.getCurrentSwing() == null;
      }
   }

   @Subscribe
   private void method02772(SwingTransformEvent var1) {
      if (var1.method00538() != null) {
         switch (var1.method00538()) {
            case TRANSLATE:
               if (this.method02762() || this.method02774()) {
                  return;
               }

               var1.method05696();
               break;
            case SWING_OFFSET:
               if (!this.method03937() || this.field06309) {
                  return;
               }

               PoseStack var5 = var1.method00532();
               if (var5 == null) {
                  return;
               }

               if (this.method02774()) {
                  float var6 = this.field06298.method03022();
                  var5.scale(var6, var6, var6);
                  return;
               }

               HumanoidArm var3 = var1.method00543();
               if (var3 == null) {
                  return;
               }

               HumanoidArm var4 = mc.player != null ? mc.player.getMainArm() : HumanoidArm.RIGHT;
               if (var3 != var4) {
                  return;
               }

               var1.method05696();
               if (var3 == HumanoidArm.LEFT) {
                  var5.scale(field06373, 1.0F, 1.0F);
               }

               this.method02770(var5, var1.method00548(), () -> {});
               if (var3 == HumanoidArm.LEFT) {
                  var5.scale(field06374, 1.0F, 1.0F);
               }
               break;
            case EQUIP_OFFSET:
               this.method02758(var1.method00551());
               if (this.method02762() || this.method02774()) {
                  return;
               }

               PoseStack var2 = var1.method00532();
               if (var2 == null) {
                  return;
               }

               var1.method05696();
               var2.translate(var1.method00541() * field06375, field06376, field06377);
         }
      }
   }

   public NumberSetting<Float> method02773() {
      return this.field06298;
   }

   private boolean method02774() {
      return this.field06293.method05600(field06365);
   }

   public ToggleSetting method02775() {
      return this.field06305;
   }

   public NumberSetting<Integer> method02777() {
      return this.field06307;
   }

   public NumberSetting<Integer> method02778() {
      return this.field06295;
   }

   public ToggleSetting method02779() {
      return this.field06297;
   }

   public NumberSetting<Integer> method02781() {
      return this.field06308;
   }

   public boolean method02782() {
      return this.field06309;
   }

   public NumberSetting<Integer> method02783() {
      return this.field06296;
   }

   public float method02785() {
      return this.field06310;
   }

   private boolean method02786() {
      return this.method02790() && !this.method02757();
   }

   private static int method02787(int var0) {
      return Math.max(1, Math.round(field06372 - var0));
   }

   private void method02788(PoseStack var1) {
      if (this.field06305.method05999()) {
         float var2 = this.field06306.method03022().intValue();
         float var3 = this.field06307.method03022().intValue();
         float var4 = this.field06308.method03022().intValue();
         var1.rotate(Axis.XP.rotationDegrees(var2));
         var1.rotate(Axis.YP.rotationDegrees(var3));
         var1.rotate(Axis.ZP.rotationDegrees(var4));
      }
   }

   public ModeSetting method02789() {
      return this.field06293;
   }

   private boolean method02790() {
      return !this.method02774() && !this.field06293.method05600(field06366);
   }
}
