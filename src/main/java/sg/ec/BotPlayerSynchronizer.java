// Original binary: sg/ec/brA2C5gyqYghj9Pv
package sg.ec;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerInventoryPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket.AttributeSnapshot;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.food.FoodData;

// $VF: Compiled from s
public final class BotPlayerSynchronizer {
   private static void method07168(ClientboundPlayerAbilitiesPacket var0, BotLocalPlayer var1) {
      if (var0 != null) {
         Abilities var2 = var1.getAbilities();
         var2.invulnerable = var0.isInvulnerable();
         var2.flying = var0.isFlying();
         var2.mayfly = var0.canFly();
         var2.instabuild = var0.canInstabuild();
         var2.setFlyingSpeed(var0.getFlyingSpeed());
         var2.setWalkingSpeed(var0.getWalkingSpeed());
      }
   }

   private static void method07169(BotPlayerState var0, BotLocalPlayer var1) {
      FoodData var2 = var1.getFoodData();
      var2.setFoodLevel(var0.method07954());
      var2.setSaturation(var0.method07945());
   }

   private BotPlayerSynchronizer() {
   }

   public static void method07170(BotWorldState var0, BotPlayerState var1, BotLocalPlayer var2) {
      method07168(var1.method07961(), var2);
      method07169(var1, var2);
      method07172(var1, var2);
      method07173(var0, var0.method07749(var1.method07965()), var2);
      method07171(var0.method07765(var1.method07965()), var2);
   }

   private static void method07171(List<ClientboundUpdateMobEffectPacket> var0, BotLocalPlayer var1) {
      if (var0 != null) {
         HashSet var2 = new HashSet();

         for (ClientboundUpdateMobEffectPacket var4 : var0) {
            var2.add(var4.getEffect());
            MobEffectInstance var5 = new MobEffectInstance(
               var4.getEffect(),
               var4.getEffectDurationTicks(),
               var4.getEffectAmplifier(),
               var4.isEffectAmbient(),
               var4.isEffectVisible(),
               var4.effectShowsIcon()
            );
            var1.forceAddEffect(var5, null);
         }

         for (var var7 : Set.copyOf(var1.getActiveEffectsMap().keySet())) {
            if (!var2.contains(var7)) {
               var1.removeEffectNoUpdate(var7);
            }
         }
      }
   }

   private static void method07172(BotPlayerState var0, BotLocalPlayer var1) {
      ClientboundContainerSetContentPacket var2 = var0.method07955();
      if (var2 != null) {
         var1.inventoryMenu.initializeContents(var2.stateId(), var2.items(), var2.carriedItem());
      }

      for (ClientboundContainerSetSlotPacket var4 : var0.method07964()) {
         if (var1.inventoryMenu.isValidSlotIndex(var4.getSlot())) {
            var1.inventoryMenu.setItem(var4.getSlot(), var4.getStateId(), var4.getItem());
         }
      }

      for (ClientboundSetPlayerInventoryPacket var6 : var0.method08007()) {
         var1.getInventory().setItem(var6.slot(), var6.contents());
      }

      var1.getInventory().setSelectedSlot(method07174(var0.method07987()));
   }

   private static void method07173(BotWorldState var0, List<AttributeSnapshot> var1, BotLocalPlayer var2) {
      if (var1 != null) {
         for (AttributeSnapshot var4 : var1) {
            AttributeInstance var5 = var2.getAttributes().getInstance(var4.attribute());
            if (var5 != null) {
               var5.setBaseValue(var4.base());
               var5.removeModifiers();

               for (AttributeModifier var7 : var4.modifiers()) {
                  var5.addTransientModifier(var7);
               }
            }
         }
      }
   }

   private static int method07174(int var0) {
      int var1 = Inventory.getSelectionSize();
      return var0 >= 0 && var0 < var1 ? var0 : 0;
   }
}
