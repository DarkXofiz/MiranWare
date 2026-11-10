// Original binary: sg/ec/Yazg9BpS53cxNKDf
package sg.ec;

import hex.script.api.Entities;
import hex.script.api.Inventory;
import hex.script.api.Player;
import hex.script.api.World;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemCooldowns.CooldownInstance;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public final class ScriptWorldAdapter implements MinecraftAccess {
   private static final EquipmentSlot[] field14820 = new EquipmentSlot[]{EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.CHEST, EquipmentSlot.HEAD};
   private final ScriptBlockQuery field14821 = new ScriptBlockQuery();
   private final World field14822 = new World(
      this.field14821::method10958,
      this::method06584,
      this::method06588,
      this::method06585,
      this::method06586,
      this.field14821::method10962,
      this.field14821::method10959,
      this.field14821::method10957,
      this.field14821::method10953,
      this.field14821::method10956
   );
   private final Inventory field14823 = new Inventory(this::method06594, this::method06582, this::method06590, this::method06589);
   private final Player field14824;
   private static final long field14825 = 24000L;

   private boolean method06580(int var1) {
      if (mc.player == null) {
         return false;
      }

      return switch (var1) {
         case 1 -> mc.player.onGround();
         case 2 -> mc.player.isShiftKeyDown();
         case 3 -> mc.player.isSprinting();
         case 4 -> mc.player.isInWater();
         case 5 -> mc.player.getAbilities().flying;
         case 6 -> mc.player.isCreative();
         case 7 -> mc.player.isSpectator();
         case 8 -> mc.player.isFallFlying();
         case 9 -> mc.player.isUsingItem();
         case 10 -> mc.player.input != null && mc.player.input.getMoveVector().lengthSquared() > 0.0F;
         case 11 -> mc.player.getMainArm() == HumanoidArm.LEFT;
         case 12 -> mc.player.isPassenger();
         case 13 -> mc.player.isUsingItem() && mc.player.getUsedItemHand() == InteractionHand.OFF_HAND;
         default -> true;
      };
   }

   private String method06581() {
      return mc.player == null ? "" : mc.player.getName().getString();
   }

   private int method06582(int var1) {
      if (mc.player == null) {
         return 0;
      }

      return switch (var1) {
         case 1 -> mc.player.containerMenu != mc.player.inventoryMenu ? 1 : 0;
         case 2 -> mc.player.containerMenu.containerId;
         default -> mc.player.getInventory().getSelectedSlot();
      };
   }

   private double[] method06583(double var1, double var3, double var5) {
      if (mc.player != null && mc.level != null) {
         Vec3 var7 = new Vec3(var1, var3, var5);
         AABB var8 = mc.player.getBoundingBox();
         var var9 = mc.level.getEntityCollisions(mc.player, var8.expandTowards(var7));
         Vec3 var10 = Entity.collideBoundingBox(mc.player, var7, var8, mc.level, var9);
         return new double[]{var10.x, var10.y, var10.z};
      } else {
         return null;
      }
   }

   ScriptWorldAdapter(Entities var1) {
      this.field14824 = new Player(this::method06591, this::method06580, this::method06581, this::method06595, this::method06583, this.field14823, var1);
   }

   private double method06584(int var1) {
      if (mc.level == null) {
         return 0.0;
      }

      return switch (var1) {
         case 1 -> mc.level.getLevelData().getGameTime();
         case 2 -> mc.level.getMinY();
         case 3 -> mc.level.getMaxY();
         default -> mc.level.getLevelData().getGameTime() % field14825;
      };
   }

   private String method06585() {
      return mc.level == null ? "" : String.valueOf(mc.level.dimension().identifier());
   }

   private double[] method06586(double var1, boolean var3) {
      if (mc.player != null && mc.level != null) {
         Vec3 var4 = mc.player.getEyePosition();
         Vec3 var5 = var4.add(mc.player.getViewVector(1.0F).scale(Math.max(0.0, var1)));
         BlockHitResult var6 = mc.level.clip(new ClipContext(var4, var5, Block.OUTLINE, var3 ? Fluid.ANY : Fluid.NONE, mc.player));
         if (var6 != null && var6.getType() == Type.BLOCK) {
            BlockPos var7 = var6.getBlockPos();
            return new double[]{var7.getX(), var7.getY(), var7.getZ(), var6.getDirection().ordinal()};
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   World method06587() {
      return this.field14822;
   }

   private boolean method06588(int var1) {
      if (mc.level == null) {
         return false;
      }

      return switch (var1) {
         case 1 -> mc.level.isRaining();
         case 2 -> mc.level.isThundering();
         default -> true;
      };
   }

   private int method06589(int var1, String var2) {
      if (mc.player != null) {
         net.minecraft.world.entity.player.Inventory var3 = mc.player.getInventory();
         if (var1 == 3) {
            int var10 = 0;

            for (int var11 = 0; var11 < 36; var11++) {
               if (var3.getItem(var11).isEmpty()) {
                  var10++;
               }
            }

            return var10;
         } else {
            ItemStack var4 = ScriptRenderResources.method08787(var2);
            if (var4.isEmpty()) {
               return var1 == 0 ? 0 : -1;
            }

            Item var5 = var4.getItem();
            int var6 = var1 == 2 ? 9 : 41;
            int var7 = 0;

            for (int var8 = 0; var8 < var6; var8++) {
               ItemStack var9 = var3.getItem(var8);
               if (!var9.isEmpty() && var9.getItem() == var5) {
                  if (var1 != 0) {
                     return var8;
                  }

                  var7 += var9.getCount();
               }
            }

            return var1 == 0 ? var7 : -1;
         }
      } else {
         return var1 != 1 && var1 != 2 ? 0 : -1;
      }
   }

   private float method06590(String var1) {
      if (mc.player == null) {
         return 0.0F;
      }

      ItemStack var2 = ScriptRenderResources.method08787(var1);
      if (var2.isEmpty()) {
         return 0.0F;
      }

      ItemCooldowns var3 = mc.player.getCooldowns();
      CooldownInstance var4 = var3.cooldowns.get(var3.getCooldownGroup(var2));
      return var4 == null ? 0.0F : Math.max(0.0F, var4.endTime() - var3.tickCount);
   }

   private double method06591(int var1) {
      if (mc.player == null) {
         return 0.0;
      }

      return switch (var1) {
         case 1 -> mc.player.getY();
         case 2 -> mc.player.getZ();
         case 3 -> mc.player.getYRot();
         case 4 -> mc.player.getXRot();
         case 5 -> PlayerUtils.method11820(mc.player);
         case 6 -> PlayerUtils.method11805(mc.player);
         case 7 -> mc.player.getAbsorptionAmount();
         case 8 -> mc.player.getFoodData().getFoodLevel();
         case 9 -> mc.player.getFoodData().getSaturationLevel();
         case 10 -> mc.player.experienceProgress;
         case 11 -> mc.player.experienceLevel;
         case 12 -> mc.player.getAirSupply();
         case 13 -> mc.player.getDeltaMovement().x;
         case 14 -> mc.player.getDeltaMovement().y;
         case 15 -> mc.player.getDeltaMovement().z;
         case 16 -> mc.player.fallDistance;
         case 17 -> mc.player.getId();
         case 18 -> mc.player.getTicksUsingItem();
         default -> mc.player.getX();
      };
   }

   Inventory method06592() {
      return this.field14823;
   }

   Player method06593() {
      return this.field14824;
   }

   private hex.script.api.Item method06594(int var1) {
      if (mc.player == null) {
         return new hex.script.api.Item();
      }

      ItemStack var2;
      if (var1 == 40) {
         var2 = mc.player.getOffhandItem();
      } else if (var1 >= 36) {
         var2 = mc.player.getItemBySlot(field14820[var1 - 36]);
      } else {
         var2 = mc.player.getInventory().getItem(var1);
      }

      return ScriptEntitiesAdapter.method09078(var2);
   }

   private double[] method06595(float var1) {
      return mc.player == null
         ? null
         : new double[]{
            mc.player.xOld + (mc.player.getX() - mc.player.xOld) * var1,
            mc.player.yOld + (mc.player.getY() - mc.player.yOld) * var1,
            mc.player.zOld + (mc.player.getZ() - mc.player.zOld) * var1
         };
   }
}
