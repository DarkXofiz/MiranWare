// Original binary: sg/mx/75DbtD0CzGAjw0Gn
package sg.mx;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.InventoryEntityRenderHook;
import sg.ec.AnimationUtils;
import sg.ec.ContainerAnimationEvent;

// $VF: Compiled from s
@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends AbstractRecipeBookScreen<InventoryMenu> {
   @Unique
   private AnimationUtils anim;
   private static final long field28005 = 250L;

   public InventoryScreenMixin(InventoryMenu var1, RecipeBookComponent<?> var2, Inventory var3, Component var4) {
      super(var1, var2, var3, var4);
   }

   @Unique
   private AnimationUtils anim() {
      AnimationUtils var1 = this.anim;
      if (var1 == null) {
         var1 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_EXPO, field28005);
         this.anim = var1;
      }

      return var1;
   }

   @Inject(
      method = "extractBackground",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blit(Lcom/mojang/renderpearl/api/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIFFIIII)V"
      )
   )
   private void renderStart(
      GuiGraphicsExtractor var1, int var2, int var3, float var4, CallbackInfo var5, @Local(ordinal = 2) int var6, @Local(ordinal = 3) int var7
   ) {
      ContainerAnimationEvent.field11706.method05385(var6, var7, this, var1, this.anim());
   }

   @Redirect(
      method = "extractBackground",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/screens/inventory/InventoryScreen;extractEntityInInventoryFollowsMouse(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IIIIIFFFLnet/minecraft/world/entity/LivingEntity;)V"
      )
   )
   private void redirectDrawEntity(
      GuiGraphicsExtractor var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, LivingEntity var10
   ) {
      InventoryEntityRenderHook.method00748(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   @Inject(method = "extractRenderState", at = @At("TAIL"))
   private void renderEnd(GuiGraphicsExtractor var1, int var2, int var3, float var4, CallbackInfo var5) {
      ContainerAnimationEvent.field11706.method05382(this, var1, this.anim());
   }

}
