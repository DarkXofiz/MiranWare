// Original binary: hex/api/baritone/utils/GuiClick
package hex.api.baritone.utils;

import sg.ec.InputCompat;

import com.mojang.blaze3d.vertex.PoseStack;
import hex.api.baritone.Baritone;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.Helper;
import java.awt.Color;
import java.util.Collections;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import sg.ec.BaritoneVertexConsumerAccess;

// $VF: Compiled from s
public class GuiClick extends Screen implements Helper {
   private Matrix4f projectionViewMatrix;
   private BlockPos clickStart;
   private BlockPos currentMouseOver;
   private static final String бУФ = "бУФ";
   private static final double бУ3 = 0;
   private static final double бУЬ = 0;

   @Override
   public void render(GuiGraphics var1, int var2, int var3, float var4) {
      double var5 = mc.mouseHandler.xpos();
      double sx = mc.mouseHandler.ypos();
      sx = mc.getWindow().getScreenHeight() - sx;
      sx *= (double)mc.getWindow().getHeight() / mc.getWindow().getScreenHeight();
      var5 *= (double)mc.getWindow().getWidth() / mc.getWindow().getScreenWidth();
      Vec3 sxx = this.toWorld(var5, sx, 0.0);
      Vec3 sxxx = this.toWorld(var5, sx, 1.0);
      if (sxx != null && sxxx != null) {
         Vec3 sxxxx = new Vec3(PathRenderer.posX(), PathRenderer.posY(), PathRenderer.posZ());
         LocalPlayer sxxxxx = BaritoneAPI.getProvider().getPrimaryBaritone().getPlayerContext().player();
         HitResult sxxxxxx = sxxxxx.level().clip(new ClipContext(sxx.add(sxxxx), sxxx.add(sxxxx), Block.OUTLINE, Fluid.NONE, sxxxxx));
         if (sxxxxxx != null && sxxxxxx.getType() == Type.BLOCK) {
            this.currentMouseOver = ((BlockHitResult)sxxxxxx).getBlockPos();
         }
      }
   }


   @Override
   public boolean mouseReleased(MouseButtonEvent var1) {
      if (this.currentMouseOver != null) {
         if (InputCompat.glfwButton(var1.button()) == 0) {
            if (this.clickStart != null && !this.clickStart.equals(this.currentMouseOver)) {
               BaritoneAPI.getProvider().getPrimaryBaritone().getSelectionManager().removeAllSelections();
               BaritoneAPI.getProvider()
                  .getPrimaryBaritone()
                  .getSelectionManager()
                  .addSelection(BetterBlockPos.from(this.clickStart), BetterBlockPos.from(this.currentMouseOver));
               MutableComponent var2 = Component.literal("Selection made! For usage: " + Baritone.settings().prefix.value + "help sel");
               var2.setStyle(
                  var2.getStyle().withColor(ChatFormatting.WHITE).withClickEvent(new RunCommand(IBaritoneChatControl.FORCE_COMMAND_PREFIX + "help sel"))
               );
               Helper.HELPER.logDirect(var2);
               this.clickStart = null;
            } else {
               BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(new GoalBlock(this.currentMouseOver));
            }
         } else if (InputCompat.glfwButton(var1.button()) == 1) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(new GoalBlock(this.currentMouseOver.above()));
         }
      }

      this.clickStart = null;
      return super.mouseReleased(var1);
   }

   public GuiClick() {
      super(Component.literal(бУФ));
   }

   @Override
   public void renderBackground(GuiGraphics var1, int var2, int var3, float var4) {
   }

   public void onRender(PoseStack var1, Matrix4f var2) {
      this.projectionViewMatrix = new Matrix4f(var2);
      this.projectionViewMatrix.mul(var1.last().pose());
      this.projectionViewMatrix.invert();
      if (this.currentMouseOver != null) {
         Entity var3 = mc.getCameraEntity();
         PathRenderer.drawManySelectionBoxes(var1, var3, Collections.singletonList(this.currentMouseOver), Color.CYAN);
         if (this.clickStart != null && !this.clickStart.equals(this.currentMouseOver)) {
            BaritoneVertexConsumerAccess sx = IRenderer.startLines(Color.RED);
            BetterBlockPos sxx = new BetterBlockPos(this.currentMouseOver);
            BetterBlockPos sxxx = new BetterBlockPos(this.clickStart);
            IRenderer.emitAABB(
               sx,
               var1,
               new AABB(
                  Math.min(sxx.x, sxxx.x),
                  Math.min(sxx.y, sxxx.y),
                  Math.min(sxx.z, sxxx.z),
                  Math.max(sxx.x, sxxx.x) + 1,
                  Math.max(sxx.y, sxxx.y) + 1,
                  Math.max(sxx.z, sxxx.z) + 1
               ),
               Baritone.settings().pathRenderLineWidthPixels.value
            );
            IRenderer.endLines(sx, true);
         }
      }
   }

   @Override
   public boolean mouseClicked(MouseButtonEvent var1, boolean var2) {
      this.clickStart = this.currentMouseOver;
      return super.mouseClicked(var1, var2);
   }

   @Override
   public boolean isPauseScreen() {
      return false;
   }

   private Vec3 toWorld(double var1, double var3, double var5) {
      if (this.projectionViewMatrix == null) {
         return null;
      }

      var1 /= mc.getWindow().getWidth();
      var3 /= mc.getWindow().getHeight();
      var1 = var1 * бУ3 - 1.0;
      var3 = var3 * бУЬ - 1.0;
      Vector4f var7 = new Vector4f((float)var1, (float)var3, (float)var5, 1.0F);
      this.projectionViewMatrix.transform(var7);
      if (var7.w() == 0.0F) {
         return null;
      }

      var7.mul(1.0F / var7.w());
      return new Vec3(var7.x(), var7.y(), var7.z());
   }
}
