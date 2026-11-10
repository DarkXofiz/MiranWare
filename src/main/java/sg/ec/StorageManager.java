// Original binary: sg/ec/x5z6Rf1SrGkOusk9
package sg.ec;

import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public final class StorageManager {
   private static final String field25276 = "Default";
   private static final String field25277 = "LastAccount";
   private static final String field25278 = "Friend";
   private static final String field25279 = "Staff";
   private static final String field25280 = "Macro";
   private static final String field25281 = "WayPoint";
   private static final String field25282 = "BlockESP";
   private static final String field25283 = "NoTrace";
   private static final String field25284 = "drags";
   private static final String field25285 = "Bots";
   private static final String field25286 = "AutoBuy";
   private static final String field25287 = "Theme";
   private static final String field25288 = "[^\\p{L}\\p{N}_.-]";
   private static final String field25289 = "_";

   public static List<StoredContent> method11277() {
      List var0 = new ArrayList<>();
      method11278(var0, StorageCategory.CONFIG, field25276, ModuleConfigStorage.method04447());
      // LAST_ACCOUNT upload removed
      method11278(var0, StorageCategory.FRIEND_LIST, field25278, NoTraceStorage.method07080());
      method11278(var0, StorageCategory.STAFF_LIST, field25279, StaffStorage.method00685());
      method11278(var0, StorageCategory.MACROS, field25280, MacroStorage.method03674());
      method11278(var0, StorageCategory.WAYPOINT_LIST, field25281, WaypointStorage.method01737());
      method11278(var0, StorageCategory.BLOCK_ESP, field25282, BlockEspConfigManager.method03033());
      method11278(var0, StorageCategory.NO_TRACE_LIST, field25283, FriendStorage.method11526());
      method11278(var0, StorageCategory.DRAGS, field25284, DragManager.INSTANCE.method05200());
      method11278(var0, StorageCategory.BOTS, field25285, BotSettingsStorage.method00299());
      method11278(var0, StorageCategory.AUTO_BUY, field25286, AutoBuyStorage.method01323());
      method11278(var0, StorageCategory.THEME_STATE, field25287, ThemeStorage.method00754());

      for (ProxyConfig sx : ProxyManager.INSTANCE.method05237()) {
         method11278(var0, StorageCategory.PROXY, sx.method03917(), ProxyStorage.method07620(sx));
      }

      for (ThemeSettings sx : ThemeManager.INSTANCE.method09636()) {
         if (!ThemeManager.INSTANCE.method09614(sx)) {
            method11278(var0, StorageCategory.THEME, method11279(sx.method09815()), ThemeStorage.method00756(sx));
         }
      }

      return var0;
   }

   private StorageManager() {
   }

   private static void method11278(List<StoredContent> var0, StorageCategory var1, String var2, byte[] var3) {
      if (var3 != null && var3.length > 0 && StoredContentCache.method05221(var1, var2, var3)) {
         var0.add(new StoredContent(var1, var2, var3));
      }
   }

   public static String method11279(String var0) {
      return var0 == null ? "" : var0.replaceAll(field25288, field25289);
   }
}
