// Original binary: sg/mx/lHnsh9Dy0RNYtXUU
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.PlayerAnimationAccess;
import sg.ec.ItemFeatureVariables;

// $VF: Compiled from s
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin_1281 implements PlayerAnimationAccess {
   @Unique
   private boolean interactOffhand;
   @Unique
   private boolean interactMainHand;
   @Unique
   private boolean blockBreaking;
   @Unique
   private int offHandSwingTicks;
   @Unique
   private boolean offHandSwinging;
   @Unique
   private float offHandSwingProgress;
   @Unique
   private float lastOffHandSwingProgress;
   @Unique
   private int mainHandSwingTicks;
   @Unique
   private boolean mainHandSwinging;
   @Unique
   private float mainHandSwingProgress;
   @Unique
   private float lastMainHandSwingProgress;
   @Unique
   private int mainSwingCount;
   @Unique
   private boolean swingMHand;
   @Unique
   private boolean swingOHand;

   @Shadow
   public abstract ItemStack getMainHandItem();

   @Shadow
   public abstract ItemStack getOffhandItem();

   @Override
   public int hMI5_0$getSwingCount() {
      return this.mainSwingCount;
   }

   @Override
   public void hMI5_0$resetOffHandSwing(boolean var1) {
      this.offHandSwingTicks = 0;
      this.offHandSwinging = true;
      this.swingOHand = !this.swingOHand;
      this.interactOffhand = var1;
   }

   @Override
   public void hMI5_0$resetMainHandSwing(boolean var1) {
      this.mainHandSwingTicks = 0;
      this.mainHandSwinging = true;
      this.swingMHand = !this.swingMHand;
      this.mainSwingCount++;
      this.interactMainHand = var1;
      if (Minecraft.getInstance().gameMode.isDestroying()) {
         this.blockBreaking = true;
      }
   }

   @Override
   public float hMI5_0$getMainHandSwingProgress(float var1) {
      float var2 = this.mainHandSwingProgress - this.lastMainHandSwingProgress;
      if (var2 < 0.0F) {
         var2++;
      }

      return this.lastMainHandSwingProgress + var2 * var1;
   }

   @Override
   public float hMI5_0$getOffHandSwingProgress(float var1) {
      float var2 = this.offHandSwingProgress - this.lastOffHandSwingProgress;
      if (var2 < 0.0F) {
         var2++;
      }

      return this.lastOffHandSwingProgress + var2 * var1;
   }

   @Override
   public boolean hMI5_0$getMInteract() {
      return this.interactMainHand;
   }

   @Override
   public boolean hMI5_0$getOInteract() {
      return this.interactOffhand;
   }

   @Override
   public boolean hMI5_0$getBlockBreak() {
      return this.blockBreaking;
   }

   @Override
   public boolean hMI5_0$getMHandEvent() {
      return this.swingMHand;
   }

   @Override
   public boolean hMI5_0$getOHandEvent() {
      return this.swingOHand;
   }

   @Inject(method = "baseTick", at = @At("HEAD"))
   private void hmiTick(CallbackInfo var1) {
      this.lastOffHandSwingProgress = this.offHandSwingProgress;
      this.lastMainHandSwingProgress = this.mainHandSwingProgress;
      int var2 = ItemFeatureVariables.field24990.field25114.getOrDefault(this.getMainHandItem().getItem().toString(), 10);
      if (this.mainHandSwinging) {
         this.mainHandSwingTicks++;
         if (this.mainHandSwingTicks >= var2) {
            this.mainHandSwingTicks = 0;
            this.mainHandSwinging = false;
         }
      } else {
         if (this.interactMainHand) {
            this.interactMainHand = false;
         }

         if (this.blockBreaking) {
            this.blockBreaking = false;
         }

         this.mainHandSwingTicks = 0;
      }

      this.mainHandSwingProgress = (float)this.mainHandSwingTicks / var2;
      int var3 = ItemFeatureVariables.field24990.field25114.getOrDefault(this.getOffhandItem().getItem().toString(), 10);
      if (this.offHandSwinging) {
         this.offHandSwingTicks++;
         if (this.offHandSwingTicks >= var3) {
            this.offHandSwingTicks = 0;
            this.offHandSwinging = false;
         }
      } else {
         if (this.interactOffhand) {
            this.interactOffhand = false;
         }

         this.offHandSwingTicks = 0;
      }

      this.offHandSwingProgress = (float)this.offHandSwingTicks / var3;
   }

   @Inject(method = "swing(Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/item/component/SwingAnimation;Z)Z", at = @At("HEAD"))
   private void hmiOnSwing(InteractionHand var1, net.minecraft.world.item.component.SwingAnimation hexAnim, boolean var2, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<Boolean> var3) {
      if (var1 == InteractionHand.OFF_HAND) {
         int var4 = ItemFeatureVariables.field24990.field25114.getOrDefault(this.getOffhandItem().getItem().toString(), 10);
         if (!this.offHandSwinging || this.offHandSwingTicks >= var4 / 2 || this.offHandSwingTicks < 0) {
            this.offHandSwingTicks = -1;
            this.offHandSwinging = true;
         }
      } else {
         int var5 = ItemFeatureVariables.field24990.field25114.getOrDefault(this.getMainHandItem().getItem().toString(), 10);
         if (!this.mainHandSwinging || this.mainHandSwingTicks >= var5 / 2 || this.mainHandSwingTicks < 0) {
            this.mainHandSwingTicks = -1;
            this.mainHandSwinging = true;
            if (Minecraft.getInstance().gameMode.isDestroying()) {
               this.blockBreaking = true;
            }
         }
      }
   }
}
