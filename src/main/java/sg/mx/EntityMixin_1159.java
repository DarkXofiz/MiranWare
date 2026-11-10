// Original binary: sg/mx/Fmo8yLILp0ljJ2hf
package sg.mx;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(Entity.class)
public interface EntityMixin_1159 {
   @Accessor("yRot")
   void IsetYaw(float var1);

   @Accessor("xRot")
   void IsetPitch(float var1);

   @Accessor("yRotO")
   float getPrevYaw_();

   @Accessor("xRotO")
   float getPrevPitch_();

   @Accessor("dimensions")
   EntityDimensions getDimensions_();

   @Accessor("stuckSpeedMultiplier")
   Vec3 getStuckSpeedMultiplier();

   @Invoker("setSharedFlag")
   void IsetFlag(int var1, boolean var2);
}
