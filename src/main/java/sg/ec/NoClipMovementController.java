// Original binary: sg/ec/XeCo2QZuMlR3Z7QR
package sg.ec;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public enum NoClipMovementController implements MinecraftAccess {
   INSTANCE;

   private static final int field14648 = 3;
   private static final double field14649 = 0;
   private static final double field14650 = 0;
   private static final double field14651 = 0;
   private static final double field14652 = 0;
   private static final double field14653 = 0;
   private static final double field14654 = 0;
   private static final Vec3 field14655 = new Vec3(0.0, 1.0, 0.0);
   private int field14656;

   public void method06467(PlayerInputEvent var1, Rotation var2) {
      this.method06469(var1, var2, Double.MAX_VALUE);
   }

   public void method06468(PlayerInputEvent var1, Vec3 var2) {
      Vec3 var3 = mc.player.position();
      double var4 = var3.distanceTo(var2);
      if (var4 < 0.001) {
         var1.method11159();
      } else {
         Vector2f var6 = PlayerUtils.method11816(var3, var2);
         this.method06469(var1, new Rotation(var6.x, var6.y), var4);
      }
   }

   private void method06469(PlayerInputEvent var1, Rotation var2, double var3) {
      var1.method11159();
      float var5 = var2.method09439() + (this.field14656 % 2 <= 0 ? 90 : 0);
      float var6 = Math.clamp(var2.method09443() + (this.field14656 % 2 <= 0 ? (var2.method09443() > 0.0F ? -70 : 70) : 0), -89.9F, 89.9F);
      RotationManager.method06570(new Rotation(var5, var6), new Rotation(var2.method09439(), var2.method09443()), 999.0F, 999, false);
      if (this.field14656 > 3) {
         this.field14656 = 0;
         mc.player.setPos(mc.player.position().add(this.method06470(var2, var3)));
      }

      this.field14656++;
   }

   private Vec3 method06470(Rotation var1, double var2) {
      Vec3 var4 = this.method06471(Vec3.directionFromRotation(var1.method09443(), var1.method09439()), var2);
      if (!this.method06474(var4)) {
         return var4;
      }

      float var5 = var1.method09439();
      Vec3[] var6 = new Vec3[]{
         Vec3.directionFromRotation(0.0F, var5), field14655, Vec3.directionFromRotation(0.0F, var5 - 90.0F), Vec3.directionFromRotation(0.0F, var5 + 90.0F)
      };

      for (Vec3 var10 : var6) {
         Vec3 var11 = this.method06471(var10, var2);
         if (!this.method06474(var11)) {
            return var11;
         }
      }

      return Vec3.ZERO;
   }

   private Vec3 method06471(Vec3 var1, double var2) {
      return var1.scale(Math.min(this.method06472(var1), var2));
   }

   private double method06472(Vec3 var1) {
      if (!this.method06473(Vec3.ZERO) && !this.method06473(var1.scale(0.5))) {
         double var2 = this.method06475(var1) ? 1.95 : 1.0;
         boolean var4 = var2 == 1.95 || this.method06475(Vec3.ZERO);
         return var4 && !this.method06475(var1.scale(var2)) ? 0.5 : var2;
      } else {
         return 0.5;
      }
   }

   private boolean method06473(Vec3 var1) {
      AABB var2 = mc.player.getBoundingBox().move(var1).deflate(0.001);
      return WorldCollisionUtils.method02821(var2, Blocks.COBWEB) || WorldCollisionUtils.method02830(var2);
   }

   private boolean method06474(Vec3 var1) {
      return WorldCollisionUtils.method02822(mc.player.getBoundingBox().move(var1).inflate(0.3));
   }

   private boolean method06475(Vec3 var1) {
      return !mc.level.noBlockCollision(mc.player, mc.player.getBoundingBox().move(var1));
   }
}
