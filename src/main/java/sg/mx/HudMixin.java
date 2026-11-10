// Original binary: sg/mx/PZ4mUe1QJZidPgMj
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.world.scores.Objective;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.HeldItemRenderEvent;
import sg.ec.PlayerListRenderEvent;
import sg.ec.NauseaStrengthEvent;
import sg.ec.CrosshairRenderEvent;
import sg.ec.VisualRemovalEvent;
import sg.ec.HotbarRenderEvent;

// $VF: Compiled from s
@Mixin(Hud.class)
public class HudMixin {
   @Shadow
   @Final
   private PlayerTabOverlay tabList;
   @Shadow
   @Final
   private Minecraft minecraft;

   @Inject(method = "extractCrosshair", at = @At("HEAD"), cancellable = true)
   private void renderCrossHair(GuiGraphicsExtractor var1, DeltaTracker var2, CallbackInfo var3) {
      CrosshairRenderEvent.field19710.method08627(var1, var2, var3);
   }

   @Inject(method = "displayScoreboardSidebar", at = @At("HEAD"), cancellable = true)
   private void renderScoreboardSidebar(GuiGraphicsExtractor var1, Objective var2, CallbackInfo var3) {
      VisualRemovalEvent.field19883.method08691(VisualRemovalEvent.Nested242.SCOREBOARD, var3);
   }

   @Inject(method = "extractTitle", at = @At("HEAD"), cancellable = true)
   private void renderTitleAndSubtitle(GuiGraphicsExtractor var1, DeltaTracker var2, CallbackInfo var3) {
      VisualRemovalEvent.field19883.method08691(VisualRemovalEvent.Nested242.OVERLAY_MESSAGE, var3);
   }

   @Inject(method = "extractEffects", at = @At("HEAD"), cancellable = true)
   private void renderStatusEffectOverlay(GuiGraphicsExtractor var1, DeltaTracker var2, CallbackInfo var3) {
      VisualRemovalEvent.field19883.method08691(VisualRemovalEvent.Nested242.MINECRAFT_EFFECTS, var3);
   }

   @Inject(method = "extractSelectedItemName", at = @At("HEAD"), cancellable = true)
   private void renderHeldItemTooltip(GuiGraphicsExtractor var1, CallbackInfo var2) {
      VisualRemovalEvent.field19883.method08691(VisualRemovalEvent.Nested242.ITEM_TITLES, var2);
   }

   @Inject(method = "extractTabList", at = @At("HEAD"), cancellable = true)
   private void onRenderPlayerList(GuiGraphicsExtractor var1, DeltaTracker var2, CallbackInfo var3) {
      PlayerListRenderEvent.field09335.method04119(var1, this.tabList, this.minecraft, var3);
   }

   @Inject(method = "extractItemHotbar", at = @At("HEAD"), cancellable = true)
   private void renderHotbarStart(GuiGraphicsExtractor var1, DeltaTracker var2, CallbackInfo var3) {
      HotbarRenderEvent.field20796.method09172(HotbarRenderEvent.Nested254.START, var2, this.minecraft, (Hud)(Object)this, var1, var3);
   }

   @Inject(method = "extractItemHotbar", at = @At("RETURN"), cancellable = true)
   private void renderHotbarEnd(GuiGraphicsExtractor var1, DeltaTracker var2, CallbackInfo var3) {
      HotbarRenderEvent.field20796.method09172(HotbarRenderEvent.Nested254.END, var2, this.minecraft, (Hud)(Object)this, var1, var3);
   }

   @ModifyExpressionValue(method = "extractItemHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;getSelectedSlot()I"))
   private int renderHotbarSelectedSlot(int var1) {
      return HeldItemRenderEvent.field00682.method00309(var1);
   }

   @ModifyExpressionValue(
      method = "extractCameraOverlays",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getEffectBlendFactor(Lnet/minecraft/core/Holder;F)F")
   )
   private float renderConfusionOverlay(float var1) {
      return NauseaStrengthEvent.field10218.method04657(var1);
   }
}
