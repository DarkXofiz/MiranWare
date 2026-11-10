// Original binary: sg/mx/rN0gokzE5UE0pyYn
package sg.mx;

import hex.api.baritone.utils.accessor.IChunkArray;
import hex.api.baritone.utils.accessor.IClientChunkProvider;
import java.lang.reflect.Field;
import java.util.Arrays;
import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.client.multiplayer.ClientLevel;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

// $VF: Compiled from s
@Mixin(ClientChunkCache.class)
public class ClientChunkCacheMixin_1300 implements IClientChunkProvider {
   @Final
   @Shadow
   ClientLevel level;

   @Override
   public ClientChunkCache createThreadSafeCopy() {
      IChunkArray var1 = this.extractReferenceArray();
      ClientChunkCache var2 = new ClientChunkCache(this.level, var1.viewDistance() - 3);
      IChunkArray var3 = ((IClientChunkProvider)var2).extractReferenceArray();
      var3.copyFrom(var1);
      if (var3.viewDistance() != var1.viewDistance()) {
         throw new IllegalStateException(var3.viewDistance() + " " + var1.viewDistance());
      } else {
         return var2;
      }
   }

   @Override
   public IChunkArray extractReferenceArray() {
      for (Field var4 : ClientChunkCache.class.getDeclaredFields()) {
         if (IChunkArray.class.isAssignableFrom(var4.getType())) {
            try {
               return (IChunkArray)var4.get(this);
            } catch (IllegalAccessException var6) {
               throw new RuntimeException(var6);
            }
         }
      }

      throw new RuntimeException(Arrays.toString(ClientChunkCache.class.getDeclaredFields()));
   }
}
