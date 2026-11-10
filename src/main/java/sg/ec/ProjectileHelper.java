// Original binary: sg/ec/OJbpjVv90itI3BW6
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Vector2f;

// $VF: Compiled from s
public class ProjectileHelper extends ClientModule {
   private static final float field10497 = 7.0F;
   private static final float field10498 = 0;
   private static final float field10499 = 0;
   private static final int field10500 = 0;
   private static final float field10501 = 0;
   private static final int field10502 = 0;
   private static final float field10503 = 0;
   private static final float field10504 = 0;
   private static final int field10505 = ColorUtils.method04597(255, 60, 60, 220);
   private static final Vec3 field10506 = new Vec3(0.0, 1.0, 0.0);
   private static final float[] field10507 = method04775(32, false);
   private static final float[] field10508 = method04775(32, true);
   private static final float[] field10509 = method04775(64, false);
   private static final float[] field10510 = method04775(64, true);
   private final MultiToggleSetting field10511;
   private final MultiToggleSetting field10512;
   private final ToggleSetting field10513;
   private static final int field10514 = 0;
   private final List<ProjectileTrajectoryTracker.Nested6> field10515;
   private Vec3 field10516;
   private Vec3 field10517;
   private static final double field10518 = Math.PI * 2;
   private static final String field10519 = "Предиктить";
   private static final String field10520 = "Эндер жемчуг";
   private static final String field10521 = "Снежок";
   private static final String field10522 = "Заряд ветра";
   private static final String field10523 = "Взрывное зелье";
   private static final String field10524 = "Стрела";
   private static final String field10525 = "Предмет";
   private static final String field10526 = "Трезубец";
   private static final String field10527 = "Пред показ";
   private static final String field10528 = "Эндер жемчуг";
   private static final String field10529 = "Снежок";
   private static final String field10530 = "Заряд ветра";
   private static final String field10531 = "Взрывное зелье";
   private static final String field10532 = "Стрела";
   private static final String field10533 = "Предмет";
   private static final String field10534 = "Трезубец";
   private static final String field10535 = "Считать время";
   private static final String field10536 = "Projectile Helper";
   private static final float field10537 = 3.5F;
   private static final float field10538 = 3.0F;
   private static final float field10539 = 10.0F;
   private static final double field10540 = 0.1F;
   private static final float field10541 = 7.0F;
   private static final float field10542 = -0.1F;
   private static final float field10543 = 7.0F;
   private static final float field10544 = 7.0F;
   private static final float field10545 = -0.1F;
   private static final float field10546 = 3.5F;
   private static final float field10547 = 0.55F;
   private static final float field10548 = 1.0E-4F;
   private static final float field10549 = 3.0F;
   private static final float field10550 = 3.0F;
   private static final float field10551 = 4.0F;
   private static final float field10552 = 0.5F;
   private static final float field10553 = 0.5F;
   private static final double field10554 = 1.0E-6;
   private static final double field10555 = 0.99;
   private static final double field10556 = 0.02;
   private static final double field10557 = 0.02;
   private static final double field10558 = 0.02;
   private static final float field10559 = 1.0E-4F;
   private static final float field10560 = 3.0F;
   private static final float field10561 = 3.0F;

   @Subscribe
   private void method04769(Render3DEvent var1) {
      if (mc.level != null && mc.player != null) {
         float var2 = var1.method00984().getGameTimeDeltaPartialTick(true);
         Vec3 sx = this.field10516.lerp(this.field10517, var2);
         this.field10515.clear();
         this.field10515.addAll(ProjectileTrajectoryTracker.field00265.method00201(this, var2, sx));
         this.field10515.addAll(ProjectileTrajectoryTracker.field00265.method00199());
         var sxx = this.field10515;
         if (!sxx.isEmpty()) {
            Vec3 sxxx = var1.method00994().position();
            PoseStack sxxxx = var1.method00996();
            sxxxx.pushPose();
            Matrix4f sxxxxx = sxxxx.last().pose();
            if (var1.method00985().method07407(EffectRenderPipelines.method05563()) instanceof BaritoneVertexConsumerAccess sxxxxxx) {
               for (ProjectileTrajectoryTracker.Nested6 sxxxxxxx : sxx) {
                  this.method04771(sxxxxxx, sxxxxx, sxxx, sxxxxxxx);
               }

               for (ProjectileTrajectoryTracker.Nested6 sxxxxxxx : sxx) {
                  this.method04770(sxxxxxx, sxxxxx, sxxx, sxxxxxxx);
               }
            }

            sxxxx.popPose();
         }
      }
   }

   public ProjectileHelper() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field10511 = new MultiToggleSetting(field10519)
         .method04517(NamedOption.method08077(field10520, true))
         .method04517(NamedOption.method08077(field10521, false))
         .method04517(NamedOption.method08077(field10522, false))
         .method04517(NamedOption.method08077(field10523, false))
         .method04517(NamedOption.method08077(field10524, true))
         .method04517(NamedOption.method08077(field10525, false))
         .method04517(NamedOption.method08077(field10526, false))
         .method03023(this);
      this.field10512 = new MultiToggleSetting(field10527)
         .method04517(NamedOption.method08077(field10528, true))
         .method04517(NamedOption.method08077(field10529, false))
         .method04517(NamedOption.method08077(field10530, false))
         .method04517(NamedOption.method08077(field10531, false))
         .method04517(NamedOption.method08077(field10532, true))
         .method04517(NamedOption.method08077(field10533, false))
         .method04517(NamedOption.method08077(field10534, false))
         .method03023(this);
      this.field10513 = new ToggleSetting(field10535).method03017(false).method03023(this);
      this.field10515 = new ArrayList<>();
      this.field10516 = Vec3.ZERO;
      this.field10517 = Vec3.ZERO;
      this.method03935(field10536);
   }

   private void method04770(BaritoneVertexConsumerAccess var1, Matrix4f var2, Vec3 var3, ProjectileTrajectoryTracker.Nested6 var4) {
      if (var4.field00396 && var4.field00397 != null) {
         if (var4.field00403 && var4.field00401 < 0) {
            this.method04778(
               var1, var2, var3, var4.field00397, field10506, field10551, field10509, field10510, ColorUtils.method04616(var4.field00402, 220), false
            );
         } else if (var4.field00401 >= 0) {
            Vec3 var6 = var4.field00398 != null ? var4.field00398 : var3.subtract(var4.field00397);
            this.method04778(var1, var2, var3, var4.field00397, var6, field10552, field10507, field10508, field10505, true);
         } else {
            Vec3 var5 = var4.field00398 != null ? var4.field00398 : field10506;
            this.method04778(
               var1, var2, var3, var4.field00397, var5, field10553, field10507, field10508, ColorUtils.method04616(var4.field00402, 220), true
            );
         }
      }
   }

   private void method04771(BaritoneVertexConsumerAccess var1, Matrix4f var2, Vec3 var3, ProjectileTrajectoryTracker.Nested6 var4) {
      var var5 = var4.field00393;
      int var6 = var5.size();
      if (var6 >= 2) {
         int var7 = var6 - 1;
         int var8 = Math.max(1, var7 / 64);
         Vec3 var9 = (Vec3)var5.get(0);
         int var10 = 0;

         for (int var11 = var8; var11 <= var7; var11 += var8) {
            Vec3 var12 = (Vec3)var5.get(var11);
            this.method04774(var1, var2, var3, var9, var12, var4.field00402, var10, var7);
            var9 = var12;
            var10 = var11;
         }

         if (var10 != var7) {
            this.method04774(var1, var2, var3, var9, (Vec3)var5.get(var7), var4.field00402, var10, var7);
         }
      }
   }

   @Subscribe
   private void method04772(PostPlayerInputEvent var1) {
      this.field10516 = this.field10517;
      this.field10517 = mc.player != null ? mc.player.getDeltaMovement() : Vec3.ZERO;
      ProjectileTrajectoryTracker.field00265.method00195(this);
   }

   public boolean method04773(String var1) {
      return this.field10512.method04520(var1);
   }

   private void method04774(BaritoneVertexConsumerAccess var1, Matrix4f var2, Vec3 var3, Vec3 var4, Vec3 var5, int var6, int var7, int var8) {
      float var9 = (float)(var5.x - var4.x);
      float var10 = (float)(var5.y - var4.y);
      float var11 = (float)(var5.z - var4.z);
      float var12 = Mth.sqrt(var9 * var9 + var10 * var10 + var11 * var11);
      if (var12 > field10548) {
         var9 /= var12;
         var10 /= var12;
         var11 /= var12;
      } else {
         var9 = 0.0F;
         var10 = 1.0F;
         var11 = 0.0F;
      }

      int var13 = Mth.clamp(60 + var7 * 220 / var8, 0, 255);
      int var14 = ColorUtils.method04616(var6, var13);
      var1.lineVertex(var2, (float)(var4.x - var3.x), (float)(var4.y - var3.y), (float)(var4.z - var3.z), var14, var9, var10, var11, field10549);
      var1.lineVertex(var2, (float)(var5.x - var3.x), (float)(var5.y - var3.y), (float)(var5.z - var3.z), var14, var9, var10, var11, field10550);
   }

   private static float[] method04775(int var0, boolean var1) {
      float[] var2 = new float[var0 + 1];

      for (int var3 = 0; var3 <= var0; var3++) {
         double var4 = field10518 * var3 / var0;
         var2[var3] = (float)(var1 ? Math.sin(var4) : Math.cos(var4));
      }

      return var2;
   }

   @Subscribe
   private void method04776(HudRenderEvent var1) {
      if (this.field10513.method03022() && mc.level != null) {
         var var2 = ProjectileTrajectoryTracker.field00265.method00199();
         if (!var2.isEmpty()) {
            GuiGraphics var3 = var1.method05424();
            FontRenderer.method09475();
            ItemRenderUtils.method08410();
            float var4 = field10537;
            float var5 = field10538;
            float var6 = field10539;

            for (ProjectileTrajectoryTracker.Nested6 var8 : var2) {
               if (var8.method00206() != 0 && !(var8.field00395 <= 0.0)) {
                  Vec3 var9 = var8.field00393.get(var8.method00206() - 1);
                  Vector2f var10 = WorldProjectionUtils.method09455(var1.method05425(), var9.x, var9.y, var9.z);
                  String var11 = GuiHitTestUtils.method05606(var8.field00395, field10540) + " s";
                  float var12 = Fonts.field00109.method09478(var11, field10541, field10542);
                  float var13 = var10.x;
                  float var14 = var10.y;
                  float var15 = var13 - var12 / 2.0F;
                  float var16 = var14 + var4;
                  RoundedRectRenderer.method01272(
                     var3,
                     var15 - var5 / 2.0F - var6 / 2.0F,
                     var16 - var5 / 2.0F,
                     var12 + var5 + var6,
                     field10543 + var5,
                     0.0F,
                     0.0F,
                     ColorUtils.method04597(30, 30, 30, 100)
                  );
                  Fonts.field00109
                     .method09490(var3, var11, var15 + var6 / 2.0F, var16, ColorUtils.method04616(-1, 210), field10544, field10545);
                  if (var8.field00404 != null && !var8.field00404.isEmpty()) {
                     ItemRenderUtils.method08418(var3, var8.field00404, var15 - 1.0F, var16 + field10546, field10547, 1.0F, 1.0F);
                  }
               }
            }

            FontRenderer.method09484();
            ItemRenderUtils.method08420();
         }
      }
   }

   private void method04777(BaritoneVertexConsumerAccess var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      float var10 = var6 - var3;
      float var11 = var7 - var4;
      float var12 = var8 - var5;
      float var13 = Mth.sqrt(var10 * var10 + var11 * var11 + var12 * var12);
      if (var13 > field10559) {
         var10 /= var13;
         var11 /= var13;
         var12 /= var13;
      } else {
         var10 = 0.0F;
         var11 = 1.0F;
         var12 = 0.0F;
      }

      var1.lineVertex(var2, var3, var4, var5, var9, var10, var11, var12, field10560);
      var1.lineVertex(var2, var6, var7, var8, var9, var10, var11, var12, field10561);
   }

   @Override
   public void method00245() {
      super.method00245();
      this.field10515.clear();
      this.field10516 = Vec3.ZERO;
      this.field10517 = Vec3.ZERO;
   }

   private void method04778(
      BaritoneVertexConsumerAccess var1, Matrix4f var2, Vec3 var3, Vec3 var4, Vec3 var5, float var6, float[] var7, float[] var8, int var9, boolean var10
   ) {
      double var17 = var5.lengthSqr();
      double var11;
      double var13;
      double var15;
      if (var17 < field10554) {
         var11 = 0.0;
         var13 = 1.0;
         var15 = 0.0;
      } else {
         double var19 = 1.0 / Math.sqrt(var17);
         var11 = var5.x * var19;
         var13 = var5.y * var19;
         var15 = var5.z * var19;
      }

      double var21;
      double var23;
      double var58;
      if (Math.abs(var13) > field10555) {
         var58 = 1.0;
         var21 = 0.0;
         var23 = 0.0;
      } else {
         var58 = 0.0;
         var21 = 1.0;
         var23 = 0.0;
      }

      double var25 = var13 * var23 - var15 * var21;
      double var27 = var15 * var58 - var11 * var23;
      double var29 = var11 * var21 - var13 * var58;
      double var31 = 1.0 / Math.sqrt(var25 * var25 + var27 * var27 + var29 * var29);
      var25 *= var31;
      var27 *= var31;
      var29 *= var31;
      double var33 = var13 * var29 - var15 * var27;
      double var35 = var15 * var25 - var11 * var29;
      double var37 = var11 * var27 - var13 * var25;
      double var39 = var4.x + var11 * field10556 - var3.x;
      double var41 = var4.y + var13 * field10557 - var3.y;
      double var43 = var4.z + var15 * field10558 - var3.z;
      int var45 = var7.length - 1;
      float var46 = 0.0F;
      float var47 = 0.0F;
      float var48 = 0.0F;

      for (int var49 = 0; var49 <= var45; var49++) {
         double var50 = var7[var49] * var6;
         double var52 = var8[var49] * var6;
         float var54 = (float)(var39 + var25 * var50 + var33 * var52);
         float var55 = (float)(var41 + var27 * var50 + var35 * var52);
         float var56 = (float)(var43 + var29 * var50 + var37 * var52);
         if (var49 > 0) {
            this.method04777(var1, var2, var46, var47, var48, var54, var55, var56, var9);
         }

         var46 = var54;
         var47 = var55;
         var48 = var56;
      }

      if (var10) {
         float var62 = (float)(var25 * var6);
         float var63 = (float)(var27 * var6);
         float var51 = (float)(var29 * var6);
         float var64 = (float)(var33 * var6);
         float var53 = (float)(var35 * var6);
         float var65 = (float)(var37 * var6);
         float var66 = (float)var39;
         float var67 = (float)var41;
         float var57 = (float)var43;
         this.method04777(var1, var2, var66 - var62, var67 - var63, var57 - var51, var66 + var62, var67 + var63, var57 + var51, var9);
         this.method04777(var1, var2, var66 - var64, var67 - var53, var57 - var65, var66 + var64, var67 + var53, var57 + var65, var9);
      }
   }

   public boolean method04779(String var1) {
      return this.field10511.method04520(var1);
   }
}
