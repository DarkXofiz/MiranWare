// Original binary: sg/ec/vxHb6NCt4Mu047Rk
package sg.ec;

import net.minecraft.client.Options;
import net.minecraft.world.entity.player.Input;

// $VF: Compiled from s
public abstract class PlayerMovementEvent extends Event {
   private float field24982;
   private float field24983;
   private boolean field24984;
   private boolean field24985;
   private boolean field24986;
   private static final float field24987 = -1.0F;

   public void method11158(float var1) {
      this.field24983 = var1;
   }

   public void method11159() {
      this.field24982 = 0.0F;
      this.field24983 = 0.0F;
      this.field24984 = false;
      this.field24985 = false;
      this.field24986 = false;
   }

   public boolean method11160() {
      return this.field24985;
   }

   public float method11161() {
      return this.field24982;
   }

   public abstract boolean method02726();

   public boolean method11162() {
      return this.field24984;
   }

   protected void method11163(float var1, float var2, boolean var3, boolean var4, boolean var5) {
      this.field24982 = var1;
      this.field24983 = var2;
      this.field24984 = var3;
      this.field24985 = var4;
      this.field24986 = var5;
   }

   public boolean method11164() {
      return this.field24982 != 0.0F || this.field24983 != 0.0F;
   }

   public boolean method11165() {
      return this.field24986;
   }

   public float method11166() {
      return this.field24983;
   }

   public abstract boolean method02725();

   public void method11167(float var1) {
      this.field24982 = var1;
   }

   public void method11168() {
      this.field24982 = 0.0F;
      this.field24983 = 0.0F;
   }

   public void method11169(boolean var1) {
      this.field24985 = var1;
   }

   protected void method11170(Options var1) {
      this.field24982 = method11172(var1.keyUp.isDown(), var1.keyDown.isDown());
      this.field24983 = method11172(var1.keyLeft.isDown(), var1.keyRight.isDown());
      this.field24984 = var1.keyJump.isDown();
      this.field24985 = var1.keyShift.isDown();
      this.field24986 = var1.keySprint.isDown();
   }

   public Input method11171() {
      return new Input(
         this.field24982 > 0.0F, this.field24982 < 0.0F, this.field24983 > 0.0F, this.field24983 < 0.0F, this.field24984, this.field24985, this.field24986
      );
   }

   private static float method11172(boolean var0, boolean var1) {
      return var0 == var1 ? 0.0F : (var0 ? 1.0F : field24987);
   }

   public void method11173(boolean var1) {
      this.field24984 = var1;
   }

   public void method11174(boolean var1) {
      this.field24986 = var1;
   }
}
