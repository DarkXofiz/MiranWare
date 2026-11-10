// Original binary: sg/ec/CfqKWZ9rNP1TWLR1
package sg.ec;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class MoveRelativeEvent extends Event {
   public static final MoveRelativeEvent field06827 = new MoveRelativeEvent();
   private Entity field06828;
   private float field06829;
   private Vec3 field06830;

   public float method03001() {
      return this.field06829;
   }

   public void method03002(Vec3 var1) {
      this.field06830 = var1;
   }

   public Entity method03003() {
      return this.field06828;
   }

   public Vec3 method03004() {
      return this.field06830;
   }

   public void method03005(Entity var1, float var2, Vec3 var3) {
      this.field06828 = var1;
      this.field06829 = var2;
      this.field06830 = var3;
      super.method03208();
   }

   public void method03006(Entity var1) {
      this.field06828 = var1;
   }

   public void method03007(float var1) {
      this.field06829 = var1;
   }
}
