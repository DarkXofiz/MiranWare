// Original binary: sg/ec/gCkJngMoU3DW2l10
package sg.ec;

// $VF: Compiled from s
public final class Easings {
   public static final double field19389 = 1.70158;
   public static final double field19390 = 0;
   public static final double field19391 = 0;
   public static final double field19392 = 0;
   public static final double field19393 = 0;
   public static final EasingFunction field19394 = var0 -> var0;
   public static final EasingFunction field19395 = method08445(2);
   public static final EasingFunction field19396 = method08429(1.0);
   public static final EasingFunction field19397 = method08426(2);
   public static final EasingFunction field19398 = method08434(Easings.field19534);
   public static final EasingFunction field19399 = method08445(3);
   public static final EasingFunction field19400 = method08426(3);
   public static final EasingFunction field19401 = method08434(Easings.field19535);
   public static final EasingFunction field19402 = method08445(4);
   public static final EasingFunction field19403 = method08426(4);
   public static final EasingFunction field19404 = method08434(Easings.field19536);
   public static final EasingFunction field19405 = method08445(5);
   public static final EasingFunction field19406 = method08426(5);
   public static final EasingFunction field19407 = method08434(Easings.field19537);
   public static final EasingFunction field19408 = var0 -> 1.0 - Math.cos(var0 * Easings.field19532 / Easings.field19533);
   public static final EasingFunction field19409 = var0 -> Math.sin(var0 * Easings.field19530 / Easings.field19531);
   public static final EasingFunction field19410 = var0 -> -(Math.cos(Easings.field19528 * var0) - 1.0) / Easings.field19529;
   public static final EasingFunction field19411 = var0 -> 1.0 - Math.sqrt(1.0 - Math.pow(var0, Easings.field19527));
   public static final EasingFunction field19412 = var0 -> Math.sqrt(1.0 - Math.pow(var0 - 1.0, Easings.field19526));
   public static final EasingFunction field19413 = var0 -> var0 < Easings.field19518
      ? (1.0 - Math.sqrt(1.0 - Math.pow(Easings.field19519 * var0, Easings.field19520))) / Easings.field19521
      : (Math.sqrt(1.0 - Math.pow(Easings.field19522 * var0 + Easings.field19523, Easings.field19524)) + 1.0)
         / Easings.field19525;
   public static final EasingFunction field19414 = var0 -> var0 != 0.0 && var0 != 1.0
      ? Math.pow(Easings.field19512, Easings.field19513 * var0 - Easings.field19514)
         * Math.sin((var0 * Easings.field19515 - Easings.field19516) * Easings.field19517)
      : var0;
   public static final EasingFunction field19415 = var0 -> var0 != 0.0 && var0 != 1.0
      ? Math.pow(Easings.field19507, Easings.field19508 * var0)
            * Math.sin((var0 * Easings.field19509 - Easings.field19510) * Easings.field19511)
         + 1.0
      : var0;
   public static final EasingFunction field19416 = var0 -> {
      if (var0 != 0.0 && var0 != 1.0) {
         return var0 < Easings.field19492
            ? -(
                  Math.pow(Easings.field19493, Easings.field19494 * var0 - Easings.field19495)
                     * Math.sin((Easings.field19496 * var0 - Easings.field19497) * Easings.field19498)
               )
               / Easings.field19499
            : Math.pow(Easings.field19500, Easings.field19501 * var0 + Easings.field19502)
                  * Math.sin((Easings.field19503 * var0 - Easings.field19504) * Easings.field19505)
                  / Easings.field19506
               + 1.0;
      } else {
         return var0;
      }
   };
   public static final EasingFunction field19417 = var0 -> var0 != 0.0
      ? Math.pow(Easings.field19489, Easings.field19490 * var0 - Easings.field19491)
      : var0;
   public static final EasingFunction field19418 = var0 -> var0 != 1.0
      ? 1.0 - Math.pow(Easings.field19487, Easings.field19488 * var0)
      : var0;
   public static final EasingFunction field19419 = var0 -> {
      if (var0 != 0.0 && var0 != 1.0) {
         return var0 < Easings.field19477
            ? Math.pow(Easings.field19478, Easings.field19479 * var0 - Easings.field19480) / Easings.field19481
            : (Easings.field19482 - Math.pow(Easings.field19483, Easings.field19484 * var0 + Easings.field19485))
               / Easings.field19486;
      } else {
         return var0;
      }
   };
   public static final EasingFunction field19420 = var0 -> Easings.field19473 * Math.pow(var0, Easings.field19474)
      - Easings.field19475 * Math.pow(var0, Easings.field19476);
   public static final EasingFunction field19421 = var0 -> 1.0
      + Easings.field19469 * Math.pow(var0 - 1.0, Easings.field19470)
      + Easings.field19471 * Math.pow(var0 - 1.0, Easings.field19472);
   public static final EasingFunction field19422 = var0 -> var0 < Easings.field19454
      ? Math.pow(Easings.field19455 * var0, Easings.field19456)
         * (Easings.field19457 * var0 - Easings.field19458)
         / Easings.field19459
      : (
            Math.pow(Easings.field19460 * var0 - Easings.field19461, Easings.field19462)
                  * (Easings.field19463 * (var0 * Easings.field19464 - Easings.field19465) + Easings.field19466)
               + Easings.field19467
         )
         / Easings.field19468;
   public static final EasingFunction field19423 = var0 -> {
      double var2 = Easings.field19440;
      double var4 = Easings.field19441;
      if (var0 < 1.0 / var4) {
         return var2 * Math.pow(var0, Easings.field19442);
      } else if (var0 < Easings.field19443 / var4) {
         return var2 * Math.pow(var0 - Easings.field19444 / var4, Easings.field19445) + Easings.field19446;
      } else {
         return var0 < Easings.field19447 / var4
            ? var2 * Math.pow(var0 - Easings.field19448 / var4, Easings.field19449) + Easings.field19450
            : var2 * Math.pow(var0 - Easings.field19451 / var4, Easings.field19452) + Easings.field19453;
      }
   };
   public static final EasingFunction field19424 = var0 -> 1.0 - field19423.method07086(1.0 - var0);
   public static final EasingFunction field19425 = var0 -> var0 < Easings.field19435
      ? (1.0 - field19423.method07086(1.0 - Easings.field19436 * var0)) / Easings.field19437
      : (1.0 + field19423.method07086(Easings.field19438 * var0 - 1.0)) / Easings.field19439;
   private static final float field19426 = 5.0F;
   private static final String field19427 = "This is a utility class and cannot be instantiated";
   private static final double field19428 = 3.0;
   private static final double field19429 = 2.0;
   private static final double field19430 = 0.5;
   private static final double field19431 = 2.0;
   private static final double field19432 = -2.0;
   private static final double field19433 = 2.0;
   private static final double field19434 = 2.0;
   private static final double field19435 = 0.5;
   private static final double field19436 = 2.0;
   private static final double field19437 = 2.0;
   private static final double field19438 = 2.0;
   private static final double field19439 = 2.0;
   private static final double field19440 = 7.5625;
   private static final double field19441 = 2.75;
   private static final double field19442 = 2.0;
   private static final double field19443 = 2.0;
   private static final double field19444 = 1.5;
   private static final double field19445 = 2.0;
   private static final double field19446 = 0.75;
   private static final double field19447 = 2.5;
   private static final double field19448 = 2.25;
   private static final double field19449 = 2.0;
   private static final double field19450 = 0.9375;
   private static final double field19451 = 2.625;
   private static final double field19452 = 2.0;
   private static final double field19453 = 0.984375;
   private static final double field19454 = 0.5;
   private static final double field19455 = 2.0;
   private static final double field19456 = 2.0;
   private static final double field19457 = 7.189819;
   private static final double field19458 = 2.5949095;
   private static final double field19459 = 2.0;
   private static final double field19460 = 2.0;
   private static final double field19461 = 2.0;
   private static final double field19462 = 2.0;
   private static final double field19463 = 3.5949095;
   private static final double field19464 = 2.0;
   private static final double field19465 = 2.0;
   private static final double field19466 = 2.5949095;
   private static final double field19467 = 2.0;
   private static final double field19468 = 2.0;
   private static final double field19469 = 2.70158;
   private static final double field19470 = 3.0;
   private static final double field19471 = 1.70158;
   private static final double field19472 = 2.0;
   private static final double field19473 = 2.70158;
   private static final double field19474 = 3.0;
   private static final double field19475 = 1.70158;
   private static final double field19476 = 2.0;
   private static final double field19477 = 0.5;
   private static final double field19478 = 2.0;
   private static final double field19479 = 20.0;
   private static final double field19480 = 10.0;
   private static final double field19481 = 2.0;
   private static final double field19482 = 2.0;
   private static final double field19483 = 2.0;
   private static final double field19484 = -20.0;
   private static final double field19485 = 10.0;
   private static final double field19486 = 2.0;
   private static final double field19487 = 2.0;
   private static final double field19488 = -10.0;
   private static final double field19489 = 2.0;
   private static final double field19490 = 10.0;
   private static final double field19491 = 10.0;
   private static final double field19492 = 0.5;
   private static final double field19493 = 2.0;
   private static final double field19494 = 20.0;
   private static final double field19495 = 10.0;
   private static final double field19496 = 20.0;
   private static final double field19497 = 11.125;
   private static final double field19498 = Math.PI * 4.0 / 9.0;
   private static final double field19499 = 2.0;
   private static final double field19500 = 2.0;
   private static final double field19501 = -20.0;
   private static final double field19502 = 10.0;
   private static final double field19503 = 20.0;
   private static final double field19504 = 11.125;
   private static final double field19505 = Math.PI * 4.0 / 9.0;
   private static final double field19506 = 2.0;
   private static final double field19507 = 2.0;
   private static final double field19508 = -10.0;
   private static final double field19509 = 10.0;
   private static final double field19510 = 0.75;
   private static final double field19511 = Math.PI * 2.0 / 3.0;
   private static final double field19512 = -2.0;
   private static final double field19513 = 10.0;
   private static final double field19514 = 10.0;
   private static final double field19515 = 10.0;
   private static final double field19516 = 10.75;
   private static final double field19517 = Math.PI * 2.0 / 3.0;
   private static final double field19518 = 0.5;
   private static final double field19519 = 2.0;
   private static final double field19520 = 2.0;
   private static final double field19521 = 2.0;
   private static final double field19522 = -2.0;
   private static final double field19523 = 2.0;
   private static final double field19524 = 2.0;
   private static final double field19525 = 2.0;
   private static final double field19526 = 2.0;
   private static final double field19527 = 2.0;
   private static final double field19528 = Math.PI;
   private static final double field19529 = 2.0;
   private static final double field19530 = Math.PI;
   private static final double field19531 = 2.0;
   private static final double field19532 = Math.PI;
   private static final double field19533 = 2.0;
   private static final double field19534 = 2.0;
   private static final double field19535 = 3.0;
   private static final double field19536 = 4.0;
   private static final double field19537 = 5.0;

   public static EasingFunction method08423(double var0) {
      return var2 -> Math.pow(var2, var0);
   }

   private Easings() {
      throw new UnsupportedOperationException(field19427);
   }

   public static EasingFunction method08426(int var0) {
      return method08437(var0);
   }

   public static EasingFunction method08429(double var0) {
      double var2 = var0;
      float var4 = field19426;
      return var3 -> Math.max(0.0, 1.0 + var4 * Math.pow(var2 - 1.0, field19428) + var3 * Math.pow(var2 - 1.0, field19429));
   }

   public static EasingFunction method08434(double var0) {
      return var2 -> var2 < field19430
         ? Math.pow(field19431, var0 - 1.0) * Math.pow(var2, var0)
         : 1.0 - Math.pow(field19432 * var2 + field19433, var0) / field19434;
   }

   public static EasingFunction method08437(double var0) {
      return var2 -> 1.0 - Math.pow(1.0 - var2, var0);
   }

   public static EasingFunction method08445(int var0) {
      return method08423(var0);
   }
}
