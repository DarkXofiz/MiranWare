// Original binary: sg/ec/VFPkW5ppw3dHmyDa
package sg.ec;

import hex.dscRPC.DiscordRPC;
import hex.dscRPC.activity.model.Activity;
import hex.dscRPC.activity.model.ActivityTimestamps;
import java.time.Instant;
import net.minecraft.client.multiplayer.ServerData;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;

// $VF: Compiled from s
public class DiscordRpcModule extends ClientModule {
   private final ToggleSetting field12700;
   private final ToggleSetting field12701;
   private final ToggleSetting field12702;
   private static final long field12703 = 60000L;
   private static final int field12704 = 0;
   private boolean field12705;
   private String field12706;
   private Instant field12707;
   private long field12708;
   private boolean field12709;
   private static final String field12710 = "Выключить RPC";
   private static final String field12711 = "Отображать статус";
   private static final String field12712 = "Показывает на каком сервере в Minecraft вы находитесь.";
   private static final String field12713 = "Показывать музыку";
   private static final String field12714 = "Раз в минуту подменяет номер билда на трек из MediaPlayer.";
   private static final String field12715 = "Discord RPC";
   private static final long field12716 = 60000L;
   private static final String field12717 = "Telegram";
   private static final String field12718 = "https://t.me/quickclient";
   private static final String field12719 = "Website";
   private static final String field12720 = "https://quickclient.cc";
   private static final String field12721 = "\\.";
   private static final String field12722 = "rpc";

   private static String method05933(String var0) {
      return "https://api.mcstatus.io/v2/icon/" + var0;
   }

   private static boolean method05934() {
      MediaPlayerHud var0 = ModuleManager.INSTANCE.method08274().method04953().method00017(MediaPlayerHud.class);
      return var0 != null && var0.method06457();
   }

   private String method05936() {
      if (this.field12702.method03022() && method05934() && WindowsMediaManager.field06035) {
         String var1 = WindowsMediaManager.field06029.trim();
         if (var1.isEmpty()) {
            return null;
         }

         String var2 = WindowsMediaManager.field06030.trim();
         return method05937(var2.isEmpty() ? var1 : var2 + " — " + var1);
      } else {
         return null;
      }
   }

   @Override
   public void method00245() {
   }

   private static String method05937(String var0) {
      return var0.length() <= 128 ? var0 : var0.substring(0, 127).stripTrailing() + "…";
   }

   @Override
   public void method00276() {
   }

   public DiscordRpcModule() {
      super(ModuleCategory.Misc, ModuleSubCategory.Other);
      this.field12700 = new ToggleSetting(field12710).method03017(false).method03023(this);
      this.field12701 = new ToggleSetting(field12711).method03017(true).method03018(field12712).method03023(this);
      this.field12702 = new ToggleSetting(field12713).method03017(false).method03018(field12714).method03023(this);
      this.method03929(false);
      this.method03933(false);
      this.method03935(field12715);
      EventBus.method00263(this);
   }

   private Activity method05938(String var1, String var2) {
      String var3 = ProfileAPI.get().getModel().getName();
      boolean var4 = !var1.isEmpty();
      return Activity.builder()
         .details(var2)
         .state("UID: " + ProfileAPI.get().getModel().getUserIdentifier())
         .timestamps(ActivityTimestamps.from(this.field12707 != null ? this.field12707 : Instant.now(), null))
         .button(field12717, field12718)
         .button(field12719, field12720)
         .assets(var3x -> {
            var3x.largeImage(field12722, var3);
            if (var4) {
               var3x.smallImage(method05933(var1), method05939(var1));
            }
         })
         .build();
   }

   private static String method05939(String var0) {
      String var1 = var0;
      int var2 = var1.indexOf(58);
      if (var2 != -1) {
         var1 = var1.substring(0, var2);
      }

      String[] var3 = var1.split(field12721);
      if (var3.length >= 2) {
         String var4 = var3[var3.length - 2];
         if (!var4.isEmpty() && !var4.chars().allMatch(Character::isDigit)) {
            return var4;
         }
      }

      return var1;
   }

   @Subscribe
   private void method05940(TickEvent var1) {
      if (this.field12700.method03022()) {
         if (this.field12705) {
            DiscordRPC.stop();
            this.field12705 = false;
            this.field12706 = null;
         }
      } else {
         if (!this.field12705) {
            DiscordRPC.start();
            this.field12705 = true;
            this.field12706 = null;
            this.field12707 = Instant.now();
         }

         String var2 = this.field12701.method03022() ? this.method05941() : "";
         String var3 = this.method05942();
         String var4 = var2 + "|" + var3;
         if (!var4.equals(this.field12706)) {
            this.field12706 = var4;
            DiscordRPC.update(this.method05938(var2, var3));
         }
      }
   }

   private String method05941() {
      try {
         ServerData var1 = mc.getCurrentServer();
         if (var1 != null && var1.ip != null && !var1.ip.isBlank()) {
            return var1.ip.trim();
         }
      } catch (Throwable var2) {
      }

      return "";
   }

   private String method05942() {
      String var1 = "Build #" + ClientEnvironment.field07578;
      String var2 = this.method05936();
      if (var2 == null) {
         this.field12709 = false;
         this.field12708 = 0L;
         return var1;
      }

      long var3 = System.currentTimeMillis();
      if (this.field12708 == 0L) {
         this.field12708 = var3;
      } else if (var3 - this.field12708 >= field12716) {
         this.field12708 = var3;
         this.field12709 = !this.field12709;
      }

      return this.field12709 ? var2 : var1;
   }
}
