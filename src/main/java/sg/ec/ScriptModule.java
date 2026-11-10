// Original binary: sg/ec/rR7A20b4ALNL741w
package sg.ec;

import hex.script.api.Button;
import hex.script.api.Canvas;
import hex.script.api.CheckBox;
import hex.script.api.ColorPicker;
import hex.script.api.Combo;
import hex.script.api.Custom;
import hex.script.api.Hotkey;
import hex.script.api.Input;
import hex.script.api.Selectable;
import hex.script.api.Setting;
import hex.script.api.Slider;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public final class ScriptModule extends ClientModule {
   private final LoadedScript field23229;
   private final List<Runnable> field23230 = new ArrayList<>();
   private boolean field23231;
   private static final String field23232 = "Скрипт из папки scripts.";
   private static final String field23233 = "Скрипт из папки scripts.";

   void method10294() {
      for (int var1 = 0; var1 < this.field23230.size(); var1++) {
         try {
            this.field23230.get(var1).run();
         } catch (Throwable var3) {
         }
      }
   }

   void method10295(boolean var1) {
      if (!this.field23231 && this.method03937() != var1) {
         this.field23231 = true;

         try {
            this.method03939(var1);
         } finally {
            this.field23231 = false;
         }
      }
   }

   @Override
   public void method00245() {
      super.method00245();
      if (!this.field23231) {
         this.field23231 = true;

         try {
            ScriptRuntime.INSTANCE.method06185(this.field23229);
         } finally {
            this.field23231 = false;
         }
      }
   }

   private void method10296(Button var1) {
      ActionSetting var2 = new ActionSetting(var1.name());
      var2.method03017(var1::press);
      this.method10316(var1, var2);
   }

   private void method10298(Selectable var1) {
      ModeSetting var2 = new ModeSetting(var1.name()).method05597(var1.options().toArray(new String[0]));
      var2.method03017(var1.value());
      this.method10316(var1, var2);
      String[] var3 = new String[]{var1.value()};
      this.field23230.add(() -> {
         String var3x = var2.method03022();
         String var4 = var1.value();
         if (!var3[0].equals(var3x)) {
            var1.value(var3x);
            var3[0] = var1.value();
         } else if (!var3[0].equals(var4)) {
            var2.method05603(var4);
            var3[0] = var4;
         }
      });
   }

   public boolean method10300() {
      return this.field23231;
   }

   private void method10301(Custom var1) {
      ItemSelectionSetting var2 = new ItemSelectionSetting(var1.name()).method03683(var1.height());
      var2.method03676((var1x, var2x, var3, var4, var5, var6, var7, var8) -> {
         ScriptRender2DAdapter var9 = ScriptRuntime.INSTANCE.method06230().method11765();
         GuiGraphics var10 = var9.method04298();
         var9.method04307(var1x);

         try {
            var1.draw(new Canvas(var9.method04312(), var2x, var3, var4, var5, var6, var7, var8));
         } finally {
            if (var10 == null) {
               var9.method04326();
            } else {
               var9.method04307(var10);
            }
         }
      });
      var2.method03679((var1x, var3, var5) -> var1.click((float)var1x, (float)var3, var5));
      var2.method03677((var1x, var3, var5) -> var1.release((float)var1x, (float)var3, var5));
      this.method10316(var1, var2);
   }

   private void method10302(Input var1) {
      TextAreaSetting var2 = new TextAreaSetting(var1.name()).method05828(var1.placeholder());
      var2.method03017(var1.value());
      this.method10316(var1, var2);
      String[] var3 = new String[]{var1.value()};
      this.field23230.add(() -> {
         String var3x = var2.method05830();
         String var4 = var1.value();
         if (!var3[0].equals(var3x)) {
            var1.value(var3x);
            var3[0] = var3x;
         } else if (!var3[0].equals(var4)) {
            var2.method03014(var4);
            var3[0] = var4;
         }
      });
   }

   @Override
   public void method00276() {
      super.method00276();
      if (!this.field23231) {
         this.field23231 = true;

         try {
            ScriptRuntime.INSTANCE.method06184(this.field23229);
         } finally {
            this.field23231 = false;
         }
      }
   }

   private static String method10304(LoadedScript var0) {
      try {
         String var1 = var0.method03393().description();
         return var1 != null && !var1.isEmpty() ? var1 : field23232;
      } catch (Throwable var2) {
         return field23233;
      }
   }

   private void method10305(CheckBox var1) {
      ToggleSetting var2 = new ToggleSetting(var1.name());
      var2.method03017(var1.value());
      this.method10316(var1, var2);
      boolean[] var3 = new boolean[]{var1.value()};
      this.field23230.add(() -> {
         boolean var3x = var2.method05999();
         boolean var4 = var1.value();
         if (var3x != var3[0]) {
            var1.value(var3x);
            var3[0] = var3x;
         } else if (var4 != var3[0]) {
            var2.method03014(var4);
            var3[0] = var4;
         }
      });
   }

   private void method10306() {
      for (Setting var2 : ScriptSettingsAdapter.method00977(this.field23229.method03393())) {
         if (var2 instanceof CheckBox var3) {
            this.method10305(var3);
         } else if (var2 instanceof Slider var4) {
            this.method10318(var4);
         } else if (var2 instanceof Selectable var5) {
            this.method10298(var5);
         } else if (var2 instanceof Combo var6) {
            this.method10311(var6);
         } else if (var2 instanceof ColorPicker var7) {
            this.method10307(var7);
         } else if (var2 instanceof Hotkey var8) {
            this.method10320(var8);
         } else if (var2 instanceof Button var9) {
            this.method10296(var9);
         } else if (var2 instanceof Custom var10) {
            this.method10301(var10);
         } else if (var2 instanceof Input var11) {
            this.method10302(var11);
         }
      }
   }

   private void method10307(ColorPicker var1) {
      ColorSetting var2 = new ColorSetting(var1.name());
      var2.method03017(new Color(var1.value(), true));
      this.method10316(var1, var2);
      int[] var3 = new int[]{var1.value()};
      this.field23230.add(() -> {
         int var3x = var2.method03022().getRGB();
         int var4 = var1.value();
         if (var3x != var3[0]) {
            var1.value(var3x);
            var3[0] = var3x;
         } else if (var4 != var3[0]) {
            var2.method11672(new Color(var4, true));
            var3[0] = var4;
         }
      });
   }

   private void method10311(Combo var1) {
      MultiToggleSetting var2 = new MultiToggleSetting(var1.name());

      for (String var4 : var1.options()) {
         var2.method04517(NamedOption.method08077(var4, var1.has(var4)));
      }

      this.method10316(var1, var2);

      for (String var7 : var1.options()) {
         boolean[] var5 = new boolean[]{var1.has(var7)};
         this.field23230.add(() -> {
            boolean var4x = var2.method04520(var7);
            boolean var5x = var1.has(var7);
            if (var4x != var5[0]) {
               var1.set(var7, var4x);
               var5[0] = var4x;
            } else if (var5x != var5[0]) {
               var2.method04519(var7, var5x);
               var5[0] = var5x;
            }
         });
      }
   }

   public List<Runnable> method10313() {
      return this.field23230;
   }

   private void method10316(Setting<?> var1, sg.ec.Setting<?> var2) {
      var2.method03018(var1.description());
      var2.method03016(var1.id());
      var2.method03025(var1::visible);
      this.method03026().add(var2);
   }

   ScriptModule(LoadedScript var1) {
      super(ModuleCategory.Scripts, ModuleSubCategory.Main);
      this.field23229 = var1;
      this.method03935(var1.method03400());
      this.method03931(method10304(var1));
      this.method10306();
   }

   public LoadedScript method10317() {
      return this.field23229;
   }

   private void method10318(Slider var1) {
      NumberSetting var2 = new NumberSetting<Float>(var1.name()).method10835(var1.min()).method10838(var1.max()).method10834(var1.step());
      var2.method03017(var1.value());
      this.method10316(var1, var2);
      float[] var3 = new float[]{var1.value()};
      this.field23230.add(() -> {
         float var3x = (Float)var2.method03022();
         float var4 = var1.value();
         if (var3x != var3[0]) {
            var1.value(var3x);
            var3[0] = var1.value();
         } else if (var4 != var3[0]) {
            var2.method03014(var4);
            var3[0] = var4;
         }
      });
   }

   private void method10320(Hotkey var1) {
      KeyBindSetting var2 = new KeyBindSetting(var1.name());
      var2.method03017(new KeyBinding(var1.key()));
      this.method10316(var1, var2);
      int[] var3 = new int[]{var1.key()};
      this.field23230.add(() -> {
         int var3x = var2.method03022().method05871();
         int var4 = var1.key();
         if (var3x != var3[0]) {
            var1.key(var3x);
            var3[0] = var3x;
         } else if (var4 != var3[0]) {
            var2.method03022().method05872(var4);
            var3[0] = var4;
         }
      });
   }
}
