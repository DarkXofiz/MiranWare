// Original binary: sg/ec/GBJ2FG10d7cPuPGV
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

// $VF: Compiled from s
public final class CombatTargetUtils implements MinecraftAccess {
   public static boolean method03517(Player var0, AntiBot var1) {
      return method03518(var0) && !FriendManager.INSTANCE.method00172(var0) && (var1 == null || !var1.method00605(var0));
   }

   public static boolean method03518(Player var0) {
      return var0 != mc.player && !(var0 instanceof LocalPlayer) && var0.isAlive() && !var0.isDeadOrDying() && !var0.isSpectator();
   }

   public static List<Player> method03519(float var0) {
      ArrayList var1 = new ArrayList();
      if (mc.player != null && mc.level != null) {
         AntiBot var2 = ModuleManager.INSTANCE.method08260();
         EntityExtensionAccess var3 = (EntityExtensionAccess)mc.player;

         for (Entity var5 : mc.level.entitiesForRendering()) {
            if (var5 instanceof Player var6 && method03517(var6, var2) && !(var3.getDistanceEyePos(var6) > var0)) {
               var1.add(var6);
            }
         }

         return var1;
      } else {
         return var1;
      }
   }

   public static boolean method03520(Player var0) {
      return method03517(var0, ModuleManager.INSTANCE.method08260());
   }

   public static List<Player> method03521(float var0) {
      ArrayList var1 = new ArrayList();
      if (mc.player != null && mc.level != null) {
         EntityExtensionAccess var2 = (EntityExtensionAccess)mc.player;

         for (Entity var4 : mc.level.entitiesForRendering()) {
            if (var4 instanceof Player var5 && method03518(var5) && FriendManager.INSTANCE.method00172(var5) && !(var2.getDistanceEyePos(var5) > var0)) {
               var1.add(var5);
            }
         }

         return var1;
      } else {
         return var1;
      }
   }

   private CombatTargetUtils() {
   }
}
