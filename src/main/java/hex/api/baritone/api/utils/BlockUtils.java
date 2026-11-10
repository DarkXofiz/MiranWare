// Original binary: hex/api/baritone/api/utils/BlockUtils
package hex.api.baritone.api.utils;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public class BlockUtils {
   private static transient Map<String, Block> resourceCache = new HashMap<>();
   private static final String бч7 = "бч7";
   private static final String бчУ = "бчУ";
   private static final String бч0 = "бч0";

   public static Block stringToBlockRequired(String var0) {
      Block var1 = stringToBlockNullable(var0);
      if (var1 == null) {
         throw new IllegalArgumentException(String.format(бчУ, var0));
      } else {
         return var1;
      }
   }


   public static String blockToString(Block var0) {
      Identifier var1 = BuiltInRegistries.BLOCK.getKey(var0);
      String sx = var1.getPath();
      if (!var1.getNamespace().equals(бч7)) {
         sx = var1.toString();
      }

      return sx;
   }

   public static Block stringToBlockNullable(String var0) {
      Block var1 = resourceCache.get(var0);
      if (var1 != null) {
         return var1;
      }

      if (resourceCache.containsKey(var0)) {
         return null;
      }

      var1 = BuiltInRegistries.BLOCK.getOptional(Identifier.tryParse(var0.contains(бч0) ? var0 : "minecraft:" + var0)).orElse(null);
      var sx = new HashMap<>(resourceCache);
      sx.put(var0, var1);
      resourceCache = sx;
      return var1;
   }

   private BlockUtils() {
   }
}
