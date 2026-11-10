// Original binary: hex/api/baritone/api/event/events/RotationMoveEvent
package hex.api.baritone.api.event.events;

import hex.api.baritone.api.utils.Rotation;

// $VF: Compiled from s
public final class RotationMoveEvent {
   private final RotationMoveEvent.Type type;
   private final Rotation original;
   private float yaw;
   private float pitch;

   public RotationMoveEvent(RotationMoveEvent.Type var1, float var2, float var3) {
      this.type = var1;
      this.original = new Rotation(var2, var3);
      this.yaw = var2;
      this.pitch = var3;
   }

   public Rotation getOriginal() {
      return this.original;
   }

   public void setYaw(float var1) {
      this.yaw = var1;
   }

   public void setPitch(float var1) {
      this.pitch = var1;
   }

   public RotationMoveEvent.Type getType() {
      return this.type;
   }

   public float getPitch() {
      return this.pitch;
   }

   public float getYaw() {
      return this.yaw;
   }

   // $VF: Compiled from s
   public enum Type {
      MOTION_UPDATE,
      JUMP;
   }
}
