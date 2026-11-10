// Original binary: sg/mx/j1YvOiB22GMSgcEa
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.MobEffectVisibilityEvent;
import sg.ec.PostTravelEvent;
import sg.ec.EntityCollisionPolicyEvent;
import sg.ec.EntityJumpEvent;
import sg.ec.BotEntityUtils;
import sg.ec.SprintStateEvent;
import sg.ec.SwingDurationEvent;
import sg.ec.ElytraVelocityEvent;
import sg.ec.ItemUseStartEvent;
import sg.ec.MobEffectEvent;

// $VF: Compiled from s
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin_1268 {
   @Inject(method = "onClimbable", at = @At("HEAD"), cancellable = true)
   private void isClimbing(CallbackInfoReturnable<Boolean> var1) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         EntityCollisionPolicyEvent.field06700.method02898((LivingEntity)(Object)this, EntityCollisionPolicyEvent.Nested73.LIANA, var1);
      }
   }

   @Inject(method = "onEffectAdded", at = @At("RETURN"))
   private void onStatusEffectApplied(MobEffectInstance var1, Entity var2, CallbackInfo var3) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         MobEffectEvent.field19880.method08689(var1, (LivingEntity)(Object)this);
      }
   }

   @Inject(method = "removeEffectNoUpdate", at = @At("RETURN"))
   private void onRemoveStatusEffectInternal(Holder<MobEffect> var1, CallbackInfoReturnable<MobEffectInstance> var2) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         MobEffectEvent.field19880.method08690((MobEffectInstance)var2.getReturnValue(), (LivingEntity)(Object)this);
      }
   }

   @Inject(method = "isPushable", at = @At("HEAD"), cancellable = true)
   private void onIsPushable(CallbackInfoReturnable<Boolean> var1) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         EntityCollisionPolicyEvent.field06700.method02898((LivingEntity)(Object)this, EntityCollisionPolicyEvent.Nested73.PLAYER, var1);
      }
   }

   @ModifyReturnValue(method = "hasEffect", at = @At("RETURN"))
   private boolean onHasStatusEffect(boolean var1, Holder<MobEffect> var2) {
      return BotEntityUtils.method03835((Entity)(Object)this) ? var1 : MobEffectVisibilityEvent.field01112.method00608((LivingEntity)(Object)this, var2.value(), var1);
   }

   @Inject(method = "jumpFromGround", at = @At("HEAD"))
   private void onJump(CallbackInfo var1) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         EntityJumpEvent.field08473.method03778((LivingEntity)(Object)this);
      }
   }

   @Inject(method = "startUsingItem", at = @At("RETURN"))
   private void onStartUsingItem(InteractionHand var1, CallbackInfo var2) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         LivingEntity var3 = (LivingEntity)(Object)this;
         if (var3.level().isClientSide()) {
            ItemUseStartEvent.field19542.method08461(var3);
         }
      }
   }

   @Inject(method = "setSprinting", at = @At("HEAD"), cancellable = true)
   private void onSetSprinting(boolean var1, CallbackInfo var2) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         SprintStateEvent.field08731.method03881((LivingEntity)(Object)this, var1, var2);
      }
   }

   @Inject(method = "getModifiedSwingDuration", at = @At("HEAD"), cancellable = true)
   private void onArmSpeed(net.minecraft.world.item.component.SwingAnimation var0, CallbackInfoReturnable<Integer> var1) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         SwingDurationEvent.field11216.method05146((LivingEntity)(Object)this, var1);
      }
   }

   @Inject(method = "travel", at = @At("RETURN"))
   private void onPostTravel(Vec3 var1, CallbackInfo var2) {
      if (!BotEntityUtils.method03835((Entity)(Object)this)) {
         PostTravelEvent.field03983.method03208();
      }
   }

   @ModifyReturnValue(method = "updateFallFlyingMovement", at = @At("RETURN"))
   private Vec3 onSetVelocity(Vec3 var1) {
      return BotEntityUtils.method03835((Entity)(Object)this) ? var1 : ElytraVelocityEvent.field14681.method06495(var1, (LivingEntity)(Object)this);
   }
}
