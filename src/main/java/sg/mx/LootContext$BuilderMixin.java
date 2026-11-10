// Original binary: sg/mx/CoZqc7THtqquvzpi
package sg.mx;

import hex.api.baritone.api.utils.BlockOptionalMeta;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ReloadableServerRegistries.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.loot.LootContext.Builder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// $VF: Compiled from s
@Mixin(Builder.class)
public abstract class LootContext$BuilderMixin {
   @Shadow
   public abstract ServerLevel getLevel();

   @Redirect(
      method = "create",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/server/MinecraftServer;reloadableRegistries()Lnet/minecraft/server/ReloadableServerRegistries$Holder;"
      )
   )
   private Holder hex$create(MinecraftServer var1) {
      if (var1 != null) {
         return var1.reloadableRegistries();
      } else {
         return this.getLevel() instanceof BlockOptionalMeta.ServerLevelStub var2 ? var2.holder() : null;
      }
   }
}
