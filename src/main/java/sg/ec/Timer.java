// Original binary: sg/ec/gW0BimIT6VZI4sOf
package sg.ec;

import net.minecraft.util.Mth;

// $VF: Compiled from s
public class Timer extends ClientModule {
   private final NumberSetting<Float> field19545;
   private final ToggleSetting field19546;
   private final NumberSetting<Float> field19547;
   public static float field19548 = Timer.field19568;
   public static float field19549 = 0.0F;
   private double field19550;
   private double field19551;
   private double field19552;
   private float field19553;
   private float field19554;
   private float field19555;
   private static final String field19556 = "Скорость";
   private static final float field19557 = 5.0F;
   private static final float field19558 = 0.1F;
   private static final float field19559 = 1.8F;
   private static final String field19560 = "Умный";
   private static final String field19561 = "Скорость убывания";
   private static final float field19562 = 0.5F;
   private static final float field19563 = 3.0F;
   private static final float field19564 = 0.1F;
   private static final String field19565 = "Timer";
   private static final float field19566 = 10.0F;
   private static final float field19567 = 10.0F;
   private static final float field19568 = 100.0F;

   public Timer() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field19545 = new NumberSetting<Float>(field19556)
         .method10835(1.0F)
         .method10838(field19557)
         .method10834(field19558)
         .method03017(field19559)
         .method03023(this);
      this.field19546 = new ToggleSetting(field19560).method03014(true).method03023(this);
      this.field19547 = new NumberSetting<Float>(field19561)
         .method10835(field19562)
         .method10838(field19563)
         .method10834(field19564)
         .method03017(1.0F)
         .method03025(this.field19546::method05999)
         .method03023(this);
      this.field19555 = 1.0F;
      this.method03935(field19565);
   }

   public double method08462() {
      return this.field19551;
   }

   @Subscribe
   private void method08463(TimerSpeedEvent var1) {
      var1.method05695(true);
      var1.method01450(this.field19555);
   }

   public float method08464() {
      return this.field19553;
   }

   public void method08465(float var1, float var2, double var3, double var5, double var7, boolean var9) {
      if (this.method08471(var3, var5, var7, var1, var2) || var9) {
         field19549++;
         field19549++;
      } else if (this.method03937()) {
         field19549 = field19549 - this.field19545.method03022() * 2.0F * this.field19547.method03022();
      }

      field19549 = (float)Mth.clamp(field19549, 0.0, field19548);
      this.field19550 = var3;
      this.field19551 = var5;
      this.field19552 = var7;
      this.field19553 = var1;
      this.field19554 = var2;
   }

   public float method08466() {
      return this.field19555;
   }

   public ToggleSetting method08467() {
      return this.field19546;
   }

   public NumberSetting<Float> method08468() {
      return this.field19547;
   }

   private static boolean method08469(
      double var0, double var2, double var4, float var6, float var7, double var8, double var10, double var12, float var14, float var15
   ) {
      return var0 == var8 && var2 == var10 && var4 == var12 && var6 == var14 && var7 == var15;
   }

   @Override
   public void method00382() {
      super.method00382();
      this.field19555 = 1.0F;
   }

   public float method08470() {
      return this.field19554;
   }

   private boolean method08471(double var1, double var3, double var5, float var7, float var8) {
      return method08469(var1, var3, var5, var7, var8, this.field19550, this.field19551, this.field19552, this.field19553, this.field19554);
   }

   public double method08472() {
      return this.field19550;
   }

   @Subscribe
   public void method08473(PlayerUpdateEvent var1) {
      if (this.field19546.method03022()) {
         if (field19549 > field19566) {
            this.field19555 = this.field19545.method03022();
         } else {
            this.field19555 = 1.0F;
         }
      } else {
         this.field19555 = this.field19545.method03022();
      }

      if (field19549 < field19567 && this.field19546.method03022()) {
         this.method00382();
      }
   }

   public NumberSetting<Float> method08474() {
      return this.field19545;
   }

   public double method08475() {
      return this.field19552;
   }
}
