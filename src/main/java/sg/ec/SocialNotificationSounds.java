// Original binary: sg/ec/SamPTHldilieRsm4
package sg.ec;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerData.Type;
import net.minecraft.client.multiplayer.resolver.ServerAddress;

// $VF: Compiled from s
public final class SocialNotificationSounds {
   private static final AtomicLong field11792 = new AtomicLong();
   public static final List<SocialNotificationSounds.Nested169> field11793 = new CopyOnWriteArrayList<>();
   private static final String field11794 = "invite";
   private static final String field11795 = "friendreq";
   private static final String field11796 = "configbought";
   private static final String field11797 = "приглашает на сервер";
   private static final String field11798 = "Покупка конфига";
   private static final String field11799 = "Принято";
   private static final String field11800 = "Отклонено";
   private static final long field11801 = 3000L;
   private static final String field11802 = "Друг";

   private SocialNotificationSounds() {
   }

   public static void method05503(String var0) {
      if (var0 != null && !var0.isBlank()) {
         try {
            ServerAddress var1 = ServerAddress.parseString(var0);
            ServerData var2 = new ServerData(field11802, var0, Type.OTHER);
            Minecraft var3 = Minecraft.getInstance();
            ConnectScreen.startConnecting(var3.screen != null ? var3.screen : TitleScreenHooks.method11006(), var3, var1, var2, false, null);
         } catch (Throwable var5) {
            try {
               Minecraft.getInstance().keyboardHandler.setClipboard(var0);
            } catch (Throwable var4) {
            }
         }
      }
   }

   public static void method05506(SocialNotificationSounds.Nested169 var0) {
      field11793.remove(var0);
      if (var0.kind() == SocialNotificationSounds.Nested170.INVITE) {
         GlobalRequestSender.method09378(var1 -> var1.method01845(var0.title(), true));
         method05503(var0.server());
         method05508(field11799);
      }
   }

   public static void method05507(String var0, String var1, String var2, String var3) {
      FriendRequestState var4 = FriendRequestState.field11201;
      String var5 = var1 == null ? "" : var1;
      long var6 = System.currentTimeMillis();
      switch (var0 == null ? "" : var0) {
         case field11794:
            if (!var4.field11205) {
               return;
            }

            field11793.removeIf(var1x -> var1x.kind() == SocialNotificationSounds.Nested170.INVITE && var1x.title().equalsIgnoreCase(var5));
            field11793.add(
               new SocialNotificationSounds.Nested169(
                  field11792.incrementAndGet(), SocialNotificationSounds.Nested170.INVITE, var5, field11797, var3 == null ? "" : var3, var6
               )
            );
            break;
         case field11795:
            if (var4.field11206) {
               GlobalRequestSender.method09378(var0x -> var0x.method01818());
            }
            break;
         case field11796:
            if (!var4.field11207) {
               return;
            }

            field11793.add(
               new SocialNotificationSounds.Nested169(
                  field11792.incrementAndGet(), SocialNotificationSounds.Nested170.INFO, field11798, var5 + " " + (var2 == null ? "" : var2), "", var6
               )
            );
            break;
         default:
            field11793.add(
               new SocialNotificationSounds.Nested169(field11792.incrementAndGet(), SocialNotificationSounds.Nested170.INFO, var5, var2 == null ? "" : var2, "", var6)
            );
      }

      while (field11793.size() > 6) {
         field11793.remove(0);
      }
   }

   private static void method05508(String var0) {
      try {
         NotificationManager.method08597(var0, field11801, NotificationType.INFO);
      } catch (Throwable var2) {
      }
   }

   public static void method05509(SocialNotificationSounds.Nested169 var0) {
      field11793.remove(var0);
      if (var0.kind() == SocialNotificationSounds.Nested170.INVITE) {
         GlobalRequestSender.method09378(var1 -> var1.method01845(var0.title(), false));
         method05508(field11800);
      }
   }

   public static void method05512(SocialNotificationSounds.Nested169 var0) {
      field11793.remove(var0);
   }

   // $VF: Compiled from s
   public record Nested169(long field11803, SocialNotificationSounds.Nested170 kind, String title, String message, String server, long time) {
      public boolean interactive() {
         return this.kind == SocialNotificationSounds.Nested170.INVITE;
      }
   }

   // $VF: Compiled from s
   public enum Nested170 {
      INVITE,
      INFO;
   }
}
