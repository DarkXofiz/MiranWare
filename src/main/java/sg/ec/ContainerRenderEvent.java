// Original binary: sg/ec/pVkG2oq3660gAjM8
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

// $VF: Compiled from s
public class ContainerRenderEvent extends Event {
   public static final ContainerRenderEvent field22775 = new ContainerRenderEvent();
   private AbstractContainerScreen<?> field22776;
   private int field22777;
   private int field22778;
   private int field22779;
   private int field22780;
   private int field22781;
   private int field22782;
   private GuiGraphicsExtractor field22783;

   public int method10104() {
      return this.field22780;
   }

   public void method10105(int var1) {
      this.field22781 = var1;
   }

   public int method10106() {
      return this.field22782;
   }

   public void method10107(int var1) {
      this.field22782 = var1;
   }

   public int method10108() {
      return this.field22781;
   }

   public void method10109(GuiGraphicsExtractor var1) {
      this.field22783 = var1;
   }

   public void method10110(AbstractContainerScreen<?> var1) {
      this.field22776 = var1;
   }

   public void method10111(int var1) {
      this.field22778 = var1;
   }

   public void method10112(int var1) {
      this.field22780 = var1;
   }

   public void method10113(AbstractContainerScreen<?> var1, GuiGraphicsExtractor var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.field22776 = var1;
      this.field22783 = var2;
      this.field22777 = var3;
      this.field22778 = var4;
      this.field22779 = var5;
      this.field22780 = var6;
      this.field22781 = var7;
      this.field22782 = var8;
      super.method03208();
   }

   public AbstractContainerScreen<?> method10114() {
      return this.field22776;
   }

   public int method10115() {
      return this.field22778;
   }

   public void method10116(int var1) {
      this.field22777 = var1;
   }

   public int method10117() {
      return this.field22779;
   }

   public GuiGraphicsExtractor method10118() {
      return this.field22783;
   }

   public void method10119(int var1) {
      this.field22779 = var1;
   }

   public int method10120() {
      return this.field22777;
   }
}
