// Original binary: sg/ec/oJWyjsjqEAzbnOn3
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public abstract class GuiComponent implements MinecraftAccess {
   private float field22094;
   private float field22095;
   private float field22096;
   private float field22097;
   private float field22098;

   public float method09780() {
      return this.field22094;
   }

   public void method00250(int var1, int var2, int var3) {
   }

   public void method09781(float var1) {
      this.field22096 = var1;
   }

   public float method09782() {
      return this.field22095;
   }

   public abstract void method00040(double var1, double var3, int var5);

   public void method09783(float var1) {
      this.field22098 = var1;
   }

   public float method09784() {
      return this.field22096;
   }

   public abstract void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4);

   public float method09785() {
      return this.field22097;
   }

   public void method09786(float var1) {
      this.field22097 = var1;
   }

   public boolean method09787(double var1, double var3) {
      return GuiHitTestUtils.method05609(var1, var3, this.field22094, this.field22095, this.field22096, this.field22097);
   }

   public void method09788(float var1) {
      this.field22095 = var1;
   }

   public void method03946(char var1, int var2) {
   }

   public void method07531() {
   }

   public void method09789(float var1) {
      this.field22094 = var1;
   }

   public void method02632(double var1, double var3, int var5) {
   }

   public float method09790() {
      return this.field22098;
   }
}
