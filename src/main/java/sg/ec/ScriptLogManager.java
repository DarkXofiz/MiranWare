// Original binary: sg/ec/fP2a3uf4HSkDHU5u
package sg.ec;

import hex.script.api.Chat;
import hex.script.api.Log;
import hex.script.api.Script;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $VF: Compiled from s
public enum ScriptLogManager implements MinecraftAccess {
   INSTANCE;

   public static final int field18920 = 0;
   public static final int field18921 = 0;
   public static final int field18922 = 0;
   private static final Logger field18923 = LoggerFactory.getLogger("MiranWare");
   private static final int field18924 = 0;
   private static final String field18925 = "field18925";
   private static final DateTimeFormatter field18926 = DateTimeFormatter.ofPattern("HH:mm:ss");
   private final ArrayDeque<ScriptLogManager.Nested233> field18927 = new ArrayDeque<>();
   private final Map<Object, Chat> field18928 = new ConcurrentHashMap<>();
   private final Map<Object, Log> field18929 = new ConcurrentHashMap<>();
   private volatile int field18930;
   private long field18931;

   Chat method08081(Object var1) {
      return this.field18928.computeIfAbsent(var1, var1x -> new Chat(var1x, this::method08096, this::method08097));
   }

   Log method08082(Object var1) {
      return this.field18929.computeIfAbsent(var1, var1x -> new Log(var1x, this::method08094));
   }

   void method08083(Object var1) {
      this.field18928.remove(var1);
      this.field18929.remove(var1);
   }

   public List<ScriptLogManager.Nested233> method08084() {
      synchronized (this.field18927) {
         return new ArrayList<>(this.field18927);
      }
   }

   public int method08085() {
      synchronized (this.field18927) {
         return this.field18927.size();
      }
   }

   public List<ScriptLogManager.Nested233> method08086(long var1, int var3) {
      ArrayList var4 = new ArrayList();
      synchronized (this.field18927) {
         for (ScriptLogManager.Nested233 var7 : this.field18927) {
            if (var7.seq() > var1) {
               var4.add(var7);
            }
         }
      }

      int var10 = var4.size() - Math.max(0, var3);
      return var10 > 0 ? new ArrayList<>(var4.subList(var10, var4.size())) : var4;
   }

   public long method08087() {
      synchronized (this.field18927) {
         return this.field18931;
      }
   }

   public int method08088() {
      return this.field18930;
   }

   public void method08089() {
      synchronized (this.field18927) {
         this.field18927.clear();
      }

      this.field18930++;
   }

   public String method08090() {
      StringBuilder var1 = new StringBuilder();

      for (ScriptLogManager.Nested233 var3 : this.method08084()) {
         var1.append(var3.stamp())
            .append(' ')
            .append(method08100(var3.level()))
            .append(' ')
            .append(var3.source())
            .append(": ")
            .append(var3.text())
            .append('\n');
      }

      return var1.toString();
   }

   public void method08091(int var1, String var2) {
      this.method08095("client", var1, var2);
      ChatTextUtils.method05098(Component.literal(var2));
   }

   public void method08092(int var1, String var2) {
      this.method08095("client", var1, var2);
   }

   void method08093(Object var1, String var2) {
      this.method08094(var1, 1, var2, null);
   }

   private void method08094(Object var1, int var2, String var3, Throwable var4) {
      String var5 = this.method08099(var1);
      String var6 = var4 == null ? var3 : var3 + " — " + this.method08098(var4);
      this.method08095(var5, var2, var6);
      String var7 = "[script] " + var5 + ": " + var6;
      switch (var2) {
         case 1:
            field18923.warn(var7);
            break;
         case 2:
            field18923.error(var7, var4);
            break;
         default:
            field18923.info(var7);
      }
   }

   private void method08095(String var1, int var2, String var3) {
      if (var3 != null) {
         int var4 = Math.max(0, Math.min(2, var2));
         synchronized (this.field18927) {
            ScriptLogManager.Nested233 var6 = new ScriptLogManager.Nested233(++this.field18931, field18926.format(LocalTime.now()), var4, var1, var3);

            while (this.field18927.size() >= 1000) {
               this.field18927.pollFirst();
            }

            this.field18927.addLast(var6);
         }

         this.field18930++;
      }
   }

   private void method08096(Object var1, String var2, Object var3) {
      ChatTextUtils.method05098(
         Component.literal("[" + (var2 == null ? this.method08099(var1) : var2) + "] ").append(ScriptTextAdapter.method09250(var3))
      );
   }

   private void method08097(String var1) {
      ChatTextUtils.method05080(var1);
   }

   private String method08098(Throwable var1) {
      String var2 = var1.getMessage();
      return var1.getClass().getSimpleName() + (var2 == null ? "" : ": " + var2);
   }

   private String method08099(Object var1) {
      if (var1 instanceof Script var2) {
         try {
            String var3 = var2.name();
            if (var3 != null && !var3.isEmpty()) {
               return var3;
            }
         } catch (Throwable var4) {
         }
      }

      return var1 == null ? "client" : var1.getClass().getSimpleName();
   }

   public static String method08100(int var0) {
      return switch (var0) {
         case 1 -> "WARN";
         case 2 -> "ERROR";
         default -> "INFO";
      };
   }

   // $VF: Compiled from s
   public record Nested233(long seq, String stamp, int level, String source, String text) {
   }
}
