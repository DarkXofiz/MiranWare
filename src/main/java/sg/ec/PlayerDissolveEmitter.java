// Original binary: sg/ec/Gxw5e4bfWRXfndvA
package sg.ec;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.world.entity.Entity;
import org.joml.Vector3f;

// $VF: Compiled from s
public class PlayerDissolveEmitter extends EntityParticleEmitter {
   public static final int field08311 = 350;
   private static final int field08312 = 0;
   private static final int field08313 = 0;
   private static final int field08314 = 0;
   private static final float field08315 = 0;
   private static final float field08316 = 0;
   private static final float field08317 = 0;
   private static final float field08318 = 0;
   private static final float field08319 = 0;
   private static final float field08320 = 0;
   private static final float field08321 = 0;
   private static final float field08322 = 0;
   private static final float field08323 = 0;
   private static final float field08324 = 0;
   private static final float field08325 = 0;
   private final List<Vector3f> field08326;
   private static final double field08327 = 0.5;
   private static final double field08328 = 1.0E-4;
   private static final float field08329 = 0.1F;
   private static final float field08330 = 0.2F;
   private static final float field08331 = -0.21F;
   private static final float field08332 = 0.21F;
   private static final float field08333 = 0.01F;
   private static final float field08334 = 0.53F;
   private static final float field08335 = -0.1F;
   private static final float field08336 = 0.9F;
   private static final float field08337 = 0.8F;
   private static final float field08338 = 0.5F;
   private static final int field08339 = -16777216;

   private static int method03742(ThreadLocalRandom var0) {
      int var1 = var0.nextInt(110, 191);
      int sx = var0.nextInt(225, 256);
      return field08339 | var1 << 16 | sx << 8 | 0xFF;
   }

   @Override
   protected void method03743(ClientParticleManager var1) {
      Entity var2 = this.method10772();
      if (var2 != null && var2.level() != null) {
         double var3 = var2.getX();
         double var5 = var2.getY() + var2.getBbHeight() * field08327;
         double var7 = var2.getZ();

         for (Vector3f var10 : this.field08326) {
            double var11 = var10.x - var3;
            double var13 = var10.y - var5;
            double var15 = var10.z - var7;
            double var17 = Math.sqrt(var11 * var11 + var13 * var13 + var15 * var15);
            if (var17 < field08328) {
               var11 = 0.0;
               var13 = 1.0;
               var15 = 0.0;
            } else {
               var11 /= var17;
               var13 /= var17;
               var15 /= var17;
            }

            this.method03744(var1, var10.x, var10.y, var10.z, var11, var13, var15);
         }

         this.method03863();
      } else {
         this.method03863();
      }
   }

   public PlayerDissolveEmitter(Entity var1, List<Vector3f> var2) {
      super(var1, 1, Math.max(1, var2.size()));
      this.field08326 = var2;
   }

   @Override
   protected void method03744(ClientParticleManager var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      ThreadLocalRandom var14 = ThreadLocalRandom.current();
      float var15 = var14.nextFloat(field08329, field08330);
      int var16 = ModuleManager.INSTANCE.method08231().method03728(var14.nextInt() % 360);
      float var17 = var14.nextFloat(field08331, field08332);
      float var18 = var14.nextFloat(field08333, field08334);
      ClientParticle.Nested35 var19 = new ClientParticle.Nested35(var2, var4, var6)
         .method01117(var8 * var18, var10 * var18, var12 * var18)
         .method01112(field08335)
         .method01115(15)
         .method01110(field08336)
         .method01109(false)
         .method01127(82)
         .method01120(var15, var15)
         .method01128(var17)
         .method01094(field08337, 1.0F, 0.0F, field08338);
      var1.method08834(var19, var16, var15, 46);
   }
}
