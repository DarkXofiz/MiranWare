// Original binary: sg/mx/gc8Vazu4KudsLYi8
package sg.mx;

import com.mojang.datafixers.util.Either;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.waypoints.ClientWaypointManager;
import net.minecraft.world.waypoints.TrackedWaypoint;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
@Mixin(ClientWaypointManager.class)
public abstract class ClientWaypointManagerMixin {
   @Shadow
   @Final
   private Map<Either<UUID, String>, TrackedWaypoint> waypoints;

   @Inject(method = "updateWaypoint(Lnet/minecraft/world/waypoints/TrackedWaypoint;)V", at = @At("HEAD"), cancellable = true)
   private void trackMissingWaypoint(TrackedWaypoint var1, CallbackInfo var2) {
      if (this.waypoints.putIfAbsent(var1.id(), var1) == null) {
         var2.cancel();
      }
   }
}
