// Original binary: hex/api/baritone/api/BaritoneAPI
package hex.api.baritone.api;

import hex.api.baritone.BaritoneProvider;
import hex.api.baritone.api.utils.SettingsUtil;

// $VF: Compiled from s
public final class BaritoneAPI {
   private static IBaritoneProvider provider;
   private static final Settings settings = new Settings();
   private static final String 诶АО = "诶АО";

   public static Settings getSettings() {
      return settings;
   }

   public static void initBaritone() {
      SettingsUtil.readAndApply(settings, 诶АО);
      provider = new BaritoneProvider();
   }


   public static IBaritoneProvider getProvider() {
      return provider;
   }
}
