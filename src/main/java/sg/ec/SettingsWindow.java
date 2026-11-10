// Original binary: sg/ec/MvCGENl5KSwAt5ff
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class SettingsWindow extends FloatingWindow {
   private static final float field10259 = GuiSize.method04763(SettingsWindow.field10286)
      .method04764(SettingsWindow.field10287)
      .method04761();
   private final SettingsContainer field10260;
   private final List<SettingComponent<?>> field10261 = new ArrayList<>();
   private final ScrollController field10262 = new ScrollController();
   private float field10263;
   private static final float field10264 = 101.333336F;
   private static final float field10265 = 168.0F;
   private static final float field10266 = 101.333336F;
   private static final float field10267 = 0.01F;
   private static final float field10268 = 13.0F;
   private static final float field10269 = 0.01F;
   private static final float field10270 = 13.0F;
   private static final float field10271 = 5.0F;
   private static final float field10272 = 20.0F;
   private static final float field10273 = 150.0F;
   private static final float field10274 = 5.0F;
   private static final float field10275 = 0.01F;
   private static final float field10276 = 6.5F;
   private static final float field10277 = 2.5F;
   private static final float field10278 = 13.0F;
   private static final float field10279 = 5.0F;
   private static final float field10280 = 20.0F;
   private static final float field10281 = 150.0F;
   private static final float field10282 = 150.0F;
   private static final float field10283 = 0.01F;
   private static final float field10284 = 0.01F;
   private static final float field10285 = 0.01F;
   private static final float field10286 = 10.0F;
   private static final float field10287 = 0.5F;

   public static List<SettingComponent<?>> method04679(List<Setting<?>> var0, FloatingWindow var1) {
      List var2 = new ArrayList<>();

      for (Setting sx : var0) {
         SettingComponent sxx = method04685(sx, var1);
         if (sxx != null) {
            var2.add(sxx);
         }
      }

      return var2;
   }

   public static List<SettingComponent<?>> method04680(SettingsContainer var0, FloatingWindow var1) {
      return method04679(var0.method03026(), var1);
   }

   public SettingsContainer method04681() {
      return this.field10260;
   }

   public SettingsWindow(String var1, SettingsContainer var2) {
      super(var1);
      this.field10260 = var2;
      this.method04688();
   }

   @Override
   public void method01898(char var1, int var2) {
      for (SettingComponent var4 : this.field10261) {
         var4.method03946(var1, var2);
      }
   }

   public List<SettingComponent<?>> method04682() {
      return this.field10261;
   }

   public float method04683() {
      this.method08971(this.method04689());
      float var1 = 0.0F;

      for (SettingComponent var3 : this.field10261) {
         if (var3.method10977().method03019() || !(var3.method10979().method06173() < field10269)) {
            var3.method09781(this.method09568() - field10270);
            var3.method03443();
            var1 += var3.method09785() * (var3.method10977().method03019() ? 1.0F : 0.0F);
         }
      }

      this.field10263 = var1;
      float var4 = Mth.clamp(var1 + field10271, field10272, field10273);
      this.method09561(var4);
      return var4;
   }

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.method08971(this.method04689());
      this.field10262.method01145();
      this.field10262.method01134(this.field10263, this.method09574() - field10274);
      WindowFrameRenderer.method03056(var1, this, field10259);
      var1.enableScissor(
         (int)this.method09576(),
         (int)this.method09560(),
         (int)Math.ceil(this.method09576() + this.method09568()),
         (int)Math.ceil(this.method09560() + this.method09574())
      );
      float var5 = 0.0F;

      for (SettingComponent var7 : this.field10261) {
         if (var7.method10977().method03019() || !(var7.method10979().method06173() < field10275)) {
            var7.method09789(this.method09576() + field10276);
            var7.method09788(this.method09560() + field10277 + this.field10262.method01136() + var5);
            var7.method09781(this.method09568() - field10278);
            var7.method09783(this.method09573().method06173() * var7.method10979().method06173());
            var7.method00042(var1, var2, var3, var4);
            var5 += var7.method09785() * var7.method10979().method06173();
         }
      }

      var1.disableScissor();
      this.field10263 = var5;
      this.method09561(Mth.clamp(var5 + field10279, field10280, field10281));
      this.field10262.method01152(this.method09574() >= field10282);
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      for (SettingComponent var7 : this.field10261) {
         if (var7.method10977().method03019() || !(var7.method10979().method06173() < field10284)) {
            var7.method02632(var1, var3, var5);
         }
      }
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      for (SettingComponent var5 : this.field10261) {
         var5.method00250(var1, var2, var3);
      }
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      for (SettingComponent var7 : this.field10261) {
         if ((var7.method10977().method03019() || !(var7.method10979().method06173() < field10283)) && !var7.method00251(var1, var3, var5)) {
            var7.method00040(var1, var3, var5);
         }
      }
   }

   public static boolean method04684(Setting<?> var0) {
      return var0 instanceof ToggleSetting
         || var0 instanceof BooleanSetting
         || var0 instanceof NumberSetting
         || var0 instanceof ModeSetting
         || var0 instanceof MultiToggleSetting
         || var0 instanceof KeyBindSetting
         || var0 instanceof ColorSetting
         || var0 instanceof ActionSetting
         || var0 instanceof ActionListSetting
         || var0 instanceof TextSetting
         || var0 instanceof SliderSetting
         || var0 instanceof ItemSelectionSetting
         || var0 instanceof TextAreaSetting
         || var0 instanceof ItemFilterSetting;
   }

   public SettingsWindow(String var1, String var2, SettingsContainer var3) {
      super(var1, var2);
      this.field10260 = var3;
      this.method04688();
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      for (SettingComponent var8 : this.field10261) {
         if ((var8.method10977().method03019() || !(var8.method10979().method06173() < field10285))
            && var8 instanceof NumberSettingComponent var9
            && var9.method04527(var1, var3, var5)) {
            return;
         }
      }

      if (GuiHitTestUtils.method05609(var1, var3, this.method09576(), this.method09560(), this.method09568(), this.method09574())) {
         this.field10262.method01133(var5);
      }
   }

   public static SettingComponent<?> method04685(Setting<?> var0, FloatingWindow var1) {
      if (var0 instanceof ToggleSetting var15) {
         return new ToggleSettingComponent(var15, var1);
      } else if (var0 instanceof BooleanSetting var14) {
         return new BooleanSettingComponent(var14);
      } else if (var0 instanceof NumberSetting var13) {
         return new NumberSettingComponent(var13);
      } else if (var0 instanceof ModeSetting var12) {
         return new ModeSettingComponent(var12);
      } else if (var0 instanceof MultiToggleSetting var11) {
         return new MultiToggleSettingComponent(var11);
      } else if (var0 instanceof KeyBindSetting var10) {
         return new KeyBindSettingComponent(var10);
      } else if (var0 instanceof ColorSetting var9) {
         return new ColorSettingComponent(var9, var1);
      } else if (var0 instanceof SliderSetting var8) {
         return new SliderSettingComponent(var8, var1);
      } else if (var0 instanceof ActionSetting var7) {
         return new ActionSettingComponent(var7);
      } else if (var0 instanceof ActionListSetting var6) {
         return new ActionListSettingComponent(var6);
      } else if (var0 instanceof TextSetting var5) {
         return new TextSettingComponent(var5);
      } else if (var0 instanceof ItemSelectionSetting var4) {
         return new ItemSelectionSettingComponent(var4);
      } else if (var0 instanceof TextAreaSetting var3) {
         return new TextAreaSettingComponent(var3);
      } else {
         return var0 instanceof ItemFilterSetting var2 ? new ItemFilterSettingComponent(var2, var1) : null;
      }
   }

   public ScrollController method04686() {
      return this.field10262;
   }

   public float method04687() {
      return this.field10263;
   }

   private void method04688() {
      this.method08971(field10264);
      this.method09561(field10265);
      this.field10261.addAll(method04680(this.field10260, this));
   }

   private float method04689() {
      float var1 = field10266;

      for (SettingComponent var3 : this.field10261) {
         if (var3.method10977().method03019() || !(var3.method10979().method06173() < field10267)) {
            var1 = Math.max(var1, var3.method10978() + field10268);
         }
      }

      return var1;
   }
}
