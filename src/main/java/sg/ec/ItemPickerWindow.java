// Original binary: sg/ec/cAao6BZd3dQkk0br
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class ItemPickerWindow extends FloatingWindow {
   private static final String field17671 = "menu.itempicker";
   private static final String field17672 = "field17672";
   private static final String field17673 = "field17673";
   private static final int field17674 = 0;
   private static final int field17675 = 0;
   private static final float field17676 = 0;
   private static final float field17677 = 0;
   private static final float field17678 = 0;
   private static final float field17679 = 0;
   private static final float field17680 = 0;
   private static final float field17681 = 0;
   private static final float field17682 = 0;
   private static final float field17683 = 0;
   private static final float field17684 = 0;
   private static final float field17685 = 0;
   private static final float field17686 = 0;
   private static final float field17687 = 0;
   private static final float field17688 = 0;
   private static final float field17689 = 0;
   private static final float field17690 = 0;
   private static final float field17691 = 0;
   private static final float field17692 = GuiSize.method04763(ItemPickerWindow.field17743)
      .method04764(ItemPickerWindow.field17744)
      .method04761();
   private final ItemFilterSetting field17693;
   private final FloatingWindow field17694;
   private final List<ItemPickerWindow.Nested212> field17695 = new ArrayList<>();
   private final Map<ItemFilterSetting.Nested29, SmoothAnimation> field17696 = new HashMap<>();
   private final ScrollController field17697 = new ScrollController();
   private ItemStack[] field17698;
   private ItemFilterSetting.Nested29 field17699;
   private ItemPickerWindow.Nested212 field17700;
   private float field17701;
   private static final String field17702 = "menu.itempicker";
   private static final float field17703 = 6.5F;
   private static final float field17704 = 88.0F;
   private static final float field17705 = 13.0F;
   private static final float field17706 = 6.5F;
   private static final float field17707 = 6.5F;
   private static final String field17708 = "Нет подходящих предметов";
   private static final float field17709 = 48.0F;
   private static final float field17710 = 5.5F;
   private static final float field17711 = 5.5F;
   private static final String field17712 = "Не выбрано";
   private static final float field17713 = 5.5F;
   private static final float field17714 = 88.0F;
   private static final float field17715 = 12.0F;
   private static final float field17716 = 5.5F;
   private static final float field17717 = 5.5F;
   private static final float field17718 = 88.0F;
   private static final float field17719 = 88.0F;
   private static final float field17720 = 18.0F;
   private static final float field17721 = 18.0F;
   private static final float field17722 = 16.0F;
   private static final float field17723 = 16.0F;
   private static final float field17724 = 16.0F;
   private static final float field17725 = 16.0F;
   private static final float field17726 = 16.0F;
   private static final float field17727 = 2.5F;
   private static final float field17728 = 16.0F;
   private static final float field17729 = 16.0F;
   private static final float field17730 = 2.5F;
   private static final float field17731 = 0.5F;
   private static final float field17732 = 0.75F;
   private static final float field17733 = 0.45F;
   private static final double field17734 = 0.15F;
   private static final float field17735 = 18.0F;
   private static final float field17736 = 96.0F;
   private static final float field17737 = 13.0F;
   private static final float field17738 = 12.0F;
   private static final float field17739 = 18.0F;
   private static final float field17740 = 4.0F;
   private static final float field17741 = 13.0F;
   private static final float field17742 = 88.0F;
   private static final float field17743 = 10.0F;
   private static final float field17744 = 0.5F;

   private float method07266() {
      return this.method09576() + field17740;
   }

   @Override
   public void method04220() {
      super.method04220();
      this.method07268();
      this.method07269();
   }

   private float method07267(ItemFilterSetting.Nested29 var1, boolean var2) {
      SmoothAnimation var3 = this.field17696.computeIfAbsent(var1, var0 -> new SmoothAnimation());
      var3.method06162();
      var3.method06158(var2 ? 1.0 : 0.0, field17734, Easings.field19400);
      return var3.method06173();
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (var5 == 0 && this.field17700 != null) {
         if (GuiHitTestUtils.method05609(var1, var3, this.method07266(), this.method07272(), field17742, this.field17701)) {
            this.field17693.method00871(this.field17700.key());
            this.method09580().method09654(this);
         }
      }
   }

   @Override
   public boolean method01682() {
      return this.field17694 != null && this.field17694.method01682();
   }

   private void method07268() {
      List var1 = mc.player == null ? List.of() : mc.player.inventoryMenu.slots;
      if (this.method07273(var1)) {
         this.field17695.clear();

         for (Slot var3 : (Iterable<Slot>) (Iterable) var1) {
            ItemStack var4 = var3.getItem();
            if (var3.container == mc.player.getInventory() && !var4.isEmpty() && this.field17693.method00866().test(var4)) {
               ItemFilterSetting.Nested29 var5 = ItemFilterSetting.Nested29.method00875(var4);
               if (!this.method07270(var5)) {
                  this.field17695.add(new ItemPickerWindow.Nested212(var5, var4.copy(), true));
               }
            }
         }

         ItemFilterSetting.Nested29 var6 = this.field17693.method03022();
         if (var6 != null && !this.method07270(var6)) {
            this.field17695.add(0, new ItemPickerWindow.Nested212(var6, this.field17693.method00874(), false));
         }
      }
   }

   private void method07269() {
      int var1 = Math.max(1, (this.field17695.size() + 5 - 1) / 5);
      this.field17701 = Math.min(var1, 4) * field17735 - 2.0F;
      this.method08971(field17736);
      this.method09561(field17737 + this.field17701 + field17738);
      this.field17697.method01152(var1 > 4);
      this.field17697.method01134(var1 * field17739 - 2.0F, this.field17701);
   }

   @Override
   public void method06773() {
      super.method06773();
      if (this.field17694 != null) {
         this.field17694.method09565(true);
      }
   }

   private boolean method07270(ItemFilterSetting.Nested29 var1) {
      for (ItemPickerWindow.Nested212 var3 : this.field17695) {
         if (var3.key().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.method07268();
      this.method07269();
      this.field17697.method01145();
      float var5 = this.method09573().method06173();
      GuiRenderBatch.method05183();
      WindowFrameRenderer.method03056(var1, this, field17692);
      GuiThemeStyle.field03544
         .method09480(
            var1,
            GuiThemeStyle.method01438(GuiThemeStyle.field03544, this.method09566(), field17703, field17704),
            this.method07266(),
            this.method09560() + (field17705 - GuiThemeStyle.field03544.method09485(field17706)) / 2.0F,
            GuiThemeStyle.method01443(GuiThemeStyle.method01441().field22108.method11676(), var5),
            field17707
         );
      this.field17700 = null;
      if (this.field17695.isEmpty()) {
         GuiThemeStyle.field03545
            .method09473(
               var1,
               field17708,
               this.method09576() + field17709,
               this.method07272() + (this.field17701 - GuiThemeStyle.field03545.method09485(field17710)) / 2.0F,
               GuiThemeStyle.method01445(var5),
               field17711
            );
      } else {
         this.method07274(var1, var2, var3, var5);
      }

      ItemFilterSetting.Nested29 var6 = this.field17693.method03022();
      String var7 = this.field17700 != null ? this.field17700.key().name() : (var6 != null ? var6.name() : field17712);
      int var8 = this.field17700 != null ? GuiThemeStyle.method01437(var5) : GuiThemeStyle.method01445(var5);
      GuiThemeStyle.field03545
         .method09480(
            var1,
            GuiThemeStyle.method01438(GuiThemeStyle.field03545, var7, field17713, field17714),
            this.method07266(),
            this.method07272() + this.field17701 + (field17715 - GuiThemeStyle.field03545.method09485(field17716)) / 2.0F,
            var8,
            field17717
         );
   }

   private float method07272() {
      return this.method09560() + field17741;
   }

   private boolean method07273(List<Slot> var1) {
      boolean var2 = this.field17698 == null || this.field17698.length != var1.size();
      boolean var3 = var2 || this.field17699 != this.field17693.method03022();
      if (var2) {
         this.field17698 = new ItemStack[var1.size()];
      }

      for (int var4 = 0; var4 < var1.size(); var4++) {
         ItemStack var5 = ((Slot)var1.get(var4)).getItem();
         if (this.field17698[var4] != var5) {
            this.field17698[var4] = var5;
            var3 = true;
         }
      }

      this.field17699 = this.field17693.method03022();
      return var3;
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      this.field17697.method01133(var5);
   }

   public ItemPickerWindow(ItemFilterSetting var1, FloatingWindow var2) {
      super(var1.method03024(), field17702);
      this.field17693 = var1;
      this.field17694 = var2;
   }

   private void method07274(GuiGraphics var1, int var2, int var3, float var4) {
      float var5 = this.method07266();
      float var6 = this.method07272();
      boolean var7 = GuiHitTestUtils.method05624(var2, var3, var5, var6, field17718, this.field17701);
      ItemFilterSetting.Nested29 var8 = this.field17693.method03022();
      int var9 = GuiThemeStyle.method01441().field22116.method11676();
      int var10 = GuiThemeStyle.method01441().field22115.method11676();
      var1.enableScissor((int)var5, (int)var6, (int)Math.ceil(var5 + field17719), (int)Math.ceil(var6 + this.field17701));

      for (int var11 = 0; var11 < this.field17695.size(); var11++) {
         float var12 = var5 + var11 % 5 * field17720;
         float var13 = var6 + this.field17697.method01136() + var11 / 5 * field17721;
         if (!(var13 + field17722 < var6) && !(var13 > var6 + this.field17701)) {
            ItemPickerWindow.Nested212 var14 = this.field17695.get(var11);
            boolean var15 = var7 && GuiHitTestUtils.method05624(var2, var3, var12, var13, field17723, field17724);
            if (var15) {
               this.field17700 = var14;
            }

            boolean var16 = var14.key().equals(var8);
            float var17 = var16 ? 1.0F : this.method07267(var14.key(), var15);
            RoundedRectRenderer.method01272(
               var1,
               var12,
               var13,
               field17725,
               field17726,
               field17727,
               1.0F,
               GuiThemeStyle.method01443(GuiThemeStyle.method01440(var9, var10, var17), var4)
            );
            if (var16) {
               GuiShapeRenderer.method09703(var1, var12, var13, field17728, field17729, field17730, field17731, GuiThemeStyle.method01446(var4));
            }

            ItemRenderUtils.method08416(var1, var14.stack(), var12 + 2.0F, var13 + 2.0F, field17732, var14.present() ? var4 : var4 * field17733);
         }
      }

      var1.disableScissor();
   }

   // $VF: Compiled from s
   private record Nested212(ItemFilterSetting.Nested29 key, ItemStack stack, boolean present) {
   }
}
