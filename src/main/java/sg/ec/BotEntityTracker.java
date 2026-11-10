// Original binary: sg/ec/c7wB7X1OlV9R5KSz
package sg.ec;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.RemotePlayer;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public final class BotEntityTracker {
   private static final int field17667 = 1024;
   private final BotClientLevel field17668;
   private final Map<Integer, Entity> field17669 = new HashMap<>();
   private final List<AbstractClientPlayer> field17670 = new ArrayList<>();

   public void method07244(int var1, double var2, double var4, double var6, float var8, float var9) {
      Entity var10 = this.field17669.get(var1);
      if (var10 != null) {
         var10.snapTo(var2, var4, var6, var8, var9);
         var10.getPositionCodec().setBase(new Vec3(var2, var4, var6));
         var10.setOldPosAndRot();
      }
   }

   public void method07245(ClientboundAddEntityPacket var1, GameProfile var2) {
      if (this.field17669.size() < 1024 && !this.field17669.containsKey(var1.getId())) {
         Entity var3 = var1.getType() == EntityType.PLAYER
            ? (var2 == null ? null : new RemotePlayer(this.field17668, var2))
            : var1.getType().create(this.field17668, EntitySpawnReason.LOAD);
         if (var3 != null) {
            var3.recreateFromPacket(var1);
            this.field17669.put(var3.getId(), var3);
            this.method07250(var3);
         }
      }
   }

   public void method07246() {
      this.field17669.clear();
      this.field17670.clear();
   }

   public void method07247(ClientboundSetPassengersPacket var1) {
      Entity var2 = this.field17669.get(var1.getVehicle());
      if (var2 == null) {
         this.method07254(var1.getVehicle());
      } else {
         for (Entity var4 : new ArrayList<>(var2.getPassengers())) {
            var4.stopRiding();
         }

         for (int var6 : var1.getPassengers()) {
            Entity var7 = this.field17669.get(var6);
            if (var7 != null) {
               var7.startRiding(var2, true, true);
            }
         }
      }
   }

   private void method07248(Entity var1) {
      if (var1 instanceof AbstractClientPlayer var2) {
         this.field17670.remove(var2);
      }

      var1.setDeltaMovement(Vec3.ZERO);
   }

   public boolean method07249(Entity var1) {
      return var1 != null && this.field17669.get(var1.getId()) == var1;
   }

   private void method07250(Entity var1) {
      if (var1 instanceof AbstractClientPlayer var2) {
         this.field17670.add(var2);
      }
   }

   public List<Entity> method07251(Entity var1, AABB var2) {
      return this.method07265(var1, var2, EntitySelector.pushableBy(var1));
   }

   public BotLocalPlayer method07252() {
      for (Entity var2 : this.field17669.values()) {
         if (var2 instanceof BotLocalPlayer var3) {
            return var3;
         }
      }

      return null;
   }

   public void method07253(ClientboundSetEntityDataPacket var1) {
      Entity var2 = this.field17669.get(var1.id());
      if (var2 != null) {
         var2.getEntityData().assignValues(var1.packedItems());
      }
   }

   private void method07254(int var1) {
      for (Entity var3 : new ArrayList<>(this.field17669.values())) {
         Entity var4 = var3.getVehicle();
         if (var4 != null && var4.getId() == var1) {
            var3.stopRiding();
         }
      }
   }

   public <T extends Entity> void method07255(EntityTypeTest<Entity, T> var1, AABB var2, Predicate<? super T> var3, List<? super T> var4, int var5) {
      for (Entity var7 : this.field17669.values()) {
         T var8 = var1.tryCast(var7);
         if (var8 != null && !var8.isRemoved() && var8.getBoundingBox().intersects(var2) && var3.test(var8)) {
            var4.add(var8);
            if (var4.size() >= var5) {
               return;
            }
         }
      }
   }

   public void method07256() {
      for (Entity var2 : List.copyOf(this.field17669.values())) {
         if (!(var2 instanceof BotLocalPlayer)) {
            if (var2.isRemoved()) {
               this.method07263(var2.getId());
            } else {
               var2.setOldPosAndRot();
               var2.tickCount++;
               var2.tick();
            }
         }
      }
   }

   public void method07257(int var1, float var2) {
      Entity var3 = this.field17669.get(var1);
      if (var3 != null) {
         var3.lerpHeadTo(var2, 3);
      }
   }

   public List<VoxelShape> method07258(Entity var1, AABB var2) {
      ArrayList var3 = new ArrayList();

      for (Entity var5 : this.field17669.values()) {
         if (var5 != var1 && var5.getBoundingBox().intersects(var2) && var5.canBeCollidedWith(var1)) {
            var3.add(Shapes.create(var5.getBoundingBox()));
         }
      }

      return var3;
   }

   public void method07259(Entity var1) {
      Entity var2 = this.field17669.put(var1.getId(), var1);
      if (var2 != null) {
         this.method07248(var2);
      }

      this.method07250(var1);
   }

   public void method07260(int var1, double var2, double var4, double var6, float var8, float var9, boolean var10) {
      Entity var11 = this.field17669.get(var1);
      if (var11 != null && !(var11 instanceof BotLocalPlayer)) {
         Vec3 var12 = new Vec3(var2, var4, var6);
         var11.getPositionCodec().setBase(var12);
         var11.moveOrInterpolateTo(var12, var8, var9);
         var11.setOnGround(var10);
      }
   }

   public Entity method07261(int var1) {
      return this.field17669.get(var1);
   }

   public Collection<Entity> method07262() {
      return List.copyOf(this.field17669.values());
   }

   public void method07263(int var1) {
      Entity var2 = this.field17669.remove(var1);
      if (var2 != null) {
         for (Entity var4 : new ArrayList<>(var2.getPassengers())) {
            var4.stopRiding();
         }

         var2.stopRiding();
         this.method07248(var2);
      }
   }

   BotEntityTracker(BotClientLevel var1) {
      this.field17668 = var1;
   }

   public List<AbstractClientPlayer> method07264() {
      return List.copyOf(this.field17670);
   }

   public List<Entity> method07265(Entity var1, AABB var2, Predicate<? super Entity> var3) {
      ArrayList var4 = new ArrayList();

      for (Entity var6 : this.field17669.values()) {
         if (var6 != var1 && !var6.isRemoved() && var6.getBoundingBox().intersects(var2) && var3.test(var6)) {
            var4.add(var6);
         }
      }

      return var4;
   }
}
