// Original binary: sg/mx/k8AjSk8TO4bLpXwO
package sg.mx;

import java.util.List;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import sg.ec.ParticleSpriteSelector;

// $VF: Compiled from s
@Mixin(targets = "net.minecraft.client.particle.ParticleResources$MutableSpriteSet")
public abstract class ParticleResources$MutableSpriteSetMixin {
   @Shadow
   private List<TextureAtlasSprite> sprites;

   @Overwrite
   public TextureAtlasSprite get(int var1, int var2) {
      return ParticleSpriteSelector.method01248(this.sprites, var1, var2);
   }

   @Overwrite
   public TextureAtlasSprite get(RandomSource var1) {
      return ParticleSpriteSelector.method01247(this.sprites, var1);
   }

   @Overwrite
   public TextureAtlasSprite first() {
      return ParticleSpriteSelector.method01250(this.sprites);
   }
}
