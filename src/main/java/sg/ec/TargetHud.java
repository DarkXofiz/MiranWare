// Original binary: sg/ec/af0qIAe31FOwM8tl
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import org.joml.Matrix3x2fStack;

// $VF: Compiled from s
public class TargetHud extends HudElement {
   private final ModeSetting field15683;
   private final ModeSetting field15684;
   private final ToggleSetting field15685;
   private final ToggleSetting field15686;
   private final ToggleSetting field15687;
   private final ToggleSetting field15688;
   private static final int field15689 = 7;
   private static final int field15690 = 0;
   private static final int field15691 = 0;
   private final AnimationUtils field15692;
   private String field15693;
   private float field15694;
   private float field15695;
   private Identifier field15696;
   private int field15697;
   private int field15698;
   private final List<TargetHealthAnimation> field15699;
   private final AnimationUtils field15700;
   private final AnimationUtils field15701;
   private static final int field15702 = 0;
   private ItemStack field15703;
   private int field15704;
   private int field15705;
   private int field15706;
   private boolean field15707;
   private final SmoothAnimation field15708;
   private static final double field15709 = 0;
   private final SmoothAnimation field15710;
   private String field15711;
   private String field15712;
   private int field15713;
   private boolean field15714;
   private final List<TargetHud.Nested204> field15715;
   private static final EquipmentSlot[] field15716 = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   private LivingEntity field15717;
   private final SmoothAnimation field15718;
   private final DraggableElement field15719;
   private static final String field15720 = "TargetHUD";
   private static final String field15721 = "Интерфейс";
   private static final String field15722 = "1 вид";
   private static final String field15723 = "2 вид";
   private static final String field15724 = "1 вид";
   private static final String field15725 = "Цвет отображения хп";
   private static final String field15726 = "Клиентский";
   private static final String field15727 = "Здоровье";
   private static final String field15728 = "Клиентский";
   private static final String field15729 = "Здоровье поглощения";
   private static final String field15730 = "Использование предмета";
   private static final String field15731 = "Партиклы";
   private static final String field15732 = "Отображать броню";
   private static final long field15733 = 300L;
   private static final long field15734 = 250L;
   private static final long field15735 = 250L;
   private static final String field15736 = "Клиентский";
   private static final String field15737 = "1 вид";
   private static final String field15738 = "2 вид";
   private static final float field15739 = 105.0F;
   private static final float field15740 = 35.0F;
   private static final float field15741 = 8.0F;
   private static final float field15742 = 0.01F;
   private static final float field15743 = 3.0F;
   private static final float field15744 = 3.0F;
   private static final float field15745 = 29.0F;
   private static final float field15746 = 17.5F;
   private static final float field15747 = 12.0F;
   private static final float field15748 = 3.0F;
   private static final float field15749 = 3.0F;
   private static final float field15750 = 0.5F;
   private static final float field15751 = 7.0F;
   private static final float field15752 = 360.0F;
   private static final float field15753 = 360.0F;
   private static final float field15754 = 360.0F;
   private static final float field15755 = 360.0F;
   private static final float field15756 = 360.0F;
   private static final float field15757 = 0.75F;
   private static final float field15758 = 4.0F;
   private static final float field15759 = 8.0F;
   private static final float field15760 = 16.0F;
   private static final float field15761 = 0.55F;
   private static final float field15762 = 3.0F;
   private static final float field15763 = 3.0F;
   private static final float field15764 = 7.0F;
   private static final float field15765 = 8.0F;
   private static final float field15766 = 17.0F;
   private static final float field15767 = 17.0F;
   private static final float field15768 = 105.0F;
   private static final float field15769 = 40.0F;
   private static final float field15770 = 0.01F;
   private static final float field15771 = 4.0F;
   private static final float field15772 = 4.0F;
   private static final float field15773 = 32.0F;
   private static final float field15774 = 45.0F;
   private static final float field15775 = 3.0F;
   private static final float field15776 = 10.0F;
   private static final String field15777 = "Z";
   private static final float field15778 = 0.75F;
   private static final float field15779 = 0.75F;
   private static final float field15780 = 5.0F;
   private static final float field15781 = 13.5F;
   private static final float field15782 = 0.75F;
   private static final float field15783 = 5.0F;
   private static final float field15784 = 5.0F;
   private static final float field15785 = 0.5F;
   private static final float field15786 = 7.0F;
   private static final float field15787 = 5.0F;
   private static final float field15788 = 3.0F;
   private static final float field15789 = 99.0F;
   private static final float field15790 = 0.5F;
   private static final float field15791 = 12.0F;
   private static final float field15792 = 6.0F;
   private static final float field15793 = 5.0F;
   private static final float field15794 = 7.0F;
   private static final float field15795 = 4.0F;
   private static final float field15796 = 4.0F;
   private static final float field15797 = 0.01F;
   private static final float field15798 = 4.0F;
   private static final float field15799 = 3.0F;
   private static final float field15800 = 3.0F;
   private static final float field15801 = 8.0F;
   private static final float field15802 = 20.0F;
   private static final float field15803 = 20.0F;
   private static final float field15804 = 0.25F;
   private static final float field15805 = 0.25F;
   private static final float field15806 = 0.05F;
   private static final float field15807 = 10.0F;
   private static final float field15808 = 1.2F;
   private static final float field15809 = 0.2F;
   private static final float field15810 = 0.5F;
   private static final float field15811 = 3.0F;
   private static final float field15812 = 0.01F;
   private static final float field15813 = 0.85F;
   private static final float field15814 = 16.0F;
   private static final float field15815 = 6.0F;
   private static final float field15816 = 0.7F;
   private static final float field15817 = 0.3F;
   private static final float field15818 = 16.0F;
   private static final float field15819 = 8.0F;
   private static final float field15820 = 1.5F;
   private static final float field15821 = 0.01F;
   private static final float field15822 = 99.0F;
   private static final double field15823 = 0.25;
   private static final double field15824 = 0.6;
   private static final double field15825 = 0.2F;
   private static final float field15826 = 0.01F;
   private static final float field15827 = 2.5F;
   private static final float field15828 = 4.0F;
   private static final float field15829 = 6.0F;
   private static final double field15830 = 365.0;
   private static final double field15831 = 0.16F;
   private static final double field15832 = 0.16F;
   private static final double field15833 = 0.16F;
   private static final float field15834 = 0.01F;

   private static ItemStack method06966(LivingEntity var0) {
      if (!var0.isUsingItem()) {
         return ItemStack.EMPTY;
      }

      ItemStack var1 = var0.getUseItem();
      if (method06967(var1)) {
         return var1;
      }

      ItemStack sx = var0.getItemInHand(var0.getUsedItemHand());
      return method06967(sx) ? sx : ItemStack.EMPTY;
   }

   @Override
   public void method00024() {
      this.field15699.removeIf(var0 -> var0.method07095() > 22 && var0.method07106().method03377() < field15834);
      this.field15717 = this.method06980(this.field15717);
      if (this.field15717 != null) {
         this.method06986();
         this.method06979();
         this.method06984();
         if (!(this.field15718.method06173() < field15821)) {
            this.method06974();
            super.method00024();
         }
      }
   }

   private static boolean method06967(ItemStack var0) {
      if (var0.isEmpty()) {
         return false;
      }

      ItemUseAnimation var1 = var0.getUseAnimation();
      return var1 == ItemUseAnimation.EAT || var1 == ItemUseAnimation.DRINK;
   }

   private void method06968() {
      this.field15703 = ItemStack.EMPTY;
      this.field15704 = 0;
      this.field15705 = 0;
      this.field15707 = false;
      this.field15708.method06157(0.0);
   }

   private CornerColors[] method06969(float var1, float var2) {
      float var3 = this.field15692.method03377();
      int var4 = ColorUtils.Nested138.method04638(0);
      int var5 = ColorUtils.Nested138.method04638(90);
      int var6 = ColorUtils.method04601(var1, 1.0F, false);
      int var7 = ColorUtils.method04596(var6, field15804);
      int var8 = ColorUtils.method04611(ColorUtils.method04627(var4, var7, var3), var2);
      int var9 = ColorUtils.method04611(ColorUtils.method04627(var5, var6, var3), var2);
      int var10 = ColorUtils.method04611(var9, var2 * field15805);
      CornerColors var11 = new CornerColors(var8, var8, var9, var9);
      CornerColors var12 = new CornerColors(var10, var10, var10, var10);
      return new CornerColors[]{var11, var12};
   }

   private void method06970(int var1) {
      String var2 = Integer.toString(var1);
      if (!var2.equals(this.field15712)) {
         this.field15711 = this.field15712.isEmpty() ? null : this.field15712;
         this.field15714 = var1 > this.field15713;
         this.field15713 = var1;
         this.field15712 = var2;
         this.field15710.method06157(0.0);
         this.field15710.method06158(1.0, field15823, Easings.field19403);
      }
   }

   private Identifier method06971(LivingEntity var1) {
      try {
         if (!(mc.getEntityRenderDispatcher().getRenderer(var1) instanceof LivingEntityRenderer var3)) {
            return null;
         } else {
            return var3.createRenderState(var1, mc.getDeltaTracker().getGameTimeDeltaPartialTick(true)) instanceof LivingEntityRenderState var5
               ? var3.getTextureLocation(var5)
               : null;
         }
      } catch (Throwable var6) {
         return null;
      }
   }

   private void method06972(GuiGraphics var1, float var2, float var3, float var4, float var5, boolean var6) {
      if (this.field15688.method05999()) {
         float var7 = field15818 * var5;
         float var8 = var7 + var5;
         float var9 = field15819 * var5;
         int var10 = 0;

         for (TargetHud.Nested204 var12 : this.field15715) {
            if (var6 || !var12.hands()) {
               ItemStack var13 = var12.stack();
               float var14 = var2 + var10 * var8;
               ItemRenderUtils.method08415(var1, var13, var14, var3, 1.0F, var4, var5);
               if (var13.isDamaged()) {
                  float var15 = Mth.clamp((float)var13.getDamageValue() / var13.getMaxDamage(), 0.0F, 1.0F);
                  float var16 = var14 + var5;
                  float var17 = var3 + var7;
                  float var18 = var7 - 2.0F * var5;
                  float var19 = field15820 * var5;
                  RoundedRectRenderer.method01272(
                     var1, var16, var17, var18, var19, 0.0F, 0.0F, ColorUtils.method04611(ColorUtils.method04604(30, 30, 30), var4)
                  );
                  RoundedRectRenderer.method01272(
                     var1,
                     var16,
                     var17,
                     var18 * (1.0F - var15),
                     var19,
                     0.0F,
                     0.0F,
                     ColorUtils.method04611(ColorUtils.method04601(var13.getDamageValue(), var13.getMaxDamage(), true), var4)
                  );
               }

               int var20 = var13.getCount();
               if (var20 > 1) {
                  String var21 = var20 + "";
                  float var22 = field14601.method09486(var21, var9);
                  field14601.method09480(
                     var1, var21, var14 + (var7 - var22) / 2.0F, var3 - var9, ColorUtils.method04611(this.method06438(), var4), var9
                  );
               }

               var10++;
            }
         }
      }
   }

   private void method06973(GuiGraphics var1, float var2, float var3, float var4, float var5) {
      this.method06972(var1, var2, var3, var4, var5, true);
   }

   private void method06974() {
      if (this.field15687.method05999()) {
         float var1 = field15827;

         for (int var2 = 0; var2 < 3; var2++) {
            if (this.field15717.hurtTime > 5) {
               this.field15699
                  .add(
                     new TargetHealthAnimation(
                        this.method06436(),
                        this.method06464(),
                        GuiHitTestUtils.method05613(-var1, var1),
                        GuiHitTestUtils.method05613(-var1, var1),
                        GuiHitTestUtils.method05613(field15828, field15829),
                        (int)(Math.random() * field15830)
                     )
                  );
            }
         }
      }

      if (!this.field15699.isEmpty()) {
         for (TargetHealthAnimation var4 : this.field15699) {
            var4.method07107();
         }
      }
   }

   private void method06975(GuiGraphics var1, float var2, float var3, float var4) {
      this.field15708.method06162();
      float var5 = this.field15708.method06173();
      if (!(var5 < field15812) && !this.field15703.isEmpty()) {
         float var6 = field15813;
         float var7 = field15814 * var6;
         float var8 = field15815;
         float var9 = 1.0F;
         float var10 = var7 + var9 + var8;
         float var11 = var3 - var10 / 2.0F;
         float var12 = var4 * var5;
         float var13 = field15816 + field15817 * var5;
         float var14 = this.field15707 ? mc.getDeltaTracker().getGameTimeDeltaPartialTick(true) : 0.0F;
         float var15 = Math.max(0.0F, this.field15704 - var14);
         int var16 = Math.round(var15 / 2.0F);
         String var17 = var16 / 10 + "." + var16 % 10 + " с.";
         Matrix3x2fStack var18 = var1.pose();
         var18.pushMatrix();
         var18.translate(var2, var3);
         var18.scale(var13, var13);
         var18.translate(-var2, -var3);
         ItemRenderUtils.method08415(var1, this.field15703, var2 - var7 / 2.0F, var11, 1.0F, var12, var6);
         field14601.method09473(var1, var17, var2, var11 + var7 + var9, ColorUtils.method04611(-1, var12), var8);
         var18.popMatrix();
      }
   }

   private static int method06976(LivingEntity var0, ItemStack var1) {
      int var2 = var0.getUseItemRemainingTicks();
      return var2 > 0 ? var2 : var1.getUseDuration(var0);
   }

   private float method06977() {
      return (this.field15717.hurtTime - (this.field15717.hurtTime != 0 ? mc.getDeltaTracker().getGameTimeDeltaPartialTick(true) : 0.0F)) / field15807;
   }

   private void method06979() {
      this.field15696 = this.method06971(this.field15717);
      int var1 = StreamerNameUtils.method03490();
      if (this.field15697 != this.field15717.getId() || this.field15698 != var1) {
         this.field15697 = this.field15717.getId();
         this.field15698 = var1;
         this.field15693 = StreamerNameUtils.method03481(this.field15717.getName().getString());
      }

      this.field15694 = PlayerUtils.method11820(this.field15717);
      this.field15695 = this.field15717.getAbsorptionAmount();
      this.method06970((int)Mth.clamp(this.field15694, 1.0F, field15822));
   }

   public LivingEntity method06980(LivingEntity var1) {
      LivingEntity var2 = var1;
      if (AttackAura.method00456() instanceof LivingEntity) {
         var2 = AttackAura.method00456();
         this.field15718.method06168(1.0, field15831, Easings.field19394, true);
      } else if (mc.gui.screen() instanceof ChatScreen) {
         var2 = mc.player;
         this.field15718.method06168(1.0, field15832, Easings.field19394, true);
      } else {
         this.field15718.method06168(0.0, field15833, Easings.field19394, true);
      }

      return var2;
   }

   private void method06981(Matrix3x2fStack var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var2 + var4 / 2.0F;
      float var8 = var3 + var5 / 2.0F;
      float var9 = field15808 - var6 * field15809;
      var1.pushMatrix();
      var1.translate(var7, var8);
      var1.scale(var9, var9);
      var1.translate(-var7, -var8);
   }

   private void method06982(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (this.field15696 != null) {
         int var8 = ColorUtils.method04611(ColorUtils.method04627(ColorUtils.method04604(255, 50, 50), -1, var6), var7);
         GuiTextureRenderer.method10260(
            var1, this.field15696, false, var2 + field15810, var3, var4, var4, new CornerRadii(var5), 1.0F, new CornerColors(var8)
         );
         GuiTextureRenderer.method10260(
            var1, this.field15696, true, var2 - 1.0F, var3, var4 + field15811, var4, new CornerRadii(var5), 1.0F, new CornerColors(var8)
         );
      }
   }

   private static float method06983(float var0, float var1) {
      return Math.max(field15806, Math.min(1.0F, var0 / var1));
   }

   private void method06984() {
      if (this.field15706 != this.field15717.getId()) {
         this.field15706 = this.field15717.getId();
         this.method06968();
      }

      ItemStack var1 = this.field15686.method05999() ? method06966(this.field15717) : ItemStack.EMPTY;
      if (var1.isEmpty()) {
         this.field15707 = false;
         if (this.field15705 > 0) {
            this.field15705--;
         }
      } else {
         if (ItemStack.isSameItem(var1, this.field15703)) {
            int var2 = this.field15717.getUseItemRemainingTicks();
            this.field15704 = var2 > 0 ? var2 : Math.max(0, this.field15704 - 1);
         } else {
            if (!this.field15703.isEmpty()) {
               this.field15708.method06157(field15824);
            }

            this.field15703 = var1;
            this.field15704 = method06976(this.field15717, var1);
         }

         this.field15707 = true;
         this.field15705 = 2;
      }

      boolean var3 = this.field15707 || this.field15705 > 0;
      this.field15708.method06168(var3 ? 1.0 : 0.0, field15825, Easings.field19403, true);
      if (!var3 && this.field15708.method06173() < field15826) {
         this.field15703 = ItemStack.EMPTY;
      }
   }

   public TargetHud() {
      super(field15720);
      this.field15683 = new ModeSetting(field15721).method05597(field15722, field15723).method03017(field15724).method03023(this);
      this.field15684 = new ModeSetting(field15725).method05597(field15726, field15727).method03017(field15728).method03023(this);
      this.field15685 = new ToggleSetting(field15729).method03017(true).method03023(this);
      this.field15686 = new ToggleSetting(field15730).method03017(true).method03023(this);
      this.field15687 = new ToggleSetting(field15731).method03017(true).method03023(this);
      this.field15688 = new ToggleSetting(field15732).method03017(false).method03023(this);
      this.field15692 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field15733);
      this.field15693 = "";
      this.field15694 = 1.0F;
      this.field15695 = 1.0F;
      this.field15696 = null;
      this.field15697 = 0;
      this.field15698 = -1;
      this.field15699 = new ArrayList<>();
      this.field15700 = new AnimationUtils(AnimationUtils.Nested95.NOVA_EASING, field15734);
      this.field15701 = new AnimationUtils(AnimationUtils.Nested95.NOVA_EASING, field15735);
      this.field15703 = ItemStack.EMPTY;
      this.field15704 = 0;
      this.field15705 = 0;
      this.field15706 = 0;
      this.field15707 = false;
      this.field15708 = new SmoothAnimation();
      this.field15710 = new SmoothAnimation();
      this.field15711 = null;
      this.field15712 = "";
      this.field15713 = 0;
      this.field15714 = true;
      this.field15715 = new ArrayList<>();
      this.field15717 = null;
      this.field15718 = new SmoothAnimation();
      this.field15719 = this.method06449(this, 0.0F, 0.0F);
   }

   private void method06985(GuiGraphics var1) {
      float var2 = field15739;
      float var3 = field15740;
      float var4 = field15741;
      this.method06465(this.field15719.method02685());
      this.method06453(this.field15719.method02669());
      this.method06448(var2);
      this.method06456(var3);
      if (this.field15717 != null) {
         this.field15718.method06162();
         if (!(this.field15718.method06173() < field15742)) {
            Matrix3x2fStack var5 = var1.pose();
            float var6 = this.method06436();
            float var7 = this.method06464();
            this.field15700.method03375(this.field15694);
            this.field15701.method03375(this.field15695);
            float var8 = this.method06455();
            float var9 = GuiHitTestUtils.method05621(this.field15718.method06173());
            float var10 = this.method06977();
            float var11 = this.field15717.getMaxHealth();
            float var12 = method06983(this.field15700.method03377(), var11);
            float var13 = this.field15685.method05999() ? Mth.clamp(this.field15701.method03377() / var11, 0.0F, 1.0F) : 0.0F;
            int var14 = ColorUtils.method04611(this.method06438(), var9);
            float var15 = var6 + field15743;
            float var16 = var7 + field15744;
            float var17 = field15745;
            float var18 = var6 + var2 - field15746;
            float var19 = var7 + var3 / 2.0F;
            float var20 = field15747;
            float var21 = field15748;
            float var22 = var15 + var17 + field15749;
            this.method06981(var5, var6, var7, var2, var3, this.field15718.method06173());
            this.method06439(var1, var6, var7, var2, var3, var4, this.method06466(), var9);
            if (!this.method06447()) {
               GuiShadowRenderer.method10984(
                  var1, var6, var7, var2, var3, var4, field15750, field15751, ColorUtils.method04611(this.method06460(), var9 * var8)
               );
            }

            RoundedRectRenderer.method01272(
               var1, var6, var7, var2, var3, var4, this.method06466(), ColorUtils.method04611(this.method06460(), var9 * var8)
            );
            this.method06982(var1, var15, var16, var17, var4 - 2.0F, var10, var9);
            this.method06975(var1, var15 + var17 / 2.0F, var16 + var17 / 2.0F, var9);
            CornerColors[] var23 = this.method06969(var12, var9);
            CornerColors var24 = var23[0];
            float var25 = field15752 * var12;
            float var26 = field15753 * var13;
            float var27 = var25 + var26;
            float var28 = var27 > field15754 ? field15755 / var27 : 1.0F;
            float var29 = var25 * var28;
            float var30 = var27 * var28;
            GuiShapeRenderer.Nested268.method09707(
               var1,
               var18,
               var19,
               0.0F,
               field15756,
               var20,
               var21,
               false,
               var9,
               ColorUtils.method04611(ColorUtils.method04604(30, 30, 30), field15757 * var9)
            );
            GuiShapeRenderer.Nested268.method09711(
               var1,
               var18,
               var19,
               var29,
               var30,
               var20,
               var21,
               var9,
               var24.color2(),
               var24.color3(),
               ColorUtils.method04604(255, 242, 0),
               ColorUtils.method04604(150, 142, 0),
               4
            );
            TextRenderUtils.method00668(
               var1,
               field14601,
               this.field15711,
               this.field15712,
               this.field15710.method06173(),
               var18,
               var19 - field15758,
               ColorUtils.method04611(-1, var9),
               field15759,
               this.field15714
            );
            this.method06972(var1, var22, var7 + field15760, var9, field15761, false);
            TextRenderUtils.method00669(
               var1,
               field14601,
               this.field15693,
               var22,
               var16 + field15762,
               var18 - (var20 + var21 / 2.0F) - field15763 - var22,
               var14,
               field15764,
               -field14608,
               field15765
            );
            this.method06987(var1, field15766, field15767, var9);
            var5.popMatrix();
            this.field15719.method02676(this.method06458());
            this.field15719.method02696(this.method06435());
         }
      }
   }

   private void method06986() {
      if (this.field15688.method05999()) {
         this.field15715.clear();
         ItemStack var1 = this.field15717.getMainHandItem();
         ItemStack var2 = this.field15717.getOffhandItem();
         if (!var1.isEmpty()) {
            this.field15715.add(new TargetHud.Nested204(this.field15717.getMainHandItem(), true));
         }

         if (!var2.isEmpty()) {
            this.field15715.add(new TargetHud.Nested204(this.field15717.getOffhandItem(), true));
         }

         for (EquipmentSlot var6 : field15716) {
            ItemStack var7 = this.field15717.getItemBySlot(var6);
            if (!var7.isEmpty()) {
               this.field15715.add(new TargetHud.Nested204(var7, false));
            }
         }
      }
   }

   @Override
   public void method00027(GuiGraphics var1) {
      super.method00027(var1);
      this.field15710.method06162();
      this.field15692.method03375(this.field15684.method05600(field15736) ? 1.0 : 0.0);
      switch ((String)this.field15683.method03022()) {
         case field15737:
            this.method06988(var1);
            break;
         case field15738:
            this.method06985(var1);
      }
   }

   private void method06987(GuiGraphics var1, float var2, float var3, float var4) {
      for (TargetHealthAnimation var6 : this.field15699) {
         var6.method07108(var1, var2, var3, var4);
      }
   }

   private void method06988(GuiGraphics var1) {
      float var2 = field15768;
      float var3 = field15769;
      this.method06465(this.field15719.method02685());
      this.method06453(this.field15719.method02669());
      this.method06448(var2);
      this.method06456(var3);
      if (this.field15717 != null) {
         this.field15718.method06162();
         if (!(this.field15718.method06173() < field15770)) {
            Matrix3x2fStack var4 = var1.pose();
            float var5 = this.method06436();
            float var6 = this.method06464();
            this.field15700.method03375(this.field15694);
            this.field15701.method03375(this.field15695);
            float var7 = this.method06455();
            float var8 = GuiHitTestUtils.method05621(this.field15718.method06173());
            float var9 = this.method06977();
            int var10 = ColorUtils.method04611(this.method06438(), var8);
            float var11 = this.field15717.getMaxHealth();
            float var12 = var5 + field15771;
            float var13 = var6 + field15772;
            float var14 = field15773;
            float var15 = var2 - field15774;
            float var16 = method06983(this.field15700.method03377(), var11);
            float var17 = this.field15685.method05999() ? Mth.clamp(this.field15701.method03377() / var11, 0.0F, 1.0F) : 0.0F;
            float var18 = var12 + var14 + field15775;
            float var19 = var6 + var3 - field15776;
            String var20 = field15777;
            int var21 = ColorUtils.method04611(ColorUtils.method04604(255, 255, 0), var8 * field15778);
            int var22 = ColorUtils.method04611(ColorUtils.method04604(75, 75, 0), var8 * field15779);
            this.method06981(var4, var5, var6, var2, var3, this.field15718.method06173());
            this.method06973(var1, var5 + field15780, var6 - field15781, var8, field15782);
            this.method06439(var1, var5, var6, var2, var3, field15783, this.method06466(), var8);
            if (!this.method06447()) {
               GuiShadowRenderer.method10984(
                  var1, var5, var6, var2, var3, field15784, field15785, field15786, ColorUtils.method04611(this.method06460(), var8 * var7)
               );
            }

            RoundedRectRenderer.method01272(
               var1, var5, var6, var2, var3, field15787, this.method06466(), ColorUtils.method04611(this.method06460(), var8 * var7)
            );
            this.method06982(var1, var12, var13, var14, field15788, var9, var8);
            this.method06975(var1, var12 + var14 / 2.0F, var13 + var14 / 2.0F, var8);
            int var23 = (int)Mth.clamp(this.field15694, 1.0F, field15789);
            field14601.method09473(var1, var23 + "", var18 - field15790 + var15 * var16, var19 - field15791, var10, field15792);
            Fonts.field00107
               .method09480(var1, var20, var18 - field15793 + var15 * var16, var19 - field15794, var10, HudElement.field14607);
            CornerColors[] var24 = this.method06969(var16, var8);
            CornerColors var25 = var24[0];
            CornerColors var26 = var24[1];
            RoundedRectRenderer.method01275(var1, var18, var19, var15, field15795, 1.0F, 1.0F, var26);
            RoundedRectRenderer.method01275(var1, var18, var19, var15 * var16, field15796, 1.0F, 1.0F, var25);
            if (var17 > field15797) {
               RoundedRectRenderer.method01275(var1, var18, var19, var15 * var17, field15798, 1.0F, 1.0F, new CornerColors(var22, var22, var21, var21));
            }

            TextRenderUtils.method00669(
               var1,
               field14601,
               this.field15693,
               var18,
               var13 + field15799,
               var5 + var2 - var18 - field15800,
               var10,
               HudElement.field14607,
               -field14608,
               field15801
            );
            this.method06987(var1, field15802, field15803, var8);
            var4.popMatrix();
            this.field15719.method02676(var2);
            this.field15719.method02696(var3);
         }
      }
   }

   // $VF: Compiled from s
   private record Nested204(ItemStack stack, boolean hands) {
   }
}
