// Original binary: sg/ec/CqgYVRiZvg6hqbpw
package sg.ec;

import com.google.common.hash.HashCode;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess.Frozen;
import net.minecraft.network.HashedStack;
import net.minecraft.network.HashedPatchMap.HashGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.network.protocol.game.ServerboundContainerButtonClickPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClickPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.resources.RegistryOps;
import net.minecraft.util.HashOps;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class BotContainerController {
   private final BotClient field06843;
   private AbstractContainerMenu field06844;
   private Component field06845 = Component.empty();
   private HashGenerator field06846;
   private Frozen field06847;

   public void method03038(ClientboundContainerSetContentPacket var1) {
      if (this.field06844 != null && this.field06844.containerId == var1.containerId()) {
         this.field06844.initializeContents(var1.stateId(), var1.items(), var1.carriedItem());
      }
   }

   public void method03039(int var1) {
      if (this.field06844 != null && this.field06844.containerId == var1) {
         this.method03044();
      }
   }

   public void method03041() {
      if (this.field06844 != null) {
         this.field06843.method00164(new ServerboundContainerClosePacket(this.field06844.containerId));
         this.method03044();
      }
   }

   public int method03042() {
      return this.field06844 == null ? 0 : this.field06844.containerId;
   }

   private Int2ObjectMap<HashedStack> method03043(NonNullList<Slot> var1, List<ItemStack> var2) {
      Int2ObjectOpenHashMap var3 = new Int2ObjectOpenHashMap();

      for (int var4 = 0; var4 < var1.size(); var4++) {
         ItemStack var5 = ((Slot)var1.get(var4)).getItem();
         if (!ItemStack.matches((ItemStack)var2.get(var4), var5)) {
            var3.put(var4, HashedStack.create(var5, this.method03046()));
         }
      }

      return var3;
   }

   private void method03044() {
      BotLocalPlayer var1 = this.field06843.method00090().method07688();
      if (var1 != null) {
         var1.containerMenu = var1.inventoryMenu;
      }

      this.field06844 = null;
      this.field06845 = Component.empty();
   }

   public void method03045() {
      this.field06844 = null;
      this.field06845 = Component.empty();
      this.field06846 = null;
      this.field06847 = null;
   }

   private HashGenerator method03046() {
      Frozen var1 = this.field06843.method00090().method07758();
      if (this.field06846 == null || this.field06847 != var1) {
         RegistryOps<HashCode> var2 = var1.createSerializationContext(HashOps.CRC32C_INSTANCE);
         this.field06846 = var1x -> ((HashCode)var1x.encodeValue(var2)
               .getOrThrow(var1xx -> new IllegalArgumentException("Не удалось захешировать " + var1x + ": " + var1xx)))
            .asInt();
         this.field06847 = var1;
      }

      return this.field06846;
   }

   public void method03047(ClientboundOpenScreenPacket var1) {
      BotLocalPlayer var2 = this.field06843.method00090().method07688();
      if (var2 != null) {
         AbstractContainerMenu var3 = var1.getType().create(var1.getContainerId(), var2.getInventory());
         if (var3 != null) {
            this.field06844 = var3;
            this.field06845 = var1.getTitle();
            var2.containerMenu = var3;
         }
      }
   }

   public boolean method03048() {
      return this.field06844 != null;
   }

   public void method03049(int var1) {
      if (this.field06844 != null) {
         this.field06843.method00164(new ServerboundContainerButtonClickPacket(this.field06844.containerId, var1));
      }
   }

   public BotContainerController(BotClient var1) {
      this.field06843 = var1;
   }

   public AbstractContainerMenu method03050() {
      return this.field06844;
   }

   public void method03051(ClientboundContainerSetSlotPacket var1) {
      if (this.field06844 != null && this.field06844.containerId == var1.getContainerId() && this.field06844.isValidSlotIndex(var1.getSlot())) {
         this.field06844.setItem(var1.getSlot(), var1.getStateId(), var1.getItem());
      }
   }

   public void method03053(int var1, int var2, ContainerInput var3) {
      BotLocalPlayer var4 = this.field06843.method00090().method07688();
      if (var4 != null) {
         AbstractContainerMenu var5 = this.field06844 != null ? this.field06844 : var4.inventoryMenu;
         NonNullList<Slot> var6 = var5.slots;
         List<ItemStack> var7 = new ArrayList<>(var6.size());

         for (Slot var9 : (Iterable<Slot>) (Iterable) var6) {
            var7.add(var9.getItem().copy());
         }

         ItemStack var13 = var5.getCarried().copy();
         var5.clicked(var1, var2, var3, var4);

         ServerboundContainerClickPacket var14;
         try {
            var14 = new ServerboundContainerClickPacket(
               var5.containerId,
               var5.getStateId(),
               (short)var1,
               (byte)var2,
               var3,
               this.method03043(var6, var7),
               HashedStack.create(var5.getCarried(), this.method03046())
            );
         } catch (RuntimeException var12) {
            for (int var11 = 0; var11 < var6.size(); var11++) {
               ((Slot)var6.get(var11)).set((ItemStack)var7.get(var11));
            }

            var5.setCarried(var13);
            throw var12;
         }

         this.field06843.method00164(var14);
      }
   }

   public Component method03054() {
      return this.field06845;
   }
}
