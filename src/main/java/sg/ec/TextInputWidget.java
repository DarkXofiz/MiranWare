// Original binary: sg/ec/Ym2QQToZVyNeEmdT
package sg.ec;

import java.util.function.Consumer;
import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class TextInputWidget implements MinecraftAccess {
   private static final int field14999 = ColorUtils.method04604(183, 201, 255);
   private final SmoothAnimation field15000 = new SmoothAnimation();
   private String field15001 = "";
   private int field15002;
   private int field15003 = -1;
   private int field15004 = -1;
   private int field15005;
   private boolean field15006;
   private boolean field15007;
   private boolean field15008 = true;
   private int field15009 = 64;
   private String field15010 = "";
   private String field15011 = "";
   private float field15012;
   private FontRenderer field15013;
   private float field15014;
   private Runnable field15015;
   private Runnable field15016;
   private Consumer<String> field15017;
   private float field15018;
   private float field15019;
   private float field15020;
   private float field15021;
   private float field15022;
   private long field15023;
   private static final float field15024 = 5.0F;
   private static final float field15025 = 7.0F;
   private static final long field15026 = Long.MIN_VALUE;
   private static final float field15027 = 0.25F;
   private static final float field15028 = 0.7F;
   private static final float field15029 = 0.5F;
   private static final double field15030 = 0.15F;
   private static final String field15031 = "|";
   private static final float field15032 = 2.5F;
   private static final float field15033 = 5.0F;
   private static final float field15034 = Float.MAX_VALUE;
   private static final long field15035 = 450L;
   private static final long field15036 = 2L;

   private float method06668() {
      return this.field15011.isEmpty() ? 0.0F : this.field15013.method09486(this.field15011, this.field15014);
   }

   public void method06669(int var1) {
      this.field15009 = var1;
   }

   public void method06670(GuiGraphics var1, double var2, float var4) {
      ThemeSettings var5 = ThemeManager.INSTANCE.method09611();
      this.method06725(
         var1,
         var2,
         ColorUtils.method04611(var5.field22109.method11676(), var4),
         ColorUtils.method04611(var5.field22110.method11676(), var4 * field15028),
         method06677(var4)
      );
   }

   private static boolean method06671() {
      return KeyboardKey.method00362(341) || KeyboardKey.method00362(345);
   }

   public String method06672() {
      return this.field15001.trim();
   }

   public void method06673(double var1, double var3, int var5) {
      this.field15006 = false;
   }

   public String method06674() {
      return this.field15011;
   }

   public void method06675(String var1) {
      this.field15001 = var1 == null ? "" : this.method06727(var1);
      this.field15002 = this.field15001.length();
      this.method06737();
      this.method06684();
   }

   private static boolean method06676() {
      return KeyboardKey.method00362(340) || KeyboardKey.method00362(344);
   }

   public static int method06677(float var0) {
      return ColorUtils.method04605(field14999, var0 * field15027);
   }

   public TextInputWidget method06678(FontRenderer var1, float var2) {
      this.field15013 = var1;
      this.field15014 = var2;
      return this;
   }

   public float method06679() {
      return this.field15012;
   }

   private static String method06680(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         if (var3 >= ' ' && var3 != 127) {
            var1.append(var3);
         }
      }

      return var1.toString();
   }

   public void method06681(boolean var1) {
      this.field15008 = var1;
   }

   public boolean method06682() {
      return this.field15008;
   }

   private void method06683(GuiGraphics var1, float var2, int var3) {
      if (this.method06690()) {
         int var4 = Math.min(Math.min(this.field15003, this.field15004), this.field15001.length());
         int var5 = Math.min(Math.max(this.field15003, this.field15004), this.field15001.length());
         if (var4 < var5) {
            float var6 = var2 - this.field15022 + this.field15013.method09486(this.field15001.substring(0, var4), this.field15014);
            float var7 = var2 - this.field15022 + this.field15013.method09486(this.field15001.substring(0, var5), this.field15014);
            RoundedRectRenderer.method01272(var1, var6, this.field15019 + field15032, var7 - var6 + 1.0F, this.field15021 - field15033, 0.0F, 0.0F, var3);
         }
      }
   }

   private void method06684() {
      this.field15002 = Math.max(0, Math.min(this.field15002, this.field15001.length()));
      if (this.field15017 != null) {
         this.field15017.accept(this.field15001);
      }
   }

   public boolean method06685() {
      return this.field15001.isEmpty();
   }

   public void method06686(Consumer<String> var1) {
      this.field15017 = var1;
   }

   public String method06687() {
      return this.field15001;
   }

   public String method06688() {
      return this.field15010;
   }

   public void method06689(Runnable var1) {
      this.field15015 = var1;
   }

   private boolean method06690() {
      return this.field15003 != -1 && this.field15004 != -1 && this.field15003 != this.field15004;
   }

   private int method06691(double var1) {
      float var3 = (float)(var1 - this.field15018 - this.field15012 - this.method06668()) + this.field15022;
      int var4 = 0;
      float var5 = field15034;

      for (int var6 = 0; var6 <= this.field15001.length(); var6++) {
         float var7 = Math.abs(this.field15013.method09486(this.field15001.substring(0, var6), this.field15014) - var3);
         if (var7 < var5) {
            var5 = var7;
            var4 = var6;
         }
      }

      return var4;
   }

   public void method06692() {
      this.field15001 = "";
      this.field15002 = 0;
      this.field15022 = 0.0F;
      this.method06737();
      this.method06684();
   }

   private boolean method06693() {
      if (!this.method06690()) {
         return false;
      }

      int var1 = Math.min(this.field15003, this.field15004);
      int var2 = Math.max(this.field15003, this.field15004);
      mc.keyboardHandler.setClipboard(this.field15001.substring(var1, var2));
      return true;
   }

   private void method06694(int var1) {
      if (!method06676() && this.method06690()) {
         int var2 = var1 < 0 ? Math.min(this.field15003, this.field15004) : Math.max(this.field15003, this.field15004);
         this.method06737();
         this.field15002 = var2;
         this.field15005 = var2;
      } else {
         this.method06728(this.field15002 + var1);
      }
   }

   private void method06695() {
      if (!this.field15001.isEmpty()) {
         this.field15003 = 0;
         this.field15004 = this.field15001.length();
         this.field15005 = 0;
         this.field15002 = this.field15001.length();
      }
   }

   private void method06696(int var1) {
      if (var1 == this.field15005) {
         this.method06737();
      } else {
         this.field15003 = Math.min(this.field15005, var1);
         this.field15004 = Math.max(this.field15005, var1);
      }
   }

   public long method06697() {
      return this.field15023;
   }

   public FontRenderer method06698() {
      return this.field15013;
   }

   private void method06699(float var1, float var2) {
      float var3 = this.field15013.method09486(this.field15001, this.field15014);
      if (var3 <= var2) {
         this.field15022 = 0.0F;
      } else {
         if (var1 - this.field15022 > var2) {
            this.field15022 = var1 - var2;
         }

         if (var1 - this.field15022 < 0.0F) {
            this.field15022 = var1;
         }

         if (var3 - this.field15022 < var2) {
            this.field15022 = var3 - var2;
         }
      }
   }

   public TextInputWidget method06700(float var1, float var2, float var3, float var4) {
      this.field15018 = var1;
      this.field15019 = var2;
      this.field15020 = var3;
      this.field15021 = var4;
      return this;
   }

   private void method06701() {
      if (this.method06690()) {
         this.method06708();
      } else {
         if (this.field15002 >= this.field15001.length()) {
            return;
         }

         this.field15001 = this.field15001.substring(0, this.field15002) + this.field15001.substring(this.field15002 + 1);
      }

      this.method06684();
   }

   public void method06702() {
      this.method06692();
      this.field15007 = false;
      this.field15006 = false;
   }

   public boolean method06703(double var1, double var3, int var5) {
      if (var5 != 0) {
         return false;
      }

      if (this.method06711() && GuiHitTestUtils.method05609(var1, var3, this.field15018, this.field15019, this.field15020, this.field15021)) {
         this.field15002 = this.method06691(var1);
         this.field15005 = this.field15002;
         this.method06737();
         this.field15006 = true;
         this.field15007 = true;
         return true;
      }

      if (this.field15008) {
         this.method06722();
      }

      return false;
   }

   public Runnable method06704() {
      return this.field15015;
   }

   public void method06705(Runnable var1) {
      this.field15016 = var1;
   }

   public void method06706(FontRenderer var1) {
      this.field15013 = var1;
   }

   public float method06707() {
      return this.field15020;
   }

   private void method06708() {
      if (this.method06690()) {
         int var1 = Math.min(this.field15003, this.field15004);
         int var2 = Math.max(this.field15003, this.field15004);
         this.field15001 = this.field15001.substring(0, var1) + this.field15001.substring(var2);
         this.field15002 = var1;
         this.method06737();
      }
   }

   private void method06709(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         String var2 = method06680(var1);
         if (!var2.isEmpty()) {
            this.method06708();
            int var3 = this.field15009 - this.field15001.length();
            if (var3 > 0) {
               if (var2.length() > var3) {
                  var2 = var2.substring(0, var3);
               }

               this.field15001 = this.field15001.substring(0, this.field15002) + var2 + this.field15001.substring(this.field15002);
               this.field15002 = this.field15002 + var2.length();
               this.method06684();
            }
         }
      }
   }

   public SmoothAnimation method06710() {
      return this.field15000;
   }

   public boolean method06711() {
      return this.field15023 >= FrameClock.method09542() - 1L;
   }

   public void method06712(String var1) {
      this.field15011 = var1;
   }

   public float method06713() {
      return this.field15021;
   }

   public boolean method06714() {
      return this.field15006;
   }

   public int method06715() {
      return this.field15002;
   }

   public void method06716() {
      this.field15007 = true;
      this.field15002 = this.field15001.length();
      this.method06737();
   }

   public void method06717(String var1) {
      this.field15010 = var1;
   }

   public float method06718() {
      return this.field15019;
   }

   public Runnable method06719() {
      return this.field15016;
   }

   public float method06720() {
      return this.field15018;
   }

   private static boolean method06721() {
      return System.currentTimeMillis() / field15035 % field15036 == 0L;
   }

   public void method06722() {
      this.field15007 = false;
      this.field15006 = false;
      this.method06737();
   }

   public Consumer<String> method06723() {
      return this.field15017;
   }

   public void method06724(boolean var1) {
      this.field15007 = var1;
   }

   public TextInputWidget() {
      this.field15012 = field15024;
      this.field15013 = Fonts.field00111;
      this.field15014 = field15025;
      this.field15023 = field15026;
   }

   public void method06725(GuiGraphics var1, double var2, int var4, int var5, int var6) {
      this.field15023 = FrameClock.method09542();
      this.field15000.method06162();
      float var7 = this.field15018 + this.field15012 + this.method06668();
      float var8 = Math.max(1.0F, this.field15020 - this.field15012 * 2.0F - this.method06668());
      float var9 = this.field15019 + this.field15021 / 2.0F - this.field15013.method09485(this.field15014) / 2.0F - field15029;
      if (this.field15006) {
         int var10 = this.method06691(var2);
         this.method06696(var10);
         this.field15002 = var10;
      }

      float var11 = this.field15013.method09486(this.field15001.substring(0, Math.min(this.field15002, this.field15001.length())), this.field15014);
      this.method06699(var11, var8);
      this.field15000.method06168(var11 - this.field15022, field15030, Easings.field19400, true);
      var1.enableScissor(
         (int)(this.field15018 + 1.0F), (int)this.field15019, (int)(this.field15018 + this.field15020 - 1.0F), (int)(this.field15019 + this.field15021)
      );
      if (!this.field15011.isEmpty()) {
         this.field15013.method09480(var1, this.field15011, this.field15018 + this.field15012, var9, var5, this.field15014);
      }

      if (!this.field15001.isEmpty() || this.field15007) {
         this.method06683(var1, var7, var6);
         this.field15013.method09480(var1, this.field15001, var7 - this.field15022, var9, var4, this.field15014);
         if (this.field15007 && method06721()) {
            this.field15013.method09480(var1, field15031, var7 + this.field15000.method06173(), var9, var4, this.field15014);
         }
      } else if (!this.field15010.isEmpty()) {
         this.field15013.method09480(var1, this.field15010, var7, var9, var5, this.field15014);
      }

      var1.disableScissor();
   }

   public boolean method06726() {
      return this.field15007;
   }

   private String method06727(String var1) {
      String var2 = method06680(var1);
      return var2.length() > this.field15009 ? var2.substring(0, this.field15009) : var2;
   }

   private void method06728(int var1) {
      int var2 = Math.max(0, Math.min(var1, this.field15001.length()));
      if (method06676()) {
         if (!this.method06690()) {
            this.field15005 = this.field15002;
         }

         this.field15002 = var2;
         this.method06696(var2);
      } else {
         this.method06737();
         this.field15002 = var2;
         this.field15005 = var2;
      }
   }

   private void method06729() {
      if (this.field15016 != null) {
         this.field15016.run();
      } else {
         this.method06722();
      }
   }

   public boolean method06730(char var1) {
      if (this.field15007 && var1 >= ' ' && var1 != 127) {
         this.method06709(String.valueOf(var1));
         return true;
      } else {
         return false;
      }
   }

   public float method06731() {
      return this.field15014;
   }

   private void method06732() {
      if (this.method06690()) {
         this.method06708();
      } else {
         if (this.field15002 <= 0) {
            return;
         }

         this.field15001 = this.field15001.substring(0, this.field15002 - 1) + this.field15001.substring(this.field15002);
         this.field15002--;
      }

      this.method06684();
   }

   public boolean method06733(int var1) {
      if (!this.field15007) {
         return false;
      }

      switch (var1) {
         case 65:
            if (!method06671()) {
               return false;
            }

            this.method06695();
            break;
         case 67:
            if (!method06671()) {
               return false;
            }

            this.method06693();
            break;
         case 86:
            if (!method06671()) {
               return false;
            }

            this.method06709(mc.keyboardHandler.getClipboard());
            break;
         case 88:
            if (!method06671()) {
               return false;
            }

            if (this.method06693()) {
               this.method06708();
               this.method06684();
            }
            break;
         case 256:
            this.method06729();
            break;
         case 257:
         case 335:
            this.method06742();
            break;
         case 259:
            this.method06732();
            break;
         case 261:
            this.method06701();
            break;
         case 262:
            this.method06694(1);
            break;
         case 263:
            this.method06694(-1);
            break;
         case 268:
            this.method06728(0);
            break;
         case 269:
            this.method06728(this.field15001.length());
            break;
         default:
            return false;
      }

      return true;
   }

   public void method06734(float var1) {
      this.field15012 = var1;
   }

   public float method06735() {
      return this.field15022;
   }

   public int method06736() {
      return this.field15005;
   }

   private void method06737() {
      this.field15003 = -1;
      this.field15004 = -1;
   }

   public void method06738(float var1) {
      this.field15014 = var1;
   }

   public int method06739() {
      return this.field15009;
   }

   public int method06740() {
      return this.field15003;
   }

   public int method06741() {
      return this.field15004;
   }

   private void method06742() {
      if (this.field15015 != null) {
         this.field15015.run();
      }
   }
}
