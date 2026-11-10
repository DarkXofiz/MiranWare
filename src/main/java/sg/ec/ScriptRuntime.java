// Original binary: sg/ec/XFCN8YsCMW9mlOpE
package sg.ec;

import hex.script.api.Bridge;
import hex.script.api.Point;
import hex.script.api.Script;
import hex.script.api.Setting;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public enum ScriptRuntime implements MinecraftAccess {
   INSTANCE;

   private final SortableArrayList<LoadedScript> field13890 = new SortableArrayList<>();
   private final ScriptHostImpl field13891 = new ScriptHostImpl();
   private final ScriptDirectoryWatcher field13892 = new ScriptDirectoryWatcher();
   private final ScriptEventAdapter field13893 = new ScriptEventAdapter(this.field13891.method11770());
   private int field13894;
   private boolean field13895;
   private boolean field13896;
   private String field13897 = "не подключался";
   private String field13898 = "не распаковывался";

   public void method06176() {
      Bridge.install(this.field13891.method11772());
      this.field13897 = ScriptManager.method01296();
      this.field13898 = ScriptApiExporter.method03132(this.field13892.method05737());
      this.method06179();
      this.method06177();
      this.field13891.method11767().method01565();
      EventBus.method00263(this);
   }

   public int method06177() {
      this.method06180();
      var var1 = this.field13892.method05741();

      for (Script var3 : var1) {
         ScriptSettingsAdapter.method00983(var3);
         this.method06181(var3, false);
      }

      this.method06223();
      if (ScriptShaderManager.method10929() || ScriptManager.method01293()) {
         ScriptShaderManager.method10950();
      }

      for (String var6 : this.field13892.method05743()) {
         ScriptLogManager.INSTANCE.method08091(2, "[script] " + var6);
      }

      for (String var7 : this.field13892.method05735()) {
         ScriptLogManager.INSTANCE.method08091(1, "[script] " + var7 + ": миксины изменились — нужен перезапуск Minecraft");
      }

      ScriptLogManager.INSTANCE.method08092(0, "[script] загружено скриптов: " + var1.size());
      return var1.size();
   }

   public boolean method06178(LoadedScript var1) {
      ScriptSourceLoader var2 = ScriptLifecycle.method03298(var1.method03393());
      return var2 != null && this.field13892.method05735().contains(var2.method08400());
   }

   private void method06179() {
      for (String var2 : ScriptMixinManager.method08299()) {
         ScriptLogManager.INSTANCE.method08091(2, "[script] миксины: " + var2);
      }

      if (!ScriptMixinManager.method08297().isEmpty()) {
         ScriptLogManager.INSTANCE.method08092(0, "[script] вшито миксинов скриптов: " + ScriptMixinManager.method08297().size());
      }
   }

   private void method06180() {
      this.field13896 = true;

      for (int var1 = this.field13890.size() - 1; var1 >= 0; var1--) {
         LoadedScript var2 = this.field13890.get(var1);
         if (!var2.method03396()) {
            this.method06185(var2);
            ScriptSettingsAdapter.method00982(var2.method03393());
            this.field13891.method11767().method01570(var2.method03393());
            if (var2.method03398() != null) {
               ModuleManager.INSTANCE.method08167(var2.method03398());
               var2.method03399(null);
            }

            this.field13890.remove(var1);
         }
      }

      this.field13891.method11767().method01567();
      ScriptShaderManager.method10940();
      FontRegistry.method02894();
      MeshBufferUtils.method07832();
      this.field13892.method05745();
      this.field13896 = false;
   }

   public LoadedScript method06181(Script var1, boolean var2) {
      LoadedScript var3 = new LoadedScript(var1, var2);
      this.field13890.add(var3);
      return var3;
   }

   public LoadedScript method06182(String var1) {
      for (int var2 = 0; var2 < this.field13890.size(); var2++) {
         LoadedScript var3 = this.field13890.get(var2);
         if (var3.method03400().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public boolean method06183(LoadedScript var1) {
      return var1.method03392() ? this.method06185(var1) : this.method06184(var1);
   }

   public boolean method06184(LoadedScript var1) {
      if (var1.method03392()) {
         return true;
      }

      var1.method03397(true);
      this.field13894++;
      boolean var2 = this.method06227(var1, var1.method03393()::activate);
      if (var1.method03398() != null) {
         var1.method03398().method10295(var1.method03392());
      }

      this.method06222(var1, var1.method03392());
      return var2;
   }

   public boolean method06185(LoadedScript var1) {
      if (!var1.method03392()) {
         return true;
      }

      var1.method03397(false);
      this.field13894--;
      boolean var2 = this.method06227(var1, var1.method03393()::deactivate);
      this.field13891.method11768(var1.method03393());
      ScriptScheduledTasks.method06951(var1.method03393());
      CommandLineParser.method05588(var1.method03393());
      this.field13891.method11767().method01574(var1.method03393());
      ScriptSettingsAdapter.method00982(var1.method03393());
      if (var1.method03398() != null) {
         var1.method03398().method10295(false);
      }

      this.method06222(var1, false);
      return var2;
   }

   @Subscribe
   private void method06186(PlayerUpdateEvent var1) {
      ScriptItemSnapshotCache.method11761();
      this.field13891.method11771();

      for (int var2 = 0; var2 < this.field13890.size(); var2++) {
         ScriptModule var3 = this.field13890.get(var2).method03398();
         if (var3 != null) {
            var3.method10294();
         }
      }

      this.field13891.method11767().method01561();
      if (this.field13894 != 0) {
         ScriptScheduledTasks.method06950();

         for (int var4 = 0; var4 < this.field13890.size(); var4++) {
            LoadedScript var5 = this.field13890.get(var4);
            if (var5.method03392()) {
               this.method06227(var5, var5.method03393()::onTick);
            }
         }

         this.field13891.method11770().method04782("tick", var1, null, false);
         this.field13893.method08966();
      }
   }

   @Subscribe
   private void method06187(PlayerInputEvent var1) {
      this.method06219("update", var1, null, false);
   }

   @Subscribe
   private void method06188(PreMovementPacketEvent var1) {
      this.method06219("motion", var1, null, false);
   }

   @Subscribe
   private void method06189(EntityJumpEvent var1) {
      this.method06219("jump", var1, this.method06216(var1.method03779()), false);
   }

   @Subscribe
   private void method06190(AttackEntityEvent var1) {
      if (var1.method09431() == AttackEntityEvent.Nested264.PRE) {
         this.method06219("attack", var1, this.method06216(var1.method09434()), true);
      }
   }

   @Subscribe
   private void method06191(KeyInputEvent var1) {
      if (var1.method05884() != InputAction.RELEASE) {
         for (int var2 = 0; var2 < this.field13890.size(); var2++) {
            LoadedScript var3 = this.field13890.get(var2);
            if (var3.method03392()) {
               LoadedScript var4 = var3;
               this.method06227(var4, () -> ScriptSettingsAdapter.method00971(var4.method03393(), var1.method05887()));
            }
         }
      }

      String var5 = var1.method05884() == InputAction.RELEASE ? "keyRelease" : "key";
      this.method06219(var5, var1, var1.method05887(), false);
   }

   @Subscribe
   private void method06192(TickEvent var1) {
      if (this.field13892.method05749()) {
         ScriptLogManager.INSTANCE.method08091(0, "[script] джарники изменились, перезагружено скриптов: " + this.method06177());
      }

      this.method06219("gameTick", var1, null, false);
   }

   @Subscribe
   private void method06193(PostPlayerInputEvent var1) {
      this.method06219("postUpdate", var1, this.method06217(var1), false);
   }

   @Subscribe
   private void method06194(PlayerInputEvent var1) {
      this.method06219("input", var1, this.method06217(var1), false);
   }

   @Subscribe
   private void method06195(EntityMoveEvent var1) {
      this.method06219("move", var1, var1.method10059(), false);
   }

   public boolean method06196(int var1, boolean var2, double var3, double var5) {
      if (this.field13894 == 0) {
         return false;
      }

      boolean var7 = this.field13893.method08964(var1, var2, var3, var5);
      return this.field13891.method11770().method04784("mouse", new Object[]{var1, var2 ? "press" : "release", var3, var5}, true) || var7;
   }

   public boolean method06197(double var1, double var3) {
      return this.field13894 != 0 && this.field13893.method08963(var1, var3);
   }

   public boolean method06198(int var1, int var2, int var3, boolean var4) {
      return this.field13894 != 0 && this.field13893.method08967(var1, var2, var3, var4);
   }

   public void method06199(boolean var1) {
      if (this.field13894 != 0) {
         this.field13893.method08969(var1);
      }
   }

   public boolean method06200(Component var1, GuiMessageSource var2) {
      if (this.field13894 != 0 && !this.field13895 && mc.isSameThread()) {
         this.field13895 = true;

         try {
            boolean var3 = this.field13893.method08970(var1, var2);
            if (this.field13891.method11770().method04791("chatReceive")) {
               var3 = this.field13891.method11770().method04784("chatReceive", var1 == null ? "" : var1.getString(), true) || var3;
            }

            return var3;
         } finally {
            this.field13895 = false;
         }
      } else {
         return false;
      }
   }

   @Subscribe
   private void method06201(ServerHeldSlotEvent var1) {
      this.method06219("slotChange", var1, var1.method09334(), true);
   }

   @Subscribe
   private void method06202(SelectedSlotEvent var1) {
      this.method06219("hotbarSelect", var1, var1.method03512(), false);
   }

   @Subscribe
   private void method06203(ContainerClickEvent var1) {
      this.method06219("clickSlot", var1, new Object[]{var1.method03777(), var1.method03773(), var1.method03776()}, true);
   }

   @Subscribe
   private void method06204(ItemUseStartEvent var1) {
      this.method06219("useItem", var1, new Object[]{var1.method08456(), var1.method08459()}, false);
   }

   @Subscribe
   private void method06205(ItemUseEvent var1) {
      this.method06219("interactItem", var1, var1.method02445(), true);
   }

   @Subscribe
   private void method06206(BlockBreakStartEvent var1) {
      this.method06219("destroyBlock", var1, new Object[]{var1.method08305(), var1.method08306()}, false);
   }

   @Subscribe
   private void method06207(BlockPlaceEvent var1) {
      this.method06219("placeBlock", var1, var1.method10967(), false);
   }

   @Subscribe
   private void method06208(BlockUpdateEvent var1) {
      this.method06219("newBlock", var1, new Object[]{var1.method06654(), var1.method06658()}, false);
   }

   @Subscribe
   private void method06209(WorldLoadEvent var1) {
      this.method06219("joinWorld", var1, null, false);
   }

   @Subscribe
   private void method06210(EntityDeathEvent var1) {
      this.method06219("death", var1, this.method06216(var1.method11303()), false);
   }

   @Subscribe
   private void method06211(ChatSendEvent var1) {
      this.method06219("sendMessage", var1, var1.method11711(), true);
   }

   @Subscribe
   private void method06212(TotemPopEvent var1) {
      this.method06219("useTotem", var1, new Object[]{this.method06216(var1.method01501()), ScriptEntitiesAdapter.method09078(var1.method01507())}, false);
   }

   @Subscribe
   private void method06213(EntityVelocityEvent var1) {
      this.method06219(
         "entityVelocity",
         var1,
         new Object[]{this.method06216(var1.method02128()), new Point(var1.method02131().x, var1.method02131().y, var1.method02131().z)},
         false
      );
   }

   @Subscribe
   private void method06214(ToggleStateEvent var1) {
      this.method06219(
         "toggleModule", var1, new Object[]{this.method06215(var1.method06763()), var1.method06761() == ToggleStateEvent.Nested198.ENABLE}, false
      );
   }

   private String method06215(Object var1) {
      if (var1 instanceof ToggleableModule var3) {
         return var3.method03925();
      } else if (var1 instanceof sg.ec.Setting var2) {
         return var2.method03024();
      } else {
         return var1 == null ? "" : var1.toString();
      }
   }

   private Object method06216(Object var1) {
      return var1 instanceof Entity var2 ? this.field13891.method11767().method01576().entities().of(var2.getId()) : null;
   }

   private Object[] method06217(PlayerMovementEvent var1) {
      return new Object[]{var1.method11161(), var1.method11166(), var1.method11162(), var1.method11160(), var1.method11165()};
   }

   @Subscribe
   private void method06218(PacketEvent var1) {
      boolean var2 = var1.method10899();
      String var3 = var2 ? "packetSend" : "packetReceive";
      if (this.field13894 != 0 && this.field13891.method11770().method04791(var3)) {
         this.field13891.method11770().method04782(var3, var1, ScriptNetworkAdapter.method03446(var1.method10897(), !var2), true);
      }
   }

   private void method06219(String var1, Event var2, Object var3, boolean var4) {
      if (this.field13894 != 0 && this.field13891.method11770().method04791(var1)) {
         this.field13891.method11770().method04782(var1, var2, var3, var4);
      }
   }

   @Subscribe
   private void method06220(Render3DEvent var1) {
      if (this.field13894 != 0) {
         ScriptRender3DAdapter var2 = this.field13891.method11764();
         var2.method09684(var1.method00996(), var1.method00985(), var1.method00994(), var1.method00984().getGameTimeDeltaPartialTick(true));

         try {
            for (int var3 = 0; var3 < this.field13890.size(); var3++) {
               LoadedScript var4 = this.field13890.get(var3);
               if (var4.method03392()) {
                  LoadedScript var5 = var4;
                  this.method06227(var5, () -> var5.method03393().onRender3D(var2.method09694()));
               }
            }
         } finally {
            var2.method09690();
         }

         if (this.field13891.method11770().method04791("render3d")) {
            Object[] var9 = new Object[]{
               var1.method00996(), var1.method00985().method07407(EffectRenderPipelines.method05562()), var1.method00994(), var1.method00986()
            };
            this.field13891.method11770().method04782("render3d", var1, var9, false);
         }
      }
   }

   @Subscribe
   private void method06221(HudRenderEvent var1) {
      ScriptManager.method01295();
      if (this.field13894 != 0) {
         GuiGraphics var2 = var1.method05424();
         if (var2 != null) {
            this.field13891.method11771();
            ScriptRender2DAdapter var3 = this.field13891.method11765();
            var3.method04307(var2);

            try {
               for (int var4 = 0; var4 < this.field13890.size(); var4++) {
                  LoadedScript var5 = this.field13890.get(var4);
                  if (var5.method03392()) {
                     LoadedScript var6 = var5;
                     this.method06227(var6, () -> var6.method03393().onRender2D(var3.method04312()));
                  }
               }
            } finally {
               var3.method04326();
            }
         }
      }
   }

   private void method06222(LoadedScript var1, boolean var2) {
      if (!this.field13896) {
         ScriptSettingsAdapter.method00972(var1.method03393(), var2);
      }
   }

   private void method06223() {
      for (int var1 = 0; var1 < this.field13890.size(); var1++) {
         LoadedScript var2 = this.field13890.get(var1);
         if (!var2.method03396() && var2.method03398() == null) {
            ScriptModule var3 = new ScriptModule(var2);
            var2.method03399(var3);
            ModuleManager.INSTANCE.method05140(var3);
            if (ScriptSettingsAdapter.method00974(var2.method03393())) {
               var3.method03939(true);
            }
         }
      }

      KeyBindingManager.INSTANCE.method11748();
      if (MiranWare.getInstance() != null && MiranWare.getInstance().getMenuScreen() != null) {
         MiranWare.getInstance().getMenuScreen().method09961(ModuleCategory.Scripts);
      }
   }

   public List<Setting<?>> method06224(LoadedScript var1) {
      return ScriptSettingsAdapter.method00977(var1.method03393());
   }

   public boolean method06225(LoadedScript var1, String var2, String var3) {
      var var4 = ScriptSettingsAdapter.method00981(var1.method03393(), var2);
      if (var4 == null) {
         return false;
      }

      boolean var5 = ScriptSettingsAdapter.method00979(var4, var3);
      ScriptSettingsAdapter.method00982(var1.method03393());
      return var5;
   }

   void method06226(Object var1, Throwable var2) {
      for (int var3 = 0; var3 < this.field13890.size(); var3++) {
         LoadedScript var4 = this.field13890.get(var3);
         if (var4.method03393() == var1) {
            this.method06228(var4, var2);
            return;
         }
      }
   }

   private boolean method06227(LoadedScript var1, Runnable var2) {
      ScriptSourceLoader var3 = ScriptLifecycle.method03294(var1.method03393());

      try {
         var2.run();
         return true;
      } catch (Throwable var9) {
         this.method06228(var1, var9);
         return false;
      } finally {
         ScriptLifecycle.method03293(var3);
      }
   }

   private void method06228(LoadedScript var1, Throwable var2) {
      if (var1.method03392()) {
         this.field13894--;
      }

      var1.method03394();
      if (var1.method03398() != null) {
         var1.method03398().method10295(false);
      }

      this.field13891.method11768(var1.method03393());
      this.field13891.method11767().method01574(var1.method03393());
      String var3 = var2.getClass().getSimpleName() + (var2.getMessage() == null ? "" : ": " + var2.getMessage());
      ScriptLogManager.INSTANCE.method08091(2, "[script] " + var1.method03400() + " отключён — " + var3);
   }

   public SortableArrayList<LoadedScript> method06229() {
      return this.field13890;
   }

   public ScriptHostImpl method06230() {
      return this.field13891;
   }

   public ScriptDirectoryWatcher method06231() {
      return this.field13892;
   }

   public ScriptEventAdapter method06232() {
      return this.field13893;
   }

   public int method06233() {
      return this.field13894;
   }

   public boolean method06234() {
      return this.field13895;
   }

   public boolean method06235() {
      return this.field13896;
   }

   public String method06236() {
      return this.field13897;
   }

   public String method06237() {
      return this.field13898;
   }
}
