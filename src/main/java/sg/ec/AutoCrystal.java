// Original binary: sg/ec/nJiPXc37aOt8UINI
package sg.ec;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import org.joml.Vector2f;

// $VF: Compiled from s
public class AutoCrystal extends ClientModule {
   private final ToggleSetting field21922;
   private final KeyBindSetting field21923;
   private final NumberSetting<Long> field21924;
   private final ToggleSetting field21925;
   private boolean field21926;
   private static final int field21927 = 6;
   private final ElapsedTimer field21928;
   private int field21929;
   private static final String field21930 = "Ставить обсидиан";
   private static final String field21931 = "Кнопка взрыва";
   private static final String field21932 = "Задержка";
   private static final long field21933 = 500L;
   private static final long field21934 = 10L;
   private static final long field21935 = 100L;
   private static final String field21936 = "Не взрывать ресурсы";
   private static final String field21937 = "Auto Crystal";
   private static final float field21938 = 3.0F;
   private static final double field21939 = 3.0;
   private static final float field21940 = 9999.0F;
   private static final double field21941 = 6.0;

   @Subscribe
   private void method09640(KeyInputEvent var1) {
      if (var1.method05887() == this.field21923.method03022().method05871()) {
         if (var1.method05884() == InputAction.PRESS) {
            this.field21926 = true;
         }

         if (var1.method05884() == InputAction.RELEASE) {
            this.field21926 = false;
            this.method09648();
         }
      }
   }

   public AutoCrystal() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field21922 = new ToggleSetting(field21930).method03017(false).method03023(this);
      this.field21923 = new KeyBindSetting(field21931).method03017(new KeyBinding()).method03023(this);
      this.field21924 = new NumberSetting<Long>(field21932)
         .method10835(0L)
         .method10838(field21933)
         .method10834(field21934)
         .method03017(field21935)
         .method03023(this);
      this.field21925 = new ToggleSetting(field21936).method03017(false).method03023(this);
      this.field21926 = false;
      this.field21928 = new ElapsedTimer();
      this.field21929 = -1;
      this.method03935(field21937);
   }

   private static double method09641(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16) {
      double var18 = Math.max(var6, Math.min(var0, var12));
      double var20 = Math.max(var8, Math.min(var2, var14));
      double var22 = Math.max(var10, Math.min(var4, var16));
      double var24 = var0 - var18;
      double var26 = var2 - var20;
      double var28 = var4 - var22;
      return Math.sqrt(var24 * var24 + var26 * var26 + var28 * var28);
   }

   private void method09642(Entity var1, float var2) {
      if (RaycastUtils.method09502(mc.player.getYRot(), mc.player.getXRot(), var2, var1)) {
         mc.gameMode.attack(mc.player, var1);
         mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
      } else {
         Vec3 var3 = mc.player.getEyePosition();
         Vector2f var4 = PlayerUtils.method11816(var3, ExplosionDamageUtils.method04404(var1, var3, var2));
         RotationManager.method06547(new Rotation(var4.x, var4.y), field21940, 2, false);
         if (RaycastUtils.method09502(mc.player.getYRot(), mc.player.getXRot(), var2, var1)) {
            mc.gameMode.attack(mc.player, var1);
            mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
         }
      }
   }

   @Subscribe
   private void method09643(PlayerUpdateEvent var1) {
      if (this.field21926) {
         if (mc.player != null && mc.level != null) {
            if (this.field21928.method04699(this.field21924.method03022())) {
               this.method09644();
               this.field21928.method04694();
            }
         }
      }
   }

   private void method09644() {
      Entity var1 = this.method09646();
      if (var1 != null) {
         if (!this.field21925.method05999() || !this.method09645(var1.position())) {
            this.method09642(var1, field21938);
         }
      } else {
         BlockHitResult var2 = RaycastUtils.method09511(Blocks.OBSIDIAN, Blocks.BEDROCK);
         if (this.field21922.method05999() && var2 == null) {
            int var3 = InventoryUtils.method06111(Items.OBSIDIAN, true);
            if (var3 == -1) {
               return;
            }

            if (this.field21929 == -1) {
               this.field21929 = mc.player.getInventory().getSelectedSlot();
               mc.player.getInventory().setSelectedSlot(var3);
            }

            if (mc.hitResult instanceof BlockHitResult var4
               && var4.getType() == Type.BLOCK
               && !mc.level.getBlockState(var4.getBlockPos()).isAir()
               && mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var4) == InteractionResult.SUCCESS) {
               RotationChangeTracker.method02903();
               mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
            }

            this.method09648();
         }

         if (var2 != null) {
            if (this.field21925.method05999() && this.method09645(Vec3.atCenterOf(var2.getBlockPos().above()))) {
               return;
            }

            int var6 = InventoryUtils.method06111(Items.END_CRYSTAL, true);
            if (var6 == -1) {
               return;
            }

            if (this.field21929 == -1) {
               this.field21929 = mc.player.getInventory().getSelectedSlot();
               mc.player.getInventory().setSelectedSlot(var6);
            }

            if (mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var2) == InteractionResult.SUCCESS) {
               RotationChangeTracker.method02903();
               mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
            }
         }
      }
   }

   private boolean method09645(Vec3 var1) {
      return WorldCollisionUtils.method02818(ItemEntity.class, var1, field21941);
   }

   private Entity method09646() {
      double var1 = field21939;

      for (Entity var4 : mc.level.entitiesForRendering()) {
         if (var4 instanceof EndCrystal var5) {
            AABB var6 = var5.getBoundingBox();
            Vec3 var7 = mc.player.getEyePosition();
            double var8 = method09641(var7.x, var7.y, var7.z, var6.minX, var6.minY, var6.minZ, var6.maxX, var6.maxY, var6.maxZ);
            if (var8 <= var1) {
               return var5;
            }
         }
      }

      return null;
   }

   @Subscribe
   private void method09647(MouseButtonEvent var1) {
      if (var1.method06914() == this.field21923.method03022().method05871()) {
         if (var1.method06919() == InputAction.PRESS) {
            this.field21926 = true;
         }

         if (var1.method06919() == InputAction.RELEASE) {
            this.field21926 = false;
            this.method09648();
         }
      }
   }

   private void method09648() {
      if (mc.player != null) {
         if (this.field21929 != -1) {
            mc.player.getInventory().setSelectedSlot(this.field21929);
            this.field21929 = -1;
         }
      }
   }
}
