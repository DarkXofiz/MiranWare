// Original binary: sg/ec/dH2XXPEF2ph4EW1A
package sg.ec;

import hex.api.baritone.api.IBaritone;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundTabListPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.phys.BlockHitResult;

// $VF: Compiled from s
public final class WardenNavigationTask extends AbstractBotTask {
   private static final float field18104 = 1.0F;
   private final BotClient field18105;
   private final WardenSpawnerTracker field18106;
   private Runnable field18107;
   private int field18108;
   private boolean field18109;
   private static final String field18110 = "WARDEN";
   private static final String field18111 = "WARDEN";
   private static final float field18112 = -90.0F;
   private static final float field18113 = 90.0F;

   @Override
   public void method01754(int var1) {
      this.field18105.method00137().method00496(var1);
      BotManager.INSTANCE.method03088();
   }

   @Override
   public AbstractContainerMenu method01765() {
      return this.field18105.method00135().method03050();
   }

   @Override
   public void method01750(BlockHitResult var1) {
      this.field18105.method00082().method06246(var1, InteractionHand.MAIN_HAND);
   }

   public void method07402() {
      if (this.field18108 > 0) {
         this.field18108--;
      } else {
         Runnable var1 = this.field18107;
         if (var1 != null) {
            this.field18107 = null;
            this.field18108 = 1;
            var1.run();
         }
      }
   }

   @Override
   public boolean method01773() {
      return false;
   }

   @Override
   public LocalPlayer method01747() {
      return this.field18105.method00090().method07688();
   }

   @Override
   public IBaritone method01775() {
      return this.field18105.method00107();
   }

   @Override
   public void method01772(Rotation var1, float var2) {
      BotPlayerState var3 = this.field18105.method00070();
      float var4 = Math.max(1.0F, var2);
      float var5 = var3.method08008() + Mth.clamp(Mth.wrapDegrees(var1.method09439() - var3.method08008()), -var4, var4);
      float var6 = Mth.clamp(var3.method08003() + Mth.clamp(var1.method09443() - var3.method08003(), -var4, var4), field18112, field18113);
      this.field18105.method00116(var5, var6);
   }

   @Override
   public void method01759(Runnable var1) {
      this.field18107 = var1;
   }

   @Override
   public void method01770(int var1) {
      this.field18105.method00089().method10878(var1);
   }

   @Override
   public void method01767(BlockPos var1, Direction var2) {
      this.field18105.method00082().method06249(var1, var2);
   }

   @Override
   public boolean method01768(int var1) {
      return this.field18105.method00137().method00474(var1);
   }

   @Override
   public void method01761() {
      BotLocalPlayer var1 = this.field18105.method00090().method07688();
      if (var1 != null) {
         this.field18105.method00082().method06269(InteractionHand.MAIN_HAND);
         var1.startUsingItem(InteractionHand.MAIN_HAND);
      }
   }

   @Override
   public int method01743() {
      ClientboundTabListPacket var1 = this.field18105.method00090().method07691();
      return var1 == null ? -1 : PvpTimerUtils.method06498(var1.header().getString());
   }

   @Override
   public void method01753(int var1) {
      this.field18105.method00137().method00472(var1);
      BotManager.INSTANCE.method03088();
   }

   @Override
   public int method01756() {
      return this.field18105.method00090().method07764();
   }

   public WardenNavigationTask(BotClient var1, WardenSpawnerTracker var2) {
      this.field18105 = var1;
      this.field18106 = var2;
   }

   @Override
   public WardenSpawnerTracker method01766() {
      return this.field18106;
   }

   @Override
   public boolean method01778() {
      return this.field18107 != null || this.field18108 > 0;
   }

   @Override
   public void method01776(int var1, int var2, ContainerInput var3) {
      this.field18105.method00135().method03053(var1, var2, var3);
   }

   @Override
   public void method01771() {
      this.field18105.method00135().method03041();
   }

   @Override
   public void method01757(boolean var1) {
      if (this.field18109 != var1) {
         this.field18109 = var1;
         if (!var1) {
            this.field18105.method00082().method06270();
         }
      }
   }

   @Override
   public boolean method02630() {
      return this.field18105.method00070().method07955() != null && !this.field18105.method00070().method07990();
   }

   @Override
   public boolean method01777() {
      return PvpTimerUtils.method06501(this.field18105.method00090().method07685().values());
   }

   @Override
   public void method01760(int var1) {
      this.field18105.method00082().method06272(var1);
   }

   @Override
   public Rotation method01762() {
      BotPlayerState var1 = this.field18105.method00070();
      return !this.field18105.method00078()
         ? new Rotation(var1.method08008(), var1.method08003())
         : new Rotation(this.field18105.method00097(), this.field18105.method00071());
   }

   @Override
   public ClientLevel method01752() {
      return this.field18105.method00090().method07636();
   }

   @Override
   public int method01745() {
      return PvpTimerUtils.method06496(this.field18105.method00090().method07685().values());
   }

   @Override
   public void method01748() {
      this.field18105.method00082().method06265(InteractionHand.MAIN_HAND);
   }

   @Override
   public void method01744(String var1) {
      this.field18105.method00066(Component.literal(var1));
   }

   @Override
   public WardenBotOptions method01764() {
      return WardenBotSettings.INSTANCE.method09333();
   }

   @Override
   public void method01751(String var1) {
      String.valueOf("команда /" + var1);
      this.field18105.method00144("/" + var1);
   }
}
