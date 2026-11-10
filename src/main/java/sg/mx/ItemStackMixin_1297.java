// Original binary: sg/mx/qToKT9VtKLPPTlMj
package sg.mx;

import hex.api.baritone.api.utils.accessor.IItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
@Mixin(ItemStack.class)
public abstract class ItemStackMixin_1297 implements IItemStack {
   @Unique
   private int hex$baritoneHash;

   @Shadow
   public abstract int getDamageValue();

   @Shadow
   public abstract Item getItem();

   @Unique
   private void hex$recalculateHash() {
      Item var1 = this.getItem();
      this.hex$baritoneHash = var1 == null ? -1 : var1.hashCode() + this.getDamageValue();
   }

   @Inject(method = "setDamageValue", at = @At("TAIL"))
   private void hex$onItemDamageSet(CallbackInfo var1) {
      this.hex$recalculateHash();
   }

   @Override
   public int getBaritoneHash() {
      if (this.hex$baritoneHash == 0) {
         this.hex$recalculateHash();
      }

      return this.hex$baritoneHash;
   }
}
