#!/usr/bin/env python3
# MiranWare 1.21.11 port - adim 10 (calisma zamani cokmesi: mixin plugin sertlestirme + hata yazdirma). Idempotent.
import os, sys
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

f = "sg/ec/ViaBotGuardMixinPlugin.java"
# static baslaticida firlatma -> ExceptionInInitializerError -> NoClassDefFoundError zinciri; artik null doner ve hatayi yazdirir
edit(f, "      } catch (Exception var1) {\n         throw new IllegalStateException(field01844, var1);\n      }",
        "      } catch (Throwable var1) {\n         System.err.println(\"[MiranWare] \" + field01844);\n         var1.printStackTrace();\n         return null;\n      }")
edit(f, "   private static String guardMethodName(String var0) {\n      MethodNode var1 = null;\n",
        "   private static String guardMethodName(String var0) {\n      if (field01834 == null) {\n         return null;\n      }\n\n      MethodNode var1 = null;\n")
edit(f, "            if (var1 != null) {\n               throw new IllegalStateException(field01845);\n            }\n",
        "            if (var1 != null) {\n               System.err.println(\"[MiranWare] \" + field01845);\n               return null;\n            }\n")
edit(f, "      if (var1 == null) {\n         throw new IllegalStateException(field01846);\n      } else {\n         return var1.name;\n      }",
        "      if (var1 == null) {\n         System.err.println(\"[MiranWare] \" + field01846);\n         return null;\n      } else {\n         return var1.name;\n      }")

f = "sg/ec/MiranWare.java"
edit(f, "      public void onLoad(String var1) {\n         ScriptMixinManager.method08302();\n      }",
        "      public void onLoad(String var1) {\n         try {\n            ScriptMixinManager.method08302();\n         } catch (Throwable var2) {\n            System.err.println(\"[MiranWare] script mixin yukleme hatasi\");\n            var2.printStackTrace();\n         }\n      }")
edit(f, "      public void onLoad(String var1) {\n         this.field01756.onLoad(var1);\n      }",
        "      public void onLoad(String var1) {\n         try {\n            this.field01756.onLoad(var1);\n         } catch (Throwable var2) {\n            System.err.println(\"[MiranWare] ViaBotGuard onLoad hatasi\");\n            var2.printStackTrace();\n         }\n      }")
print("uygulanan:", applied)
for a, b in missing: print("UYUSMAYAN", a, b)
