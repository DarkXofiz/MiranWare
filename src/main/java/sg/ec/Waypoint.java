// Original binary: sg/ec/x3dZabPNLsYENy5A
package sg.ec;

// $VF: Compiled from s
public class Waypoint {
   private float field25267;
   private float field25268;
   private float field25269;
   private String field25270;
   private long field25271;
   private boolean field25272;
   private float field25273 = 0.0F;
   private AnimationUtils field25274;
   private static final long field25275 = 250L;

   public Waypoint(float var1, float var2, float var3, String var4, long var5) {
      this(var1, var2, var3, var4, var5, true);
   }

   public float method11260() {
      return this.field25268;
   }

   public void method11261(AnimationUtils var1) {
      this.field25274 = var1;
   }

   public String method11262() {
      return this.field25270;
   }

   public void method11263(float var1) {
      this.field25269 = var1;
   }

   public float method11264() {
      return this.field25267;
   }

   public void method11265(String var1) {
      this.field25270 = var1;
   }

   public long method11266() {
      return this.field25271;
   }

   public void method11267(float var1) {
      this.field25267 = var1;
   }

   public Waypoint(float var1, float var2, float var3, String var4, long var5, boolean var7) {
      this.field25267 = var1;
      this.field25268 = var2;
      this.field25269 = var3;
      this.field25270 = var4;
      this.field25271 = var5;
      this.field25272 = var7;
      this.field25274 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field25275);
   }

   public boolean method11268() {
      return this.field25272;
   }

   public float method11269() {
      return this.field25269;
   }

   public float method11270() {
      return this.field25273;
   }

   public void method11271(float var1) {
      this.field25273 = var1;
   }

   public void method11272(boolean var1) {
      this.field25272 = var1;
   }

   public void method11273(long var1) {
      this.field25271 = var1;
   }

   public AnimationUtils method11274() {
      return this.field25274;
   }

   public void method11275(float var1) {
      this.field25268 = var1;
   }
}
