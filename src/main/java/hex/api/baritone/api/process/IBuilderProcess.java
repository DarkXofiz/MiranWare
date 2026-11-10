// Original binary: hex/api/baritone/api/process/IBuilderProcess
package hex.api.baritone.api.process;

import hex.api.baritone.api.schematic.ISchematic;
import java.io.File;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public interface IBuilderProcess extends IBaritoneProcess {
   Optional<Integer> getMaxLayer();

   void build(String var1, ISchematic var2, Vec3i var3);

   @Deprecated
   default boolean build(String var1, BlockPos var2) {
      File var3 = new File(new File(Minecraft.getInstance().gameDirectory, "schematics"), var1);
      return this.build(var1, var3, var2);
   }

   boolean build(String var1, File var2, Vec3i var3);

   boolean isPaused();

   void buildOpenLitematic(int var1);

   void buildOpenSchematic();

   List<BlockState> getApproxPlaceable();

   void pause();

   Optional<Integer> getMinLayer();

   void resume();

   void clearArea(BlockPos var1, BlockPos var2);
}
