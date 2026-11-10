// Original binary: sg/ec/5Y3ziFwLpwmYegKH
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.LerpingBossEvent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.BossEvent.BossBarOverlay;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;
import sg.mx.BossHealthOverlayMixin;

// $VF: Compiled from s
public class WorldHelper extends ClientModule {
   private final ModeSetting field02425;
   private final List<_5bBkC0fhj2Q8h9bz> field02426;
   private static final double field02427 = 3.0;
   private final Set<UUID> field02428;
   private static final long field02429 = 0;
   private static final int field02430 = 0;
   private static final int field02431 = 0;
   private static final int field02432 = 0;
   private static final int field02433 = 0;
   private static final double field02434 = 0;
   private static final int field02435 = 0;
   private static final int field02436 = 0;
   private static final int field02437 = 0;
   private static final double field02438 = 0;
   private static final int field02439 = 0;
   private static final int field02440 = 0;
   private static final int field02441 = 0;
   private static final int field02442 = 0;
   private static final int field02443 = 0;
   private static final int field02444 = 0;
   private static final double field02445 = 0;
   private static final int field02446 = 0;
   private static final int field02447 = 0;
   private static final int field02448 = 0;
   private static final double field02449 = 0;
   private static final int field02450 = 0;
   private static final int field02451 = 0;
   private final List<fEEsjlIyg7aYDL47> field02452;
   private long field02453;
   private int field02454;
   private final Map<Long, Block> field02455;
   private final Object field02456;
   private final AtomicBoolean field02457;
   private volatile boolean field02458;
   private static final String field02459 = "Сервер";
   private static final String field02460 = "Funtime";
   private static final String field02461 = "HolyWorld";
   private static final String field02462 = "ReallyWorld";
   private static final String field02463 = "Funtime";
   private static final String field02464 = "World Helper";
   private static final String field02465 = "ReallyWorld";
   private static final String field02466 = "Funtime";
   private static final float field02467 = 20.0F;
   private static final float field02468 = 40.0F;
   private static final float field02469 = 6.0F;
   private static final float field02470 = 4.0F;
   private static final float field02471 = 11.0F;
   private static final float field02472 = 7.0F;
   private static final float field02473 = 2.5F;
   private static final float field02474 = 3.0F;
   private static final float field02475 = 5.0F;
   private static final float field02476 = 0.65F;
   private static final float field02477 = 6.0F;
   private static final float field02478 = 6.0F;
   private static final double field02479 = 3.0;
   private static final double field02480 = 3.0;
   private static final String field02481 = "HolyWorld";
   private static final float field02482 = 0.5F;
   private static final float field02483 = 0.7F;
   private static final String field02484 = "ReallyWorld";
   private static final String field02485 = "Funtime";
   private static final long field02486 = 1000L;
   private static final double field02487 = 2.0;
   private static final double field02488 = 0.5;
   private static final double field02489 = 2.0;
   private static final double field02490 = 0.5;
   private static final double field02491 = 2.0;
   private static final double field02492 = 0.5;
   private static final double field02493 = 2.0;
   private static final double field02494 = 0.5;
   private static final double field02495 = 0.5;
   private static final double field02496 = 2.0;
   private static final double field02497 = 0.5;
   private static final double field02498 = 2.0;
   private static final double field02499 = 0.5;
   private static final double field02500 = 2.0;
   private static final double field02501 = 0.5;
   private static final double field02502 = 2.0;
   private static final double field02503 = 0.5;
   private static final double field02504 = 3.0;
   private static final double field02505 = 2.0;
   private static final double field02506 = 4.0;
   private static final double field02507 = 3.0;
   private static final double field02508 = 4.0;
   private static final double field02509 = 2.0;
   private static final double field02510 = 4.0;
   private static final double field02511 = 4.0;
   private static final double field02512 = 4.0;
   private static final double field02513 = 4.0;
   private static final long field02514 = 400L;

   private Vec3 method01153(List<fEEsjlIyg7aYDL47> var1) {
      return this.method01161(var1, 4, 1, 4, 45, 4, 1, 4);
   }

   @Subscribe
   private void method01155(HudRenderEvent var1) {
      if (!this.field02426.isEmpty()) {
         GuiGraphics var2 = var1.method05424();
         PoseStack var3 = var1.method05425();
         float var4 = field02467;
         float var5 = field02468;
         ItemRenderUtils.method08410();
         RoundedRectRenderer.method01277();
         FontRenderer.method09475();

         for (_5bBkC0fhj2Q8h9bz var7 : this.field02426) {
            ItemStack var8 = var7.б();
            Vector2f var9 = WorldProjectionUtils.method09460(var3, var7.西());
            int var10 = var7.г() - var7.юю();
            String var11 = TextRenderUtils.method00680(var10);
            String var12 = var7.Б().必();
            float var13 = var9.x;
            float var14 = var9.y;
            float var15 = field02469;
            float var16 = field02470;
            float var17 = field02471;
            float var18 = field02472;
            float var19 = field02473;
            float var20 = field02474;
            float var21 = Fonts.field00109.method09486(var12, var18);
            float var22 = Fonts.field00109.method09486(var11, var18);
            float var23 = var15 + var17 + var16 + var21 + var16 + var22 + var15;
            float var24 = var13 - var23 / 2.0F;
            float var25 = var14 - var4 / 2.0F;
            float var26 = var24 + var15;
            float var27 = var26 + var17 + var16;
            float var28 = var27 + var21 + var16;
            float var29 = var18 + var20 + var19;
            float var30 = var25 + (var4 - var29) / 2.0F;
            float var31 = var30 + var18 / 2.0F;
            float var32 = var30 + var18 + var20;
            RoundedRectRenderer.method01272(var2, var24, var25, var23, var4, field02475, 1.0F, ColorUtils.method04597(30, 30, 30, 200));
            ItemRenderUtils.method08418(var2, var8, var26 + var17 / 2.0F, var31, field02476, 1.0F, 1.0F);
            Fonts.field00109.method09480(var2, var12, var27, var30, -1, var18);
            Fonts.field00109.method09480(var2, var11, var28, var30, ColorUtils.method04604(170, 170, 170), var18);
            float var33 = var23 - var15 * 2.0F;
            float var34 = var7.г() <= 0 ? 0.0F : Math.max(0.0F, Math.min(1.0F, (float)var10 / var7.г()));
            RoundedRectRenderer.method01272(var2, var24 + var15, var32, var33, var19, field02477, 1.0F, ColorUtils.method04597(30, 30, 30, 200));
            RoundedRectRenderer.method01272(var2, var24 + var15, var32, var33 * var34, var19, field02478, 1.0F, -1);
         }

         FontRenderer.method09484();
         RoundedRectRenderer.method01278();
         ItemRenderUtils.method08420();
      }
   }

   private Vec3 method01156(List<fEEsjlIyg7aYDL47> var1, boolean var2) {
      HashSet var3 = new HashSet();

      for (fEEsjlIyg7aYDL47 var5 : var1) {
         int var6 = var5.x();
         int var7 = var5.y();
         int var8 = var2 ? var5.x() + var5.z() : var5.x() - var5.z();
         int var9 = var6;
         int var10 = var6;
         int var11 = var7;
         int var12 = var7;
         int var13 = var5.z();
         int var14 = var5.z();
         int var15 = var8;
         int var16 = var8;
         int var17 = 0;
         var3.clear();

         for (fEEsjlIyg7aYDL47 var19 : var1) {
            int var20 = var2 ? var19.x() + var19.z() : var19.x() - var19.z();
            if (Math.abs(var20 - var8) <= 1 && var19.x() >= var6 && var19.x() <= var6 + 4 && var19.y() >= var7 && var19.y() <= var7 + 4) {
               var17++;
               var3.add(var19.block());
               var9 = Math.min(var9, var19.x());
               var10 = Math.max(var10, var19.x());
               var11 = Math.min(var11, var19.y());
               var12 = Math.max(var12, var19.y());
               var13 = Math.min(var13, var19.z());
               var14 = Math.max(var14, var19.z());
               var15 = Math.min(var15, var20);
               var16 = Math.max(var16, var20);
            }
         }

         if (var17 >= 40 && var3.size() <= 3 && var10 - var9 >= 4 && var12 - var11 >= 4 && var16 - var15 <= 1) {
            return new Vec3((var9 + var10) / field02487 + field02488, (var11 + var12) / field02489 + field02490, (var13 + var14) / field02491 + field02492);
         }
      }

      return null;
   }

   @Subscribe
   private void method01157(PlayerUpdateEvent var1) {
      for (_5bBkC0fhj2Q8h9bz var3 : this.field02426) {
         var3.х必();
      }

      this.field02426.removeIf(var0 -> var0.бl >= var0.б6);
      this.method01176();
   }

   @Subscribe
   private void method01158(Render3DEvent var1) {
      if (!this.field02426.isEmpty()) {
         ;
      }
   }

   private void method01159(hZnjm1pQrEw3G4DU var1, Vec3 var2) {
      if (var1 == hZnjm1pQrEw3G4DU.BIG_TRAP) {
         this.field02426.removeIf(var2x -> var2x.Б() == hZnjm1pQrEw3G4DU.TRAP && this.method01181(var2x.西(), var2, field02512, field02513));
      } else if (var1 == hZnjm1pQrEw3G4DU.TRAP
         && this.field02426.stream().anyMatch(var2x -> var2x.Б() == hZnjm1pQrEw3G4DU.BIG_TRAP && this.method01181(var2x.西(), var2, field02510, field02511))) {
         return;
      }

      boolean var3 = var1 == hZnjm1pQrEw3G4DU.TRAP || var1 == hZnjm1pQrEw3G4DU.BIG_TRAP;
      boolean var4 = var1 == hZnjm1pQrEw3G4DU.PLAST || var1 == hZnjm1pQrEw3G4DU.PLAST_WALL;
      boolean var5 = var1 == hZnjm1pQrEw3G4DU.REALLYWORLD_TRAP;
      double var6 = var3 ? field02504 : (var4 ? field02505 : (var5 ? field02506 : 0.0));
      double var8 = var3 ? field02507 : (var5 ? field02508 : field02509);
      if (this.field02426.stream().noneMatch(var7 -> var7.Б() == var1 && this.method01181(var7.西(), var2, var6, var8))) {
         this.field02426.add(new _5bBkC0fhj2Q8h9bz(var1, var2));
      }
   }

   private void method01160(hZnjm1pQrEw3G4DU var1, Vec3 var2) {
      mc.execute(() -> {
         if (this.method03937()) {
            this.method01159(var1, var2);
         }
      });
   }

   private Vec3 method01161(List<fEEsjlIyg7aYDL47> var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      HashSet var9 = new HashSet();

      for (fEEsjlIyg7aYDL47 var11 : var1) {
         int var12 = var11.x();
         int var13 = var11.x();
         int var14 = var11.y();
         int var15 = var11.y();
         int var16 = var11.z();
         int var17 = var11.z();
         int var18 = 0;
         var9.clear();

         for (fEEsjlIyg7aYDL47 var20 : var1) {
            if (var20.x() >= var11.x()
               && var20.x() <= var11.x() + var2
               && var20.y() >= var11.y()
               && var20.y() <= var11.y() + var3
               && var20.z() >= var11.z()
               && var20.z() <= var11.z() + var4) {
               var18++;
               var9.add(var20.block());
               var12 = Math.min(var12, var20.x());
               var13 = Math.max(var13, var20.x());
               var14 = Math.min(var14, var20.y());
               var15 = Math.max(var15, var20.y());
               var16 = Math.min(var16, var20.z());
               var17 = Math.max(var17, var20.z());
            }
         }

         if (var18 >= var5 && var9.size() <= 3 && var13 - var12 >= var6 && var15 - var14 >= var7 && var17 - var16 >= var8) {
            return new Vec3((var12 + var13) / field02498 + field02499, (var14 + var15) / field02500 + field02501, (var16 + var17) / field02502 + field02503);
         }
      }

      return null;
   }

   @Subscribe
   private void method01162(PacketEvent var1) {
      if (var1.method10904()) {
         if (var1.method10897() instanceof ClientboundSoundPacket var2) {
            SoundEvent var7 = var2.getSound().value();
            float var4 = var2.getVolume();
            float var5 = var2.getPitch();
            Vec3 var6 = new Vec3(var2.getX(), Math.floor(var2.getY()) + 1.0, var2.getZ());
            if (this.field02425.method05600(field02481)
               && var7 == SoundEvents.EVOKER_FANGS_ATTACK
               && (var4 == field02482 || var4 == field02483)
               && var5 == 1.0F) {
               this.method01159(hZnjm1pQrEw3G4DU.STAN, var6);
            }

            var1.method05696();
         }
      }
   }

   private Map<UUID, LerpingBossEvent> method01163() {
      return mc.gui != null && mc.gui.hud != null ? ((BossHealthOverlayMixin)(Object)mc.gui.hud.getBossOverlay()).events() : null;
   }

   private Vec3 method01164(List<fEEsjlIyg7aYDL47> var1) {
      Vec3 var2 = this.method01156(var1, false);
      if (var2 == null) {
         var2 = this.method01156(var1, true);
      }

      return var2;
   }

   private Vec3 method01165(List<fEEsjlIyg7aYDL47> var1) {
      Vec3 var2 = this.method01161(var1, 4, 4, 1, 45, 4, 4, 1);
      if (var2 == null) {
         var2 = this.method01161(var1, 1, 4, 4, 45, 1, 4, 4);
      }

      return var2;
   }

   private void method01166() {
      this.field02458 = true;
      if (this.field02457.compareAndSet(false, true)) {
         Util.backgroundExecutor().execute(this::method01177);
      }
   }

   @Subscribe
   private void method01167(BlockUpdateEvent var1) {
      boolean var2 = this.field02425.method05600(field02465);
      if (var2 || this.field02425.method05600(field02466)) {
         synchronized (this.field02456) {
            if (var2) {
               this.method01175(var1.method06654(), var1.method06658().getBlock());
            } else {
               BlockState var4 = var1.method06658();
               long var5 = var1.method06654().asLong();
               Block var7 = this.field02455.get(var5);
               if (var7 != null) {
                  if (var7 != var4.getBlock()) {
                     this.field02455.remove(var5);
                  }

                  return;
               }

               if (var4.isAir() || var4.getBlock() instanceof LeavesBlock) {
                  return;
               }

               this.field02455.put(var5, var4.getBlock());
               this.method01175(var1.method06654(), var4.getBlock());
            }
         }

         this.method01166();
      }
   }

   private boolean method01168(Map<Long, Block> var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = 0;

      for (int var8 = var2; var8 <= var3; var8++) {
         for (int var9 = var5; var9 <= var6; var9++) {
            if (var1.containsKey(BlockPos.asLong(var8, var4, var9))) {
               var7++;
            }
         }
      }

      return var7 >= 15;
   }

   private boolean method01173() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.field02453 >= field02486) {
         this.field02453 = var1;
         this.field02454 = 0;
      }

      if (this.field02454 >= 400) {
         return false;
      }

      this.field02454++;
      return true;
   }

   private Vec3 method01174(List<fEEsjlIyg7aYDL47> var1, Map<Long, Block> var2) {
      HashSet var3 = new HashSet();

      for (fEEsjlIyg7aYDL47 var5 : var1) {
         int var6 = var5.x();
         int var7 = var5.y();
         int var8 = var5.z();
         int var9 = var6;
         int var10 = var6;
         int var11 = var8;
         int var12 = var8;
         int var13 = 0;
         var3.clear();

         for (fEEsjlIyg7aYDL47 var15 : var1) {
            if (var15.y() == var7 && var15.x() >= var6 && var15.x() <= var6 + 4 && var15.z() >= var8 && var15.z() <= var8 + 4) {
               var13++;
               var3.add(var15.block());
               var9 = Math.min(var9, var15.x());
               var10 = Math.max(var10, var15.x());
               var11 = Math.min(var11, var15.z());
               var12 = Math.max(var12, var15.z());
            }
         }

         if (var13 >= 23
            && var3.size() <= 3
            && var10 - var9 >= 4
            && var12 - var11 >= 4
            && (this.method01168(var2, var9, var10, var7 - 1, var11, var12) || this.method01168(var2, var9, var10, var7 + 1, var11, var12))) {
            return new Vec3((var9 + var10) / field02493 + field02494, var7 + field02495, (var11 + var12) / field02496 + field02497);
         }
      }

      return null;
   }

   private void method01175(BlockPos var1, Block var2) {
      long var3 = System.currentTimeMillis();
      this.field02452.add(new fEEsjlIyg7aYDL47(var1.getX(), var1.getY(), var1.getZ(), var3, var2));
      this.field02452.removeIf(var2x -> var3 - var2x.time() > field02514);

      while (this.field02452.size() > 512) {
         this.field02452.remove(0);
      }
   }

   private void method01176() {
      if (!this.field02426.isEmpty() || !this.field02428.isEmpty()) {
         var var1 = this.method01163();
         if (var1 != null) {
            LocalPlayer var2 = mc.player;
            var var3 = this.field02428.iterator();

            while (var3.hasNext()) {
               UUID var4 = (UUID)var3.next();
               if (var2 == null || this.method01180(var4, var2.position()) == null) {
                  var1.remove(var4);
                  var3.remove();
               }
            }

            if (var2 != null) {
               Vec3 var10 = var2.position();

               for (_5bBkC0fhj2Q8h9bz var6 : this.field02426) {
                  if (!(var10.distanceTo(var6.西()) > field02479)) {
                     UUID var7 = var6.с();
                     float var8 = Math.max(0.0F, Math.min(1.0F, (float)(var6.г() - var6.юю()) / var6.г()));
                     LerpingBossEvent var9 = (LerpingBossEvent)var1.get(var7);
                     if (var9 == null) {
                        var1.put(
                           var7, new LerpingBossEvent(var7, Component.literal(var6.Б().必()), var8, var6.Б().К(), BossBarOverlay.PROGRESS, false, false, false)
                        );
                        this.field02428.add(var7);
                     } else {
                        var9.setProgress(var8);
                     }
                  }
               }
            }
         }
      }
   }

   public WorldHelper() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field02425 = new ModeSetting(field02459).method05597(field02460, field02461, field02462).method03017(field02463).method03023(this);
      this.field02426 = new ArrayList<>();
      this.field02428 = new HashSet<>();
      this.field02452 = new ArrayList<>();
      this.field02453 = 0L;
      this.field02454 = 0;
      this.field02455 = new QLj4EFKQ3ej3X0Aa(this);
      this.field02456 = new Object();
      this.field02457 = new AtomicBoolean(false);
      this.field02458 = false;
      this.method03935(field02464);
   }

   private void method01177() {
      while (this.field02458) {
         this.field02458 = false;
         this.method01182();
      }

      this.field02457.set(false);
      if (this.field02458 && this.field02457.compareAndSet(false, true)) {
         Util.backgroundExecutor().execute(this::method01177);
      }
   }

   @Override
   public void method00245() {
      this.method01183();
      super.method00245();
   }

   private void method01179(List<fEEsjlIyg7aYDL47> var1, Map<Long, Block> var2) {
      Vec3 var3 = this.method01161(var1, 6, 6, 6, 100, 5, 5, 5);
      if (var3 != null) {
         this.method01160(hZnjm1pQrEw3G4DU.BIG_TRAP, var3);
      } else {
         Vec3 var4 = this.method01161(var1, 4, 4, 4, 60, 3, 3, 3);
         if (var4 != null) {
            this.method01160(hZnjm1pQrEw3G4DU.TRAP, var4);
         } else {
            Vec3 var5 = this.method01153(var1);
            if (var5 != null) {
               this.method01160(hZnjm1pQrEw3G4DU.PLAST, var5);
            } else {
               Vec3 var6 = this.method01165(var1);
               if (var6 != null) {
                  this.method01160(hZnjm1pQrEw3G4DU.PLAST_WALL, var6);
               } else {
                  Vec3 var7 = this.method01164(var1);
                  if (var7 != null) {
                     this.method01160(hZnjm1pQrEw3G4DU.PLAST_WALL, var7);
                  } else {
                     Vec3 var8 = this.method01174(var1, var2);
                     if (var8 != null) {
                        this.method01160(hZnjm1pQrEw3G4DU.PLAST, var8);
                     }
                  }
               }
            }
         }
      }
   }

   private _5bBkC0fhj2Q8h9bz method01180(UUID var1, Vec3 var2) {
      for (_5bBkC0fhj2Q8h9bz var4 : this.field02426) {
         if (var4.с().equals(var1) && var2.distanceTo(var4.西()) <= field02480) {
            return var4;
         }
      }

      return null;
   }

   private boolean method01181(Vec3 var1, Vec3 var2, double var3, double var5) {
      return Math.abs(Math.floor(var1.x) - Math.floor(var2.x)) <= var3
         && Math.abs(Math.floor(var1.z) - Math.floor(var2.z)) <= var3
         && Math.abs(var1.y - var2.y) <= var5;
   }

   private void method01182() {
      boolean var1 = this.field02425.method05600(field02484);
      boolean var2 = this.field02425.method05600(field02485);
      if (var1 || var2) {
         ArrayList var3;
         HashMap var4;
         synchronized (this.field02456) {
            if (this.field02452.isEmpty()) {
               return;
            }

            var3 = new ArrayList<>(this.field02452);
            var4 = var2 ? new HashMap<>(this.field02455) : null;
         }

         if (var1) {
            if (var3.size() >= 60) {
               if (this.method01173()) {
                  Vec3 var8 = this.method01161(var3, 6, 6, 6, 60, 3, 3, 3);
                  if (var8 != null) {
                     this.method01160(hZnjm1pQrEw3G4DU.REALLYWORLD_TRAP, var8);
                  }
               }
            }
         } else if (var3.size() >= 23) {
            if (this.method01173()) {
               this.method01179(var3, var4);
            }
         }
      }
   }

   private void method01183() {
      var var1 = this.method01163();
      if (var1 != null) {
         for (UUID var3 : this.field02428) {
            var1.remove(var3);
         }
      }

      this.field02428.clear();
   }

   record fEEsjlIyg7aYDL47(int x, int y, int z, long time, Block block) {
   }

   enum hZnjm1pQrEw3G4DU {
      TRAP("Трапка", net.minecraft.world.BossEvent.BossBarColor.RED, 300, net.minecraft.world.item.Items.NETHERITE_SCRAP),
      BIG_TRAP("Большая трапка", net.minecraft.world.BossEvent.BossBarColor.RED, 300, net.minecraft.world.item.Items.NETHERITE_SCRAP),
      PLAST("Пласт", net.minecraft.world.BossEvent.BossBarColor.YELLOW, 400, net.minecraft.world.item.Items.DRIED_KELP),
      PLAST_WALL("Пласт", net.minecraft.world.BossEvent.BossBarColor.YELLOW, 400, net.minecraft.world.item.Items.DRIED_KELP),
      REALLYWORLD_TRAP("Трапка", net.minecraft.world.BossEvent.BossBarColor.RED, 300, net.minecraft.world.item.Items.NETHERITE_SCRAP),
      STAN("Стан", net.minecraft.world.BossEvent.BossBarColor.PURPLE, 600, net.minecraft.world.item.Items.NETHER_STAR);

      private final String name;
      private final net.minecraft.world.BossEvent.BossBarColor color;
      final int duration;
      final net.minecraft.world.item.Item item;

      hZnjm1pQrEw3G4DU(String name, net.minecraft.world.BossEvent.BossBarColor color, int duration, net.minecraft.world.item.Item item) {
         this.name = name;
         this.color = color;
         this.duration = duration;
         this.item = item;
      }

      String 必() {
         return this.name;
      }

      net.minecraft.world.BossEvent.BossBarColor К() {
         return this.color;
      }
   }

   static final class _5bBkC0fhj2Q8h9bz {
      private final hZnjm1pQrEw3G4DU type;
      private final Vec3 pos;
      private final UUID id = UUID.randomUUID();
      private final ItemStack stack;
      int бl;
      final int б6;

      _5bBkC0fhj2Q8h9bz(hZnjm1pQrEw3G4DU type, Vec3 pos) {
         this.type = type;
         this.pos = pos;
         this.б6 = type.duration;
         this.stack = new ItemStack(type.item);
      }

      hZnjm1pQrEw3G4DU Б() {
         return this.type;
      }

      Vec3 西() {
         return this.pos;
      }

      ItemStack б() {
         return this.stack;
      }

      int г() {
         return this.б6;
      }

      int юю() {
         return this.бl;
      }

      UUID с() {
         return this.id;
      }

      void х必() {
         this.бl++;
      }
   }

   static final class QLj4EFKQ3ej3X0Aa extends java.util.LinkedHashMap<Long, Block> {
      QLj4EFKQ3ej3X0Aa(WorldHelper owner) {
         super(1024, 0.75F, true);
      }

      @Override
      protected boolean removeEldestEntry(Map.Entry<Long, Block> eldest) {
         return this.size() > 8192;
      }
   }
}
