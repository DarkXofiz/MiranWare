// Original binary: sg/ec/olxLSlnEEB3TUzsz
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class InformationHud extends HudElement {
   private static final String field22193 = "Задержка Сервера к клиенту";
   private static final String field22194 = "field22194";
   private static final String field22195 = "field22195";
   private static final String field22196 = "field22196";
   private static final float field22197 = 0;
   private static final float field22198 = 0;
   private static final float field22199 = 0;
   private static final float field22200 = 0;
   private static final float field22201 = 0;
   private static final float field22202 = 0;
   private static final float field22203 = 0;
   private final NamedOption<Boolean> field22204;
   private final NamedOption<Boolean> field22205;
   private final NamedOption<Boolean> field22206;
   private final NamedOption<Boolean> field22207;
   private final MultiToggleSetting field22208;
   private final List<InformationHud.Nested277> field22209;
   private final InformationHud.Nested277 field22210;
   private final InformationHud.Nested277 field22211;
   private final InformationHud.Nested277 field22212;
   private final InformationHud.Nested277 field22213;
   private double field22214;
   private String field22215;
   private static final String field22216 = "Information";
   private static final String field22217 = "Задержка Сервера к клиенту";
   private static final String field22218 = "Отображение координат";
   private static final String field22219 = "Счетчик тпс сервера";
   private static final String field22220 = "Счетчик блоков в секунду";
   private static final String field22221 = "Элементы";
   private static final float field22222 = 5.0F;
   private static final float field22223 = 5.0F;
   private static final float field22224 = 4.0F;
   private static final float field22225 = 4.0F;
   private static final float field22226 = 4.0F;
   private static final float field22227 = 0.5F;
   private static final float field22228 = 7.0F;
   private static final float field22229 = 5.0F;
   private static final float field22230 = 5.0F;
   private static final float field22231 = 5.0F;
   private static final float field22232 = 5.0F;
   private static final double field22233 = 20.0;
   private static final double field22234 = 0.01F;
   private static final double field22235 = 0.01F;
   private static final double field22236 = 0.01F;
   private static final float field22237 = 5.0F;
   private static final float field22238 = 20.0F;
   private static final float field22239 = 5.0F;
   private static final float field22240 = 2.5F;
   private static final float field22241 = 25.0F;
   private static final float field22242 = 10.0F;
   private static final float field22243 = 2.5F;
   private static final float field22244 = 25.0F;
   private static final float field22245 = 5.0F;
   private static final float field22246 = 5.0F;

   private void method09877() {
      float var1 = this.method06454();
      float sx = this.method06450();
      int sxx = 0;
      int sxxx = 0;

      for (InformationHud.Nested277 sxxxx : this.field22209) {
         float sxxxxx = var1 - sxxxx.method09883() - field22239;
         float sxxxxxx = sx - sxx * (sxxxx.method09892() + field22240) - field22241;
         if (sxxxx.method09889()) {
            sxxxxx = field22242;
            sxxxxxx = sx - sxxx * (sxxxx.method09892() + field22243) - field22244;
            sxxx++;
         } else {
            sxx++;
         }

         sxxxx.method09891(sxxxxx);
         sxxxx.method09890(sxxxxxx);
      }
   }

   private void method09878(NamedOption<Boolean> var1, InformationHud.Nested277 var2, String var3) {
      if (Boolean.TRUE.equals(var1.method08074())) {
         var2.method09885(var3);
         var2.method09887(field14601.method09478(var3, field14607, -field14608) + field22237);
         var2.method09884(field22238);
         this.field22209.add(var2);
      }
   }

   public InformationHud() {
      super(field22216);
      this.field22204 = NamedOption.method08077(field22217, true);
      this.field22205 = NamedOption.method08077(field22218, true);
      this.field22206 = NamedOption.method08077(field22219, true);
      this.field22207 = NamedOption.method08077(field22220, false);
      this.field22208 = new MultiToggleSetting(field22221)
         .method04517(this.field22204)
         .method04517(this.field22205)
         .method04517(this.field22206)
         .method04517(this.field22207)
         .method04521(1)
         .method03023(this);
      this.field22209 = new ArrayList<>();
      this.field22210 = new InformationHud.Nested277(this.field22205, true, "");
      this.field22211 = new InformationHud.Nested277(this.field22204, true, "");
      this.field22212 = new InformationHud.Nested277(this.field22206, false, "");
      this.field22213 = new InformationHud.Nested277(this.field22207, false, "");
      this.field22214 = 0.0;
      this.field22215 = "";
   }

   @Override
   public void method00027(GuiGraphics var1) {
      super.method00027(var1);
      this.method09877();
      float var2 = this.method06455();

      for (InformationHud.Nested277 var4 : this.field22209) {
         float var5 = var4.method09886() - field22222;
         float var6 = var4.method09883() + field22223;
         int var7 = ColorUtils.method04611(this.method06460(), var2);
         this.method06439(var1, var5, var4.method09881(), var6, var4.method09892(), field22224, this.method06466(), 1.0F);
         RoundedRectRenderer.method01272(var1, var5, var4.method09881(), var6, var4.method09892(), field22225, this.method06466(), var7);
         if (!this.method06447()) {
            GuiShadowRenderer.method10984(var1, var5, var4.method09881(), var6, var4.method09892(), field22226, field22227, field22228, var7);
         }

         field14601.method09490(
            var1,
            var4.method09888(),
            var4.method09886(),
            var4.method09881() + var4.method09892() / 2.0F - field14607 / 2.0F,
            this.method06438(),
            field14607,
            -field14608
         );
      }

      if (!this.field22209.isEmpty()) {
         InformationHud.Nested277 var8 = this.field22209.getFirst();
         this.method06465(var8.method09886() - field22229);
         this.method06453(var8.method09881());
         this.method06448(var8.method09883() + field22230);
         this.method06456(var8.method09892());
      } else {
         this.method06465(0.0F);
         this.method06453(0.0F);
         this.method06448(0.0F);
         this.method06456(0.0F);
      }
   }

   private void method09879() {
      this.field22209.clear();
      String var1 = ServerLatencyTracker.INSTANCE.method01666() + " Ping";
      String var2 = GuiHitTestUtils.method05606(ServerTickRateTracker.INSTANCE.method00347(), field22235) + " Ticks";
      String var3 = GuiHitTestUtils.method05606(this.field22214, field22236) + " Blocks";
      this.method09878(this.field22205, this.field22210, this.field22215);
      this.method09878(this.field22204, this.field22211, var1);
      this.method09878(this.field22206, this.field22212, var2);
      this.method09878(this.field22207, this.field22213, var3);
   }

   @Override
   public void method00021(PreMovementPacketEvent var1) {
      double var2 = var1.method07315();
      double var4 = var1.method07307();
      double var6 = var1.method07298();
      float var8 = (float)(var2 - var1.method07321());
      float var9 = (float)(var4 - var1.method07306());
      float var10 = (float)(var6 - var1.method07316());
      float var11 = (float)Math.sqrt(var8 * var8 + var9 * var9 + var10 * var10);
      float var12 = (float)(var11 * field22233);
      this.field22214 = GuiHitTestUtils.method05606(var12, field22234);
      this.field22215 = "XYZ " + (int)var2 + ", " + (int)var4 + ", " + (int)var6;
      super.method00021(var1);
   }

   @Override
   public boolean method06444(float var1, float var2) {
      this.method09877();

      for (InformationHud.Nested277 var4 : this.field22209) {
         if (this.method09880(var4, var1, var2)) {
            this.method06465(var4.method09886() - field22231);
            this.method06453(var4.method09881());
            this.method06448(var4.method09883() + field22232);
            this.method06456(var4.method09892());
            return true;
         }
      }

      return false;
   }

   @Override
   public void method00034(TickEvent var1) {
      this.method09879();
      super.method00034(var1);
   }

   private boolean method09880(InformationHud.Nested277 var1, float var2, float var3) {
      return GuiHitTestUtils.method05625(
         var2, var3, var1.method09886() - field22245, var1.method09881(), var1.method09883() + field22246, var1.method09892()
      );
   }

   // $VF: Compiled from s
   private static class Nested277 {
      private final NamedOption<Boolean> field22247;
      private final boolean field22248;
      private String field22249;
      private float field22250;
      private float field22251;
      private float field22252;
      private float field22253;

      public float method09881() {
         return this.field22251;
      }

      public NamedOption<Boolean> method09882() {
         return this.field22247;
      }

      public Nested277(NamedOption<Boolean> var1, boolean var2, String var3) {
         this.field22247 = var1;
         this.field22248 = var2;
         this.field22249 = var3;
      }

      public float method09883() {
         return this.field22252;
      }

      public void method09884(float var1) {
         this.field22253 = var1;
      }

      public void method09885(String var1) {
         this.field22249 = var1;
      }

      public float method09886() {
         return this.field22250;
      }

      public void method09887(float var1) {
         this.field22252 = var1;
      }

      public String method09888() {
         return this.field22249;
      }

      public boolean method09889() {
         return this.field22248;
      }

      public void method09890(float var1) {
         this.field22251 = var1;
      }

      public void method09891(float var1) {
         this.field22250 = var1;
      }

      public float method09892() {
         return this.field22253;
      }
   }
}
