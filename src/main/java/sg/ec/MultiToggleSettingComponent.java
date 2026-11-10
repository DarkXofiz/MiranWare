// Original binary: sg/ec/y1aiPzBvBelUQPhs
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class MultiToggleSettingComponent extends SettingComponent<MultiToggleSetting> {
   private final FontRenderer field26345 = Fonts.field00110;
   private final float field26346;
   private final List<MultiToggleOptionComponent> field26347;
   private static final float field26348 = 7.0F;
   private static final float field26349 = 7.0F;
   private static final float field26350 = 5.0F;
   private static final float field26351 = 5.0F;
   private static final float field26352 = 2.75F;
   private static final float field26353 = 0.5F;
   private static final float field26354 = 5.0F;
   private static final float field26355 = 2.75F;
   private static final float field26356 = 0.5F;
   private static final float field26357 = 10.5F;
   private static final float field26358 = 7.0F;
   private static final float field26359 = 7.0F;
   private static final float field26360 = 10.0F;
   private static final float field26361 = 1.5F;
   private static final float field26362 = 7.0F;
   private static final float field26363 = 7.0F;
   private static final float field26364 = 1.5F;
   private static final float field26365 = 7.0F;
   private static final float field26366 = 7.0F;
   private static final float field26367 = 6.0F;

   public MultiToggleSettingComponent(MultiToggleSetting var1) {
      super(var1);
      this.field26346 = field26348;
      this.field26347 = new ArrayList<>();

      for (NamedOption var3 : var1.method03022()) {
         this.field26347.add(new MultiToggleOptionComponent(var1, var3));
      }
   }

   @Override
   public float method04887() {
      return Math.min(this.method09785(), this.field26345.method09485(field26366) * 2.0F + field26367);
   }

   private float method11528(boolean var1) {
      float var2 = this.field26345.method09485(field26349) + field26350;
      float var3 = this.method09784();
      ArrayList var4 = new ArrayList();

      for (MultiToggleOptionComponent var6 : this.field26347) {
         if (var6.method00772().method08075()) {
            var4.add(var6);
         }
      }

      while (!var4.isEmpty()) {
         float var12 = 0.0F;
         float var13 = 0.0F;
         ArrayList var7 = new ArrayList();

         for (MultiToggleOptionComponent var9 : (Iterable<MultiToggleOptionComponent>) (Iterable) var4) {
            float var10 = var9.method00774().method09486(var9.method00772().method08080(), var9.method00771()) + field26351;
            float var11 = var9.method00774().method09485(var9.method00771()) + field26352;
            var9.method09786(var11);
            if (!(var12 + var10 <= var3) && var12 != 0.0F) {
               var7.add(var9);
            } else {
               if (var1) {
                  var9.method09789(this.method09780() + var12);
                  var9.method09788(this.method09782() + var2);
                  var9.method09781(var10);
                  var9.method09783(this.method09790());
               }

               var12 += var10 + field26353;
               var13 = Math.max(var13, var11);
            }
         }

         if (var13 == 0.0F && !var7.isEmpty()) {
            MultiToggleOptionComponent var14 = (MultiToggleOptionComponent)var7.remove(0);
            float var15 = var14.method00774().method09486(var14.method00772().method08080(), var14.method00771()) + field26354;
            float var16 = var14.method00774().method09485(var14.method00771()) + field26355;
            var14.method09786(var16);
            if (var1) {
               var14.method09789(this.method09780());
               var14.method09788(this.method09782() + var2);
               var14.method09781(var15);
               var14.method09783(this.method09790());
            }

            var13 = var16;
         }

         var4 = var7;
         if (!var4.isEmpty()) {
            var2 += var13 + field26356;
         }
      }

      return field26357 + var2;
   }

   @Override
   public void method03443() {
      this.method09786(this.method11528(false));
   }

   @Override
   public float method10978() {
      float var1 = this.field26345.method09486(this.method10977().method03024(), field26358);
      int var2 = this.method10977().method04514();
      int var3 = this.method10977().method03022().size();
      String var4 = var2 + " из " + var3;
      float var5 = this.field26345.method09486(var4, field26359);
      return var1 + field26360 + var5;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      for (MultiToggleOptionComponent var7 : this.field26347) {
         if (var7.method00772().method08075()) {
            var7.method00040(var1, var3, var5);
         }
      }
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      this.field26345
         .method09480(
            var1,
            this.method10977().method03024(),
            this.method09780(),
            this.method09782() + field26361,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11676(), this.method09790()),
            field26362
         );
      int var5 = this.method10977().method04514();
      int var6 = this.method10977().method03022().size();
      String var7 = var5 + " из " + var6;
      this.field26345
         .method09480(
            var1,
            var7,
            this.method09780() + this.method09784() - this.field26345.method09486(var7, field26363),
            this.method09782() + field26364,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11676(), this.method09790()),
            field26365
         );
      float var8 = this.method11528(true);

      for (MultiToggleOptionComponent var10 : this.field26347) {
         if (var10.method00772().method08075()) {
            var10.method00042(var1, var2, var3, var4);
         }
      }

      this.method09786(var8);
   }
}
