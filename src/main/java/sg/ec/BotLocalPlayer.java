// Original binary: sg/ec/RBBDFkW4T5xThwu4
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.syncher.SynchedEntityData.DataValue;
import net.minecraft.stats.StatsCounter;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.level.GameType;
import sg.mx.LocalPlayerMixin_1170;

// $VF: Compiled from s
public final class BotLocalPlayer extends LocalPlayer {
   private GameType field11398 = GameType.SURVIVAL;
   private boolean field11399;
   private final SprintStateTracker field11400 = new SprintStateTracker();
   private int field11401;

   @Override
   protected void updateAutoJump(float var1, float var2) {
   }

   public void ridingTick() {
      this.setOldPosAndRot();
      this.tickCount++;
      this.rideTick();
   }

   public boolean isSynced() {
      return this.field11399;
   }

   @Override
   protected boolean isControlledCamera() {
      return true;
   }

   public BotLocalPlayer(Minecraft var1, BotClientLevel var2, ClientPacketListener var3) {
      super(var1, var2, var3, new StatsCounter(), new ClientRecipeBook(), Input.EMPTY, false);
      this.input = new BotKeyboardInput();
      ((LocalPlayerMixin_1170)(Object)this).ambientSoundHandlers().clear();
   }

   public void setGameType(GameType var1) {
      this.field11398 = var1;
   }

   public void seedSentBaseline(BotPlayerState var1) {
      LocalPlayerMixin_1170 var2 = (LocalPlayerMixin_1170)(Object)this;
      var2.setWasSprinting(var1.method07969());
      if (var1.method07995()) {
         var2.setLastX(var1.method08018());
         var2.setLastY(var1.method08017());
         var2.setLastZ(var1.method08020());
         var2.setLastYRot(var1.method07992());
         var2.setLastXRot(var1.method07976());
         var2.setLastOnGround(var1.method07997());
         var2.setLastHorizontalCollision(var1.method07978());
         var2.setPositionReminder(var1.method07949());
      } else {
         var2.setLastX(var1.method08006());
         var2.setLastY(var1.method07981());
         var2.setLastZ(var1.method08004());
         var2.setLastYRot(var1.method08008());
         var2.setLastXRot(var1.method08003());
         var2.setLastOnGround(var1.method07991());
         var2.setLastHorizontalCollision(var1.method07986());
         var2.setPositionReminder(0);
      }
   }

   public void physicsTick() {
      this.setOldPosAndRot();
      this.tickCount++;
      this.tick();
   }

   @Override
   public GameType gameMode() {
      return this.field11398;
   }

   public void armSprintResync() {
      this.field11400.method04930(this);
   }

   public void aimFrom(BotPlayerState var1) {
      this.setYRot(var1.method08008());
      this.setXRot(var1.method08003());
      this.setYHeadRot(var1.method08008());
   }

   public void setInput(Input var1) {
      this.field11400.method04929(this);
      if (this.field11401 > 0) {
         this.field11401--;
         var1 = new Input(var1.forward(), var1.backward(), var1.left(), var1.right(), var1.jump(), var1.shift(), false);
      }

      ((BotKeyboardInput)this.input).apply(var1);
   }

   public void syncFrom(BotPlayerState var1) {
      this.snapTo(var1.method08006(), var1.method07981(), var1.method08004(), var1.method08008(), var1.method08003());
      this.setOldPosAndRot();
      this.setYHeadRot(var1.method08008());
      this.setOnGround(var1.method07991());
      this.setDeltaMovement(var1.method07994(), var1.method07947(), var1.method07948());
      if (!this.field11399) {
         this.fallDistance = 0.0;
      }

      this.field11399 = true;
   }

   public void applyMetadata(List<DataValue<?>> var1) {
      if (ModuleManager.INSTANCE.method08222().method02966(this) && this.field11400.method04932(this, var1)) {
         this.setSprinting(false);
         this.field11401 = 1;
      }

      var var2 = new ArrayList(var1.size());

      for (DataValue var4 : var1) {
         if (var4.id() != DATA_SHARED_FLAGS_ID.id()) {
            var2.add(var4);
         }
      }

      if (!var2.isEmpty()) {
         this.getEntityData().assignValues(var2);
      }
   }
}
