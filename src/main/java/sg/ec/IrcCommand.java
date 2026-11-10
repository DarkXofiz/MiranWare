// Original binary: sg/ec/46i5FSGrrHs7Drh1
package sg.ec;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;

// $VF: Compiled from s
@CommandInfo(name = "irc", description = "")
public class IrcCommand extends AbstractCommand {
   private static final String field01873 = "use";
   private static final String field01874 = "name";
   private static final String field01875 = "clear";
   private static final String field01876 = "prefixes";
   private static final String field01877 = "message";
   private static final String field01878 = "Кастомных префиксов нет.";
   private static final String field01879 = "» ";
   private static final String field01880 = " · выбран";
   private static final String field01881 = "IRC";
   private static final String field01882 = ".irc clear";
   private static final String field01883 = "Нажми, чтобы убрать префикс";
   private static final String field01884 = "Нажми, чтобы выбрать префикс";
   private static final String field01885 = "message";
   private static final String field01886 = "name";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var1.then(
         this.method01188(field01873)
            .then(
               this.method01184(field01874, StringArgumentType.string())
                  .suggests((var1x, var2) -> SharedSuggestionProvider.suggest(this.method00797(), var2))
                  .executes(var0 -> {
                     IrcPrefixUtils.method05945(PrefixC2SPacket.Nested238.SELECT, StringArgumentType.getString(var0, field01886), null, "", "");
                     return 1;
                  })
            )
      );
      var1.then(this.method01188(field01875).executes(var0 -> {
         IrcPrefixUtils.method05945(PrefixC2SPacket.Nested238.CLEAR, "", null, "", "");
         return 1;
      }));
      var1.then(this.method01188(field01876).executes(var1x -> {
         this.method00798();
         return 1;
      }));
      var1.then(this.method01184(field01877, StringArgumentType.greedyString()).executes(var0 -> {
         String var1x = StringArgumentType.getString(var0, field01885);
         if (var1x == null || var1x.trim().isEmpty()) {
            return 1;
         }

         if (MiranWare.getInstance().getClient() == null) {
            return 0;
         }

         GlobalConnectionManager.method03852(new ChatC2SPacket(GlobalConnectionManager.method03858(), var1x.trim()));
         return 1;
      }));
   }

   private List<PrefixEntry> method00793() {
      UserRole var1 = IrcPrefixUtils.method05948();
      ArrayList var2 = new ArrayList();

      for (PrefixEntry var4 : IrcPrefixUtils.method05947()) {
         if (var1.method08586(var4.role())) {
            var2.add(var4);
         }
      }

      return var2;
   }

   private List<String> method00797() {
      ArrayList var1 = new ArrayList();

      for (PrefixEntry var3 : this.method00793()) {
         var1.add(var3.name());
      }

      return var1;
   }

   private void method00798() {
      var var1 = this.method00793();
      if (var1.isEmpty()) {
         this.method01187(field01878);
      } else {
         String var2 = IrcPrefixUtils.method05946();

         for (PrefixEntry var4 : var1) {
            boolean var5 = var4.name().equalsIgnoreCase(var2);
            MutableComponent var6 = Component.literal(var4.name() + " ").withStyle(ChatFormatting.GRAY);
            var6.append(Component.literal(field01879).withStyle(ChatFormatting.WHITE));
            var6.append(StyledTextParser.method11508(var4.value()));
            if (var5) {
               var6.append(Component.literal(field01880).withStyle(ChatFormatting.GREEN));
            }

            ChatTextUtils.method05096(
               field01881,
               var6.withStyle(
                  var2x -> var2x.withClickEvent(new RunCommand(var5 ? field01882 : ".irc use " + var4.name()))
                     .withHoverEvent(new ShowText(Component.literal(var5 ? field01883 : field01884)))
               )
            );
         }
      }
   }
}
