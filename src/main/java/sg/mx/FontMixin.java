// Original binary: sg/mx/yvCRzt9RPXJYpCt0
package sg.mx;

import java.util.List;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Font.PreparedText;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.FontTextCache;
import sg.ec.FontTextCacheAccess;

// $VF: Compiled from s
@Mixin(Font.class)
public class FontMixin implements FontTextCacheAccess {
   @Unique
   private FontTextCache hex$cache;

   @Override
   public FontTextCache hexTextCache() {
      return this.hex$cache();
   }

   @Unique
   private FontTextCache hex$cache() {
      FontTextCache var1 = this.hex$cache;
      if (var1 == null) {
         var1 = new FontTextCache();
         this.hex$cache = var1;
      }

      return var1;
   }

   @Inject(
      method = "prepareText(Lnet/minecraft/util/FormattedCharSequence;FFIZZI)Lnet/minecraft/client/gui/Font$PreparedText;",
      at = @At("HEAD"),
      cancellable = true
   )
   private void hex$prepLookup(
      FormattedCharSequence var1, float var2, float var3, int var4, boolean var5, boolean var6, int var7, CallbackInfoReturnable<PreparedText> var8
   ) {
      this.hex$cache().method01339(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   @Inject(method = "prepareText(Lnet/minecraft/util/FormattedCharSequence;FFIZZI)Lnet/minecraft/client/gui/Font$PreparedText;", at = @At("RETURN"))
   private void hex$prepStore(
      FormattedCharSequence var1, float var2, float var3, int var4, boolean var5, boolean var6, int var7, CallbackInfoReturnable<PreparedText> var8
   ) {
      this.hex$cache().method01341((PreparedText)var8.getReturnValue());
   }

   @Inject(method = "split(Lnet/minecraft/network/chat/FormattedText;I)Ljava/util/List;", at = @At("HEAD"), cancellable = true)
   private void hex$splitLookup(FormattedText var1, int var2, CallbackInfoReturnable<List<FormattedCharSequence>> var3) {
      this.hex$cache().method01348(var1, var2, var3);
   }

   @Inject(method = "split(Lnet/minecraft/network/chat/FormattedText;I)Ljava/util/List;", at = @At("RETURN"))
   private void hex$splitStore(FormattedText var1, int var2, CallbackInfoReturnable<List<FormattedCharSequence>> var3) {
      this.hex$cache().method01344((List<FormattedCharSequence>)var3.getReturnValue());
   }

   @Inject(method = "width(Lnet/minecraft/util/FormattedCharSequence;)I", at = @At("HEAD"), cancellable = true)
   private void hex$seqWidthLookup(FormattedCharSequence var1, CallbackInfoReturnable<Integer> var2) {
      this.hex$cache().method01340(var1, var2);
   }

   @Inject(method = "width(Lnet/minecraft/util/FormattedCharSequence;)I", at = @At("RETURN"))
   private void hex$seqWidthStore(FormattedCharSequence var1, CallbackInfoReturnable<Integer> var2) {
      this.hex$cache().method01346(var2.getReturnValueI());
   }

   @Inject(method = "width(Lnet/minecraft/network/chat/FormattedText;)I", at = @At("HEAD"), cancellable = true)
   private void hex$textWidthLookup(FormattedText var1, CallbackInfoReturnable<Integer> var2) {
      this.hex$cache().method01343(var1, var2);
   }

   @Inject(method = "width(Lnet/minecraft/network/chat/FormattedText;)I", at = @At("RETURN"))
   private void hex$textWidthStore(FormattedText var1, CallbackInfoReturnable<Integer> var2) {
      this.hex$cache().method01349(var2.getReturnValueI());
   }
}
