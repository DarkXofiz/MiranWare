// Original binary: sg/ec/LaaLqQzE7bMMuap3
package sg.ec;

import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public interface EntityExtensionAccess {
   void setBotEntity(boolean var1);

   List<TrailPoint> getTrailPoints();

   Vec2 getVec2f();

   void setVec3d(Vec3 var1);

   boolean botEntity();

   Vec3 getVec3d();

   double getDistanceEyePos(Entity var1);

   void setVec2f(Vec2 var1);
}
