// Original binary: sg/ec/AtZXo7bWZIYECD9R
package sg.ec;

import hex.api.baritone.api.IBaritone;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.phys.BlockHitResult;

// $VF: Compiled from s
public interface BotTask {
   WardenBotOptions method01764();

   void method01748();

   int method01745();

   boolean method01768(int var1);

   AbstractContainerMenu method01765();

   void method01751(String var1);

   void method01759(Runnable var1);

   void method01753(int var1);

   ClientLevel method01752();

   void method01767(BlockPos var1, Direction var2);

   default boolean method02627() {
      return this.method01765() != null;
   }

   void method01771();

   boolean method01777();

   void method01754(int var1);

   boolean method02628();

   default boolean method02629() {
      return this.method01747() != null && this.method01752() != null;
   }

   void method01763();

   void method01750(BlockHitResult var1);

   void method01744(String var1);

   void method01757(boolean var1);

   void method01772(Rotation var1, float var2);

   default void method01755(String var1) {
   }

   void method01760(int var1);

   void method01761();

   void method01770(int var1);

   boolean method01778();

   default boolean method02630() {
      return true;
   }

   void method02631();

   Rotation method01762();

   int method01756();

   int method01743();

   WardenSpawnerTracker method01766();

   LocalPlayer method01747();

   void method01776(int var1, int var2, ContainerInput var3);

   boolean method01773();

   IBaritone method01775();
}
