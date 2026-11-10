// Original binary: sg/ec/e0G32zWvnfFETWqw
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;

// $VF: Compiled from s
public class InventoryActionSequence implements MinecraftAccess {
   private final List<InventoryActionSequence.Nested224> field18443 = new ArrayList<>();
   private int field18444;
   private int field18445;
   private boolean field18446;
   private boolean field18447 = true;
   private boolean field18448;
   private boolean field18449;
   private boolean field18450;
   private int[] field18451;

   public InventoryActionSequence method07534(Runnable var1, int var2, boolean var3) {
      this.field18443.add(new InventoryActionSequence.Nested224(var1, this.field18445, var2, var3, false, this.field18446));
      this.field18445 = 0;
      this.field18446 = false;
      return this;
   }

   public InventoryActionSequence method07535() {
      this.field18449 = true;
      return this;
   }

   public InventoryActionSequence method07536(Runnable var1, int var2, boolean var3) {
      this.field18443.add(new InventoryActionSequence.Nested224(var1, this.field18445, var2, var3, true, this.field18446));
      this.field18445 = 0;
      this.field18446 = false;
      return this;
   }

   void method07537() {
      this.field18450 = true;
   }

   private void method07538(InventoryActionSequence.Nested224 var1) {
      var1.clicks().run();
      if (var1.close() && mc.player != null) {
         PlayerUtils.method11812(new ServerboundContainerClosePacket(mc.player.containerMenu.containerId));
      }
   }

   public InventoryActionSequence method07539(int var1) {
      return this.method07542(var1, false);
   }

   public int method07540() {
      return this.field18444 < this.field18443.size() ? this.field18443.get(this.field18444).priority() : 0;
   }

   public int[] method07541() {
      return this.field18451;
   }

   public InventoryActionSequence method07542(int var1, boolean var2) {
      this.field18445 += var1;
      if (var2) {
         this.field18446 = true;
      }

      return this;
   }

   public InventoryActionSequence method07543() {
      this.field18448 = true;
      return this;
   }

   public boolean method07544() {
      return this.field18444 < this.field18443.size() && this.field18443.get(this.field18444).delayStop();
   }

   public InventoryActionSequence method07545() {
      return this.method07542(1, false);
   }

   public boolean method07546() {
      return this.field18450;
   }

   public boolean method07547() {
      return this.field18448;
   }

   public InventoryActionSequence method07548(int... var1) {
      this.field18451 = var1;
      return this;
   }

   public boolean method07549() {
      return this.field18444 < this.field18443.size();
   }

   public InventoryActionSequence method07550(Runnable var1) {
      return this.method07536(var1, 1, false);
   }

   public boolean method07551() {
      return this.field18444 < this.field18443.size() && this.field18443.get(this.field18444).use();
   }

   public boolean method07552() {
      return this.field18449;
   }

   public boolean method07553() {
      return this.field18447;
   }

   public int method07554() {
      if (this.field18444 >= this.field18443.size()) {
         return 0;
      }

      InventoryActionSequence.Nested224 var1 = this.field18443.get(this.field18444++);
      this.method07538(var1);

      while (
         this.field18444 < this.field18443.size()
            && this.field18443.get(this.field18444).delay() == 0
            && this.field18443.get(this.field18444).use() == var1.use()
      ) {
         var1 = this.field18443.get(this.field18444++);
         this.method07538(var1);
      }

      return this.field18444 < this.field18443.size() ? this.field18443.get(this.field18444).delay() : 0;
   }

   public InventoryActionSequence method07555(boolean var1) {
      this.field18447 = var1;
      return this;
   }

   public InventoryActionSequence method07556(Runnable var1) {
      return this.method07534(var1, 1, true);
   }

   // $VF: Compiled from s
   private record Nested224(Runnable clicks, int delay, int priority, boolean close, boolean use, boolean delayStop) {
   }
}
