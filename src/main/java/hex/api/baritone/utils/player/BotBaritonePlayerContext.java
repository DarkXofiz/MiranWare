// Original binary: hex/api/baritone/utils/player/BotBaritonePlayerContext
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
public final class BotBaritonePlayerContext implements IPlayerContext {
   private final Baritone baritone;
   private final Minecraft mc;
   private final BotClient bot;
   private final IPlayerController activeController;
   private final IPlayerController botController;

   @Override
   public BetterBlockPos viewerPos() {
      Entity var1 = this.player();
      return var1 == null ? this.playerFeet() : BetterBlockPos.from(var1.blockPosition());
   }

   @Override
   public IWorldData worldData() {
      return this.baritone.getWorldProvider().getCurrentWorld();
   }

   @Override
   public Minecraft minecraft() {
      return this.mc;
   }

   public BotClient bot() {
      return this.bot;
   }

   public BotBaritonePlayerContext(Baritone var1, Minecraft var2, BotClient var3) {
      this.baritone = var1;
      this.mc = var2;
      this.bot = var3;
      this.activeController = new BaritonePlayerController(var2);
      this.botController = new BotBaritonePlayerController(var3);
   }

   private boolean active() {
      return BotSessionManager.INSTANCE.method08733(this.bot);
   }

   @Override
   public LocalPlayer player() {
      return this.active() ? this.mc.player : this.bot.method00090().method07688();
   }

   @Override
   public Level world() {
      return this.active() ? this.mc.level : this.bot.method00090().method07636();
   }

   @Override
   public IPlayerController playerController() {
      return this.active() ? this.activeController : this.botController;
   }

   @Override
   public Rotation playerRotations() {
      return this.baritone.getLookBehavior().getEffectiveRotation().orElseGet(() -> IPlayerContext.super.playerRotations());
   }

   @Override
   public HitResult objectMouseOver() {
      return RayTraceUtils.rayTraceTowards(this.player(), this.playerRotations(), this.playerController().getBlockReachDistance());
   }
}
