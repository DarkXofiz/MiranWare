// Original binary: sg/ec/wIrcDMC5seRIwctt
package sg.ec;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.network.Connection;

// $VF: Compiled from s
public final class ViaFabricPlusProtocolAccess {
   public static final String field25155 = "";
   private static final String field25156 = "field25156";
   private static final String field25157 = "field25157";
   private static final String field25158 = "field25158";
   private static final String field25159 = "field25159";
   private static final String field25160 = "field25160";
   private static final String field25161 = "field25161";
   private static final String field25162 = "field25162";
   private static volatile Boolean field25163;
   private static volatile List<String> field25164;
   private static final String field25165 = "com.viaversion.viaversion.api.protocol.version.ProtocolVersion";
   private static final String field25166 = "com.viaversion.viafabricplus.protocoltranslator.util.ProtocolVersionDetector";
   private static final String field25167 = "AUTO_DETECT_VERSION";
   private static final String field25168 = "com.viaversion.viafabricplus.protocoltranslator.ProtocolTranslationImpl";
   private static final String field25169 = "NATIVE_VERSION";
   private static final String field25170 = "olderThan";
   private static final String field25171 = "com.viaversion.viaversion.api.protocol.version.ProtocolVersion";
   private static final String field25172 = "getClosest";
   private static final String field25173 = "viaFabricPlus$setTargetVersion";
   private static final String field25174 = "com.viaversion.viafabricplus.protocoltranslator.util.ProtocolVersionDetector";
   private static final String field25175 = "AUTO_DETECT_VERSION";
   private static final String field25176 = "com.viaversion.viafabricplus.protocoltranslator.ProtocolTranslationImpl";
   private static final String field25177 = "NATIVE_VERSION";
   private static final String field25178 = "get";
   private static final String field25179 = "com.viaversion.viafabricplus.ViaFabricPlus";
   private static final String field25180 = "getImpl";
   private static final String field25181 = "getTargetVersion";
   private static final String field25182 = "getTargetVersion";
   private static final String field25183 = "viafabricplus";
   private static final String field25184 = "com.viaversion.viaversion.api.protocol.version.ProtocolVersion";
   private static final String field25185 = "com.viaversion.viafabricplus.ViaFabricPlus";
   private static final String field25186 = "com.viaversion.viaversion.api.protocol.version.ProtocolVersion";
   private static final String field25187 = "getProtocols";
   private static final String field25188 = "isKnown";
   private static final String field25189 = "getName";

   private static String method11190(Object var0) throws ReflectiveOperationException {
      return (String)var0.getClass().getMethod(field25189).invoke(var0);
   }

   private static Object method11191() throws Exception {
      Object var0 = Class.forName(field25179).getMethod(field25180).invoke(null);
      ClientPacketListener var1 = Minecraft.getInstance().getConnection();
      if (var1 != null) {
         Object var2 = var0.getClass().getMethod(field25181, Connection.class).invoke(var0, var1.getConnection());
         if (var2 != null) {
            return var2;
         }
      }

      return var0.getClass().getMethod(field25182).invoke(var0);
   }

   public static String method11192() {
      if (!method11193()) {
         return "";
      }

      try {
         return method11190(method11191());
      } catch (Throwable var1) {
         return "";
      }
   }

   public static boolean method11193() {
      Boolean var0 = field25163;
      if (var0 == null) {
         var0 = method11199();
         field25163 = var0;
      }

      return var0;
   }

   public static List<String> method11194() {
      var var0 = field25164;
      if (var0 == null) {
         var0 = method11197();
         field25164 = var0;
      }

      return var0;
   }

   public static boolean method11195() {
      if (!method11193()) {
         return false;
      }

      try {
         var var0 = Class.forName(field25165);
         Object var1 = method11191();
         if (var1 != null && var1 != Class.forName(field25166).getField(field25167).get(null)) {
            Object var2 = Class.forName(field25168).getField(field25169).get(null);
            return (Boolean)var0.getMethod(field25170, var0).invoke(var1, var2);
         } else {
            return false;
         }
      } catch (Throwable var3) {
         return false;
      }
   }

   private static Object method11196(ServerAddress var0, InetSocketAddress var1, Class<?> var2) throws Exception {
      Object var3 = method11191();
      var var4 = Class.forName(field25174);
      if (var3 != var4.getField(field25175).get(null)) {
         return var3;
      }

      Object var5 = Class.forName(field25176).getField(field25177).get(null);
      return var4.getMethod(field25178, ServerAddress.class, InetSocketAddress.class, var2).invoke(null, var0, var1, var5);
   }

   private static List<String> method11197() {
      if (!method11193()) {
         return List.of();
      }

      try {
         var var0 = Class.forName(field25186);
         List var1 = (List)var0.getMethod(field25187).invoke(null);
         Method var2 = var0.getMethod(field25188);
         var var3 = new ArrayList(var1.size());

         for (Object var5 : var1) {
            if ((Boolean)var2.invoke(var5)) {
               var3.add(method11190(var5));
            }
         }

         Collections.reverse(var3);
         return Collections.unmodifiableList(var3);
      } catch (Throwable var6) {
         return List.of();
      }
   }

   private ViaFabricPlusProtocolAccess() {
   }

   public static void method11198(Connection var0, ServerAddress var1, InetSocketAddress var2, String var3) {
      if (method11193()) {
         try {
            var var4 = Class.forName(field25171);
            boolean var5 = var3 == null || var3.isEmpty();
            Object var6 = var5 ? method11196(var1, var2, var4) : var4.getMethod(field25172, String.class).invoke(null, var3);
            if (var6 == null) {
               return;
            }

            Method var7 = var0.getClass().getMethod(field25173, var4);
            var7.invoke(var0, var6);
         } catch (Throwable var8) {
         }
      }
   }

   private static boolean method11199() {
      if (!FabricLoader.getInstance().isModLoaded(field25183)) {
         return false;
      }

      try {
         Class.forName(field25184);
         Class.forName(field25185);
         return true;
      } catch (Throwable var1) {
         return false;
      }
   }
}
