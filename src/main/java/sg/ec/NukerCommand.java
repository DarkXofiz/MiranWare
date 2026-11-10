// Original binary: sg/ec/teuZLX22W809mSnd
package sg.ec;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.ArrayList;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
@CommandInfo(name = "nuker", description = "")
public class NukerCommand extends AbstractCommand {
   public final ArrayList<Block> field24123 = new ArrayList<>();
   private static final String field24124 = "add";
   private static final String field24125 = "name";
   private static final String field24126 = "remove";
   private static final String field24127 = "name";
   private static final String field24128 = "list";
   private static final String field24129 = "clear";
   private static final String field24130 = "Список блоков был очищен.";
   private static final String field24131 = "Список блоков пуст.";
   private static final String field24132 = "Список блоков:";
   private static final String field24133 = "block.minecraft.";
   private static final String field24134 = "name";
   private static final String field24135 = "block.minecraft.";
   private static final String field24136 = "block.minecraft.";
   private static final String field24137 = "name";
   private static final String field24138 = "block.minecraft.";
   private static final String field24139 = "block.minecraft.";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var1.then(this.method01188(field24124).then(this.method01184(field24125, new BlockStateArgument()).executes(var1x -> {
         BlockState var2 = (BlockState)var1x.getArgument(field24137, BlockState.class);
         Block var3 = var2.getBlock();
         if (this.field24123.contains(var3)) {
            this.method01187("Блок с названием: " + var3.getDescriptionId().replace(field24138, "") + " уже добавлен.");
            return 1;
         } else {
            this.field24123.add(var3);
            this.method01187("Блок с названием: " + var3.getDescriptionId().replace(field24139, "") + " был добавлен.");
            return 1;
         }
      })));
      var1.then(this.method01188(field24126).then(this.method01184(field24127, new NukerBlockArgument()).executes(var1x -> {
         Block var2 = (Block)var1x.getArgument(field24134, Block.class);
         if (!this.field24123.contains(var2)) {
            this.method01187("Блок с названием: " + var2.getDescriptionId().replace(field24135, "") + " не найден в списке.");
            return 1;
         } else {
            this.field24123.remove(var2);
            this.method01187("Блок с названием: " + var2.getDescriptionId().replace(field24136, "") + " был удален.");
            return 1;
         }
      })));
      var1.then(this.method01188(field24128).executes(var1x -> {
         if (this.field24123.isEmpty()) {
            this.method01187(field24131);
            return 1;
         }

         this.method01187(field24132);

         for (Block var3 : this.field24123) {
            this.method01187(var3.getDescriptionId().replace(field24133, ""));
         }

         return 1;
      }));
      var1.then(this.method01188(field24129).executes(var1x -> {
         this.field24123.clear();
         this.method01187(field24130);
         return 1;
      }));
   }
}
