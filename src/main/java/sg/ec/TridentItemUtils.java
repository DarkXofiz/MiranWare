// Original binary: sg/ec/may16wCdPMGDbJ4j
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public final class TridentItemUtils {
   private static final double field21545 = -1.0;
   private static final double field21546 = 1.5;
   private static final double field21547 = -0.3;
   private static final double field21548 = -0.47;
   private static final double field21549 = 15.0;
   private static final double field21550 = 0.5;
   private static final double field21551 = 0.5;
   private static final double field21552 = 0.5;
   private static final double field21553 = 35.0;
   private static final double field21554 = 0.5;
   private static final double field21555 = 0.5;
   private static final double field21556 = 0.5;
   private static final double field21557 = -65.0;
   private static final double field21558 = 0.5;
   private static final double field21559 = 0.5;
   private static final double field21560 = 0.5;
   private static final double field21561 = 0.9;
   private static final double field21562 = 0.9;
   private static final double field21563 = 0.9;
   private static final double field21564 = 0.09723;
   private static final double field21565 = 0.60632;
   private static final double field21566 = 3.24;
   private static final double field21567 = 1.65;
   private static final double field21568 = 0.1;
   private static final String field21569 = "trident";
   private static final double field21570 = 10.0;
   private static final double field21571 = 6.0;

   private TridentItemUtils() {
   }

   public static void method09512(ItemAnimationContext var0) {
      ItemFeatureVariables var1 = ItemFeatureVariables.field24990;
      PoseStack var2 = var0.field19839;
      double var3 = var0.field19843 ? 1.0 : field21545;
      String var5 = ItemFeatureProperties.method05406(var0.field19838);
      if (ItemFeatureProperties.method05419(var0.field19838) && var1.field25057 > 0.0) {
         ItemAnimationMath.method00529(var2, field21546 * var3);
         ItemAnimationMath.method00527(var2, field21547);
         ItemAnimationMath.method00517(var2, field21548);
         ItemAnimationMath.method00511(var2, field21549, field21550 * var3, field21551, field21552);
         ItemAnimationMath.method00508(var2, field21553 * var3, field21554 * var3, field21555, field21556);
         ItemAnimationMath.method00509(var2, field21557 * var3, field21558 * var3, field21559, field21560);
         ItemAnimationMath.method00516(var2, field21561, field21562, field21563);
      }

      double var6 = var0.field19842 ? var1.field25060 : var1.field25061;
      double var8 = AnimationCurveMath.method08362(
         ItemAnimationMath.method00526(ItemAnimationMath.method00520(var6, field21564, field21565) * field21566 * field21567 - field21568)
      );
      if ((
            ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23902)
               || ItemFeatureProperties.method05404(var0.field19838, Items.ENDER_PEARL)
               || ItemFeatureProperties.method05404(var0.field19838, Items.ENDER_EYE)
               || ItemFeatureProperties.method05416(var0.field19838)
               || ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23905)
               || ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23906)
               || ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23901)
         )
         && !var5.equals(field21569)) {
         ItemAnimationMath.method00513(var2, field21570 * var8);
         ItemAnimationMath.method00524(var2, field21571 * var8);
      }
   }
}
