// Original binary: sg/ec/41Or6voYOmM5KEZx
package sg.ec;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.service.MixinService;

// $VF: Compiled from s
public class ViaBotGuardMixinPlugin implements IMixinConfigPlugin {
   private static final String field01832 = "viafabricplus";
   private static final String field01833 = Type.getInternalName(ViaFabricPlusConnectionAccess.class);
   private static final ClassNode field01834 = guardClass();
   private static final String field01835 = guardMethodName(ViaBotGuardMixinPlugin.field01861);
   private static final String field01836 = guardMethodName(ViaBotGuardMixinPlugin.field01862);
   private static final String field01837 = guardMethodName(ViaBotGuardMixinPlugin.field01863);
   private static final String field01838 = "field01838";
   private static final String field01839 = "field01839";
   private static final String field01840 = "field01840";
   private static final String[] field01841 = new String[]{ViaBotGuardMixinPlugin.field01864, ViaBotGuardMixinPlugin.field01865};
   private boolean field01842;
   private final Set<String> field01843 = new HashSet<>();
   private static final String field01844 = "Unable to read ViaBotGuard bytecode";
   private static final String field01845 = "Ambiguous ViaBotGuard method signature";
   private static final String field01846 = "ViaBotGuard method signature not found";
   private static final String field01847 = "viafabricplus";
   private static final String field01848 = "(Ljava/lang/Object;)Ljava/lang/Object;";
   private static final String field01849 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V";
   private static final String field01850 = "userconnection";
   private static final String field01851 = "getPlayNetworkUserConnection";
   private static final String field01852 = "via";
   private static final String field01853 = "connection";
   private static final String field01854 = "protocol";
   private static final String field01855 = "(Ljava/lang/Class;)V";
   private static final String field01856 = "scheduleSendToServer";
   private static final String field01857 = "via";
   private static final String field01858 = "network";
   private static final String field01859 = "connection";
   private static final String field01860 = "(Ljava/lang/Object;)Z";
   private static final String field01861 = "(Ljava/lang/Object;)Ljava/lang/Object;";
   private static final String field01862 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V";
   private static final String field01863 = "(Ljava/lang/Object;)Z";
   private static final String field01864 = "viaFabricPlus$sendSneakingPacket";
   private static final String field01865 = "viaFabricPlus$sendInputPacket";

   private static boolean isScheduledSend(MethodInsnNode var0) {
      if (!field01855.equals(var0.desc)) {
         return false;
      }

      if (field01856.equals(var0.name)) {
         return true;
      }

      String var1 = var0.owner.toLowerCase();
      return var1.contains(field01857) || var1.contains(field01858) || var1.contains(field01859);
   }

   private static MethodNode findHookMethod(ClassNode var0, String var1) {
      for (MethodNode var3 : var0.methods) {
         if (var3.name.contains(var1)) {
            return var3;
         }
      }

      return null;
   }

   private static String guardMethodName(String var0) {
      if (field01834 == null) {
         return null;
      }

      MethodNode var1 = null;

      for (MethodNode var3 : field01834.methods) {
         byte var4 = 9;
         if ((var3.access & var4) == var4 && var3.desc.equals(var0)) {
            if (var1 != null) {
               System.err.println("[MiranWare] " + field01845);
               return null;
            }

            var1 = var3;
         }
      }

      if (var1 == null) {
         System.err.println("[MiranWare] " + field01846);
         return null;
      } else {
         return var1.name;
      }
   }

   private static ClassNode guardClass() {
      try {
         return MixinService.getService().getBytecodeProvider().getClassNode(field01833.replace('/', '.'), false);
      } catch (Throwable var1) {
         System.err.println("[MiranWare] " + field01844);
         var1.printStackTrace();
         return null;
      }
   }

   public boolean shouldApplyMixin(String var1, String var2) {
      return true;
   }

   private static boolean patch(ClassNode var0, String var1) {
      MethodNode var2 = findHookMethod(var0, var1);
      if (var2 == null) {
         return false;
      } else {
         int var3 = redirect(var2);
         int var4 = reschedule(var2);
         if (var3 != 0 && var4 != 0) {
            var2.instructions.insert(bailOut());
            System.out
               .println(
                  "[MiranWare] ViaFabricPlus." + var1 + " перенаправлен в bot connection (" + var2.name + ", connection: " + var3 + ", send: " + var4 + ")"
               );
            return true;
         } else {
            System.err.println("[MiranWare] ViaFabricPlus." + var1 + " не удалось полностью пропатчить (connection: " + var3 + ", send: " + var4 + ")");
            return false;
         }
      }
   }

   public void preApply(String var1, ClassNode var2, String var3, IMixinInfo var4) {
   }

   private static boolean isConnectionCall(MethodInsnNode var0) {
      Type var1 = Type.getMethodType(var0.desc);
      if (var1.getArgumentTypes().length != 0) {
         return false;
      }

      Type var2 = var1.getReturnType();
      if (var2.getSort() != 10) {
         return false;
      }

      if (!var2.getInternalName().toLowerCase().contains(field01850)) {
         return false;
      }

      if (field01851.equals(var0.name)) {
         return true;
      }

      String var3 = var0.owner.toLowerCase();
      return var3.contains(field01852) || var3.contains(field01853) || var3.contains(field01854);
   }

   public void postApply(String var1, ClassNode var2, String var3, IMixinInfo var4) {
      if (this.field01842 && !this.field01843.contains(var1)) {
         boolean var5 = false;

         for (String var9 : field01841) {
            if (patch(var2, var9)) {
               var5 = true;
            }
         }

         if (var5) {
            this.field01843.add(var1);
         }
      }
   }

   private static int redirect(MethodNode var0) {
      int var1 = 0;

      for (AbstractInsnNode var5 : var0.instructions.toArray()) {
         if (var5 instanceof MethodInsnNode var6) {
            boolean var7 = var6.getOpcode() == 185 || var6.getOpcode() == 182;
            if ((var6.getOpcode() == 184 || var7) && isConnectionCall(var6)) {
               InsnList var8 = new InsnList();
               if (var7) {
                  var8.add(new InsnNode(87));
               }

               var8.add(new VarInsnNode(25, 0));
               var8.add(new MethodInsnNode(184, field01833, field01835, field01848, false));
               Type var9 = Type.getReturnType(var6.desc);
               if (var9.getSort() == 10 || var9.getSort() == 9) {
                  var8.add(new TypeInsnNode(192, var9.getInternalName()));
               }

               var0.instructions.insertBefore(var6, var8);
               var0.instructions.remove(var6);
               var1++;
            }
         }
      }

      return var1;
   }

   public List<String> getMixins() {
      return null;
   }

   private static int reschedule(MethodNode var0) {
      int var1 = 0;

      for (AbstractInsnNode var5 : var0.instructions.toArray()) {
         if (var5 instanceof MethodInsnNode var6 && isScheduledSend(var6)) {
            InsnList var7 = new InsnList();
            var7.add(new VarInsnNode(25, 0));
            var7.add(new MethodInsnNode(184, field01833, field01836, field01849, false));
            var0.instructions.insertBefore(var6, var7);
            var0.instructions.remove(var6);
            var1++;
         }
      }

      return var1;
   }

   private static InsnList bailOut() {
      InsnList var0 = new InsnList();
      var0.add(new VarInsnNode(25, 0));
      var0.add(new MethodInsnNode(184, field01833, field01837, field01860, false));
      LabelNode var1 = new LabelNode();
      var0.add(new JumpInsnNode(153, var1));
      var0.add(new InsnNode(177));
      var0.add(var1);
      return var0;
   }

   public void acceptTargets(Set<String> var1, Set<String> var2) {
   }

   public String getRefMapperConfig() {
      return null;
   }

   public void onLoad(String var1) {
      this.field01842 = FabricLoader.getInstance().isModLoaded(field01847);
   }
}
