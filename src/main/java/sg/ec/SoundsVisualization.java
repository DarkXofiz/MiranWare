// Original binary: sg/ec/AiYDswbIbMb91HDa
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3x2fStack;

// $VF: Compiled from s
public class SoundsVisualization extends ClientModule {
   private static final CornerRadii field06142 = new CornerRadii(1.0F);
   private static final float field06143 = 0.25F;
   private static final float field06144 = 0;
   private final List<SoundsVisualization.Nested71> field06145 = new ArrayList<>(64);
   private static final String field06146 = "Sounds Visualization";
   private static final double field06147 = 10.0;
   private static final String field06148 = "FireWork";
   private static final float field06149 = (float) (Math.PI / 180.0);
   private static final float field06150 = 0.25F;
   private static final float field06151 = -125.0F;
   private static final float field06152 = (float) (Math.PI / 2);
   private static final float field06153 = 250.0F;
   private static final float field06154 = 250.0F;
   private static final String field06155 = "Default";

   private void method02585(Vec3 var1) {
      this.method02588(var1, field06155);
   }

   @Subscribe
   private void method02586(TickEvent var1) {
      this.field06145.removeIf(SoundsVisualization.Nested71::method02597);
      this.field06145.forEach(SoundsVisualization.Nested71::method02593);
   }

   @Subscribe
   private void method02587(WorldSoundEvent var1) {
      if (mc.player != null) {
         if (var1.method08872() == WorldSoundEvent.Nested247.FIREWORK) {
            Vec3 var2 = var1.method08873();
            if (mc.player.getEyePosition().distanceTo(var2) > field06147) {
               this.method02590(var1.method08873(), field06148, 20);
            }
         }
      }
   }

   private void method02588(Vec3 var1, String var2) {
      this.method02590(var1, var2, 30);
   }

   @Subscribe
   private void method02589(HudRenderEvent var1) {
      if (!this.field06145.isEmpty()) {
         Identifier var2 = ClientTextures.INSTANCE.method04564();
         GuiGraphicsExtractor var3 = var1.method05424();
         Matrix3x2fStack var4 = var3.pose();
         EntityRenderDispatcher var5 = mc.getEntityRenderDispatcher();
         float var6 = var5.camera.yRot() * field06149;
         Vec3 var7 = var5.camera.position();
         float var8 = mc.getWindow().getGuiScaledWidth() / 2.0F;
         float var9 = mc.getWindow().getGuiScaledHeight() / 2.0F;
         float var10 = mc.getWindow().getGuiScaledHeight() * field06150;
         float var11 = field06151;
         GuiTextureRenderer.method10262();

         for (SoundsVisualization.Nested71 var13 : this.field06145) {
            int var14 = var13.method02591();
            int var15 = var13.method02598();
            AnimationUtils var16 = var13.method02602();
            var16.method03375(var14 < var15 - 4 ? 1.0 : 0.0);
            Vec3 var17 = var13.method02592();
            float var18 = (float)Mth.atan2(var7.z() - var17.z, var7.x() - var17.x) - var6;
            float var19 = (var15 - var14) * 1.0F / var15;
            int var20 = ColorUtils.method04611(ColorUtils.method04601(var19, 1.0F, false), var16.method03377());
            var4.pushMatrix();
            var4.translate(var8 + var10 * Mth.cos(var18), var9 + var10 * Mth.sin(var18));
            var4.rotate(var18 + field06152);
            GuiTextureRenderer.method10253(
               var3, var2, 1.0F, 1.0F, 1.0F, 1.0F, var11, var11, field06153, field06154, field06142, 1.0F, new CornerColors(var20)
            );
            var4.popMatrix();
         }

         GuiTextureRenderer.method10261();
      }
   }

   private void method02590(Vec3 var1, String var2, int var3) {
      this.field06145.add(new SoundsVisualization.Nested71(var1, var2, var3));
   }

   public SoundsVisualization() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.method03935(field06146);
   }

   // $VF: Compiled from s
   public static class Nested71 {
      private Vec3 field06156;
      private String field06157;
      private AnimationUtils field06158;
      private int field06159;
      private int field06160;
      private static final long field06161 = 150L;

      public int method02591() {
         return this.field06159;
      }

      public Vec3 method02592() {
         return this.field06156;
      }

      public void method02593() {
         this.field06159++;
      }

      public void method02594(Vec3 var1) {
         this.field06156 = var1;
      }

      public String method02595() {
         return this.field06157;
      }

      public void method02596(int var1) {
         this.field06159 = var1;
      }

      public Nested71(Vec3 var1, String var2, int var3) {
         this.field06156 = var1;
         this.field06157 = var2;
         this.field06160 = var3;
         this.field06158 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field06161);
      }

      public boolean method02597() {
         return this.field06159 > this.field06160;
      }

      public int method02598() {
         return this.field06160;
      }

      public void method02599(String var1) {
         this.field06157 = var1;
      }

      public void method02600(int var1) {
         this.field06160 = var1;
      }

      public void method02601(AnimationUtils var1) {
         this.field06158 = var1;
      }

      public AnimationUtils method02602() {
         return this.field06158;
      }
   }
}
