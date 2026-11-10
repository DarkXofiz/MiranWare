// Original binary: sg/mx/JHLZtfuCXvURKdZQ
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.FishingHookRenderer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ItemAnimationState;

// $VF: Compiled from s
@Mixin(FishingHookRenderer.class)
public abstract class FishingHookRendererMixin {
   private static final double field28007 = 960.0;
   private static final float field28008 = 0;

   @Inject(method = "getPlayerHandPos", at = @At("HEAD"), cancellable = true)
   private void hmi$handPos(Player var1, float var2, float var3, CallbackInfoReturnable<Vec3> var4) {
      Minecraft var5 = Minecraft.getInstance();
      if (var5.options.getCameraType().isFirstPerson() && var1 == var5.player) {
         float var6 = var5.options.fov().get().intValue();
         double var7 = field28007 / var6;
         int var9 = FishingHookRenderer.getHoldingArm(var1) == HumanoidArm.RIGHT ? 1 : -1;
         Matrix4f var10 = var9 == 1 ? ItemAnimationState.INSTANCE.field07844 : ItemAnimationState.INSTANCE.field07845;
         Vector4f var11 = new Vector4f(0.0F, 0.0F, 0.0F, 1.0F);
         var11.mul(var10);
         Vec3 var12 = new Vec3(var11.x(), var11.y(), var11.z()).scale(var7);
         Vec3 var13 = var5.gameRenderer.mainCamera().getNearPlane(var6).getPointOnPlane(var9 * 0.525F, -0.1F).scale(var7).add(var12);
         var4.setReturnValue(var5.gameRenderer.mainCamera().position().add(var13));
      }
   }

}
