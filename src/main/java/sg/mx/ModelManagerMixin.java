// Original binary: sg/mx/ppC1VB1Hm9QE1SzS
package sg.mx;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockStateModelSet;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.util.LightCoordsUtil;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.ModelManagerAccess;

// $VF: Compiled from s
@Mixin(ModelManager.class)
public abstract class ModelManagerMixin implements ModelManagerAccess {
   private static final long field28040 = 42L;

   @Shadow
   public abstract BlockStateModelSet getBlockStateModelSet();

   @Unique
   @Override
   public void renderSingleBlockWithEmission(BlockState var1, PoseStack var2, SubmitNodeCollector var3, int var4, ClientLevel var5, AbstractClientPlayer var6) {
      if (var1.getRenderShape() != RenderShape.INVISIBLE) {
         int var7 = LightCoordsUtil.withBlock(var4, Math.max(LightCoordsUtil.block(var4), var1.getLightEmission()));
         BlockStateModel var8 = this.getBlockStateModelSet().get(var1);
         ArrayList var9 = new ArrayList<>();
         var8.collectParts(RandomSource.create(field28040), var9);
         int[] var10 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
         var3.submitBlockModel(var2, Sheets.cutoutBlockItemSheet(), var9, var10, var7, OverlayTexture.NO_OVERLAY, 0);
      }
   }

}
