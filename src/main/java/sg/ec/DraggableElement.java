// Original binary: sg/ec/BEOiGTnSfPbiPkC0
package sg.ec;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mojang.blaze3d.platform.Window;
import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public class DraggableElement implements MinecraftAccess {
   @SerializedName("x")
   @Expose
   private float xPos;
   @SerializedName("y")
   @Expose
   private float yPos;
   public float field06220;
   public float field06221;
   private float field06222;
   private float field06223;
   private boolean field06224;
   private boolean field06225;
   private boolean field06226;
   private float field06227;
   private float field06228;
   private float field06229 = 1.0F;
   private float field06230;
   private float field06231;
   private float field06232;
   private float field06233;
   @SerializedName("name")
   @Expose
   private final String name;
   private final HudElement field06234;
   private final GuiViewport field06235;

   public void method02661(float var1) {
      this.field06229 = var1;
   }

   public void method02662(float var1) {
      this.field06223 = var1;
   }

   public void method02663(float var1) {
      this.xPos = var1;
   }

   public boolean method02664() {
      return this.field06226;
   }

   public final boolean method02665(double var1, double var3, int var5) {
      if (var5 != 0) {
         return false;
      } else if (!(this.field06227 <= 0.0F) && !(this.field06228 <= 0.0F)) {
         float var6 = this.method02697();
         Vec2 var7 = GuiHitTestUtils.method05611((float)(var1 / var6), (float)(var3 / var6));
         return this.method02674(var7.x, var7.y, var7.x, var7.y, var5);
      } else {
         return false;
      }
   }

   private float method02666() {
      float var1 = this.field06235.method04537();
      return var1 <= 0.0F ? var1 : var1 / this.method02697();
   }

   public DraggableElement(String var1, float var2, float var3, GuiViewport var4) {
      this.field06234 = null;
      this.name = var1;
      this.field06235 = var4;
      this.field06227 = var2;
      this.field06228 = var3;
   }

   public void method02667(float var1) {
      float var2 = this.method02666();
      if (var2 <= 0.0F) {
         this.yPos = var1;
      } else {
         this.yPos = (this.field06225 ? var1 + this.field06228 / 2.0F : var1) / var2;
      }
   }

   public float method02668() {
      return this.xPos;
   }

   public float method02669() {
      float var1 = this.method02666();
      if (this.field06225) {
         return this.method02711(var1) - this.field06228 / 2.0F;
      } else {
         return var1 <= 0.0F ? this.yPos : this.yPos * var1;
      }
   }

   public float method02670() {
      return this.field06231;
   }

   public float method02671() {
      return this.field06233;
   }

   private boolean method02672(float var1, float var2, float var3, float var4) {
      return this.field06232 > 0.0F && this.field06233 > 0.0F
         ? GuiHitTestUtils.method05625(var1, var2, this.field06230, this.field06231, this.field06232, this.field06233)
         : GuiHitTestUtils.method05625(var1, var2, var3, var4, this.field06227, this.field06228);
   }

   public void method02673(float var1, float var2, float var3, float var4) {
      this.field06230 = var1;
      this.field06231 = var2;
      this.field06232 = var3;
      this.field06233 = var4;
   }

   public final boolean method02674(double var1, double var3, double var5, double var7, int var9) {
      if (var9 != 0) {
         return false;
      }

      if (!(this.field06227 <= 0.0F) && !(this.field06228 <= 0.0F)) {
         float var10 = this.method02704();
         float var11 = this.method02666();
         if (this.field06225) {
            float var16 = this.method02680(var10);
            float var17 = this.method02711(var11);
            float var14 = var16 - this.field06227 / 2.0F;
            float var15 = var17 - this.field06228 / 2.0F;
            if (this.method02672((float)var5, (float)var7, var14, var15)) {
               this.field06224 = true;
               this.field06222 = (float)(var1 - var16);
               this.field06223 = (float)(var3 - var17);
               return true;
            } else {
               return false;
            }
         } else {
            float var12 = var10 > 0.0F ? this.xPos * var10 : this.xPos;
            float var13 = var11 > 0.0F ? this.yPos * var11 : this.yPos;
            if (this.method02672((float)var5, (float)var7, var12, var13)) {
               this.field06224 = true;
               this.field06222 = (float)(var1 - var12);
               this.field06223 = (float)(var3 - var13);
               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public void method02675(boolean var1) {
      this.field06224 = var1;
   }

   public void method02676(float var1) {
      this.field06227 = var1;
   }

   public void method02677(boolean var1) {
      this.field06225 = var1;
   }

   public float method02678() {
      return this.field06222;
   }

   public void method02679(float var1) {
      this.field06232 = var1;
   }

   private float method02680(float var1) {
      float var2 = var1 > 0.0F ? this.xPos * var1 : this.xPos;
      if (var1 > 0.0F) {
         float var3 = this.field06227 * this.field06229 / 2.0F;
         var2 = method02706(var2, var3, var1 - var3);
      }

      return var2;
   }

   public DraggableElement(HudElement var1, String var2, float var3, float var4) {
      this.field06234 = var1;
      this.name = var2;
      this.field06235 = GuiViewport.field10077;
      this.xPos = var3;
      this.yPos = var4;
      this.field06220 = var3;
      this.field06221 = var4;
      float var5 = this.field06235.method04535();
      float var6 = this.field06235.method04537();
      if (var5 > 0.0F && var6 > 0.0F) {
         this.method02695(var5, var6);
      }
   }

   public float method02681() {
      return this.field06228;
   }

   public void method02682(boolean var1) {
      this.field06226 = var1;
   }

   public float method02683() {
      return this.field06229;
   }

   public boolean method02684() {
      return this.field06225;
   }

   public float method02685() {
      float var1 = this.method02704();
      if (this.field06225) {
         return this.method02680(var1) - this.field06227 / 2.0F;
      } else {
         return var1 <= 0.0F ? this.xPos : this.xPos * var1;
      }
   }

   public final void method02686(int var1) {
      if (var1 == 0) {
         this.field06224 = false;
      }
   }

   public float method02687() {
      return this.field06227;
   }

   public float method02688() {
      return this.yPos;
   }

   public void method02689(float var1) {
      this.yPos = var1;
   }

   public final void method02690(int var1, int var2, Window var3) {
      float var4 = this.method02697();
      Vec2 var5 = GuiHitTestUtils.method05611(var1 / var4, var2 / var4);
      var1 = (int)var5.x;
      var2 = (int)var5.y;
      float var6 = this.method02704();
      float var7 = this.method02666();
      if (!(var6 <= 0.0F) && !(var7 <= 0.0F)) {
         if (this.field06224) {
            if (this.field06225) {
               float var14 = this.field06227 * this.field06229 / 2.0F;
               float var15 = this.field06228 * this.field06229 / 2.0F;
               float var16 = method02706(var1 - this.field06222, var14, var6 - var14);
               float var17 = method02706(var2 - this.field06223, var15, var7 - var15);
               if (!this.field06226) {
                  this.xPos = var16 / var6;
               }

               this.yPos = var17 / var7;
            } else {
               float var8 = var1 - this.field06222;
               float var9 = var2 - this.field06223;
               float var10 = this.field06227 * this.field06229;
               float var11 = this.field06228 * this.field06229;
               if (var8 + var10 > var6) {
                  var8 = var6 - var10;
               }

               if (var9 + var11 > var7) {
                  var9 = var7 - var11;
               }

               if (var8 < 0.0F) {
                  var8 = 0.0F;
               }

               if (var9 < 0.0F) {
                  var9 = 0.0F;
               }

               if (!this.field06226) {
                  this.xPos = var8 / var6;
               }

               this.yPos = var9 / var7;
            }
         }
      }
   }

   public void method02691(float var1) {
      this.field06222 = var1;
   }

   public void method02692(float var1) {
      this.field06233 = var1;
   }

   public GuiViewport method02693() {
      return this.field06235;
   }

   public void method02694(float var1) {
      this.field06221 = var1;
   }

   void method02695(float var1, float var2) {
      if (!(var1 <= 0.0F) && !(var2 <= 0.0F)) {
         if (this.xPos > 1.0F || this.yPos > 1.0F) {
            this.xPos /= var1;
            this.yPos /= var2;
         }
      }
   }

   public void method02696(float var1) {
      this.field06228 = var1;
   }

   private float method02697() {
      return this.field06234 == null ? this.field06235.method04536() : this.field06234.method06446();
   }

   public void method02698(float var1) {
      this.field06220 = var1;
   }

   public float method02699() {
      return this.field06221;
   }

   public float method02700() {
      return this.field06230;
   }

   public boolean method02701() {
      return this.field06224;
   }

   public void method02702(float var1) {
      this.field06231 = var1;
   }

   public float method02703() {
      return this.field06220;
   }

   private float method02704() {
      float var1 = this.field06235.method04535();
      return var1 <= 0.0F ? var1 : var1 / this.method02697();
   }

   public HudElement method02705() {
      return this.field06234;
   }

   private static float method02706(float var0, float var1, float var2) {
      if (var1 > var2) {
         return (var1 + var2) / 2.0F;
      } else {
         return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
      }
   }

   public void method02707(float var1) {
      float var2 = this.method02704();
      if (var2 <= 0.0F) {
         this.xPos = var1;
      } else {
         this.xPos = (this.field06225 ? var1 + this.field06227 / 2.0F : var1) / var2;
      }
   }

   public float method02708() {
      return this.field06223;
   }

   public void method02709(float var1) {
      this.field06230 = var1;
   }

   public float method02710() {
      return this.field06232;
   }

   private float method02711(float var1) {
      float var2 = var1 > 0.0F ? this.yPos * var1 : this.yPos;
      if (var1 > 0.0F) {
         float var3 = this.field06228 * this.field06229 / 2.0F;
         var2 = method02706(var2, var3, var1 - var3);
      }

      return var2;
   }

   public String method02712() {
      return this.name;
   }
}
