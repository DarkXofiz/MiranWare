// Original binary: sg/ec/Yl3DqcEHXUtwpxrY
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.CameraType;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

// $VF: Compiled from s
public class Trails extends ClientModule {
   private static final String field14956 = "Игроков";
   private static final String field14957 = "field14957";
   private static final String field14958 = "field14958";
   private static final String field14959 = "field14959";
   private static final float field14960 = 0;
   private static final long field14961 = 0;
   private final MultiToggleSetting field14962;
   private final NumberSetting<Float> field14963;
   private final int[] field14964;
   private int field14965;
   private int field14966;
   private boolean field14967;
   private static final String field14968 = "Отображать";
   private static final String field14969 = "Игроков";
   private static final String field14970 = "Друзей";
   private static final String field14971 = "Себя";
   private static final String field14972 = "Невидимых";
   private static final String field14973 = "Длина";
   private static final float field14974 = 4.0F;
   private static final float field14975 = 0.5F;
   private static final float field14976 = 2.5F;
   private static final String field14977 = "Trails";
   private static final String field14978 = "Рисует шлейф по последним позициям существ";
   private static final float field14979 = 100.0F;
   private static final long field14980 = 4L;
   private static final double field14981 = 0.05;
   private static final double field14982 = 0.15;
   private static final long field14983 = 16L;
   private static final long field14984 = 360L;
   private static final float field14985 = 4.0F;
   private static final float field14986 = 4.0F;
   private static final float field14987 = 4.0F;
   private static final float field14988 = 4.0F;
   private static final float field14989 = 255.0F;
   private static final float field14990 = 255.0F;
   private static final float field14991 = 180.0F;
   private static final float field14992 = 0.15F;
   private static final float field14993 = 0.15F;
   private static final int field14994 = 16777215;
   private static final String field14995 = "Себя";
   private static final String field14996 = "Друзей";
   private static final String field14997 = "Игроков";
   private static final String field14998 = "Невидимых";

   @Subscribe
   public void method06661(Render3DEvent var1) {
      if (mc.level != null && mc.player != null) {
         float var2 = var1.method00984().getGameTimeDeltaPartialTick(true);
         long sx = System.currentTimeMillis();
         float sxx = this.field14963.method03022() * field14979;
         boolean sxxx = ModuleManager.INSTANCE.method08258().method03937();
         boolean sxxxx = mc.options.getCameraType() == CameraType.FIRST_PERSON && !sxxx;
         Frustum sxxxxx = var1.method00986();
         if (var1.method00985().method07407(EffectRenderPipelines.field11857) instanceof BaritoneVertexConsumerAccess sxxxxxx) {
            if (var1.method00985().method07407(EffectRenderPipelines.method05519()) instanceof BaritoneVertexConsumerAccess sxxxxxxx) {
               PoseStack var13 = var1.method00996();
               Vec3 var14 = var1.method00994().position();
               var13.pushPose();
               Matrix4f var15 = var13.last().pose();
               long var16 = sx / field14980;
               this.method06666();
               float var18 = var15.m00();
               float var19 = var15.m01();
               float var20 = var15.m02();
               float var21 = var15.m10();
               float var22 = var15.m11();
               float var23 = var15.m12();
               float var24 = var15.m20();
               float var25 = var15.m21();
               float var26 = var15.m22();
               float var27 = var15.m30();
               float var28 = var15.m31();
               float var29 = var15.m32();

               for (Entity sxxxxxxxx : mc.level.entitiesForRendering()) {
                  if (this.method06665(sxxxxxxxx, sxxxxx) && sxxxxxxxx instanceof LivingEntity sxxxxxxxxx) {
                     Vec3 sxxxxxxxxxx = sxxxxxxxxx.getPosition(var2);
                     double sxxxxxxxxxxx = sxxxxxxxxxx.y + field14981 - (sxxxxxxxxx.isFallFlying() ? field14982 : 0.0);
                     boolean sxxxxxxxxxxxx = sxxxxxxxxx instanceof LocalPlayer && sxxxx;
                     var sxxxxxxxxxxxxx = ((EntityExtensionAccess)sxxxxxxxxx).getTrailPoints();
                     if (!sxxxxxxxxxxxx) {
                        int sxxxxxxxxxxxxxx = sxxxxxxxxxxxxx.size() - 1;
                        if (sxxxxxxxxxxxxxx >= 0 && sx - sxxxxxxxxxxxxx.get(sxxxxxxxxxxxxxx).field02252 < field14983) {
                           sxxxxxxxxxxxxx.get(sxxxxxxxxxxxxxx).method00997(sxxxxxxxxxx.x, sxxxxxxxxxxx, sxxxxxxxxxx.z);
                        } else {
                           sxxxxxxxxxxxxx.add(new TrailPoint(sxxxxxxxxxx.x, sxxxxxxxxxxx, sxxxxxxxxxx.z, sx));
                        }
                     }

                     int sxxxxxxxxxxxxxx = 0;

                     while (sxxxxxxxxxxxxxx < sxxxxxxxxxxxxx.size() && (float)(sx - sxxxxxxxxxxxxx.get(sxxxxxxxxxxxxxx).field02252) > sxx) {
                        sxxxxxxxxxxxxxx++;
                     }

                     if (sxxxxxxxxxxxxxx > 0) {
                        sxxxxxxxxxxxxx.subList(0, sxxxxxxxxxxxxxx).clear();
                     }

                     if (!sxxxxxxxxxxxxx.isEmpty()) {
                        float sxxxxxxxxxxxxxxx = sxxxxxxxxx.getBbHeight();
                        float sxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxx * var21;
                        float sxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxx * var22;
                        float sxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxx * var23;
                        float sxxxxxxxxxxxxxxxxxxx = 0.0F;
                        float sxxxxxxxxxxxxxxxxxxxx = 0.0F;
                        float sxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                        float sxxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                        float sxxxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                        float sxxxxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                        float sxxxxxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                        float sxxxxxxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                        float sxxxxxxxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                        int sxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 0;
                        boolean sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = false;

                        for (int sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 0;
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx < sxxxxxxxxxxxxx.size();
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx++
                        ) {
                           TrailPoint sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxx.get(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                           long sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sx - sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.field02252;
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.field02251 = method06663(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, sxx);
                           int sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = method06662(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.field02251) << 24
                              | this.field14964[(int)((var16 - (int)sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.field02251) % field14984)];
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (float)(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.field02248 - var14.x);
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (float)(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.field02249 - var14.y);
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (float)(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.field02250 - var14.z);
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = var18 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var21 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var24 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var27;
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = var19 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var22 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var25 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var28;
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = var20 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var23 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var26 * sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              + var29;
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx + sxxxxxxxxxxxxxxxx;
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx + sxxxxxxxxxxxxxxxxx;
                           float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx + sxxxxxxxxxxxxxxxxxx;
                           if (sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              sxxxxxx.coloredVertexPre(
                                 sxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              );
                              sxxxxxx.coloredVertexPre(
                                 sxxxxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              );
                              sxxxxxx.coloredVertexPre(
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              );
                              sxxxxxx.coloredVertexPre(
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              );
                              float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx - sxxxxxxxxxxxxxxxxxxx;
                              float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx - sxxxxxxxxxxxxxxxxxxxx;
                              float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx - sxxxxxxxxxxxxxxxxxxxxx;
                              float sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = EntityESP.method09228(
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              );
                              if (sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != 0.0F) {
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx /= sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx /= sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx /= sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                              } else {
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 1.0F;
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 0.0F;
                              }

                              sxxxxxxx.lineVertexPre(
                                 sxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 field14985
                              );
                              sxxxxxxx.lineVertexPre(
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 field14986
                              );
                              sxxxxxxx.lineVertexPre(
                                 sxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 field14987
                              );
                              sxxxxxxx.lineVertexPre(
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 field14988
                              );
                           }

                           sxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = true;
                        }
                     }
                  }
               }

               var13.popPose();
            }
         }
      }
   }

   public Trails() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field14962 = new MultiToggleSetting(field14968)
         .method04517(NamedOption.method08077(field14969, false))
         .method04517(NamedOption.method08077(field14970, true))
         .method04517(NamedOption.method08077(field14971, true))
         .method04517(NamedOption.method08077(field14972, false))
         .method03023(this);
      this.field14963 = new NumberSetting<Float>(field14973)
         .method10835(2.0F)
         .method10838(field14974)
         .method10834(field14975)
         .method03017(field14976)
         .method03023(this);
      this.field14964 = new int[360];
      this.method03935(field14977);
      this.method03931(field14978);
   }

   private static int method06662(float var0) {
      return Math.max(0, Math.min(255, (int)(field14990 - var0)));
   }

   private static float method06663(long var0, float var2) {
      return Math.max(0.0F, Math.min(1.0F, (float)var0 / var2)) * field14989;
   }

   @Subscribe
   public void method06664(WorldLoadEvent var1) {
      this.method06667();
   }

   private boolean method06665(Entity var1, Frustum var2) {
      if (var1 instanceof Player var3) {
         if (ModuleManager.INSTANCE.method08260().method00605(var1)) {
            return false;
         }

         if (var3 instanceof LocalPlayer) {
            if (!this.field14962.method04520(field14995)) {
               return false;
            }
         } else if (FriendManager.INSTANCE.method00172(var3)) {
            if (!this.field14962.method04520(field14996)) {
               return false;
            }
         } else if (!this.field14962.method04520(field14997)) {
            return false;
         }

         if (var1.isInvisible() && !this.field14962.method04520(field14998)) {
            return false;
         } else {
            return !var1.isAlive() ? false : var2.isVisible(var1.getBoundingBox());
         }
      } else {
         return false;
      }
   }

   private void method06666() {
      int var1 = ColorUtils.Nested138.method04636();
      int var2 = ColorUtils.Nested138.method04637();
      if (!this.field14967 || var1 != this.field14965 || var2 != this.field14966) {
         for (int var3 = 0; var3 < this.field14964.length; var3++) {
            int var4 = var3 >= 180 ? 360 - var3 : var3;
            int var5 = ColorUtils.method04599(ColorUtils.method04583(var1, var2, var4 / field14991), field14992);
            this.field14964[var3] = ColorUtils.method04599(var5, field14993) & field14994;
         }

         this.field14965 = var1;
         this.field14966 = var2;
         this.field14967 = true;
      }
   }

   @Override
   public void method00245() {
      super.method00245();
      this.method06667();
   }

   private void method06667() {
      if (mc.level != null) {
         for (Entity var2 : mc.level.entitiesForRendering()) {
            if (var2 instanceof LivingEntity) {
               ((EntityExtensionAccess)var2).getTrailPoints().clear();
            }
         }
      }
   }
}
