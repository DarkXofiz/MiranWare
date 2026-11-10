// Original binary: sg/ec/RHVb1vKRqWdWZlGt
package sg.ec;

// $VF: Compiled from s
public class LegitMode extends ClientModule {
   private final MultiToggleSetting field11402;
   private static final String field11403 = "Что убрать?";
   private static final String field11404 = "Сообщения клиента";
   private static final String field11405 = "Команды в чате";
   private static final String field11406 = "Выбросить всё";
   private static final String field11407 = "Главное меню";
   private static final String field11408 = "Клиентские Плащ/Элитры";
   private static final String field11409 = "Поиск в сундуках";
   private static final String field11410 = "Legit Mode";
   private static final String field11411 = "Сообщения клиента";
   private static final String field11412 = "Выбросить всё";
   private static final String field11413 = "Команды в чате";
   private static final String field11414 = "Главное меню";
   private static final String field11415 = "Клиентские Плащ/Элитры";
   private static final String field11416 = "Поиск в сундуках";

   @Subscribe
   private void method05268(ClientFeaturePolicyEvent var1) {
      boolean var2 = switch (var1.method06425()) {
         case CLIENT_MESSAGE -> this.field11402.method04520(field11411);
         case INVENTORY_BUTTON -> this.field11402.method04520(field11412);
         case CHAT_COMMAND -> this.field11402.method04520(field11413);
         case MAIN_MENU -> this.field11402.method04520(field11414);
         case CLIENT_CAPE -> this.field11402.method04520(field11415);
         case CHEST_SEARCH -> this.field11402.method04520(field11416);
      };
      if (var2) {
         var1.method05696();
      }
   }

   public LegitMode() {
      super(ModuleCategory.Misc, ModuleSubCategory.Other);
      this.field11402 = new MultiToggleSetting(field11403)
         .method04517(NamedOption.method08077(field11404, false))
         .method04517(NamedOption.method08077(field11405, true))
         .method04517(NamedOption.method08077(field11406, true))
         .method04517(NamedOption.method08077(field11407, false))
         .method04517(NamedOption.method08077(field11408, false))
         .method04517(NamedOption.method08077(field11409, true))
         .method03023(this);
      this.method03935(field11410);
   }
}
