// Original binary: sg/ec/wHhrTwDlAukVybCw
package sg.ec;

import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class ItemEntityRenderStateHooks {
   private float field25150;
   private float field25151;
   private boolean field25152;
   private boolean field25153;
   private boolean field25154;

   private static boolean method11183(ItemEntity var0) {
      BlockState var1 = var0.level().getBlockState(var0.blockPosition());
      return var1.is(Blocks.SNOW) || var1.is(Blocks.SOUL_SAND) || var1.is(Blocks.MUD);
   }

   public float method11184() {
      return this.field25150;
   }

   public boolean method11185() {
      return this.field25152;
   }

   public float method11186() {
      return this.field25151;
   }

   public boolean method11187() {
      return this.field25153;
   }

   public void method11188(ItemEntityRenderState var1, ItemEntity var2) {
      if (!ItemPhysics.method04428()) {
         this.field25152 = true;
      } else {
         this.field25154 = var1.item.usesBlockLight();
         ItemPhysicsRenderer.method06932(var2, var1);
         this.field25152 = false;
         this.field25153 = method11183(var2);
         this.field25150 = var2.getXRot();
         this.field25151 = var2.getYRot();
      }
   }

   public boolean method11189() {
      return this.field25154;
   }
}
