// Original binary: sg/mx/Ic0YXheWDWJZBer0
package sg.mx;

import java.util.List;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(LocalPlayer.class)
public interface LocalPlayerMixin_1170 {
   @Accessor("wasSprinting")
   boolean wasSprinting();

   @Accessor("wasSprinting")
   void setWasSprinting(boolean var1);

   @Accessor("xLast")
   double lastX();

   @Accessor("yLast")
   double lastY();

   @Accessor("zLast")
   double lastZ();

   @Accessor("yRotLast")
   float lastYRot();

   @Accessor("xRotLast")
   float lastXRot();

   @Accessor("lastOnGround")
   boolean lastOnGround();

   @Accessor("lastHorizontalCollision")
   boolean lastHorizontalCollision();

   @Accessor("positionReminder")
   int positionReminder();

   @Accessor("ambientSoundHandlers")
   List<?> ambientSoundHandlers();

   @Accessor("xLast")
   void setLastX(double var1);

   @Accessor("yLast")
   void setLastY(double var1);

   @Accessor("zLast")
   void setLastZ(double var1);

   @Accessor("yRotLast")
   void setLastYRot(float var1);

   @Accessor("xRotLast")
   void setLastXRot(float var1);

   @Accessor("lastOnGround")
   void setLastOnGround(boolean var1);

   @Accessor("lastHorizontalCollision")
   void setLastHorizontalCollision(boolean var1);

   @Accessor("positionReminder")
   void setPositionReminder(int var1);
}
