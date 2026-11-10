// Original binary: sg/ec/b8gpmuNN8lgr3W2F
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class ArmorHud extends HudElement {
   private static final int field16908 = 4;
   private static final int field16909 = 0;
   private static final int field16910 = 0;
   private static final int field16911 = 0;
   private static final int field16912 = 0;
   private static final EquipmentSlot[] field16913 = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   private final DraggableElement field16914 = this.method06449(this, 0.0F, 0.0F);
   private final List<ItemStack> field16915 = new ArrayList<>();
   private static final String field16916 = "Armor";
   private static final float field16917 = 92.0F;
   private static final float field16918 = 22.0F;
   private static final float field16919 = 100.0F;
   private static final float field16920 = 11.5F;
   private static final float field16921 = 23.0F;
   private static final float field16922 = 12.5F;
   private static final float field16923 = 23.0F;
   private static final float field16924 = 23.0F;
   private static final float field16925 = 4.0F;
   private static final float field16926 = 23.0F;
   private static final float field16927 = 23.0F;
   private static final float field16928 = 4.0F;
   private static final float field16929 = 23.0F;
   private static final float field16930 = 23.0F;
   private static final float field16931 = 4.0F;
   private static final float field16932 = 0.5F;
   private static final float field16933 = 7.0F;
   private static final float field16934 = 1.5F;
   private static final float field16935 = 1.5F;
   private static final float field16936 = 1.25F;

   @Override
   public void method00027(GuiGraphics var1) {
      this.field16915.clear();

      for (EquipmentSlot var5 : field16913) {
         ItemStack sx = mc.player.getItemBySlot(var5);
         if (!sx.isEmpty()) {
            this.field16915.add(sx);
         }
      }

      if (!this.field16915.isEmpty()) {
         float var12 = this.field16914.method02685();
         float sx = this.field16914.method02669();
         this.method06465(var12);
         this.method06453(sx);
         this.method06448(field16917);
         this.method06456(field16918);
         float sxx = this.method06455();
         int sxxx = this.field16915.size();

         for (int sxxxx = 0; sxxxx < sxxx; sxxxx++) {
            ItemStack sxxxxx = this.field16915.get(sxxx - 1 - sxxxx);
            if (!sxxxxx.isEmpty()) {
               float sxxxxxx = var12 + sxxxx * 23;
               int sxxxxxxx = (int)((float)(sxxxxx.getMaxDamage() - sxxxxx.getDamageValue()) / sxxxxx.getMaxDamage() * field16919);
               boolean sxxxxxxxx = sxxxxxxx > 99;
               String sxxxxxxxxx = sxxxxxxx + "%";
               if (!sxxxxxxxx) {
                  field14601.method09488(var1, sxxxxxxxxx, sxxxxxx + field16920, sx - field16921 + field16922, -1, field14607, -field14608);
               }

               this.method06439(var1, sxxxxxx, sx, field16923, field16924, field16925, 1.0F, 1.0F);
               RoundedRectRenderer.method01272(
                  var1, sxxxxxx, sx, field16926, field16927, field16928, 1.0F, ColorUtils.method04611(this.method06460(), sxx)
               );
               if (!this.method06447()) {
                  GuiShadowRenderer.method10984(
                     var1, sxxxxxx, sx, field16929, field16930, field16931, field16932, field16933, ColorUtils.method04611(this.method06460(), sxx)
                  );
               }

               ItemRenderUtils.method08415(var1, sxxxxx, sxxxxxx + field16934, sx + field16935, 1.0F, 1.0F, field16936);
            }
         }

         this.field16914.method02676(this.method06458());
         this.field16914.method02696(this.method06435());
      }
   }

   public ArmorHud() {
      super(field16916);
   }
}
