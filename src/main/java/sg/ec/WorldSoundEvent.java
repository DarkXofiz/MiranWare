// Original binary: sg/ec/j3aRO9aLb7HJHHcQ
package sg.ec;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class WorldSoundEvent extends Event {
   public static final WorldSoundEvent field20209 = new WorldSoundEvent();
   private Vec3 field20210;
   private WorldSoundEvent.Nested247 field20211;
   private float field20212;
   private float field20213;

   public WorldSoundEvent.Nested247 method08872() {
      return this.field20211;
   }

   public Vec3 method08873() {
      return this.field20210;
   }

   public void method08874(WorldSoundEvent.Nested247 var1) {
      this.field20211 = var1;
   }

   public float method08875(WorldSoundEvent.Nested247 var1, float var2, Vec3 var3) {
      if (var1 == null) {
         return var2;
      }

      this.field20210 = var3;
      this.field20211 = var1;
      this.field20212 = var2;
      this.field20213 = 1.0F;
      super.method03208();
      return this.method05694() ? var2 * (1.0F - Mth.clamp(this.field20213, 0.0F, 1.0F)) : var2;
   }

   public float method08876() {
      return this.field20213;
   }

   public float method08877() {
      return this.field20212;
   }

   public void method08878(Vec3 var1) {
      this.field20210 = var1;
   }

   public SimpleSoundInstance method08879(
      WorldSoundEvent.Nested247 var1, SoundEvent var2, SoundSource var3, float var4, float var5, RandomSource var6, double var7, double var9, double var11
   ) {
      float var13 = this.method08875(var1, var4, new Vec3(var7, var9, var11));
      return new SimpleSoundInstance(var2, var3, var13, var5, var6, var7, var9, var11);
   }

   public void method08880(float var1) {
      this.field20212 = var1;
   }

   public void method08881(float var1) {
      this.field20213 = var1;
   }

   // $VF: Compiled from s
   public enum Nested247 {
      WATER(SoundEvents.WATER_AMBIENT),
      WATER_DRIP(SoundEvents.POINTED_DRIPSTONE_DRIP_WATER),
      DRAGON_SUMMON(SoundEvents.ENDER_DRAGON_GROWL, SoundEvents.ENDER_DRAGON_DEATH, SoundEvents.ENDER_DRAGON_AMBIENT),
      WITHER_RELEASED(SoundEvents.WITHER_SPAWN),
      FIREWORK(SoundEvents.FIREWORK_ROCKET_LAUNCH),
      EXPERIENCE_BOTTLE(SoundEvents.EXPERIENCE_BOTTLE_THROW);

      private final SoundEvent[] field20214;

      Nested247(SoundEvent... var3) {
         this.field20214 = var3;
      }

      public static WorldSoundEvent.Nested247 method08882(SoundEvent var0) {
         if (var0 == null) {
            return null;
         }

         for (WorldSoundEvent.Nested247 var4 : values()) {
            for (SoundEvent var8 : var4.field20214) {
               if (var8.equals(var0)) {
                  return var4;
               }
            }
         }

         return null;
      }
   }
}
