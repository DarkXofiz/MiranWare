// Original binary: sg/ec/B7xTnHufNT380G9P
package sg.ec;

// $VF: Compiled from s
public enum ConfigSharePromptManager implements MinecraftAccess {
   INSTANCE;

   private final TextPromptScreen field06207 = new TextPromptScreen();
   private volatile ConfigSharePromptManager.Nested72 field06208;

   public ConfigSharePromptManager.Nested72 method02650() {
      return this.field06208;
   }

   public void method02651(ConfigSharePromptManager.Nested72 var1) {
      if (var1 != null && !var1.field06209().isEmpty()) {
         this.field06208 = var1;
         mc.execute(() -> ClientScreenManager.INSTANCE.method08319(this.field06207));
      }
   }

   public void method02652() {
      this.method02654(true);
   }

   public void method02653() {
      this.method02654(false);
   }

   private void method02654(boolean var1) {
      ConfigSharePromptManager.Nested72 var2 = this.field06208;
      this.field06208 = null;
      ClientScreenManager.INSTANCE.method08321();
      if (var2 != null) {
         GlobalRequestSender.method09378(var2x -> var2x.method01867(var2.field06209(), var1));
      }
   }

   // $VF: Compiled from s
   public record Nested72(String field06209, String discordName, String configName, String author, String description) {
      public Nested72(String field06209, String discordName, String configName, String author, String description) {
         field06209 = field06209 == null ? "" : field06209;
         discordName = discordName == null ? "" : discordName;
         configName = configName == null ? "" : configName;
         author = author == null ? "" : author;
         description = description == null ? "" : description;
         this.field06209 = field06209;
         this.discordName = discordName;
         this.configName = configName;
         this.author = author;
         this.description = description;
      }
   }
}
