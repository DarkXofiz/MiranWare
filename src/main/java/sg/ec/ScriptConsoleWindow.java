// Original binary: sg/ec/fvMpUbzGEULMjFjl
package sg.ec;

import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ScriptConsoleWindow extends ScrollableWindow {
   public static final String field19186 = "scripts.console";
   private static final String field19187 = "field19187";
   private static final String field19188 = "field19188";
   private static final String field19189 = "field19189";
   private static final float field19190 = 0;
   private static final float field19191 = 0;
   private static final float field19192 = 0;
   private static final float field19193 = 0;
   private static final float field19194 = 0;
   private static final float field19195 = 0;
   private static final float field19196 = 0;
   private static final float field19197 = 0;
   private static final int field19198 = ColorUtils.method04604(235, 180, 90);
   private final FontRenderer field19199 = GuiThemeStyle.field03545;
   private final ScrollController field19200 = new ScrollController();
   private final List<ScrollableWindow.Nested257> field19201;
   private boolean field19202;
   private boolean field19203 = true;
   private static final String field19204 = "Консоль";
   private static final String field19205 = "scripts.console";
   private static final String field19206 = "Вывод скриптов";
   private static final float field19207 = 215.0F;
   private static final float field19208 = 120.0F;
   private static final float field19209 = 7.0F;
   private static final float field19210 = 7.0F;
   private static final float field19211 = 8.0F;
   private static final String field19212 = "пока пусто — скрипты ещё ничего не написали";
   private static final float field19213 = 5.5F;
   private static final float field19214 = 8.0F;
   private static final float field19215 = 8.0F;
   private static final float field19216 = 0.5F;
   private static final float field19217 = 0.7F;
   private static final float field19218 = 5.5F;
   private static final float field19219 = 5.5F;
   private static final float field19220 = 5.5F;
   private static final float field19221 = 3.0F;

   private void method08346() {
      ScriptLogManager.INSTANCE.method08089();
      this.field19203 = true;
   }

   private void method08348(float var1) {
      float var2 = this.field21185.method02802();
      this.field19200.method01152(var1 > var2);
      this.field19200.method01134(var1, var2);
      float var3 = Math.min(0.0F, var2 - var1);
      if (this.field19203) {
         this.field19200.method01140(var3);
      } else if (this.field19200.method01135() <= var3 + field19216) {
         this.field19203 = true;
      }

      this.field19200.method01145();
   }

   public ScriptConsoleWindow() {
      super(field19204, field19205, field19206, field19207, field19208);
      this.field19201 = List.of(
         new ScrollableWindow.Nested257(method09310(GuiIcon.PIN, field19209), () -> this.field19202, () -> this.field19202 = !this.field19202),
         new ScrollableWindow.Nested257(method09310(GuiIcon.DELETE, field19210), () -> false, this::method08346),
         this.method09311()
      );
   }

   private void method08349(GuiGraphicsExtractor var1, ScriptLogManager.Nested233 var2, float var3) {
      float var4 = this.field21185.method02809() + 1.0F;
      int var5 = GuiThemeStyle.method01443(method08350(var2.level()), this.field21186);
      var4 = this.method08351(var1, var2.stamp(), var4, var3, GuiThemeStyle.method01445(field19217 * this.field21186));
      var4 = this.method08351(var1, "[" + ScriptLogManager.method08100(var2.level()) + "]", var4, var3, var5);
      var4 = this.method08351(var1, "[" + var2.source() + "]", var4, var3, GuiThemeStyle.method01437(this.field21186));
      this.field19199.method09480(var1, var2.text(), var4, var3, var2.level() == 0 ? GuiThemeStyle.method01437(this.field21186) : var5, field19218);
   }

   @Override
   public boolean method01698() {
      return this.field19202;
   }

   private static int method08350(int var0) {
      return switch (var0) {
         case 1 -> field19198;
         case 2 -> GuiThemeStyle.field03548;
         default -> GuiThemeStyle.method01441().field22113.method11676();
      };
   }

   private float method08351(GuiGraphicsExtractor var1, String var2, float var3, float var4, int var5) {
      this.field19199.method09480(var1, var2, var3, var4, var5, field19219);
      return var3 + this.field19199.method09486(var2, field19220) + field19221;
   }

   @Override
   protected void method01894(GuiGraphicsExtractor var1, int var2, int var3) {
      var var4 = ScriptLogManager.INSTANCE.method08084();
      float var5 = var4.size() * field19211;
      this.method08348(var5);
      if (var4.isEmpty()) {
         this.field19199
            .method09480(
               var1,
               field19212,
               this.field21185.method02809() + 1.0F,
               this.field21185.method02808() + 2.0F,
               GuiThemeStyle.method01445(this.field21186),
               field19213
            );
      } else {
         float var6 = this.field21185.method02808();
         float var7 = var6 + this.field21185.method02802();
         var1.enableScissor(
            (int)this.field21185.method02809(), (int)var6, (int)Math.ceil(this.field21185.method02809() + this.field21185.method02804()), (int)Math.ceil(var7)
         );
         float var8 = var6 + this.field19200.method01136();

         for (ScriptLogManager.Nested233 var10 : var4) {
            if (var8 + field19214 >= var6 && var8 <= var7) {
               this.method08349(var1, var10, var8);
            }

            var8 += field19215;
         }

         var1.disableScissor();
      }
   }

   @Override
   protected void method01899(double var1, double var3, double var5) {
      this.field19203 = false;
      this.field19200.method01133(var5);
   }

   @Override
   protected List<ScrollableWindow.Nested257> method01897() {
      return this.field19201;
   }

   @Override
   protected boolean method08354() {
      return true;
   }
}
