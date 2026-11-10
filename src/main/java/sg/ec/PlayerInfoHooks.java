// Original binary: sg/ec/VkeplNFhTSHFSQhm
package sg.ec;

import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameType;
import net.minecraft.world.scores.PlayerTeam;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class PlayerInfoHooks {
   private Component field12728;
   private Component field12729;
   private PlayerTeam field12730;
   private GameType field12731;
   private int field12732 = -1;
   private int field12733 = -1;

   public void method05956(PlayerInfo var1, Component var2) {
      Component var3 = var1.getTabListDisplayName();
      this.field12728 = var2;
      this.field12729 = var3;
      this.field12731 = var1.getGameMode();
      this.field12732 = TextCacheInvalidator.field17747;
      this.field12730 = var3 == null ? var1.getTeam() : null;
      this.field12733 = ScoreboardHooks.field18114;
   }

   public void method05957(PlayerInfo var1, CallbackInfoReturnable<Component> var2) {
      if (this.field12728 != null) {
         Component var3 = var1.getTabListDisplayName();
         if (this.field12729 == var3 && this.field12731 == var1.getGameMode() && this.field12732 == TextCacheInvalidator.field17747) {
            if (var3 != null || this.field12733 == ScoreboardHooks.field18114 && this.field12730 == var1.getTeam()) {
               var2.setReturnValue(this.field12728);
            }
         }
      }
   }
}
