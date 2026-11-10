// Original binary: sg/ec/vXSAGh2gfhmUIuXx
package sg.ec;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public final class TitleScreenHooks implements MinecraftAccess {
   private static MainMenuScreen field24684;

   public static MainMenuScreen method11006() {
      if (field24684 == null) {
         field24684 = new MainMenuScreen();
      }

      return field24684;
   }

   private TitleScreenHooks() {
   }

   public static void method11007(CallbackInfo var0) {
      if (!ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.MAIN_MENU)) {
         MainMenuScreen var1 = method11006();
         if (mc.gui.screen() != var1) {
            mc.gui.setScreen(var1);
            var0.cancel();
         }
      }
   }
}
