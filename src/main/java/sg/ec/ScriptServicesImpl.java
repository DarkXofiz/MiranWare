// Original binary: sg/ec/6xsvkGDA2oiWyivj
package sg.ec;

import hex.script.api.Assets;
import hex.script.api.Clipboard;
import hex.script.api.FontRegistry;
import hex.script.api.Notifications;
import hex.script.api.ScriptServices;
import hex.script.api.Shaders;
import hex.script.api.Storage;
import hex.script.api.Tasks;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $VF: Compiled from s
public final class ScriptServicesImpl implements MinecraftAccess {
   private final Map<Object, Map<String, Storage>> field03736 = new HashMap<>();
   private final Map<Object, Tasks> field03737 = new HashMap<>();
   private final Assets field03738 = new Assets(
      ResourcePathUtils::method11306, ResourcePathUtils::method11307, ResourcePathUtils::method11309, ResourcePathUtils::method11305
   );
   private final Map<Object, Clipboard> field03739 = new HashMap<>();
   private final Set<Object> field03740 = new HashSet<>();
   private final Notifications field03741 = new Notifications(this::method01558);
   private final ScriptInteractionAdapter field03742 = new ScriptInteractionAdapter();
   private final ScriptInputAdapter field03743 = new ScriptInputAdapter();
   private final ScriptEntitiesAdapter field03744 = new ScriptEntitiesAdapter();
   private final ScriptWorldAdapter field03745 = new ScriptWorldAdapter(this.field03744.method09079());
   private final ScriptContainerAdapter field03746 = new ScriptContainerAdapter();
   private final ScriptClientInfoAdapter field03747 = new ScriptClientInfoAdapter();
   private final ScriptTabAdapter field03748 = new ScriptTabAdapter();
   private final ScriptScoreboardAdapter field03749 = new ScriptScoreboardAdapter();
   private final ScriptEffectsAdapter field03750 = new ScriptEffectsAdapter();
   private final FontRegistry field03751 = new FontRegistry(
      sg.ec.FontRegistry::method02879, sg.ec.FontRegistry::method02889, sg.ec.FontRegistry::method02892, sg.ec.FontRegistry::method02884
   );
   private final ScriptSlotsAdapter field03752 = new ScriptSlotsAdapter();
   private final ScriptSocialAdapter field03753 = new ScriptSocialAdapter();
   private final ScriptWorldgenTools field03754 = new ScriptWorldgenTools();
   private final ProjectileTypes field03755 = new ProjectileTypes();
   private final Shaders field03756 = new Shaders(ScriptShaderManager::method10944, ScriptShaderManager::method10931, ScriptShaderManager::method10949);
   private final ScriptServices field03757 = new ScriptServices(
      this::method01572,
      this::method01563,
      () -> this.field03738,
      this::method01575,
      () -> this.field03741,
      CommandLineParser::method05593,
      () -> this.field03756,
      this.field03742::method00582,
      this.field03742::method00581,
      this.field03755::method10266,
      this.field03753::method04715,
      this.field03753::method04722,
      MeshBufferUtils::method07833,
      this.field03745::method06587,
      this.field03745::method06593,
      this.field03745::method06592,
      this.field03750::method02976,
      this.field03750::method02996,
      this.field03747::method04659,
      () -> this.field03751,
      this.field03746::method02432,
      this.field03748::method04822,
      this.field03749::method10464,
      this.field03744::method09079,
      ScriptPacketsAdapter::method03453,
      this.field03743::method06637,
      this.field03743::method06629,
      this.field03752::method01453,
      ScriptLogManager.INSTANCE::method08081,
      ScriptLogManager.INSTANCE::method08082,
      this.field03754::method09366
   );
   private static final String field03758 = "читает системный буфер обмена";
   private static final long field03759 = 250L;

   private void method01554(String var1) {
      try {
         mc.keyboardHandler.setClipboard(var1);
      } catch (Throwable var3) {
      }
   }

   private void method01558(String var1, long var2, int var4) {
      if (var1 != null && !var1.isEmpty()) {
         NotificationManager.method08597(var1, Math.max(field03759, var2), switch (var4) {
            case 1 -> NotificationType.ENABLE;
            case 2 -> NotificationType.WARNING;
            case 3 -> NotificationType.ERROR;
            default -> NotificationType.INFO;
         });
      }
   }

   private Storage method01559(Object var1, String var2) {
      ScriptDataStorage var3 = new ScriptDataStorage(ScriptSettingsAdapter.method00973(var1), var2);
      return new Storage(var2, var3::method11801, var3::method11792, var3::method11797, var3::method11796, var3::method11791);
   }

   void method01561() {
      this.field03752.method01459();
      this.field03749.method10467();
      ScriptManager.method01295();
   }

   private Tasks method01563(Object var1) {
      return this.field03737
         .computeIfAbsent(
            var1,
            var0 -> new Tasks(
               (var1x, var3, var5, var6) -> ScriptScheduledTasks.method06953(var0, var1x, var3, var5, var6),
               var1x -> ScriptScheduledTasks.method06952(var0, var1x),
               () -> ScriptScheduledTasks.method06951(var0)
            )
         );
   }

   void method01565() {
      EventBus.method00263(this.field03743);
      this.field03750.method02985();
   }

   void method01567() {
      for (var var2 : this.field03736.values()) {
         for (Storage var4 : (Iterable<Storage>) (Iterable) var2.values()) {
            var4.save();
         }
      }
   }

   private String method01569(Object var1) {
      if (this.field03740.add(var1)) {
         ScriptLogManager.INSTANCE.method08093(var1, field03758);
      }

      try {
         return mc.keyboardHandler.getClipboard();
      } catch (Throwable var3) {
         return "";
      }
   }

   void method01570(Object var1) {
      CommandLineParser.method05588(var1);
      this.field03752.method01454(var1);
      this.field03739.remove(var1);
      this.field03740.remove(var1);
      ScriptLogManager.INSTANCE.method08083(var1);
      var var2 = this.field03736.remove(var1);
      if (var2 != null) {
         for (Storage var4 : var2.values()) {
            var4.save();
         }
      }

      this.field03737.remove(var1);
   }

   private Storage method01572(Object var1, String var2) {
      String var3 = ScriptDataStorage.method11795(var2);
      return this.field03736.computeIfAbsent(var1, var0 -> new HashMap<>()).computeIfAbsent(var3, var2x -> this.method01559(var1, var2x));
   }

   void method01574(Object var1) {
      this.field03752.method01454(var1);
   }

   private Clipboard method01575(Object var1) {
      return this.field03739.computeIfAbsent(var1, var1x -> new Clipboard(() -> this.method01569(var1x), this::method01554));
   }

   ScriptServices method01576() {
      return this.field03757;
   }
}
