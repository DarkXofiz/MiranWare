// Original binary: sg/ec/FKZiDWYJL3ov3b8Y
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public interface ModelManagerAccess {
   void renderSingleBlockWithEmission(BlockState var1, PoseStack var2, SubmitNodeCollector var3, int var4, ClientLevel var5, AbstractClientPlayer var6);
}
