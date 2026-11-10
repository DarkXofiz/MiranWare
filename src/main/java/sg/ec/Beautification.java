// Original binary: sg/ec/Fv31JpjneQgDrMJO
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.AttackIndicatorStatus;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import org.joml.Matrix3x2fStack;
import sg.mx.HudMixin_1316;

// $VF: Compiled from s
public class Beautification extends ClientModule {
   private static final int field07738 = ColorUtils.method04604(230, 230, 230);
   private static final String field07739 = "Соотношение сторон";
   private static final String field07740 = "field07740";
   private final MultiToggleSetting field07741;
   private final ModeSetting field07742;
   private final NumberSetting<Float> field07743;
   private boolean field07744;
   private int field07745;
   private boolean field07746;
   private boolean field07747;
   private boolean field07748;
   private boolean field07749;
   private float field07750;
   private final AnimationUtils field07751;
   private static final String field07752 = "Украшения";
   private static final String field07753 = "Открытие таба";
   private static final String field07754 = "Открытие инвентаря";
   private static final String field07755 = "Сообщения в чате";
   private static final String field07756 = "Кастомный хотбар";
   private static final String field07757 = "Соотношение сторон";
   private static final String field07758 = "Формат";
   private static final String field07759 = "16:9";
   private static final String field07760 = "16:10";
   private static final String field07761 = "4:3";
   private static final String field07762 = "Своё";
   private static final String field07763 = "16:9";
   private static final String field07764 = "Значение";
   private static final float field07765 = 0.5F;
   private static final float field07766 = 4.0F;
   private static final float field07767 = 0.05F;
   private static final float field07768 = 1.75F;
   private static final long field07769 = 100L;
   private static final String field07770 = "Beautification";
   private static final String field07771 = "Открытие инвентаря";
   private static final String field07772 = "Открытие таба";
   private static final String field07773 = "Кастомный хотбар";
   private static final String field07774 = "Сообщения в чате";
   private static final String field07775 = "Соотношение сторон";
   private static final String field07776 = "16:10";
   private static final String field07777 = "4:3";
   private static final String field07778 = "Своё";
   private static final float field07779 = 1.6F;
   private static final float field07780 = 1.3333334F;
   private static final float field07781 = 1.7777778F;
   private static final float field07782 = 0.01F;
   private static final float field07783 = 0.01F;
   private static final float field07784 = 5.0F;
   private static final float field07785 = 0.75F;
   private static final double field07786 = 8.0;
   private static final float field07787 = 182.0F;
   private static final float field07788 = 22.0F;
   private static final float field07789 = 20.0F;
   private static final float field07790 = 0.5F;
   private static final float field07791 = 22.0F;
   private static final float field07792 = 22.0F;
   private static final float field07793 = 29.5F;
   private static final float field07794 = 22.0F;
   private static final float field07795 = 22.0F;
   private static final float field07796 = 22.0F;
   private static final float field07797 = 22.0F;
   private static final float field07798 = 19.0F;
   private static final float field07799 = 5.0F;
   private static final float field07800 = 14.0F;
   private static final float field07801 = 1.5F;
   private static final float field07802 = 1.5F;
   private static final float field07803 = 9.0F;
   private static final float field07804 = 9.0F;
   private static final String field07805 = "Соотношение сторон";
   private static final String field07806 = "Своё";
   private static final String field07807 = "Соотношение сторон";

   @Subscribe
   private void method03468(PlayerListRenderEvent var1) {
      if (this.field07747) {
         GuiGraphics var2 = var1.method04114();
         Matrix3x2fStack sx = var2.pose();
         float sxx = var1.method04122();
         switch (var1.method04113()) {
            case ANIM_UPDATE:
               var1.method05696();
               break;
            case START:
               float sxxx = mc.getWindow().getGuiScaledWidth() / 2.0F;
               sx.pushMatrix();
               sx.translate(sxxx, 0.0F);
               sx.scale(sxx, sxx);
               sx.translate(-sxxx, 0.0F);
               break;
            case END:
               sx.popMatrix();
               break;
            case VISIBLE:
               PlayerTabOverlay sxxxx = var1.method04117();
               Minecraft sxxxxx = var1.method04115();
               Scoreboard sxxxxxx = sxxxxx.level.getScoreboard();
               Objective sxxxxxxx = sxxxxxx.getDisplayObjective(DisplaySlot.LIST);
               float sxxxxxxxx = ((AnimationAccess)sxxxx).anim().method03377();
               sxxxx.setVisible(
                  sxxxxx.options.keyPlayerList.isDown()
                     && (!sxxxxx.isLocalServer() || sxxxxx.player.connection.getListedOnlinePlayers().size() > 1 || sxxxxxxx != null)
               );
               if (sxxxxxxxx > field07783) {
                  sxxxx.extractRenderState(var2, var2.guiWidth(), sxxxxxx, sxxxxxxx);
               }

               var1.method05696();
         }
      }
   }

   @Subscribe
   private void method03470(TickEvent var1) {
      this.field07746 = this.field07741.method04520(field07771);
      this.field07747 = this.field07741.method04520(field07772);
      this.field07749 = this.field07741.method04520(field07773);
      this.field07748 = this.field07741.method04520(field07774);
      this.field07750 = this.field07741.method04520(field07775) ? this.method03477() : 0.0F;
   }

   public Beautification() {
      super(ModuleCategory.Render, ModuleSubCategory.Other);
      this.field07741 = new MultiToggleSetting(field07752)
         .method04517(NamedOption.method08077(field07753, true))
         .method04517(NamedOption.method08077(field07754, true))
         .method04517(NamedOption.method08077(field07755, false))
         .method04517(NamedOption.method08077(field07756, false))
         .method04517(NamedOption.method08077(field07757, false))
         .method03023(this);
      this.field07742 = new ModeSetting(field07758)
         .method05597(field07759, field07760, field07761, field07762)
         .method03017(field07763)
         .method03025(() -> this.field07741.method04520(field07807))
         .method03023(this);
      this.field07743 = new NumberSetting<Float>(field07764)
         .method10835(field07765)
         .method10838(field07766)
         .method10834(field07767)
         .method03017(field07768)
         .method03025(() -> this.field07741.method04520(field07805) && this.field07742.method05600(field07806))
         .method03023(this);
      this.field07746 = false;
      this.field07747 = false;
      this.field07748 = false;
      this.field07749 = false;
      this.field07751 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_EXPO, field07769);
      this.method03935(field07770);
   }

   public float method03472() {
      return this.field07750;
   }

   @Subscribe
   private void method03473(ChatAlphaEvent var1) {
      if (this.field07748) {
         var1.method05696();
      }
   }

   private void method03474(GuiGraphics var1, DeltaTracker var2, Player var3, Beautification.Nested99 var4) {
      int var5 = var4.field07809();
      int var6 = var4.field07810();
      ItemStack var7 = var4.stack();
      float var8 = var7.getPopTime() - var2.getGameTimeDeltaPartialTick(true);
      if (var8 > 0.0F) {
         float var9 = 1.0F + var8 / field07799;
         float var10 = var5 + 8;
         float var11 = var6 + 12;
         var1.pose().pushMatrix();
         var1.pose().translate(var10, var11);
         var1.pose().scale(1.0F / var9, (var9 + 1.0F) / 2.0F);
         var1.pose().translate(-var10, -var11);
      }

      var1.item(var3, var7, var5, var6, var4.seed());
      if (var8 > 0.0F) {
         var1.pose().popMatrix();
      }
   }

   private void method03475(List<Beautification.Nested99> var1, int var2, int var3, ItemStack var4, int var5) {
      if (!var4.isEmpty()) {
         var1.add(new Beautification.Nested99(var2, var3, var4, var5));
      }
   }

   @Subscribe
   private void method03476(ContainerAnimationEvent var1) {
      if (this.field07746) {
         if (var1.method05373() instanceof InventoryScreen) {
            if (var1.method05379() == ContainerAnimationEvent.Nested164.END) {
               if (this.field07744 && this.field07745 > 0) {
                  this.field07745--;
               }

               if (this.field07744 && this.field07745 == 0) {
                  var1.method05378().pose().popMatrix();
                  this.field07744 = false;
               }
            } else {
               this.field07745++;
               if (!this.field07744) {
                  GuiGraphics var2 = var1.method05378();
                  AnimationUtils var3 = var1.method05376();
                  var3.method03375(1.0);
                  float var4 = Math.max(field07782, Math.min(1.0F, var3.method03377()));
                  Matrix3x2fStack var5 = var2.pose();
                  float var6 = var2.guiWidth() / 2.0F;
                  float var7 = var2.guiHeight() / 2.0F;
                  var5.pushMatrix();
                  this.field07744 = true;
                  var5.translate(var6, var7);
                  var5.scale(var4, var4);
                  var5.translate(-var6, -var7);
                  var1.method05380(var4);
               }
            }
         }
      }
   }

   private float method03477() {
      return switch ((String)this.field07742.method03022()) {
         case field07776 -> field07779;
         case field07777 -> field07780;
         case field07778 -> this.field07743.method03022();
         default -> field07781;
      };
   }

   private void method03478(GuiGraphics var1, Beautification.Nested99 var2) {
      int var3 = var2.field07809();
      int var4 = var2.field07810();
      ItemStack var5 = var2.stack();
      float var6 = var5.getMaxDamage();
      float var7 = var5.getDamageValue();
      if (var5.isDamaged()) {
         float var8 = field07800;
         float var9 = var8 * Mth.clamp(var7 / var6, 0.0F, 1.0F);
         RoundedRectRenderer.method01272(var1, var3 + 1, var4 + 14, var8, field07801, 0.0F, 0.0F, ColorUtils.method04604(30, 30, 30));
         RoundedRectRenderer.method01272(var1, var3 + 1, var4 + 14, var8 - var9, field07802, 0.0F, 0.0F, ColorUtils.method04601(var7, var6, true));
      }

      int var10 = var5.getCount();
      if (var10 >= 2) {
         String var11 = Integer.toString(var10);
         Fonts.field00109
            .method09480(var1, var11, var3 + 19 - 2 - Fonts.field00109.method09486(var11, field07803), var4 + 8, field07738, field07804);
      }
   }

   @Subscribe
   private void method03479(HotbarRenderEvent var1) {
      if (var1.method09179() != HotbarRenderEvent.Nested254.END) {
         if (this.field07749) {
            Minecraft var2 = var1.method09175();
            Hud var3 = var1.method09180();
            GuiGraphics var4 = var1.method09170();
            DeltaTracker var5 = var1.method09181();
            Player var6 = ((HudMixin_1316)(Object)var3).IgetCameraPlayer();
            int var7 = ColorUtils.method04604(0, 0, 0);
            if (var6 != null) {
               float var8 = field07784;
               float var9 = field07785;
               RoundedRectRenderer.method01277();
               ItemStack var10 = var6.getOffhandItem();
               HumanoidArm var11 = var6.getMainArm().getOpposite();
               int var12 = var4.guiWidth() / 2;
               int var13 = HeldItemRenderEvent.field00682.method00309(var6.getInventory().getSelectedSlot());
               this.field07751.method03375(var13);
               float var14 = (float)Math.max(0.0, Math.min(field07786, this.field07751.method03384()));
               var4.pose().pushMatrix();
               var4.pose().translate(0.0F, 0.0F);
               RoundedRectRenderer.method01272(
                  var4, var12 - 91, var4.guiHeight() - 22, field07787, field07788, var8, 1.0F, ColorUtils.method04611(var7, var9)
               );
               RoundedRectRenderer.method01272(
                  var4,
                  var12 - 91 + var14 * field07789,
                  var4.guiHeight() - 22 + field07790,
                  field07791,
                  field07792,
                  var8,
                  1.0F,
                  ColorUtils.method04611(var7, var9)
               );
               if (!var10.isEmpty()) {
                  if (var11 == HumanoidArm.LEFT) {
                     RoundedRectRenderer.method01272(
                        var4, var12 - 90 - field07793, var4.guiHeight() - 22, field07794, field07795, var8, 1.0F, ColorUtils.method04611(var7, var9)
                     );
                  } else {
                     RoundedRectRenderer.method01272(
                        var4, var12 + 96, var4.guiHeight() - 22, field07796, field07797, var8, 1.0F, ColorUtils.method04611(var7, var9)
                     );
                  }
               }

               RoundedRectRenderer.method01278();
               var4.pose().popMatrix();
               int var15 = 1;
               var var19 = new ArrayList(10);

               for (int var16 = 0; var16 < 9; var16++) {
                  int var17 = var12 - 90 + var16 * 20 + 2;
                  int var18 = var4.guiHeight() - 16 - 3;
                  this.method03475(var19, var17, var18, var6.getInventory().getNonEquipmentItems().get(var16), var15++);
               }

               if (!var10.isEmpty()) {
                  int var24 = var4.guiHeight() - 16 - 3;
                  if (var11 == HumanoidArm.LEFT) {
                     this.method03475(var19, var12 - 91 - 26, var24, var10, var15++);
                  } else {
                     this.method03475(var19, var12 + 89 + 10, var24, var10, var15++);
                  }
               }

               for (Beautification.Nested99 var21 : (Iterable<Beautification.Nested99>) (Iterable) var19) {
                  this.method03474(var4, var5, var6, var21);
               }

               if (!var19.isEmpty()) {
                  var4.nextStratum();
                  RoundedRectRenderer.method01277();

                  for (Beautification.Nested99 var29 : (Iterable<Beautification.Nested99>) (Iterable) var19) {
                     this.method03478(var4, var29);
                  }

                  RoundedRectRenderer.method01278();
               }

               if (var2.options.attackIndicator().get() == AttackIndicatorStatus.HOTBAR) {
                  float var28 = var2.player.getAttackStrengthScale(0.0F);
                  if (var28 < 1.0F) {
                     int var25 = var4.guiHeight() - 20;
                     int var26 = var12 + 91 + 6;
                     if (var11 == HumanoidArm.RIGHT) {
                        var26 = var12 - 91 - 22;
                     }

                     int var30 = (int)(var28 * field07798);
                     var4.blitSprite(RenderPipelines.GUI_TEXTURED, HudMixin_1316.HOTBAR_ATTACK_INDICATOR_BACKGROUND_TEXTURE(), var26, var25, 18, 18);
                     var4.blitSprite(
                        RenderPipelines.GUI_TEXTURED,
                        HudMixin_1316.HOTBAR_ATTACK_INDICATOR_PROGRESS_TEXTURE(),
                        18,
                        18,
                        0,
                        18 - var30,
                        var26,
                        var25 + 18 - var30,
                        18,
                        var30
                     );
                  }
               }
            }

            var1.method05696();
            HotbarRenderEvent.field20796
               .method09172(
                  HotbarRenderEvent.Nested254.END, var1.method09181(), var1.method09175(), var1.method09180(), var1.method09170(), var1.method09171()
               );
         }
      }
   }

   // $VF: Compiled from s
   private record Nested99(int field07809, int field07810, ItemStack stack, int seed) {
   }
}
