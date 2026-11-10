// Original binary: sg/ec/JTkoRUKOtgFCmsla
package sg.ec;

import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import org.joml.Vector4fc;

// $VF: Compiled from s
public final class EntityMaskRenderHooks {
   private static final GuiGpuRenderer field08877 = new GuiGpuRenderer();

   public static void method04011() {
      field08877.method00366();
   }

   public static RenderPass method04012(
      CommandEncoder var0, Supplier<String> var1, GpuTextureView var2, Optional<Vector4fc> var3, GpuTextureView var4, OptionalDouble var5
   ) {
      return field08877.method00369(var0, var1, var2, var3, var4, var5);
   }

   private EntityMaskRenderHooks() {
   }

   public static void method04013(RenderPass var0) {
      field08877.method00370(var0);
   }

   public static void method04014() {
      field08877.method00367();
   }
}
