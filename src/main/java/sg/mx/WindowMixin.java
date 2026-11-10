// Original binary: sg/mx/CrfjR7PTDstiywcx
package sg.mx;

import com.mojang.blaze3d.platform.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(Window.class)
public interface WindowMixin {
   @Invoker("onFramebufferResize")
   void hexOnFramebufferResize(int var1, int var2);
}
