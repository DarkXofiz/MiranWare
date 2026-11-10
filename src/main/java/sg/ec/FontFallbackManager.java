// Original binary: sg/ec/bzOCItEiEmicGcqm
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

// $VF: Compiled from s
public final class FontFallbackManager {
   private static final long field17458 = 15000L;
   private static final long field17459 = 0;
   private static final Map<FontFallbackManager.Nested211, FontFallbackManager.Nested210> field17460 = new HashMap<>();
   private static final List<FontFallbackManager.Nested210> field17461 = new ArrayList<>();
   private static long field17462;
   private static FontFallbackManager.Nested210 field17463;
   private static String field17464;
   private static String field17465;
   private static int field17466;
   private static int field17467;
   private static int field17468;
   private static int field17469;
   private static FontFallbackManager.Nested210 field17470;
   private static String field17471;
   private static int field17472;
   private static int field17473;
   private static int field17474;
   private static int field17475;
   private static final long field17476 = 1000L;
   private static final String field17477 = "default";
   private static final String field17478 = "default";
   private static final String field17479 = "null";
   private static final int field17480 = 16777215;
   private static final String field17481 = "This is a utility class and cannot be instantiated";

   public static String method07175(String var0, String var1, int var2, int var3, int var4) {
      return method07178(var0, var1, var2, var3, var4, 5);
   }

   public static void method07176() {
      long var0 = System.currentTimeMillis();
      if (!field17461.isEmpty()) {
         for (FontFallbackManager.Nested210 var3 : field17461) {
            var3.method07195(var0);
            var3.method07196();
         }

         field17461.clear();
      }

      if (var0 - field17462 >= field17476) {
         var var4 = field17460.entrySet().iterator();

         while (var4.hasNext()) {
            FontFallbackManager.Nested210 var5 = (FontFallbackManager.Nested210)((Entry)var4.next()).getValue();
            if (var5.method07197(var0)) {
               var4.remove();
            }
         }

         field17462 = var0;
      }
   }

   public static String method07177(String var0, String var1, int var2, int var3) {
      return method07175(var0, var1, var2, var3, 20);
   }

   public static String method07178(String var0, String var1, int var2, int var3, int var4, int var5) {
      if (var1 != null && !var1.isEmpty()) {
         String var6 = var0 != null && !var0.isEmpty() ? var0 : field17477;
         int var7 = method07181(var2);
         int var8 = method07181(var3);
         if (field17463 != null
            && Objects.equals(field17464, var6)
            && Objects.equals(field17465, var1)
            && field17466 == var7
            && field17467 == var8
            && field17468 == var4
            && field17469 == var5) {
            long var11 = System.currentTimeMillis();
            field17463.method07202(var1, var7, var8, var4, var5);
            field17463.method07199(var11);
            field17463.method07200(field17461);
            return field17463.method07193();
         } else {
            FontFallbackManager.Nested210 var9 = method07180(method07188(var6, var1), var1, var7, var8, var4, var5);
            field17463 = var9;
            field17464 = var6;
            field17465 = var1;
            field17466 = var7;
            field17467 = var8;
            field17468 = var4;
            field17469 = var5;
            return var9.method07193();
         }
      } else {
         return "";
      }
   }

   public static String method07179(String var0, int var1, int var2) {
      return method07192(var0, var1, var2, 20);
   }

   private static FontFallbackManager.Nested210 method07180(FontFallbackManager.Nested211 var0, String var1, int var2, int var3, int var4, int var5) {
      long var6 = System.currentTimeMillis();
      FontFallbackManager.Nested210 var8 = field17460.get(var0);
      if (var8 == null) {
         var8 = new FontFallbackManager.Nested210(var1, var2, var3, var4, var5, var6);
         field17460.put(var0, var8);
      }

      var8.method07202(var1, var2, var3, var4, var5);
      var8.method07199(var6);
      var8.method07200(field17461);
      return var8;
   }

   private static int method07181(int var0) {
      return var0 & field17480;
   }

   private static FontFallbackManager.Nested211 method07182(String var0, int var1, int var2, int var3, int var4) {
      return new FontFallbackManager.Nested211(false, null, var0, var1, var2, var3, var4);
   }

   public static Component method07183(String var0, int var1, int var2, int var3, int var4) {
      return var0 != null && !var0.isEmpty()
         ? method07190(method07182(var0, var1, var2, var3, var4), var0, var1, var2, var3, var4).method07203()
         : Component.empty();
   }

   private FontFallbackManager() {
      throw new UnsupportedOperationException(field17481);
   }

   public static Component method07184(String var0, String var1, int var2, int var3, int var4) {
      return method07187(var0, var1, var2, var3, var4, 5);
   }

   public static Component method07185(String var0, String var1, int var2, int var3) {
      return method07184(var0, var1, var2, var3, 20);
   }

   public static String method07186(String var0, int var1, int var2, int var3, int var4) {
      if (var0 != null && !var0.isEmpty()) {
         int var5 = method07181(var1);
         int var6 = method07181(var2);
         if (field17470 != null && Objects.equals(field17471, var0) && field17472 == var5 && field17473 == var6 && field17474 == var3 && field17475 == var4) {
            long var9 = System.currentTimeMillis();
            field17470.method07202(var0, var5, var6, var3, var4);
            field17470.method07199(var9);
            field17470.method07200(field17461);
            return field17470.method07193();
         } else {
            FontFallbackManager.Nested210 var7 = method07180(method07182(var0, var5, var6, var3, var4), var0, var5, var6, var3, var4);
            field17470 = var7;
            field17471 = var0;
            field17472 = var5;
            field17473 = var6;
            field17474 = var3;
            field17475 = var4;
            return var7.method07193();
         }
      } else {
         return "";
      }
   }

   public static Component method07187(String var0, String var1, int var2, int var3, int var4, int var5) {
      return var1 != null && !var1.isEmpty() ? method07190(method07188(var0, var1), var1, var2, var3, var4, var5).method07203() : Component.empty();
   }

   private static FontFallbackManager.Nested211 method07188(String var0, String var1) {
      String var2 = var0 != null && !var0.isEmpty() ? var0 : field17478;
      String var3 = var1 == null ? field17479 : var1;
      return new FontFallbackManager.Nested211(true, var2, var3, 0, 0, 0, 0);
   }

   public static Component method07189(String var0, int var1, int var2, int var3) {
      return method07183(var0, var1, var2, var3, 5);
   }

   private static FontFallbackManager.Nested210 method07190(FontFallbackManager.Nested211 var0, String var1, int var2, int var3, int var4, int var5) {
      long var6 = System.currentTimeMillis();
      FontFallbackManager.Nested210 var8 = field17460.get(var0);
      if (var8 == null) {
         var8 = new FontFallbackManager.Nested210(var1, var2, var3, var4, var5, var6);
         field17460.put(var0, var8);
      }

      var8.method07202(var1, var2, var3, var4, var5);
      var8.method07201(var6);
      var8.method07200(field17461);
      return var8;
   }

   public static Component method07191(String var0, int var1, int var2) {
      return method07189(var0, var1, var2, 20);
   }

   public static String method07192(String var0, int var1, int var2, int var3) {
      return method07186(var0, var1, var2, var3, 5);
   }

   // $VF: Compiled from s
   private static final class Nested210 {
      private String field17482;
      private int field17483;
      private int field17484;
      private int field17485;
      private int field17486;
      private MutableComponent field17487;
      private String field17488;
      private long field17489;
      private long field17490;
      private boolean field17491;
      private boolean field17492;
      private boolean field17493;
      private boolean field17494;
      private static final long field17495 = 15000L;

      private String method07193() {
         if (this.field17488 == null) {
            this.field17488 = FontRenderer.method09483(this.field17487);
         }

         return this.field17488;
      }

      private long method07194(long var1) {
         return var1 / Math.max(1, this.field17486);
      }

      private void method07195(long var1) {
         if (this.field17491 || this.field17492 || this.field17493) {
            long var3 = this.method07194(var1);
            boolean var5 = this.field17493 || var3 != this.field17490;
            if (var5) {
               this.field17487 = ChatTextUtils.method05097(this.field17482, this.field17483, this.field17484, this.field17485, this.field17486);
               this.field17490 = var3;
               if (this.field17492) {
                  this.field17488 = FontRenderer.method09483(this.field17487);
               } else {
                  this.field17488 = null;
               }
            } else if (this.field17492 && this.field17488 == null) {
               this.field17488 = FontRenderer.method09483(this.field17487);
            }

            this.field17493 = false;
            this.method07198();
         }
      }

      private void method07196() {
         this.field17494 = false;
      }

      private boolean method07197(long var1) {
         return var1 - this.field17489 > field17495;
      }

      private void method07198() {
         this.field17491 = false;
         this.field17492 = false;
      }

      private Nested210(String var1, int var2, int var3, int var4, int var5, long var6) {
         this.field17482 = var1;
         this.field17483 = var2;
         this.field17484 = var3;
         this.field17485 = var4;
         this.field17486 = var5;
         this.field17487 = ChatTextUtils.method05097(var1, var2, var3, var4, var5);
         this.field17488 = null;
         this.field17489 = var6;
         this.field17490 = this.method07194(var6);
      }

      private void method07199(long var1) {
         this.field17489 = var1;
         this.field17491 = true;
         this.field17492 = true;
      }

      private void method07200(List<FontFallbackManager.Nested210> var1) {
         if (!this.field17494) {
            this.field17494 = true;
            var1.add(this);
         }
      }

      private void method07201(long var1) {
         this.field17489 = var1;
         this.field17491 = true;
      }

      private void method07202(String var1, int var2, int var3, int var4, int var5) {
         if (!Objects.equals(this.field17482, var1) || this.field17483 != var2 || this.field17484 != var3 || this.field17485 != var4 || this.field17486 != var5
            )
          {
            this.field17482 = var1;
            this.field17483 = var2;
            this.field17484 = var3;
            this.field17485 = var4;
            this.field17486 = var5;
            this.field17493 = true;
         }
      }

      private Component method07203() {
         return this.field17487.copy();
      }
   }

   // $VF: Compiled from s
   private record Nested211(boolean named, String namedKey, String text, int color1, int color2, int power, int speed) {
   }
}
