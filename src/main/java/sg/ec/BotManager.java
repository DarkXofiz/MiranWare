// Original binary: sg/ec/DA7wuDcuzXL8WQGG
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.Connection;
import net.minecraft.server.network.EventLoopGroupHolder;

// $VF: Compiled from s
public enum BotManager implements MinecraftAccess {
   INSTANCE;

   public static final int field06862 = 512;
   public static final int field06863 = 0;
   private static final long field06864 = 0;
   private final List<BotClient> field06865 = new CopyOnWriteArrayList<>();
   private final ConcurrentLinkedQueue<BotClient> field06866 = new ConcurrentLinkedQueue<>();
   private final AtomicBoolean field06867 = new AtomicBoolean();
   private long field06868 = 400L;
   private int field06869 = 4;
   private boolean field06870;
   private boolean field06871 = true;

   public boolean method03064() {
      return true;
   }

   public void method03065() {
      EventBus.method00263(this);
   }

   public BotClient method03066(String var1, String var2) {
      return this.method03067(var1, var2, "");
   }

   public BotClient method03067(String var1, String var2, String var3) {
      BotClient var4 = this.method03069(var1, var2, var3);
      if (var4 != null) {
         this.method03088();
      }

      return var4;
   }

   public BotClient method03068(String var1, String var2) {
      return this.method03069(var1, var2, "");
   }

   public BotClient method03069(String var1, String var2, String var3) {
      if (this.field06865.size() >= 512) {
         return null;
      } else {
         String var4 = var1 == null ? "" : var1.trim();
         String var5 = method03087(var2);
         if (TextRenderUtils.method00673(var4) && !var5.isEmpty() && this.method03073(var4) == null) {
            AutoBuyBotState var6 = new AutoBuyBotState(var4, var5);
            var6.method00495(var3 == null ? "" : var3);
            BotClient var7 = new BotClient(var6);
            this.field06865.add(var7);
            return var7;
         } else {
            return null;
         }
      }
   }

   public List<BotClient> method03070(String var1, int var2, String var3) {
      return this.method03071(var1, var2, var3, "");
   }

   public List<BotClient> method03071(String var1, int var2, String var3, String var4) {
      ArrayList var5 = new ArrayList();
      String var6 = var1 == null ? "" : var1.trim();

      for (int var7 = 1; var7 <= var2; var7++) {
         BotClient var8 = this.method03069(var6 + var7, var3, var4);
         if (var8 != null) {
            var5.add(var8);
         }
      }

      if (!var5.isEmpty()) {
         this.method03088();
      }

      return var5;
   }

   public void method03072(BotClient var1) {
      if (var1 != null) {
         var1.method00103();
         this.field06865.remove(var1);
         BotFollowManager.INSTANCE.method02187(var1);
         BotTaskManager.INSTANCE.method05435(var1);
         BotStatusManager.INSTANCE.method02731(var1);
         this.method03088();
      }
   }

   public BotClient method03073(String var1) {
      for (BotClient var3 : this.field06865) {
         if (var3.method00137().method00491().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public BotClient method03074(Connection var1) {
      for (BotClient var3 : this.field06865) {
         if (var3.method00128() == var1) {
            return var3;
         }
      }

      BotClient var4 = BotSessionManager.INSTANCE.method08761();
      return var4 != null && var4.method00128() == var1 ? var4 : null;
   }

   public void method03075() {
      for (BotClient var2 : this.field06865) {
         if (var2.method00146() != BotConnectionState.CONTROLLED) {
            var2.method00151();
         }
      }
   }

   public void method03076() {
      for (BotClient var2 : this.field06865) {
         var2.method00103();
      }
   }

   public int method03077(String var1) {
      BotClient var2 = BotSessionManager.INSTANCE.method08761();
      int var3 = 0;

      for (BotClient var5 : this.field06865) {
         if (var5 != var2 && (var5.method00146().method05278() || BotSessionManager.INSTANCE.method08733(var5))) {
            var5.method00144(var1);
            var3++;
         }
      }

      return var3;
   }

   public int method03078() {
      int var1 = 0;

      for (BotClient var3 : this.field06865) {
         if (var3.method00146().method05278()) {
            var1++;
         }
      }

      return var1;
   }

   public int method03079() {
      int var1 = 0;

      for (BotClient var3 : this.field06865) {
         if (var3.method00146().method05280()) {
            var1++;
         }
      }

      return var1;
   }

   public void method03080(BotClient var1) {
      if (!this.field06866.contains(var1)) {
         this.field06866.add(var1);
      }

      this.method03082(0L);
   }

   public void method03081(BotClient var1) {
      this.field06866.remove(var1);
   }

   private void method03082(long var1) {
      if (this.field06867.compareAndSet(false, true)) {
         this.method03083(var1);
      }
   }

   private void method03083(long var1) {
      EventLoopGroupHolder.remote(mc.options.useNativeTransport()).eventLoopGroup().schedule(this::method03084, Math.max(var1, 1L), TimeUnit.MILLISECONDS);
   }

   private void method03084() {
      try {
         long var1 = System.currentTimeMillis();
         ArrayList var3 = new ArrayList();
         BotClient var4 = null;

         for (BotClient var5 = this.field06866.poll(); var5 != null; var5 = this.field06866.poll()) {
            if (var5.method00069()) {
               if (var1 >= var5.method00076()) {
                  var4 = var5;
                  break;
               }

               var3.add(var5);
            }
         }

         this.field06866.addAll(var3);
         if (var4 == null) {
            this.field06867.set(false);
            if (!this.field06866.isEmpty()) {
               this.method03082(1000L);
            }

            return;
         }

         if (this.method03085() >= 30) {
            this.field06866.add(var4);
            this.method03083(1000L);
            return;
         }

         var4.method00170();
         this.method03083(this.field06868);
      } catch (Throwable var6) {
         Object var10000 = null;
         String var10001 = "QUEUE";
         String.valueOf("очередь сорвалась: " + var6);
         this.field06867.set(false);
         this.method03083(1000L);
      }
   }

   private int method03085() {
      int var1 = 0;

      for (BotClient var3 : this.field06865) {
         BotConnectionState var4 = var3.method00146();
         if (var4 != BotConnectionState.QUEUED && var4.method05280()) {
            var1++;
         }
      }

      return var1;
   }

   public String method03086() {
      ServerData var1 = mc.getCurrentServer();
      return var1 != null && var1.ip != null ? var1.ip : "";
   }

   public static String method03087(String var0) {
      return var0 == null ? "" : var0.trim().toLowerCase(Locale.ROOT);
   }

   public void method03088() {
      CustomResourceManager.INSTANCE.method02460();
   }

   @Subscribe
   private void method03089(ClientShutdownEvent var1) {
      this.method03076();
   }

   @Subscribe(4)
   private void method03090(PlayerInputEvent var1) {
      BotSessionManager.INSTANCE.method08744(var1);
   }

   @Subscribe
   private void method03091(TickEvent var1) {
      if (!this.field06865.isEmpty()) {
         RegistryDataMerger.method08053();
      }

      BotSessionManager.INSTANCE.method08745();
      BotFollowManager.INSTANCE.method02188();
      BotTaskManager.INSTANCE.method05438();
      BotStatusManager.INSTANCE.method02729();

      for (BotClient var3 : this.field06865) {
         var3.method00109();
      }

      BotClient var4 = BotSessionManager.INSTANCE.method08761();
      if (var4 != null) {
         var4.method00109();
      }
   }

   public List<BotClient> method03092() {
      return this.field06865;
   }

   public ConcurrentLinkedQueue<BotClient> method03093() {
      return this.field06866;
   }

   public AtomicBoolean method03094() {
      return this.field06867;
   }

   public long method03095() {
      return this.field06868;
   }

   public int method03096() {
      return this.field06869;
   }

   public boolean method03097() {
      return this.field06870;
   }

   public boolean method03098() {
      return this.field06871;
   }

   public void method03099(long var1) {
      this.field06868 = var1;
   }

   public void method03100(int var1) {
      this.field06869 = var1;
   }

   public void method03101(boolean var1) {
      this.field06870 = var1;
   }

   public void method03102(boolean var1) {
      this.field06871 = var1;
   }
}
