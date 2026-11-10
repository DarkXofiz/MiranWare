// Original binary: sg/ec/jwZRQ8ssiyxHL214
package sg.ec;

import hex.script.api.Entities;
import hex.script.api.Item;
import hex.script.api.Text;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;

// $VF: Compiled from s
public final class ScriptEntitiesAdapter implements MinecraftAccess {
   private static final EquipmentSlot[] field20577 = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   private static final int field20578 = 64;
   private final Int2ObjectLinkedOpenHashMap<ScriptEntitiesAdapter.Nested252> field20579 = new Int2ObjectLinkedOpenHashMap();
   private final Entities field20580 = new Entities(
      this::method09066, this::method09065, this::method09070, this::method09076, this::method09068, this::method09077, this::method09067
   );
   private static final int field20581 = -16777216;

   private boolean method09065(int var1, int var2) {
      Entity var3 = this.method09075(var1);
      if (var3 == null) {
         return false;
      }

      return switch (var2) {
         case 1 -> var3.isAlive();
         case 2 -> var3 instanceof Player;
         case 3 -> var3 instanceof LivingEntity;
         case 4 -> var3 == mc.player;
         case 5 -> var3.isShiftKeyDown();
         case 6 -> var3.isSprinting();
         case 7 -> var3.onGround();
         case 8 -> var3.isInvisible();
         case 9 -> var3 instanceof Player && FriendManager.INSTANCE.method00171(var3.getName().getString());
         case 10 -> var3.isInWater();
         case 11 -> {
            if (var3 instanceof LivingEntity var4 && var4.isFallFlying()) {
               yield true;
            }

            yield false;
         }
         default -> true;
      };
   }

   private double method09066(int var1, int var2) {
      Entity var3 = this.method09075(var1);
      if (var3 == null) {
         return 0.0;
      }

      return switch (var2) {
         case 1 -> var3.getY();
         case 2 -> var3.getZ();
         case 3 -> var3.getYRot();
         case 4 -> var3.getXRot();
         case 5 -> var3 instanceof LivingEntity var7 ? PlayerUtils.method11820(var7) : 0.0;
         case 6 -> var3 instanceof LivingEntity var6 ? PlayerUtils.method11805(var6) : 0.0;
         case 7 -> var3 instanceof LivingEntity var5 ? var5.getAbsorptionAmount() : 0.0;
         case 8 -> var3.getBbWidth();
         case 9 -> var3.getBbHeight();
         case 10 -> mc.player == null ? 0.0 : mc.player.distanceTo(var3);
         case 11 -> var3.getDeltaMovement().x;
         case 12 -> var3.getDeltaMovement().y;
         case 13 -> var3.getDeltaMovement().z;
         case 14 -> var3 instanceof LivingEntity var4 ? var4.hurtTime : 0.0;
         default -> var3.getX();
      };
   }

   private double[] method09067(int var1, float var2) {
      Entity var3 = this.method09075(var1);
      return var3 == null
         ? null
         : new double[]{
            var3.xOld + (var3.getX() - var3.xOld) * var2, var3.yOld + (var3.getY() - var3.yOld) * var2, var3.zOld + (var3.getZ() - var3.zOld) * var2
         };
   }

   private Item method09068(int var1, int var2) {
      if (!(this.method09075(var1) instanceof LivingEntity var4)) {
         return new Item();
      } else {
         ItemStack var5 = switch (var2) {
            case -2 -> var4.getOffhandItem();
            case -1 -> var4.getMainHandItem();
            default -> var2 >= 0 && var2 < field20577.length ? var4.getItemBySlot(field20577[var2]) : ItemStack.EMPTY;
         };
         return method09078(var5);
      }
   }

   private int[] method09069(Entity var1) {
      return var1 == null ? new int[0] : new int[]{var1.getId()};
   }

   private String method09070(int var1, int var2) {
      Entity var3 = this.method09075(var1);
      if (var3 == null) {
         return "";
      }

      return switch (var2) {
         case 1 -> String.valueOf(BuiltInRegistries.ENTITY_TYPE.getKey(var3.getType()));
         case 2 -> var3 instanceof AbstractClientPlayer var4 ? String.valueOf(var4.getSkin().body().texturePath()) : "";
         case 3 -> var3.getUUID().toString();
         default -> var3.getName().getString();
      };
   }

   hex.script.api.Entity method09071(Entity var1) {
      return var1 == null ? null : this.field20580.of(var1.getId());
   }

   private static Text method09072(Component var0) {
      Text var1 = Text.empty();
      var0.visit((var1x, var2) -> {
         if (!var2.isEmpty()) {
            method09074(var1.append(var2), var1x);
         }

         return Optional.empty();
      }, Style.EMPTY);
      return var1;
   }

   static Entity method09073(Object var0) {
      if (var0 instanceof Entity var2) {
         return var2;
      } else {
         return var0 instanceof hex.script.api.Entity var1 && mc.level != null ? mc.level.getEntity(var1.id()) : null;
      }
   }

   private static void method09074(Text var0, Style var1) {
      TextColor var2 = var1.getColor();
      if (var2 != null) {
         var0.color(field20581 | var2.getValue());
      }

      if (var1.isBold()) {
         var0.bold();
      }

      if (var1.isItalic()) {
         var0.italic();
      }

      if (var1.isUnderlined()) {
         var0.underline();
      }

      if (var1.isStrikethrough()) {
         var0.strike();
      }

      if (var1.isObfuscated()) {
         var0.magic();
      }
   }

   private Entity method09075(int var1) {
      return mc.level == null ? null : mc.level.getEntity(var1);
   }

   private Text method09076(int var1, int var2) {
      Entity var3 = this.method09075(var1);
      if (var3 == null) {
         return Text.empty();
      }

      long var4 = var3.level().getGameTime();
      ScriptEntitiesAdapter.Nested252 var6 = (ScriptEntitiesAdapter.Nested252)this.field20579.getAndMoveToFirst(var1);
      if (var6 != null && var6.field20584 == var4) {
         return var6.field20582;
      }

      Component var7 = var3.getDisplayName();
      long var8 = TextCacheKeys.method03825(var7);
      if (var6 == null) {
         var6 = new ScriptEntitiesAdapter.Nested252();
         this.field20579.putAndMoveToFirst(var1, var6);
         if (this.field20579.size() > 64) {
            this.field20579.removeLast();
         }
      }

      if (var6.field20582 == null || var6.field20583 != var8) {
         var6.field20582 = method09072(var7);
         var6.field20583 = var8;
      }

      var6.field20584 = var4;
      return var6.field20582;
   }

   private int[] method09077(int var1, double var2) {
      if (mc.level != null && mc.player != null) {
         if (var1 == 3) {
            return this.method09069(AttackAura.method00456());
         }

         if (var1 == 4) {
            return mc.hitResult instanceof EntityHitResult var9 ? this.method09069(var9.getEntity()) : new int[0];
         }

         double var4 = var2 * var2;
         ArrayList<Entity> var6 = new ArrayList<>();

         for (Entity var8 : mc.level.entitiesForRendering()) {
            if (var8 != mc.player
               && !(mc.player.distanceToSqr(var8) > var4)
               && (var1 != 1 || var8 instanceof Player)
               && (var1 != 2 || var8 instanceof LivingEntity)) {
               var6.add(var8);
            }
         }

         var6.sort(Comparator.comparingDouble(mc.player::distanceToSqr));
         int[] var10 = new int[var6.size()];

         for (int var11 = 0; var11 < var10.length; var11++) {
            var10[var11] = ((Entity)var6.get(var11)).getId();
         }

         return var10;
      } else {
         return new int[0];
      }
   }

   static Item method09078(ItemStack var0) {
      return ScriptItemSnapshotCache.method11754(var0);
   }

   Entities method09079() {
      return this.field20580;
   }

   // $VF: Compiled from s
   private static final class Nested252 {
      private Text field20582;
      private long field20583;
      private long field20584;
      private static final long field20585 = Long.MIN_VALUE;

      private Nested252() {
         this.field20584 = field20585;
      }
   }
}
