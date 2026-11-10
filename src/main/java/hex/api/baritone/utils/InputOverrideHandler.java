// Original binary: hex/api/baritone/utils/InputOverrideHandler
package hex.api.baritone.utils;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.event.events.TickEvent;
import hex.api.baritone.api.utils.IInputOverrideHandler;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.behavior.Behavior;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.player.KeyboardInput;

// $VF: Compiled from s
public final class InputOverrideHandler extends Behavior implements IInputOverrideHandler {
   private final Map<Input, Boolean> inputForceStateMap = new HashMap<>();
   private boolean forcedSprint;
   private final BlockBreakHelper blockBreakHelper;
   private final BlockPlaceHelper blockPlaceHelper;

   @Override
   public final void setInputForceState(Input var1, boolean var2) {
      this.inputForceStateMap.put(var1, var2);
   }

   public InputOverrideHandler(Baritone var1) {
      super(var1);
      this.blockBreakHelper = new BlockBreakHelper(var1.getPlayerContext());
      this.blockPlaceHelper = new BlockPlaceHelper(var1.getPlayerContext());
   }

   public BlockBreakHelper getBlockBreakHelper() {
      return this.blockBreakHelper;
   }

   @Override
   public final void setForcedSprint(boolean var1) {
      this.forcedSprint = var1;
   }

   @Override
   public final boolean isForcedSprint() {
      return this.forcedSprint;
   }

   @Override
   public final boolean isInputForcedDown(Input var1) {
      return var1 == null ? false : this.inputForceStateMap.getOrDefault(var1, false);
   }

   private boolean inControl() {
      for (Input var4 : new Input[]{Input.MOVE_FORWARD, Input.MOVE_BACK, Input.MOVE_LEFT, Input.MOVE_RIGHT, Input.SNEAK, Input.JUMP}) {
         if (this.isInputForcedDown(var4)) {
            return true;
         }
      }

      return this.baritone.getPathingBehavior().isPathing();
   }

   @Override
   public final void onTick(TickEvent var1) {
      if (var1.getType() != TickEvent.Type.OUT) {
         if (this.isInputForcedDown(Input.CLICK_LEFT)) {
            this.setInputForceState(Input.CLICK_RIGHT, false);
         }

         this.blockBreakHelper.tick(this.isInputForcedDown(Input.CLICK_LEFT));
         this.blockPlaceHelper.tick(this.isInputForcedDown(Input.CLICK_RIGHT));
         boolean var2 = this.ctx.player() != null && this.ctx.player() == this.ctx.minecraft().player && this.ctx.minecraft().isSameThread();
         if (var2) {
            if (this.inControl()) {
               if (this.ctx.player().input.getClass() != PlayerMovementInput.class) {
                  this.ctx.player().input = new PlayerMovementInput(this);
               }
            } else if (this.ctx.player().input.getClass() == PlayerMovementInput.class) {
               this.ctx.player().input = new KeyboardInput(this.ctx.minecraft().options);
            }
         }
      }
   }

   @Override
   public final void clearAllKeys() {
      this.inputForceStateMap.clear();
      this.forcedSprint = false;
   }
}
