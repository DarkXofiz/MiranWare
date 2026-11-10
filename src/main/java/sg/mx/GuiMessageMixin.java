// Original binary: sg/mx/Nc8dIb1CpynHkApQ
package sg.mx;

import net.minecraft.client.multiplayer.chat.GuiMessage;
import net.minecraft.client.multiplayer.chat.GuiMessageSource;
import net.minecraft.client.multiplayer.chat.GuiMessageTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MessageSignature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ChatMessageFlagsAccess;
import sg.ec.ChatMessagePolicy;
import sg.ec.ChatMessageHooks;

// $VF: Compiled from s
@Mixin(GuiMessage.class)
public class GuiMessageMixin implements ChatMessageFlagsAccess {
   @Shadow
   @Final
   private Component content;
   @Unique
   private boolean clientMessage;
   @Unique
   private String baseText;
   @Unique
   private int repeats;

   @Inject(method = "<init>", at = @At("RETURN"))
   private void onInit(int var1, Component var2, MessageSignature var3, GuiMessageSource var4, GuiMessageTag var5, CallbackInfo var6) {
      this.repeats = 1;
      this.clientMessage = ChatMessagePolicy.method04006(var2);
   }

   @ModifyArg(
      method = "splitLines",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/components/ComponentRenderUtils;wrapComponents(Lnet/minecraft/network/chat/FormattedText;ILnet/minecraft/client/gui/Font;)Ljava/util/List;"
      ),
      index = 0
   )
   private FormattedText withRepeats(FormattedText var1) {
      return this.repeats > 1 ? ChatMessageHooks.method09163(this.content, this.repeats) : var1;
   }

   @Override
   public boolean isClientMessage() {
      return this.clientMessage;
   }

   @Override
   public void setClientMessage(boolean var1) {
      this.clientMessage = var1;
   }

   @Override
   public String getBaseText() {
      if (this.baseText == null) {
         this.baseText = this.content.getString();
      }

      return this.baseText;
   }

   @Override
   public int getRepeats() {
      return this.repeats;
   }

   @Override
   public void setRepeats(int var1) {
      this.repeats = var1;
   }
}
