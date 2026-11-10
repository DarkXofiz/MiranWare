// Original binary: sg/ec/RsE5ySDtYq7f70KZ
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;

// $VF: Compiled from s
public class ContainerAnimationEvent extends Event {
   public static final ContainerAnimationEvent field11706 = new ContainerAnimationEvent();
   private float field11707;
   private float field11708;
   private Screen field11709;
   private GuiGraphicsExtractor field11710;
   private AnimationUtils field11711;
   private ContainerAnimationEvent.Nested164 field11712;
   private float field11713 = 1.0F;

   public void method05370(float var1) {
      this.field11707 = var1;
   }

   public void method05371(AnimationUtils var1) {
      this.field11711 = var1;
   }

   public float method05372() {
      return this.field11713;
   }

   public Screen method05373() {
      return this.field11709;
   }

   public float method05374() {
      return this.field11707;
   }

   public void method05375(float var1) {
      this.field11708 = var1;
   }

   public AnimationUtils method05376() {
      return this.field11711;
   }

   public float method05377() {
      return this.field11708;
   }

   public GuiGraphicsExtractor method05378() {
      return this.field11710;
   }

   public ContainerAnimationEvent.Nested164 method05379() {
      return this.field11712;
   }

   public void method05380(float var1) {
      this.field11713 = var1;
   }

   public void method05381(GuiGraphicsExtractor var1) {
      this.field11710 = var1;
   }

   public void method05382(Screen var1, GuiGraphicsExtractor var2, AnimationUtils var3) {
      this.field11709 = var1;
      this.field11710 = var2;
      this.field11711 = var3;
      this.field11712 = ContainerAnimationEvent.Nested164.END;
      super.method03208();
   }

   public void method05383(Screen var1) {
      this.field11709 = var1;
   }

   public void method05384(ContainerAnimationEvent.Nested164 var1) {
      this.field11712 = var1;
   }

   public void method05385(float var1, float var2, Screen var3, GuiGraphicsExtractor var4, AnimationUtils var5) {
      this.field11707 = var1;
      this.field11708 = var2;
      this.field11709 = var3;
      this.field11710 = var4;
      this.field11711 = var5;
      this.field11712 = ContainerAnimationEvent.Nested164.START;
      this.field11713 = 1.0F;
      super.method03208();
   }

   // $VF: Compiled from s
   public enum Nested164 {
      START,
      END;
   }
}
