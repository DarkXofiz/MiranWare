// Original binary: sg/ec/ittBiiWxAIJEtyIn
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class TextAreaSettingComponent extends SettingComponent<TextAreaSetting> {
   private static TextAreaSettingComponent field20131;
   private final FontRenderer field20132 = Fonts.field00110;
   private final TextInputWidget field20133 = new TextInputWidget();
   private boolean field20134;
   private static final float field20135 = 24.0F;
   private static final float field20136 = 6.5F;
   private static final float field20137 = 7.0F;
   private static final float field20138 = 9.0F;
   private static final float field20139 = 10.0F;
   private static final float field20140 = 3.0F;
   private static final float field20141 = 4.0F;
   private static final float field20142 = 8.0F;

   @Override
   public void method03946(char var1, int var2) {
      if (field20131 == this) {
         this.field20133.method06730(var1);
      }
   }

   @Override
   public void method02632(double var1, double var3, int var5) {
      this.field20133.method06673(var1, var3, var5);
   }

   public boolean method08858() {
      return this.field20134;
   }

   public static boolean method08859() {
      return field20131 != null;
   }

   public TextAreaSettingComponent(TextAreaSetting var1) {
      super(var1);
      this.method09786(field20135);
      this.field20133.method06678(this.field20132, field20136);
      this.field20133.method06717(var1.method05829());
      this.field20133.method06669(var1.method05827());
      this.field20133.method06681(false);
      this.field20133.method06675(var1.method05830());
   }

   public TextInputWidget method08860() {
      return this.field20133;
   }

   public FontRenderer method08861() {
      return this.field20132;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (this.field20134) {
         if (this.field20133.method06703(var1, var3, var5)) {
            field20131 = this;
         } else if (field20131 == this) {
            this.field20133.method06722();
            field20131 = null;
         }
      }
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      this.field20134 = true;
      int var5 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11679(), this.method09790());
      int var6 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22110.method11679(), this.method09790());
      int var7 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22123.method11676(), this.method09790());
      this.field20132.method09490(var1, this.method10977().method03024(), this.method09780(), this.method09782(), var5, field20137, 0.0F);
      float var8 = this.method09782() + field20138;
      float var9 = this.method09785() - field20139;
      RoundedRectRenderer.method01272(var1, this.method09780(), var8, this.method09784(), var9, field20140, 1.0F, var7);
      this.field20133
         .method06700(this.method09780() + field20141, var8, this.method09784() - field20142, var9)
         .method06725(var1, var2, var5, var6, TextInputWidget.method06677(this.method09790()));
      if (!this.method10977().method05830().equals(this.field20133.method06687())) {
         this.method10977().method03014(this.field20133.method06687());
      }
   }

   @Override
   public void method00250(int var1, int var2, int var3) {
      if (field20131 == this) {
         this.field20133.method06733(var1);
      }
   }
}
