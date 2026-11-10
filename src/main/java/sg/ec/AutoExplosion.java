// Original binary: sg/ec/Ftd8mrQlpEIadgv2
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class AutoExplosion extends ClientModule {
   private final ToggleSetting field07712;
   private final ToggleSetting field07713;
   private static final int field07714 = 6;
   private static final int field07715 = 0;
   private static final int field07716 = 0;
   private static final float field07717 = 0;
   private static final float field07718 = 0;
   private BlockPos field07719;
   private boolean field07720;
   private int field07721;
   private int field07722;
   private int field07723;
   private final HitResultConstraint field07724;
   private static final String field07725 = "Не взрывать ресурсы";
   private static final String field07726 = "Обход Matrix";
   private static final String field07727 = "Auto Explosion";
   private static final float field07728 = 3.0F;
   private static final double field07729 = 3.0;
   private static final float field07730 = 999.0F;
   private static final double field07731 = 3.0;
   private static final double field07732 = 0.5;
   private static final float field07733 = 999.0F;
   private static final double field07734 = 3.0;
   private static final double field07735 = 4.5;
   private static final float field07736 = 999.0F;
   private static final double field07737 = 3.0;

   public boolean method03460() {
      return this.field07713.method05999();
   }

   @Subscribe
   private void method03461(BlockPlaceEvent var1) {
      if (this.field07719 == null) {
         if (mc.player != null && mc.level != null) {
            BlockPlaceContext var2 = var1.method10967();
            if (var2.getPlayer() instanceof LocalPlayer) {
               BlockPos var3 = var2.getClickedPos();
               if (BlockPlacementTracker.method05650(var3)) {
                  return;
               }

               if (mc.level.getBlockState(var3).getBlock() == Blocks.OBSIDIAN) {
                  this.field07719 = var3;
                  this.field07720 = false;
                  this.field07723 = mc.player.tickCount;
               }
            }
         }
      }
   }

   private boolean method03462(Vec3 var1) {
      return WorldCollisionUtils.method02818(ItemEntity.class, var1, field07737);
   }

   private BlockHitResult method03463(boolean var1) {
      if (!var1) {
         BlockHitResult var9 = RaycastUtils.method09511(Blocks.OBSIDIAN);
         return var9 != null && var9.getBlockPos().equals(this.field07719) ? var9 : null;
      }

      this.field07724.method02874(this.field07719);

      try {
         double var2 = mc.player.getEyePosition().distanceTo(Vec3.atCenterOf(this.field07719)) + 1.0;
         return mc.player.pick(var2, 1.0F, false) instanceof BlockHitResult var5 && var5.getBlockPos().equals(this.field07719) ? var5 : null;
      } finally {
         this.field07724.method02876();
      }
   }

   @Override
   public void method00382() {
      this.method03466();
      super.method00382();
   }

   @Subscribe
   private void method03464(HitResultEvent var1) {
      this.field07724.method02875(var1);
   }

   @Subscribe
   private void method03465(WorldLoadEvent var1) {
      this.method03466();
   }

   private void method03466() {
      if (this.field07721 != -1 && mc.player != null) {
         mc.player.getInventory().setSelectedSlot(this.field07721);
      }

      this.field07719 = null;
      this.field07720 = false;
      this.field07721 = -1;
      this.field07722 = -1;
      this.field07723 = -1;
   }

   public AutoExplosion() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field07712 = new ToggleSetting(field07725).method03017(false).method03023(this);
      this.field07713 = new ToggleSetting(field07726).method03017(false).method03023(this);
      this.field07719 = null;
      this.field07720 = false;
      this.field07721 = -1;
      this.field07722 = -1;
      this.field07723 = -1;
      this.field07724 = new HitResultConstraint();
      this.method03935(field07727);
   }

   @Subscribe
   private void method03467(PlayerUpdateEvent var1) {
      if (this.field07719 != null && mc.player != null && mc.level != null && mc.gameMode != null) {
         boolean var2 = this.field07713.method05999();
         int var3 = var2 ? 14 : 6;
         if (mc.player.tickCount - this.field07723 > var3) {
            this.method03466();
         } else {
            BlockPos var4 = this.field07719.above();

            for (Entity var6 : mc.level.entitiesForRendering()) {
               if (var6 instanceof EndCrystal && var6.blockPosition().equals(var4)) {
                  if (this.field07712.method05999() && this.method03462(var6.position())) {
                     return;
                  }

                  if (var2) {
                     RotationManager.method06555();
                     Vec3 var11 = ExplosionDamageUtils.method04371(var6, mc.player.getEyePosition(), field07728, true);
                     if (var11 == null) {
                        return;
                     }

                     Vector2f var14 = BlockPlacementManager.method07908(var6, var11, field07729);
                     if (var14 == null) {
                        return;
                     }

                     RotationManager.method06547(new Rotation(var14.x, var14.y), field07730, 1000, false);
                     if (BlockPlacementManager.method07909(var6, field07731)) {
                        mc.gameMode.attack(mc.player, var6);
                        mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
                        this.method03466();
                     }

                     return;
                  }

                  Vec3 var7 = Vec3.atCenterOf(var4).add(0.0, field07732, 0.0);
                  Rotation var8 = Rotation.method09438(var7.subtract(mc.player.getEyePosition()));
                  RotationManager.method06547(var8, field07733, 1000, false);
                  if (RaycastUtils.method09502(mc.player.getYRot(), mc.player.getXRot(), field07734, var6)) {
                     mc.gameMode.attack(mc.player, var6);
                     mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
                     this.method03466();
                  }

                  return;
               }
            }

            if (this.field07720) {
               if (var2) {
                  RotationManager.method06555();
               }
            } else {
               int var9 = InventoryUtils.method06111(Items.END_CRYSTAL, true);
               if (var9 == -1 || mc.level.getBlockState(this.field07719).getBlock() != Blocks.OBSIDIAN) {
                  this.method03466();
               } else if (!this.field07712.method05999() || !this.method03462(Vec3.atCenterOf(var4))) {
                  Rotation var10;
                  if (var2) {
                     RotationManager.method06555();
                     Vector2f var12 = BlockPlacementManager.method07903(this.field07719, field07735, true);
                     if (var12 == null) {
                        return;
                     }

                     var10 = new Rotation(var12.x, var12.y);
                  } else {
                     var10 = Rotation.method09438(Vec3.atCenterOf(this.field07719).subtract(mc.player.getEyePosition()));
                  }

                  RotationManager.method06547(var10, field07736, 1000, false);
                  if (this.field07721 == -1) {
                     this.field07721 = mc.player.getInventory().getSelectedSlot();
                     mc.player.getInventory().setSelectedSlot(var9);
                     this.field07722 = mc.player.tickCount;
                  } else if (mc.player.tickCount > this.field07722) {
                     BlockHitResult var13 = this.method03463(var2);
                     if (var13 != null) {
                        if (mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var13) == InteractionResult.SUCCESS) {
                           RotationChangeTracker.method02903();
                           mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
                           this.field07720 = true;
                        }
                     }
                  }
               }
            }
         }
      } else {
         this.method03466();
      }
   }
}
