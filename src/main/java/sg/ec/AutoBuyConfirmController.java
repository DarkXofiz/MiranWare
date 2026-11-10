// Original binary: sg/ec/pDouYvTJbZG9C3hT
package sg.ec;

import net.minecraft.util.Mth;

// $VF: Compiled from s
public final class AutoBuyConfirmController implements MinecraftAccess {
   private static final long field22677 = 75000L;
   private static final long field22678 = 0;
   private static final long field22679 = 0;
   private static final float field22680 = 0;
   private static final float field22681 = 0;
   private static final float field22682 = 0;
   private static final double field22683 = 0;
   private long field22684;
   private long field22685;
   private float field22686;
   private static final long field22687 = 75000L;
   private static final long field22688 = 900L;
   private static final long field22689 = 1800L;
   private static final float field22690 = 3.5F;
   private static final float field22691 = 10.0F;
   private static final double field22692 = 0.003;
   private static final float field22693 = 8.0F;
   private static final long field22694 = 75000L;

   private void method10054(long var1) {
      this.field22686 = Mth.wrapDegrees(this.field22686 + field22690);
      mc.player.setYRot(this.field22686);
      mc.player.setXRot(field22691 + (float)Math.sin(var1 * field22692) * field22693);
      if (var1 >= this.field22685) {
         this.field22685 = 0L;
         this.field22684 = var1 + AutoBuyDelayUtils.method07071(field22694);
      }
   }

   public void method10055() {
      this.field22685 = 0L;
   }

   private boolean method10056() {
      return AutoBuySettings.field19624.method08577()
         && AutoBuyManager.INSTANCE.method09759()
         && AutoBuyItemRegistry.INSTANCE.method10998() == AutoBuyServer.FUN_TIME
         && mc.player != null
         && mc.level != null;
   }

   public void method10057(long var1) {
      if (!this.method10056()) {
         this.field22685 = 0L;
         this.field22684 = var1 + AutoBuyDelayUtils.method07071(field22687);
      } else if (this.field22685 > 0L) {
         this.method10054(var1);
      } else {
         if (var1 >= this.field22684) {
            this.field22685 = var1 + AutoBuyDelayUtils.method07073(field22688, field22689);
            this.field22686 = mc.player.getYRot();
         }
      }
   }
}
