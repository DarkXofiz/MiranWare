// Original binary: hex/api/baritone/command/defaults/FindCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.BlockById;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.cache.CachedChunk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public class FindCommand extends Command {
   private static final String 诶弟_ = "诶弟_";
   private static final String 诶弟с = "诶弟с";
   private static final String 诶弟Л = "诶弟Л";
   private static final String 诶弟ь = "诶弟ь";
   private static final String 诶弟Я = "诶弟Я";
   private static final String 诶弟Х = "诶弟Х";
   private static final String 诶弟Ш = "诶弟Ш";
   private static final String 诶弟а = "诶弟а";
   private static final String 诶弟7 = "诶弟7";
   private static final String 诶弟У = "诶弟У";
   private static final int 诶弟0 = 0;


   private Component positionToComponent(BetterBlockPos var1) {
      String var2 = String.format(诶弟Л, var1.x, var1.y, var1.z);
      String sx = String.format(诶弟ь, IBaritoneChatControl.FORCE_COMMAND_PREFIX, var2);
      MutableComponent sxx = Component.literal(var1.toString());
      MutableComponent sxxx = Component.literal(诶弟Я);
      sxx.setStyle(sxx.getStyle().withColor(ChatFormatting.GRAY).withInsertion(var2).withClickEvent(new RunCommand(sx)).withHoverEvent(new ShowText(sxxx)));
      return sxx;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      return new TabCompleteHelper()
         .append(CachedChunk.BLOCKS_TO_KEEP_TRACK_OF.stream().map(BuiltInRegistries.BLOCK::getKey).map(Object::toString))
         .filterPrefixNamespaced(var2.getString())
         .sortAlphabetically()
         .stream();
   }

   public FindCommand(IBaritone var1) {
      super(var1, 诶弟_);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMin(1);
      List<Block> var3 = new ArrayList<>();

      while (var2.hasAny()) {
         var3.add(var2.getDatatypeFor(BlockById.INSTANCE));
      }

      BetterBlockPos sx = this.ctx.playerFeet();
      Component[] sxx = var3.stream()
         .flatMap(
            var2x -> this.ctx.worldData().getCachedWorld().getLocationsOf(BuiltInRegistries.BLOCK.getKey(var2x).getPath(), 诶弟0, sx.x, sx.y, 4).stream()
         )
         .map(BetterBlockPos::new)
         .map(this::positionToComponent)
         .toArray(Component[]::new);
      if (sxx.length > 0) {
         var var10000 = Arrays.asList(sxx);
         FindCommand var6 = this;
         var10000.forEach(var1x -> var6.logDirect(var1x));
      } else {
         this.logDirect(诶弟с);
      }
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(诶弟Ш, 诶弟а, "", 诶弟7, 诶弟У);
   }

   @Override
   public String getShortDesc() {
      return 诶弟Х;
   }
}
