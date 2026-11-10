// Original binary: sg/ec/ykAEH7L2aczHqddC
package sg.ec;

import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;

// $VF: Compiled from s
public final class ServerItemUseController implements MinecraftAccess {
   private static final int field26494 = 90000;
   private static final int field26495 = 0;
   private static final int field26496 = 0;
   private static final int field26497 = 0;
   private boolean field26498;
   private ServerItemUseController.Nested326 field26499;
   private int field26500;
   private int field26501;
   private int field26502;
   private boolean field26503;
   private boolean field26504;
   private float field26505;
   private float field26506;
   private boolean field26507;
   private boolean field26508;
   private boolean field26509;
   private int field26510;
   private int field26511;
   private static final float field26512 = -1.0F;
   private static final float field26513 = 180.0F;
   private static final float field26514 = 90.0F;
   private static final float field26515 = 9999.0F;
   private static final int field26516 = 90000;

   public void method11647(Slot var1, boolean var2, float var3) {
      if (!this.field26498 && mc.player != null && mc.gameMode != null) {
         int var4 = var1.getContainerSlot();
         this.field26502 = mc.player.getInventory().getSelectedSlot();
         if (var4 == this.field26502) {
            this.field26499 = ServerItemUseController.Nested326.SELECTED;
         } else if (var4 >= 0 && var4 < 9) {
            this.field26499 = ServerItemUseController.Nested326.HOTBAR;
            this.field26501 = var4;
         } else {
            this.field26499 = ServerItemUseController.Nested326.INVENTORY;
            this.field26500 = var1.index;
         }

         this.field26503 = var2;
         if (var2) {
            float sx = MovementUtils.method05717();
            boolean sxx = sx != field26512;
            float sxxx = sxx ? sx : mc.player.getYRot();
            this.field26504 = true;
            this.field26505 = Mth.wrapDegrees(sxxx + field26513);
            this.field26506 = sxx ? var3 : field26514;
         } else {
            this.field26504 = false;
         }

         this.field26498 = true;
         this.field26507 = false;
         this.field26508 = false;
         this.field26509 = false;
         this.field26510 = 0;
         this.method11653();
      }
   }

   public void method11648(FrameUpdateEvent var1) {
      if (this.field26498 && this.field26504 && !this.field26507) {
         RotationManager.method06547(new Rotation(this.field26505, this.field26506), field26515, field26516, false);
      }
   }

   public void method11649() {
      this.field26498 = false;
      this.field26507 = false;
      this.field26503 = false;
      this.field26504 = false;
      this.field26508 = false;
      this.field26509 = false;
   }

   public boolean method11650() {
      return this.field26498;
   }

   private void method11651(int var1) {
      if (mc.player != null && mc.player.connection != null) {
         if (var1 >= 0 && var1 <= 8) {
            mc.player.connection.send(new ServerboundSetCarriedItemPacket(var1));
         }
      }
   }

   public void method11652(PlayerInputEvent var1) {
      if (this.field26498 && this.field26504 && !this.field26507 && this.field26499 != ServerItemUseController.Nested326.INVENTORY) {
         RotationManager.field14787 = true;
      }

      if (this.field26509 && mc.player != null && mc.player.onGround()) {
         this.field26509 = false;
         this.field26508 = true;
         var1.method11173(true);
      }
   }

   private void method11653() {
      switch (this.field26499) {
         case SELECTED:
            InventoryActionManager.INSTANCE.method10475(this::method11657, 0, false);
            break;
         case HOTBAR:
            InventoryActionManager.INSTANCE
               .method10475(() -> this.method11651(this.field26501), 0, false)
               .method07545()
               .method07536(this::method11657, 0, false)
               .method07545()
               .method07536(() -> this.method11651(this.field26502), 0, false);
            break;
         case INVENTORY:
            InventoryActionManager.INSTANCE
               .method10470(this::method11658, 1, false)
               .method07545()
               .method07536(this::method11657, 0, false)
               .method07545()
               .method07534(this::method11658, 1, false)
               .method07555(false);
      }
   }

   public void method11656() {
      if (this.field26498) {
         if (mc.player == null || mc.level == null) {
            this.method11649();
         } else if (this.field26507) {
            if (this.field26503 && !this.field26508) {
               if (this.field26510 >= this.field26511) {
                  this.field26509 = true;
               }

               this.field26510++;
               if (this.field26510 > 20) {
                  this.method11649();
               }
            } else {
               this.method11649();
            }
         }
      }
   }

   private void method11657() {
      if (mc.player != null && mc.gameMode != null) {
         InteractionHand var1 = InteractionHand.MAIN_HAND;
         mc.gameMode.useItem(mc.player, var1);
         mc.player.swing(var1);
         this.field26507 = true;
         this.field26510 = 0;
         this.field26511 = Math.max(1, 2 + ServerLatencyTracker.INSTANCE.method01667() - 1);
      }
   }

   private void method11658() {
      if (mc.player != null && mc.player.containerMenu != null && mc.gameMode != null) {
         int var1 = mc.player.containerMenu.containerId;
         mc.gameMode.handleInventoryMouseClick(var1, this.field26500, this.field26502, ClickType.SWAP, mc.player);
      }
   }

   // $VF: Compiled from s
   private enum Nested326 {
      SELECTED,
      HOTBAR,
      INVENTORY;
   }
}
