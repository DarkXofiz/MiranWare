// Original binary: sg/mx/4dLfMuv1yo87NYnt
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.ClientInput;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.client.sounds.SoundEngine.PlayResult;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.SprintSyncEvent;
import sg.ec.EntityCollisionPolicyEvent;
import sg.ec.BotEntityUtils;
import sg.ec.RaycastEvent;
import sg.ec.CanSprintEvent;
import sg.ec.PostPlayerInputEvent;
import sg.ec.ElytraStartEvent;
import sg.ec.PlayerTickEvent;
import sg.ec.PlayerUpdateEvent;
import sg.ec.PreMovementPacketEvent;
import sg.ec.ContainerCloseEvent;
import sg.ec.ModuleManager;
import sg.ec.LocalPlayerHooks;
import sg.ec.ItemUseSlowdownEvent;
import sg.ec.PostMovementPacketEvent;

// $VF: Compiled from s
@Mixin(value = LocalPlayer.class, priority = 500)
public abstract class LocalPlayerMixin {
   @Shadow
   @Final
   protected Minecraft minecraft;

   @Unique
   private boolean owner() {
      return !BotEntityUtils.method03835((Entity)(Object)this);
   }

   @Inject(
      method = "aiStep",
      at = @At(value = "FIELD", target = "Lnet/minecraft/client/player/LocalPlayer;wasFallFlying:Z", opcode = 181, shift = Shift.AFTER)
   )
   private void onElytraSync(CallbackInfo var1) {
      if (this.owner()) {
         LocalPlayer var2 = (LocalPlayer)(Object)this;
         if (ElytraStartEvent.field11209.method05133(var2)) {
            if (var2.tryToStartFallFlying()) {
               var2.connection.send(new ServerboundPlayerCommandPacket(var2, Action.START_FALL_FLYING));
            }
         }
      }
   }

   @Inject(method = "onSyncedDataUpdated", at = @At("TAIL"))
   private void onSyncedData(EntityDataAccessor<?> var1, CallbackInfo var2) {
      if (this.owner()) {
         ModuleManager.INSTANCE.method08187().method06063();
      }
   }

   @ModifyReturnValue(method = "isAutoJumpEnabled", at = @At("RETURN"))
   private boolean onIsAutoJumpEnabled(boolean var1) {
      return !this.owner() ? var1 : var1 && !ModuleManager.INSTANCE.method08187().method06047();
   }

   @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
   private void onTick(CallbackInfo var1) {
      if (this.owner()) {
         PlayerTickEvent.field14709.method06522(var1);
      }
   }

   @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;tick()V"))
   private void onUpdate(CallbackInfo var1) {
      if (this.owner()) {
         PlayerUpdateEvent.field14745.method03208();
      }
   }

   @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;tick()V", shift = Shift.AFTER))
   private void onPostUpdate(CallbackInfo var1) {
      if (this.owner()) {
         PostPlayerInputEvent.field10869.method03208();
      }
   }

   @Inject(
      method = "sendPosition",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isControlledCamera()Z", shift = Shift.AFTER),
      cancellable = true
   )
   private void sendMovementPacketsStart(CallbackInfo var1) {
      if (this.owner()) {
         PreMovementPacketEvent.field17844.method07297((LocalPlayer)(Object)this, var1);
      }
   }

   @Inject(
      method = {"sendPosition", "tick"},
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;sendIsSprintingIfNeeded()V", shift = Shift.AFTER)
   )
   private void onSprintSync(CallbackInfo var1) {
      if (this.owner()) {
         SprintSyncEvent.field00464.method03208();
      }
   }

   @Inject(method = "sendPosition", at = @At("TAIL"))
   private void sendMovementPacketsEnd(CallbackInfo var1) {
      if (this.owner()) {
         PostMovementPacketEvent.field24605.method03208();
      }
   }

   @ModifyExpressionValue(method = "sendPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getXRot()F"))
   private float modifyPitch(float var1) {
      return !this.owner() ? var1 : PreMovementPacketEvent.field17844.method07300(var1);
   }

   @ModifyExpressionValue(method = "sendPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getYRot()F"))
   private float modifyYaw(float var1) {
      return !this.owner() ? var1 : PreMovementPacketEvent.field17844.method07304(var1);
   }

   @ModifyExpressionValue(method = "sendPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getX()D"))
   private double modifyGetX(double var1) {
      return !this.owner() ? var1 : PreMovementPacketEvent.field17844.method07305(var1);
   }

   @ModifyExpressionValue(method = "sendPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getY()D"))
   private double modifyGetY(double var1) {
      return !this.owner() ? var1 : PreMovementPacketEvent.field17844.method07302(var1);
   }

   @ModifyExpressionValue(method = "sendPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getZ()D"))
   private double modifyGetZ(double var1) {
      return !this.owner() ? var1 : PreMovementPacketEvent.field17844.method07313(var1);
   }

   @ModifyExpressionValue(method = "sendPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;onGround()Z"))
   private boolean modifyOnGround(boolean var1) {
      return !this.owner() ? var1 : PreMovementPacketEvent.field17844.method07320(var1);
   }

   @Redirect(method = "modifyInput", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isUsingItem()Z"))
   private boolean tickMovement(LocalPlayer var1) {
      return !this.owner() ? var1.isUsingItem() : ItemUseSlowdownEvent.field19179.method08337(var1.isUsingItem());
   }

   @ModifyReturnValue(method = "modifyInput", at = @At("RETURN"))
   private Vec2 tickMovementInput(Vec2 var1) {
      return !this.owner() ? var1 : ItemUseSlowdownEvent.field19179.method08338(var1);
   }

   @ModifyExpressionValue(method = "applyInput", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getYRot()F"))
   private float tickNewAiYaw(float var1) {
      return !this.owner() ? var1 : LocalPlayerHooks.method08275(this.minecraft, var1);
   }

   @ModifyExpressionValue(method = "applyInput", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getXRot()F"))
   private float tickNewAiPitch(float var1) {
      return !this.owner() ? var1 : LocalPlayerHooks.method08276(this.minecraft, var1);
   }

   @ModifyExpressionValue(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;canStartSprinting()Z"))
   private boolean tickMovement(boolean var1) {
      return !this.owner() ? var1 : CanSprintEvent.field10222.method04668(var1, (LocalPlayer)(Object)this);
   }

   @ModifyExpressionValue(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;isSpectator()Z"))
   private boolean useSessionSpectatorState(boolean var1) {
      return this.owner() ? var1 : ((LocalPlayer)(Object)this).isSpectator();
   }

   @Redirect(
      method = {"aiStep", "handlePortalTransitionEffect"},
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;screen()Lnet/minecraft/client/gui/screens/Screen;")
   )
   private Screen isolateBotScreen(Gui var1) {
      return this.owner() ? var1.screen() : null;
   }

   @Redirect(
      method = "handlePortalTransitionEffect",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/sounds/SoundManager;play(Lnet/minecraft/client/resources/sounds/SoundInstance;)Lnet/minecraft/client/sounds/SoundEngine$PlayResult;"
      )
   )
   private PlayResult suppressBotPortalSound(SoundManager var1, SoundInstance var2) {
      return !this.owner() ? PlayResult.NOT_STARTED : var1.play(var2);
   }

   @Inject(method = "suffocatesAt", at = @At("HEAD"), cancellable = true)
   private void onWouldCollideAt(CallbackInfoReturnable<Boolean> var1) {
      if (this.owner()) {
         EntityCollisionPolicyEvent.field06700.method02899(EntityCollisionPolicyEvent.Nested73.BLOCK, var1);
      }
   }

   @ModifyExpressionValue(
      method = "pick(Lnet/minecraft/world/entity/Entity;DDF)Lnet/minecraft/world/phys/HitResult;",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/entity/projectile/ProjectileUtil;getEntityHitResult(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;D)Lnet/minecraft/world/phys/EntityHitResult;"
      )
   )
   private static EntityHitResult onFindCrosshairTarget(EntityHitResult var0) {
      return RaycastEvent.field09341.method04124(var0);
   }

   @Redirect(
      method = {"onSyncedDataUpdated", "updateIsUnderwater()Z", "startRiding(Lnet/minecraft/world/entity/Entity;ZZ)Z"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/sounds/SoundManager;play(Lnet/minecraft/client/resources/sounds/SoundInstance;)Lnet/minecraft/client/sounds/SoundEngine$PlayResult;"
      )
   )
   private PlayResult hexSuppressBotSound(SoundManager var1, SoundInstance var2) {
      return !this.owner() ? PlayResult.NOT_STARTED : var1.play(var2);
   }

   @Redirect(
      method = "aiStep",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/tutorial/Tutorial;onInput(Lnet/minecraft/client/player/ClientInput;)V")
   )
   private void hexSuppressBotTutorial(Tutorial var1, ClientInput var2) {
      if (this.owner()) {
         var1.onInput(var2);
      }
   }

   @Inject(method = "closeContainer", at = @At("HEAD"), cancellable = true)
   public void closeScreen(CallbackInfo var1) {
      if (this.owner()) {
         ContainerCloseEvent.field19023.method08157(this.minecraft, (LocalPlayer)(Object)this, var1);
      }
   }
}
