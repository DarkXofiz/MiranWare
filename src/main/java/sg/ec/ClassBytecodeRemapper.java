// Original binary: sg/ec/78pyDkaVQ8ZrBVSy
package sg.ec;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ConstantDynamic;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

// $VF: Compiled from s
public final class ClassBytecodeRemapper {
   private static final int field03953 = 589824;
   private static final int field03954 = 0;
   private static final String field03955 = "field03955";
   private static final String field03956 = "This is a utility class and cannot be instantiated";

   private ClassBytecodeRemapper() {
      throw new UnsupportedOperationException(field03956);
   }

   public static List<String> method01624(String var0, byte[] var1, Set<String> var2, ScriptSourceType var3) {
      ClassBytecodeRemapper.Nested45 var4 = new ClassBytecodeRemapper.Nested45(var2, var3);

      try {
         new ClassReader(var1).accept(new ClassBytecodeRemapper.Nested47(var4), 6);
      } catch (Throwable var8) {
         var4.field03959.add("байткод не разбирается: " + var8.getClass().getSimpleName());
      }

      ArrayList var5 = new ArrayList();

      for (String var7 : var4.field03959) {
         var5.add(var0 + ": " + var7);
         if (var5.size() >= 8) {
            break;
         }
      }

      return var5;
   }

   // $VF: Compiled from s
   private static final class Nested45 {
      private final Set<String> field03957;
      private final ScriptSourceType field03958;
      private final Set<String> field03959 = new LinkedHashSet<>();
      private static final String field03960 = "(";
      private static final String field03961 = "[";
      private static final String field03962 = "L";
      private static final String field03963 = ";";
      private static final String field03964 = "[";
      private static final String field03965 = "Lorg/spongepowered/asm/mixin/Mixin;";

      void method01625(String var1) {
         this.method01633(var1.replace('.', '/'));
      }

      void method01626(String var1) {
         if (var1 != null && !var1.isEmpty()) {
            if (var1.charAt(0) != '(') {
               this.method01633(var1);
            } else {
               Type var2 = Type.getMethodType(var1);

               for (Type var6 : var2.getArgumentTypes()) {
                  this.method01633(var6.getDescriptor());
               }

               this.method01633(var2.getReturnType().getDescriptor());
            }
         }
      }

      AnnotationVisitor method01627(String var1) {
         this.method01633(var1);
         return new ClassBytecodeRemapper.Nested46(this, field03965.equals(var1), false);
      }

      void method01628(String var1) {
         int var2 = var1.length();

         for (int var3 = 0; var3 < var2; var3++) {
            if (var1.charAt(var3) == 'L' && (var3 <= 0 || !Character.isJavaIdentifierPart(var1.charAt(var3 - 1)))) {
               int var4 = var1.indexOf(59, var3);
               if (var4 < 0) {
                  return;
               }

               String var5 = var1.substring(var3 + 1, var4);
               if (var5.indexOf(47) > 0 && this.method01631(var5)) {
                  this.method01633(var5);
                  var3 = var4;
               }
            }
         }
      }

      void method01629(Object var1) {
         if (var1 instanceof Type var2) {
            if (var2.getSort() == 11) {
               this.method01626(var2.getDescriptor());
            } else {
               this.method01633(var2.getDescriptor());
            }
         } else if (var1 instanceof Handle var3) {
            this.method01634(var3);
         } else if (var1 instanceof ConstantDynamic var4) {
            this.method01626(var4.getDescriptor());
            this.method01632(var4.getBootstrapMethod());

            for (int var5 = 0; var5 < var4.getBootstrapMethodArgumentCount(); var5++) {
               this.method01629(var4.getBootstrapMethodArgument(var5));
            }
         }
      }

      private boolean method01630(String var1) {
         return this.field03957.contains(var1.replace('/', '.'));
      }

      private boolean method01631(String var1) {
         for (int var2 = 0; var2 < var1.length(); var2++) {
            char var3 = var1.charAt(var2);
            if (var3 != '/' && !Character.isJavaIdentifierPart(var3)) {
               return false;
            }
         }

         return true;
      }

      Nested45(Set<String> var1, ScriptSourceType var2) {
         this.field03957 = var1;
         this.field03958 = var2;
      }

      void method01632(Handle var1) {
         if (var1 != null) {
            if (!ScriptClassAccessPolicy.method04729(var1.getOwner())) {
               this.field03959.add("запрещённый bootstrap " + ScriptClassAccessPolicy.method04731(var1.getOwner()));
            }
         }
      }

      void method01633(String var1) {
         if (var1 != null) {
            if (var1.startsWith(field03960)) {
               this.method01626(var1);
            } else {
               String var2 = var1;

               while (var2.startsWith(field03961)) {
                  var2 = var2.substring(1);
               }

               if (var2.startsWith(field03962) && var2.endsWith(field03963)) {
                  var2 = var2.substring(1, var2.length() - 1);
               }

               if (!var2.isEmpty() && var2.length() != 1 && !this.method01630(var2)) {
                  if (!ScriptClassAccessPolicy.method04732(this.field03958, var2)) {
                     this.field03959.add("запрещённый класс " + ScriptClassAccessPolicy.method04731(var2));
                  }
               }
            }
         }
      }

      void method01634(Handle var1) {
         if (var1 != null) {
            this.method01635(var1.getOwner(), var1.getName(), var1.getDesc());
         }
      }

      void method01635(String var1, String var2, String var3) {
         this.method01626(var3);
         if (var1 != null && !this.method01630(var1)) {
            if (var1.startsWith(field03964)) {
               this.method01633(var1);
            } else {
               if (!ScriptClassAccessPolicy.method04734(this.field03958, var1, var2)) {
                  this.field03959.add("запрещённый вызов " + ScriptClassAccessPolicy.method04731(var1) + "." + var2);
               }
            }
         }
      }
   }

   // $VF: Compiled from s
   private static final class Nested46 extends AnnotationVisitor {
      private final ClassBytecodeRemapper.Nested45 field03966;
      private final boolean field03967;
      private final boolean field03968;
      private static final int field03969 = 589824;
      private static final String field03970 = "targets";

      public void visitEnum(String var1, String var2, String var3) {
         this.field03966.method01633(var2);
      }

      public AnnotationVisitor visitAnnotation(String var1, String var2) {
         return this.field03966.method01627(var2);
      }

      public AnnotationVisitor visitArray(String var1) {
         return new ClassBytecodeRemapper.Nested46(this.field03966, false, this.field03967 && field03970.equals(var1));
      }

      Nested46(ClassBytecodeRemapper.Nested45 var1, boolean var2, boolean var3) {
         super(field03969);
         this.field03966 = var1;
         this.field03967 = var2;
         this.field03968 = var3;
      }

      public void visit(String var1, Object var2) {
         if (var2 instanceof String var3) {
            if (this.field03968) {
               this.field03966.method01625(var3);
            } else {
               this.field03966.method01628(var3);
            }
         } else {
            this.field03966.method01629(var2);
         }
      }
   }

   // $VF: Compiled from s
   private static final class Nested47 extends ClassVisitor {
      private final ClassBytecodeRemapper.Nested45 field03971;
      private static final int field03972 = 589824;

      public FieldVisitor visitField(int var1, String var2, String var3, String var4, Object var5) {
         this.field03971.method01626(var3);
         this.field03971.method01629(var5);
         return new ClassBytecodeRemapper.Nested48(this.field03971);
      }

      public void visit(int var1, int var2, String var3, String var4, String var5, String[] var6) {
         this.field03971.method01633(var5);
         if (var6 != null) {
            for (String var10 : var6) {
               this.field03971.method01633(var10);
            }
         }
      }

      Nested47(ClassBytecodeRemapper.Nested45 var1) {
         super(field03972);
         this.field03971 = var1;
      }

      public MethodVisitor visitMethod(int var1, String var2, String var3, String var4, String[] var5) {
         this.field03971.method01626(var3);
         if (var5 != null) {
            for (String var9 : var5) {
               this.field03971.method01633(var9);
            }
         }

         return new ClassBytecodeRemapper.Nested49(this.field03971);
      }

      public AnnotationVisitor visitAnnotation(String var1, boolean var2) {
         return this.field03971.method01627(var1);
      }
   }

   // $VF: Compiled from s
   private static final class Nested48 extends FieldVisitor {
      private final ClassBytecodeRemapper.Nested45 field03973;
      private static final int field03974 = 589824;

      Nested48(ClassBytecodeRemapper.Nested45 var1) {
         super(field03974);
         this.field03973 = var1;
      }

      public AnnotationVisitor visitAnnotation(String var1, boolean var2) {
         return this.field03973.method01627(var1);
      }
   }

   // $VF: Compiled from s
   private static final class Nested49 extends MethodVisitor {
      private final ClassBytecodeRemapper.Nested45 field03975;
      private static final int field03976 = 589824;

      public AnnotationVisitor visitParameterAnnotation(int var1, String var2, boolean var3) {
         return this.field03975.method01627(var2);
      }

      public void visitMultiANewArrayInsn(String var1, int var2) {
         this.field03975.method01626(var1);
      }

      public void visitInvokeDynamicInsn(String var1, String var2, Handle var3, Object... var4) {
         this.field03975.method01626(var2);
         this.field03975.method01632(var3);

         for (Object var8 : var4) {
            this.field03975.method01629(var8);
         }
      }

      public void visitLdcInsn(Object var1) {
         this.field03975.method01629(var1);
      }

      public AnnotationVisitor visitAnnotation(String var1, boolean var2) {
         return this.field03975.method01627(var1);
      }

      Nested49(ClassBytecodeRemapper.Nested45 var1) {
         super(field03976);
         this.field03975 = var1;
      }

      public void visitMethodInsn(int var1, String var2, String var3, String var4, boolean var5) {
         this.field03975.method01635(var2, var3, var4);
      }

      public void visitTypeInsn(int var1, String var2) {
         this.field03975.method01633(var2);
      }

      public void visitFieldInsn(int var1, String var2, String var3, String var4) {
         this.field03975.method01635(var2, var3, var4);
      }

      public void visitTryCatchBlock(Label var1, Label var2, Label var3, String var4) {
         this.field03975.method01633(var4);
      }
   }
}
