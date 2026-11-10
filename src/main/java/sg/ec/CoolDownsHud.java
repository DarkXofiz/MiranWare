// Original binary: sg/ec/z5FcqO9PW144SPcz
package sg.ec;

import java.util.HashMap;
import java.util.HashSet;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import sg.mx.ItemCooldowns$CooldownInstanceMixin;
import sg.mx.ItemCooldownsMixin;

// $VF: Compiled from s
public class CoolDownsHud extends HudElement {
   private final DraggableElement field27820 = this.method06449(this, 0.0F, 0.0F);
   private final AnimationUtils field27821;
   private final SortableArrayList<CoolDownsHud.Nested328> field27822;
   private static final String field27823 = "CoolDowns";
   private static final long field27824 = 150L;
   private static final float field27825 = 12.5F;
   private static final float field27826 = 0.001F;
   private static final float field27827 = 11.0F;
   private static final float field27828 = 15.0F;
   private static final float field27829 = 80.0F;
   private static final float field27830 = 2.5F;
   private static final float field27831 = 5.0F;
   private static final String field27832 = "d";
   private static final float field27833 = 0.001F;
   private static final float field27834 = 20.0F;
   private static final float field27835 = 11.0F;
   private static final float field27836 = 11.0F;
   private static final float field27837 = 3.0F;
   private static final float field27838 = 0.75F;
   private static final float field27839 = 5.0F;
   private static final float field27840 = 5.0F;
   private static final float field27841 = 11.0F;
   private static final float field27842 = 11.0F;

   private long method11684(ItemCooldowns var1, Identifier var2) {
      Object var3 = ((ItemCooldownsMixin)(Object)var1).entries().get(var2);
      return var3 instanceof ItemCooldowns$CooldownInstanceMixin
         ? ((ItemCooldowns$CooldownInstanceMixin)var3).getEndTick()
         : ((ItemCooldownsMixin)(Object)var1).getTicks();
   }

   @Override
   public void method00024() {
      if (mc.player == null) {
         this.field27822.clear();
         super.method00024();
      } else {
         ItemCooldowns var1 = mc.player.getCooldowns();
         int var2 = ((ItemCooldownsMixin)(Object)var1).getTicks();
         var var3 = new HashMap(this.field27822.size());

         for (CoolDownsHud.Nested328 var5 : this.field27822) {
            var5.method11693(false);
            if (var5.method11688() != null) {
               var3.put(var5.method11688(), var5);
            }
         }

         HashSet var13 = new HashSet();

         for (ItemStack var6 : mc.player.getInventory().getNonEquipmentItems()) {
            if (!var6.isEmpty()) {
               Identifier var7 = var1.getCooldownGroup(var6);
               if (var13.add(var7) && var1.isOnCooldown(var6)) {
                  long var8 = this.method11684(var1, var7);
                  int var10 = method11686(var8, var2);
                  String var11 = TextRenderUtils.method00680(var10);
                  CoolDownsHud.Nested328 var12 = (CoolDownsHud.Nested328)var3.get(var7);
                  if (var12 == null) {
                     var12 = new CoolDownsHud.Nested328(var6.copy(), var7);
                     var12.method11693(true);
                     var12.method11692(var12.method11695().getStyledHoverName());
                     var12.method11701(field14601.method09478(var12.method11704().getString(), field14607, -field14608));
                     var12.method11700(var11);
                     var12.method11689(field14601.method09478(var11, field14607, -field14608));
                     var12.method11703(var8);
                     this.field27822.add(var12);
                  } else {
                     var12.method11693(true);
                     var12.method11703(var8);
                     if (!ItemStack.isSameItemSameComponents(var12.method11695(), var6)) {
                        var12.method11697(var6.copy());
                        var12.method11692(var12.method11695().getStyledHoverName());
                        var12.method11701(field14601.method09478(var12.method11704().getString(), field14607, -field14608));
                     }

                     if (!var11.equals(var12.method11696())) {
                        var12.method11700(var11);
                        var12.method11689(field14601.method09478(var11, field14607, -field14608));
                     }
                  }
               }
            }
         }

         this.field27822.removeIf(var0 -> !var0.method11699() && var0.method11694().method03384() == 0.0);
         this.field27822.method00232(CoolDownsHud.Nested328::method11698);
         super.method00024();
      }
   }

   private static int method11686(long var0, int var2) {
      return (int)Math.max(0L, var0 - var2);
   }

   @Override
   public void method00027(GuiGraphics var1) {
      super.method00027(var1);
      this.method06465(this.field27820.method02685());
      this.method06453(this.field27820.method02669());
      float var2 = 0.0F;
      float var3 = 0.0F;
      float var4 = field27825;

      for (CoolDownsHud.Nested328 var6 : this.field27822) {
         AnimationUtils var7 = var6.method11694();
         var7.method03375(var6.method11699() ? 1.0 : 0.0);
         float var8 = var7.method03377();
         if (!(var8 <= field27826)) {
            var3 += var8 * field27827;
            var2 = Math.max(var6.method11690() + var6.method11702() + var4 + field27828, var2);
         }
      }

      this.field27821.method03375(Math.max(field27829, var2));
      float var13 = Math.max(field27830, var3 + field27831);
      this.method06448(this.field27821.method03377());
      this.method06456(field14609 + var13);
      this.method06441(var1, field27832);
      float var14 = this.method06464();
      int var15 = 0;

      for (CoolDownsHud.Nested328 var9 : this.field27822) {
         float var10 = var9.method11694().method03377();
         if (!(var10 <= field27833)) {
            int var11 = ColorUtils.method04611(this.method06438(), var10);
            float var12 = var14 + field27834 + var10 * field27835 - field27836 + var15 * 11;
            ItemRenderUtils.method08415(var1, var9.method11695(), this.method06436() + field27837, var12 - 2.0F, 1.0F, var10, field27838);
            field14601.method09477(var1, var9.method11704(), this.method06436() + field27839 + var4, var12, var11, field14607, -field14608);
            field14601.method09490(
               var1, var9.method11696(), this.method06436() + this.method06458() - var9.method11702() - field27840, var12, var11, field14607, -field14608
            );
            var14 += field27841 * var10 - field27842;
            var15++;
         }
      }

      this.field27820.method02676(this.method06458());
      this.field27820.method02696(this.method06435());
   }

   public CoolDownsHud() {
      super(field27823);
      this.field27821 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field27824);
      this.field27822 = new SortableArrayList<>();
   }

   // $VF: Compiled from s
   private static class Nested328 {
      private ItemStack field27843;
      private Identifier field27844;
      private Component field27845 = Component.empty();
      private String field27846 = "";
      private boolean field27847;
      private AnimationUtils field27848;
      private long field27849;
      private float field27850;
      private float field27851;
      private static final long field27852 = 150L;

      public void method11687(AnimationUtils var1) {
         this.field27848 = var1;
      }

      public Identifier method11688() {
         return this.field27844;
      }

      public void method11689(float var1) {
         this.field27851 = var1;
      }

      public float method11690() {
         return this.field27850;
      }

      public void method11691(Identifier var1) {
         this.field27844 = var1;
      }

      public void method11692(Component var1) {
         this.field27845 = var1;
      }

      public void method11693(boolean var1) {
         this.field27847 = var1;
      }

      public Nested328(ItemStack var1, Identifier var2) {
         this.field27843 = var1;
         this.field27844 = var2;
         this.field27848 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field27852);
      }

      public AnimationUtils method11694() {
         return this.field27848;
      }

      public ItemStack method11695() {
         return this.field27843;
      }

      public String method11696() {
         return this.field27846;
      }

      public void method11697(ItemStack var1) {
         this.field27843 = var1;
      }

      public long method11698() {
         return this.field27849;
      }

      public boolean method11699() {
         return this.field27847;
      }

      public void method11700(String var1) {
         this.field27846 = var1;
      }

      public void method11701(float var1) {
         this.field27850 = var1;
      }

      public float method11702() {
         return this.field27851;
      }

      public void method11703(long var1) {
         this.field27849 = var1;
      }

      public Component method11704() {
         return this.field27845;
      }
   }
}
