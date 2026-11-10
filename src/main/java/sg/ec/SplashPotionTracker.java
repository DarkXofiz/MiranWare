// Original binary: sg/ec/A3f0b9df15YOW2Oo
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownSplashPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public enum SplashPotionTracker implements MinecraftAccess {
   INSTANCE;

   private static final double field05975 = 16.0;
   private static final long field05976 = 0;
   private final Map<Integer, Long> field05977 = new HashMap<>();
   private final Map<Integer, SplashPotionTracker.Nested66> field05978 = new HashMap<>();
   private final Set<Integer> field05979 = new HashSet<>();

   public void method02446() {
      EventBus.method00263(this);
   }

   @Subscribe
   private void method02447(PotionHitEvent var1) {
      AbstractThrownPotion var2 = var1.method09608();
      Level var3 = var2.level();
      boolean var4 = this.field05977.put(var2.getId(), var3.getGameTime()) == null;
      if (var4) {
         if (this.method02455()) {
            ItemStack var5 = var2.getItem();
            if (method02454()) {
               method02453(var5);
            }

            if (!var5.is(Items.LINGERING_POTION)) {
               PotionContents var6 = var5.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
               if (var6.hasEffects() && !var6.is(Potions.WATER)) {
                  Vec3 var7 = var1.method09606().getLocation();
                  AABB var8 = var2.getBoundingBox().move(var7.subtract(var2.position()));
                  this.method02450(var3, var2, var8, var5, var6, ProjectileUtil.computeMargin(var2));
               }
            }
         }
      }
   }

   @Subscribe
   private void method02448(TickEvent var1) {
      ClientLevel var2 = mc.level;
      if (var2 == null) {
         this.field05977.clear();
         this.field05978.clear();
      } else {
         long var3 = var2.getGameTime();
         var var5 = this.field05977.entrySet().iterator();

         while (var5.hasNext()) {
            long var6 = (Long)((Entry)var5.next()).getValue();
            if (var3 < var6 || var3 - var6 > 60L) {
               var5.remove();
            }
         }

         NotificationHud var17 = this.method02456();
         if (var17 != null && var17.method01417().method04706()) {
            boolean var7 = method02454();
            this.field05979.clear();

            for (Entity var9 : var2.entitiesForRendering()) {
               if (var9 instanceof AbstractThrownPotion var10) {
                  ItemStack var11 = var10.getItem();
                  if (var7) {
                     method02453(var11);
                  }

                  if (!var11.is(Items.LINGERING_POTION)) {
                     PotionContents var12 = var11.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
                     if (var12.hasEffects() && !var12.is(Potions.WATER)) {
                        int var13 = var10.getId();
                        this.field05979.add(var13);
                        SplashPotionTracker.Nested66 var14 = this.field05978.get(var13);
                        Vec3 var15 = var10.position();
                        Vec3 var16 = var14 != null ? var14.currentPos() : var15;
                        this.field05978.put(var13, new SplashPotionTracker.Nested66(var16, var15, var10.getBoundingBox(), var11.copy(), var10.tickCount));
                     }
                  }
               }
            }

            if (this.field05978.size() != this.field05979.size()) {
               var var18 = this.field05978.entrySet().iterator();

               while (var18.hasNext()) {
                  Entry var19 = (Entry)var18.next();
                  int var20 = (Integer)var19.getKey();
                  if (!this.field05979.contains(var20)) {
                     var18.remove();
                     if (this.field05977.remove(var20) == null) {
                        this.method02449(var2, var20, (SplashPotionTracker.Nested66)var19.getValue());
                     }
                  }
               }
            }
         } else {
            this.field05978.clear();
         }
      }
   }

   private void method02449(Level var1, int var2, SplashPotionTracker.Nested66 var3) {
      Vec3 var4 = var3.currentPos().subtract(var3.previousPos());
      Vec3 var5 = var3.currentPos().add(var4);
      AABB var6 = var3.boundingBox().move(var5.subtract(var3.currentPos()));
      ItemStack var7 = var3.stack();
      PotionContents var8 = var7.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
      if (var8.hasEffects() && !var8.is(Potions.WATER)) {
         float var9 = var7.getOrDefault(DataComponents.POTION_DURATION_SCALE, 1.0F);
         float var10 = method02451(var3.tickCount());
         ThrownSplashPotion var11 = null;

         for (Player var13 : var1.players()) {
            if (var13 != null && !var13.isSpectator() && var13.isAlive() && var13.isAffectedByPotions()) {
               double var14 = var6.distanceToSqr(var13.getBoundingBox().inflate(var10));
               if (!(var14 >= 16.0)) {
                  double var16 = 1.0 - Math.sqrt(var14) / 4.0;
                  var var18 = method02452(var8, var16, var9);
                  if (!var18.isEmpty()) {
                     if (var11 == null) {
                        var11 = new ThrownSplashPotion(var1, var5.x, var5.y, var5.z, var7);
                        var11.setId(var2);
                     }

                     SplashPotionEffectsEvent.field03977.method01643(var1, var18, var11, var13, var16);
                  }
               }
            }
         }
      }
   }

   private void method02450(Level var1, AbstractThrownPotion var2, AABB var3, ItemStack var4, PotionContents var5, float var6) {
      float var7 = var4.getOrDefault(DataComponents.POTION_DURATION_SCALE, 1.0F);

      for (Player var9 : var1.players()) {
         if (var9 != null && !var9.isSpectator() && var9.isAlive() && var9.isAffectedByPotions()) {
            double var10 = var3.distanceToSqr(var9.getBoundingBox().inflate(var6));
            if (!(var10 >= 16.0)) {
               double var12 = 1.0 - Math.sqrt(var10) / 4.0;
               var var14 = method02452(var5, var12, var7);
               if (!var14.isEmpty()) {
                  SplashPotionEffectsEvent.field03977.method01643(var1, var14, var2, var9, var12);
               }
            }
         }
      }
   }

   private static float method02451(int var0) {
      return Math.max(0.0F, Math.min(0.3F, (var0 - 2) / 20.0F));
   }

   private static List<MobEffectInstance> method02452(PotionContents var0, double var1, float var3) {
      ArrayList var4 = new ArrayList();

      for (MobEffectInstance var6 : var0.getAllEffects()) {
         MobEffect var7 = var6.getEffect().value();
         if (var7.isInstantaneous()) {
            var4.add(var6);
         } else {
            int var8 = var6.mapDuration(var3x -> (int)(var1 * var3 * var3x + 0.5));
            MobEffectInstance var9 = new MobEffectInstance(var6.getEffect(), var8, var6.getAmplifier(), var6.isAmbient(), var6.isVisible());
            if (!var9.endsWithin(20)) {
               var4.add(var9);
            }
         }
      }

      return var4;
   }

   private static void method02453(ItemStack var0) {
      PotionContents var1 = var0.get(DataComponents.POTION_CONTENTS);
      if (var1 != null) {
         int var2 = var1.customColor().orElse(-1);
         PotionContents var3 = PotionItemData.method11411(var2);
         if (var3 != null) {
            var0.set(DataComponents.POTION_CONTENTS, var3);
         }

         Component var4 = PotionItemData.method11489(var2);
         if (var4 != null) {
            var0.set(DataComponents.CUSTOM_NAME, var4);
         }
      }
   }

   private static boolean method02454() {
      return ModuleManager.INSTANCE.method08184().method03937() && ModuleManager.INSTANCE.method08184().field12174;
   }

   private boolean method02455() {
      NotificationHud var1 = this.method02456();
      return var1 != null && var1.method01417().method04706();
   }

   private NotificationHud method02456() {
      return ModuleManager.INSTANCE.method08274().method04953().method00017(NotificationHud.class);
   }

   // $VF: Compiled from s
   private record Nested66(Vec3 previousPos, Vec3 currentPos, AABB boundingBox, ItemStack stack, int tickCount) {
   }
}
