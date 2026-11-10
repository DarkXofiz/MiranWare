// Original binary: sg/ec/QP7pRc7G90avrucg
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

// $VF: Compiled from s
public class McpSettingsWindow extends SettingsListWindow {
   public static final String field11230 = "menu.mcp";
   public static final float field11231 = 0;
   private static final float field11232 = 0;
   private static final long field11233 = 0;
   private static final int field11234 = 0;
   private static final String field11235 = "field11235";
   private static final String field11236 = "field11236";
   private static final String field11237 = "field11237";
   private static final String field11238 = "field11238";
   private static final String field11239 = "field11239";
   private static final String field11240 = "field11240";
   private static final String field11241 = "field11241";
   private static final String field11242 = "field11242";
   private static final String field11243 = "field11243";
   private static final String field11244 = "field11244";
   private static final String field11245 = "field11245";
   private final McpServer field11246 = McpServer.INSTANCE;
   private final ElapsedTimer field11247 = new ElapsedTimer();
   private final List<SettingsListWindow.Nested200> field11248;
   private final List<SettingsListWindow.Nested200> field11249;
   private CompletableFuture<String> field11250;
   private String field11251;
   private boolean field11252;
   private Object field11253;
   private static final String field11254 = "MCP";
   private static final String field11255 = "menu.mcp";
   private static final float field11256 = 150.0F;
   private static final float field11257 = 230.0F;
   private static final String field11258 = "Включён";
   private static final String field11259 = "Адрес";
   private static final String field11260 = "Токен";
   private static final String field11261 = "Агент";
   private static final long field11262 = 2500L;
   private static final String field11263 = "скопировано";
   private static final String field11264 = "Настраиваю…";
   private static final String field11265 = "Новый порт и токен";
   private static final String field11266 = "Скопировать адрес и токен";
   private static final String field11267 = "Скопировать адрес и токен";
   private static final String field11268 = "Скопировать адрес и токен";
   private static final String field11269 = "Скопировать ";
   private static final String field11270 = "Скопировать ";
   private static final String field11271 = "Токен";
   private static final String field11272 = "Токен";
   private static final String field11273 = "Адрес";
   private static final String field11274 = "Адрес";

   private boolean method05156() {
      return !this.field11247.method04699(field11262);
   }

   @Override
   protected List<SettingsListWindow.Nested200> method04173() {
      this.method05157();
      return this.field11252 ? this.field11249 : this.field11248;
   }

   private void method05157() {
      if (this.field11250 != null && this.field11250.isDone()) {
         try {
            this.field11251 = this.field11250.join();
            this.field11252 = false;
         } catch (RuntimeException var3) {
            Throwable var2 = var3.getCause() == null ? var3 : var3.getCause();
            this.field11251 = var2.getMessage();
            this.field11252 = true;
         }

         this.field11250 = null;
         this.field11253 = null;
         this.field11247.method04694();
      }
   }

   private static List<SettingsListWindow.Nested200> method05159(List<SettingsListWindow.Nested200> var0, List<SettingsListWindow.Nested200> var1) {
      var var2 = new ArrayList<>(var0);
      var2.addAll(var1);
      return var2;
   }

   public McpSettingsWindow() {
      super(field11254, field11255, field11256, field11257);
      this.field11247.method04694();
      this.field11248 = List.of(
         this.method06850(field11258, () -> this.method05162().method08279(), var1 -> {
            this.method05162().method08284(var1);
            this.field11246.method11630();
         }),
         this.method06851(
            field11259,
            () -> this.method05178(field11274, this.method05162().method08285()),
            () -> this.method05164(field11273, this.method05162().method08285())
         ),
         this.method06851(
            field11260, () -> this.method05178(field11272, this.method05177()), () -> this.method05164(field11271, this.method05162().method08280())
         ),
         this.method06851(field11261, () -> this.method05162().method08291().field26005, this::method05173),
         this.method06830(this::method05168, () -> this.field11252 ? GuiThemeStyle.Nested40.DANGER : GuiThemeStyle.Nested40.NORMAL, this::method05170)
      );
      this.field11249 = method05159(
         this.field11248,
         List.of(
            this.method06830(
               () -> this.method05178(field11270, "Скопировать " + this.method05162().method08291().method11335()),
               () -> GuiThemeStyle.Nested40.DISABLED,
               () -> this.method05164(field11269, this.method05162().method08283())
            ),
            this.method06830(
               () -> this.method05178(field11267, field11268),
               () -> GuiThemeStyle.Nested40.DISABLED,
               () -> this.method05164(field11266, this.method05162().method08285() + " " + this.method05162().method08280())
            ),
            this.method06830(() -> field11265, () -> GuiThemeStyle.Nested40.DANGER, this::method05167)
         )
      );
   }

   private McpConfigStorage method05162() {
      return this.field11246.method11645();
   }

   private void method05164(Object var1, String var2) {
      mc.keyboardHandler.setClipboard(var2);
      this.field11253 = var1;
      this.field11247.method04694();
   }

   private void method05167() {
      this.method05162().method08287();
      this.method05162().method08289();
      this.field11246.method11630();
      this.field11252 = false;
      this.field11251 = null;
   }

   private String method05168() {
      if (this.field11250 != null) {
         return field11264;
      } else {
         return this.field11251 != null && this.method05156() ? this.field11251 : "Настроить " + this.method05162().method08291().field26005;
      }
   }

   private void method05170() {
      if (this.field11250 == null) {
         if (!this.method05162().method08279()) {
            this.method05162().method08284(true);
            this.field11246.method11630();
         }

         McpServerMode var1 = this.method05162().method08291();
         McpConfigStorage var2 = this.method05162();
         this.field11250 = CompletableFuture.supplyAsync(() -> {
            try {
               return ScriptConsole.method10147(var1, var2);
            } catch (ScriptConsole.Nested282 var3) {
               throw new IllegalStateException(var3.getMessage(), var3);
            }
         });
      }
   }

   private void method05173() {
      this.method05162().method08278(this.method05162().method08291().method11333());
      this.method05162().method08282();
      this.field11252 = false;
      this.field11251 = null;
   }

   private String method05177() {
      String var1 = this.method05162().method08280();
      return var1.length() <= 12 ? var1 : var1.substring(0, 6) + "…" + var1.substring(var1.length() - 6);
   }

   private String method05178(Object var1, String var2) {
      return var1.equals(this.field11253) && this.method05156() ? field11263 : var2;
   }
}
