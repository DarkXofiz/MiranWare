// Original binary: sg/mx/Qr06xDGFyNgnRfZl
package sg.mx;

import com.llamalad7.mixinextras.sugar.Local;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.AnimationAccess;
import sg.ec.AnimationToggle;
import sg.ec.AnimationUtils;
import sg.ec.PlayerListLayoutEvent;
import sg.ec.PlayerListRowColorEvent;
import sg.ec.PlayerListRenderEvent;

// $VF: Compiled from s
@Mixin(PlayerTabOverlay.class)
public class PlayerTabOverlayMixin_1206 implements AnimationAccess {
   @Unique
   private AnimationUtils anim;
   private static final long field28014 = 250L;

   @Inject(method = "setVisible", at = @At("TAIL"))
   private void setVisible(boolean var1, CallbackInfo var2) {
      AnimationToggle.method02737(this.anim(), var1);
   }

   @Inject(method = "extractRenderState", at = @At("HEAD"))
   private void startRender(GuiGraphicsExtractor var1, int var2, Scoreboard var3, Objective var4, CallbackInfo var5) {
      PlayerListRenderEvent.field09335.method04118(var1, PlayerListRenderEvent.Nested125.START, this.anim().method03377());
   }

   @Inject(method = "extractRenderState", at = @At("TAIL"))
   private void endRender(GuiGraphicsExtractor var1, int var2, Scoreboard var3, Objective var4, CallbackInfo var5) {
      PlayerListRenderEvent.field09335.method04118(var1, PlayerListRenderEvent.Nested125.END, this.anim().method03377());
   }

   @ModifyArg(
      method = "extractRenderState",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V", ordinal = 2),
      index = 4
   )
   private int onFillRowBackground(int var1, @Local(ordinal = 0) List<PlayerInfo> var2, @Local(ordinal = 4) int var3) {
      return PlayerListRowColorEvent.field08574.method03805(var2, var1, var3);
   }

   @ModifyConstant(method = "extractRenderState", constant = @Constant(intValue = 20, ordinal = 0))
   private int replaceHeight(int var1) {
      return PlayerListLayoutEvent.field08065.method03628(var1);
   }

   @ModifyConstant(method = "getPlayerInfos", constant = @Constant(longValue = 80L))
   private long replacePlayerCap(long var1) {
      return PlayerListLayoutEvent.field08065.method03630(var1);
   }

   @Override
   public AnimationUtils anim() {
      AnimationUtils var1 = this.anim;
      if (var1 == null) {
         var1 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_EXPO, field28014);
         this.anim = var1;
      }

      return var1;
   }

   @Generated
   public AnimationUtils getAnim() {
      return this.anim;
   }

}
