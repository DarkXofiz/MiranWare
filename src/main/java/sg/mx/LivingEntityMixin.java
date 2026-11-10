// Original binary: sg/mx/LfANa9BiYtXLzik7
package sg.mx;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.HelmetStackCacheAccess;

// $VF: Compiled from s
@Mixin(LivingEntity.class)
public class LivingEntityMixin implements HelmetStackCacheAccess {
   @Unique
   private ItemStack hex$stack;
   @Unique
   private long hex$stamp;

   @Override
   public ItemStack hex$helmet() {
      return this.hex$stack;
   }

   @Override
   public long hex$helmetStamp() {
      return this.hex$stamp;
   }

   @Override
   public void hex$helmet(ItemStack var1, long var2) {
      this.hex$stack = var1;
      this.hex$stamp = var2;
   }
}
