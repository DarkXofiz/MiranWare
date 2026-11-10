// Original binary: sg/ec/8YTBlPYS07Z4dwkp
package sg.ec;

import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class ArmorColorEvent extends Event {
   public static final ArmorColorEvent field04612 = new ArmorColorEvent();
   private ItemStack field04613;
   private int field04614;
   private boolean field04615;

   public ItemStack method01909() {
      return this.field04613;
   }

   public void method01910(int var1) {
      this.method01913(var1);
   }

   public int method01911(ItemStack var1, int var2) {
      this.field04613 = var1;
      this.field04614 = var2;
      this.field04615 = false;
      super.method03208();
      this.method05694();
      return this.field04615 ? this.field04614 : var2;
   }

   public int method01912() {
      return this.field04614;
   }

   public void method01913(int var1) {
      this.field04614 = var1;
      this.field04615 = true;
   }

   public boolean method01914() {
      return this.field04615;
   }
}
