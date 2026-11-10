// Original binary: hex/api/baritone/process/FollowProcess
package hex.api.baritone.process;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import hex.api.baritone.api.pathing.goals.GoalComposite;
import hex.api.baritone.api.pathing.goals.GoalNear;
import hex.api.baritone.api.pathing.goals.GoalXZ;
import hex.api.baritone.api.process.IFollowProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.utils.BaritoneProcessHelper;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class FollowProcess extends BaritoneProcessHelper implements IFollowProcess {
   private Predicate<Entity> filter;
   private List<Entity> cache;
   private boolean into;

   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      this.scanWorld();
      Goal var3 = new GoalComposite(this.cache.stream().map(this::towards).toArray(Goal[]::new));
      return new PathingCommand(var3, PathingCommandType.REVALIDATE_GOAL_AND_PATH);
   }

   @Override
   public String displayName0() {
      return "Following " + this.cache;
   }

   @Override
   public boolean isActive() {
      if (this.filter == null) {
         return false;
      }

      this.scanWorld();
      return !this.cache.isEmpty();
   }

   public FollowProcess(Baritone var1) {
      super(var1);
   }

   @Override
   public Predicate<Entity> currentFilter() {
      return this.filter;
   }

   @Override
   public void pickup(Predicate<ItemStack> var1) {
      this.filter = var1x -> var1x instanceof ItemEntity && var1.test(((ItemEntity)var1x).getItem());
      this.into = true;
   }

   @Override
   public void follow(Predicate<Entity> var1) {
      this.filter = var1;
      this.into = false;
   }

   private boolean followable(Entity var1) {
      if (var1 == null) {
         return false;
      }

      if (!var1.isAlive()) {
         return false;
      }

      if (var1.equals(this.ctx.player())) {
         return false;
      }

      int var2 = Baritone.settings().followTargetMaxDistance.value;
      return var2 != 0 && var1.distanceToSqr(this.ctx.player()) > var2 * var2 ? false : this.ctx.entitiesStream().anyMatch(var1::equals);
   }

   private void scanWorld() {
      this.cache = this.ctx.entitiesStream().filter(this::followable).filter(this.filter).distinct().collect(Collectors.toList());
   }

   @Override
   public void onLostControl() {
      this.filter = null;
      this.cache = null;
   }

   private Goal towards(Entity var1) {
      BlockPos var2;
      if (Baritone.settings().followOffsetDistance.value != 0.0 && !this.into) {
         GoalXZ sx = GoalXZ.fromDirection(var1.position(), Baritone.settings().followOffsetDirection.value, Baritone.settings().followOffsetDistance.value);
         var2 = new BetterBlockPos(sx.getX(), var1.position().y, sx.getZ());
      } else {
         var2 = var1.blockPosition();
      }

      return this.into ? new GoalBlock(var2) : new GoalNear(var2, Baritone.settings().followRadius.value);
   }

   @Override
   public List<Entity> following() {
      return this.cache;
   }
}
