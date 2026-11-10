// Original binary: sg/ec/MprDgamw2aNdVxBj
package sg.ec;

import hex.script.api.ClientInfo;
import hex.script.api.Effect;
import java.util.Collection;
import net.minecraft.client.User;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.TickRateManager;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;

// $VF: Compiled from s
public final class ScriptClientInfoAdapter implements MinecraftAccess {
   private static final Effect[] field10219 = new Effect[0];
   private final ClientInfo field10220 = new ClientInfo(
      this::method04662,
      this::method04665,
      this::method04664,
      this::method04667,
      StreamerNameUtils::method03481,
      ScriptScreenAdapter::method10159,
      this::method04661
   );

   private TickRateManager method04658() {
      return mc.level == null ? null : mc.level.tickRateManager();
   }

   ClientInfo method04659() {
      return this.field10220;
   }

   private Effect method04660(MobEffectInstance var1) {
      Effect var2 = new Effect();
      MobEffect var3 = var1.getEffect().value();
      var2.set(
         String.valueOf(BuiltInRegistries.MOB_EFFECT.getKey(var3)),
         var3.getDisplayName().getString(),
         var1.getAmplifier(),
         var1.getDuration(),
         var1.isInfiniteDuration(),
         var1.isAmbient(),
         var1.isVisible(),
         var3.getColor(),
         this.method04663(var3.getCategory())
      );
      return var2;
   }

   private Effect method04661(String var1) {
      if (mc.player == null) {
         return null;
      }

      for (MobEffectInstance var3 : mc.player.getActiveEffects()) {
         Effect var4 = this.method04660(var3);
         if (var4.is(var1)) {
            return var4;
         }
      }

      return null;
   }

   private double method04662(int var1) {
      return switch (var1) {
         case 1 -> ServerLatencyTracker.INSTANCE.method01666();
         case 2 -> {
            TickRateManager var2 = this.method04658();
            yield var2 == null ? 0.0 : var2.tickrate();
         }
         default -> mc.getFps();
      };
   }

   private int method04663(MobEffectCategory var1) {
      return switch (var1) {
         case BENEFICIAL -> 0;
         case HARMFUL -> 1;
         default -> 2;
      };
   }

   private String method04664(int var1) {
      if (var1 == 1) {
         ServerData var4 = mc.getCurrentServer();
         return var4 != null && var4.ip != null ? var4.ip : "";
      } else if (var1 != 2) {
         String var3 = this.method04666();
         return var1 == 3 ? StreamerNameUtils.method03481(var3) : var3;
      } else {
         String var2 = ProfileAPI.get() != null && ProfileAPI.get().getModel() != null ? ProfileAPI.get().getModel().getName() : null;
         return var2 == null ? "" : var2;
      }
   }

   private boolean method04665(int var1) {
      if (var1 == 1) {
         return mc.isLocalServer();
      }

      if (var1 == 2) {
         return mc.getDebugOverlay().showDebugScreen();
      }

      TickRateManager var2 = this.method04658();
      return var2 != null && var2.isFrozen();
   }

   private String method04666() {
      User var1 = mc.getUser();
      return var1 != null && var1.getName() != null ? var1.getName() : "";
   }

   private Effect[] method04667() {
      if (mc.player == null) {
         return field10219;
      }

      var var1 = mc.player.getActiveEffects();
      if (var1.isEmpty()) {
         return field10219;
      }

      Effect[] var2 = new Effect[var1.size()];
      int var3 = 0;

      for (MobEffectInstance var5 : var1) {
         var2[var3++] = this.method04660(var5);
      }

      return var2;
   }
}
