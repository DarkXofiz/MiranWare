// Original binary: sg/ec/32vtCkNi6WzDHQef
package sg.ec;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

// $VF: Compiled from s
public class AntiBot extends ClientModule {
   private final ToggleSetting field01109;
   private static final String field01110 = "Убирать с мира";
   private static final String field01111 = "Anti Bot";

   private boolean method00601(Player var1) {
      UUID var2 = UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1.getName().getString()).getBytes(StandardCharsets.UTF_8));
      return var1.getUUID().equals(var2);
   }

   @Subscribe(1)
   private void method00602(HitResultEvent var1) {
      if (this.field01109.method05999()) {
         if (var1.method03289() == HitResultEvent.Nested91.ENTITY && var1.method03286() instanceof Player var3 && this.method00605(var3)) {
            var1.method05696();
         }
      }
   }

   @Subscribe
   private void method00603(PlayerUpdateEvent var1) {
      this.method00604();
   }

   private void method00604() {
      ClientPacketListener var1 = mc.getConnection();
      LocalPlayer var2 = mc.player;
      if (var1 != null && var2 != null) {
         boolean var3 = this.method00601(var2);

         for (Entity var5 : mc.level.entitiesForRendering()) {
            if (var5 instanceof Player var6) {
               EntityExtensionAccess var7 = (EntityExtensionAccess)var6;
               if (!var7.botEntity()) {
                  if (var6 instanceof LocalPlayer) {
                     var7.setBotEntity(true);
                  } else {
                     boolean var8 = var3 ? this.method00601(var6) : var1.getPlayerInfo(var6.getUUID()) != null;
                     if (var8) {
                        var7.setBotEntity(true);
                     }
                  }
               }
            }
         }
      }
   }

   public AntiBot() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field01109 = new ToggleSetting(field01110).method03017(false).method03023(this);
      this.method03935(field01111);
   }

   public boolean method00605(Entity var1) {
      return var1 == null ? false : this.method03937() && !((EntityExtensionAccess)var1).botEntity();
   }

   @Subscribe(1)
   private void method00606(EntityVisibilityEvent var1) {
      if (this.field01109.method05999()) {
         if (var1.method05669() instanceof Player var3 && this.method00605(var3)) {
            var1.method05672(false);
            var1.method05696();
         }
      }
   }
}
