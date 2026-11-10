// Original binary: sg/ec/Htio3o0DvV2afRbF
package sg.ec;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance.Attenuation;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import sg.mx.SoundEngineMixin;
import sg.mx.SoundManagerMixin_1257;

// $VF: Compiled from s
public enum ClientSoundManager implements MinecraftAccess {
   INSTANCE;

   private final Map<String, SoundEvent> field08642 = new ConcurrentHashMap<>();
   private final Map<String, Boolean> field08643 = new ConcurrentHashMap<>();

   public void method03827(String var1, float var2) {
      SoundEvent var3 = this.method03829(var1);
      if (var3 != null) {
         SoundEngine var4 = ((SoundManagerMixin_1257)(Object)mc.getSoundManager()).getSoundSystem();
         if (((SoundEngineMixin)(Object)var4).isStarted()) {
            var4.play(
               new SimpleSoundInstance(
                  var3.location(),
                  SoundSource.MASTER,
                  this.method03833(var2),
                  1.0F,
                  SoundInstance.createUnseededRandom(),
                  false,
                  0,
                  Attenuation.NONE,
                  0.0,
                  0.0,
                  0.0,
                  true
               )
            );
         }
      }
   }

   public void method03828(String var1, float var2, double var3, double var5, double var7) {
      if (mc.level == null) {
         this.method03827(var1, var2);
      } else {
         SoundEvent var9 = this.method03829(var1);
         if (var9 != null) {
            mc.level.playSound(mc.player, var3, var5, var7, var9, SoundSource.MASTER, this.method03833(var2), 1.0F);
         }
      }
   }

   private SoundEvent method03829(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String var2 = var1.toLowerCase(Locale.ROOT);
         return !this.method03831(var2) ? null : this.field08642.computeIfAbsent(var2, ClientSoundManager::method03830);
      } else {
         return null;
      }
   }

   private static SoundEvent method03830(String var0) {
      Identifier var1 = Identifier.fromNamespaceAndPath("Hex".toLowerCase(Locale.ROOT), var0);
      return SoundEvent.createVariableRangeEvent(var1);
   }

   private boolean method03831(String var1) {
      return this.field08643.computeIfAbsent(var1, ClientSoundManager::method03832);
   }

   private static boolean method03832(String var0) {
      Identifier var1 = Identifier.fromNamespaceAndPath("Hex".toLowerCase(Locale.ROOT), "sounds/" + var0 + ".ogg");
      return mc.getResourceManager().getResource(var1).isPresent();
   }

   private float method03833(float var1) {
      if (!Float.isFinite(var1)) {
         return 0.0F;
      } else {
         return var1 < 0.0F ? 0.0F : var1;
      }
   }

   public void method03834() {
      this.field08642.clear();
      this.field08643.clear();
   }
}
