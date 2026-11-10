// Original binary: sg/ec/es57qABlbYPM4vlw
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $VF: Compiled from s
public class NoSlow extends ClientModule {
   private static final Logger field18715 = LoggerFactory.getLogger(NoSlow.field18775);
   private static final byte field18716 = 2;
   private static final byte field18717 = 0;
   private static final int field18718 = 0;
   private static final double field18719 = 0;
   private static final double field18720 = 0;
   private static final float field18721 = 0;
   private final ModeSetting field18722;
   private int field18723;
   private int field18724;
   private double field18725;
   private double field18726;
   private double field18727;
   private double field18728;
   private boolean field18729;
   private boolean field18730;
   private static final String field18731 = "Режим";
   private static final String field18732 = "ReallyWorld";
   private static final String field18733 = "Vanilla";
   private static final String field18734 = "Grim Last";
   private static final String field18735 = "Grim Old";
   private static final String field18736 = "Matrix + Grim";
   private static final String field18737 = "Funtime Crossbow";
   private static final String field18738 = "ReallyWorld";
   private static final double field18739 = 0.14;
   private static final String field18740 = "No Slow";
   private static final String field18741 = "Funtime Crossbow";
   private static final String field18742 = "ReallyWorld";
   private static final String field18743 = "Vanilla";
   private static final String field18744 = "Funtime Crossbow";
   private static final String field18745 = "Grim Last";
   private static final String field18746 = "Grim Old";
   private static final String field18747 = "Matrix + Grim";
   private static final float field18748 = 0.2F;
   private static final String field18749 = "swim-diag";
   private static final float field18750 = 0.2F;
   private static final String field18751 = "warmup";
   private static final float field18752 = 0.2F;
   private static final String field18753 = "burst";
   private static final String field18754 = "slow";
   private static final float field18755 = 0.2F;
   private static final float field18756 = 0.6F;
   private static final float field18757 = 0.6F;
   private static final double field18758 = 0.5;
   private static final double field18759 = 0.14;
   private static final double field18760 = 1.3;
   private static final double field18761 = 0.91;
   private static final double field18762 = 0.91;
   private static final double field18763 = 0.16277136;
   private static final double field18764 = 1.05;
   private static final double field18765 = 0.005;
   private static final double field18766 = 1.05;
   private static final double field18767 = 0.8;
   private static final double field18768 = 0.055;
   private static final float field18769 = Float.MAX_VALUE;
   private static final float field18770 = Float.MAX_VALUE;
   private static final float field18771 = Float.MAX_VALUE;
   private static final float field18772 = Float.MAX_VALUE;
   private static final float field18773 = 0.2F;
   private static final String field18774 = "ReallyWorld";
   private static final String field18775 = "MiranWare";

   private void method07876(ItemUseSlowdownEvent var1) {
      if (mc.player != null) {
         if (MovementUtils.method05733() && mc.player.isUsingItem()) {
            if (!this.field18730) {
               InventoryUtils.method06142(mc.player.getUsedItemHand(), field18769, field18770, false);
               InventoryUtils.method06142(
                  mc.player.getUsedItemHand() == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND,
                  field18771,
                  field18772,
                  false
               );
               var1.method05695(true);
               return;
            }

            if (method07886(this.field18723, mc.player.tickCount, 2, 2)) {
               var1.method05695(true);
            }
         }
      }
   }

   private void method07877(ItemUseSlowdownEvent var1) {
      if (mc.player != null) {
         if (method07886(this.field18723, mc.player.tickCount, 2, 2)) {
            var1.method05695(true);
         }
      }
   }

   private double method07878() {
      if (mc.player == null) {
         return field18759;
      }

      double var1 = mc.player.getAttributeValue(Attributes.MOVEMENT_SPEED);
      double var3 = mc.player.isSprinting() ? var1 : var1 * field18760;
      double var5 = mc.player.onGround() ? this.method07881() * field18761 : field18762;
      double var7 = var3 * (field18763 / (var5 * var5 * var5));
      double var9 = var7 * field18764 + field18765;
      var9 *= mc.player.zza > 0.0F ? field18766 : field18767;
      if (!mc.player.onGround()) {
         var9 += field18768;
      }

      return var9;
   }

   private void method07879(ItemUseSlowdownEvent var1) {
      if (mc.player != null) {
         if (mc.player.getMainHandItem().getItem() == Items.CROSSBOW) {
            var1.method05695(true);
         }
      }
   }

   @Subscribe
   private void method07880(PlayerUpdateEvent var1) {
      if (mc.player != null) {
         boolean var2 = mc.player.isUsingItem();
         double var3 = Math.hypot(mc.player.getX() - this.field18727, mc.player.getZ() - this.field18728);
         this.field18727 = mc.player.getX();
         this.field18728 = mc.player.getZ();
         this.field18726 = this.method07878();
         if (var2 && this.field18722.method05600(field18774)) {
            if (mc.player.onGround() && var3 > this.field18726) {
               this.field18724 = Math.min(this.field18724 + 2, 24);
            } else if (this.field18724 > 0) {
               this.field18724--;
            }
         } else if (this.field18724 > 0) {
            this.field18724--;
         }

         this.field18725 = var3;
         if (!mc.player.isFallFlying()) {
            ItemStack var5 = mc.player.getMainHandItem();
            this.field18730 = var5.getItem() != Items.BOW;
            if (var2) {
               this.field18723++;
            } else {
               this.field18723 = 0;
               this.field18729 = false;
            }
         }
      }
   }

   private float method07881() {
      if (mc.level == null) {
         return field18757;
      }

      BlockPos var1 = BlockPos.containing(mc.player.getX(), mc.player.getY() - field18758, mc.player.getZ());
      return mc.level.getBlockState(var1).getBlock().getFriction();
   }

   private boolean method07882() {
      return this.method07881() > field18756;
   }

   private void method07883(ItemUseSlowdownEvent var1) {
      if (mc.player != null && mc.player.isUsingItem()) {
         if (mc.player.isSwimming() && MovementUtils.method05730()) {
            var1.method08336(field18748);
            var1.method05695(true);
            this.field18729 = false;
         } else if (this.field18723 <= 1) {
            this.field18729 = false;
         } else {
            boolean var2 = mc.player.onGround() && mc.player.zza > 0.0F && !this.field18729 && this.field18724 <= 2 && this.field18725 <= this.field18726;
            if (var2) {
               var1.method08336(1.0F);
               var1.method05695(true);
               this.field18729 = true;
               float var10002 = 1.0F;
            } else {
               this.field18729 = false;
            }
         }
      }
   }

   private void method07884(ItemUseSlowdownEvent var1) {
      if (mc.player != null) {
         boolean var2 = mc.player.isSwimming();
         if (var2 && mc.player.isUsingItem() && MovementUtils.method05730()) {
            var1.method08336(field18773);
            var1.method05695(true);
         } else {
            if (method07886(this.field18723, mc.player.tickCount, 3, 3)) {
               var1.method05695(true);
            }
         }
      }
   }

   @Subscribe
   private void method07885(ItemUseSlowdownEvent var1) {
      boolean var2 = mc.player.hasEffect(MobEffects.BLINDNESS) || !mc.player.getFoodData().hasEnoughFood() || mc.player.isFallFlying();
      if (!this.field18722.method05600(field18741) && mc.player.isUsingItem() && !ModuleManager.INSTANCE.method08219().method00383()) {
         boolean var3 = mc.player.input.hasForwardImpulse();
         if (mc.player.isSprinting() != var3) {
            mc.player.setSprinting(var3 && !var2);
         }
      }

      switch ((String)this.field18722.method03022()) {
         case field18742:
            this.method07883(var1);
            break;
         case field18743:
            var1.method05695(true);
            break;
         case field18744:
            this.method07879(var1);
            break;
         case field18745:
            this.method07877(var1);
            break;
         case field18746:
            this.method07876(var1);
            break;
         case field18747:
            this.method07884(var1);
      }
   }

   public NoSlow() {
      super(ModuleCategory.Movement, ModuleSubCategory.Other);
      this.field18722 = new ModeSetting(field18731)
         .method05597(field18732, field18733, field18734, field18735, field18736, field18737)
         .method03017(field18738)
         .method03023(this);
      this.field18723 = 0;
      this.field18724 = 0;
      this.field18725 = 0.0;
      this.field18726 = field18739;
      this.field18729 = false;
      Object var10001 = null;
      this.method03935(field18740);
   }

   private static boolean method07886(int var0, int var1, int var2, int var3) {
      return var0 > var3 && var1 % var2 == 0;
   }
}
