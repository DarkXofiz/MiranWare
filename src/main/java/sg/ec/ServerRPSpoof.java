// Original binary: sg/ec/BbUPTb5IV6vlkWtd
package sg.ec;

import net.minecraft.network.protocol.common.ServerboundResourcePackPacket;
import net.minecraft.network.protocol.common.ServerboundResourcePackPacket.Action;

// $VF: Compiled from s
public class ServerRPSpoof extends ClientModule {
   private final ToggleSetting field06542;
   private static final String field06543 = "Обход анти фикса";
   private static final String field06544 = "Server RP Spoof";

   @Subscribe
   private void method02811(ResourcePackRequestEvent var1) {
      if (var1.method06960() != null && var1.method06964() != null) {
         var1.method06960().send(new ServerboundResourcePackPacket(var1.method06964().id(), Action.ACCEPTED));
         Runnable var2 = () -> var1.method06960().send(new ServerboundResourcePackPacket(var1.method06964().id(), Action.SUCCESSFULLY_LOADED));
         if (this.field06542.method05999() && var1.method06959() != null) {
            var1.method06959().execute(var2);
         } else {
            var2.run();
         }

         var1.method05696();
      }
   }

   public ServerRPSpoof() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field06542 = new ToggleSetting(field06543).method03017(false).method03023(this);
      this.method03935(field06544);
   }
}
