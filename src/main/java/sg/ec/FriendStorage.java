// Original binary: sg/ec/xzsXiARD4L2yvHap
package sg.ec;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public class FriendStorage extends AbstractStorage {
   private static final String field26342 = ":";
   private static final String field26343 = "\n";
   private static final String field26344 = ":";

   private static String method11520(byte[] var0) {
      return var0 == null ? null : new String(var0, StandardCharsets.UTF_8);
   }

   private static byte[] method11521() {
      NotraceCommand var0 = CommandManager.INSTANCE.method04650(NotraceCommand.class);
      if (var0 == null) {
         return new byte[0];
      }

      StringBuilder var1 = new StringBuilder();

      for (Block var3 : var0.field18407) {
         Identifier var4 = BuiltInRegistries.BLOCK.getKey(var3);
         if (var4 != null) {
            var1.append(var4.toString()).append(field26343);
         }
      }

      return var1.toString().getBytes(StandardCharsets.UTF_8);
   }

   @Override
   public boolean method00298() {
      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] var2 = var1.readAllBytes();
         var var3 = this.method11527(this.method11524(CustomResourceManager.method02470(var2)));
         if (var3 == null) {
            var3 = this.method11527(this.method11524(var2));
         }

         if (var3 == null) {
            return false;
         }

         NotraceCommand var4 = CommandManager.INSTANCE.method04650(NotraceCommand.class);
         var4.field18407.clear();

         for (String var6 : var3) {
            Identifier var7 = Identifier.tryParse(var6.contains(field26342) ? var6 : "minecraft:" + var6);
            if (var7 != null) {
               Block var8 = BuiltInRegistries.BLOCK.getValue(var7);
               if (var8 != null && BuiltInRegistries.BLOCK.getKey(var8).equals(var7) && !var4.field18407.contains(var8)) {
                  var4.field18407.add(var8);
               }
            }
         }

         return true;
      } catch (Exception var11) {
         return false;
      }
   }

   private static List<String> method11522(String var0) {
      return var0 == null ? null : var0.lines().map(String::trim).filter(var0x -> !var0x.isEmpty()).distinct().toList();
   }

   public static boolean method11523(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         var var1 = method11522(method11520(CustomResourceManager.method02470(var0)));
         if (var1 == null) {
            var1 = method11522(method11520(var0));
         }

         if (var1 == null) {
            return false;
         }

         try {
            NotraceCommand var2 = CommandManager.INSTANCE.method04650(NotraceCommand.class);
            var2.field18407.clear();

            for (String var4 : var1) {
               Identifier var5 = Identifier.tryParse(var4.contains(field26344) ? var4 : "minecraft:" + var4);
               if (var5 != null) {
                  Block var6 = BuiltInRegistries.BLOCK.getValue(var5);
                  if (var6 != null && BuiltInRegistries.BLOCK.getKey(var6).equals(var5) && !var2.field18407.contains(var6)) {
                     var2.field18407.add(var6);
                  }
               }
            }

            return true;
         } catch (Exception var7) {
            return false;
         }
      } else {
         return false;
      }
   }

   private String method11524(byte[] var1) {
      return var1 == null ? null : new String(var1, StandardCharsets.UTF_8);
   }

   @Override
   public boolean method00296() {
      try {
         return this.method03302(method11521());
      } catch (Exception var2) {
         return false;
      }
   }

   public static byte[] method11526() {
      try {
         return CustomResourceManager.method02469(method11521());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   public FriendStorage(File var1) {
      super(var1);
   }

   private List<String> method11527(String var1) {
      return var1 == null ? null : var1.lines().map(String::trim).filter(var0 -> !var0.isEmpty()).distinct().toList();
   }
}
