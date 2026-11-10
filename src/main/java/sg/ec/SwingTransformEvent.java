// Original binary: sg/ec/2W5Lc1QaRiWYblK8
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.HumanoidArm;

// $VF: Compiled from s
public class SwingTransformEvent extends Event {
   public static final SwingTransformEvent field01060 = new SwingTransformEvent();
   private SwingTransformEvent.Nested17 field01061;
   private PoseStack field01062;
   private HumanoidArm field01063;
   private float field01064;
   private float field01065;
   private float field01066;
   private float field01067;
   private int field01068;
   private float field01069;

   public float method00531() {
      return this.field01066;
   }

   public PoseStack method00532() {
      return this.field01062;
   }

   public void method00533(float var1) {
      this.field01066 = var1;
   }

   public void method00534(PoseStack var1, HumanoidArm var2, float var3, Runnable var4) {
      this.method05695(false);
      this.field01061 = SwingTransformEvent.Nested17.SWING_OFFSET;
      this.field01062 = var1;
      this.field01063 = var2;
      this.field01064 = var3;
      super.method03208();
      if (!this.method05694()) {
         var4.run();
      }
   }

   public void method00535(PoseStack var1, float var2, float var3, float var4, int var5, float var6) {
      this.method05695(false);
      this.field01061 = SwingTransformEvent.Nested17.EQUIP_OFFSET;
      this.field01062 = var1;
      this.field01065 = var2;
      this.field01066 = var3;
      this.field01067 = var4;
      this.field01068 = var5;
      this.field01069 = var6;
      super.method03208();
      if (!this.method05694()) {
         var1.translate(var2, var3, var4);
      }
   }

   public void method00536(PoseStack var1, float var2, float var3, float var4) {
      this.method05695(false);
      this.field01061 = SwingTransformEvent.Nested17.TRANSLATE;
      this.field01062 = var1;
      this.field01065 = var2;
      this.field01066 = var3;
      this.field01067 = var4;
      super.method03208();
      if (!this.method05694()) {
         var1.translate(var2, var3, var4);
      }
   }

   public void method00537(PoseStack var1) {
      this.field01062 = var1;
   }

   public SwingTransformEvent.Nested17 method00538() {
      return this.field01061;
   }

   public void method00539(float var1) {
      this.field01064 = var1;
   }

   public float method00540() {
      return this.field01065;
   }

   public int method00541() {
      return this.field01068;
   }

   public void method00542(SwingTransformEvent.Nested17 var1) {
      this.field01061 = var1;
   }

   public HumanoidArm method00543() {
      return this.field01063;
   }

   public void method00544(float var1) {
      this.field01065 = var1;
   }

   public void method00545(int var1) {
      this.field01068 = var1;
   }

   public void method00546(float var1) {
      this.field01067 = var1;
   }

   public float method00547() {
      return this.field01067;
   }

   public float method00548() {
      return this.field01064;
   }

   public void method00549(float var1) {
      this.field01069 = var1;
   }

   public void method00550(HumanoidArm var1) {
      this.field01063 = var1;
   }

   public float method00551() {
      return this.field01069;
   }

   // $VF: Compiled from s
   public enum Nested17 {
      TRANSLATE,
      SWING_OFFSET,
      EQUIP_OFFSET;
   }
}
