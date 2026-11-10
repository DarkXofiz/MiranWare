// Original binary: sg/ec/mcNe8YQ155Q8EHJn
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class AutoAnchor extends ClientModule {
   private final NumberSetting<Float> field21572;
   private final NumberSetting<Float> field21573;
   private final NumberSetting<Float> field21574;
   private final NumberSetting<Float> field21575;
   private final NumberSetting<Float> field21576;
   private final ToggleSetting field21577;
   private final NumberSetting<Integer> field21578;
   private final ToggleSetting field21579;
   private final ToggleSetting field21580;
   private final ToggleSetting field21581;
   private final ToggleSetting field21582;
   private static final int field21583 = 96;
   private static final int field21584 = 0;
   private static final int field21585 = 0;
   private static final long field21586 = 0;
   private static final int field21587 = ColorUtils.method04604(45, 125, 255);
   private static final int field21588 = ColorUtils.method04604(255, 180, 40);
   private static final int field21589 = ColorUtils.method04604(255, 55, 55);
   private static final long field21590 = 0;
   private final ElapsedTimer field21591;
   private final HitResultConstraint field21592;
   private BlockPos field21593;
   private int field21594;
   private BlockPos field21595;
   private int field21596;
   private int field21597;
   private boolean field21598;
   private boolean field21599;
   private int field21600;
   private BlockPos field21601;
   private int field21602;
   private final List<AutoAnchor.Nested265> field21603;
   private static final String field21604 = "Радиус цели";
   private static final float field21605 = 4.0F;
   private static final float field21606 = 12.0F;
   private static final float field21607 = 0.5F;
   private static final float field21608 = 8.0F;
   private static final String field21609 = "Дальность установки";
   private static final float field21610 = 3.0F;
   private static final float field21611 = 6.0F;
   private static final float field21612 = 0.1F;
   private static final float field21613 = 4.5F;
   private static final String field21614 = "Мин. урон врагу";
   private static final float field21615 = 20.0F;
   private static final float field21616 = 0.5F;
   private static final float field21617 = 6.0F;
   private static final String field21618 = "Макс. урон себе";
   private static final float field21619 = 20.0F;
   private static final float field21620 = 0.5F;
   private static final float field21621 = 8.0F;
   private static final String field21622 = "Мин. % ХП цели";
   private static final float field21623 = 100.0F;
   private static final float field21624 = 5.0F;
   private static final float field21625 = 35.0F;
   private static final String field21626 = "Не тратить якорь, если урон меньше этой доли ХП цели. Добивание разрешено всегда";
   private static final String field21627 = "Только на добивание";
   private static final String field21628 = "Тратить якорь только если удар убивает цель";
   private static final String field21629 = "Задержка в тиках";
   private static final String field21630 = "Пинг 0-50: 0 | 50-100: 1-2 | 100-150: 2-3 | 150-200: 3-4 | 200+: 4-5";
   private static final String field21631 = "Авто установка";
   private static final String field21632 = "Анти-суицид";
   private static final String field21633 = "Обход Matrix";
   private static final String field21634 = "Визуализация";
   private static final String field21635 = "Auto Anchor";
   private static final long field21636 = 50L;
   private static final float field21637 = Float.MAX_VALUE;
   private static final float field21638 = -Float.MAX_VALUE;
   private static final float field21639 = -1.0F;
   private static final double field21640 = 10.0;
   private static final float field21641 = -Float.MAX_VALUE;
   private static final double field21642 = 2.0;
   private static final double field21643 = 2.0;
   private static final float field21644 = -1.0F;
   private static final double field21645 = 10.0;
   private static final float field21646 = -1.0F;
   private static final double field21647 = 10.0;
   private static final double field21648 = 3.0;
   private static final float field21649 = -1.0F;
   private static final double field21650 = 10.0;
   private static final float field21651 = -1.0F;
   private static final double field21652 = 10.0;
   private static final float field21653 = 100.0F;
   private static final float field21654 = 320.0F;
   private static final float field21655 = 0.5F;
   private static final float field21656 = 0.5F;
   private static final float field21657 = 210.0F;
   private static final double field21658 = 0.5;
   private static final double field21659 = 0.5;
   private static final double field21660 = 0.5;
   private static final double field21661 = 0.5;
   private static final float field21662 = 0.05F;

   private AABB method09513(BlockPos var1, float var2) {
      double var3 = var1.getX() + field21658;
      double sx = var1.getY() + field21659;
      double sxx = var1.getZ() + field21660;
      double sxxx = field21661 * Mth.clamp(var2, field21662, 1.0F);
      return new AABB(var3 - sxxx, sx - sxxx, sxx - sxxx, var3 + sxxx, sx + sxxx, sxx + sxxx);
   }

   private boolean method09514(BlockPos var1, int var2, int var3, boolean var4) {
      if (var2 == -1) {
         return false;
      }

      Vec3 var5 = ExplosionDamageUtils.method04412(var1, mc.player.getEyePosition());
      Vector2f var6 = PlayerUtils.method11816(mc.player.getEyePosition(), var5);
      if (this.field21581.method05999()) {
         BlockPlacementManager.method07910(var6);
      }

      if (!BlockActionQueue.method11512(this, var6)) {
         return false;
      }

      this.method09525(var1, var2, var3, false, var4);
      return true;
   }

   private float method09515(BlockPos var1) {
      return ExplosionDamageUtils.method04416(Vec3.atCenterOf(var1), mc.player, mc.player.getBoundingBox(), field21649, field21650);
   }

   private int method09516() {
      int var1 = mc.player.getInventory().getSelectedSlot();
      if (!mc.player.getInventory().getItem(var1).is(Items.GLOWSTONE)) {
         return var1;
      }

      for (int var2 = 0; var2 < 9; var2++) {
         if (!mc.player.getInventory().getItem(var2).is(Items.GLOWSTONE)) {
            return var2;
         }
      }

      return -1;
   }

   private boolean method09517() {
      return InventoryUtils.method06111(Items.GLOWSTONE, true) != -1;
   }

   @Subscribe
   private void method09518(Render3DEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (!this.field21582.method05999()) {
            this.field21603.clear();
         } else if (!this.field21603.isEmpty()) {
            PoseStack var2 = var1.method00996();
            Camera var3 = var1.method00994();
            Frustum var4 = var1.method00986();
            WorldVertexCollector var5 = var1.method00985();
            long var6 = System.currentTimeMillis();
            var var8 = this.field21603.iterator();

            while (var8.hasNext()) {
               AutoAnchor.Nested265 var9 = (AutoAnchor.Nested265)var8.next();
               float var10 = (float)(var6 - var9.field21665) / field21654;
               if (var10 >= 1.0F) {
                  var8.remove();
               } else {
                  float var11 = field21655 + field21656 * var10;
                  int var12 = (int)((1.0F - var10) * field21657);
                  WorldBoxRenderer.method06958(
                     this.method09513(var9.field21663, var11), var2, var3, var4, var5, ColorUtils.method04616(var9.field21664, var12)
                  );
               }
            }
         }
      }
   }

   private void method09519() {
      this.field21595 = null;
      this.field21596 = -1;
      this.field21597 = 0;
      this.field21598 = false;
      this.field21599 = false;
      this.field21600 = -100;
   }

   @Subscribe
   private void method09520(PostPlayerInputEvent var1) {
      if (this.field21595 != null) {
         BlockPos var2 = this.field21595;
         int var3 = this.field21596;
         int var4 = this.field21597;
         boolean var5 = this.field21598;
         boolean var6 = this.field21599;
         int var7 = this.field21600;
         this.method09519();
         if (mc.player != null && mc.level != null && mc.gameMode != null) {
            if (mc.player.tickCount == var7) {
               if (var5) {
                  this.method09524(var2);
               } else {
                  this.method09531(var2, var3, var4, var6);
               }
            }
         }
      }
   }

   private boolean method09521(BlockPos var1) {
      return this.method09514(var1, InventoryUtils.method06111(Items.GLOWSTONE, true), field21588, false);
   }

   private static float method09522(float var0, float var1, double var2) {
      return var0 - var1 * 2.0F - (float)(var2 * field21648);
   }

   private boolean method09523(Vec3 var1, float var2) {
      BlockState var3 = mc.level.getBlockState(this.field21593);
      boolean var4 = ExplosionDamageUtils.method04381(var1, this.field21593) <= this.field21573.method03022() * this.field21573.method03022();
      if (var3.is(Blocks.RESPAWN_ANCHOR) && var4 && mc.player.tickCount - this.field21594 <= 40) {
         int var5 = var3.getValue(RespawnAnchorBlock.CHARGE);
         if (var5 >= 1) {
            if (this.method09515(this.field21593) >= var2) {
               this.field21593 = null;
               return false;
            }

            boolean var6 = this.method09537(this.field21593);
            if (var6) {
               this.field21593 = null;
            }

            return var6;
         } else if (!this.method09517()) {
            this.field21593 = null;
            return false;
         } else {
            return this.method09521(this.field21593);
         }
      } else {
         this.field21593 = null;
         return false;
      }
   }

   private void method09524(BlockPos var1) {
      ExplosionDamageUtils.Nested134 var2 = ExplosionDamageUtils.method04420(var1, mc.player.getEyePosition(), this.field21573.method03022());
      if (var2 != null) {
         int var3 = InventoryUtils.method06111(Items.RESPAWN_ANCHOR, true);
         if (var3 != -1) {
            int var4 = mc.player.getInventory().getSelectedSlot();
            mc.player.getInventory().setSelectedSlot(var3);
            this.field21592.method02874(var2.neighbor());
            boolean var5 = false;

            try {
               double var6 = Math.min(mc.player.getEyePosition().distanceTo(var2.aim()) + 1.0, mc.player.blockInteractionRange());
               if (mc.player.pick(var6, 1.0F, false) instanceof BlockHitResult var9
                  && var9.getBlockPos().equals(var2.neighbor())
                  && var9.getBlockPos().relative(var9.getDirection()).equals(var1)
                  && mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var9) == InteractionResult.SUCCESS) {
                  mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
                  RotationChangeTracker.method02903();
                  if (this.field21581.method05999()) {
                     RotationManager.method06555();
                  }

                  var5 = true;
               }
            } finally {
               this.field21592.method02876();
               mc.player.getInventory().setSelectedSlot(var4);
            }

            if (var5 && this.field21582.method05999()) {
               this.field21603.add(new AutoAnchor.Nested265(var1, field21587, System.currentTimeMillis()));
            }
         }
      }
   }

   private void method09525(BlockPos var1, int var2, int var3, boolean var4, boolean var5) {
      this.field21595 = var1;
      this.field21596 = var2;
      this.field21597 = var3;
      this.field21598 = var4;
      this.field21599 = var5;
      this.field21600 = mc.player.tickCount;
   }

   private List<BlockPos> method09526(List<Player> var1, Vec3 var2, float var3) {
      ArrayList var4 = new ArrayList();
      LongOpenHashSet var5 = new LongOpenHashSet();
      double var6 = var3 * var3;

      for (Player var9 : var1) {
         BlockPos var10 = var9.blockPosition();

         for (int var11 = -4; var11 <= 4; var11++) {
            for (int var12 = -2; var12 <= 3; var12++) {
               for (int var13 = -4; var13 <= 4; var13++) {
                  BlockPos var14 = var10.offset(var11, var12, var13);
                  if (var5.add(var14.asLong())
                     && mc.level.getBlockState(var14).is(Blocks.RESPAWN_ANCHOR)
                     && !(ExplosionDamageUtils.method04381(var2, var14) > var6)) {
                     var4.add(var14);
                  }
               }
            }
         }
      }

      return var4;
   }

   private AutoAnchor.Nested266 method09527(List<BlockPos> var1, List<Player> var2, boolean var3, float var4) {
      AABB var5 = mc.player.getBoundingBox();
      AutoAnchor.Nested266 var6 = null;
      float var7 = field21638;

      for (BlockPos var9 : var1) {
         if (!var3 || !this.method09528(var9)) {
            BlockState var10 = mc.level.getBlockState(var9);
            int var11 = var10.getValue(RespawnAnchorBlock.CHARGE);
            if (var3 ? var11 >= 1 : var11 == 0) {
               Vec3 var12 = Vec3.atCenterOf(var9);
               float var13 = this.method09536(var12, var2);
               if (!(var13 <= 0.0F)) {
                  float var14 = ExplosionDamageUtils.method04416(var12, mc.player, var5, field21639, field21640);
                  if (!(var14 >= var4) && (!(var14 > this.field21575.method03022()) || !(var14 >= var13)) && var13 > var7) {
                     var7 = var13;
                     var6 = new AutoAnchor.Nested266(var9, var13, var14);
                  }
               }
            }
         }
      }

      return var6;
   }

   private boolean method09528(BlockPos var1) {
      return var1.equals(this.field21601) && mc.player.tickCount - this.field21602 < 10;
   }

   private boolean method09529(float var1, Player var2) {
      float var3 = var2.getHealth() + var2.getAbsorptionAmount();
      if (var1 >= var3) {
         return true;
      } else if (this.field21577.method05999()) {
         return false;
      } else {
         return var1 < this.field21574.method03022() ? false : var1 >= var3 * (this.field21576.method03022() / field21653);
      }
   }

   private boolean method09530(BlockPos var1) {
      ExplosionDamageUtils.Nested134 var2 = ExplosionDamageUtils.method04420(var1, mc.player.getEyePosition(), this.field21573.method03022());
      if (var2 == null) {
         return false;
      }

      int var3 = InventoryUtils.method06111(Items.RESPAWN_ANCHOR, true);
      if (var3 == -1) {
         return false;
      }

      Vector2f var4 = PlayerUtils.method11816(mc.player.getEyePosition(), var2.aim());
      if (this.field21581.method05999()) {
         BlockPlacementManager.method07910(var4);
      }

      if (!BlockActionQueue.method11512(this, var4)) {
         return false;
      }

      this.method09525(var1, var3, field21587, true, false);
      return true;
   }

   public AutoAnchor() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field21572 = new NumberSetting<Float>(field21604)
         .method10835(field21605)
         .method10838(field21606)
         .method10834(field21607)
         .method03017(field21608)
         .method03023(this);
      this.field21573 = new NumberSetting<Float>(field21609)
         .method10835(field21610)
         .method10838(field21611)
         .method10834(field21612)
         .method03017(field21613)
         .method03023(this);
      this.field21574 = new NumberSetting<Float>(field21614)
         .method10835(1.0F)
         .method10838(field21615)
         .method10834(field21616)
         .method03017(field21617)
         .method03023(this);
      this.field21575 = new NumberSetting<Float>(field21618)
         .method10835(0.0F)
         .method10838(field21619)
         .method10834(field21620)
         .method03017(field21621)
         .method03023(this);
      this.field21576 = new NumberSetting<Float>(field21622)
         .method10835(0.0F)
         .method10838(field21623)
         .method10834(field21624)
         .method03017(field21625)
         .method03018(field21626)
         .method03023(this);
      this.field21577 = new ToggleSetting(field21627).method03017(false).method03018(field21628).method03023(this);
      this.field21578 = new NumberSetting<Integer>(field21629)
         .method10835(0)
         .method10838(5)
         .method10834(1)
         .method03017(0)
         .method03018(field21630)
         .method03023(this);
      this.field21579 = new ToggleSetting(field21631).method03017(true).method03023(this);
      this.field21580 = new ToggleSetting(field21632).method03017(true).method03023(this);
      this.field21581 = new ToggleSetting(field21633).method03017(false).method03023(this);
      this.field21582 = new ToggleSetting(field21634).method03017(true).method03023(this);
      this.field21591 = new ElapsedTimer();
      this.field21592 = new HitResultConstraint();
      this.field21596 = -1;
      this.field21600 = -100;
      this.field21602 = -100;
      this.field21603 = new ArrayList<>();
      this.method03935(field21635);
   }

   private void method09531(BlockPos var1, int var2, int var3, boolean var4) {
      if (var2 != -1) {
         Vec3 var5 = Vec3.atCenterOf(var1);
         int var6 = mc.player.getInventory().getSelectedSlot();
         if (mc.player.getInventory().getSelectedSlot() != var2) {
            mc.player.getInventory().setSelectedSlot(var2);
         }

         this.field21592.method02874(var1);
         boolean var7 = false;

         try {
            double var8 = Math.min(mc.player.getEyePosition().distanceTo(var5) + 1.0, mc.player.blockInteractionRange());
            if (mc.player.pick(var8, 1.0F, false) instanceof BlockHitResult var11 && var11.getBlockPos().equals(var1)) {
               mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var11);
               mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
               RotationChangeTracker.method02903();
               if (this.field21581.method05999()) {
                  RotationManager.method06555();
               }

               var7 = true;
            }
         } finally {
            this.field21592.method02876();
            mc.player.getInventory().setSelectedSlot(var6);
         }

         if (var7) {
            if (var4) {
               this.field21601 = var1;
               this.field21602 = mc.player.tickCount;
            }

            if (this.field21582.method05999()) {
               this.field21603.add(new AutoAnchor.Nested265(var1, var3, System.currentTimeMillis()));
            }
         }
      }
   }

   private AutoAnchor.Nested266 method09532(List<Player> var1, Vec3 var2, float var3) {
      AABB var4 = mc.player.getBoundingBox();
      float var5 = this.field21573.method03022();
      AutoAnchor.Nested266 var6 = null;
      float var7 = field21641;
      int var8 = 0;
      boolean var9 = CrystalAura.method07430();

      for (Player var11 : var1) {
         AABB var12 = var11.getBoundingBox();
         Vec3 var13 = new Vec3((var12.minX + var12.maxX) / field21642, var12.minY, (var12.minZ + var12.maxZ) / field21643);
         BlockPos var14 = BlockPos.containing(var13.x, var13.y, var13.z);

         for (int var15 = -2; var15 <= 2; var15++) {
            for (int var16 = -2; var16 <= 2; var16++) {
               for (int var17 = -1; var17 <= 1; var17++) {
                  if (var8 >= 96) {
                     return var6;
                  }

                  BlockPos var18 = var14.offset(var15, var17, var16);
                  if (mc.level.getBlockState(var18).canBeReplaced()
                     && !BlockPlacementTracker.method05646(this, var18)
                     && (!var9 || !ExplosionDamageUtils.method04382(var18, var12))
                     && !this.method09534(var18)
                     && !(ExplosionDamageUtils.method04381(var2, var18) > var5 * var5)) {
                     Vec3 var19 = Vec3.atCenterOf(var18);
                     if (ExplosionDamageUtils.method04420(var18, var2, var5) != null) {
                        float var20 = ExplosionDamageUtils.method04416(var19, var11, var12, field21644, field21645);
                        if (this.method09529(var20, var11)) {
                           var8++;
                           float var21 = ExplosionDamageUtils.method04416(var19, mc.player, var4, field21646, field21647);
                           if (!(var21 >= var3) && (!(var21 > this.field21575.method03022()) || !(var21 >= var20))) {
                              double var22 = var19.distanceTo(var13);
                              float var24 = method09522(var20, var21, var22);
                              if (var24 > var7) {
                                 var7 = var24;
                                 var6 = new AutoAnchor.Nested266(var18, var20, var21);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var6;
   }

   @Override
   public void method00245() {
      this.field21593 = null;
      this.field21592.method02876();
      BlockActionQueue.method11514(this);
      this.field21603.clear();
      super.method00245();
   }

   @Subscribe
   private void method09533(PlayerUpdateEvent var1) {
      if (mc.player != null && mc.level != null && mc.gameMode != null && !mc.player.isSpectator()) {
         Vec3 var2 = mc.player.getEyePosition();
         var var3 = CombatTargetUtils.method03519(this.field21572.method03022());
         if (var3.isEmpty()) {
            this.field21593 = null;
         } else if (this.field21591.method04699(this.field21578.method03022().intValue() * field21636)) {
            float var4 = this.field21580.method05999() ? Math.max(0.0F, mc.player.getHealth() + mc.player.getAbsorptionAmount() - 1.0F) : field21637;
            if (this.field21593 != null) {
               BlockPlacementTracker.method05652();
               BlockPlacementTracker.method05649(this, this.field21593);
               if (this.method09523(var2, var4)) {
                  this.field21591.method04694();
               }
            } else {
               var var5 = this.method09526(var3, var2, this.field21573.method03022());

               for (int var6 = 0; var6 < var5.size(); var6++) {
                  BlockPlacementTracker.method05649(this, (BlockPos)var5.get(var6));
               }

               AutoAnchor.Nested266 var8 = this.method09527(var5, var3, true, var4);
               if (var8 != null) {
                  BlockPlacementTracker.method05652();
                  BlockPlacementTracker.method05649(this, var8.field21666);
                  if (this.method09537(var8.field21666)) {
                     this.field21591.method04694();
                  }
               } else {
                  if (this.method09517() && !this.method09539()) {
                     AutoAnchor.Nested266 var7 = this.method09527(var5, var3, false, var4);
                     if (var7 != null) {
                        BlockPlacementTracker.method05652();
                        BlockPlacementTracker.method05649(this, var7.field21666);
                        this.field21593 = var7.field21666;
                        this.field21594 = mc.player.tickCount;
                        if (this.method09523(var2, var4)) {
                           this.field21591.method04694();
                        }

                        return;
                     }
                  }

                  if (this.field21579.method05999() && this.method09538() && this.method09517() && !this.method09539()) {
                     AutoAnchor.Nested266 var9 = this.method09532(var3, var2, var4);
                     if (var9 != null) {
                        BlockPlacementTracker.method05652();
                        BlockPlacementTracker.method05649(this, var9.field21666);
                        if (this.method09530(var9.field21666)) {
                           this.field21593 = var9.field21666;
                           this.field21594 = mc.player.tickCount;
                           this.field21591.method04694();
                        }
                     }
                  }
               }
            }
         }
      } else {
         this.field21593 = null;
      }
   }

   private boolean method09534(BlockPos var1) {
      AABB var2 = new AABB(var1.getX(), var1.getY(), var1.getZ(), var1.getX() + 1.0, var1.getY() + 1.0, var1.getZ() + 1.0);
      return !mc.level.getEntitiesOfClass(Entity.class, var2, var0 -> var0.isAlive() && !var0.isSpectator()).isEmpty();
   }

   private float method09536(Vec3 var1, List<Player> var2) {
      float var3 = 0.0F;

      for (Player var5 : var2) {
         float var6 = ExplosionDamageUtils.method04416(var1, var5, var5.getBoundingBox(), field21651, field21652);
         if (var6 > var3 && this.method09529(var6, var5)) {
            var3 = var6;
         }
      }

      return var3;
   }

   private boolean method09537(BlockPos var1) {
      return this.method09514(var1, this.method09516(), field21589, true);
   }

   private boolean method09538() {
      return InventoryUtils.method06111(Items.RESPAWN_ANCHOR, true) != -1;
   }

   private boolean method09539() {
      return mc.player.tickCount - this.field21602 < 10;
   }

   public boolean method09540() {
      return this.field21581.method05999();
   }

   @Subscribe
   private void method09541(HitResultEvent var1) {
      this.field21592.method02875(var1);
   }

   // $VF: Compiled from s
   private static final class Nested265 {
      private final BlockPos field21663;
      private final int field21664;
      private final long field21665;

      private Nested265(BlockPos var1, int var2, long var3) {
         this.field21663 = var1;
         this.field21664 = var2;
         this.field21665 = var3;
      }
   }

   // $VF: Compiled from s
   private static final class Nested266 {
      private final BlockPos field21666;
      private final float field21667;
      private final float field21668;

      private Nested266(BlockPos var1, float var2, float var3) {
         this.field21666 = var1;
         this.field21667 = var2;
         this.field21668 = var3;
      }
   }
}
