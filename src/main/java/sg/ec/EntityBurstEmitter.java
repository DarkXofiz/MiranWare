// Original binary: sg/ec/j6vugvX0MODMpO7l
package sg.ec;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public class EntityBurstEmitter extends EntityParticleEmitter {
   private static final float field20344 = 0.225F;
   private static final float field20345 = 0;
   private static final int field20346 = 0;
   private static final int field20347 = 0;
   private static final float field20348 = 0;
   private static final float field20349 = 0;
   private static final float field20350 = 0.2F;
   private static final float field20351 = 0.25F;
   private static final float field20352 = 0.225F;
   private static final float field20353 = 0.75F;
   private static final float field20354 = 0.6F;
   private static final float field20355 = 0.2F;
   private static final float field20356 = 0.6F;
   private static final float field20357 = 0.3F;
   private static final float field20358 = 0.2F;
   private static final float field20359 = 0.1F;
   private static final float field20360 = 0.2F;
   private static final float field20361 = 0.4F;
   private static final float field20362 = 0.3F;
   private static final float field20363 = 0.2F;
   private static final float field20364 = 255.0F;
   private static final float field20365 = 255.0F;
   private static final float field20366 = 255.0F;
   private static final int field20367 = -16777216;

   @Override
   protected void method03744(ClientParticleManager var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      ThreadLocalRandom var14 = ThreadLocalRandom.current();
      int sx = 80 + var14.nextInt(40);
      float sxx = var14.nextFloat(field20350, field20351);
      int sxxx = method08942(var14);
      var1.method08834(
         new ClientParticle.Nested35(var2, var4, var6)
            .method01117(var8, var10, var12)
            .method01112(field20352)
            .method01110(field20353)
            .method01127(sx)
            .method01109(true)
            .method01120(sxx, sxx),
         sxxx,
         sxx,
         Math.max(1, sx / 2)
      );
   }

   public EntityBurstEmitter(Entity var1, int var2) {
      super(var1, var2);
   }

   private static int method08942(ThreadLocalRandom var0) {
      float var1;
      float var2;
      float var3;
      if (var0.nextInt(4) == 0) {
         var1 = field20354 + var0.nextFloat() * field20355;
         var2 = field20356 + var0.nextFloat() * field20357;
         var3 = var0.nextFloat() * field20358;
      } else {
         var1 = field20359 + var0.nextFloat() * field20360;
         var2 = field20361 + var0.nextFloat() * field20362;
         var3 = var0.nextFloat() * field20363;
      }

      int var4 = Math.min(255, Math.max(0, (int)(var1 * field20364)));
      int var5 = Math.min(255, Math.max(0, (int)(var2 * field20365)));
      int var6 = Math.min(255, Math.max(0, (int)(var3 * field20366)));
      return field20367 | var4 << 16 | var5 << 8 | var6;
   }
}
