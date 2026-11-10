// Original binary: sg/ec/5AnwGLAbrlDG2b9A
package sg.ec;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.commands.SharedSuggestionProvider;

// $VF: Compiled from s
@CommandInfo(name = "cfg", description = "")
public class ConfigCommand extends AbstractCommand {
   private static final String field02090 = "load";
   private static final String field02091 = "name";
   private static final String field02092 = "loadKey";
   private static final String field02093 = "key";
   private static final String field02094 = "key";
   private static final String field02095 = "name";
   private static final String field02096 = "nick";
   private static final String field02097 = "save";
   private static final String field02098 = "name";
   private static final String field02099 = "reset";
   private static final String field02100 = "remove";
   private static final String field02101 = "name";
   private static final String field02102 = "list";
   private static final String field02103 = "Загрузка конфига по ключу...";
   private static final String field02104 = "Globals не подключён.";
   private static final String field02105 = "Облачных конфигов нет.";
   private static final String field02106 = "name";
   private static final String field02107 = "Globals не подключён.";
   private static final String field02108 = "name";
   private static final String field02109 = "name";
   private static final String field02110 = "nick";
   private static final String field02111 = "name";
   private static final String field02112 = "key";
   private static final String field02113 = "name";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var1.then(
         this.method01188(field02090)
            .then(
               this.method01184(field02091, StringArgumentType.string())
                  .suggests((var1x, var2) -> SharedSuggestionProvider.suggest(this.method00922(), var2))
                  .executes(var1x -> this.method00931(StringArgumentType.getString(var1x, field02113)))
            )
      );
      var1.then(
         this.method01188(field02092)
            .then(
               this.method01184(field02093, StringArgumentType.string()).executes(var1x -> this.method00930(StringArgumentType.getString(var1x, field02112)))
            )
      );
      var1.then(
         this.method01188(field02094)
            .then(
               ((RequiredArgumentBuilder)this.method01184(field02095, StringArgumentType.string())
                     .suggests((var1x, var2) -> SharedSuggestionProvider.suggest(this.method00922(), var2))
                     .executes(var1x -> this.method00928(StringArgumentType.getString(var1x, field02111), "")))
                  .then(
                     this.method01184(field02096, StringArgumentType.greedyString())
                        .executes(
                           var1x -> this.method00928(StringArgumentType.getString(var1x, field02109), StringArgumentType.getString(var1x, field02110).trim())
                        )
                  )
            )
      );
      var1.then(this.method01188(field02097).then(this.method01184(field02098, StringArgumentType.string()).executes(var1x -> {
         String var2 = (String)var1x.getArgument(field02108, String.class);
         if (CustomResourceManager.INSTANCE.method02465(var2)) {
            this.method01187("Конфиг с названием: " + var2 + " Был сохранен.");
         }

         GlobalWebSocketClient var3 = MiranWare.getInstance().getClient();
         if (var3 != null && var3.isOpen()) {
            byte[] var4 = ModuleConfigStorage.method04447();
            if (var4.length > 0) {
               var3.getManager().method01779(var2, var4);
               StoredContentCache.method05219(StorageCategory.CONFIG, var2, var4);
            }
         }

         return 1;
      })));
      var1.then(this.method01188(field02099).executes(var1x -> {
         this.method00924();
         return 1;
      }));
      var1.then(
         this.method01188(field02100)
            .then(
               this.method01184(field02101, StringArgumentType.string())
                  .suggests((var1x, var2) -> SharedSuggestionProvider.suggest(this.method00922(), var2))
                  .executes(var1x -> {
                     String var2 = StringArgumentType.getString(var1x, field02106);
                     boolean sx = ConfigFileUtils.method07558(var2);
                     GlobalWebSocketClient sxx = MiranWare.getInstance().getClient();
                     if (sxx != null && sxx.isOpen()) {
                        sxx.getManager().method01782(StorageCategory.CONFIG, var2);
                        this.method01187("Конфиг \"" + var2 + "\" удалён.");
                     } else if (sx) {
                        this.method01187("Конфиг \"" + var2 + "\" удалён локально (Globals не подключён).");
                     } else {
                        this.method01187(field02107);
                     }

                     return 1;
                  })
            )
      );
      var1.then(this.method01188(field02102).executes(var1x -> {
         GlobalWebSocketClient var2 = this.method00923();
         if (var2 == null) {
            return 0;
         }

         var2.getManager().method01844();
         var var3 = var2.getManager().method01793();
         if (var3.isEmpty()) {
            this.method01187(field02105);
            return 1;
         }

         this.method01187("Облачные конфиги (" + var3.size() + "):");

         for (StoredContentInfo var5 : var3) {
            this.method01187("- " + var5.name());
         }

         return 1;
      }));
   }

   private List<String> method00922() {
      ArrayList var1 = new ArrayList();
      GlobalWebSocketClient var2 = MiranWare.getInstance().getClient();
      if (var2 == null) {
         return var1;
      }

      for (StoredContentInfo var4 : var2.getManager().method01793()) {
         var1.add(var4.name());
      }

      return var1;
   }

   private GlobalWebSocketClient method00923() {
      GlobalWebSocketClient var1 = MiranWare.getInstance().getClient();
      if (var1 != null && var1.isOpen()) {
         return var1;
      }

      this.method01187(field02104);
      return null;
   }

   private void method00924() {
      for (ToggleableModule var2 : ModuleManager.INSTANCE.method05138()) {
         if (!(var2 instanceof ClickGUI)) {
            var2.method03922(new KeyBinding());
            var2.method03939(false);

            for (Setting var4 : var2.method03026()) {
               if (var4 instanceof NumberSetting var5) {
                  var5.method10837(((Number)var5.method03015()).floatValue());
               } else if (var4 instanceof ToggleSetting var6) {
                  var6.method03014(var6.method03015());
               } else if (var4 instanceof KeyBindSetting var7) {
                  var7.method03014(var7.method03015());
               } else if (var4 instanceof BooleanSetting var8) {
                  var8.method03014(var8.method03015());
               } else if (var4 instanceof ColorSetting var9) {
                  var9.method11672(var9.method03015());
               } else if (var4 instanceof MultiToggleSetting var10) {
                  for (NamedOption var14 : var10.method03022()) {
                     var14.method08078();
                  }
               } else if (var4 instanceof ModeSetting var11) {
                  var11.method05603(var11.method03015());
               } else if (var4 instanceof ItemFilterSetting var12) {
                  var12.method00869();
               }
            }
         }
      }
   }

   private int method00928(String var1, String var2) {
      GlobalWebSocketClient var3 = this.method00923();
      if (var3 == null) {
         return 0;
      }

      var3.getManager().method01810(var1, var2);
      this.method01187("Создание ключа для \"" + var1 + "\"" + (var2.isBlank() ? "" : " для " + var2) + "...");
      return 1;
   }

   private int method00930(String var1) {
      GlobalWebSocketClient var2 = this.method00923();
      if (var2 == null) {
         return 0;
      }

      var2.getManager().method01853(var1);
      this.method01187(field02103);
      return 1;
   }

   private int method00931(String var1) {
      GlobalWebSocketClient var2 = this.method00923();
      if (var2 == null) {
         return 0;
      }

      var2.getManager().method01817(StorageCategory.CONFIG, var1);
      this.method01187("Загрузка конфига \"" + var1 + "\" с сервера...");
      return 1;
   }
}
