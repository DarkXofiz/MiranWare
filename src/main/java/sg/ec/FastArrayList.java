// Original binary: sg/ec/pWSOI0kbig2wX7f0
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.renderer.state.gui.ScreenArea;

// $VF: Compiled from s
public final class FastArrayList<E> extends ArrayList<E> {
   private static final int field22784 = 48;
   private transient RectangleOverlapIndex field22785;
   private transient int field22786;

   private static boolean method10121(ScreenRectangle var0, List<?> var1) {
      int var2 = 0;

      for (int sx = var1.size(); var2 < sx; var2++) {
         ScreenRectangle sxx = ((ScreenArea)var1.get(var2)).bounds();
         if (sxx != null && sxx.intersects(var0)) {
            return true;
         }
      }

      return false;
   }

   public static boolean method10122(ScreenRectangle var0, List<? extends ScreenArea> var1) {
      if (var1 == null) {
         return false;
      } else {
         return var1 instanceof FastArrayList var2 ? var2.method10123(var0) : method10121(var0, var1);
      }
   }

   private boolean method10123(ScreenRectangle var1) {
      int var2 = this.size();
      if (var2 < 48) {
         return method10121(var1, this);
      }

      RectangleOverlapIndex var3 = this.field22785;
      if (var3 == null) {
         var3 = new RectangleOverlapIndex();
         this.field22785 = var3;
         this.field22786 = 0;
      }

      for (int var4 = this.field22786; var4 < var2; var4++) {
         var3.method05581(((ScreenArea)this.get(var4)).bounds());
      }

      this.field22786 = var2;
      return var3.method05579(var1);
   }

   public FastArrayList(int var1) {
      super(var1);
   }

   @Override
   public void clear() {
      this.field22785 = null;
      this.field22786 = 0;
      super.clear();
   }
}
