// Original binary: sg/ec/zdq5S0bRXDIZZws5
package sg.ec;

import hex.script.api.Item;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.Arrays;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.equipment.Equippable;

// $VF: Compiled from s
final class ScriptItemSnapshotCache {
   private static final int field27912 = 255;
   private static final String[] field27913 = new String[0];
   private static final int[] field27914 = new int[0];
   private static final ScriptItemSnapshotCache.Nested333[] field27915 = new ScriptItemSnapshotCache.Nested333[256];
   private static final Object2IntOpenHashMap<Holder<Enchantment>> field27916 = new Object2IntOpenHashMap();
   private static final int field27917 = 0;
   private static final ItemStack[] field27918 = new ItemStack[4096];
   private static int field27919;
   private static int field27920 = 1;

   static Item method11754(ItemStack var0) {
      Item var1 = new Item();
      if (var0 != null && !var0.isEmpty()) {
         ScriptItemSnapshotCache.Nested333 sx = method11758(var0);
         var1.set(sx.field27922, sx.field27923, var0.getCount(), var0.getDamageValue(), var0.getMaxDamage());
         var1.handle(method11756(var0));
         var1.set(sx.field27924, sx.field27925, sx.field27926, sx.field27927, sx.field27928, sx.field27929, sx.field27930, sx.field27931, sx.field27932);
         var1.set(sx.field27933, sx.field27934, sx.field27935);
         return var1;
      } else {
         return var1;
      }
   }

   private ScriptItemSnapshotCache() {
   }

   static ItemStack method11755(long var0) {
      if (var0 != 0L && (int)(var0 >>> 32) == field27920) {
         ItemStack var2 = field27918[(int)var0 & 4095];
         return var2 == null ? ItemStack.EMPTY : var2;
      } else {
         return ItemStack.EMPTY;
      }
   }

   private static long method11756(ItemStack var0) {
      int var1 = field27919++ & 4095;
      field27918[var1] = var0;
      return (long)field27920 << 32 | var1;
   }

   private static ScriptItemSnapshotCache.Nested333 method11757(ItemStack var0) {
      ScriptItemSnapshotCache.Nested333 var1 = new ScriptItemSnapshotCache.Nested333();
      var1.field27921 = var0;
      var1.field27922 = String.valueOf(BuiltInRegistries.ITEM.getKey(var0.getItem()));
      var1.field27923 = var0.getHoverName().getString();
      var1.field27924 = var0.getMaxStackSize();
      var1.field27928 = var0.isStackable();
      var1.field27927 = var0.has(DataComponents.UNBREAKABLE);
      var1.field27929 = var0.has(DataComponents.FOOD);
      var1.field27930 = var0.has(DataComponents.TOOL);
      var1.field27932 = var0.hasNonDefault(DataComponents.CUSTOM_NAME) || var0.hasNonDefault(DataComponents.ITEM_NAME);
      Equippable var2 = var0.get(DataComponents.EQUIPPABLE);
      if (var2 != null) {
         EquipmentSlot var3 = var2.slot();
         ItemAttributeModifiers var4 = var0.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
         var1.field27931 = var3.isArmor();
         var1.field27925 = (float)var4.compute(Attributes.ARMOR, 0.0, var3);
         var1.field27926 = (float)var4.compute(Attributes.ARMOR_TOUGHNESS, 0.0, var3);
      }

      method11760(var0, var1);
      method11759(var0, var1);
      return var1;
   }

   private static ScriptItemSnapshotCache.Nested333 method11758(ItemStack var0) {
      int var1 = System.identityHashCode(var0) & 0xFF;
      ScriptItemSnapshotCache.Nested333 var2 = field27915[var1];
      if (var2 != null && var2.field27921 == var0) {
         return var2;
      }

      ScriptItemSnapshotCache.Nested333 var3 = method11757(var0);
      field27915[var1] = var3;
      return var3;
   }

   private static void method11759(ItemStack var0, ScriptItemSnapshotCache.Nested333 var1) {
      ItemLore var2 = var0.get(DataComponents.LORE);
      if (var2 != null) {
         var var3 = var2.lines();
         if (!var3.isEmpty()) {
            String[] var4 = new String[var3.size()];

            for (int var5 = 0; var5 < var4.length; var5++) {
               var4[var5] = ((Component)var3.get(var5)).getString();
            }

            var1.field27935 = var4;
         }
      }
   }

   private static void method11760(ItemStack var0, ScriptItemSnapshotCache.Nested333 var1) {
      synchronized (field27916) {
         EnchantmentUtils.method06759(var0, field27916);
         int var3 = field27916.size();
         if (var3 != 0) {
            String[] var4 = new String[var3];
            int[] var5 = new int[var3];
            int var6 = 0;

            for (ObjectIterator var7 = field27916.object2IntEntrySet().iterator(); var7.hasNext(); var6++) {
               Entry var8 = (Entry)var7.next();
               var4[var6] = ((Holder)var8.getKey()).getRegisteredName();
               var5[var6] = var8.getIntValue();
            }

            var1.field27933 = var4;
            var1.field27934 = var5;
         }
      }
   }

   static void method11761() {
      if (field27919 != 0) {
         Arrays.fill(field27918, null);
         field27919 = 0;
         if (++field27920 == 0) {
            field27920 = 1;
         }
      }
   }

   // $VF: Compiled from s
   private static final class Nested333 {
      private ItemStack field27921;
      private String field27922;
      private String field27923;
      private int field27924;
      private float field27925;
      private float field27926;
      private boolean field27927;
      private boolean field27928;
      private boolean field27929;
      private boolean field27930;
      private boolean field27931;
      private boolean field27932;
      private String[] field27933;
      private int[] field27934;
      private String[] field27935;
      private static final String field27936 = "minecraft:air";

      private Nested333() {
         this.field27922 = field27936;
         this.field27923 = "";
         this.field27933 = ScriptItemSnapshotCache.field27913;
         this.field27934 = ScriptItemSnapshotCache.field27914;
         this.field27935 = ScriptItemSnapshotCache.field27913;
      }
   }
}
