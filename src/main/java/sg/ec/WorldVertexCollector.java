package sg.ec;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;

/**
 * TODO(port 1.21.11): 26.x SubmitNodeStorage tabanli toplayici yerine gecici koprusu.
 * Dunya cizimi yeni render hattina tasininca gercek toplayici geri gelecek.
 */
public final class WorldVertexCollector {
   private final MultiBufferSource source;

   public WorldVertexCollector(MultiBufferSource source) {
      this.source = source;
   }

   public void method07404() {
   }

   public int method07406() {
      return 0;
   }

   public VertexConsumer method07407(RenderType var1) {
      return this.source == null ? null : this.source.getBuffer(var1);
   }
}
