// Original binary: sg/ec/13q17R11Eda6GXKo
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

// $VF: Compiled from s
public class WindStreaks extends ClientModule {
   private static final float field00465 = 10.0F;
   private static final float field00466 = 0;
   private static final int field00467 = 0;
   private static final float field00468 = 0;
   private static final float field00469 = 0;
   private static final float field00470 = 0;
   private static final float field00471 = 0;
   private static final float field00472 = 0;
   private final NumberSetting<Float> field00473;
   private final NumberSetting<Float> field00474;
   private final ModeSetting field00475;
   private final ToggleSetting field00476;
   private final List<WindStreaks.Nested7> field00477;
   private final Random field00478;
   private static final String field00479 = "Плотность";
   private static final float field00480 = 0.5F;
   private static final float field00481 = 0.1F;
   private static final String field00482 = "Длина";
   private static final float field00483 = 6.0F;
   private static final float field00484 = 0.5F;
   private static final float field00485 = 3.0F;
   private static final String field00486 = "Цвет";
   private static final String field00487 = "От темы";
   private static final String field00488 = "Белый";
   private static final String field00489 = "От темы";
   private static final String field00490 = "Только на элитре";
   private static final String field00491 = "Wind Streaks";
   private static final String field00492 = "Штрихи скорости мимо камеры при быстром движении";
   private static final float field00493 = 10.0F;
   private static final double field00494 = 1.0E-4;
   private static final float field00495 = 10.0F;
   private static final float field00496 = 30.0F;
   private static final float field00497 = 0.15F;
   private static final float field00498 = 4.0F;
   private static final double field00499 = 6.0;
   private static final double field00500 = 16.0;
   private static final double field00501 = 1.2F;
   private static final double field00502 = 6.0;
   private static final double field00503 = (float) (Math.PI * 2);
   private static final float field00504 = 0.6F;
   private static final float field00505 = 0.8F;
   private static final float field00506 = 0.5F;
   private static final float field00507 = 0.5F;
   private static final double field00508 = 0.9;
   private static final String field00509 = "От темы";
   private static final float field00510 = (float) Math.PI;
   private static final float field00511 = 10.0F;
   private static final float field00512 = 0.85F;

   @Subscribe
   private void method00239(Render3DEvent var1) {
      if (!this.field00477.isEmpty()) {
         if (var1.method00985().method07407(EffectRenderPipelines.method05519()) instanceof BaritoneVertexConsumerAccess var3) {
            long var4 = System.currentTimeMillis();
            Vec3 var6 = var1.method00994().position();
            Matrix4f var7 = var1.method00996().last().pose();
            boolean var8 = this.field00475.method05600(field00509);
            int var9 = ColorUtils.Nested138.method04636();
            int var10 = ColorUtils.Nested138.method04637();
            int var11 = 0;

            for (WindStreaks.Nested7 sx : this.field00477) {
               float sxx = (float)(var4 - sx.spawnTime()) / (float)(sx.deathTime() - sx.spawnTime());
               if (!(sxx <= 0.0F) && !(sxx >= 1.0F)) {
                  float sxxx = Mth.sin(sxx * field00510);
                  int sxxxx = var8 ? ColorUtils.method04583(var9, var10, var11++ % 10 / field00511) : ColorUtils.field10169;
                  int sxxxxx = ColorUtils.method04611(sxxxx, field00512 * sxxx);
                  int sxxxxxx = ColorUtils.method04611(sxxxx, 0.0F);
                  float sxxxxxxx = (float)(sx.position().x - var6.x);
                  float sxxxxxxxx = (float)(sx.position().y - var6.y);
                  float sxxxxxxxxx = (float)(sx.position().z - var6.z);
                  float sxxxxxxxxxx = sxxxxxxx - (float)sx.direction().x * sx.length();
                  float sxxxxxxxxxxx = sxxxxxxxx - (float)sx.direction().y * sx.length();
                  float sxxxxxxxxxxxx = sxxxxxxxxx - (float)sx.direction().z * sx.length();
                  float sxxxxxxxxxxxxx = (float)sx.direction().x;
                  float sxxxxxxxxxxxxxx = (float)sx.direction().y;
                  float sxxxxxxxxxxxxxxx = (float)sx.direction().z;
                  var3.lineVertex(var7, sxxxxxxx, sxxxxxxxx, sxxxxxxxxx, sxxxxx, sxxxxxxxxxxxxx, sxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxx, 2.0F);
                  var3.lineVertex(var7, sxxxxxxxxxx, sxxxxxxxxxxx, sxxxxxxxxxxxx, sxxxxxx, sxxxxxxxxxxxxx, sxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxx, 2.0F);
               }
            }
         }
      }
   }

   public WindStreaks() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field00473 = new NumberSetting<Float>(field00479)
         .method10835(field00480)
         .method10838(2.0F)
         .method10834(field00481)
         .method03017(1.0F)
         .method03023(this);
      this.field00474 = new NumberSetting<Float>(field00482)
         .method10835(1.0F)
         .method10838(field00483)
         .method10834(field00484)
         .method03017(field00485)
         .method03023(this);
      this.field00475 = new ModeSetting(field00486).method05597(field00487, field00488).method03017(field00489).method03023(this);
      this.field00476 = new ToggleSetting(field00490).method03017(false).method03023(this);
      this.field00477 = new ArrayList<>();
      this.field00478 = new Random();
      this.method03935(field00491);
      this.method03931(field00492);
   }

   private static Vec3 method00240(Vec3 var0) {
      Vec3 var1 = Math.abs(var0.y) < field00508 ? new Vec3(0.0, 1.0, 0.0) : new Vec3(1.0, 0.0, 0.0);
      return var0.cross(var1).normalize();
   }

   private void method00241(Vec3 var1, Vec3 var2, float var3, long var4) {
      Vec3 var6 = method00240(var2);
      Vec3 var7 = var2.cross(var6);
      double var8 = Mth.lerp(this.field00478.nextDouble(), field00499, field00500);
      double var10 = Mth.lerp(this.field00478.nextDouble(), field00501, field00502);
      double var12 = this.field00478.nextDouble() * field00503;
      Vec3 var14 = var1.add(var2.scale(var8)).add(var6.scale(Math.cos(var12) * var10)).add(var7.scale(Math.sin(var12) * var10));
      float var15 = this.field00474.method03022() * (field00504 + field00505 * this.field00478.nextFloat()) * (field00506 + field00507 * var3);
      long var16 = 350 + this.field00478.nextInt(350);
      this.field00477.add(new WindStreaks.Nested7(var14, var2, var15, var4, var4 + var16));
   }

   @Subscribe
   private void method00242(TickEvent var1) {
      long var2 = System.currentTimeMillis();
      this.field00477.removeIf(var2x -> var2 >= var2x.deathTime());
      if (mc.player != null && mc.level != null) {
         if (!this.field00476.method03022() || mc.player.isFallFlying()) {
            float var4 = MovementUtils.method05729(mc.player).floatValue();
            if (!(var4 < field00493)) {
               Vec3 var5 = MovementUtils.method05718(mc.player);
               double var6 = var5.length();
               if (!(var6 < field00494)) {
                  Vec3 var8 = var5.scale(1.0 / var6);
                  float var9 = Mth.clamp((var4 - field00495) / field00496, field00497, 1.0F);
                  int var10 = Math.round(this.field00473.method03022() * var9 * field00498);
                  Vec3 var11 = mc.player.getEyePosition();

                  for (int var12 = 0; var12 < var10 && this.field00477.size() < 80; var12++) {
                     this.method00241(var11, var8, var9, var2);
                  }
               }
            }
         }
      }
   }

   @Subscribe
   private void method00243(WorldLoadEvent var1) {
      this.field00477.clear();
   }

   @Override
   public void method00245() {
      super.method00245();
      this.field00477.clear();
   }

   // $VF: Compiled from s
   private record Nested7(Vec3 position, Vec3 direction, float length, long spawnTime, long deathTime) {
   }
}
