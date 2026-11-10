// Original binary: sg/ec/y6r5iRCAjMwV4RIB
package sg.ec;

import it.unimi.dsi.fastutil.ints.IntList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.gameevent.GameEvent;

// $VF: Compiled from s
public class CrystalOptimizer extends ClientModule {
   private static final int field26386 = 6;
   private static final int field26387 = 0;
   private static final int field26388 = 0;
   private final Map<Integer, CrystalOptimizer.Nested323> field26389 = new ConcurrentHashMap<>();
   private int field26390 = -1;
   private static final String field26391 = "Crystal Optimizer";
   private static final double field26392 = 3.0;
   private static final double field26393 = 4.0;

   @Subscribe
   private void method11554(PacketEvent var1) {
      if (var1.method10904() && var1.method10897() instanceof ClientboundRemoveEntitiesPacket var2) {
         IntList var6 = var2.entityIds();

         for (int var4 = 0; var4 < var6.size(); var4++) {
            CrystalOptimizer.Nested323 sx = this.field26389.get(var6.getInt(var4));
            if (sx != null) {
               sx.field26396 = true;
            }
         }
      }
   }

   private void method11555(EndCrystal var1) {
      if (mc.player != null && mc.hitResult != null && mc.crosshairPickEntity == var1) {
         mc.hitResult = mc.player.pick(mc.player.blockInteractionRange(), 1.0F, false);
         mc.crosshairPickEntity = null;
      }
   }

   private boolean method11556(LocalPlayer var1) {
      double var2 = var1.getAttributeBaseValue(Attributes.ATTACK_DAMAGE);
      var2 += this.method11558(var1.getMainHandItem());
      MobEffectInstance var4 = var1.getEffect(MobEffects.STRENGTH);
      if (var4 != null) {
         var2 += field26392 * (var4.getAmplifier() + 1);
      }

      MobEffectInstance var5 = var1.getEffect(MobEffects.WEAKNESS);
      if (var5 != null) {
         var2 -= field26393 * (var5.getAmplifier() + 1);
      }

      return var2 > 0.0;
   }

   @Subscribe
   private void method11557(PlayerUpdateEvent var1) {
      if (mc.player != null && mc.level != null) {
         int var2 = mc.player.tickCount;
         if (var2 < this.field26390) {
            this.field26389.clear();
         }

         this.field26390 = var2;
         if (!this.field26389.isEmpty()) {
            var var3 = this.field26389.entrySet().iterator();

            while (var3.hasNext()) {
               CrystalOptimizer.Nested323 var4 = (CrystalOptimizer.Nested323)((Entry)var3.next()).getValue();
               if (var4.field26396) {
                  var3.remove();
               } else if (var2 >= var4.field26395) {
                  this.method11560(var4.field26394);
                  var3.remove();
               }
            }
         }
      } else {
         this.field26389.clear();
      }
   }

   private double method11558(ItemStack var1) {
      ItemAttributeModifiers var2 = var1.get(DataComponents.ATTRIBUTE_MODIFIERS);
      if (var2 == null) {
         return 0.0;
      }

      double var3 = 0.0;

      for (net.minecraft.world.item.component.ItemAttributeModifiers.Entry var6 : var2.modifiers()) {
         if (var6.attribute().value() == Attributes.ATTACK_DAMAGE.value()) {
            var3 += var6.modifier().amount();
         }
      }

      return var3;
   }

   @Override
   public void method00245() {
      super.method00245();
      this.field26389.clear();
      this.field26390 = -1;
   }

   public CrystalOptimizer() {
      super(ModuleCategory.Combat, ModuleSubCategory.Other);
      this.method03935(field26391);
   }

   @Subscribe
   private void method11559(AttackEntityEvent var1) {
      if (var1.method09431() == AttackEntityEvent.Nested264.POST) {
         if (mc.player != null && mc.level != null) {
            if (var1.method09434() instanceof EndCrystal var2) {
               if (!var2.isRemoved()) {
                  if (this.method11556(mc.player)) {
                     var2.remove(RemovalReason.KILLED);
                     var2.gameEvent(GameEvent.ENTITY_DIE);
                     this.method11555(var2);
                     int var4 = Mth.clamp(ServerLatencyTracker.INSTANCE.method01667() + 4, 6, 30);
                     this.field26389.put(var2.getId(), new CrystalOptimizer.Nested323(var2, mc.player.tickCount + var4));
                  }
               }
            }
         }
      }
   }

   private void method11560(EndCrystal var1) {
      if (mc.level != null && mc.level.getEntity(var1.getId()) == null) {
         var1.unsetRemoved();
         mc.level.addEntity(var1);
      }
   }

   @Subscribe
   private void method11561(WorldLoadEvent var1) {
      this.field26389.clear();
      this.field26390 = -1;
   }

   // $VF: Compiled from s
   private static final class Nested323 {
      private final EndCrystal field26394;
      private final int field26395;
      private volatile boolean field26396;

      private Nested323(EndCrystal var1, int var2) {
         this.field26394 = var1;
         this.field26395 = var2;
      }
   }
}
