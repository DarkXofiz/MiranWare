// Original binary: sg/ec/Qqgb5ebhKfy5Ok5T
package sg.ec;

import net.minecraft.world.entity.item.ItemEntity;

// $VF: Compiled from s
public interface ItemEntityPhysicsAccess {
   boolean isBlock();

   float getYRot();

   void extractPhysic(ItemEntity var1);

   boolean skipRendering();

   float getXRot();

   boolean hasAdditionalOffset();
}
