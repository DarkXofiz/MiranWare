// Original binary: sg/ec/jh5hmmE5Moj03s8k
package sg.ec;

import java.util.Arrays;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ModuleArrayListHud extends HudElement {
   private static final String field20490 = "Render";
   private static final String field20491 = "field20491";
   private static final String field20492 = "field20492";
   private static final String field20493 = "field20493";
   private static final String field20494 = "field20494";
   private static final String field20495 = "field20495";
   private static final float field20496 = 0;
   private static final int field20497 = 0;
   private static final long field20498 = 0;
   private final NumberSetting<Float> field20499;
   private final NumberSetting<Integer> field20500;
   private final NumberSetting<Float> field20501;
   private final MultiToggleSetting field20502;
   private final DraggableElement field20503;
   private final SortableArrayList<ModuleArrayListHud.Nested250> field20504;
   private ToggleableModule[] field20505;
   private long[] field20506;
   private String[] field20507;
   private float[] field20508;
   private float field20509;
   private Object field20510;
   private float field20511;
   private float field20512;
   private float field20513;
   private static final String field20514 = "ArrayList";
   private static final String field20515 = "Размер шрифтов";
   private static final float field20516 = 7.0F;
   private static final float field20517 = 9.0F;
   private static final float field20518 = 0.1F;
   private static final float field20519 = 8.0F;
   private static final String field20520 = "Отступ градиента";
   private static final String field20521 = "Длина отступа";
   private static final float field20522 = 10.0F;
   private static final float field20523 = 13.0F;
   private static final float field20524 = 0.5F;
   private static final float field20525 = 10.0F;
   private static final String field20526 = "Рендерить категории";
   private static final String field20527 = "Render";
   private static final String field20528 = "Combat";
   private static final String field20529 = "Movement";
   private static final String field20530 = "Player";
   private static final String field20531 = "Misc";
   private static final String field20532 = "Scripts";
   private static final float field20533 = 5.0F;
   private static final float field20534 = 30.0F;
   private static final float field20535 = 10.0F;
   private static final float field20536 = 8.0F;
   private static final float field20537 = 10.0F;
   private static final float field20538 = 5.0F;
   private static final float field20539 = 15.0F;
   private static final float field20540 = 0.15F;
   private static final float field20541 = 5.0F;
   private static final float field20542 = 2.5F;
   private static final String field20543 = "Render";
   private static final String field20544 = "Combat";
   private static final String field20545 = "Movement";
   private static final String field20546 = "Player";
   private static final String field20547 = "Misc";
   private static final String field20548 = "Scripts";
   private static final int field20549 = Integer.MAX_VALUE;
   private static final long field20550 = 1048575L;
   private static final int field20551 = Integer.MAX_VALUE;
   private static final float field20552 = 0.01F;
   private static final float field20553 = 5.0F;

   @Override
   public void method00027(GuiGraphicsExtractor var1) {
      super.method00027(var1);
      float var2 = this.field20512;
      float sx = 0.0F;

      for (ModuleArrayListHud.Nested250 sxx : this.field20504) {
         sxx.anim.method03375(sxx.state ? 1.0 : 0.0);
         sx += var2 * sxx.anim.method03377();
      }

      this.method06459(this.field20503, this.field20511, sx);
      boolean sxx = this.method06445();
      float sxxx = this.field20513;
      float sxxxx = field20537;
      float sxxxxx = this.method06464();
      float sxxxxxx = 0.0F;
      float sxxxxxxx = 0.0F;

      for (ModuleArrayListHud.Nested250 sxxxxxxxx : this.field20504) {
         float sxxxxxxxxx = sxxxxxxxx.anim.method03377();
         float sxxxxxxxxxx = sxxxxxxxx.widthName + field20538;
         float sxxxxxxxxxxx = this.method09031(sxx, sxxxxxxxxxx);
         float sxxxxxxxxxxxx = sxxxxx + sxxxxxx;
         RoundedRectRenderer.method01272(
            var1,
            sxxxxxxxxxxx - sxxxx,
            sxxxxxxxxxxxx - sxxxx,
            sxxxxxxxxxx + sxxxx * 2.0F,
            var2 + sxxxx * 2.0F,
            field20539,
            sxxxx,
            ColorUtils.method04611(sxxxxxxxx.color, sxxxxxxxxx * field20540)
         );
         sxxxxxx += var2 * sxxxxxxxxx;
      }

      float sxxxxxxxx = this.method06455();

      for (ModuleArrayListHud.Nested250 sxxxxxxxxx : this.field20504) {
         float sxxxxxxxxxx = sxxxxxxxxx.anim.method03377();
         float sxxxxxxxxxxx = sxxxxxxxxx.widthName + field20541;
         float sxxxxxxxxxxxx = this.method09031(sxx, sxxxxxxxxxxx);
         float sxxxxxxxxxxxxx = sxxxxx + sxxxxxxx;
         int sxxxxxxxxxxxxxx = ColorUtils.method04611(this.method06460(), sxxxxxxxxxx * sxxxxxxxx);
         int sxxxxxxxxxxxxxxx = ColorUtils.method04611(sxxxxxxxxx.color, sxxxxxxxxxx);
         this.method06439(var1, sxxxxxxxxxxxx, sxxxxxxxxxxxxx, sxxxxxxxxxxx, var2, 0.0F, 0.0F, sxxxxxxxxxx);
         RoundedRectRenderer.method01272(var1, sxxxxxxxxxxxx, sxxxxxxxxxxxxx, sxxxxxxxxxxx, var2, 0.0F, 0.0F, sxxxxxxxxxxxxxx);
         field14601.method09490(
            var1, sxxxxxxxxx.name, sxxxxxxxxxxxx + field20542, sxxxxxxxxxxxxx + var2 / 2.0F - sxxx / 2.0F, sxxxxxxxxxxxxxxx, sxxx, -field14608
         );
         sxxxxxxx += var2 * sxxxxxxxxxx;
      }
   }

   private float method09030(int var1, String var2, float var3) {
      if (var1 >= this.field20507.length) {
         this.field20507 = Arrays.copyOf(this.field20507, Math.max(64, var1 << 1));
         this.field20508 = Arrays.copyOf(this.field20508, this.field20507.length);
      }

      if (this.field20507[var1] != var2) {
         this.field20507[var1] = var2;
         this.field20508[var1] = field14601.method09478(var2, var3, -field14608);
      }

      return this.field20508[var1];
   }

   @Override
   public void method00013(FrameDeltaEvent var1) {
      this.field20504.clear();
      float var2 = this.field20499.method03022();
      float var3 = this.field20501.method03022();
      int var4 = this.field20500.method03022();
      this.field20513 = var2;
      this.field20512 = var3;
      boolean var5 = this.field20502.method04520(field20543);
      boolean var6 = this.field20502.method04520(field20544);
      boolean var7 = this.field20502.method04520(field20545);
      boolean var8 = this.field20502.method04520(field20546);
      boolean var9 = this.field20502.method04520(field20547);
      boolean var10 = this.field20502.method04520(field20548);
      if (var2 != this.field20509 || field14601 != this.field20510) {
         this.field20509 = var2;
         this.field20510 = field14601;
         Arrays.fill(this.field20507, null);
      }

      int var11 = 0;
      int var12 = 0;

      for (ToggleableModule var14 : ModuleManager.INSTANCE.method05138()) {
         int var15 = var12++;
         var14.method03927().method03375(var14.method03937() ? 1.0 : 0.0);

         boolean var16 = switch (var14.method03938()) {
            case Render -> var5;
            case Combat -> var6;
            case Movement -> var7;
            case Player -> var8;
            case Misc -> var9;
            case Scripts -> var10;
            case Configs, Themes, Friends, Bots, AutoBuy -> false;
         };
         if (var16) {
            if (var11 == this.field20505.length) {
               this.field20505 = Arrays.copyOf(this.field20505, var11 << 1);
               this.field20506 = Arrays.copyOf(this.field20506, var11 << 1);
            }

            this.field20505[var11] = var14;
            this.field20506[var11] = (long)(field20549 - Float.floatToIntBits(this.method09030(var15, var14.method03925(), var2))) << 20 | var11;
            var11++;
         }
      }

      Arrays.sort(this.field20506, 0, var11);
      float var21 = 0.0F;
      float var22 = 0.0F;

      for (int var23 = 0; var23 < var11; var23++) {
         long var24 = this.field20506[var23];
         ToggleableModule var18 = this.field20505[(int)(var24 & field20550)];
         float var19 = Float.intBitsToFloat(field20551 - (int)(var24 >>> 20));
         float var20 = var18.method03927().method03377();
         if (var20 > field20552) {
            this.field20504
               .add(
                  new ModuleArrayListHud.Nested250(
                     var18.method03937(), var18.method03925(), var18.method03927(), var19, ColorUtils.method04621(Math.round((var22 + 1.0F) * var4))
                  )
               );
            var21 = Math.max(var21, var19);
         }

         var22 += var20;
      }

      Arrays.fill(this.field20505, 0, var11, null);
      this.field20511 = var21 + field20553;
   }

   public ModuleArrayListHud() {
      super(field20514);
      this.field20499 = new NumberSetting<Float>(field20515)
         .method10835(field20516)
         .method10838(field20517)
         .method10834(field20518)
         .method03017(field20519)
         .method03023(this);
      this.field20500 = new NumberSetting<Integer>(field20520).method10835(5).method10838(50).method10834(1).method03017(10).method03023(this);
      this.field20501 = new NumberSetting<Float>(field20521)
         .method10835(field20522)
         .method10838(field20523)
         .method10834(field20524)
         .method03017(field20525)
         .method03023(this);
      this.field20502 = new MultiToggleSetting(field20526)
         .method04517(NamedOption.method08077(field20527, false))
         .method04517(NamedOption.method08077(field20528, true))
         .method04517(NamedOption.method08077(field20529, true))
         .method04517(NamedOption.method08077(field20530, true))
         .method04517(NamedOption.method08077(field20531, false))
         .method04517(NamedOption.method08077(field20532, true))
         .method04521(1)
         .method03023(this);
      this.field20503 = this.method06449(this, field20533, field20534);
      this.field20504 = new SortableArrayList<>();
      this.field20505 = new ToggleableModule[64];
      this.field20506 = new long[64];
      this.field20507 = new String[64];
      this.field20508 = new float[64];
      this.field20509 = Float.NaN;
      this.field20512 = field20535;
      this.field20513 = field20536;
   }

   private float method09031(boolean var1, float var2) {
      return var1 ? this.method06436() + this.method06458() - var2 : this.method06436();
   }

   // $VF: Compiled from s
   private record Nested250(boolean state, String name, AnimationUtils anim, float widthName, int color) {
   }
}
