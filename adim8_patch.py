#!/usr/bin/env python3
# MiranWare 1.21.11 port - adim 8 yama scripti
# Kullanim (repo kokunde):  python3 adim8_patch.py     (adim7_patch.py'den SONRA)
# Idempotent: iki kez calistirmak zararsiz. Uyusmayan duzeltmeleri rapor eder.
import os, re, sys

ROOT = os.path.join(os.getcwd(), "src", "main", "java")
RES = os.path.join(os.getcwd(), "src", "main", "resources")
if not os.path.isdir(ROOT):
    print("HATA: repo kokunde calistir (src/main/java bulunamadi)"); sys.exit(1)

cache = {}   # rel -> (text_lf, crlf)
def load(rel, base=ROOT):
    k = (base, rel)
    if k not in cache:
        p = os.path.join(base, rel)
        if not os.path.isfile(p):
            cache[k] = None
        else:
            raw = open(p, "rb").read().decode("utf-8")
            crlf = "\r\n" in raw
            cache[k] = [raw.replace("\r\n", "\n"), crlf, False]
    return cache[k]

applied = 0
missing = []

def sub(rel, old, new, regex=False, count=0, base=ROOT):
    """old -> new. Zaten uygulanmissa sessiz gecer."""
    global applied
    e = load(rel, base)
    if e is None:
        missing.append((rel, "dosya yok")); return
    s = e[0]
    if regex:
        n = len(re.findall(old, s, flags=re.S))
        if n:
            s2 = re.sub(old, new, s, count=count, flags=re.S)
        else:
            s2 = s
    else:
        n = s.count(old)
        s2 = s.replace(old, new) if n else s
    if n:
        e[0] = s2; e[2] = True; applied += n
    else:
        # uygulanmis mi? (new metni var mi)
        chk = new if not regex else None
        if chk is not None and chk in s:
            return
        if regex:
            return  # regex'lerde sessiz
        missing.append((rel, "bulunamadi: " + old[:70].replace("\n", " ")))

def gsub(pat, rep):
    """tum .java dosyalarinda regex"""
    global applied
    for dp, dn, fn in os.walk(ROOT):
        for n in fn:
            if not n.endswith(".java"): continue
            rel = os.path.relpath(os.path.join(dp, n), ROOT)
            e = load(rel)
            s2, c = re.subn(pat, rep, e[0])
            if c:
                e[0] = s2; e[2] = True; applied += c

def write_new(rel, text, base=ROOT):
    p = os.path.join(base, rel)
    os.makedirs(os.path.dirname(p), exist_ok=True)
    open(p, "wb").write(text.replace("\n", "\r\n").encode("utf-8"))

# ---------------------------------------------------------------- global
# adim7'nin yanlis tahmini: 1.21.11 Camera'da position()/xRot()/yRot() var (getPosition/getYRot/getXRot yok)
gsub(r"\.getMainCamera\(\)\.getPosition\(\)", ".getMainCamera().position()")
gsub(r"\.getMainCamera\(\)\.getYRot\(\)", ".getMainCamera().yRot()")
gsub(r"\.getMainCamera\(\)\.getXRot\(\)", ".getMainCamera().xRot()")
# DataFixers / yeni ad: handleContainerInput -> handleInventoryMouseClick (satir bolunmus olanlar da)
gsub(r"\.handleContainerInput\(", ".handleInventoryMouseClick(")
# Blaze3D.openUri/openPath -> Util.getPlatform()
gsub(r"com\.mojang\.blaze3d\.Blaze3D\.openUri\(", "net.minecraft.Util.getPlatform().openUri(")
gsub(r"com\.mojang\.blaze3d\.Blaze3D\.openPath\(", "net.minecraft.Util.getPlatform().openPath(")
# paket erisimcileri
gsub(r"(\bvar\d+)\.entityIds\(\)", r"\1.getEntityIds()")
# registry
gsub(r"\bRegistryLayer\.WORLD\b", "RegistryLayer.WORLDGEN")
gsub(r"\bRegistryDataLoader\.WORLD_REGISTRIES\b", "RegistryDataLoader.WORLDGEN_REGISTRIES")
gsub(r"createVanillaPackSource\(\)\.fullResources\(\)", "createVanillaPackSource()")
# chat
gsub(r"\.addClientSystemMessage\(", ".addMessage(")

# ---------------------------------------------------------------- baritone
f = "hex/api/baritone/api/utils/BlockOptionalMeta.java"
sub(f, "super(var1, var2, var3, var4, var5, var6, var7, var8, var10, var11);",
       "super(var1, var2, var3, var4, var5, var6, var7, var8, var10, var11, null);")
sub(f, "RegistryDataLoader.load(var0, sxxx, RegistryDataLoader.WORLDGEN_REGISTRIES, ForkJoinPool.commonPool()).join()",
       "RegistryDataLoader.load(var0, sxxx, RegistryDataLoader.WORLDGEN_REGISTRIES)")

f = "hex/api/baritone/process/ExploreProcess.java"
sub(f, "Objects.requireNonNull(var1);\n         super();\n", "super();\n         Objects.requireNonNull(var1);\n")

sub("hex/api/baritone/api/Settings.java", ".getChat().addPlayerMessage(var1x, null, var2);", ".getChat().addMessage(var1x, null, var2);")
sub("hex/api/baritone/command/defaults/RenderCommand.java", "levelRenderer.resetLevelRenderData();", "levelRenderer.allChanged();")

# ---------------------------------------------------------------- ScriptWorldGenerator
f = "sg/ec/ScriptWorldGenerator.java"
sub(f, "RegistryDataLoader.load(var0, var3, RegistryDataLoader.WORLDGEN_REGISTRIES, Runnable::run).join()",
       "RegistryDataLoader.load(var0, var3, RegistryDataLoader.WORLDGEN_REGISTRIES)")
sub(f, "RandomState.create(ScriptWorldGenerator.this.field14661.lookupOrThrow(net.minecraft.core.registries.Registries.NOISE), var2, var5.value())",
       "RandomState.create(var5.value(), ScriptWorldGenerator.this.field14661.lookupOrThrow(net.minecraft.core.registries.Registries.NOISE), var2)")
sub(f, "this.field14675.createClimateSampler(net.minecraft.world.level.levelgen.densityfunction.SamplerContext.builder().build())",
       "this.field14675.sampler()")

# ---------------------------------------------------------------- RegistryDataMerger
sub("sg/ec/RegistryDataMerger.java", r",\s*Util\.backgroundExecutor\(\)\s*\)\s*\.join\(\)", ")", regex=True)

# ---------------------------------------------------------------- Bot*
f = "sg/ec/BotWorldState.java"
sub(f, "TelemetryEventSender.DISABLED, false, null, null, var3.method00070().method08001()", "TelemetryEventSender.DISABLED, false, null, null")
sub(f, "var1.getZ(), var1.lightData());", "var1.getZ(), var1.getLightData());")
sub(f, r"\n\s*var1\.onlineMode\(\),", "", regex=True)
sub(f, "var1.entityIds()", "var1.getEntityIds()")
sub("sg/ec/BotSessionManager.java", r"\n\s*var2\.onlineMode\(\),", "", regex=True)

f = "sg/ec/BotClientLevel.java"
sub(f, "Minecraft.getInstance().levelExtractor,", "Minecraft.getInstance().levelRenderer,")
sub(f, "      var1.flipUpdateTrackingSets();\n", "")
sub(f, "var1.chunkData();\n      this.getChunkSource().replaceWithPacketData(var2, var3, var4);\n      this.applyLight(var2, var3, var1.lightData());",
       "var1.getChunkData();\n      this.getChunkSource().replaceWithPacketData(var2, var3, var4.getReadBuffer(), var4.getHeightmaps(), var4.getBlockEntitiesTagsConsumer(var2, var3));\n      this.applyLight(var2, var3, var1.getLightData());")
sub(f, "var3.skyYMask(), var3.emptySkyYMask(), var3.skyUpdates().iterator()", "var3.getSkyYMask(), var3.getEmptySkyYMask(), var3.getSkyUpdates().iterator()")
sub(f, "var3.blockYMask(), var3.emptyBlockYMask(), var3.blockUpdates().iterator()", "var3.getBlockYMask(), var3.getEmptyBlockYMask(), var3.getBlockUpdates().iterator()")

sub("sg/ec/BotLoginPacketListener.java", "      this.field00729.method00070().method07959(var1.sessionId());\n", "")

f = "sg/ec/BotPlayPacketListener.java"
sub(f, r"(handleSetEntityData\(ClientboundSetEntityDataPacket var1\) \{\s*if \(var1)\.getId\(\)", r"\1.id()", regex=True)
sub(f, r"(var\d+)\.getXa\(\)", r"\1.getMovement().x", regex=True)
sub(f, r"(var\d+)\.getYa\(\)", r"\1.getMovement().y", regex=True)
sub(f, r"(var\d+)\.getZa\(\)", r"\1.getMovement().z", regex=True)

sub("sg/ec/Velocity.java", "ClientboundSetEntityMotionPacket var3 && var3.id() !=", "ClientboundSetEntityMotionPacket var3 && var3.getId() !=")
sub("sg/ec/AntiThorns.java", "if (var2.id() == mc.player.getId())", "if (var2.getId() == mc.player.getId())")
f = "sg/ec/ScriptNetworkAdapter.java"
sub(f, "Vec3 sx = var3.movement();\n         var0.put(field07669, var3.id());", "Vec3 sx = var3.getMovement();\n         var0.put(field07669, var3.getId());")
sub(f, "var10.unsignedContent().orElse(null)", "var10.unsignedContent()")

# ---------------------------------------------------------------- mixins
sub("sg/mx/ClientConfigurationPacketListenerImplMixin.java", "method03167(var1.tags())", "method03167(var1.getTags())")
f = "sg/mx/FishingHookRendererMixin.java"
sub(f, ".getNearPlane(var6)", ".getNearPlane()")
f = "sg/mx/LocalPlayerMixin.java"
sub(f, 'at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;screen()Lnet/minecraft/client/gui/screens/Screen;")\n   )\n   private Screen isolateBotScreen(Gui var1) {\n      return this.owner() ? var1.screen() : null;',
       'at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;screen:Lnet/minecraft/client/gui/screens/Screen;", opcode = 180)\n   )\n   private Screen isolateBotScreen(net.minecraft.client.Minecraft var1) {\n      return this.owner() ? var1.screen : null;')
f = "sg/mx/MinecraftMixin_1215.java"
sub(f, 'target = "Lnet/minecraft/client/player/LocalPlayer;swing(Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/item/component/SwingAnimation;Z)Z"',
       'target = "Lnet/minecraft/client/player/LocalPlayer;swing(Lnet/minecraft/world/InteractionHand;)V"')
sub(f, "private boolean hmiDoItemUse(LocalPlayer var1, InteractionHand var2, net.minecraft.world.item.component.SwingAnimation var4, boolean var5) {",
       "private void hmiDoItemUse(LocalPlayer var1, InteractionHand var2) {")
sub(f, "return var1.swing(var2, var4, var5);", "var1.swing(var2);")
sub(f, "private void hmiDoAttack(CallbackInfoReturnable<Boolean> var1) {", "private void hmiDoAttack(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<Boolean> var1) {")

# FogRendererMixin: FogData.color 1.21.11'de yok -> derlemeden cikar, mixins.json'dan sil
mj = load("miranware.mixins.json", RES)
if mj:
    s2 = re.sub(r'\n\s*"FogRendererMixin",?', "", mj[0])
    s2 = s2.replace(",\n  ]", "\n  ]")
    if s2 != mj[0]:
        mj[0] = s2; mj[2] = True; applied += 1

# ---------------------------------------------------------------- render/gui
sub("sg/ec/RenderUtils.java", "      var2.scoreText = null;\n", "")
sub("sg/ec/RenderUtils.java", "var1.entity(this.field05200,", "var1.submitEntityRenderState(this.field05200,")
sub("sg/ec/Beautification.java", "sxxxx.extractRenderState(var2, var2.guiWidth(), sxxxxxx, sxxxxxxx);", "sxxxx.render(var2, var2.guiWidth(), sxxxxxx, sxxxxxxx);")
sub("sg/ec/Beautification.java", "var1.item(var3, var7, var5, var6, var4.seed());", "var1.renderItem(var3, var7, var5, var6, var4.seed());")
sub("sg/ec/AutoSwapWheelScreen.java", "var1.item(var11, (int)(var9 - field08600), (int)(var10 - field08601));", "var1.renderItem(var11, (int)(var9 - field08600), (int)(var10 - field08601));")
sub("sg/ec/InventoryEntityRenderHook.java", "InventoryScreen.extractEntityInInventoryFollowsMouse(", "InventoryScreen.renderEntityInInventoryFollowsMouse(")
sub("sg/ec/HudRenderTargetHooks.java", "return var0.mainRenderTarget();", "return net.minecraft.client.Minecraft.getInstance().getMainRenderTarget();")
sub("sg/ec/ItemTextureAtlas.java", "writeToTexture(this.field13950.getTexture(), this.field13951, 0, 0, var2 % 16 * 16, var2 / 16 * 8);",
    "writeToTexture(this.field13950.getTexture(), this.field13951, 0, 0, var2 % 16 * 16, var2 / 16 * 8, this.field13951.getWidth(), this.field13951.getHeight(), 0, 0);")
sub("sg/ec/TexturePixelReader.java", "return !sx.isClosed() && var1.test(sx);", "return var1.test(sx);")
sub("sg/ec/PanicController.java", ".getWindow().isExclusiveFullscreen()", ".getWindow().isFullscreen()")
sub("sg/ec/CapturedPlayer.java", "this.field06964.swingAnimation = var1.getSwingAnimation(0.0F);", "this.field06964.attackTime = var1.getAttackAnim(0.0F);")
sub("sg/ec/RotationRenderHooks.java", "var0.getSwingAnimation(0.0F) > 0.0F", "var0.getAttackAnim(0.0F) > 0.0F")
f = "sg/ec/CrosshairRenderHooks.java"
sub(f, "PngEncoder.method00661(var8.getPixelBytes(), var6, var7)", "PngEncoder.method00661(abgrToRgbaBuffer(var8), var6, var7)")
if "abgrToRgbaBuffer(NativeImage" not in (load(f) or [""])[0]:
  sub(f, "   private CrosshairRenderHooks() {\n   }\n",
"""   private CrosshairRenderHooks() {
   }

   private static java.nio.ByteBuffer abgrToRgbaBuffer(NativeImage var0) {
      java.nio.ByteBuffer var1 = java.nio.ByteBuffer.allocate(var0.getWidth() * var0.getHeight() * 4).order(java.nio.ByteOrder.LITTLE_ENDIAN);

      for (int var2 = 0; var2 < var0.getHeight(); var2++) {
         for (int var3 = 0; var3 < var0.getWidth(); var3++) {
            var1.putInt(var0.getPixel(var3, var2));
         }
      }

      var1.flip();
      return var1;
   }
""")

# ---------------------------------------------------------------- bot/world/gameplay
sub("sg/ec/GpsManager.java", ".getMainCamera().getYRot()", ".getMainCamera().yRot()")
sub("sg/ec/SimulatedPlayerInput.java", "var5.typeHolder().tags().toList()", "var5.getType().builtInRegistryHolder().tags().toList()")
sub("sg/ec/AntiCrash.java", "int sx = var3.count();", "int sx = var3.getCount();")
sub("sg/ec/AntiCrash.java", "float sxx = var3.xDist();", "float sxx = var3.getXDist();")
sub("sg/ec/AntiCrash.java", "float sxxx = var3.yDist();", "float sxxx = var3.getYDist();")
sub("sg/ec/AntiCrash.java", "float sxxxx = var3.zDist();", "float sxxxx = var3.getZDist();")
sub("sg/ec/AntiCrash.java", "Math.max(var3.xMaxSpeed(), Math.max(var3.yMaxSpeed(), var3.zMaxSpeed()))", "var3.getMaxSpeed()")
sub("sg/ec/AutoKeyFinder.java", "mc.gameMode.interact(mc.player, this.field24809, new EntityHitResult(", "mc.gameMode.interactAt(mc.player, this.field24809, new EntityHitResult(")
sub("sg/ec/InventoryMove.java", "InputConstants.isKeyDown(var1x.getDefaultKey().getValue())", "InputConstants.isKeyDown(net.minecraft.client.Minecraft.getInstance().getWindow(), var1x.getDefaultKey().getValue())")
sub("sg/ec/BlockBreakManager.java", "mc.gui.overlay() == null", "mc.getOverlay() == null")
sub("sg/ec/BlockBreakManager.java", "mc.level.addBreakingBlockEffects(var1.getBlockPos(), var1.getDirection(), false);", "mc.particleEngine.crack(var1.getBlockPos(), var1.getDirection());")
sub("sg/ec/SplashPotionTracker.java", "var7.isInstantaneous()", "var7.isInstantenous()")
sub("sg/ec/ScriptEffectsAdapter.java", "new ItemParticleOption(var3, var4.getItem())", "new ItemParticleOption(var3, var4)")
sub("sg/ec/AutoBuyManager.java", "var3.command() + \"\\\"\"", "var3.getCommand() + \"\\\"\"")
f = "sg/ec/AutoBuyItemMatcher.java"
sub(f, "var4.nonEmptyItemCopyStream().mapToLong", "var4.nonEmptyStream().mapToLong")
sub(f, "var5.itemCopies().mapToLong", "var5.items().stream().mapToLong")
sub("sg/ec/ScriptContextImpl.java", "   @Override\n   public boolean canUseCommandBlocks()", "   public boolean canUseCommandBlocks()")

# chat satir (Line.parent() 1.21.11'de yok)
sub("sg/ec/BetterChat.java", "var3 == null && var1.parent() != null", "var3 == null && false")
sub("sg/ec/BetterChat.java", "var3 = var1.parent().content();", "var3 = null;")
sub("sg/ec/ChatMessageHooks.java", "removeIf(var1x -> var1x.parent() == var7)", "removeIf(var1x -> false)")

# esyalar (26.x Items.DYE/DYED_* yok)
COLORS = ["WHITE","ORANGE","MAGENTA","LIGHT_BLUE","YELLOW","LIME","PINK","GRAY","LIGHT_GRAY","CYAN","PURPLE","BLUE","BROWN","GREEN","RED","BLACK"]
shulkers = "java.util.List.<net.minecraft.world.item.Item>of(" + ", ".join("Items.%s_SHULKER_BOX" % c for c in COLORS) + ")"
bundles = "java.util.List.<net.minecraft.world.item.Item>of(" + ", ".join("Items.%s_BUNDLE" % c for c in COLORS) + ")"
sub("sg/ec/EnchantmentIds.java", "var var0 = Items.DYED_SHULKER_BOX.asList();", "var var0 = " + shulkers + ";")
sub("sg/ec/EnchantmentIds.java", "Items.DYED_BUNDLE.asList().toArray(new Item[0])", bundles + ".toArray(new Item[0])")
sub("sg/ec/CustomEnchantmentAliases.java", "Items.DYE.pick(DyeColor.ORANGE)", "Items.ORANGE_DYE")
sub("sg/ec/CustomEnchantmentAliases.java", "Items.DYED_SHULKER_BOX.pick(var1)", "net.minecraft.world.level.block.ShulkerBoxBlock.getBlockByColor(var1).asItem()")
sub("sg/ec/ConfirmScreenAuctionScanner.java", "Items.STAINED_GLASS_PANE.pick(var5.confirmed() ? DyeColor.LIME : DyeColor.RED)", "(var5.confirmed() ? Items.LIME_STAINED_GLASS_PANE : Items.RED_STAINED_GLASS_PANE)")

# ---------------------------------------------------------------- ScriptManager (Pack.ResourcesSupplier 1.21.11)
f = "sg/ec/ScriptManager.java"
sub(f, """         @Override
         public net.minecraft.server.packs.PackMetadataResources openMetadata(PackLocationInfo var1) {
            return new PathPackResources(var1, var0);
         }

         @Override
         public java.util.stream.Stream<PackResources> openResources(PackLocationInfo var1, Metadata var2) {
            return java.util.stream.Stream.of(new PathPackResources(var1, var0));
         }""",
"""         @Override
         public PackResources openPrimary(PackLocationInfo var1) {
            return new PathPackResources(var1, var0);
         }

         @Override
         public PackResources openFull(PackLocationInfo var1, Metadata var2) {
            return new PathPackResources(var1, var0);
         }""")

# ---------------------------------------------------------------- stub'lar
def stub(rel, body):
    write_new(rel, body)
STUB_HDR = "package sg.ec;\n\n// TODO(port 1.21.11): 26.x render API'sine bagli orijinal sinif cikarilmisti; derleme icin bos govde (gorsel ozellik calismaz).\n"
stub("sg/ec/TextureGuiRenderState.java", STUB_HDR + "public final class TextureGuiRenderState {\n   public TextureGuiRenderState(Object... args) {\n   }\n}\n")
stub("sg/ec/GuiShadowRenderState.java", STUB_HDR + "public final class GuiShadowRenderState {\n   public GuiShadowRenderState(Object... args) {\n   }\n}\n")
stub("sg/ec/PixelReader.java", STUB_HDR + "public final class PixelReader {\n   private PixelReader() {\n   }\n\n   public static void method01300(int var0, int var1, java.util.function.IntConsumer var2) {\n   }\n}\n")
sub("sg/ec/RoundedBorderRenderState.java", "   private RoundedBorderRenderState() {\n   }", "   public RoundedBorderRenderState(Object... args) {\n   }")
sub("sg/ec/EffectRenderPipelines.java", "public static final Object field11857 = null;", "public static final net.minecraft.client.renderer.rendertype.RenderType field11857 = null;")
sub("sg/ec/EffectRenderPipelines.java", "public static final Object field11856 = null;", "public static final net.minecraft.client.renderer.rendertype.RenderType field11856 = null;")

# ---------------------------------------------------------------- build.gradle
bg = os.path.join(os.getcwd(), "build.gradle")
if os.path.isfile(bg):
    raw = open(bg, "rb").read().decode("utf-8"); crlf = "\r\n" in raw
    s = raw.replace("\r\n", "\n"); o = s
    for n in ["TextureGuiRenderState", "GuiShadowRenderState", "PixelReader"]:
        s = s.replace("\t\t\texclude 'sg/ec/%s.java'\n" % n, "")
    if "FogRendererMixin" not in s:
        s = s.replace("\t\t\t// adim 4\n", "\t\t\t// adim 8: FogData.color 1.21.11'de yok\n\t\t\texclude 'sg/mx/FogRendererMixin.java'\n\t\t\t// adim 4\n", 1)
    if s != o:
        open(bg, "wb").write((s.replace("\n", "\r\n") if crlf else s).encode("utf-8")); applied += 1

# ---------------------------------------------------------------- yaz
changed = 0
for (base, rel), e in cache.items():
    if e and e[2]:
        t = e[0].replace("\n", "\r\n") if e[1] else e[0]
        open(os.path.join(base, rel), "wb").write(t.encode("utf-8")); changed += 1
print("uygulanan duzeltme:", applied, "| degisen dosya:", changed)
if missing:
    print("UYUSMAYAN (%d):" % len(missing))
    for a, b in missing: print("  ", a, "-", b)
