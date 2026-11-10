// Original binary: sg/ec/4OAC3wS6utLPygCG
package sg.ec;

import com.google.gson.annotations.SerializedName;
import java.util.List;

// $VF: Compiled from s
public final class FontAtlasMetadata {
   @SerializedName("atlas")
   private FontAtlasMetadata.Nested25 atlas;
   @SerializedName("metrics")
   private FontAtlasMetadata.Nested26 metrics;
   @SerializedName("glyphs")
   private List<FontAtlasMetadata.Nested23> glyphs;
   @SerializedName("kerning")
   private List<FontAtlasMetadata.Nested27> kernings;

   public FontAtlasMetadata.Nested25 method00820() {
      return this.atlas;
   }

   public List<FontAtlasMetadata.Nested27> method00821() {
      return this.kernings;
   }

   public List<FontAtlasMetadata.Nested23> method00822() {
      return this.glyphs;
   }

   public FontAtlasMetadata.Nested26 method00823() {
      return this.metrics;
   }

   // $VF: Compiled from s
   public static final class Nested23 {
      @SerializedName("unicode")
      private int unicode;
      @SerializedName("advance")
      private float advance;
      @SerializedName("planeBounds")
      private FontAtlasMetadata.Nested24 planeBounds;
      @SerializedName("atlasBounds")
      private FontAtlasMetadata.Nested24 atlasBounds;

      public FontAtlasMetadata.Nested24 method00824() {
         return this.planeBounds;
      }

      public FontAtlasMetadata.Nested24 method00825() {
         return this.atlasBounds;
      }

      public float method00826() {
         return this.advance;
      }

      public int method00827() {
         return this.unicode;
      }
   }

   // $VF: Compiled from s
   public static final class Nested24 {
      @SerializedName("left")
      private float left;
      @SerializedName("top")
      private float top;
      @SerializedName("right")
      private float right;
      @SerializedName("bottom")
      private float bottom;

      public float method00828() {
         return this.right;
      }

      public float method00829() {
         return this.bottom;
      }

      public float method00830() {
         return this.top;
      }

      public float method00831() {
         return this.left;
      }
   }

   // $VF: Compiled from s
   public static final class Nested25 {
      @SerializedName("distanceRange")
      private float range;
      @SerializedName("width")
      private float width;
      @SerializedName("height")
      private float height;

      public float method00832() {
         return this.range;
      }

      public float method00833() {
         return this.width;
      }

      public float method00834() {
         return this.height;
      }
   }

   // $VF: Compiled from s
   public static final class Nested26 {
      @SerializedName("lineHeight")
      private float lineHeight;
      @SerializedName("ascender")
      private float ascender;
      @SerializedName("descender")
      private float descender;

      public float method00835() {
         return this.descender;
      }

      public float method00836() {
         return this.lineHeight + this.descender;
      }

      public float method00837() {
         return this.lineHeight;
      }

      public float method00838() {
         return this.ascender;
      }
   }

   // $VF: Compiled from s
   public static final class Nested27 {
      @SerializedName("unicode1")
      private int leftChar;
      @SerializedName("unicode2")
      private int rightChar;
      @SerializedName("advance")
      private float advance;

      public int method00839() {
         return this.leftChar;
      }

      public int method00840() {
         return this.rightChar;
      }

      public float method00841() {
         return this.advance;
      }
   }
}
