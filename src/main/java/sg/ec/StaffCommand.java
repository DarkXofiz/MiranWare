// Original binary: sg/ec/xcvbmmXHTX5ZGOY2
package sg.ec;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

// $VF: Compiled from s
@CommandInfo(name = "staff", description = "")
public class StaffCommand extends AbstractCommand {
   private static final String field26015 = "add";
   private static final String field26016 = "name";
   private static final String field26017 = "remove";
   private static final String field26018 = "name";
   private static final String field26019 = "clear";
   private static final String field26020 = "list";
   private static final String field26021 = "Список staff.";
   private static final String field26022 = "список staff пуст.";
   private static final String field26023 = "Список staff был очищен.";
   private static final String field26024 = "Нечего очищать список staff пуст.";
   private static final String field26025 = "name";
   private static final String field26026 = "name";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      StaffManager var2 = StaffManager.INSTANCE;
      var1.then(this.method01188(field26015).then(this.method01184(field26016, new PlayerNameArgument()).executes(var2x -> {
         String var3 = (String)var2x.getArgument(field26026, String.class);
         if (!var2.method02175(var3)) {
            var2.method02172(var3);
            this.method01187("Игрок с ником: " + var3 + " Был добавлен в staff.");
         } else {
            this.method01187("Игрок с ником: " + var3 + " Уже есть в staff.");
         }

         return 1;
      })));
      var1.then(this.method01188(field26017).then(this.method01184(field26018, new StaffNameArgument()).executes(var2x -> {
         String var3 = (String)var2x.getArgument(field26025, String.class);
         if (var2.method02175(var3)) {
            var2.method02173(var3);
            this.method01187("Игрок с ником: " + var3 + " Был удален со staff.");
         } else {
            this.method01187("Игрока с ником: " + var3 + " Нету в staff.");
         }

         return 1;
      })));
      var1.then(this.method01188(field26019).executes(var2x -> {
         if (!var2.method02176().isEmpty()) {
            var2.method02174();
            this.method01187(field26023);
         } else {
            this.method01187(field26024);
         }

         return 1;
      }));
      var1.then(this.method01188(field26020).executes(var2x -> {
         if (!var2.method02176().isEmpty()) {
            this.method01187(field26021);

            for (String var4 : var2.method02176()) {
               this.method01187(var4);
            }
         } else {
            this.method01187(field26022);
         }

         return 1;
      }));
   }
}
