// Original binary: sg/ec/3i7DyWJoj0TYDaoR
package sg.ec;

import hex.api.baritone.api.BaritoneAPI;
import java.io.File;
import java.util.List;
import java.util.Set;
import net.fabricmc.api.ModInitializer;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;
import ru.dreamix.protection.api.impl.profile.objects.RoleObject;

// $VF: Compiled from s
public class MiranWare implements MinecraftAccess, ModInitializer {
   private static MiranWare field01747;
   public static final String field01748 = "Hex";
   private final File field01749;
   private static boolean field01750 = false;
   private ClickGuiScreen field01751;
   private GlobalWebSocketClient field01752;
   private static final String field01753 = "Hex";
   private static final String field01754 = "W1oX1S";
   private static final String field01755 = "dlеаmixd";

   @Override
   public void onInitialize() {
      BaritoneAPI.initBaritone();
      ProfileAPI.create(false ? field01754 : field01755, 0, false ? RoleObject.ADMIN : RoleObject.DEFAULT);
      field01747 = this;
      EventBus.method00263(this);
   }

   public File getClientDir() {
      return this.field01749;
   }

   public void setClient(GlobalWebSocketClient var1) {
      this.field01752 = var1;
   }

   public static MiranWare getInit() {
      return field01747;
   }

   public ClickGuiScreen getMenuScreen() {
      return this.field01751;
   }

   public static MiranWare getInstance() {
      return field01747;
   }

   public MiranWare() {
      this.field01749 = new File(mc.gameDirectory, field01753);
   }

   @Subscribe
   private void onGameStarted(GameStartedEvent var1) {
      if (ProfileAPI.get().getModel().getRole().priorityHigherOrEquals(RoleObject.BETA)) {
         ClientEnvironment.field07579 = ClientEnvironment.field07579 + "Alpha";
      }

      new ClientManagers();
      this.field01751 = new ClickGuiScreen();
   }

   public GlobalWebSocketClient getClient() {
      return this.field01752;
   }

   // $VF: Compiled from s
   public static final class Nested21 implements IMixinConfigPlugin {
      public void postApply(String var1, ClassNode var2, String var3, IMixinInfo var4) {
      }

      public void onLoad(String var1) {
         ScriptMixinManager.method08302();
      }

      public void preApply(String var1, ClassNode var2, String var3, IMixinInfo var4) {
      }

      public boolean shouldApplyMixin(String var1, String var2) {
         return true;
      }

      public void acceptTargets(Set<String> var1, Set<String> var2) {
      }

      public List<String> getMixins() {
         return ScriptMixinManager.method08297();
      }

      public String getRefMapperConfig() {
         return null;
      }
   }

   // $VF: Compiled from s
   public static final class Nested22 implements IMixinConfigPlugin {
      private final IMixinConfigPlugin field01756 = new ViaBotGuardMixinPlugin();

      public void onLoad(String var1) {
         this.field01756.onLoad(var1);
      }

      public void preApply(String var1, ClassNode var2, String var3, IMixinInfo var4) {
         this.field01756.preApply(var1, var2, var3, var4);
      }

      public String getRefMapperConfig() {
         return this.field01756.getRefMapperConfig();
      }

      public boolean shouldApplyMixin(String var1, String var2) {
         return this.field01756.shouldApplyMixin(var1, var2);
      }

      public void acceptTargets(Set<String> var1, Set<String> var2) {
         this.field01756.acceptTargets(var1, var2);
      }

      public void postApply(String var1, ClassNode var2, String var3, IMixinInfo var4) {
         this.field01756.postApply(var1, var2, var3, var4);
      }

      public List<String> getMixins() {
         return this.field01756.getMixins();
      }
   }
}
