// Original binary: sg/ec/bnTOnziGUkbljH8S
package sg.ec;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public final class EntityEspStyle {
   public static final String field17371 = "Отключено";
   public static final String field17372 = "field17372";
   public static final String field17373 = "field17373";
   public static final String field17374 = "field17374";
   public static final String field17375 = "field17375";
   public static final String field17376 = "field17376";
   public static final String field17377 = "field17377";
   public static final String field17378 = "field17378";
   public static final String field17379 = "field17379";
   private final String field17380;
   private final EntityEspStyle.Nested209 field17381;
   private final ToggleSetting field17382;
   private final ToggleSetting field17383;
   private final ToggleSetting field17384;
   private final ToggleSetting field17385;
   private final ToggleSetting field17386;
   private final ToggleSetting field17387;
   private final ModeSetting field17388;
   private final ModeSetting field17389;
   private final ColorSetting field17390;
   private final ModeSetting field17391;
   private final ColorSetting field17392;
   private final ColorSetting field17393;
   private final ToggleSetting field17394;
   private final ColorSetting field17395;
   private final NumberSetting<Float> field17396;
   private final ToggleSetting field17397;
   private final NumberSetting<Float> field17398;
   private final ToggleSetting field17399;
   private final NumberSetting<Float> field17400;
   private final ToggleSetting field17401;
   private final ColorSetting field17402;
   private final NumberSetting<Float> field17403;
   private final List<Setting<?>> field17404 = new ArrayList<>();
   private static final String field17405 = "Отображать";
   private static final String field17406 = "Ник";
   private static final String field17407 = "Броня";
   private static final String field17408 = "Зачарования";
   private static final String field17409 = "Предметы в руках";
   private static final String field17410 = "Статус войс чата";
   private static final String field17411 = "Бокс";
   private static final String field17412 = "Отключено";
   private static final String field17413 = "Углы";
   private static final String field17414 = "Квадрат";
   private static final String field17415 = "Углы";
   private static final String field17416 = "Режим цвета";
   private static final String field17417 = "Клиентский";
   private static final String field17418 = "Статичный";
   private static final String field17419 = "Клиентский";
   private static final String field17420 = "Цвет бокса";
   private static final String field17421 = "Бар здоровья";
   private static final String field17422 = "Отключен";
   private static final String field17423 = "Состояние";
   private static final String field17424 = "Индивидуальный";
   private static final String field17425 = "Клиентский";
   private static final String field17426 = "Отключен";
   private static final String field17427 = "Верхний цвет";
   private static final String field17428 = "Нижний цвет";
   private static final String field17429 = "Обводка";
   private static final String field17430 = "Текстурная обводка";
   private static final String field17431 = "Цвет обводки";
   private static final String field17432 = "Толщина";
   private static final float field17433 = 3.0F;
   private static final String field17434 = "Свечение";
   private static final String field17435 = "Радиус свечения";
   private static final float field17436 = 25.0F;
   private static final float field17437 = 8.0F;
   private static final String field17438 = "Насыщение";
   private static final float field17439 = 3.0F;
   private static final float field17440 = 0.1F;
   private static final float field17441 = 1.5F;
   private static final String field17442 = "Линии";
   private static final String field17443 = "Цвет линий";
   private static final String field17444 = "Толщина линий";
   private static final float field17445 = 5.0F;
   private static final float field17446 = 0.5F;
   private static final String field17447 = "Отключено";
   private static final String field17448 = "Углы";
   private static final String field17449 = "Статичный";
   private static final String field17450 = "Отключен";
   private static final String field17451 = "Индивидуальный";
   private static final String field17452 = "Индивидуальный";
   private static final String field17453 = "Статичный";

   public ColorSetting method07116() {
      return this.field17393;
   }

   public ToggleSetting method07117() {
      return this.field17383;
   }

   public NumberSetting<Float> method07118() {
      return this.field17398;
   }

   public boolean method07119() {
      return this.method07130() || this.method07161() || this.method07144() || this.method07131();
   }

   public ToggleSetting method07120() {
      return this.field17394;
   }

   public ModeSetting method07121() {
      return this.field17391;
   }

   public boolean method07122() {
      return this.field17391 != null && !this.field17391.method05600(field17450);
   }

   public String method07123() {
      return this.field17380;
   }

   public ToggleSetting method07124() {
      return this.field17385;
   }

   public boolean method07125() {
      return this.field17401 != null && this.field17401.method05999();
   }

   public NumberSetting<Float> method07126() {
      return this.field17400;
   }

   public ToggleSetting method07127() {
      return this.field17397;
   }

   private <T, S extends Setting<T>> S method07128(SettingsContainer var1, String var2, S var3) {
      var3.method03016(var2 + "." + var3.method03024());
      var3.method03023(var1);
      this.field17404.add(var3);
      return (S)var3;
   }

   public boolean method07129() {
      return !this.field17388.method05600(field17447);
   }

   public boolean method07130() {
      return this.field17383.method05999();
   }

   public boolean method07131() {
      return this.field17386 != null && this.field17386.method05999();
   }

   public boolean method07132() {
      return this.field17387 != null && this.field17387.method05999();
   }

   public NumberSetting<Float> method07133() {
      return this.field17403;
   }

   public ToggleSetting method07135() {
      return this.field17386;
   }

   public float method07136() {
      return this.field17398.method03022();
   }

   public EntityEspStyle(SettingsContainer var1, String var2, String var3, EntityEspStyle.Nested209 var4, boolean var5, boolean var6, boolean var7) {
      this.field17380 = var2;
      this.field17381 = var4;
      boolean var8 = var4 == EntityEspStyle.Nested209.PLAYER;
      this.field17382 = this.method07128(var1, var3, new ToggleSetting(field17405).method03017(var6));
      this.field17383 = this.method07128(var1, var3, new ToggleSetting(field17406).method03017(true));
      if (var8) {
         this.field17384 = this.method07128(var1, var3, new ToggleSetting(field17407).method03017(true));
         this.field17387 = this.method07128(var1, var3, new ToggleSetting(field17408).method03025(this.field17384::method05999).method03017(false));
         this.field17385 = this.method07128(var1, var3, new ToggleSetting(field17409).method03017(true));
         this.field17386 = var5 ? this.method07128(var1, var3, new ToggleSetting(field17410).method03017(false)) : null;
      } else {
         this.field17384 = null;
         this.field17387 = null;
         this.field17385 = null;
         this.field17386 = null;
      }

      this.field17388 = this.method07128(var1, var3, new ModeSetting(field17411).method05597(field17412, field17413, field17414).method03017(field17415));
      this.field17389 = this.method07128(
         var1, var3, new ModeSetting(field17416).method05597(field17417, field17418).method03017(field17419).method03025(this::method07129)
      );
      this.field17390 = this.method07128(
         var1,
         var3,
         new ColorSetting(field17420)
            .method03017(new Color(255, 255, 255))
            .method03025(() -> this.method07129() && this.field17389.method05600(field17453))
      );
      if (var4 != EntityEspStyle.Nested209.ITEM) {
         this.field17391 = this.method07128(
            var1, var3, new ModeSetting(field17421).method05597(field17422, field17423, field17424, field17425).method03017(field17426)
         );
         this.field17392 = this.method07128(
            var1, var3, new ColorSetting(field17427).method03017(new Color(0, 255, 0)).method03025(() -> this.field17391.method05600(field17452))
         );
         this.field17393 = this.method07128(
            var1, var3, new ColorSetting(field17428).method03017(new Color(255, 0, 0)).method03025(() -> this.field17391.method05600(field17451))
         );
      } else {
         this.field17391 = null;
         this.field17392 = null;
         this.field17393 = null;
      }

      this.field17394 = this.method07128(var1, var3, new ToggleSetting(field17429).method03017(false));
      this.field17399 = this.method07128(var1, var3, new ToggleSetting(field17430).method03017(false).method03025(this.field17394::method05999));
      this.field17395 = this.method07128(
         var1,
         var3,
         new ColorSetting(field17431)
            .method03017(new Color(255, 255, 255))
            .method03025(() -> this.field17394.method05999() && !this.field17399.method05999())
      );
      this.field17396 = this.method07128(
         var1,
         var3,
         new NumberSetting<Float>(field17432)
            .method10835(1.0F)
            .method10838(field17433)
            .method10834(1.0F)
            .method03017(2.0F)
            .method03025(this.field17394::method05999)
      );
      this.field17397 = this.method07128(var1, var3, new ToggleSetting(field17434).method03017(false).method03025(this.field17394::method05999));
      this.field17398 = this.method07128(
         var1,
         var3,
         new NumberSetting<Float>(field17435)
            .method10835(1.0F)
            .method10838(field17436)
            .method10834(1.0F)
            .method03017(field17437)
            .method03025(() -> this.field17394.method05999() && this.field17397.method05999())
      );
      this.field17400 = this.method07128(
         var1,
         var3,
         new NumberSetting<Float>(field17438)
            .method10835(1.0F)
            .method10838(field17439)
            .method10834(field17440)
            .method03017(field17441)
            .method03025(() -> this.field17394.method05999() && this.field17399.method05999())
      );
      if (var7) {
         this.field17401 = this.method07128(var1, var3, new ToggleSetting(field17442).method03017(false));
         this.field17402 = this.method07128(
            var1, var3, new ColorSetting(field17443).method03017(new Color(255, 255, 255)).method03025(this.field17401::method05999)
         );
         this.field17403 = this.method07128(
            var1,
            var3,
            new NumberSetting<Float>(field17444)
               .method10835(1.0F)
               .method10838(field17445)
               .method10834(field17446)
               .method03017(2.0F)
               .method03025(this.field17401::method05999)
         );
      } else {
         this.field17401 = null;
         this.field17402 = null;
         this.field17403 = null;
      }
   }

   public boolean method07138() {
      return this.field17397.method05999();
   }

   public boolean method07139() {
      return this.field17389.method05600(field17449);
   }

   public NumberSetting<Float> method07140() {
      return this.field17396;
   }

   public ColorSetting method07141() {
      return this.field17402;
   }

   public boolean method07142() {
      return this.field17388.method05600(field17448);
   }

   public boolean method07144() {
      return this.field17385 != null && this.field17385.method05999();
   }

   public boolean method07146() {
      return this.field17399.method05999();
   }

   public ToggleSetting method07147() {
      return this.field17401;
   }

   public ColorSetting method07148() {
      return this.field17395;
   }

   public ToggleSetting method07149() {
      return this.field17387;
   }

   public ToggleSetting method07151() {
      return this.field17382;
   }

   public ModeSetting method07152() {
      return this.field17388;
   }

   public boolean method07154() {
      return this.field17382.method05999();
   }

   public ToggleSetting method07155() {
      return this.field17384;
   }

   public ToggleSetting method07156() {
      return this.field17399;
   }

   public int method07157() {
      return this.field17402.method11676();
   }

   public boolean method07158() {
      return this.field17394.method05999();
   }

   public float method07159() {
      return this.field17400.method03022();
   }

   public ColorSetting method07160() {
      return this.field17390;
   }

   public boolean method07161() {
      return this.field17384 != null && this.field17384.method05999();
   }

   public ModeSetting method07162() {
      return this.field17389;
   }

   public List<Setting<?>> method07163() {
      return this.field17404;
   }

   public ColorSetting method07164() {
      return this.field17392;
   }

   public float method07165() {
      return this.field17403.method03022();
   }

   public EntityEspStyle.Nested209 method07166() {
      return this.field17381;
   }

   public float method07167() {
      return this.field17396.method03022();
   }

   // $VF: Compiled from s
   public enum Nested209 {
      PLAYER,
      LIVING,
      ITEM;
   }
}
