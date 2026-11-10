// Original binary: sg/ec/FohUeWGf7EUUhceh
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class ActionListSettingComponent extends SettingComponent<ActionListSetting> {
   private final FontRenderer field07630 = Fonts.field00110;
   private final FontRenderer field07631 = Fonts.field00111;
   private static final float field07632 = 7.0F;
   private static final float field07633 = 0;
   private static final float field07634 = 0;
   private static final float field07635 = 0;
   private static final float field07636 = 0;
   private final List<ActionOptionComponent> field07637 = new ArrayList<>();
   private static final float field07638 = 7.0F;
   private static final float field07639 = 5.0F;
   private static final float field07640 = 6.0F;
   private static final float field07641 = 5.0F;
   private static final float field07642 = 6.0F;
   private static final float field07643 = 2.75F;
   private static final float field07644 = 0.5F;
   private static final float field07645 = 0.5F;
   private static final float field07646 = 10.5F;
   private static final float field07647 = 1.5F;
   private static final float field07648 = 7.0F;
   private static final float field07649 = 7.0F;
   private static final float field07650 = 5.0F;
   private static final float field07651 = 6.0F;
   private static final float field07652 = 5.0F;
   private static final float field07653 = 6.0F;
   private static final float field07654 = 2.75F;
   private static final float field07655 = 0.5F;
   private static final float field07656 = 6.0F;
   private static final float field07657 = 0.5F;
   private static final float field07658 = 10.5F;

   @Override
   public void method00042(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      this.field07630
         .method09480(
            var1,
            this.method10977().method03024(),
            this.method09780(),
            this.method09782() + field07647,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11676(), this.method09790()),
            field07648
         );
      float var5 = 0.0F;
      float sx = this.field07630.method09485(field07649) + field07650;

      for (ActionOptionComponent sxx : this.field07637) {
         float sxxx = Math.min(this.method09784(), this.field07631.method09486(sxx.method01431(), field07651) + field07652);
         float sxxxx = this.field07631.method09485(field07653) + field07654;
         if (var5 + sxxx > this.method09784()) {
            var5 = 0.0F;
            sx += sxxxx + field07655;
         }

         sxx.method09789(this.method09780() + var5);
         sxx.method09788(this.method09782() + sx);
         sxx.method09781(sxxx);
         sxx.method09786(sxxxx);
         sxx.method09783(this.method09790());
         sxx.method01430(this.field07631, field07656, false);
         sxx.method00042(var1, var2, var3, var4);
         var5 += sxxx + field07657;
      }

      this.method09786(field07658 + sx);
   }

   public ActionListSettingComponent(ActionListSetting var1) {
      super(var1);

      for (NamedOption var3 : var1.method03022()) {
         this.field07637.add(new ActionOptionComponent(var3));
      }
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      for (ActionOptionComponent var7 : this.field07637) {
         var7.method00040(var1, var3, var5);
      }
   }

   @Override
   public void method03443() {
      float var1 = 0.0F;
      float var2 = this.field07630.method09485(field07638) + field07639;

      for (ActionOptionComponent var4 : this.field07637) {
         float var5 = Math.min(this.method09784(), this.field07631.method09486(var4.method01431(), field07640) + field07641);
         float var6 = this.field07631.method09485(field07642) + field07643;
         var4.method09786(var6);
         if (var1 + var5 > this.method09784()) {
            var1 = 0.0F;
            var2 += var6 + field07644;
         }

         var1 += var5 + field07645;
      }

      this.method09786(field07646 + var2);
   }
}
