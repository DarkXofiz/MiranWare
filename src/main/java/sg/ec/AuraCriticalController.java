// Original binary: sg/ec/4shU1yrD0NGUspwS
package sg.ec;

import net.minecraft.client.player.LocalPlayer;

// $VF: Compiled from s
public final class AuraCriticalController implements MinecraftAccess {
   private final AttackAura field02082;
   private final CriticalHitStrategy[] field02083 = new CriticalHitStrategy[]{new PoseCriticalHitStrategy(), new JumpCriticalHitStrategy()};
   private boolean field02084;
   private static final String field02085 = "пробел придержан: повторное нажатие включило бы полёт";

   public void method00898() {
      for (CriticalHitStrategy var4 : this.field02083) {
         if (var4.method03149(this.field02082)) {
            var4.method03154(this.field02082);
         } else {
            var4.method03155();
         }
      }
   }

   private static boolean method00899() {
      LocalPlayer var0 = mc.player;
      return var0 != null && var0.getAbilities().mayfly && var0.jumpTriggerTime > 0;
   }

   public void method00900(PlayerInputEvent var1) {
      boolean var2 = var1.method11162();

      for (CriticalHitStrategy var6 : this.field02083) {
         if (var6.method03149(this.field02082)) {
            var6.method03163(var1);
         }
      }

      if (var2 && !var1.method11162()) {
         this.field02084 = true;
      } else if (this.field02084 && var2 && method00899()) {
         var1.method11173(false);
      } else {
         this.field02084 = false;
      }
   }

   public int method00901() {
      for (CriticalHitStrategy var4 : this.field02083) {
         if (var4.method03149(this.field02082)) {
            int var5 = var4.method03152(this.field02082);
            if (var5 >= 0) {
               return var5;
            }
         }
      }

      return -1;
   }

   public AuraCriticalController(AttackAura var1) {
      this.field02082 = var1;
   }

   public boolean method00902() {
      for (CriticalHitStrategy var4 : this.field02083) {
         if (var4.method03149(this.field02082) && var4.method03148(this.field02082)) {
            return true;
         }
      }

      return false;
   }

   public void method00903() {
      this.field02084 = false;

      for (CriticalHitStrategy var4 : this.field02083) {
         var4.method03155();
      }
   }
}
