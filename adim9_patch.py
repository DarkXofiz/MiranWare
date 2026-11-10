#!/usr/bin/env python3
# MiranWare 1.21.11 port - adim 9 yama scripti (adim8'den SONRA). Idempotent.
import os, re, sys
ROOT = os.path.join(os.getcwd(), "src", "main", "java")
if not os.path.isdir(ROOT):
    print("HATA: repo kokunde calistir"); sys.exit(1)
applied = 0; missing = []
def edit(rel, old, new):
    global applied
    p = os.path.join(ROOT, rel)
    if not os.path.isfile(p): missing.append((rel, "dosya yok")); return
    raw = open(p, "rb").read().decode("utf-8"); crlf = "\r\n" in raw
    s = raw.replace("\r\n", "\n")
    if old in s:
        s = s.replace(old, new); applied += 1
        open(p, "wb").write((s.replace("\n", "\r\n") if crlf else s).encode("utf-8"))
    elif new not in s:
        missing.append((rel, "bulunamadi: " + old[:60].replace("\n", " ")))

# Util 1.21.11'de net.minecraft.util.Util
for rel in ["hex/api/baritone/command/ExampleBaritoneControl.java", "sg/ec/ScriptsPanel.java", "sg/ec/ConfigMarketManager.java"]:
    edit(rel, "net.minecraft.Util.getPlatform()", "net.minecraft.util.Util.getPlatform()")
# Structure.generate: Sampler arguman yok
edit("sg/ec/ScriptWorldGenerator.java", "            this.field14675.sampler(),\n            this.field14675,\n", "            this.field14675,\n")
# crack() yok (sadece parcacik efekti)
edit("sg/ec/BlockBreakManager.java", "            mc.particleEngine.crack(var1.getBlockPos(), var1.getDirection());\n", "")
# BundleContents.items() Iterable
edit("sg/ec/AutoBuyItemMatcher.java", "var5.items().stream().mapToLong", "java.util.stream.StreamSupport.stream(var5.items().spliterator(), false).mapToLong")
print("uygulanan:", applied)
for a, b in missing: print("UYUSMAYAN", a, b)
