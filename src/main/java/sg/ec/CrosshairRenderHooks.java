// Original binary: sg/ec/H8KxTgOCNNlIB9Px
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class CrosshairRenderHooks {
   public static final String field08340 = "textures/gui/sprites";
   public static final String field08341 = "field08341";
   public static final List<String> field08342 = List.of(CrosshairRenderHooks.field08459, CrosshairRenderHooks.field08460);
   private static final String field08343 = "field08343";
   private static final String field08344 = "field08344";
   private static final String field08345 = "field08345";
   private static final String field08346 = "field08346";
   private static final String field08347 = "field08347";
   private static final String field08348 = "field08348";
   private static final String field08349 = "field08349";
   private static final String field08350 = "field08350";
   private static final String field08351 = "field08351";
   private static final String field08352 = "field08352";
   private static final String field08353 = "field08353";
   private static final int field08354 = 0;
   private static final int field08355 = 0;
   private static final int field08356 = 0;
   private static final int field08357 = 0;
   private static final int field08358 = 0;
   private static final int field08359 = 0;
   private static final int field08360 = 0;
   private static final int field08361 = 0;
   private static final int field08362 = 0;
   private static final int field08363 = 0;
   private static final int field08364 = 0;
   private static final int field08365 = 0;
   private static final String field08366 = "field08366";
   private static final int field08367 = 0;
   private static final Map<String, CrosshairRenderHooks.Nested110> field08368 = method03748();
   private static final String field08369 = "textures/gui/sprites/hud/crosshair";
   private static final String field08370 = "textures/gui/icons.png";
   private static final String field08371 = "textures/gui/sprites/hud/crosshair_attack_indicator_background";
   private static final String field08372 = "textures/gui/icons.png";
   private static final String field08373 = "textures/gui/sprites/hud/crosshair_attack_indicator_progress";
   private static final String field08374 = "textures/gui/icons.png";
   private static final String field08375 = "textures/gui/sprites/hud/crosshair_attack_indicator_full";
   private static final String field08376 = "textures/gui/icons.png";
   private static final String field08377 = "textures/gui/sprites/hud/hotbar_attack_indicator_background";
   private static final String field08378 = "textures/gui/icons.png";
   private static final String field08379 = "textures/gui/sprites/hud/hotbar_attack_indicator_progress";
   private static final String field08380 = "textures/gui/icons.png";
   private static final String field08381 = "textures/gui/sprites/hud/armor_empty";
   private static final String field08382 = "textures/gui/sprites/hud/armor_half";
   private static final String field08383 = "textures/gui/sprites/hud/armor_full";
   private static final String field08384 = "textures/gui/sprites/hud/air";
   private static final String field08385 = "textures/gui/sprites/hud/air_bursting";
   private static final String field08386 = "textures/gui/sprites/hud/food_empty";
   private static final String field08387 = "textures/gui/sprites/hud/food_full";
   private static final String field08388 = "textures/gui/sprites/hud/food_half";
   private static final String field08389 = "textures/gui/sprites/hud/food_full_hunger";
   private static final String field08390 = "textures/gui/sprites/hud/food_half_hunger";
   private static final String field08391 = "textures/gui/sprites/hud/food_empty_hunger";
   private static final String field08392 = "textures/gui/sprites/hud/heart/vehicle_container";
   private static final String field08393 = "textures/gui/sprites/hud/heart/vehicle_full";
   private static final String field08394 = "textures/gui/sprites/hud/heart/vehicle_half";
   private static final String field08395 = "textures/gui/sprites/hud/experience_bar_background";
   private static final String field08396 = "textures/gui/icons.png";
   private static final String field08397 = "textures/gui/sprites/hud/experience_bar_progress";
   private static final String field08398 = "textures/gui/icons.png";
   private static final String field08399 = "textures/gui/sprites/hud/jump_bar_cooldown";
   private static final String field08400 = "textures/gui/icons.png";
   private static final String field08401 = "textures/gui/sprites/hud/jump_bar_background";
   private static final String field08402 = "textures/gui/icons.png";
   private static final String field08403 = "textures/gui/sprites/hud/jump_bar_progress";
   private static final String field08404 = "textures/gui/icons.png";
   private static final String field08405 = "hardcore_";
   private static final String field08406 = "textures/gui/sprites/hud/hotbar";
   private static final String field08407 = "textures/gui/widgets.png";
   private static final String field08408 = "textures/gui/sprites/hud/hotbar_selection";
   private static final String field08409 = "textures/gui/widgets.png";
   private static final String field08410 = "textures/gui/sprites/hud/hotbar_offhand_left";
   private static final String field08411 = "textures/gui/widgets.png";
   private static final String field08412 = "textures/gui/sprites/hud/hotbar_offhand_right";
   private static final String field08413 = "textures/gui/widgets.png";
   private static final String field08414 = "pink";
   private static final String field08415 = "blue";
   private static final String field08416 = "red";
   private static final String field08417 = "green";
   private static final String field08418 = "yellow";
   private static final String field08419 = "purple";
   private static final String field08420 = "white";
   private static final String field08421 = "textures/gui/sprites/hud/effect_background";
   private static final String field08422 = "textures/gui/container/inventory.png";
   private static final String field08423 = "textures/gui/sprites/hud/effect_background_ambient";
   private static final String field08424 = "textures/gui/container/inventory.png";
   private static final String field08425 = "container";
   private static final String field08426 = "container_hardcore";
   private static final String field08427 = "poisoned_";
   private static final String field08428 = "withered_";
   private static final String field08429 = "absorbing_";
   private static final String field08430 = "frozen_";
   private static final String field08431 = "generic_";
   private static final String field08432 = "splash_";
   private static final String field08433 = "effect_";
   private static final String field08434 = "spell_";
   private static final String field08435 = "spark_";
   private static final String field08436 = "glitter_";
   private static final String field08437 = "bubble";
   private static final String field08438 = "flame";
   private static final String field08439 = "lava";
   private static final String field08440 = "note";
   private static final String field08441 = "critical_hit";
   private static final String field08442 = "enchanted_hit";
   private static final String field08443 = "damage";
   private static final String field08444 = "heart";
   private static final String field08445 = "angry";
   private static final String field08446 = "glint";
   private static final String field08447 = "drip_hang";
   private static final String field08448 = "drip_fall";
   private static final String field08449 = "drip_land";
   private static final String field08450 = "textures/particle/flash.png";
   private static final String field08451 = "textures/particle/particles.png";
   private static final String field08452 = "abcdefghijklmnopqrstuvwxyz";
   private static final String field08453 = "abcdefghijklmnopqrstuvwxyz";
   private static final String field08454 = "textures/entity/explosion.png";
   private static final String field08455 = "textures/particle/particles.png";
   private static final String field08456 = "textures/gui/icons.png";
   private static final String field08457 = "textures/gui/bars.png";
   private static final String field08458 = "textures/gui/bars.png";
   private static final String field08459 = "textures/gui/sprites";
   private static final String field08460 = "textures/particle";

   private static void method03745(Map<String, CrosshairRenderHooks.Nested110> var0, String var1, int var2, int var3) {
      method03747(var0, var1, field08456, var2, var3, 9, 9);
   }

   private static void method03746(Map<String, CrosshairRenderHooks.Nested110> var0, String var1, String var2, int var3) {
      method03747(var0, var1, var2, 0, var3, 182, 5);
   }

   private static void method03747(Map<String, CrosshairRenderHooks.Nested110> var0, String var1, String var2, int var3, int var4, int var5, int var6) {
      var0.put(var1 + ".png", new CrosshairRenderHooks.Nested110(var2, 256, var3, var4, var5, var6));
   }

   private static Map<String, CrosshairRenderHooks.Nested110> method03748() {
      LinkedHashMap var0 = new LinkedHashMap();
      method03749(var0);
      method03751(var0);
      return Map.copyOf(var0);
   }

   private static void method03749(Map<String, CrosshairRenderHooks.Nested110> var0) {
      method03747(var0, field08369, field08370, 0, 0, 15, 15);
      method03747(var0, field08371, field08372, 36, 94, 16, 4);
      method03747(var0, field08373, field08374, 52, 94, 16, 4);
      method03747(var0, field08375, field08376, 68, 94, 16, 16);
      method03747(var0, field08377, field08378, 0, 94, 18, 18);
      method03747(var0, field08379, field08380, 18, 94, 18, 18);
      method03745(var0, field08381, 16, 9);
      method03745(var0, field08382, 25, 9);
      method03745(var0, field08383, 34, 9);
      method03745(var0, field08384, 16, 18);
      method03745(var0, field08385, 25, 18);
      method03745(var0, field08386, 16, 27);
      method03745(var0, field08387, 52, 27);
      method03745(var0, field08388, 61, 27);
      method03745(var0, field08389, 88, 27);
      method03745(var0, field08390, 97, 27);
      method03745(var0, field08391, 133, 27);
      method03745(var0, field08392, 52, 9);
      method03745(var0, field08393, 88, 9);
      method03745(var0, field08394, 97, 9);
      method03746(var0, field08395, field08396, 64);
      method03746(var0, field08397, field08398, 69);
      method03746(var0, field08399, field08400, 74);
      method03746(var0, field08401, field08402, 84);
      method03746(var0, field08403, field08404, 89);
      method03758(var0, "", 0);
      method03758(var0, field08405, 45);
      method03747(var0, field08406, field08407, 0, 0, 182, 22);
      method03747(var0, field08408, field08409, 0, 22, 24, 23);
      method03747(var0, field08410, field08411, 24, 22, 29, 24);
      method03747(var0, field08412, field08413, 53, 22, 29, 24);
      String[] var1 = new String[]{field08414, field08415, field08416, field08417, field08418, field08419, field08420};

      for (int var2 = 0; var2 < var1.length; var2++) {
         method03757(var0, var1[var2], var2 * 2 * 5);
      }

      int[] var4 = new int[]{6, 10, 12, 20};

      for (int var3 = 0; var3 < var4.length; var3++) {
         method03757(var0, "notched_" + var4[var3], 80 + var3 * 2 * 5);
      }

      method03747(var0, field08421, field08422, 141, 166, 24, 24);
      method03747(var0, field08423, field08424, 165, 166, 24, 24);
   }

   private static int method03750(byte[] var0, int var1) {
      return (var0[var1] & 0xFF) << 24 | (var0[var1 + 1] & 0xFF) << 16 | (var0[var1 + 2] & 0xFF) << 8 | var0[var1 + 3] & 0xFF;
   }

   private static void method03751(Map<String, CrosshairRenderHooks.Nested110> var0) {
      method03754(var0, field08431, 8, 0, 0);
      method03754(var0, field08432, 4, 24, 8);
      method03754(var0, field08433, 8, 0, 64);
      method03754(var0, field08434, 8, 0, 72);
      method03754(var0, field08435, 8, 0, 80);
      method03754(var0, field08436, 8, 0, 88);
      method03752(var0, field08437, 0, 16);
      method03752(var0, field08438, 0, 24);
      method03752(var0, field08439, 8, 24);
      method03752(var0, field08440, 0, 32);
      method03752(var0, field08441, 8, 32);
      method03752(var0, field08442, 16, 32);
      method03752(var0, field08443, 24, 32);
      method03752(var0, field08444, 0, 40);
      method03752(var0, field08445, 8, 40);
      method03752(var0, field08446, 16, 40);
      method03752(var0, field08447, 0, 56);
      method03752(var0, field08448, 8, 56);
      method03752(var0, field08449, 16, 56);
      var0.put(field08450, new CrosshairRenderHooks.Nested110(field08451, 128, 32, 16, 32, 32));

      for (int var1 = 0; var1 < field08452.length(); var1++) {
         int var2 = var1 < 15 ? 8 + var1 * 8 : (var1 - 15) * 8;
         int var3 = var1 < 15 ? 112 : 120;
         method03752(var0, "sga_" + field08453.charAt(var1), var2, var3);
      }

      for (int var4 = 0; var4 < 16; var4++) {
         var0.put("textures/particle/explosion_" + var4 + ".png", new CrosshairRenderHooks.Nested110(field08454, 128, var4 % 4 * 32, var4 / 4 * 32, 32, 32));
      }
   }

   private static void method03752(Map<String, CrosshairRenderHooks.Nested110> var0, String var1, int var2, int var3) {
      var0.put("textures/particle/" + var1 + ".png", new CrosshairRenderHooks.Nested110(field08455, 128, var2, var3, 8, 8));
   }

   public static List<String> method03753(String var0) {
      ArrayList var1 = new ArrayList();

      for (String var3 : field08368.keySet()) {
         if (var3.startsWith(var0)) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private CrosshairRenderHooks() {
   }

   private static void method03754(Map<String, CrosshairRenderHooks.Nested110> var0, String var1, int var2, int var3, int var4) {
      for (int var5 = 0; var5 < var2; var5++) {
         method03752(var0, var1 + var5, var3 + var5 * 8, var4);
      }
   }

   public static byte[] method03755(NativeImage var0, CrosshairRenderHooks.Nested110 var1) {
      int var2 = var0.getWidth();
      if (var2 >= var1.field08462 && var2 % var1.field08462 == 0) {
         int var3 = var2 / var1.field08462;
         int var4 = var1.field08463 * var3;
         int var5 = var1.field08464 * var3;
         int var6 = var1.field08465 * var3;
         int var7 = var1.field08466 * var3;
         if (var4 + var6 <= var2 && var5 + var7 <= var0.getHeight()) {
            try (NativeImage var8 = new NativeImage(var6, var7, false)) {
               var0.copyRect(var8, var4, var5, 0, 0, var6, var7, false, false);
               return PngEncoder.method00661(var8.getPixelBytes(), var6, var7);
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public static NativeImage method03756(InputStream var0) throws Exception {
      byte[] var1 = var0.readNBytes(24);
      if (method03760(var1)) {
         return null;
      }

      byte[] var2 = var0.readAllBytes();
      byte[] var3 = new byte[var1.length + var2.length];
      System.arraycopy(var1, 0, var3, 0, var1.length);
      System.arraycopy(var2, 0, var3, var1.length, var2.length);
      return NativeImage.read(var3);
   }

   private static void method03757(Map<String, CrosshairRenderHooks.Nested110> var0, String var1, int var2) {
      method03746(var0, "textures/gui/sprites/boss_bar/" + var1 + "_background", field08457, var2);
      method03746(var0, "textures/gui/sprites/boss_bar/" + var1 + "_progress", field08458, var2 + 5);
   }

   private static void method03758(Map<String, CrosshairRenderHooks.Nested110> var0, String var1, int var2) {
      String var3 = "textures/gui/sprites/hud/heart/" + (var1.isEmpty() ? field08425 : field08426);
      method03745(var0, var3, 16, var2);
      method03745(var0, var3 + "_blinking", 25, var2);
      String[] var4 = new String[]{"", field08427, field08428};

      for (int var5 = 0; var5 < var4.length; var5++) {
         String var6 = "textures/gui/sprites/hud/heart/" + var4[var5] + var1;
         int var7 = 52 + var5 * 36;
         method03745(var0, var6 + "full", var7, var2);
         method03745(var0, var6 + "half", var7 + 9, var2);
         method03745(var0, var6 + "full_blinking", var7 + 18, var2);
         method03745(var0, var6 + "half_blinking", var7 + 27, var2);
      }

      String[] var9 = new String[]{field08429, field08430};

      for (int var10 = 0; var10 < var9.length; var10++) {
         String var11 = "textures/gui/sprites/hud/heart/" + var9[var10] + var1;
         int var8 = 160 + var10 * 18;
         method03745(var0, var11 + "full", var8, var2);
         method03745(var0, var11 + "half", var8 + 9, var2);
         method03745(var0, var11 + "full_blinking", var8, var2);
         method03745(var0, var11 + "half_blinking", var8 + 9, var2);
      }
   }

   public static CrosshairRenderHooks.Nested110 method03759(Identifier var0) {
      return field08368.get(var0.getPath());
   }

   public static boolean method03760(byte[] var0) {
      if (var0.length < 24) {
         return true;
      }

      int var1 = method03750(var0, 16);
      int var2 = method03750(var0, 20);
      return var1 <= 0 || var2 <= 0 || var1 > 8192 || var2 > 8192;
   }

   // $VF: Compiled from s
   public static final class Nested110 {
      private final String field08461;
      private final int field08462;
      private final int field08463;
      private final int field08464;
      private final int field08465;
      private final int field08466;

      public String method03761() {
         return this.field08461;
      }

      public int method03762() {
         return this.field08466;
      }

      private Nested110(String var1, int var2, int var3, int var4, int var5, int var6) {
         this.field08461 = var1;
         this.field08462 = var2;
         this.field08463 = var3;
         this.field08464 = var4;
         this.field08465 = var5;
         this.field08466 = var6;
      }

      public int method03763() {
         return this.field08463;
      }

      public int method03764() {
         return this.field08465;
      }

      public int method03765() {
         return this.field08464;
      }

      public int method03766() {
         return this.field08462;
      }
   }
}
