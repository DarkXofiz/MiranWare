// Original binary: sg/ec/G67lA87gEaRN2rgr
package sg.ec;

import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;

// $VF: Compiled from s
public class TickTaskScheduler implements MinecraftAccess {
   private static TickTaskScheduler field07849;
   private final TickTaskQueue field07850 = new TickTaskQueue();
   public static int field07851;

   public static TickTaskScheduler method03501() {
      return field07849;
   }

   public static void method03503(int var0) {
      field07851 = var0;
   }

   @Subscribe(0)
   private void method03504(PlayerInputEvent var1) {
      field07849.field07850.method10553();
      if (field07851 > 0) {
         var1.method11168();
         var1.method11173(false);
         var1.method11169(false);
         field07851--;
      }
   }

   public static int method03505() {
      return field07851;
   }

   public TickTaskQueue method03506() {
      return this.field07850;
   }

   public static void method03507(Runnable var0) {
      method03509(var0, 1, true);
   }

   public static void method03509(Runnable var0, int var1, boolean var2) {
      int var3 = mc.player.containerMenu.containerId;
      InventoryMove var4 = ModuleManager.INSTANCE.method08262();
      if (!var4.method03558() && !method03511(var4)) {
         var0.run();
         if (var2) {
            PlayerUtils.method11812(new ServerboundContainerClosePacket(var3));
         }
      } else {
         TickTaskQueue var5 = method03501().method03506();
         var5.method10569();
         var5.method10577(0, () -> field07851 = var4.method03543(var1), 0).method10577(1, () -> {
            var0.run();
            if (var2) {
               PlayerUtils.method11812(new ServerboundContainerClosePacket(var3));
            }
         }, 0);
      }
   }

   public static void method03510(Runnable var0, int var1) {
      method03509(var0, var1, true);
   }

   private static boolean method03511(InventoryMove var0) {
      return var0.field07867.method05999() && mc.options.keyJump.isDown();
   }

   public TickTaskScheduler() {
      field07849 = this;
      EventBus.method00263(this);
   }
}
