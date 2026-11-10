// Original binary: sg/ec/Lxe3A7L2BZloqOLz
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess.Frozen;
import net.minecraft.core.RegistrySynchronization.PackedRegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.Connection;
import net.minecraft.network.DisconnectionDetails;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.common.ClientboundClearDialogPacket;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.ClientboundCustomReportDetailsPacket;
import net.minecraft.network.protocol.common.ClientboundDisconnectPacket;
import net.minecraft.network.protocol.common.ClientboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ClientboundPingPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPopPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.network.protocol.common.ClientboundServerLinksPacket;
import net.minecraft.network.protocol.common.ClientboundShowDialogPacket;
import net.minecraft.network.protocol.common.ClientboundStoreCookiePacket;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;
import net.minecraft.network.protocol.common.ClientboundUpdateTagsPacket;
import net.minecraft.network.protocol.common.ServerboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ServerboundPongPacket;
import net.minecraft.network.protocol.common.custom.BrandPayload;
import net.minecraft.network.protocol.configuration.ClientConfigurationPacketListener;
import net.minecraft.network.protocol.configuration.ClientboundCodeOfConductPacket;
import net.minecraft.network.protocol.configuration.ClientboundFinishConfigurationPacket;
import net.minecraft.network.protocol.configuration.ClientboundRegistryDataPacket;
import net.minecraft.network.protocol.configuration.ClientboundResetChatPacket;
import net.minecraft.network.protocol.configuration.ClientboundSelectKnownPacks;
import net.minecraft.network.protocol.configuration.ClientboundUpdateEnabledFeaturesPacket;
import net.minecraft.network.protocol.configuration.ServerboundAcceptCodeOfConductPacket;
import net.minecraft.network.protocol.configuration.ServerboundFinishConfigurationPacket;
import net.minecraft.network.protocol.configuration.ServerboundSelectKnownPacks;
import net.minecraft.network.protocol.cookie.ClientboundCookieRequestPacket;
import net.minecraft.network.protocol.cookie.ServerboundCookieResponsePacket;
import net.minecraft.network.protocol.game.GameProtocols;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagNetworkSerialization.NetworkPayload;
import net.minecraft.world.flag.FeatureFlags;

// $VF: Compiled from s
public final class BotConfigurationPacketListener implements ClientConfigurationPacketListener {
   private static final long field09981 = 1400L;
   private final BotClient field09982;
   private final Connection field09983;
   private final Map<ResourceKey<? extends Registry<?>>, List<PackedRegistryEntry>> field09984 = new HashMap<>();
   private final Map<ResourceKey<? extends Registry<?>>, NetworkPayload> field09985 = new HashMap<>();
   private static final long field09986 = 1400L;
   private static final String field09987 = "REGISTRY";
   private static final String field09988 = "Реестры сервера не разобраны";
   private static final String field09989 = "Реестры не собрались";
   private static final String field09990 = "REGISTRY";
   private static final String field09991 = "используем прошлый снапшот реестров";
   private static final String field09992 = "REGISTRY";
   private static final String field09993 = "KICK-CONFIG";

   @Override
   public void handleTransfer(ClientboundTransferPacket var1) {
      this.field09982.method00122(var1.host(), var1.port());
   }

   @Override
   public void handleResourcePackPop(ClientboundResourcePackPopPacket var1) {
   }

   @Override
   public void onDisconnect(DisconnectionDetails var1) {
      this.field09982.method00119(var1.reason().getString());
   }

   @Override
   public void handleShowDialog(ClientboundShowDialogPacket var1) {
   }

   @Override
   public void handleCustomPayload(ClientboundCustomPayloadPacket var1) {
      if (var1.payload() instanceof BrandPayload var2) {
         this.field09982.method00090().method07751(var2.brand());
      }
   }

   @Override
   public void handlePing(ClientboundPingPacket var1) {
      this.field09983.send(new ServerboundPongPacket(var1.getId()));
   }

   @Override
   public void handleClearDialog(ClientboundClearDialogPacket var1) {
   }

   @Override
   public void handleServerLinks(ClientboundServerLinksPacket var1) {
   }

   @Override
   public void handleCodeOfConduct(ClientboundCodeOfConductPacket var1) {
      BotPacketDispatcher.method09318(this.field09982.method00156(), () -> {
         if (this.field09983.isConnected() && this.field09983.getPacketListener() instanceof BotConfigurationPacketListener) {
            this.field09983.send(ServerboundAcceptCodeOfConductPacket.INSTANCE);
         }
      }, field09986);
   }

   public BotConfigurationPacketListener(BotClient var1, Connection var2) {
      this.field09982 = var1;
      this.field09983 = var2;
   }

   @Override
   public void handleUpdateTags(ClientboundUpdateTagsPacket var1) {
      this.field09985.putAll(var1.tags());
      this.field09982.method00090().method07797(var1.tags());
   }

   @Override
   public void handleResourcePackPush(ClientboundResourcePackPushPacket var1) {
      BotPacketDispatcher.method09320(this.field09982.method00156(), this.field09983, var1.id());
   }

   @Override
   public void handleConfigurationFinished(ClientboundFinishConfigurationPacket var1) {
      Frozen var2;
      try {
         var2 = RegistryDataMerger.method08062(this.field09984, this.field09985);
      } catch (Throwable var5) {
         String.valueOf("реестры не собрались: " + var5);
         Frozen var4 = this.field09982.method00090().method07758();
         if (var4 == null) {
            this.field09982.method00126(field09988);
            this.field09982.method00102(field09989);
            return;
         }

         var2 = var4;
      }
String.valueOf(
      "биомов " + var2.lookupOrThrow(Registries.BIOME).size());
      this.field09982.method00090().method07726(var2);
      this.field09983
         .setupInboundProtocol(
            GameProtocols.CLIENTBOUND_TEMPLATE.bind(RegistryFriendlyByteBuf.decorator(var2)), new BotPlayPacketListener(this.field09982, this.field09983)
         );
      this.field09983.send(ServerboundFinishConfigurationPacket.INSTANCE);
      this.field09983.setupOutboundProtocol(GameProtocols.SERVERBOUND_TEMPLATE.bind(RegistryFriendlyByteBuf.decorator(var2), ScriptContextImpl.field20130));
   }

   @Override
   public void handleDisconnect(ClientboundDisconnectPacket var1) {
      var1.reason().getString();
      this.field09982.method00126(var1.reason().getString());
      this.field09982.method00102(var1.reason().getString());
   }

   @Override
   public void handleCustomReportDetails(ClientboundCustomReportDetailsPacket var1) {
   }

   @Override
   public void handleRegistryData(ClientboundRegistryDataPacket var1) {
      this.field09984.computeIfAbsent(var1.registry(), var0 -> new ArrayList<>()).addAll(var1.entries());
   }

   @Override
   public boolean isAcceptingMessages() {
      return this.field09983.isConnected();
   }

   @Override
   public void handleSelectKnownPacks(ClientboundSelectKnownPacks var1) {
      this.field09983.send(new ServerboundSelectKnownPacks(List.of()));
   }

   @Override
   public void handleEnabledFeatures(ClientboundUpdateEnabledFeaturesPacket var1) {
      this.field09982.method00090().method07759(FeatureFlags.REGISTRY.fromNames(var1.features()));
   }

   @Override
   public void handleRequestCookie(ClientboundCookieRequestPacket var1) {
      this.field09983.send(new ServerboundCookieResponsePacket(var1.key(), this.field09982.method00168(var1.key())));
   }

   @Override
   public void handleKeepAlive(ClientboundKeepAlivePacket var1) {
      this.field09983.send(new ServerboundKeepAlivePacket(var1.getId()));
      this.field09982.method00106(var1.getId());
   }

   @Override
   public void handleResetChat(ClientboundResetChatPacket var1) {
   }

   @Override
   public void handleStoreCookie(ClientboundStoreCookiePacket var1) {
      this.field09982.method00134(var1.key(), var1.payload());
   }

   @Override
   public void handlePostEffects(net.minecraft.network.protocol.common.ClientboundPostEffectsPacket var1) {
   }
}
