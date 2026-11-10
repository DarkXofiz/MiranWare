// Original binary: sg/ec/zyT2uiGIzttqoVa1
package sg.ec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.protocol.Packet;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import org.joml.Vector2f;
import sg.mx.DeltaTracker$TimerMixin_1312;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public final class PlayerUtils implements MinecraftAccess {
   public static final Pattern field27987 = Pattern.compile(PlayerUtils.field28003);
   private static final float field27988 = 20.0F;
   private static final double field27989 = 180.0;
   private static final double field27990 = Math.PI;
   private static final float field27991 = 90.0F;
   private static final double field27992 = 180.0;
   private static final double field27993 = Math.PI;
   private static final double field27994 = -90.0;
   private static final double field27995 = 90.0;
   private static final float field27996 = 6.0F;
   private static final double field27997 = 2.0;
   private static final double field27998 = 2.0;
   private static final double field27999 = 2.0;
   private static final double field28000 = 2.0;
   private static final double field28001 = 2.0;
   private static final String field28002 = "This is a utility class and cannot be instantiated";
   private static final String field28003 = "^[A-zА-я0-9_]{3,16}$";

   public static float method11802() {
      return ((DeltaTracker$TimerMixin_1312)mc.getDeltaTracker()).tickDelta();
   }

   public static ItemStack method11803(Player var0) {
      return HeldItemRenderEvent.field00682.method00316(var0, var0.getMainHandItem());
   }

   public static boolean method11804(int var0, int var1, int var2, int var3, int var4, int var5, float var6, boolean var7) {
      double var8 = Math.pow(var0 - var3, field27997) + Math.pow(var2 - var5, field27998) + Math.pow(var1 - var4, field27999);
      return var8 < Math.pow(var6, field28000) && (!var7 || var8 >= Math.pow(var6 - 1.0F, field28001));
   }

   public static float method11805(LivingEntity var0) {
      return ModuleManager.INSTANCE.method08175().method03937() && var0 instanceof Player ? method11807(var0)[1] : var0.getMaxHealth();
   }

   public static void method11806(Minecraft var0) {
      if (var0 != null && var0.player != null && var0.gameMode != null && mc.player != null) {
         var0.gameMode
            .handleContainerInput(var0.player.containerMenu.containerId, 36 + mc.player.getInventory().getSelectedSlot(), 1, ClickType.THROW, var0.player);
      }
   }

   public static float[] method11807(LivingEntity var0) {
      float[] var1 = new float[]{var0.getHealth(), var0.getMaxHealth()};
      if (mc.level == null) {
         return var1;
      }

      Scoreboard var2 = mc.level.getScoreboard();
      Objective var3 = var2.getDisplayObjective(DisplaySlot.BELOW_NAME);
      if (var3 == null) {
         return var1;
      }

      String var4 = var0.getScoreboardName();

      for (PlayerScoreEntry var6 : var2.listPlayerScores(var3)) {
         if (var6.owner().equals(var4)) {
            var1[0] = var6.value();
            var1[1] = field27988;
            break;
         }
      }

      return var1;
   }

   public static List<BlockPos> method11808(BlockPos var0, float var1, float var2, boolean var3, boolean var4, int var5, boolean var6) {
      ArrayList var7 = new ArrayList();
      int var8 = var0.getX();
      int var9 = var0.getY();
      int var10 = var0.getZ();

      for (int var11 = var8 - (int)var1; var11 <= var8 + var1; var11++) {
         for (int var12 = var10 - (int)var1; var12 <= var10 + var1; var12++) {
            int var13 = var4 ? var9 - (int)var1 : var9;
            int var14 = var4 ? var9 + (int)var1 : var9 + (int)var2;

            for (int var15 = var13; var15 < var14; var15++) {
               if (method11804(var8, var9, var10, var11, var15, var12, var1, var3) || var6) {
                  var7.add(new BlockPos(var11, var15 + var5, var12));
               }
            }
         }
      }

      return var7;
   }

   private PlayerUtils() {
      throw new UnsupportedOperationException(field28002);
   }

   public static double method11809(Entity var0, BlockPos var1) {
      return GuiHitTestUtils.method05620(var0.getX(), var0.getY(), var0.getZ(), var1.getX(), var1.getY(), var1.getZ());
   }

   public static double method11810(double var0, double var2, double var4) {
      return Math.clamp(var4, var0, var2);
   }

   public static Component method11811(PlayerTeam var0) {
      return method11819(var0, true, true, true);
   }

   public static boolean method11812(Packet<?> var0) {
      if (mc.getConnection() != null && mc.getConnection().getConnection() instanceof BotConnectionAccess var3) {
         var3.sendPacket(var0);
         return true;
      } else {
         Connection var1 = BotConnectionAccess.method05259();
         if (var1 instanceof BotConnectionAccess var4 && var1.isConnected()) {
            var4.sendPacket(var0);
            return true;
         } else {
            return false;
         }
      }
   }

   public static Component method11813(LivingEntity var0) {
      return method11827(var0, true, true, true);
   }

   private static Component method11814(Component var0, Component var1, Component var2) {
      MutableComponent var3 = Component.empty();
      if (var0 != null) {
         String var4 = var0.getString();
         if (var4.length() < 64) {
            var3.append(var0);
         }
      }

      if (var1 != null) {
         var3.append(var1);
      }

      if (var2 != null) {
         String var6 = var2.getString();
         if (var6.length() < 64) {
            String var5 = var2.getString().replace('&', '§');
            if (!ChatFormatting.stripFormatting(var5).isBlank()) {
               var3.append(var2);
            }
         }
      }

      return var3;
   }

   public static boolean method11815(Entity var0) {
      if (var0 == null) {
         return false;
      }

      if (var0.getBoundingBox() == null) {
         return false;
      }

      if (mc.getEntityRenderDispatcher() == null) {
         return false;
      }

      Frustum var1 = ((LevelRendererAccess)mc.levelRenderer).frustum();
      return var1 == null || var1.isVisible(var0.getBoundingBox());
   }

   public static Vector2f method11816(Vec3 var0, Vec3 var1) {
      Vec3 var2 = var1.subtract(var0);
      double var3 = Math.hypot(var2.x(), var2.z());
      float var5 = (float)(Mth.atan2(var2.z(), var2.x()) * field27989 / field27990) - field27991;
      float var6 = (float)(-(Mth.atan2(var2.y(), var3) * field27992 / field27993));
      var5 = method11824(var5);
      var6 = (float)method11810(field27994, field27995, var6);
      return new Vector2f(var5, var6);
   }

   public static boolean method11817(AABB var0) {
      if (var0 == null) {
         return false;
      }

      if (mc.getEntityRenderDispatcher() == null) {
         return false;
      }

      Frustum var1 = ((LevelRendererAccess)mc.levelRenderer).frustum();
      return var1 == null || var1.isVisible(var0);
   }

   public static boolean method11818() {
      return mc.player == null ? false : ((LivingEntityMixin_1248)(Object)mc.player).glidingtick() > 2;
   }

   public static Component method11819(PlayerTeam var0, boolean var1, boolean var2, boolean var3) {
      boolean var4 = var0 != null;
      Component var5 = var1 && var4 ? var0.getPlayerPrefix() : null;
      Component var6 = var3 && var4 ? var0.getPlayerSuffix() : null;
      MutableComponent var7 = null;
      if (var2) {
         MutableComponent var8 = var4 ? var0.getFormattedDisplayName() : null;
         TextColor var9 = var8 != null ? var8.getStyle().getColor() : null;
         MutableComponent var10 = Component.literal(StreamerNameUtils.method03481(method11829(var0)));
         if (var9 != null) {
            var10.setStyle(Style.EMPTY.withColor(var9));
         }

         var7 = var10;
      }

      return method11814(var5, var7, var6);
   }

   public static float method11820(LivingEntity var0) {
      return ModuleManager.INSTANCE.method08175().method03937() && var0 instanceof Player ? method11807(var0)[0] : var0.getHealth();
   }

   public static boolean method11821(String var0) {
      return var0 == null ? true : !field27987.matcher(var0).matches();
   }

   public static float method11824(float var0) {
      return Mth.wrapDegrees(var0);
   }

   public static BlockPos method11825() {
      return mc.player == null ? BlockPos.ZERO : BlockPos.containing(Math.floor(mc.player.getX()), Math.floor(mc.player.getY()), Math.floor(mc.player.getZ()));
   }

   public static ItemStack method11826(LivingEntity var0) {
      if (var0 instanceof Player var1) {
         return method11803(var1);
      } else {
         return var0 == null ? ItemStack.EMPTY : var0.getMainHandItem();
      }
   }

   public static Component method11827(LivingEntity var0, boolean var1, boolean var2, boolean var3) {
      PlayerTeam var4 = var0.getTeam();
      boolean var5 = var4 != null;
      Component var6 = var1 && var5 ? var4.getPlayerPrefix() : null;
      Component var7 = var3 && var5 ? var4.getPlayerSuffix() : null;
      MutableComponent var8 = null;
      if (var2) {
         TextColor var9 = var0.getDisplayName().getStyle().getColor();
         MutableComponent var10 = Component.literal(StreamerNameUtils.method03481(var0.getName().getString()));
         if (var9 != null) {
            var10.setStyle(Style.EMPTY.withColor(var9));
         }

         var8 = var10;
      }

      return method11814(var6, var8, var7);
   }

   public static void method11828(Minecraft var0) {
      if (var0 != null && var0.player != null && var0.gameMode != null) {
         for (int var1 = 0; var1 < var0.player.containerMenu.slots.size(); var1++) {
            if (!var0.player.containerMenu.slots.get(var1).getItem().isEmpty()) {
               var0.gameMode.handleInventoryMouseClick(mc.player.containerMenu.containerId, var1, 1, ClickType.THROW, var0.player);
            }
         }
      }
   }

   public static String method11829(PlayerTeam var0) {
      if (var0 == null) {
         return "";
      } else {
         var var1 = var0.getPlayers();
         if (var1 != null && !var1.isEmpty()) {
            String var2 = (String)var1.iterator().next();
            return var2 == null ? "" : var2;
         } else {
            return "";
         }
      }
   }

   public static BlockPos method11830(float var0, Block var1) {
      return method11808(method11825(), var0, field27996, false, true, 0, false)
         .stream()
         .filter(var1x -> mc.level.getBlockState(var1x).getBlock() == var1)
         .min(Comparator.comparing(var0x -> method11809(mc.player, var0x)))
         .orElse(null);
   }

   public static boolean method11831(int var0) {
      return mc.player == null ? false : ((LivingEntityMixin_1248)(Object)mc.player).glidingtick() > var0;
   }

   public static int method11832(Player var0) {
      if (mc.getConnection() != null && var0 != null) {
         PlayerInfo var1 = mc.getConnection().getPlayerInfo(var0.getUUID());
         return var1 == null ? -1 : var1.getLatency();
      } else {
         return -1;
      }
   }
}
