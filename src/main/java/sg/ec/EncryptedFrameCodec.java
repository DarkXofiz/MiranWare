// Original binary: sg/ec/5M9mRigNAVdzNOaE
package sg.ec;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// $VF: Compiled from s
public final class EncryptedFrameCodec {
   static final int field02195 = 32;
   static final int field02196 = 0;
   static final int field02197 = 0;
   private static final byte field02198 = 0;
   private static final byte field02199 = 0;
   private static final int field02200 = 0;
   private static final int field02201 = 0;
   private static final int field02202 = 0;
   private static final int field02203 = 0;
   private static final int field02204 = 0;
   private final SecretKeySpec field02205;
   private final SecretKeySpec field02206;
   private final byte[] field02207;
   private final byte[] field02208;
   private final byte field02209;
   private final byte field02210;
   private long field02211;
   private long field02212;
   private long field02213;
   private static final long field02214 = -1L;
   private static final String field02215 = "Bad key material";
   private static final String field02216 = "AES";
   private static final String field02217 = "AES";
   private static final String field02218 = "Nothing to seal";
   private static final String field02219 = "AES/GCM/NoPadding";
   private static final String field02220 = "Frame too short";
   private static final String field02221 = "Replayed frame";
   private static final String field02222 = "AES/GCM/NoPadding";
   private static final long field02223 = 64L;
   private static final long field02224 = 64L;
   private static final long field02225 = 64L;
   private static final long field02226 = Long.MIN_VALUE;
   private static final long field02227 = 255L;

   private static void method00958(byte[] var0, int var1, long var2) {
      for (int var4 = 0; var4 < 8; var4++) {
         var0[var1 + var4] = (byte)(var2 >>> 56 - var4 * 8);
      }
   }

   private EncryptedFrameCodec(SecretKeySpec var1, byte[] var2, byte var3, SecretKeySpec var4, byte[] var5, byte var6) {
      this.field02212 = field02214;
      this.field02205 = var1;
      this.field02207 = var2;
      this.field02209 = var3;
      this.field02206 = var4;
      this.field02208 = var5;
      this.field02210 = var6;
   }

   private static long method00959(byte[] var0) {
      long var1 = 0L;

      for (int var3 = 0; var3 < 8; var3++) {
         var1 = var1 << 8 | var0[var3] & field02227;
      }

      return var1;
   }

   private void method00960(long var1) {
      if (var1 > this.field02212) {
         long var3 = var1 - this.field02212;
         if (var3 > field02224) {
            this.field02213 = 0L;
         } else if (var3 == field02225) {
            this.field02213 = field02226;
         } else {
            this.field02213 = this.field02213 << (int)var3 | 1L << (int)(var3 - 1L);
         }

         this.field02212 = var1;
      } else {
         this.field02213 = this.field02213 | 1L << (int)(this.field02212 - var1 - 1L);
      }
   }

   private static byte[] method00961(byte[] var0, long var1) {
      byte[] var3 = new byte[12];
      System.arraycopy(var0, 0, var3, 0, 4);
      method00958(var3, 4, var1);
      return var3;
   }

   private static void method00962(byte[] var0, long var1) {
      method00958(var0, 0, var1);
   }

   private boolean method00963(long var1) {
      if (var1 < 0L) {
         return false;
      }

      if (var1 > this.field02212) {
         return true;
      }

      long var3 = this.field02212 - var1;
      return var3 <= field02223 && var3 > 0L && (this.field02213 & 1L << (int)(var3 - 1L)) == 0L;
   }

   static EncryptedFrameCodec method00964(byte[] var0, boolean var1) throws GeneralSecurityException {
      if (var0 != null && var0.length == 72) {
         SecretKeySpec var2 = new SecretKeySpec(var0, 0, 32, field02216);
         SecretKeySpec var3 = new SecretKeySpec(var0, 32, 32, field02217);
         byte[] var4 = Arrays.copyOfRange(var0, 64, 68);
         byte[] var5 = Arrays.copyOfRange(var0, 68, 72);
         Arrays.fill(var0, (byte)0);
         return var1 ? new EncryptedFrameCodec(var2, var4, (byte)17, var3, var5, (byte)34) : new EncryptedFrameCodec(var3, var5, (byte)34, var2, var4, (byte)17);
      } else {
         throw new GeneralSecurityException(field02215);
      }
   }

   public synchronized byte[] method00965(byte[] var1) throws GeneralSecurityException {
      if (var1 == null) {
         throw new GeneralSecurityException(field02218);
      }

      long var2 = this.field02211++;
      byte[] var4 = new byte[8 + var1.length + 16];
      method00962(var4, var2);
      Cipher var5 = Cipher.getInstance(field02219);
      var5.init(1, this.field02205, new GCMParameterSpec(128, method00961(this.field02207, var2)));
      var5.updateAAD(method00967(this.field02209, var2));
      var5.doFinal(var1, 0, var1.length, var4, 8);
      return var4;
   }

   public synchronized byte[] method00966(byte[] var1) throws GeneralSecurityException {
      if (var1 != null && var1.length > 24) {
         long var2 = method00959(var1);
         if (!this.method00963(var2)) {
            throw new GeneralSecurityException(field02221);
         }

         Cipher var4 = Cipher.getInstance(field02222);
         var4.init(2, this.field02206, new GCMParameterSpec(128, method00961(this.field02208, var2)));
         var4.updateAAD(method00967(this.field02210, var2));
         byte[] var5 = var4.doFinal(var1, 8, var1.length - 8);
         this.method00960(var2);
         return var5;
      } else {
         throw new GeneralSecurityException(field02220);
      }
   }

   private static byte[] method00967(byte var0, long var1) {
      byte[] var3 = new byte[SecureHandshake.field21497.length + 2 + 8];
      System.arraycopy(SecureHandshake.field21497, 0, var3, 0, SecureHandshake.field21497.length);
      var3[SecureHandshake.field21497.length] = 2;
      var3[SecureHandshake.field21497.length + 1] = var0;
      method00958(var3, SecureHandshake.field21497.length + 2, var1);
      return var3;
   }
}
