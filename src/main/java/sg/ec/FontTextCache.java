// Original binary: sg/ec/6Ou70qXFM6FDQt5Y
package sg.ec;

import it.unimi.dsi.fastutil.longs.Long2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap;
import java.util.List;
import net.minecraft.client.gui.Font.PreparedText;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class FontTextCache {
   private static final int field03176 = 2048;
   private final Long2ObjectLinkedOpenHashMap<PreparedText> field03177 = new Long2ObjectLinkedOpenHashMap();
   private final Long2ObjectLinkedOpenHashMap<List<FormattedCharSequence>> field03178 = new Long2ObjectLinkedOpenHashMap();
   private final Long2IntLinkedOpenHashMap field03179 = TextCacheKeys.method03826();
   private final Long2IntLinkedOpenHashMap field03180 = TextCacheKeys.method03826();
   private final Reference2LongLinkedOpenHashMap<FormattedCharSequence> field03181 = new Reference2LongLinkedOpenHashMap();
   private boolean field03182;
   private int field03183 = -1;
   private Language field03184;
   private long field03185;
   private boolean field03186;
   private long field03187;
   private boolean field03188;
   private long field03189;
   private boolean field03190;
   private long field03191;
   private boolean field03192;
   private static final int field03193 = Integer.MIN_VALUE;
   private static final int field03194 = Integer.MIN_VALUE;

   public void method01339(
      FormattedCharSequence var1, float var2, float var3, int var4, boolean var5, boolean var6, int var7, CallbackInfoReturnable<PreparedText> var8
   ) {
      PreparedText var9 = this.method01345(var1, var2, var3, var4, var5, var6, var7);
      if (var9 != null) {
         var8.setReturnValue(var9);
      }
   }

   public void method01340(FormattedCharSequence var1, CallbackInfoReturnable<Integer> var2) {
      this.field03190 = false;
      if (TextCacheKeys.field08607) {
         this.method01342();
         long var3 = this.method01347(var1);
         if (var3 != 0L) {
            int var5 = this.field03179.getAndMoveToFirst(var3);
            if (var5 != field03193) {
               TextCacheKeys.field08612++;
               var2.setReturnValue(var5);
            } else {
               this.field03189 = var3;
               this.field03190 = true;
            }
         }
      }
   }

   public void method01341(PreparedText var1) {
      if (this.field03186) {
         this.field03186 = false;
         if (var1 != null) {
            if (this.field03177.size() >= 2048) {
               this.field03177.removeLast();
            }

            this.field03177.putAndMoveToFirst(this.field03185, var1);
            TextCacheKeys.field08609++;
         }
      }
   }

   private void method01342() {
      int var1 = TextCacheInvalidator.field17747;
      Language var2 = Language.getInstance();
      if (var1 != this.field03183 || var2 != this.field03184) {
         this.field03177.clear();
         this.field03178.clear();
         this.field03179.clear();
         this.field03180.clear();
         this.field03181.clear();
         this.field03183 = var1;
         this.field03184 = var2;
      }
   }

   public void method01343(FormattedText var1, CallbackInfoReturnable<Integer> var2) {
      this.field03192 = false;
      if (TextCacheKeys.field08607) {
         this.method01342();
         long var3 = TextCacheKeys.method03825(var1);
         int var5 = this.field03180.getAndMoveToFirst(var3);
         if (var5 != field03194) {
            TextCacheKeys.field08612++;
            var2.setReturnValue(var5);
         } else {
            this.field03191 = var3;
            this.field03192 = true;
         }
      }
   }

   public void method01344(List<FormattedCharSequence> var1) {
      if (this.field03188) {
         this.field03188 = false;
         if (var1 != null) {
            if (this.field03178.size() >= 2048) {
               this.field03178.removeLast();
            }

            this.field03178.putAndMoveToFirst(this.field03187, var1);
            TextCacheKeys.field08611++;
         }
      }
   }

   public PreparedText method01345(FormattedCharSequence var1, float var2, float var3, int var4, boolean var5, boolean var6, int var7) {
      this.field03186 = false;
      if (!TextCacheKeys.field08607) {
         return null;
      }

      this.method01342();
      long var8 = this.method01347(var1);
      if (var8 != 0L && !this.field03182) {
         var8 = TextCacheKeys.method03823(var8, Float.floatToRawIntBits(var2));
         var8 = TextCacheKeys.method03823(var8, Float.floatToRawIntBits(var3));
         var8 = TextCacheKeys.method03823(var8, var4);
         var8 = TextCacheKeys.method03823(var8, var7);
         var8 = TextCacheKeys.method03823(var8, (var5 ? 1 : 0) | (var6 ? 2 : 0));
         PreparedText var10 = (PreparedText)this.field03177.getAndMoveToFirst(var8);
         if (var10 != null) {
            TextCacheKeys.field08608++;
            return var10;
         } else {
            this.field03185 = var8;
            this.field03186 = true;
            return null;
         }
      } else {
         return null;
      }
   }

   public void method01346(int var1) {
      if (this.field03190) {
         this.field03190 = false;
         if (this.field03179.size() >= 2048) {
            this.field03179.removeLastInt();
         }

         this.field03179.putAndMoveToFirst(this.field03189, var1);
         TextCacheKeys.field08613++;
      }
   }

   private long method01347(FormattedCharSequence var1) {
      this.field03182 = false;
      long var2 = this.field03181.getAndMoveToFirst(var1);
      if (var2 != 0L) {
         return var2;
      }

      TextCacheKeys.Nested112 var4 = TextCacheKeys.method03822(var1);
      this.field03182 = var4.field08635;
      if (var4.field08634 != 0L && !var4.field08635) {
         if (this.field03181.size() >= 2048) {
            this.field03181.removeLastLong();
         }

         this.field03181.putAndMoveToFirst(var1, var4.field08634);
      }

      return var4.field08634;
   }

   public void method01348(FormattedText var1, int var2, CallbackInfoReturnable<List<FormattedCharSequence>> var3) {
      this.field03188 = false;
      if (TextCacheKeys.field08607) {
         this.method01342();
         long var4 = TextCacheKeys.method03823(TextCacheKeys.method03825(var1), var2);
         List var6 = (List)this.field03178.getAndMoveToFirst(var4);
         if (var6 != null) {
            TextCacheKeys.field08610++;
            var3.setReturnValue(var6);
         } else {
            this.field03187 = var4;
            this.field03188 = true;
         }
      }
   }

   public void method01349(int var1) {
      if (this.field03192) {
         this.field03192 = false;
         if (this.field03180.size() >= 2048) {
            this.field03180.removeLastInt();
         }

         this.field03180.putAndMoveToFirst(this.field03191, var1);
         TextCacheKeys.field08613++;
      }
   }
}
