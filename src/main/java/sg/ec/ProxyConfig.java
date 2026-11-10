// Original binary: sg/ec/IlyLFYErt3Ng6Yrv
package sg.ec;

import java.util.UUID;

// $VF: Compiled from s
public final class ProxyConfig {
   private final String field08757;
   private String field08758;
   private String field08759;
   private int field08760;
   private ProxyConfig.Nested114 field08761;
   private String field08762;
   private String field08763;
   private String field08764 = "";
   private static final int field08765 = 65535;
   private static final int field08766 = 65535;

   public String method03899() {
      return this.field08762;
   }

   public void method03900(String var1) {
      this.field08759 = var1;
   }

   public ProxyConfig.Nested114 method03901() {
      return this.field08761;
   }

   public String method03902() {
      return this.field08759 + ":" + this.field08760;
   }

   public void method03903(String var1) {
      this.field08762 = var1;
   }

   public String method03904() {
      return this.field08759;
   }

   public static ProxyConfig method03905(String var0, String var1, ProxyConfig.Nested114 var2, String var3, String var4) {
      String var5 = var1 == null ? "" : var1.trim();
      int var6 = var5.lastIndexOf(58);
      if (var6 > 0 && var6 != var5.length() - 1) {
         int var7 = method03911(var5.substring(var6 + 1));
         if (var7 <= 0) {
            return null;
         }

         ProxyConfig var8 = new ProxyConfig(var0, var5.substring(0, var6), var7, var2, var3, var4);
         return var8.method03907() ? var8 : null;
      } else {
         return null;
      }
   }

   public void method03906(String var1) {
      this.field08763 = var1;
   }

   public boolean method03907() {
      return !this.field08759.isEmpty() && this.field08760 > 0 && this.field08760 <= field08766;
   }

   public void method03908(String var1) {
      this.field08764 = var1;
   }

   public void method03909(ProxyConfig.Nested114 var1) {
      this.field08761 = var1;
   }

   public ProxyConfig(String var1, String var2, String var3, int var4, ProxyConfig.Nested114 var5, String var6, String var7) {
      this.field08757 = var1 != null && !var1.isEmpty() ? var1 : UUID.randomUUID().toString();
      this.field08758 = var2 == null ? "" : var2;
      this.field08759 = var3 == null ? "" : var3.trim();
      this.field08760 = var4;
      this.field08761 = var5 == null ? ProxyConfig.Nested114.SOCKS5 : var5;
      this.field08762 = var6 == null ? "" : var6;
      this.field08763 = var7 == null ? "" : var7;
   }

   public void method03910(String var1) {
      this.field08758 = var1;
   }

   public static int method03911(String var0) {
      try {
         int var1 = Integer.parseInt(var0.trim());
         return var1 > 0 && var1 <= field08765 ? var1 : -1;
      } catch (NumberFormatException var2) {
         return -1;
      }
   }

   public int method03912() {
      return this.field08760;
   }

   public String method03913() {
      return this.field08757;
   }

   public String method03914() {
      String var1 = this.field08758.trim();
      return var1.isEmpty() ? this.method03902() : var1;
   }

   public String method03915() {
      return this.field08763;
   }

   public String method03916() {
      return this.field08758;
   }

   public String method03917() {
      return this.field08764;
   }

   public boolean method03918() {
      return !this.field08762.isEmpty() || !this.field08763.isEmpty();
   }

   public ProxyConfig(String var1, String var2, int var3, ProxyConfig.Nested114 var4, String var5, String var6) {
      this(null, var1, var2, var3, var4, var5, var6);
   }

   public void method03919(int var1) {
      this.field08760 = var1;
   }

   // $VF: Compiled from s
   public enum Nested114 {
      SOCKS4("SOCKS4"),
      SOCKS5("SOCKS5");

      private final String field08767;

      Nested114(String var3) {
         this.field08767 = var3;
      }

      public ProxyConfig.Nested114 method03920() {
         return this == SOCKS4 ? SOCKS5 : SOCKS4;
      }

      public String method03921() {
         return this.field08767;
      }
   }
}
