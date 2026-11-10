// Original binary: sg/ec/lHOir8juoJT7NIY6
package sg.ec;

// $VF: Compiled from s
public enum WardenBotSettings {
   INSTANCE;

   private boolean field21245;
   private boolean field21246;
   private boolean field21247;
   private String field21248 = "Средний";
   private int field21249 = 4;
   private WardenBotOptions field21250 = this.method09327();

   public void method09322(boolean var1) {
      this.field21245 = var1;
      this.field21250 = this.method09327();
   }

   public void method09323(boolean var1) {
      this.field21246 = var1;
      this.field21250 = this.method09327();
   }

   public void method09324(boolean var1) {
      this.field21247 = var1;
      this.field21250 = this.method09327();
   }

   public void method09325(String var1) {
      this.field21248 = var1;
      this.field21250 = this.method09327();
   }

   public void method09326(int var1) {
      this.field21249 = var1;
      this.field21250 = this.method09327();
   }

   private WardenBotOptions method09327() {
      return new WardenBotOptions(this.field21245, this.field21246, this.field21248, this.field21249, this.field21247);
   }

   public boolean method09328() {
      return this.field21245;
   }

   public boolean method09329() {
      return this.field21246;
   }

   public boolean method09330() {
      return this.field21247;
   }

   public String method09331() {
      return this.field21248;
   }

   public int method09332() {
      return this.field21249;
   }

   public WardenBotOptions method09333() {
      return this.field21250;
   }
}
