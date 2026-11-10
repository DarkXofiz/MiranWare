// Original binary: sg/ec/SUcGO1jM1r7viS0I
package sg.ec;

import hex.api.baritone.api.IBaritone;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSoundEntityPacket;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Input;

// $VF: Compiled from s
public enum BotTaskManager implements MinecraftAccess {
   INSTANCE;

   private static final long field11756 = 300000L;
   private final Map<String, BotTaskManager.Nested166> field11757 = new ConcurrentHashMap<>();
   private final BotInputState field11758 = new BotInputState();
   private int field11759;

   public void method05428() {
      EventBus.method00263(this);
   }

   @Subscribe
   private void method05429(PlayerInputEvent var1) {
      WardenLootTask var2 = this.method05442();
      if (var2 != null && mc.player != null) {
         if (!mc.player.onGround() && !mc.player.onClimbable()) {
            var1.method11169(false);
         }

         int var3 = var2.method05890();
         if (var3 != 0) {
            var1.method11167(var3);
            var1.method11158(var3);
         } else {
            this.method05430(var1, var2.method01775());
         }
      }
   }

   private void method05430(PlayerInputEvent var1, IBaritone var2) {
      if (var1.method11161() > 0.0F) {
         var1.method11158(0.0F);
         var1.method11174(!var1.method11160() && !BotClient.method00077(var2));
         if (BotPathingUtils.method06243(var2, mc.player)) {
            var1.method11173(true);
         }
      }

      Input var3 = this.field11758.method05145(mc.player, var1.method11171());
      var1.method11167(var3.forward() ? 1.0F : (var3.backward() ? -1.0F : 0.0F));
      var1.method11158(var3.left() ? 1.0F : (var3.right() ? -1.0F : 0.0F));
      var1.method11173(var3.jump());
      var1.method11174(var3.sprint());
   }

   @Subscribe
   private void method05431(ItemUseInputEvent var1) {
      WardenLootTask var2 = this.method05442();
      if (var2 != null && var2.method05889()) {
         var1.method10456(true);
      }
   }

   @Subscribe
   private void method05432(PacketEvent var1) {
      if (var1.method10904()) {
         BotClient var2 = BotSessionManager.INSTANCE.method08762();
         if (var2 != null) {
            if (var1.method10897() instanceof ClientboundSoundPacket var3) {
               this.method05433(var2, var3.getSound().value());
            } else if (var1.method10897() instanceof ClientboundSoundEntityPacket var4) {
               this.method05433(var2, var4.getSound().value());
            }
         }
      }
   }

   public void method05433(BotClient var1, SoundEvent var2) {
      String var3 = var2.location().getPath();
      if (var3.contains("warden.roar") || var3.contains("warden.angry") || var3.contains("warden.sonic")) {
         BotTaskManager.Nested166 var4 = this.field11757.get(var1.method00137().method00497());
         if (var4 != null) {
            var4.field11762.method02631();
         }
      }
   }

   public BotTaskManager.Nested166 method05434(BotClient var1) {
      return this.field11757.computeIfAbsent(var1.method00137().method00497(), var1x -> new BotTaskManager.Nested166(var1));
   }

   public void method05435(BotClient var1) {
      BotTaskManager.Nested166 var2 = this.field11757.remove(var1.method00137().method00497());
      if (var2 != null) {
         var2.method05451();
      }
   }

   public void method05436(BotClient var1, Component var2) {
      BotTaskManager.Nested166 var3 = this.field11757.get(var1.method00137().method00497());
      if (var3 != null) {
         var3.method05448(var2.getString());
      }
   }

   public boolean method05437(BotClient var1) {
      BotTaskManager.Nested166 var2 = this.field11757.get(var1.method00137().method00497());
      return var2 != null && var2.field11765;
   }

   public void method05438() {
      this.method05439();
      HashSet var1 = new HashSet();
      BotClient var2 = BotSessionManager.INSTANCE.method08755();
      if (var2 != null) {
         var1.add(var2.method00137().method00497());
         if (this.method05441(var2)) {
            this.method05443();
            this.method05434(var2).method05449(var2);
         } else {
            this.method05444(var2);
         }
      }

      for (BotClient var4 : BotManager.INSTANCE.method03092()) {
         var1.add(var4.method00137().method00497());
         if (this.method05441(var4)) {
            this.method05443();
            this.method05434(var4).method05449(var4);
         } else {
            this.method05444(var4);
         }
      }

      var var5 = this.field11757.entrySet().iterator();

      while (var5.hasNext()) {
         Entry var6 = (Entry)var5.next();
         if (!var1.contains(var6.getKey())) {
            ((BotTaskManager.Nested166)var6.getValue()).method05452();
            var5.remove();
         }
      }
   }

   private void method05439() {
      BotClient var1 = BotSessionManager.INSTANCE.method08762();
      if (var1 != null && var1.method00137().method00475() != AutoBuyBotStatus.WARDEN) {
         if (++this.field11759 % 100 == 0) {
            String var10001 = "WARDEN";
            String var10002 = "варден выключен — мозг не работает";
         }
      }
   }

   public void method05440(BotClient var1) {
      if (!this.method05441(var1) && this.method05445(var1)) {
         this.method05434(var1).method05449(var1);
      }
   }

   private boolean method05441(BotClient var1) {
      if (var1.method00137().method00475() != AutoBuyBotStatus.WARDEN) {
         return false;
      } else if (mc.player == null || mc.level == null) {
         return false;
      } else {
         return var1 == BotSessionManager.INSTANCE.method08761()
            ? BotSessionManager.INSTANCE.method08762() == null
            : BotSessionManager.INSTANCE.method08733(var1) && var1.method00146() == BotConnectionState.CONTROLLED;
      }
   }

   public WardenLootTask method05442() {
      BotClient var1 = BotSessionManager.INSTANCE.method08762();
      if (var1 != null && this.method05441(var1)) {
         BotTaskManager.Nested166 var2 = this.field11757.get(var1.method00137().method00497());
         return var2 != null && var2.field11765 ? var2.field11762.method01749() : null;
      } else {
         return null;
      }
   }

   private void method05443() {
      if (mc.player != null && mc.player.deathTime >= 5) {
         if (mc.screen instanceof DeathScreen) {
            mc.player.respawn();
         }
      }
   }

   private void method05444(BotClient var1) {
      if (!this.method05445(var1) && !this.method05446(var1)) {
         BotTaskManager.Nested166 var2 = this.field11757.get(var1.method00137().method00497());
         if (var2 != null) {
            var2.method05452();
            var2.method05450(300000L);
         }
      }
   }

   private boolean method05445(BotClient var1) {
      if (var1.method00137().method00475() != AutoBuyBotStatus.WARDEN) {
         return false;
      } else {
         return BotSessionManager.INSTANCE.method08733(var1)
            ? this.method05441(var1)
            : var1.method00146() == BotConnectionState.PLAYING && var1.method00090().method07688() != null && var1.method00090().method07636() != null;
      }
   }

   private boolean method05446(BotClient var1) {
      return var1.method00137().method00475() != AutoBuyBotStatus.WARDEN
         ? false
         : var1.method00146().method05280() || var1.method00146() == BotConnectionState.CONTROLLED || BotSessionManager.INSTANCE.method08733(var1);
   }

   // $VF: Compiled from s
   public static final class Nested166 {
      private final WardenSpawnerTracker field11760 = new WardenSpawnerTracker();
      private final ElapsedTimer field11761 = new ElapsedTimer();
      private final WardenBotTask field11762;
      private final WardenBotController field11763;
      private final Object field11764 = new Object();
      private volatile boolean field11765;
      private volatile boolean field11766;
      private boolean field11767;
      private int field11768 = -1;
      private int field11769 = -1;

      private void method05448(String var1) {
         synchronized (this.field11764) {
            if (this.field11765) {
               this.field11763.method02108(var1);
            }
         }
      }

      private void method05449(BotClient var1) {
         synchronized (this.field11764) {
            if (!this.field11766) {
               this.field11761.method04694();
               this.field11767 = false;
               this.field11762.method01746();
               this.field11762.method01769();
               if (!this.field11765) {
                  this.field11765 = true;
                  this.field11768 = -1;
                  this.field11769 = -1;
                  this.field11763.method02043();
               }

               AutoBuyBotState var3 = var1.method00137();
               int var4 = var3.method00487();
               int var5 = var3.method00482();
               if (var5 < 0) {
                  int var6 = this.field11762.method01743();
                  if (var6 >= 0 && this.field11763.method02021()) {
                     var3.method00488(var6);
                     BotManager.INSTANCE.method03088();
                     var5 = var6;
                  }
               }

               if (this.field11768 != var4 || this.field11769 != var5) {
                  this.field11768 = var4;
                  this.field11769 = var5;
                  this.field11763.method02084(var5, var4);
               }

               this.field11763.method02054();
            }
         }
      }

      private void method05450(long var1) {
         synchronized (this.field11764) {
            if (!this.field11767 && this.field11761.method04699(var1)) {
               this.field11767 = true;
               this.field11760.method05353();
               this.field11763.method02103();
            }
         }
      }

      private void method05451() {
         this.field11766 = true;
         this.method05452();
      }

      private void method05452() {
         synchronized (this.field11764) {
            if (this.field11765) {
               this.field11765 = false;
               this.field11768 = -1;
               this.field11769 = -1;
               this.field11763.method02068();
               this.field11762.method01763();
            }
         }
      }

      private Nested166(BotClient var1) {
         this.field11762 = new WardenBotTask(var1, this.field11760);
         this.field11763 = new WardenBotController(this.field11762);
      }
   }
}
