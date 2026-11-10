// Original binary: sg/mx/RPSItrikE7v0gc32
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.blaze3d.platform.Window;
import java.util.UUID;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.main.GameConfig;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.TickEvent;
import sg.ec.PostTickEvent;
import sg.ec.MinecraftInteractionAccess;
import sg.ec.MinecraftHooks;
import sg.ec.RenderFrameStartEvent;
import sg.ec.BlockBreakManager;
import sg.ec.BlockCollisionEvent;
import sg.ec.BotSessionManager;
import sg.ec.AttackKeyEvent;
import sg.ec.ClientShutdownEvent;
import sg.ec.WorldLoadEvent;
import sg.ec.RenderFrameEndEvent;
import sg.ec.ItemUseInputDispatchEvent;
import sg.ec.GameStartedEvent;

// $VF: Compiled from s
@Mixin(Minecraft.class)
public abstract class MinecraftMixin_1211 implements MinecraftInteractionAccess {
   @Shadow
   @Nullable
   public LocalPlayer player;
   @Shadow
   public Options options;
   @Shadow
   protected int missTime;
   @Shadow
   @Nullable
   public MultiPlayerGameMode gameMode;
   @Shadow
   public Gui gui;
   @Shadow
   public Screen screen;

   @Shadow
   public abstract Window getWindow();

   @Shadow
   protected abstract boolean startAttack();

   @Shadow
   protected abstract void startUseItem();

   @Override
   public boolean IdoAttack() {
      if (this.screen != null) {
         this.missTime = 0;
      }

      return this.startAttack();
   }

   @Override
   public void IdoItemUse() {
      if (this.screen != null && this.gameMode != null && this.gameMode.isDestroying()) {
         this.gameMode.stopDestroyBlock();
      }

      this.startUseItem();
   }

   @Inject(method = "<init>", at = @At("RETURN"))
   private void onPostInit(GameConfig var1, CallbackInfo var2) {
      GameStartedEvent.field25203.method03208();
   }

   @Inject(method = "runTick", at = @At("HEAD"))
   private void onRunTickClose(boolean var1, CallbackInfo var2) {
      MinecraftHooks.method04017(this.getWindow());
   }

   @Inject(method = "close", at = @At("HEAD"))
   private void onCloseSave(CallbackInfo var1) {
      ClientShutdownEvent.field20788.method03208();
   }

   @Inject(method = "setLevel", at = @At("TAIL"))
   private void onLoadWorld(ClientLevel var1, CallbackInfo var2) {
      WorldLoadEvent.field23228.method03208();
   }

   @Inject(method = "tick", at = @At("HEAD"))
   private void startTick(CallbackInfo var1) {
      TickEvent.field07044.method03208();
   }

   @Inject(
      method = "tick",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;screen()Lnet/minecraft/client/gui/screens/Screen;", ordinal = 0)
   )
   private void onAttack(CallbackInfo var1) {
      AttackKeyEvent.field20562.method03208();
      if (BlockBreakManager.INSTANCE.method04909()) {
         this.missTime = 0;
      }
   }

   @Inject(method = "tick", at = @At("RETURN"))
   private void endTick(CallbackInfo var1) {
      PostTickEvent.field07602.method03208();
   }

   @Inject(method = "pick(F)V", at = @At("HEAD"))
   private void onPickStart(float var1, CallbackInfo var2) {
      BlockBreakManager.INSTANCE.method04910();
   }

   @Inject(method = "pick(F)V", at = @At("RETURN"))
   private void onPickEnd(float var1, CallbackInfo var2) {
      BlockBreakManager.INSTANCE.method04911();
   }

   @Redirect(method = "handleKeybinds", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;startUseItem()V", ordinal = 1))
   private void handleInputEvents$doItemUse(Minecraft var1) {
      ItemUseInputDispatchEvent.field24204.method10890(var1);
   }

   @Redirect(method = "handleKeybinds", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;setSelectedSlot(I)V"))
   private void handleInputEvents$selectSlot(Inventory var1, int var2) {
      MinecraftHooks.method04016(var1, var2);
   }

   @Redirect(method = "handleKeybinds", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/KeyMapping;isDown()Z"))
   private boolean handleInputEvents$isPressed(KeyMapping var1) {
      return MinecraftHooks.method04015(var1, this.options);
   }

   @Inject(method = "isBlocked", at = @At("HEAD"), cancellable = true)
   private void isBlocked(UUID var1, CallbackInfoReturnable<Boolean> var2) {
      var2.setReturnValue(false);
   }

   @Inject(method = "setScreenAndShow", at = @At("HEAD"), cancellable = true)
   private void onSetScreenAndShow(Screen var1, CallbackInfo var2) {
      if (BotSessionManager.INSTANCE.method08749()) {
         var2.cancel();
      }
   }

   @ModifyExpressionValue(method = "renderFrame", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Util;getNanos()J"))
   private long startRender(long var1) {
      return BlockCollisionEvent.field19709.method08622(var1);
   }

   @Inject(method = "renderFrame", at = @At("HEAD"))
   private void onRenderThreadStart(boolean var1, CallbackInfo var2) {
      RenderFrameStartEvent.field10214.method03208();
   }

   @Inject(method = "renderFrame", at = @At("RETURN"))
   private void onRenderThreadEnd(boolean var1, CallbackInfo var2) {
      RenderFrameEndEvent.field24174.method03208();
   }
}
