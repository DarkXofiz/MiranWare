// Original binary: sg/ec/SFv4V8OkuZXi6Y1f
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public final class FontTextRenderState implements GuiElementRenderState {
   private final String field11744;
   private final FontFace field11745;
   private final float field11746;
   private final float field11747;
   private final float field11748;
   private final float field11749;
   private final CornerColors field11750;
   private final float field11751;
   private final ScreenRectangle field11752;
   private final Matrix3x2f field11753;
   private ScreenRectangle field11754;
   private boolean field11755;

   @Override
   public @Nullable ScreenRectangle bounds() {
      if (!this.field11755) {
         this.field11754 = this.computeBounds();
         this.field11755 = true;
      }

      return this.field11754;
   }

   public FontTextRenderState(
      String var1,
      FontFace var2,
      float var3,
      float var4,
      float var5,
      float var6,
      CornerColors var7,
      float var8,
      ScreenRectangle var9,
      Matrix3x2f var10
   ) {
      this.field11744 = var1;
      this.field11745 = var2;
      this.field11746 = var3;
      this.field11747 = var4;
      this.field11748 = var5;
      this.field11749 = var6;
      this.field11750 = var7;
      this.field11751 = var8;
      this.field11752 = var9;
      this.field11753 = var10;
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
      if (this.field11744 != null && !this.field11744.isEmpty()) {
         float var2 = this.field11747 + this.field11745.method07006().method00836() * this.field11749;
         this.field11745
            .method07003(
               this.field11753,
               var1,
               this.field11744,
               this.field11749,
               this.field11751,
               this.field11746,
               var2,
               this.field11750,
               this.field11748,
               this.field11745.method06997()
            );
      }
   }

   @Override
   public ScreenRectangle scissorArea() {
      return this.field11752;
   }

   @Override
   public TextureSetup textureSetup() {
      return TextureSetup.singleTexture(this.field11745.method07012(), this.field11745.method07014());
   }

   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21439;
   }

   private @Nullable ScreenRectangle computeBounds() {
      if (this.field11744 != null && !this.field11744.isEmpty()) {
         float var1 = this.field11745.method06999(this.field11744, this.field11749, this.field11751);
         float var2 = this.field11745.method07006().method00837() * this.field11749;
         return GuiRectangleUtils.method08621(
            this.field11746 - this.field11749,
            this.field11747 - this.field11749,
            this.field11746 + var1 + this.field11749,
            this.field11747 + var2 + this.field11749,
            this.field11753,
            this.field11752
         );
      } else {
         return null;
      }
   }
}
