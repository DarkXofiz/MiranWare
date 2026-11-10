// Original binary: sg/ec/goBdRmBrKZDfMQmg
package sg.ec;

// $VF: Compiled from s
public final class AutoBuySettings {
   public static final AutoBuySettings field19624 = new AutoBuySettings();
   private int field19625 = 40;
   private boolean field19626 = true;
   private boolean field19627 = true;
   private int field19628 = 4;
   private boolean field19629;
   private String field19630;
   private AutoBuySettings.Nested239 field19631;
   private boolean field19632;
   private boolean field19633;
   private boolean field19634;
   private boolean field19635;
   private boolean field19636;
   private float field19637;
   private float field19638;
   private boolean field19639;
   private float field19640;
   private boolean field19641;
   private boolean field19642;
   private float field19643;
   private String field19644;
   private float field19645;
   private int field19646;
   private int field19647;
   private static final String field19648 = "ah";
   private static final float field19649 = 5.0F;
   private static final float field19650 = 100.0F;
   private static final float field19651 = 50.0F;
   private static final float field19652 = 10.0F;
   private static final double field19653 = 60000.0;
   private static final double field19654 = 60000.0;
   private static final long field19655 = 60000L;
   private static final float field19656 = 0.5F;
   private static final float field19657 = 120.0F;
   private static final float field19658 = 200.0F;
   private static final float field19659 = 60.0F;
   private static final float field19660 = 5.0F;
   private static final float field19661 = 95.0F;
   private static final float field19662 = 200.0F;
   private static final String field19663 = "ah";

   public boolean method08536() {
      return this.field19644 != null && !this.field19644.isBlank();
   }

   public float method08537() {
      return this.field19645;
   }

   public float method08538() {
      return this.field19640;
   }

   public long method08539() {
      return this.field19647 * field19655;
   }

   public long method08540() {
      return Math.round(this.field19645 * field19654);
   }

   public boolean method08541() {
      return this.field19626;
   }

   public void method08542(boolean var1) {
      this.field19636 = var1;
   }

   public void method08543(boolean var1) {
      this.field19626 = var1;
   }

   public String method08544() {
      return this.field19644;
   }

   public void method08545(float var1) {
      this.field19638 = Math.max(1.0F, Math.min(field19658, var1));
   }

   public void method08546(boolean var1) {
      this.field19629 = var1;
   }

   public void method08547(float var1) {
      this.field19645 = Math.max(1.0F, Math.min(field19659, var1));
   }

   public int method08548() {
      return this.field19646;
   }

   public boolean method08549() {
      return this.field19641;
   }

   public void method08550(String var1) {
      this.field19630 = var1 != null && !var1.isBlank() ? var1.trim() : field19663;
   }

   public boolean method08551() {
      return this.field19634;
   }

   public boolean method08552() {
      return this.field19639;
   }

   public float method08553() {
      return this.field19637;
   }

   public int method08554() {
      return this.field19628;
   }

   public void method08555(int var1) {
      this.field19628 = Math.max(0, Math.min(64, var1));
   }

   public String method08556() {
      return this.field19630;
   }

   public boolean method08557() {
      return this.field19642;
   }

   public boolean method08558() {
      return this.field19632;
   }

   public int method08559() {
      return this.field19625;
   }

   public void method08560(String var1) {
      this.field19644 = var1 == null ? "" : var1.trim();
   }

   public void method08561(boolean var1) {
      this.field19632 = var1;
   }

   public void method08562(int var1) {
      this.field19625 = Math.max(1, Math.min(1000, var1));
   }

   public long method08563() {
      return Math.round(this.field19637 * field19653);
   }

   public void method08564(float var1) {
      this.field19640 = Math.max(field19660, Math.min(field19661, var1));
   }

   public float method08565() {
      return this.field19643;
   }

   public void method08566(boolean var1) {
      this.field19639 = var1;
   }

   public void method08567(boolean var1) {
      this.field19627 = var1;
   }

   public void method08568(float var1) {
      this.field19637 = Math.max(field19656, Math.min(field19657, var1));
   }

   public boolean method08569() {
      return this.field19627;
   }

   public void method08570(boolean var1) {
      this.field19633 = var1;
   }

   public void method08571(boolean var1) {
      this.field19641 = var1;
   }

   public void method08572(int var1) {
      this.field19646 = Math.max(0, Math.min(32, var1));
   }

   public boolean method08573() {
      return this.field19636;
   }

   public float method08574() {
      return this.field19638;
   }

   public void method08575(int var1) {
      this.field19647 = Math.max(0, Math.min(180, var1));
   }

   public AutoBuySettings.Nested239 method08576() {
      return this.field19631;
   }

   public boolean method08577() {
      return this.field19633;
   }

   public void method08578(boolean var1) {
      this.field19634 = var1;
   }

   public boolean method08579() {
      return this.field19635;
   }

   public boolean method08580() {
      return this.field19629;
   }

   private AutoBuySettings() {
      this.field19630 = field19648;
      this.field19631 = AutoBuySettings.Nested239.KEEP;
      this.field19632 = true;
      this.field19633 = true;
      this.field19637 = field19649;
      this.field19638 = field19650;
      this.field19640 = field19651;
      this.field19644 = "";
      this.field19645 = field19652;
   }

   public void method08581(boolean var1) {
      this.field19635 = var1;
   }

   public void method08582(AutoBuySettings.Nested239 var1) {
      this.field19631 = var1;
   }

   public void method08583(float var1) {
      this.field19643 = Math.max(0.0F, Math.min(field19662, var1));
   }

   public void method08584(boolean var1) {
      this.field19642 = var1;
   }

   public int method08585() {
      return this.field19647;
   }

   // $VF: Compiled from s
   public enum Nested239 {
      KEEP("Не менять"),
      AUCTION("Аукцион"),
      TRADES("Торги"),
      BIDS("Ставки");

      public final String field19664;

      Nested239(String var3) {
         this.field19664 = var3;
      }
   }
}
