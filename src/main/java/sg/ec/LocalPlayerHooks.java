// Original binary: sg/ec/fbvVxBtY7SVd2QdX
package sg.ec;

import net.minecraft.client.Minecraft;

// $VF: Compiled from s
public final class LocalPlayerHooks {
   public static float method08275(Minecraft var0, float var1) {
      return FreeLookController.method10130() ? var0.gameRenderer.mainCamera().yRot() : var1;
   }

   public static float method08276(Minecraft var0, float var1) {
      return FreeLookController.method10130() ? var0.gameRenderer.mainCamera().xRot() : var1;
   }

   private LocalPlayerHooks() {
   }
}
