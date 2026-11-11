#!/usr/bin/env python3
# MiranWare 1.21.11 port - adim 11: MixinExtras ClassCastException (class_5250 / MutableComponent) calisma zamani cokmesi. Idempotent.
import os, sys
ROOT = os.path.join(os.getcwd(), "src", "main", "java")
if not os.path.isdir(ROOT):
    print("HATA: repo kokunde calistir"); sys.exit(1)
rel = "sg/mx/MutableComponentMixin_1227.java"
p = os.path.join(ROOT, rel)
raw = open(p, "rb").read().decode("utf-8"); crlf = "\r\n" in raw
s = raw.replace("\r\n", "\n")
old1 = '''   @Redirect(
      method = "setStyle",
      at = @At(value = "FIELD", target = "Lnet/minecraft/network/chat/MutableComponent;style:Lnet/minecraft/network/chat/Style;", opcode = 181)
   )
   private void hex$invalidateOnStyle(MutableComponent var1, Style var2) {
      this.style = var2;
      this.hex$hash = 0;
      this.hex$text = 0L;
      this.hex$formatted = null;
   }
'''
new1 = '''   @Inject(method = "setStyle", at = @At("HEAD"))
   private void hex$invalidateOnStyle(CallbackInfoReturnable<MutableComponent> var1) {
      this.hex$hash = 0;
      this.hex$text = 0L;
      this.hex$formatted = null;
   }
'''
old2 = '''   @Redirect(
      method = "append(Lnet/minecraft/network/chat/Component;)Lnet/minecraft/network/chat/MutableComponent;",
      at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z")
   )
   private boolean hex$invalidateOnAppend(List<Component> var1, Object var2) {
      this.hex$hash = 0;
      this.hex$text = 0L;
      this.hex$formatted = null;
      return var1.add((Component)var2);
   }
'''
new2 = '''   @Inject(
      method = "append(Lnet/minecraft/network/chat/Component;)Lnet/minecraft/network/chat/MutableComponent;",
      at = @At("HEAD")
   )
   private void hex$invalidateOnAppend(CallbackInfoReturnable<MutableComponent> var1) {
      this.hex$hash = 0;
      this.hex$text = 0L;
      this.hex$formatted = null;
   }
'''
n = 0
for o, w in ((old1, new1), (old2, new2)):
    if o in s: s = s.replace(o, w); n += 1
    elif w not in s: print("UYUSMAYAN:", o[:50])
if n:
    open(p, "wb").write((s.replace("\n", "\r\n") if crlf else s).encode("utf-8"))
print("uygulanan:", n)
