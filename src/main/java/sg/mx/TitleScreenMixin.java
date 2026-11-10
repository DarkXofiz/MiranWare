// Original binary: sg/mx/OX8vdHVzqP1IK7z8
package sg.mx;

import com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
@Mixin(TitleScreen.class)
public class TitleScreenMixin {
   @Redirect(
      method = "init()V",
      at = @At(
         value = "FIELD",
         target = "Lnet/minecraft/client/gui/screens/TitleScreen;realmsNotificationsScreen:Lcom/mojang/realmsclient/gui/screens/RealmsNotificationsScreen;",
         opcode = 181
      )
   )
   private void hex$noNotifications(TitleScreen var1, RealmsNotificationsScreen var2) {
   }

   @Redirect(
      method = "createNormalMenuOptions",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/screens/TitleScreen;addRenderableWidget(Lnet/minecraft/client/gui/components/events/GuiEventListener;)Lnet/minecraft/client/gui/components/events/GuiEventListener;",
         ordinal = 3
      )
   )
   private GuiEventListener hex$dropRealmsButton(TitleScreen var1, GuiEventListener var2) {
      return var2;
   }

   @Inject(method = "createNormalMenuOptions", at = @At("RETURN"), cancellable = true)
   private void hex$closeRealmsGap(int var1, int var2, CallbackInfoReturnable<Integer> var3) {
      var3.setReturnValue((Integer)var3.getReturnValue() - var2);
   }
}
