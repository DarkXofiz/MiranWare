// Original binary: hex/api/baritone/command/defaults/HelpCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.command.ICommand;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandNotFoundException;
import hex.api.baritone.api.command.helpers.Paginator;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;

// $VF: Compiled from s
public class HelpCommand extends Command {
   private static final String а0 = "а0";
   private static final String аГ = "аГ";
   private static final String аф = "аф";
   private static final String аЕ = "аЕ";
   private static final String ач = "ач";
   private static final String а衣 = "а衣";
   private static final String ац = "ац";
   private static final String аМ = "аМ";
   private static final String а5 = "а5";
   private static final String аЖ = "аЖ";
   private static final String ао = "ао";
   private static final String аК = "аК";
   private static final String аЭ = "аЭ";
   private static final String аЪ = "аЪ";

   public HelpCommand(IBaritone var1) {
      super(var1, а0, аГ);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      return var2.hasExactlyOne()
         ? new TabCompleteHelper().addCommands(this.baritone.getCommandManager()).filterPrefix(var2.getString()).stream()
         : Stream.empty();
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(ац, "", аМ, а5, аЖ);
   }


   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(1);
      if (var2.hasAny() && !var2.is(Integer.class)) {
         String var3 = var2.getString().toLowerCase();
         ICommand sx = this.baritone.getCommandManager().getCommand(var3);
         if (sx == null) {
            throw new CommandNotFoundException(var3);
         }

         this.logDirect(String.format(аф, String.join(аЕ, sx.getNames()), sx.getShortDesc()));
         this.logDirect("");
         sx.getLongDesc().forEach(this::logDirect);
         this.logDirect("");
         MutableComponent sxx = Component.literal(ач);
         sxx.setStyle(sxx.getStyle().withClickEvent(new RunCommand(IBaritoneChatControl.FORCE_COMMAND_PREFIX + var1)));
         this.logDirect(sxx);
      } else {
         Paginator.paginate(
            var2,
            new Paginator<>(
               this.baritone.getCommandManager().getRegistry().descendingStream().filter(var0 -> !var0.hiddenFromHelp()).collect(Collectors.toList())
            ),
            () -> this.logDirect(аЪ),
            var1x -> {
               String names = String.join(ао, var1x.getNames());
               String sx = var1x.getNames().get(0);
               MutableComponent sxx = Component.literal(" - " + var1x.getShortDesc());
               sxx.setStyle(sxx.getStyle().withColor(ChatFormatting.DARK_GRAY));
               MutableComponent sxxx = Component.literal(names);
               sxxx.setStyle(sxxx.getStyle().withColor(ChatFormatting.WHITE));
               MutableComponent sxxxx = Component.literal("");
               sxxxx.setStyle(sxxxx.getStyle().withColor(ChatFormatting.GRAY));
               sxxxx.append(sxxx);
               sxxxx.append("\n" + var1x.getShortDesc());
               sxxxx.append(аК);
               String sxxxxx = IBaritoneChatControl.FORCE_COMMAND_PREFIX + String.format(аЭ, var1, var1x.getNames().get(0));
               MutableComponent sxxxxxx = Component.literal(sx);
               sxxxxxx.setStyle(sxxxxxx.getStyle().withColor(ChatFormatting.GRAY));
               sxxxxxx.append(sxx);
               sxxxxxx.setStyle(sxxxxxx.getStyle().withHoverEvent(new ShowText(sxxxx)).withClickEvent(new RunCommand(sxxxxx)));
               return sxxxxxx;
            },
            IBaritoneChatControl.FORCE_COMMAND_PREFIX + var1
         );
      }
   }

   @Override
   public String getShortDesc() {
      return а衣;
   }
}
