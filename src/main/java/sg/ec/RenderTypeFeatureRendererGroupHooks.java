// Original binary: sg/ec/yHb6pBH8oKPCtFsg
package sg.ec;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.systems.ScissorState;
import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import java.util.List;
import net.minecraft.client.renderer.rendertype.PreparedRenderType;
import net.minecraft.client.renderer.rendertype.RenderType;
import org.joml.Matrix4f;

// $VF: Compiled from s
public final class RenderTypeFeatureRendererGroupHooks {
   private static final int field26463 = -2;
   private final Reference2ObjectOpenHashMap<RenderType, PreparedRenderType> field26464 = new Reference2ObjectOpenHashMap();
   private final Reference2IntOpenHashMap<PreparedRenderType> field26465 = new Reference2IntOpenHashMap();
   private final Matrix4f field26466 = new Matrix4f();
   private boolean field26467;
   private boolean field26468;
   private int field26469;
   private int field26470;
   private int field26471;
   private int field26472;

   private void method11614() {
      ScissorState var1 = RenderSystem.getScissorStateForRenderTypeDraws();
      Matrix4f sx = RenderSystem.getModelViewStack();
      if (!this.field26467
         || this.field26468 != var1.enabled()
         || this.field26469 != var1.x()
         || this.field26470 != var1.y()
         || this.field26471 != var1.width()
         || this.field26472 != var1.height()
         || !this.field26466.equals(sx)) {
         this.field26464.clear();
         this.field26465.clear();
         this.field26466.set(sx);
         this.field26468 = var1.enabled();
         this.field26469 = var1.x();
         this.field26470 = var1.y();
         this.field26471 = var1.width();
         this.field26472 = var1.height();
         this.field26467 = true;
      }
   }

   public PreparedRenderType method11615(RenderType var1) {
      this.method11614();
      PreparedRenderType var2 = (PreparedRenderType)this.field26464.get(var1);
      if (var2 != null) {
         return var2;
      }

      PreparedRenderType var3 = var1.prepare();
      this.field26464.put(var1, var3);
      return var3;
   }

   public RenderTypeFeatureRendererGroupHooks() {
      this.field26465.defaultReturnValue(-2);
   }

   public int method11616(List<?> var1, Object var2) {
      int var3 = this.field26465.getInt(var2);
      if (var3 != -2) {
         return var3;
      }

      int var4 = var1.indexOf(var2);
      this.field26465.put((PreparedRenderType)var2, var4 == -1 ? var1.size() : var4);
      return var4;
   }
}
