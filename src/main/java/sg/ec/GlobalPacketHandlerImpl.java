// Original binary: sg/ec/L4RACaLzRZuszg3s
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.ClickEvent.CopyToClipboard;
import net.minecraft.network.chat.HoverEvent.ShowText;

// $VF: Compiled from s
public class GlobalPacketHandlerImpl extends AbstractGlobalPacketHandler {
   private static final String field09751 = "Globals";
   private static final String field09752 = "Cloud";
   private static final String field09753 = ": ";
   private static final String field09754 = "Ключ для ";
   private static final String field09755 = "Нажми, чтобы скопировать ключ";
   private static final String field09756 = "Cloud";
   private static final String field09757 = "Cloud";
   private static final long field09758 = 1000L;

   private void method04353() {
      this.method04355(() -> System.exit(0));
   }

   public GlobalPacketHandlerImpl(GlobalWebSocketClient var1) {
      super(var1);
   }

   @Override
   public void method04354(ChatS2CPacket var1) {
      if (var1 != null) {
         if (var1.method02488() != null) {
            ModuleManager.INSTANCE.method08212().method07279(var1);
         }
      }
   }

   private void method04355(Runnable var1) {
      if (var1 != null) {
         if (MinecraftAccess.mc.isSameThread()) {
            var1.run();
         } else {
            MinecraftAccess.mc.execute(var1);
         }
      }
   }

   @Override
   public void method04356(VoiceS2CPacket var1) {
      if (var1 != null && var1.method08766() != null) {
         if (var1.method08766().method07566(this.method10047().getClientPlayer())) {
            VoiceAudioPlayer var2 = VoiceAudioPlayer.INSTANCE;
            switch (var1.method08769()) {
               case START:
                  var2.method02384(var1.method08773(), var1.method08767(), var1.method08768());
                  break;
               case STREAM:
                  var2.method02385(var1.method08774());
                  break;
               case STOP:
                  var2.method02388();
                  break;
               case VOLUME:
                  var2.method02389(var1.method08768());
                  break;
               case SEEK:
                  var2.method02386();
            }
         }
      }
   }

   @Override
   public void method04357(CloudDataS2CPacket var1) {
      super.method04357(var1);
      if (var1 != null && var1.method03837() != null) {
         if (var1.method03837().method07566(this.method10047().getClientPlayer())) {
            if (var1.method03841() && var1.method03843().length > 0) {
               if (StorageCategory.CONFIG == StorageCategory.method00554(var1.method03839())) {
                  ConfigMarketState.field13926.method06280(var1.method03840());
               }

               ChatTextUtils.method05101(field09752, "Загружено: " + var1.method03838());
            } else {
               String var2 = var1.method03840();
               if (var2 != null && !var2.isBlank()) {
                  int var3 = var2.lastIndexOf(field09753);
                  if (var2.startsWith(field09754) && var3 >= 0 && var3 + 2 < var2.length()) {
                     String var4 = var2.substring(0, var3 + 2);
                     String var5 = var2.substring(var3 + 2).trim();
                     KnownCloudConfigKeys.INSTANCE.method03165(var5);
                     MutableComponent var6 = Component.literal(var5)
                        .setStyle(
                           Style.EMPTY
                              .withColor(ColorUtils.method04604(120, 220, 140))
                              .withUnderlined(true)
                              .withHoverEvent(new ShowText(Component.literal(field09755)))
                              .withClickEvent(new CopyToClipboard(var5))
                        );
                     ChatTextUtils.method05096(field09756, Component.literal(var4).append(var6));
                  } else {
                     ChatTextUtils.method05101(field09757, var2);
                  }
               }

               if (var1.method03841()) {
                  this.method10047().getManager().method01792();
               }
            }
         }
      }
   }

   @Override
   public void method04358(ClientCommandS2CPacket var1) {
      if (var1 != null && var1.method09754() != null) {
         if (var1.method09754().method07566(this.method10047().getClientPlayer())) {
            this.method04355(() -> {
               if (var1.method09748().equals(ClientCommandS2CPacket.Nested272.USERS)) {
                  if (var1.method09749()) {
                     List var2 = var1.method09751() == null ? List.of() : new ArrayList<>(var1.method09751());
                     this.method10047().getManager().method01826(var2);
                  } else {
                     this.method10047().getManager().method01804(var1.method09751(), var1.method09747());
                  }
               }

               if (true) {
                  switch (var1.method09748()) {
                     case MESSAGE:
                        String var5 = var1.method09750();
                        if (var5 == null || var5.isBlank()) {
                           return;
                        }

                        ChatTextUtils.method05080(var5);
                        break;
                     case NETWORK_STOP:
                        long var4 = Math.max(1, var1.method09753()) * field09758;
                        PacketBufferManager.INSTNCE.method03609(var4);
                        break;
                     case DROP_ALL:
                        InventoryActionManager.INSTANCE.method10469(() -> PlayerUtils.method11828(MinecraftAccess.mc));
                        break;
                     case CURRENT_DROP:
                        InventoryActionManager.INSTANCE.method10469(() -> PlayerUtils.method11806(MinecraftAccess.mc));
                        break;
                     case CLOSE:
                        this.method04353();
                  }
               }
            });
         }
      }
   }

   @Override
   public void method04361(PartyCreateS2CPacket var1) {
      super.method04361(var1);
   }

   @Override
   public void method04362(ServerMessageS2CPacket var1) {
      if (Objects.equals(var1.method05690().method07586(), this.method10047().getClientPlayer().method07586())
         && Objects.equals(var1.method05690().method07590(), this.method10047().getClientPlayer().method07590())) {
         ChatTextUtils.method05101(field09751, var1.method05693());
      }
   }

   @Override
   public void method04363(WaypointSendS2CPacket var1) {
      float var2 = var1.method04752().method01656();
      float var3 = var1.method04752().method01647();
      float var4 = var1.method04752().method01651();
      String var5 = var1.method04755().method07586();
      WaypointManager.INSTANCE.method09831(var2, var3, var4, var5, System.currentTimeMillis());
   }
}
