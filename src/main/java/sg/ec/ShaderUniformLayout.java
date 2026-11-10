// Original binary: sg/ec/dULkKlT4gKgKgWPG
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.vertex.VertexFormat;
import com.mojang.renderpearl.api.vertex.VertexFormat.Builder;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import org.lwjgl.system.MemoryUtil;

// $VF: Compiled from s
public final class ShaderUniformLayout {
   public static final ShaderUniformLayout.Nested221 field18142 = new ShaderUniformLayout.Nested221(0, ShaderUniformLayout.field18167, GpuFormat.RGBA32_FLOAT);
   public static final ShaderUniformLayout.Nested221 field18143 = new ShaderUniformLayout.Nested221(1, ShaderUniformLayout.field18168, GpuFormat.RG32_FLOAT);
   public static final ShaderUniformLayout.Nested221 field18144 = new ShaderUniformLayout.Nested221(2, ShaderUniformLayout.field18169, GpuFormat.R32_FLOAT);
   public static final ShaderUniformLayout.Nested221 field18145 = new ShaderUniformLayout.Nested221(3, ShaderUniformLayout.field18170, GpuFormat.R32_FLOAT);
   public static final ShaderUniformLayout.Nested221 field18146 = new ShaderUniformLayout.Nested221(4, ShaderUniformLayout.field18171, GpuFormat.R32_FLOAT);
   public static final ShaderUniformLayout.Nested221 field18147 = new ShaderUniformLayout.Nested221(5, ShaderUniformLayout.field18172, GpuFormat.RG32_FLOAT);
   public static final ShaderUniformLayout.Nested221 field18148 = new ShaderUniformLayout.Nested221(6, ShaderUniformLayout.field18173, GpuFormat.RG32_FLOAT);
   public static final ShaderUniformLayout.Nested221[] field18149 = new ShaderUniformLayout.Nested221[]{
      field18142, field18143, field18144, field18145, field18146, field18147, field18148
   };
   private static final int field18150 = Integer.MIN_VALUE;
   private static final int[] field18151 = method07419();
   private static final Map<VertexFormat, int[]> field18152 = new IdentityHashMap<>();
   private static final int field18153 = Integer.MIN_VALUE;
   private static final long field18154 = -1L;
   private static final long field18155 = 4L;
   private static final long field18156 = 8L;
   private static final long field18157 = 12L;
   private static final long field18158 = -1L;
   private static final long field18159 = 4L;
   private static final long field18160 = -1L;
   private static final long field18161 = -1L;
   private static final long field18162 = 4L;
   private static final long field18163 = -1L;
   private static final long field18164 = -1L;
   private static final long field18165 = 4L;
   private static final long field18166 = -1L;
   private static final String field18167 = "Radius";
   private static final String field18168 = "Size";
   private static final String field18169 = "Smoothness";
   private static final String field18170 = "Thickness";
   private static final String field18171 = "Range";
   private static final String field18172 = "VEC2F";
   private static final String field18173 = "Coord";

   public static void method07412(ShaderUniformLayout.Nested220 var0, VertexFormat var1, long var2, float var4, float var5) {
      long var6 = var0.method07425(var1, var2, field18147);
      if (var6 != field18158) {
         MemoryUtil.memPutFloat(var6, var4);
         MemoryUtil.memPutFloat(var6 + field18159, var5);
      }
   }

   public static void method07413(ShaderUniformLayout.Nested220 var0, VertexFormat var1, long var2, float var4, float var5) {
      long var6 = var0.method07425(var1, var2, field18143);
      if (var6 != field18161) {
         MemoryUtil.memPutFloat(var6, var4);
         MemoryUtil.memPutFloat(var6 + field18162, var5);
      }
   }

   public static void method07414(ShaderUniformLayout.Nested220 var0, VertexFormat var1, long var2, float var4) {
      long var5 = var0.method07425(var1, var2, field18144);
      if (var5 != field18163) {
         MemoryUtil.memPutFloat(var5, var4);
      }
   }

   public static ShaderUniformLayout.Nested219 method07415(int var0) {
      return new ShaderUniformLayout.Nested219(var0);
   }

   public static void method07416(ShaderUniformLayout.Nested220 var0, VertexFormat var1, long var2, float var4, float var5, float var6) {
      var0.method07426(var1, var2, var4, var5, var6);
   }

   public static void method07417(ShaderUniformLayout.Nested220 var0, VertexFormat var1, long var2, float var4) {
      long var5 = var0.method07425(var1, var2, field18146);
      if (var5 != field18160) {
         MemoryUtil.memPutFloat(var5, var4);
      }
   }

   public static void method07418(ShaderUniformLayout.Nested220 var0, VertexFormat var1, long var2, float var4) {
      long var5 = var0.method07425(var1, var2, field18145);
      if (var5 != field18166) {
         MemoryUtil.memPutFloat(var5, var4);
      }
   }

   private static int[] method07419() {
      int[] var0 = new int[field18149.length];
      Arrays.fill(var0, field18153);
      return var0;
   }

   private ShaderUniformLayout() {
   }

   public static void method07420(ShaderUniformLayout.Nested220 var0, VertexFormat var1, long var2, float var4, float var5) {
      long var6 = var0.method07425(var1, var2, field18148);
      if (var6 != field18164) {
         MemoryUtil.memPutFloat(var6, var4);
         MemoryUtil.memPutFloat(var6 + field18165, var5);
      }
   }

   public static void method07421(ShaderUniformLayout.Nested220 var0, VertexFormat var1, long var2, float var4, float var5, float var6, float var7) {
      long var8 = var0.method07425(var1, var2, field18142);
      if (var8 != field18154) {
         MemoryUtil.memPutFloat(var8, var4);
         MemoryUtil.memPutFloat(var8 + field18155, var5);
         MemoryUtil.memPutFloat(var8 + field18156, var6);
         MemoryUtil.memPutFloat(var8 + field18157, var7);
      }
   }

   // $VF: Compiled from s
   public static final class Nested219 {
      private final Builder field18174;
      private final int[] field18175 = ShaderUniformLayout.method07419();
      private int field18176;

      private Nested219(int var1) {
         this.field18174 = VertexFormat.builder(var1);
      }

      public ShaderUniformLayout.Nested219 method07422(String var1, GpuFormat var2) {
         this.field18174.addAttribute(var1, var2);
         this.field18176 = this.field18176 + var2.blockSize();
         return this;
      }

      public ShaderUniformLayout.Nested219 method07423(ShaderUniformLayout.Nested221 var1) {
         this.field18174.addAttribute(var1.name(), var1.format());
         this.field18175[var1.index()] = this.field18176;
         this.field18176 = this.field18176 + var1.format().blockSize();
         return this;
      }

      public VertexFormat method07424() {
         VertexFormat var1 = this.field18174.build();
         ShaderUniformLayout.field18152.put(var1, this.field18175);
         return var1;
      }
   }

   // $VF: Compiled from s
   public static final class Nested220 {
      private VertexFormat field18177;
      private int[] field18178 = ShaderUniformLayout.field18151;
      private static final long field18179 = -1L;
      private static final long field18180 = -1L;
      private static final int field18181 = Integer.MIN_VALUE;
      private static final long field18182 = -1L;
      private static final long field18183 = -1L;
      private static final int field18184 = Integer.MIN_VALUE;
      private static final int field18185 = Integer.MIN_VALUE;
      private static final int field18186 = Integer.MIN_VALUE;

      private long method07425(VertexFormat var1, long var2, ShaderUniformLayout.Nested221 var4) {
         if (var2 == field18179) {
            return field18180;
         }

         if (var1 != this.field18177) {
            int[] var5 = ShaderUniformLayout.field18152.get(var1);
            this.field18178 = var5 == null ? ShaderUniformLayout.field18151 : var5;
            this.field18177 = var1;
         }

         int var6 = this.field18178[var4.index()];
         return var6 == field18181 ? field18182 : var2 + var6;
      }

      private void method07426(VertexFormat var1, long var2, float var4, float var5, float var6) {
         if (var2 != field18183) {
            if (var1 != this.field18177) {
               int[] var7 = ShaderUniformLayout.field18152.get(var1);
               this.field18178 = var7 == null ? ShaderUniformLayout.field18151 : var7;
               this.field18177 = var1;
            }

            int[] var11 = this.field18178;
            int var8 = var11[ShaderUniformLayout.field18145.index()];
            if (var8 != field18184) {
               MemoryUtil.memPutFloat(var2 + var8, var4);
            }

            int var9 = var11[ShaderUniformLayout.field18146.index()];
            if (var9 != field18185) {
               MemoryUtil.memPutFloat(var2 + var9, var5);
            }

            int var10 = var11[ShaderUniformLayout.field18144.index()];
            if (var10 != field18186) {
               MemoryUtil.memPutFloat(var2 + var10, var6);
            }
         }
      }
   }

   // $VF: Compiled from s
   public record Nested221(int index, String name, GpuFormat format) {
   }
}
