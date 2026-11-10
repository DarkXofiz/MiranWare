// Original binary: sg/ec/u3Q5jQnbW10SQZWv
package sg.ec;

import net.minecraft.client.Minecraft;
import sg.mx.MinecraftMixin;

// $VF: Compiled from s
public class ItemUseInputDispatchEvent extends Event {
   public static final ItemUseInputDispatchEvent field24204 = new ItemUseInputDispatchEvent();
   private Minecraft field24205;

   public void method10890(Minecraft var1) {
      this.field24205 = var1;
      super.method03208();
      ((MinecraftMixin)(Object)var1).IdoItemUse();
   }

   public Minecraft method10891() {
      return this.field24205;
   }

   public void method10892(Minecraft var1) {
      this.field24205 = var1;
   }
}
