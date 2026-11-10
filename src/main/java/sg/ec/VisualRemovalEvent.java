// Original binary: sg/ec/hlGd1SbCG5bbuvpM
package sg.ec;

import java.util.List;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class VisualRemovalEvent extends Event {
   public static final VisualRemovalEvent field19883 = new VisualRemovalEvent();
   private VisualRemovalEvent.Nested242 field19884;
   private List<?> field19885;

   public boolean method08691(VisualRemovalEvent.Nested242 var1, CallbackInfo var2) {
      if (this.method08697(var1)) {
         var2.cancel();
         return true;
      } else {
         return false;
      }
   }

   public FogType method08692(FogType var1, VisualRemovalEvent.Nested242 var2) {
      return this.method08697(var2) ? FogType.NONE : var1;
   }

   public void method08693(VisualRemovalEvent.Nested242 var1, List<?> var2) {
      if (this.method05698()) {
         this.field19885 = var2;
         this.method08697(var1);
         this.field19885 = null;
      }
   }

   public VisualRemovalEvent.Nested242 method08694() {
      return this.field19884;
   }

   public void method08695(VisualRemovalEvent.Nested242 var1) {
      this.field19884 = var1;
   }

   public void method08696(List<?> var1) {
      this.field19885 = var1;
   }

   public boolean method08697(VisualRemovalEvent.Nested242 var1) {
      if (!this.method05698()) {
         return false;
      }

      this.field19884 = var1;
      super.method03208();
      return this.method05694();
   }

   public void method08698(VisualRemovalEvent.Nested242 var1, CallbackInfoReturnable<Float> var2, float var3) {
      if (this.method08697(var1)) {
         var2.setReturnValue(var3);
      }
   }

   public List<?> method08699() {
      return this.field19885;
   }

   // $VF: Compiled from s
   public enum Nested242 {
      FIRE,
      NOHURTCAM,
      F5_XUETA,
      SCOREBOARD,
      ITEM_TITLES,
      TOTEM,
      OVERLAY_MESSAGE,
      MINECRAFT_EFFECTS,
      WATER_FOG,
      LAVA_FOG,
      NIGHT_VISION_FOG,
      LAG_MACHINE;
   }
}
