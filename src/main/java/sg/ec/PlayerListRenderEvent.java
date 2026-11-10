// Original binary: sg/ec/JmyXSostCXpIiF4Q
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class PlayerListRenderEvent extends Event {
   public static final PlayerListRenderEvent field09335 = new PlayerListRenderEvent();
   private GuiGraphics field09336;
   private PlayerListRenderEvent.Nested125 field09337;
   private float field09338;
   private Minecraft field09339;
   private PlayerTabOverlay field09340;

   public void method04111(float var1) {
      this.field09338 = var1;
   }

   public void method04112(PlayerListRenderEvent.Nested125 var1) {
      this.field09337 = var1;
   }

   public PlayerListRenderEvent.Nested125 method04113() {
      return this.field09337;
   }

   public GuiGraphics method04114() {
      return this.field09336;
   }

   public Minecraft method04115() {
      return this.field09339;
   }

   public void method04116(Minecraft var1) {
      this.field09339 = var1;
   }

   public PlayerTabOverlay method04117() {
      return this.field09340;
   }

   public void method04118(GuiGraphics var1, PlayerListRenderEvent.Nested125 var2, float var3) {
      this.field09336 = var1;
      this.field09337 = var2;
      this.field09338 = var3;
      super.method03208();
   }

   public void method04119(GuiGraphics var1, PlayerTabOverlay var2, Minecraft var3, CallbackInfo var4) {
      this.field09336 = var1;
      this.field09340 = var2;
      this.field09339 = var3;
      this.field09337 = PlayerListRenderEvent.Nested125.VISIBLE;
      super.method03208();
      if (this.method05694()) {
         var4.cancel();
      }
   }

   public void method04120(PlayerTabOverlay var1) {
      this.field09340 = var1;
   }

   public void method04121(GuiGraphics var1) {
      this.field09336 = var1;
   }

   public float method04122() {
      return this.field09338;
   }

   // $VF: Compiled from s
   public enum Nested125 {
      START,
      END,
      VISIBLE,
      ANIM_UPDATE;
   }
}
