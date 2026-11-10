// Original binary: sg/ec/CKlZsxgyrFDrRLOb
package sg.ec;

import java.util.List;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.syncher.SynchedEntityData.DataValue;
import net.minecraft.world.effect.MobEffects;

// $VF: Compiled from s
public class AutoSprint extends ClientModule {
   private final ToggleSetting field06794;
   private final ToggleSetting field06795;
   private final ToggleSetting field06796;
   private static final int field06797 = 4;
   public static final int field06798 = 0;
   private final SprintStateTracker field06799;
   private int field06800;
   private int field06801;
   private static final String field06802 = "Сброс 1.20 и ниже";
   private static final String field06803 = "Сохранять спринт";
   private static final String field06804 = "Сброс для RW";
   private static final String field06805 = "Auto Sprint";
   private static final float field06806 = 0.8F;

   @Subscribe
   private void method02963(CanSprintEvent var1) {
      if (var1.method04672() == null) {
         if (mc.player != null) {
            mc.options.keySprint.setDown(true);
            boolean var2 = this.field06794.method05999() ? this.method02965() : mc.player.input.keyPresses.forward();
            boolean sx = !mc.player.isPassenger() || mc.player.getVehicle().canSprint() && mc.player.getVehicle().isLocalInstanceAuthoritative();
            boolean sxx = method02973(
               mc.player.isUsingItem(),
               mc.player.hasEffect(MobEffects.BLINDNESS),
               sx,
               mc.player.isFallFlying(),
               mc.player.isMovingSlowly(),
               mc.player.isUnderWater(),
               mc.player.isInWater(),
               mc.player.horizontalCollision,
               mc.player.minorHorizontalCollision
            );
            var1.method04669(var2 && sxx && !mc.player.isSprinting());
         }
      }
   }

   @Subscribe
   private void method02964(SprintSyncEvent var1) {
      if (this.field06800 > 0) {
         this.field06800--;
      }

      if (this.field06801 > 0) {
         this.field06801--;
      }

      this.field06799.method04929(mc.player);
   }

   private boolean method02965() {
      return mc.player.isUnderWater() ? mc.player.input.hasForwardImpulse() : mc.player.input.getMoveVector().y >= field06806;
   }

   public boolean method02966(LocalPlayer var1) {
      return this.method03937() && this.field06796.method05999() && var1.isInWater();
   }

   public AutoSprint() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field06794 = new ToggleSetting(field06802).method03017(false).method03023(this);
      this.field06795 = new ToggleSetting(field06803).method03017(false).method03025(() -> !this.field06794.method05999()).method03023(this);
      this.field06796 = new ToggleSetting(field06804).method03017(false).method03023(this);
      this.field06799 = new SprintStateTracker();
      this.method03935(field06805);
   }

   @Subscribe
   private void method02967(AttackEntityEvent var1) {
      if (var1.method09431() == AttackEntityEvent.Nested264.POST) {
         this.field06799.method04930(mc.player);
      }
   }

   @Subscribe
   public void method02968(PlayerUpdateEvent var1) {
      if (this.method02972()) {
         if (mc.player.isSprinting()) {
            mc.player.setSprinting(false);
            this.field06800 = 4;
         }
      }
   }

   @Subscribe
   private void method02969(PlayerInputEvent var1) {
      if (this.field06801 > 0) {
         var1.method11174(false);
      }

      if (this.field06800 > 0) {
         var1.method11168();
         var1.method11174(false);
      }
   }

   public void method02970(LocalPlayer var1, List<DataValue<?>> var2) {
      if (this.method02966(var1) && this.field06799.method04932(var1, var2)) {
         var1.setSprinting(false);
         this.field06801 = 1;
      }
   }

   @Override
   public void method00245() {
      this.field06800 = 0;
      this.field06801 = 0;
      this.field06799.method04928();
      super.method00245();
   }

   @Subscribe
   private void method02971(PlayerMovementActionEvent var1) {
      if (this.field06795.method05999()) {
         if (!this.field06794.method05999()) {
            if (mc.player != null) {
               if (mc.player.isInWater()) {
                  var1.method05695(true);
               }
            }
         }
      }
   }

   private boolean method02972() {
      return this.field06794.method05999() && mc.player != null && mc.player.isInWater() && !mc.player.isUnderWater();
   }

   private static boolean method02973(
      boolean var0, boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8
   ) {
      return !var0 && !var1 && var2 && !var3 && (!var4 || var5) && (!var6 || var5) && !var7 && !var8;
   }

   @Subscribe
   private void method02975(SprintStateEvent var1) {
      if (this.field06800 > 0 || this.field06801 > 0 || this.method02972()) {
         var1.method03879(false);
      }
   }
}
