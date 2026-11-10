// Original binary: sg/mx/EqvSK0Afrvq8cn0I
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.List;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.CollisionUtils;

// $VF: Compiled from s
@Mixin(Particle.class)
public class ParticleMixin_1154 {
   @WrapOperation(
      method = "move(DDD)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/entity/Entity;collideBoundingBox(Lnet/minecraft/world/phys/shapes/CollisionContext;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/AABB;Lnet/minecraft/world/level/Level;Ljava/util/List;)Lnet/minecraft/world/phys/Vec3;"
      )
   )
   private Vec3 hex$fastCollide(CollisionContext var1, Vec3 var2, AABB var3, Level var4, List<VoxelShape> var5, Operation<Vec3> var6) {
      return var5.isEmpty() && CollisionUtils.method02657(var4, var3, var2) ? var2 : (Vec3)var6.call(new Object[]{var1, var2, var3, var4, var5});
   }
}
