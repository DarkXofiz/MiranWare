// Original binary: sg/ec/ILQmug0lpPVJsDez
package sg.ec;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class ArmorDurabilityView extends ClientModule {
   private static final int field08733 = 4096;
   private static final int field08734 = 0;
   private static final long field08735 = 0;
   private final Long2IntOpenHashMap field08736 = new Long2IntOpenHashMap();
   private static final String field08737 = "Armor Durability View";
   private static final long field08738 = 4194303L;
   private static final long field08739 = 4194303L;

   private int method03882(ItemStack var1) {
      int var2 = var1.getDamageValue();
      int sx = var1.getMaxDamage();
      long sxx = this.method03885(var1, var2, sx);
      if (this.field08736.containsKey(sxx)) {
         return this.field08736.get(sxx);
      }

      if (this.field08736.size() >= 4096) {
         this.field08736.clear();
      }

      int sxxx = sx - var2;
      int sxxxx = ColorUtils.method04601(sxxx, sx, false);
      this.field08736.put(sxx, sxxxx);
      return sxxxx;
   }

   @Override
   public void method00245() {
      super.method00245();
      this.field08736.clear();
   }

   private boolean method03883(ItemStack var1) {
      return var1 != null && !var1.isEmpty() && var1.isDamageableItem() && var1.getMaxDamage() > 0;
   }

   public ArmorDurabilityView() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.method03935(field08737);
   }

   @Subscribe
   private void method03884(ArmorColorEvent var1) {
      ItemStack var2 = var1.method01909();
      if (this.method03883(var2)) {
         var1.method01910(this.method03882(var2));
      }
   }

   private long method03885(ItemStack var1, int var2, int var3) {
      long var4 = BuiltInRegistries.ITEM.getId(var1.getItem());
      return var4 << 44 | (var3 & field08738) << 22 | var2 & field08739;
   }
}
