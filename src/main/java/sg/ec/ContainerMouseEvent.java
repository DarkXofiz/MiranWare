// Original binary: sg/ec/pRyrkEoGOe6Uv6dK
package sg.ec;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class ContainerMouseEvent extends Event {
   public static final ContainerMouseEvent field22761 = new ContainerMouseEvent();
   private AbstractContainerScreen<?> field22762;
   private ContainerMouseEvent.Nested281 field22763;
   private double field22764;
   private double field22765;
   private int field22766;
   private double field22767;
   private CallbackInfoReturnable<Boolean> field22768;

   public void method10083() {
      this.field22768.setReturnValue(true);
   }

   public void method10084(AbstractContainerScreen<?> var1) {
      this.field22762 = var1;
   }

   public void method10085(
      AbstractContainerScreen<?> var1,
      ContainerMouseEvent.Nested281 var2,
      double var3,
      double var5,
      int var7,
      double var8,
      CallbackInfoReturnable<Boolean> var10
   ) {
      this.field22762 = var1;
      this.field22763 = var2;
      this.field22764 = var3;
      this.field22765 = var5;
      this.field22766 = var7;
      this.field22767 = var8;
      this.field22768 = var10;
      super.method03208();
   }

   public AbstractContainerScreen<?> method10086() {
      return this.field22762;
   }

   public int method10087() {
      return this.field22766;
   }

   public ContainerMouseEvent.Nested281 method10088() {
      return this.field22763;
   }

   public double method10089() {
      return this.field22765;
   }

   public CallbackInfoReturnable<Boolean> method10090() {
      return this.field22768;
   }

   public void method10091(double var1) {
      this.field22764 = var1;
   }

   public void method10092(double var1) {
      this.field22767 = var1;
   }

   public void method10093(int var1) {
      this.field22766 = var1;
   }

   public void method10094(double var1) {
      this.field22765 = var1;
   }

   public void method10095(ContainerMouseEvent.Nested281 var1) {
      this.field22763 = var1;
   }

   public void method10096(CallbackInfoReturnable<Boolean> var1) {
      this.field22768 = var1;
   }

   public double method10097() {
      return this.field22767;
   }

   public double method10098() {
      return this.field22764;
   }

   // $VF: Compiled from s
   public enum Nested281 {
      CLICK,
      DRAG,
      RELEASE,
      SCROLL;
   }
}
