// Original binary: sg/ec/kaQYni9Q7E1lJCTa
package sg.ec;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.Hud;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class HotbarRenderEvent extends Event {
   public static final HotbarRenderEvent field20796 = new HotbarRenderEvent();
   private DeltaTracker field20797;
   private Minecraft field20798;
   private Hud field20799;
   private GuiGraphics field20800;
   private HotbarRenderEvent.Nested254 field20801;
   private CallbackInfo field20802;

   public void method09169(CallbackInfo var1) {
      this.field20802 = var1;
   }

   public GuiGraphics method09170() {
      return this.field20800;
   }

   public CallbackInfo method09171() {
      return this.field20802;
   }

   public void method09172(HotbarRenderEvent.Nested254 var1, DeltaTracker var2, Minecraft var3, Hud var4, GuiGraphics var5, CallbackInfo var6) {
      this.field20801 = var1;
      this.field20797 = var2;
      this.field20798 = var3;
      this.field20799 = var4;
      this.field20800 = var5;
      this.field20802 = var6;
      super.method03208();
      if (this.method05694()) {
         var6.cancel();
      }
   }

   public void method09173(Minecraft var1) {
      this.field20798 = var1;
   }

   public void method09174(HotbarRenderEvent.Nested254 var1) {
      this.field20801 = var1;
   }

   public Minecraft method09175() {
      return this.field20798;
   }

   public void method09176(DeltaTracker var1) {
      this.field20797 = var1;
   }

   public void method09177(Hud var1) {
      this.field20799 = var1;
   }

   public void method09178(GuiGraphics var1) {
      this.field20800 = var1;
   }

   public HotbarRenderEvent.Nested254 method09179() {
      return this.field20801;
   }

   public Hud method09180() {
      return this.field20799;
   }

   public DeltaTracker method09181() {
      return this.field20797;
   }

   // $VF: Compiled from s
   public enum Nested254 {
      START,
      END;
   }
}
