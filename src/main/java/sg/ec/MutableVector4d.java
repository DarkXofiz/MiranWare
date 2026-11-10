// Original binary: sg/ec/vgxOQ5cEpTWSFqc7
package sg.ec;

import net.minecraft.world.phys.Vec3;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4fc;
import org.joml.Vector4ic;

// $VF: Compiled from s
public class MutableVector4d {
   public double field24957;
   public double field24958;
   public double field24959;
   private static final double field24960 = -1.0;

   public MutableVector4d method11118(Vector4dc var1) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var1.z();
      return this;
   }

   public double method11119() {
      return this.field24959;
   }

   public MutableVector4d method11120(Vector4ic var1) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var1.z();
      return this;
   }

   public MutableVector4d method11121(float[] var1) {
      this.field24957 = var1[0];
      this.field24958 = var1[1];
      this.field24959 = var1[2];
      return this;
   }

   public MutableVector4d method11122(MutableVector4d var1) {
      return this.method11129(var1.field24957, var1.field24958, var1.field24959);
   }

   public MutableVector4d method11123(Vector3fc var1) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var1.z();
      return this;
   }

   public MutableVector4d method11124(double var1) {
      this.field24957 = var1;
      this.field24958 = var1;
      this.field24959 = var1;
      return this;
   }

   public MutableVector4d method11125(Vector2dc var1, double var2) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var2;
      return this;
   }

   public MutableVector4d method11126(double var1, double var3, double var5) {
      this.field24957 = var1;
      this.field24958 = var3;
      this.field24959 = var5;
      return this;
   }

   public MutableVector4d method11127(Vec3 var1) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var1.z();
      return this;
   }

   public MutableVector4d method11128(double[] var1) {
      this.field24957 = var1[0];
      this.field24958 = var1[1];
      this.field24959 = var1[2];
      return this;
   }

   public MutableVector4d method11129(double var1, double var3, double var5) {
      return new MutableVector4d(this.field24957 * var1, this.field24958 * var3, this.field24959 * var5);
   }

   public MutableVector4d method11130(Vector3ic var1) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var1.z();
      return this;
   }

   public MutableVector4d method11131(double var1, double var3, double var5) {
      return this.method11139(-var1, -var3, -var5);
   }

   public MutableVector4d method11132() {
      return this.method11133(field24960);
   }

   public MutableVector4d method11133(double var1) {
      return this.method11129(var1, var1, var1);
   }

   public MutableVector4d method11134(double var1) {
      return this.method11139(var1, var1, var1);
   }

   public MutableVector4d() {
   }

   public MutableVector4d(double var1, double var3, double var5) {
      this.field24957 = var1;
      this.field24958 = var3;
      this.field24959 = var5;
   }

   public MutableVector4d method11135(double var1) {
      return this.method11131(var1, var1, var1);
   }

   public MutableVector4d method11136(Vector4fc var1) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var1.z();
      return this;
   }

   public MutableVector4d method11137() {
      return new MutableVector4d(this.field24957, 0.0, this.field24959);
   }

   public double method11138() {
      return this.field24957;
   }

   public MutableVector4d method11139(double var1, double var3, double var5) {
      return new MutableVector4d(this.field24957 + var1, this.field24958 + var3, this.field24959 + var5);
   }

   public MutableVector4d method11140(Vector2fc var1, double var2) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var2;
      return this;
   }

   public MutableVector4d method11141(Vector3dc var1) {
      if (var1 == this) {
         return this;
      }

      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var1.z();
      return this;
   }

   public MutableVector4d method11142(MutableVector4d var1) {
      return this.method11131(var1.field24957, var1.field24958, var1.field24959);
   }

   public MutableVector4d method11143(Vector2ic var1, double var2) {
      this.field24957 = var1.x();
      this.field24958 = var1.y();
      this.field24959 = var2;
      return this;
   }

   public double method11144() {
      return this.field24958;
   }

   public MutableVector4d(double var1) {
      this.field24957 = var1;
      this.field24958 = var1;
      this.field24959 = var1;
   }

   public MutableVector4d method11145(MutableVector4d var1) {
      return this.method11139(var1.field24957, var1.field24958, var1.field24959);
   }
}
