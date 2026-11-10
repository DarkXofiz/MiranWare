// Original binary: sg/ec/1VSuR2Mi8gYir92G
package sg.ec;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

// $VF: Compiled from s
public class BotSettingsStorage extends AbstractStorage {
   private static final String field00619 = "connectDelay";
   private static final String field00620 = "connectDelay";
   private static final String field00621 = "viewDistance";
   private static final String field00622 = "viewDistance";
   private static final String field00623 = "autoReconnect";
   private static final String field00624 = "autoReconnect";
   private static final String field00625 = "autoRespawn";
   private static final String field00626 = "autoRespawn";
   private static final String field00627 = "warden";
   private static final String field00628 = "warden";
   private static final String field00629 = "warden";
   private static final String field00630 = "useSpeed";
   private static final String field00631 = "useSpeed";
   private static final String field00632 = "reportKillers";
   private static final String field00633 = "reportKillers";
   private static final String field00634 = "debug";
   private static final String field00635 = "debug";
   private static final String field00636 = "lootPriority";
   private static final String field00637 = "lootPriority";
   private static final String field00638 = "lootLimit";
   private static final String field00639 = "lootLimit";
   private static final String field00640 = "bots";
   private static final String field00641 = "name";
   private static final String field00642 = "address";
   private static final String field00643 = "name";
   private static final String field00644 = "address";
   private static final String field00645 = "proxyId";
   private static final String field00646 = "proxyId";
   private static final String field00647 = "task";
   private static final String field00648 = "task";
   private static final String field00649 = "version";
   private static final String field00650 = "version";
   private static final String field00651 = "buyRole";
   private static final String field00652 = "buyRole";
   private static final String field00653 = "anarchy";
   private static final String field00654 = "anarchy";
   private static final String field00655 = "bank";
   private static final String field00656 = "bank";
   private static final String field00657 = "homes";
   private static final String field00658 = "homes";
   private static final String field00659 = "homes";
   private static final String field00660 = "connectDelay";
   private static final String field00661 = "viewDistance";
   private static final String field00662 = "autoReconnect";
   private static final String field00663 = "autoRespawn";
   private static final String field00664 = "useSpeed";
   private static final String field00665 = "reportKillers";
   private static final String field00666 = "debug";
   private static final String field00667 = "lootPriority";
   private static final String field00668 = "lootLimit";
   private static final String field00669 = "warden";
   private static final String field00670 = "name";
   private static final String field00671 = "address";
   private static final String field00672 = "proxyId";
   private static final String field00673 = "task";
   private static final String field00674 = "version";
   private static final String field00675 = "buyRole";
   private static final String field00676 = "anarchy";
   private static final String field00677 = "bank";
   private static final String field00678 = "homes";
   private static final String field00679 = "bots";

   private static byte[] method00295() {
      BotManager var0 = BotManager.INSTANCE;
      JsonObject sx = new JsonObject();
      sx.addProperty(field00660, var0.method03095());
      sx.addProperty(field00661, var0.method03096());
      sx.addProperty(field00662, var0.method03097());
      sx.addProperty(field00663, var0.method03098());
      WardenBotSettings sxx = WardenBotSettings.INSTANCE;
      JsonObject sxxx = new JsonObject();
      sxxx.addProperty(field00664, sxx.method09328());
      sxxx.addProperty(field00665, sxx.method09329());
      sxxx.addProperty(field00666, sxx.method09330());
      sxxx.addProperty(field00667, sxx.method09331());
      sxxx.addProperty(field00668, sxx.method09332());
      sx.add(field00669, sxxx);
      JsonArray sxxxx = new JsonArray();

      for (BotClient sxxxxx : var0.method03092()) {
         JsonObject sxxxxxx = new JsonObject();
         sxxxxxx.addProperty(field00670, sxxxxx.method00137().method00491());
         sxxxxxx.addProperty(field00671, sxxxxx.method00137().method00486());
         sxxxxxx.addProperty(field00672, sxxxxx.method00137().method00490());
         sxxxxxx.addProperty(field00673, sxxxxx.method00137().method00475().name());
         sxxxxxx.addProperty(field00674, sxxxxx.method00137().method00492());
         sxxxxxx.addProperty(field00675, sxxxxx.method00137().method00498().name());
         sxxxxxx.addProperty(field00676, sxxxxx.method00137().method00487());
         sxxxxxx.addProperty(field00677, sxxxxx.method00137().method00482());
         JsonArray sxxxxxxx = new JsonArray();

         for (int sxxxxxxxx : sxxxxx.method00137().method00500()) {
            sxxxxxxx.add(sxxxxxxxx);
         }

         sxxxxxx.add(field00678, sxxxxxxx);
         sxxxx.add(sxxxxxx);
      }

      sx.add(field00679, sxxxx);
      return sx.toString().getBytes(StandardCharsets.UTF_8);
   }

   @Override
   public boolean method00296() {
      File var1 = this.method03303().getParentFile();
      if (var1 != null && !var1.exists()) {
         var1.mkdirs();
      }

      return this.method03302(method00295());
   }

   private static JsonObject method00297(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         try {
            JsonElement var1 = JsonParser.parseString(new String(var0, StandardCharsets.UTF_8));
            return var1.isJsonObject() ? var1.getAsJsonObject() : null;
         } catch (Exception var2) {
            return null;
         }
      } else {
         return null;
      }
   }

   @Override
   public boolean method00298() {
      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] var2 = var1.readAllBytes();
         return var2.length == 0 || method00300(var2);
      } catch (Exception var6) {
         return false;
      }
   }

   public static byte[] method00299() {
      try {
         return CustomResourceManager.method02469(method00295());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   public static boolean method00300(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         JsonObject var1 = method00297(CustomResourceManager.method02470(var0));
         if (var1 == null) {
            var1 = method00297(var0);
         }

         if (var1 == null) {
            return false;
         }

         BotManager var2 = BotManager.INSTANCE;
         var2.method03076();
         var2.method03092().clear();
         if (var1.has(field00619)) {
            var2.method03099(var1.get(field00620).getAsLong());
         }

         if (var1.has(field00621)) {
            var2.method03100(var1.get(field00622).getAsInt());
         }

         if (var1.has(field00623)) {
            var2.method03101(var1.get(field00624).getAsBoolean());
         }

         if (var1.has(field00625)) {
            var2.method03102(var1.get(field00626).getAsBoolean());
         }

         if (var1.has(field00627) && var1.get(field00628).isJsonObject()) {
            JsonObject var3 = var1.getAsJsonObject(field00629);
            WardenBotSettings var4 = WardenBotSettings.INSTANCE;
            if (var3.has(field00630)) {
               var4.method09322(var3.get(field00631).getAsBoolean());
            }

            if (var3.has(field00632)) {
               var4.method09323(var3.get(field00633).getAsBoolean());
            }

            if (var3.has(field00634)) {
               var4.method09324(var3.get(field00635).getAsBoolean());
            }

            if (var3.has(field00636)) {
               var4.method09325(var3.get(field00637).getAsString());
            }

            if (var3.has(field00638)) {
               var4.method09326(var3.get(field00639).getAsInt());
            }
         }

         JsonArray var10 = var1.getAsJsonArray(field00640);
         if (var10 != null) {
            for (JsonElement var5 : var10) {
               if (var5.isJsonObject()) {
                  JsonObject var6 = var5.getAsJsonObject();
                  if (var6.has(field00641) && var6.has(field00642)) {
                     BotClient var7 = var2.method03069(
                        var6.get(field00643).getAsString(), var6.get(field00644).getAsString(), var6.has(field00645) ? var6.get(field00646).getAsString() : ""
                     );
                     if (var7 != null) {
                        if (var6.has(field00647)) {
                           var7.method00137().method00483(AutoBuyBotStatus.method04676(var6.get(field00648).getAsString()));
                        }

                        if (var6.has(field00649)) {
                           var7.method00137().method00485(var6.get(field00650).getAsString());
                        }

                        if (var6.has(field00651)) {
                           var7.method00137().method00480(AutoBuyBotRole.method04641(var6.get(field00652).getAsString()));
                        }

                        if (var6.has(field00653)) {
                           var7.method00137().method00493(var6.get(field00654).getAsInt());
                        }

                        if (var6.has(field00655)) {
                           var7.method00137().method00488(var6.get(field00656).getAsInt());
                        }

                        if (var6.has(field00657) && var6.get(field00658).isJsonArray()) {
                           for (JsonElement var9 : var6.getAsJsonArray(field00659)) {
                              var7.method00137().method00496(var9.getAsInt());
                           }
                        }
                     }
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public BotSettingsStorage(File var1) {
      super(var1);
   }
}
