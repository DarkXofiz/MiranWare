// Original binary: sg/ec/c7di1lt8hI6cBjhW
package sg.ec;

import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public final class StoredContentImporter {
   public static boolean method07240(StorageCategory var0, String var1, byte[] var2) {
      if (var0 == null || var2 == null || var2.length == 0) {
         return false;
      }

      if (var0 == StorageCategory.PROXY) {
         return ProxyStorage.method07614(var1, CompressedFrameCodec.method00058(var2));
      }

      method07241(var0, CompressedFrameCodec.method00058(var2));
      if (var0 == StorageCategory.CONFIG) {
         ActiveConfigTracker.field06857.method03062(var1);
      }

      return true;
   }

   private static void method07241(StorageCategory var0, byte[] var1) {
      if (var1 != null && var1.length != 0) {
         switch (var0) {
            case CONFIG:
               DeferredCloudDataLoader.INSTANCE.method02274(var1);
               break;
            case FRIEND_LIST:
               NoTraceStorage.method07078(var1);
               break;
            case STAFF_LIST:
               StaffStorage.method00687(var1);
               break;
            case MACROS:
               MacroStorage.method03673(var1);
               break;
            case WAYPOINT_LIST:
               WaypointStorage.method01742(var1);
               break;
            case BLOCK_ESP:
               BlockEspConfigManager.method03029(var1);
               break;
            case NO_TRACE_LIST:
               FriendStorage.method11523(var1);
               break;
            case LAST_ACCOUNT:
               AccountStorage.method02637(var1);
               break;
            case DRAGS:
               DragManager.INSTANCE.method05201(var1);
               break;
            case BOTS:
               BotSettingsStorage.method00300(var1);
               break;
            case AUTO_BUY:
               AutoBuyStorage.method01309(var1);
               break;
            case THEME:
               ThemeStorage.method00757(var1);
               break;
            case THEME_STATE:
               ThemeStorage.method00752(var1);
               break;
            case PROXY:
               ProxyStorage.method07614("", var1);
         }
      }
   }

   public static void method07242(List<StoredContent> var0) {
      if (var0 != null && !var0.isEmpty()) {
         var var1 = new ArrayList(var0.size());

         for (StoredContent var3 : var0) {
            var1.add(new StoredContent(var3.category(), var3.name(), CompressedFrameCodec.method00058(var3.content())));
         }

         StoredContentCache.method05220(var1);

         for (StoredContent var9 : (Iterable<StoredContent>) (Iterable) var1) {
            if (var9.category() == StorageCategory.LAST_ACCOUNT) {
               method07241(var9.category(), var9.content());
            }
         }

         for (StoredContent var10 : (Iterable<StoredContent>) (Iterable) var1) {
            if (var10.category() == StorageCategory.THEME) {
               ThemeStorage.method00757(var10.content());
            }
         }

         method07243(var1);

         for (StoredContent var11 : (Iterable<StoredContent>) (Iterable) var1) {
            StorageCategory var4 = var11.category();
            if (var4 != StorageCategory.LAST_ACCOUNT
               && var4 != StorageCategory.THEME
               && var4 != StorageCategory.PROXY
               && var4 != StorageCategory.THEME_STATE) {
               method07241(var4, var11.content());
               if (var4 == StorageCategory.CONFIG) {
                  ActiveConfigTracker.field06857.method03062(var11.name());
               }
            }
         }

         for (StoredContent var12 : (Iterable<StoredContent>) (Iterable) var1) {
            if (var12.category() == StorageCategory.THEME_STATE) {
               ThemeStorage.method00752(var12.content());
            }
         }
      }
   }

   private static void method07243(List<StoredContent> var0) {
      boolean var1 = false;

      for (StoredContent var3 : var0) {
         if (var3.category() == StorageCategory.PROXY) {
            var1 = true;
            break;
         }
      }

      if (var1) {
         ProxyManager.INSTANCE.method05231();

         for (StoredContent var5 : var0) {
            if (var5.category() == StorageCategory.PROXY) {
               ProxyStorage.method07614(var5.name(), var5.content());
            }
         }

         ProxyManager.INSTANCE.method05233();
      }
   }

   private StoredContentImporter() {
   }
}
