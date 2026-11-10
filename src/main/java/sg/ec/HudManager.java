// Original binary: sg/ec/0Aw2NRF7mguC4JsQ
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.joml.Matrix3x2fStack;

// $VF: Compiled from s
public class HudManager implements HudRenderComponent {
   private final Map<Class<? extends HudElement>, HudElement> field00075 = new HashMap<>();
   private final List<HudElement> field00076 = new ArrayList<>();
   private final ModuleContextMenu field00077 = new ModuleContextMenu();
   private static final float field00078 = 6.0F;
   private static final float field00079 = 6.0F;

   @Override
   public void method00012(MobEffectEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00012(var1);
         }
      }
   }

   @Override
   public void method00013(FrameDeltaEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00013(var1);
         }
      }
   }

   private void method00014(HudElement var1) {
      String var2 = "hud.settings." + var1.method06462().toLowerCase();
      if (this.field00077.method09669(var2) == null) {
         ModuleContextMenu.field21943.putIfAbsent(var2, "Настройки " + var1.method06462());
         ModuleBindingSettingsWindow var3 = new ModuleBindingSettingsWindow(var2, var1);
         float var4 = var1.method06446();
         float var5 = GuiScaleUtils.method06753();
         float var6 = GuiScaleUtils.method06754();
         float var7 = var3.method09568();
         float var8 = var3.method04683();
         float var9 = var1.method06436() * var4;
         float var10 = var1.method06464() * var4;
         float var11 = var1.method06458() * var4;
         float var12 = var9 + var11 + field00078;
         if (var12 + var7 > var5) {
            var12 = var9 - var7 - field00079;
         }

         if (var12 + var7 > var5) {
            var12 = var5 - var7 - 2.0F;
         }

         if (var12 < 2.0F) {
            var12 = 2.0F;
         }

         float var13 = var10;
         if (var13 + var8 > var6) {
            var13 = var6 - var8 - 2.0F;
         }

         if (var13 < 2.0F) {
            var13 = 2.0F;
         }

         this.field00077.method09652(var3, var12, var13);
      }
   }

   @Override
   public void method00015(SplashPotionEffectsEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00015(var1);
         }
      }
   }

   public ModuleContextMenu method00016() {
      return this.field00077;
   }

   public <T extends HudElement> T method00017(Class<T> var1) {
      return (T)(Object)var1.cast(this.field00075.get(var1));
   }

   @Override
   public void method00018() {
      for (HudElement var2 : this.field00076) {
         if (var2.method06457()) {
            var2.method00018();
         }
      }

      for (FloatingWindow var4 : new ArrayList<>(this.field00077.method09655())) {
         this.field00077.method09654(var4);
      }
   }

   @Override
   public void method00019(int var1, int var2, int var3) {
      this.field00077.method09670(var1, var2, var3);

      for (HudElement var5 : this.field00076) {
         if (var5.method06457()) {
            var5.method00019(var1, var2, var3);
         }
      }
   }

   @Override
   public void method00020(HotbarRenderEvent var1) {
      if (var1.method09179() != HotbarRenderEvent.Nested254.END) {
         for (HudElement var3 : this.field00076) {
            if (var3.method06457()) {
               var3.method00020(var1);
            }
         }
      }
   }

   @Override
   public void method00021(PreMovementPacketEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00021(var1);
         }
      }
   }

   public void method00022(GuiGraphicsExtractor var1, float var2, float var3) {
      Matrix3x2fStack var4 = var1.pose();
      ItemRenderUtils.method08410();
      GuiRenderBatch.method05194();

      for (HudElement var6 : this.field00076) {
         if (var6.method06457()) {
            float var7 = var6.method06446();
            var4.pushMatrix();
            var4.scale(var7, var7);
            var6.method00027(var1);
            var4.popMatrix();
         }
      }

      GuiRenderBatch.method05181();
      ItemRenderUtils.method08420();
      GuiClipStack.method00343();
      this.field00077.method09659(var1, (int)var2, (int)var3, 1.0F);
      GuiClipStack.method00342();
   }

   @Override
   public void method00023(HudElement var1) {
      this.field00076.add(var1);
      this.field00075.put((Class<? extends HudElement>)var1.getClass(), var1);
   }

   @Override
   public void method00024() {
      for (HudElement var2 : this.field00076) {
         if (var2.method06457()) {
            var2.method00024();
         }
      }
   }

   @Override
   public void method00025(int var1, float var2, float var3) {
      this.field00077.method09653(var2, var3, var1);
      if (!this.field00077.method09668(var2, var3)) {
         for (HudElement var5 : this.field00076) {
            if (var5.method06457()) {
               float var6 = var5.method06440(var2);
               float var7 = var5.method06440(var3);
               if (var1 == 1 && var5.method06444(var6, var7) && !var5.method03026().isEmpty()) {
                  this.method00014(var5);
                  return;
               }

               var5.method00025(var1, var6, var7);
            }
         }
      }
   }

   @Override
   public void method00026(AttackEntityEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00026(var1);
         }
      }
   }

   @Override
   public void method00027(GuiGraphicsExtractor var1) {
      float var2 = (float)(mc.mouseHandler.xpos() / mc.getWindow().getGuiScale());
      float var3 = (float)(mc.mouseHandler.ypos() / mc.getWindow().getGuiScale());
      this.method00022(var1, var2, var3);
   }

   public List<HudElement> method00028() {
      return this.field00076;
   }

   @Override
   public void method00029(EntityDeathEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00029(var1);
         }
      }
   }

   @Override
   public void method00030(double var1, double var3, double var5) {
      this.field00077.method09651(var1, var3, var5);

      for (HudElement var8 : this.field00076) {
         if (var8.method06457()) {
            var8.method00030(var8.method06443(var1), var8.method06443(var3), var5);
         }
      }
   }

   @Override
   public void method00031(int var1, float var2, float var3) {
      this.field00077.method09664(var2, var3, var1);

      for (HudElement var5 : this.field00076) {
         if (var5.method06457()) {
            var5.method00031(var1, var5.method06440(var2), var5.method06440(var3));
         }
      }
   }

   @Override
   public void method00032(PacketEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00032(var1);
         }
      }
   }

   public HudManager() {
      this.method00023(new ItemHelperHud());
      this.method00023(new NotificationHud());
      this.method00023(new SchedulesHud());
      this.method00023(new InformationHud());
      this.method00023(new TargetHud());
      this.method00023(new StaffListHud());
      this.method00023(new WaterMarkHud());
      this.method00023(new ArmorHud());
      this.method00023(new ModuleArrayListHud());
      this.method00023(new CoolDownsHud());
      this.method00023(new HotKeysHud());
      this.method00023(new KillFeedHud());
      this.method00023(new PotionsHud());
      this.method00023(new MediaPlayerHud());
   }

   @Override
   public void method00033(ItemUseStartEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00033(var1);
         }
      }
   }

   @Override
   public void method00034(TickEvent var1) {
      Hud var2 = ModuleManager.INSTANCE.method08274();

      for (HudElement var4 : this.field00076) {
         var4.method06451(var2.method04958().method04520(var4.method06462()));
         if (var4.method06457()) {
            var4.method00034(var1);
         }
      }
   }

   public Map<Class<? extends HudElement>, HudElement> method00035() {
      return this.field00075;
   }

   @Override
   public void method00036(TotemPopEvent var1) {
      for (HudElement var3 : this.field00076) {
         if (var3.method06457()) {
            var3.method00036(var1);
         }
      }
   }
}
