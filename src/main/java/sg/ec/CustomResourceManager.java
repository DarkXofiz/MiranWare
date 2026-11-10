// Original binary: sg/ec/A4XtXxhrCRoJZBtQ
package sg.ec;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public enum CustomResourceManager implements MinecraftAccess {
   INSTANCE;

   public final File field05980 = new File(ClientEnvironment.field07577, "custom/");
   public final File field05981;
   public final File field05982;
   private final String field05983;

   CustomResourceManager() {
      Object var10001 = null;
      this.field05981 = new File(ClientEnvironment.field07577, "mics/");
      this.field05982 = new File(ClientEnvironment.field07577, "theme/");
      this.field05983 = ".file";
   }

   public void method02458() {
   }

   public void method02459() {
      try {
         this.method02464("Friend");
         this.method02464("Macro");
         this.method02464("Staff");
         this.method02464("WayPoint");
         this.method02464("Theme");
         this.method02464("NoTrace");
         this.method02464("Proxy");
         this.method02464("Bots");
         this.method02464("Default");
      } catch (Throwable var2) {
         throw var2;
      }
   }

   public boolean method02460() {
      return this.method02463(StorageCategory.BOTS, "Bots", BotSettingsStorage.method00299());
   }

   public boolean method02461() {
      return true;
   }

   public boolean method02462() {
      return this.method02463(StorageCategory.AUTO_BUY, "AutoBuy", AutoBuyStorage.method01323());
   }

   private boolean method02463(StorageCategory var1, String var2, byte[] var3) {
      return var3 != null && var3.length != 0 ? GlobalRequestSender.method09378(var3x -> {
         if (StoredContentCache.method05221(var1, var2, var3)) {
            var3x.method01839(var1, var2, var3);
            StoredContentCache.method05219(var1, var2, var3);
         }
      }) : false;
   }

   public boolean method02464(String var1) {
      AbstractStorage var2 = this.method02466(var1);
      return var2 != null && var2.method00298();
   }

   public boolean method02465(String var1) {
      AbstractStorage var2 = this.method02466(var1);
      if (var2 == null) {
         return false;
      }

      File var3 = var2.method03303().getParentFile();
      return var3 != null && !var3.exists() && !var3.mkdirs() ? false : var2.method00296();
   }

   public AbstractStorage method02466(String var1) {
      if (var1.equals("default")) {
         return new ModuleConfigStorage(new File(ClientEnvironment.field07577, "default.file"));
      }

      File[] var2 = this.field05980.listFiles();
      if (var2 != null) {
         for (File var6 : var2) {
            if (var6.getName().replace(".file", "").equals(var1)) {
               return new ModuleConfigStorage(var6);
            }
         }
      }

      File[] var9 = this.field05981.listFiles();
      if (var9 != null) {
         for (File var7 : var9) {
            String var8 = var7.getName().replace(".file", "");
            if (var8.equalsIgnoreCase(var1)) {
               return this.method02467(var8, var7);
            }
         }
      }

      return this.method02467(var1, new File(this.field05981, var1 + ".file"));
   }

   private AbstractStorage method02467(String var1, File var2) {
      return switch (var1) {
         case "Friend" -> new NoTraceStorage(var2);
         case "LastAccount" -> new AccountStorage(var2);
         case "Macro" -> new MacroStorage(var2);
         case "Staff" -> new StaffStorage(var2);
         case "WayPoint" -> new WaypointStorage(var2);
         case "Theme" -> new ThemeStorage(var2);
         case "NoTrace" -> new FriendStorage(var2);
         case "Bots" -> new BotSettingsStorage(var2);
         case "Proxy" -> new ProxyStorage(var2);
         case "AutoBuy" -> new AutoBuyStorage(var2);
         default -> null;
      };
   }

   public List<ModuleConfigStorage> method02468() {
      ArrayList var1 = new ArrayList();
      File[] var2 = this.field05980.listFiles();
      if (var2 != null) {
         for (File var6 : var2) {
            var1.add(new ModuleConfigStorage(var6));
         }
      }

      return var1;
   }

   public static byte[] method02469(byte[] var0) {
      return ResourceByteCodec.method06878(var0);
   }

   public static byte[] method02470(byte[] var0) {
      return ResourceByteCodec.method06874(var0);
   }
}
