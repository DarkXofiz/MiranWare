// Original binary: sg/ec/xaxdoqTxOJR3dTwG
package sg.ec;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class Nuker extends ClientModule {
   private static final double field25985 = 4.5;
   private static final double field25986 = 0;
   private final NumberSetting<Float> field25987;
   private final ToggleSetting field25988;
   private final ToggleSetting field25989;
   private final BlockBreakManager field25990;
   private BlockPos field25991;
   private static final String field25992 = "Радиус";
   private static final float field25993 = 5.0F;
   private static final String field25994 = "Копать под собой";
   private static final String field25995 = "Копать все";
   private static final String field25996 = "Nuker";
   private static final double field25997 = Double.MAX_VALUE;
   private static final double field25998 = 20.25;
   private static final double field25999 = 0.5;
   private static final double field26000 = 0.5;
   private static final double field26001 = 0.5;

   @Subscribe
   private void method11325(PlayerUpdateEvent var1) {
      if (mc.player != null && mc.level != null) {
         Vec3 var2 = mc.player.getEyePosition();
         boolean sx = this.field25989.method03022();
         List<Block> sxx = sx ? List.of() : this.method11329();
         if (this.field25991 == null || !this.method11331(this.field25991, method11327(var2, this.field25991), sx, sxx)) {
            this.field25991 = this.method11328(var2, sx, sxx);
         }

         if (this.field25991 == null || !this.field25990.method04892(this, this.field25991, BlockBreakManager.Nested147.UTILITY)) {
            this.method11330();
         }
      } else {
         this.method11330();
      }
   }

   @Subscribe
   private void method11326(PlayerInputEvent var1) {
      if (this.field25990.method04906(this)) {
         RotationManager.field14787 = true;
      }
   }

   public Nuker() {
      super(ModuleCategory.Misc, ModuleSubCategory.Utility);
      this.field25987 = new NumberSetting<Float>(field25992)
         .method10835(1.0F)
         .method10838(field25993)
         .method10834(1.0F)
         .method03017(2.0F)
         .method03023(this);
      this.field25988 = new ToggleSetting(field25994).method03014(false).method03023(this);
      this.field25989 = new ToggleSetting(field25995).method03014(true).method03023(this);
      this.field25990 = BlockBreakManager.INSTANCE;
      this.method03935(field25996);
   }

   private static double method11327(Vec3 var0, BlockPos var1) {
      return var0.distanceToSqr(var1.getX() + field25999, var1.getY() + field26000, var1.getZ() + field26001);
   }

   @Override
   public void method00245() {
      this.method11330();
      super.method00245();
   }

   private BlockPos method11328(Vec3 var1, boolean var2, List<Block> var3) {
      int var4 = this.field25987.method03022().intValue();
      int var5 = this.field25988.method03022() ? -var4 : 0;
      int var6 = Mth.floor(var1.x);
      int var7 = Mth.floor(var1.y);
      int var8 = Mth.floor(var1.z);
      MutableBlockPos var9 = new MutableBlockPos();
      BlockPos var10 = null;
      double var11 = field25997;

      for (int var13 = -var4; var13 <= var4; var13++) {
         for (int var14 = var5; var14 <= var4; var14++) {
            for (int var15 = -var4; var15 <= var4; var15++) {
               var9.set(var6 + var13, var7 + var14, var8 + var15);
               double var16 = method11327(var1, var9);
               if (!(var16 >= var11) && this.method11331(var9, var16, var2, var3)) {
                  var10 = var9.immutable();
                  var11 = var16;
               }
            }
         }
      }

      return var10;
   }

   private List<Block> method11329() {
      NukerCommand var1 = CommandManager.INSTANCE.method04650(NukerCommand.class);
      return var1 == null ? List.of() : var1.field24123;
   }

   private void method11330() {
      if (this.field25991 != null) {
         this.field25991 = null;
         this.field25990.method04904(this);
      }
   }

   private boolean method11331(BlockPos var1, double var2, boolean var4, List<Block> var5) {
      if (var2 > field25998) {
         return false;
      }

      BlockState var6 = mc.level.getBlockState(var1);
      return !var6.isAir() && !(var6.getDestroySpeed(mc.level, var1) < 0.0F) ? var4 || var5.contains(var6.getBlock()) : false;
   }
}
