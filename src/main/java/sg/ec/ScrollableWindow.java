// Original binary: sg/ec/l4YkWmc2yxpDUspB
package sg.ec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public abstract class ScrollableWindow extends FloatingWindow {
   protected static final float field21167 = 6.0F;
   protected static final float field21168 = 0;
   private static final float field21169 = 0;
   private static final float field21170 = 0;
   private static final float field21171 = 0;
   private static final float field21172 = 0;
   private static final float field21173 = 0;
   private static final float field21174 = 0;
   private static final float field21175 = 0;
   private static final float field21176 = 0;
   private static final float field21177 = 0;
   private static final float field21178 = 0;
   private static final float field21179 = 0;
   private static final float field21180 = 0;
   private static final float field21181 = GuiSize.method04763(ScrollableWindow.field21239)
      .method04764(ScrollableWindow.field21240)
      .method04768();
   private static final int field21182 = 0;
   protected final FontRenderer field21183 = GuiThemeStyle.field03544;
   protected final GuiClickRegions field21184 = new GuiClickRegions();
   protected final GuiBounds field21185 = new GuiBounds();
   protected float field21186;
   private final Map<Object, SmoothAnimation> field21187 = new HashMap<>();
   private final String field21188;
   private final float field21189;
   private final float field21190;
   private boolean field21191;
   private boolean field21192;
   private float field21193;
   private float field21194;
   private static final float field21195 = 6.0F;
   private static final float field21196 = 21.0F;
   private static final float field21197 = 12.0F;
   private static final float field21198 = 21.0F;
   private static final float field21199 = 6.0F;
   private static final float field21200 = 6.0F;
   private static final float field21201 = 6.0F;
   private static final float field21202 = 7.0F;
   private static final float field21203 = 3.5F;
   private static final float field21204 = 7.0F;
   private static final float field21205 = 5.5F;
   private static final float field21206 = 11.5F;
   private static final float field21207 = 5.5F;
   private static final float field21208 = 10.5F;
   private static final float field21209 = 5.0F;
   private static final float field21210 = 6.0F;
   private static final float field21211 = 10.0F;
   private static final float field21212 = 10.0F;
   private static final float field21213 = 10.0F;
   private static final float field21214 = 10.0F;
   private static final float field21215 = 10.0F;
   private static final float field21216 = 1.5F;
   private static final float field21217 = 5.0F;
   private static final float field21218 = 5.0F;
   private static final float field21219 = 10.0F;
   private static final float field21220 = 10.0F;
   private static final float field21221 = 12.0F;
   private static final float field21222 = 10.0F;
   private static final float field21223 = 0.5F;
   private static final float field21224 = 2.5F;
   private static final float field21225 = 2.5F;
   private static final float field21226 = 2.2F;
   private static final float field21227 = 2.2F;
   private static final float field21228 = 2.2F;
   private static final float field21229 = 0.5F;
   private static final double field21230 = 0.15F;
   private static final float field21231 = 8.0F;
   private static final float field21232 = 8.0F;
   private static final float field21233 = 8.0F;
   private static final float field21234 = 8.0F;
   private static final float field21235 = 0.999F;
   private static final float field21236 = 21.0F;
   private static final float field21237 = 7.0F;
   private static final int field21238 = -1750963;
   private static final float field21239 = 10.0F;
   private static final float field21240 = 0.5F;

   private void method09302(GuiGraphics var1, int var2, int var3) {
      float var4 = this.method09304(var1, var2, var3);
      float sx = this.method09576() + field21200;
      float sxx = var4 - field21201 - sx;
      this.field21183
         .method09480(
            var1,
            GuiThemeStyle.method01438(this.field21183, this.method09566(), field21202, sxx),
            sx,
            this.method09560() + field21203,
            GuiThemeStyle.method01437(this.field21186),
            field21204
         );
      GuiThemeStyle.field03545
         .method09480(
            var1,
            GuiThemeStyle.method01438(GuiThemeStyle.field03545, this.field21188, field21205, sxx),
            sx,
            this.method09560() + field21206,
            GuiThemeStyle.method01445(this.field21186),
            field21207
         );
   }

   private void method09303(int var1, int var2) {
      if (this.field21192) {
         this.method08971(Math.max(this.field21189, var1 - this.method09576() + this.field21193));
         this.method09561(Math.max(this.field21190, var2 - this.method09560() + this.field21194));
      }
   }

   protected void method01901(double var1, double var3, int var5) {
   }

   private float method09304(GuiGraphics var1, int var2, int var3) {
      var var4 = this.method01897();
      float var5 = this.method09560() + field21208 - field21209;
      float var6 = this.method09576() + this.method09568() - field21210 - field21211;

      for (int var7 = var4.size() - 1; var7 >= 0; var7--) {
         ScrollableWindow.Nested257 var8 = (ScrollableWindow.Nested257)var4.get(var7);
         boolean var9 = var8.active().getAsBoolean();
         float var10 = this.method09305(var8, GuiHitTestUtils.method05624(var2, var3, var6, var5, field21212, field21213));
         GuiThemeStyle.method01448(var1, var6, var5, field21214, field21215, field21216, var10, this.field21186);
         int var11 = var9
            ? GuiThemeStyle.method01446(this.field21186)
            : GuiThemeStyle.method01443(
               GuiThemeStyle.method01440(
                  GuiThemeStyle.method01441().field22110.method11676(), GuiThemeStyle.method01441().field22109.method11676(), var10
               ),
               this.field21186
            );
         var8.icon().method09317(var1, var6 + field21217, var5 + field21218, var11);
         this.field21184.method03442(var6, var5, field21219, field21220, var8.action());
         var6 -= field21221;
      }

      return var6 + field21222 + 2.0F;
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (!(this.method09573().method06173() < field21235)) {
         if (var5 != 0) {
            if (this.field21185.method02799(var1, var3)) {
               this.method01901(var1, var3, var5);
            }
         } else if (!this.field21184.method03441(var1, var3)) {
            if (this.method09308(var1, var3)) {
               this.field21192 = true;
               this.field21193 = this.method09576() + this.method09568() - (float)var1;
               this.field21194 = this.method09560() + this.method09574() - (float)var3;
            } else if (GuiHitTestUtils.method05609(var1, var3, this.method09576(), this.method09560(), this.method09568(), field21236)) {
               this.field21191 = true;
               this.field21193 = (float)var1 - this.method09576();
               this.field21194 = (float)var3 - this.method09560();
            } else {
               if (this.field21185.method02799(var1, var3)) {
                  this.method01901(var1, var3, var5);
               }
            }
         }
      }
   }

   protected float method09305(Object var1, boolean var2) {
      SmoothAnimation var3 = this.field21187.computeIfAbsent(var1, var0 -> new SmoothAnimation());
      var3.method06162();
      var3.method06158(var2 ? 1.0 : 0.0, field21230, Easings.field19400);
      return var3.method06173();
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      if (this.field21185.method02799(var1, var3)) {
         this.method01899(var1, var3, var5);
      }
   }

   private void method09306(int var1, int var2) {
      if (this.field21191) {
         this.method09571(Mth.clamp(var1 - this.field21193, 0.0F, GuiScaleUtils.method06753() - this.method09568()));
         this.method09563(Mth.clamp(var2 - this.field21194, 0.0F, GuiScaleUtils.method06754() - this.method09574()));
      }
   }

   private void method09307() {
      this.field21185.method02801(this.method09576() + field21195);
      this.field21185.method02806(this.method09560() + field21196);
      this.field21185.method02803(this.method09568() - field21197);
      this.field21185.method02798(this.method09574() - field21198 - field21199);
   }

   private boolean method09308(double var1, double var3) {
      return this.method08354()
         && GuiHitTestUtils.method05609(
            var1, var3, this.method09576() + this.method09568() - field21231, this.method09560() + this.method09574() - field21232, field21233, field21234
         );
   }

   protected abstract List<ScrollableWindow.Nested257> method01897();

   protected ScrollableWindow(String var1, String var2, String var3, float var4, float var5) {
      super(var1, var2);
      this.field21188 = var3;
      this.field21189 = var4;
      this.field21190 = var5;
      this.method08971(var4);
      this.method09561(var5);
   }

   protected void method01900() {
   }

   protected void method01899(double var1, double var3, double var5) {
   }

   private void method09309(GuiGraphics var1) {
      int var2 = GuiThemeStyle.method01445(field21223 * this.field21186);
      float var3 = this.method09576() + this.method09568() - field21224;
      float var4 = this.method09560() + this.method09574() - field21225;

      for (int var5 = 0; var5 < 3; var5++) {
         for (int var6 = 0; var6 <= var5; var6++) {
            RoundedRectRenderer.method01272(
               var1, var3 - var5 * field21226 + var6 * field21227 - 1.0F, var4 - var6 * field21228 - 1.0F, 1.0F, 1.0F, field21229, 1.0F, var2
            );
         }
      }
   }

   protected static ScrollableWindow.Nested256 method09310(GuiIcon var0, float var1) {
      return (var2, var3, var4, var5) -> var0.method01190(var2, var3, var4, var1, var5);
   }

   protected boolean method08354() {
      return false;
   }

   protected ScrollableWindow.Nested257 method09311() {
      ScrollableWindow.Nested256 var1 = (var1x, var2, var3, var4) -> GuiIcon.CLOSE
         .method01190(var1x, var2, var3, field21237, ColorUtils.method04611(field21238, this.field21186));
      return new ScrollableWindow.Nested257(var1, () -> false, () -> this.method09580().method09654(this));
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      if (var5 == 0) {
         this.field21191 = false;
         this.field21192 = false;
      }
   }

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.field21186 = this.method09573().method06173() * GuiHitTestUtils.method05621(var4);
      this.method09306(var2, var3);
      this.method09303(var2, var3);
      this.method01900();
      this.method09307();
      this.field21184.method03440();
      GuiRenderBatch.method05183();
      ScrollbarRenderer.method06911(var1, this.method09576() + this.method09568() / 2.0F, this.method09560(), this.field21186);
      WindowFrameRenderer.method03057(var1, this, field21181, this.field21186);
      this.method09302(var1, var2, var3);
      this.method01894(var1, var2, var3);
      if (this.method08354()) {
         this.method09309(var1);
      }

      var1.pose().popMatrix();
   }

   protected abstract void method01894(GuiGraphics var1, int var2, int var3);

   @Override
   public boolean method01686() {
      return false;
   }

   // $VF: Compiled from s
   protected interface Nested256 {
      void method09317(GuiGraphics var1, float var2, float var3, int var4);
   }

   // $VF: Compiled from s
   protected record Nested257(ScrollableWindow.Nested256 icon, BooleanSupplier active, Runnable action) {
   }
}
