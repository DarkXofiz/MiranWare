package sg.ec;

// TODO(port 1.21.11): parcacik cizimi (ParticleAtlas / pipeline) yeni render hattina tasinacak.
public class ClientParticleRenderer {
   private static final float field23527 = 0.003921569F;
   private static final float field23530 = 255.0F;

   public void method10539() {
   }

   public static int method10534(int var0) {
      float var1 = ColorUtils.method04594(var0) * field23527;
      return method10529(ColorUtils.method04617(var0) * var1, ColorUtils.method04619(var0) * var1, ColorUtils.method04607(var0) * var1);
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
}
