// Original binary: hex/api/baritone/command/ExampleBaritoneControl
package hex.api.baritone.command;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.Settings;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.command.argument.ICommandArgument;
import hex.api.baritone.api.command.exception.CommandNotEnoughArgumentsException;
import hex.api.baritone.api.command.exception.CommandNotFoundException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.command.manager.ICommandManager;
import hex.api.baritone.api.event.events.ChatEvent;
import hex.api.baritone.api.event.events.TabCompleteEvent;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.api.utils.Tuple;
import hex.api.baritone.behavior.Behavior;
import hex.api.baritone.command.argument.ArgConsumer;
import hex.api.baritone.command.argument.CommandArguments;
import hex.api.baritone.command.manager.CommandManager;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;
import net.minecraft.util.Util;
import sg.ec.ClientFeaturePolicyEvent;

// $VF: Compiled from s
public class ExampleBaritoneControl extends Behavior implements Helper {
   private static final Settings settings = BaritoneAPI.getSettings();
   private final ICommandManager manager;
   private static final String мщ = "мщ";
   private static final String Фб = "Фб";
   private static final String ФА = "ФА";
   private static final String Ф诶 = "Ф诶";
   private static final String ФЫ = "ФЫ";
   private static final String Фз = "Фз";
   private static final String ФР = "ФР";
   private static final String Фх = "Фх";
   private static final String ФЦ = "ФЦ";
   private static final String Ф9 = "Ф9";
   private static final String ФЮ = "ФЮ";
   private static final String ФO = "ФO";
   private static final String Ф弟 = "Ф弟";
   private static final String ФВ = "ФВ";


   @Override
   public void onPreTabComplete(TabCompleteEvent var1) {
      if (settings.prefixControl.value && !ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CHAT_COMMAND)) {
         String var2 = var1.prefix;
         String sx = settings.prefix.value;
         if (var2.startsWith(sx)) {
            String sxx = var2.substring(sx.length());
            var sxxx = CommandArguments.from(sxx, true);
            var sxxxx = this.tabComplete(sxx);
            if (sxxx.size() == 1) {
               sxxxx = sxxxx.map(var1x -> sx + var1x);
            }

            var1.completions = sxxxx.toArray(String[]::new);
         }
      }
   }

   @Override
   public void onSendChatMessage(ChatEvent var1) {
      String var2 = var1.getMessage();
      String sx = settings.prefix.value;
      boolean sxx = var2.startsWith(IBaritoneChatControl.FORCE_COMMAND_PREFIX);
      if (sxx || !ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CHAT_COMMAND)) {
         if (settings.prefixControl.value && var2.startsWith(sx) || sxx) {
            var1.cancel();
            String sxxx = var2.substring(sxx ? IBaritoneChatControl.FORCE_COMMAND_PREFIX.length() : sx.length());
            if (!this.runCommand(sxxx) && !sxxx.trim().isEmpty()) {
               new CommandNotFoundException(CommandManager.expand(sxxx).getA()).handle(null, null);
            }
         }
      }
   }

   public ExampleBaritoneControl(Baritone var1) {
      super(var1);
      this.manager = var1.getCommandManager();
   }

   public Stream<String> tabComplete(String var1) {
      try {
         var var2 = CommandArguments.from(var1, true);
         ArgConsumer sx = new ArgConsumer(this.manager, var2);
         if (sx.hasAtMost(2)) {
            if (sx.hasExactly(1)) {
               return new TabCompleteHelper().addCommands(this.manager).addSettings().filterPrefix(sx.getString()).stream();
            }

            var sxx = settings.byLowerName.get(sx.getString().toLowerCase(Locale.US));
            if (sxx != null && !sxx.isJavaOnly()) {
               if (sxx.getValueClass() == Boolean.class) {
                  TabCompleteHelper sxxx = new TabCompleteHelper();
                  if ((Boolean)sxx.value) {
                     sxxx.append(ФЮ, ФO);
                  } else {
                     sxxx.append(Ф弟, ФВ);
                  }

                  return sxxx.filterPrefix(sx.getString()).stream();
               }

               return Stream.of(SettingsUtil.settingValueToString(sxx));
            }
         }

         return this.manager.tabComplete(var1);
      } catch (CommandNotEnoughArgumentsException var6) {
         return Stream.empty();
      }
   }

   public boolean runCommand(String var1) {
      if (var1.trim().equalsIgnoreCase(ФА)) {
         this.logDirect(Ф诶);
         return false;
      }

      if (var1.trim().equalsIgnoreCase(ФЫ)) {
         try {
            com.mojang.blaze3d.Blaze3D.openUri(java.net.URI.create(Фз));
         } catch (Exception var9) {
         }

         return false;
      } else {
         if (var1.isEmpty()) {
            return this.runCommand(ФР);
         }

         var var2 = CommandManager.expand(var1);
         String sx = var2.getA();
         String sxx = var1.substring(var2.getA().length());
         ArgConsumer sxxx = new ArgConsumer(this.manager, var2.getB());
         if (!sxxx.hasAny()) {
            var sxxxx = settings.byLowerName.get(sx.toLowerCase(Locale.US));
            if (sxxxx != null) {
               this.logRanCommand(sx, sxx);
               if (sxxxx.getValueClass() == Boolean.class) {
                  this.manager.execute(String.format(Фх, sxxxx.getName()));
               } else {
                  this.manager.execute(String.format(ФЦ, sxxxx.getName()));
               }

               return true;
            }
         } else if (sxxx.hasExactlyOne()) {
            for (Settings.Setting sxxxx : settings.allSettings) {
               if (!sxxxx.isJavaOnly() && sxxxx.getName().equalsIgnoreCase(var2.getA())) {
                  this.logRanCommand(sx, sxx);

                  try {
                     this.manager.execute(String.format(Ф9, sxxxx.getName(), sxxx.getString()));
                  } catch (CommandNotEnoughArgumentsException var10) {
                  }

                  return true;
               }
            }
         }

         if (this.manager.getCommand(var2.getA()) != null) {
            this.logRanCommand(sx, sxx);
         }

         return this.manager.execute(var2);
      }
   }

   private void logRanCommand(String var1, String var2) {
      if (settings.echoCommands.value) {
         String var3 = var1 + var2;
         String sx = settings.censorRanCommands.value ? var1 + " ..." : var3;
         MutableComponent sxx = Component.literal(String.format(мщ, sx));
         sxx.setStyle(
            sxx.getStyle()
               .withColor(ChatFormatting.WHITE)
               .withHoverEvent(new ShowText(Component.literal(Фб)))
               .withClickEvent(new RunCommand(IBaritoneChatControl.FORCE_COMMAND_PREFIX + var3))
         );
         this.logDirect(sxx);
      }
   }
}
