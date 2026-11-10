// Original binary: sg/mx/es5DDiucX16VR6AZ
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.function.Function;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

// $VF: Compiled from s
@Mixin(SpriteId.class)
public class SpriteIdMixin {
   @Unique
   private Function<Identifier, RenderType> hex$source;
   @Unique
   private RenderType hex$renderType;

   @WrapMethod(method = "renderType")
   private RenderType hex$cachedRenderType(Function<Identifier, RenderType> var1, Operation<RenderType> var2) {
      if (this.hex$source == var1) {
         return this.hex$renderType;
      }

      RenderType var3 = (RenderType)var2.call(new Object[]{var1});
      this.hex$source = var1;
      this.hex$renderType = var3;
      return var3;
   }
}
