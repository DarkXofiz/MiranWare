// Original binary: sg/ec/fnH46zlCw4wpJ1hi
package sg.ec;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class GuiRenderEvent extends Event {
   public static final GuiRenderEvent field19167 = new GuiRenderEvent();
   private DeltaTracker field19168;
   private GuiGraphicsExtractor field19169;
   private int field19170;
   private int field19171;

   public int method08307() {
      return this.field19170;
   }

   public void method08308(DeltaTracker var1, GuiGraphicsExtractor var2, int var3, int var4) {
      this.field19168 = var1;
      this.field19169 = var2;
      this.field19170 = var3;
      this.field19171 = var4;
      super.method03208();
   }

   public void method08309(int var1) {
      this.field19170 = var1;
   }

   public void method08310(GuiGraphicsExtractor var1) {
      this.field19169 = var1;
   }

   public GuiGraphicsExtractor method08311() {
      return this.field19169;
   }

   public DeltaTracker method08312() {
      return this.field19168;
   }

   public void method08313(int var1) {
      this.field19171 = var1;
   }

   public int method08314() {
      return this.field19171;
   }

   public void method08315(DeltaTracker var1) {
      this.field19168 = var1;
   }
}
