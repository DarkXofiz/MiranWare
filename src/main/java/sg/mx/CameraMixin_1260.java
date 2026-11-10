// Original binary: sg/mx/gbL4LIuKz71jAK7l
package sg.mx;

import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(Camera.class)
public interface CameraMixin_1260 {
   @Invoker("setRotation")
   void IsetRotation(float var1, float var2);

   @Invoker("setPosition")
   void setPositionAccessor(double var1, double var3, double var5);
}
