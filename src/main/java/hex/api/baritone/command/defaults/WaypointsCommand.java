// Original binary: hex/api/baritone/command/defaults/WaypointsCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.cache.IWaypoint;
import hex.api.baritone.api.cache.IWorldData;
import hex.api.baritone.api.cache.Waypoint;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.ForWaypoints;
import hex.api.baritone.api.command.datatypes.RelativeBlockPos;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.command.exception.CommandInvalidTypeException;
import hex.api.baritone.api.command.helpers.Paginator;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.ClickEvent.SuggestCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;

// $VF: Compiled from s
public class WaypointsCommand extends Command {
   private Map<IWorldData, List<IWaypoint>> deletedWaypoints = new HashMap<>();
   private static final String бяД = "бяД";
   private static final String бяН = "бяН";
   private static final String бяш = "бяш";
   private static final String бял = "бял";
   private static final String бяи = "бяи";
   private static final String бящ = "бящ";
   private static final String бIб = "бIб";
   private static final String бIА = "бIА";
   private static final String бI诶 = "бI诶";
   private static final String бIЫ = "бIЫ";
   private static final String бIз = "бIз";
   private static final String бIР = "бIР";
   private static final String бIх = "бIх";
   private static final String бIЦ = "бIЦ";
   private static final String бI9 = "бI9";
   private static final String бIЮ = "бIЮ";
   private static final String бIO = "бIO";
   private static final String бI弟 = "бI弟";
   private static final String бIВ = "бIВ";
   private static final String бIж = "бIж";
   private static final String бI8 = "бI8";
   private static final String бIТ = "бIТ";
   private static final String бIЙ = "бIЙ";
   private static final String бIэ = "бIэ";
   private static final String бIО = "бIО";
   private static final String бIИ = "бIИ";
   private static final String бIП = "бIП";
   private static final String бI_ = "бI_";
   private static final String бIс = "бIс";
   private static final String бIЛ = "бIЛ";
   private static final String бIь = "бIь";
   private static final String бIЯ = "бIЯ";
   private static final String бIХ = "бIХ";
   private static final String бIШ = "бIШ";
   private static final String бIа = "бIа";
   private static final String бI7 = "бI7";
   private static final String бIУ = "бIУ";
   private static final String бI0 = "бI0";
   private static final String бIГ = "бIГ";
   private static final String бIф = "бIф";
   private static final String бIЕ = "бIЕ";
   private static final String бIч = "бIч";
   private static final String бI衣 = "бI衣";
   private static final String бIц = "бIц";
   private static final String бIМ = "бIМ";
   private static final String бI5 = "бI5";
   private static final String бIЖ = "бIЖ";
   private static final String бIо = "бIо";
   private static final String бIК = "бIК";
   private static final String бIЭ = "бIЭ";
   private static final String бIЪ = "бIЪ";
   private static final String бIЧ = "бIЧ";

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      WaypointsCommand.Action var3 = var2.hasAny() ? WaypointsCommand.Action.getByName(var2.getString()) : WaypointsCommand.Action.LIST;
      if (var3 == null) {
         throw new CommandInvalidTypeException(var2.consumed(), бял);
      }

      BiFunction<IWaypoint, WaypointsCommand.Action, Component> sx = (var1x, var2x) -> {
         MutableComponent comp = Component.literal("");
         MutableComponent tagC = Component.literal(var1x.getTag().name() + " ");
         tagC.setStyle(tagC.getStyle().withColor(ChatFormatting.GRAY));
         String nm = var1x.getName();
         MutableComponent sxxx = Component.literal(!nm.isEmpty() ? nm : бIЭ);
         sxxx.setStyle(sxxx.getStyle().withColor(!nm.isEmpty() ? ChatFormatting.GRAY : ChatFormatting.DARK_GRAY));
         MutableComponent sxxxx = Component.literal(" @ " + new Date(var1x.getCreationTimestamp()));
         sxxxx.setStyle(sxxxx.getStyle().withColor(ChatFormatting.DARK_GRAY));
         comp.append(tagC);
         comp.append(sxxx);
         comp.append(sxxxx);
         comp.setStyle(
            comp.getStyle()
               .withHoverEvent(new ShowText(Component.literal(бIЪ)))
               .withClickEvent(
                  new RunCommand(
                     String.format(бIЧ, IBaritoneChatControl.FORCE_COMMAND_PREFIX, var1, var2x.names[0], var1x.getTag().getName(), var1x.getCreationTimestamp())
                  )
               )
         );
         return comp;
      };
      Function<IWaypoint, Component> sxx = var2x -> sx.apply(var2x, var3 == WaypointsCommand.Action.LIST ? WaypointsCommand.Action.INFO : var3);
      if (var3 == WaypointsCommand.Action.LIST) {
         IWaypoint.Tag sxxx = var2.hasAny() ? IWaypoint.Tag.getByName(var2.peekString()) : null;
         if (sxxx != null) {
            var2.get();
         }

         IWaypoint[] sxxxx = sxxx != null ? ForWaypoints.getWaypointsByTag(this.baritone, sxxx) : ForWaypoints.getWaypoints(this.baritone);
         if (sxxxx.length <= 0) {
            var2.requireMax(0);
            throw new CommandInvalidStateException(sxxx != null ? бящ : бIб);
         }

         var2.requireMax(1);
         Paginator.paginate(
            var2,
            sxxxx,
            () -> this.logDirect(sxxx != null ? String.format(бIо, sxxx.name()) : бIК),
            sxx,
            String.format(бяи, IBaritoneChatControl.FORCE_COMMAND_PREFIX, var1, var3.names[0], sxxx != null ? " " + sxxx.getName() : "")
         );
      } else if (var3 == WaypointsCommand.Action.SAVE) {
         IWaypoint.Tag sxxx = var2.hasAny() ? IWaypoint.Tag.getByName(var2.peekString()) : null;
         if (sxxx == null) {
            sxxx = IWaypoint.Tag.USER;
         } else {
            var2.get();
         }

         String sxxxx = !var2.hasExactlyOne() && !var2.hasExactly(4) ? "" : var2.getString();
         BetterBlockPos sxxxxx = var2.hasAny() ? var2.getDatatypePost(RelativeBlockPos.INSTANCE, this.ctx.playerFeet()) : this.ctx.playerFeet();
         var2.requireMax(0);
         IWaypoint sxxxxxx = new Waypoint(sxxxx, sxxx, sxxxxx);
         ForWaypoints.waypoints(this.baritone).addWaypoint(sxxxxxx);
         MutableComponent sxxxxxxx = Component.literal(бIА);
         sxxxxxxx.setStyle(sxxxxxxx.getStyle().withColor(ChatFormatting.GRAY));
         sxxxxxxx.append(sx.apply(sxxxxxx, WaypointsCommand.Action.INFO));
         this.logDirect(sxxxxxxx);
      } else if (var3 == WaypointsCommand.Action.CLEAR) {
         var2.requireMax(1);
         String sxxx = var2.getString();
         IWaypoint.Tag sxxxx = IWaypoint.Tag.getByName(sxxx);
         if (sxxxx == null) {
            throw new CommandInvalidStateException("Invalid tag, \"" + sxxx + "\"");
         }

         IWaypoint[] sxxxxx = ForWaypoints.getWaypointsByTag(this.baritone, sxxxx);

         for (IWaypoint sxxxxxx : sxxxxx) {
            ForWaypoints.waypoints(this.baritone).removeWaypoint(sxxxxxx);
         }

         this.deletedWaypoints.computeIfAbsent(this.baritone.getWorldProvider().getCurrentWorld(), var0 -> new ArrayList<>()).addAll(Arrays.asList(sxxxxx));
         MutableComponent sxxxxxx = Component.literal(String.format(бI诶, sxxxxx.length));
         sxxxxxx.setStyle(
            sxxxxxx.getStyle()
               .withClickEvent(
                  new RunCommand(
                     String.format(
                        бIЫ,
                        IBaritoneChatControl.FORCE_COMMAND_PREFIX,
                        var1,
                        Stream.of(sxxxxx).map(var0 -> Long.toString(var0.getCreationTimestamp())).collect(Collectors.joining(бIз))
                     )
                  )
               )
         );
         this.logDirect(sxxxxxx);
      } else if (var3 == WaypointsCommand.Action.RESTORE) {
         List<IWaypoint> sxxx = new ArrayList<>();
         var sxxxx = this.deletedWaypoints.getOrDefault(this.baritone.getWorldProvider().getCurrentWorld(), Collections.emptyList());
         if (!var2.peekString().equals(бIР)) {
            var2.requireExactly(1);
            int sxxxxx = sxxxx.size();
            int sxxxxxx = Math.min(sxxxxx, var2.getAs(Integer.class));
            sxxx = new ArrayList<>(sxxxx.subList(sxxxxx - sxxxxxx, sxxxxx));
         } else {
            var2.get();

            while (var2.hasAny()) {
               long sxxxxx = var2.getAs(Long.class);

               for (IWaypoint sxxxxxx : sxxxx) {
                  if (sxxxxxx.getCreationTimestamp() == sxxxxx) {
                     sxxx.add(sxxxxxx);
                     break;
                  }
               }
            }
         }

         sxxx.forEach(ForWaypoints.waypoints(this.baritone)::addWaypoint);
         sxxxx.removeIf(sxxx::contains);
         this.logDirect(String.format(бIх, sxxx.size()));
      } else {
         IWaypoint[] sxxx = var2.getDatatypeFor(ForWaypoints.INSTANCE);
         IWaypoint sxxxx = null;
         if (var2.hasAny() && var2.peekString().equals(бIЦ)) {
            var2.requireExactly(2);
            var2.get();
            long sxxxxx = var2.getAs(Long.class);

            for (IWaypoint sxxxxxx : sxxx) {
               if (sxxxxxx.getCreationTimestamp() == sxxxxx) {
                  sxxxx = sxxxxxx;
                  break;
               }
            }

            if (sxxxx == null) {
               throw new CommandInvalidStateException(бI9);
            }
         } else {
            switch (sxxx.length) {
               case 0:
                  throw new CommandInvalidStateException(бIЮ);
               case 1:
                  sxxxx = sxxx[0];
            }
         }

         if (sxxxx == null) {
            var2.requireMax(1);
            Paginator.paginate(
               var2,
               sxxx,
               () -> this.logDirect(бIЖ),
               sxx,
               String.format(бIO, IBaritoneChatControl.FORCE_COMMAND_PREFIX, var1, var3.names[0], var2.consumedString())
            );
         } else if (var3 == WaypointsCommand.Action.INFO) {
            this.logDirect(sxx.apply(sxxxx));
            this.logDirect(String.format(бI弟, sxxxx.getLocation()));
            MutableComponent sxxxxx = Component.literal(бIВ);
            sxxxxx.setStyle(
               sxxxxx.getStyle()
                  .withClickEvent(
                     new RunCommand(String.format(бIж, IBaritoneChatControl.FORCE_COMMAND_PREFIX, var1, sxxxx.getTag().getName(), sxxxx.getCreationTimestamp()))
                  )
            );
            MutableComponent sxxxxxx = Component.literal(бI8);
            sxxxxxx.setStyle(
               sxxxxxx.getStyle()
                  .withClickEvent(
                     new RunCommand(String.format(бIТ, IBaritoneChatControl.FORCE_COMMAND_PREFIX, var1, sxxxx.getTag().getName(), sxxxx.getCreationTimestamp()))
                  )
            );
            MutableComponent sxxxxxxx = Component.literal(бIЙ);
            sxxxxxxx.setStyle(
               sxxxxxxx.getStyle()
                  .withClickEvent(
                     new SuggestCommand(
                        String.format(
                           бIэ,
                           Baritone.settings().prefix.value,
                           var1,
                           sxxxx.getTag().getName(),
                           sxxxx.getName(),
                           sxxxx.getLocation().x,
                           sxxxx.getLocation().y,
                           sxxxx.getLocation().z
                        )
                     )
                  )
            );
            MutableComponent sxxxxxxxx = Component.literal(бIО);
            sxxxxxxxx.setStyle(sxxxxxxxx.getStyle().withClickEvent(new RunCommand(String.format(бIИ, IBaritoneChatControl.FORCE_COMMAND_PREFIX, var1))));
            this.logDirect(sxxxxx);
            this.logDirect(sxxxxxx);
            this.logDirect(sxxxxxxx);
            this.logDirect(sxxxxxxxx);
         } else if (var3 == WaypointsCommand.Action.DELETE) {
            ForWaypoints.waypoints(this.baritone).removeWaypoint(sxxxx);
            this.deletedWaypoints.computeIfAbsent(this.baritone.getWorldProvider().getCurrentWorld(), var0 -> new ArrayList<>()).add(sxxxx);
            MutableComponent sxxxxx = Component.literal(бIП);
            sxxxxx.setStyle(
               sxxxxx.getStyle()
                  .withClickEvent(new RunCommand(String.format(бI_, IBaritoneChatControl.FORCE_COMMAND_PREFIX, var1, sxxxx.getCreationTimestamp())))
            );
            this.logDirect(sxxxxx);
         } else if (var3 == WaypointsCommand.Action.GOAL) {
            Goal sxxxxx = new GoalBlock(sxxxx.getLocation());
            this.baritone.getCustomGoalProcess().setGoal(sxxxxx);
            this.logDirect(String.format(бIс, sxxxxx));
         } else if (var3 == WaypointsCommand.Action.GOTO) {
            Goal sxxxxx = new GoalBlock(sxxxx.getLocation());
            this.baritone.getCustomGoalProcess().setGoalAndPath(sxxxxx);
            this.logDirect(String.format(бIЛ, sxxxxx));
         }
      }
   }

   @Override
   public String getShortDesc() {
      return бIь;
   }


   public WaypointsCommand(IBaritone var1) {
      super(var1, бяД, бяН, бяш);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      if (var2.hasAny()) {
         if (var2.hasExactlyOne()) {
            return new TabCompleteHelper().append(WaypointsCommand.Action.getAllNames()).sortAlphabetically().filterPrefix(var2.getString()).stream();
         }

         WaypointsCommand.Action var3 = WaypointsCommand.Action.getByName(var2.getString());
         if (var2.hasExactlyOne()) {
            if (var3 != WaypointsCommand.Action.LIST && var3 != WaypointsCommand.Action.SAVE && var3 != WaypointsCommand.Action.CLEAR) {
               if (var3 == WaypointsCommand.Action.RESTORE) {
                  return Stream.empty();
               }

               return var2.tabCompleteDatatype(ForWaypoints.INSTANCE);
            }

            return new TabCompleteHelper().append(IWaypoint.Tag.getAllNames()).sortAlphabetically().filterPrefix(var2.getString()).stream();
         }

         if (var2.has(3) && var3 == WaypointsCommand.Action.SAVE) {
            var2.get();
            var2.get();
            return var2.tabCompleteDatatype(RelativeBlockPos.INSTANCE);
         }
      }

      return Stream.empty();
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(бIЯ, "", бIХ, "", бIШ, "", бIа, "", бI7, бIУ, бI0, бIГ, бIф, бIЕ, бIч, бI衣, бIц, бIМ, бI5);
   }

   // $VF: Compiled from s
   private enum Action {
      LIST("list", "get", "l"),
      CLEAR("clear", "c"),
      SAVE("save", "s"),
      INFO("info", "show", "i"),
      DELETE("delete", "d"),
      RESTORE("restore"),
      GOAL("goal", "g"),
      GOTO("goto");

      private final String[] names;

      Action(String... var3) {
         this.names = var3;
      }

      public static WaypointsCommand.Action getByName(String var0) {
         for (WaypointsCommand.Action var4 : values()) {
            for (String sx : var4.names) {
               if (sx.equalsIgnoreCase(var0)) {
                  return var4;
               }
            }
         }

         return null;
      }

      public static String[] getAllNames() {
         Set var0 = new HashSet<>();

         for (WaypointsCommand.Action sx : values()) {
            var0.addAll(Arrays.asList(sx.names));
         }

         return (String[]) var0.toArray(new String[0]);
      }
   }
}
