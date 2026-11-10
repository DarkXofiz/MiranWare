// Original binary: sg/ec/mp1fBGOUC2gEZuq5
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class FloatingWindow implements MinecraftAccess {
   private final SmoothAnimation field21766 = new SmoothAnimation();
   private final SmoothAnimation field21767 = new SmoothAnimation();
   private final String field21768;
   private final String field21769;
   private float field21770;
   private float field21771;
   private float field21772;
   private float field21773;
   private boolean field21774;
   private boolean field21775;
   private boolean field21776;
   private boolean field21777 = true;
   private boolean field21778 = true;
   private ModuleContextMenu field21779;
   private final ElapsedTimer field21780 = new ElapsedTimer();
   private static final String field21781 = "unknown";
   private static final double field21782 = 1.15F;
   private static final double field21783 = 1.16F;
   private static final double field21784 = 0.25;
   private static final double field21785 = 0.25;
   private static final double field21786 = 1.16F;
   private static final String field21787 = "Window manager for '%s' is null";
   private static final double field21788 = 1.15F;

   public void method09557(boolean var1) {
      this.field21776 = var1;
   }

   public ElapsedTimer method09558() {
      return this.field21780;
   }

   public boolean method09559() {
      return this.field21777;
   }

   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      this.field21766.method06162();
      this.field21767.method06162();
      this.field21766.method06168(this.field21774 ? 1.0 : field21783, field21784, Easings.field19412, true);
      this.field21767.method06168(this.field21774 ? 1.0 : 0.0, field21785, Easings.field19412, true);
      if (this.field21766.method06159() == field21786) {
         this.field21779.method09655().remove(this);
         this.method06773();
      }

      if (this.field21779 == null) {
         throw new RuntimeException(field21787.formatted(this.getClass().getSimpleName()));
      }
   }

   public float method09560() {
      return this.field21771;
   }

   public void method09561(float var1) {
      this.field21773 = var1;
   }

   public FloatingWindow(String var1) {
      this(ModuleContextMenu.field21943.getOrDefault(var1, field21781), var1);
   }

   public String method09562() {
      return this.field21769;
   }

   public void method09563(float var1) {
      this.field21771 = var1;
   }

   public void method09564(boolean var1) {
      this.field21777 = var1;
   }

   public boolean method06786() {
      return false;
   }

   public boolean method01682() {
      return false;
   }

   public FloatingWindow(String var1, String var2) {
      this.field21768 = var1;
      this.field21769 = var2;
      this.field21766.method06175(field21782);
      this.field21775 = true;
      this.field21780.method04694();
   }

   public void method09565(boolean var1) {
      this.field21775 = var1;
   }

   public String method09566() {
      return this.field21768;
   }

   public void method09567(boolean var1) {
      this.field21778 = var1;
   }

   public float method09568() {
      return this.field21772;
   }

   public void method01689(double var1, double var3, int var5) {
   }

   public boolean method09569() {
      return this.field21774;
   }

   public void method06773() {
   }

   public boolean method09570() {
      return this.field21776;
   }

   public void method09571(float var1) {
      this.field21770 = var1;
   }

   public void method09572(boolean var1) {
      this.field21774 = var1;
   }

   public SmoothAnimation method09573() {
      return this.field21767;
   }

   public void method00611(int var1, int var2, int var3) {
   }

   public void method00613(double var1, double var3, int var5) {
   }

   public void method08971(float var1) {
      this.field21772 = var1;
   }

   public float method09574() {
      return this.field21773;
   }

   public void method04220() {
      this.field21766.method06175(field21788);
      this.field21775 = true;
      this.field21780.method04694();
   }

   public SmoothAnimation method09575() {
      return this.field21766;
   }

   public void method01685(double var1, double var3, double var5) {
   }

   public float method09576() {
      return this.field21770;
   }

   public void method09577(ModuleContextMenu var1) {
      this.field21779 = var1;
   }

   public boolean method01698() {
      return false;
   }

   public boolean method09578(double var1, double var3) {
      return GuiHitTestUtils.method05624((int)var1, (int)var3, this.field21770, this.field21771, this.field21772, this.field21773);
   }

   public boolean method09579() {
      return this.field21778;
   }

   public boolean method01686() {
      return this.field21775;
   }

   public ModuleContextMenu method09580() {
      return this.field21779;
   }

   public void method01898(char var1, int var2) {
   }
}
