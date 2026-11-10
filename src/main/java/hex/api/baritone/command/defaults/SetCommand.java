// Original binary: hex/api/baritone/command/defaults/SetCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.Settings;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.RelativeFile;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.command.exception.CommandInvalidTypeException;
import hex.api.baritone.api.command.helpers.Paginator;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.utils.SettingsUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.ClickEvent.SuggestCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;

// $VF: Compiled from s
public class SetCommand extends Command {
   private static final String Я西 = "Я西";
   private static final String Ят = "Ят";
   private static final String Яд = "Яд";
   private static final String Яе = "Яе";
   private static final String Я6 = "Я6";
   private static final String Яl = "Яl";
   private static final String Я必 = "Я必";
   private static final String ЯЗ = "ЯЗ";
   private static final String Ян = "Ян";
   private static final String ЯД = "ЯД";
   private static final String ЯН = "ЯН";
   private static final String Яш = "Яш";
   private static final String Ял = "Ял";
   private static final String Яи = "Яи";
   private static final String Ящ = "Ящ";
   private static final String Хб = "Хб";
   private static final String ХА = "ХА";
   private static final String Х诶 = "Х诶";
   private static final String ХЫ = "ХЫ";
   private static final String Хз = "Хз";
   private static final String ХР = "ХР";
   private static final String Хх = "Хх";
   private static final String ХЦ = "ХЦ";
   private static final String Х9 = "Х9";
   private static final String ХЮ = "ХЮ";
   private static final String ХO = "ХO";
   private static final String Х弟 = "Х弟";
   private static final String ХВ = "ХВ";
   private static final String Хж = "Хж";
   private static final String Х8 = "Х8";
   private static final String ХТ = "ХТ";
   private static final String ХЙ = "ХЙ";
   private static final String Хэ = "Хэ";
   private static final String ХО = "ХО";
   private static final String ХИ = "ХИ";
   private static final String ХП = "ХП";
   private static final String Х_ = "Х_";
   private static final String Хс = "Хс";
   private static final String ХЛ = "ХЛ";
   private static final String Хь = "Хь";
   private static final String ХЯ = "ХЯ";
   private static final String ХХ = "ХХ";
   private static final String ХШ = "ХШ";
   private static final String Ха = "Ха";
   private static final String Х7 = "Х7";
   private static final String ХУ = "ХУ";
   private static final String Х0 = "Х0";
   private static final String ХГ = "ХГ";
   private static final String Хф = "Хф";
   private static final String ХЕ = "ХЕ";
   private static final String Хч = "Хч";
   private static final String Х衣 = "Х衣";
   private static final String Хц = "Хц";
   private static final String ХМ = "ХМ";
   private static final String Х5 = "Х5";
   private static final String ХЖ = "ХЖ";
   private static final String Хо = "Хо";
   private static final String ХК = "ХК";
   private static final String ХЭ = "ХЭ";
   private static final String ХЪ = "ХЪ";
   private static final String ХЧ = "ХЧ";
   private static final String ХЩ = "ХЩ";
   private static final String Хм = "Хм";
   private static final String ХФ = "ХФ";
   private static final String Х3 = "Х3";
   private static final String ХЬ = "ХЬ";
   private static final String Х1 = "Х1";
   private static final String Хя = "Хя";
   private static final String ХI = "ХI";
   private static final String Хы = "Хы";
   private static final String Ху = "Ху";
   private static final String Хг = "Хг";
   private static final String Хю = "Хю";
   private static final String Х4 = "Х4";
   private static final String ХС = "ХС";
   private static final String Хъ = "Хъ";
   private static final String ХБ = "ХБ";
   private static final String Хв = "Хв";
   private static final String Хр = "Хр";

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      if (var2.hasAny()) {
         String var3 = var2.getString();
         if (var2.hasExactlyOne() && !Arrays.asList(ХЛ, Хь).contains(var2.peekString().toLowerCase(Locale.US))) {
            if (var3.equalsIgnoreCase(ХЯ)) {
               return new TabCompleteHelper().addModifiedSettings().prepend(ХХ).filterPrefix(var2.getString()).stream();
            }

            if (var3.equalsIgnoreCase(ХШ)) {
               return new TabCompleteHelper().addToggleableSettings().filterPrefix(var2.getString()).stream();
            }

            if (Arrays.asList(Ха, Х7).contains(var3.toLowerCase(Locale.US))) {
               return RelativeFile.tabComplete(var2, Minecraft.getInstance().gameDirectory.toPath().resolve(ХУ).toFile());
            }

            var sx = Baritone.settings().byLowerName.get(var3.toLowerCase(Locale.US));
            if (sx != null) {
               if (sx.getType() == Boolean.class) {
                  TabCompleteHelper sxx = new TabCompleteHelper();
                  if ((Boolean)sx.value) {
                     sxx.append(Х0, ХГ);
                  } else {
                     sxx.append(Хф, ХЕ);
                  }

                  return sxx.filterPrefix(var2.getString()).stream();
               }

               return Stream.of(SettingsUtil.settingValueToString(sx));
            }
         } else if (!var2.hasAny()) {
            return new TabCompleteHelper().addSettings().sortAlphabetically().prepend(Хч, Х衣, Хц, ХМ, Х5, ХЖ).filterPrefix(var3).stream();
         }
      }

      return Stream.empty();
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      String var3 = var2.hasAny() ? var2.getString().toLowerCase(Locale.US) : Яе;
      if (Arrays.asList(Я6, Яl).contains(var3)) {
         SettingsUtil.save(Baritone.settings());
         this.logDirect(Я必);
      } else if (Arrays.asList(ЯЗ, Ян).contains(var3)) {
         String sx = ЯД;
         if (var2.hasAny()) {
            sx = var2.getString();
         }

         SettingsUtil.modifiedSettings(Baritone.settings()).forEach(Settings.Setting::reset);
         SettingsUtil.readAndApply(Baritone.settings(), sx);
         this.logDirect("Settings reloaded from " + sx);
      } else {
         boolean sx = Arrays.asList(ЯН, Яш, Ял).contains(var3);
         boolean sxx = Arrays.asList(Яи, Ящ, Хб).contains(var3);
         boolean sxxx = sx || sxx;
         if (sxxx) {
            String sxxxx = var2.hasAny() && var2.peekAsOrNull(Integer.class) == null ? var2.getString() : "";
            var2.requireMax(1);
            List<Settings.Setting> sxxxxx = (sx ? SettingsUtil.modifiedSettings(Baritone.settings()) : Baritone.settings().allSettings)
               .stream()
               .filter(var0 -> !var0.isJavaOnly())
               .filter(var1x -> var1x.getName().toLowerCase(Locale.US).contains(sxxxx.toLowerCase(Locale.US)))
               .sorted((var0, var1x) -> String.CASE_INSENSITIVE_ORDER.compare(var0.getName(), var1x.getName()))
               .collect(Collectors.toList());
            Paginator.paginate(
               var2,
               new Paginator<Settings.Setting>(sxxxxx),
               () -> this.logDirect(!sxxxx.isEmpty() ? String.format(Хъ, sx ? ХБ : "", sxxxx) : String.format(Хв, sx ? Хр : "")),
               var0 -> {
                  MutableComponent sxxxxxx = (MutableComponent) Component.literal(String.format(Ху, SettingsUtil.settingTypeToString(var0)));
                  sxxxxxx.setStyle(sxxxxxx.getStyle().withColor(ChatFormatting.DARK_GRAY));
                  MutableComponent sxxxxxxx = Component.literal("");
                  sxxxxxxx.setStyle(sxxxxxxx.getStyle().withColor(ChatFormatting.GRAY));
                  sxxxxxxx.append(var0.getName());
                  sxxxxxxx.append(String.format(Хг, SettingsUtil.settingTypeToString(var0)));
                  sxxxxxxx.append(String.format(Хю, SettingsUtil.settingValueToString(var0)));
                  sxxxxxxx.append(String.format(Х4, SettingsUtil.settingDefaultToString(var0)));
                  String sxxxxxxxx = Baritone.settings().prefix.value + String.format(ХС, var0.getName());
                  MutableComponent sxxxxxxxxx = Component.literal(var0.getName());
                  sxxxxxxxxx.setStyle(sxxxxxxxxx.getStyle().withColor(ChatFormatting.GRAY));
                  sxxxxxxxxx.append(sxxxxxx);
                  sxxxxxxxxx.setStyle(sxxxxxxxxx.getStyle().withHoverEvent(new ShowText(sxxxxxxx)).withClickEvent(new SuggestCommand(sxxxxxxxx)));
                  return sxxxxxxxxx;
               },
               IBaritoneChatControl.FORCE_COMMAND_PREFIX + "set " + var3 + " " + sxxxx
            );
         } else {
            var2.requireMax(1);
            boolean sxxxx = var3.equalsIgnoreCase(ХА);
            boolean sxxxxx = var3.equalsIgnoreCase(Х诶);
            boolean sxxxxxx = sxxxx || sxxxxx;
            if (sxxxx) {
               if (!var2.hasAny()) {
                  this.logDirect(ХЫ);
                  this.logDirect(Хз);
                  this.logDirect(ХР);
               } else if (var2.peekString().equalsIgnoreCase(Хх)) {
                  SettingsUtil.modifiedSettings(Baritone.settings()).forEach(Settings.Setting::reset);
                  this.logDirect(ХЦ);
                  SettingsUtil.save(Baritone.settings());
                  return;
               }
            }

            if (sxxxxx) {
               var2.requireMin(1);
            }

            String sxxxxxxx = sxxxxxx ? var2.getString() : var3;
            Settings.Setting sxxxxxxxx = Baritone.settings()
               .allSettings
               .stream()
               .filter(var1x -> var1x.getName().equalsIgnoreCase(sxxxxxxx))
               .findFirst()
               .orElse(null);
            if (sxxxxxxxx == null) {
               throw new CommandInvalidTypeException(var2.consumed(), Х9);
            }

            if (sxxxxxxxx.isJavaOnly()) {
               throw new CommandInvalidStateException(String.format(ХЮ, sxxxxxxxx.getName()));
            }

            if (!sxxxxxx && !var2.hasAny()) {
               this.logDirect(String.format(ХO, sxxxxxxxx.getName()));
               this.logDirect(SettingsUtil.settingValueToString(sxxxxxxxx));
            } else {
               String sxxxxxxxxx = SettingsUtil.settingValueToString(sxxxxxxxx);
               if (sxxxx) {
                  sxxxxxxxx.reset();
               } else if (sxxxxx) {
                  if (sxxxxxxxx.getValueClass() != Boolean.class) {
                     throw new CommandInvalidTypeException(var2.consumed(), Х弟, ХВ);
                  }

                  var sxxxxxxxxxx = (Settings.Setting<Boolean>)sxxxxxxxx;
                  var var14 = sxxxxxxxxxx;
                  var14.value = !var14.value;
                  this.logDirect(String.format(Хж, sxxxxxxxx.getName(), Boolean.toString((Boolean)sxxxxxxxx.value)));
               } else {
                  String sxxxxxxxxxx = var2.getString();

                  try {
                     SettingsUtil.parseAndApply(Baritone.settings(), var3, sxxxxxxxxxx);
                  } catch (Throwable sxxxxxxxxxxx) {
                     throw new CommandInvalidTypeException(var2.consumed(), Х8, sxxxxxxxxxxx);
                  }
               }

               if (!sxxxxx) {
                  this.logDirect(String.format(ХТ, sxxxx ? ХЙ : Хэ, sxxxxxxxx.getName(), SettingsUtil.settingValueToString(sxxxxxxxx)));
               }

               MutableComponent sxxxxxxxxxx = Component.literal(String.format(ХО, sxxxxxxxxx));
               sxxxxxxxxxx.setStyle(
                  sxxxxxxxxxx.getStyle()
                     .withColor(ChatFormatting.GRAY)
                     .withHoverEvent(new ShowText(Component.literal(ХИ)))
                     .withClickEvent(new RunCommand(IBaritoneChatControl.FORCE_COMMAND_PREFIX + String.format(ХП, sxxxxxxxx.getName(), sxxxxxxxxx)))
               );
               this.logDirect(sxxxxxxxxxx);
               if (sxxxxxxxx.getName().equals(Х_) && !(Boolean)sxxxxxxxx.value) {
                  this.logDirect(Хс, ChatFormatting.RED);
               }
            }

            SettingsUtil.save(Baritone.settings());
         }
      }
   }


   @Override
   public String getShortDesc() {
      return Хо;
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(ХК, "", ХЭ, ХЪ, ХЧ, ХЩ, Хм, ХФ, Х3, ХЬ, Х1, Хя, ХI, Хы);
   }

   public SetCommand(IBaritone var1) {
      super(var1, Я西, Ят, Яд);
   }
}
