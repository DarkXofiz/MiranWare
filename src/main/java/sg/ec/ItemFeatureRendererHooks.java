// Original binary: sg/ec/FFAc8pmF5BjLUyaE
package sg.ec;

import java.util.HashMap;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class ItemFeatureRendererHooks {
   public static final ItemTransformSequence field07286 = new ItemTransformSequence();
   private static final HashMap<String, Boolean> field07287 = new HashMap<>();
   private static final HashMap<String, Boolean> field07288 = new HashMap<>();
   private static final HashMap<String, Boolean> field07289 = new HashMap<>();
   private static final HashMap<String, Integer> field07290 = new HashMap<>();
   private static final HashMap<String, Boolean> field07291 = new HashMap<>();
   private static final HashMap<String, Object> field07292 = new HashMap<>();
   public static float field07293 = 1.0F;
   public static float field07294 = 1.0F;
   public static float field07295 = 1.0F;
   public static float field07296 = 1.0F;
   public static float field07297 = 1.0F;
   public static float field07298 = 1.0F;
   public static float field07299 = 1.0F;
   public static float field07300 = 1.0F;
   private static float field07301 = 0.0F;
   private static float field07302 = 0.0F;
   private static float field07303 = 0.0F;
   private static final double field07304 = Math.PI;
   private static final double field07305 = 2.0;
   private static final double field07306 = 30.0;
   private static final double field07307 = -1.0;
   private static final double field07308 = 0.55;
   private static final float field07309 = 0.045F;
   private static final float field07310 = 30.0F;
   private static final float field07311 = 0.07F;
   private static final float field07312 = 30.0F;
   private static final double field07313 = 0.4;
   private static final double field07314 = 2.0;
   private static final double field07315 = 0.6;
   private static final double field07316 = -5.0;
   private static final double field07317 = 5.0;
   private static final float field07318 = 0.5F;
   private static final float field07319 = 0.7F;
   private static final float field07320 = 0.5F;
   private static final double field07321 = 0.6;
   private static final double field07322 = -5.0;
   private static final double field07323 = 5.0;
   private static final float field07324 = 0.5F;
   private static final float field07325 = 0.7F;
   private static final float field07326 = 0.5F;
   private static final double field07327 = 0.02;
   private static final double field07328 = 0.02;
   private static final double field07329 = -1.5;
   private static final double field07330 = 0.08;
   private static final double field07331 = 20.0;
   private static final double field07332 = -20.0;
   private static final double field07333 = 20.0;
   private static final float field07334 = 0.5F;
   private static final float field07335 = 0.7F;
   private static final float field07336 = 0.5F;
   private static final double field07337 = 2.0;
   private static final float field07338 = 0.5F;
   private static final float field07339 = 0.7F;
   private static final float field07340 = 0.5F;
   private static final double field07341 = 0.3;
   private static final float field07342 = 0.5F;
   private static final float field07343 = 0.7F;
   private static final float field07344 = 0.5F;
   private static final double field07345 = 0.3;
   private static final float field07346 = 0.5F;
   private static final float field07347 = 0.7F;
   private static final float field07348 = 0.5F;
   private static final double field07349 = 0.02;
   private static final double field07350 = -1.5;
   private static final double field07351 = 0.08;
   private static final double field07352 = 15.0;
   private static final double field07353 = -20.0;
   private static final double field07354 = 20.0;
   private static final float field07355 = 0.5F;
   private static final float field07356 = 0.7F;
   private static final float field07357 = 0.5F;
   private static final float field07358 = 0.5F;
   private static final float field07359 = 0.7F;
   private static final float field07360 = 0.5F;
   private static final double field07361 = 0.15;
   private static final float field07362 = 0.5F;
   private static final float field07363 = 0.7F;
   private static final float field07364 = 0.5F;
   private static final double field07365 = 0.15;
   private static final float field07366 = 0.5F;
   private static final float field07367 = 0.7F;
   private static final float field07368 = 0.5F;
   private static final double field07369 = 10.0;
   private static final double field07370 = 10.0;
   private static final double field07371 = 0.4;
   private static final double field07372 = 30.0;
   private static final float field07373 = 0.8F;
   private static final float field07374 = 0.5F;
   private static final float field07375 = 0.4F;
   private static final double field07376 = -10.0;
   private static final double field07377 = 10.0;
   private static final double field07378 = 0.4;
   private static final double field07379 = 30.0;
   private static final float field07380 = 0.3F;
   private static final float field07381 = 0.5F;
   private static final float field07382 = 0.4F;
   private static final double field07383 = 80.0;
   private static final float field07384 = 0.5F;
   private static final float field07385 = 0.85F;
   private static final float field07386 = 0.3F;
   private static final double field07387 = 15.0;
   private static final float field07388 = 0.5F;
   private static final float field07389 = 0.85F;
   private static final float field07390 = 0.3F;
   private static final double field07391 = 80.0;
   private static final float field07392 = 0.5F;
   private static final float field07393 = 0.85F;
   private static final float field07394 = 0.3F;
   private static final double field07395 = -15.0;
   private static final float field07396 = 0.5F;
   private static final float field07397 = 0.85F;
   private static final float field07398 = 0.3F;
   private static final double field07399 = 0.02;
   private static final double field07400 = 0.025;
   private static final double field07401 = 0.03;
   private static final double field07402 = 0.03;
   private static final double field07403 = 0.03;
   private static final double field07404 = 0.1;
   private static final double field07405 = 0.02;
   private static final double field07406 = -1.5;
   private static final double field07407 = 0.08;
   private static final double field07408 = 0.1;
   private static final double field07409 = -0.03;
   private static final double field07410 = 0.002;
   private static final float field07411 = 0.5F;
   private static final float field07412 = 0.5F;
   private static final float field07413 = 0.5F;
   private static final float field07414 = 0.5F;
   private static final float field07415 = 0.5F;
   private static final float field07416 = 0.5F;
   private static final double field07417 = 3.0;
   private static final double field07418 = 3.0;
   private static final float field07419 = 0.5F;
   private static final float field07420 = 0.5F;
   private static final float field07421 = 0.5F;
   private static final double field07422 = 15.0;
   private static final double field07423 = 3.0;
   private static final float field07424 = 0.5F;
   private static final float field07425 = 0.5F;
   private static final float field07426 = 0.5F;
   private static final double field07427 = 0.1;
   private static final double field07428 = 0.1;
   private static final double field07429 = 0.1;
   private static final double field07430 = 0.1;
   private static final double field07431 = 0.05;
   private static final double field07432 = 0.02;
   private static final double field07433 = -1.5;
   private static final double field07434 = 0.08;
   private static final double field07435 = 0.1;
   private static final double field07436 = -0.03;
   private static final double field07437 = 0.002;
   private static final double field07438 = 0.6;
   private static final float field07439 = 0.5F;
   private static final float field07440 = 0.5F;
   private static final float field07441 = 0.5F;
   private static final double field07442 = 0.6;
   private static final float field07443 = 0.5F;
   private static final float field07444 = 0.5F;
   private static final float field07445 = 0.5F;
   private static final double field07446 = 3.0;
   private static final double field07447 = 1.5;
   private static final float field07448 = 0.5F;
   private static final float field07449 = 0.5F;
   private static final float field07450 = 0.5F;
   private static final double field07451 = -10.0;
   private static final float field07452 = 0.5F;
   private static final float field07453 = 0.5F;
   private static final float field07454 = 0.5F;
   private static final double field07455 = -0.05;
   private static final double field07456 = 0.2;
   private static final float field07457 = 0.6F;
   private static final float field07458 = 0.2F;
   private static final double field07459 = -5.0;
   private static final float field07460 = 0.6F;
   private static final float field07461 = 0.2F;
   private static final double field07462 = 0.15;
   private static final double field07463 = 0.15;
   private static final double field07464 = 0.15;
   private static final double field07465 = 0.1;
   private static final double field07466 = 0.04;
   private static final double field07467 = 0.02;
   private static final double field07468 = -1.5;
   private static final double field07469 = 0.08;
   private static final double field07470 = 0.1;
   private static final double field07471 = 0.002;
   private static final double field07472 = 0.6;
   private static final float field07473 = 0.5F;
   private static final float field07474 = 0.5F;
   private static final double field07475 = 0.6;
   private static final float field07476 = 0.5F;
   private static final float field07477 = 0.5F;
   private static final float field07478 = 0.5F;
   private static final double field07479 = 3.0;
   private static final double field07480 = 1.5;
   private static final float field07481 = 0.5F;
   private static final float field07482 = 0.5F;
   private static final float field07483 = 0.5F;
   private static final double field07484 = -10.0;
   private static final float field07485 = 0.5F;
   private static final float field07486 = 0.5F;
   private static final float field07487 = 0.5F;
   private static final double field07488 = 0.2;
   private static final float field07489 = 0.6F;
   private static final float field07490 = 0.25F;
   private static final double field07491 = -5.0;
   private static final float field07492 = 0.6F;
   private static final float field07493 = 0.25F;
   private static final double field07494 = 0.1;
   private static final double field07495 = 0.02;
   private static final double field07496 = -1.5;
   private static final double field07497 = 0.08;
   private static final double field07498 = 0.1;
   private static final double field07499 = -0.03;
   private static final double field07500 = 0.002;
   private static final double field07501 = 0.6;
   private static final float field07502 = 0.5F;
   private static final float field07503 = 0.5F;
   private static final float field07504 = 0.5F;
   private static final double field07505 = 0.6;
   private static final float field07506 = 0.5F;
   private static final float field07507 = 0.5F;
   private static final float field07508 = 0.5F;
   private static final double field07509 = 0.6;
   private static final float field07510 = 0.5F;
   private static final float field07511 = 0.5F;
   private static final float field07512 = 0.5F;
   private static final double field07513 = 3.0;
   private static final double field07514 = 3.0;
   private static final float field07515 = 0.5F;
   private static final float field07516 = 0.5F;
   private static final float field07517 = 0.5F;
   private static final double field07518 = 0.1;
   private static final double field07519 = 0.02;
   private static final double field07520 = -1.5;
   private static final double field07521 = 0.08;
   private static final double field07522 = 0.1;
   private static final double field07523 = -0.03;
   private static final double field07524 = 0.002;
   private static final double field07525 = 0.2;
   private static final float field07526 = 0.5F;
   private static final float field07527 = 0.5F;
   private static final float field07528 = 0.5F;
   private static final double field07529 = 0.2;
   private static final float field07530 = 0.5F;
   private static final float field07531 = 0.5F;
   private static final float field07532 = 0.5F;
   private static final double field07533 = 0.2;
   private static final float field07534 = 0.5F;
   private static final float field07535 = 0.5F;
   private static final double field07536 = 3.0;
   private static final float field07537 = 0.5F;
   private static final float field07538 = 0.5F;
   private static final float field07539 = 0.5F;
   private static final double field07540 = 10.0;
   private static final double field07541 = 10.0;
   private static final double field07542 = 0.4;
   private static final double field07543 = 30.0;
   private static final float field07544 = 0.5F;
   private static final float field07545 = 0.5F;
   private static final float field07546 = 0.5F;
   private static final double field07547 = -10.0;
   private static final double field07548 = 10.0;
   private static final double field07549 = 0.4;
   private static final double field07550 = 30.0;
   private static final float field07551 = 0.5F;
   private static final float field07552 = 0.5F;
   private static final float field07553 = 0.5F;
   private static final double field07554 = 0.1;
   private static final double field07555 = 1.35;
   private static final double field07556 = 999.0;
   private static final float field07557 = 0.5F;
   private static final float field07558 = 0.5F;
   private static final float field07559 = 0.8F;
   private static final double field07560 = 0.12;
   private static final float field07561 = 0.5F;
   private static final float field07562 = 0.5F;

   public static boolean method03337(ItemStack var0) {
      return field07288.getOrDefault(var0.getItem().toString(), Boolean.FALSE);
   }

   public static boolean method03338(ItemStack var0) {
      return field07291.getOrDefault(var0.getItem().toString(), Boolean.FALSE);
   }

   public static boolean method03339(ItemStack var0) {
      return field07288.getOrDefault(var0.getItem().toString(), Boolean.FALSE);
   }

   public static boolean method03340(ItemStack var0) {
      return field07289.getOrDefault(var0.getItem().toString(), Boolean.FALSE);
   }

   public static boolean method03341(ItemStack var0) {
      return field07287.getOrDefault(var0.getItem().toString(), Boolean.TRUE);
   }

   public static void method03342(ItemStack var0, int var1) {
      field07290.put(var0.getItem().toString(), var1);
   }

   public static int method03343(ItemStack var0) {
      return field07290.getOrDefault(var0.getItem().toString(), 1);
   }

   public static boolean method03344(ItemStack var0) {
      return var0.is(Items.WATER_BUCKET)
         || var0.is(Items.LAVA_BUCKET)
         || var0.is(Items.MILK_BUCKET)
         || var0.is(Items.AXOLOTL_BUCKET)
         || var0.is(Items.TROPICAL_FISH_BUCKET)
         || var0.is(Items.COD_BUCKET)
         || var0.is(Items.SALMON_BUCKET)
         || var0.is(Items.TADPOLE_BUCKET)
         || var0.is(Items.PUFFERFISH_BUCKET)
         || var0.is(ItemTags.CHEST_BOATS);
   }

   private static double method03345(double var0) {
      return 1.0 - Math.cos(var0 * field07304 / field07305);
   }

   public static void method03346(ItemStack var0, Object var1) {
      field07292.put(var0.getItem().toString(), var1);
   }

   public static Object method03347(ItemStack var0) {
      return field07292.get(var0.getItem().toString());
   }

   public static void method03348(ItemStack var0, boolean var1) {
      field07287.put(var0.getItem().toString(), var1);
   }

   public static void method03349(ItemFeatureContext var0) {
      AbstractClientPlayer var1 = var0.field04549;
      if (var1 != null) {
         ItemStack var2 = var0.field04548;
         float var3 = var0.field04552;
         int var4 = var0.field04546 ? 1 : -1;
         Vec3 var5 = var1.getDeltaMovement();
         double var6 = var5.y;
         field07302 = field07302 + (float)(var6 * var3 * field07306);
         if (!var1.onGround() && var6 * field07307 > field07308) {
            field07301 = field07301 + field07309 * var3 * field07310;
         } else {
            field07301 = field07301 - field07311 * var3 * field07312;
         }

         field07301 = (float)Math.clamp(field07301, 0.0, 1.0);
         double var8 = ItemFeatureVariables.field24990.field25042;
         double var10 = ItemFeatureVariables.field24990.field25045;
         double var12 = ItemFeatureVariables.field24990.field25040;
         double var14 = ItemFeatureVariables.field24990.field25041;
         double var16 = Math.clamp(var8 * field07313, 0.0, field07314) * (field07301 * field07301 * field07301);
         double var18 = var0.field04551 ? ItemFeatureVariables.field24990.field25020 : ItemFeatureVariables.field24990.field25018;
         double var20 = var0.field04551 ? ItemFeatureVariables.field24990.field25019 : ItemFeatureVariables.field24990.field25017;
         if (var2.is(Items.WATER_BUCKET) || var2.is(Items.LAVA_BUCKET) || var2.is(Items.MILK_BUCKET)) {
            field07286.method11240(0, 1, (float)(Math.clamp(-var20 * field07315, field07316, field07317) * field07298), field07318, field07319, field07320);
            field07286.method11243(0, 1, (float)(Math.clamp(var18 * field07321, field07322, field07323) * field07298), field07324, field07325, field07326);
         }

         if (var2.is(Items.AXOLOTL_BUCKET)) {
            field07286.method11245(0, 11, (float)(var8 * field07327 * field07293));
            field07286.method11245(0, 11, (float)(field07328 * Math.sin(var10 * field07329) * (1.0 - var14) * field07293));
            field07286.method11245(0, 11, (float)(field07330 * method03345(Math.abs(Math.sin(var12))) * var14 * field07293));
            field07286.method11240(0, 11, (float)(Math.clamp(field07331 * var8, field07332, field07333) * field07293), field07334, field07335, field07336);
            field07286.method11243(0, 11, (float)(field07337 * Math.sin(var10) * field07293), field07338, field07339, field07340);
            field07286.method11240(0, 11, (float)(var20 * field07341 * field07293), field07342, field07343, field07344);
            field07286.method11243(0, 11, (float)(-var18 * field07345 * field07293), field07346, field07347, field07348);
            field07286.method11245(12, 19, (float)(field07349 * Math.sin(var10 * field07350) * (1.0 - var14) * field07293));
            field07286.method11245(12, 19, (float)(field07351 * method03345(Math.abs(Math.sin(var12))) * var14 * field07293));
            field07286.method11240(12, 19, (float)(Math.clamp(field07352 * var8, field07353, field07354) * field07293), field07355, field07356, field07357);
            field07286.method11243(12, 19, (float)(1.0 * Math.sin(var10) * field07293), field07358, field07359, field07360);
            field07286.method11240(12, 19, (float)(var20 * field07361 * field07293), field07362, field07363, field07364);
            field07286.method11243(12, 19, (float)(-var18 * field07365 * field07293), field07366, field07367, field07368);
            field07286.method11238(
               8,
               9,
               (float)(field07369 * Math.sin(var10 * field07370) * Math.pow(Math.sin(var10 * field07371), field07372) * field07293),
               field07373,
               field07374,
               field07375
            );
            field07286.method11238(
               10,
               11,
               (float)(field07376 * Math.sin(var10 * field07377) * Math.pow(Math.sin(var10 * field07378), field07379) * field07293),
               field07380,
               field07381,
               field07382
            );
            field07286.method11240(20, 21, (float)(field07383 * var16 * field07293), field07384, field07385, field07386);
            field07286.method11243(20, 21, (float)(field07387 * var16 * field07293), field07388, field07389, field07390);
            field07286.method11240(22, 23, (float)(field07391 * var16 * field07293), field07392, field07393, field07394);
            field07286.method11243(22, 23, (float)(field07395 * var16 * field07293), field07396, field07397, field07398);
            field07286.method11242(0, 23, (float)(var8 * field07399 * field07293));
            field07286.method11247(0, 23, (float)(var8 * field07400 * field07293));
            field07286.method11236(
               0,
               23,
               (float)(1.0 - field07401 * var8 * field07293),
               (float)(1.0 + field07402 * var8 * field07293),
               (float)(1.0 - field07403 * var8 * field07293)
            );
         }

         if (var2.is(Items.TROPICAL_FISH_BUCKET)) {
            field07286.method11245(0, 12, (float)(var8 * field07404 * field07299));
            field07286.method11245(0, 12, (float)(field07405 * Math.sin(var10 * field07406) * (1.0 - var14) * field07299));
            field07286.method11245(0, 12, (float)(field07407 * method03345(Math.abs(Math.sin(var12))) * var14 * field07299));
            field07286.method11247(0, 12, (float)(field07408 * field07299));
            field07286.method11245(0, 12, (float)(field07409 * field07299));
            field07286.method11245(0, 12, (float)(-var18 * field07410 * field07299));
            field07286.method11240(0, 12, (float)(-var18 * field07299), field07411, field07412, field07413);
            field07286.method11243(0, 12, (float)(-var20 * field07299), field07414, field07415, field07416);
            field07286.method11240(0, 12, (float)(field07417 * Math.sin(var10 * field07418) * (1.0 - var14) * field07299), field07419, field07420, field07421);
            field07286.method11243(6, 9, (float)(field07422 * Math.sin(var10 * field07423) * field07299), field07424, field07425, field07426);
         }

         if (var2.is(Items.COD_BUCKET)) {
            field07286.method11236(
               0, 25, (float)(1.0 - field07427 * field07296), (float)(1.0 - field07428 * field07296), (float)(1.0 - field07429 * field07296)
            );
            field07286.method11245(0, 25, (float)(var8 * field07430 * field07296));
            field07286.method11245(0, 25, (float)(field07431 * field07296));
            field07286.method11245(0, 25, (float)(field07432 * Math.sin(var10 * field07433) * (1.0 - var14) * field07296));
            field07286.method11245(0, 25, (float)(field07434 * method03345(Math.abs(Math.sin(var12))) * var14 * field07296));
            field07286.method11247(0, 25, (float)(field07435 * field07296));
            field07286.method11245(0, 25, (float)(field07436 * field07296));
            field07286.method11245(0, 25, (float)(-var18 * field07437 * field07296));
            field07286.method11240(0, 25, (float)(-var18 * field07438 * field07296), field07439, field07440, field07441);
            field07286.method11243(0, 25, (float)(-var20 * field07442 * field07296), field07443, field07444, field07445);
            field07286.method11240(0, 25, (float)(field07446 * Math.sin(var10 * field07447) * (1.0 - var14) * field07296), field07448, field07449, field07450);
            field07286.method11240(0, 25, (float)(var8 * field07451 * field07296), field07452, field07453, field07454);
            field07286.method11242(10, 21, (float)(field07455 * var4 * field07296));
            field07286.method11240(10, 21, (float)(-var18 * field07456 * field07296), 0.0F, field07457, field07458);
            field07286.method11240(10, 21, (float)(var8 * field07459 * field07296), 0.0F, field07460, field07461);
         }

         if (var2.is(Items.SALMON_BUCKET)) {
            field07286.method11236(
               0, 52, (float)(1.0 - field07462 * field07295), (float)(1.0 - field07463 * field07295), (float)(1.0 - field07464 * field07295)
            );
            field07286.method11245(0, 52, (float)(var8 * field07465 * field07295));
            field07286.method11245(0, 52, (float)(field07466 * field07295));
            field07286.method11245(0, 52, (float)(field07467 * Math.sin(var10 * field07468) * (1.0 - var14) * field07295));
            field07286.method11245(0, 52, (float)(field07469 * method03345(Math.abs(Math.sin(var12))) * var14 * field07295));
            field07286.method11247(0, 52, (float)(field07470 * field07295));
            field07286.method11245(0, 52, (float)(-var18 * field07471 * field07295));
            field07286.method11240(0, 52, (float)(-var18 * field07472 * field07295), 1.0F, field07473, field07474);
            field07286.method11243(0, 52, (float)(-var20 * field07475 * field07295), field07476, field07477, field07478);
            field07286.method11240(0, 52, (float)(field07479 * Math.sin(var10 * field07480) * (1.0 - var14) * field07295), field07481, field07482, field07483);
            field07286.method11240(0, 52, (float)(var8 * field07484 * field07295), field07485, field07486, field07487);
            field07286.method11240(0, 5, (float)(-var18 * field07488 * field07295), 0.0F, field07489, field07490);
            field07286.method11240(0, 5, (float)(var8 * field07491 * field07295), 0.0F, field07492, field07493);
         }

         if (var2.is(Items.TADPOLE_BUCKET)) {
            field07286.method11245(0, 7, (float)(var8 * field07494 * field07297));
            field07286.method11245(0, 7, (float)(field07495 * Math.sin(var10 * field07496) * (1.0 - var14) * field07297));
            field07286.method11245(0, 7, (float)(field07497 * method03345(Math.abs(Math.sin(var12))) * var14 * field07297));
            field07286.method11247(0, 7, (float)(field07498 * field07297));
            field07286.method11245(0, 7, (float)(field07499 * field07297));
            field07286.method11245(0, 7, (float)(-var18 * field07500 * field07297));
            field07286.method11238(0, 7, (float)(-var18 * field07501 * field07297), field07502, field07503, field07504);
            field07286.method11240(0, 7, (float)(-var20 * field07505 * field07297), field07506, field07507, field07508);
            field07286.method11243(0, 7, (float)(-var18 * field07509 * field07297), field07510, field07511, field07512);
            field07286.method11240(0, 7, (float)(field07513 * Math.sin(var10 * field07514) * (1.0 - var14) * field07297), field07515, field07516, field07517);
         }

         if (var2.is(Items.PUFFERFISH_BUCKET)) {
            field07286.method11245(0, 29, (float)(var8 * field07518 * field07294));
            field07286.method11245(0, 29, (float)(field07519 * Math.sin(var10 * field07520) * (1.0 - var14) * field07294));
            field07286.method11245(0, 29, (float)(field07521 * method03345(Math.abs(Math.sin(var12))) * var14 * field07294));
            field07286.method11247(0, 29, (float)(field07522 * field07294));
            field07286.method11245(0, 29, (float)(field07523 * field07294));
            field07286.method11245(0, 29, (float)(-var18 * field07524 * field07294));
            field07286.method11240(0, 29, (float)(Math.abs(-var18) * field07525 * field07294), field07526, field07527, field07528);
            field07286.method11240(0, 29, (float)(-var20 * field07529 * field07294), field07530, field07531, field07532);
            field07286.method11243(0, 29, (float)(-var18 * field07533 * field07294), 1.0F, field07534, field07535);
            field07286.method11240(0, 29, (float)(1.0 * Math.sin(var10 * field07536) * (1.0 - var14) * field07294), field07537, field07538, field07539);
            field07286.method11243(
               6,
               7,
               (float)(field07540 * Math.sin(var10 * field07541) * Math.pow(Math.sin(var10 * field07542), field07543) * field07294),
               field07544,
               field07545,
               field07546
            );
            field07286.method11243(
               8,
               9,
               (float)(field07547 * Math.sin(var10 * field07548) * Math.pow(Math.sin(var10 * field07549), field07550) * field07294),
               field07551,
               field07552,
               field07553
            );
         }

         if (var2.is(ItemTags.CHEST_BOATS)) {
            field07286.method11245(0, 15, (float)(Math.clamp(var8 * field07554, 0.0, 1.0) * field07300));
            field07286.method11240(0, 11, (float)(Math.clamp(var20 * field07555, 0.0, field07556) * field07300), field07557, field07558, field07559);
            field07286.method11243(0, 15, (float)(-var18 * field07560 * field07300), field07561, 0.0F, field07562);
         }
      }
   }

   public static void method03350(ItemStack var0, boolean var1) {
      field07288.put(var0.getItem().toString(), var1);
   }

   private ItemFeatureRendererHooks() {
   }

   public static void method03351(ItemStack var0, boolean var1) {
      field07291.put(var0.getItem().toString(), var1);
   }

   public static void method03352(ItemStack var0, boolean var1) {
      field07289.put(var0.getItem().toString(), var1);
   }
}
