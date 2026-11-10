// Original binary: sg/ec/fE5zndaDy6kx3CfH
package sg.ec;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public class StopUsingItemEvent extends Event {
   public static final StopUsingItemEvent field18897 = new StopUsingItemEvent();
   private LivingEntity field18898;
   private ItemStack field18899;

   public LivingEntity method08030() {
      return this.field18898;
   }

   public void method08031(LivingEntity var1) {
      this.field18898 = var1;
   }

   public void method08032(LivingEntity var1, CallbackInfo var2) {
      this.method05695(false);
      this.field18898 = var1;
      this.field18899 = ((LivingEntityMixin_1248)(Object)var1).activeItemStack();
      super.method03208();
      if (this.method05694()) {
         var2.cancel();
      }
   }

   public ItemStack method08033() {
      return this.field18899;
   }

   public void method08034(ItemStack var1) {
      this.field18899 = var1;
   }
}
