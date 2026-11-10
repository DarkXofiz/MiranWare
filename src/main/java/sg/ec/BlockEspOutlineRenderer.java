// Original binary: sg/ec/k7iQf80sYdTHnNBC
package sg.ec;

import com.mojang.renderpearl.api.commands.RenderPass;

import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.systems.RenderSystem.AutoStorageIndexBuffer;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.rendertype.PreparedRenderType;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4fStack;

// $VF: Compiled from s
public final class BlockEspOutlineRenderer {
   private static final Supplier<String> field20780 = () -> BlockEspOutlineRenderer.field20787;
   private static GpuBuffer field20781;
   private static int field20782;
   private static int field20783;
   private static double field20784;
   private static double field20785;
   private static double field20786;
   private static final String field20787 = "hex block esp outlines";

   public static boolean method09154() {
      return (field20781 != null || BlockEspMeshWorker.method00052()) && method09158();
   }

   private BlockEspOutlineRenderer() {
   }

   public static void method09156() {
      if (method09158()) {
         BlockEspMesh var0 = BlockEspMeshWorker.method00050();
         if (var0 != null) {
            method09157(var0);
         }

         if (field20781 != null) {
            Vec3 var1 = Minecraft.getInstance().gameRenderer.mainCamera().position();
            int var2 = PrimitiveTopology.DEBUG_LINES.indexCount(field20783);
            AutoStorageIndexBuffer var3 = RenderSystem.getSequentialBuffer(PrimitiveTopology.DEBUG_LINES);
            GpuBuffer var4 = var3.getBuffer(var2);
            RenderType var5 = EffectRenderPipelines.method05562();
            Matrix4fStack var6 = RenderSystem.getModelViewStack();
            var6.pushMatrix();
            var6.translate((float)(field20784 - var1.x), (float)(field20785 - var1.y), (float)(field20786 - var1.z));
            PreparedRenderType var7 = var5.prepare();
            var6.popMatrix();
            var var8 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
            try (RenderPass var9 = RenderSystem.getDevice()
                  .createCommandEncoder()
                  .createRenderPass(() -> "hex block esp", var8.getColorTextureView(), java.util.Optional.empty(), var8.getDepthTextureView(), java.util.OptionalDouble.empty())) {
               var7.drawFromBuffer(new net.minecraft.client.renderer.StagedVertexBuffer.ExecuteInfo(field20781, var4, var3.type(), 0, 0, var2, PrimitiveTopology.DEBUG_LINES), var9);
            }
         }
      }
   }

   private static void method09157(BlockEspMesh var0) {
      if (var0.vertices() == 0) {
         method09159();
      } else {
         int var1 = var0.data().remaining();
         if (field20781 == null || field20782 < var1) {
            method09159();
            field20782 = var1 + (var1 >> 2);
            field20781 = RenderSystem.getDevice().createBuffer(field20780, 40, field20782);
         }

         RenderSystem.getDevice().createCommandEncoder().writeToBuffer(field20781.slice(0L, var1), var0.data());
         field20783 = var0.vertices();
         field20784 = var0.originX();
         field20785 = var0.originY();
         field20786 = var0.originZ();
      }
   }

   private static boolean method09158() {
      BlockESP var0 = ModuleManager.INSTANCE.method08249();
      return var0 != null && var0.method03937();
   }

   private static void method09159() {
      field20783 = 0;
      field20782 = 0;
      if (field20781 != null) {
         field20781.close();
         field20781 = null;
      }
   }

   public static void method09160() {
      BlockEspMeshWorker.method00051();
      method09159();
   }
}
