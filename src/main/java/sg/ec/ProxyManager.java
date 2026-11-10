// Original binary: sg/ec/QmzQk7jIjXtU63ZA
package sg.ec;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

// $VF: Compiled from s
public enum ProxyManager {
   INSTANCE;

   public static final int field11359 = 128;
   private static final String field11360 = "field11360";
   private final List<ProxyConfig> field11361 = new CopyOnWriteArrayList<>();
   private final Set<String> field11362 = new LinkedHashSet<>();
   private String field11363 = "";
   private boolean field11364;
   private boolean field11365;

   public ProxyConfig method05222(ProxyConfig var1) {
      ProxyConfig var2 = this.method05223(var1);
      if (var2 != null) {
         this.method05234();
      }

      return var2;
   }

   public ProxyConfig method05223(ProxyConfig var1) {
      if (var1 != null && var1.method03907() && this.field11361.size() < 128) {
         this.field11361.add(var1);
         return var1;
      } else {
         return null;
      }
   }

   public void method05224(String var1) {
      ProxyConfig var2 = this.method05225(var1);
      if (var2 != null) {
         this.field11361.remove(var2);
         if (var2.method03913().equals(this.field11363)) {
            this.field11363 = "";
            this.field11364 = false;
         }

         this.method05234();
      }
   }

   public ProxyConfig method05225(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         for (ProxyConfig var3 : this.field11361) {
            if (var3.method03913().equals(var1)) {
               return var3;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public void method05226(String var1) {
      ProxyConfig var2 = this.method05225(var1);
      this.field11363 = var2 == null ? "" : var2.method03913();
      if (var2 == null) {
         this.field11364 = false;
      }

      this.method05234();
   }

   public ProxyConfig method05227() {
      return this.method05225(this.field11363);
   }

   public ProxyConfig method05228() {
      if (!this.field11364) {
         return null;
      }

      ProxyConfig var1 = this.method05227();
      return var1 != null && var1.method03907() ? var1 : null;
   }

   public boolean method05229(String var1) {
      return !this.field11363.isEmpty() && this.field11363.equals(var1);
   }

   public void method05230() {
      this.field11364 = !this.field11364 && this.method05227() != null;
      this.method05234();
   }

   public void method05231() {
      this.field11365 = true;
      this.field11361.clear();
      this.field11362.clear();
      this.field11363 = "";
      this.field11364 = false;
   }

   public ProxyConfig method05232(String var1, ProxyConfig var2) {
      ProxyConfig var3 = this.method05223(var2);
      if (var3 == null) {
         return null;
      }

      var3.method03908(var1 == null ? "" : var1);
      return var3;
   }

   public void method05233() {
      this.field11365 = false;
      this.field11361.sort(Comparator.comparing(ProxyConfig::method03917));
      this.method05235();
      if (this.method05227() == null) {
         this.field11363 = "";
         this.field11364 = false;
      }

      CustomResourceManager.INSTANCE.method02461();
   }

   public void method05234() {
      if (!this.field11365) {
         var var1 = new LinkedHashSet<>(this.field11362);
         this.method05235();
         var1.removeAll(this.field11362);
         CustomResourceManager.INSTANCE.method02461();
         this.method05236(var1);
      }
   }

   private void method05235() {
      this.field11362.clear();

      for (ProxyConfig var2 : this.field11361) {
         String var3 = StorageManager.method11279(var2.method03914());
         if (var3.isEmpty()) {
            var3 = "proxy";
         }

         String var4 = var3;

         for (int var5 = 1; !this.field11362.add(var4); var5++) {
            var4 = var3 + "_" + var5;
         }

         var2.method03908(var4);
      }
   }

   private void method05236(Set<String> var1) {
      GlobalRequestSender.method09378(var2 -> {
         for (String var4 : var1) {
            var2.method01782(StorageCategory.PROXY, var4);
         }

         for (ProxyConfig var7 : this.field11361) {
            byte[] var5 = ProxyStorage.method07620(var7);
            if (var5.length != 0 && StoredContentCache.method05221(StorageCategory.PROXY, var7.method03917(), var5)) {
               var2.method01839(StorageCategory.PROXY, var7.method03917(), var5);
               StoredContentCache.method05219(StorageCategory.PROXY, var7.method03917(), var5);
            }
         }
      });
   }

   public List<ProxyConfig> method05237() {
      return this.field11361;
   }

   public Set<String> method05238() {
      return this.field11362;
   }

   public String method05239() {
      return this.field11363;
   }

   public boolean method05240() {
      return this.field11364;
   }

   public boolean method05241() {
      return this.field11365;
   }

   public void method05242(String var1) {
      this.field11363 = var1;
   }

   public void method05243(boolean var1) {
      this.field11364 = var1;
   }
}
