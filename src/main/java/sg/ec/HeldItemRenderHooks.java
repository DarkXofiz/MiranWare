// Original binary: sg/ec/TbuZIBhe0rOJOTsw
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class HeldItemRenderHooks {
   public static float method05661(Minecraft var0, float var1) {
      return FreeLookController.method10130() && var0.getEntityRenderDispatcher().camera != null ? var0.getEntityRenderDispatcher().camera.yRot() : var1;
   }

   public static boolean method05662() {
      SeeInvisible var0 = ModuleManager.INSTANCE.method08189();
      return var0 != null && var0.method04538();
   }

   private HeldItemRenderHooks() {
   }

   public static float method05663() {
      SwingAnimations var0 = ModuleManager.INSTANCE.method08174();
      return var0 == null ? 1.0F : var0.method02738();
   }

   public static float method05664(Minecraft var0, float var1) {
      return FreeLookController.method10130() && var0.getEntityRenderDispatcher().camera != null ? var0.getEntityRenderDispatcher().camera.xRot() : var1;
   }

   public static ItemStack method05665(InteractionHand var0, Minecraft var1, ItemStack var2) {
      return var0 == InteractionHand.MAIN_HAND && var1.player != null ? HeldItemRenderEvent.field00682.method00316(var1.player, var2) : var2;
   }

   public static int method05666(int var0) {
      SeeInvisible var1 = ModuleManager.INSTANCE.method08189();
      return var1 == null ? var0 : var1.method04540(var0);
   }

   public static void method05667(ItemStack var0, ItemStack var1) {
      HandGlowRenderer.method01224(var0, var1);
   }
}
