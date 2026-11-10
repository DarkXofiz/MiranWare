// Original binary: sg/mx/1xecA1QxJIXctzdK
package sg.mx;

import hex.api.extensions.GuiMessage$LineExtensions;
import net.minecraft.client.GuiMessage;
import net.minecraft.client.GuiMessage.Line;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.AnimationUtils;

// $VF: Compiled from s
@Mixin(Line.class)
public class GuiMessage$LineMixin implements GuiMessage$LineExtensions {
   @Unique
   private AnimationUtils animation;
   private static final long field28004 = 150L;

   @Inject(method = "<init>", at = @At("RETURN"))
   private void onInit(GuiMessage var1, FormattedCharSequence var2, boolean var3, CallbackInfo var4) {
      this.animation = new AnimationUtils(field28004);
   }

   @Override
   public AnimationUtils animation() {
      return this.animation;
   }

}
