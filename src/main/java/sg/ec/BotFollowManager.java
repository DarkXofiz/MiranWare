// Original binary: sg/ec/9Gw0F8uXcKhnO5eP
package sg.ec;

import com.mojang.authlib.GameProfile;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.pathing.goals.GoalNear;
import hex.api.baritone.api.process.ICustomGoalProcess;
import hex.api.baritone.api.utils.interfaces.IGoalRenderPos;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public enum BotFollowManager implements MinecraftAccess {
   INSTANCE;

   private static final int field05164 = 2;
   private static final double field05165 = 0;
   private final Set<BotClient> field05166 = Collections.newSetFromMap(new ConcurrentHashMap<>());
   private volatile String field05167 = "";
   private volatile String field05168 = "";
   private volatile boolean field05169;
   private volatile int field05170;
   private volatile int field05171;
   private volatile int field05172;

   public String method02178() {
      return this.field05167;
   }

   public String method02179() {
      return this.field05168;
   }

   public boolean method02180() {
      return !this.field05167.isEmpty();
   }

   public boolean method02181() {
      return !this.field05168.isEmpty();
   }

   public void method02182(String var1) {
      this.method02185();
      this.field05167 = var1;
   }

   public void method02183(String var1) {
      this.method02184();
      this.field05169 = false;
      this.field05168 = var1;
   }

   public void method02184() {
      if (!this.field05167.isEmpty()) {
         this.field05167 = "";
         this.method02194();
      }
   }

   public void method02185() {
      this.field05168 = "";
      this.field05169 = false;
   }

   public void method02186() {
      this.method02184();
      this.method02185();
   }

   public void method02187(BotClient var1) {
      this.field05166.remove(var1);
   }

   public void method02188() {
      if (this.method02180()) {
         this.method02191();
      } else if (this.method02181()) {
         this.method02192();
      }
   }

   public void method02189(BotClient var1) {
      if (var1 != BotSessionManager.INSTANCE.method08761()) {
         if (this.field05169 && var1.method00146().method05278()) {
            IBaritone var2 = var1.method00099();
            if (var2 != null) {
               ICustomGoalProcess var3 = var2.getCustomGoalProcess();
               BlockPos var4 = new BlockPos(this.field05170, this.field05171, this.field05172);
               this.field05166.add(var1);
               if (!(var3.getGoal() instanceof IGoalRenderPos var5 && var5.getGoalPos().equals(var4))) {
                  var3.setGoalAndPath(new GoalNear(var4, 2));
               }
            }
         } else {
            this.method02190(var1);
         }
      }
   }

   private void method02190(BotClient var1) {
      if (this.field05166.remove(var1)) {
         IBaritone var2 = var1.method00099();
         if (var2 != null) {
            var2.getPathingBehavior().cancelEverything();
         }
      }
   }

   private void method02191() {
      Player var1 = this.method02195(this.field05167);
      if (var1 == null) {
         this.method02194();
      } else {
         Input var2 = this.method02193(var1);
         float var3 = var1.getYRot();
         float var4 = var1.getXRot();

         for (BotClient var6 : BotManager.INSTANCE.method03092()) {
            if (var6.method00146().method05278()) {
               var6.method00089().method10867(var2.forward(), var2.backward(), var2.left(), var2.right(), var2.jump(), var2.shift(), var2.sprint());
               var6.method00116(var3, var4);
            }
         }
      }
   }

   private void method02192() {
      Player var1 = this.method02195(this.field05168);
      if (var1 == null) {
         this.field05169 = false;
      } else {
         BlockPos var2 = var1.blockPosition();
         this.field05170 = var2.getX();
         this.field05171 = var2.getY();
         this.field05172 = var2.getZ();
         this.field05169 = true;

         for (BotClient var4 : BotManager.INSTANCE.method03092()) {
            if (var4.method00146().method05278()) {
               var4.method00107();
            }
         }
      }
   }

   private Input method02193(Player var1) {
      if (var1 instanceof LocalPlayer var13) {
         return var13.getLastSentInput();
      } else {
         Vec3 var2 = var1.position().subtract(var1.xo, var1.yo, var1.zo);
         double var3 = Math.toRadians(var1.getYRot());
         double var5 = Math.sin(var3);
         double var7 = Math.cos(var3);
         double var9 = var7 * var2.z - var5 * var2.x;
         double var11 = var7 * var2.x + var5 * var2.z;
         return new Input(var9 > 0.015, var9 < -0.015, var11 > 0.015, var11 < -0.015, !var1.onGround() && var2.y > 0.0, var1.isCrouching(), var1.isSprinting());
      }
   }

   private void method02194() {
      for (BotClient var2 : BotManager.INSTANCE.method03092()) {
         var2.method00089().method10866();
      }
   }

   private Player method02195(String var1) {
      if (mc.level == null) {
         return null;
      }

      for (AbstractClientPlayer var3 : mc.level.players()) {
         GameProfile var4 = var3.getGameProfile();
         if (var4 != null && var4.name().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }
}
