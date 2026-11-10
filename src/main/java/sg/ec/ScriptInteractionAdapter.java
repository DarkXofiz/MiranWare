// Original binary: sg/ec/2llgjkD1xKoikct8
package sg.ec;

import hex.script.api.Interaction;
import hex.script.api.Rotations;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class ScriptInteractionAdapter implements MinecraftAccess {
   private static final int field01096 = 40;
   private final EntityAimPointSampler field01097 = new EntityAimPointSampler();
   private final Rotations field01098 = new Rotations(
      this::method00590, this::method00588, this::method00586, this::method00592, RotationManager::method06558
   );
   private final Interaction field01099 = new Interaction(this::method00591, this::method00589, this::method00585, this::method00583, this::method00587);
   private static final double field01100 = 180.0;
   private static final float field01101 = 180.0F;
   private static final double field01102 = 0.5;
   private static final String field01103 = "nearest";
   private static final String field01104 = "center";
   private static final String field01105 = "multi";
   private static final double field01106 = 0.01;

   Interaction method00581() {
      return this.field01099;
   }

   Rotations method00582() {
      return this.field01098;
   }

   private double[] method00583(Object var1, String var2, double var3, boolean var5) {
      Entity var6 = ScriptEntitiesAdapter.method09073(var1);
      if (mc.player != null && var6 != null) {
         Vec3 var7 = switch (var2 == null ? field01103 : var2.toLowerCase()) {
            case field01104 -> var6.getBoundingBox().getCenter();
            case field01105 -> this.field01097.method01265(var6, var3);
            default -> this.method00584(var6, var3, var5);
         };
         return new double[]{var7.x, var7.y, var7.z};
      } else {
         return null;
      }
   }

   private Vec3 method00584(Entity var1, double var2, boolean var4) {
      Vec3 var5 = mc.player.getEyePosition();
      Vec3 var6 = var1.getBoundingBox().deflate(field01106).getCenter();
      Vec3 var7 = new Vec3(
         this.method00593(var5.x, var1.getBoundingBox().minX, var1.getBoundingBox().maxX),
         this.method00593(var5.y, var1.getBoundingBox().minY, var1.getBoundingBox().maxY),
         this.method00593(var5.z, var1.getBoundingBox().minZ, var1.getBoundingBox().maxZ)
      );
      return !var4 && var5.distanceTo(var7) > var2 ? var6 : var7;
   }

   private boolean method00585(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      if (mc.player != null && mc.gameMode != null) {
         BlockPos var7 = new BlockPos(var2, var3, var4);
         Direction var8 = Direction.values()[Math.max(0, Math.min(5, var5))];

         return switch (var1) {
            case 1 -> mc.gameMode.startDestroyBlock(var7, var8);
            case 2 -> mc.gameMode.continueDestroyBlock(var7, var8);
            default -> {
               Vec3 var9 = Vec3.atCenterOf(var7).relative(var8, field01102);
               InteractionHand var10 = var6 ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
               mc.gameMode.useItemOn(mc.player, var10, new BlockHitResult(var9, var8, var7, false));
               yield true;
            }
         };
      } else {
         return false;
      }
   }

   private float method00586(double var1, double var3, double var5) {
      if (mc.player == null) {
         return 0.0F;
      }

      float[] var7 = this.method00588(var1, var3, var5);
      Rotation var8 = new Rotation(mc.player.getYRot(), mc.player.getXRot());
      return (float)Math.min(field01100, var8.method09436(new Rotation(var7[0], var7[1])));
   }

   private float method00587(int var1) {
      if (mc.player == null) {
         return 0.0F;
      }

      return switch (var1) {
         case 1 -> mc.player.getAttackStrengthScale(0.0F);
         default -> mc.gameMode != null && mc.gameMode.isDestroying() ? 1.0F : 0.0F;
      };
   }

   private float[] method00588(double var1, double var3, double var5) {
      if (mc.player == null) {
         return new float[]{0.0F, 0.0F};
      }

      Rotation var7 = Rotation.method09438(new Vec3(var1, var3, var5).subtract(mc.player.getEyePosition()));
      return new float[]{var7.method09439(), var7.method09443()};
   }

   private boolean method00589(Object var1) {
      Entity var2 = ScriptEntitiesAdapter.method09073(var1);
      if (mc.player != null && mc.gameMode != null && var2 != null && var2.isAlive()) {
         mc.gameMode.attack(mc.player, var2);
         mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
         return true;
      } else {
         return false;
      }
   }

   private float method00590(int var1) {
      if (mc.player == null) {
         return 0.0F;
      }

      return switch (var1) {
         case 1 -> mc.player.getXRot();
         case 2 -> RotationManager.method06563();
         case 3 -> RotationManager.method06557();
         default -> mc.player.getYRot();
      };
   }

   private boolean method00591(int var1, boolean var2) {
      if (mc.player != null && mc.gameMode != null) {
         InteractionHand var3 = var2 ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
         switch (var1) {
            case 0:
               if (!(mc.hitResult instanceof EntityHitResult var6)) {
                  return false;
               }

               mc.gameMode.attack(mc.player, var6.getEntity());
               mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
               break;
            case 1:
               if (!(mc.hitResult instanceof BlockHitResult var4)) {
                  return false;
               }

               mc.gameMode.useItemOn(mc.player, var3, var4);
               break;
            case 2:
               mc.gameMode.releaseUsingItem(mc.player);
               break;
            case 3:
               if (mc.getConnection() == null) {
                  return false;
               }

               mc.getConnection().send(new ServerboundPlayerActionPacket(Action.SWAP_ITEM_WITH_OFFHAND, BlockPos.ZERO, Direction.DOWN));
               break;
            case 4:
               mc.player.swing(var3, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
               break;
            case 5:
               mc.gameMode.useItem(mc.player, var3);
               break;
            case 6:
               mc.gameMode.stopDestroyBlock();
               break;
            default:
               return false;
         }

         return true;
      } else {
         return false;
      }
   }

   private boolean method00592(float var1, float var2, float var3, int var4) {
      if (mc.player != null && mc.level != null) {
         int var5 = Math.max(0, Math.min(40, var4));
         float var6 = var3 <= 0.0F ? field01101 : var3;
         return RotationManager.method06547(new Rotation(var1, var2), var6, var5, false);
      } else {
         return false;
      }
   }

   private double method00593(double var1, double var3, double var5) {
      return var1 < var3 ? var3 : (var1 > var5 ? var5 : var1);
   }
}
