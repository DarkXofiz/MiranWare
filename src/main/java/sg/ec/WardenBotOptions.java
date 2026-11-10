// Original binary: sg/ec/NokA56NmaoLZ9DZh
package sg.ec;

// $VF: Compiled from s
public record WardenBotOptions(boolean useSpeed, boolean reportKillers, String lootPriority, int lootLimit, boolean debug) {
   public static final String PRIORITY_LOW = "Низкий";
   public static final String PRIORITY_MEDIUM = "PRIORITY_MEDIUM";
   public static final String PRIORITY_HIGH = "PRIORITY_HIGH";

   public boolean priorityIs(String var1) {
      return this.lootPriority.equals(var1);
   }
}
