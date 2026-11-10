// Original binary: sg/ec/2qaQm2HItjQAtjod
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ParticleStatus;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.ChatVisiblity;

// $VF: Compiled from s
public final class ClientLanguage {
   private static final String field01108 = "en_us";

   public static ClientInformation method00599() {
      ClientInformation var0 = method00600();
      return var0 == null
         ? new ClientInformation(
            field01108, BotManager.INSTANCE.method03096(), ChatVisiblity.FULL, true, 127, HumanoidArm.RIGHT, false, true, ParticleStatus.ALL
         )
         : new ClientInformation(
            var0.language(),
            BotManager.INSTANCE.method03096(),
            var0.chatVisibility(),
            var0.chatColors(),
            var0.modelCustomisation(),
            var0.mainHand(),
            var0.textFilteringEnabled(),
            var0.allowsListing(),
            var0.particleStatus()
         );
   }

   private static ClientInformation method00600() {
      Options var0 = Minecraft.getInstance().options;
      return var0 == null ? null : var0.buildPlayerInformation();
   }

   private ClientLanguage() {
   }
}
