// Original binary: sg/ec/gktr9dJSTiz0HfAR
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class WebTrap extends ClientModule {
   private static final float field19594 = 4.5F;
   private static final int field19595 = 0;
   private static final int field19596 = 0;
   private static final int field19597 = 0;
   private static final int field19598 = 0;
   private final ModeSetting field19599;
   private final ToggleSetting field19600;
   private final ToggleSetting field19601;
   private int field19602;
   private int field19603;
   private int field19604;
   private BlockPos field19605;
   private static final String field19606 = "Mode";
   private static final String field19607 = "Solo";
   private static final String field19608 = "Multi";
   private static final String field19609 = "Solo";
   private static final String field19610 = "RageMode";
   private static final String field19611 = "Обход Matrix";
   private static final String field19612 = "Web Trap";
   private static final double field19613 = Double.MAX_VALUE;
   private static final double field19614 = 4.5;
   private static final String field19615 = "Multi";

   private List<BlockTrapController.Nested324> method08519(Player var1, BlockPos var2) {
      List var3 = new ArrayList<>();
      this.field19602 = 0;
      boolean sx = CrystalAura.method07430();
      if (this.field19599.method05600(field19615)) {
         this.method08524(var3, var2, var1, sx);
         this.method08524(var3, var2.above(), var1, sx);
         this.method08524(var3, var2.offset(1, 0, 0), var1, sx);
         this.method08524(var3, var2.offset(-1, 0, 0), var1, sx);
         this.method08524(var3, var2.offset(0, 0, 1), var1, sx);
         this.method08524(var3, var2.offset(0, 0, -1), var1, sx);
         this.method08524(var3, var2.offset(1, 1, 0), var1, sx);
         this.method08524(var3, var2.offset(-1, 1, 0), var1, sx);
         this.method08524(var3, var2.offset(0, 1, 1), var1, sx);
         this.method08524(var3, var2.offset(0, 1, -1), var1, sx);
         return var3;
      }

      BlockPos sxx = var2.above();
      if (!this.method08527(sxx) && !this.method08527(var2)) {
         if (!BlockTrapController.method11572(sxx) || !this.method08524(var3, sxx, var1, sx)) {
            this.method08524(var3, var2, var1, sx);
         }

         return var3;
      } else {
         return var3;
      }
   }

   private Player method08520() {
      Player var1 = null;
      double var2 = field19613;
      AntiBot var4 = ModuleManager.INSTANCE.method08260();

      for (Player var6 : mc.level.players()) {
         if (CombatTargetUtils.method03517(var6, var4) && this.method08526(var6)) {
            double var7 = var6.position().distanceToSqr(mc.player.position());
            if (var7 < var2) {
               var2 = var7;
               var1 = var6;
            }
         }
      }

      return var1;
   }

   private BlockPos method08521(Player var1) {
      SimulatedPlayerInput var2 = SimulatedPlayerInput.method08903(var1, 7);
      Vec3 var3 = var2.field20218 != null ? var2.field20218 : var1.position();
      return BlockPos.containing(var3);
   }

   @Subscribe
   private void method08522(PlayerUpdateEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (InventoryUtils.method06111(Items.COBWEB, true) == -1) {
            this.method08525();
         } else if (mc.player.tickCount < this.field19604) {
            this.method08525();
         } else {
            Player var2 = this.method08520();
            if (var2 != null && !var2.isEyeInFluid(FluidTags.WATER)) {
               BlockPos var3 = this.method08521(var2);
               var var4 = this.method08519(var2, var3);
               if (!var4.isEmpty() && this.field19602 != 0) {
                  this.field19603 = var3.equals(this.field19605) ? this.field19603 + 1 : 1;
                  this.field19605 = var3;
                  if (this.field19603 > 8) {
                     this.field19604 = mc.player.tickCount + 20;
                     this.method08525();
                  } else {
                     BlockTrapController.method11595(var4, true, true, 100, this.field19600.method03022(), this.field19601.method03022());
                  }
               } else {
                  this.method08525();
               }
            } else {
               this.method08525();
            }
         }
      }
   }

   private boolean method08523(BlockPos var1) {
      BlockPos var2 = mc.player.blockPosition();
      return !var1.equals(var2) && !var1.equals(var2.above()) ? mc.player.getBoundingBox().intersects(new AABB(var1)) : true;
   }

   private boolean method08524(List<BlockTrapController.Nested324> var1, BlockPos var2, Player var3, boolean var4) {
      if (this.method08523(var2)) {
         return false;
      }

      if (!mc.level.getFluidState(var2).isEmpty()) {
         return false;
      }

      if (BlockPlacementTracker.method05650(var2)) {
         return false;
      }

      if (var4 && ExplosionDamageUtils.method04382(var2, var3.getBoundingBox())) {
         return false;
      }

      if (mc.level.getBlockState(var2).canBeReplaced()) {
         this.field19602++;
      }

      var1.add(new BlockTrapController.Nested324(var2, Items.COBWEB));
      return true;
   }

   private void method08525() {
      BlockTrapController.method11581(100);
      this.field19603 = 0;
      this.field19605 = null;
   }

   private boolean method08526(Player var1) {
      Vec3 var2 = mc.player.getEyePosition();
      Vec3 var3 = var1.getEyePosition();
      double var4 = var2.distanceTo(var3);
      if (var4 > field19614) {
         return false;
      }

      Vector2f var6 = PlayerUtils.method11816(var2, var3);
      return RaycastUtils.method09505(var6.x, var6.y, var4, var1, false);
   }

   private boolean method08527(BlockPos var1) {
      return mc.level.getBlockState(var1).is(Blocks.COBWEB);
   }

   public WebTrap() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field19599 = new ModeSetting(field19606).method05597(field19607, field19608).method03017(field19609).method03023(this);
      this.field19600 = new ToggleSetting(field19610).method03017(false).method03023(this);
      this.field19601 = new ToggleSetting(field19611).method03017(false).method03023(this);
      this.field19604 = -1;
      this.method03935(field19612);
   }

   @Override
   public void method00245() {
      BlockTrapController.method11581(100);
      this.field19603 = 0;
      this.field19604 = -1;
      this.field19605 = null;
      super.method00245();
   }
}
