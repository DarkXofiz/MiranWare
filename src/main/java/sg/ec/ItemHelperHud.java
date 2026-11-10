// Original binary: sg/ec/MsyFhuQOzQ2J7eri
package sg.ec;

import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class ItemHelperHud extends HudElement {
   private final ToggleSetting field10239;
   private static final float field10240 = 20.0F;
   private static final float field10241 = 0;
   private static final float field10242 = 0;
   private static final float field10243 = 0;
   private final DraggableElement field10244;
   private static final String field10245 = "ItemHelper";
   private static final String field10246 = "Убирать если кд";
   private static final float field10247 = 12.5F;
   private static final float field10248 = 20.0F;
   private static final float field10249 = 6.0F;
   private static final float field10250 = 20.0F;
   private static final float field10251 = 6.0F;
   private static final float field10252 = 0.5F;
   private static final float field10253 = 7.0F;
   private static final float field10254 = 0.75F;
   private static final float field10255 = 20.0F;
   private static final float field10256 = 3.0F;
   private static final float field10257 = 3.0F;
   private static final float field10258 = 6.0F;

   @Override
   public void method00027(GuiGraphicsExtractor var1) {
      float var2 = field10247;
      var sx = ModuleManager.INSTANCE.method08184().method05776();
      float sxx = 0.0F;
      boolean sxxx = false;

      for (ServerHelper.Nested174 sxxxx : sx) {
         ItemStack sxxxxx = sxxxx.method05824();
         if (!sxxxxx.isEmpty() && sxxxxx.getCount() >= 0) {
            sxx += field10248 + field14601.method09486(sxxxx.method05825(), field10249) + 1.0F;
            sxxx = true;
         }
      }

      if (sxxx) {
         sxx--;
      }

      this.field10244.method02676(sxx);
      this.field10244.method02696(var2);
      float sxxxx = this.field10244.method02685();
      float sxxxxx = this.field10244.method02669();
      this.method06465(sxxxx);
      this.method06453(sxxxxx);
      this.method06448(sxx);
      this.method06456(var2);
      float sxxxxxx = sxxxx;
      float sxxxxxxx = this.method06455();

      for (ServerHelper.Nested174 sxxxxxxxx : sx) {
         ItemStack sxxxxxxxxx = sxxxxxxxx.method05824();
         if (!sxxxxxxxxx.isEmpty() && sxxxxxxxxx.getCount() >= 0) {
            String sxxxxxxxxxx = sxxxxxxxx.method05825();
            float sxxxxxxxxxxx = field10250 + field14601.method09486(sxxxxxxxxxx, field10251);
            this.method06439(var1, sxxxxxx, sxxxxx, sxxxxxxxxxxx, var2, 2.0F, this.method06466(), 1.0F);
            RoundedRectRenderer.method01272(
               var1, sxxxxxx, sxxxxx, sxxxxxxxxxxx, var2, 2.0F, this.method06466(), ColorUtils.method04611(this.method06460(), sxxxxxxx)
            );
            if (!this.method06447()) {
               GuiShadowRenderer.method10984(
                  var1, sxxxxxx, sxxxxx, sxxxxxxxxxxx, var2, 2.0F, field10252, field10253, ColorUtils.method04611(this.method06460(), sxxxxxxx)
               );
            }

            ItemRenderUtils.method08415(var1, sxxxxxxxxx, sxxxxxx + 2.0F, sxxxxx, 1.0F, 1.0F, field10254);
            field14601.method09480(var1, sxxxxxxxxxx, sxxxxxx + field10255 - field10256, sxxxxx + var2 / 2.0F - field10257, this.method06438(), field10258);
            sxxxxxx += sxxxxxxxxxxx + 1.0F;
         }
      }
   }

   public ItemHelperHud() {
      super(field10245);
      this.field10239 = new ToggleSetting(field10246).method03017(false).method03023(this);
      this.field10244 = this.method06449(this, 0.0F, 0.0F);
      this.field10244.method02677(true);
   }

   public ToggleSetting method04678() {
      return this.field10239;
   }
}
