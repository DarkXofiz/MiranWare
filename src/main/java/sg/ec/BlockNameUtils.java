// Original binary: sg/ec/Hn1MEcieY6IPOHHp
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class BlockNameUtils {
   private static final String field08578 = "tile.";
   private static final String field08579 = "field08579";
   private static final Map<BlockEntityType<?>, List<Block>> field08580 = new ConcurrentHashMap<>();
   private static final String field08581 = " ";
   private static final String field08582 = "_";
   private static final String field08583 = "block.minecraft.";

   public static String method03810(BlockEntityType<?> var0) {
      return BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(var0).toString();
   }

   public static String method03811(EntityType<?> var0) {
      return "entity." + BuiltInRegistries.ENTITY_TYPE.getKey(var0).getPath();
   }

   public static String method03812(Block var0) {
      return var0.getDescriptionId().replace(field08583, "");
   }

   public static List<Block> method03813(BlockEntityType<?> var0) {
      return field08580.computeIfAbsent(var0, var0x -> {
         ArrayList var1 = new ArrayList();

         for (Block var3 : BuiltInRegistries.BLOCK) {
            if (var0x.isValid(var3.defaultBlockState())) {
               var1.add(var3);
            }
         }

         return var1;
      });
   }

   public static String method03814(EntityType<?> var0) {
      return BuiltInRegistries.ENTITY_TYPE.getKey(var0).toString();
   }

   public static String method03815(BlockEntityType<?> var0) {
      return "tile." + BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(var0).getPath();
   }

   public static BlockState method03816(BlockEntityType<?> var0) {
      var var1 = method03813(var0);
      return var1.isEmpty() ? Blocks.AIR.defaultBlockState() : ((Block)var1.getFirst()).defaultBlockState();
   }

   public static Item method03818(EntityType<?> var0) {
      Identifier var1 = BuiltInRegistries.ENTITY_TYPE.getKey(var0);
      Item var2 = BuiltInRegistries.ITEM.getOptional(var1).orElse(null);
      if (var2 != null) {
         return var2;
      }

      Identifier var3 = Identifier.fromNamespaceAndPath(var1.getNamespace(), var1.getPath() + "_spawn_egg");
      return BuiltInRegistries.ITEM.getOptional(var3).orElse(Items.AIR);
   }

   private BlockNameUtils() {
   }

   public static BlockEntityType<?> method03819(String var0) {
      return BuiltInRegistries.BLOCK_ENTITY_TYPE.getOptional(Identifier.tryParse(var0)).orElse(null);
   }

   public static String method03820(String var0) {
      return var0.replace(field08581, "").replace(field08582, "").toLowerCase();
   }

   public static EntityType<?> method03821(String var0) {
      return BuiltInRegistries.ENTITY_TYPE.getOptional(Identifier.tryParse(var0)).orElse(null);
   }
}
