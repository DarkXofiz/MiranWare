// Original binary: sg/mx/bGvaQcgYFqLDj7E6
package sg.mx;

import java.awt.Color;
import java.util.Locale;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.RoundedRectRenderer;
import sg.ec.AnimationUtils;
import sg.ec.ColorUtils;
import sg.ec.AbstractContainerScreenHooks;
import sg.ec.ClientFeaturePolicyEvent;

// $VF: Compiled from s
@Mixin(AbstractContainerScreen.class)
public abstract class AbstractContainerScreenMixin_1243 extends Screen {
   @Shadow
   protected int leftPos;
   @Shadow
   protected int topPos;
   @Shadow
   @Final
   protected int imageWidth;
   @Shadow
   @Final
   protected AbstractContainerMenu menu;
   @Unique
   private static String hex$searchText;
   @Unique
   private AnimationUtils hex$highlightAnimation;
   @Unique
   private EditBox hex$searchBox;
   @Unique
   private String hex$normalizedSearch;
   @Unique
   private boolean hex$searchHidden;
   private static final long field28024 = 150L;
   private static final String field28025 = "Поиск";
   private static final String field28026 = "Поиск предметов...";
   private static final long field28027 = 1000L;
   private static final long field28028 = 500L;
   private static final double field28029 = 1.0;
   private static final float field28030 = 16.0F;
   private static final float field28031 = 16.0F;

   @Unique
   private static String hex$searchText() {
      return hex$searchText == null ? "" : hex$searchText;
   }

   @Unique
   private AnimationUtils hex$highlightAnimation() {
      AnimationUtils var1 = this.hex$highlightAnimation;
      if (var1 == null) {
         var1 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field28024);
         this.hex$highlightAnimation = var1;
      }

      return var1;
   }

   @Unique
   private String hex$normalizedSearch() {
      return this.hex$normalizedSearch == null ? "" : this.hex$normalizedSearch;
   }

   protected AbstractContainerScreenMixin_1243(Component var1) {
      super(var1);
   }

   @Inject(method = "init", at = @At("TAIL"))
   private void hex$initSearch(CallbackInfo var1) {
      if (this.hex$isChestScreen()) {
         this.hex$normalizedSearch = hex$normalize(hex$searchText());
         int var2 = AbstractContainerScreenHooks.method06045(this.topPos);
         this.hex$searchBox = new EditBox(this.font, this.leftPos, var2, this.imageWidth, 12, Component.literal(field28025));
         this.hex$searchBox.setHint(Component.literal(field28026));
         this.hex$searchBox.setMaxLength(64);
         this.hex$searchBox.setValue(hex$searchText());
         this.hex$searchBox.setResponder(var1x -> {
            hex$searchText = var1x;
            this.hex$normalizedSearch = hex$normalize(var1x);
         });
         this.addRenderableWidget(this.hex$searchBox);
         this.hex$updateSearchVisibility();
      }
   }

   @Inject(method = "extractContents", at = @At("HEAD"))
   private void hex$updateSearchState(GuiGraphics var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (this.hex$isChestScreen()) {
         this.hex$updateSearchVisibility();
      }
   }

   @Inject(method = "extractSlots", at = @At("TAIL"))
   private void hex$highlightSearchResults(GuiGraphics var1, int var2, int var3, CallbackInfo var4) {
      if (this.hex$isChestScreen() && !this.hex$searchHidden && !this.hex$normalizedSearch().isEmpty()) {
         long var5 = System.currentTimeMillis();
         this.hex$highlightAnimation().method03375(var5 % field28027 > field28028 ? field28029 : 0.0);
         int var7 = ColorUtils.method04611(Color.YELLOW.getRGB(), this.hex$highlightAnimation().method03377());
         int var8 = ((ChestMenu)(Object)this.menu).getRowCount() * 9;
         RoundedRectRenderer.method01277();

         for (int var9 = 0; var9 < var8; var9++) {
            Slot var10 = this.menu.slots.get(var9);
            if (this.hex$matches(var10)) {
               RoundedRectRenderer.method01272(var1, var10.x, var10.y, field28030, field28031, 0.0F, 0.0F, var7);
            }
         }

         RoundedRectRenderer.method01278();
      }
   }

   @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
   private void hex$handleSearchInput(KeyEvent var1, CallbackInfoReturnable<Boolean> var2) {
      if (this.hex$isChestScreen() && this.hex$searchBox != null && this.hex$searchBox.visible && this.hex$searchBox.isFocused() && !var1.isEscape()) {
         boolean var3 = this.hex$searchBox.keyPressed(var1);
         var2.setReturnValue(var3 || this.hex$searchBox.canConsumeInput());
      }
   }

   @Inject(method = "mouseClicked", at = @At("HEAD"))
   private void hex$clearSearchFocusOnOutsideClick(MouseButtonEvent var1, boolean var2, CallbackInfoReturnable<Boolean> var3) {
      if (this.hex$isChestScreen() && this.hex$searchBox != null && this.hex$searchBox.isFocused() && !this.hex$searchBox.isMouseOver(var1.x(), var1.y())) {
         this.setFocused(null);
      }
   }

   @Unique
   private boolean hex$isChestScreen() {
      return (Object)this instanceof ContainerScreen;
   }

   @Unique
   private boolean hex$matches(Slot var1) {
      return var1.hasItem() && hex$normalize(var1.getItem().getStyledHoverName().getString()).contains(this.hex$normalizedSearch());
   }

   @Unique
   private void hex$updateSearchVisibility() {
      if (this.hex$searchBox != null) {
         this.hex$searchHidden = ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CHEST_SEARCH);
         this.hex$searchBox.visible = !this.hex$searchHidden;
         this.hex$searchBox.active = !this.hex$searchHidden;
         if (this.hex$searchHidden) {
            this.setFocused(null);
         }
      }
   }

   @Unique
   private static String hex$normalize(String var0) {
      return var0.trim().toLowerCase(Locale.ROOT);
   }

}
