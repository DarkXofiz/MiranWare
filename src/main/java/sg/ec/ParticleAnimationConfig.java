// Original binary: sg/ec/GZT4LHK8R8edES5M
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

// $VF: Compiled from s
public class ParticleAnimationConfig {
   private int field07998;
   private Consumer<ParticleAnimationConfig> field07999;
   public String field08000;
   public String field08001;
   public boolean field08002;
   private boolean field08003 = true;
   private final String field08004;
   private double field08005;
   public double field08006;
   public double field08007;
   public double field08008;
   public double field08009;
   public double field08010;
   public double field08011;
   private double field08012;
   private double field08013;
   public double field08014;
   public double field08015;
   public double field08016;
   public double field08017;
   public double field08018;
   public double field08019;
   public double field08020;
   private double field08021;
   private final boolean field08022;
   public InteractionHand field08023;
   private Identifier field08024;
   private final List<Identifier> field08025;
   public PoseStack field08026;
   private final Iterator<Identifier> field08027;
   private static final double field08028 = 255.0;
   private static final double field08029 = 255.0;
   private static final float field08030 = 0.1F;
   private static final float field08031 = 30.0F;
   private static final double field08032 = 9999.0;
   private static final float field08033 = 0.1F;
   private static final float field08034 = 30.0F;
   private static final double field08035 = 30.0;
   private static final double field08036 = 30.0;
   private static final double field08037 = 30.0;
   private static final double field08038 = 0.9;
   private static final float field08039 = 30.0F;
   private static final double field08040 = 0.9;
   private static final float field08041 = 30.0F;
   private static final double field08042 = 0.9;
   private static final float field08043 = 30.0F;
   private static final double field08044 = 0.01;
   private static final double field08045 = 30.0;
   private static final double field08046 = 30.0;
   private static final double field08047 = 30.0;
   private static final double field08048 = 30.0;
   private static final String field08049 = "SCALE";
   private static final double field08050 = 0.03;
   private static final double field08051 = 30.0;
   private static final double field08052 = 0.07;
   private static final double field08053 = 30.0;
   private static final String field08054 = "OPACITY";
   private static final float field08055 = 10.0F;
   private static final float field08056 = 30.0F;
   private static final double field08057 = 255.0;
   private static final String field08058 = "SPAWN";
   private static final String field08059 = "KEYFRAME";
   private static final String field08060 = "ADDITIVE";
   private static final double field08061 = Math.PI / 180.0;
   private static final double field08062 = Math.PI / 180.0;
   private static final double field08063 = Math.PI / 180.0;
   private static final double field08064 = 0.25;

   public ParticleAnimationConfig(
      boolean var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      double var26,
      Identifier var28,
      String var29,
      InteractionHand var30,
      String var31,
      String var32,
      double var33,
      double var35,
      Consumer<ParticleAnimationConfig> var37
   ) {
      this.field08012 = field08028;
      this.field08014 = 1.0;
      this.field08025 = new ArrayList<>();
      this.field08022 = var1;
      this.field08000 = var31;
      this.field08004 = var32;
      this.field08001 = var29;
      this.field08023 = var30;
      this.field07999 = var37;
      this.field08012 = var35;
      this.field08006 = var2;
      this.field08007 = var4;
      this.field08008 = var6;
      this.field08009 = var8;
      this.field08010 = var10;
      this.field08011 = var12;
      this.field08015 = var14;
      this.field08016 = var16;
      this.field08017 = var18;
      this.field08018 = var20;
      this.field08019 = var22;
      this.field08020 = var24;
      this.field08014 = var26;
      this.field08005 = var33;
      this.field08024 = var28;
      this.field08027 = this.field08025.iterator();
   }

   public ParticleAnimationConfig(
      boolean var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      double var26,
      Identifier var28,
      String var29,
      InteractionHand var30,
      String var31,
      String var32,
      double var33,
      double var35
   ) {
      this(var1, var2, var4, var6, var8, var10, var12, var14, var16, var18, var20, var22, var24, var26, var28, var29, var30, var31, var32, var33, var35, null);
   }

   public ParticleAnimationConfig(
      boolean var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      double var26,
      Identifier var28,
      String var29,
      InteractionHand var30,
      String var31,
      String var32,
      double var33,
      double var35,
      Consumer<ParticleAnimationConfig> var37,
      PoseStack var38
   ) {
      this(var1, var2, var4, var6, var8, var10, var12, var14, var16, var18, var20, var22, var24, var26, var28, var29, var30, var31, var32, var33, var35, var37);
      this.field08026 = var38;
   }

   public ParticleAnimationConfig(
      boolean var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      double var26,
      Identifier var28,
      List<Identifier> var29,
      String var30,
      InteractionHand var31,
      String var32,
      String var33,
      double var34,
      double var36,
      Consumer<ParticleAnimationConfig> var38
   ) {
      this.field08012 = field08029;
      this.field08014 = 1.0;
      this.field08025 = var29;
      this.field08022 = var1;
      this.field08000 = var32;
      this.field08004 = var33;
      this.field08001 = var30;
      this.field08023 = var31;
      this.field07999 = var38;
      this.field08006 = var2;
      this.field08007 = var4;
      this.field08008 = var6;
      this.field08012 = var36;
      this.field08009 = var8;
      this.field08010 = var10;
      this.field08011 = var12;
      this.field08015 = var14;
      this.field08016 = var16;
      this.field08017 = var18;
      this.field08018 = var20;
      this.field08019 = var22;
      this.field08020 = var24;
      this.field08014 = var26;
      this.field08024 = var28;
      this.field08027 = var29.iterator();
   }

   public void method03621(PoseStack var1, SubmitNodeCollector var2, int var3, AbstractClientPlayer var4, float var5) {
      if (!this.field08002) {
         var1.pushPose();
         var1.translate(this.field08006, this.field08007, this.field08008);
         float var6 = (float)this.field08013;
         var1.scale(var6, var6, var6);
         RenderType var7 = field08060.equals(this.field08004)
            ? ParticleRenderer.method11152(this.field08024)
            : ParticleRenderer.method11151(this.field08024);
         Matrix4f var8 = var1.last().pose();
         Vector3f var9 = new Vector3f();
         Vector3f var10 = new Vector3f();
         var8.getTranslation(var9);
         var8.getScale(var10);
         Camera var11 = Minecraft.getInstance().gameRenderer.mainCamera();
         var8.identity().translate(var9).scale(var10).rotate(var11.rotation());
         var8.rotate(new Quaternionf().rotateX((float)(this.field08015 * field08061)));
         var8.rotate(new Quaternionf().rotateY((float)(this.field08016 * field08062)));
         var8.rotate(new Quaternionf().rotateZ((float)(this.field08017 * field08063)));
         double var12 = field08064;
         int var14 = Math.clamp((int)this.field08012, 0, 255);
         float var15 = (float)var12;
         var2.submitCustomGeometry(var1, var7, (var2x, var3x) -> {
            Matrix4f var4x = var2x.pose();
            Vector3f var5x = new Vector3f();
            var4x.transformPosition(var15, var15, 0.0F, var5x);
            var3x.addVertex(var5x.x, var5x.y, var5x.z).setUv(1.0F, 0.0F).setColor(255, 255, 255, var14);
            var4x.transformPosition(-var15, var15, 0.0F, var5x);
            var3x.addVertex(var5x.x, var5x.y, var5x.z).setUv(0.0F, 0.0F).setColor(255, 255, 255, var14);
            var4x.transformPosition(-var15, -var15, 0.0F, var5x);
            var3x.addVertex(var5x.x, var5x.y, var5x.z).setUv(0.0F, 1.0F).setColor(255, 255, 255, var14);
            var4x.transformPosition(var15, -var15, 0.0F, var5x);
            var3x.addVertex(var5x.x, var5x.y, var5x.z).setUv(1.0F, 1.0F).setColor(255, 255, 255, var14);
         });
         var1.popPose();
      }
   }

   public void method03623() {
      if (!this.field08002) {
         float var1 = ParticleRenderer.field24961;
         this.field08005 = this.field08005 - field08030 * var1 * field08031;
         this.field08005 = Math.clamp(this.field08005, 0.0, field08032);
         this.field08021 = this.field08021 + field08033 * var1 * field08034;
         this.field08006 = this.field08006 + this.field08009 * var1 * field08035;
         this.field08007 = this.field08007 + this.field08010 * var1 * field08036;
         this.field08008 = this.field08008 + this.field08011 * var1 * field08037;
         this.field08009 = this.field08009 * Math.pow(field08038, var1 * field08039);
         this.field08010 = this.field08010 * Math.pow(field08040, var1 * field08041);
         this.field08011 = this.field08011 * Math.pow(field08042, var1 * field08043);
         LocalPlayer var2 = Minecraft.getInstance().player;
         if (var2 != null) {
            if (this.field08022) {
               this.field08010 = this.field08010 - field08044 * var1 * field08045;
            }

            this.field08015 = this.field08015 + this.field08018 * var1 * field08046;
            this.field08016 = this.field08016 + this.field08019 * var1 * field08047;
            this.field08017 = this.field08017 + this.field08020 * var1 * field08048;
            if (!this.field08025.isEmpty() && this.field08027.hasNext() && var2.tickCount % 4 == 0 && var2.tickCount != this.field07998) {
               this.field08024 = this.field08027.next();
            }

            if (field08049.equals(this.field08000)) {
               if (!this.field08003 && this.field08005 == 0.0) {
                  this.field08013 = this.field08013 - field08050 * var1 * field08051;
                  if (this.field08013 <= 0.0) {
                     this.field08002 = true;
                  }
               } else {
                  this.field08013 = this.field08013 + field08052 * var1 * field08053;
                  if (this.field08013 >= this.field08014) {
                     this.field08013 = this.field08014;
                     this.field08003 = false;
                  }
               }
            } else if (field08054.equals(this.field08000)) {
               if (!this.field08003 && this.field08005 == 0.0) {
                  this.field08012 = this.field08012 - field08055 * var1 * field08056;
                  if (this.field08012 <= 0.0) {
                     this.field08002 = true;
                     this.field08012 = 0.0;
                  }
               } else {
                  this.field08013 = this.field08014;
                  this.field08003 = false;
                  this.field08012 = field08057;
               }
            } else if (field08058.equals(this.field08000)) {
               if (!this.field08003 && this.field08005 == 0.0) {
                  this.field08002 = true;
               } else {
                  this.field08013 = this.field08014;
                  this.field08003 = false;
               }
            } else if (field08059.equals(this.field08000)) {
               if (!this.field08003 && !this.field08027.hasNext()) {
                  this.field08002 = true;
               } else {
                  this.field08013 = this.field08014;
                  this.field08003 = false;
               }
            }

            if (this.field07999 != null) {
               this.field07999.accept(this);
            }

            this.field07998 = var2.tickCount;
         }
      }
   }
}
