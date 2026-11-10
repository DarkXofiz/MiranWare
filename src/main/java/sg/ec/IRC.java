// Original binary: sg/ec/cTllnDf895iPTXbK
package sg.ec;

// $VF: Compiled from s
public class IRC extends ClientModule {
   private final ToggleSetting field17748;
   private final ToggleSetting field17749;
   private static final String field17750 = "Выключить IRC";
   private static final String field17751 = "Скрывает сообщения глобального чата клиента.";
   private static final String field17752 = "Отображать префикс";
   private static final String field17753 = "Показывает тег отправителя перед его ником.";
   private static final String field17754 = "IRC";
   private static final String field17755 = "custom";
   private static final String field17756 = "IRC";
   private static final String field17757 = "[IRC]";

   public IRC() {
      super(ModuleCategory.Misc, ModuleSubCategory.Other);
      this.field17748 = new ToggleSetting(field17750).method03017(false).method03018(field17751).method03023(this);
      this.field17749 = new ToggleSetting(field17752).method03017(true).method03018(field17753).method03023(this);
      this.method03929(false);
      this.method03933(false);
      this.method03935(field17754);
   }

   @Override
   public void method00276() {
   }

   @Override
   public void method00245() {
   }

   public void method07279(ChatS2CPacket var1) {
      if (!this.field17748.method03022()) {
         if (var1 != null && var1.method02479() != null) {
            String var2 = this.field17749.method03022() ? var1.method02489() : "";
            String var3 = var1.method02479().method07586();
            boolean var4 = var1.method02484().containsKey(field17755) && var2 != null && !var2.isEmpty();
            if (var4) {
               ChatTextUtils.method05095(field17757, StyledTextParser.method11508(var2), var3, var1.method02486());
            } else {
               ChatTextUtils.method05081("[" + (var2 != null && !var2.isEmpty() ? var2 : field17756) + "]", var3, var1.method02486());
            }
         }
      }
   }
}
