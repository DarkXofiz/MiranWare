// Original binary: sg/mx/2CWd7BVodITF5BxK
package sg.mx;

import hex.api.baritone.api.utils.accessor.ILootTable;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(LootTable.class)
public abstract class LootTableMixin implements ILootTable {
   @Invoker
   @Override
   public abstract ObjectArrayList<ItemStack> invokeGetRandomItems(LootContext var1);
}
