// Original binary: sg/ec/rxG3TMeQMpHfP4DD
package sg.ec;

import com.mojang.math.Axis;
import java.util.List;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

// $VF: Compiled from s
public class ClientParticleRenderer implements MinecraftAccess {
   private static final Quaternionf field23498 = Axis.ZP.rotationDegrees(ClientParticleRenderer.field23531);
   private static final float field23499 = 0.003921569F;
   private static final float field23500 = 0;
   private final Quaternionf field23501 = new Quaternionf();
   private final Vector3f field23502 = new Vector3f().set(1.0F, 0.0F, 0.0F);
   private final Vector3f field23503 = new Vector3f().set(0.0F, 1.0F, 0.0F);
   private final Vector3f field23504 = new Vector3f();
   private final Vector3f field23505 = new Vector3f();
   private final Vector3f field23506 = new Vector3f();
   private final Vector3f field23507 = new Vector3f();
   private final Vector3f field23508 = new Vector3f();
   private final Vector3f field23509 = new Vector3f();
   private final Vector3f field23510 = new Vector3f();
   private final Quaternionf field23511 = new Quaternionf();
   private RenderType field23512;
   private int field23513 = -1;
   private static final float field23514 = 0.001F;
   private static final float field23515 = 0.001F;
   private static final float field23516 = 0.5F;
   private static final float field23517 = 0.75F;
   private static final float field23518 = 128.0F;
   private static final float field23519 = 64.0F;
   private static final float field23520 = 4.0F;
   private static final float field23521 = 4.0F;
   private static final float field23522 = 4.0F;
   private static final float field23523 = 4.0F;
   private static final float field23524 = 4.0F;
   private static final float field23525 = 4.0F;
   private static final float field23526 = 32.0F;
   private static final float field23527 = 0.003921569F;
   private static final float field23528 = 0.003921569F;
   private static final float field23529 = 0.003921569F;
   private static final float field23530 = 255.0F;
   private static final float field23531 = 90.0F;

   @Subscribe
   private void method10527(FrameDeltaEvent var1) {
      this.method10533(ModuleManager.INSTANCE.method08231());
      if (!ClientParticleManager.INSTANCE.method08831()) {
         ClientParticleManager.INSTANCE.method08841();
      }
   }

   private static void method10528(
      BaritoneVertexConsumerAccess var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12
   ) {
      var0.texturedVertexPre(var1 - var4 - var7, var2 - var5 - var8, var3 - var6 - var9, var10, 0.0F, var12);
      var0.texturedVertexPre(var1 + var4 - var7, var2 + var5 - var8, var3 + var6 - var9, var10, 1.0F, var12);
      var0.texturedVertexPre(var1 + var4 + var7, var2 + var5 + var8, var3 + var6 + var9, var11, 1.0F, var12);
      var0.texturedVertexPre(var1 - var4 + var7, var2 - var5 + var8, var3 - var6 + var9, var11, 0.0F, var12);
   }

   private static int method10529(float var0, float var1, float var2) {
      float var3 = Math.max(var0, Math.max(var1, var2)) / 2.0F;
      if (var3 <= 0.0F) {
         return 0;
      }

      int var4 = Math.min(255, Math.max(1, Math.round(var3)));
      float var5 = field23530 / (var4 * 2.0F);
      return var4 << 24 | method10530(var0 * var5) << 16 | method10530(var1 * var5) << 8 | method10530(var2 * var5);
   }

   private static int method10530(float var0) {
      return Math.min(255, Math.max(0, Math.round(var0)));
   }

   @Subscribe
   private void method10531(TickEvent var1) {
      ClientParticleManager.INSTANCE.method08840();
   }

   private static int method10532(int var0, int var1) {
      float var2 = ColorUtils.method04594(var0) * field23528;
      float var3 = ColorUtils.method04594(var1) * field23529;
      return method10529(
         ColorUtils.method04617(var0) * var2 + ColorUtils.method04617(var1) * var3,
         ColorUtils.method04619(var0) * var2 + ColorUtils.method04619(var1) * var3,
         ColorUtils.method04607(var0) * var2 + ColorUtils.method04607(var1) * var3
      );
   }

   private void method10533(Particles var1) {
      int var2 = method10537(var1);
      if (var2 == 0) {
         this.field23512 = null;
      } else {
         if (var2 != this.field23513) {
            ParticleAtlas.INSTANCE.method03423(var2);
            if (ParticleAtlas.INSTANCE.method03420() == null) {
               return;
            }

            this.field23513 = var2;
         }

         this.field23512 = ParticleAtlas.INSTANCE.method03420();
      }
   }

   public static int method10534(int var0) {
      float var1 = ColorUtils.method04594(var0) * field23527;
      return method10529(ColorUtils.method04617(var0) * var1, ColorUtils.method04619(var0) * var1, ColorUtils.method04607(var0) * var1);
   }

   @Subscribe
   private void method10535(Render3DEvent var1) {
      Particles var2 = ModuleManager.INSTANCE.method08231();
      if (!ClientParticleManager.INSTANCE.method08831()) {
         if (this.field23512 == null) {
            this.method10533(var2);
         }

         RenderType var3 = this.field23512;
         int var4 = ParticleAtlas.INSTANCE.method03419();
         if (var3 != null && var4 != 0) {
            if (var1.method00985().method07407(var3) instanceof BaritoneVertexConsumerAccess var6) {
               float var7 = PlayerUtils.method11802();
               boolean var8 = var2.method03706().method05999();
               Vec3 var9 = var1.method00994().position();
               this.field23501.set(mc.getEntityRenderDispatcher().camera.rotation()).mul(field23498);
               this.field23504.set(1.0F, 0.0F, 0.0F);
               this.field23505.set(0.0F, 1.0F, 0.0F);
               this.field23501.transform(this.field23504);
               this.field23501.transform(this.field23505);
               this.field23504.cross(this.field23505, this.field23506).normalize();
               Matrix4f var10 = var1.method00996().last().pose();
               var10.transformDirection(this.field23507.set(this.field23504));
               var10.transformDirection(this.field23508.set(this.field23505));

               for (ClientParticleManager.Nested246 var12 : ClientParticleManager.INSTANCE.method08832()) {
                  if (var12.method08854()) {
                     ClientParticle var13 = var12.method08856();
                     if (var13.method01051()) {
                        float var14 = var12.method08853(var7);
                        if (!(var14 <= field23514)) {
                           float var15 = var13.method01077(var7);
                           if (!(var15 <= field23515)) {
                              float var16 = var13.method01058() != 0.0F ? var13.method01014(var7) : 0.0F;
                              if (var16 != 0.0F) {
                                 this.field23511.setAngleAxis(var16, this.field23506.x, this.field23506.y, this.field23506.z);
                                 this.field23511.transform(this.field23502.set(this.field23504));
                                 this.field23511.transform(this.field23503.set(this.field23505));
                                 var10.transformDirection(this.field23509.set(this.field23502));
                                 var10.transformDirection(this.field23510.set(this.field23503));
                              } else {
                                 this.field23502.set(this.field23504);
                                 this.field23503.set(this.field23505);
                                 this.field23509.set(this.field23507);
                                 this.field23510.set(this.field23508);
                              }

                              int var17 = (int)(var12.method08852() * var4);
                              if (var17 >= var4) {
                                 var17 = var4 - 1;
                              }

                              this.method10536(
                                 var6,
                                 var10,
                                 var9,
                                 var12,
                                 var14,
                                 var15,
                                 var8,
                                 var13.method01067(var7),
                                 var13.method01069(var7),
                                 var13.method01013(var7),
                                 ParticleAtlas.INSTANCE.method03421(var17),
                                 ParticleAtlas.INSTANCE.method03422(var17)
                              );
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void method10536(
      BaritoneVertexConsumerAccess var1,
      Matrix4f var2,
      Vec3 var3,
      ClientParticleManager.Nested246 var4,
      float var5,
      float var6,
      boolean var7,
      double var8,
      double var10,
      double var12,
      float var14,
      float var15
   ) {
      float var16 = var4.method08857() * var6;
      float var17 = var16 * field23516;
      var5 *= field23517;
      int var18 = ColorUtils.method04611(var4.method08855(), var5);
      float var19 = (float)(var8 - var3.x) + this.field23503.x * var17;
      float var20 = (float)(var10 - var3.y) + this.field23503.y * var17;
      float var21 = (float)(var12 - var3.z) + this.field23503.z * var17;
      float var22 = var2.m00();
      float var23 = var2.m10();
      float var24 = var2.m20();
      float var25 = var2.m30();
      float var26 = var2.m01();
      float var27 = var2.m11();
      float var28 = var2.m21();
      float var29 = var2.m31();
      float var30 = var2.m02();
      float var31 = var2.m12();
      float var32 = var2.m22();
      float var33 = var2.m32();
      float var34 = var22 * var19 + var23 * var20 + var24 * var21 + var25;
      float var35 = var26 * var19 + var27 * var20 + var28 * var21 + var29;
      float var36 = var30 * var19 + var31 * var20 + var32 * var21 + var33;
      float var37 = this.field23509.x * var16;
      float var38 = this.field23509.y * var16;
      float var39 = this.field23509.z * var16;
      float var40 = this.field23510.x * var16;
      float var41 = this.field23510.y * var16;
      float var42 = this.field23510.z * var16;
      int var43 = ColorUtils.method04616(var18, (int)(field23518 * var5));
      method10528(var1, var34, var35, var36, var37, var38, var39, var40, var41, var42, var14, var15, method10532(var18, var43));
      if (var7) {
         method10528(
            var1,
            var34,
            var35,
            var36,
            var37 * 2.0F,
            var38 * 2.0F,
            var39 * 2.0F,
            var40 * 2.0F,
            var41 * 2.0F,
            var42 * 2.0F,
            var14,
            var15,
            method10534(ColorUtils.method04616(var43, (int)(field23519 * var5)))
         );
         method10528(
            var1,
            var34,
            var35,
            var36,
            var37 * field23520,
            var38 * field23521,
            var39 * field23522,
            var40 * field23523,
            var41 * field23524,
            var42 * field23525,
            var14,
            var15,
            method10534(ColorUtils.method04616(var43, (int)(field23526 * var5)))
         );
      }
   }

   private static int method10537(Particles var0) {
      var var1 = var0.method03726().method03022();
      int var2 = 0;

      for (int var3 = 0; var3 < var1.size() && var3 < 11; var3++) {
         if (Boolean.TRUE.equals(((NamedOption)var1.get(var3)).method08074())) {
            var2 |= 1 << var3;
         }
      }

      return var2;
   }

   @Subscribe
   private void method10538(WorldLoadEvent var1) {
      ClientParticleManager.INSTANCE.method08839();
   }

   public void method10539() {
      EventBus.method00263(this);
   }
}
