// Original binary: sg/ec/sPEBx9wbkWoReoUl
package sg.ec;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.renderer.PlayerSkinRenderCache;
import net.minecraft.client.renderer.PlayerSkinRenderCache.RenderInfo;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.SkullBlock.Type;
import net.minecraft.world.level.block.SkullBlock.Types;
import net.minecraft.world.level.block.entity.SkullBlockEntity;

// $VF: Compiled from s
public final class SkullBlockRendererHooks {
   public static RenderType method10660(int var0, Type var1, SkullBlockEntity var2, PlayerSkinRenderCache var3, Operation<RenderType> var4) {
      if (var0 > 0) {
         return SkullTextureAtlas.INSTANCE.method11601();
      }

      RenderInfo var5 = method10661(var1, var2, var3);
      return var5 == null ? (RenderType)var4.call(new Object[]{var1, var2}) : var5.renderType();
   }

   private SkullBlockRendererHooks() {
   }

   private static RenderInfo method10661(Type var0, SkullBlockEntity var1, PlayerSkinRenderCache var2) {
      if (var0 != Types.PLAYER) {
         return null;
      }

      ResolvableProfile var3 = var1.getOwnerProfile();
      if (var3 == null) {
         return null;
      }

      SkullRenderInfoAccess var4 = (SkullRenderInfoAccess)var1;
      RenderInfo var5 = var4.hex$skullInfo();
      if (var5 != null && var4.hex$skullProfile() == var3) {
         return var5;
      }

      var var6 = var2.lookup(var3);
      boolean var7 = var6.isDone();
      RenderInfo var8 = var6.getNow(Optional.empty()).orElse(null);
      if (var8 == null) {
         var8 = var2.getOrDefault(var3);
      }

      if (var7) {
         var4.hex$skullInfo(var3, var8);
      }

      return var8;
   }

   public static int method10662(Type var0, SkullBlockEntity var1, PlayerSkinRenderCache var2) {
      RenderInfo var3 = method10661(var0, var1, var2);
      if (var3 == null) {
         return 0;
      }

      SkullRenderInfoAccess var4 = (SkullRenderInfoAccess)var1;
      Identifier var5 = var3.playerSkin().body().texturePath();
      int var6 = var4.hex$skullSlot();
      if (var6 > 0 && SkullTextureAtlas.INSTANCE.method11603(var6 - 1, var5)) {
         return var6;
      }

      var6 = SkullTextureAtlas.INSTANCE.method11604(var5) + 1;
      var4.hex$skullSlot(var6);
      return var6;
   }
}
