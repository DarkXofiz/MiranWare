// Original binary: sg/ec/ucsss3R5QNNZmDI5
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;

// $VF: Compiled from s
public class ItemFeatureContextStack implements MinecraftAccess {
   private static final List<ItemFeatureContext> field24604 = new ArrayList<>();

   public static void method10964() {
      field24604.clear();
   }

   public static void method10965(ItemFeatureContext var0, ItemStack var1) {
      if (!var1.isEmpty() && var1.getUseAnimation() != ItemUseAnimation.EAT && var1.getUseAnimation() != ItemUseAnimation.DRINK) {
         field24604.add(var0);
      }
   }

   public static ItemFeatureContext method10966() {
      if (!field24604.isEmpty()) {
         ItemFeatureContext var0 = field24604.getFirst();
         field24604.remove(var0);
         return var0;
      } else {
         return new ItemFeatureContext(
            false, 0.0F, mc.player, InteractionHand.MAIN_HAND, false, 0.0F, 0.0F, 0.0F, 0.0F, false, false, false, false, false, false, ItemStack.EMPTY
         );
      }
   }
}
