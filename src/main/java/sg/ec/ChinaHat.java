// Original binary: sg/ec/Pg0i8FyqjmrwcD1o
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import org.joml.Matrix4f;

// $VF: Compiled from s
public class ChinaHat extends ClientModule {
   private static final float field11109 = 0.06981317F;
   private static final float field11110 = 0;
   private static final float[] field11111 = new float[181];
   private static final float[] field11112 = new float[181];
   private static final float[] field11113 = new float[180];
   private static final float[] field11114 = new float[180];
   private final int[] field11115 = new int[181];
   private final int[] field11116 = new int[181];
   private final float[] field11117 = new float[181];
   private final float[] field11118 = new float[181];
   private long field11119;
   private int field11120;
   private int field11121;
   private float field11122;
   private final ToggleSetting field11123;
   private static final long field11124 = Long.MIN_VALUE;
   private static final String field11125 = "Отображать на друзьях";
   private static final String field11126 = "China Hat";
   private static final String field11127 = "Добавляет китайскую шапку, изменяя внешний вид персонажа";
   private static final float field11128 = 0.42F;
   private static final float field11129 = 0.52F;
   private static final float field11130 = 180.0F;
   private static final float field11131 = 90.0F;
   private static final float field11132 = 0.5F;
   private static final int field11133 = -16777216;
   private static final int field11134 = 1073741824;
   private static final int field11135 = 16777215;
   private static final long field11136 = 3L;
   private static final float field11137 = 0.5F;
   private static final int field11138 = 16777215;
   private static final float field11139 = 0.3F;
   private static final float field11140 = 0.3F;
   private static final float field11141 = 3.5F;
   private static final float field11142 = 3.5F;
   private static final float field11143 = 0.3F;
   private static final float field11144 = 0.06981317F;
   private static final float field11145 = 0.06981317F;
   private static final float field11146 = 1.0E-4F;

   public void method05069(LivingEntityRenderState var1, PoseStack var2, SubmitNodeCollector var3, ModelPart var4) {
      if (((EntityRenderStateAccess)var1).getHexEntity() instanceof Player var6) {
         boolean sx = var6 == mc.player;
         boolean sxx = FriendManager.INSTANCE.method00172(var6);
         if (sx || this.field11123.method05999() && sxx) {
            float sxxx = var6.getBbWidth();
            float sxxxx = var6.getItemBySlot(EquipmentSlot.HEAD).isEmpty() ? field11128 : field11129;
            int sxxxxx = ColorUtils.Nested138.method04636();
            int sxxxxxx = ColorUtils.Nested138.method04637();
            var2.pushPose();
            var4.translateAndRotate(var2);
            var2.translate(0.0F, -sxxxx, 0.0F);
            var2.rotate(Axis.ZN.rotationDegrees(field11130));
            var2.rotate(Axis.YP.rotationDegrees(field11131));
            int sxxxxxxx = ColorUtils.method04599(sxxxxxx, field11132);
            this.method05073(sxxxxx, sxxxxxxx);
            this.method05072(sxxx);
            int[] sxxxxxxxx = this.field11115;
            int[] sxxxxxxxxx = this.field11116;
            float[] sxxxxxxxxxx = this.field11117;
            float[] sxxxxxxxxxxx = this.field11118;
            var3.submitCustomGeometry(var2, EffectRenderPipelines.method05533(), (var4x, var5) -> {
               if (var5 instanceof ExtendedVertexConsumer var6x) {
                  Matrix4f var7x = var4x.pose();

                  for (int var8x = 0; var8x <= 180; var8x++) {
                     var6x.coloredVertex(var7x, sxxxxxxxxxx[var8x], 0.0F, sxxxxxxxxxxx[var8x], sxxxxxxxxx[var8x]);
                     var6x.coloredVertex(var7x, 0.0F, field11143, 0.0F, sxxxxx);
                  }
               }
            });
            var3.submitCustomGeometry(var2, EffectRenderPipelines.method05555(), (var3x, var4x) -> {
               if (var4x instanceof ExtendedVertexConsumer var5) {
                  Matrix4f var6x = var3x.pose();

                  for (int var7x = 0; var7x < 180; var7x++) {
                     float var8x = field11113[var7x];
                     float var9x = field11114[var7x];
                     var5.lineVertex(var6x, sxxxxxxxxxx[var7x], 0.0F, sxxxxxxxxxxx[var7x], sxxxxxxxx[var7x], var8x, 0.0F, var9x, field11141);
                     var5.lineVertex(var6x, sxxxxxxxxxx[var7x + 1], 0.0F, sxxxxxxxxxxx[var7x + 1], sxxxxxxxx[var7x + 1], var8x, 0.0F, var9x, field11142);
                  }
               }
            });
            if (var1.outlineColor != 0) {
               int sxxxxxxxxxxxx = var1.outlineColor;
               int sxxxxxxxxxxxxx = sxxxxxxxxxxxx & field11133;
               boolean sxxxxxxxxxxxxxx = (sxxxxxxxxxxxx & field11134) != 0;
               int sxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxx ? sxxxxx & field11135 | sxxxxxxxxxxxxx : sxxxxxxxxxxxx;
               var3.submitCustomGeometry(var2, EffectRenderPipelines.method05538(), (var7x, var8x) -> {
                  if (var8x instanceof ExtendedVertexConsumer var9x) {
                     Matrix4f var10x = var7x.pose();
                     if (sxxxxxxxxxxxxxx) {
                        for (int var11x = 0; var11x <= 180; var11x++) {
                           int var12x = sxxxxxxxx[var11x] & field11138 | sxxxxxxxxxxxxx;
                           var9x.coloredVertex(var10x, sxxxxxxxxxx[var11x], 0.0F, sxxxxxxxxxxx[var11x], var12x);
                           var9x.coloredVertex(var10x, 0.0F, field11139, 0.0F, sxxxxxxxxxxxxxxx);
                        }
                     } else {
                        for (int var13x = 0; var13x <= 180; var13x++) {
                           var9x.coloredVertex(var10x, sxxxxxxxxxx[var13x], 0.0F, sxxxxxxxxxxx[var13x], sxxxxxxxxxxxx);
                           var9x.coloredVertex(var10x, 0.0F, field11140, 0.0F, sxxxxxxxxxxxx);
                        }
                     }
                  }
               });
            }

            var2.popPose();
         }
      }
   }

   private void method05072(float var1) {
      if (var1 != this.field11122) {
         this.field11122 = var1;
         float[] var2 = this.field11117;
         float[] var3 = this.field11118;

         for (int var4 = 0; var4 <= 180; var4++) {
            var2[var4] = field11111[var4] * var1;
            var3[var4] = field11112[var4] * var1;
         }
      }
   }

   private void method05073(int var1, int var2) {
      long var3 = System.currentTimeMillis() / field11136;
      if (var3 != this.field11119 || var1 != this.field11120 || var2 != this.field11121) {
         this.field11119 = var3;
         this.field11120 = var1;
         this.field11121 = var2;
         int[] var5 = this.field11115;
         int[] var6 = this.field11116;

         for (int var7 = 0; var7 <= 180; var7++) {
            int var8 = ColorUtils.method04608(3, var7 * 16, var1, var2);
            var5[var7] = var8;
            var6[var7] = ColorUtils.method04611(var8, field11137);
         }
      }
   }

   static {
      for (int var0 = 0; var0 <= 180; var0++) {
         field11111[var0] = Mth.sin(var0 * field11144);
         field11112[var0] = Mth.cos(var0 * field11145);
      }

      for (int var4 = 0; var4 < 180; var4++) {
         float var1 = field11111[var4 + 1] - field11111[var4];
         float var2 = field11112[var4 + 1] - field11112[var4];
         float var3 = Mth.sqrt(var1 * var1 + var2 * var2);
         if (var3 > field11146) {
            field11113[var4] = var1 / var3;
            field11114[var4] = var2 / var3;
         } else {
            field11113[var4] = 0.0F;
            field11114[var4] = 0.0F;
         }
      }
   }

   public ChinaHat() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field11119 = field11124;
      this.field11122 = Float.NaN;
      this.field11123 = new ToggleSetting(field11125).method03017(true).method03023(this);
      this.method03935(field11126);
      this.method03931(field11127);
   }
}
