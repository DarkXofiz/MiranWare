// Original binary: sg/mx/55EeFxDRsFXWZonz
package sg.mx;

import java.util.List;
import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.feature.phase.FeatureRenderPhase;
import net.minecraft.client.renderer.feature.phase.SimpleFeatureRenderPhase;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.RenderSubmissionAccess;
import sg.ec.SubmitNodeCollectionHooks;

// $VF: Compiled from s
@Mixin(SubmitNodeCollection.class)
public abstract class SubmitNodeCollectionMixin implements RenderSubmissionAccess {
   @Unique
   private SimpleFeatureRenderPhase hexBeforeClear;
   @Shadow
   @Final
   @Mutable
   private List<FeatureRenderPhase<?>> allPhases;

   @Inject(method = "<init>", at = @At("TAIL"))
   private void hexRegisterPhase(CallbackInfo var1) {
      this.hexBeforeClear = new SimpleFeatureRenderPhase();
      this.allPhases = SubmitNodeCollectionHooks.method10798(this.allPhases, this.hexBeforeClear);
   }

   @Override
   public SimpleFeatureRenderPhase hexBeforeClear() {
      return this.hexBeforeClear;
   }
}
