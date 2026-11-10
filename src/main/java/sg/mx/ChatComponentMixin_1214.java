// Original binary: sg/mx/SOdspB4RmLZ6CoGJ
package sg.mx;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.client.multiplayer.chat.GuiMessage;
import net.minecraft.client.multiplayer.chat.GuiMessageSource;
import net.minecraft.client.multiplayer.chat.GuiMessageTag;
import net.minecraft.client.multiplayer.chat.GuiMessage.Line;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MessageSignature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.BotClient;
import sg.ec.ChatAlphaEvent;
import sg.ec.ChatMessageFlagsAccess;
import sg.ec.ChatMessagePolicy;
import sg.ec.ChatComponentHooks;
import sg.ec.ChatMessageAddedEvent;
import sg.ec.ScriptRuntime;
import sg.ec.BotSessionManager;
import sg.ec.ChatMessageHooks;

// $VF: Compiled from s
@Mixin(ChatComponent.class)
public class ChatComponentMixin_1214 {
   @Inject(
      method = "addMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/chat/MessageSignature;Lnet/minecraft/client/multiplayer/chat/GuiMessageSource;Lnet/minecraft/client/multiplayer/chat/GuiMessageTag;)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/components/ChatComponent;addMessageToDisplayQueue(Lnet/minecraft/client/multiplayer/chat/GuiMessage;)V"
      )
   )
   private void hex$compactDuplicates(
      Component var1, MessageSignature var2, GuiMessageSource var3, GuiMessageTag var4, CallbackInfo var5, @Local GuiMessage var6
   ) {
      ChatMessageHooks.method09164((ChatComponent)(Object)this, var6);
   }

   @Inject(
      method = "addMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/chat/MessageSignature;Lnet/minecraft/client/multiplayer/chat/GuiMessageSource;Lnet/minecraft/client/multiplayer/chat/GuiMessageTag;)V",
      at = @At("HEAD"),
      cancellable = true
   )
   private void hex$scriptChat(Component var1, MessageSignature var2, GuiMessageSource var3, GuiMessageTag var4, CallbackInfo var5) {
      if (ScriptRuntime.INSTANCE.method06200(var1, var3)) {
         var5.cancel();
      }
   }

   @Inject(method = "addMessageToQueue", at = @At("HEAD"))
   private void hex$recordActiveSessionChat(GuiMessage var1, CallbackInfo var2) {
      if (!((ChatMessageFlagsAccess)(Object)var1).isClientMessage()) {
         BotClient var3 = BotSessionManager.INSTANCE.method08762();
         if (var3 == null) {
            var3 = BotSessionManager.INSTANCE.method08761();
         }

         if (var3 != null) {
            var3.method00066(var1.content());
         }
      }
   }

   @ModifyArg(
      method = "lambda$extractRenderState$1",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/ChatComponent$ChatGraphicsAccess;fill(IIIII)V"),
      index = 4
   )
   private static int onRenderBackground(int var0, @Local(argsOnly = true) Line var1) {
      return ChatComponentHooks.method04728(var1, var0);
   }

   @Inject(method = "addMessageToDisplayQueue", at = @At("HEAD"), cancellable = true)
   private void onHideClientMessage(GuiMessage var1, CallbackInfo var2) {
      if (ChatMessagePolicy.method04005(var1)) {
         var2.cancel();
      }
   }

   @Inject(method = "addMessageToDisplayQueue", at = @At("TAIL"))
   private void onAddVisibleMessage(GuiMessage var1, CallbackInfo var2) {
      ChatMessageAddedEvent.field11383.method05250((ChatComponent)(Object)this, var1);
   }

   @ModifyVariable(method = "forEachLine", at = @At("STORE"), ordinal = 0)
   private float modifyAlpha(float var1, @Local Line var2) {
      return ChatAlphaEvent.field00417.method00216(var1, var2);
   }
}
