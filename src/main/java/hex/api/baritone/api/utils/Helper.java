// Original binary: hex/api/baritone/api/utils/Helper
package hex.api.baritone.api.utils;

import hex.api.baritone.api.BaritoneAPI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Stream;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.chat.GuiMessageTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

// $VF: Compiled from s
public interface Helper {
   Helper HELPER = new Helper()   // $VF: Compiled from s
 {};
   @Deprecated
   Minecraft mc = Minecraft.getInstance();
   GuiMessageTag MESSAGE_TAG = new GuiMessageTag(16733695, null, Component.literal("Baritone message."), "Baritone");

   default void logDirect(String var1, boolean var2) {
      this.logDirect(var1, ChatFormatting.GRAY, var2);
   }

   default void logNotificationDirect(String var1) {
      this.logNotificationDirect(var1, false);
   }

   default void logDirect(Component... var1) {
      this.logDirect(BaritoneAPI.getSettings().logAsToast.value, var1);
   }

   static Component getPrefix() {
      Calendar var0 = Calendar.getInstance();
      boolean sx = var0.get(2) == 3 && var0.get(5) <= 3;
      MutableComponent sxx = Component.literal(sx ? "Baritoe" : (BaritoneAPI.getSettings().shortBaritonePrefix.value ? "B" : "Baritone"));
      sxx.setStyle(sxx.getStyle().withColor(ChatFormatting.LIGHT_PURPLE));
      MutableComponent sxxx = Component.literal("");
      sxxx.setStyle(sxx.getStyle().withColor(ChatFormatting.DARK_PURPLE));
      sxxx.append("[");
      sxxx.append(sxx);
      sxxx.append("]");
      return sxxx;
   }

   default void logNotification(String var1) {
      this.logNotification(var1, false);
   }

   default void logDebug(String var1) {
      if (BaritoneAPI.getSettings().chatDebug.value) {
         this.logDirect(var1, false);
      }
   }

   default void logDirect(String var1) {
      this.logDirect(var1, BaritoneAPI.getSettings().logAsToast.value);
   }

   default void logNotification(String var1, boolean var2) {
      if (BaritoneAPI.getSettings().desktopNotifications.value) {
         this.logNotificationDirect(var1, var2);
      }
   }

   default void logUnhandledException(Throwable var1) {
      HELPER.logDirect(
         "An unhandled exception occurred. The error is in your game's log, please report this at https://github.com/cabaletta/baritone/issues",
         ChatFormatting.RED
      );
   }

   default void logToast(String var1) {
      this.logToast(getPrefix(), Component.literal(var1));
   }

   default void logToast(Component var1, Component var2) {
      Minecraft.getInstance().execute(() -> BaritoneAPI.getSettings().toaster.value.accept(var1, var2));
   }

   default void logNotificationDirect(String var1, boolean var2) {
      Minecraft.getInstance().execute(() -> BaritoneAPI.getSettings().notifier.value.accept(var1, var2));
   }

   default void logDirect(String var1, ChatFormatting var2, boolean var3) {
      Stream.of(var1.split("\n")).forEach(var3x -> {
         MutableComponent var4 = Component.literal(var3x.replace("\t", "    "));
         var4.setStyle(var4.getStyle().withColor(var2));
         this.logDirect(var3, var4);
      });
   }

   default void logToast(String var1, String var2) {
      this.logToast(Component.literal(var1), Component.literal(var2));
   }

   default void logDirect(boolean var1, Component... var2) {
      MutableComponent var3 = Component.literal("");
      if (!var1 && !BaritoneAPI.getSettings().useMessageTag.value) {
         var3.append(getPrefix());
         var3.append(Component.literal(" "));
      }

      Arrays.asList(var2).forEach(var3::append);
      if (var1) {
         this.logToast(getPrefix(), var3);
      } else {
         Minecraft.getInstance().execute(() -> BaritoneAPI.getSettings().logger.value.accept(var3));
      }
   }

   default void logDirect(String var1, ChatFormatting var2) {
      this.logDirect(var1, var2, BaritoneAPI.getSettings().logAsToast.value);
   }
}
