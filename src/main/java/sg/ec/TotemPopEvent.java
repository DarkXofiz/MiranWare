// Original binary: sg/ec/6mvlXmcuhMaAsegv
package sg.ec;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public class TotemPopEvent extends Event {
   public static final TotemPopEvent field03649 = new TotemPopEvent();
   private Entity field03650;
   private ItemStack field03651;
   private float field03652;
   private float field03653;
   private float field03654;

   public void method01497(float var1) {
      this.field03654 = var1;
   }

   public float method01498() {
      return this.field03654;
   }

   public void method01499(Entity var1) {
      this.field03650 = var1;
      this.field03651 = method01500(var1);
      this.field03652 = (float)var1.getX();
      this.field03653 = (float)var1.getY();
      this.field03654 = (float)var1.getZ();
      super.method03208();
   }

   private static ItemStack method01500(Entity var0) {
      if (var0 instanceof LivingEntity var1) {
         ItemStack var2 = var1.getMainHandItem();
         if (var2.is(Items.TOTEM_OF_UNDYING)) {
            return var2.copy();
         }

         ItemStack var3 = var1.getOffhandItem();
         return var3.is(Items.TOTEM_OF_UNDYING) ? var3.copy() : ItemStack.EMPTY;
      } else {
         return ItemStack.EMPTY;
      }
   }

   public Entity method01501() {
      return this.field03650;
   }

   public void method01502(float var1) {
      this.field03653 = var1;
   }

   public float method01503() {
      return this.field03652;
   }

   public void method01504(Entity var1) {
      this.field03650 = var1;
   }

   public float method01505() {
      return this.field03653;
   }

   public void method01506(float var1) {
      this.field03652 = var1;
   }

   public ItemStack method01507() {
      return this.field03651;
   }

   public void method01508(ItemStack var1) {
      this.field03651 = var1;
   }
}
