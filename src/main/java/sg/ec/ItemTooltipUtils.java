// Original binary: sg/ec/BDgkQ434UOJrYKlv
package sg.ec;

import java.util.List;
import java.util.regex.Pattern;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.TooltipFlag.Default;
import net.minecraft.world.item.component.ItemLore;

// $VF: Compiled from s
public final class ItemTooltipUtils implements MinecraftAccess {
   private static final Pattern field06218 = Pattern.compile(ItemTooltipUtils.field06219);
   private static final String field06219 = "(?i)§[0-9A-FK-OR]";

   private ItemTooltipUtils() {
   }

   public static List<Component> method02658(ItemStack var0) {
      if (var0 == null || var0.isEmpty()) {
         return List.of();
      } else if (mc != null && mc.level != null) {
         Default var2 = mc.options != null && mc.options.advancedItemTooltips ? TooltipFlag.ADVANCED : TooltipFlag.NORMAL;
         return var0.getTooltipLines(TooltipContext.of(mc.level), mc.player, var2);
      } else {
         ItemLore var1 = var0.get(DataComponents.LORE);
         return var1 == null ? List.of() : var1.lines();
      }
   }

   public static String method02659(String var0) {
      return var0 != null && !var0.isEmpty() ? field06218.matcher(var0).replaceAll("") : "";
   }

   public static List<Component> method02660(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         ItemLore var1 = var0.get(DataComponents.LORE);
         return var1 == null ? List.of() : var1.styledLines();
      } else {
         return List.of();
      }
   }
}
