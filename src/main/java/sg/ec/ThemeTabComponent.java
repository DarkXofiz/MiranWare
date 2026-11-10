// Original binary: sg/ec/tQFMZAg9M2iKOkPn
package sg.ec;

import java.util.Objects;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ThemeTabComponent extends GuiComponent {
   private final ThemeSettings field23922;
   private final SmoothAnimation field23923 = new SmoothAnimation();
   private final ModuleContextMenu field23924;
   private final float field23925;
   private final float field23926;
   private final TextInputWidget field23927;
   private boolean field23928;
   private long field23929;
   private static final float field23930 = 5.0F;
   private static final float field23931 = 7.5F;
   private static final float field23932 = 7.5F;
   private static final double field23933 = 0.25;
   private static final float field23934 = 10.0F;
   private static final float field23935 = 5.0F;
   private static final float field23936 = 5.0F;
   private static final float field23937 = 5.0F;
   private static final float field23938 = 0.25F;
   private static final float field23939 = 0.25F;
   private static final float field23940 = 5.0F;
   private static final float field23941 = 0.5F;
   private static final float field23942 = 5.0F;
   private static final float field23943 = 5.0F;
   private static final float field23944 = 5.0F;
   private static final float field23945 = 5.0F;
   private static final float field23946 = 7.5F;
   private static final float field23947 = 5.0F;
   private static final float field23948 = 7.5F;
   private static final float field23949 = 10.0F;
   private static final float field23950 = 5.0F;
   private static final float field23951 = 5.0F;
   private static final float field23952 = 5.0F;
   private static final float field23953 = 7.5F;
   private static final float field23954 = 5.0F;
   private static final float field23955 = 10.0F;
   private static final float field23956 = 10.0F;
   private static final float field23957 = 5.0F;
   private static final float field23958 = 5.0F;
   private static final float field23959 = 5.0F;
   private static final float field23960 = 7.5F;
   private static final float field23961 = 5.0F;
   private static final float field23962 = 5.0F;
   private static final float field23963 = 125.0F;
   private static final long field23964 = 250L;
   private static final float field23965 = 5.0F;
   private static final float field23966 = 5.0F;
   private static final float field23967 = 5.0F;
   private static final float field23968 = 7.5F;
   private static final float field23969 = 7.5F;
   private static final float field23970 = 5.0F;
   private static final float field23971 = 7.5F;

   private boolean method10822(double var1, double var3, FontRenderer var5, float var6) {
      float var7 = this.method09780() + field23965 + var6 + field23966;
      float sx = this.method09782() + field23967;
      float sxx = var5.method09486(this.field23922.method09815(), field23968);
      float sxxx = var5.method09485(field23969);
      return GuiHitTestUtils.method05624((int)var1, (int)var3, var7, sx, sxx, sxxx);
   }

   private void method10823() {
      if (!this.field23928) {
         this.field23928 = true;
         this.field23927.method06675(this.field23922.method09815());
         this.field23927.method06716();
      }
   }

   public SmoothAnimation method10824() {
      return this.field23923;
   }

   private void method10825() {
      this.field23928 = false;
      this.field23927.method06702();
   }

   public float method10826() {
      Objects.requireNonNull(this);
      return field23970;
   }

   public long method10827() {
      return this.field23929;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      float var6 = this.method09785() - field23955;
      FontRenderer var7 = Fonts.field00109;
      boolean var8 = !ThemeManager.INSTANCE.method09614(this.field23922);
      if (var5 == 2 && var8 && this.method09787(var1, var3)) {
         ThemeManager.INSTANCE.method09617(this.field23922);
         this.field23928 = false;
      } else if (!this.field23928 || !this.field23927.method06703(var1, var3, var5)) {
         if (var5 == 0 && this.field23928) {
            this.method10828();
         }

         if (var8) {
            float var9 = field23956;
            if (GuiHitTestUtils.method05624(
               (int)var1,
               (int)var3,
               this.method09780() + field23957 + var6 + field23958,
               this.method09782() + field23959 + var7.method09485(field23960) + field23961,
               var9,
               var9
            )) {
               ThemeManager.INSTANCE.method09612(this.field23922);
               this.field23924.method09652(new ThemeEditorWindow(), field23962, GuiScaleUtils.method06754() / 2.0F - field23963);
               return;
            }

            if (var5 == 0 && this.method10822(var1, var3, var7, var6)) {
               long var10 = System.currentTimeMillis();
               if (var10 - this.field23929 < field23964) {
                  if (this.field23928) {
                     this.method10828();
                  } else {
                     this.method10823();
                  }

                  return;
               }

               this.field23929 = var10;
            }
         }

         if (GuiHitTestUtils.method05624((int)var1, (int)var3, this.method09780(), this.method09782(), this.method09784(), this.method09785())) {
            ThemeManager.INSTANCE.method09612(this.field23922);
         }
      }
   }

   public ThemeTabComponent(ThemeSettings var1, ModuleContextMenu var2) {
      this.field23925 = field23930;
      this.field23926 = field23931;
      this.field23927 = new TextInputWidget().method06678(Fonts.field00109, field23932);
      this.field23922 = var1;
      this.field23924 = var2;
      this.field23927.method06669(24);
      this.field23927.method06734(0.0F);
      this.field23927.method06681(false);
      this.field23927.method06689(this::method10828);
      this.field23927.method06705(this::method10825);
   }

   private void method10828() {
      ThemeManager.INSTANCE.method09616(this.field23922, this.field23927.method06687());
      this.method10825();
   }

   public ThemeSettings method10829() {
      return this.field23922;
   }

   @Override
   public void method00250(int var1, int var2, int var3) {
      this.field23927.method06733(var1);
   }

   public boolean method10830() {
      return this.field23928;
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      this.field23923.method06162();
      this.field23923.method06168(ThemeManager.INSTANCE.method09611() == this.field23922 ? 1.0 : 0.0, field23933, Easings.field19400, false);
      FontRenderer var5 = Fonts.field00109;
      float var6 = this.method09785() - field23934;
      int var7 = ColorUtils.method04611(this.field23922.field22119.method11676(), var4);
      RoundedRectRenderer.method01275(
         var1,
         this.method09780() + field23935,
         this.method09782() + field23936,
         var6,
         var6,
         GuiSize.method04763(field23937).method04768(),
         1.0F,
         new CornerColors(var7, var7, ColorUtils.method04596(var7, field23938), ColorUtils.method04596(var7, field23939))
      );
      GuiShapeRenderer.method09703(
         var1,
         this.method09780(),
         this.method09782(),
         this.method09784(),
         this.method09785(),
         field23940,
         1.0F,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), var4 * field23941)
      );
      float var8 = this.method09780() + field23942 + var6 + field23943;
      int var9 = ColorUtils.method04611(
         ColorUtils.method04631(
            ThemeManager.INSTANCE.method09611().field22110.method11676(),
            ThemeManager.INSTANCE.method09611().field22109.method11676(),
            this.field23923.method06173()
         ),
         var4
      );
      if (this.field23928) {
         this.field23927
            .method06700(
               var8, this.method09782() + field23944, this.method09784() - (var8 - this.method09780()) - field23945, var5.method09485(field23946) + 1.0F
            )
            .method06725(var1, var2, var9, var9, TextInputWidget.method06677(var4));
      } else if (!this.field23922.method09815().isEmpty()) {
         var5.method09480(var1, this.field23922.method09815(), var8, this.method09782() + field23947, var9, field23948);
      }

      if (!ThemeManager.INSTANCE.method09614(this.field23922)) {
         float var10 = field23949;
         GuiTextureRenderer.method10259(
            var1,
            ClientTextures.INSTANCE.method04565(),
            this.method09780() + field23950 + var6 + field23951,
            this.method09782() + field23952 + var5.method09485(field23953) + field23954,
            var10,
            var10,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22109.method11676(), this.field23923.method06173() * var4)
         );
      }
   }

   public float method10831() {
      Objects.requireNonNull(this);
      return field23971;
   }

   public ModuleContextMenu method10832() {
      return this.field23924;
   }

   public TextInputWidget method10833() {
      return this.field23927;
   }

   @Override
   public void method03946(char var1, int var2) {
      this.field23927.method06730(var1);
   }

   @Override
   public void method02632(double var1, double var3, int var5) {
      this.field23927.method06673(var1, var3, var5);
   }
}
