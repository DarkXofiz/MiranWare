// Original binary: sg/ec/JshEKgJ5XDoTWlCQ
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class ViewModelOffsetEvent extends Event {
   public static final ViewModelOffsetEvent field09348 = new ViewModelOffsetEvent();
   private Vec3 field09349;
   private Vec3 field09350;

   public Vec3 method04137() {
      return this.field09349;
   }

   public Vec3 method04138() {
      return this.field09350;
   }

   public void method04139(Vec3 var1) {
      this.field09349 = var1;
   }

   public void method04140(Vec3 var1) {
      this.field09350 = var1;
   }

   public void method04141(AbstractClientPlayer var1, InteractionHand var2, PoseStack var3) {
      if (this.method05698()) {
         this.method05695(false);
         super.method03208();
         if (this.method05694()) {
            boolean var4 = var2 == InteractionHand.MAIN_HAND && var1.getMainArm() == HumanoidArm.RIGHT
               || var2 == InteractionHand.OFF_HAND && var1.getMainArm() == HumanoidArm.LEFT;
            Vec3 var5 = var4 ? this.field09349 : this.field09350;
            if (var5 != null) {
               var3.translate(var5);
            }
         }
      }
   }
}
