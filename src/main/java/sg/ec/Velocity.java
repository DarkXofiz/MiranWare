// Original binary: sg/ec/QGwYNeY6jT68jo5V
package sg.ec;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;

// $VF: Compiled from s
public class Velocity extends ClientModule {
   private final MultiToggleSetting field11219;
   private static final String field11220 = "Выключать при условиях";
   private static final String field11221 = "На элитрах";
   private static final String field11222 = "На земле";
   private static final String field11223 = "В воздухе";
   private static final String field11224 = "В воде";
   private static final String field11225 = "Velocity";
   private static final String field11226 = "На элитрах";
   private static final String field11227 = "В воде";
   private static final String field11228 = "На земле";
   private static final String field11229 = "В воздухе";

   private boolean method05151() {
      if (mc.player == null) {
         return false;
      } else if (this.field11219.method04520(field11226) && mc.player.isFallFlying()) {
         return true;
      } else if (this.field11219.method04520(field11227) && mc.player.isInWater()) {
         return true;
      } else {
         return this.field11219.method04520(field11228) && mc.player.onGround()
            ? true
            : this.field11219.method04520(field11229) && !mc.player.onGround() && !mc.player.isInWater() && !mc.player.isFallFlying();
      }
   }

   public Velocity() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field11219 = new MultiToggleSetting(field11220)
         .method04517(NamedOption.method08077(field11221, true))
         .method04517(NamedOption.method08077(field11222, false))
         .method04517(NamedOption.method08077(field11223, false))
         .method04517(NamedOption.method08077(field11224, false))
         .method03023(this);
      this.method03935(field11225);
   }

   @Subscribe
   private void method05152(PacketEvent var1) {
      if (mc.player != null) {
         Packet var2 = var1.method10897();
         if (var1.method10904()) {
            if (var2 instanceof ClientboundSetEntityMotionPacket var3 && var3.getId() != mc.player.getId()) {
               return;
            }

            if (var2 instanceof ClientboundSetEntityMotionPacket) {
               if (this.method05151()) {
                  return;
               }

               var1.method05695(true);
            }
         }
      }
   }
}
