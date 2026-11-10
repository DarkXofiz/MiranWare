// Original binary: sg/ec/6lpUI1UMzaaNGVga
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import org.joml.Vector2f;

// $VF: Compiled from s
public class WardenESP extends ClientModule {
   private static final String field03579 = "00:00";
   private static final float field03580 = 0;
   private static final float field03581 = 0;
   private static final float field03582 = 0;
   private static final float field03583 = 0;
   private static final float field03584 = 0;
   private static final float field03585 = 0;
   private static final float field03586 = 0;
   private static final float field03587 = 0;
   private static final float field03588 = 0;
   private static final float field03589 = 0;
   private static final float field03590 = 0;
   private static final float field03591 = 0;
   private static final float field03592 = 0;
   private static final float field03593 = 0;
   private static final float field03594 = 0;
   private static final float field03595 = 0;
   private static final float field03596 = 0;
   private static final float field03597 = 0;
   private static final long field03598 = 0;
   private static final long field03599 = 0;
   private final StringBuilder field03600 = new StringBuilder(5);
   private final WardenSpawnerTracker field03601 = new WardenSpawnerTracker();
   private final Vector2f field03602 = new Vector2f();
   private final WardenESP.Nested43 field03603 = new WardenESP.Nested43();
   private static final String field03604 = "Warden ESP";
   private static final String field03605 = "Показывает сундуки города варденов и таймер их возрождения.";
   private static final String field03606 = "00:00";
   private static final float field03607 = 7.0F;
   private static final float field03608 = 10.0F;
   private static final float field03609 = 7.0F;
   private static final float field03610 = 6.0F;
   private static final double field03611 = 0.5;
   private static final double field03612 = 0.5;
   private static final float field03613 = Float.MAX_VALUE;
   private static final double field03614 = 0.5;
   private static final float field03615 = 8.0F;
   private static final float field03616 = 3.0F;
   private static final float field03617 = 7.0F;
   private static final double field03618 = 8.0;
   private static final double field03619 = 0.01;
   private static final float field03620 = 0.7F;
   private static final float field03621 = 1.15F;
   private static final float field03622 = 8.0F;
   private static final float field03623 = -2.0F;
   private static final float field03624 = -2.0F;
   private static final float field03625 = 0.38F;
   private static final float field03626 = 5.0F;
   private static final float field03627 = -2.0F;
   private static final float field03628 = -2.0F;
   private static final float field03629 = -2.0F;
   private static final float field03630 = -2.0F;
   private static final float field03631 = -2.0F;
   private static final long field03632 = 10000L;
   private static final long field03633 = 700L;
   private static final double field03634 = 700.0;
   private static final double field03635 = Math.PI;
   private static final double field03636 = 2.0;
   private static final float field03637 = 0.5F;
   private static final float field03638 = 0.5F;
   private static final float field03639 = 0.35F;
   private static final long field03640 = 1000L;

   public List<BlockPos> method01480() {
      return this.field03601.method05348(mc.level, mc.player, PvpTimerUtils.method06499());
   }

   @Subscribe
   private void method01481(Render3DEvent var1) {
      var var2 = this.method01480();
      if (!var2.isEmpty()) {
         int var3 = ColorUtils.method04611(ColorUtils.Nested138.method04636(), field03639);

         for (BlockPos var5 : var2) {
            if (!this.field03601.method05359(var5)) {
               WorldBoxRenderer.method06958(new AABB(var5), var1.method00996(), var1.method00994(), var1.method00986(), var1.method00985(), var3);
            }
         }
      }
   }

   private static void method01482(GuiGraphics var0, float var1, float var2, float var3, WardenESP.Nested42 var4) {
      float var5 = 2.0F * var3;
      float var6 = var5 / 2.0F;
      float var7 = 1.0F * var3;
      float var8 = field03622 * var3;
      RoundedRectRenderer.method01272(var0, var1 - var6, var2 - var6, var5, var5, 0.0F, field03623, var4.accentStart);
      RoundedRectRenderer.method01275(
         var0,
         var1 - var7 / 2.0F,
         var2 - var6 - var8,
         var7,
         var8,
         0.0F,
         field03624,
         new CornerColors(var4.stemTop, var4.stemBottom, var4.stemBottom, var4.stemTop)
      );
   }

   private String method01483(long var1) {
      int var3 = (int)(var1 / field03640);
      this.field03600.setLength(0);
      this.method01484(var3 / 60).append(':');
      return this.method01484(var3 % 60).toString();
   }

   private StringBuilder method01484(int var1) {
      if (var1 < 10) {
         this.field03600.append('0');
      }

      return this.field03600.append(var1);
   }

   private void method01485(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7, WardenESP.Nested42 var8) {
      float var9 = var2 + var4 - var6;
      float var10 = var3 + var5 - var6;
      float var11 = var2 + var4 / 2.0F;
      RoundedRectRenderer.method01272(var1, var2, var3, var4, var6, 0.0F, field03628, var8.track);
      RoundedRectRenderer.method01272(var1, var2, var10, var4, var6, 0.0F, field03629, var8.track);
      RoundedRectRenderer.method01272(var1, var2, var3 + var6, var6, var5 - var6 * 2.0F, 0.0F, field03630, var8.track);
      RoundedRectRenderer.method01272(var1, var9, var3 + var6, var6, var5 - var6 * 2.0F, 0.0F, field03631, var8.track);
      float var12 = (var4 + var5) * 2.0F;
      this.field03603.method01492(var1, var12, var12 * var7, var6, var8);
      this.field03603.method01495(var11, var3, var4 / 2.0F, false);
      this.field03603.method01494(var9, var3, var5, false);
      this.field03603.method01495(var2 + var4, var10, var4, true);
      this.field03603.method01494(var2, var3 + var5, var5, true);
      this.field03603.method01495(var2, var3, var4 / 2.0F, false);
   }

   private static int method01486(long var0, WardenESP.Nested42 var2) {
      if (var0 > field03632) {
         return var2.text;
      }

      double var3 = System.currentTimeMillis() % field03633 / field03634 * field03635 * field03636;
      float var5 = field03637 + field03638 * (float)Math.sin(var3);
      return ColorUtils.method04627(var2.text, var2.accentStart, var5);
   }

   private static void method01487(
      GuiGraphics var0, float var1, float var2, float var3, float var4, float var5, float var6, WardenESP.Nested42 var7
   ) {
      int var8 = ColorUtils.method04611(var7.accentStart, field03625 * var6);
      GuiShadowRenderer.method10984(var0, var1, var2, var3, var4, 0.0F, 1.0F, field03626 * var5, var8);
      RoundedRectRenderer.method01272(var0, var1, var2, var3, var4, 0.0F, field03627, var7.plate);
   }

   public WardenESP() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.method03935(field03604);
      this.method03931(field03605);
   }

   @Subscribe
   private void method01488(HudRenderEvent var1) {
      var var2 = this.method01480();
      if (!var2.isEmpty()) {
         WorldProjectionUtils.method09450();
         GuiGraphics var3 = var1.method05424();
         PoseStack var4 = var1.method05425();
         FontRenderer var5 = Fonts.field00109;
         WardenESP.Nested42 var6 = WardenESP.Nested42.method01491(ThemeManager.INSTANCE.method09611());
         float var7 = var5.method09486(field03606, field03607) + field03608;
         float var8 = var5.method09485(field03609) + field03610;
         GuiRenderBatch.method05194();
         FontRenderer.method09475();

         for (BlockPos var10 : var2) {
            if (this.field03601.method05359(var10)) {
               double var11 = var10.getX() + field03611;
               double var13 = var10.getZ() + field03612;
               WorldProjectionUtils.method09454(var4, var11, var10.getY() + 1, var13, this.field03602);
               if (this.field03602.x != field03613) {
                  float var15 = this.method01489(var11, var10.getY() + field03614, var13);
                  float var16 = var7 * var15;
                  float var17 = var8 * var15;
                  float var18 = this.field03602.x - var16 / 2.0F;
                  float var19 = this.field03602.y - field03615 * var15 - var17;
                  long var20 = this.field03601.method05349(var10);
                  float var22 = Math.max(0.0F, Math.min(1.0F, this.field03601.method05356(var10)));
                  method01482(var3, this.field03602.x, this.field03602.y, var15, var6);
                  method01487(var3, var18, var19, var16, var17, var15, var22, var6);
                  this.method01485(var3, var18, var19, var16, var17, 1.0F * var15, var22, var6);
                  var5.method09473(var3, this.method01483(var20), this.field03602.x, var19 + field03616 * var15, method01486(var20, var6), field03617 * var15);
               }
            }
         }

         FontRenderer.method09484();
         GuiRenderBatch.method05181();
      }
   }

   private float method01489(double var1, double var3, double var5) {
      double var7 = Math.sqrt(mc.player.getEyePosition().distanceToSqr(var1, var3, var5));
      float var9 = (float)(field03618 / Math.max(var7, field03619));
      return Math.max(field03620, Math.min(field03621, var9));
   }

   public long method01490(BlockPos var1) {
      this.method01480();
      return this.field03601.method05349(var1);
   }

   // $VF: Compiled from s
   private record Nested42(int plate, int track, int text, int stemTop, int stemBottom, int accentStart, int accentEnd) {
      static WardenESP.Nested42 method01491(ThemeSettings var0) {
         int var1 = var0.field22107.method11676();
         int var2 = var0.method09800();
         return new WardenESP.Nested42(
            ColorUtils.method04611(var0.field22106.method11676(), 0.82F),
            ColorUtils.method04611(var1, 0.14F),
            var1,
            ColorUtils.method04611(var2, 0.45F),
            ColorUtils.method04611(var2, 0.0F),
            var2,
            var0.method09809()
         );
      }
   }

   // $VF: Compiled from s
   private static final class Nested43 {
      private GuiGraphics field03641;
      private WardenESP.Nested42 field03642;
      private float field03643;
      private float field03644;
      private float field03645;
      private float field03646;
      private static final float field03647 = -2.0F;
      private static final float field03648 = -2.0F;

      void method01492(GuiGraphics var1, float var2, float var3, float var4, WardenESP.Nested42 var5) {
         this.field03641 = var1;
         this.field03643 = var2;
         this.field03645 = var3;
         this.field03644 = var4;
         this.field03642 = var5;
         this.field03646 = 0.0F;
      }

      private float method01493(float var1) {
         float var2 = Math.min(var1, this.field03645);
         this.field03645 -= var2;
         return var2;
      }

      void method01494(float var1, float var2, float var3, boolean var4) {
         float var5 = this.method01493(var3);
         if (!(var5 <= 0.0F)) {
            int var6 = this.method01496(this.field03646);
            int var7 = this.method01496(this.field03646 + var5);
            float var8 = var4 ? var2 - var5 : var2;
            int var9 = var4 ? var7 : var6;
            int var10 = var4 ? var6 : var7;
            RoundedRectRenderer.method01275(
               this.field03641, var1, var8, this.field03644, var5, 0.0F, field03648, new CornerColors(var9, var10, var10, var9)
            );
            this.field03646 += var5;
         }
      }

      void method01495(float var1, float var2, float var3, boolean var4) {
         float var5 = this.method01493(var3);
         if (!(var5 <= 0.0F)) {
            int var6 = this.method01496(this.field03646);
            int var7 = this.method01496(this.field03646 + var5);
            float var8 = var4 ? var1 - var5 : var1;
            int var9 = var4 ? var7 : var6;
            int var10 = var4 ? var6 : var7;
            RoundedRectRenderer.method01275(
               this.field03641, var8, var2, var5, this.field03644, 0.0F, field03647, new CornerColors(var9, var9, var10, var10)
            );
            this.field03646 += var5;
         }
      }

      private int method01496(float var1) {
         return ColorUtils.method04627(this.field03642.accentStart, this.field03642.accentEnd, var1 / this.field03643);
      }
   }
}
