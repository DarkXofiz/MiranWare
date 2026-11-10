// Original binary: sg/ec/JsQxVGylFGZklkbL
package sg.ec;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class RaycastEvent extends Event {
   public static final RaycastEvent field09341 = new RaycastEvent();
   private RaycastEvent.Nested126 field09342;
   private Entity field09343;
   private HitResult field09344;
   private double field09345;
   private float field09346;
   private boolean field09347;

   public Entity method04123() {
      return this.field09343;
   }

   public EntityHitResult method04124(HitResult var1) {
      this.field09342 = RaycastEvent.Nested126.ENTITY;
      this.field09344 = var1;
      super.method03208();
      return this.field09344 instanceof EntityHitResult var2 ? var2 : null;
   }

   public void method04125(Entity var1, double var2, float var4, boolean var5, CallbackInfoReturnable<HitResult> var6) {
      this.field09342 = RaycastEvent.Nested126.BLOCK;
      this.field09343 = var1;
      this.field09344 = (HitResult)var6.getReturnValue();
      this.field09345 = var2;
      this.field09346 = var4;
      this.field09347 = var5;
      super.method03208();
      if (this.method05694()) {
         var6.setReturnValue(this.field09344);
      }
   }

   public void method04126(HitResult var1) {
      this.field09344 = var1;
   }

   public boolean method04127() {
      return this.field09347;
   }

   public float method04128() {
      return this.field09346;
   }

   public RaycastEvent.Nested126 method04129() {
      return this.field09342;
   }

   public double method04130() {
      return this.field09345;
   }

   public void method04131(RaycastEvent.Nested126 var1) {
      this.field09342 = var1;
   }

   public void method04132(boolean var1) {
      this.field09347 = var1;
   }

   public void method04133(double var1) {
      this.field09345 = var1;
   }

   public void method04134(float var1) {
      this.field09346 = var1;
   }

   public void method04135(Entity var1) {
      this.field09343 = var1;
   }

   public HitResult method04136() {
      return this.field09344;
   }

   // $VF: Compiled from s
   public enum Nested126 {
      BLOCK,
      ENTITY;
   }
}
