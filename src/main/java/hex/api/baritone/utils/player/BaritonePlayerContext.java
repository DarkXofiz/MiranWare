// Original binary: hex/api/baritone/utils/player/BaritonePlayerContext
package hex.api.baritone.utils.player;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.cache.IWorldData;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.api.utils.IPlayerController;
import hex.api.baritone.api.utils.RayTraceUtils;
import hex.api.baritone.api.utils.Rotation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import sg.ec.BotClient;
import sg.ec.BotSessionManager;

// $VF: Compiled from s
public final class BaritonePlayerContext implements IPlayerContext {
   private final Baritone baritone;
   private final Minecraft mc;
   private final IPlayerController playerController;
   private IPlayerController ownerBotController;
   private BotClient ownerBotControllerFor;

   public BaritonePlayerContext(Baritone var1, Minecraft var2) {
      this.baritone = var1;
      this.mc = var2;
      this.playerController = new BaritonePlayerController(var2);
   }

   @Override
   public Level world() {
      BotClient var1 = this.backgroundOwner();
      return var1 != null ? var1.method00090().method07636() : this.mc.level;
   }

   private BotClient backgroundOwner() {
      BotClient var1 = BotSessionManager.INSTANCE.method08761();
      if (var1 != null && !BotSessionManager.INSTANCE.method08733(var1)) {
         return var1.method00090().method07688() != null && var1.method00090().method07636() != null ? var1 : null;
      } else {
         return null;
      }
   }

   @Override
   public IWorldData worldData() {
      return this.baritone.getWorldProvider().getCurrentWorld();
   }

   @Override
   public IPlayerController playerController() {
      BotClient var1 = this.backgroundOwner();
      if (var1 == null) {
         return this.playerController;
      }

      if (this.ownerBotControllerFor != var1) {
         this.ownerBotController = new BotBaritonePlayerController(var1);
         this.ownerBotControllerFor = var1;
      }

      return this.ownerBotController;
   }

   @Override
   public BetterBlockPos viewerPos() {
      Entity var1 = this.backgroundOwner() != null ? this.player() : this.mc.getCameraEntity();
      return var1 == null ? this.playerFeet() : BetterBlockPos.from(var1.blockPosition());
   }

   @Override
   public Minecraft minecraft() {
      return this.mc;
   }

   @Override
   public Rotation playerRotations() {
      return this.baritone.getLookBehavior().getEffectiveRotation().orElseGet(() -> IPlayerContext.super.playerRotations());
   }

   @Override
   public HitResult objectMouseOver() {
      return RayTraceUtils.rayTraceTowards(this.player(), this.playerRotations(), this.playerController().getBlockReachDistance());
   }

   @Override
   public LocalPlayer player() {
      BotClient var1 = this.backgroundOwner();
      return var1 != null ? var1.method00090().method07688() : this.mc.player;
   }
}
