// Original binary: hex/api/baritone/command/defaults/ElytraCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.process.ICustomGoalProcess;
import hex.api.baritone.api.process.IElytraProcess;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;

// $VF: Compiled from s
public class ElytraCommand extends Command {
   private static final long OLD_2B2T_SEED = -4100785268875389365L;
   private static final long NEW_2B2T_SEED = 146008555100680L;
   private static final String АЦч = "АЦч";
   private static final String АЦ衣 = "АЦ衣";
   private static final String АЦц = "АЦц";
   private static final String АЦМ = "АЦМ";
   private static final String АЦ5 = "АЦ5";
   private static final String АЦЖ = "АЦЖ";
   private static final String АЦо = "АЦо";
   private static final String АЦК = "АЦК";
   private static final String АЦЭ = "АЦЭ";
   private static final long АЦЪ = 0;
   private static final long АЦЧ = 0;
   private static final String АЦЩ = "АЦЩ";
   private static final String АЦм = "АЦм";
   private static final String АЦФ = "АЦФ";
   private static final String АЦ3 = "АЦ3";
   private static final String АЦЬ = "АЦЬ";
   private static final String АЦ1 = "АЦ1";
   private static final String АЦя = "АЦя";
   private static final String АЦI = "АЦI";
   private static final String АЦы = "АЦы";
   private static final String АЦу = "АЦу";
   private static final String АЦг = "АЦг";
   private static final String АЦю = "АЦю";
   private static final String АЦ4 = "АЦ4";
   private static final String АЦС = "АЦС";
   private static final String АЦъ = "АЦъ";
   private static final String АЦБ = "АЦБ";
   private static final String АЦв = "АЦв";
   private static final String АЦр = "АЦр";
   private static final long АЦй = 0;
   private static final String АЦк = "АЦк";
   private static final long АЦп = 0;
   private static final String АЦ2 = "АЦ2";
   private static final String АЦ西 = "АЦ西";
   private static final long АЦт = 0;
   private static final long АЦд = 0;
   private static final String АЦе = "АЦе";
   private static final String АЦ6 = "АЦ6";
   private static final String АЦl = "АЦl";
   private static final String АЦ必 = "АЦ必";
   private static final String АЦЗ = "АЦЗ";
   private static final String АЦн = "АЦн";
   private static final String АЦД = "АЦД";
   private static final String АЦН = "АЦН";
   private static final String АЦш = "АЦш";
   private static final String АЦл = "АЦл";
   private static final String АЦи = "АЦи";
   private static final String АЦщ = "АЦщ";
   private static final String А9б = "А9б";
   private static final String А9А = "А9А";
   private static final String А9诶 = "А9诶";

   private void warn2b2t() {
      if (Baritone.settings().elytraPredictTerrain.value) {
         long var1 = Baritone.settings().elytraNetherSeed.value;
         if (var1 != АЦЪ && var1 != АЦЧ) {
            this.logDirect(Component.literal(АЦЩ));
            this.logDirect(this.suggest2b2tSeeds());
         }
      }
   }

   private void gatekeep() {
      MutableComponent var1 = Component.literal("");
      var1.append(АЦI);
      var1.append(АЦы);
      MutableComponent sx = Component.literal(АЦу);
      sx.setStyle(sx.getStyle().withHoverEvent(new ShowText(Component.literal(Baritone.settings().prefix.value + "set elytraAutoJump true"))));
      var1.append(sx);
      MutableComponent sxx = Component.literal(АЦг);
      sxx.setStyle(
         sxx.getStyle()
            .withHoverEvent(
               new ShowText(
                  Component.literal(
                     Baritone.settings().prefix.value
                        + "set elytraConserveFireworks true\n"
                        + Baritone.settings().prefix.value
                        + "set elytraFireworkSpeed 0.6\n(the 0.6 number is just an example, tweak to your liking)"
                  )
               )
            )
      );
      var1.append(sxx);
      MutableComponent sxxx = Component.literal(АЦю);
      MutableComponent sxxxx = Component.literal(АЦ4);
      sxxxx.setStyle(sxxxx.getStyle().withColor(ChatFormatting.RED).withUnderlined(true).withBold(true));
      sxxx.append(sxxxx);
      sxxx.append(АЦС);
      MutableComponent sxxxxx = Component.literal(АЦъ);
      sxxxxx.setStyle(sxxxxx.getStyle().withColor(ChatFormatting.RED).withUnderlined(true).withBold(true));
      sxxx.append(sxxxxx);
      sxxx.append(АЦБ);
      var1.append(sxxx);
      var1.append(АЦв);
      if (this.detectOn2b2t()) {
         MutableComponent sxxxxxx = Component.literal(АЦр);
         sxxxxxx.append(this.suggest2b2tSeeds());
         if (!Baritone.settings().elytraPredictTerrain.value) {
            sxxxxxx.append(Baritone.settings().prefix.value + "elytraPredictTerrain is currently disabled. ");
         } else if (Baritone.settings().elytraNetherSeed.value == АЦй) {
            sxxxxxx.append(АЦк);
         } else if (Baritone.settings().elytraNetherSeed.value == АЦп) {
            sxxxxxx.append(АЦ2);
         } else {
            sxxxxxx.append(АЦ西);
            Baritone.settings().elytraNetherSeed.value = АЦт;
         }

         var1.append(sxxxxxx);
      } else if (Baritone.settings().elytraNetherSeed.value == АЦд) {
         MutableComponent sxxxxxx = Component.literal(
            "Baritone doesn't know the seed of your world. Set it with: " + Baritone.settings().prefix.value + "set elytraNetherSeed seedgoeshere\n"
         );
         sxxxxxx.append(АЦе);
         var1.append(sxxxxxx);
         Baritone.settings().elytraPredictTerrain.value = false;
      } else if (Baritone.settings().elytraPredictTerrain.value) {
         MutableComponent sxxxxxx = Component.literal(
            "Baritone Elytra is predicting terrain assuming that "
               + Baritone.settings().elytraNetherSeed.value
               + " is the correct seed. Change that with "
               + Baritone.settings().prefix.value
               + "set elytraNetherSeed seedgoeshere, or disable it with "
               + Baritone.settings().prefix.value
               + "set elytraPredictTerrain false"
         );
         var1.append(sxxxxxx);
      } else {
         MutableComponent sxxxxxx = Component.literal(
            "Baritone Elytra is not predicting terrain. If you don't know the seed, this is the correct thing to do. If you do know the seed, input it with "
               + Baritone.settings().prefix.value
               + "set elytraNetherSeed seedgoeshere, and then enable it with "
               + Baritone.settings().prefix.value
               + "set elytraPredictTerrain true"
         );
         var1.append(sxxxxxx);
      }

      this.logDirect(var1);
   }

   private static String unsupportedSystemMessage() {
      String var0 = System.getProperty(А9б);
      String sx = System.getProperty(А9А);
      return String.format(А9诶, var0, sx);
   }

   @Override
   public String getShortDesc() {
      return АЦн;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      TabCompleteHelper var3 = new TabCompleteHelper();
      if (var2.hasExactlyOne()) {
         var3.append(АЦl, АЦ必, АЦЗ);
      }

      return var3.filterPrefix(var2.getString()).stream();
   }

   private boolean detectOn2b2t() {
      ServerData var1 = this.ctx.minecraft().getCurrentServer();
      return var1 != null && var1.ip.toLowerCase().contains(АЦ6);
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(АЦД, "", АЦН, АЦш, АЦл, АЦи, АЦщ);
   }

   private Component suggest2b2tSeeds() {
      MutableComponent var1 = Component.literal("");
      var1.append(АЦм);
      var1.append(АЦФ);
      MutableComponent sx = Component.literal(АЦ3);
      sx.setStyle(
         sx.getStyle()
            .withUnderlined(true)
            .withBold(true)
            .withHoverEvent(new ShowText(Component.literal(Baritone.settings().prefix.value + "set elytraNetherSeed -4100785268875389365")))
            .withClickEvent(new RunCommand(IBaritoneChatControl.FORCE_COMMAND_PREFIX + "set elytraNetherSeed -4100785268875389365"))
      );
      var1.append(sx);
      var1.append(АЦЬ);
      MutableComponent sxx = Component.literal(АЦ1);
      sxx.setStyle(
         sxx.getStyle()
            .withUnderlined(true)
            .withBold(true)
            .withHoverEvent(new ShowText(Component.literal(Baritone.settings().prefix.value + "set elytraNetherSeed 146008555100680")))
            .withClickEvent(new RunCommand(IBaritoneChatControl.FORCE_COMMAND_PREFIX + "set elytraNetherSeed 146008555100680"))
      );
      var1.append(sxx);
      var1.append(АЦя);
      return var1;
   }

   public ElytraCommand(IBaritone var1) {
      super(var1, АЦч);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      ICustomGoalProcess var3 = this.baritone.getCustomGoalProcess();
      IElytraProcess sx = this.baritone.getElytraProcess();
      if (var2.hasExactlyOne() && var2.peekString().equals(АЦ衣)) {
         this.logDirect(sx.isLoaded() ? АЦц : unsupportedSystemMessage());
      } else {
         if (!sx.isLoaded()) {
            throw new CommandInvalidStateException(unsupportedSystemMessage());
         }

         if (!var2.hasAny()) {
            if (Baritone.settings().elytraTermsAccepted.value) {
               if (this.detectOn2b2t()) {
                  this.warn2b2t();
               }
            } else {
               this.gatekeep();
            }

            Goal sxx = var3.mostRecentGoal();
            if (sxx == null) {
               throw new CommandInvalidStateException(АЦМ);
            }

            try {
               sx.pathTo(sxx);
            } catch (IllegalArgumentException sxxx) {
               throw new CommandInvalidStateException(sxxx.getMessage());
            }
         } else {
            String sxx = var2.getString();
            switch (sxx) {
               case АЦ5:
                  try {
                     sx.resetState();
                  } catch (IllegalArgumentException sxxx) {
                     throw new CommandInvalidStateException(sxxx.getMessage());
                  }

                  this.logDirect(АЦо);
                  break;
               case АЦЖ:
                  sx.repackChunks();
                  this.logDirect(АЦК);
                  break;
               default:
                  throw new CommandInvalidStateException(АЦЭ);
            }
         }
      }
   }

}
