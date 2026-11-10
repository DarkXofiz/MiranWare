// Original binary: sg/ec/FkWrKk9efRXNBOnU
package sg.ec;

import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public final class GuiClickRegions {
   private final List<GuiClickRegions.Nested97> field07625 = new ArrayList<>();

   public void method03440() {
      this.field07625.clear();
   }

   public boolean method03441(double var1, double var3) {
      for (GuiClickRegions.Nested97 var6 : this.field07625) {
         if (var6.contains(var1, var3)) {
            var6.action().run();
            return true;
         }
      }

      return false;
   }

   public void method03442(float var1, float var2, float var3, float var4, Runnable var5) {
      this.field07625.add(new GuiClickRegions.Nested97(var1, var2, var3, var4, var5));
   }

   // $VF: Compiled from s
   private record Nested97(float field07626, float field07627, float field07628, float field07629, Runnable action) {
      boolean contains(double var1, double var3) {
         return GuiHitTestUtils.method05609(var1, var3, this.field07626, this.field07627, this.field07628, this.field07629);
      }
   }
}
