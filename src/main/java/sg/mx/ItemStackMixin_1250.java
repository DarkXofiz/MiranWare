// Original binary: sg/mx/eHvY4lbRMnQNnyzj
package sg.mx;

import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.ItemStackAccess;

// $VF: Compiled from s
@Mixin(ItemStack.class)
public class ItemStackMixin_1250 implements ItemStackAccess {
   @Unique
   private static final int DEFAULT_SWING_SPEED = 10;
   @Unique
   private int transformPlusOne;
   @Unique
   private int swingSpeedDelta;
   @Unique
   private int shouldRenderAsBlockPlusOne;

   @Override
   public void hMI5_0$setTransform(boolean var1) {
      this.hMI5_0$setTransform(var1 ? 1 : 0);
   }

   @Override
   public void hMI5_0$setTransform(int var1) {
      this.transformPlusOne = var1 + 1;
   }

   @Override
   public int hMI5_0$getTransform() {
      return this.transformPlusOne - 1;
   }

   @Override
   public void hMI5_0$setSwingSpeed(int var1) {
      this.swingSpeedDelta = var1 - 10;
   }

   @Override
   public int hMI5_0$getSwingSpeed() {
      return 10 + this.swingSpeedDelta;
   }

   @Override
   public void hMI5_0$setRenderAsBlock(boolean var1) {
      this.shouldRenderAsBlockPlusOne = (var1 ? 1 : 0) + 1;
   }

   @Override
   public int hMI5_0$getRenderAsBlock() {
      return 0;
   }
}
