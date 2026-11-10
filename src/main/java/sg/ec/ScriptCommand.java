// Original binary: sg/ec/BH66FnKUIO1B0gFO
package sg.ec;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import hex.script.api.Setting;
import java.io.Serializable;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

// $VF: Compiled from s
@CommandInfo(name = "script", description = "Скрипты клиента")
public class ScriptCommand extends AbstractCommand {
   private static final String field06236 = "list";
   private static final String field06237 = "reload";
   private static final String field06238 = "toggle";
   private static final String field06239 = "name";
   private static final String field06240 = "settings";
   private static final String field06241 = "name";
   private static final String field06242 = "set";
   private static final String field06243 = "name";
   private static final String field06244 = "setting";
   private static final String field06245 = "value";
   private static final String field06246 = "  ";
   private static final String field06247 = "name";
   private static final String field06248 = "setting";
   private static final String field06249 = "value";
   private static final String field06250 = "name";
   private static final String field06251 = "name";

   private String method02715(Setting<?> var1) {
      String var2 = var1.parent() == null ? "" : field06246;
      String var3 = String.valueOf(var1.write());
      String var4 = var3.isEmpty() ? ChatFormatting.DARK_GRAY + "(кнопка)" : ChatFormatting.RESET + var3;
      return var2 + ChatFormatting.GRAY + var1.name() + ": " + var4;
   }

   private LoadedScript method02716(String var1) {
      LoadedScript var2 = ScriptRuntime.INSTANCE.method06182(var1);
      if (var2 == null) {
         this.method01187(ChatFormatting.RED + "Скрипт " + var1 + " не найден");
      }

      return var2;
   }

   private String method02717(LoadedScript var1) {
      if (var1.method03391()) {
         return ChatFormatting.RED + "[ошибка] " + ChatFormatting.RESET;
      } else {
         return var1.method03392() ? ChatFormatting.GREEN + "[вкл] " + ChatFormatting.RESET : ChatFormatting.GRAY + "[выкл] " + ChatFormatting.RESET;
      }
   }

   private String method02718(LoadedScript var1) {
      String var2 = ScriptRuntime.INSTANCE.method06178(var1) ? ChatFormatting.GOLD + "[нужен перезапуск] " + ChatFormatting.RESET : "";
      return this.method02717(var1) + var2;
   }

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var1.then(this.method01188(field06236).executes(var1x -> {
         var var2 = ScriptRuntime.INSTANCE.method06229();
         if (var2.isEmpty()) {
            this.method01187(ChatFormatting.RED + "Скриптов нет");
            return 1;
         }

         for (LoadedScript sx : var2) {
            String sxx = sx.method03396() ? ChatFormatting.DARK_GRAY + " (встроенный)" : "";
            this.method01187(this.method02718(sx) + sx.method03400() + sxx);
         }

         return 1;
      }));
      var1.then(this.method01188(field06237).executes(var1x -> {
         int var2 = ScriptRuntime.INSTANCE.method06177();
         this.method01187(ChatFormatting.GRAY + "Загружено скриптов: " + ChatFormatting.RESET + var2);
         return 1;
      }));
      var1.then(this.method01188(field06238).then(this.method01184(field06239, StringArgumentType.word()).executes(var1x -> {
         String var2 = (String)var1x.getArgument(field06251, String.class);
         LoadedScript var3 = ScriptRuntime.INSTANCE.method06182(var2);
         if (var3 == null) {
            this.method01187(ChatFormatting.RED + "Скрипт " + var2 + " не найден");
            return 1;
         } else {
            ScriptRuntime.INSTANCE.method06183(var3);
            this.method01187(this.method02718(var3) + var3.method03400());
            return 1;
         }
      })));
      var1.then(this.method01188(field06240).then(this.method01184(field06241, StringArgumentType.word()).executes(var1x -> {
         LoadedScript var2 = this.method02716((String)var1x.getArgument(field06250, String.class));
         if (var2 == null) {
            return 1;
         }

         var var3 = ScriptRuntime.INSTANCE.method06224(var2);
         if (var3.isEmpty()) {
            this.method01187(ChatFormatting.GRAY + "У " + var2.method03400() + " нет настроек");
            return 1;
         }

         for (Setting var5 : var3) {
            this.method01187(this.method02715(var5));
         }

         return 1;
      })));
      var1.then(
         this.method01188(field06242)
            .then(
               this.method01184(field06243, StringArgumentType.word())
                  .then(
                     this.method01184(field06244, StringArgumentType.word())
                        .then(
                           this.method01184(field06245, StringArgumentType.greedyString())
                              .executes(
                                 var1x -> {
                                    LoadedScript var2 = this.method02716((String)var1x.getArgument(field06247, String.class));
                                    if (var2 == null) {
                                       return 1;
                                    } else {
                                       String var3 = (String)var1x.getArgument(field06248, String.class);
                                       String var4 = (String)var1x.getArgument(field06249, String.class);
                                       if (!ScriptRuntime.INSTANCE.method06225(var2, var3, var4)) {
                                          this.method01187(ChatFormatting.RED + "Настройка " + var3 + " не найдена или значение не подошло");
                                          return 1;
                                       } else {
                                          Setting var5 = ScriptRuntime.INSTANCE
                                             .method06224(var2)
                                             .stream()
                                             .filter(var1xx -> var1xx.id().equalsIgnoreCase(var3) || var1xx.name().equalsIgnoreCase(var3))
                                             .findFirst()
                                             .orElse(null);
                                          this.method01187(var5 == null ? ChatFormatting.GREEN + "готово" : this.method02715(var5));
                                          return 1;
                                       }
                                    }
                                 }
                              )
                        )
                  )
            )
      );
   }
}
