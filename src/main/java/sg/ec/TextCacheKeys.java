// Original binary: sg/ec/HqZHmgVtpxnP5ZpJ
package sg.ec;

import it.unimi.dsi.fastutil.longs.Long2IntLinkedOpenHashMap;
import java.util.List;
import java.util.Optional;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.FormattedText.StyledContentConsumer;
import net.minecraft.network.chat.contents.PlainTextContents;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.FormattedCharSink;

// $VF: Compiled from s
public final class TextCacheKeys {
   public static volatile boolean field08607 = true;
   public static long field08608;
   public static long field08609;
   public static long field08610;
   public static long field08611;
   public static long field08612;
   public static long field08613;
   private static final long field08614 = 1469598103934665603L;
   private static final long field08615 = 0;
   private static final long field08616 = 0;
   private static final int field08617 = Integer.MIN_VALUE;
   private static final long field08618 = 4294967295L;
   private static final long field08619 = 1099511628211L;
   private static final long field08620 = 1469598103934665603L;
   private static final long field08621 = -7046029254386353131L;
   private static final long field08622 = 1099511628211L;
   private static final long field08623 = 1099511628211L;
   private static final long field08624 = -7046029254386353131L;
   private static final long field08625 = -7046029254386353131L;
   private static final long field08626 = -7046029254386353131L;

   public static TextCacheKeys.Nested112 method03822(FormattedCharSequence var0) {
      TextCacheKeys.Nested112 var1 = new TextCacheKeys.Nested112();
      var0.accept(var1);
      return var1;
   }

   private TextCacheKeys() {
   }

   public static long method03823(long var0, int var2) {
      return (var0 ^ var2 & field08618) * field08619;
   }

   private static long method03824(Component var0, long var1) {
      var1 = (var1 ^ var0.getStyle().hashCode()) * field08622;
      ComponentContents var3 = var0.getContents();
      if (!(var3 instanceof PlainTextContents)) {
         return field08624;
      }

      String var4 = ((PlainTextContents)var3).text();

      for (int var5 = 0; var5 < var4.length(); var5++) {
         var1 = (var1 ^ var4.charAt(var5)) * field08623;
      }

      var var7 = var0.getSiblings();

      for (int var8 = 0; var8 < var7.size(); var8++) {
         var1 = method03824((Component)var7.get(var8), var1);
         if (var1 == field08625) {
            return field08626;
         }
      }

      return var1;
   }

   public static long method03825(FormattedText var0) {
      if (var0 instanceof Component) {
         ComponentTextCacheAccess var1 = var0 instanceof ComponentTextCacheAccess ? (ComponentTextCacheAccess)var0 : null;
         if (var1 != null) {
            long var2 = var1.hex$textHash();
            if (var2 != 0L) {
               return var2;
            }
         }

         long var5 = method03824((Component)var0, field08620);
         if (var5 != field08621) {
            if (var1 != null) {
               var1.hex$textHash(var5);
            }

            return var5;
         }
      }

      TextCacheKeys.Nested111 var4 = new TextCacheKeys.Nested111();
      var0.visit(var4, Style.EMPTY);
      return var4.field08627;
   }

   public static Long2IntLinkedOpenHashMap method03826() {
      Long2IntLinkedOpenHashMap var0 = new Long2IntLinkedOpenHashMap();
      var0.defaultReturnValue(field08617);
      return var0;
   }

   // $VF: Compiled from s
   private static final class Nested111 implements StyledContentConsumer<Object> {
      private long field08627;
      private Style field08628;
      private int field08629;
      private boolean field08630;
      private static final long field08631 = 1469598103934665603L;
      private static final long field08632 = 1099511628211L;
      private static final long field08633 = 1099511628211L;

      @Override
      public Optional<Object> accept(Style var1, String var2) {
         int var3;
         if (this.field08630 && var1 == this.field08628) {
            var3 = this.field08629;
         } else {
            var3 = var1 == null ? 0 : var1.hashCode();
            this.field08628 = var1;
            this.field08629 = var3;
            this.field08630 = true;
         }

         long sx = (this.field08627 ^ var3) * field08632;

         for (int sxx = 0; sxx < var2.length(); sxx++) {
            sx = (sx ^ var2.charAt(sxx)) * field08633;
         }

         this.field08627 = sx;
         return Optional.empty();
      }

      private Nested111() {
         this.field08627 = field08631;
      }
   }

   // $VF: Compiled from s
   public static final class Nested112 implements FormattedCharSink {
      public long field08634;
      public boolean field08635;
      private Style field08636;
      private int field08637;
      private boolean field08638;
      private static final long field08639 = 1469598103934665603L;
      private static final long field08640 = 1099511628211L;
      private static final long field08641 = 1099511628211L;

      public Nested112() {
         this.field08634 = field08639;
      }

      @Override
      public boolean accept(int var1, Style var2, int var3) {
         int var4;
         if (this.field08638 && var2 == this.field08636) {
            var4 = this.field08637;
         } else {
            var4 = var2 == null ? 0 : var2.hashCode();
            if (var2 != null && var2.isObfuscated()) {
               this.field08635 = true;
            }

            this.field08636 = var2;
            this.field08637 = var4;
            this.field08638 = true;
         }

         long var5 = (this.field08634 ^ var3) * field08640;
         var5 = (var5 ^ var4) * field08641;
         this.field08634 = var5;
         return true;
      }
   }
}
