// Original binary: hex/api/baritone/behavior/WaypointBehavior
package hex.api.baritone.behavior;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.cache.IWaypoint;
import hex.api.baritone.api.cache.IWorldData;
import hex.api.baritone.api.cache.Waypoint;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.event.events.BlockInteractEvent;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.utils.BlockStateInterface;
import java.util.Set;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;

// $VF: Compiled from s
public class WaypointBehavior extends Behavior {
   private static final String бтм = "бтм";
   private static final String бтФ = "бтФ";
   private static final String бт3 = "бт3";
   private static final String бтЬ = "бтЬ";
   private static final String бт1 = "бт1";
   private static final String бтя = "бтя";

   @Override
   public void onPlayerDeath() {
      if (Baritone.settings().doDeathWaypoints.value) {
         IWorldData var1 = this.baritone.getWorldProvider().getCurrentWorld();
         if (var1 != null) {
            Waypoint sx = new Waypoint(бтФ, IWaypoint.Tag.DEATH, this.ctx.playerFeet());
            var1.getWaypoints().addWaypoint(sx);
            MutableComponent sxx = Component.literal(бт3);
            sxx.setStyle(
               sxx.getStyle()
                  .withColor(ChatFormatting.WHITE)
                  .withHoverEvent(new ShowText(Component.literal(бтЬ)))
                  .withClickEvent(
                     new RunCommand(String.format(бт1, IBaritoneChatControl.FORCE_COMMAND_PREFIX, бтя, sx.getTag().getName(), sx.getCreationTimestamp()))
                  )
            );
            Helper.HELPER.logDirect(sxx);
         }
      }
   }


   @Override
   public void onBlockInteract(BlockInteractEvent var1) {
      if (Baritone.settings().doBedWaypoints.value) {
         IWorldData var2 = this.baritone.getWorldProvider().getCurrentWorld();
         if (var2 != null) {
            if (var1.getType() == BlockInteractEvent.Type.USE) {
               BetterBlockPos sx = BetterBlockPos.from(var1.getPos());
               BlockState sxx = BlockStateInterface.get(this.ctx, sx);
               if (sxx.getBlock() instanceof BedBlock) {
                  if (sxx.getValue(BedBlock.PART) == BedPart.FOOT) {
                     sx = sx.relative(sxx.getValue(BedBlock.FACING));
                  }

                  var sxxx = var2.getWaypoints().getByTag(IWaypoint.Tag.BED);
                  boolean sxxxx = sxxx.stream().map(IWaypoint::getLocation).filter(sx::equals).findFirst().isPresent();
                  if (!sxxxx) {
                     var2.getWaypoints().addWaypoint(new Waypoint(бтм, IWaypoint.Tag.BED, sx));
                  }
               }
            }
         }
      }
   }

   public WaypointBehavior(Baritone var1) {
      super(var1);
   }
}
