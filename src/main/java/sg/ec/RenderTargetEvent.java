// Original binary: sg/ec/02TQNbIpejMdZ6Lq
package sg.ec;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.renderpearl.api.textures.GpuTextureView;

// $VF: Compiled from s
public class RenderTargetEvent extends Event {
   public static final RenderTargetEvent field00066 = new RenderTargetEvent();
   private RenderTarget field00067;
   private GpuTextureView field00068;

   public boolean method00001(RenderTarget var1, GpuTextureView var2) {
      this.field00067 = var1;
      this.field00068 = var2;
      super.method03208();
      return this.method05694();
   }

   public void method00002(GpuTextureView var1) {
      this.field00068 = var1;
   }

   public RenderTarget method00003() {
      return this.field00067;
   }

   public void method00004(RenderTarget var1) {
      this.field00067 = var1;
   }

   public GpuTextureView method00005() {
      return this.field00068;
   }
}
