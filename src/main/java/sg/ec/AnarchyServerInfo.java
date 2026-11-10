// Original binary: sg/ec/wfIsYX0CLXrJp5pQ
package sg.ec;

// $VF: Compiled from s
public class AnarchyServerInfo {
   private String field25211;
   private String field25212;
   private String field25213;
   private String field25214;
   private String field25215;
   private String field25216;
   private String field25217;
   private long field25218;
   private long field25219;
   private long field25220;
   private boolean field25221;
   private int field25222;
   private int field25223;
   private int field25224;
   private long field25225;
   private static final String field25226 = "anarchy";
   private static final String field25227 = "an";
   private static final long field25228 = 1000L;

   public void method11205(long var1) {
      this.field25218 = var1;
   }

   public long method11206() {
      return this.field25218;
   }

   public String method11207() {
      return this.field25217;
   }

   public String method11208() {
      return this.field25216;
   }

   public String method11209() {
      return this.field25215;
   }

   @Override
   public String toString() {
      return "FunTimeEvent{server='"
         + this.field25211
         + "', id='"
         + this.field25212
         + "', eventName='"
         + this.field25213
         + "', phase='"
         + this.field25216
         + "', secondsRemaining="
         + this.method11223()
         + "}";
   }

   public long method11210() {
      return this.field25225;
   }

   public String method11211() {
      return this.field25212;
   }

   public long method11212() {
      return this.field25220;
   }

   public void method11213(long var1) {
      this.field25220 = var1;
   }

   public String method11214() {
      return this.field25214;
   }

   public long method11215() {
      return this.field25219;
   }

   public void method11216(String var1) {
      this.field25211 = var1 == null ? null : var1.replace(field25226, field25227);
   }

   public void method11217(String var1) {
      this.field25212 = var1;
   }

   public String method11218() {
      return this.field25211;
   }

   public void method11219(int var1) {
      this.field25223 = var1;
   }

   public void method11220(String var1) {
      this.field25216 = var1;
   }

   public int method11221() {
      return this.field25222;
   }

   public String method11222() {
      return this.field25213;
   }

   public long method11223() {
      if (this.field25225 <= 0L) {
         return this.field25220;
      }

      long var1 = (System.currentTimeMillis() - this.field25225) / field25228;
      return Math.max(0L, this.field25220 - var1);
   }

   public int method11224() {
      return this.field25224;
   }

   public void method11225(int var1) {
      this.field25222 = var1;
   }

   public void method11226(long var1) {
      this.field25225 = var1;
   }

   public int method11227() {
      return this.field25223;
   }

   public boolean method11228() {
      return this.field25221;
   }

   public void method11229(String var1) {
      this.field25214 = var1;
   }

   public void method11230(long var1) {
      this.field25219 = var1;
   }

   public void method11231(boolean var1) {
      this.field25221 = var1;
   }

   public void method11232(String var1) {
      this.field25217 = var1;
   }

   public void method11233(String var1) {
      this.field25213 = var1;
   }

   public void method11234(String var1) {
      this.field25215 = var1;
   }

   public void method11235(int var1) {
      this.field25224 = var1;
   }
}
