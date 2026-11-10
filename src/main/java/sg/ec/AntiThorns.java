// Original binary: sg/ec/ozVejNmncCo6KIrz
package sg.ec;

import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.world.damagesource.DamageTypes;

// $VF: Compiled from s
public class AntiThorns extends ClientModule {
   private static final long field22401 = 100L;
   private final ToggleSetting field22402;
   private volatile long field22403;
   private static final String field22404 = "Только на элитрах";
   private static final String field22405 = "Anti Thorns";
   private static final long field22406 = 100L;

   public AntiThorns() {
      super(ModuleCategory.Player, ModuleSubCategory.Other);
      this.field22402 = new ToggleSetting(field22404).method03014(false).method03023(this);
      this.method03935(field22405);
   }

   @Override
   public void method00276() {
      this.field22403 = 0L;
      super.method00276();
   }

   @Subscribe
   private void method09910(PacketEvent var1) {
      if (mc.player != null && var1.method10904()) {
         if (var1.method10897() instanceof ClientboundDamageEventPacket var4) {
            if (var4.entityId() == mc.player.getId() && var4.sourceType().is(DamageTypes.THORNS)) {
               this.field22403 = System.currentTimeMillis();
            }
         } else if (var1.method10897() instanceof ClientboundSetEntityMotionPacket var2) {
            if (var2.id() == mc.player.getId()) {
               if (!this.field22402.method03022() || mc.player.isFallFlying()) {
                  if (System.currentTimeMillis() - this.field22403 <= field22406) {
                     this.field22403 = 0L;
                     var1.method05696();
                  }
               }
            }
         }
      }
   }
}
