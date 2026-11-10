// Original binary: hex/api/baritone/api/utils/accessor/ILootTable
package hex.api.baritone.api.utils.accessor;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;

// $VF: Compiled from s
public interface ILootTable {
   ObjectArrayList<ItemStack> invokeGetRandomItems(LootContext var1);
}
