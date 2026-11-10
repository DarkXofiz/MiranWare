// Original binary: sg/ec/fwTplczcstVBUTUR
package sg.ec;

// $VF: Compiled from s
public final class AnimationCurveMath {
   private static final double field19222 = 1.70158F;
   private static final double field19223 = 1.525F;
   private static final double field19224 = 0.5;
   private static final double field19225 = 2.0;
   private static final double field19226 = 2.0;
   private static final double field19227 = 2.0;
   private static final double field19228 = 2.0;
   private static final double field19229 = 2.0;
   private static final double field19230 = 2.0;
   private static final double field19231 = 2.0;
   private static final double field19232 = 2.0;
   private static final double field19233 = 2.0;
   private static final double field19234 = 2.0;
   private static final double field19235 = 2.0;
   private static final double field19236 = 1.70158F;
   private static final double field19237 = 1.70158F;
   private static final double field19238 = 3.0;
   private static final double field19239 = 2.0;
   private static final double field19240 = Math.PI;
   private static final double field19241 = 2.0;
   private static final double field19242 = Math.PI;
   private static final double field19243 = 2.0;
   private static final double field19244 = Math.PI;
   private static final double field19245 = 2.0;
   private static final double field19246 = 0.5;
   private static final double field19247 = 2.0;
   private static final double field19248 = -2.0;
   private static final double field19249 = 2.0;
   private static final double field19250 = 2.0;
   private static final double field19251 = 2.0;
   private static final double field19252 = 3.0;
   private static final double field19253 = 0.5;
   private static final double field19254 = 4.0;
   private static final double field19255 = -2.0;
   private static final double field19256 = 2.0;
   private static final double field19257 = 3.0;
   private static final double field19258 = 2.0;
   private static final double field19259 = 4.0;
   private static final double field19260 = 0.5;
   private static final double field19261 = 8.0;
   private static final double field19262 = -2.0;
   private static final double field19263 = 2.0;
   private static final double field19264 = 4.0;
   private static final double field19265 = 2.0;
   private static final double field19266 = 5.0;
   private static final double field19267 = 0.5;
   private static final double field19268 = 16.0;
   private static final double field19269 = -2.0;
   private static final double field19270 = 2.0;
   private static final double field19271 = 5.0;
   private static final double field19272 = 2.0;
   private static final double field19273 = 2.0;
   private static final double field19274 = 10.0;
   private static final double field19275 = 10.0;
   private static final double field19276 = 2.0;
   private static final double field19277 = -10.0;
   private static final double field19278 = 0.5;
   private static final double field19279 = 2.0;
   private static final double field19280 = 20.0;
   private static final double field19281 = 10.0;
   private static final double field19282 = 2.0;
   private static final double field19283 = 2.0;
   private static final double field19284 = 2.0;
   private static final double field19285 = -20.0;
   private static final double field19286 = 10.0;
   private static final double field19287 = 2.0;
   private static final double field19288 = 2.0;
   private static final double field19289 = 2.0;
   private static final double field19290 = 0.5;
   private static final double field19291 = 2.0;
   private static final double field19292 = 2.0;
   private static final double field19293 = 2.0;
   private static final double field19294 = -2.0;
   private static final double field19295 = 2.0;
   private static final double field19296 = 2.0;
   private static final double field19297 = 2.0;
   private static final double field19298 = Math.PI * 2.0 / 3.0;
   private static final double field19299 = 2.0;
   private static final double field19300 = 10.0;
   private static final double field19301 = 10.0;
   private static final double field19302 = 10.0;
   private static final double field19303 = 10.75;
   private static final double field19304 = Math.PI * 2.0 / 3.0;
   private static final double field19305 = 2.0;
   private static final double field19306 = -10.0;
   private static final double field19307 = 10.0;
   private static final double field19308 = 0.75;
   private static final double field19309 = Math.PI * 4.0 / 9.0;
   private static final double field19310 = 0.5;
   private static final double field19311 = 2.0;
   private static final double field19312 = 20.0;
   private static final double field19313 = 10.0;
   private static final double field19314 = 20.0;
   private static final double field19315 = 11.125;
   private static final double field19316 = 2.0;
   private static final double field19317 = 2.0;
   private static final double field19318 = -20.0;
   private static final double field19319 = 10.0;
   private static final double field19320 = 20.0;
   private static final double field19321 = 11.125;
   private static final double field19322 = 2.0;
   private static final double field19323 = 7.5625;
   private static final double field19324 = 2.75;
   private static final double field19325 = 2.0;
   private static final double field19326 = 1.5;
   private static final double field19327 = 0.75;
   private static final double field19328 = 2.5;
   private static final double field19329 = 2.25;
   private static final double field19330 = 0.9375;
   private static final double field19331 = 2.625;
   private static final double field19332 = 0.984375;
   private static final double field19333 = 0.5;
   private static final double field19334 = 2.0;
   private static final double field19335 = 2.0;
   private static final double field19336 = 2.0;
   private static final double field19337 = 2.0;
   private static final double field19338 = 3.0;
   private static final double field19339 = 2.0;

   public static double method08355(double var0) {
      if (var0 == 0.0) {
         return 0.0;
      } else if (var0 == 1.0) {
         return 1.0;
      } else {
         return var0 < field19278
            ? Math.pow(field19279, field19280 * var0 - field19281) / field19282
            : (field19283 - Math.pow(field19284, field19285 * var0 + field19286)) / field19287;
      }
   }

   public static double method08356(double var0) {
      return var0 < field19246 ? field19247 * var0 * var0 : 1.0 - Math.pow(field19248 * var0 + field19249, field19250) / field19251;
   }

   public static double method08357(double var0) {
      return var0 == 1.0 ? 1.0 : 1.0 - Math.pow(field19276, field19277 * var0);
   }

   public static double method08358(double var0) {
      return var0 * var0 * var0;
   }

   public static double method08359(double var0) {
      return var0 < field19290
         ? (1.0 - Math.sqrt(1.0 - Math.pow(field19291 * var0, field19292))) / field19293
         : (Math.sqrt(1.0 - Math.pow(field19294 * var0 + field19295, field19296)) + 1.0) / field19297;
   }

   public static double method08360(double var0) {
      return var0 < field19260 ? field19261 * var0 * var0 * var0 * var0 : 1.0 - Math.pow(field19262 * var0 + field19263, field19264) / field19265;
   }

   public static double method08361(double var0) {
      return -(Math.cos(field19244 * var0) - 1.0) / field19245;
   }

   public static double method08362(double var0) {
      double var2 = field19236;
      double var4 = var2 + 1.0;
      return var4 * var0 * var0 * var0 - var2 * var0 * var0;
   }

   public static double method08363(double var0) {
      return 1.0 - Math.pow(1.0 - var0, field19259);
   }

   public static double method08364(double var0) {
      return Math.sin(var0 * field19242 / field19243);
   }

   public static double method08365(double var0) {
      return 1.0 - (1.0 - var0) * (1.0 - var0);
   }

   public static double method08366(double var0) {
      return var0 * var0 * var0 * var0 * var0;
   }

   public static double method08367(double var0) {
      double var2 = field19222;
      double var4 = var2 * field19223;
      return var0 < field19224
         ? Math.pow(field19225 * var0, field19226) * ((var4 + 1.0) * field19227 * var0 - var4) / field19228
         : (Math.pow(field19229 * var0 - field19230, field19231) * ((var4 + 1.0) * (var0 * field19232 - field19233) + var4) + field19234) / field19235;
   }

   public static double method08368(double var0) {
      return 1.0 - Math.pow(1.0 - var0, field19266);
   }

   public static double method08369(double var0) {
      return var0 == 0.0 ? 0.0 : Math.pow(field19273, field19274 * var0 - field19275);
   }

   private AnimationCurveMath() {
   }

   public static double method08370(double var0) {
      return var0 < field19333 ? (1.0 - method08373(1.0 - field19334 * var0)) / field19335 : (1.0 + method08373(field19336 * var0 - 1.0)) / field19337;
   }

   public static double method08371(double var0) {
      return 1.0 - method08373(1.0 - var0);
   }

   public static double method08372(double var0) {
      return var0 * var0;
   }

   public static double method08373(double var0) {
      double var2 = field19323;
      double var4 = field19324;
      if (var0 < 1.0 / var4) {
         return var2 * var0 * var0;
      } else if (var0 < field19325 / var4) {
         var0 -= field19326 / var4;
         return var2 * var0 * var0 + field19327;
      } else if (var0 < field19328 / var4) {
         var0 -= field19329 / var4;
         return var2 * var0 * var0 + field19330;
      } else {
         var0 -= field19331 / var4;
         return var2 * var0 * var0 + field19332;
      }
   }

   public static double method08374(double var0) {
      return var0 * var0 * var0 * var0;
   }

   public static double method08375(double var0) {
      double var2 = field19237;
      double var4 = var2 + 1.0;
      return 1.0 + var4 * Math.pow(var0 - 1.0, field19238) + var2 * Math.pow(var0 - 1.0, field19239);
   }

   public static double method08376(double var0) {
      return var0 < field19253 ? field19254 * var0 * var0 * var0 : 1.0 - Math.pow(field19255 * var0 + field19256, field19257) / field19258;
   }

   public static double method08377(double var0) {
      return 1.0 - Math.pow(1.0 - var0, field19252);
   }

   public static double method08378(double var0) {
      double var2 = field19304;
      if (var0 == 0.0) {
         return 0.0;
      } else {
         return var0 == 1.0 ? 1.0 : Math.pow(field19305, field19306 * var0) * Math.sin((var0 * field19307 - field19308) * var2) + 1.0;
      }
   }

   public static double method08379(double var0) {
      return 1.0 - Math.sqrt(1.0 - Math.pow(var0, field19288));
   }

   public static double method08380(double var0) {
      return Math.sqrt(1.0 - Math.pow(var0 - 1.0, field19289));
   }

   public static double method08381(double var0) {
      double var2 = field19309;
      if (var0 == 0.0) {
         return 0.0;
      } else if (var0 == 1.0) {
         return 1.0;
      } else {
         return var0 < field19310
            ? -(Math.pow(field19311, field19312 * var0 - field19313) * Math.sin((field19314 * var0 - field19315) * var2)) / field19316
            : Math.pow(field19317, field19318 * var0 + field19319) * Math.sin((field19320 * var0 - field19321) * var2) / field19322 + 1.0;
      }
   }

   public static double method08382(double var0) {
      return var0 < field19267 ? field19268 * var0 * var0 * var0 * var0 * var0 : 1.0 - Math.pow(field19269 * var0 + field19270, field19271) / field19272;
   }

   public static double method08383(double var0) {
      double var2 = field19298;
      if (var0 == 0.0) {
         return 0.0;
      } else {
         return var0 == 1.0 ? 1.0 : -Math.pow(field19299, field19300 * var0 - field19301) * Math.sin((var0 * field19302 - field19303) * var2);
      }
   }

   public static double method08384(double var0) {
      return var0 * var0 * (field19338 - field19339 * var0);
   }

   public static double method08385(double var0) {
      return 1.0 - Math.cos(var0 * field19240 / field19241);
   }
}
