// Original binary: sg/ec/8OviS26ZGP2qppN7
package sg.ec;

import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ScriptSettingsWindow extends ScrollableWindow {
   private static final String field04581 = "scripts.settings.";
   private static final String field04582 = "field04582";
   private static final float field04583 = 0;
   private static final float field04584 = 0;
   private static final float field04585 = 0;
   private static final float field04586 = 0;
   private final LoadedScript field04587;
   private final List<SettingComponent<?>> field04588;
   private final List<ScrollableWindow.Nested257> field04589;
   private final ScrollController field04590 = new ScrollController();
   private float field04591;
   private static final String field04592 = "Настройки скрипта";
   private static final float field04593 = 115.0F;
   private static final float field04594 = 200.0F;
   private static final float field04595 = 115.0F;
   private static final float field04596 = 12.0F;
   private static final float field04597 = 12.0F;
   private static final float field04598 = 200.0F;
   private static final float field04599 = 21.0F;
   private static final float field04600 = 6.0F;
   private static final float field04601 = 0.01F;

   @Override
   protected void method01894(GuiGraphicsExtractor var1, int var2, int var3) {
      this.field04590.method01152(this.field04591 > this.field21185.method02802());
      this.field04590.method01145();
      this.field04590.method01134(this.field04591, this.field21185.method02802());
      float var4 = this.field21185.method02808();
      float sx = var4 + this.field21185.method02802();
      var1.enableScissor((int)this.method09576(), (int)var4, (int)Math.ceil(this.method09576() + this.method09568()), (int)Math.ceil(sx));
      float sxx = 2.0F + this.field04590.method01136();

      for (SettingComponent sxxx : this.field04588) {
         if (!method01896(sxxx)) {
            float sxxxx = sxxx.method10979().method06173();
            sxxx.method09789(this.field21185.method02809());
            sxxx.method09788(var4 + sxx);
            sxxx.method09781(this.field21185.method02804());
            sxxx.method09783(this.field21186 * sxxxx);
            sxxx.method00042(var1, var2, var3, this.field21186);
            sxx += sxxx.method09785() * sxxxx;
         }
      }

      var1.disableScissor();
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      for (SettingComponent var5 : this.field04588) {
         var5.method00250(var1, var2, var3);
      }
   }

   public LoadedScript method01895() {
      return this.field04587;
   }

   public ScriptSettingsWindow(LoadedScript var1) {
      super(var1.method03400(), method01902(var1), field04592, field04593, field04594);
      this.field04587 = var1;
      this.field04588 = SettingsWindow.method04679(var1.method03398().method03932(), this);
      this.field04589 = List.of(this.method09311());
   }

   private static boolean method01896(SettingComponent<?> var0) {
      return !var0.method10977().method03019() && var0.method10979().method06173() < field04601;
   }

   @Override
   protected List<ScrollableWindow.Nested257> method01897() {
      return this.field04589;
   }

   @Override
   public void method01898(char var1, int var2) {
      for (SettingComponent var4 : this.field04588) {
         var4.method03946(var1, var2);
      }
   }

   @Override
   protected void method01899(double var1, double var3, double var5) {
      for (SettingComponent var8 : this.field04588) {
         if (!method01896(var8) && var8 instanceof NumberSettingComponent var9 && var9.method04527(var1, var3, var5)) {
            return;
         }
      }

      this.field04590.method01133(var5);
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      super.method01689(var1, var3, var5);

      for (SettingComponent var7 : this.field04588) {
         if (!method01896(var7)) {
            var7.method02632(var1, var3, var5);
         }
      }
   }

   @Override
   protected void method01900() {
      float var1 = field04595;

      for (SettingComponent var3 : this.field04588) {
         if (!method01896(var3)) {
            var1 = Math.max(var1, var3.method10978() + field04596);
         }
      }

      this.method08971(var1);
      this.field04591 = 2.0F;

      for (SettingComponent var5 : this.field04588) {
         if (!method01896(var5)) {
            var5.method09781(var1 - field04597);
            var5.method03443();
            this.field04591 = this.field04591 + var5.method09785() * var5.method10979().method06173();
         }
      }

      this.method09561(Math.min(field04598, field04599 + this.field04591 + field04600));
      this.method09557(this.method09569() && TextAreaSettingComponent.method08859());
   }

   @Override
   protected void method01901(double var1, double var3, int var5) {
      for (SettingComponent var7 : this.field04588) {
         if (!method01896(var7) && !var7.method00251(var1, var3, var5)) {
            var7.method00040(var1, var3, var5);
         }
      }
   }

   public static String method01902(LoadedScript var0) {
      return "scripts.settings." + var0.method03400();
   }
}
