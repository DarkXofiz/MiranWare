// Original binary: sg/ec/ig6ByBArEglG0bBm
package sg.ec;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public enum ClientParticleManager implements MinecraftAccess {
   INSTANCE;

   private static final int field20111 = -1;
   private static final float field20112 = 0;
   private static final int field20113 = 0;
   public static final int field20114 = 0;
   private final ClientParticleRenderer field20115 = new ClientParticleRenderer();
   private final ArrayDeque<ClientParticleManager.Nested246> field20116 = new ArrayDeque<>();
   private final ArrayDeque<ClientParticleManager.Nested246> field20117 = new ArrayDeque<>();
   private final ArrayDeque<ParticleEmitter> field20118 = new ArrayDeque<>();
   private final ArrayDeque<ParticleEmitter> field20119 = new ArrayDeque<>();
   private int field20120 = 16384;
   private boolean field20121;

   public void method08828() {
      this.field20115.method10539();
   }

   public void method08829(int var1) {
      this.field20120 = Math.max(1, var1);
      this.method08848(0);
   }

   public int method08830() {
      return this.field20116.size() + this.field20117.size();
   }

   public boolean method08831() {
      return this.field20116.isEmpty() && this.field20117.isEmpty() && this.field20118.isEmpty() && this.field20119.isEmpty();
   }

   public Iterable<ClientParticleManager.Nested246> method08832() {
      return this.field20116;
   }

   public ClientParticle method08833(ClientParticle.Nested35 var1) {
      return this.method08834(var1, -1, 0.2F, 6);
   }

   public ClientParticle method08834(ClientParticle.Nested35 var1, int var2, float var3, int var4) {
      Objects.requireNonNull(var1, "args");
      ClientParticle var5 = new ClientParticle(var1);
      this.method08836(var5, var2, var3, var4);
      return var5;
   }

   public boolean method08835(ClientParticle var1) {
      return this.method08836(var1, -1, 0.2F, 6);
   }

   public boolean method08836(ClientParticle var1, int var2, float var3, int var4) {
      if (var1 != null && var1.method01051()) {
         ClientParticleManager.Nested246 var5 = new ClientParticleManager.Nested246(var1, var2, Math.max(0.01F, var3), method08849(var1, var4));
         return this.method08843(var5);
      } else {
         return false;
      }
   }

   public boolean method08837(ParticleEmitter var1) {
      if (var1 == null || !var1.method03861()) {
         return false;
      } else if (this.field20121) {
         this.field20119.addLast(var1);
         return true;
      } else {
         this.field20118.addLast(var1);
         return true;
      }
   }

   public EntityBurstEmitter method08838(Entity var1, int var2) {
      EntityBurstEmitter var3 = new EntityBurstEmitter(var1, var2);
      this.method08837(var3);
      return var3;
   }

   public void method08839() {
      this.field20116.clear();
      this.field20117.clear();
      this.field20118.clear();
      this.field20119.clear();
   }

   public void method08840() {
      this.field20121 = true;

      try {
         this.method08844();
         this.method08845();
      } finally {
         this.field20121 = false;
      }

      this.method08846();
      this.method08847();
   }

   public void method08841() {
      if (!this.field20116.isEmpty()) {
         LocalPlayer var1 = mc.player;

         for (ClientParticleManager.Nested246 var3 : this.field20116) {
            ClientParticle var4 = var3.field20122;
            var3.field20127 = var4.method01051() && method08842(var1, var4) && PlayerUtils.method11817(var4.method01092());
         }
      }
   }

   private static boolean method08842(Entity var0, ClientParticle var1) {
      double var2 = var1.method01089();
      return !(var2 <= 0.0) && var0 != null ? var0.distanceToSqr(var1.method01093(), var1.method01071(), var1.method01066()) <= var2 : true;
   }

   private boolean method08843(ClientParticleManager.Nested246 var1) {
      this.method08848(1);
      if (this.field20121) {
         this.field20117.addLast(var1);
         return true;
      } else {
         var1.field20128 = var1.field20129;
         var1.field20129 = method08850(var1.field20122, var1.field20125);
         this.field20116.addLast(var1);
         return true;
      }
   }

   private void method08844() {
      var var1 = this.field20116.iterator();

      while (var1.hasNext()) {
         ClientParticleManager.Nested246 var2 = (ClientParticleManager.Nested246)var1.next();
         ClientParticle var3 = var2.field20122;
         var3.method01052();
         if (!var3.method01051()) {
            var1.remove();
         } else {
            var2.field20128 = var2.field20129;
            var2.field20129 = method08850(var3, var2.field20125);
         }
      }
   }

   private void method08845() {
      var var1 = this.field20118.iterator();

      while (var1.hasNext()) {
         ParticleEmitter var2 = (ParticleEmitter)var1.next();
         var2.method03862(this);
         if (!var2.method03861()) {
            var1.remove();
         }
      }
   }

   private void method08846() {
      if (!this.field20117.isEmpty()) {
         ClientParticleManager.Nested246 var1;
         while ((var1 = this.field20117.pollFirst()) != null) {
            ClientParticle var2 = var1.field20122;
            if (var2.method01051()) {
               var1.field20128 = var1.field20129;
               var1.field20129 = method08850(var2, var1.field20125);
               this.field20116.addLast(var1);
            }
         }
      }
   }

   private void method08847() {
      if (!this.field20119.isEmpty()) {
         ParticleEmitter var1;
         while ((var1 = this.field20119.pollFirst()) != null) {
            if (var1.method03861()) {
               this.field20118.addLast(var1);
            }
         }
      }
   }

   private void method08848(int var1) {
      int var2 = this.field20116.size() + this.field20117.size() + var1 - this.field20120;

      while (var2 > 0) {
         ClientParticleManager.Nested246 var3 = this.field20116.pollFirst();
         if (var3 != null) {
            var3.field20122.method01015();
            var2--;
         } else {
            ClientParticleManager.Nested246 var4 = this.field20117.pollFirst();
            if (var4 == null) {
               break;
            }

            var4.field20122.method01015();
            var2--;
         }
      }
   }

   private static int method08849(ClientParticle var0, int var1) {
      int var2 = Math.max(1, var0.method01011());
      return var1 <= 0 ? Math.max(1, var2 / 2) : Math.max(1, Math.min(var1, var2));
   }

   private static float method08850(ClientParticle var0, int var1) {
      int var2 = Math.max(1, var0.method01011());
      float var3 = Math.min(var2, var0.method01064());
      if (var0.method01079() == ParticleInterpolationMode.LINEAR) {
         return Math.clamp(1.0F - var3 / var2, 0.0F, 1.0F);
      }

      int var4 = Math.max(1, Math.min(var1, var2));
      float var5 = var2 - var4;
      float var6 = var3 > var5 ? (var2 - var3) / var4 : 1.0F;
      float var7 = Math.min(3.0F, var4);
      float var8 = var3 / Math.max(1.0F, var7);
      float var9 = Math.clamp(Math.min(var8, var6), 0.0F, 1.0F);
      return method08851(var9);
   }

   private static float method08851(float var0) {
      return var0 * var0 * (3.0F - 2.0F * var0);
   }

   // $VF: Compiled from s
   public static final class Nested246 {
      private final ClientParticle field20122;
      private final int field20123;
      private final float field20124;
      private final int field20125;
      private final float field20126 = ThreadLocalRandom.current().nextFloat();
      private boolean field20127 = true;
      private float field20128;
      private float field20129;

      public float method08852() {
         return this.field20126;
      }

      private Nested246(ClientParticle var1, int var2, float var3, int var4) {
         this.field20122 = var1;
         this.field20123 = var2;
         this.field20124 = var3;
         this.field20125 = var4;
      }

      public float method08853(float var1) {
         return this.field20128 + (this.field20129 - this.field20128) * var1;
      }

      public boolean method08854() {
         return this.field20127;
      }

      public int method08855() {
         return this.field20123;
      }

      public ClientParticle method08856() {
         return this.field20122;
      }

      public float method08857() {
         return this.field20124;
      }
   }
}
