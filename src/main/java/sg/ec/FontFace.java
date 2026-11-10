// Original binary: sg/ec/aorSKQTyy5kb0HAv
package sg.ec;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.AddressMode;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuSampler;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.Identifier;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class FontFace {
   private final String field16569;
   private final AbstractTexture field16570;
   private final FontAtlasMetadata.Nested25 field16571;
   private final FontAtlasMetadata.Nested26 field16572;
   public final Map<Integer, FontGlyph> field16573;
   private final Map<Long, Float> field16574;
   private final FontGlyph[] field16575;
   private static final int field16576 = 2048;
   private final Map<FontFace.Nested207, Float> field16577;
   private final FontFace.Nested207 field16578;
   private static GpuSampler field16579;
   private static final int[] field16580 = new int[]{
      0,
      170,
      FontFace.field16735,
      FontFace.field16736,
      FontFace.field16737,
      FontFace.field16738,
      FontFace.field16739,
      FontFace.field16740,
      FontFace.field16741,
      FontFace.field16742,
      FontFace.field16743,
      FontFace.field16744,
      FontFace.field16745,
      FontFace.field16746,
      FontFace.field16747,
      FontFace.field16748
   };
   private static final char field16581 = ' ';
   private static final Map<String, String> field16582 = new HashMap<>();
   private static final String[] field16583 = new String[FontFace.field16749];
   private static boolean field16584 = false;
   private static volatile boolean field16585 = false;
   private static final float field16586 = 0.75F;
   private static final String field16587 = "ꔀ";
   private static final String field16588 = "PLAYER";
   private static final String field16589 = "ꔄ";
   private static final String field16590 = "HERO";
   private static final String field16591 = "ꔈ";
   private static final String field16592 = "TITAN";
   private static final String field16593 = "ꔒ";
   private static final String field16594 = "AVENGER";
   private static final String field16595 = "ꔖ";
   private static final String field16596 = "OVERLORD";
   private static final String field16597 = "ꔠ";
   private static final String field16598 = "MAGISTER";
   private static final String field16599 = "ꔤ";
   private static final String field16600 = "IMPERATOR";
   private static final String field16601 = "ꔨ";
   private static final String field16602 = "DRAGON";
   private static final String field16603 = "ꕠ";
   private static final String field16604 = "D.HELPER";
   private static final String field16605 = "ꕀ";
   private static final String field16606 = "HYDRA";
   private static final String field16607 = "ꕖ";
   private static final String field16608 = "BUNNY";
   private static final String field16609 = "ꕈ";
   private static final String field16610 = "COBRA";
   private static final String field16611 = "ꕄ";
   private static final String field16612 = "DRACULA";
   private static final String field16613 = "ꔶ";
   private static final String field16614 = "TIGER";
   private static final String field16615 = "ꕒ";
   private static final String field16616 = "RABBIT";
   private static final String field16617 = "ꔲ";
   private static final String field16618 = "BULL";
   private static final String field16619 = "ꕁ";
   private static final String field16620 = "GOD";
   private static final String field16621 = "ꕅ";
   private static final String field16622 = "VAMPIRE";
   private static final String field16623 = "ꕉ";
   private static final String field16624 = "PEGAS";
   private static final String field16625 = "ꔉ";
   private static final String field16626 = "HELPER";
   private static final String field16627 = "ꔓ";
   private static final String field16628 = "ML.MODER";
   private static final String field16629 = "ꔗ";
   private static final String field16630 = "MODER";
   private static final String field16631 = "ꔡ";
   private static final String field16632 = "MODER";
   private static final String field16633 = "+";
   private static final String field16634 = "ꔥ";
   private static final String field16635 = "ST.MODER";
   private static final String field16636 = "ꔩ";
   private static final String field16637 = "GL.MODER";
   private static final String field16638 = "ꔳ";
   private static final String field16639 = "ML.ADMIN";
   private static final String field16640 = "ꔷ";
   private static final String field16641 = "ADMIN";
   private static final String field16642 = "ꔅ";
   private static final String field16643 = "YT";
   private static final String field16644 = "ꔁ";
   private static final String field16645 = "MEDIA";
   private static final String field16646 = "ꕓ";
   private static final String field16647 = "GHOST";
   private static final String field16648 = "ꕂ";
   private static final String field16649 = "SPONSOR";
   private static final String field16650 = "ꔸ";
   private static final String field16651 = "GOD";
   private static final String field16652 = "ꔆ";
   private static final String field16653 = "D.MODER";
   private static final String field16654 = "ꔢ";
   private static final String field16655 = "D.ST.MODER";
   private static final String field16656 = "ꔔ";
   private static final String field16657 = "D.GL.MODER";
   private static final String field16658 = "ꔰ";
   private static final String field16659 = "D.ML.ADMIN";
   private static final String field16660 = "ꔂ";
   private static final String field16661 = "D.MODER";
   private static final String field16662 = "ꔘ";
   private static final String field16663 = "D.ST.MODER";
   private static final String field16664 = "ꔐ";
   private static final String field16665 = "D.GL.MODER";
   private static final String field16666 = "ꔦ";
   private static final String field16667 = "D.ML.ADMIN";
   private static final String field16668 = "ꕗ";
   private static final String field16669 = "D.ADMIN";
   private static final String field16670 = "ꔴ";
   private static final String field16671 = "OWNER";
   private static final String field16672 = "ð";
   private static final String field16673 = "◆";
   private static final String field16674 = "●";
   private static final String field16675 = "ᴀ";
   private static final String field16676 = "A";
   private static final String field16677 = "ʙ";
   private static final String field16678 = "B";
   private static final String field16679 = "ᴄ";
   private static final String field16680 = "C";
   private static final String field16681 = "ᴅ";
   private static final String field16682 = "D";
   private static final String field16683 = "ᴇ";
   private static final String field16684 = "E";
   private static final String field16685 = "ғ";
   private static final String field16686 = "F";
   private static final String field16687 = "ꜰ";
   private static final String field16688 = "F";
   private static final String field16689 = "ɢ";
   private static final String field16690 = "G";
   private static final String field16691 = "ʜ";
   private static final String field16692 = "H";
   private static final String field16693 = "ɪ";
   private static final String field16694 = "I";
   private static final String field16695 = "ᴊ";
   private static final String field16696 = "J";
   private static final String field16697 = "ᴋ";
   private static final String field16698 = "K";
   private static final String field16699 = "ʟ";
   private static final String field16700 = "L";
   private static final String field16701 = "ᴍ";
   private static final String field16702 = "M";
   private static final String field16703 = "ɴ";
   private static final String field16704 = "N";
   private static final String field16705 = "ᴏ";
   private static final String field16706 = "O";
   private static final String field16707 = "ᴘ";
   private static final String field16708 = "P";
   private static final String field16709 = "ꜱ";
   private static final String field16710 = "S";
   private static final String field16711 = "ǫ";
   private static final String field16712 = "Q";
   private static final String field16713 = "ʀ";
   private static final String field16714 = "R";
   private static final String field16715 = "ᴛ";
   private static final String field16716 = "T";
   private static final String field16717 = "ᴜ";
   private static final String field16718 = "U";
   private static final String field16719 = "ᴠ";
   private static final String field16720 = "V";
   private static final String field16721 = "ᴡ";
   private static final String field16722 = "W";
   private static final String field16723 = "ʏ";
   private static final String field16724 = "Y";
   private static final String field16725 = "ᴢ";
   private static final String field16726 = "Z";
   private static final String field16727 = "reset";
   private static final String field16728 = "rgba(";
   private static final String field16729 = "rgb(";
   private static final int field16730 = 65536;
   private static final int field16731 = 65535;
   private static final long field16732 = 4294967295L;
   private static final int field16733 = 16777215;
   private static final int field16734 = 65408;
   private static final int field16735 = 43520;
   private static final int field16736 = 43690;
   private static final int field16737 = 11141120;
   private static final int field16738 = 11141290;
   private static final int field16739 = 16755200;
   private static final int field16740 = 11184810;
   private static final int field16741 = 5592405;
   private static final int field16742 = 5592575;
   private static final int field16743 = 5635925;
   private static final int field16744 = 5636095;
   private static final int field16745 = 16733525;
   private static final int field16746 = 16733695;
   private static final int field16747 = 16777045;
   private static final int field16748 = 16777215;
   private static final int field16749 = 65536;

   public static String method06991(String var0) {
      if (var0 != null && !var0.isEmpty() && !field16582.isEmpty()) {
         if (!field16584 && method07016(var0)) {
            return var0;
         }

         StringBuilder var1 = null;
         int sx = var0.length();

         for (int sxx = 0; sxx < sx; sxx++) {
            char sxxx = var0.charAt(sxx);
            String sxxxx = field16583[sxxx];
            if (sxxxx != null) {
               if (var1 == null) {
                  var1 = new StringBuilder(sx);
                  if (sxx > 0) {
                     var1.append(var0, 0, sxx);
                  }
               }

               var1.append(sxxxx);
            } else if (var1 != null) {
               var1.append(sxxx);
            }
         }

         return var1 == null ? var0 : var1.toString();
      } else {
         return var0;
      }
   }

   private static int method06992(char var0) {
      return switch (var0) {
         case '0' -> 0;
         case '1' -> 1;
         case '2' -> 2;
         case '3' -> 3;
         case '4' -> 4;
         case '5' -> 5;
         case '6' -> 6;
         case '7' -> 7;
         case '8' -> 8;
         case '9' -> 9;
         default -> -1;
         case 'A', 'a' -> 10;
         case 'B', 'b' -> 11;
         case 'C', 'c' -> 12;
         case 'D', 'd' -> 13;
         case 'E', 'e' -> 14;
         case 'F', 'f' -> 15;
      };
   }

   private void method06993(
      Matrix3x2f var1,
      VertexConsumer var2,
      FontGlyph[] var3,
      String var4,
      float var5,
      float var6,
      float var7,
      float var8,
      CornerColors var9,
      float var10,
      float var11
   ) {
      boolean var12 = false;
      int var13 = -1;
      int var14 = var4.length();

      for (int var15 = 0; var15 < var14; var15++) {
         char var16 = var4.charAt(var15);
         FontGlyph var17 = var3[var16];
         if (var17 != null) {
            if (var12) {
               var7 += var6 + this.method07013(var13, var16, var5);
            }

            var7 += var17.method03689(var1, var2, var5, var7, var8, var9, var10, var11, var6);
            var12 = true;
            var13 = var16;
         }
      }
   }

   private FontFace(
      String var1,
      AbstractTexture var2,
      FontAtlasMetadata.Nested25 var3,
      FontAtlasMetadata.Nested26 var4,
      Map<Integer, FontGlyph> var5,
      Map<Long, Float> var6
   ) {
      this.field16577 = new LinkedHashMap<FontFace.Nested207, Float>(512, field16586, false)      // $VF: Compiled from s
 {
         @Override
         protected boolean removeEldestEntry(Entry<FontFace.Nested207, Float> var1) {
            return this.size() > 2048;
         }
      };
      this.field16578 = new FontFace.Nested207();
      this.field16569 = var1;
      this.field16570 = var2;
      this.field16571 = var3;
      this.field16572 = var4;
      this.field16573 = var5;
      this.field16574 = var6;
      this.field16575 = method07000(var5);
      this.method06998();
   }

   private static int method06994(int var0, int var1) {
      return method07001(var1) << 24 | var0 & field16733;
   }

   private float method06995(String var1, float var2, float var3) {
      var1 = method06991(var1);
      if (var1 != null && !var1.isEmpty()) {
         if (var1.indexOf(167) >= 0) {
            var1 = ChatFormatting.stripFormatting(var1);
         }

         if (var1.indexOf(36) >= 0) {
            var1 = ChatColorFormatter.method07516(var1);
         }

         FontGlyph[] var4 = this.field16575;
         float var5 = 0.0F;
         float var6 = Float.POSITIVE_INFINITY;
         float var7 = Float.NEGATIVE_INFINITY;
         boolean var8 = false;
         int var9 = -1;
         int var10 = var1.length();

         for (int var11 = 0; var11 < var10; var11++) {
            char var12 = var1.charAt(var11);
            FontGlyph var13 = var4[var12];
            if (var13 != null) {
               if (var8) {
                  var5 += var3 + this.method07013(var9, var12, var2);
               }

               float var14;
               float var15;
               if (var13.method03695()) {
                  var14 = var5 + var13.method03703(var2);
                  var15 = var5 + var13.method03697(var2);
               } else {
                  var14 = var5;
                  var15 = var5 + var13.method03699(var2);
               }

               if (var14 < var6) {
                  var6 = var14;
               }

               if (var15 > var7) {
                  var7 = var15;
               }

               var5 += var13.method03699(var2);
               var8 = true;
               var9 = var12;
            }
         }

         return !var8 ? 0.0F : Math.max(0.0F, var7 - var6);
      } else {
         return 0.0F;
      }
   }

   void method06996(
      Matrix3x2f var1,
      VertexConsumer var2,
      String var3,
      float var4,
      float var5,
      float var6,
      float var7,
      CornerColors var8,
      float var9,
      FontAtlasMetadata.Nested25 var10
   ) {
      var3 = method06991(var3);
      if (var3 != null && !var3.isEmpty()) {
         int var11 = var8.color1();
         float var12 = var10.method00832();
         FontGlyph[] var13 = this.field16575;
         if (var3.indexOf(36) < 0 && var3.indexOf(167) < 0) {
            this.method06993(var1, var2, var13, var3, var4, var5, var6, var7, var8, var9, var12);
         } else {
            int var14 = var11;
            CornerColors var15 = var8;
            boolean var16 = false;
            int var17 = 255;
            boolean var18 = false;
            int var19 = -1;
            int var20 = var3.length();
            int var21 = 0;

            while (var21 < var20) {
               char var22 = var3.charAt(var21);
               if (var22 == '$' && var21 + 2 < var20 && var3.charAt(var21 + 1) == '{') {
                  int var23 = var21 + 2;
                  int var24 = var3.indexOf(125, var23);
                  if (var24 > var23) {
                     boolean var25 = false;
                     if (var24 - var23 == 5 && var3.regionMatches(true, var23, field16727, 0, 5)) {
                        if (var16) {
                           var14 = var11;
                           var15 = var8;
                           var16 = false;
                        }

                        var17 = 255;
                        var25 = true;
                     } else {
                        boolean var26 = var3.regionMatches(true, var23, field16728, 0, 5);
                        boolean var27 = !var26 && var3.regionMatches(true, var23, field16729, 0, 4);
                        if ((var26 || var27) && var3.charAt(var24 - 1) == ')') {
                           int var28 = var23 + (var26 ? 5 : 4);
                           int var29 = 0;
                           int var30 = 0;
                           boolean var31 = false;
                           boolean var32 = true;
                           int var33 = 0;
                           int var34 = 0;
                           int var35 = 0;
                           int var36 = var17;

                           for (int var37 = var28; var37 <= var24 - 1; var37++) {
                              char var38 = var37 == var24 - 1 ? ',' : var3.charAt(var37);
                              if (var38 >= '0' && var38 <= '9') {
                                 var30 = var30 * 10 + (var38 - '0');
                                 var31 = true;
                              } else {
                                 if (var38 != ',' || !var31) {
                                    var32 = false;
                                    break;
                                 }

                                 switch (var29) {
                                    case 0:
                                       var33 = var30;
                                       break;
                                    case 1:
                                       var34 = var30;
                                       break;
                                    case 2:
                                       var35 = var30;
                                       break;
                                    case 3:
                                       var36 = var30;
                                       break;
                                    default:
                                       var32 = false;
                                 }

                                 if (!var32) {
                                    break;
                                 }

                                 var29++;
                                 var30 = 0;
                                 var31 = false;
                              }
                           }

                           boolean var44 = var29 == 3 || var26 && var29 == 4;
                           if (var32 && var44) {
                              if (var26 && var29 == 4) {
                                 var17 = method07001(var36);
                              }

                              int var45 = method07007(var33, var34, var35, var17);
                              if (!var16 || var45 != var14) {
                                 var14 = var45;
                                 var15 = new CornerColors(var14);
                                 var16 = true;
                              }

                              var25 = true;
                           }
                        }
                     }

                     if (var25) {
                        var21 = var24 + 1;
                        continue;
                     }
                  }
               }

               if (var22 == 167 && var21 + 1 < var20) {
                  int var41 = method06992(var3.charAt(var21 + 1));
                  if (var41 >= 0) {
                     int var42 = field16580[var41];
                     int var43 = method06994(var42, var17);
                     if (!var16 || var43 != var14) {
                        var14 = var43;
                        var15 = new CornerColors(var14);
                        var16 = true;
                     }
                  }

                  var21 += 2;
               } else {
                  FontGlyph var40 = var13[var22];
                  if (var40 != null) {
                     if (var18) {
                        var6 += var5 + this.method07013(var19, var22, var4);
                     }

                     var6 += var40.method03689(var1, var2, var4, var6, var7, var15, var9, var12, var5);
                     var18 = true;
                     var19 = var22;
                  }

                  var21++;
               }
            }
         }
      }
   }

   public FontAtlasMetadata.Nested25 method06997() {
      return this.field16571;
   }

   private void method06998() {
      if (!field16585) {
         synchronized (FontFace.class) {
            if (!field16585) {
               field16582.put(
                  field16587,
                  ChatColorFormatter.method07510(field16588, ColorUtils.method04604(120, 120, 120), ColorUtils.method04604(220, 220, 220))
               );
               field16582.put(
                  field16589,
                  ChatColorFormatter.method07510(field16590, ColorUtils.method04604(1, 33, 248), ColorUtils.method04604(58, 94, 251))
               );
               field16582.put(
                  field16591,
                  ChatColorFormatter.method07510(field16592, ColorUtils.method04604(248, 215, 0), ColorUtils.method04604(206, 247, 0))
               );
               field16582.put(
                  field16593,
                  ChatColorFormatter.method07510(field16594, ColorUtils.method04604(43, 247, 1), ColorUtils.method04604(118, 247, 152))
               );
               field16582.put(
                  field16595,
                  ChatColorFormatter.method07510(field16596, ColorUtils.method04604(63, 172, 218), ColorUtils.method04604(0, 239, 251))
               );
               field16582.put(
                  field16597,
                  ChatColorFormatter.method07510(field16598, ColorUtils.method04604(248, 140, 0), ColorUtils.method04604(248, 190, 64))
               );
               field16582.put(
                  field16599,
                  ChatColorFormatter.method07510(field16600, ColorUtils.method04604(215, 46, 46), ColorUtils.method04604(248, 80, 82))
               );
               field16582.put(
                  field16601,
                  ChatColorFormatter.method07510(field16602, ColorUtils.method04604(246, 0, 224), ColorUtils.method04604(190, 35, 247))
               );
               field16582.put(
                  field16603,
                  ChatColorFormatter.method07510(field16604, ColorUtils.method04604(239, 202, 35), ColorUtils.method04604(232, 226, 60))
               );
               field16582.put(
                  field16605,
                  ChatColorFormatter.method07510(field16606, ColorUtils.method04604(27, 94, 21), ColorUtils.method04604(32, 149, 29))
               );
               field16582.put(
                  field16607,
                  ChatColorFormatter.method07510(field16608, ColorUtils.method04604(36, 39, 40), ColorUtils.method04604(101, 103, 105))
               );
               field16582.put(
                  field16609,
                  ChatColorFormatter.method07510(field16610, ColorUtils.method04604(0, 247, 0), ColorUtils.method04604(111, 247, 112))
               );
               field16582.put(
                  field16611,
                  ChatColorFormatter.method07510(field16612, ColorUtils.method04604(157, 32, 32), ColorUtils.method04604(207, 51, 51))
               );
               field16582.put(
                  field16613,
                  ChatColorFormatter.method07510(field16614, ColorUtils.method04604(236, 91, 34), ColorUtils.method04604(231, 127, 8))
               );
               field16582.put(
                  field16615,
                  ChatColorFormatter.method07510(field16616, ColorUtils.method04604(204, 210, 218), ColorUtils.method04604(246, 249, 255))
               );
               field16582.put(
                  field16617,
                  ChatColorFormatter.method07510(field16618, ColorUtils.method04604(80, 50, 138), ColorUtils.method04604(121, 81, 202))
               );
               field16582.put(
                  field16619,
                  ChatColorFormatter.method07510(field16620, ColorUtils.method04604(235, 169, 32), ColorUtils.method04604(252, 212, 134))
               );
               field16582.put(
                  field16621,
                  ChatColorFormatter.method07510(field16622, ColorUtils.method04604(94, 28, 28), ColorUtils.method04604(214, 64, 64))
               );
               field16582.put(
                  field16623,
                  ChatColorFormatter.method07510(field16624, ColorUtils.method04604(255, 255, 0), ColorUtils.method04604(139, 132, 0))
               );
               field16582.put(
                  field16625,
                  ChatColorFormatter.method07510(field16626, ColorUtils.method04604(241, 204, 45), ColorUtils.method04604(232, 226, 60))
               );
               field16582.put(
                  field16627,
                  ChatColorFormatter.method07510(field16628, ColorUtils.method04604(100, 180, 255), ColorUtils.method04604(30, 110, 220))
               );
               field16582.put(
                  field16629,
                  ChatColorFormatter.method07510(field16630, ColorUtils.method04604(62, 79, 255), ColorUtils.method04604(100, 113, 251))
               );
               field16582.put(
                  field16631,
                  ChatColorFormatter.method07510(field16632, ColorUtils.method04604(62, 79, 255), ColorUtils.method04604(110, 123, 249))
                     + ChatColorFormatter.method07510(field16633, ColorUtils.method04604(241, 160, 0))
               );
               field16582.put(
                  field16634,
                  ChatColorFormatter.method07510(field16635, ColorUtils.method04604(49, 67, 255), ColorUtils.method04604(120, 133, 247))
               );
               field16582.put(
                  field16636,
                  ChatColorFormatter.method07510(field16637, ColorUtils.method04604(76, 86, 194), ColorUtils.method04604(70, 84, 242))
               );
               field16582.put(
                  field16638,
                  ChatColorFormatter.method07510(field16639, ColorUtils.method04604(0, 100, 100), ColorUtils.method04604(0, 255, 246))
               );
               field16582.put(
                  field16640,
                  ChatColorFormatter.method07510(field16641, ColorUtils.method04604(254, 85, 85), ColorUtils.method04604(255, 40, 40))
               );
               field16582.put(
                  field16642,
                  ChatColorFormatter.method07510(field16643, ColorUtils.method04604(255, 0, 0), ColorUtils.method04604(255, 255, 255))
               );
               field16582.put(
                  field16644,
                  ChatColorFormatter.method07510(field16645, ColorUtils.method04604(80, 50, 138), ColorUtils.method04604(127, 91, 195))
               );
               field16582.put(
                  field16646,
                  ChatColorFormatter.method07510(field16647, ColorUtils.method04604(107, 107, 107), ColorUtils.method04604(141, 141, 141))
               );
               field16582.put(
                  field16648,
                  ChatColorFormatter.method07510(field16649, ColorUtils.method04604(50, 252, 70), ColorUtils.method04604(32, 165, 52))
               );
               field16582.put(
                  field16650,
                  ChatColorFormatter.method07510(field16651, ColorUtils.method04604(235, 169, 32), ColorUtils.method04604(252, 212, 134))
               );
               field16582.put(
                  field16652,
                  ChatColorFormatter.method07510(field16653, ColorUtils.method04604(107, 107, 107), ColorUtils.method04604(151, 151, 151))
               );
               field16582.put(
                  field16654,
                  ChatColorFormatter.method07510(field16655, ColorUtils.method04604(107, 107, 107), ColorUtils.method04604(156, 156, 156))
               );
               field16582.put(
                  field16656,
                  ChatColorFormatter.method07510(field16657, ColorUtils.method04604(107, 107, 107), ColorUtils.method04604(156, 156, 156))
               );
               field16582.put(
                  field16658,
                  ChatColorFormatter.method07510(field16659, ColorUtils.method04604(107, 107, 107), ColorUtils.method04604(151, 151, 151))
               );
               field16582.put(
                  field16660,
                  ChatColorFormatter.method07510(field16661, ColorUtils.method04604(49, 67, 255), ColorUtils.method04604(100, 113, 251))
               );
               field16582.put(
                  field16662,
                  ChatColorFormatter.method07510(field16663, ColorUtils.method04604(49, 67, 255), ColorUtils.method04604(120, 133, 247))
               );
               field16582.put(
                  field16664,
                  ChatColorFormatter.method07510(field16665, ColorUtils.method04604(70, 79, 176), ColorUtils.method04604(70, 84, 242))
               );
               field16582.put(
                  field16666,
                  ChatColorFormatter.method07510(field16667, ColorUtils.method04604(0, 100, 100), ColorUtils.method04604(0, 255, 246))
               );
               field16582.put(
                  field16668,
                  ChatColorFormatter.method07510(field16669, ColorUtils.method04604(254, 85, 85), ColorUtils.method04604(255, 30, 30))
               );
               field16582.put(
                  field16670,
                  ChatColorFormatter.method07510(field16671, ColorUtils.method04604(180, 50, 50), ColorUtils.method04604(210, 90, 90))
               );
               field16582.put(field16672, "");
               field16582.put(field16673, field16674);
               field16582.put(field16675, field16676);
               field16582.put(field16677, field16678);
               field16582.put(field16679, field16680);
               field16582.put(field16681, field16682);
               field16582.put(field16683, field16684);
               field16582.put(field16685, field16686);
               field16582.put(field16687, field16688);
               field16582.put(field16689, field16690);
               field16582.put(field16691, field16692);
               field16582.put(field16693, field16694);
               field16582.put(field16695, field16696);
               field16582.put(field16697, field16698);
               field16582.put(field16699, field16700);
               field16582.put(field16701, field16702);
               field16582.put(field16703, field16704);
               field16582.put(field16705, field16706);
               field16582.put(field16707, field16708);
               field16582.put(field16709, field16710);
               field16582.put(field16711, field16712);
               field16582.put(field16713, field16714);
               field16582.put(field16715, field16716);
               field16582.put(field16717, field16718);
               field16582.put(field16719, field16720);
               field16582.put(field16721, field16722);
               field16582.put(field16723, field16724);
               field16582.put(field16725, field16726);
               method07015();
               field16584 = method07004();
               field16585 = true;
            }
         }
      }
   }

   public float method06999(String var1, float var2, float var3) {
      if (var1 != null && !var1.isEmpty()) {
         synchronized (this.field16577) {
            this.field16578.method07021(var1, var2, var3);
            Float var5 = this.field16577.get(this.field16578);
            if (var5 != null) {
               return var5;
            }

            FontFace.Nested207 var6 = new FontFace.Nested207(this.field16578);
            float var7 = this.method06995(var1, var2, var3);
            this.field16577.put(var6, var7);
            return var7;
         }
      } else {
         return 0.0F;
      }
   }

   private static FontGlyph[] method07000(Map<Integer, FontGlyph> var0) {
      FontGlyph[] var1 = new FontGlyph[field16730];

      for (var var3 : var0.entrySet()) {
         int var4 = (Integer)var3.getKey();
         if (var4 >= 0 && var4 <= field16731) {
            var1[var4] = (FontGlyph)var3.getValue();
         }
      }

      return var1;
   }

   private static int method07001(int var0) {
      return Math.max(0, Math.min(255, var0));
   }

   public String method07002() {
      return this.field16569;
   }

   public void method07003(
      Matrix3x2f var1,
      VertexConsumer var2,
      String var3,
      float var4,
      float var5,
      float var6,
      float var7,
      CornerColors var8,
      float var9,
      FontAtlasMetadata.Nested25 var10
   ) {
      GlyphMeshCache.method00331(this, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   private static boolean method07004() {
      for (int var0 = 0; var0 < 128; var0++) {
         if (field16583[var0] != null) {
            return true;
         }
      }

      return false;
   }

   public void method07005(
      Matrix3x2f var1,
      VertexConsumer var2,
      String var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      float var9,
      FontAtlasMetadata.Nested25 var10
   ) {
      this.method07003(var1, var2, var3, var4, var5, var6, var7, new CornerColors(var8), var9, var10);
   }

   public FontAtlasMetadata.Nested26 method07006() {
      return this.field16572;
   }

   private static int method07007(int var0, int var1, int var2, int var3) {
      return method07001(var3) << 24 | method07001(var0) << 16 | method07001(var1) << 8 | method07001(var2);
   }

   private static long method07008(int var0, int var1) {
      return (long)var0 << 32 | var1 & field16732;
   }

   public FontGlyph method07009(char var1) {
      return this.field16575[var1];
   }

   public static FontFace.Nested205 method07010() {
      return new FontFace.Nested205();
   }

   public float method07011(String var1, float var2) {
      return this.method06999(var1, var2, 0.0F);
   }

   public GpuTextureView method07012() {
      return this.field16570.getTextureView();
   }

   public float method07013(int var1, int var2, float var3) {
      if (var1 >= 0 && var2 >= 0 && !this.field16574.isEmpty()) {
         Float var4 = this.field16574.get(method07008(var1, var2));
         return var4 != null && var4 != 0.0F ? var4 * var3 : 0.0F;
      } else {
         return 0.0F;
      }
   }

   public GpuSampler method07014() {
      if (field16579 == null) {
         field16579 = RenderSystem.getDevice()
            .createSampler(AddressMode.CLAMP_TO_EDGE, AddressMode.CLAMP_TO_EDGE, FilterMode.LINEAR, FilterMode.LINEAR, 1, OptionalDouble.empty());
      }

      return field16579;
   }

   private static void method07015() {
      for (var var1 : field16582.entrySet()) {
         String var2 = (String)var1.getKey();
         if (var2 != null && var2.length() == 1) {
            field16583[var2.charAt(0)] = (String)var1.getValue();
         }
      }
   }

   private static boolean method07016(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         int var1 = var0.length();

         for (int var2 = 0; var2 < var1; var2++) {
            if ((var0.charAt(var2) & field16734) != 0) {
               return false;
            }
         }

         return true;
      } else {
         return true;
      }
   }

   // $VF: Compiled from s
   public static class Nested205 {
      private String field16750;
      private Identifier field16751;
      private Identifier field16752;
      private static final Map<FontFace.Nested205.Nested206, FontFace> field16753 = new ConcurrentHashMap<>();
      private static final String field16754 = "?";
      private static final String field16755 = "Hex";
      private static final String field16756 = "Hex";
      private static final String field16757 = "Font data identifier is not set";
      private static final String field16758 = "Font atlas identifier is not set";
      private static final float field16759 = 0.75F;
      private static final float field16760 = 0.75F;

      public FontFace.Nested205 method07017(String var1) {
         this.field16752 = Identifier.fromNamespaceAndPath(field16756.toLowerCase(), "fonts/" + var1 + ".png");
         return this;
      }

      public FontFace method07018() {
         if (this.field16751 == null) {
            throw new IllegalStateException(field16757);
         }

         if (this.field16752 == null) {
            throw new IllegalStateException(field16758);
         }

         FontFace.Nested205.Nested206 var1 = new FontFace.Nested205.Nested206(this.field16750, this.field16751, this.field16752);
         FontFace var2 = field16753.get(var1);
         if (var2 != null) {
            return var2;
         }

         FontAtlasMetadata var3 = ResourceLoader.method04277(this.field16751, FontAtlasMetadata.class);
         if (var3 == null) {
            throw new RuntimeException(
               "Failed to read font data file: " + this.field16751.toString() + "; Are you sure this is json file? Try to check the correctness of its syntax."
            );
         }

         Identifier var4 = TextureLoader.method07204(this.field16752);
         AbstractTexture var5 = Minecraft.getInstance().getTextureManager().getTexture(var4);
         float var6 = var3.method00820().method00833();
         float var7 = var3.method00820().method00834();
         var var8 = var3.method00822();
         int var9 = var8 == null ? 0 : var8.size();
         int var10 = Math.max(16, (int)(var9 / field16759) + 1);
         HashMap var11 = new HashMap(var10);
         if (var8 != null) {
            for (FontAtlasMetadata.Nested23 var13 : var8) {
               var11.put(var13.method00827(), new FontGlyph(var13, var6, var7));
            }
         }

         var var18 = var3.method00821();
         int var19 = var18 == null ? 0 : var18.size();
         int var14 = Math.max(16, (int)(var19 / field16760) + 1);
         HashMap var15 = new HashMap(var14);
         if (var18 != null) {
            for (FontAtlasMetadata.Nested27 var17 : var18) {
               var15.put(FontFace.method07008(var17.method00839(), var17.method00840()), var17.method00841());
            }
         }

         FontFace var20 = new FontFace(this.field16750, var5, var3.method00820(), var3.method00823(), var11, var15);
         FontFace var21 = field16753.putIfAbsent(var1, var20);
         return var21 != null ? var21 : var20;
      }

      public FontFace.Nested205 method07019(String var1) {
         this.field16750 = var1;
         return this;
      }

      private Nested205() {
         this.field16750 = field16754;
      }

      public FontFace.Nested205 method07020(String var1) {
         this.field16751 = Identifier.fromNamespaceAndPath(field16755.toLowerCase(), "fonts/" + var1 + ".json");
         return this;
      }

      // $VF: Compiled from s
      private record Nested206(String name, Identifier dataIdentifier, Identifier atlasIdentifier) {
      }
   }

   // $VF: Compiled from s
   private static final class Nested207 {
      private String field16762;
      private float field16763;
      private float field16764;
      private int field16765;

      @Override
      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else {
            return !(var1 instanceof FontFace.Nested207 var2)
               ? false
               : this.field16765 == var2.field16765
                  && Float.floatToIntBits(this.field16763) == Float.floatToIntBits(var2.field16763)
                  && Float.floatToIntBits(this.field16764) == Float.floatToIntBits(var2.field16764)
                  && this.field16762.equals(var2.field16762);
         }
      }

      private Nested207() {
      }

      @Override
      public int hashCode() {
         return this.field16765;
      }

      private void method07021(String var1, float var2, float var3) {
         this.field16762 = var1;
         this.field16763 = var2;
         this.field16764 = var3;
         this.field16765 = (var1.hashCode() * 31 + Float.floatToIntBits(var2)) * 31 + Float.floatToIntBits(var3);
      }

      private Nested207(FontFace.Nested207 var1) {
         this.field16762 = var1.field16762;
         this.field16763 = var1.field16763;
         this.field16764 = var1.field16764;
         this.field16765 = var1.field16765;
      }
   }
}
