// Original binary: sg/ec/2IqLb725gYQYFZmL
package sg.ec;

import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import org.joml.Vector4fc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $VF: Compiled from s
public final class GuiGpuRenderer {
   private static final Logger field00744 = LoggerFactory.getLogger(GuiGpuRenderer.field00751);
   private static final List<GuiGpuRenderer> field00745 = new ArrayList<>(2);
   private boolean field00746;
   private RenderPass field00747;
   private GpuTextureView field00748;
   private GpuTextureView field00749;
   private static final String field00750 = "Слитый рендер-пасс не закрылся, кадр мог потерять отрисовку";
   private static final String field00751 = "MiranWare";

   public void method00366() {
      this.method00371();
      this.field00746 = false;
   }

   public void method00367() {
      this.method00371();
      this.field00746 = true;
   }

   public GuiGpuRenderer() {
      field00745.add(this);
   }

   public static void method00368() {
      for (int var0 = 0; var0 < field00745.size(); var0++) {
         field00745.get(var0).method00371();
      }
   }

   public RenderPass method00369(
      CommandEncoder var1, Supplier<String> var2, GpuTextureView var3, Optional<Vector4fc> var4, GpuTextureView var5, OptionalDouble var6
   ) {
      if (!this.field00746) {
         return var1.createRenderPass(var2, var3, var4, var5, var6);
      } else {
         boolean var7 = var4.isPresent() || var6.isPresent();
         if (this.field00747 != null && !var7 && var3 == this.field00748 && var5 == this.field00749) {
            this.field00747.disableScissor();
            return this.field00747;
         } else {
            this.method00371();
            RenderPass var8 = var1.createRenderPass(var2, var3, var4, var5, var6);
            this.field00747 = var8;
            this.field00748 = var3;
            this.field00749 = var5;
            return var8;
         }
      }
   }

   public void method00370(RenderPass var1) {
      if (!this.field00746 || var1 != this.field00747) {
         var1.close();
      }
   }

   public void method00371() {
      RenderPass var1 = this.field00747;
      if (var1 != null) {
         this.field00747 = null;
         this.field00748 = null;
         this.field00749 = null;

         try {
            var1.close();
         } catch (Throwable var3) {
            field00744.error(field00750, var3);
         }
      }
   }

   public boolean method00372() {
      return this.field00746;
   }
}
