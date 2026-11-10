// Original binary: sg/ec/EJzpTGdFVi1ZREAZ
package sg.ec;

import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ThrowablePotionItem;
import net.minecraft.world.item.alchemy.PotionContents;

// $VF: Compiled from s
public class AutoPotion extends ClientModule {
   private static final String field07065 = "Сила";
   private static final String field07066 = "field07066";
   private static final String field07067 = "field07067";
   private final MultiToggleSetting field07068;
   private final ElapsedTimer field07069;
   private boolean field07070;
   private static final String field07071 = "Кидать зелья";
   private static final String field07072 = "Сила";
   private static final String field07073 = "Скорость";
   private static final String field07074 = "Огнестойкость";
   private static final String field07075 = "Auto Potion";
   private static final long field07076 = 500L;
   private static final String field07077 = "Сила";
   private static final String field07078 = "Скорость";
   private static final String field07079 = "Огнестойкость";
   private static final float field07080 = 80.0F;
   private static final float field07081 = 9999.0F;
   private static final int field07082 = 99999;

   @Subscribe
   public void method03228(PreMovementPacketEvent var1) {
      if (!this.field07070 && mc.player.onGround() && this.field07069.method04699(field07076) && (!mc.player.isUsingItem() || mc.player.isBlocking())) {
         if (!AutoTotem.method08643()) {
            boolean var2 = this.field07068.method04520(field07077);
            boolean sx = this.field07068.method04520(field07078);
            boolean sxx = this.field07068.method04520(field07079);
            int sxxx = this.method03232(MobEffects.STRENGTH.value());
            int sxxxx = this.method03232(MobEffects.SPEED.value());
            int sxxxxx = this.method03232(MobEffects.FIRE_RESISTANCE.value());
            boolean sxxxxxx = ItemHelper.method07868(mc.player.getEffect(MobEffects.STRENGTH), 20);
            boolean sxxxxxxx = ItemHelper.method07868(mc.player.getEffect(MobEffects.SPEED), 20);
            boolean sxxxxxxxx = ItemHelper.method07868(mc.player.getEffect(MobEffects.FIRE_RESISTANCE), 20);
            if (var2 && !sxxxxxx && sxxx != -1 || sx && !sxxxxxxx && sxxxx != -1 || sxx && !sxxxxxxxx && sxxxxx != -1) {
               this.field07070 = true;
            }

            if (this.field07070) {
               AtomicBoolean sxxxxxxxxx = new AtomicBoolean(false);
               InventoryActionManager.INSTANCE.method10470(() -> this.method03233(var1), 1, false).method07539(1).method07550(() -> {
                  try {
                     if (var2 && sxxx != -1 && !sxxxxxx) {
                        sxxxxxxxxx.set(this.method03234(sxxx, 5));
                     }

                     if (sx && sxxxx != -1 && !sxxxxxxx) {
                        sxxxxxxxxx.set(this.method03234(sxxxx, 6));
                     }

                     if (sxx && sxxxxx != -1 && !sxxxxxxxx) {
                        sxxxxxxxxx.set(this.method03234(sxxxxx, 7));
                     }

                     this.field07069.method04694();
                  } finally {
                     this.field07070 = false;
                  }
               });
            }
         }
      }
   }

   public AutoPotion() {
      super(ModuleCategory.Player, ModuleSubCategory.Main);
      this.field07068 = new MultiToggleSetting(field07071)
         .method04517(NamedOption.method08077(field07072, true))
         .method04517(NamedOption.method08077(field07073, true))
         .method04517(NamedOption.method08077(field07074, false))
         .method03023(this);
      this.field07069 = new ElapsedTimer();
      this.field07070 = false;
      this.method03935(field07075);
   }

   private static boolean method03230(int var0) {
      return var0 >= 0 && var0 <= 8;
   }

   private boolean method03231(ItemStack var1, MobEffect var2) {
      if (!var1.isEmpty() && var1.getItem() instanceof ThrowablePotionItem) {
         PotionContents var3 = var1.get(DataComponents.POTION_CONTENTS);
         if (var3 != null) {
            for (MobEffectInstance var5 : var3.getAllEffects()) {
               if (var5.getEffect().value() == var2) {
                  return true;
               }
            }

            var var7 = var3.getAllEffects();
            if (var7 != null) {
               for (MobEffectInstance var6 : var7) {
                  if (var6.getEffect().value() == var2) {
                     return true;
                  }
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private int method03232(MobEffect var1) {
      if (mc.player == null) {
         return -1;
      }

      for (int var2 = 0; var2 < mc.player.getInventory().getContainerSize(); var2++) {
         ItemStack var3 = mc.player.getInventory().getItem(var2);
         if (var3.getItem() instanceof ThrowablePotionItem && this.method03231(var3, var1)) {
            return var2;
         }
      }

      return -1;
   }

   private void method03233(PreMovementPacketEvent var1) {
      if (mc.player != null) {
         float var2 = field07080;
         var1.method07309(var2);
         RotationManager.method06547(new Rotation(mc.player.getYRot(), var2), field07081, field07082, false);
      }
   }

   boolean method03234(int var1, int var2) {
      if (mc.gameMode == null || mc.player == null) {
         return false;
      } else if (method03230(var1)) {
         mc.getConnection().send(new ServerboundSetCarriedItemPacket(var1));
         InventoryUtils.method06142(InteractionHand.MAIN_HAND, mc.player.getYRot(), mc.player.getXRot(), false);
         mc.getConnection().send(new ServerboundSetCarriedItemPacket(mc.player.getInventory().getSelectedSlot()));
         return false;
      } else {
         InventoryUtils.method06123(var1, 40, ClickType.SWAP, false);
         InventoryUtils.method06142(InteractionHand.OFF_HAND, mc.player.getYRot(), mc.player.getXRot(), false);
         InventoryUtils.method06123(var1, 40, ClickType.SWAP, false);
         return true;
      }
   }

   @Override
   public void method00382() {
      this.field07070 = false;
      super.method00382();
   }

   public boolean method03236() {
      return this.field07070;
   }
}
