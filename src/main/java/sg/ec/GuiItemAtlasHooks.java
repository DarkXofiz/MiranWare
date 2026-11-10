// Original binary: sg/ec/WQQOT3OXRVUD3QXx
package sg.ec;

import net.minecraft.client.Minecraft;

// $VF: Compiled from s
public final class GuiItemAtlasHooks {
   private static long field13680 = GuiItemAtlasHooks.field13687;
   private static long field13681;
   private final long field13682;
   private long field13683;
   private static final long field13684 = 1000000000L;
   private static final long field13685 = 1000000000L;
   private static final long field13686 = 1000000000L;
   private static final long field13687 = 16666666L;

   public GuiItemAtlasHooks(int var1) {
      this.field13682 = var1 > 0 ? field13684 / var1 : 0L;
   }

   public boolean method06043() {
      long var1 = System.nanoTime();
      long var3 = Math.max(this.field13682, method06044(var1));
      if (var1 < this.field13683) {
         return false;
      }

      this.field13683 += var3;
      if (var1 >= this.field13683) {
         this.field13683 = var1 + var3;
      }

      return true;
   }

   public GuiItemAtlasHooks() {
      this(0);
   }

   private static long method06044(long var0) {
      if (var0 >= field13681) {
         int var2 = Minecraft.getInstance().getWindow().getPreferredFullscreenVideoMode().map(m -> (int) m.getRefreshRate()).orElse(60);
         if (var2 <= 0) {
            var2 = 60;
         }

         field13680 = field13685 / var2;
         field13681 = var0 + field13686;
      }

      return field13680;
   }
}
