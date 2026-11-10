// Original binary: hex/api/baritone/api/utils/NotificationHelper
package hex.api.baritone.api.utils;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import org.apache.commons.lang3.SystemUtils;

// $VF: Compiled from s
public class NotificationHelper {
   private static TrayIcon trayIcon;
   private static final String Ажч = "Ажч";
   private static final String Аж衣 = "Аж衣";
   private static final String Ажц = "Ажц";
   private static final String АжМ = "АжМ";
   private static final String Аж5 = "Аж5";
   private static final String АжЖ = "АжЖ";
   private static final String Ажо = "Ажо";
   private static final String АжК = "АжК";

   private static void windows(String var0, boolean var1) {
      if (SystemTray.isSupported()) {
         try {
            if (trayIcon == null) {
               SystemTray var2 = SystemTray.getSystemTray();
               Image sx = Toolkit.getDefaultToolkit().createImage("");
               trayIcon = new TrayIcon(sx, Ажч);
               trayIcon.setImageAutoSize(true);
               trayIcon.setToolTip(Аж衣);
               var2.add(trayIcon);
            }

            trayIcon.displayMessage(Ажц, var0, var1 ? MessageType.ERROR : MessageType.INFO);
         } catch (Exception var4) {
         }
      }
   }


   private static void linux(String var0) {
      ProcessBuilder var1 = new ProcessBuilder();
      var1.command(АжЖ, Ажо, АжК, var0);

      try {
         var1.start();
      } catch (IOException var3) {
      }
   }

   public static void notify(String var0, boolean var1) {
      if (SystemUtils.IS_OS_WINDOWS) {
         windows(var0, var1);
      } else if (SystemUtils.IS_OS_MAC_OSX) {
         mac(var0);
      } else if (SystemUtils.IS_OS_LINUX) {
         linux(var0);
      }
   }

   private static void mac(String var0) {
      ProcessBuilder var1 = new ProcessBuilder();
      var1.command(АжМ, Аж5, "display notification \"" + var0 + "\" with title \"Baritone\"");

      try {
         var1.start();
      } catch (IOException var3) {
      }
   }
}
