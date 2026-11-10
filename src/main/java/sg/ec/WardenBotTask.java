// Original binary: sg/ec/7yFVaq4KDk3VAeiq
package sg.ec;

import hex.api.baritone.api.IBaritone;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.phys.BlockHitResult;

// $VF: Compiled from s
public final class WardenBotTask extends AbstractBotTask {
   private final BotClient field04467;
   private final WardenNavigationTask field04468;
   private final WardenLootTask field04469;
   private volatile BotTask field04470;
   private static final String field04471 = "WARDEN";
   private static final String field04472 = "WARDEN";

   @Override
   public int method01743() {
      return this.method01758().method01743();
   }

   @Override
   public void method01744(String var1) {
      this.method01758().method01744(var1);
   }

   @Override
   public int method01745() {
      return this.method01758().method01745();
   }

   public void method01746() {
      AbstractBotTask var1 = this.method01774() ? this.field04469 : this.field04468;
      if (this.field04470 != var1) {
         this.field04470 = var1;
         (var1 == this.field04469 ? this.field04468 : this.field04469).method01763();
      }
   }

   @Override
   public LocalPlayer method01747() {
      return this.method01758().method01747();
   }

   @Override
   public void method01748() {
      this.method01758().method01748();
   }

   public WardenLootTask method01749() {
      return this.field04469;
   }

   @Override
   public void method01750(BlockHitResult var1) {
      this.method01758().method01750(var1);
   }

   @Override
   public void method01751(String var1) {
      this.method01758().method01751(var1);
   }

   @Override
   public ClientLevel method01752() {
      return this.method01758().method01752();
   }

   @Override
   public void method01753(int var1) {
      this.field04467.method00137().method00472(var1);
      BotManager.INSTANCE.method03088();
   }

   @Override
   public void method01754(int var1) {
      this.field04467.method00137().method00496(var1);
      BotManager.INSTANCE.method03088();
   }

   @Override
   public void method01755(String var1) {
   }

   @Override
   public int method01756() {
      return this.method01758().method01756();
   }

   @Override
   public void method01757(boolean var1) {
      this.method01758().method01757(var1);
   }

   private BotTask method01758() {
      BotTask var1 = this.field04470;
      return var1 == null ? (this.method01774() ? this.field04469 : this.field04468) : var1;
   }

   @Override
   public void method01759(Runnable var1) {
      this.method01758().method01759(var1);
   }

   @Override
   public void method01760(int var1) {
      this.method01758().method01760(var1);
   }

   @Override
   public void method01761() {
      this.method01758().method01761();
   }

   @Override
   public Rotation method01762() {
      return this.method01758().method01762();
   }

   @Override
   public void method01763() {
      super.method01763();
      this.field04469.method01763();
      this.field04468.method01763();
   }

   @Override
   public WardenBotOptions method01764() {
      return this.method01758().method01764();
   }

   @Override
   public AbstractContainerMenu method01765() {
      return this.method01758().method01765();
   }

   @Override
   public WardenSpawnerTracker method01766() {
      return this.method01758().method01766();
   }

   @Override
   public void method01767(BlockPos var1, Direction var2) {
      this.method01758().method01767(var1, var2);
   }

   @Override
   public boolean method01768(int var1) {
      return this.field04467.method00137().method00474(var1);
   }

   public void method01769() {
      this.field04468.method07402();
   }

   @Override
   public void method01770(int var1) {
      this.method01758().method01770(var1);
   }

   @Override
   public void method01771() {
      this.method01758().method01771();
   }

   @Override
   public void method01772(Rotation var1, float var2) {
      this.method01758().method01772(var1, var2);
   }

   @Override
   public boolean method01773() {
      return this.method01758().method01773();
   }

   public boolean method01774() {
      return BotSessionManager.INSTANCE.method08733(this.field04467);
   }

   @Override
   public IBaritone method01775() {
      return this.field04467.method00107();
   }

   @Override
   public void method01776(int var1, int var2, ContainerInput var3) {
      this.method01758().method01776(var1, var2, var3);
   }

   @Override
   public boolean method01777() {
      return this.method01758().method01777();
   }

   @Override
   public boolean method01778() {
      return this.method01758().method01778();
   }

   public WardenBotTask(BotClient var1, WardenSpawnerTracker var2) {
      this.field04467 = var1;
      this.field04468 = new WardenNavigationTask(var1, var2);
      this.field04469 = new WardenLootTask(var2);
   }
}
