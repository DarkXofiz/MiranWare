// Original binary: sg/mx/huFY3jvz4Y0vKfrG
package sg.mx;

import net.minecraft.client.renderer.culling.Frustum;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(Frustum.class)
public interface FrustumMixin_1266 {
   @Accessor("matrix")
   Matrix4f getMatrix();

   @Invoker("cubeInFrustum")
   int hexCubeInFrustum(double var1, double var3, double var5, double var7, double var9, double var11);
}
