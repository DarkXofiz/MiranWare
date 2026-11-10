// Original binary: sg/ec/5MHL31xaSjeAjDSt
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack.Pose;
import java.util.ArrayList;

// $VF: Compiled from s
public final class PoseStackPool {
   public static final PoseStackPool field02228 = new PoseStackPool();
   private final ArrayList<Pose> field02229 = new ArrayList<>(256);
   private int field02230;

   public void method00968() {
      EventBus.method00263(this);
   }

   @Subscribe
   private void method00969(RenderFrameStartEvent var1) {
      this.field02230 = 0;
   }

   private PoseStackPool() {
   }

   public Pose method00970(Pose var1) {
      var var2 = this.field02229;
      Pose var3;
      if (this.field02230 < var2.size()) {
         var3 = (Pose)var2.get(this.field02230);
      } else {
         var3 = new Pose();
         var2.add(var3);
      }

      this.field02230++;
      var3.set(var1);
      return var3;
   }
}
