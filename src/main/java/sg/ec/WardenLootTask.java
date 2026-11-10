// Original binary: sg/ec/UarCVSV0s4J26f3h
package sg.ec;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.phys.BlockHitResult;

// $VF: Compiled from s
public final class WardenLootTask extends AbstractBotTask implements MinecraftAccess {
   private static final int field12529 = 2;
   private final WardenSpawnerTracker field12530;
   private volatile boolean field12531;
   private volatile int field12532;
   private static final float field12533 = Float.MAX_VALUE;
   private static final float field12534 = Float.MAX_VALUE;

   @Override
   public void method01751(String var1) {
      if (mc.player != null) {
         mc.player.connection.sendCommand(var1);
      }
   }

   @Override
   public int method01756() {
      return (int)ServerLatencyTracker.INSTANCE.method01666();
   }

   @Override
   public AbstractContainerMenu method01765() {
      return mc.screen instanceof AbstractContainerScreen var1 ? var1.getMenu() : null;
   }

   @Override
   public void method01757(boolean var1) {
      this.field12531 = var1;
   }

   @Override
   public boolean method01777() {
      return PvpTimerUtils.method06497();
   }

   @Override
   public void method01771() {
      AbstractContainerMenu var1 = this.method01765();
      if (var1 != null && mc.player != null) {
         int var2 = var1.containerId;
         mc.player.clientSideCloseContainer();
         PlayerUtils.method11812(new ServerboundContainerClosePacket(var2));
      }
   }

   @Override
   public int method01743() {
      return PvpTimerUtils.method06499();
   }

   @Override
   public Rotation method01762() {
      return new Rotation(RotationManager.method06563(), RotationManager.method06557());
   }

   @Override
   public int method01745() {
      return PvpTimerUtils.method06500();
   }

   @Override
   public void method01759(Runnable var1) {
      InventoryActionManager.INSTANCE.method10470(var1, 1, false);
   }

   @Override
   public WardenBotOptions method01764() {
      return WardenBotSettings.INSTANCE.method09333();
   }

   public WardenLootTask(WardenSpawnerTracker var1) {
      this.field12530 = var1;
   }

   @Override
   public LocalPlayer method01747() {
      return mc.player;
   }

   @Override
   public void method01748() {
      if (mc.player != null) {
         mc.player.swing(InteractionHand.MAIN_HAND);
      }
   }

   public boolean method05889() {
      return this.field12531;
   }

   @Override
   public void method01767(BlockPos var1, Direction var2) {
      if (mc.gameMode != null) {
         mc.gameMode.startDestroyBlock(var1, var2);
      }
   }

   @Override
   public void method01770(int var1) {
      this.field12532 = var1;
   }

   @Override
   public IBaritone method01775() {
      return BaritoneAPI.getProvider().getPrimaryBaritone();
   }

   @Override
   public void method01776(int var1, int var2, ClickType var3) {
      AbstractContainerMenu var4 = this.method01765();
      if (var4 == null) {
         InventoryUtils.method06123(var1, var2, var3, false);
      } else {
         InventoryUtils.method06137(var4.containerId, var1, var2, var3, mc.player);
      }
   }

   @Override
   public ClientLevel method01752() {
      return mc.level;
   }

   @Override
   public void method01772(Rotation var1, float var2) {
      RotationManager.method06547(var1, var2, 2, true);
   }

   @Override
   public void method01744(String var1) {
      ChatTextUtils.method05086(var1);
   }

   @Override
   public boolean method01778() {
      return InventoryActionManager.INSTANCE.method10476();
   }

   @Override
   public WardenSpawnerTracker method01766() {
      return this.field12530;
   }

   @Override
   public void method01750(BlockHitResult var1) {
      if (mc.gameMode != null && mc.player != null) {
         mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var1);
      }
   }

   @Override
   public void method01761() {
      if (mc.player != null) {
         InventoryUtils.method06110(InteractionHand.MAIN_HAND, field12533, field12534);
      }
   }

   @Override
   public boolean method01773() {
      return true;
   }

   @Override
   public void method01760(int var1) {
      if (mc.player != null) {
         mc.player.getInventory().setSelectedSlot(var1);
      }
   }

   public int method05890() {
      return this.field12532;
   }
}
