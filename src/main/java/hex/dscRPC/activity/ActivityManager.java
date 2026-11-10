// Original binary: hex/dscRPC/activity/ActivityManager
package hex.dscRPC.activity;

import hex.dscRPC.JDiscordIPC;
import hex.dscRPC.JDiscordIPCState;
import hex.dscRPC.activity.model.Activity;
import hex.dscRPC.event.DiscordEventListener;
import hex.dscRPC.event.model.ReadyEvent;
import hex.dscRPC.internal.util.SystemUtil;
import hex.dscRPC.packet.PacketManager;
import hex.dscRPC.packet.impl.frame.outgoing.SetActivityRequestPacket;

// $VF: Compiled from s
public class ActivityManager implements DiscordEventListener {
   private final JDiscordIPC jDiscordIPC;
   private final PacketManager packetManager;
   private Activity currentActivity = null;

   private void sendActivityPacket() {
      SetActivityRequestPacket var1 = new SetActivityRequestPacket(new SetActivityRequestPacket.Arguments(SystemUtil.getProcessId(), this.currentActivity));
      this.packetManager.sendPacket(var1, var0 -> {});
   }

   public ActivityManager(JDiscordIPC var1, PacketManager var2) {
      this.packetManager = var2;
      this.jDiscordIPC = var1;
      this.jDiscordIPC.registerEventListener(this);
   }

   public void updateActivity(Activity var1) {
      this.currentActivity = var1;
      if (this.jDiscordIPC.state() == JDiscordIPCState.READY) {
         this.sendActivityPacket();
      }
   }

   @Override
   public void onReadyEvent(ReadyEvent var1) {
      this.sendActivityPacket();
   }
}
