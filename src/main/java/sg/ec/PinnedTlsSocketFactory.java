// Original binary: sg/ec/awGTWnP3C0IXr1JK
package sg.ec;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

// $VF: Compiled from s
public final class PinnedTlsSocketFactory extends SSLSocketFactory {
   private static final byte[] field16831 = Base64.getDecoder().decode(PinnedTlsSocketFactory.field16835);
   private static final String[] field16832 = new String[]{PinnedTlsSocketFactory.field16836};
   private final SSLSocketFactory field16833;
   private static final String field16834 = "TLSv1.3";
   private static final String field16835 = "bm1ZIL/knVXIhxYu7l1GkVNkrFdMH+WVkWNlQs6Kids=";
   private static final String field16836 = "TLSv1.3";

   @Override
   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException {
      return method07053(this.field16833.createSocket(var1, var2, var3, var4));
   }

   @Override
   public Socket createSocket(InetAddress var1, int var2, InetAddress var3, int var4) throws IOException {
      return method07053(this.field16833.createSocket(var1, var2, var3, var4));
   }

   public static SSLSocketFactory method07052() throws GeneralSecurityException {
      SSLContext var0 = SSLContext.getInstance(field16834);
      var0.init(null, new TrustManager[]{new PinnedTlsSocketFactory.Nested208()}, new SecureRandom());
      return new PinnedTlsSocketFactory(var0.getSocketFactory());
   }

   @Override
   public String[] getSupportedCipherSuites() {
      return this.field16833.getSupportedCipherSuites();
   }

   private PinnedTlsSocketFactory(SSLSocketFactory var1) {
      this.field16833 = var1;
   }

   @Override
   public String[] getDefaultCipherSuites() {
      return this.field16833.getDefaultCipherSuites();
   }

   @Override
   public Socket createSocket(String var1, int var2) throws IOException {
      return method07053(this.field16833.createSocket(var1, var2));
   }

   @Override
   public Socket createSocket(InetAddress var1, int var2) throws IOException {
      return method07053(this.field16833.createSocket(var1, var2));
   }

   @Override
   public Socket createSocket() throws IOException {
      return method07053(this.field16833.createSocket());
   }

   @Override
   public Socket createSocket(String var1, int var2, InetAddress var3, int var4) throws IOException {
      return method07053(this.field16833.createSocket(var1, var2, var3, var4));
   }

   private static Socket method07053(Socket var0) {
      if (var0 instanceof SSLSocket var1) {
         var1.setEnabledProtocols(field16832);
      }

      return var0;
   }

   // $VF: Compiled from s
   private static final class Nested208 implements X509TrustManager {
      private static final String field16837 = "No server certificate presented";
      private static final String field16838 = "SHA-256";
      private static final String field16839 = "SHA-256 unavailable";
      private static final String field16840 = "Server certificate pin mismatch";

      @Override
      public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         if (var1 != null && var1.length != 0) {
            byte[] var3;
            try {
               var3 = MessageDigest.getInstance(field16838).digest(var1[0].getPublicKey().getEncoded());
            } catch (NoSuchAlgorithmException sx) {
               throw new CertificateException(field16839, sx);
            }

            if (!MessageDigest.isEqual(var3, PinnedTlsSocketFactory.field16831)) {
               throw new CertificateException(field16840);
            }
         } else {
            throw new CertificateException(field16837);
         }
      }

      @Override
      public X509Certificate[] getAcceptedIssuers() {
         return new X509Certificate[0];
      }

      @Override
      public void checkClientTrusted(X509Certificate[] var1, String var2) {
      }
   }
}
