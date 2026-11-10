// Original binary: sg/ec/gfYKkQ2PiIGDmxCz
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;

// $VF: Compiled from s
public class ServerJoinTextUtils implements MinecraftAccess {
   public static String method08510(String var0, ItemStack var1, boolean var2) {
      Component var3 = method08511(var0, var1);
      if (var3 == null) {
         return null;
      } else {
         return var2 ? var3.getString().trim() : var3.getString();
      }
   }

   public static Component method08511(String var0, ItemStack var1) {
      return method08518(var0, var1, false);
   }

   private static Component method08512(Component var0) {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      var0.visit((var2x, var3x) -> {
         var1.add(var2x);
         var2.add(var3x);
         return Optional.empty();
      }, Style.EMPTY);

      int var3;
      for (var3 = 0; var3 < var2.size(); var3++) {
         String var4 = ((String)var2.get(var3)).stripLeading();
         var2.set(var3, var4);
         if (!var4.isEmpty()) {
            break;
         }
      }

      int var7;
      for (var7 = var2.size() - 1; var7 >= var3; var7--) {
         String var5 = ((String)var2.get(var7)).stripTrailing();
         var2.set(var7, var5);
         if (!var5.isEmpty()) {
            break;
         }
      }

      MutableComponent var8 = Component.empty();

      for (int var6 = var3; var6 <= var7; var6++) {
         if (!((String)var2.get(var6)).isEmpty()) {
            var8.append(Component.literal((String)var2.get(var6)).setStyle((Style)var1.get(var6)));
         }
      }

      return var8;
   }

   public static Component method08513(ItemStack var0) {
      return var0 != null && !var0.isEmpty() ? var0.get(DataComponents.CUSTOM_NAME) : null;
   }

   public static String method08515(String var0, ItemStack var1) {
      return method08510(var0, var1, false);
   }

   public static int method08516(String var0, ItemStack var1) {
      if (mc.player != null && mc.player.containerMenu != null) {
         try {
            if (var1.isEmpty()) {
               return -1;
            }

            ItemLore var2 = var1.get(DataComponents.LORE);
            if (var2 != null) {
               for (Component var5 : var2.lines()) {
                  String var6 = var5.getString();
                  if (var6.contains(var0)) {
                     Pattern var7 = Pattern.compile(var0 + "\\s*(\\d+)");
                     Matcher var8 = var7.matcher(var6);
                     if (var8.find()) {
                        try {
                           return Integer.parseInt(var8.group(1));
                        } catch (NumberFormatException var10) {
                           return -1;
                        }
                     }
                     break;
                  }
               }
            }
         } catch (Exception var11) {
         }

         return -1;
      } else {
         return -1;
      }
   }

   public static List<Component> method08517(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         ItemLore var1 = var0.get(DataComponents.LORE);
         return var1 == null ? List.of() : var1.lines();
      } else {
         return List.of();
      }
   }

   public static Component method08518(String var0, ItemStack var1, boolean var2) {
      if (var1 != null && !var1.isEmpty()) {
         ItemLore var3 = var1.get(DataComponents.LORE);
         if (var3 == null) {
            return null;
         }

         for (Component var5 : var3.lines()) {
            String var6 = var5.getString();
            if (var6.contains(var0)) {
               return var2 ? method08512(var5) : var5;
            }
         }

         return null;
      } else {
         return null;
      }
   }
}
