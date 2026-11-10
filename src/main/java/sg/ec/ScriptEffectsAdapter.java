// Original binary: sg/ec/CWoOkQ4cmLkew6Xe
package sg.ec;

import hex.script.api.Particles;
import hex.script.api.Sounds;
import hex.script.api.event.SoundEvent;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.DustColorTransitionOptions;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public final class ScriptEffectsAdapter implements MinecraftAccess {
   private static final Object field06812 = new Object();
   private static final int field06813 = 256;
   private static final int field06814 = 0;
   private final Map<String, Object> field06815 = new ConcurrentHashMap<>();
   private final Map<String, Object> field06816 = new ConcurrentHashMap<>();
   private final SoundEvent field06817 = new SoundEvent();
   private final Sounds field06818 = new Sounds(this::method02984, this::method02995, this::method02979);
   private final Particles field06819 = new Particles(this::method02981);
   private String[] field06820;
   private boolean field06821;
   private static final float field06822 = 16.0F;
   private static final float field06823 = 0.5F;
   private static final float field06824 = 0.01F;
   private static final float field06825 = 0.01F;

   Sounds method02976() {
      this.method02987();
      return this.field06818;
   }

   private ParticleOptions method02977(String var1, int var2, int var3, int var4, float var5, String var6) {
      return switch (var2) {
         case 1 -> new DustParticleOptions(var3, Math.max(field06824, var5));
         case 2 -> new DustColorTransitionOptions(var3, var4, Math.max(field06825, var5));
         case 3 -> this.method02988(var1, var3);
         case 4 -> this.method02993(var1, var6);
         case 5 -> this.method02992(var1, var6);
         default -> this.method02989(var1);
      };
   }

   private String[] method02979() {
      if (this.field06820 == null) {
         var var1 = BuiltInRegistries.SOUND_EVENT.keySet();
         String[] var2 = new String[var1.size()];
         int var3 = 0;

         for (Identifier var5 : var1) {
            var2[var3++] = var5.toString();
         }

         Arrays.sort(var2);
         this.field06820 = var2;
      }

      return (String[])this.field06820.clone();
   }

   private boolean method02981(
      String var1,
      int var2,
      int var3,
      int var4,
      float var5,
      String var6,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      int var19,
      double var20
   ) {
      if (Double.isFinite(var7)
         && Double.isFinite(var9)
         && Double.isFinite(var11)
         && Double.isFinite(var13)
         && Double.isFinite(var15)
         && Double.isFinite(var17)
         && Double.isFinite(var20)
         && Float.isFinite(var5)) {
         ParticleOptions var22 = this.method02977(var1, var2, var3, var4, var5, var6);
         if (var22 != null && mc.level != null) {
            int var23 = Mth.clamp(var19, 1, 512);
            double var24 = Math.max(0.0, var20);
            return method02998(() -> this.method02982(var22, var7, var9, var11, var13, var15, var17, var23, var24));
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void method02982(ParticleOptions var1, double var2, double var4, double var6, double var8, double var10, double var12, int var14, double var15) {
      ClientLevel var17 = mc.level;
      if (var17 != null) {
         if (var15 <= 0.0) {
            for (int var20 = 0; var20 < var14; var20++) {
               var17.addParticle(var1, var2, var4, var6, var8, var10, var12);
            }
         } else {
            RandomSource var18 = var17.getRandom();

            for (int var19 = 0; var19 < var14; var19++) {
               var17.addParticle(
                  var1, var2 + var18.nextGaussian() * var15, var4 + var18.nextGaussian() * var15, var6 + var18.nextGaussian() * var15, var8, var10, var12
               );
            }
         }
      }
   }

   private boolean method02984(String var1, double var2, double var4, double var6, float var8, float var9, boolean var10) {
      net.minecraft.sounds.SoundEvent var11 = this.method02990(var1);
      if (var11 == null) {
         return false;
      } else {
         float var12 = method02997(var8, 1.0F, 0.0F, field06822);
         float var13 = method02997(var9, 1.0F, field06823, 2.0F);
         if (!var10) {
            return method02998(() -> {
               SoundManager var3 = mc.getSoundManager();
               if (var3 != null) {
                  var3.play(SimpleSoundInstance.forUI(var11, var13, var12));
               }
            });
         } else {
            return mc.level != null && Double.isFinite(var2) && Double.isFinite(var4) && Double.isFinite(var6) ? method02998(() -> {
               ClientLevel var9x = mc.level;
               if (var9x != null) {
                  var9x.playLocalSound(var2, var4, var6, var11, SoundSource.MASTER, var12, var13, false);
               }
            }) : false;
         }
      }
   }

   void method02985() {
      this.method02987();
   }

   private void method02986(SoundInstance var1, WeighedSoundEvents var2, float var3) {
      if (var1 != null) {
         ScriptEventNames var4 = ScriptRuntime.INSTANCE.method06230().method11770();
         if (var4.method04786(SoundEvent.class)) {
            Identifier var5 = var1.getIdentifier();
            SoundSource var6 = var1.getSource();
            this.field06817
               .set(
                  var5 == null ? "" : var5.toString(),
                  var6 == null ? "" : var6.getName(),
                  var1.getVolume(),
                  var1.getPitch(),
                  var1.getX(),
                  var1.getY(),
                  var1.getZ()
               );
            var4.method04785(this.field06817, false);
         }
      }
   }

   private void method02987() {
      if (!this.field06821) {
         SoundManager var1 = mc.getSoundManager();
         if (var1 != null) {
            var1.addListener(this::method02986);
            this.field06821 = true;
         }
      }
   }

   private ParticleOptions method02988(String var1, int var2) {
      ParticleType var3 = this.method02994(var1);
      return var3 != ParticleTypes.ENTITY_EFFECT && var3 != ParticleTypes.TINTED_LEAVES && var3 != ParticleTypes.FLASH
         ? null
         : ColorParticleOption.create(var3, var2);
   }

   private ParticleOptions method02989(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         Object var2 = this.field06816.get(var1);
         if (var2 != null) {
            return var2 instanceof ParticleOptions var7 ? var7 : null;
         }

         Identifier var3 = Identifier.tryParse(var1);
         SimpleParticleType var5 = (var3 == null ? null : (ParticleType)BuiltInRegistries.PARTICLE_TYPE.getValue(var3)) instanceof SimpleParticleType var6
            ? var6
            : null;
         method02999(this.field06816, var1, var5);
         return var5;
      } else {
         return null;
      }
   }

   private net.minecraft.sounds.SoundEvent method02990(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         Object var2 = this.field06815.get(var1);
         if (var2 != null) {
            return var2 instanceof net.minecraft.sounds.SoundEvent var5 ? var5 : null;
         }

         Identifier var3 = Identifier.tryParse(var1);
         net.minecraft.sounds.SoundEvent var4 = var3 == null ? null : BuiltInRegistries.SOUND_EVENT.getValue(var3);
         method02999(this.field06815, var1, var4);
         return var4;
      } else {
         return null;
      }
   }

   private ParticleOptions method02992(String var1, String var2) {
      ParticleType var3 = this.method02994(var1);
      if (var3 != ParticleTypes.ITEM) {
         return null;
      }

      ItemStack var4 = ScriptRenderResources.method08787(var2);
      return var4.isEmpty() ? null : new ItemParticleOption(var3, var4);
   }

   private ParticleOptions method02993(String var1, String var2) {
      ParticleType var3 = this.method02994(var1);
      if (var3 != ParticleTypes.BLOCK
         && var3 != ParticleTypes.BLOCK_MARKER
         && var3 != ParticleTypes.FALLING_DUST
         && var3 != ParticleTypes.DUST_PILLAR
         && var3 != ParticleTypes.BLOCK_CRUMBLE) {
         return null;
      }

      Identifier var4 = var2 != null && !var2.isEmpty() ? Identifier.tryParse(var2.indexOf(58) < 0 ? "minecraft:" + var2 : var2) : null;
      Block var5 = var4 == null ? null : BuiltInRegistries.BLOCK.getValue(var4);
      return var5 == null ? null : new BlockParticleOption(var3, var5.defaultBlockState());
   }

   private ParticleType<?> method02994(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         Identifier var2 = Identifier.tryParse(var1.indexOf(58) < 0 ? "minecraft:" + var1 : var1);
         return var2 == null ? null : BuiltInRegistries.PARTICLE_TYPE.getValue(var2);
      } else {
         return null;
      }
   }

   private boolean method02995(String var1) {
      SoundManager var2 = mc.getSoundManager();
      if (var2 == null) {
         return false;
      }

      if (var1 == null) {
         return method02998(var2::stop);
      }

      net.minecraft.sounds.SoundEvent var3 = this.method02990(var1);
      return var3 == null ? false : method02998(() -> var2.stop(var3.location(), null));
   }

   Particles method02996() {
      this.method02987();
      return this.field06819;
   }

   private static float method02997(float var0, float var1, float var2, float var3) {
      return Float.isFinite(var0) ? Mth.clamp(var0, var2, var3) : var1;
   }

   private static boolean method02998(Runnable var0) {
      if (mc.isSameThread()) {
         var0.run();
         return true;
      } else {
         mc.execute(var0);
         return true;
      }
   }

   private static void method02999(Map<String, Object> var0, String var1, Object var2) {
      if (var0.size() >= 256) {
         var0.clear();
      }

      var0.put(var1, var2 == null ? field06812 : var2);
   }
}
