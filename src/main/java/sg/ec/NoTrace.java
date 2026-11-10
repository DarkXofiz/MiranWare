// Original binary: sg/ec/weSboUnnuBLIwGDd
package sg.ec;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public class NoTrace extends ClientModule {
   private final MultiToggleSetting field25204;
   private static final String field25205 = "Mode";
   private static final String field25206 = "Entity";
   private static final String field25207 = "Block";
   private static final String field25208 = "No Trace";
   private static final String field25209 = "Entity";
   private static final String field25210 = "Block";

   public NoTrace() {
      super(ModuleCategory.Player, ModuleSubCategory.Other);
      this.field25204 = new MultiToggleSetting(field25205)
         .method04517(NamedOption.method08077(field25206, true))
         .method04517(NamedOption.method08077(field25207, false))
         .method03023(this);
      this.method03935(field25208);
   }

   @Subscribe(4)
   private void method11204(HitResultEvent var1) {
      if (var1.method03289() == HitResultEvent.Nested91.ENTITY) {
         if (this.field25204.method04520(field25209) && var1.method03286() instanceof Player) {
            var1.method05695(true);
         }
      } else {
         if (var1.method03289() == HitResultEvent.Nested91.BLOCK) {
            if (!this.field25204.method04520(field25210)) {
               return;
            }

            if (var1.method03283() == null) {
               return;
            }

            Block var2 = var1.method03283().getBlock();
            if (CommandManager.INSTANCE.method04650(NotraceCommand.class).field18407.contains(var2)) {
               var1.method05695(true);
            }
         }
      }
   }
}
