// Original binary: sg/mx/BaV2slGCpZcLuFKz
package sg.mx;

import com.mojang.renderpearl.api.vertex.VertexFormat;
import com.mojang.renderpearl.api.vertex.VertexFormatElement;
import java.util.Map;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.VertexFormatHooks;

// $VF: Compiled from s
@Mixin(VertexFormat.class)
public abstract class VertexFormatMixin {
   @Mutable
   @Shadow
   @Final
   private Map<String, VertexFormatElement> elements;

   @Inject(method = "<init>", at = @At("TAIL"))
   private void hex$fasterElementLookup(CallbackInfo var1) {
      this.elements = VertexFormatHooks.method11304(this.elements);
   }
}
