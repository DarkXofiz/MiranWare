// Original binary: sg/ec/XJu7m8Hasi86RyzX
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemOnPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class BotInteractionController {
   private static final int field13916 = 5;
   private final BotClient field13917;
   private final BotPlayerState field13918;
   private int field13919;
   private int field13920 = -1;
   private BlockPos field13921;
   private Direction field13922;
   private float field13923;
   private int field13924;
   private boolean field13925;

   public void method06244(Entity var1, InteractionHand var2) {
      if (var1 != null) {
         this.method06259();
         this.field13917.method00123(ServerboundInteractPacket.createInteractionPacket(var1, this.method06256(), var2, Vec3.ZERO));
      }
   }

   public void method06245() {
      this.field13925 = false;
      this.field13921 = null;
      this.field13922 = null;
      this.field13923 = 0.0F;
      this.field13924 = 0;
      this.field13920 = -1;
   }

   public void method06246(BlockHitResult var1, InteractionHand var2) {
      this.method06259();
      this.field13917.method00123(new ServerboundUseItemOnPacket(var2, var1, this.method06262()));
   }

   public void method06247(int var1) {
      this.field13924 = var1;
   }

   public void method06248() {
      if (this.field13924 > 0) {
         this.field13924--;
      }

      this.method06259();
   }

   public boolean method06249(BlockPos var1, Direction var2) {
      return this.method06264(var1, var2);
   }

   public void method06250(boolean var1) {
      this.field13925 = var1 && this.field13921 != null;
   }

   public void method06251() {
      BotLocalPlayer var1 = this.field13917.method00090().method07688();
      if (var1 != null) {
         this.field13917.method00123(new ServerboundPlayerCommandPacket(var1, Action.START_FALL_FLYING));
      }
   }

   public int method06252() {
      return this.field13919;
   }

   public void method06253(int var1) {
      this.field13919 = var1;
   }

   public void method06254(boolean var1, BlockPos var2, float var3, int var4) {
      this.field13925 = var1 && var2 != null;
      this.field13921 = this.field13925 ? var2.immutable() : null;
      this.field13922 = null;
      this.field13923 = this.field13925 ? var3 : 0.0F;
      this.field13924 = 0;
      this.field13920 = var4;
   }

   public boolean method06255() {
      return this.field13925;
   }

   private boolean method06256() {
      return this.field13917.method00089().method10870();
   }

   public boolean method06257(BlockPos var1, Direction var2) {
      return this.method06273(var1, var2);
   }

   private void method06258(BlockPos var1, Direction var2) {
      BotLocalPlayer var3 = this.field13917.method00090().method07688();
      int var4 = var3 == null ? this.method06262() : this.method06267(var3, var1);
      this.field13917
         .method00123(
            new ServerboundPlayerActionPacket(net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.STOP_DESTROY_BLOCK, var1, var2, var4)
         );
      this.field13925 = false;
      this.field13923 = 0.0F;
      this.field13924 = 5;
   }

   private void method06259() {
      int var1 = this.field13918.method07987();
      if (var1 != this.field13920) {
         this.field13920 = var1;
         this.field13917.method00123(new ServerboundSetCarriedItemPacket(var1));
      }
   }

   public void method06260() {
      this.field13917
         .method00123(
            new ServerboundPlayerActionPacket(
               net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.SWAP_ITEM_WITH_OFFHAND,
               BlockPos.ZERO,
               Direction.DOWN,
               this.method06262()
            )
         );
   }

   public float method06261() {
      return this.field13923;
   }

   private int method06262() {
      return ++this.field13919;
   }

   public BlockPos method06263() {
      return this.field13921;
   }

   private boolean method06264(BlockPos var1, Direction var2) {
      if (this.field13924 > 0) {
         return false;
      }

      BotLocalPlayer var3 = this.field13917.method00090().method07688();
      if (var3 == null) {
         return false;
      }

      var1 = var1.immutable();
      this.method06259();
      if (this.field13918.method07950() == GameType.CREATIVE) {
         this.field13917
            .method00123(
               new ServerboundPlayerActionPacket(
                  net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK, var1, var2, this.method06267(var3, var1)
               )
            );
         this.field13924 = 5;
         return true;
      }

      if (this.field13925 && var1.equals(this.field13921)) {
         return this.method06273(var1, var2);
      }

      if (this.field13925 && this.field13921 != null) {
         this.field13917
            .method00123(
               new ServerboundPlayerActionPacket(
                  net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.ABORT_DESTROY_BLOCK, this.field13921, Direction.DOWN, 0
               )
            );
      }

      BlockState var4 = var3.level().getBlockState(var1);
      if (var4.isAir()) {
         this.field13925 = false;
         return false;
      }

      boolean var5 = var4.getDestroyProgress(var3, var3.level(), var1) >= 1.0F;
      int var6 = var5 ? this.method06267(var3, var1) : this.method06262();
      this.field13917
         .method00123(
            new ServerboundPlayerActionPacket(net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK, var1, var2, var6)
         );
      this.field13921 = var1;
      this.field13922 = var2;
      this.field13923 = 0.0F;
      if (var5) {
         this.field13925 = false;
         this.field13924 = 5;
      } else {
         this.field13925 = true;
      }

      return true;
   }

   public void method06265(InteractionHand var1) {
   }

   public void method06266() {
      if (this.field13925) {
         if (this.field13921 != null) {
            this.field13917
               .method00123(
                  new ServerboundPlayerActionPacket(
                     net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.ABORT_DESTROY_BLOCK, this.field13921, Direction.DOWN, 0
                  )
               );
         }

         this.field13925 = false;
         this.field13923 = 0.0F;
      }
   }

   private int method06267(BotLocalPlayer var1, BlockPos var2) {
      BotClientLevel var3 = (BotClientLevel)var1.level();
      this.field13919 = var3.predictBlockRemoval(var2, var1, this.field13919);
      return this.field13919;
   }

   public void method06268(Entity var1) {
      if (var1 != null) {
         this.method06274(var1.getId());
      }
   }

   public void method06269(InteractionHand var1) {
      this.method06259();
      this.field13917.method00123(new ServerboundUseItemPacket(var1, this.method06262(), this.field13918.method08008(), this.field13918.method08003()));
   }

   public BotInteractionController(BotClient var1) {
      this.field13917 = var1;
      this.field13918 = var1.method00070();
   }

   public void method06270() {
      this.field13917
         .method00123(
            new ServerboundPlayerActionPacket(
               net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.RELEASE_USE_ITEM, BlockPos.ZERO, Direction.DOWN, this.method06262()
            )
         );
   }

   public void method06271(boolean var1) {
      net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action var2 = var1
         ? net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.DROP_ALL_ITEMS
         : net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action.DROP_ITEM;
      this.field13917.method00123(new ServerboundPlayerActionPacket(var2, BlockPos.ZERO, Direction.DOWN, this.method06262()));
   }

   public void method06272(int var1) {
      if (var1 >= 0 && var1 < 9) {
         this.field13918.method07979(var1);
         this.method06259();
      }
   }

   private boolean method06273(BlockPos var1, Direction var2) {
      var1 = var1.immutable();
      BotLocalPlayer var3 = this.field13917.method00090().method07688();
      if (var3 == null) {
         return false;
      }

      if (this.field13924 > 0) {
         return false;
      }

      if (this.field13918.method07950() == GameType.CREATIVE) {
         return this.method06264(var1, var2);
      }

      if (this.field13925 && var1.equals(this.field13921)) {
         BlockState var4 = var3.level().getBlockState(var1);
         if (var4.isAir()) {
            this.field13925 = false;
            return false;
         }

         this.method06259();
         this.field13923 = this.field13923 + var4.getDestroyProgress(var3, var3.level(), var1);
         if (this.field13923 >= 1.0F) {
            this.method06258(var1, var2);
         }

         return true;
      } else {
         return this.method06264(var1, var2);
      }
   }

   public void method06274(int var1) {
      this.method06259();
      var hex$atk = CompatPackets.attack(this.field13917.method00090().method07688(), var1);
      if (hex$atk != null) {
         this.field13917.method00123(hex$atk);
      }
      this.method06265(InteractionHand.MAIN_HAND);
      BotLocalPlayer var2 = this.field13917.method00090().method07688();
      if (var2 != null) {
         var2.resetAttackStrengthTicker();
         var2.armSprintResync();
      }
   }

   public void method06275(Entity var1, InteractionHand var2, Vec3 var3) {
      if (var1 != null) {
         this.method06259();
         Vec3 var4 = var3.subtract(var1.getX(), var1.getY(), var1.getZ());
         this.field13917.method00123(ServerboundInteractPacket.createInteractionPacket(var1, this.method06256(), var2, var4));
      }
   }
}
