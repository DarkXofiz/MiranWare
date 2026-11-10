// Original binary: sg/mx/OPg3evrLKSphQDNs
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.function.Consumer;
import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.feature.phase.FeatureRenderPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

// $VF: Compiled from s
@Mixin(SubmitNodeStorage.class)
public class SubmitNodeStorageMixin {
   @Unique
   private SubmitNodeCollection hex$defaultOrder;

   @WrapMethod(method = "order(I)Lnet/minecraft/client/renderer/SubmitNodeCollection;")
   private SubmitNodeCollection hex$cachedOrder(int var1, Operation<SubmitNodeCollection> var2) {
      if (var1 != 0) {
         return (SubmitNodeCollection)var2.call(new Object[]{var1});
      }

      SubmitNodeCollection var3 = this.hex$defaultOrder;
      if (var3 == null) {
         var3 = (SubmitNodeCollection)var2.call(new Object[]{var1});
         this.hex$defaultOrder = var3;
      }

      return var3;
   }

   @WrapMethod(method = "drainPhases")
   private void hex$dropOrderCache(Consumer<FeatureRenderPhase<?>> var1, Operation<Void> var2) {
      var2.call(new Object[]{var1});
      this.hex$defaultOrder = null;
   }
}
