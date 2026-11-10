// Original binary: sg/mx/okqblLQKNVCNyDJK
package sg.mx;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
@Mixin(targets = "net.minecraft.client.renderer.state.level.FirstPersonHandsAndItemsRenderState$HandRenderSelection")
public abstract class ItemInHandRenderer$HandRenderSelectionMixin {
   @Shadow
   @Final
   @Mutable
   public boolean renderMainHand;
   @Shadow
   @Final
   @Mutable
   public boolean renderOffHand;

   @Inject(method = "<init>", at = @At("RETURN"))
   private void hmi$makeBothHandsRender(String var1, int var2, boolean var3, boolean var4, CallbackInfo var5) {
      this.renderMainHand = true;
      this.renderOffHand = true;
   }
}
