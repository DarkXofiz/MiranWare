// Original binary: sg/mx/VFngsu6lOqNrE0Qk
package sg.mx;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.PackedColorHook;
import sg.ec.ComponentTextCacheAccess;
import sg.ec.MutableComponentHooks;

// $VF: Compiled from s
@Mixin(MutableComponent.class)
public abstract class MutableComponentMixin_1227 implements ComponentTextCacheAccess {
   @Shadow
   private Style style;
   @Unique
   private long hex$reorderKey;
   @Unique
   private int hex$hash;
   @Unique
   private long hex$text;
   @Unique
   private int hex$decomposeGeneration;
   @Unique
   private String hex$formatted;
   @Unique
   private int hex$formattedColor;
   @Unique
   private int hex$formattedGeneration;

   @Override
   public String hex$formattedText() {
      return this.hex$formatted;
   }

   @Override
   public int hex$formattedColor() {
      return this.hex$formattedColor;
   }

   @Override
   public int hex$formattedGeneration() {
      return this.hex$formattedGeneration;
   }

   @Override
   public void hex$formattedText(String var1, int var2, int var3) {
      this.hex$formatted = var1;
      this.hex$formattedColor = var2;
      this.hex$formattedGeneration = var3;
   }

   @Override
   public long hex$textHash() {
      return this.hex$text;
   }

   @Override
   public void hex$textHash(long var1) {
      this.hex$text = var1;
   }

   @Override
   public int hex$decomposeGeneration() {
      return this.hex$decomposeGeneration;
   }

   @Override
   public void hex$decomposeGeneration(int var1) {
      this.hex$decomposeGeneration = var1;
   }

   @Inject(method = "getVisualOrderText", at = @At("HEAD"), cancellable = true)
   private void hex$reorderLookup(CallbackInfoReturnable<FormattedCharSequence> var1) {
      this.hex$reorderKey = MutableComponentHooks.method11300((MutableComponentMixin)(Object)this, var1);
   }

   @Inject(method = "getVisualOrderText", at = @At("RETURN"))
   private void hex$reorderStore(CallbackInfoReturnable<FormattedCharSequence> var1) {
      MutableComponentHooks.method11299((MutableComponentMixin)(Object)this, this.hex$reorderKey, var1);
   }

   @Inject(method = "hashCode", at = @At("HEAD"), cancellable = true)
   private void hex$cachedHash(CallbackInfoReturnable<Integer> var1) {
      PackedColorHook.method02835(this.hex$hash, var1);
   }

   @Inject(method = "hashCode", at = @At("RETURN"))
   private void hex$storeHash(CallbackInfoReturnable<Integer> var1) {
      this.hex$hash = var1.getReturnValueI();
   }

   @Redirect(
      method = "setStyle",
      at = @At(value = "FIELD", target = "Lnet/minecraft/network/chat/MutableComponent;style:Lnet/minecraft/network/chat/Style;", opcode = 181)
   )
   private void hex$invalidateOnStyle(MutableComponent var1, Style var2) {
      this.style = var2;
      this.hex$hash = 0;
      this.hex$text = 0L;
      this.hex$formatted = null;
   }

   @Redirect(
      method = "append(Lnet/minecraft/network/chat/Component;)Lnet/minecraft/network/chat/MutableComponent;",
      at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z")
   )
   private boolean hex$invalidateOnAppend(List<Component> var1, Object var2) {
      this.hex$hash = 0;
      this.hex$text = 0L;
      this.hex$formatted = null;
      return var1.add((Component)var2);
   }
}
