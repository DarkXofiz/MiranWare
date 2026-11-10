// Original binary: sg/ec/q6c4Yt2CH3hbzJcA
package sg.ec;

import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;

// $VF: Compiled from s
public final class ScriptScreenAdapter implements MinecraftAccess {
   private static final String field22840 = "ClientScreen";
   private static final String field22841 = "This is a utility class and cannot be instantiated";

   private static String method10157(Screen var0) {
      try {
         return var0.getTitle().getString();
      } catch (Throwable var2) {
         return "";
      }
   }

   private static int method10158(Screen var0) {
      if (var0 instanceof ChatScreen) {
         return 1;
      } else if (var0 instanceof InventoryScreen) {
         return 2;
      } else {
         return var0 instanceof AbstractContainerScreen ? 3 : 5;
      }
   }

   public static void method10159(hex.script.api.Screen var0) {
      Screen var1 = mc.gui == null ? null : mc.gui.screen();
      if (var1 == null) {
         boolean var2 = ClientScreenManager.INSTANCE.method08316();
         var0.set(var2 ? 4 : 0, var2 ? field22840 : "", "");
      } else {
         var0.set(method10158(var1), var1.getClass().getSimpleName(), method10157(var1));
      }
   }

   private ScriptScreenAdapter() {
      throw new UnsupportedOperationException(field22841);
   }
}
