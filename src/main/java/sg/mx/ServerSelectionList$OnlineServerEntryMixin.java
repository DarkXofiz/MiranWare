// Original binary: sg/mx/XU1WoKnQCR77bGoF
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList.Entry;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList.OnlineServerEntry;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.PromotedServerManager;
import sg.ec.PromotedServerAccess;
import sg.ec.ColorUtils;
import sg.ec.MultiplayerServerListAccess;

// $VF: Compiled from s
@Mixin(OnlineServerEntry.class)
public class ServerSelectionList$OnlineServerEntryMixin implements MultiplayerServerListAccess {
   @Unique
   private static final float BACKGROUND_ALPHA = 0.25F;
   @Shadow
   @Final
   private ServerData serverData;
   private static final float field28023 = 0.3F;

   @Override
   public boolean hex$promoted() {
      return PromotedServerManager.method02793(this.serverData);
   }

   @Inject(method = "extractContent", at = @At("HEAD"))
   private void hex$promotedBackground(GuiGraphics var1, int var2, int var3, boolean var4, float var5, CallbackInfo var6) {
      if (this.hex$promoted()) {
         Entry var7 = (Entry)(Object)this;
         var1.fill(
            var7.getX(),
            var7.getY(),
            var7.getX() + var7.getWidth(),
            var7.getY() + var7.getHeight(),
            ColorUtils.method04605(((PromotedServerAccess)(Object)this.serverData).hex$promotedColor(), field28023)
         );
      }
   }

   @WrapOperation(
      method = {"extractContent", "keyPressed", "mouseClicked"},
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/multiplayer/ServerSelectionList;children()Ljava/util/List;")
   )
   private List<Entry> hex$userEntries(ServerSelectionList var1, Operation<List<Entry>> hex$original) {
      var var2 = var1.children();
      int var3 = 0;

      for (var var5 : var2) {
         if (!(var5 instanceof MultiplayerServerListAccess var6) || !var6.hex$promoted()) {
            break;
         }

         var3++;
      }

      return var3 == 0 ? var2 : var2.subList(var3, var2.size());
   }

   @WrapOperation(
      method = {"extractContent", "keyPressed", "mouseClicked"},
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ServerList;size()I")
   )
   private int hex$userServerCount(ServerList var1, Operation<Integer> hex$original) {
      return this.hex$promoted() ? 0 : var1.size();
   }

}
