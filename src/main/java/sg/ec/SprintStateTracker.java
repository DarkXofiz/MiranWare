// Original binary: sg/ec/OoudZOZ2SIlCuCNq
package sg.ec;

import java.util.List;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.syncher.SynchedEntityData.DataValue;
import net.minecraft.world.entity.Entity;
import sg.mx.LocalPlayerMixin_1170;

// $VF: Compiled from s
public final class SprintStateTracker {
   private static final int field10870 = 8;
   private static final int field10871 = 0;
   private int field10872;

   public void method04928() {
      this.field10872 = 0;
   }

   public void method04929(LocalPlayer var1) {
      if (this.field10872 != 0) {
         this.field10872 = method04933(var1) ? this.field10872 - 1 : 0;
      }
   }

   public void method04930(LocalPlayer var1) {
      if (method04933(var1)) {
         this.field10872 = 40;
      }
   }

   private static boolean method04931(List<DataValue<?>> var0) {
      for (DataValue var2 : var0) {
         if (var2.id() == Entity.DATA_SHARED_FLAGS_ID.id() && var2.value() instanceof Byte var3) {
            return (var3 & 8) == 0;
         }
      }

      return false;
   }

   public boolean method04932(LocalPlayer var1, List<DataValue<?>> var2) {
      if (this.field10872 != 0 && method04933(var1) && method04931(var2)) {
         this.field10872 = 0;
         return true;
      } else {
         return false;
      }
   }

   private static boolean method04933(LocalPlayer var0) {
      return ((LocalPlayerMixin_1170)(Object)var0).wasSprinting();
   }
}
