// Original binary: sg/ec/9ValJOzRVgzzloC4
package sg.ec;

// $VF: Compiled from s
public class FunTimeServerData {
   private String field05372;
   private String field05373;
   private String field05374;
   private String field05375;
   private String field05376;
   private long field05377;
   private long field05378;
   private static final long field05379 = 1000L;

   public String method02243() {
      return this.field05376;
   }

   public void method02244(String var1) {
      this.field05376 = var1;
   }

   public void method02245(String var1) {
      this.field05374 = var1;
   }

   public long method02246() {
      return this.field05378;
   }

   public void method02247(String var1) {
      this.field05375 = var1;
   }

   public void method02248(long var1) {
      this.field05377 = var1;
   }

   public long method02249() {
      long var1 = (System.currentTimeMillis() - this.field05378) / field05379;
      return Math.max(0L, this.field05377 - var1);
   }

   public void method02250(long var1) {
      this.field05378 = var1;
   }

   public String method02251() {
      return this.field05373;
   }

   public void method02252(String var1) {
      this.field05372 = var1;
   }

   public void method02253(String var1) {
      this.field05373 = var1;
   }

   @Override
   public String toString() {
      return "FunTimeMine{serverId='"
         + this.field05372
         + "', serverRuName='"
         + this.field05373
         + "', mineName='"
         + this.field05374
         + "', mineRarity='"
         + this.field05375
         + "', nextMineRarity='"
         + this.field05376
         + "', secondsRemaining="
         + this.method02249()
         + "}";
   }

   public String method02254() {
      return this.field05372;
   }

   public String method02255() {
      return this.field05374;
   }

   public long method02256() {
      return this.field05377;
   }

   public String method02257() {
      return this.field05375;
   }
}
