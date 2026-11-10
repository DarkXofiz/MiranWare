// Original binary: sg/ec/Ndtq4v0iuuF6asy6
package sg.ec;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Pos;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.StatusOnly;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap.Types;

// $VF: Compiled from s
@CommandInfo(name = "vclip", description = "")
public class VClipCommand extends AbstractCommand {
   private static final String field10292 = "up";
   private static final String field10293 = "down";
   private static final String field10294 = "value";
   private static final float field10295 = -5000.0F;
   private static final float field10296 = 5000.0F;
   private static final double field10297 = 10.0;
   private static final String field10298 = "value";

   private void method04709(double var1) {
      int var3 = Math.max((int)(Math.abs(var1) / field10297), 1);

      for (int var4 = 0; var4 < var3; var4++) {
         if (mc.player != null && mc.player.connection != null) {
            PlayerUtils.method11812(new StatusOnly(mc.player.onGround(), mc.player.horizontalCollision));
         }
      }

      PlayerUtils.method11812(new Pos(mc.player.getX(), mc.player.getY() + var1, mc.player.getZ(), mc.player.onGround(), mc.player.horizontalCollision));
      mc.player.setPos(mc.player.getX(), mc.player.getBlockY() + var1, mc.player.getZ());
   }

   private float method04711(BlockPos var1, boolean var2) {
      int var3 = var1.getX();
      int var4 = var1.getY();
      int var5 = var1.getZ();
      MutableBlockPos var6 = new MutableBlockPos();
      if (var2) {
         int var9 = mc.level.getHeight(Types.WORLD_SURFACE, var3, var5);

         for (int var10 = var4 + 1; var10 <= var9; var10++) {
            var6.set(var3, var10, var5);
            if (mc.level.getBlockState(var6).canBeReplaced()
               && mc.level.getBlockState(var6.above()).canBeReplaced()
               && mc.level.getBlockState(var6.below()).isRedstoneConductor(mc.level, var6.below())) {
               return var10 - var4;
            }
         }

         this.method01187(ChatFormatting.RED + "Не удалось найти безопасную позицию выше");
         return 0.0F;
      } else {
         int var7 = mc.level.getMinY();

         for (int var8 = var4 - 1; var8 >= var7; var8--) {
            var6.set(var3, var8, var5);
            if (mc.level.getBlockState(var6).is(Blocks.BEDROCK)) {
               this.method01187(ChatFormatting.RED + "Тут нельзя телепортироваться под землю");
               return 0.0F;
            }

            if (mc.level.getBlockState(var6).canBeReplaced()
               && mc.level.getBlockState(var6.above()).canBeReplaced()
               && mc.level.getBlockState(var6.below()).isRedstoneConductor(mc.level, var6.below())) {
               return var8 - var4;
            }
         }

         this.method01187(ChatFormatting.RED + "Не удалось найти безопасную позицию ниже");
         return 0.0F;
      }
   }

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var1.then(this.method01188(field10292).executes(var1x -> {
         double var2 = this.method04711(mc.player.blockPosition(), true);
         this.method04709(var2);
         return 1;
      }));
      var1.then(this.method01188(field10293).executes(var1x -> {
         double var2 = this.method04711(mc.player.blockPosition(), false);
         this.method04709(var2);
         return 1;
      }));
      var1.then(this.method01184(field10294, FloatArgumentType.floatArg(field10295, field10296)).executes(var1x -> {
         float var2 = (Float)var1x.getArgument(field10298, Float.class);
         this.method04709(var2);
         return 1;
      }));
   }
}
