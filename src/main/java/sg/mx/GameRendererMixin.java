// Original binary: sg/mx/6Aqu2W8HWHLbeUKS
package sg.mx;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(GameRenderer.class)
public interface GameRendererMixin {
   @Invoker("bobHurt")
   void tiltViewWhenHurtAccessor(CameraRenderState var1, PoseStack var2);

   @Invoker("bobView")
   void bobViewAccessor(CameraRenderState var1, PoseStack var2);
}
