// Original binary: sg/ec/5MRWoDHqpOHUm2Sh
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.culling.Frustum;
import org.joml.Matrix4f;

// $VF: Compiled from s
public class Render3DEvent extends Event {
   public static final Render3DEvent field02241 = new Render3DEvent();
   private WorldVertexCollector field02242;
   private DeltaTracker field02243;
   private PoseStack field02244;
   private Matrix4f field02245;
   private Frustum field02246;
   private Camera field02247;

   public DeltaTracker method00984() {
      return this.field02243;
   }

   public WorldVertexCollector method00985() {
      return this.field02242;
   }

   public Frustum method00986() {
      return this.field02246;
   }

   public void method00987(Frustum var1) {
      this.field02246 = var1;
   }

   public void method00988(WorldVertexCollector var1, DeltaTracker var2, PoseStack var3, Matrix4f var4, Frustum var5, Camera var6) {
      this.field02242 = var1;
      this.field02243 = var2;
      this.field02244 = var3;
      this.field02245 = var4;
      this.field02246 = var5;
      this.field02247 = var6;
      super.method03208();
      this.field02242.method07404();
   }

   public void method00989(Matrix4f var1) {
      this.field02245 = var1;
   }

   public void method00990(DeltaTracker var1) {
      this.field02243 = var1;
   }

   public void method00991(Camera var1) {
      this.field02247 = var1;
   }

   public Matrix4f method00992() {
      return this.field02245;
   }

   public void method00993(PoseStack var1) {
      this.field02244 = var1;
   }

   public Camera method00994() {
      return this.field02247;
   }

   public void method00995(WorldVertexCollector var1) {
      this.field02242 = var1;
   }

   public PoseStack method00996() {
      return this.field02244;
   }
}
