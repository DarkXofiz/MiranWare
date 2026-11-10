// Original binary: sg/ec/yVgIXrUCYDpSsXMS
package sg.ec;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class ContainerKeyEvent extends Event {
   public static final ContainerKeyEvent field26473 = new ContainerKeyEvent();
   private AbstractContainerScreen<?> field26474;
   private int field26475;
   private int field26476;
   private int field26477;
   private CallbackInfoReturnable<Boolean> field26478;

   public void method11617(int var1) {
      this.field26475 = var1;
   }

   public AbstractContainerScreen<?> method11618() {
      return this.field26474;
   }

   public void method11619(CallbackInfoReturnable<Boolean> var1) {
      this.field26478 = var1;
   }

   public CallbackInfoReturnable<Boolean> method11620() {
      return this.field26478;
   }

   public void method11621(AbstractContainerScreen<?> var1) {
      this.field26474 = var1;
   }

   public int method11622() {
      return this.field26476;
   }

   public void method11623(int var1) {
      this.field26476 = var1;
   }

   public int method11624() {
      return this.field26475;
   }

   public void method11625(int var1) {
      this.field26477 = var1;
   }

   public int method11626() {
      return this.field26477;
   }

   public void method11627(AbstractContainerScreen<?> var1, int var2, int var3, int var4, CallbackInfoReturnable<Boolean> var5) {
      this.field26474 = var1;
      this.field26475 = var2;
      this.field26476 = var3;
      this.field26477 = var4;
      this.field26478 = var5;
      super.method03208();
   }
}
