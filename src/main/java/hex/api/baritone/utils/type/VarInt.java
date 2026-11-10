// Original binary: hex/api/baritone/utils/type/VarInt
package hex.api.baritone.utils.type;

import it.unimi.dsi.fastutil.bytes.ByteArrayList;
import it.unimi.dsi.fastutil.bytes.ByteList;

// $VF: Compiled from s
public final class VarInt {
   private final int value;
   private final byte[] serialized;
   private final int size;
   private static final String АХ衣 = "АХ衣";

   public static VarInt read(byte[] var0) {
      return read(var0, 0);
   }

   public final int getValue() {
      return this.value;
   }


   public final int getSize() {
      return this.size;
   }

   public VarInt(int var1) {
      this.value = var1;
      this.serialized = serialize0(this.value);
      this.size = this.serialized.length;
   }

   public final byte[] serialize() {
      return this.serialized;
   }

   public static VarInt read(byte[] var0, int var1) {
      int var2 = 0;
      int sx = 0;
      int sxx = var1;

      byte sxxx;
      do {
         sxxx = var0[sxx++];
         var2 |= (sxxx & 127) << sx++ * 7;
         if (sx > 5) {
            throw new IllegalArgumentException(АХ衣);
         }
      } while ((sxxx & 128) != 0);

      return new VarInt(var2);
   }

   private static byte[] serialize0(int var0) {
      ByteList var1 = new ByteArrayList();

      int sx;
      for (sx = var0; (sx & 128) != 0; sx >>>= 7) {
         var1.add((byte)(sx & 127 | 128));
      }

      var1.add((byte)(sx & 0xFF));
      return var1.toByteArray();
   }
}
