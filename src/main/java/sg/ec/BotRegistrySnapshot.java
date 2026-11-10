// Original binary: sg/ec/DutDtlE2kvWJpurg
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.core.Registry;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookRemovePacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookSettingsPacket;
import net.minecraft.network.protocol.game.ClientboundSelectAdvancementsTabPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAdvancementsPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateRecipesPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket.Entry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagNetworkSerialization.NetworkPayload;

// $VF: Compiled from s
public enum BotRegistrySnapshot {
   INSTANCE;

   private static final int field06990 = 4096;
   private final List<Entry> field06991 = new ArrayList<>();
   private volatile ClientboundUpdateRecipesPacket field06992;
   private volatile ClientboundRecipeBookSettingsPacket field06993;
   private volatile ClientboundUpdateAdvancementsPacket field06994;
   private volatile ClientboundSelectAdvancementsTabPacket field06995;
   private volatile Map<ResourceKey<? extends Registry<?>>, NetworkPayload> field06996 = Map.of();

   public void method03167(Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var1) {
      this.field06996 = RegistryDataMerger.method08046(this.field06996, var1);
   }

   public void method03168(ClientboundUpdateRecipesPacket var1) {
      this.field06992 = var1;
   }

   public void method03169(ClientboundRecipeBookAddPacket var1) {
      synchronized (this.field06991) {
         if (var1.replace()) {
            this.field06991.clear();
         }

         for (var var4 : var1.entries()) {
            if (this.field06991.size() < 4096) {
               this.field06991.add(var4);
            }
         }
      }
   }

   public void method03170(ClientboundRecipeBookRemovePacket var1) {
      synchronized (this.field06991) {
         this.field06991.removeIf(var1x -> var1.recipes().contains(var1x.contents().id()));
      }
   }

   public void method03171(ClientboundRecipeBookSettingsPacket var1) {
      this.field06993 = var1;
   }

   public void method03172(ClientboundUpdateAdvancementsPacket var1) {
      this.field06994 = var1;
   }

   public void method03173(ClientboundSelectAdvancementsTabPacket var1) {
      this.field06995 = var1;
   }

   public ClientboundRecipeBookAddPacket method03174() {
      synchronized (this.field06991) {
         return this.field06991.isEmpty() ? null : new ClientboundRecipeBookAddPacket(new ArrayList<>(this.field06991), true);
      }
   }

   public void method03175() {
      this.field06992 = null;
      this.field06993 = null;
      this.field06994 = null;
      this.field06995 = null;
      synchronized (this.field06991) {
         this.field06991.clear();
      }
   }

   public List<Entry> method03176() {
      return this.field06991;
   }

   public ClientboundUpdateRecipesPacket method03177() {
      return this.field06992;
   }

   public ClientboundRecipeBookSettingsPacket method03178() {
      return this.field06993;
   }

   public ClientboundUpdateAdvancementsPacket method03179() {
      return this.field06994;
   }

   public ClientboundSelectAdvancementsTabPacket method03180() {
      return this.field06995;
   }

   public Map<ResourceKey<? extends Registry<?>>, NetworkPayload> method03181() {
      return this.field06996;
   }
}
