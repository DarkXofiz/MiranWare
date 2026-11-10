// Original binary: sg/ec/gtt0ou1LqwQGMXeu
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.joml.Vector4f;

// $VF: Compiled from s
public final class NotificationManager implements MinecraftAccess {
   private static final SortableArrayList<Notification> field19667 = new SortableArrayList<>();
   private static float[] field19668 = new float[16];
   private static final float field19669 = 6.0F;
   private static final long field19670 = 0;
   private static final String field19671 = "field19671";
   private static Notification field19672;
   private static final ElapsedTimer field19673 = new ElapsedTimer();
   private static int field19674 = 0;
   private static final NotificationType[] field19675 = NotificationType.values();
   private static final long field19676 = Long.MAX_VALUE;
   private static final float field19677 = 6.0F;
   private static final float field19678 = 13.0F;
   private static final float field19679 = 6.0F;
   private static final float field19680 = 15.5F;
   private static final float field19681 = 10.0F;
   private static final float field19682 = Float.MAX_VALUE;
   private static final float field19683 = Float.MAX_VALUE;
   private static final float field19684 = -Float.MAX_VALUE;
   private static final float field19685 = -Float.MAX_VALUE;
   private static final float field19686 = 20.0F;
   private static final float field19687 = 5.0F;
   private static final float field19688 = 1.5F;
   private static final float field19689 = 0.55F;
   private static final float field19690 = 8.0F;
   private static final float field19691 = 3.0F;
   private static final float field19692 = 3.0F;
   private static final float field19693 = 3.0F;
   private static final float field19694 = 0.5F;
   private static final float field19695 = 7.0F;
   private static final float field19696 = 0.5F;
   private static final float field19697 = 6.0F;
   private static final float field19698 = 0.25F;
   private static final float field19699 = 0.01F;
   private static final float field19700 = Float.MAX_VALUE;
   private static final String field19701 = "Это пример уведомления, нажмите пкм для настройки.";
   private static final long field19702 = 250L;
   private static final long field19703 = 1000L;
   private static final long field19704 = 250L;
   private static final String field19705 = "This is a utility class and cannot be instantiated";
   private static final float field19706 = 0.01F;

   public static void method08594() {
      long var0 = System.currentTimeMillis();
      method08599(var0);
      method08607();
      field19667.method00232(Notification::method08807);
      field19667.removeIf(var2 -> var2.method08810(var0) && var2.method08801().method03377() < field19706);
      if (field19672 != null && !field19667.contains(field19672)) {
         field19672 = null;
      }
   }

   public static void method08595(Notification var0) {
      if (var0 != null) {
         var0.method08805(true);
      }
   }

   public static Notification method08596(Component var0, NotificationType var1) {
      return method08605(var0, field19676, var1);
   }

   public static void method08597(String var0, long var1, NotificationType var3) {
      method08615(var0, var1, var3, ModuleSoundAction.NONE);
   }

   public static void method08598(Component var0, long var1, ItemStack var3) {
      if (!method08614(ModuleManager.INSTANCE.method08274())) {
         method08603(new Notification(FontRenderer.method09483(var0), var1, var3));
      }
   }

   private static void method08599(long var0) {
      boolean var2 = mc.gui.screen() instanceof ChatScreen;
      boolean var3 = method08602();
      if (var2 && !var3) {
         if (field19672 != null && field19667.contains(field19672)) {
            if (field19673.method04699(field19703)) {
               field19674 = (field19674 + 1) % field19675.length;
               field19673.method04694();
            }

            field19672.method08808(field19675[field19674]);
            field19672.method08806(field19704);
            field19672.method08802(var0);
         } else {
            field19672 = method08603(new Notification(field19701, field19702, NotificationType.INFO));
         }
      }
   }

   public static void method08600(Notification var0, String var1) {
      method08617(var0, Component.literal(var1));
   }

   private static String method08601(String var0, ModuleSoundAction var1) {
      String var2 = var1.method03704();
      if (var1.equals(ModuleSoundAction.ENABLE) || var1.equals(ModuleSoundAction.DISABLE)) {
         var2 = var1.method03704() + var0;
      }

      return var2;
   }

   private static boolean method08602() {
      for (Notification var1 : field19667) {
         if (var1 != field19672) {
            return true;
         }
      }

      return false;
   }

   private NotificationManager() {
      throw new UnsupportedOperationException(field19705);
   }

   private static Notification method08603(Notification var0) {
      method08609(var0);
      method08613(var0);
      return var0;
   }

   private static Notification method08605(Component var0, long var1, NotificationType var3) {
      return method08614(ModuleManager.INSTANCE.method08274())
         ? null
         : method08603(new Notification(FontRenderer.method09483(var0), var1, var3));
   }

   private static void method08607() {
      for (int var0 = 0; var0 < field19667.size(); var0++) {
         Notification var1 = field19667.get(var0);
         if (var1.method08804() == 0.0F && !var1.method08800().isEmpty()) {
            method08609(var1);
         }
      }
   }

   public static Notification method08608(String var0, NotificationType var1) {
      return method08596(Component.literal(var0), var1);
   }

   private static void method08609(Notification var0) {
      FontRenderer var1 = HudElement.field14601;
      if (var1 != null) {
         var0.method08795(var1.method09478(var0.method08800(), field19677, -HudElement.field14608));
      }
   }

   public static void method08610(Component var0, long var1, NotificationType var3, ModuleSoundAction var4) {
      Hud var5 = ModuleManager.INSTANCE.method08274();
      if (!method08614(var5)) {
         method08603(new Notification(FontRenderer.method09483(var0), var1, var3));
         if (var5.field10878.method05999() && !var4.equals(ModuleSoundAction.NONE)) {
            ClientSoundManager.INSTANCE.method03827(method08601(var5.method04952(), var4), 1.0F);
         }
      }
   }

   public static Notification method08612(Component var0, NotificationType var1, long var2) {
      return method08605(var0, var2, var1);
   }

   private static void method08613(Notification var0) {
      if (!mc.isSameThread()) {
         mc.execute(() -> field19667.add(var0));
      } else {
         field19667.add(var0);
      }
   }

   private static boolean method08614(Hud var0) {
      return var0 == null || !var0.method03937();
   }

   public static void method08615(String var0, long var1, NotificationType var3, ModuleSoundAction var4) {
      method08610(Component.literal(var0), var1, var3, var4);
   }

   public static Vector4f method08616(GuiGraphics var0, HudElement var1, float var2) {
      if (field19667.isEmpty()) {
         return new Vector4f(0.0F, 0.0F, 0.0F, 0.0F);
      }

      FontRenderer var3 = HudElement.field14601;
      long var4 = System.currentTimeMillis();
      float var6 = field19678;
      float var7 = var1.method06450();
      float var8 = var1.method06454() / 2.0F;
      float var9 = var2;
      float var10 = field19679;
      float var11 = -HudElement.field14608;
      float var12 = field19680;
      float var13 = field19681;
      float var14 = field19682;
      float var15 = field19683;
      float var16 = field19684;
      float var17 = field19685;
      float var18 = var1.method06455();
      int var19 = field19667.size();
      if (field19668.length < var19) {
         field19668 = new float[var19];
      }

      for (int var20 = var19 - 1; var20 >= 0; var20--) {
         Notification var21 = field19667.get(var20);
         AnimationUtils var22 = var21.method08801();
         var22.method03375(var21.method08798(var4) ? 1.0 : 0.0);
         field19668[var20] = var22.method03377();
      }

      float var42 = var7 + field19686;
      int var43 = 0;
      float var44 = 0.0F;

      for (int var23 = var19 - 1; var23 >= 0 && !(var2 + var44 + var6 > var42); var23--) {
         var43++;
         var44 += field19668[var23] * var6;
      }

      int var45 = 0;

      for (int var24 = var19 - 1; var24 >= 0 && var45 < var43; var45++) {
         Notification var25 = field19667.get(var24);
         ItemStack var26 = var25.method08797();
         String var27 = var25.method08800();
         float var28 = var25.method08804() + var12;
         float var29 = var28 + var13;
         float var30 = field19668[var24];
         int var31 = ColorUtils.method04611(var1.method06438(), var30);
         float var32 = var9 + var45 * var6;
         float var33 = var8 - var28 / 2.0F;
         float var34 = var33 - var13 / 2.0F;
         float var35 = var34 + field19687;
         float var36 = var32 + var6 / 2.0F - var10 / 2.0F - field19688;
         if (var26 != null) {
            ItemRenderUtils.method08415(var0, var26, var35, var36, 1.0F, var30, field19689);
         }

         NotificationType var37 = var25.method08811();
         float var38 = var32 + var6 / 2.0F - var10 / 2.0F;
         if (var37 != null) {
            int var39 = var37.method05136();
            int var40 = var39 == -1 ? var31 : ColorUtils.method04611(var39, var30);
            String var41 = var37.method05135();
            Fonts.field00107.method09480(var0, var41, var35, var38, var40, field19690);
         }

         var3.method09490(var0, var27, var33 + var12, var38, var31, var10, var11);
         int var48 = ColorUtils.method04611(var1.method06460(), var18 * var30);
         var1.method06439(var0, var34, var32, var29, var6, field19691, var1.method06466(), var30);
         RoundedRectRenderer.method01272(var0, var34, var32, var29, var6, field19692, var1.method06466(), var48);
         if (!var1.method06447()) {
            GuiShadowRenderer.method10984(var0, var34, var32, var29, var6, field19693, field19694, field19695, var48);
         }

         RoundedRectRenderer.method01272(
            var0, var34 + var12 + 1.0F, var36 + 1.0F, field19696, var6 - field19697, 0.0F, 0.0F, ColorUtils.method04611(var31, field19698)
         );
         if (var30 > field19699) {
            var14 = Math.min(var14, var34);
            var15 = Math.min(var15, var32);
            var16 = Math.max(var16, var34 + var29);
            var17 = Math.max(var17, var32 + var6);
         }

         var9 += var30 * var6 - var6;
         var24--;
      }

      if (var14 == field19700) {
         return new Vector4f(var8, var2, 0.0F, 0.0F);
      }

      float var46 = var16 - var14;
      float var47 = var17 - var15;
      return new Vector4f(var14, var15, var46, var47);
   }

   public static void method08617(Notification var0, Component var1) {
      if (var0 != null) {
         if (!mc.isSameThread()) {
            mc.execute(() -> method08617(var0, var1));
         } else {
            var0.method08803(FontRenderer.method09483(var1));
            method08609(var0);
         }
      }
   }

   public static Notification method08618(String var0, NotificationType var1, long var2) {
      return method08612(Component.literal(var0), var1, var2);
   }

   public static void method08619(Component var0, long var1, NotificationType var3) {
      method08610(var0, var1, var3, ModuleSoundAction.NONE);
   }
}
