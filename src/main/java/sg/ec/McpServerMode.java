// Original binary: sg/ec/xbJUN6T3iWS1mnEF
package sg.ec;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.Locale;

// $VF: Compiled from s
public enum McpServerMode {
   CLAUDE("Claude Code", McpServerMode.Nested321.CLI, null, null),
   CODEX("Codex", McpServerMode.Nested321.TOML, "~/.codex/config.toml", null),
   OPENCODE("OpenCode", McpServerMode.Nested321.JSON, "~/.config/opencode/opencode.json", "mcp"),
   CURSOR("Cursor", McpServerMode.Nested321.JSON, "~/.cursor/mcp.json", "mcpServers"),
   WINDSURF("Windsurf", McpServerMode.Nested321.JSON, "~/.codeium/windsurf/mcp_config.json", "mcpServers"),
   GEMINI("Gemini CLI", McpServerMode.Nested321.JSON, "~/.gemini/settings.json", "mcpServers"),
   VSCODE("VS Code", McpServerMode.Nested321.JSON, null, "servers");

   private static final String field26002 = "Authorization";
   private static final String field26003 = "field26003";
   private static final String field26004 = "field26004";
   public final String field26005;
   public final McpServerMode.Nested321 field26006;
   private final String field26007;
   private final String field26008;

   McpServerMode(String var3, McpServerMode.Nested321 var4, String var5, String var6) {
      this.field26005 = var3;
      this.field26006 = var4;
      this.field26007 = var5;
      this.field26008 = var6;
   }

   public static McpServerMode method11332(String var0) {
      for (McpServerMode var4 : values()) {
         if (var4.name().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return CLAUDE;
   }

   public McpServerMode method11333() {
      return values()[(this.ordinal() + 1) % values().length];
   }

   public String method11334() {
      return this.field26008;
   }

   public String method11335() {
      return this.field26006 == McpServerMode.Nested321.CLI ? "команда" : "конфиг";
   }

   public File method11336() {
      if (this == VSCODE) {
         return method11342();
      } else {
         return this.field26007 == null ? null : new File(System.getProperty("user.home"), this.field26007.substring("~/".length()));
      }
   }

   public String[] method11337(String var1, String var2) {
      return new String[]{"claude", "mcp", "add", "--scope", "user", "--transport", "http", "miranware", var1, "--header", "Authorization: Bearer " + var2};
   }

   public JsonObject method11338(String var1, String var2) {
      JsonObject var3 = new JsonObject();
      switch (this) {
         case OPENCODE:
            var3.addProperty("type", "remote");
            var3.addProperty("url", var1);
            var3.addProperty("enabled", true);
            break;
         case CURSOR:
         default:
            var3.addProperty("url", var1);
            break;
         case WINDSURF:
            var3.addProperty("serverUrl", var1);
            break;
         case GEMINI:
            var3.addProperty("httpUrl", var1);
            break;
         case VSCODE:
            var3.addProperty("type", "http");
            var3.addProperty("url", var1);
      }

      JsonObject var4 = new JsonObject();
      var4.addProperty("Authorization", "Bearer " + var2);
      var3.add("headers", var4);
      return var3;
   }

   public String method11339(String var1, String var2) {
      return "[mcp_servers.miranware]\nurl = \"" + var1 + "\"\nhttp_headers = { Authorization = \"Bearer " + var2 + "\" }\n";
   }

   public String method11340(String var1, String var2) {
      return switch (this.field26006) {
         case CLI -> String.join(" ", method11341(this.method11337(var1, var2)));
         case TOML -> this.method11339(var1, var2);
         case JSON -> {
            JsonObject var3 = new JsonObject();
            var3.add("miranware", this.method11338(var1, var2));
            JsonObject var4 = new JsonObject();
            var4.add(this.field26008, var3);
            yield new GsonBuilder().setPrettyPrinting().create().toJson(var4);
         }
      };
   }

   private static String[] method11341(String[] var0) {
      String[] var1 = new String[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = var0[var2].indexOf(32) >= 0 ? "\"" + var0[var2] + "\"" : var0[var2];
      }

      return var1;
   }

   private static File method11342() {
      String var0 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
      String var1 = System.getProperty("user.home");
      if (var0.contains("win")) {
         String var2 = System.getenv("APPDATA");
         return new File(var2 == null ? var1 + "/AppData/Roaming" : var2, "Code/User/mcp.json");
      } else {
         return var0.contains("mac") ? new File(var1, "Library/Application Support/Code/User/mcp.json") : new File(var1, ".config/Code/User/mcp.json");
      }
   }

   // $VF: Compiled from s
   public enum Nested321 {
      CLI,
      TOML,
      JSON;
   }
}
