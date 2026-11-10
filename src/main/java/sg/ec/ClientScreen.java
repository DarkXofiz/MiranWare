// Original binary: sg/ec/6kqkTDEv8eocCMBF
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public abstract class ClientScreen implements MinecraftAccess {
   private static final float field03569 = 0.15F;
   private static final float field03570 = 0;
   private final SmoothAnimation field03571 = new SmoothAnimation();
   private ClientScreen field03572;
   private boolean field03573;
   private static final float field03574 = 3.0F;
   private static final float field03575 = 0.9F;
   private static final float field03576 = 0.100000024F;
   private static final double field03577 = 0.15F;
   private static final double field03578 = 0.15F;

   public boolean method01463(double var1, double var3, double var5, double var7) {
      return false;
   }

   public boolean method01464(int var1, int var2, int var3) {
      return false;
   }

   public boolean method01465(double var1, double var3, int var5) {
      return false;
   }

   protected void method01466() {
   }

   protected final void method01467(GuiGraphics var1, float var2, float var3) {
      float var4 = GuiHitTestUtils.method05621(this.method01470());
      float var5 = var4 * var4 * (field03574 - 2.0F * var4);
      float var6 = field03575 + field03576 * var5;
      var1.pose().pushMatrix();
      var1.pose().translate(var2, var3);
      var1.pose().scale(1.0F, var6);
      var1.pose().translate(-var2, -var3);
   }

   ClientScreen method01468() {
      return this.field03572;
   }

   void method01469(ClientScreen var1) {
      this.field03572 = var1;
      if (!this.method01473()) {
         this.field03571.method06157(0.0);
      }

      this.field03573 = false;
      this.field03571.method06166(1.0, field03577);
      this.method01474();
   }

   protected final float method01470() {
      return this.field03571.method06173();
   }

   public boolean method01471() {
      return false;
   }

   protected abstract void method01472(GuiGraphics var1, int var2, int var3, float var4);

   boolean method01473() {
      return this.field03573 && !this.field03571.method06171();
   }

   protected void method01474() {
   }

   void method01475() {
      this.field03573 = true;
      this.field03571.method06166(0.0, field03578);
      this.method01466();
   }

   public boolean method01476(char var1, int var2) {
      return false;
   }

   public boolean method01477(double var1, double var3, int var5, boolean var6) {
      return false;
   }

   void method01478(GuiGraphics var1, int var2, int var3, float var4) {
      this.field03571.method06162();
      if (!this.field03573 || !this.field03571.method06171()) {
         GuiScaleUtils.method06750(var1);
         GuiRenderBatch.method05194();
         ItemRenderUtils.method08410();
         this.method01472(var1, var2, var3, var4);
         GuiRenderBatch.method05181();
         ItemRenderUtils.method08420();
         GuiScaleUtils.method06748(var1);
      }
   }

   public void method01479(int var1, int var2) {
   }
}
