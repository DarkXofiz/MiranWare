// Original binary: sg/ec/YihmAxzK8Rt9cY3g
package sg.ec;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;

// $VF: Compiled from s
public class AuctionHelper extends ClientModule {
   private static final Pattern field14913 = Pattern.compile(AuctionHelper.field14949, 66);
   private final ModeSetting field14914;
   private final ToggleSetting field14915;
   private final ToggleSetting field14916;
   private final List<AuctionHelper.Nested193> field14917;
   private final Map<Integer, AuctionHelper.Nested196> field14918;
   private AbstractContainerMenu field14919;
   private boolean field14920;
   private final AnimationUtils field14921;
   private static final String field14922 = "Режим отображения";
   private static final String field14923 = "Подсвечивать";
   private static final String field14924 = "Перемещать дешевые в начало";
   private static final String field14925 = "Подсвечивать";
   private static final String field14926 = "Показывать цену за 1 предмет";
   private static final String field14927 = "Показывать общую сумму";
   private static final String field14928 = "Показывает сумму всех товаров, выставленные тобой на аукционе.";
   private static final long field14929 = 240L;
   private static final String field14930 = "Auction Helper";
   private static final String field14931 = "Подсвечивать";
   private static final long field14932 = 480L;
   private static final long field14933 = 240L;
   private static final double field14934 = 0.5;
   private static final float field14935 = 16.0F;
   private static final float field14936 = 16.0F;
   private static final String field14937 = "0a2zspace";
   private static final String field14938 = "поиск";
   private static final String field14939 = "аукцион";
   private static final String field14940 = "Товар не актуален";
   private static final String field14941 = "[^0-9.,]";
   private static final double field14942 = Double.MAX_VALUE;
   private static final String field14943 = ",";
   private static final double field14944 = Double.MAX_VALUE;
   private static final String field14945 = "%,.2f";
   private static final String field14946 = "\\.?0+$";
   private static final String field14947 = "$ ";
   private static final String field14948 = "Цена за 1 шт: ";
   private static final String field14949 = ".*ц[еe]н[аa].*";

   private void method06639() {
      if (mc.player != null && mc.player.containerMenu == this.field14919 && !this.field14918.isEmpty()) {
         for (Slot var2 : mc.player.containerMenu.slots) {
            AuctionHelper.Nested196 sx = this.field14918.get(var2.index);
            if (sx != null) {
               var2.x = sx.field14950();
               var2.y = sx.field14951();
            }
         }
      }
   }

   public AuctionHelper() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field14914 = new ModeSetting(field14922).method05597(field14923, field14924).method03017(field14925).method03023(this);
      this.field14915 = new ToggleSetting(field14926).method03017(true).method03023(this);
      this.field14916 = new ToggleSetting(field14927).method03017(false).method03018(field14928).method03023(this);
      this.field14917 = new ArrayList<>();
      this.field14918 = new HashMap<>();
      this.field14921 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field14929);
      this.method03935(field14930);
   }

   private void method06640() {
      if (mc.player != null && mc.player.containerMenu != null) {
         AbstractContainerMenu var1 = mc.player.containerMenu;
         int var2 = var1.slots.size() - 36;
         if (var2 > 0) {
            this.method06646(var1, var2);
            if (!this.field14920) {
               if (!this.method06647(var1)) {
                  ArrayList var3 = new ArrayList();
                  ArrayList var4 = new ArrayList();

                  for (int var5 = 0; var5 < var2; var5++) {
                     Slot var6 = var1.slots.get(var5);
                     Double var7 = this.method06643(var6.getItem());
                     if (var7 == null) {
                        var4.add(var6);
                     } else {
                        var3.add(new AuctionHelper.Nested194(var6, var7));
                     }
                  }

                  if (!var3.isEmpty()) {
                     var3.sort(Comparator.comparingDouble(AuctionHelper.Nested194::pricePerItem));
                     ArrayList var9 = new ArrayList(var2);

                     for (AuctionHelper.Nested194 var12 : (Iterable<AuctionHelper.Nested194>) (Iterable) var3) {
                        var9.add(var12.slot());
                     }

                     var9.addAll(var4);

                     for (int var11 = 0; var11 < var9.size(); var11++) {
                        AuctionHelper.Nested196 var13 = this.field14918.get(var1.slots.get(var11).index);
                        if (var13 != null) {
                           Slot var8 = (Slot)var9.get(var11);
                           var8.x = var13.field14950();
                           var8.y = var13.field14951();
                        }
                     }

                     this.field14920 = true;
                  }
               }
            }
         }
      }
   }

   private boolean method06641() {
      return this.field14914.method05600(field14931);
   }

   @Override
   public void method00245() {
      this.method06639();
      this.field14918.clear();
      this.field14919 = null;
      this.field14920 = false;
      super.method00245();
   }

   private static double method06642(String var0) {
      try {
         String var1 = var0.replace(field14943, "");
         return Double.parseDouble(var1);
      } catch (NumberFormatException var2) {
         return field14944;
      }
   }

   private Double method06643(ItemStack var1) {
      if (!var1.isEmpty() && !this.method06644(var1)) {
         ItemLore var2 = var1.get(DataComponents.LORE);
         if (var2 == null) {
            return null;
         }

         AuctionHelper.Nested192 var3 = this.method06651(var2.lines());
         return var3 == null ? null : var3.value() / Math.max(var1.getCount(), 1);
      } else {
         return null;
      }
   }

   private boolean method06644(ItemStack var1) {
      return var1.getStyledHoverName().getString().contains(field14940);
   }

   @Subscribe
   private void method06645(TooltipRenderEvent var1) {
      if (this.field14915.method05999() && this.method06650()) {
         if (mc.gui.screen() instanceof AbstractContainerScreen var2) {
            Slot var7 = var2.hoveredSlot;
            if (var7 != null && !var7.getItem().isEmpty()) {
               AuctionHelper.Nested192 var4 = this.method06651(var1.method07401());
               if (var4 != null) {
                  double var5 = var4.value() / Math.max(var7.getItem().getCount(), 1);
                  var1.method07397(var4.index() + 1, method06648(var5));
               }
            }
         }
      }
   }

   private void method06646(AbstractContainerMenu var1, int var2) {
      if (this.field14919 != var1) {
         this.field14918.clear();
         this.field14919 = var1;
         this.field14920 = false;
      }

      for (int var3 = 0; var3 < var2; var3++) {
         Slot var4 = var1.slots.get(var3);
         this.field14918.putIfAbsent(var4.index, new AuctionHelper.Nested196(var4.x, var4.y));
      }
   }

   private boolean method06647(AbstractContainerMenu var1) {
      int var2 = var1.slots.size() - 36;

      for (int var3 = 0; var3 < var2; var3++) {
         ItemStack var4 = var1.slots.get(var3).getItem();
         if (!var4.isEmpty() && !this.method06644(var4)) {
            return false;
         }
      }

      return true;
   }

   private static Component method06648(double var0) {
      return Component.literal(field14947)
         .withStyle(ChatFormatting.GREEN)
         .append(Component.literal(field14948).withStyle(ChatFormatting.WHITE))
         .append(Component.literal("$" + method06653((int)var0)).withStyle(ChatFormatting.GREEN));
   }

   @Subscribe
   private void method06649(ContainerRenderEvent var1) {
      if (!this.method06650()) {
         this.field14917.clear();
      } else if (!this.method06641()) {
         this.method06640();
      } else {
         GuiGraphics var2 = var1.method10118();
         int var3 = var1.method10120();
         int var4 = var1.method10115();
         long var5 = System.currentTimeMillis();
         this.field14921.method03375(var5 % field14932 > field14933 ? field14934 : 0.0);
         float var7 = this.field14921.method03377();
         RoundedRectRenderer.method01277();

         for (AuctionHelper.Nested193 var9 : this.field14917) {
            int var10 = switch (var9.place()) {
               case 1 -> ColorUtils.method04611(Color.GREEN.getRGB(), var7);
               case 2 -> ColorUtils.method04611(Color.YELLOW.getRGB(), var7);
               default -> ColorUtils.method04611(Color.RED.getRGB(), var7);
            };
            RoundedRectRenderer.method01272(var2, var3 + var9.xSlot(), var4 + var9.ySlot(), field14935, field14936, 0.0F, 0.0F, var10);
         }

         RoundedRectRenderer.method01278();
      }
   }

   private boolean method06650() {
      if (mc.gui.screen() == null) {
         return false;
      }

      String var1 = mc.gui.screen().getTitle().getString().toLowerCase();
      return var1.contains(field14937) || var1.contains(field14938) || var1.contains(field14939);
   }

   private AuctionHelper.Nested192 method06651(List<Component> var1) {
      for (int var2 = 0; var2 < var1.size(); var2++) {
         Component var3 = (Component)var1.get(var2);
         String var4 = var3.getString();
         if (field14913.matcher(var4).matches()) {
            int var5 = var4.indexOf(58);
            if (var5 >= 0) {
               var4 = var4.substring(var5 + 1);
            }

            String var6 = var4.replaceAll(field14941, "");
            if (var6.isEmpty()) {
               return null;
            }

            double var7 = method06642(var6);
            return var7 == field14942 ? null : new AuctionHelper.Nested192(var7, var2);
         }
      }

      return null;
   }

   @Subscribe
   private void method06652(PlayerUpdateEvent var1) {
      if (mc.player != null && mc.player.containerMenu != null) {
         if (!this.method06650()) {
            this.field14917.clear();
         } else if (!this.method06641()) {
            this.method06640();
         } else if (!this.method06647(mc.player.containerMenu)) {
            ArrayList var2 = new ArrayList();

            for (Slot var4 : mc.player.containerMenu.slots) {
               ItemStack var5 = var4.getItem();
               Double var6 = this.method06643(var5);
               if (var6 != null) {
                  int var7 = Math.max(var5.getCount(), 1);
                  var2.add(new AuctionHelper.Nested195(var4.x, var4.y, var6 * var7, var7, var6));
               }
            }

            var2.sort(Comparator.comparingDouble(AuctionHelper.Nested195::pricePerItem));
            this.field14917.clear();

            for (int var8 = 0; var8 < Math.min(3, var2.size()); var8++) {
               AuctionHelper.Nested195 var9 = (AuctionHelper.Nested195)var2.get(var8);
               this.field14917.add(new AuctionHelper.Nested193(var9.xSlot(), var9.ySlot(), var8 + 1));
            }
         }
      }
   }

   private static String method06653(double var0) {
      return String.format(Locale.US, field14945, var0).replaceAll(field14946, "");
   }

   // $VF: Compiled from s
   private record Nested192(double value, int index) {
   }

   // $VF: Compiled from s
   private record Nested193(int xSlot, int ySlot, int place) {
   }

   // $VF: Compiled from s
   private record Nested194(Slot slot, double pricePerItem) {
   }

   // $VF: Compiled from s
   private record Nested195(int xSlot, int ySlot, double price, int count, double pricePerItem) {
   }

   // $VF: Compiled from s
   private record Nested196(int field14950, int field14951) {
   }
}
