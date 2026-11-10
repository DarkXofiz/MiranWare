// Original binary: sg/mx/1zTNYMwWGz443fKG
package sg.mx;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.LastHealthAccess;
import sg.ec.EntityCollisionPolicyEvent;
import sg.ec.BotEntityUtils;
import sg.ec.PlayerMovementActionEvent;
import sg.ec.DragonTravelEvent;

// $VF: Compiled from s
@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity implements LastHealthAccess {
   @Unique
   private float lastHealth = 0.0F;

   @Override
   public void setLastHealth(float var1) {
      this.lastHealth = var1;
   }

   @Override
   public float lastHealth() {
      return this.lastHealth;
   }

   protected PlayerMixin(EntityType<? extends LivingEntity> var1, Level var2) {
      super(var1, var2);
   }

   @Inject(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Avatar;travel(Lnet/minecraft/world/phys/Vec3;)V", ordinal = 1))
   private void onDragonFly(Vec3 var1, CallbackInfo var2) {
      Player var3 = (Player)(Object)this;
      if (var3 instanceof LocalPlayer && !BotEntityUtils.method03835(var3)) {
         var3.setDeltaMovement(DragonTravelEvent.field17745.method07276(var3.getDeltaMovement()));
      }
   }

   @Inject(method = "isPushedByFluid", at = @At("HEAD"), cancellable = true)
   private void onIsPushedByFluids(CallbackInfoReturnable<Boolean> var1) {
      if (!BotEntityUtils.method03835(this)) {
         EntityCollisionPolicyEvent.field06700.method02898((Player)(Object)this, EntityCollisionPolicyEvent.Nested73.WATER, var1);
      }
   }

   @Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;isSprinting()Z"))
   private boolean attackWithServerKnownSprint(Player var1) {
      return var1 instanceof LocalPlayer && !BotEntityUtils.method03835(var1) ? ((LocalPlayerMixin_1170)(Object)var1).wasSprinting() : var1.isSprinting();
   }

   @Redirect(
      method = "causeExtraKnockback",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V")
   )
   private void onSetVelocity(Player var1, Vec3 var2) {
      if (BotEntityUtils.method03835(var1)) {
         var1.setDeltaMovement(var2);
      } else {
         PlayerMovementActionEvent.field15333.method06803(var1, var2);
      }
   }

   @Redirect(method = "causeExtraKnockback", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;setSprinting(Z)V"))
   private void onSetSprinting(Player var1, boolean var2) {
      if (BotEntityUtils.method03835(var1)) {
         var1.setSprinting(var2);
      } else {
         PlayerMovementActionEvent.field15333.method06802(var1, var2);
      }
   }
}
