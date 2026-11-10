// Original binary: sg/ec/kuMbuMCo2tKmmrpf
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

// $VF: Compiled from s
public class TargetESP extends ClientModule {
   private static final String field20925 = "Призраки 1";
   private static final String field20926 = "field20926";
   private static final String field20927 = "field20927";
   private static final String field20928 = "field20928";
   private static final String field20929 = "field20929";
   private static final String field20930 = "field20930";
   private static final float field20931 = 0;
   private static final double field20932 = 0;
   private static final long field20933 = System.nanoTime();
   private static final double field20934 = 0;
   private static final float field20935 = 0;
   private static final float field20936 = 0;
   private static final double field20937 = 0;
   private static final float field20938 = 0;
   private static final float field20939 = 0;
   private final ModeSetting field20940;
   private final ToggleSetting field20941;
   private final ToggleSetting field20942;
   private final ToggleSetting field20943;
   private final ToggleSetting field20944;
   private final NumberSetting<Integer> field20945;
   private LivingEntity field20946;
   private boolean field20947;
   private LivingEntity field20948;
   private float field20949;
   private double field20950;
   private final AnimationUtils field20951;
   private long field20952;
   private final long field20953;
   private static final float field20954 = 0;
   private static final int field20955 = 0;
   private static final int field20956 = 0;
   private static final double field20957 = 0;
   private static final double field20958 = 0;
   private static final double field20959 = 0;
   private static final float field20960 = 0;
   private static final float field20961 = 0;
   private static final int field20962 = 0;
   private static final int field20963 = ColorUtils.method04630(205, 50, 50);
   private static final int field20964 = ColorUtils.method04630(255, 140, 140);
   private static final double[] field20965 = new double[73];
   private static final double[] field20966 = new double[73];
   private static final double[] field20967 = new double[46];
   private static final double[] field20968 = new double[46];
   private final List<TargetESP.Nested255> field20969;
   private double field20970;
   private float field20971;
   AnimationUtils field20972;
   private static final short field20973 = 0;
   private static final short field20974 = 0;
   private static final String field20975 = "Тип";
   private static final String field20976 = "Призраки 1";
   private static final String field20977 = "Призраки 2";
   private static final String field20978 = "Призраки 3";
   private static final String field20979 = "Квадрат";
   private static final String field20980 = "Круг";
   private static final String field20981 = "Сканирование";
   private static final String field20982 = "Призраки 1";
   private static final String field20983 = "Свечение";
   private static final String field20984 = "Просвечивать";
   private static final String field20985 = "Старый";
   private static final String field20986 = "Сетка";
   private static final String field20987 = "Охват сетки";
   private static final long field20988 = 300L;
   private static final long field20989 = 1500L;
   private static final String field20990 = "Target ESP";
   private static final String field20991 = "Призраки 3";
   private static final String field20992 = "Призраки 1";
   private static final String field20993 = "Призраки 2";
   private static final String field20994 = "Квадрат";
   private static final String field20995 = "Сканирование";
   private static final String field20996 = "Круг";
   private static final float field20997 = 0.01F;
   private static final String field20998 = "Призраки 3";
   private static final double field20999 = 4.0;
   private static final double field21000 = 360.0;
   private static final float field21001 = 0.6F;
   private static final float field21002 = 0.5F;
   private static final float field21003 = 0.4F;
   private static final double field21004 = 360.0;
   private static final double field21005 = 2.0;
   private static final float field21006 = 0.4F;
   private static final float field21007 = 400.0F;
   private static final float field21008 = 400.0F;
   private static final float field21009 = 800.0F;
   private static final float field21010 = 400.0F;
   private static final long field21011 = -200L;
   private static final double field21012 = 0.05F;
   private static final float field21013 = 0.2F;
   private static final float field21014 = 15.0F;
   private static final float field21015 = 0.55F;
   private static final float field21016 = 0.2F;
   private static final float field21017 = 10.0F;
   private static final float field21018 = 0.45F;
   private static final double field21019 = 4.0;
   private static final float field21020 = 1.5F;
   private static final float field21021 = 1.5F;
   private static final float field21022 = 1.5F;
   private static final float field21023 = 8.0F;
   private static final float field21024 = 0.55F;
   private static final float field21025 = 0.2F;
   private static final double field21026 = 125.0;
   private static final float field21027 = 10.0F;
   private static final double field21028 = 15.0;
   private static final float field21029 = 0.045F;
   private static final double field21030 = 0.35F;
   private static final float field21031 = 0.045F;
   private static final double field21032 = 0.35F;
   private static final float field21033 = 0.045F;
   private static final float field21034 = 0.5F;
   private static final float field21035 = 0.85F;
   private static final float field21036 = 0.25F;
   private static final float field21037 = 0.125F;
   private static final float field21038 = 4.0F;
   private static final float field21039 = 550.0F;
   private static final float field21040 = 10.0F;
   private static final float field21041 = 0.25F;
   private static final float field21042 = 0.125F;
   private static final float field21043 = 0.8F;
   private static final float field21044 = 0.0875F;
   private static final float field21045 = 0.0125F;
   private static final float field21046 = 0.1F;
   private static final float field21047 = 0.8F;
   private static final double field21048 = 0.5;
   private static final float field21049 = 0.3F;
   private static final float field21050 = 0.2F;
   private static final float field21051 = 0.2F;
   private static final float field21052 = 0.8F;
   private static final float field21053 = 1.5F;
   private static final float field21054 = 1.5F;
   private static final long field21055 = 5500L;
   private static final float field21056 = 5500.0F;
   private static final float field21057 = 2750.0F;
   private static final float field21058 = 1500.0F;
   private static final float field21059 = -1500.0F;
   private static final float field21060 = -1500.0F;
   private static final float field21061 = 1500.0F;
   private static final float field21062 = 3000.0F;
   private static final float field21063 = 1500.0F;
   private static final double field21064 = 3.5;
   private static final double field21065 = 7.0;
   private static final float field21066 = -0.175F;
   private static final float field21067 = -0.175F;
   private static final float field21068 = -0.175F;
   private static final double field21069 = 1.0E9;
   private static final double field21070 = 4.0;
   private static final double field21071 = 4.0;
   private static final double field21072 = Math.PI * 2;
   private static final double field21073 = 0.5;
   private static final float field21074 = 0.5F;
   private static final float field21075 = 0.1F;
   private static final float field21076 = 2.4F;
   private static final float field21077 = 0.1F;
   private static final float field21078 = 0.011111111F;
   private static final float field21079 = 0.5F;
   private static final float field21080 = 1.2F;
   private static final float field21081 = -1.0F;
   private static final double field21082 = Math.PI * 10;
   private static final double field21083 = 0.12;
   private static final String field21084 = "Сканирование";
   private static final float field21085 = 0.65F;
   private static final double field21086 = 1550.0;
   private static final double field21087 = 1550.0;
   private static final double field21088 = 1550.0;
   private static final double field21089 = Math.PI;
   private static final double field21090 = 2.0;
   private static final float field21091 = 10.0F;
   private static final double field21092 = 0.5;
   private static final double field21093 = 0.5;
   private static final double field21094 = 1.15;
   private static final double field21095 = 0.5;
   private static final double field21096 = 1.15;
   private static final double field21097 = 0.5;
   private static final float field21098 = 0.25F;
   private static final float field21099 = 0.005F;
   private static final float field21100 = 0.3F;
   private static final float field21101 = 0.75F;
   private static final float field21102 = 0.65F;
   private static final float field21103 = 0.7058824F;
   private static final float field21104 = 1.5F;
   private static final double field21105 = 200.0;
   private static final double field21106 = 2.0;
   private static final double field21107 = 200.0;
   private static final double field21108 = 2.0;
   private static final long field21109 = -100L;
   private static final float field21110 = 0.01F;
   private static final String field21111 = "Сканирование";
   private static final String field21112 = "Сканирование";
   private static final String field21113 = "Круг";
   private static final String field21114 = "Призраки 1";
   private static final String field21115 = "Призраки 2";
   private static final String field21116 = "Призраки 3";
   private static final String field21117 = "Квадрат";
   private static final String field21118 = "Призраки 1";
   private static final String field21119 = "Призраки 2";

   private void method09258(Render3DEvent var1) {
      PoseStack var2 = var1.method00996();
      if (var1.method00985().method07407(EffectRenderPipelines.method05553(this.field20942.method05999())) instanceof BaritoneVertexConsumerAccess sx) {
         Camera sxx = mc.gameRenderer.mainCamera();
         Vec3 var6 = sxx.position();
         float var7 = field21006;
         var2.pushPose();
         long var8 = System.currentTimeMillis();

         for (TargetESP.Nested255 sxxx : this.field20969) {
            SmoothAnimation sxxxx = sxxx.method09288();
            sxxxx.method06162();
            long sxxxxx = sxxx.method09285();
            float sxxxxxx = (float)(var8 - sxxxxx);
            float sxxxxxxx;
            if (sxxxxxx < field21007) {
               sxxxxxxx = 1.0F - sxxxxxx / field21008;
            } else if (sxxxxxx < field21009) {
               sxxxxxxx = sxxxxxx / field21010 - 1.0F;
            } else {
               sxxxxxxx = 1.0F;
            }

            sxxxxxxx = Math.max(0.0F, Math.min(1.0F, sxxxxxxx));
            sxxxx.method06166(sxxxxx - var8 > field21011 ? 1.0 : 0.0, field21012);
            int sxxxxxxxx = ClientParticleRenderer.method10534(
               ColorUtils.method04616(sxxx.method09286(), Math.round(ColorUtils.method04625(sxxx.method09286()) * sxxxx.method06173()))
            );
            var2.pushPose();
            var2.translate(sxxx.method09287() - var6.x(), sxxx.method09283() - var6.y(), sxxx.method09284() - var6.z());
            var2.rotate(sxx.rotation());
            Matrix4f sxxxxxxxxx = var2.last().pose();
            float sxxxxxxxxxx = var7 * sxxxxxxx;
            this.method09265(sx, sxxxxxxxxx, sxxxxxxxxxx, sxxxxxxxx);
            var2.popPose();
         }

         var2.popPose();
      }
   }

   public void method09259(Render3DEvent var1) {
      boolean var2 = this.field20941.method05999();
      if (var1.method00985().method07407(EffectRenderPipelines.method05553(this.field20942.method05999())) instanceof BaritoneVertexConsumerAccess var4) {
         PoseStack var5 = var1.method00996();
         float var6 = var1.method00984().getGameTimeDeltaPartialTick(true);
         Vec3 var7 = var1.method00994().position();
         Vec3 var8 = this.field20946.getPosition(var6).subtract(var7);
         Quaternionf var9 = var1.method00994().rotation();
         long var10 = System.currentTimeMillis();
         this.field20971 = this.field20971 + field21038 * (float)(var10 - this.field20952) / field21039;
         this.field20952 = var10;
         float var12 = GuiHitTestUtils.method05621((this.field20946.hurtTime - (this.field20946.hurtTime != 0 ? var6 : 0.0F)) / field21040);
         float var13 = this.field20951.method03377();
         int var14 = ColorUtils.method04627(ColorUtils.method04630(200, 100, 100), ColorUtils.Nested138.method04634(0), var12);
         var14 = ColorUtils.method04611(var14, var13);
         int var15 = ClientParticleRenderer.method10534(var14);
         int var16 = ColorUtils.method04616(var14, Math.round(ColorUtils.method04625(var14) * field21041));
         int var17 = ClientParticleRenderer.method10534(var16);
         int var18 = ClientParticleRenderer.method10534(ColorUtils.method04616(var16, Math.round(ColorUtils.method04625(var16) * field21042)));
         float var19 = field21043;

         for (byte var20 = 0; var20 < 9; var20 = (byte)(var20 + 3)) {
            float var21 = var20 * var20;

            for (byte var22 = 0; var22 < 12; var22++) {
               float var23 = (field21044 + field21045 * var22) * var13;
               float var24 = this.field20971 + var22 * field21046;
               var5.pushPose();
               var5.translate(
                  var8.x + field21047 * Mth.sin(var24 + var21),
                  var8.y + field21048 + field21049 * Mth.sin(this.field20971 + var22 * field21050) + field21051 * var20,
                  var8.z + field21052 * Mth.cos(var24 - var21)
               );
               var5.rotate(var9);
               Matrix4f var25 = var5.last().pose();
               this.method09273(var4, var25, var23, var15, var17, var18, var2);
               var5.popPose();
            }
         }
      }
   }

   public TargetESP() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field20940 = new ModeSetting(field20975)
         .method05597(field20976, field20977, field20978, field20979, field20980, field20981)
         .method03017(field20982)
         .method03023(this);
      this.field20941 = new ToggleSetting(field20983)
         .method03017(false)
         .method03025(() -> this.field20940.method05600(field21117) || this.field20940.method05600(field21118) || this.field20940.method05600(field21119))
         .method03023(this);
      this.field20942 = new ToggleSetting(field20984)
         .method03017(true)
         .method03025(() -> this.field20940.method05600(field21114) || this.field20940.method05600(field21115) || this.field20940.method05600(field21116))
         .method03023(this);
      this.field20943 = new ToggleSetting(field20985).method03017(false).method03025(() -> this.field20940.method05600(field21113)).method03023(this);
      this.field20944 = new ToggleSetting(field20986).method03017(false).method03025(() -> this.field20940.method05600(field21112)).method03023(this);
      this.field20945 = new NumberSetting<Integer>(field20987)
         .method10835(1)
         .method10838(10)
         .method10834(1)
         .method03017(5)
         .method03025(() -> this.field20940.method05600(field21111) && this.field20944.method05999())
         .method03023(this);
      this.field20951 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field20988);
      this.field20952 = System.currentTimeMillis();
      this.field20953 = System.currentTimeMillis();
      this.field20969 = new ArrayList<>();
      this.field20970 = 0.0;
      this.field20972 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field20989);
      this.method03935(field20990);
   }

   @Subscribe(4)
   private void method09260(EntityOutlineColorEvent var1) {
      if (this.field20940.method05600(field21084) && this.field20946 != null && var1.method00863() == this.field20946 && this.method09276()) {
         var1.method00862(EspColorUtils.method09875(var1.method00859()));
         this.field20947 = true;
      }
   }

   private static double method09261() {
      return Math.cos(System.currentTimeMillis() / field21107) / field21108;
   }

   private void method09262(Render3DEvent var1) {
      PoseStack var2 = var1.method00996();
      float var3 = var1.method00984().getGameTimeDeltaPartialTick(true);
      if (var1.method00985().method07407(EffectRenderPipelines.method05553(this.field20942.method05999())) instanceof BaritoneVertexConsumerAccess var5) {
         var2.pushPose();
         float var6 = field21013;
         float var7 = field21014;
         float var8 = field21015;
         float var9 = field21016;
         byte var10 = 9;
         float var11 = field21017;
         float var12 = field21018;
         Camera var13 = mc.gameRenderer.mainCamera();
         Vec3 var14 = var13.position();
         Vec3 var15 = this.field20946.getPosition(var3).add(0.0, this.field20946.getBbHeight() / 2.0F, 0.0).subtract(var14);
         var2.translate(var15.x, var15.y, var15.z);
         Quaternionf var16 = var13.rotation();
         long var17 = System.currentTimeMillis();
         double var19 = (var17 - this.field20953) / field21019;
         var2.scale(field21020, field21021, field21022);

         for (byte var21 = 0; var21 < 4; var21++) {
            for (byte var22 = 0; var22 < 9; var22++) {
               var2.pushPose();
               float var23 = var22 / field21023;
               float var24 = field21024 * (1.0F - var23) + field21025 * var23;
               double var25 = var19 - var21 * field21026;
               double var27 = var6 * (var25 - var22 * field21027) / field21028;
               double var29 = 0.0;
               double var31 = -Math.sin(var27) * var12;
               double var33 = -Math.cos(var27) * var12;
               switch (var21) {
                  case 0:
                     var29 += var22 * field21029;
                     var2.translate(var33, var29 + field21030, -var31);
                     break;
                  case 1:
                  case 3:
                     var29 -= var22 * field21031;
                     var2.translate(var33, var29 - field21032, -var31);
                     break;
                  case 2:
                     var29 += var22 * field21033;
                     var2.translate(var33, var29, -var31);
               }

               float var35 = var24 * field21034;
               int var36 = ColorUtils.method04627(ColorUtils.Nested138.method04634(var22 * 25), -1, field21035);
               var36 = ColorUtils.method04616(var36, Math.round(ColorUtils.method04625(var36) * this.field20951.method03377()));
               var2.rotate(var16);
               Matrix4f var37 = var2.last().pose();
               int var38 = ClientParticleRenderer.method10534(var36);
               int var39 = 0;
               int var40 = 0;
               boolean var41 = this.field20941.method05999();
               if (var41) {
                  int var42 = ColorUtils.method04616(var36, Math.round(ColorUtils.method04625(var36) * field21036));
                  var39 = ClientParticleRenderer.method10534(var42);
                  var40 = ClientParticleRenderer.method10534(ColorUtils.method04616(var42, Math.round(ColorUtils.method04625(var42) * field21037)));
               }

               this.method09273(var5, var37, var35, var38, var39, var40, var41);
               var2.popPose();
            }
         }

         var2.popPose();
      }
   }

   private float method09264(float var1, double var2) {
      if (this.field20948 != this.field20946) {
         this.field20948 = this.field20946;
         this.field20949 = var1;
         this.field20950 = var2;
         return var1;
      }

      double var4 = var2 - this.field20950;
      this.field20950 = var2;
      if (var4 > 0.0) {
         this.field20949 = this.field20949 + (var1 - this.field20949) * (float)(-Math.expm1(-var4 / field21083));
      }

      return this.field20949;
   }

   private void method09265(BaritoneVertexConsumerAccess var1, Matrix4f var2, float var3, int var4) {
      var1.texturedVertex(var2, -var3, -var3, 0.0F, 1.0F, 1.0F, var4);
      var1.texturedVertex(var2, var3, -var3, 0.0F, 0.0F, 1.0F, var4);
      var1.texturedVertex(var2, var3, var3, 0.0F, 0.0F, 0.0F, var4);
      var1.texturedVertex(var2, -var3, var3, 0.0F, 1.0F, 0.0F, var4);
   }

   private static double method09266(float var0) {
      double var1 = Math.sin(System.currentTimeMillis() / field21105);
      return (var1 + 1.0) / field21106 * var0;
   }

   private void method09267(Render3DEvent var1) {
      PoseStack var2 = var1.method00996();
      Camera var3 = var1.method00994();
      float var4 = var1.method00984().getGameTimeDeltaPartialTick(true);
      Vec3 var5 = var3.position();
      Vec3 var6 = this.field20946.getPosition(var4);
      double var7 = var6.x - var5.x();
      double var9 = var6.z - var5.z();
      double var11 = var6.y - var5.y();
      float var13 = this.field20946.getBbWidth();
      float var14 = (float)(var11 + method09266(this.field20946.getBbHeight()));
      float var15 = (float)(var14 - method09261());
      float var16 = this.field20951.method03377();
      Matrix4f var17 = var2.last().pose();
      if (var1.method00985().method07407(EffectRenderPipelines.method05542()) instanceof BaritoneVertexConsumerAccess var19) {
         for (int var20 = 0; var20 <= 45; var20++) {
            int var21 = ColorUtils.Nested138.method04634(var20 * 24);
            float var22 = ColorUtils.method04615(var21);
            float var23 = ColorUtils.method04629(var21);
            float var24 = ColorUtils.method04612(var21);
            float var25 = (float)(var7 + var13 * field20967[var20]);
            float var26 = (float)(var9 + var13 * field20968[var20]);
            var19.coloredVertexF(var17, var25, var15, var26, var22, var23, var24, 0.0F);
            var19.coloredVertexF(var17, var25, var14, var26, var22, var23, var24, var16 * field21103);
         }

         if (var1.method00985().method07407(EffectRenderPipelines.method05531()) instanceof BaritoneVertexConsumerAccess var32) {
            for (int var33 = 0; var33 < 45; var33++) {
               int var34 = ColorUtils.Nested138.method04634(var33 * 24);
               float var35 = ColorUtils.method04615(var34);
               float var36 = ColorUtils.method04629(var34);
               float var37 = ColorUtils.method04612(var34);
               float var27 = (float)(var7 + var13 * field20967[var33]);
               float var28 = (float)(var9 + var13 * field20968[var33]);
               float var29 = (float)(var7 + var13 * field20967[var33 + 1]);
               float var30 = (float)(var9 + var13 * field20968[var33 + 1]);
               method09279(var32, var17, var27, var28, var29, var30, var14, var35, var36, var37, var16, field21104);
            }
         }
      }
   }

   @Subscribe
   private void method09268(TickEvent var1) {
      long var2 = System.currentTimeMillis();
      this.field20969.removeIf(var2x -> var2x.method09285() - var2 < field21109 && var2x.method09288().method06173() < field21110);
   }

   @Subscribe
   private void method09270(Render3DEvent var1) {
      TargetScanRenderer.method05983();
      if (AttackAura.field00785 != null) {
         this.field20946 = AttackAura.field00785;
      }

      if (this.field20946 != null) {
         boolean var2 = ModuleManager.INSTANCE.method08219().method03937() && AttackAura.field00785 != null;
         this.field20951.method03375(var2 ? 1.0 : 0.0);
         if (this.field20940.method05600(field20991)) {
            this.method09258(var1);
         } else if (!this.method09276()) {
            this.field20971 = 0.0F;
         } else if (!(this.field20946 instanceof LocalPlayer)) {
            switch ((String)this.field20940.method03022()) {
               case field20992:
                  this.method09262(var1);
                  break;
               case field20993:
                  this.method09259(var1);
                  break;
               case field20994:
                  this.method09274(var1);
                  break;
               case field20995:
                  this.method09278(var1);
                  break;
               case field20996:
                  if (this.field20943.method05999()) {
                     this.method09267(var1);
                  } else {
                     this.method09280(var1);
                  }
            }
         }
      }
   }

   private void method09273(BaritoneVertexConsumerAccess var1, Matrix4f var2, float var3, int var4, int var5, int var6, boolean var7) {
      this.method09265(var1, var2, var3, var4);
      if (var7) {
         float var8 = var3 * field21053;
         this.method09265(var1, var2, var8, var5);
         this.method09265(var1, var2, var8 * field21054, var6);
      }
   }

   public void method09274(Render3DEvent var1) {
      if (var1.method00985().method07407(EffectRenderPipelines.method05532(ClientTextures.INSTANCE.method04570())) instanceof BaritoneVertexConsumerAccess var3) {
         PoseStack var4 = var1.method00996();
         if (var1.method00986().isVisible(this.field20946.getBoundingBox())) {
            float var5 = var1.method00984().getGameTimeDeltaPartialTick(true);
            float var6 = (float)(System.currentTimeMillis() % field21055);
            float var7 = var6 / field21056 * 2.0F - 1.0F;
            float var9 = field21057;
            float var10 = Math.abs((var6 - var9) / var9);
            float var8 = field21058 * var7 + field21059 * var7 * var10;
            var8 = Math.max(field21060, Math.min(field21061, var8));
            this.field20972.method03375(var6 % field21062 > field21063 ? 1.0 : 0.0);
            float var11 = (float)(field21064 * this.field20951.method03384() - field21065);
            var4.pushPose();
            Camera var12 = mc.gameRenderer.mainCamera();
            Vec3 var13 = var12.position();
            Vec3 var14 = this.field20946.getPosition(var5);
            float var15 = (float)(var14.x - var13.x());
            float var16 = (float)(var14.y - var13.y() + this.field20946.getBbHeight() / 2.0F);
            float var17 = (float)(var14.z - var13.z());
            var4.translate(var15, var16, var17);
            var4.rotate(var12.rotation());
            var4.scale(field21066, field21067, field21068);
            var4.rotate(Axis.ZP.rotationDegrees(var8));
            float var18 = this.field20951.method03377();
            int var19 = ColorUtils.Nested138.method04636();
            int var20 = ColorUtils.Nested138.method04637();
            int var21 = ColorUtils.Nested138.method04637();
            int var22 = ColorUtils.Nested138.method04636();
            var19 = ColorUtils.method04611(var19, var18);
            var20 = ColorUtils.method04611(var20, var18);
            var21 = ColorUtils.method04611(var21, var18);
            var22 = ColorUtils.method04611(var22, var18);
            Matrix4f var23 = var4.last().pose();
            var3.texturedVertex(var23, -var11, -var11, 0.0F, 0.0F, 0.0F, var19);
            var3.texturedVertex(var23, -var11, var11, 0.0F, 0.0F, 1.0F, var20);
            var3.texturedVertex(var23, var11, var11, 0.0F, 1.0F, 1.0F, var21);
            var3.texturedVertex(var23, var11, -var11, 0.0F, 1.0F, 0.0F, var22);
            var4.popPose();
         }
      }
   }

   @Subscribe
   private void method09275(RenderTargetEvent var1) {
      if (this.field20947) {
         this.field20947 = false;
         var1.method05695(true);
      }
   }

   private boolean method09276() {
      return this.field20951.method03377() > field20997;
   }

   static {
      for (int var0 = 0; var0 <= 72; var0++) {
         double var1 = Math.toRadians(var0 * 5);
         field20965[var0] = Math.cos(var1);
         field20966[var0] = Math.sin(var1);
      }

      for (int var3 = 0; var3 <= 45; var3++) {
         double var4 = Math.toRadians(var3 * 8);
         field20967[var3] = Math.cos(var4);
         field20968[var3] = Math.sin(var4);
      }
   }

   private void method09278(Render3DEvent var1) {
      float var2 = var1.method00984().getGameTimeDeltaPartialTick(true);
      Vec3 var3 = var1.method00994().position();
      Vec3 var4 = this.field20946.getPosition(var2);
      double var5 = (System.nanoTime() - field20933) / field21069;
      float var7 = this.method09264(this.field20946.getBbHeight(), var5);
      double var8 = var5 % field21070 / field21071 * field21072;
      float var10 = (float)Math.cos(var8);
      float var11 = (float)(var4.y - var3.y());
      float var12 = (float)(var11 + var7 * field21073 + Math.sin(var8) * (var7 * field21074 + field21075));
      float var13 = this.field20944.method05999() ? (var7 + field21076) * (field21077 + (this.field20945.method03022() - 1) * field21078) : 0.0F;
      TargetScanRenderer.method05985(
         var1.method00992(),
         (float)(var4.x - var3.x()),
         var11,
         (float)(var4.z - var3.z()),
         this.field20946.getBbWidth() * field21079,
         var7,
         field21080,
         var12,
         var10 > 0.0F ? 1.0F : field21081,
         Math.abs(var10),
         (float)(var5 % field21082),
         ColorUtils.Nested138.method04636(),
         ColorUtils.Nested138.method04637(),
         this.field20951.method03377(),
         var13
      );
   }

   private static void method09279(
      BaritoneVertexConsumerAccess var0,
      Matrix4f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11
   ) {
      float var12 = var4 - var2;
      float var13 = var5 - var3;
      float var14 = EntityESP.method09231(var12, var13);
      float var15 = var14 != 0.0F ? var12 / var14 : 0.0F;
      float var16 = var14 != 0.0F ? var13 / var14 : 1.0F;
      var0.lineVertexF(var1, var2, var6, var3, var7, var8, var9, var10, var15, 0.0F, var16, var11);
      var0.lineVertexF(var1, var4, var6, var5, var7, var8, var9, var10, var15, 0.0F, var16, var11);
   }

   private void method09280(Render3DEvent var1) {
      PoseStack var2 = var1.method00996();
      Camera var3 = var1.method00994();
      float var4 = var1.method00984().getGameTimeDeltaPartialTick(true);
      Vec3 var5 = var3.position();
      Vec3 var6 = this.field20946.getPosition(var4);
      double var7 = var6.x - var5.x();
      double var9 = var6.y - var5.y();
      double var11 = var6.z - var5.z();
      float var13 = this.field20951.method03377() * field21085;
      float var14 = this.field20946.getBbHeight();
      double var15 = field21086;
      double var17 = System.currentTimeMillis() % field21087 / field21088;
      double var19 = var17 * field21089 * field21090;
      float var21 = GuiHitTestUtils.method05621((this.field20946.hurtTime - (this.field20946.hurtTime != 0 ? var4 : 0.0F)) / field21091);
      boolean var22 = var21 > 0.0F;
      double var23 = field21092 + field21093 * Math.cos(var19);
      double var25 = field21094;
      double var27 = var14 * field21095 * field21096 * field21097;
      double var29 = Math.sin(var19) * var27;
      float var31 = this.field20946.getBbWidth() * field21098;
      float var32 = this.field20946.getBbWidth() + var31 - var31 * var13;
      Matrix4f var33 = var2.last().pose();
      float var34 = (float)(var9 + var14 * var23);
      float var35 = field21099;
      byte var36 = 2;
      if (var1.method00985().method07407(EffectRenderPipelines.method05528()) instanceof BaritoneVertexConsumerAccess var38) {
         for (int var39 = 0; var39 < var36; var39++) {
            float var40 = var34 + var35 / var36 * var39;
            float var41 = 1.0F - (float)var39 / var36 * field21100;
            float var42 = var13 * var41;
            int var43 = var39 * 10;

            for (byte var44 = 0; var44 < 360; var44 += 5) {
               int var45 = var44 / 5;
               int var46 = ColorUtils.method04627(ColorUtils.Nested138.method04634(var44 * 5 + var43), -1, field21101);
               if (var22) {
                  var46 = ColorUtils.method04627(ColorUtils.method04613(4, var44 * 5 + var43, field20963, field20964), var46, var21);
               }

               float var47 = ColorUtils.method04615(var46);
               float var48 = ColorUtils.method04629(var46);
               float var49 = ColorUtils.method04612(var46);
               float var50 = (float)(var7 + field20965[var45] * var32);
               float var51 = (float)(var11 + field20966[var45] * var32);
               float var52 = (float)(var7 + field20965[var45 + 1] * var32);
               float var53 = (float)(var11 + field20966[var45 + 1] * var32);
               method09279(var38, var33, var50, var51, var52, var53, var40, var47, var48, var49, var42, 2.0F);
            }
         }

         if (var1.method00985().method07407(EffectRenderPipelines.method05527()) instanceof BaritoneVertexConsumerAccess var55) {
            for (byte var56 = 0; var56 <= 360; var56 += 5) {
               int var57 = var56 / 5;
               int var58 = ColorUtils.method04627(ColorUtils.Nested138.method04634(var56 * 20), -1, field21102);
               if (var22) {
                  var58 = ColorUtils.method04627(ColorUtils.method04613(4, var56 * 20, field20963, field20964), var58, var21);
               }

               float var59 = ColorUtils.method04615(var58);
               float var60 = ColorUtils.method04629(var58);
               float var61 = ColorUtils.method04612(var58);
               float var62 = (float)(var7 + field20965[var57] * var32);
               float var63 = (float)(var11 + field20966[var57] * var32);
               var55.coloredVertexF(var33, var62, var34, var63, var59, var60, var61, var13);
               var55.coloredVertexF(var33, var62, (float)(var34 + var29), var63, var59, var60, var61, 0.0F);
            }
         }
      }
   }

   @Subscribe
   private void method09282(FrameDeltaEvent var1) {
      if (this.field20946 != null) {
         if (this.field20940.method05600(field20998)) {
            this.field20970 = this.field20970 + field20999;
            double var2 = this.field20970 % field21000;
            float var4 = field21001 + this.field20946.getBbWidth() * field21002;
            float var5 = this.field20946.getBbHeight() / 2.0F;
            long var6 = System.currentTimeMillis();
            float var8 = mc.getDeltaTracker().getGameTimeDeltaPartialTick(true);
            Vec3 var9 = this.field20946.getPosition(var8);
            if (AttackAura.field00785 != null) {
               for (int var10 = 0; var10 < 4; var10++) {
                  float var11 = (var10 - 1) * field21003;
                  double var12 = var2 + var11 * field21004;
                  double var14 = Math.toRadians(-var12);
                  double var16 = Math.sin(var14 + field21005) * var11;
                  double var18 = Math.cos(var14) * var4;
                  double var20 = Math.sin(var14) * var4;
                  double var22 = var5 + var16;
                  int var24 = ColorUtils.Nested138.method04634((int)var2 + 90 * var10);
                  this.field20969.add(new TargetESP.Nested255(var9.x() + var18, var9.y() + var22, var9.z() + var20, var6, var24));
               }
            }
         }
      }
   }

   // $VF: Compiled from s
   private static class Nested255 {
      private final double field21120;
      private final double field21121;
      private final double field21122;
      private final long field21123;
      private final SmoothAnimation field21124;
      private final int field21125;
      private static final double field21126 = 0.1F;

      public double method09283() {
         return this.field21121;
      }

      public double method09284() {
         return this.field21122;
      }

      public long method09285() {
         return this.field21123;
      }

      public int method09286() {
         return this.field21125;
      }

      public double method09287() {
         return this.field21120;
      }

      public SmoothAnimation method09288() {
         return this.field21124;
      }

      public Nested255(double var1, double var3, double var5, long var7, int var9) {
         this.field21120 = var1;
         this.field21121 = var3;
         this.field21122 = var5;
         this.field21123 = var7;
         this.field21125 = var9;
         this.field21124 = new SmoothAnimation();
         this.field21124.method06166(1.0, field21126);
      }
   }
}
