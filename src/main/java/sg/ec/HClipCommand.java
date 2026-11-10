// Original binary: sg/ec/9y5S7Tk6hGzh0Jh9
package sg.ec;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.PosRot;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
@CommandInfo(name = "hclip", description = "")
public class HClipCommand extends AbstractCommand {
   private static final String field05958 = "value";
   private static final float field05959 = -5000.0F;
   private static final float field05960 = 5000.0F;
   private static final String field05961 = "value";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var1.then(
         this.method01184(field05958, FloatArgumentType.floatArg(field05959, field05960))
            .executes(
               var0 -> {
                  float var1x = (Float)var0.getArgument(field05961, Float.class);
                  Vec3 var2 = mc.player.getLookAngle().scale(var1x);
                  PlayerUtils.method11812(
                     new PosRot(
                        mc.player.getX() + var2.x,
                        mc.player.getY(),
                        mc.player.getZ() + var2.z,
                        mc.player.getYRot(),
                        mc.player.getXRot(),
                        mc.player.onGround(),
                        mc.player.horizontalCollision
                     )
                  );
                  mc.player.setPos(mc.player.getX() + var2.x, mc.player.getBlockY(), mc.player.getZ() + var2.z);
                  return 1;
               }
            )
      );
   }
}
