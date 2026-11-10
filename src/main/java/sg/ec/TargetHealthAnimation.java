// Original binary: sg/ec/bL1KynLeXDwrSXzq
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class TargetHealthAnimation {
   private int field17359;
   private float field17360;
   private float field17361;
   private float field17362;
   private float field17363;
   private float field17364;
   private float field17365;
   private float field17366;
   private int field17367;
   private final AnimationUtils field17368;
   private static final long field17369 = 150L;
   private static final float field17370 = 0.5F;

   private void method07093() {
      this.field17368.method03375(this.field17367 > 22 ? 0.0 : 1.0);
   }

   public void method07094(float var1) {
      this.field17364 = var1;
   }

   public TargetHealthAnimation(float var1, float var2, float var3, float var4, float var5, int var6) {
      this.field17368 = new AnimationUtils(field17369);
      this.field17360 = var1;
      this.field17363 = var2;
      this.field17362 = var3;
      this.field17365 = var4;
      this.field17366 = var5;
      this.field17359 = var6;
   }

   public int method07095() {
      return this.field17367;
   }

   public float method07096() {
      return this.field17363;
   }

   public float method07097() {
      return this.field17364;
   }

   public void method07098(float var1) {
      this.field17361 = var1;
   }

   public void method07099(float var1) {
      this.field17365 = var1;
   }

   public float method07100() {
      return this.field17365;
   }

   public int method07101() {
      return this.field17359;
   }

   public void method07102(int var1) {
      this.field17367 = var1;
   }

   public float method07103() {
      return this.field17361;
   }

   public float method07104() {
      return this.field17360;
   }

   public float method07105() {
      return this.field17366;
   }

   public AnimationUtils method07106() {
      return this.field17368;
   }

   public void method07107() {
      this.field17367++;
      this.field17361 = this.field17360;
      this.field17364 = this.field17363;
      this.field17360 = this.field17360 + this.field17362;
      this.field17363 = this.field17363 + this.field17365;
      this.method07093();
   }

   public void method07108(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      this.method07093();
      float var5 = PlayerUtils.method11802();
      float var6 = Mth.lerp(var5, this.method07103(), this.method07104());
      float var7 = Mth.lerp(var5, this.method07097(), this.method07096());
      RoundedRectRenderer.method01274(
         var1,
         var6 + var2,
         var7 + var3,
         this.method07105(),
         ColorUtils.method04611(ColorUtils.method04621(this.method07101() * 5), field17370 * this.field17368.method03377() * var4)
      );
   }

   public void method07109(float var1) {
      this.field17366 = var1;
   }

   public void method07110(float var1) {
      this.field17362 = var1;
   }

   public void method07111(float var1) {
      this.field17360 = var1;
   }

   public void method07112(int var1) {
      this.field17359 = var1;
   }

   public void method07113(float var1) {
      this.field17363 = var1;
   }

   public float method07114() {
      return this.field17362;
   }
}
