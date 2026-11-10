// Original binary: sg/ec/fkZQLH5JMS8AwvWH
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.Base64;

// $VF: Compiled from s
public final class McpConfigStorage {
   public static final String SERVER_NAME = "miranware";
   public static final String PATH = "PATH";
   public static final String HOST = "HOST";
   private static final String FILE = "FILE";
   private static final int PORT_MIN = 0;
   private static final int PORT_SPAN = 0;
   private static final int TOKEN_BYTES = 0;
   private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
   private static final SecureRandom RANDOM = new SecureRandom();
   private boolean enabled;
   private int port;
   private String token;
   private String agent;
   private static final String field19148 = "mcp.json";

   private static File method08277() {
      return new File(ClientEnvironment.field07577, field19148);
   }

   public void method08278(McpServerMode var1) {
      this.agent = var1.name();
   }

   public boolean method08279() {
      return this.enabled;
   }

   public String method08280() {
      return this.token;
   }

   private static int method08281() {
      return 20000 + RANDOM.nextInt(20000);
   }

   public void method08282() {
      try {
         File var1 = method08277();
         File var2 = var1.getParentFile();
         if (var2 != null && !var2.isDirectory()) {
            var2.mkdirs();
         }

         Files.writeString(var1.toPath(), GSON.toJson(this), StandardCharsets.UTF_8);
      } catch (IOException var3) {
      }
   }

   public String method08283() {
      return this.method08291().method11340(this.method08286(), this.token);
   }

   public void method08284(boolean var1) {
      this.enabled = var1;
   }

   private McpConfigStorage() {
   }

   public String method08285() {
      return "127.0.0.1:" + this.port;
   }

   public String method08286() {
      return "http://" + this.method08285() + "/mcp";
   }

   public void method08287() {
      this.port = method08281();
   }

   public String method08288() {
      return this.agent;
   }

   public void method08289() {
      this.token = method08292();
   }

   public static McpConfigStorage method08290() {
      File var0 = method08277();
      McpConfigStorage var1 = null;
      if (var0.isFile()) {
         try {
            var1 = (McpConfigStorage)GSON.fromJson(Files.readString(var0.toPath(), StandardCharsets.UTF_8), McpConfigStorage.class);
         } catch (IOException | RuntimeException var3) {
         }
      }

      if (var1 == null) {
         var1 = new McpConfigStorage();
      }

      if (var1.port <= 0) {
         var1.port = method08281();
      }

      if (var1.token == null || var1.token.isBlank()) {
         var1.token = method08292();
      }

      var1.agent = McpServerMode.method11332(var1.agent).name();
      return var1;
   }

   public McpServerMode method08291() {
      return McpServerMode.method11332(this.agent);
   }

   private static String method08292() {
      byte[] var0 = new byte[24];
      RANDOM.nextBytes(var0);
      return Base64.getUrlEncoder().withoutPadding().encodeToString(var0);
   }

   public int method08293() {
      return this.port;
   }
}
