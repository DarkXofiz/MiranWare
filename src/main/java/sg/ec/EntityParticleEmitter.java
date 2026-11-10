// Original binary: sg/ec/srsiQUSWlkdAWR6C
package sg.ec;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public abstract class EntityParticleEmitter extends ParticleEmitter {
   private static final int field23735 = 16;
   protected final Entity field23736;
   private final int field23737;
   private final int field23738;
   private int field23739;
   private static final double field23740 = 2.0;
   private static final double field23741 = 2.0;
   private static final double field23742 = 2.0;
   private static final double field23743 = 4.0;
   private static final double field23744 = 0.5;
   private static final double field23745 = 4.0;
   private static final double field23746 = 4.0;
   private static final double field23747 = 0.2;

   protected EntityParticleEmitter(Entity var1, int var2, int var3) {
      this.field23736 = var1;
      this.field23737 = Math.max(1, var2);
      this.field23738 = Math.max(1, var3);
   }

   public Entity method10772() {
      return this.field23736;
   }

   @Override
   protected void method03743(ClientParticleManager var1) {
      if (this.field23736 != null && this.field23736.level() != null) {
         ThreadLocalRandom var2 = ThreadLocalRandom.current();

         for (int var3 = 0; var3 < this.field23738; var3++) {
            double var4 = var2.nextDouble() * field23740 - 1.0;
            double var6 = var2.nextDouble() * field23741 - 1.0;
            double var8 = var2.nextDouble() * field23742 - 1.0;
            if (!(var4 * var4 + var6 * var6 + var8 * var8 > 1.0)) {
               double var10 = this.field23736.getX(var4 / field23743);
               double var12 = this.field23736.getY(field23744 + var6 / field23745);
               double var14 = this.field23736.getZ(var8 / field23746);
               this.method03744(var1, var10, var12, var14, var4, var6 + field23747, var8);
            }
         }

         this.field23739++;
         if (this.field23739 >= this.field23737) {
            this.method03863();
         }
      } else {
         this.method03863();
      }
   }

   protected abstract void method03744(ClientParticleManager var1, double var2, double var4, double var6, double var8, double var10, double var12);

   public int method10773() {
      return this.field23739;
   }

   public int method10774() {
      return this.field23737;
   }

   protected EntityParticleEmitter(Entity var1, int var2) {
      this(var1, var2, 16);
   }
}
