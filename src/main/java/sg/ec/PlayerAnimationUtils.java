// Original binary: sg/ec/jv7CmePTV2XMaAtV
package sg.ec;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class PlayerAnimationUtils {
   public static boolean method09038(AbstractClientPlayer var0) {
      return var0.isAutoSpinAttack();
   }

   public static double method09039(AbstractClientPlayer var0) {
      return var0.getY();
   }

   public static int method09040(AbstractClientPlayer var0) {
      return var0.tickCount;
   }

   public static double method09041(AbstractClientPlayer var0) {
      return var0 instanceof PlayerAnimationAccess ? ((PlayerAnimationAccess)var0).hMI5_0$getSwingCount() : 0.0;
   }

   public static double method09042(AbstractClientPlayer var0) {
      return var0.getDeltaMovement().length();
   }

   public static double method09043(AbstractClientPlayer var0) {
      return var0.getZ();
   }

   public static double method09044(AbstractClientPlayer var0) {
      return var0.getDeltaMovement().y;
   }

   public static boolean method09045(ItemStack var0, AbstractClientPlayer var1) {
      return var1.getCooldowns().isOnCooldown(var0);
   }

   public static boolean method09046(AbstractClientPlayer var0) {
      return var0.isUsingItem();
   }

   public static InteractionHand method09047(AbstractClientPlayer var0) {
      return var0.getUsedItemHand();
   }

   public static boolean method09048(AbstractClientPlayer var0) {
      return var0.isSwimming();
   }

   public static boolean method09049(AbstractClientPlayer var0) {
      return var0.isScoping();
   }

   public static double method09050(AbstractClientPlayer var0) {
      return var0.getHealth();
   }

   public static double method09051(AbstractClientPlayer var0) {
      return var0.getYHeadRot();
   }

   public static boolean method09052(AbstractClientPlayer var0) {
      return var0.isShiftKeyDown();
   }

   public static double method09053(AbstractClientPlayer var0) {
      return var0.getXRot();
   }

   public static boolean method09054(AbstractClientPlayer var0) {
      return var0.isVisuallyCrawling();
   }

   public static ItemStack method09055(AbstractClientPlayer var0) {
      return var0.getOffhandItem();
   }

   public static ItemStack method09056(AbstractClientPlayer var0) {
      return var0.getMainHandItem();
   }

   public static boolean method09057(AbstractClientPlayer var0) {
      return var0.onGround();
   }

   public static double method09058(AbstractClientPlayer var0) {
      return var0.getDeltaMovement().x;
   }

   public static boolean method09059(AbstractClientPlayer var0) {
      return var0.isInWater();
   }

   public static boolean method09060(AbstractClientPlayer var0) {
      return var0.isUnderWater();
   }

   public static double method09061(AbstractClientPlayer var0) {
      return var0.getX();
   }

   public static boolean method09062(AbstractClientPlayer var0) {
      return var0.onClimbable();
   }

   public static double method09063(AbstractClientPlayer var0) {
      return var0.getDeltaMovement().z;
   }

   private PlayerAnimationUtils() {
   }
}
