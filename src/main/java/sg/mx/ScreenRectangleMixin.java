// Original binary: sg/mx/QtuMxXMuhqYWlGwZ
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import org.joml.Matrix3x2fc;
import org.spongepowered.asm.mixin.Mixin;
import sg.ec.ScreenRectangleHooks;

// $VF: Compiled from s
@Mixin(ScreenRectangle.class)
public class ScreenRectangleMixin {
   @WrapMethod(method = "transformMaxBounds")
   private ScreenRectangle hex$transformMaxBounds(Matrix3x2fc var1, Operation<ScreenRectangle> var2) {
      return ScreenRectangleHooks.method07115((ScreenRectangle)(Object)this, var1);
   }
}
