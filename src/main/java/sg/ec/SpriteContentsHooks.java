// Original binary: sg/ec/ZWJhDx3FZNKrjHLA
package sg.ec;

import java.util.Optional;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class SpriteContentsHooks {
   public static Object[] method06889(Object var0, Object[] var1, Object var2) {
      return MixinCallbackUtils.method09737(var0, var1, var2);
   }

   private SpriteContentsHooks() {
   }

   public static <T> void method06890(MetadataSectionType<T> var0, Object[] var1, CallbackInfoReturnable<Optional<T>> var2) {
      MixinCallbackUtils.method09738(var0, var1, var2);
   }
}
