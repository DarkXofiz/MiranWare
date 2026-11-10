// Original binary: sg/ec/n5hsaarn4xm8kzg8
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.NativeImage.Format;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.SafetyScreen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public class MainMenuScreen extends Screen implements MinecraftAccess {
   private static final float field21839 = 168.0F;
   private static final float field21840 = 0;
   private static final float field21841 = 0;
   private static final float field21842 = 0;
   private static final float field21843 = 0;
   private static final float field21844 = 0;
   private static final float field21845 = 0;
   private static final float field21846 = 0;
   private static final float field21847 = 0;
   private static final String field21848 = "field21848";
   private static boolean field21849 = false;
   private static Identifier field21850;
   private static Identifier miranLogo;
   private static boolean miranLogoTried = false;
   private static long miranLogoStart = 0L;
   private static final float MIRAN_LOGO_W = 122.0F;
   private static final float MIRAN_LOGO_H = 47.0F;
   private final List<MainMenuScreen.Nested267> field21851 = new ArrayList<>();
   private float field21852;
   private float field21853;
   private float field21854;
   private static final String field21855 = "MiranWare";
   private static final String field21856 = "Одиночная игра";
   private static final String field21857 = "Сетевая игра";
   private static final String field21858 = "Настройки";
   private static final String field21859 = "Аккаунты";
   private static final String field21860 = "Выйти";
   private static final String field21861 = "pictures/mainmenu/mainmenu.jpg";
   private static final String field21862 = "dynamic/mainmenu/background";
   private static final String field21863 = "Hex";
   private static final float field21864 = 57.0F;
   private static final float field21865 = 24.0F;
   private static final float field21866 = 6.0F;
   private static final float field21867 = 11.0F;
   private static final float field21868 = 168.0F;
   private static final float field21869 = 11.0F;
   private static final float field21870 = 46.0F;
   private static final float field21871 = 30.0F;
   private static final float field21872 = 168.0F;
   private static final float field21873 = 10.0F;
   private static final float field21874 = 5.0F;
   private static final float field21875 = 15.0F;
   private static final float field21876 = 168.0F;
   private static final float field21877 = 10.0F;
   private static final float field21878 = 5.0F;
   private static final float field21879 = 0.62F;
   private static final float field21880 = 0.62F;
   private static final float field21881 = 0.62F;
   private static final float field21882 = 0.62F;
   private static final String field21883 = "Miran";
   private static final float field21884 = 30.0F;
   private static final float field21885 = 0.05F;
   private static final float field21886 = 30.0F;
   private static final float field21887 = 168.0F;
   private static final float field21888 = 11.0F;
   private static final float field21889 = 46.0F;
   private static final String field21890 = "Miran";
   private static final float field21891 = 30.0F;
   private static final float field21892 = 0.05F;
   private static final float field21893 = 11.0F;
   private static final float field21894 = 146.0F;
   private static final float field21895 = 24.0F;
   private static final double field21896 = 0.15F;
   private static final float field21897 = 0.06F;
   private static final float field21898 = 0.3F;
   private static final float field21899 = 146.0F;
   private static final float field21900 = 24.0F;
   private static final float field21901 = 6.0F;
   private static final float field21902 = 11.0F;
   private static final float field21903 = 146.0F;
   private static final float field21904 = 24.0F;
   private static final float field21905 = 11.0F;
   private static final float field21906 = 146.0F;
   private static final float field21907 = 24.0F;

   private static void ensureMiranLogo() {
      if (miranLogoTried) {
         return;
      }

      miranLogoTried = true;
      miranLogoStart = System.nanoTime();

      try (InputStream in = MainMenuScreen.class.getResourceAsStream("/assets/miranware/miran_logo.png")) {
         if (in == null) {
            return;
         }

         NativeImage img = readImage(in.readAllBytes());
         Identifier id = Identifier.fromNamespaceAndPath("miranware", "dynamic/mainmenu/miran_logo");
         mc.getTextureManager().register(id, new DynamicTexture(() -> "miranware logo", img));
         miranLogo = id;
      } catch (Throwable ignored) {
         miranLogo = null;
      }
   }

   private static int tint(int rgb, float alpha) {
      int a = Math.max(0, Math.min(255, Math.round(alpha * 255.0F)));
      return a << 24 | rgb & 0xFFFFFF;
   }

   private void drawAnimatedLogo(GuiGraphics g) {
      float t = (System.nanoTime() - miranLogoStart) / 1.0E9F;
      float fade = Math.min(1.0F, t / 1.4F);
      fade = fade * fade * (3.0F - 2.0F * fade);
      float breathe = (float)(Math.sin(t * 2.1) * 0.5 + 0.5);
      float bob = (float)Math.sin(t * 1.5) * 2.0F;
      float cx = this.field21852 + field21887 / 2.0F;
      float cy = this.field21853 + field21888 + field21889 / 2.0F + bob;
      float pop = 0.82F + 0.18F * fade;

      // soft pulsing glow layers
      for (int i = 3; i >= 1; i--) {
         float gs = pop * (1.0F + 0.07F * i + 0.03F * breathe);
         float w = MIRAN_LOGO_W * gs;
         float h = MIRAN_LOGO_H * gs;
         float ga = (0.05F + 0.09F * breathe) * fade / i;
         GuiTextureRenderer.method10259(g, miranLogo, cx - w / 2.0F, cy - h / 2.0F, w, h, tint(0x35A8FF, ga));
      }

      // main logo, gently breathing, colour drifts between blue and cyan
      float s = pop * (1.0F + 0.025F * breathe);
      float w = MIRAN_LOGO_W * s;
      float h = MIRAN_LOGO_H * s;
      int r = Math.round(200.0F + 55.0F * (1.0F - breathe));
      int gg = Math.round(225.0F + 30.0F * breathe);
      int rgb = r << 16 | gg << 8 | 255;
      GuiTextureRenderer.method10259(g, miranLogo, cx - w / 2.0F, cy - h / 2.0F, w, h, tint(rgb, fade));
   }

   private void drawLogo(GuiGraphics var1) {
      ensureMiranLogo();
      if (miranLogo != null) {
         this.drawAnimatedLogo(var1);
         return;
      }

      FontRenderer var2 = Fonts.field00107;
      if (var2 != null) {
         float sx = var2.method09478(field21883, field21884, field21885);
         float sxx = var2.method09485(field21886);
         float sxxx = this.field21852 + (field21887 - sx) / 2.0F;
         float sxxxx = this.field21853 + field21888 + (field21889 - sxx) / 2.0F;
         CornerColors sxxxxx = new CornerColors(
            ColorUtils.Nested138.method04635(0, 1.0F),
            ColorUtils.Nested138.method04635(90, 1.0F),
            ColorUtils.Nested138.method04635(180, 1.0F),
            ColorUtils.Nested138.method04635(270, 1.0F)
         );
         var2.method09482(var1, field21890, sxxx, sxxxx, sxxxxx, field21891, field21892);
      }
   }

   private static void ensureTextures() {
      if (!field21849) {
         field21850 = register(field21861, field21862);
         if (field21850 != null) {
            field21849 = true;
         }
      }
   }

   private void layout(float var1, float var2) {
      this.field21854 = field21864 + this.field21851.size() * field21865 + (this.field21851.size() - 1) * field21866 + field21867;
      this.field21852 = (var1 - field21868) / 2.0F;
      this.field21853 = (var2 - this.field21854) / 2.0F;
      float var3 = this.field21853 + field21869 + field21870;

      for (int var4 = 0; var4 < this.field21851.size(); var4++) {
         this.field21851.get(var4).field21911 = var3 + var4 * field21871;
      }
   }

   private void drawPanel(GuiGraphics var1) {
      int var2 = ColorUtils.method04604(20, 20, 24);
      int var3 = ColorUtils.method04604(10, 10, 13);
      GuiClipStack.method00341(var1, this.field21852, this.field21853, field21872, this.field21854, field21873, field21874, field21875, 1.0F);
      RoundedRectRenderer.method01275(
         var1,
         this.field21852,
         this.field21853,
         field21876,
         this.field21854,
         field21877,
         field21878,
         new CornerColors(
            ColorUtils.method04611(var2, field21879),
            ColorUtils.method04611(var3, field21880),
            ColorUtils.method04611(var3, field21881),
            ColorUtils.method04611(var2, field21882)
         )
      );
   }

   @Override
   public boolean isPauseScreen() {
      return false;
   }

   private void drawButton(GuiGraphics var1, MainMenuScreen.Nested267 var2, int var3, int var4) {
      float var5 = this.field21852 + field21893;
      float var6 = var2.field21911;
      boolean var7 = var3 >= var5 && var3 <= var5 + field21894 && var4 >= var6 && var4 <= var6 + field21895;
      var2.field21910.method06162();
      var2.field21910.method06168(var7 ? 1.0 : 0.0, field21896, Easings.field19394, true);
      float var8 = var2.field21910.method06173();
      float var9 = field21897 + field21898 * var8;
      int var10 = ColorUtils.method04604(72, 72, 80);
      int var11 = ColorUtils.method04604(40, 40, 46);
      RoundedRectRenderer.method01275(
         var1,
         var5,
         var6,
         field21899,
         field21900,
         field21901,
         2.0F,
         new CornerColors(
            ColorUtils.method04611(var10, var9),
            ColorUtils.method04611(var11, var9),
            ColorUtils.method04611(var11, var9),
            ColorUtils.method04611(var10, var9)
         )
      );
      FontRenderer var12 = Fonts.field00110;
      if (var12 != null) {
         float var13 = field21902;
         float var14 = 0.0F;
         float var15 = var12.method09478(var2.field21908, var13, var14);
         float var16 = var5 + (field21903 - var15) / 2.0F;
         float var17 = var6 + (field21904 - var12.method09485(var13)) / 2.0F;
         int var18 = ColorUtils.method04631(
            ColorUtils.method04597(255, 255, 255, 150), ColorUtils.method04597(255, 255, 255, 235), var8
         );
         var12.method09490(var1, var2.field21908, var16, var17, var18, var13, var14);
      }
   }

   @Override
   public boolean mouseClicked(MouseButtonEvent var1, boolean var2) {
      Vec2 var3 = GuiScaleUtils.method06746(var1.x(), var1.y());
      float var4 = var3.x;
      float var5 = var3.y;
      int var6 = InputCompat.glfwButton(var1.button());
      float var7 = GuiScaleUtils.method06753();
      float var8 = GuiScaleUtils.method06754();
      this.layout(var7, var8);
      float var9 = this.field21852 + field21905;
      if (var6 == 0) {
         for (MainMenuScreen.Nested267 var11 : this.field21851) {
            float var12 = var11.field21911;
            if (var4 >= var9 && var4 < var9 + field21906 && var5 >= var12 && var5 < var12 + field21907) {
               var11.field21909.run();
               return true;
            }
         }
      }

      return super.mouseClicked(var1, var2);
   }

   public MainMenuScreen() {
      super(Component.literal(field21855));
      ensureTextures();
      this.field21851.add(new MainMenuScreen.Nested267(field21856, () -> this.minecraft.gui.setScreen(new SelectWorldScreen(this))));
      this.field21851.add(new MainMenuScreen.Nested267(field21857, () -> {
         Screen var1 = this.minecraft.options.skipMultiplayerWarning ? new JoinMultiplayerScreen(this) : new SafetyScreen(this);
         this.minecraft.gui.setScreen(var1);
      }));
      this.field21851
         .add(new MainMenuScreen.Nested267(field21858, () -> this.minecraft.gui.setScreen(new OptionsScreen(this, this.minecraft.options))));
      this.field21851.add(new MainMenuScreen.Nested267(field21859, () -> AccountScreenCompatibility.method00792(this)));
      this.field21851.add(new MainMenuScreen.Nested267(field21860, () -> this.minecraft.stop()));
   }

   public static Identifier backgroundTexture() {
      ensureTextures();
      return field21850;
   }

   private static boolean fontsReady() {
      return Fonts.field00107 != null && Fonts.field00110 != null;
   }

   @Override
   public void extractBackground(GuiGraphics var1, int var2, int var3, float var4) {
   }

   @Override
   public void extractRenderState(GuiGraphics var1, int var2, int var3, float var4) {
      Vec2 var5 = GuiScaleUtils.method06746(var2, var3);
      var2 = (int)var5.x;
      var3 = (int)var5.y;
      GuiScaleUtils.method06750(var1);
      GuiRenderBatch.method05194();
      float var6 = GuiScaleUtils.method06753();
      float var7 = GuiScaleUtils.method06754();
      this.layout(var6, var7);
      RoundedRectRenderer.method01272(var1, 0.0F, 0.0F, var6, var7, 0.0F, 0.0F, ColorUtils.field10170);
      ensureTextures();
      if (field21850 != null) {
         GuiTextureRenderer.method10259(var1, field21850, 0.0F, 0.0F, var6, var7, -1);
      }

      GuiRenderBatch.method05183();
      if (fontsReady()) {
         this.drawPanel(var1);
         this.drawLogo(var1);

         for (MainMenuScreen.Nested267 var9 : this.field21851) {
            this.drawButton(var1, var9, var2, var3);
         }
      }

      GuiRenderBatch.method05181();
      GuiScaleUtils.method06748(var1);
   }

   @Override
   public boolean shouldCloseOnEsc() {
      return false;
   }

   private static Identifier register(String var0, String var1) {
      String var2 = field21863.toLowerCase();
      Identifier var3 = Identifier.fromNamespaceAndPath(var2, var0);
      Identifier var4 = Identifier.fromNamespaceAndPath(var2, var1);

      try (InputStream var5 = mc.getResourceManager().getResource(var3).orElseThrow().open()) {
         NativeImage var6 = readImage(var5.readAllBytes());
         mc.getTextureManager().register(var4, new DynamicTexture(() -> var1, var6));
         return var4;
      } catch (Exception var10) {
         return null;
      }
   }

   private static NativeImage readImage(byte[] var0) throws IOException {
      try {
         return NativeImage.read(new ByteArrayInputStream(var0));
      } catch (IOException var8) {
         BufferedImage var2 = ImageIO.read(new ByteArrayInputStream(var0));
         if (var2 == null) {
            throw var8;
         }

         int var3 = var2.getWidth();
         int var4 = var2.getHeight();
         int[] var5 = var2.getRGB(0, 0, var3, var4, null, 0, var3);
         NativeImage var6 = new NativeImage(Format.RGBA, var3, var4, true);

         for (int var7 = 0; var7 < var5.length; var7++) {
            var6.setPixel(var7 % var3, var7 / var3, var5[var7]);
         }

         return var6;
      }
   }

   // $VF: Compiled from s
   private static class Nested267 {
      private final String field21908;
      private final Runnable field21909;
      private final SmoothAnimation field21910 = new SmoothAnimation();
      private float field21911;

      private Nested267(String var1, Runnable var2) {
         this.field21908 = var1;
         this.field21909 = var2;
      }
   }
}
