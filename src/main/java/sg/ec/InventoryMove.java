// Original binary: sg/ec/GLeNDKAH93llYY9A
package sg.ec;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.protocol.game.ClientboundContainerClosePacket;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class InventoryMove extends ClientModule {
   public KeyMapping[] field07861;
   private final List<InventoryMove.Nested102> field07862 = new CopyOnWriteArrayList<>();
   private final List<ItemStack> field07863 = new ArrayList<>();
   private ItemStack field07864 = ItemStack.EMPTY;
   private int field07865 = -1;
   private boolean field07866 = false;
   public final ToggleSetting field07867;
   public final ToggleSetting field07868;
   private static final String field07869 = "Замедлять";
   private static final String field07870 = "Обход Matrix";
   private static final String field07871 = "Inventory Move";

   public InventoryMove() {
      super(ModuleCategory.Player, ModuleSubCategory.Main);
      this.field07867 = new ToggleSetting(field07869).method03017(false).method03023(this);
      this.field07868 = new ToggleSetting(field07870).method03017(false).method03023(this);
      this.method03935(field07871);
   }

   private void method03540() {
      this.field07863.clear();
      this.field07864 = ItemStack.EMPTY;
      this.field07865 = -1;
   }

   @Subscribe
   public void method03541(ContainerClickEvent var1) {
      if (this.field07867.method05999()) {
         if (mc.gui.screen() instanceof InventoryScreen) {
            if (!this.field07866) {
               if (MovementUtils.method05733() || !this.field07862.isEmpty()) {
                  this.method03545(var1.method03776(), var1.method03777(), var1.method03773(), var1.method03771());
                  var1.method05695(true);
               }
            }
         }
      }
   }

   public int method03543(int var1) {
      return this.field07868.method05999() ? var1 + 1 : var1;
   }

   private void method03544() {
      if (this.field07865 != -1) {
         if (mc.player != null) {
            AbstractContainerMenu var1 = mc.player.containerMenu;
            if (method03546(this.field07865, var1.containerId, this.field07863.size(), var1.slots.size())) {
               for (int var2 = 0; var2 < var1.slots.size(); var2++) {
                  var1.slots.get(var2).set(this.field07863.get(var2));
               }
            }
         }
      }
   }

   private void method03545(int var1, int var2, int var3, ClickType var4) {
      if (mc.player != null) {
         if (this.field07862.isEmpty()) {
            this.method03553();
         }

         this.field07862.add(new InventoryMove.Nested102(var1, var2, var3, var4));
         mc.player.containerMenu.clicked(var2, var3, var4, mc.player);
      }
   }

   private static boolean method03546(int var0, int var1, int var2, int var3) {
      return var1 == var0 && var2 == var3;
   }

   private boolean method03547() {
      this.method03551();
      Window var1 = mc.getWindow();
      return Arrays.stream(this.field07861).anyMatch(var1x -> InputConstants.isKeyDown(var1x.getDefaultKey().getValue()));
   }

   @Subscribe
   public void method03548(PacketEvent var1) {
      if (this.field07867.method05999()) {
         if (mc.gui.screen() instanceof InventoryScreen && var1.method10897() instanceof ClientboundContainerClosePacket) {
            var1.method05695(true);
         }
      }
   }

   @Subscribe
   public void method03549(ContainerCloseEvent var1) {
      if (this.field07867.method05999()) {
         if (var1.method08156() instanceof InventoryScreen) {
            var1.method05696();
            this.method03555();
            InventoryActionManager.INSTANCE
               .method10470(
                  () -> {
                     if (!this.field07862.isEmpty()) {
                        this.field07866 = true;

                        try {
                           this.method03544();
                           this.field07862
                              .forEach(var0 -> mc.gameMode.handleContainerInput(var0.containerId(), var0.slotNum(), var0.buttonNum(), var0.input(), mc.player));
                           this.method03556();
                        } finally {
                           this.field07866 = false;
                        }

                        this.field07862.clear();
                     }

                     this.method03540();
                     mc.player.connection.send(new ServerboundContainerClosePacket(var1.method08159()));
                     mc.player.clientSideCloseContainer();
                  },
                  1,
                  true
               );
         }
      }
   }

   private void method03551() {
      if (this.field07861 == null) {
         this.field07861 = new KeyMapping[]{mc.options.keyUp, mc.options.keyDown, mc.options.keyLeft, mc.options.keyRight, mc.options.keyJump};
      }
   }

   private void method03552() {
      Arrays.stream(this.field07861).forEach(var0 -> var0.setDown(false));
   }

   private void method03553() {
      if (mc.player != null) {
         AbstractContainerMenu var1 = mc.player.containerMenu;
         this.field07863.clear();

         for (int var2 = 0; var2 < var1.slots.size(); var2++) {
            this.field07863.add(var1.slots.get(var2).getItem().copy());
         }

         this.field07865 = var1.containerId;
      }
   }

   private void method03555() {
      this.method03551();
      Window var1 = mc.getWindow();
      Arrays.stream(this.field07861).forEach(var1x -> var1x.setDown(InputConstants.isKeyDown(var1x.getDefaultKey().getValue())));
   }

   private void method03556() {
      if (mc.player != null) {
         AbstractContainerMenu var1 = mc.player.containerMenu;
      }
   }

   public boolean method03558() {
      return (this.field07867.method05999() || this.field07868.method05999()) && (MovementUtils.method05733() || this.method03547());
   }

   @Subscribe
   private void method03559(PlayerUpdateEvent var1) {
      this.method03551();
      if (mc.gui.screen() != null || ClientScreenManager.INSTANCE.method08316()) {
         if (InventoryInputPolicy.method01915(mc.gui.screen())) {
            this.method03552();
         } else {
            this.method03555();
         }
      }
   }

   // $VF: Compiled from s
   private record Nested102(int containerId, int slotNum, int buttonNum, ClickType input) {
   }
}
