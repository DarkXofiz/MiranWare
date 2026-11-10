// Original binary: sg/ec/i8Zg1RazNcUluXvs
package sg.ec;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Mth;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public class ItemHighlighter extends ClientModule {
   private static final float field20000 = 10.0F;
   private static final int field20001 = ColorUtils.method04604(0, 200, 80);
   private static final int field20002 = ColorUtils.method04604(255, 220, 0);
   private static final int field20003 = ColorUtils.method04604(255, 0, 0);
   private static final Set<Item> field20004 = Set.of(Items.SPIDER_EYE, Items.ROTTEN_FLESH, Items.POISONOUS_POTATO, Items.PUFFERFISH, Items.CHICKEN);
   private final Map<Item, Integer> field20005 = new HashMap<>();
   private final SmoothAnimation field20006 = new SmoothAnimation();
   private boolean field20007 = true;
   private float field20008;
   private static final float field20009 = 0.45F;
   private static final String field20010 = "Item Highlighter";
   private static final float field20011 = 10.0F;
   private static final float field20012 = 16.0F;
   private static final float field20013 = 16.0F;
   private static final float field20014 = 16.0F;
   private static final float field20015 = 16.0F;
   private static final float field20016 = 100.0F;
   private static final float field20017 = 1000.0F;
   private static final float field20018 = 10.0F;
   private static final float field20019 = 0.45F;
   private static final float field20020 = 10.0F;
   private static final float field20021 = 200.0F;
   private static final float field20022 = 300.0F;
   private static final double field20023 = 0.6F;
   private static final double field20024 = 0.2F;
   private static final float field20025 = 1000.0F;

   public ItemHighlighter() {
      super(ModuleCategory.Render, ModuleSubCategory.Interface);
      this.field20008 = field20009;
      this.method03935(field20010);
   }

   private void method08775(float var1) {
      if (var1 >= field20018) {
         this.field20008 = field20019;
         this.field20007 = true;
         this.field20006.method06157(this.field20008);
      } else {
         float var2 = Mth.clamp(var1 / field20020, 0.0F, 1.0F);
         float var3 = field20021 + field20022 * var2;
         if (!this.field20006.method06152()) {
            this.field20007 = !this.field20007;
            this.field20006.method06168(this.field20007 ? field20023 : field20024, var3 / field20025, Easings.field19398, false);
         }

         this.field20006.method06162();
         this.field20008 = this.field20006.method06173();
      }
   }

   private int method08776(int var1) {
      return ColorUtils.method04611(var1, this.field20008);
   }

   @Subscribe(4)
   private void method08777(HotbarRenderEvent var1) {
      if (var1.method09179() != HotbarRenderEvent.Nested254.START) {
         if (!this.field20005.isEmpty() && mc.player != null) {
            int var2 = mc.getWindow().getGuiScaledWidth();
            int var3 = mc.getWindow().getGuiScaledHeight();
            int var4 = var2 / 2 - 91;
            int var5 = var3 - 22;
            RoundedRectRenderer.method01277();

            for (int var6 = 0; var6 < 9; var6++) {
               ItemStack var7 = mc.player.getInventory().getItem(var6);
               if (!var7.isEmpty()) {
                  Integer var8 = this.field20005.get(var7.getItem());
                  if (var8 != null) {
                     int var9 = this.method08776(var8);
                     int var10 = var4 + var6 * 20 + 3;
                     int var11 = var5 + 3;
                     RoundedRectRenderer.method01272(var1.method09170(), var10, var11, field20012, field20013, 0.0F, 0.0F, var9);
                  }
               }
            }

            RoundedRectRenderer.method01278();
         }
      }
   }

   @Subscribe
   private void method08779(ContainerRenderEvent var1) {
      if (!this.field20005.isEmpty() && mc.player != null) {
         RoundedRectRenderer.method01277();

         for (Slot var3 : mc.player.containerMenu.slots) {
            if (var3.hasItem()) {
               Integer var4 = this.field20005.get(var3.getItem().getItem());
               if (var4 != null) {
                  int var5 = this.method08776(var4);
                  RoundedRectRenderer.method01272(
                     var1.method10118(), var1.method10120() + var3.x, var1.method10115() + var3.y, field20014, field20015, 0.0F, 0.0F, var5
                  );
               }
            }
         }

         RoundedRectRenderer.method01278();
      }
   }

   @Subscribe
   private void method08780(PlayerUpdateEvent var1) {
      this.field20005.clear();
      if (mc.player != null && mc.level != null) {
         float var2 = mc.player.getHealth();
         this.method08775(var2);
         if (var2 < field20011) {
            this.method08781();
         }
      }
   }

   private void method08781() {
      SortableArrayList<ItemHighlighter.Nested244> var1 = new SortableArrayList<>();

      for (ItemStack var3 : mc.player.getInventory().getNonEquipmentItems()) {
         if (!var3.isEmpty() && !mc.player.getCooldowns().isOnCooldown(var3)) {
            FoodProperties var4 = var3.get(DataComponents.FOOD);
            if (var4 != null) {
               float var5 = var4.nutrition() + var4.saturation() * 2.0F;
               if (field20004.contains(var3.getItem())) {
                  var5 -= field20016;
               }

               if (var3.is(Items.ENCHANTED_GOLDEN_APPLE)) {
                  var5 += field20017;
               }

               var1.add(new ItemHighlighter.Nested244(var3.getItem(), var5));
            }
         }
      }

      if (!var1.isEmpty()) {
         var1.method00234(var0 -> -var0.score());
         int var6 = 0;

         for (ItemHighlighter.Nested244 var8 : (Iterable<ItemHighlighter.Nested244>) (Iterable) var1) {
            if (!this.field20005.containsKey(var8.item())) {
               int var9 = switch (var6) {
                  case 0 -> field20001;
                  case 1 -> field20002;
                  case 2 -> field20003;
                  default -> 0;
               };
               if (var9 == 0) {
                  break;
               }

               this.field20005.put(var8.item(), var9);
               if (++var6 >= 3) {
                  break;
               }
            }
         }
      }
   }

   // $VF: Compiled from s
   private record Nested244(Item item, float score) {
   }
}
