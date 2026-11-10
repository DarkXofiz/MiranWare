// Original binary: sg/ec/Kwge8zXg1nFVDtwf
package sg.ec;

import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;

// $VF: Compiled from s
public class AntiCrash extends ClientModule {
   private final ToggleSetting field09724;
   private static final String field09725 = "Уведомление";
   private static final String field09726 = "Anti Crash";
   private static final String field09727 = "Вам только-что пытались крашнуть майнкрафт!";
   private static final float field09728 = 1000.0F;
   private static final float field09729 = 1000.0F;
   private static final float field09730 = 1000.0F;
   private static final float field09731 = 1000.0F;

   @Subscribe
   private void method04334(PacketEvent var1) {
      if (var1.method10897() instanceof ClientboundLevelParticlesPacket var3) {
         int sx = var3.count();
         float sxx = var3.xDist();
         float sxxx = var3.yDist();
         float sxxxx = var3.zDist();
         float sxxxxx = Math.max(var3.xMaxSpeed(), Math.max(var3.yMaxSpeed(), var3.zMaxSpeed()));
         if (method04335(sxx, sxxx, sxxxx, sx, sxxxxx)) {
            if (this.field09724.method05999()) {
               ChatTextUtils.method05086(field09727);
               ChatTextUtils.method05086(
                  "Данные пакета: xDist: " + sxx + " yDist: " + sxxx + " zDist: " + sxxxx + " Count: " + sx + " MaxSpeed: " + sxxxxx
               );
            }

            var1.method05696();
         }
      }
   }

   private static boolean method04335(float var0, float var1, float var2, int var3, float var4) {
      return var0 > field09728 || var1 > field09729 || var2 > field09730 || var3 > 1000 || var4 > field09731;
   }

   public AntiCrash() {
      super(ModuleCategory.Misc, ModuleSubCategory.Utility);
      this.field09724 = new ToggleSetting(field09725).method03017(true).method03023(this);
      this.method03935(field09726);
   }
}
