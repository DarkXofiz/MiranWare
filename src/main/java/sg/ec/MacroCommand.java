// Original binary: sg/ec/SnPGzrWnRPz1pxPu
package sg.ec;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

// $VF: Compiled from s
@CommandInfo(name = "macro", description = "")
public class MacroCommand extends AbstractCommand {
   private static final String field11942 = "add";
   private static final String field11943 = "name";
   private static final String field11944 = "key";
   private static final String field11945 = "description";
   private static final String field11946 = "remove";
   private static final String field11947 = "name";
   private static final String field11948 = "clear";
   private static final String field11949 = "list";
   private static final String field11950 = "Список макросов:";
   private static final String field11951 = "Список макросов был очищен.";
   private static final String field11952 = "name";
   private static final String field11953 = "name";
   private static final String field11954 = "description";
   private static final String field11955 = "key";
   private static final String field11956 = "Макрос с таким названием уже существует.";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      MacroManager var2 = MacroManager.INSTANCE;
      var1.then(
         this.method01188(field11942)
            .then(
               this.method01184(field11943, StringArgumentType.string())
                  .then(
                     this.method01184(field11944, new KeyNameArgument())
                        .then(this.method01184(field11945, StringArgumentType.greedyString()).executes(var2x -> {
                           String var3 = (String)var2x.getArgument(field11953, String.class);
                           String var4 = (String)var2x.getArgument(field11954, String.class);
                           String var5 = (String)var2x.getArgument(field11955, String.class);
                           if (var2.method07029().stream().anyMatch(var1xx -> var1xx.method00884().equals(var3))) {
                              this.method01187(field11956);
                              return 0;
                           } else {
                              var2.method07023(var3, var4, KeyboardKey.method00361(var5));
                              this.method01187("Был добавлен макрос с Названием: " + var3 + " и кнопкой: " + var5);
                              return 1;
                           }
                        }))
                  )
            )
      );
      var1.then(this.method01188(field11946).then(this.method01184(field11947, new MacroArgument()).executes(var2x -> {
         Macro var3 = (Macro)var2x.getArgument(field11952, Macro.class);
         String var4 = var3.method00884();
         var2.method07024(var4);
         this.method01187("Макрос: " + var4 + " был удален.");
         return 1;
      })));
      var1.then(this.method01188(field11948).executes(var2x -> {
         var2.method07025();
         this.method01187(field11951);
         return 1;
      }));
      var1.then(
         this.method01188(field11949)
            .executes(
               var2x -> {
                  this.method01187(field11950);

                  for (Macro var4 : var2.method07029()) {
                     this.method01187(
                        "Название: "
                           + var4.method00884()
                           + " Описание: "
                           + var4.method00879()
                           + " Кнопка: "
                           + KeyboardKey.method00360(var4.method00882())
                     );
                  }

                  return 1;
               }
            )
      );
   }
}
