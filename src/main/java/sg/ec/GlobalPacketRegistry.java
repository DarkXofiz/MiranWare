// Original binary: sg/ec/84FJm1wWWUbCl2Md
package sg.ec;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;

// $VF: Compiled from s
public class GlobalPacketRegistry {
   private static final long field04473 = 8000L;
   private static final long field04474 = 0;
   private static final long field04475 = 0;
   private final PacketRegistryEntry<AbstractGlobalPacketHandler> field04476 = PacketRegistryEntry.method00596();
   private final AbstractGlobalPacketHandler field04477;
   private Party field04478;
   private final Stopwatch field04479 = new Stopwatch();
   private final Stopwatch field04480 = new Stopwatch();
   private List<ClientCommandS2CPacket.Nested273> field04481 = List.of();
   private String field04482;
   private String field04483;
   private int field04484;
   private boolean field04485;
   private List<StoredContentInfo> field04486;
   private List<StoredContentInfo> field04487;
   private List<ConfigShareRequest> field04488;
   private List<MarketListS2CPacket.Nested327> field04489;
   private List<SaleListS2CPacket.Nested122> field04490;
   private SaleKeyListS2CPacket field04491;
   private List<PrefixEntry> field04492;
   private String field04493;
   private List<SocialS2CPacket.Nested57> field04494;
   private volatile long field04495;
   private volatile long field04496;
   private volatile long field04497;
   private SecureHandshake field04498;
   private volatile EncryptedFrameCodec field04499;
   private static final long field04500 = -1L;
   private static final String field04501 = "chatC2SPacket";
   private static final String field04502 = "friendsStateS2C";
   private static final String field04503 = "serverMessageS2C";
   private static final String field04504 = "partyCreateS2C";
   private static final String field04505 = "waypointSendS2C";
   private static final String field04506 = "partyTeleportS2C";
   private static final String field04507 = "globalsPongS2C";
   private static final String field04508 = "clientCommandS2C";
   private static final String field04509 = "voiceS2C";
   private static final String field04510 = "funTimeDataS2C";
   private static final String field04511 = "neuroConfigS2C";
   private static final String field04512 = "neuroRotationS2C";
   private static final String field04513 = "cloudDataS2C";
   private static final String field04514 = "cloudListS2C";
   private static final String field04515 = "cloudKeysS2C";
   private static final String field04516 = "cloudProfileS2C";
   private static final String field04517 = "marketListS2C";
   private static final String field04518 = "saleListS2C";
   private static final String field04519 = "prefixListS2C";
   private static final String field04520 = "promotedServersS2C";
   private static final String field04521 = "saleKeysS2C";
   private static final String field04522 = "saleKeyListS2C";
   private static final String field04523 = "socialS2C";
   private static final String field04524 = "forumAuthS2C";
   private static final String field04525 = "Bad frame";
   private static final long field04526 = -1L;
   private static final long field04527 = -1L;
   private static final String field04528 = "!clean";
   private static final String field04529 = "friends";
   private static final String field04530 = "status";
   private static final String field04531 = "online";
   private static final String field04532 = "share";
   private static final String field04533 = "invite";
   private static final String field04534 = "respond";
   private static final String field04535 = "accept";
   private static final String field04536 = "decline";
   private static final String field04537 = "pending";
   private static final String field04538 = "request";
   private static final String field04539 = "accept";
   private static final String field04540 = "decline";
   private static final String field04541 = "cancel";
   private static final long field04542 = 8000L;
   private static final long field04543 = 20000L;
   private static final long field04544 = 120000L;
   private static final String field04545 = "Heartbeat timeout";

   public void method01779(String var1, byte[] var2) {
      this.method01819(StorageCategory.CONFIG, var1, var2, ConfigMarketState.field13926.method06282());
   }

   public ClientCommandS2CPacket.Nested273 method01780(String var1) {
      if (var1 != null && !var1.isBlank()) {
         for (ClientCommandS2CPacket.Nested273 var3 : this.field04481) {
            if (var3 != null) {
               String var4 = var3.targetUsername();
               if (var4 != null && var4.equalsIgnoreCase(var1)) {
                  return var3;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public void method01781() {
      GlobalWebSocketClient var1 = this.field04477.method10047();
      if (var1 != null) {
         this.method01823(new SocialC2SPacket(var1.getClientPlayer(), field04529, "", ""));
      }
   }

   public void method01782(StorageCategory var1, String var2) {
      if (var1 != null) {
         this.method01847(CloudC2SPacket.Nested276.DELETE, var1, var2, new byte[0], "");
      }
   }

   public boolean method01783(ByteBuffer var1) {
      SecureHandshake var2 = this.field04498;
      this.field04498 = null;
      if (var2 == null) {
         return false;
      }

      try {
         this.field04499 = var2.method09464(method01841(var1));
         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   public void method01784(long var1) {
      this.field04495 = var1;
   }

   public void method01785(Party var1) {
      this.field04478 = var1;
   }

   public void method01786(List<MarketListS2CPacket.Nested327> var1) {
      this.field04489 = var1;
   }

   public void method01787(String var1, byte[] var2) {
      if (var1 != null && !var1.isBlank()) {
         this.method01865(MarketC2SPacket.Nested158.SELL_UPDATE, var1, 0, method01806(var2));
      }
   }

   public SecureHandshake method01788() {
      return this.field04498;
   }

   private static String method01789(String var0) {
      if (var0 != null && !var0.isBlank()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            if (Character.isLetterOrDigit(var3) || var3 == '_') {
               var1.append(Character.toLowerCase(var3));
            }
         }

         return var1.toString();
      } else {
         return "";
      }
   }

   public void method01790(boolean var1) {
      this.field04485 = var1;
   }

   public void method01791(List<ConfigShareRequest> var1) {
      this.field04488 = var1;
   }

   public void method01792() {
      this.method01847(CloudC2SPacket.Nested276.LIST, null, "", new byte[0], "");
   }

   public List<StoredContentInfo> method01793() {
      ArrayList var1 = new ArrayList();

      for (StoredContentInfo var3 : this.field04486) {
         if (var3.category() == StorageCategory.CONFIG) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public void method01794(ByteBuffer var1) {
      if (!PacketBufferManager.INSTNCE.method03611()) {
         EncryptedFrameCodec var2 = this.field04499;
         if (var2 != null) {
            byte[] var3;
            try {
               var3 = var2.method00966(method01841(var1));
            } catch (Exception var6) {
               GlobalWebSocketClient var5 = this.field04477.method10047();
               if (var5 != null) {
                  var5.closeConnection(4009, field04525);
               }

               return;
            }

            GlobalPacket var4 = this.field04476.method00598(var3);
            if (var4 != null) {
               Minecraft.getInstance().execute(() -> var4.method00212(this.field04477.method10047(), this.field04477));
            }
         }
      }
   }

   public int method01795() {
      return this.field04484;
   }

   public void method01796(long var1) {
      this.field04496 = var1;
   }

   public List<MarketListS2CPacket.Nested327> method01797() {
      return this.field04489;
   }

   public SaleKeyListS2CPacket method01798() {
      return this.field04491;
   }

   public List<SocialS2CPacket.Nested57> method01799() {
      return this.field04494;
   }

   public void method01801(String var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null && var1 != null && !var1.isBlank()) {
         this.method01823(new SocialC2SPacket(var2.getClientPlayer(), field04539, var1, ""));
      }
   }

   public PacketRegistryEntry<AbstractGlobalPacketHandler> method01802() {
      return this.field04476;
   }

   public void method01803(List<StoredContent> var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null && var1 != null && !var1.isEmpty()) {
         var var3 = new ArrayList(var1.size());

         for (StoredContent var5 : var1) {
            var3.add(new StoredContent(var5.category(), var5.name(), CompressedFrameCodec.method00057(var5.content())));
         }

         this.method01823(new CloudProfileC2SPacket(var2.getClientPlayer(), var3));
      }
   }

   public void method01804(List<ClientCommandS2CPacket.Nested273> var1, List<String> var2) {
      LinkedHashMap var3 = new LinkedHashMap();

      for (ClientCommandS2CPacket.Nested273 var5 : this.field04481) {
         var3.put(method01883(var5), var5);
      }

      if (var2 != null) {
         for (String var8 : var2) {
            if (var8 != null && !var8.isBlank()) {
               var3.remove(var8);
            }
         }
      }

      if (var1 != null) {
         for (ClientCommandS2CPacket.Nested273 var9 : var1) {
            if (var9 != null) {
               var3.put(method01883(var9), var9);
            }
         }
      }

      this.field04481 = List.copyOf(var3.values());
   }

   public Party method01805() {
      return this.field04478;
   }

   private static byte[] method01806(byte[] var0) {
      return var0 != null && var0.length != 0 ? CompressedFrameCodec.method00057(var0) : new byte[0];
   }

   public List<ConfigShareRequest> method01807() {
      return this.field04488;
   }

   public void method01808() {
      GlobalWebSocketClient var1 = this.field04477.method10047();
      if (var1 != null) {
         this.method01823(new LeaveC2SPacket(var1.getClientPlayer()));
      }
   }

   public void method01809(String var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null && var1 != null && !var1.isBlank()) {
         this.method01823(new SocialC2SPacket(var2.getClientPlayer(), field04540, var1, ""));
      }
   }

   public void method01810(String var1, String var2) {
      this.method01825(var1, var2, false);
   }

   public void method01811() {
      VoiceAudioPlayer.INSTANCE.method02388();
      this.field04479.method02439();
      this.field04481 = List.of();
      this.field04495 = 0L;
      this.field04496 = 0L;
      this.field04497 = field04527;
      this.field04498 = null;
      this.field04499 = null;
   }

   public void method01812() {
      this.method01865(MarketC2SPacket.Nested158.SELL_LIST, "", 0, new byte[0]);
   }

   private static String method01813() {
      try {
         ServerData var0 = Minecraft.getInstance().getCurrentServer();
         if (var0 != null && var0.ip != null && !var0.ip.isBlank()) {
            return var0.ip.trim();
         }
      } catch (Throwable var1) {
      }

      return "";
   }

   public void method01814(String var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null) {
         this.method01823(new NeuroFlagC2SPacket(var2.getClientPlayer(), var1));
      }
   }

   public void method01815() {
      GlobalWebSocketClient var1 = this.field04477.method10047();
      if (var1 != null && var1.isOpen()) {
         if (this.field04496 == 0L) {
            this.method01835();
         }

         long var2 = System.currentTimeMillis();
         if (this.field04479.method02438(field04542)) {
            this.field04495 = var2;
            this.method01823(new GlobalsPingC2SPacket(var1.getClientPlayer(), var2, method01813()));
            this.field04479.method02439();
         }

         if (this.field04480.method02438(field04543)) {
            this.method01844();
            this.field04480.method02439();
         }

         if (this.field04495 > 0L && this.field04496 < this.field04495 && var2 - this.field04495 > field04544) {
            this.method01811();

            try {
               var1.closeConnection(4008, field04545);
            } catch (Exception var5) {
            }
         }
      }
   }

   public void method01816(String var1) {
      this.field04493 = var1;
   }

   public void method01817(StorageCategory var1, String var2) {
      if (var1 != null) {
         this.method01847(CloudC2SPacket.Nested276.DOWNLOAD, var1, var2, new byte[0], "");
      }
   }

   public void method01818() {
      GlobalWebSocketClient var1 = this.field04477.method10047();
      if (var1 != null) {
         this.method01823(new SocialC2SPacket(var1.getClientPlayer(), field04537, "", ""));
      }
   }

   public void method01819(StorageCategory var1, String var2, byte[] var3, String var4) {
      if (var1 != null) {
         this.method01847(CloudC2SPacket.Nested276.UPLOAD, var1, var2, CompressedFrameCodec.method00057(var3), var4 == null ? "" : var4);
      }
   }

   public void method01820(String var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null && var1 != null && !var1.isBlank()) {
         this.method01823(new MarketC2SPacket(var2.getClientPlayer(), MarketC2SPacket.Nested158.DOWNLOAD, var1));
      }
   }

   public void method01821(SaleKeyListS2CPacket var1) {
      this.field04491 = var1;
   }

   public void method01822(List<PrefixEntry> var1) {
      this.field04492 = var1;
   }

   public void method01823(GlobalPacket<GlobalPacketHandler, ?> var1) {
      if (!PacketBufferManager.INSTNCE.method03611()) {
         GlobalWebSocketClient var2 = this.field04477.method10047();
         if (var2 != null && var2.isOpen()) {
            EncryptedFrameCodec var3 = this.field04499;
            if (var3 != null) {
               var2.refreshIdentity();
               byte[] var4 = this.field04476.method00594(var1);
               if (var4 != null) {
                  try {
                     var2.send(var3.method00965(var4));
                  } catch (Exception var6) {
                  }
               }
            }
         }
      }
   }

   public Stopwatch method01824() {
      return this.field04479;
   }

   public void method01825(String var1, String var2, boolean var3) {
      this.method01847(CloudC2SPacket.Nested276.KEY_CREATE, StorageCategory.CONFIG, var1, new byte[]{(byte)(var3 ? 1 : 0)}, var2);
   }

   public void method01826(List<ClientCommandS2CPacket.Nested273> var1) {
      this.field04481 = var1;
   }

   public EncryptedFrameCodec method01827() {
      return this.field04499;
   }

   public long method01828() {
      return this.field04497;
   }

   public void method01829(String var1) {
      this.field04483 = var1;
   }

   public List<StoredContentInfo> method01830() {
      return this.field04486;
   }

   public void method01831(int var1) {
      this.field04484 = var1;
   }

   public AbstractGlobalPacketHandler method01832() {
      return this.field04477;
   }

   public void method01833(String var1) {
      this.method01847(CloudC2SPacket.Nested276.KEY_DELETE, StorageCategory.CONFIG, var1, new byte[0], "");
   }

   public List<ClientCommandS2CPacket.Nested273> method01834() {
      return this.field04481;
   }

   public void method01835() {
      this.field04479.method02439();
      long var1 = System.currentTimeMillis();
      this.field04495 = 0L;
      this.field04496 = var1;
      this.field04497 = field04526;
   }

   public void method01836(boolean var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null) {
         this.method01823(new SocialC2SPacket(var2.getClientPlayer(), field04532, String.valueOf(var1), ""));
      }
   }

   public ClientCommandS2CPacket.Nested273 method01837(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String var2 = method01789(var1);

         for (ClientCommandS2CPacket.Nested273 var4 : this.field04481) {
            if (var4 != null) {
               String var5 = var4.targetUsername();
               if (var5 != null && var5.equalsIgnoreCase(var1)) {
                  return var4;
               }

               if (var5 != null && method01789(var5).equals(var2)) {
                  return var4;
               }

               String var6 = var4.clientUsername();
               if (var6 != null && var6.equalsIgnoreCase(var1)) {
                  return var4;
               }

               if (var6 != null && method01789(var6).equals(var2)) {
                  return var4;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public void method01838(String var1, String var2) {
      GlobalWebSocketClient var3 = this.field04477.method10047();
      if (var3 != null && var1 != null && !var1.isBlank()) {
         this.method01823(new SocialC2SPacket(var3.getClientPlayer(), field04533, var1, var2 == null ? "" : var2));
      }
   }

   public void method01839(StorageCategory var1, String var2, byte[] var3) {
      this.method01819(var1, var2, var3, "");
   }

   public void method01840(List<StoredContentInfo> var1) {
      this.field04487 = var1;
   }

   private static byte[] method01841(ByteBuffer var0) {
      byte[] var1 = new byte[var0.remaining()];
      var0.slice().get(var1);
      return var1;
   }

   public void method01842(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.method01865(MarketC2SPacket.Nested158.REDEEM, var1, 0, new byte[0]);
      }
   }

   public void method01843() {
      GlobalWebSocketClient var1 = this.field04477.method10047();
      if (var1 != null) {
         this.method01823(new ClientCommandC2SPacket(var1.getClientPlayer(), ClientCommandC2SPacket.Nested313.REQUEST_USERS, "", ""));
      }
   }

   public void method01844() {
      this.method01847(CloudC2SPacket.Nested276.LIST, null, "", Sha256Utils.method06659(this.field04486), "");
   }

   public void method01845(String var1, boolean var2) {
      GlobalWebSocketClient var3 = this.field04477.method10047();
      if (var3 != null && var1 != null && !var1.isBlank()) {
         this.method01823(new SocialC2SPacket(var3.getClientPlayer(), field04534, var1, var2 ? field04535 : field04536));
      }
   }

   public void method01846(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.method01865(MarketC2SPacket.Nested158.SELL_KEY_LIST, var1, 0, new byte[0]);
      }
   }

   private void method01847(CloudC2SPacket.Nested276 var1, StorageCategory var2, String var3, byte[] var4, String var5) {
      GlobalWebSocketClient var6 = this.field04477.method10047();
      if (var6 != null) {
         String var7 = var2 == null ? "" : var2.method00552();
         this.method01823(new CloudC2SPacket(var6.getClientPlayer(), var1, var7, var3, var4, var5));
      }
   }

   public String method01848() {
      return this.field04483;
   }

   public long method01849() {
      return this.field04495;
   }

   public void method01850(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.method01865(MarketC2SPacket.Nested158.SELL_KEYS, var1, 0, new byte[0]);
      }
   }

   public void method01851() {
      this.method01847(CloudC2SPacket.Nested276.KEY_LIST, StorageCategory.CONFIG, "", new byte[0], "");
   }

   public void method01852(List<StoredContentInfo> var1) {
      this.field04486 = var1;
   }

   public void method01853(String var1) {
      this.method01847(CloudC2SPacket.Nested276.KEY_LOAD, StorageCategory.CONFIG, var1, new byte[0], "");
   }

   public void method01854(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.method01865(MarketC2SPacket.Nested158.SELL_REVOKE, var1, 0, new byte[0]);
      }
   }

   public void method01855(EncryptedFrameCodec var1) {
      this.field04499 = var1;
   }

   public void method01856() {
      GlobalWebSocketClient var1 = this.field04477.method10047();
      if (var1 != null) {
         this.method01823(new MarketC2SPacket(var1.getClientPlayer(), MarketC2SPacket.Nested158.LIST, ""));
      }
   }

   public void method01857(SecureHandshake var1) {
      this.field04498 = var1;
   }

   public void method01858() {
      this.method01847(CloudC2SPacket.Nested276.PROFILE, null, "", new byte[0], "");
   }

   public Stopwatch method01859() {
      return this.field04480;
   }

   public void method01860(String var1, int var2, byte[] var3) {
      if (var1 != null && !var1.isBlank()) {
         this.method01865(MarketC2SPacket.Nested158.SELL_CREATE, var1, var2, method01806(var3));
      }
   }

   public byte[] method01861() {
      this.field04499 = null;

      try {
         this.field04498 = SecureHandshake.method09467();
         return this.field04498.method09461();
      } catch (Exception var2) {
         this.field04498 = null;
         return null;
      }
   }

   public void method01862(long var1) {
      this.field04497 = var1;
   }

   public String method01863() {
      return this.field04493;
   }

   public void method01864(StorageCategory var1, String var2) {
      if (var1 != null) {
         this.method01847(CloudC2SPacket.Nested276.TRASH_RESTORE, var1, var2, new byte[0], "");
      }
   }

   private void method01865(MarketC2SPacket.Nested158 var1, String var2, int var3, byte[] var4) {
      GlobalWebSocketClient var5 = this.field04477.method10047();
      if (var5 != null) {
         this.method01823(new MarketC2SPacket(var5.getClientPlayer(), var1, var2, var3, var4));
      }
   }

   public void method01866(String var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null) {
         this.method01823(new SocialC2SPacket(var2.getClientPlayer(), field04530, var1 == null ? field04531 : var1, ""));
      }
   }

   public void method01867(String var1, boolean var2) {
      GlobalWebSocketClient var3 = this.field04477.method10047();
      if (var3 != null && var1 != null && !var1.isBlank()) {
         this.method01823(new ForumAuthC2SPacket(var3.getClientPlayer(), var1, var2));
      }
   }

   public void method01868(long var1, long var3) {
      long var5 = System.currentTimeMillis();
      this.field04496 = var5;
      if (var1 > 0L) {
         this.field04497 = Math.max(0L, var5 - var1);
      }
   }

   public void method01869(String var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null && var1 != null && !var1.isBlank()) {
         this.method01823(new SocialC2SPacket(var2.getClientPlayer(), field04541, var1, ""));
      }
   }

   public List<SaleListS2CPacket.Nested122> method01870() {
      return this.field04490;
   }

   public void method01871(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.method01865(MarketC2SPacket.Nested158.SELL_DELETE, var1, 0, new byte[0]);
      }
   }

   public long method01872() {
      return this.field04496;
   }

   public void method01873() {
      this.method01847(CloudC2SPacket.Nested276.TRASH_LIST, null, "", new byte[0], "");
   }

   public void method01874(String var1) {
      GlobalWebSocketClient var2 = this.field04477.method10047();
      if (var2 != null && var1 != null && !var1.isBlank()) {
         this.method01823(new SocialC2SPacket(var2.getClientPlayer(), field04538, var1, ""));
      }
   }

   public void method01875(List<SaleListS2CPacket.Nested122> var1) {
      this.field04490 = var1;
   }

   public List<StoredContentInfo> method01876() {
      return this.field04487;
   }

   public boolean method01877() {
      return this.field04499 == null && this.field04498 != null;
   }

   public void method01878(List<SocialS2CPacket.Nested57> var1) {
      this.field04494 = var1;
   }

   public List<PrefixEntry> method01879() {
      return this.field04492;
   }

   public void method01880(String var1, byte[] var2) {
      this.method01819(StorageCategory.CONFIG, var1, var2, field04528);
   }

   public void method01881(String var1) {
      this.field04482 = var1;
   }

   public String method01882() {
      return this.field04482;
   }

   private static String method01883(ClientCommandS2CPacket.Nested273 var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.sessionId();
      if (var1 != null && !var1.isBlank()) {
         return var1;
      }

      String var2 = var0.targetUsername();
      return var2 == null ? "" : var2.toLowerCase();
   }

   public GlobalPacketRegistry(AbstractGlobalPacketHandler var1) {
      List.of();
      this.field04482 = "";
      this.field04483 = "";
      this.field04484 = 6;
      List.of();
      this.field04486 = List.of();
      this.field04487 = List.of();
      this.field04488 = List.of();
      this.field04489 = List.of();
      this.field04490 = List.of();
      this.field04492 = List.of();
      this.field04493 = "";
      this.field04494 = List.of();
      this.field04497 = field04500;
      this.field04477 = var1;
      this.field04476.method00595(field04501, ChatS2CPacket::new);
      this.field04476.method00595(field04502, FriendsStateS2CPacket::new);
      this.field04476.method00595(field04503, ServerMessageS2CPacket::new);
      this.field04476.method00595(field04504, PartyCreateS2CPacket::new);
      this.field04476.method00595(field04505, WaypointSendS2CPacket::new);
      this.field04476.method00595(field04506, PartyTeleportS2CPacket::new);
      this.field04476.method00595(field04507, GlobalsPongS2CPacket::new);
      this.field04476.method00595(field04508, ClientCommandS2CPacket::new);
      this.field04476.method00595(field04509, VoiceS2CPacket::new);
      this.field04476.method00595(field04510, FunTimeDataS2CPacket::new);
      this.field04476.method00595(field04511, NeuroConfigS2CPacket::new);
      this.field04476.method00595(field04512, NeuroRotationS2CPacket::new);
      this.field04476.method00595(field04513, CloudDataS2CPacket::new);
      this.field04476.method00595(field04514, CloudListS2CPacket::new);
      this.field04476.method00595(field04515, CloudKeysS2CPacket::new);
      this.field04476.method00595(field04516, CloudProfileS2CPacket::new);
      this.field04476.method00595(field04517, MarketListS2CPacket::new);
      this.field04476.method00595(field04518, SaleListS2CPacket::new);
      this.field04476.method00595(field04519, PrefixListS2CPacket::new);
      this.field04476.method00595(field04520, PromotedServersS2CPacket::new);
      this.field04476.method00595(field04521, SaleKeysS2CPacket::new);
      this.field04476.method00595(field04522, SaleKeyListS2CPacket::new);
      this.field04476.method00595(field04523, SocialS2CPacket::new);
      this.field04476.method00595(field04524, ForumAuthS2CPacket::new);
      this.method01811();
   }

   public boolean method01884() {
      return this.field04485;
   }
}
