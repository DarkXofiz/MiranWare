// Original binary: sg/mx/P8Spaooydgs2tKBU
package sg.mx;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.function.Consumer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityTickList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.EntityTickListHooks;

// $VF: Compiled from s
@Mixin(EntityTickList.class)
public class EntityTickListMixin {
   @Shadow
   private Int2ObjectMap<Entity> active;

   @Inject(method = "forEach", at = @At("HEAD"))
   private void reorderLocalPlayerLast(Consumer<Entity> var1, CallbackInfo var2) {
      EntityTickListHooks.method10963(this.active);
   }
}
