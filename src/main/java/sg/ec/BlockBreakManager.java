// Original binary: sg/ec/OoJDod2lAA4VFZYR
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;
import sg.mx.MultiPlayerGameModeMixin_1262;

// $VF: Compiled from s
public enum BlockBreakManager implements MinecraftAccess {
   INSTANCE;

   private static final int field10847 = 1;
   private static final int field10848 = 0;
   private static final float field10849 = 0;
   private static final float field10850 = 0;
   private final HitResultConstraint field10851 = new HitResultConstraint();
   private Object field10852;
   private BlockPos field10853;
   private int field10854 = -100;
   private int field10855 = -100;
   private int field10856 = -100;
   private float field10857;
   private BlockBreakManager.Nested148 field10858 = BlockBreakManager.Nested148.IDLE;
   private BlockBreakManager.Nested147 field10859 = BlockBreakManager.Nested147.COMBAT;
   private int field10860;
   private int field10861 = -100;
   private int field10862;
   private Action field10863;
   private BlockPos field10864;

   public void method04890() {
      EventBus.method00263(this);
   }

   public boolean method04891(Object var1, BlockPos var2) {
      return this.method04892(var1, var2, BlockBreakManager.Nested147.COMBAT);
   }

   public boolean method04892(Object var1, BlockPos var2, BlockBreakManager.Nested147 var3) {
      return this.method04893(var1, var2, var3, null);
   }

   public boolean method04893(Object var1, BlockPos var2, BlockBreakManager.Nested147 var3, Vec3 var4) {
      if (mc.player == null || mc.level == null || var2 == null) {
         return false;
      }

      if (this.field10852 != null && this.field10852 != var1) {
         return false;
      }

      if (method04895(var3)) {
         return false;
      }

      if (!var2.equals(this.field10853)) {
         this.field10853 = var2.immutable();
         this.field10857 = 0.0F;
         this.field10856 = mc.player.tickCount;
         this.field10858 = BlockBreakManager.Nested148.IDLE;
      }

      this.field10859 = var3;
      this.field10852 = var1;
      this.field10854 = mc.player.tickCount;
      this.field10855 = mc.player.tickCount;
      int var5 = this.method04897() ? var3.field10866 : var3.field10865;
      if (var5 < this.field10862) {
         RotationManager.method06568(this.field10862);
      }

      this.field10862 = var5;
      this.method04894(var1, var5, var4 == null ? this.method04923(this.field10853) : var4);
      return true;
   }

   private void method04894(Object var1, int var2, Vec3 var3) {
      Vector2f var4 = this.method04924(var3);
      if (this.field10859 == BlockBreakManager.Nested147.COMBAT) {
         BlockActionQueue.method11517(var1, var4, var2);
      } else {
         RotationManager.method06547(new Rotation(var4.x, var4.y), 180.0F, var2, false);
      }
   }

   private static boolean method04895(BlockBreakManager.Nested147 var0) {
      return var0.field10867 && mc.options.keyAttack.isDown();
   }

   public boolean method04896() {
      return this.field10853 != null && this.field10858 == BlockBreakManager.Nested148.MINING;
   }

   private boolean method04897() {
      if (!this.method04896()) {
         return false;
      }

      MultiPlayerGameModeMixin_1262 var1 = (MultiPlayerGameModeMixin_1262)(Object)mc.gameMode;
      boolean var2 = var1.getIsDestroying() && this.field10853.equals(var1.getDestroyBlockPos());
      return !var2 || this.method04900();
   }

   public int method04898() {
      return this.field10862;
   }

   public String method04899() {
      return this.field10863 == null ? "-" : this.field10863 + "@" + this.field10864.toShortString() + " gt=" + this.field10861;
   }

   public boolean method04900() {
      return this.method04896() && mc.player != null && mc.level != null ? this.field10857 + this.method04902(this.field10853) >= 1.0F : false;
   }

   public float method04901() {
      return this.field10853 != null && mc.player != null && mc.level != null ? this.method04902(this.field10853) : 0.0F;
   }

   private float method04902(BlockPos var1) {
      return mc.level.getBlockState(var1).getDestroyProgress(mc.player, mc.level, var1);
   }

   public void method04903(Object var1) {
      if (this.field10852 == var1 && this.field10853 != null && mc.player != null) {
         this.field10854 = mc.player.tickCount;
      }
   }

   public void method04904(Object var1) {
      if (this.field10852 == null || this.field10852 == var1) {
         this.method04926();
      }
   }

   public boolean method04905() {
      return this.field10853 != null;
   }

   public boolean method04906(Object var1) {
      return this.field10852 == var1 && this.field10853 != null;
   }

   public boolean method04907() {
      return this.field10853 != null
         && mc.player != null
         && mc.level != null
         && !mc.options.keyAttack.isDown()
         && method04925(mc.level.getBlockState(this.field10853))
         && this.method04921();
   }

   public boolean method04908() {
      return this.field10860 == this.field10861;
   }

   public boolean method04909() {
      if (!this.method04907() || mc.gameMode == null) {
         return false;
      } else if (mc.screen == null && mc.getOverlay() == null && mc.mouseHandler.isMouseGrabbed()) {
         return true;
      } else if (mc.player.isUsingItem()) {
         return true;
      } else if (mc.player.getMainHandItem().has(DataComponents.PIERCING_WEAPON)) {
         return true;
      } else if (!(mc.hitResult instanceof BlockHitResult var1 && this.field10853.equals(var1.getBlockPos()))) {
         return true;
      } else {
         if (mc.level.getBlockState(var1.getBlockPos()).isAir()) {
            return true;
         }

         if (mc.gameMode.continueDestroyBlock(var1.getBlockPos(), var1.getDirection())) {
            mc.player.swing(InteractionHand.MAIN_HAND);
         }

         return true;
      }
   }

   public void method04910() {
      if (this.field10853 != null && this.field10852 != null && mc.player != null) {
         if (mc.player.tickCount - this.field10855 <= 1) {
            this.field10851.method02874(this.field10853);
         }
      }
   }

   public void method04911() {
      this.field10851.method02876();
   }

   public BlockPos method04912() {
      return this.field10853;
   }

   public float method04913() {
      return this.field10857;
   }

   public BlockBreakManager.Nested148 method04914() {
      return this.field10858;
   }

   public boolean method04915() {
      return mc.player != null && this.field10853 != null && method04927(mc.player.tickCount, this.field10856) > 20;
   }

   @Subscribe
   private void method04916(HitResultEvent var1) {
      this.field10851.method02875(var1);
   }

   @Subscribe(0)
   private void method04917(TickEvent var1) {
      this.field10860++;
   }

   @Subscribe
   private void method04918(PacketEvent var1) {
      if (var1.method10899()) {
         if (var1.method10897() instanceof ServerboundPlayerActionPacket var2) {
            switch (var2.getAction()) {
               case START_DESTROY_BLOCK:
               case ABORT_DESTROY_BLOCK:
               case STOP_DESTROY_BLOCK:
                  this.field10861 = this.field10860;
                  this.field10863 = var2.getAction();
                  this.field10864 = var2.getPos();
            }
         }
      }
   }

   @Subscribe(3)
   private void method04919(PlayerUpdateEvent var1) {
      if (mc.player == null || mc.level == null || mc.gameMode == null) {
         this.method04926();
      } else if (this.field10853 != null) {
         if (method04895(this.field10859) || method04927(mc.player.tickCount, this.field10854) > 1) {
            this.method04926();
         } else if (!method04925(mc.level.getBlockState(this.field10853))) {
            this.field10858 = BlockBreakManager.Nested148.BROKEN;
         } else {
            this.method04922();
            if (!this.method04921()) {
               this.field10858 = this.method04915() ? BlockBreakManager.Nested148.STUCK : BlockBreakManager.Nested148.AIMING;
            } else {
               this.field10858 = this.method04915() ? BlockBreakManager.Nested148.STUCK : BlockBreakManager.Nested148.MINING;
            }
         }
      }
   }

   public int method04920() {
      return mc.gameMode == null ? 0 : ((MultiPlayerGameModeMixin_1262)(Object)mc.gameMode).getDestroyDelay();
   }

   private boolean method04921() {
      return mc.hitResult instanceof BlockHitResult var1 && this.field10853.equals(var1.getBlockPos());
   }

   private void method04922() {
      MultiPlayerGameModeMixin_1262 var1 = (MultiPlayerGameModeMixin_1262)(Object)mc.gameMode;
      float var2 = this.field10853.equals(var1.getDestroyBlockPos()) ? Mth.clamp(var1.getDestroyProgress(), 0.0F, 1.0F) : 0.0F;
      if (var2 > this.field10857 + 1.0E-6F) {
         this.field10856 = mc.player.tickCount;
      }

      this.field10857 = var2;
   }

   public Vec3 method04923(BlockPos var1) {
      return BlockPlacementManager.method07888() ? BlockPlacementManager.method07906(var1) : Vec3.atCenterOf(var1);
   }

   private Vector2f method04924(Vec3 var1) {
      Vector2f var2 = PlayerUtils.method11816(mc.player.getEyePosition(), var1);
      return BlockPlacementManager.method07888() ? BlockPlacementManager.method07910(var2) : var2;
   }

   private static boolean method04925(BlockState var0) {
      return !var0.isAir() && !(var0.getBlock() instanceof LiquidBlock);
   }

   private void method04926() {
      if (this.field10862 > 0) {
         RotationManager.method06568(this.field10862);
      }

      this.field10862 = 0;
      this.field10859 = BlockBreakManager.Nested147.COMBAT;
      this.field10851.method02876();
      this.field10852 = null;
      this.field10853 = null;
      this.field10854 = -100;
      this.field10855 = -100;
      this.field10856 = -100;
      this.field10857 = 0.0F;
      this.field10858 = BlockBreakManager.Nested148.IDLE;
   }

   private static int method04927(int var0, int var1) {
      int var2 = var0 - var1;
      return var2 < 0 ? Integer.MAX_VALUE : var2;
   }

   // $VF: Compiled from s
   public enum Nested147 {
      COMBAT(62, 65, true),
      UTILITY(999, 999, false);

      private final int field10865;
      private final int field10866;
      private final boolean field10867;

      Nested147(int var3, int var4, boolean var5) {
         this.field10865 = var3;
         this.field10866 = var4;
         this.field10867 = var5;
      }
   }

   // $VF: Compiled from s
   public enum Nested148 {
      IDLE,
      AIMING,
      MINING,
      BROKEN,
      STUCK;
   }
}
