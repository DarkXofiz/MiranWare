// Original binary: sg/ec/tLkKOADjOk6KN3Bl
package sg.ec;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

// $VF: Compiled from s
final class ItemTagAliases {
   static final TagKey<Item> field23894 = method10819(ItemTagAliases.field23909);
   static final TagKey<Item> field23895 = method10819(ItemTagAliases.field23910);
   static final TagKey<Item> field23896 = method10819(ItemTagAliases.field23911);
   static final TagKey<Item> field23897 = method10819(ItemTagAliases.field23912);
   static final TagKey<Item> field23898 = method10819(ItemTagAliases.field23913);
   static final TagKey<Item> field23899 = method10819(ItemTagAliases.field23914);
   static final TagKey<Item> field23900 = method10819(ItemTagAliases.field23915);
   static final TagKey<Item> field23901 = method10819(ItemTagAliases.field23916);
   static final TagKey<Item> field23902 = method10819(ItemTagAliases.field23917);
   static final TagKey<Item> field23903 = method10819(ItemTagAliases.field23918);
   static final TagKey<Item> field23904 = method10819(ItemTagAliases.field23919);
   static final TagKey<Item> field23905 = method10820(ItemTagAliases.field23920);
   static final TagKey<Item> field23906 = method10820(ItemTagAliases.field23921);
   private static final String field23907 = "minecraft";
   private static final String field23908 = "c";
   private static final String field23909 = "pickaxes";
   private static final String field23910 = "swords";
   private static final String field23911 = "axes";
   private static final String field23912 = "shovels";
   private static final String field23913 = "hanging_signs";
   private static final String field23914 = "signs";
   private static final String field23915 = "doors";
   private static final String field23916 = "skulls";
   private static final String field23917 = "bundles";
   private static final String field23918 = "beds";
   private static final String field23919 = "copper_golem_statues";
   private static final String field23920 = "music_discs";
   private static final String field23921 = "nuggets";

   private static TagKey<Item> method10819(String var0) {
      return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(field23907, var0));
   }

   private ItemTagAliases() {
   }

   private static TagKey<Item> method10820(String var0) {
      return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(field23908, var0));
   }
}
