// Original binary: sg/ec/WsuXQkWEY0J1ZN00
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;

// $VF: Compiled from s
public class ElytraHelper extends ClientModule {
   private static final int field13691 = 6;
   private final ToggleSetting field13692;
   private final ModeSetting field13693;
   private final KeyBindSetting field13694;
   private final KeyBindSetting field13695;
   private final ToggleSetting field13696;
   private final ToggleSetting field13697;
   private final ToggleSetting field13698;
   private boolean field13699;
   private boolean field13700;
   private static final double field13701 = 0;
   private static final int field13702 = 0;
   private static final int field13703 = 0;
   private static final int field13704 = 0;
   private static final int field13705 = 0;
   private int field13706;
   private int field13707;
   private int field13708;
   private int field13709;
   private boolean field13710;
   private int field13711;
   private InventoryActionSequence field13712;
   private static final String field13713 = "Авто Взлет";
   private static final String field13714 = "Режим взлёта";
   private static final String field13715 = "Легитный";
   private static final String field13716 = "Рейджовый";
   private static final String field13717 = "Легитный";
   private static final String field13718 = "Кнопка свапа";
   private static final String field13719 = "Кнопка фейера";
   private static final String field13720 = "Легитный свап";
   private static final String field13721 = "Легитное использование";
   private static final String field13722 = "Взлетать с левитацией";
   private static final String field13723 = "Elytra Helper";
   private static final String field13724 = "blocked-pending";
   private static final String field13725 = "no-target";
   private static final String field13726 = "rejected-busy";
   private static final String field13727 = "queued";
   private static final float field13728 = Float.MAX_VALUE;
   private static final float field13729 = Float.MAX_VALUE;
   private static final String field13730 = "Рейджовый";
   private static final String field13731 = "Рейджовый";
   private static final double field13732 = -0.6;

   public boolean method06047() {
      return this.method03937() && this.field13692.method05999() && this.method06066();
   }

   @Subscribe
   private void method06048(KeyInputEvent var1) {
      this.method06059(var1.method05887(), var1.method05884());
   }

   @Subscribe
   private void method06049(MouseButtonEvent var1) {
      this.method06059(var1.method06914(), var1.method06919());
   }

   private void method06050(Slot var1) {
      this.field13711 = 5;
      this.field13712 = this.field13696.method05999() ? DelayedInventoryActionManager.INSTANCE.method09007(var1.index, 6) : InventoryUtils.method06108(var1.index, 6);
      if (this.field13712 != null) {
         this.field13712.method07543();
      }
   }

   private Slot method06051() {
      Item[] var1 = new Item[]{Items.NETHERITE_CHESTPLATE, Items.DIAMOND_CHESTPLATE};

      for (Item var5 : var1) {
         Slot var6 = InventoryUtils.method06136(var5);
         if (var6 != null) {
            return var6;
         }
      }

      return null;
   }

   public void method06053() {
      if (mc.player != null) {
         if (this.method06065()) {
            if (false) {
               Object var10002 = null;
            }
         } else {
            boolean var1 = mc.player.getItemBySlot(EquipmentSlot.CHEST).getItem() == Items.ELYTRA;
            Slot var2;
            if (var1) {
               var2 = this.method06051();
               if (var2 == null) {
                  var2 = this.method06061();
               }
            } else {
               var2 = InventoryUtils.method06136(Items.ELYTRA);
            }

            if (var2 != null) {
               this.method06050(var2);
            }

            if (false && var2 != null && this.field13712 != null) {
               ;
            }
         }
      }
   }

   public void method06054() {
      if (mc.player != null) {
         if (mc.player.isFallFlying()) {
            Slot var1 = InventoryUtils.method06136(Items.FIREWORK_ROCKET);
            if (var1 != null) {
               if (this.field13697.method05999()) {
                  DelayedInventoryActionManager.INSTANCE.method09011(InteractionHand.OFF_HAND, var1);
               } else {
                  if (InventoryUtils.method06111(Items.FIREWORK_ROCKET, true) != -1) {
                     InventoryUtils.method06119();
                  } else {
                     InventoryUtils.method06097(var1.getItem(), field13728, field13729);
                  }
               }
            }
         }
      }
   }

   @Subscribe
   private void method06055(PostPlayerInputEvent var1) {
      if (mc.player != null) {
         if (mc.player.isFallFlying()) {
            this.field13708++;
         } else {
            this.field13708 = 0;
         }
      }
   }

   private boolean method06056() {
      return this.field13706 >= 1 && this.field13709 < 3 && !MovementUtils.method05721(mc.player) && this.method06064();
   }

   @Subscribe
   private void method06057(MobEffectVisibilityEvent var1) {
      if (mc.player != null) {
         if (this.field13698.method03022() && !mc.player.isFallFlying() && var1.method00609() == MobEffects.LEVITATION.value()) {
            var1.method05696();
         }
      }
   }

   @Subscribe
   private void method06058(ElytraStartEvent var1) {
      if (this.field13692.method05999() && this.method06066()) {
         if (!mc.player.onGround()) {
            if (this.field13711 <= 0) {
               if (this.field13693.method05600(field13731)) {
                  var1.method05131();
               } else if (this.method06056()) {
                  if (mc.player.input.keyPresses.jump() && !mc.player.getLastSentInput().jump()) {
                     var1.method05131();
                  }
               }
            }
         }
      }
   }

   public ElytraHelper() {
      super(ModuleCategory.Player, ModuleSubCategory.Main);
      this.field13692 = new ToggleSetting(field13713).method03017(false).method03023(this);
      this.field13693 = new ModeSetting(field13714)
         .method05597(field13715, field13716)
         .method03017(field13717)
         .method03025(() -> this.field13692.method05999())
         .method03023(this);
      this.field13694 = new KeyBindSetting(field13718).method03017(new KeyBinding()).method03023(this);
      this.field13695 = new KeyBindSetting(field13719).method03017(new KeyBinding()).method03023(this);
      this.field13696 = new ToggleSetting(field13720).method03017(false).method03023(this);
      this.field13697 = new ToggleSetting(field13721).method03017(false).method03023(this);
      this.field13698 = new ToggleSetting(field13722).method03017(false).method03025(() -> this.field13692.method05999()).method03023(this);
      this.field13699 = false;
      this.field13700 = false;
      Object var10001 = null;
      var10001 = null;
      this.field13707 = 2;
      this.method03935(field13723);
   }

   private void method06059(int var1, InputAction var2) {
      if (var2 != InputAction.RELEASE) {
         if (this.field13694.method03022().method05871() == var1) {
            this.field13699 = true;
         }

         if (this.field13695.method03022().method05871() == var1) {
            this.field13700 = true;
         }
      }
   }

   @Subscribe
   private void method06060(PlayerUpdateEvent var1) {
      if (mc.player != null) {
         if (this.field13711 > 0) {
            this.field13711--;
         }

         if (this.field13699) {
            this.method06053();
         }

         if (this.field13700) {
            this.method06054();
         }

         this.field13700 = false;
         this.field13699 = false;
      }
   }

   private Slot method06061() {
      if (mc.player == null) {
         return null;
      }

      AbstractContainerMenu var1 = mc.player.containerMenu;
      int var2 = method06068(var1.slots.size());

      for (int var3 = var2; var3 < var1.slots.size(); var3++) {
         Slot var4 = var1.getSlot(var3);
         if (var4.getItem().isEmpty()) {
            return var4;
         }
      }

      return null;
   }

   public void method06063() {
      if (mc.player != null) {
         boolean var1 = mc.player.isFallFlying();
         if (this.field13710 && !var1) {
            if (this.field13708 < 10) {
               this.field13709++;
            } else {
               this.field13709 = 0;
            }
         }

         this.field13710 = var1;
      }
   }

   private boolean method06064() {
      AABB var1 = mc.player.getBoundingBox().expandTowards(0.0, field13732, 0.0);
      return mc.player.level().noCollision(mc.player, var1);
   }

   private boolean method06065() {
      return this.field13712 != null && !this.field13712.method07546() && InventoryActionManager.INSTANCE.method10476();
   }

   private boolean method06066() {
      LocalPlayer var1 = mc.player;
      if (var1 == null) {
         return false;
      }

      if (!var1.isFallFlying() && !var1.isSpectator() && !var1.getAbilities().flying) {
         if (!var1.isPassenger() && !var1.onClimbable() && !var1.isInWater()) {
            if (var1.hasEffect(MobEffects.LEVITATION)) {
               return false;
            }

            for (EquipmentSlot var3 : EquipmentSlot.VALUES) {
               if (LivingEntity.canGlideUsing(var1.getItemBySlot(var3), var3)) {
                  return true;
               }
            }

            return false;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Subscribe(3)
   public void method06067(PlayerInputEvent var1) {
      if (this.field13692.method05999() && this.method06066()) {
         if (this.field13711 <= 0) {
            boolean var2 = mc.player.onGround();
            if (var2) {
               this.field13706 = 0;
               this.field13707 = 2;
               this.field13709 = 0;
            } else {
               this.field13706++;
            }

            if (this.field13693.method05600(field13730)) {
               if (var2 && !var1.method11162()) {
                  var1.method11173(true);
               }
            } else {
               if (this.field13707 < 2) {
                  this.field13707++;
               }

               boolean var3 = mc.player.getLastSentInput().jump();
               if (var2) {
                  if (!var1.method11162()) {
                     var1.method11173(true);
                  }
               } else if (this.method06056() && this.field13707 >= 2) {
                  if (var3) {
                     var1.method11173(false);
                  } else {
                     var1.method11173(true);
                     this.field13707 = 0;
                  }
               } else if (var3) {
                  var1.method11173(false);
               }

               var1.method11162();
            }
         }
      }
   }

   private static int method06068(int var0) {
      return Math.max(0, var0 - 37);
   }
}
