// Original binary: sg/ec/jxmcqHgjWghE2OD4
package sg.ec;

import java.awt.Color;

// $VF: Compiled from s
public class CustomHands extends ClientModule {
   private final ToggleSetting field20586;
   private final ModeSetting field20587;
   private final ModeSetting field20588;
   private final ModeSetting field20589;
   private final ColorSetting field20590;
   private final ColorSetting field20591;
   private final SliderSetting field20592;
   private final NumberSetting<Float> field20593;
   private final NumberSetting<Float> field20594;
   private final NumberSetting<Float> field20595;
   private final NumberSetting<Float> field20596;
   private final ToggleSetting field20597;
   private final ModeSetting field20598;
   private final ToggleSetting field20599;
   private final ModeSetting field20600;
   private final ModeSetting field20601;
   private final ColorSetting field20602;
   private final ColorSetting field20603;
   private final SliderSetting field20604;
   private final NumberSetting<Float> field20605;
   private final NumberSetting<Float> field20606;
   private final NumberSetting<Float> field20607;
   private final NumberSetting<Float> field20608;
   private final ModeSetting field20609;
   private final ColorSetting field20610;
   private final ColorSetting field20611;
   private static final String field20612 = "Свечение";
   private static final String field20613 = "Тип обводки";
   private static final String field20614 = "Статичный";
   private static final String field20615 = "Градиент";
   private static final String field20616 = "Статичный";
   private static final String field20617 = "Цвет";
   private static final String field20618 = "Клиентский";
   private static final String field20619 = "Свой";
   private static final String field20620 = "Текстурный";
   private static final String field20621 = "Клиентский";
   private static final String field20622 = "Цвет";
   private static final String field20623 = "Клиентский";
   private static final String field20624 = "Свой";
   private static final String field20625 = "Радужный";
   private static final String field20626 = "glow.gradient_color";
   private static final String field20627 = "Клиентский";
   private static final String field20628 = "Цвет обводки";
   private static final String field20629 = "Цвет обводки 2";
   private static final String field20630 = "glow.color2";
   private static final String field20631 = "Направление";
   private static final String field20632 = "glow.direction";
   private static final String field20633 = "Скорость";
   private static final float field20634 = 3.0F;
   private static final float field20635 = 0.1F;
   private static final String field20636 = "glow.speed";
   private static final String field20637 = "Насыщение";
   private static final float field20638 = 3.0F;
   private static final float field20639 = 0.1F;
   private static final float field20640 = 1.5F;
   private static final String field20641 = "Радиус свечения";
   private static final float field20642 = 25.0F;
   private static final float field20643 = 8.0F;
   private static final String field20644 = "Яркость свечения";
   private static final float field20645 = 3.5F;
   private static final float field20646 = 0.1F;
   private static final float field20647 = 1.5F;
   private static final String field20648 = "Эффект на предмет";
   private static final String field20649 = "Тип эффекта";
   private static final String field20650 = "Блюр";
   private static final String field20651 = "Глянцевый";
   private static final String field20652 = "Блюр";
   private static final String field20653 = "Цвет блюра";
   private static final String field20654 = "Тип цвета";
   private static final String field20655 = "Клиентский";
   private static final String field20656 = "Свой";
   private static final String field20657 = "Клиентский";
   private static final String field20658 = "Заливка";
   private static final String field20659 = "Сплошной";
   private static final String field20660 = "Градиент";
   private static final String field20661 = "Сплошной";
   private static final String field20662 = "Свой цвет";
   private static final String field20663 = "Свой цвет 2";
   private static final String field20664 = "Направление";
   private static final String field20665 = "Сила";
   private static final float field20666 = 0.2F;
   private static final float field20667 = 3.0F;
   private static final float field20668 = 0.1F;
   private static final float field20669 = 1.2F;
   private static final String field20670 = "Скорость";
   private static final float field20671 = 0.1F;
   private static final float field20672 = 3.0F;
   private static final float field20673 = 0.1F;
   private static final String field20674 = "Плотность волн";
   private static final float field20675 = 40.0F;
   private static final float field20676 = 12.0F;
   private static final String field20677 = "Резкость";
   private static final float field20678 = 8.0F;
   private static final float field20679 = 0.5F;
   private static final float field20680 = 3.0F;
   private static final String field20681 = "Цвет";
   private static final String field20682 = "Радужный";
   private static final String field20683 = "Клиентский";
   private static final String field20684 = "Свой";
   private static final String field20685 = "gloss.color";
   private static final String field20686 = "Радужный";
   private static final String field20687 = "Цвет 1";
   private static final String field20688 = "Цвет 2";
   private static final String field20689 = "Custom Hands";
   private static final String field20690 = "Градиент";
   private static final String field20691 = "Свой";
   private static final int field20692 = -16777216;
   private static final int field20693 = 16777215;
   private static final String field20694 = "Статичный";
   private static final String field20695 = "Текстурный";
   private static final String field20696 = "Градиент";
   private static final String field20697 = "Радужный";
   private static final String field20698 = "Свой";
   private static final int field20699 = 16777215;
   private static final String field20700 = "Свой";
   private static final int field20701 = 16777215;
   private static final String field20702 = "Глянцевый";
   private static final String field20703 = "Радужный";
   private static final String field20704 = "Свой";
   private static final int field20705 = 16777215;
   private static final String field20706 = "Свой";
   private static final int field20707 = 16777215;
   private static final String field20708 = "Градиент";
   private static final String field20709 = "Свой";
   private static final int field20710 = 16777215;
   private static final String field20711 = "Свой";
   private static final int field20712 = 16777215;
   private static final float field20713 = 120.0F;
   private static final String field20714 = "Глянцевый";
   private static final String field20715 = "Свой";
   private static final String field20716 = "Глянцевый";
   private static final String field20717 = "Свой";
   private static final String field20718 = "Глянцевый";
   private static final String field20719 = "Глянцевый";
   private static final String field20720 = "Глянцевый";
   private static final String field20721 = "Глянцевый";
   private static final String field20722 = "Глянцевый";
   private static final String field20723 = "Блюр";
   private static final String field20724 = "Градиент";
   private static final String field20725 = "Блюр";
   private static final String field20726 = "Свой";
   private static final String field20727 = "Градиент";
   private static final String field20728 = "Блюр";
   private static final String field20729 = "Свой";
   private static final String field20730 = "Блюр";
   private static final String field20731 = "Блюр";
   private static final String field20732 = "Блюр";
   private static final String field20733 = "Статичный";
   private static final String field20734 = "Текстурный";
   private static final String field20735 = "Градиент";
   private static final String field20736 = "Градиент";
   private static final String field20737 = "Градиент";
   private static final String field20738 = "Свой";
   private static final String field20739 = "Свой";
   private static final String field20740 = "Градиент";
   private static final String field20741 = "Статичный";

   public int method09081() {
      int var1 = this.field20589.method05600(field20698) ? this.field20590.method11676() : ColorUtils.Nested138.method04636();
      return var1 & field20699;
   }

   public float method09085() {
      return this.field20593.method03022();
   }

   private ModeSetting method09086() {
      return this.field20587.method05600(field20690) ? this.field20589 : this.field20588;
   }

   public float method09088() {
      return this.field20608.method03022();
   }

   public float method09089() {
      return this.field20604.method00357();
   }

   public int method09092() {
      int var1 = this.field20609.method05600(field20706) ? this.field20611.method11676() : ColorUtils.Nested138.method04637();
      return var1 & field20707;
   }

   public int method09093() {
      if (!this.method09096() && !this.method09109()) {
         int var1 = this.field20588.method05600(field20691) ? this.field20590.method11676() : ColorUtils.Nested138.method04638(90);
         return field20692 | var1 & field20693;
      } else {
         return -1;
      }
   }

   public int method09095() {
      int var1 = this.field20589.method05600(field20700) ? this.field20591.method11676() : ColorUtils.Nested138.method04637();
      return var1 & field20701;
   }

   public CustomHands() {
      super(ModuleCategory.Render, ModuleSubCategory.Interface);
      this.field20586 = new ToggleSetting(field20612).method03017(false).method03023(this);
      this.field20587 = new ModeSetting(field20613)
         .method05597(field20614, field20615)
         .method03017(field20616)
         .method03025(this.field20586::method05999)
         .method03023(this);
      this.field20588 = new ModeSetting(field20617)
         .method05597(field20618, field20619, field20620)
         .method03017(field20621)
         .method03025(() -> this.field20586.method05999() && this.field20587.method05600(field20741))
         .method03023(this);
      this.field20589 = new ModeSetting(field20622)
         .method05597(field20623, field20624, field20625)
         .method03016(field20626)
         .method03017(field20627)
         .method03025(() -> this.field20586.method05999() && this.field20587.method05600(field20740))
         .method03023(this);
      this.field20590 = new ColorSetting(field20628)
         .method03017(new Color(255, 255, 255))
         .method03025(() -> this.field20586.method05999() && this.method09086().method05600(field20739))
         .method03023(this);
      this.field20591 = new ColorSetting(field20629)
         .method03016(field20630)
         .method03017(new Color(0, 170, 255))
         .method03025(() -> this.field20586.method05999() && this.field20587.method05600(field20737) && this.field20589.method05600(field20738))
         .method03023(this);
      this.field20592 = new SliderSetting(field20631)
         .method03016(field20632)
         .method03017(0.0F)
         .method03025(() -> this.field20586.method05999() && this.field20587.method05600(field20736))
         .method03023(this);
      this.field20593 = new NumberSetting<Float>(field20633)
         .method10835(0.0F)
         .method10838(field20634)
         .method10834(field20635)
         .method03017(1.0F)
         .method03016(field20636)
         .method03025(() -> this.field20586.method05999() && this.field20587.method05600(field20735))
         .method03023(this);
      this.field20594 = new NumberSetting<Float>(field20637)
         .method10835(1.0F)
         .method10838(field20638)
         .method10834(field20639)
         .method03017(field20640)
         .method03025(() -> this.field20586.method05999() && this.field20587.method05600(field20733) && this.field20588.method05600(field20734))
         .method03023(this);
      this.field20595 = new NumberSetting<Float>(field20641)
         .method10835(1.0F)
         .method10838(field20642)
         .method10834(1.0F)
         .method03017(field20643)
         .method03025(this.field20586::method05999)
         .method03023(this);
      this.field20596 = new NumberSetting<Float>(field20644)
         .method10835(1.0F)
         .method10838(field20645)
         .method10834(field20646)
         .method03017(field20647)
         .method03025(this.field20586::method05999)
         .method03023(this);
      this.field20597 = new ToggleSetting(field20648).method03017(false).method03023(this);
      this.field20598 = new ModeSetting(field20649)
         .method05597(field20650, field20651)
         .method03017(field20652)
         .method03025(this.field20597::method05999)
         .method03023(this);
      this.field20599 = new ToggleSetting(field20653)
         .method03017(false)
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20732))
         .method03023(this);
      this.field20600 = new ModeSetting(field20654)
         .method05597(field20655, field20656)
         .method03017(field20657)
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20731) && this.field20599.method05999())
         .method03023(this);
      this.field20601 = new ModeSetting(field20658)
         .method05597(field20659, field20660)
         .method03017(field20661)
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20730) && this.field20599.method05999())
         .method03023(this);
      this.field20602 = new ColorSetting(field20662)
         .method03017(new Color(255, 255, 255))
         .method03025(
            () -> this.field20597.method05999()
               && this.field20598.method05600(field20728)
               && this.field20599.method05999()
               && this.field20600.method05600(field20729)
         )
         .method03023(this);
      this.field20603 = new ColorSetting(field20663)
         .method03017(new Color(0, 170, 255))
         .method03025(
            () -> this.field20597.method05999()
               && this.field20598.method05600(field20725)
               && this.field20599.method05999()
               && this.field20600.method05600(field20726)
               && this.field20601.method05600(field20727)
         )
         .method03023(this);
      this.field20604 = new SliderSetting(field20664)
         .method03017(0.0F)
         .method03025(
            () -> this.field20597.method05999()
               && this.field20598.method05600(field20723)
               && this.field20599.method05999()
               && this.field20601.method05600(field20724)
         )
         .method03023(this);
      this.field20605 = new NumberSetting<Float>(field20665)
         .method10835(field20666)
         .method10838(field20667)
         .method10834(field20668)
         .method03017(field20669)
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20722))
         .method03023(this);
      this.field20606 = new NumberSetting<Float>(field20670)
         .method10835(field20671)
         .method10838(field20672)
         .method10834(field20673)
         .method03017(1.0F)
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20721))
         .method03023(this);
      this.field20607 = new NumberSetting<Float>(field20674)
         .method10835(2.0F)
         .method10838(field20675)
         .method10834(1.0F)
         .method03017(field20676)
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20720))
         .method03023(this);
      this.field20608 = new NumberSetting<Float>(field20677)
         .method10835(1.0F)
         .method10838(field20678)
         .method10834(field20679)
         .method03017(field20680)
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20719))
         .method03023(this);
      this.field20609 = new ModeSetting(field20681)
         .method05597(field20682, field20683, field20684)
         .method03016(field20685)
         .method03017(field20686)
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20718))
         .method03023(this);
      this.field20610 = new ColorSetting(field20687)
         .method03017(new Color(0, 170, 255))
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20716) && this.field20609.method05600(field20717))
         .method03023(this);
      this.field20611 = new ColorSetting(field20688)
         .method03017(new Color(170, 0, 255))
         .method03025(() -> this.field20597.method05999() && this.field20598.method05600(field20714) && this.field20609.method05600(field20715))
         .method03023(this);
      this.method03935(field20689);
   }

   public boolean method09096() {
      return this.field20587.method05600(field20694) && this.field20588.method05600(field20695);
   }

   public boolean method09098() {
      return this.field20597.method05999() && !this.method09128() && this.field20599.method05999();
   }

   public boolean method09099() {
      return this.field20601.method05600(field20708);
   }

   public boolean method09100() {
      return this.method03937();
   }

   public float method09101() {
      return this.field20604.method00359();
   }

   public float method09102() {
      return this.field20607.method03022();
   }

   public int method09103() {
      int var1 = this.field20600.method05600(field20709) ? this.field20602.method11676() : ColorUtils.Nested138.method04636();
      return var1 & field20710;
   }

   public float method09104() {
      return this.field20596.method03022();
   }

   public float method09105() {
      return this.field20606.method03022();
   }

   public float method09106() {
      return this.field20594.method03022();
   }

   public float method09107() {
      return this.field20592.method00357();
   }

   public boolean method09109() {
      return this.field20587.method05600(field20696);
   }

   public boolean method09110() {
      return this.field20609.method05600(field20703);
   }

   public boolean method09112() {
      return this.method09109() && this.field20589.method05600(field20697);
   }

   public float method09113() {
      return field20713;
   }

   public boolean method09117() {
      return this.field20597.method05999();
   }

   public float method09118() {
      return this.field20595.method03022();
   }

   public float method09120() {
      return this.field20592.method00359();
   }

   public int method09121() {
      int var1 = this.field20600.method05600(field20711) ? this.field20603.method11676() : ColorUtils.Nested138.method04637();
      return var1 & field20712;
   }

   public boolean method09123() {
      return this.field20586.method05999();
   }

   public int method09127() {
      int var1 = this.field20609.method05600(field20704) ? this.field20610.method11676() : ColorUtils.Nested138.method04636();
      return var1 & field20705;
   }

   public boolean method09128() {
      return this.field20598.method05600(field20702);
   }

   public float method09130() {
      return this.field20605.method03022();
   }
}
