// Original binary: hex/api/baritone/behavior/LookBehavior
package hex.api.baritone.behavior;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.Settings;
import hex.api.baritone.api.behavior.ILookBehavior;
import hex.api.baritone.api.behavior.look.IAimProcessor;
import hex.api.baritone.api.behavior.look.ITickableAimProcessor;
import hex.api.baritone.api.event.events.PacketEvent;
import hex.api.baritone.api.event.events.PlayerUpdateEvent;
import hex.api.baritone.api.event.events.RotationMoveEvent;
import hex.api.baritone.api.event.events.TickEvent;
import hex.api.baritone.api.event.events.WorldEvent;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.api.utils.Rotation;
import hex.api.baritone.behavior.look.ForkableRandom;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.PosRot;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Rot;
import net.minecraft.util.Mth;
import sg.ec.RotationManager;

// $VF: Compiled from s
public final class LookBehavior extends Behavior implements ILookBehavior {
   private static final float BARITONE_TURN_SPEED = 180.0F;
   private static final int BARITONE_ROTATION_PRIORITY = 1;
   private LookBehavior.Target target;
   private Rotation serverRotation;
   private Rotation prevRotation;
   private final LookBehavior.AimProcessor processor;
   private final Deque<Float> smoothYawBuffer;
   private final Deque<Float> smoothPitchBuffer;
   private static final float б3Ц = 0;

   @Override
   public void onWorldEvent(WorldEvent var1) {
      this.serverRotation = null;
      this.target = null;
   }


   @Override
   public void updateTarget(Rotation var1, boolean var2) {
      this.target = new LookBehavior.Target(var1, LookBehavior.Target.Mode.resolve(this.ctx, var2));
   }

   public LookBehavior(Baritone var1) {
      super(var1);
      this.processor = new LookBehavior.AimProcessor(var1.getPlayerContext());
      this.smoothYawBuffer = new ArrayDeque<>();
      this.smoothPitchBuffer = new ArrayDeque<>();
   }

   public void pig() {
      if (this.target != null) {
         Rotation var1 = this.processor.peekRotation(this.target.rotation);
         this.ctx.player().setYRot(var1.getYaw());
      }
   }

   @Override
   public void onPlayerRotationMove(RotationMoveEvent var1) {
      if (this.target != null) {
         Rotation var2 = this.processor.peekRotation(this.target.rotation);
         var1.setYaw(var2.getYaw());
         var1.setPitch(var2.getPitch());
      }
   }

   @Override
   public void onPlayerUpdate(PlayerUpdateEvent var1) {
      if (this.target != null) {
         switch (var1.getState()) {
            case PRE:
               if (this.target.mode == LookBehavior.Target.Mode.NONE) {
                  return;
               }

               if (this.ctx.player() != null) {
                  if (this.ctx.player() == this.ctx.minecraft().player) {
                     if (this.ctx.minecraft().isSameThread()) {
                        RotationManager.method06547(new sg.ec.Rotation(this.target.rotation.getYaw(), this.target.rotation.getPitch()), б3Ц, 1, false);
                     }
                  } else {
                     Rotation var2 = this.processor.peekRotation(this.target.rotation);
                     float sx = this.ctx.player().getYRot();
                     this.ctx.player().setYRot(sx + Mth.wrapDegrees(var2.getYaw() - sx));
                     this.ctx.player().setXRot(var2.getPitch());
                  }
               }
               break;
            case POST:
               this.target = null;
         }
      }
   }

   public Optional<Rotation> getEffectiveRotation() {
      return Baritone.settings().freeLook.value ? Optional.ofNullable(this.serverRotation) : Optional.empty();
   }

   @Override
   public IAimProcessor getAimProcessor() {
      return this.processor;
   }

   @Override
   public void onSendPacket(PacketEvent var1) {
      if (var1.getPacket() instanceof ServerboundMovePlayerPacket) {
         ServerboundMovePlayerPacket var2 = (ServerboundMovePlayerPacket)var1.getPacket();
         if (var2 instanceof Rot || var2 instanceof PosRot) {
            this.serverRotation = new Rotation(var2.getYRot(0.0F), var2.getXRot(0.0F));
         }
      }
   }

   @Override
   public void onTick(TickEvent var1) {
      if (var1.getType() == TickEvent.Type.IN) {
         this.processor.tick();
      }
   }

   // $VF: Compiled from s
   private abstract static class AbstractAimProcessor implements ITickableAimProcessor {
      protected final IPlayerContext ctx;
      private final ForkableRandom rand;
      private double randomYawOffset;
      private double randomPitchOffset;
      private static final double бгЯ = 0;
      private static final double бгХ = 0;
      private static final double бгШ = 0;
      private static final double бга = 0;
      private static final double бг7 = 0;
      private static final float бгУ = 0;
      private static final float бг0 = 0;
      private static final double бгГ = 0;
      private static final double бгф = 0;
      private static final double бгЕ = 0;
      private static final float бгч = 0;

      protected abstract Rotation getPrevRotation();

      @Override
      public final Rotation peekRotation(Rotation var1) {
         Rotation var2 = this.getPrevRotation();
         float sx = var1.getYaw();
         float sxx = var1.getPitch();
         if (sxx == var2.getPitch()) {
            sxx = this.nudgeToLevel(sxx);
         }

         sx = (float)(sx + this.randomYawOffset);
         sxx = (float)(sxx + this.randomPitchOffset);
         return new Rotation(this.calculateMouseMove(var2.getYaw(), sx), this.calculateMouseMove(var2.getPitch(), sxx)).clamp();
      }

      private double angleToMouse(float var1) {
         float var2 = this.mouseToAngle(1.0);
         return Math.round(var1 / var2);
      }


      private float calculateMouseMove(float var1, float var2) {
         float var3 = var2 - var1;
         double sx = this.angleToMouse(var3);
         return var1 + this.mouseToAngle(sx);
      }

      private AbstractAimProcessor(LookBehavior.AbstractAimProcessor var1) {
         this.ctx = var1.ctx;
         this.rand = var1.rand.fork();
         this.randomYawOffset = var1.randomYawOffset;
         this.randomPitchOffset = var1.randomPitchOffset;
      }

      @Override
      public final void advance(int var1) {
         for (int var2 = 0; var2 < var1; var2++) {
            this.tick();
         }
      }

      @Override
      public final ITickableAimProcessor fork() {
         return new LookBehavior.AbstractAimProcessor(this)         // $VF: Compiled from s
 {
            private Rotation prev = AbstractAimProcessor.this.getPrevRotation();

            @Override
            public Rotation nextRotation(Rotation var1) {
               return this.prev = super.nextRotation(var1);
            }

            @Override
            protected Rotation getPrevRotation() {
               return this.prev;
            }
         };
      }

      @Override
      public final void tick() {
         this.randomYawOffset = (this.rand.nextDouble() - бгЯ) * Baritone.settings().randomLooking.value;
         this.randomPitchOffset = (this.rand.nextDouble() - бгХ) * Baritone.settings().randomLooking.value;
         double var1 = this.rand.nextDouble() - бгШ;
         if (Math.abs(var1) < бга) {
            var1 *= бг7;
         }

         this.randomYawOffset = this.randomYawOffset + var1 * Baritone.settings().randomLooking113.value;
      }

      private float mouseToAngle(double var1) {
         double var3 = this.ctx.minecraft().options.sensitivity().get() * бгГ + бгф;
         return (float)(var1 * var3 * var3 * var3 * бгЕ) * бгч;
      }

      private float nudgeToLevel(float var1) {
         if (var1 < бгУ) {
            return var1 + 1.0F;
         } else {
            return var1 > бг0 ? var1 - 1.0F : var1;
         }
      }

      @Override
      public Rotation nextRotation(Rotation var1) {
         Rotation var2 = this.peekRotation(var1);
         this.tick();
         return var2;
      }

      public AbstractAimProcessor(IPlayerContext var1) {
         this.ctx = var1;
         this.rand = new ForkableRandom();
      }
   }

   // $VF: Compiled from s
   private static final class AimProcessor extends LookBehavior.AbstractAimProcessor {
      public AimProcessor(IPlayerContext var1) {
         super(var1);
      }

      @Override
      protected Rotation getPrevRotation() {
         return this.ctx.playerRotations();
      }
   }

   // $VF: Compiled from s
   private static class Target {
      public final Rotation rotation;
      public final LookBehavior.Target.Mode mode;

      public Target(Rotation var1, LookBehavior.Target.Mode var2) {
         this.rotation = var1;
         this.mode = var2;
      }

      // $VF: Compiled from s
      enum Mode {
         CLIENT,
         SERVER,
         NONE;

         static LookBehavior.Target.Mode resolve(IPlayerContext var0, boolean var1) {
            Settings var2 = Baritone.settings();
            boolean sx = var2.antiCheatCompatibility.value;
            boolean sxx = var2.blockFreeLook.value;
            if (var0.player().isFallFlying()) {
               return var2.elytraFreeLook.value ? SERVER : CLIENT;
            }

            if (var2.freeLook.value) {
               if (var1) {
                  return sxx ? SERVER : CLIENT;
               } else {
                  return sx ? SERVER : NONE;
               }
            } else {
               return CLIENT;
            }
         }
      }
   }
}
