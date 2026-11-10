// Original binary: sg/ec/StogZKDAhbKsCJ1K
package sg.ec;

import sg.mx.MinecraftMixin;

// $VF: Compiled from s
public class TapeMouse extends ClientModule {
   private final ModeSetting field11967;
   private final NumberSetting<Integer> field11968;
   private static final String field11969 = "Кнопка мыши";
   private static final String field11970 = "Левая";
   private static final String field11971 = "Правая";
   private static final String field11972 = "Левая";
   private static final String field11973 = "Задержка в тиках";
   private static final String field11974 = "Tape Mouse";
   private static final String field11975 = "Правая";

   private static boolean method05577(int var0, int var1) {
      int var2 = Math.max(1, var1);
      return var0 % var2 == 0;
   }

   @Subscribe
   private void method05578(PlayerUpdateEvent var1) {
      if (mc.player != null) {
         if (method05577(mc.player.tickCount, this.field11968.method03022())) {
            if (this.field11967.method05600(field11975)) {
               ((MinecraftMixin)(Object)mc).IdoItemUse();
            } else {
               ((MinecraftMixin)(Object)mc).IdoAttack();
            }
         }
      }
   }

   public TapeMouse() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field11967 = new ModeSetting(field11969).method05597(field11970, field11971).method03017(field11972).method03023(this);
      this.field11968 = new NumberSetting<Integer>(field11973).method10835(1).method10838(100).method10834(1).method03017(11).method03023(this);
      this.method03935(field11974);
   }
}
