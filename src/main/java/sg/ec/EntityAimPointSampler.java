// Original binary: sg/ec/65faP5anFnAcUYkP
package sg.ec;

import java.util.ArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class EntityAimPointSampler implements MinecraftAccess {
   private static final int field02691 = 10;
   private static final int field02692 = 0;
   private static final double field02693 = 0;
   private static final double field02694 = 0;
   private final ArrayList<Vec3> field02695 = new ArrayList<>();
   private Vec3 field02696 = Vec3.ZERO;
   private Vec3 field02697 = Vec3.ZERO;
   private Vec3 field02698 = null;
   private Vec3 field02699 = null;
   private boolean field02700 = false;
   private int field02701 = -1;
   private int field02702;
   private static final int field02703 = Integer.MIN_VALUE;
   private static final double field02704 = 0.1;
   private static final double field02705 = 0.25;
   private static final double field02706 = 0.1;
   private static final double field02707 = 0.25;
   private static final double field02708 = 0.1;
   private static final double field02709 = 0.25;
   private static final double field02710 = 0.19;
   private static final double field02711 = 0.19;
   private static final double field02712 = 0.19;
   private static final float field02713 = 0.01F;
   private static final float field02714 = 0.03F;
   private static final float field02715 = 0.01F;
   private static final float field02716 = 0.03F;
   private static final float field02717 = -0.05F;
   private static final float field02718 = 0.05F;
   private static final float field02719 = -0.05F;
   private static final float field02720 = 0.05F;
   private static final float field02721 = -0.05F;
   private static final float field02722 = 0.05F;
   private static final double field02723 = 0.05;
   private static final double field02724 = 2.0;
   private static final double field02725 = 2.0;
   private static final double field02726 = 0.05;
   private static final double field02727 = 2.0;
   private static final double field02728 = 0.05;
   private static final double field02729 = 2.0;
   private static final float field02730 = 0.03F;
   private static final double field02731 = 0.1;
   private static final double field02732 = 0.05;
   private static final double field02733 = 2.0;
   private static final float field02734 = -0.03F;
   private static final float field02735 = 0.03F;
   private static final float field02736 = -0.03F;
   private static final float field02737 = 0.03F;
   private static final double field02738 = 2.0;
   private static final float field02739 = 0.05F;
   private static final float field02740 = 0.15F;
   private static final float field02741 = 0.05F;
   private static final float field02742 = 0.05F;

   private Vec3 method01262(LivingEntity var1) {
      if (this.field02695.isEmpty()) {
         return null;
      }

      if (mc.player == null) {
         return null;
      }

      Vec3 var2 = mc.player.getEyePosition();
      Vec3 sx = null;
      double sxx = Double.POSITIVE_INFINITY;

      for (Vec3 sxxx : this.field02695) {
         Vec3 sxxxx = sxxx.add(var1.position());
         if (GuiHitTestUtils.method05608(sxxxx)) {
            double sxxxxx = sxxxx.distanceToSqr(var2);
            if (sxxxxx < sxx) {
               sxx = sxxxxx;
               sx = sxxxx;
            }
         }
      }

      return sx;
   }

   private void method01263(LivingEntity var1, AABB var2) {
      this.field02695.clear();
      double var3 = Math.min(field02704, var2.getXsize() * field02705);
      double var5 = Math.min(field02706, var2.getYsize() * field02707);
      double var7 = Math.min(field02708, var2.getZsize() * field02709);
      double var9 = var2.minX + var3;
      double var11 = var2.minY + var5;
      double var13 = var2.minZ + var7;
      double var15 = var2.maxX - var3;
      double var17 = var2.maxY - var5;
      double var19 = var2.maxZ - var7;
      Vec3 var21 = var1.position();

      for (double var22 = var9; var22 <= var15; var22 += field02712) {
         for (double var24 = var11; var24 <= var17; var24 += field02711) {
            for (double var26 = var13; var26 <= var19; var26 += field02710) {
               this.field02695.add(new Vec3(var22, var24, var26).subtract(var21));
            }
         }
      }
   }

   public EntityAimPointSampler() {
      this.field02702 = field02703;
   }

   private Vec3 method01264(Vec3 var1, Vec3 var2, double var3) {
      double var5 = var3 * var3;
      Vec3 var7 = null;
      Vec3 var8 = null;
      double var9 = Double.POSITIVE_INFINITY;
      int var11 = 0;

      for (Vec3 var13 : this.field02695) {
         double var14 = var1.x + var13.x - var2.x;
         double var16 = var1.y + var13.y - var2.y;
         double var18 = var1.z + var13.z - var2.z;
         double var20 = var14 * var14 + var16 * var16 + var18 * var18;
         if (var20 < var9) {
            var9 = var20;
            var8 = var13;
         }

         if (var20 <= var5) {
            if (GuiHitTestUtils.field11989.nextInt(++var11) == 0) {
               var7 = var13;
            }
         }
      }

      this.field02700 = var7 != null;
      return var7 != null ? var7 : var8;
   }

   public Vec3 method01265(Entity var1, double var2) {
      if (mc.player == null) {
         return var1.position();
      }

      float var4 = field02713;
      float var5 = field02714;
      float var6 = field02715;
      float var7 = field02716;
      double var8 = var1.getBoundingBox().getXsize();
      double var10 = var1.getBoundingBox().getYsize();
      double var12 = var1.getBoundingBox().getZsize();
      if (this.field02697.equals(Vec3.ZERO)) {
         this.field02697 = new Vec3(
            GuiHitTestUtils.method05613(field02717, field02718),
            GuiHitTestUtils.method05613(field02719, field02720),
            GuiHitTestUtils.method05613(field02721, field02722)
         );
      }

      this.field02696 = this.field02696.add(this.field02697);
      if (this.field02696.x >= (var8 - field02723) / field02724) {
         this.field02697 = new Vec3(-GuiHitTestUtils.method05613(var4, var5), this.field02697.y(), this.field02697.z());
      }

      if (this.field02696.y >= var10 / field02725) {
         this.field02697 = new Vec3(this.field02697.x(), -GuiHitTestUtils.method05613(var6, var7), this.field02697.z());
      }

      if (this.field02696.z >= (var12 - field02726) / field02727) {
         this.field02697 = new Vec3(this.field02697.x(), this.field02697.y(), -GuiHitTestUtils.method05613(var4, var5));
      }

      if (this.field02696.x <= -(var8 - field02728) / field02729) {
         this.field02697 = new Vec3(GuiHitTestUtils.method05613(var4, field02730), this.field02697.y(), this.field02697.z());
      }

      if (this.field02696.y <= field02731) {
         this.field02697 = new Vec3(this.field02697.x(), GuiHitTestUtils.method05613(var6, var7), this.field02697.z());
      }

      if (this.field02696.z <= -(var12 - field02732) / field02733) {
         this.field02697 = new Vec3(this.field02697.x(), this.field02697.y(), GuiHitTestUtils.method05613(var4, var5));
      }

      this.field02696.add(GuiHitTestUtils.method05613(field02734, field02735), 0.0, GuiHitTestUtils.method05613(field02736, field02737));
      if (!this.method01271(mc.player.getLookAngle(), var2, var1.getBoundingBox())) {
         float var14 = (float)(var8 / field02738);

         for (float var15 = -var14; var15 <= var14; var15 += field02742) {
            for (float var16 = -var14; var16 <= var14; var16 += field02741) {
               for (float var17 = field02739; var17 <= var1.getBoundingBox().getYsize(); var17 += field02740) {
                  Vec3 var18 = new Vec3(var1.getX() + var15, var1.getY() + var17, var1.getZ() + var16);
                  Rotation var19 = Rotation.method09438(var18);
                  Vec3 var20 = RaycastUtils.method09509(var19.method09443(), var19.method09439());
                  if (this.method01271(var20, var2, var1.getBoundingBox())) {
                     this.field02696 = new Vec3(var15, var17, var16);
                     break;
                  }
               }
            }
         }
      }

      return var1.position().add(this.field02696);
   }

   public Vec3 method01266() {
      return this.field02698;
   }

   private boolean method01267(Vec3 var1, AABB var2, Vec3 var3, double var4) {
      return !var2.contains(var1) ? false : !this.field02700 || var1.distanceTo(var3) <= var4;
   }

   public void method01268(LivingEntity var1) {
      if (var1 == null) {
         this.field02695.clear();
         this.field02698 = null;
         this.field02699 = null;
      } else {
         this.method01263(var1, var1.getBoundingBox());
         this.field02698 = this.method01262(var1);
      }
   }

   public ArrayList<Vec3> method01269() {
      return this.field02695;
   }

   public Vec3 method01270(LivingEntity var1, Vec3 var2, double var3) {
      if (!this.field02695.isEmpty() && mc.player != null) {
         Vec3 var5 = var1.position();
         AABB var6 = var1.getBoundingBox();
         int var7 = mc.player.tickCount;
         if (this.field02699 == null
            || var1.getId() != this.field02701
            || var7 >= this.field02702
            || !this.method01267(this.field02699.add(var5), var6, var2, var3)) {
            this.field02699 = this.method01264(var5, var2, var3);
            this.field02701 = var1.getId();
            this.field02702 = var7 + 10 + GuiHitTestUtils.field11989.nextInt(11);
         }

         return this.field02699 == null ? null : this.field02699.add(var5);
      } else {
         return null;
      }
   }

   private boolean method01271(Vec3 var1, double var2, AABB var4) {
      if (mc.player == null) {
         return false;
      }

      Vec3 var5 = mc.player.getEyePosition();
      return var4.contains(var5) || var4.clip(var5, var5.add(var1.scale(var2))).isPresent();
   }
}
