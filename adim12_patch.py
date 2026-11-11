#!/usr/bin/env python3
# MiranWare 1.21.11 port - adim 12
# MixinExtras 0.5.4 FactoryRedirectWrapperMixinTransformer, bu modun @Redirect'lerinde ClassCastException ile cokuyor
# (class_1657 / class_310 ...). Cozum: tum @Redirect -> @WrapOperation (ayni isi gorur, ayni imza + Operation parametresi).
# adim11'den SONRA calistir. Idempotent.
import os, re, sys

ROOT = os.path.join(os.getcwd(), "src", "main", "java")
if not os.path.isdir(ROOT):
    print("HATA: repo kokunde calistir"); sys.exit(1)

BOX = {"void": "Void", "int": "Integer", "boolean": "Boolean", "float": "Float", "double": "Double",
       "long": "Long", "byte": "Byte", "short": "Short", "char": "Character"}
IMP_WO = "import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;"
IMP_OP = "import com.llamalad7.mixinextras.injector.wrapoperation.Operation;"

def match_paren(s, i):
    """s[i] == '(' -> kapanis indeksi (string/char literal'lere duyarli)"""
    depth = 0; j = i; n = len(s)
    while j < n:
        c = s[j]
        if c == '"':
            j += 1
            while s[j] != '"':
                j += 2 if s[j] == '\\' else 1
        elif c == "'":
            j += 1
            while s[j] != "'":
                j += 2 if s[j] == '\\' else 1
        elif c == '(':
            depth += 1
        elif c == ')':
            depth -= 1
            if depth == 0: return j
        j += 1
    raise ValueError("parantez kapanmadi")

def split_top(params):
    parts = []; depth = 0; cur = ""
    for c in params:
        if c in "(<[": depth += 1
        elif c in ")>]": depth -= 1
        if c == "," and depth == 0:
            parts.append(cur); cur = ""
        else:
            cur += c
    parts.append(cur)
    return parts

HDR = re.compile(r"\s*((?:@[\w.]+(?:\s*\([^)]*\))?\s*)*)((?:(?:private|protected|public|static|final|synchronized)\s+)*)([\w$.<>\[\]?,\s]+?)\s+([\w$]+)\s*\(", re.S)

def convert(s):
    out = []; pos = 0; count = 0
    while True:
        k = s.find("@Redirect", pos)
        if k < 0: break
        # @Redirect( ... )
        p = k + len("@Redirect")
        if not s[p:].lstrip().startswith("("):
            out.append(s[pos:p]); pos = p; continue
        a_open = s.index("(", p)
        a_close = match_paren(s, a_open)
        m = HDR.match(s, a_close + 1)
        if not m:
            raise ValueError("metot basligi okunamadi @ %d" % k)
        ret = m.group(3).strip()
        p_open = m.end() - 1
        p_close = match_paren(s, p_open)
        params = s[p_open + 1:p_close]
        boxed = BOX.get(ret, ret)
        op = "Operation<%s> hex$original" % boxed
        parts = split_top(params) if params.strip() else []
        idx = None
        for i, part in enumerate(parts):
            if part.strip().startswith("@Local"):
                idx = i; break
        if idx is None:
            new_params = (params.rstrip() + ", " + op) if parts else op
        else:
            before = [x for x in parts[:idx]]
            after = parts[idx:]
            new_params = ",".join(before) + (", " if before else "") + op + ", " + ",".join(x.strip() for x in after)
        out.append(s[pos:k])
        out.append("@WrapOperation" + s[p:a_close + 1])
        out.append(s[a_close + 1:p_open + 1])
        out.append(new_params)
        pos = p_close
        count += 1
    out.append(s[pos:])
    return "".join(out), count

def add_imports(s):
    add = [i for i in (IMP_WO, IMP_OP) if i not in s]
    if not add: return s
    m = re.search(r"^import .*$", s, flags=re.M)
    ins = "\n".join(add) + "\n"
    if m: return s[:m.start()] + ins + s[m.start():]
    m = re.search(r"^package .*?;\s*$", s, flags=re.M)
    return s[:m.end()] + "\n\n" + ins + s[m.end():]

total = 0; files = 0
for dp, dn, fn in os.walk(ROOT):
    for n in fn:
        if not n.endswith(".java"): continue
        p = os.path.join(dp, n)
        raw = open(p, "rb").read().decode("utf-8")
        if "@Redirect" not in raw: continue
        crlf = "\r\n" in raw
        s = raw.replace("\r\n", "\n")
        try:
            s2, c = convert(s)
        except Exception as e:
            print("HATA", os.path.relpath(p, ROOT), e); continue
        if c:
            s2 = add_imports(s2)
            open(p, "wb").write((s2.replace("\n", "\r\n") if crlf else s2).encode("utf-8"))
            total += c; files += 1
print("donusturulen @Redirect:", total, "| dosya:", files)
