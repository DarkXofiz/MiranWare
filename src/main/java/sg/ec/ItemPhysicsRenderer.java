// Original binary: sg/ec/aXgHIbcAXlEqEQZq
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.cuboid.ItemTransform;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import sg.mx.EntityMixin_1159;
import sg.mx.ItemStackRenderState$LayerRenderStateMixin;
import sg.mx.ItemStackRenderStateMixin;

// $VF: Compiled from s
public class ItemPhysicsRenderer {
   private static final float field15611 = 0.25F;
   private static final double field15612 = 0;
   private static final Minecraft field15613 = Minecraft.getInstance();
   private static final float field15614 = 0.25F;
   private static final double field15615 = 0.2;
   private static final double field15616 = 5.0;
   private static final float field15617 = 90.0F;
   private static final float field15618 = 180.0F;
   private static final float field15619 = 270.0F;
   private static final float field15620 = 90.0F;
   private static final float field15621 = 180.0F;
   private static final float field15622 = 270.0F;
   private static final float field15623 = 90.0F;
   private static final float field15624 = 180.0F;
   private static final float field15625 = 270.0F;
   private static final float field15626 = (float) (Math.PI / 2);
   private static final double field15627 = -0.2;
   private static final double field15628 = -0.08;
   private static final double field15629 = -0.14;
   private static final double field15630 = 0.007957747154594767;
   private static final double field15631 = -0.04;
   private static final double field15632 = 0.007957747154594767;
   private static final float field15633 = -0.0F;
   private static final float field15634 = 0.5F;
   private static final float field15635 = -0.0F;
   private static final float field15636 = 0.5F;
   private static final float field15637 = -0.09375F;
   private static final float field15638 = 0.5F;
   private static final float field15639 = 0.09375F;

   public static boolean method06931(ItemEntityRenderState var0, PoseStack var1, SubmitNodeCollector var2, CameraRenderState var3, RandomSource var4) {
      if (!ItemPhysics.method04428()) {
         return false;
      }

      if (!(var0.ageInTicks < 1.0F) && !((ItemEntityPhysicsAccess)var0).skipRendering()) {
         var1.pushPose();
         var4.setSeed(var0.seed);
         int var5 = method06933(var0.count);
         boolean sx = ((ItemEntityPhysicsAccess)var0).isBlock();
         ItemTransform sxx = ((ItemStackRenderState$LayerRenderStateMixin)((ItemStackRenderStateMixin)(Object)var0.item).callFirstLayer()).getItemTransform();
         var1.rotate(Axis.XP.rotation(field15626));
         var1.rotate(Axis.ZP.rotation(((ItemEntityPhysicsAccess)var0).getYRot()));
         if (var0.ageInTicks != 0.0F && (sx || field15613.options != null)) {
            if (sx) {
               var1.translate(0.0, field15627, field15628);
            } else if (((ItemEntityPhysicsAccess)var0).hasAdditionalOffset()) {
               var1.translate(0.0, 0.0, field15629 - var0.bobOffset * field15630);
            } else {
               var1.translate(0.0, 0.0, field15631 - var0.bobOffset * field15632);
            }

            double sxxx = sxx.scale().y();
            if (sx) {
               var1.translate(0.0, sxxx, 0.0);
            }

            var1.rotate(Axis.YP.rotation(((ItemEntityPhysicsAccess)var0).getXRot()));
            if (sx) {
               var1.translate(0.0, -sxxx, 0.0);
            }
         }

         if (!sx) {
            float sxxx = field15633 * (var5 - 1) * field15634;
            float sxxxx = field15635 * (var5 - 1) * field15636;
            float sxxxxx = field15637 * (var5 - 1) * field15638;
            var1.translate(sxxx, sxxxx, sxxxxx);
         }

         float sxxx = sxx.scale().x();
         float sxxxx = sxx.scale().y();
         float sxxxxx = sxx.scale().z();

         for (int sxxxxxx = 0; sxxxxxx < var5; sxxxxxx++) {
            var1.pushPose();
            if (sxxxxxx > 0 && sx) {
               float sxxxxxxx = (var4.nextFloat() * 2.0F - 1.0F) * sxxx;
               float sxxxxxxxx = (var4.nextFloat() * 2.0F - 1.0F) * sxxxx;
               float sxxxxxxxxx = (var4.nextFloat() * 2.0F - 1.0F) * sxxxxx;
               var1.translate(sxxxxxxx, sxxxxxxxx, sxxxxxxxxx);
            }

            var0.item.submit(var1, var2, var0.lightCoords, OverlayTexture.NO_OVERLAY, var0.outlineColor);
            var1.popPose();
            if (!sx) {
               var1.translate(0.0F * sxxx, 0.0F * sxxxx, field15639 * sxxxxx);
            }
         }

         var1.popPose();
         return true;
      } else {
         return false;
      }
   }

   public static void method06932(ItemEntity var0, ItemEntityRenderState var1) {
      if (var0 != null) {
         ItemPhysics var2 = ItemPhysics.method04427();
         if (var2 != null) {
            float var3 = field15613.getDeltaTracker().getRealtimeDeltaTicks() * field15614 * var2.method04426();
            if (field15613.isPaused()) {
               var3 = 0.0F;
            }

            Vec3 var4 = ((EntityMixin_1159)(Object)var0).getStuckSpeedMultiplier();
            if (var4 != null && var4.lengthSqr() > 0.0) {
               var3 = (float)(var3 * (var4.x * field15615));
            }

            boolean var5 = ((ItemEntityPhysicsAccess)var1).isBlock();
            if (var5) {
               if (!var0.onGround()) {
                  var3 *= 2.0F;
                  Fluid var6 = ItemFluidPhysics.method07428(var0);
                  if (var6 == null) {
                     var6 = ItemFluidPhysics.method07429(var0, true);
                  }

                  if (var6 != null) {
                     var3 /= 1.0F + ItemFluidPhysics.method07427(var6, var0.level());
                  }

                  var0.setXRot(var0.getXRot() + var3);
               } else if (var2.method04425()) {
                  for (int var16 = 0; var16 < 4; var16++) {
                     double var7 = var16 * 90;
                     double var9 = field15616;
                     if (var0.getXRot() > var7 - var9 && var0.getXRot() < var7 + var9) {
                        var0.setXRot((float)var7);
                     }
                  }

                  if (var0.getXRot() != 0.0F && var0.getXRot() != field15617 && var0.getXRot() != field15618 && var0.getXRot() != field15619) {
                     double var17 = Math.abs(var0.getXRot());
                     double var8 = Math.abs(var0.getXRot() - field15620);
                     double var10 = Math.abs(var0.getXRot() - field15621);
                     double var12 = Math.abs(var0.getXRot() - field15622);
                     if (var17 <= var8 && var17 <= var10 && var17 <= var12) {
                        if (var0.getXRot() < 0.0F) {
                           var0.setXRot(var0.getXRot() + var3);
                        } else {
                           var0.setXRot(var0.getXRot() - var3);
                        }
                     }

                     if (var8 < var17 && var8 <= var10 && var8 <= var12) {
                        if (var0.getXRot() - field15623 < 0.0F) {
                           var0.setXRot(var0.getXRot() + var3);
                        } else {
                           var0.setXRot(var0.getXRot() - var3);
                        }
                     }

                     if (var10 < var8 && var10 < var17 && var10 <= var12) {
                        if (var0.getXRot() - field15624 < 0.0F) {
                           var0.setXRot(var0.getXRot() + var3);
                        } else {
                           var0.setXRot(var0.getXRot() - var3);
                        }
                     }

                     if (var12 < var8 && var12 < var10 && var12 < var17) {
                        if (var0.getXRot() - field15625 < 0.0F) {
                           var0.setXRot(var0.getXRot() + var3);
                        } else {
                           var0.setXRot(var0.getXRot() - var3);
                        }
                     }
                  }
               }
            } else if (var0 != null && !Double.isNaN(var0.getX()) && !Double.isNaN(var0.getY()) && !Double.isNaN(var0.getZ()) && var0.level() != null) {
               if (var0.onGround()) {
                  var0.setXRot(0.0F);
               } else {
                  var3 *= 2.0F;
                  Fluid var18 = ItemFluidPhysics.method07428(var0);
                  if (var18 != null) {
                     var3 /= 1.0F + ItemFluidPhysics.method07427(var18, var0.level());
                  }

                  var0.setXRot(var0.getXRot() + var3);
               }
            }
         }
      }
   }

   public static int method06933(int var0) {
      if (var0 > 48) {
         return 5;
      } else if (var0 > 32) {
         return 4;
      } else if (var0 > 16) {
         return 3;
      } else {
         return var0 > 1 ? 2 : 1;
      }
   }
}
