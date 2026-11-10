// Original binary: sg/ec/nC5pLtgr4oN4PJA9
package sg.ec;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public enum ThemeManager {
   INSTANCE;

   private static final long field21915 = 250L;
   private int field21916 = 0;
   private final List<ThemeSettings> field21917 = new ArrayList<>();
   private ThemeSettings field21918 = new ThemeSettings("Фиолетовая");
   private AnimationUtils field21919;

   public void method09609(ThemeSettings var1) {
      this.field21917.add(var1);
   }

   public void method09610(ThemeSettings var1) {
      this.field21917.remove(var1);
   }

   public ThemeSettings method09611() {
      return this.field21918;
   }

   public void method09612(ThemeSettings var1) {
      if (var1 != null && var1 != this.field21918) {
         if (this.field21918 != null) {
            var var2 = this.field21918.method03026();
            var var3 = var1.method03026();
            int var4 = Math.min(var2.size(), var3.size());

            for (int var5 = 0; var5 < var4; var5++) {
               if (var2.get(var5) instanceof ColorSetting var6 && var3.get(var5) instanceof ColorSetting var7) {
                  var7.method11681(var6.method11677());
               }
            }

            this.field21919 = new AnimationUtils(AnimationUtils.Nested95.CUBIC, 250L);
            this.field21919.method03375(1.0);
         }

         this.field21918 = var1;
      }
   }

   public float method09613() {
      if (this.field21919 == null) {
         return 1.0F;
      }

      this.field21919.method03375(1.0);
      return this.field21919.method03377();
   }

   public boolean method09614(ThemeSettings var1) {
      int var2 = this.field21917.indexOf(var1);
      return var2 > -1 && var2 < this.field21916;
   }

   public ThemeSettings method09615() {
      String var1 = "Theme";
      int var2 = 1;
      String var3 = var1 + " " + var2;

      while (this.method09618(var3)) {
         var3 = var1 + " " + ++var2;
      }

      ThemeSettings var4 = new ThemeSettings(var3);
      this.field21917.add(var4);
      return var4;
   }

   public boolean method09616(ThemeSettings var1, String var2) {
      if (var1 != null && !this.method09614(var1)) {
         String var3 = var2 == null ? "" : var2.trim();
         if (var3.isEmpty()) {
            return false;
         }

         String var4 = this.method09619(var3, var1);
         if (var4.equals(var1.method09815())) {
            return false;
         }

         String var5 = var1.method09815();
         var1.method09825(var4);
         this.method09622(var5, var4);
         return true;
      } else {
         return false;
      }
   }

   public boolean method09617(ThemeSettings var1) {
      if (var1 != null && !this.method09614(var1)) {
         String var2 = StorageManager.method11279(var1.method09815());
         this.field21917.remove(var1);
         if (this.field21918 == var1 && !this.field21917.isEmpty()) {
            this.field21918 = this.field21917.getFirst();
         }

         this.method09621(var1.method09815());
         GlobalRequestSender.method09378(var1x -> var1x.method01782(StorageCategory.THEME, var2));
         return true;
      } else {
         return false;
      }
   }

   private boolean method09618(String var1) {
      for (ThemeSettings var3 : this.field21917) {
         if (var3.method09815().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   private String method09619(String var1, ThemeSettings var2) {
      String var3 = var1;

      for (int var4 = 1; this.method09620(var3, var2); var4++) {
         var3 = var1 + " " + var4;
      }

      return var3;
   }

   private boolean method09620(String var1, ThemeSettings var2) {
      for (ThemeSettings var4 : this.field21917) {
         if (var4 != var2 && var4.method09815().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   private void method09621(String var1) {
      File var2 = this.method09623(var1);
      if (var2.exists()) {
         var2.delete();
      }
   }

   private void method09622(String var1, String var2) {
      File var3 = this.method09623(var1);
      File var4 = this.method09623(var2);
      if (var3.exists()) {
         if (var4.exists()) {
            var4.delete();
         }

         var3.renameTo(var4);
      }
   }

   public File method09623(String var1) {
      String var2 = var1.replaceAll("[^a-zA-Z0-9А-Яа-яЁё]", "_") + ".json";
      return new File(CustomResourceManager.INSTANCE.field05982, var2);
   }

   private ThemeSettings method09624() {
      ThemeSettings var1 = new ThemeSettings("Зелёная");
      var1.field22104.method11672(new Color(ColorUtils.method04592(133, 255, 133, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(49, 160, 49, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(3, 4, 3, 181), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(255, 255, 255, 175), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(76, 153, 76, 255), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(76, 153, 76, 255), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(38, 76, 38, 120), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(51, 102, 51, 255), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(38, 76, 38, 120), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(69, 153, 69, 50), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(12, 25, 12, 255), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(57, 127, 57, 3), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(12, 25, 12, 180), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(12, 25, 12, 206), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(12, 25, 12, 225), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(76, 153, 76, 255), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(126, 253, 126, 30), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(133, 255, 133, 255), true));
      return var1;
   }

   private ThemeSettings method09625() {
      this.field21918.field22104.method11672(new Color(ColorUtils.method04592(241, 133, 255, 255), true));
      this.field21918.field22105.method11672(new Color(ColorUtils.method04592(147, 49, 160, 255), true));
      this.field21918.field22106.method11672(new Color(ColorUtils.method04592(4, 3, 4, 181), true));
      this.field21918.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      this.field21918.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      this.field21918.field22110.method11672(new Color(ColorUtils.method04592(255, 255, 255, 175), true));
      this.field21918.field22111.method11672(new Color(ColorUtils.method04592(144, 76, 153, 255), true));
      this.field21918.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      this.field21918.field22113.method11672(new Color(ColorUtils.method04592(144, 76, 153, 255), true));
      this.field21918.field22114.method11672(new Color(ColorUtils.method04592(72, 38, 76, 120), true));
      this.field21918.field22115.method11672(new Color(ColorUtils.method04592(96, 51, 102, 255), true));
      this.field21918.field22116.method11672(new Color(ColorUtils.method04592(72, 38, 76, 120), true));
      this.field21918.field22117.method11672(new Color(ColorUtils.method04592(143, 69, 153, 50), true));
      this.field21918.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      this.field21918.field22119.method11672(new Color(ColorUtils.method04592(23, 12, 25, 255), true));
      this.field21918.field22120.method11672(new Color(ColorUtils.method04592(119, 57, 127, 3), true));
      this.field21918.field22121.method11672(new Color(ColorUtils.method04592(23, 12, 25, 180), true));
      this.field21918.field22122.method11672(new Color(ColorUtils.method04592(23, 12, 25, 206), true));
      this.field21918.field22123.method11672(new Color(ColorUtils.method04592(144, 76, 153, 255), true));
      this.field21918.field22124.method11672(new Color(ColorUtils.method04592(238, 126, 253, 30), true));
      this.field21918.field22125.method11672(new Color(ColorUtils.method04592(241, 133, 255, 255), true));
      this.field21918.field22126.method11672(new Color(ColorUtils.method04592(23, 12, 25, 225), true));
      return this.field21918;
   }

   private ThemeSettings method09626() {
      ThemeSettings var1 = new ThemeSettings("Синяя");
      var1.field22104.method11672(new Color(ColorUtils.method04592(133, 150, 255, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(49, 65, 160, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(3, 3, 4, 181), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(255, 255, 255, 175), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(76, 87, 153, 255), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(76, 87, 153, 255), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(38, 43, 76, 120), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(51, 58, 102, 255), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(38, 43, 76, 120), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(69, 81, 153, 50), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(12, 14, 25, 255), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(57, 67, 127, 3), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(12, 14, 25, 180), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(12, 14, 25, 206), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(76, 87, 153, 255), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(126, 144, 253, 30), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(133, 150, 255, 255), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(12, 14, 25, 225), true));
      return var1;
   }

   private ThemeSettings method09627() {
      ThemeSettings var1 = new ThemeSettings("Красная");
      var1.field22104.method11672(new Color(ColorUtils.method04592(255, 133, 142, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(160, 49, 57, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(4, 3, 3, 181), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(255, 255, 255, 175), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(153, 76, 82, 255), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(153, 76, 82, 255), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(76, 38, 41, 120), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(102, 51, 55, 255), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(76, 38, 41, 120), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(153, 69, 75, 50), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(25, 12, 13, 255), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(127, 57, 62, 3), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(25, 12, 13, 180), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(25, 12, 13, 206), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(25, 12, 13, 225), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(153, 76, 82, 255), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(253, 126, 136, 30), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(255, 133, 142, 255), true));
      return var1;
   }

   private ThemeSettings method09628() {
      ThemeSettings var1 = new ThemeSettings("Оранжевая");
      var1.field22104.method11672(new Color(ColorUtils.method04592(255, 187, 133, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(160, 98, 49, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(4, 3, 3, 181), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(255, 255, 255, 175), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(153, 110, 76, 255), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(153, 110, 76, 255), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(76, 55, 38, 120), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(102, 74, 51, 255), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(76, 55, 38, 120), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(153, 106, 69, 50), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(25, 18, 12, 255), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(127, 88, 57, 3), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(25, 18, 12, 180), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(25, 18, 12, 206), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(25, 18, 12, 225), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(153, 110, 76, 255), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(253, 182, 126, 30), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(255, 187, 133, 255), true));
      return var1;
   }

   private ThemeSettings method09629() {
      ThemeSettings var1 = new ThemeSettings("Розовая");
      var1.field22104.method11672(new Color(ColorUtils.method04592(255, 133, 190, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(160, 49, 101, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(4, 3, 3, 181), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(255, 255, 255, 175), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(153, 76, 112, 255), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(153, 76, 112, 255), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(76, 38, 56, 120), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(102, 51, 75, 255), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(76, 38, 56, 120), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(153, 69, 108, 50), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(25, 12, 18, 255), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(127, 57, 90, 3), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(25, 12, 18, 180), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(25, 12, 18, 206), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(25, 12, 18, 225), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(153, 76, 112, 255), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(253, 126, 185, 30), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(255, 133, 190, 255), true));
      return var1;
   }

   private ThemeSettings method09630() {
      ThemeSettings var1 = new ThemeSettings("Голубая");
      var1.field22104.method11672(new Color(ColorUtils.method04592(133, 249, 255, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(49, 155, 160, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(3, 4, 4, 181), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(255, 255, 255, 175), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(76, 149, 153, 255), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(76, 149, 153, 255), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(38, 74, 76, 120), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(51, 100, 102, 255), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(38, 74, 76, 120), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(69, 149, 153, 50), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(12, 24, 25, 255), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(57, 124, 127, 3), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(12, 24, 25, 180), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(12, 24, 25, 206), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(12, 24, 25, 225), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(76, 149, 153, 255), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(126, 247, 253, 30), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(133, 249, 255, 255), true));
      return var1;
   }

   private ThemeSettings method09631() {
      ThemeSettings var1 = new ThemeSettings("Темно-фиолетовая");
      var1.method09826("Miran");
      var1.field22104.method11672(new Color(ColorUtils.method04592(198, 133, 255, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(107, 49, 160, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(3, 3, 4, 181), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(255, 255, 255, 175), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(118, 76, 153, 255), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(118, 76, 153, 255), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(59, 38, 76, 120), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(78, 51, 102, 255), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(59, 38, 76, 120), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(103, 69, 153, 50), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(19, 12, 25, 255), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(86, 57, 127, 3), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(19, 12, 25, 180), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(19, 12, 25, 206), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(118, 76, 153, 255), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(179, 126, 253, 30), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(198, 133, 255, 255), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(19, 12, 25, 225), true));
      return var1;
   }

   private ThemeSettings method09632() {
      ThemeSettings var1 = new ThemeSettings("Темно-сиреневая");
      var1.method09826("Miran");
      var1.field22104.method11672(new Color(ColorUtils.method04592(95, 113, 191, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(49, 69, 135, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(3, 3, 4, 181), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(211, 228, 255, 206), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(208, 218, 240, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(164, 171, 171, 168), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(124, 131, 255, 59), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(82, 84, 157, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(124, 131, 255, 59), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(38, 43, 76, 67), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(82, 84, 157, 144), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(38, 43, 76, 67), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(82, 84, 157, 76), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(82, 84, 157, 84), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(3, 3, 4, 227), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(82, 84, 157, 13), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(3, 3, 4, 96), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(3, 3, 4, 181), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(82, 84, 157, 28), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(82, 84, 157, 166), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(133, 140, 255, 255), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(1, 3, 18, 175), true));
      return var1;
   }

   private ThemeSettings method09633() {
      ThemeSettings var1 = new ThemeSettings("Светло-сиреневая");
      var1.method09826("Miran");
      var1.field22104.method11672(new Color(ColorUtils.method04592(115, 135, 255, 255), true));
      var1.field22105.method11672(new Color(ColorUtils.method04592(50, 55, 164, 255), true));
      var1.field22106.method11672(new Color(ColorUtils.method04592(16, 18, 36, 199), true));
      var1.field22108.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22109.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22110.method11672(new Color(ColorUtils.method04592(203, 203, 203, 224), true));
      var1.field22111.method11672(new Color(ColorUtils.method04592(76, 80, 153, 255), true));
      var1.field22112.method11672(new Color(ColorUtils.method04592(255, 255, 255, 255), true));
      var1.field22113.method11672(new Color(ColorUtils.method04592(76, 80, 153, 255), true));
      var1.field22114.method11672(new Color(ColorUtils.method04592(38, 43, 76, 120), true));
      var1.field22115.method11672(new Color(ColorUtils.method04592(51, 52, 102, 255), true));
      var1.field22116.method11672(new Color(ColorUtils.method04592(38, 43, 76, 120), true));
      var1.field22117.method11672(new Color(ColorUtils.method04592(69, 70, 153, 29), true));
      var1.field22118.method11672(new Color(ColorUtils.method04592(255, 255, 255, 35), true));
      var1.field22119.method11672(new Color(ColorUtils.method04592(16, 18, 36, 255), true));
      var1.field22120.method11672(new Color(ColorUtils.method04592(42, 42, 94, 34), true));
      var1.field22121.method11672(new Color(ColorUtils.method04592(16, 18, 36, 167), true));
      var1.field22122.method11672(new Color(ColorUtils.method04592(11, 12, 28, 203), true));
      var1.field22123.method11672(new Color(ColorUtils.method04592(76, 80, 153, 255), true));
      var1.field22124.method11672(new Color(ColorUtils.method04592(126, 144, 253, 30), true));
      var1.field22125.method11672(new Color(ColorUtils.method04592(133, 140, 255, 255), true));
      var1.field22126.method11672(new Color(ColorUtils.method04592(13, 12, 25, 225), true));
      return var1;
   }

   public void method09634() {
      this.method09609(this.method09625());
      this.method09609(this.method09624());
      this.method09609(this.method09626());
      this.method09609(this.method09627());
      this.method09609(this.method09628());
      this.method09609(this.method09629());
      this.method09609(this.method09630());
      this.method09609(this.method09631());
      this.method09609(this.method09632());
      this.method09609(this.method09633());
      this.field21916 = this.field21917.size();
   }

   public int method09635() {
      return this.field21916;
   }

   public List<ThemeSettings> method09636() {
      return this.field21917;
   }

   public AnimationUtils method09637() {
      return this.field21919;
   }
}
