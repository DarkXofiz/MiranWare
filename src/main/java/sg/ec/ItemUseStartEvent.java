// Original binary: sg/ec/gSIfE40mWJXTtPXX
package sg.ec;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public class ItemUseStartEvent extends Event {
   public static final ItemUseStartEvent field19542 = new ItemUseStartEvent();
   private LivingEntity field19543;
   private ItemStack field19544;

   public LivingEntity method08456() {
      return this.field19543;
   }

   public void method08457(LivingEntity var1, ItemStack var2) {
      this.field19543 = var1;
      this.field19544 = var2;
      super.method03208();
   }

   public void method08458(ItemStack var1) {
      this.field19544 = var1;
   }

   public ItemStack method08459() {
      return this.field19544;
   }

   public void method08460(LivingEntity var1) {
      this.field19543 = var1;
   }

   public void method08461(LivingEntity var1) {
      this.field19543 = var1;
      this.field19544 = ((LivingEntityMixin_1248)(Object)var1).activeItemStack();
      super.method03208();
   }
}
