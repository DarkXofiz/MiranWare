// Original binary: sg/ec/qR3z6U8wLTlUfChZ
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class GuiTextureRenderer implements MinecraftAccess {
   private static final CornerRadii field23088 = new CornerRadii(1.0F);
   private static final float field23089 = 0.125F;
   private static final float field23090 = 0;
   private static final float field23091 = 0.625F;
   private static final float field23092 = 0.125F;
   private static final float field23093 = 0.125F;
   private static final float field23094 = 0.125F;
   private static final float field23095 = 0.125F;
   private static final float field23096 = 0.03125F;
   private static final float field23097 = 0.03125F;
   private static final String field23098 = "This is a utility class and cannot be instantiated";

   public static void method10253(
      GuiGraphicsExtractor var0,
      Identifier var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      CornerRadii var10,
      float var11,
      CornerColors var12
   ) {
      GuiRenderBatch.method05186(
         var0.guiRenderState,
         new TextureGuiRenderState(
            var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var0.scissorStack.peek(), new Matrix3x2f(var0.pose())
         )
      );
   }

   public static void method10254(
      GuiGraphicsExtractor var0, Identifier var1, float var2, float var3, float var4, float var5, CornerRadii var6, float var7, int var8
   ) {
      method10253(var0, var1, 0.0F, 0.0F, 1.0F, 1.0F, var2, var3, var4, var5, var6, var7, new CornerColors(var8));
   }

   public static void method10255(GuiGraphicsExtractor var0, Identifier var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      method10253(var0, var1, 0.0F, 0.0F, 1.0F, 1.0F, var2, var3, var4, var5, new CornerRadii(var6), var7, new CornerColors(var8));
   }

   public static void method10256(
      GuiGraphicsExtractor var0, Identifier var1, float var2, float var3, float var4, float var5, float var6, float var7, CornerColors var8
   ) {
      method10253(var0, var1, 0.0F, 0.0F, 1.0F, 1.0F, var2, var3, var4, var5, new CornerRadii(var6), var7, var8);
   }

   private GuiTextureRenderer() {
      throw new UnsupportedOperationException(field23098);
   }

   public static void method10257(
      GuiGraphicsExtractor var0, Identifier var1, float var2, float var3, float var4, float var5, CornerRadii var6, float var7, CornerColors var8
   ) {
      method10253(var0, var1, 0.0F, 0.0F, 1.0F, 1.0F, var2, var3, var4, var5, var6, var7, var8);
   }

   public static void method10258(GuiGraphicsExtractor var0, Identifier var1, float var2, float var3, float var4, float var5, CornerColors var6) {
      method10253(var0, var1, 0.0F, 0.0F, 1.0F, 1.0F, var2, var3, var4, var5, field23088, 1.0F, var6);
   }

   public static void method10259(GuiGraphicsExtractor var0, Identifier var1, float var2, float var3, float var4, float var5, int var6) {
      method10253(var0, var1, 0.0F, 0.0F, 1.0F, 1.0F, var2, var3, var4, var5, field23088, 1.0F, new CornerColors(var6));
   }

   public static void method10260(
      GuiGraphicsExtractor var0,
      Identifier var1,
      boolean var2,
      float var3,
      float var4,
      float var5,
      float var6,
      CornerRadii var7,
      float var8,
      CornerColors var9
   ) {
      ItemTextureAtlas var10 = ItemTextureAtlas.INSTANCE;
      int var11 = var10.method06287(var1);
      if (var11 < 0) {
         method10253(var0, var1, var2 ? field23091 : field23092, field23093, field23094, field23095, var3, var4, var5, var6, var7, var8, var9);
      } else {
         method10253(
            var0,
            var10.method06284(),
            var10.method06285(var11, var2),
            var10.method06286(var11),
            field23096,
            field23097,
            var3,
            var4,
            var5,
            var6,
            var7,
            var8,
            var9
         );
      }
   }

   public static void method10261() {
      GuiRenderBatch.method05181();
   }

   public static void method10262() {
      GuiRenderBatch.method05194();
   }
}
