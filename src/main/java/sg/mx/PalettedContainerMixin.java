// Original binary: sg/mx/QGvSTG7rBtDffZz2
package sg.mx;

import hex.api.baritone.utils.accessor.IPalettedContainer;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import net.minecraft.util.BitStorage;
import net.minecraft.world.level.chunk.Palette;
import net.minecraft.world.level.chunk.PalettedContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

// $VF: Compiled from s
@Mixin(PalettedContainer.class)
public abstract class PalettedContainerMixin<T> implements IPalettedContainer<T> {
   @Unique
   private static final MethodHandle hex$DATA_GETTER;
   private static final String field28011 = "field28011";
   private static final String field28012 = "field28012";
   private static final String field28013 = "field28013";

   @Override
   public Palette<T> getPalette() {
      return this.data().getPalette();
   }

   @Override
   public BitStorage getStorage() {
      return this.data().getStorage();
   }

   @Unique
   private IPalettedContainer.IData<T> data() {
      try {
         return (IPalettedContainer.IData<T>)(Object)hex$DATA_GETTER.invoke((PalettedContainer)((PalettedContainer)(Object)this));
      } catch (Throwable var2) {
         throw (RuntimeException)hex$sneaky(var2, RuntimeException.class);
      }
   }

   @Unique
   private static <T extends Throwable> T hex$sneaky(Throwable var0, Class<T> var1) throws T {
      throw (T) var0;
   }

   static {
      Field var0 = null;

      for (Field var4 : PalettedContainer.class.getDeclaredFields()) {
         var var5 = var4.getType();
         if (IPalettedContainer.IData.class.isAssignableFrom(var5) && (var4.getModifiers() & 24) == 0 && !var4.isSynthetic()) {
            if (var0 != null) {
               throw new IllegalStateException(field28011);
            }

            var0 = var4;
         }
      }

      if (var0 == null) {
         throw new IllegalStateException(field28012);
      }

      MethodHandle var7;
      try {
         var7 = MethodHandles.lookup().unreflectGetter(var0);
      } catch (IllegalAccessException var6) {
         throw new IllegalStateException(field28013, var6);
      }

      MethodType var8 = MethodType.methodType(IPalettedContainer.IData.class, PalettedContainer.class);
      hex$DATA_GETTER = MethodHandles.explicitCastArguments(var7, var8);
   }
}
