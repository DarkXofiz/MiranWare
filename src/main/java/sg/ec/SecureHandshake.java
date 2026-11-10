// Original binary: sg/ec/m9rFVSgWEjvzO5Yd
package sg.ec;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// $VF: Compiled from s
public final class SecureHandshake {
   static final byte[] field21497 = new byte[]{81, 71, 2, -73};
   static final byte field21498 = 2;
   private static final String field21499 = "field21499";
   private static final String field21500 = "field21500";
   private static final String field21501 = "field21501";
   private static final String field21502 = "field21502";
   private static final int field21503 = 0;
   private static final int field21504 = 0;
   private static final int field21505 = 0;
   private static final int field21506 = field21497.length + 1;
   private static final int field21507 = field21506 + 44 + 32;
   private static final int field21508 = field21507 + 64;
   private static final SecureRandom field21509 = new SecureRandom();
   private final KeyPair field21510;
   private final byte[] field21511;
   private static final String field21512 = "X25519";
   private static final String field21513 = "Malformed server hello";
   private static final String field21514 = "Unsupported protocol";
   private static final String field21515 = "Ed25519";
   private static final String field21516 = "Server identity mismatch";
   private static final String field21517 = "Ed25519";
   private static final String field21518 = "MCowBQYDK2VwAyEAJaCR10OZjsfSwIfvZSDKp291Xyr2Jjw1/g7UQNrCq6E=";
   private static final String field21519 = "X25519";
   private static final String field21520 = "Unexpected public key encoding";
   private static final String field21521 = "X25519";
   private static final String field21522 = "SHA-256";
   private static final String field21523 = "HmacSHA256";
   private static final String field21524 = "HmacSHA256";
   private static final String field21525 = "HmacSHA256";
   private static final String field21526 = "QuickClient/Globals/v2";

   public byte[] method09461() {
      return (byte[])this.field21511.clone();
   }

   private static byte[] method09462(byte[] var0, byte[] var1, int var2) throws GeneralSecurityException {
      Mac var3 = Mac.getInstance(field21523);
      var3.init(new SecretKeySpec(var0, field21524));
      byte[] var4 = var3.doFinal(var1);
      var3.init(new SecretKeySpec(var4, field21525));
      Arrays.fill(var4, (byte)0);
      byte[] var5 = field21526.getBytes(StandardCharsets.UTF_8);
      byte[] var6 = new byte[var2];
      byte[] var7 = new byte[0];
      int var8 = 0;

      for (byte var9 = 1; var8 < var2; var9++) {
         var3.update(var7);
         var3.update(var5);
         var3.update(var9);
         var7 = var3.doFinal();
         int var10 = Math.min(var7.length, var2 - var8);
         System.arraycopy(var7, 0, var6, var8, var10);
         var8 += var10;
      }

      return var6;
   }

   private SecureHandshake(KeyPair var1, byte[] var2) {
      this.field21510 = var1;
      this.field21511 = var2;
   }

   private static byte[] method09463(KeyPair var0, PublicKey var1, byte[] var2) throws GeneralSecurityException {
      KeyAgreement var3 = KeyAgreement.getInstance(field21521);
      var3.init(var0.getPrivate());
      var3.doPhase(var1, true);
      byte[] var4 = var3.generateSecret();
      byte[] var5 = MessageDigest.getInstance(field21522).digest(var2);
      byte[] var6 = method09462(var5, var4, 72);
      Arrays.fill(var4, (byte)0);
      return var6;
   }

   public EncryptedFrameCodec method09464(byte[] var1) throws GeneralSecurityException {
      if (var1 == null || var1.length != field21508) {
         throw new GeneralSecurityException(field21513);
      }

      if (Arrays.equals(var1, 0, field21497.length, field21497, 0, field21497.length) && var1[field21497.length] == 2) {
         byte[] var2 = new byte[field21507 * 2];
         System.arraycopy(this.field21511, 0, var2, 0, field21507);
         System.arraycopy(var1, 0, var2, field21507, field21507);
         Signature var3 = Signature.getInstance(field21515);
         var3.initVerify(method09466());
         var3.update(var2);
         if (!var3.verify(Arrays.copyOfRange(var1, field21507, field21508))) {
            throw new GeneralSecurityException(field21516);
         } else {
            return EncryptedFrameCodec.method00964(method09463(this.field21510, method09468(var1), var2), true);
         }
      } else {
         throw new GeneralSecurityException(field21514);
      }
   }

   private static byte[] method09465(PublicKey var0) throws GeneralSecurityException {
      byte[] var1 = var0.getEncoded();
      if (var1 != null && var1.length == 44) {
         return var1;
      } else {
         throw new GeneralSecurityException(field21520);
      }
   }

   private static PublicKey method09466() throws GeneralSecurityException {
      return KeyFactory.getInstance(field21517).generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(field21518)));
   }

   public static SecureHandshake method09467() throws GeneralSecurityException {
      KeyPair var0 = KeyPairGenerator.getInstance(field21512).generateKeyPair();
      byte[] var1 = new byte[field21507];
      System.arraycopy(field21497, 0, var1, 0, field21497.length);
      var1[field21497.length] = 2;
      System.arraycopy(method09465(var0.getPublic()), 0, var1, field21506, 44);
      byte[] var2 = new byte[32];
      field21509.nextBytes(var2);
      System.arraycopy(var2, 0, var1, field21506 + 44, 32);
      return new SecureHandshake(var0, var1);
   }

   private static PublicKey method09468(byte[] var0) throws GeneralSecurityException {
      return KeyFactory.getInstance(field21519).generatePublic(new X509EncodedKeySpec(Arrays.copyOfRange(var0, field21506, field21506 + 44)));
   }
}
