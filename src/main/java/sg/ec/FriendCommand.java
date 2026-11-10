// Original binary: sg/ec/dDrT4TiU1FZwNg52
package sg.ec;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

// $VF: Compiled from s
@CommandInfo(name = "friend", description = "Управление списком друзей")
public class FriendCommand extends AbstractCommand {
   private static final String field18081 = "add";
   private static final String field18082 = "name";
   private static final String field18083 = "alias";
   private static final String field18084 = "alias";
   private static final String field18085 = "name";
   private static final String field18086 = "alias";
   private static final String field18087 = "remove";
   private static final String field18088 = "name";
   private static final String field18089 = "clear";
   private static final String field18090 = "list";
   private static final String field18091 = "Список друзей: ";
   private static final String field18092 = "Список друзей был очищен.";
   private static final String field18093 = "name";
   private static final String field18094 = "name";
   private static final String field18095 = "alias";
   private static final String field18096 = "name";
   private static final String field18097 = "alias";
   private static final String field18098 = " получил придуманный ник: ";
   private static final String field18099 = " был добавлен в список друзей с придуманным ником: ";
   private static final String field18100 = "name";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      FriendManager var2 = FriendManager.INSTANCE;
      var1.then(this.method01188(field18081).then(((RequiredArgumentBuilder)this.method01184(field18082, new PlayerNameArgument()).executes(var2x -> {
         String var3 = (String)var2x.getArgument(field18100, String.class);
         if (var2.method00171(var3)) {
            this.method01187("Игрок с ником: " + var3 + " уже есть в списке друзей.");
            return 0;
         } else {
            Friend var4 = var2.method00176(var3);
            if (var4 != null) {
               this.method01187("Нельзя добавить " + var3 + ": слишком похоже на друга " + var4.method03787() + ".");
               return 0;
            } else {
               var2.method00177(var3);
               this.method01187("Игрок с ником: " + var3 + " был добавлен в список друзей.");
               return 1;
            }
         }
      })).then(this.method01184(field18083, StringArgumentType.greedyString()).executes(var2x -> {
         String var3 = (String)var2x.getArgument(field18096, String.class);
         String var4 = StringArgumentType.getString(var2x, field18097);
         boolean var5 = var2.method00171(var3);
         if (!var5) {
            Friend var6 = var2.method00176(var3);
            if (var6 == null && !var4.isEmpty()) {
               var6 = var2.method00176(var4);
            }

            if (var6 != null) {
               this.method01187("Нельзя добавить " + var3 + ": слишком похоже на друга " + var6.method03787() + ".");
               return 0;
            }
         }

         var2.method00178(var3, var4);
         this.method01187("Игрок с ником: " + var3 + (var5 ? field18098 : field18099) + var4);
         return 1;
      }))));
      var1.then(
         this.method01188(field18084)
            .then(
               this.method01184(field18085, new FriendAliasArgument()).then(this.method01184(field18086, StringArgumentType.greedyString()).executes(var2x -> {
                  String var3 = (String)var2x.getArgument(field18094, String.class);
                  String var4 = StringArgumentType.getString(var2x, field18095);
                  if (!var2.method00171(var3)) {
                     this.method01187("Игрока с ником: " + var3 + " нету в списке друзей.");
                     return 0;
                  } else {
                     var2.method00179(var3, var4);
                     this.method01187("Игроку с ником: " + var3 + " установлен придуманный ник: " + var4);
                     return 1;
                  }
               }))
            )
      );
      var1.then(this.method01188(field18087).then(this.method01184(field18088, new FriendAliasArgument()).executes(var2x -> {
         String var3 = (String)var2x.getArgument(field18093, String.class);
         if (!var2.method00171(var3)) {
            this.method01187("Игрока с ником: " + var3 + " нету в списке друзей.");
            return 0;
         } else {
            var2.method00180(var3);
            this.method01187("Игрок с ником: " + var3 + " был удален из списка друзей.");
            return 1;
         }
      })));
      var1.then(this.method01188(field18089).executes(var2x -> {
         this.method01187(field18092);
         var2.method00183();
         return 1;
      }));
      var1.then(this.method01188(field18090).executes(var2x -> {
         this.method01187(field18091);

         for (String var4 : var2.method00173()) {
            Friend var5 = var2.method00174(var4);
            this.method01187(var5 != null && var5.method03786() ? var4 + " (" + var5.method03788() + ")" : var4);
         }

         return 1;
      }));
   }
}
