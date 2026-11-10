// Original binary: sg/ec/Yo1Bcek1Iravl2gY
package sg.ec;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;

// $VF: Compiled from s
public final class EnchantmentUtils {
   @SafeVarargs
   public static boolean method06755(ItemStack var0, Holder<Enchantment>... var1) {
      if (var0.isEmpty()) {
         return false;
      }

      Object2IntOpenHashMap var2 = new Object2IntOpenHashMap();
      method06759(var0, var2);

      for (var sx : var1) {
         if (!var2.containsKey(sx)) {
            return false;
         }
      }

      return true;
   }

   public static boolean method06756(Object2IntMap<Holder<Enchantment>> var0, Holder<Enchantment> var1) {
      return var0.containsKey(var1);
   }

   public static int method06757(ItemStack var0, ResourceKey<Enchantment> var1) {
      if (var0.isEmpty()) {
         return 0;
      }

      Object2IntOpenHashMap var2 = new Object2IntOpenHashMap();
      method06759(var0, var2);
      String var3 = var1.identifier().toString();
      ObjectIterator var4 = var2.object2IntEntrySet().iterator();

      while (var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         if (((Holder)var5.getKey()).getRegisteredName().equals(var3)) {
            return var5.getIntValue();
         }
      }

      return 0;
   }

   private EnchantmentUtils() {
   }

   public static int method06758(Object2IntMap<Holder<Enchantment>> var0, Holder<Enchantment> var1) {
      return var0.getInt(var1);
   }

   public static void method06759(ItemStack var0, Object2IntMap<Holder<Enchantment>> var1) {
      var1.clear();
      if (!var0.isEmpty()) {
         ItemEnchantments var2 = var0.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
         ItemEnchantments var3 = var0.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);

         for (var var5 : var2.entrySet()) {
            var1.put((Holder)var5.getKey(), var5.getIntValue());
         }

         for (var var7 : var3.entrySet()) {
            var1.put((Holder)var7.getKey(), var7.getIntValue());
         }
      }
   }

   public static int method06760(ItemStack var0, Holder<Enchantment> var1) {
      if (var0.isEmpty()) {
         return 0;
      }

      Object2IntOpenHashMap var2 = new Object2IntOpenHashMap();
      method06759(var0, var2);
      return var2.getInt(var1);
   }
}
