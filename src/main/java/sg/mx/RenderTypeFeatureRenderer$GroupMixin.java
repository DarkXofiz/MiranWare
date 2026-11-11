// Original binary: sg/mx/AxaVeJW8dincnIoo
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.List;
import net.minecraft.client.renderer.rendertype.PreparedRenderType;
import net.minecraft.client.renderer.rendertype.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.RenderTypeFeatureRendererGroupHooks;

// $VF: Compiled from s
@Mixin(targets = "net.minecraft.client.renderer.feature.RenderTypeFeatureRenderer$Group")
public class RenderTypeFeatureRenderer$GroupMixin {
   @Unique
   private RenderTypeFeatureRendererGroupHooks hex$cache;

   @Unique
   private RenderTypeFeatureRendererGroupHooks hex$cache() {
      RenderTypeFeatureRendererGroupHooks var1 = this.hex$cache;
      if (var1 == null) {
         var1 = new RenderTypeFeatureRendererGroupHooks();
         this.hex$cache = var1;
      }

      return var1;
   }

   @WrapOperation(
      method = "getOrAddDraw",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/rendertype/RenderType;prepare()Lnet/minecraft/client/renderer/rendertype/PreparedRenderType;"
      )
   )
   private PreparedRenderType hex$cachedPrepare(RenderType var1, Operation<PreparedRenderType> hex$original) {
      return this.hex$cache().method11615(var1);
   }

   @WrapOperation(method = "getOrAddDraw", at = @At(value = "INVOKE", target = "Ljava/util/List;indexOf(Ljava/lang/Object;)I"))
   private int hex$cachedIndex(List<?> var1, Object var2, Operation<Integer> hex$original) {
      return this.hex$cache().method11616(var1, var2);
   }
}
