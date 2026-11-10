// Original binary: sg/mx/MpQ6sg3MkHttr3zD
package sg.mx;

import java.util.List;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelPart.Cube;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ModelPart.class)
public interface ModelPartMixin {
   @Accessor("cubes")
   List<Cube> cuboids();
}
