// Original binary: sg/ec/K5K9WMJVggUCulAd
package sg.ec;

import java.util.Collection;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class ScoreboardEntryCache {
   private int field09351;
   private int field09352 = -1;
   private Objective field09353;
   private Collection<PlayerScoreEntry> field09354;

   public void method04142() {
      this.field09351++;
   }

   public void method04143(Objective var1, CallbackInfoReturnable<Collection<PlayerScoreEntry>> var2) {
      if (this.field09354 != null && this.field09352 == this.field09351 && this.field09353 == var1) {
         var2.setReturnValue(this.field09354);
      }
   }

   public void method04144(Objective var1, Collection<PlayerScoreEntry> var2) {
      this.field09353 = var1;
      this.field09354 = var2;
      this.field09352 = this.field09351;
   }
}
