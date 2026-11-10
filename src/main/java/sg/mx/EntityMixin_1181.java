// Original binary: sg/mx/MO8LtlYIbq9PuUNj
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.TrailPoint;
import sg.ec.EntityVelocityEvent;
import sg.ec.MoveRelativeEvent;
import sg.ec.BotEntityUtils;
import sg.ec.RaycastEvent;
import sg.ec.EntityExtensionAccess;
import sg.ec.WaterStateEvent;
import sg.ec.EntityMoveEvent;
import sg.ec.EntityEyeDistanceUtils;

// $VF: Compiled from s
@Mixin(Entity.class)
public abstract class EntityMixin_1181 implements EntityExtensionAccess {
   @Shadow
   private int id;
   @Unique
   public boolean botEntity;
   @Unique
   public Vec2 vec2f;
   @Unique
   public Vec3 vec3d;
   @Unique
   public List<TrailPoint> trailPoints;

   @Inject(method = "getId", at = @At("HEAD"), cancellable = true)
   private void onGetId(CallbackInfoReturnable<Integer> var1) {
      var1.setReturnValue(this.id);
   }

   @ModifyReturnValue(method = "getDeltaMovement", at = @At("RETURN"))
   private Vec3 onVelocity(Vec3 var1) {
      return BotEntityUtils.method03835((Entity)(Object)this) ? var1 : EntityVelocityEvent.field05097.method02132((Entity)(Object)this, var1);
   }

   @ModifyExpressionValue(
      method = "move",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/entity/Entity;maybeBackOffFromEdge(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/MoverType;)Lnet/minecraft/world/phys/Vec3;"
      )
   )
   private Vec3 modifyMovement(Vec3 var1, MoverType var2) {
      return BotEntityUtils.method03835((Entity)(Object)this) ? var1 : EntityMoveEvent.field22695.method10058((Entity)(Object)this, var1);
   }

   @Inject(method = "pick", at = @At("RETURN"), cancellable = true)
   private void onRaycast(double var1, float var3, boolean var4, CallbackInfoReturnable<HitResult> var5) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         RaycastEvent.field09341.method04125((Entity)(Object)this, var1, var3, var4, var5);
      }
   }

   @Inject(method = "moveRelative", at = @At("RETURN"))
   private void onMoveRelative(float var1, Vec3 var2, CallbackInfo var3) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         MoveRelativeEvent.field06827.method03005((Entity)(Object)this, var1, var2);
      }
   }

   @ModifyReturnValue(method = "isInWater", at = @At("RETURN"))
   private boolean isTouchingWater(boolean var1) {
      return BotEntityUtils.method03835((Entity)(Object)this) ? var1 : WaterStateEvent.field20794.method09166(var1);
   }

   @Override
   public double getDistanceEyePos(Entity var1) {
      return this.getDist(var1);
   }

   @Override
   public boolean botEntity() {
      return this.botEntity;
   }

   @Override
   public void setBotEntity(boolean var1) {
      this.botEntity = var1;
   }

   @Override
   public Vec2 getVec2f() {
      return this.vec2f != null ? this.vec2f : Vec2.ZERO;
   }

   @Override
   public void setVec2f(Vec2 var1) {
      this.vec2f = var1;
   }

   @Override
   public Vec3 getVec3d() {
      return this.vec3d != null ? this.vec3d : Vec3.ZERO;
   }

   @Override
   public void setVec3d(Vec3 var1) {
      this.vec3d = var1 != null ? var1 : Vec3.ZERO;
   }

   @Override
   public List<TrailPoint> getTrailPoints() {
      var var1 = this.trailPoints;
      if (var1 == null) {
         var1 = new ArrayList<>();
         this.trailPoints = var1;
      }

      return var1;
   }

   @Unique
   public float getDist(Entity var1) {
      return EntityEyeDistanceUtils.method10980((Entity)(Object)this, var1);
   }
}
