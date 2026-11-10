// Original binary: sg/ec/RZi9OBzBiYu0TPl9
package sg.ec;

// $VF: Compiled from s
public enum BotConnectionState {
   IDLE("Оффлайн", false),
   QUEUED("В очереди", true),
   CONNECTING("Подключение", true),
   LOGGING_IN("Авторизация", true),
   CONFIGURING("Настройка", true),
   PLAYING("В игре", true),
   CONTROLLED("Ты играешь", false),
   FAILED("Ошибка", false);

   private final String field11436;
   private final boolean field11437;

   BotConnectionState(String var3, boolean var4) {
      this.field11436 = var3;
      this.field11437 = var4;
   }

   public boolean method05278() {
      return this == PLAYING;
   }

   public String method05279() {
      return this.field11436;
   }

   public boolean method05280() {
      return this.field11437;
   }
}
