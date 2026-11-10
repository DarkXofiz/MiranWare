// Original binary: sg/mx/N9BiJ0TLuv5P30gd
package sg.mx;

import com.mojang.brigadier.CommandDispatcher;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.client.multiplayer.LevelLoadTracker;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.LastSeenMessagesTracker;
import net.minecraft.network.chat.MessageSignatureCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ClientPacketListener.class)
public interface ClientPacketListenerMixin {
   @Accessor("playerInfoMap")
   Map<UUID, PlayerInfo> getPlayerInfoMap();

   @Accessor("listedPlayers")
   Set<PlayerInfo> getListedPlayers();

   @Accessor("clientLoaded")
   void markClientLoaded(boolean var1);

   @Accessor("levelLoadTracker")
   void setLevelLoadTracker(LevelLoadTracker var1);

   @Accessor("commands")
   CommandDispatcher<ClientSuggestionProvider> getCommandDispatcher();

   @Accessor("commands")
   void setCommandDispatcher(CommandDispatcher<ClientSuggestionProvider> var1);

   @Accessor("serverChunkRadius")
   int getServerChunkRadius();

   @Accessor("serverSimulationDistance")
   int getServerSimulationDistance();

   @Accessor("nextChatIndex")
   int getNextChatIndex();

   @Accessor("nextChatIndex")
   void setNextChatIndex(int var1);

   @Accessor("lastSeenMessages")
   LastSeenMessagesTracker getLastSeenMessages();

   @Accessor("lastSeenMessages")
   void setLastSeenMessages(LastSeenMessagesTracker var1);

   @Accessor("messageSignatureCache")
   MessageSignatureCache getMessageSignatureCache();

   @Accessor("messageSignatureCache")
   void setMessageSignatureCache(MessageSignatureCache var1);
}
