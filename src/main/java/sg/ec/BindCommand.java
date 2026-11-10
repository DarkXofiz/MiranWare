// Original binary: sg/ec/1IQ2EtKgp84mIdXC
package sg.ec;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.List;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.ClickEvent.SuggestCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;

// $VF: Compiled from s
@CommandInfo(name = "bind", description = "")
public class BindCommand extends AbstractCommand {
   private static final String field00542 = "add";
   private static final String field00543 = "name";
   private static final String field00544 = "key";
   private static final String field00545 = "remove";
   private static final String field00546 = "name";
   private static final String field00547 = "list";
   private static final String field00548 = "clear";
   private static final String field00549 = "Список биндов был очищен.";
   private static final String field00550 = "Список биндов:";
   private static final String field00551 = " ";
   private static final String field00552 = "[x]";
   private static final String field00553 = " ";
   private static final String field00554 = "Список биндов пуст:";
   private static final String field00555 = "name";
   private static final String field00556 = "name";
   private static final String field00557 = "key";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var var2 = ModuleManager.INSTANCE.method05138().stream().toList();
      var1.then(
         this.method01188(field00542)
            .then(
               this.method01184(field00543, new ModuleArgument())
                  .then(
                     this.method01184(field00544, new KeyNameArgument())
                        .executes(
                           var1x -> {
                              ToggleableModule var2x = (ToggleableModule)var1x.getArgument(field00556, ToggleableModule.class);
                              String var3 = (String)var1x.getArgument(field00557, String.class);
                              Integer var4 = null;

                              try {
                                 var4 = KeyboardKey.method00361(var3);
                              } catch (Exception var6) {
                              }

                              if (var4 != null) {
                                 var2x.method03930().method05872(var4);
                              }

                              this.method01187(
                                 "Кнопка: "
                                    + KeyboardKey.method00360(var2x.method03930().method05871())
                                    + " была привязана к модулю: "
                                    + var2x.method03925()
                                    + "."
                              );
                              return 1;
                           }
                        )
                  )
            )
      );
      var1.then(
         this.method01188(field00545)
            .then(
               this.method01184(field00546, new BindableModuleArgument())
                  .executes(
                     var1x -> {
                        ToggleableModule var2x = (ToggleableModule)var1x.getArgument(field00555, ToggleableModule.class);
                        this.method01187(
                           "Кнопка: "
                              + KeyNames.method06800(var2x.method03930().method05871())
                              + " была отвязана от модуля: "
                              + var2x.method03925()
                              + "."
                        );
                        var2x.method03930().method05872(-1);
                        return 1;
                     }
                  )
            )
      );
      var1.then(
         this.method01188(field00547)
            .executes(
               var2x -> {
                  if (!var2.isEmpty()) {
                     this.method01187(field00550);

                     for (ToggleableModule var4 : var2) {
                        if (var4.method03930().method05871() != -1) {
                           MutableComponent var5 = Component.literal(
                              "Модуль: " + var4.method03925() + " Кнопка: [" + KeyNames.method06800(var4.method03930().method05871()) + "]"
                           );
                           MutableComponent var6 = Component.literal(field00551)
                              .append(field00552)
                              .setStyle(
                                 Style.EMPTY
                                    .withColor(ColorUtils.method04604(255, 100, 100))
                                    .withHoverEvent(new ShowText(Component.literal("Нажмите чтобы удалить бинд [" + var4.method03925() + "]")))
                                    .withClickEvent(new SuggestCommand(".bind remove " + var4.method03925().replace(field00553, "")))
                              );
                           var5.append(var6);
                           ChatTextUtils.method05098(var5);
                        }
                     }

                     return 1;
                  } else {
                     this.method01187(field00554);
                     return 0;
                  }
               }
            )
      );
      var1.then(this.method01188(field00548).executes(var2x -> {
         for (ToggleableModule var4 : var2) {
            if (var4.method03930().method05871() == -1) {
               var4.method03930().method05872(-1);
            }
         }

         this.method01187(field00549);
         return 1;
      }));
   }
}
