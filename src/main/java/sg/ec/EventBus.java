// Original binary: sg/ec/18WD7WCM0D8rPOhJ
package sg.ec;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

// $VF: Compiled from s
public final class EventBus {
   private static final Map<Class<? extends Event>, EventBus.Nested9[]> field00529 = new ConcurrentHashMap<>();
   private static final EventListener[] field00530 = new EventListener[0];
   private static volatile int field00531 = 0;
   private static final String field00532 = "fire";
   private static final String field00533 = "This is a utility class and cannot be instantiated";

   public static EventListener[] method00259(Event var0) {
      EventBus.Nested10 var1 = var0.field12065;
      if (var1 != null && var1.field00540 == field00531) {
         return var1.field00541;
      }

      EventBus.Nested9[] sx = field00529.get(var0.getClass());
      EventListener[] sxx = field00530;
      if (sx != null) {
         sxx = new EventListener[sx.length];

         for (int sxxx = 0; sxxx < sx.length; sxxx++) {
            sxx[sxxx] = sx[sxxx].field00539;
         }
      }

      var0.field12065 = new EventBus.Nested10(field00531, sxx);
      return sxx;
   }

   private static boolean method00260(Method var0) {
      return var0.getParameterCount() != 1 || !var0.isAnnotationPresent(Subscribe.class);
   }

   private static EventListener method00261(Object var0, Method var1) {
      try {
         Lookup var2 = MethodHandles.privateLookupIn(var0.getClass(), MethodHandles.lookup());
         MethodHandle var3 = var2.unreflect(var1);
         CallSite var4 = LambdaMetafactory.metafactory(
            var2,
            field00532,
            MethodType.methodType(EventListener.class, var0.getClass()),
            MethodType.methodType(void.class, Event.class),
            var3,
            MethodType.methodType(void.class, var1.getParameterTypes()[0])
         );
         return (EventListener)var4.getTarget().invoke((Object)var0);
      } catch (Throwable var6) {
         try {
            if (!var1.isAccessible()) {
               var1.setAccessible(true);
            }
         } catch (Throwable var5) {
         }

         return new EventBus.Nested8(var0, var1);
      }
   }

   public static void method00262(boolean var0) {
      var var1 = field00529.entrySet().iterator();

      while (var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         if (!var0 || ((EventBus.Nested9[])var2.getValue()).length == 0) {
            var1.remove();
         }
      }
   }

   public static void method00263(Object var0) {
      for (Method var4 : var0.getClass().getDeclaredMethods()) {
         if (!method00260(var4)) {
            method00264(var4, var0);
         }
      }
   }

   private static void method00264(Method var0, Object var1) {
      Class<? extends Event> var2 = (Class<? extends Event>) var0.getParameterTypes()[0];
      EventBus.Nested9 var3 = new EventBus.Nested9(var1, var0, var0.getAnnotation(Subscribe.class).value());
      EventBus.Nested9[] var4 = field00529.get(var2);
      if (var4 == null) {
         field00529.put(var2, new EventBus.Nested9[]{var3});
         field00531++;
      } else {
         for (EventBus.Nested9 var8 : var4) {
            if (var8.method00266(var3)) {
               return;
            }
         }

         int var9 = var4.length;

         for (int var10 = 0; var10 < var4.length; var10++) {
            if (var3.method00267() < var4[var10].method00267()) {
               var9 = var10;
               break;
            }
         }

         EventBus.Nested9[] var11 = new EventBus.Nested9[var4.length + 1];
         System.arraycopy(var4, 0, var11, 0, var9);
         var11[var9] = var3;
         System.arraycopy(var4, var9, var11, var9 + 1, var4.length - var9);
         field00529.put(var2, var11);
         field00531++;
      }
   }

   private EventBus() {
      throw new UnsupportedOperationException(field00533);
   }

   public static void method00265(Object var0) {
      var var1 = field00529.entrySet().iterator();

      while (var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         EventBus.Nested9[] var3 = (EventBus.Nested9[])var2.getValue();
         int var4 = 0;

         for (EventBus.Nested9 var8 : var3) {
            if (!var8.method00268(var0)) {
               var4++;
            }
         }

         if (var4 != var3.length) {
            if (var4 == 0) {
               var1.remove();
            } else {
               EventBus.Nested9[] var11 = new EventBus.Nested9[var4];
               int var12 = 0;

               for (EventBus.Nested9 var10 : var3) {
                  if (!var10.method00268(var0)) {
                     var11[var12++] = var10;
                  }
               }

               var2.setValue(var11);
            }
         }
      }

      field00531++;
      method00262(true);
   }

   // $VF: Compiled from s
   public static final class Nested10 {
      private final int field00540;
      private final EventListener[] field00541;

      Nested10(int var1, EventListener[] var2) {
         this.field00540 = var1;
         this.field00541 = var2;
      }
   }

   // $VF: Compiled from s
   private static final class Nested8 implements EventListener {
      private final Object field00534;
      private final Method field00535;

      @Override
      public void fire(Event var1) {
         try {
            this.field00535.invoke(this.field00534, var1);
         } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException var3) {
         }
      }

      Nested8(Object var1, Method var2) {
         this.field00534 = var1;
         this.field00535 = var2;
      }
   }

   // $VF: Compiled from s
   private static final class Nested9 {
      private final Object field00536;
      private final Method field00537;
      private final byte field00538;
      private final EventListener field00539;

      public boolean method00266(EventBus.Nested9 var1) {
         return this.field00536.equals(var1.field00536) && this.field00537.equals(var1.field00537);
      }

      public byte method00267() {
         return this.field00538;
      }

      public Nested9(Object var1, Method var2, byte var3) {
         this.field00536 = var1;
         this.field00537 = var2;
         this.field00538 = var3;
         this.field00539 = EventBus.method00261(var1, var2);
      }

      public boolean method00268(Object var1) {
         return this.field00536.equals(var1);
      }
   }
}
