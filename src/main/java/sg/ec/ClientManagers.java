// Original binary: sg/ec/PM4lU9BXckJEDnCG
package sg.ec;

import hex.api.baritone.HexBaritone;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents.ClientStopping;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;
import sg.mx.ScreenMixin;

// $VF: Compiled from s
public class ClientManagers implements MinecraftAccess {
   private static final long field10927 = 100L;
   private static final float field10928 = 0;
   private static final long field10929 = 0;
   private long field10930 = Util.getNanos();
   private int field10931 = 0;
   private boolean field10932 = false;
   private static final long field10933 = 0;
   private long field10934 = Util.getNanos();
   private int field10935 = 0;
   private static final String field10936 = "Включен";
   private static final String field10937 = "Выключен";
   private static final long field10938 = 2000L;
   private static final long field10939 = 2000L;
   private static final String field10940 = "Выбросить всё";
   private static final long field10941 = 100L;
   private static final float field10942 = 0.05F;
   private static final long field10943 = 16666666L;
   private static final long field10944 = 16666666L;
   private static final long field10945 = 16666666L;
   private static final long field10946 = 4166666L;
   private static final long field10947 = 4166666L;
   private static final String field10948 = "NoTrace";
   private static final String field10949 = "Theme";

   private void method04967() {
      CustomResourceManager.INSTANCE.method02465(field10948);
      CustomResourceManager.INSTANCE.method02465(field10949);
   }

   @Subscribe
   private void method04968(TickEvent var1) {
      GlobalWebSocketClient var2 = MiranWare.getInstance().getClient();
      if (var2 != null && mc.player != null) {
         if (var2.getManager().method01805() != null) {
            GlobalPlayer var3 = var2.getClientPlayer();
            if (var3 != null) {
               Party var4 = var2.getManager().method01805();
               boolean var5 = var4.method10148().size() > 1;
               double var6 = mc.player.getX();
               double var8 = mc.player.getY();
               double var10 = mc.player.getZ();
               if (!Double.isFinite(var6) || !Double.isFinite(var8) || !Double.isFinite(var10)) {
                  return;
               }

               var3.method07567(mc.getUser().getName());
               var3.method07568(ProfileAPI.get().getModel().getName());
               var3.method07577(GlobalConnectionManager.field08653);
               var3.method07582().field03984 = (float)var6;
               var3.method07582().field03985 = (float)var8;
               var3.method07582().field03986 = (float)var10;
               method04977(var4, var3);
               boolean var12 = var3.method07576();
               if (!var5 && !var12) {
                  return;
               }

               boolean var13 = var5 && var3.method07604(field10941, field10942);
               if (var12 || var13) {
                  PartyUpdateC2SPacket var14 = new PartyUpdateC2SPacket(var3, var12, var13);
                  if (!var14.method01433()) {
                     return;
                  }

                  var2.getManager().method01823(var14);
                  var3.method07597(var12, var13);
               }
            }
         }
      }
   }

   @Subscribe
   private void method04969(TickEvent var1) {
      GlobalWebSocketClient var2 = MiranWare.getInstance().getClient();
      if (var2 != null) {
         var2.getManager().method01815();
      }

      StreamerNameUtils.method03483();
      ChatMessagePolicy.method04010();
   }

   @Subscribe
   private void method04970(ToggleStateEvent var1) {
      NotificationHud var2 = ModuleManager.INSTANCE.method08274().method04953().method00017(NotificationHud.class);
      Object var3 = var1.method06763();
      ToggleStateEvent.Nested198 var4 = var1.method06761();
      ToggleStateEvent.Nested197 var5 = var1.method06767();
      boolean var6 = var2.method01424().method03022();
      boolean var7 = var4 == ToggleStateEvent.Nested198.ENABLE;
      NotificationType var8 = var7 ? NotificationType.ENABLE : NotificationType.DISABLE;
      ModuleSoundAction var9 = var7 ? ModuleSoundAction.ENABLE : ModuleSoundAction.DISABLE;
      String var10 = var7 ? field10936 : field10937;
      if (var6) {
         if (var5 == ToggleStateEvent.Nested197.MODULE
            && var3 instanceof ToggleableModule var11
            && !(var11 instanceof ClickGUI)
            && var11.method03930().method05873()) {
            NotificationManager.method08615(var11.method03925() + " " + var10 + "!", field10938, var8, var9);
         }

         if (var5 == ToggleStateEvent.Nested197.CHECKBOX
            && var3 instanceof ToggleSetting var12
            && var12.method05997().method05871() != -1
            && var12.method05997().method05873()) {
            NotificationManager.method08615(var12.method03024() + " " + var10 + "!", field10939, var8, var9);
         }
      }
   }

   public ClientManagers() {
      EventBus.method00263(this);
      this.method04981();
   }

   @Subscribe
   private void method04972(PlayerUpdateEvent var1) {
      GlobalWebSocketClient var2 = MiranWare.getInstance().getClient();
      if (var2 != null) {
         Party var3 = var2.getManager().method01805();
         if (var3 != null) {
            var2.getClientPlayer().method07596();

            for (PartyMember var5 : var3.method10148()) {
               var5.method07596();
            }
         }
      }
   }

   @Subscribe
   private void method04973(EntityStatusPacketEvent var1) {
      CallbackInfo var2 = var1.method09671();
      ClientLevel var3 = mc.level;
      ClientboundEntityEventPacket var4 = var1.method09673();
      Entity var5 = var4.getEntity(var3);
      byte var6 = var4.getEventId();
      if (var5 != null && var3 != null) {
         boolean var7 = var5 instanceof LivingEntity && var6 == 3;
         if (var7) {
            EntityDeathEvent.field25737.method11302(var5);
         }

         if (var6 == 35) {
            TotemPopEvent.field03649.method01499(var5);
            if (VisualRemovalEvent.field19883.method08691(VisualRemovalEvent.Nested242.TOTEM, var2)) {
               mc.particleEngine.createTrackingEmitter(var5, ParticleTypes.TOTEM_OF_UNDYING, 30);
               var3.playLocalSound(var5.getX(), var5.getY(), var5.getZ(), SoundEvents.TOTEM_USE, var5.getSoundSource(), 1.0F, 1.0F, false);
            }
         }
      }
   }

   @Subscribe
   private void method04975(ScreenInitEvent var1) {
      if (!ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.INVENTORY_BUTTON)) {
         Screen var2 = var1.method06768();
         if (var2 instanceof InventoryScreen) {
            ((ScreenMixin)(Object)var2).IaddDrawableChild(Button.builder(Component.literal(field10940), var0 -> {
               if (mc.player != null && mc.gameMode != null) {
                  PlayerUtils.method11828(mc);
               }
            }).bounds(var2.width / 2 - 50, var2.height / 2 - 125, 100, 20).build());
         }
      }
   }

   private static void method04977(Party var0, GlobalPlayer var1) {
      if (var0 != null && var1 != null) {
         PartyMember var2 = var0.method10151(var1x -> var1x.method07566(var1));
         if (var2 != null) {
            String var3 = var1.method07586();
            if (var3 != null && !var3.isEmpty()) {
               var2.method07568(var3);
            }

            String var4 = var1.method07580();
            if (var4 != null && !var4.isEmpty()) {
               var2.method07567(var4);
            }

            String var5 = var1.method07584();
            if (var5 != null && !var5.isEmpty()) {
               var2.method07577(var5);
            }

            var2.method07582().field03984 = var1.method07582().field03984;
            var2.method07582().field03985 = var1.method07582().field03985;
            var2.method07582().field03986 = var1.method07582().field03986;
         }
      }
   }

   @Subscribe
   private void method04978(PreMovementPacketEvent var1) {
      ModuleManager.INSTANCE
         .method08269()
         .method08465(var1.method07310(), var1.method07301(), var1.method07315(), var1.method07307(), var1.method07298(), this.method04982());
   }

   @Subscribe
   private void method04979(BlockCollisionEvent var1) {
      FrameUpdateEvent.field08522.method03781(mc.getDeltaTracker());
   }

   @Subscribe
   private void method04980(WorldLoadEvent var1) {
      this.method04967();
   }

   private void method04981() {
      ClientTextures.INSTANCE.method04553();
      DelayedInventoryActionManager.INSTANCE.method10615();
      InventoryActionManager.INSTANCE.method10468();
      WaypointManager.INSTANCE.method09830();
      ThemeManager.INSTANCE.method09634();
      CustomResourceManager.INSTANCE.method02458();
      ModuleManager.INSTANCE.method08164();
      ScriptRuntime.INSTANCE.method06176();
      McpServer.INSTANCE.method11628();
      CommandManager.INSTANCE.method04643();
      MacroManager.INSTANCE.method07022();
      ServerTickRateTracker.INSTANCE.method00346();
      ServerLatencyTracker.INSTANCE.method01665();
      SplashPotionTracker.INSTANCE.method02446();
      PlayerVelocityTracker.INSTANCE.method02568();
      BotManager.INSTANCE.method03065();
      AutoBuyManager.INSTANCE.method09756();
      BotTaskManager.INSTANCE.method05428();
      HexBaritone.INSTANCE.onInit();
      CustomResourceManager.INSTANCE.method02459();
      new FreeLookController();
      new RotationManager();
      new BlockTrapController();
      new BlockActionQueue();
      new RotationChangeTracker();
      BlockBreakManager.INSTANCE.method04890();
      BlockPlacementManager.INSTANCE.method07887();
      new RaycastManager();
      new TickTaskScheduler();
      PacketBufferManager.INSTNCE.method03599();
      ClientParticleManager.INSTANCE.method08828();
      ClientLifecycleEvents.CLIENT_STOPPING.register((ClientStopping)var0 -> ClientShutdownEvent.field20788.method03208());
      Runtime.getRuntime().addShutdownHook(new Thread(ClientShutdownEvent.field20788::method03208));
      Fonts.method00059();
      GlyphMeshCache.field00691.method00332();
      PoseStackPool.field02228.method00968();
      FrameClock.field21669.method09543();
      DragManager.INSTANCE.method05195();
      GlobalConnectionManager.method03860();
   }

   private boolean method04982() {
      return PlayerVelocityTracker.INSTANCE.method02572();
   }

   @Subscribe
   private void method04983(BlockCollisionEvent var1) {
      long var2 = var1.method08623();
      boolean var4 = FrameDeltaEvent.field22099.method05698();
      if (!var4) {
         this.field10931 = 0;
         this.field10930 = var2;
         this.field10932 = false;
      } else {
         if (!this.field10932) {
            this.field10932 = true;
            this.field10930 = var2 - field10943;
         }

         long var5 = var2 - this.field10930;
         this.field10931 = this.field10931 + (int)(var5 / field10944);
         if (this.field10931 > 0) {
            this.field10930 = this.field10930 + this.field10931 * field10945;

            for (this.field10931 = Math.min(this.field10931, 60); this.field10931 > 0; this.field10931--) {
               FontFallbackManager.method07176();
               FrameDeltaEvent.field22099.method09792(this.field10931);
            }
         }
      }

      if (!AuraUpdateEvent.field18471.method05698()) {
         this.field10935 = 0;
         this.field10934 = var2;
      } else {
         long var7 = var2 - this.field10934;
         this.field10935 = this.field10935 + (int)(var7 / field10946);
         if (this.field10935 > 0) {
            this.field10934 = this.field10934 + this.field10935 * field10947;

            for (this.field10935 = Math.min(this.field10935, 240); this.field10935 > 0; this.field10935--) {
               AuraUpdateEvent.field18471.method03208();
            }
         }
      }
   }

   @Subscribe
   private void method04984(ClientShutdownEvent var1) {
      this.method04967();
      GlobalConnectionManager.method03857();
   }
}
