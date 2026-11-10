// Original binary: sg/ec/kmlfgvym6kQq8eew
package sg.ec;

import com.google.common.collect.ArrayListMultimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.AbstractSkullBlock;

// $VF: Compiled from s
public final class PlayerHeadUtils {
   private static final String field20909 = "textures";
   private static final String field20910 = "field20910";
   private static final String field20911 = "field20911";
   private static final String field20912 = "textures";
   private static final String field20913 = "\"url\"";
   private static final String field20914 = "textures";
   private static final String field20915 = "textures";
   private static final String field20916 = "Head";
   private static final String field20917 = "This is a utility class and cannot be instantiated";

   public static String method09239(ItemStack var0) {
      ResolvableProfile var1 = var0.get(DataComponents.PROFILE);
      if (var1 != null && var1.partialProfile() != null) {
         var var2 = var1.partialProfile().properties().get(field20912).iterator();
         if (var2.hasNext()) {
            Property sx = (Property)var2.next();
            return sx.value();
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private PlayerHeadUtils() {
      throw new UnsupportedOperationException(field20917);
   }

   public static String method09240(String var0) {
      String var1 = "{\"textures\":{\"SKIN\":{\"url\":\"http://textures.minecraft.net/texture/" + var0 + "\"}}}";
      return Base64.getEncoder().encodeToString(var1.getBytes(StandardCharsets.UTF_8));
   }

   public static String method09241(String var0) {
      if (var0 != null && !var0.isBlank()) {
         try {
            String var1 = new String(Base64.getDecoder().decode(var0), StandardCharsets.UTF_8);
            int var2 = var1.indexOf(field20913);
            if (var2 < 0) {
               return null;
            }

            int var3 = var1.indexOf(34, var2 + 5);
            if (var3 < 0) {
               return null;
            }

            int var4 = var1.indexOf(34, var3 + 1);
            return var4 < 0 ? null : var1.substring(var3 + 1, var4);
         } catch (IllegalArgumentException var5) {
            return null;
         }
      } else {
         return null;
      }
   }

   public static boolean method09242(ItemStack var0) {
      return var0.getItem() instanceof BlockItem var1 && var1.getBlock() instanceof AbstractSkullBlock;
   }

   public static void method09243(ItemStack var0, String var1) {
      ArrayListMultimap var2 = ArrayListMultimap.create();
      var2.put(field20914, new Property(field20915, var1));
      GameProfile var3 = new GameProfile(UUID.nameUUIDFromBytes(var1.getBytes(StandardCharsets.UTF_8)), field20916, new PropertyMap(var2));
      var0.set(DataComponents.PROFILE, ResolvableProfile.createResolved(var3));
   }

   public static String method09244(ItemStack var0) {
      String var1 = method09241(method09239(var0));
      if (var1 == null) {
         return null;
      }

      int var2 = var1.lastIndexOf(47);
      return var2 + 1 < var1.length() ? var1.substring(var2 + 1) : null;
   }
}
