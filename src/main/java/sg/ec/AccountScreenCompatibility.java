// Original binary: sg/ec/44W9fjvgk2Bnum0b
package sg.ec;

import java.lang.reflect.Constructor;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;

// $VF: Compiled from s
public final class AccountScreenCompatibility implements MinecraftAccess {
   private static final String field01866 = "ias";
   private static final String field01867 = "field01867";
   private static final Object field01868 = new Object();
   private static volatile boolean field01869;
   private static Constructor<?> field01870;
   private static final String field01871 = "ias";
   private static final String field01872 = "ru.vidtu.ias.screen.AccountScreen";

   public static boolean method00790() {
      method00791();
      return field01870 != null;
   }

   private static void method00791() {
      if (!field01869) {
         synchronized (field01868) {
            if (!field01869) {
               try {
                  if (FabricLoader.getInstance().isModLoaded(field01871)) {
                     var var1 = Class.forName(field01872);
                     field01870 = var1.getConstructor(Screen.class);
                  }
               } catch (Throwable var7) {
                  field01870 = null;
               } finally {
                  field01869 = true;
               }
            }
         }
      }
   }

   private AccountScreenCompatibility() {
   }

   public static boolean method00792(Screen var0) {
      method00791();
      var var1 = field01870;
      if (var1 == null) {
         mc.gui.setScreen(new AccountSwitcherScreen(var0));
         return true;
      }

      try {
         Screen var2 = (Screen)var1.newInstance(var0);
         mc.gui.setScreen(var2);
         return true;
      } catch (Throwable var3) {
         mc.gui.setScreen(new AccountSwitcherScreen(var0));
         return true;
      }
   }
}
