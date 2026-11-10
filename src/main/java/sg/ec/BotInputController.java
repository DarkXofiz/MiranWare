// Original binary: sg/ec/toDJx3JPUH4HgPMQ
package sg.ec;

import net.minecraft.world.entity.player.Input;

// $VF: Compiled from s
public final class BotInputController {
   private final BotClient field24175;
   private volatile boolean field24176;
   private volatile boolean field24177;
   private volatile boolean field24178;
   private volatile boolean field24179;
   private volatile boolean field24180;
   private volatile boolean field24181;
   private volatile boolean field24182;
   private volatile int field24183;

   public void method10866() {
      this.method10867(false, false, false, false, false, false, false);
      this.field24183 = 0;
   }

   public void method10867(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      this.field24176 = var1;
      this.field24177 = var2;
      this.field24178 = var3;
      this.field24179 = var4;
      this.field24180 = var5;
      this.field24181 = var6;
      this.field24182 = var7;
   }

   public BotClient method10868() {
      return this.field24175;
   }

   public boolean method10869() {
      return this.field24177;
   }

   public boolean method10870() {
      return this.field24181;
   }

   public boolean method10871() {
      return this.field24179;
   }

   public BotInputController(BotClient var1) {
      this.field24175 = var1;
   }

   public boolean method10872() {
      return this.field24180;
   }

   public Input method10873() {
      int var1 = this.field24183;
      return new Input(
         this.field24176 || var1 > 0,
         this.field24177 || var1 < 0,
         this.field24178 || var1 > 0,
         this.field24179 || var1 < 0,
         this.field24180,
         this.field24181,
         this.field24182
      );
   }

   public int method10874() {
      return this.field24183;
   }

   public void method10875() {
      this.method10866();
   }

   public boolean method10876() {
      return this.field24178;
   }

   public boolean method10877() {
      return this.field24182;
   }

   public void method10878(int var1) {
      this.field24183 = var1;
   }

   public boolean method10879() {
      return this.field24176;
   }
}
