// Original binary: sg/ec/90Fj1Xd5GjraP16n
package sg.ec;

import java.awt.Color;
import net.minecraft.client.CameraType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.phys.EntityHitResult;

// $VF: Compiled from s
public class Crosshair extends ClientModule {
   private static final float field05120 = 0.5F;
   private final NumberSetting<Float> field05121;
   private final NumberSetting<Float> field05122;
   private final NumberSetting<Float> field05123;
   private final ToggleSetting field05124;
   private final NumberSetting<Float> field05125;
   private final ToggleSetting field05126;
   private final ColorSetting field05127;
   private final ColorSetting field05128;
   private boolean field05129;
   private final SmoothAnimation field05130;
   private static final String field05131 = "Ширина";
   private static final float field05132 = 5.0F;
   private static final float field05133 = 0.1F;
   private static final String field05134 = "Длина";
   private static final float field05135 = 5.0F;
   private static final float field05136 = 0.1F;
   private static final String field05137 = "Пробел";
   private static final float field05138 = 5.0F;
   private static final float field05139 = 0.1F;
   private static final String field05140 = "Динамический";
   private static final String field05141 = "Сила расширения";
   private static final float field05142 = 10.0F;
   private static final float field05143 = 0.1F;
   private static final String field05144 = "Менять цвет при наведении";
   private static final String field05145 = "Цвет";
   private static final String field05146 = "Цвет при наведении";
   private static final String field05147 = "Crosshair";
   private static final double field05148 = 0.1F;
   private static final float field05149 = 0.5F;
   private static final float field05150 = 0.5F;
   private static final float field05151 = 0.5F;
   private static final float field05152 = 0.5F;

   public Crosshair() {
      super(ModuleCategory.Render, ModuleSubCategory.Interface);
      this.field05121 = new NumberSetting<Float>(field05131)
         .method10835(1.0F)
         .method10838(field05132)
         .method10834(field05133)
         .method03017(1.0F)
         .method03023(this);
      this.field05122 = new NumberSetting<Float>(field05134)
         .method10835(1.0F)
         .method10838(field05135)
         .method10834(field05136)
         .method03017(1.0F)
         .method03023(this);
      this.field05123 = new NumberSetting<Float>(field05137)
         .method10835(1.0F)
         .method10838(field05138)
         .method10834(field05139)
         .method03017(1.0F)
         .method03023(this);
      this.field05124 = new ToggleSetting(field05140).method03017(false).method03023(this);
      this.field05125 = new NumberSetting<Float>(field05141)
         .method10835(1.0F)
         .method10838(field05142)
         .method10834(field05143)
         .method03017(1.0F)
         .method03025(this.field05124::method03022)
         .method03023(this);
      this.field05126 = new ToggleSetting(field05144).method03017(false).method03023(this);
      this.field05127 = new ColorSetting(field05145).method03017(new Color(ColorUtils.method04604(255, 255, 255))).method03023(this);
      this.field05128 = new ColorSetting(field05146)
         .method03017(new Color(ColorUtils.method04604(255, 255, 255)))
         .method03025(this.field05126::method03022)
         .method03023(this);
      this.field05129 = false;
      this.field05130 = new SmoothAnimation();
      this.method03935(field05147);
   }

   private void method02152(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      this.method02155(var1, var2 - field05151, var3 - field05152, var4 + 1.0F, var5 + 1.0F, var7);
      this.method02155(var1, var2, var3, var4, var5, var6);
   }

   private static float method02153(float var0, float var1, float var2) {
      return var0 + (1.0F - var1) * var2;
   }

   @Subscribe
   private void method02154(CrosshairRenderEvent var1) {
      if (mc.options.getCameraType() == CameraType.FIRST_PERSON) {
         if (mc.player != null) {
            GuiGraphicsExtractor var2 = var1.method08629();
            this.field05130.method06162();
            this.field05130.method06166(this.field05129 ? 1.0 : 0.0, field05148);
            float var3 = this.field05123.method03022();
            float var4 = this.field05121.method03022();
            float var5 = this.field05122.method03022();
            float var6 = mc.getWindow().getGuiScaledWidth() / 2.0F - field05149;
            float var7 = mc.getWindow().getGuiScaledHeight() / 2.0F - field05150;
            int var8 = ColorUtils.method04627(this.field05128.method11676(), this.field05127.method11676(), this.field05130.method06173());
            int var9 = ColorUtils.method04604(0, 0, 0);
            if (this.field05124.method05999()) {
               var3 = method02153(var3, mc.player.getAttackStrengthScale(var1.method08625().getGameTimeDeltaPartialTick(true)), this.field05125.method03022());
            }

            float var10 = var4 / 2.0F;
            this.method02152(var2, var6 - var3 - var5, var7 - var10, var5, var4, var8, var9);
            this.method02152(var2, var6 + var3, var7 - var10, var5, var4, var8, var9);
            this.method02152(var2, var6 - var10, var7 - var3 - var5, var4, var5, var8, var9);
            this.method02152(var2, var6 - var10, var7 + var3, var4, var5, var8, var9);
            var1.method05696();
         }
      }
   }

   public void method02155(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, int var6) {
      RoundedRectRenderer.method01272(var1, var2, var3, var4, var5, 0.0F, 0.0F, var6);
   }

   @Subscribe
   private void method02156(PlayerUpdateEvent var1) {
      this.field05129 = false;
      if (this.field05126.method05999() && mc.hitResult instanceof EntityHitResult var2 && var2.getEntity() != null) {
         this.field05129 = true;
      }
   }
}
