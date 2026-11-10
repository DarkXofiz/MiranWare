// Original binary: sg/ec/FfbSsAkTslsHrCuI
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public enum ParticleAtlas {
   INSTANCE;

   public static final int field07603 = 11;
   private static final String field07604 = "field07604";
   private static final int field07605 = 0;
   private static final int field07606 = 0;
   private final ParticleAtlas.Nested96[] field07607 = new ParticleAtlas.Nested96[4];
   private int field07608;
   private ParticleAtlas.Nested96 field07609;

   public int method03419() {
      return this.field07609 == null ? 0 : this.field07609.slotCount;
   }

   public RenderType method03420() {
      return this.field07609 == null ? null : this.field07609.renderType;
   }

   public float method03421(int var1) {
      return this.field07609.field07611[var1];
   }

   public float method03422(int var1) {
      return this.field07609.field07612[var1];
   }

   public void method03423(int var1) {
      for (ParticleAtlas.Nested96 var5 : this.field07607) {
         if (var5 != null && var5.mask == var1) {
            this.field07609 = var5;
            return;
         }
      }

      this.field07609 = this.method03424(method03432(var1));
   }

   private ParticleAtlas.Nested96 method03424(ParticleAtlas.Nested96 var1) {
      if (var1 == null) {
         return null;
      }

      method03425(this.field07607[this.field07608]);
      this.field07607[this.field07608] = var1;
      this.field07608 = (this.field07608 + 1) % 4;
      return var1;
   }

   private static void method03425(ParticleAtlas.Nested96 var0) {
      if (var0 != null) {
         Minecraft.getInstance().getTextureManager().release(var0.field07610);
      }
   }

   private static List<NativeImage> method03426(int var0) {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < 11; var2++) {
         if ((var0 & 1 << var2) != 0) {
            NativeImage var3 = ClientTextures.INSTANCE.method04561(var2);
            if (var3 != null) {
               var1.add(var3);
            }
         }
      }

      return var1;
   }

   private static int method03427(int var0) {
      return Math.max(0, Integer.numberOfTrailingZeros(var0) - Integer.numberOfTrailingZeros(32));
   }

   private static NativeImage[] method03428(NativeImage var0, int var1) {
      NativeImage[] var2 = new NativeImage[var1 + 1];
      var2[0] = var0;

      for (int var3 = 1; var3 < var2.length; var3++) {
         var2[var3] = method03429(var2[var3 - 1]);
      }

      return var2;
   }

   private static NativeImage method03429(NativeImage var0) {
      int var1 = var0.getWidth() >> 1;
      int var2 = var0.getHeight() >> 1;
      NativeImage var3 = new NativeImage(var1, var2, false);

      for (int var4 = 0; var4 < var2; var4++) {
         for (int var5 = 0; var5 < var1; var5++) {
            var3.setPixel(var5, var4, method03431(var0, var5 << 1, (var5 << 1) + 2, var4 << 1, (var4 << 1) + 2));
         }
      }

      return var3;
   }

   private static void method03430(NativeImage var0, NativeImage var1, int var2, int var3) {
      int var4 = var0.getWidth();
      int var5 = var0.getHeight();

      for (int var6 = 0; var6 < var3; var6++) {
         int var7 = var6 * var5 / var3;
         int var8 = Math.max(var7 + 1, (var6 + 1) * var5 / var3);

         for (int var9 = 0; var9 < var3; var9++) {
            int var10 = var9 * var4 / var3;
            int var11 = Math.max(var10 + 1, (var9 + 1) * var4 / var3);
            var1.setPixel(var2 + var9, var6, method03431(var0, var10, var11, var7, var8));
         }
      }
   }

   private static int method03431(NativeImage var0, int var1, int var2, int var3, int var4) {
      long var5 = 0L;
      long var7 = 0L;
      long var9 = 0L;
      long var11 = 0L;

      for (int var13 = var3; var13 < var4; var13++) {
         for (int var14 = var1; var14 < var2; var14++) {
            int var15 = var0.getPixel(var14, var13);
            int var16 = var15 >>> 24 & 0xFF;
            var5 += (var15 >> 16 & 0xFF) * var16;
            var7 += (var15 >> 8 & 0xFF) * var16;
            var9 += (var15 & 0xFF) * var16;
            var11 += var16;
         }
      }

      if (var11 == 0L) {
         return 0;
      }

      int var17 = (int)(var11 / ((long)(var2 - var1) * (var4 - var3)));
      return var17 << 24 | (int)(var5 / var11) << 16 | (int)(var7 / var11) << 8 | (int)(var9 / var11);
   }

   private static ParticleAtlas.Nested96 method03432(int var0) {
      var var1 = method03426(var0);
      if (var1.isEmpty()) {
         return null;
      }

      int var2 = var1.size();
      int var3 = 0;

      for (NativeImage var5 : var1) {
         var3 = Math.max(var3, Math.max(var5.getWidth(), var5.getHeight()));
      }

      if (var3 == 0) {
         return null;
      }

      var3 = Integer.highestOneBit(var3 * 2 - 1);
      int var16 = var3 * var2;
      NativeImage var17 = new NativeImage(var16, var3, false);

      for (int var6 = 0; var6 < var2; var6++) {
         method03430((NativeImage)var1.get(var6), var17, var6 * var3, var3);
      }

      int var18 = method03427(var3);
      Identifier var7 = Identifier.fromNamespaceAndPath("Hex".toLowerCase(), "dynamic/particle_atlas_" + Integer.toHexString(var0));
      UploadedTexture var8 = new UploadedTexture(() -> "hex particle atlas", method03428(var17, var18));

      try {
         Minecraft.getInstance().getTextureManager().register(var7, var8);
         float[] var9 = new float[var2];
         float[] var10 = new float[var2];
         float var11 = 0.5F * (1 << var18) / var16;

         for (int var12 = 0; var12 < var2; var12++) {
            var9[var12] = (float)(var12 * var3) / var16 + var11;
            var10[var12] = (float)((var12 + 1) * var3) / var16 - var11;
         }

         return new ParticleAtlas.Nested96(var0, var7, EffectRenderPipelines.method05541(var7), var2, var9, var10);
      } catch (Exception var14) {
         try {
            var8.close();
         } catch (Exception var13) {
         }

         return null;
      }
   }

   // $VF: Compiled from s
   private record Nested96(int mask, Identifier field07610, RenderType renderType, int slotCount, float[] field07611, float[] field07612) {
   }
}
