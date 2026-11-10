// Original binary: sg/ec/C1b8elWZB8k39noU
package sg.ec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public class EntityEspSettingsPanel extends GuiPanel implements GuiOverlay {
   private static final String[] field06557 = new String[]{
      EntityEspSettingsPanel.field06650, EntityEspSettingsPanel.field06651, EntityEspSettingsPanel.field06652, EntityEspSettingsPanel.field06653
   };
   private static final String[] field06558 = new String[]{EntityEspSettingsPanel.field06654, EntityEspSettingsPanel.field06655, EntityEspSettingsPanel.field06656};
   private static final float field06559 = 118.0F;
   private static final float field06560 = 0;
   private static final float field06561 = 0;
   private static final float field06562 = 0;
   private static final float field06563 = 0;
   private static final float field06564 = 0;
   private static final float field06565 = 0;
   private static final float field06566 = 0;
   private static final float field06567 = 0;
   private static final float field06568 = 0;
   private static final float field06569 = 0;
   private final ClickGuiScreen field06570;
   private final FloatingWindow field06571;
   private final RenderUtils field06572;
   private final GuiPanel.Nested290 field06573;
   private final GuiPanel.Nested284 field06574;
   private final Map<EntityEspStyle, List<SettingComponent<?>>> field06575;
   private int field06576;
   private int field06577;
   private float field06578;
   private float field06579;
   private float field06580;
   private float field06581;
   private float field06582;
   private float field06583;
   private float field06584;
   private float field06585;
   private float field06586;
   private static final String field06587 = "entityesp.settings";
   private static final float field06588 = 6.0F;
   private static final float field06589 = 6.0F;
   private static final float field06590 = 118.0F;
   private static final float field06591 = 12.0F;
   private static final float field06592 = 6.0F;
   private static final float field06593 = 6.0F;
   private static final float field06594 = 6.5F;
   private static final float field06595 = 0.6F;
   private static final float field06596 = 6.5F;
   private static final float field06597 = 0.5F;
   private static final String field06598 = "ENTITY ESP";
   private static final float field06599 = 7.0F;
   private static final float field06600 = 5.0F;
   private static final float field06601 = 0.8F;
   private static final float field06602 = 5.5F;
   private static final float field06603 = 15.0F;
   private static final float field06604 = 3.0F;
   private static final float field06605 = 0.5F;
   private static final float field06606 = 0.5F;
   private static final float field06607 = 0.5F;
   private static final float field06608 = 0.5F;
   private static final float field06609 = 30.0F;
   private static final float field06610 = 0.01F;
   private static final float field06611 = 7.0F;
   private static final float field06612 = 14.0F;
   private static final float field06613 = 4.0F;
   private static final float field06614 = 6.5F;
   private static final float field06615 = 0.6F;
   private static final float field06616 = 6.5F;
   private static final float field06617 = 0.5F;
   private static final float field06618 = 3.0F;
   private static final float field06619 = 12.0F;
   private static final String field06620 = "tab:";
   private static final String field06621 = "Зажмите ПКМ, чтобы вращать модель";
   private static final float field06622 = 3.0F;
   private static final float field06623 = 12.0F;
   private static final float field06624 = 3.0F;
   private static final float field06625 = 0.45F;
   private static final float field06626 = 4.5F;
   private static final float field06627 = 0.5F;
   private static final float field06628 = 0.5F;
   private static final float field06629 = 0.5F;
   private static final float field06630 = 0.5F;
   private static final float field06631 = 0.35000002F;
   private static final float field06632 = 0.65F;
   private static final float field06633 = 0.35000002F;
   private static final float field06634 = 10.0F;
   private static final float field06635 = 0.6F;
   private static final float field06636 = 20.0F;
   private static final float field06637 = 62.0F;
   private static final float field06638 = 28.0F;
   private static final float field06639 = 3.0F;
   private static final float field06640 = 12.0F;
   private static final float field06641 = 0.2F;
   private static final float field06642 = 3.0F;
   private static final float field06643 = 12.0F;
   private static final float field06644 = 21.0F;
   private static final int field06645 = 16777215;
   private static final int field06646 = 16777215;
   private static final float field06647 = 0.01F;
   private static final float field06648 = 0.01F;
   private static final float field06649 = 0.01F;
   private static final String field06650 = "Игроки";
   private static final String field06651 = "Мобы";
   private static final String field06652 = "Жители";
   private static final String field06653 = "Предметы";
   private static final String field06654 = "Себя";
   private static final String field06655 = "Все";
   private static final String field06656 = "Друзья";

   public EntityEspSettingsPanel(ClickGuiScreen var1) {
      this.field06571 = new FloatingWindow(field06587);
      this.field06572 = new RenderUtils();
      this.field06573 = new GuiPanel.Nested290();
      this.field06574 = new GuiPanel.Nested284();
      this.field06575 = new HashMap<>();
      this.field06570 = var1;
      this.field06571.method09577(var1.method09983());
   }

   private List<SettingComponent<?>> method02836(EntityESP var1, int var2) {
      EntityEspStyle var3 = this.method02837(var1, var2);
      return this.field06575.computeIfAbsent(var3, var1x -> SettingsWindow.method04679(var1x.method07163(), this.field06571));
   }

   private EntityEspStyle method02837(EntityESP var1, int var2) {
      if (var1 == null) {
         return null;
      } else {
         return var2 <= 2 ? var1.method09225(0, var2) : var1.method09225(var2 - 2, 0);
      }
   }

   private Entity method02838(int var1) {
      Entity var2 = switch (var1) {
         case 1 -> new Zombie(mc.level);
         case 2 -> new Villager(EntityTypes.VILLAGER, mc.level);
         case 3 -> new ItemEntity(mc.level, 0.0, 0.0, 0.0, new ItemStack(Items.ENDER_PEARL, 16));
         default -> RenderUtils.method02206();
      };
      var2.setPos(mc.player.getX(), mc.player.getY(), mc.player.getZ());
      return var2;
   }

   @Override
   public void method02839(double var1, double var3, int var5) {
      if (var5 == 0) {
         int var6 = this.field06573.method10244((float)var1, (float)var3);
         if (var6 >= 0) {
            this.method02845(var6);
            return;
         }

         int var7 = this.method10184((float)var1, (float)var3);
         if (var7 >= 0) {
            this.method02855(var7);
            return;
         }
      }

      if (!this.field06572.method02202(var1, var3, var5)) {
         if (GuiHitTestUtils.method05609(var1, var3, this.field06578, this.field06579, this.field06580, this.field06581)) {
            for (SettingComponent var9 : this.method02854()) {
               if ((var9.method10977().method03019() || !(var9.method10979().method06173() < field06647)) && !var9.method00251(var1, var3, var5)) {
                  var9.method00040(var1, var3, var5);
               }
            }
         }
      }
   }

   @Override
   public void method02840(double var1, double var3, int var5) {
      this.field06572.method02203(var5);

      for (SettingComponent var7 : this.method02854()) {
         if (var7.method10977().method03019() || !(var7.method10979().method06173() < field06648)) {
            var7.method02632(var1, var3, var5);
         }
      }
   }

   private void method02841(int var1, int var2) {
      this.field22881 = this.field22876.method03377();
      this.field22875.method10231(var1, var2);
      this.method10196();
   }

   private void method02843(int var1, int var2, int var3, int var4) {
      this.field06577 = var4;
      this.field06574.method10237(var1, var2, var3);
   }

   @Override
   public boolean method02844(double var1, double var3, double var5) {
      for (SettingComponent var8 : this.method02854()) {
         if ((var8.method10977().method03019() || !(var8.method10979().method06173() < field06649))
            && var8 instanceof NumberSettingComponent var9
            && var9.method04527(var1, var3, var5)) {
            return true;
         }
      }

      return GuiHitTestUtils.method05609(var1, var3, this.field06578, this.field06579, this.field06580, this.field06581) ? this.method10181(var5) : false;
   }

   private void method02845(int var1) {
      if (var1 != this.method02848() || this.field06576 != 0) {
         int var2 = this.method02848();
         int var3 = this.field06576;
         int var4 = this.method02853(var3, var2);
         this.field06576 = 0;
         this.field06573.method10247(var1);
         int var5 = this.method02853(this.field06576, this.method02848());
         this.method02841(var4, var5);
         this.method02843(var3, var4, var5, var2);
      }
   }

   @Override
   public void method02847(GuiGraphics var1, int var2, int var3, float var4) {
      EntityESP var5 = ModuleManager.INSTANCE.method08235();
      if (var5 != null) {
         float var6 = this.field06570.method09986();
         float var7 = this.field06570.method09963();
         float var8 = this.field06570.method10015();
         float var9 = this.field06570.method10026();
         this.field06578 = var6 + field06588;
         this.field06579 = var7 + field06589;
         this.field06580 = field06590;
         this.field06581 = var9 - field06591;
         this.field06582 = this.field06578 + this.field06580 + field06592;
         this.field06583 = this.field06579;
         this.field06584 = var6 + var8 - field06593 - this.field06582;
         this.field06585 = this.field06581;
         this.field22875.method10235();
         this.field06574.method10235();
         boolean var10 = this.field22875.method10232();
         boolean var11 = this.field06574.method10232();
         this.method02850(var1, var2, var3, var4, var5);
         this.method02849(var1, var2, var3, var4, var5, var10, var11);
      }
   }

   private int method02848() {
      return this.field06573.method10246();
   }

   private void method02849(GuiGraphics var1, int var2, int var3, float var4, EntityESP var5, boolean var6, boolean var7) {
      RoundedRectRenderer.method01272(
         var1, this.field06582, this.field06583, this.field06584, this.field06585, field06614, 1.0F, method10227(method10186(), field06615 * var4)
      );
      GuiShapeRenderer.method09703(
         var1, this.field06582, this.field06583, this.field06584, this.field06585, field06616, 1.0F, method10227(method10223(), field06617 * var4)
      );
      if (this.field22883.length != field06557.length) {
         this.field22883 = new GuiPanel.Nested283[field06557.length];
      }

      this.field22879 = this.method10192(
         var1,
         var2,
         var3,
         var4,
         this.field06582,
         this.field06583 + field06618,
         this.field06584,
         field06619,
         field06557,
         this.field06576,
         field06620,
         this.field22877,
         this.field22878,
         this.field22879,
         this.field22883,
         null
      );
      boolean var8 = this.field06576 == 0;
      boolean var9 = var8
         && this.field22883[0] != null
         && (this.field22883[0].has(var2, var3) || this.field06573.method10248(var2, var3, this.field22883[0].field23011() + this.field22883[0].field23013()));
      float var10 = this.field22883[0] != null
         ? this.field22883[0].field23010() + this.field22883[0].field23012() / 2.0F
         : this.field06582 + this.field06584 / 2.0F;
      Fonts.field00110
         .method09473(
            var1,
            field06621,
            this.field06582 + this.field06584 / 2.0F,
            this.field06583 + field06622 + field06623 + field06624,
            method10227(method10213(), field06625 * var4),
            field06626
         );
      float var11 = this.field06574.method10234();
      boolean var12 = var7 && var11 < field06627;
      float var13 = !var7 ? 1.0F : GuiHitTestUtils.method05621(var12 ? var11 / field06628 : (var11 - field06629) / field06630);
      float var14 = !var7 ? 1.0F : (var12 ? 1.0F - var13 : var13);
      float var15 = !var7 ? 0.0F : this.field06574.method10236() * (var12 ? -var13 : 1.0F - var13);
      float var16 = !var7 ? 1.0F : (var12 ? 1.0F - field06631 * var13 : field06632 + field06633 * var13);
      int var17 = var12 ? this.field06574.method10233() : this.field06576;
      int var18 = var12 ? this.field06577 : this.method02848();
      float var19 = this.field06582 + field06634 + var15 * this.field06584 * field06635;
      float var20 = this.field06584 - field06636;
      float var21 = this.field06583 + field06637;
      float var22 = this.field06583 + this.field06585 - field06638 - var21;
      float var23 = this.field06583 + field06639 + field06640 + 2.0F;
      var1.enableScissor((int)this.field06582, (int)var23, (int)(this.field06582 + this.field06584), (int)(this.field06583 + this.field06585));
      EntityEspStyle var24 = var5.method09225(var17, var18);
      this.method02851(var24);
      int var25 = var17;
      GuiRenderBatch.method05183();
      this.field06572.method02212(var1, var25, () -> this.method02838(var25), var19, var21, var20, var22, var2, var16, var4 * var14);
      GuiRenderBatch.method05184();
      if (this.field06572.method02205() != null && var24.method07154()) {
         float var26 = this.field06572.method02201() - this.field06572.method02199() * field06641;
         float var27 = this.field06572.method02204();
         float var28 = this.field06572.method02213() - this.field06572.method02210();
         float var29 = this.field06572.method02213() + this.field06572.method02210();
         ItemRenderUtils.method08410();
         var5.method09218(var1, this.field06572.method02205(), var24, var28, var26, var29, var27, var4 * var14);
         var5.method09229(var1, this.field06572.method02205(), var24, this.field06572.method02213(), var26, var27, var4 * var14);
         GuiRenderBatch.method05185();
         GuiRenderBatch.method05184();
         ItemRenderUtils.method08420();
      }

      var1.disableScissor();
      this.method10194(var1, var2, var3, var4, this.field06573, field06558, var10, this.field06583 + field06642 + field06643 + field06644, var9);
   }

   private void method02850(GuiGraphics var1, int var2, int var3, float var4, EntityESP var5) {
      if (var5 != null) {
         RoundedRectRenderer.method01272(
            var1, this.field06578, this.field06579, this.field06580, this.field06581, field06594, 1.0F, method10227(method10186(), field06595 * var4)
         );
         GuiShapeRenderer.method09703(
            var1, this.field06578, this.field06579, this.field06580, this.field06581, field06596, 1.0F, method10227(method10223(), field06597 * var4)
         );
         FontRenderer var6 = Fonts.field00110;
         var6.method09480(
            var1, field06598, this.field06578 + field06599, this.field06579 + field06600, method10227(method10213(), field06601 * var4), field06602
         );
         float var7 = this.field06579 + field06603;
         float var8 = this.field06579 + this.field06581 - field06604;
         boolean var9 = this.field22875.method10232();
         float var10 = this.field22875.method10234();
         boolean var11 = var9 && var10 < field06605;
         float var12 = !var9 ? 1.0F : GuiHitTestUtils.method05621(var11 ? var10 / field06606 : (var10 - field06607) / field06608);
         float var13 = !var9 ? 1.0F : (var11 ? 1.0F - var12 : var12);
         float var14 = !var9 ? 0.0F : this.field22875.method10236() * (var11 ? -var12 : 1.0F - var12);
         int var15 = var11 ? this.field22875.method10233() : this.method02853(this.field06576, this.method02848());
         var var16 = this.method02836(var5, var15);
         float var17 = var11 ? this.field22881 : this.method10226(this.field06586, var8 - var7);
         var1.enableScissor((int)this.field06578, (int)var7, (int)(this.field06578 + this.field06580), (int)var8);
         var1.pose().pushMatrix();
         var1.pose().translate(var14 * field06609, 0.0F);
         float var18 = 0.0F;

         for (SettingComponent var20 : var16) {
            if (var20.method10977().method03019() || !(var20.method10979().method06173() < field06610)) {
               float var21 = GuiHitTestUtils.method05621(var20.method10979().method06173());
               var20.method09789(this.field06578 + field06611);
               var20.method09781(this.field06580 - field06612);
               var20.method03443();
               var20.method09788(var7 + 1.0F + var17 + var18);
               var20.method09783(var4 * var13 * var21);
               var20.method00042(var1, var2, var3, var4);
               var18 += var20.method09785() * var21;
            }
         }

         var1.pose().popMatrix();
         var1.disableScissor();
         this.field06586 = var18 + field06613;
      }
   }

   private void method02851(EntityEspStyle var1) {
      if (var1 != null) {
         boolean var2 = var1.method07154() && var1.method07158();
         boolean var3 = var1.method07146();
         int var4 = var3 ? field06645 : var1.method07148().method11676() & field06646;
         PictureInPictureRendererHooks.method07562(var2, var3, var1.method07159(), var4, var1.method07136(), var1.method07138(), var1.method07167());
      }
   }

   @Override
   public void method02852() {
      this.method10196();
   }

   private int method02853(int var1, int var2) {
      return var1 == 0 ? var2 : var1 + 2;
   }

   private List<SettingComponent<?>> method02854() {
      return this.method02836(ModuleManager.INSTANCE.method08235(), this.method02853(this.field06576, this.method02848()));
   }

   private void method02855(int var1) {
      if (var1 != this.field06576) {
         int var2 = this.method02848();
         int var3 = this.field06576;
         int var4 = this.method02853(var3, var2);
         this.field06576 = var1;
         int var5 = this.method02853(this.field06576, this.method02848());
         this.method02841(var4, var5);
         this.method02843(var3, var4, var5, var2);
      }
   }
}
