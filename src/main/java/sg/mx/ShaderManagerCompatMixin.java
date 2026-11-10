package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.renderpearl.api.pipeline.ShaderType;
import net.minecraft.client.renderer.ShaderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.ShaderCompat;

@Mixin(ShaderManager.class)
public abstract class ShaderManagerCompatMixin {
   @ModifyExpressionValue(
      method = "loadShader",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/resources/Resource;readAllAsString()Ljava/lang/String;")
   )
   private static String hex$upgradeShader(String var0, @Local(argsOnly = true) ShaderType var1) {
      return ShaderCompat.upgrade(var0, var1 == ShaderType.VERTEX, false);
   }

   @ModifyExpressionValue(
      method = {"loadInclude", "lambda$listAllIncludes$0"},
      at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/resources/Resource;readAllAsString()Ljava/lang/String;"),
      require = 0
   )
   private static String hex$upgradeInclude(String var0) {
      return ShaderCompat.upgrade(var0, false, true);
   }

   @com.llamalad7.mixinextras.injector.ModifyReturnValue(method = "loadConfigs", at = @At("RETURN"))
   private static ShaderManager.Configs hex$matchVaryings(ShaderManager.Configs var0) {
      java.util.Map<ShaderManager.ShaderSourceKey, String> var1 = new java.util.HashMap<>(var0.shaderSources());
      java.util.Map<net.minecraft.resources.Identifier, String> var2 = new java.util.HashMap<>();
      var1.forEach((k, v) -> {
         if (k.type() == ShaderType.VERTEX) {
            var2.put(k.id(), v);
         }
      });
      boolean[] var3 = new boolean[1];
      var1.replaceAll((k, v) -> {
         if (k.type() != ShaderType.FRAGMENT) {
            return v;
         }
         String var4 = var2.get(k.id());
         if (var4 == null) {
            return v;
         }
         String var5 = ShaderCompat.matchFragmentInputs(var4, v);
         if (!var5.equals(v)) {
            var3[0] = true;
         }
         return var5;
      });
      return var3[0] ? new ShaderManager.Configs(com.google.common.collect.ImmutableMap.copyOf(var1), var0.includeSources(), var0.postChains()) : var0;
   }
}
