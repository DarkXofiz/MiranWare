// Original binary: sg/ec/C5EfakzfTCWbRVzD
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.world.entity.projectile.FishingHook;

// $VF: Compiled from s
public class NoPush extends ClientModule {
   private final MultiToggleSetting field06658;
   private boolean field06659;
   private boolean field06660;
   private boolean field06661;
   private boolean field06662;
   private boolean field06663;
   private static final String field06664 = "Тип";
   private static final String field06665 = "Игроки";
   private static final String field06666 = "Блоки";
   private static final String field06667 = "Вода";
   private static final String field06668 = "Удочка";
   private static final String field06669 = "Ползанье";
   private static final String field06670 = "No Push";
   private static final String field06671 = "Вода";
   private static final String field06672 = "Блоки";
   private static final String field06673 = "Игроки";
   private static final String field06674 = "Удочка";
   private static final String field06675 = "Ползанье";

   @Subscribe
   private void method02858(PacketEvent var1) {
      if (this.field06663) {
         if (mc.level != null) {
            if (var1.method10904()
               && var1.method10897() instanceof ClientboundEntityEventPacket var2
               && var2.getEventId() == 31
               && var2.getEntity(mc.level) instanceof FishingHook sx
               && sx.getHookedIn() instanceof LocalPlayer) {
               var1.method05696();
            }
         }
      }
   }

   @Subscribe
   private void method02859(TickEvent var1) {
      this.field06659 = this.field06658.method04520(field06671);
      this.field06660 = this.field06658.method04520(field06672);
      this.field06661 = this.field06658.method04520(field06673);
      this.field06663 = this.field06658.method04520(field06674);
      this.field06662 = this.field06658.method04520(field06675);
   }

   public NoPush() {
      super(ModuleCategory.Player, ModuleSubCategory.Other);
      this.field06658 = new MultiToggleSetting(field06664)
         .method04517(NamedOption.method08077(field06665, true))
         .method04517(NamedOption.method08077(field06666, true))
         .method04517(NamedOption.method08077(field06667, false))
         .method04517(NamedOption.method08077(field06668, true))
         .method04517(NamedOption.method08077(field06669, false))
         .method03023(this);
      this.field06659 = false;
      this.field06660 = false;
      this.field06661 = false;
      this.field06662 = false;
      this.field06663 = false;
      this.method03935(field06670);
   }

   @Subscribe
   private void method02860(EntityCollisionPolicyEvent var1) {
      boolean var2 = switch (var1.method02897()) {
         case WATER -> this.field06659;
         case BLOCK -> this.field06660;
         case PLAYER -> this.field06661;
         case LIANA -> this.field06662;
      };
      if (var2) {
         var1.method05696();
      }
   }
}
