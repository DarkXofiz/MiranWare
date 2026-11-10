// Original binary: sg/mx/UbUI6YRypHaBg5Pm
package sg.mx;

import net.minecraft.server.packs.repository.PackRepository;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ScriptManager;
import sg.ec.RenderPipelineCache;

// $VF: Compiled from s
@Mixin(PackRepository.class)
public class PackRepositoryMixin {
   @Inject(method = "reload", at = @At("HEAD"))
   private void attachScriptPack(CallbackInfo var1) {
      ScriptManager.method01287((PackRepository)(Object)this);
      RenderPipelineCache.method10800();
   }
}
