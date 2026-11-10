// Original binary: sg/ec/GIduymlKL5bSqPKz
package sg.ec;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// $VF: Compiled from s
public final class OfflineAccountUtils {
   public static final OfflineAccountUtils field07854 = new OfflineAccountUtils();
   private final List<SocialS2CPacket.Nested57> field07855 = new CopyOnWriteArrayList<>();
   private final List<SocialS2CPacket.Nested57> field07856 = new CopyOnWriteArrayList<>();
   private static final String field07857 = "offline";
   private static final String field07858 = "Заявка принята";
   private static final String field07859 = "Заявка отклонена";
   private static final long field07860 = 3000L;

   public void method03524(List<SocialS2CPacket.Nested57> var1, List<SocialS2CPacket.Nested57> var2) {
      this.field07855.clear();
      if (var1 != null) {
         this.field07855.addAll(var1);
      }

      this.field07856.clear();
      if (var2 != null) {
         this.field07856.addAll(var2);
      }
   }

   public void method03526(String var1) {
      this.method03531(var1);
      GlobalRequestSender.method09378(var1x -> var1x.method01869(var1));
   }

   public void method03528(String var1) {
      this.method03534(var1);
      GlobalRequestSender.method09378(var1x -> var1x.method01801(var1));
      method03537(field07858);
   }

   public List<SocialS2CPacket.Nested57> method03529() {
      return this.field07856;
   }

   public void method03530(String var1) {
      this.method03534(var1);
      GlobalRequestSender.method09378(var1x -> var1x.method01809(var1));
      method03537(field07859);
   }

   private void method03531(String var1) {
      this.field07856.removeIf(var1x -> var1x.username().equalsIgnoreCase(var1));
   }

   public List<SocialS2CPacket.Nested57> method03532() {
      return this.field07855;
   }

   private void method03534(String var1) {
      this.field07855.removeIf(var1x -> var1x.username().equalsIgnoreCase(var1));
   }

   private OfflineAccountUtils() {
   }

   public void method03536(String var1) {
      String var2 = var1 == null ? "" : var1.trim();
      if (!var2.isEmpty()) {
         if (this.field07856.stream().noneMatch(var1x -> var1x.username().equalsIgnoreCase(var2))) {
            this.field07856.add(new SocialS2CPacket.Nested57(var2, false, null, field07857));
         }

         GlobalRequestSender.method09378(var1x -> var1x.method01874(var2));
         method03537("Заявка отправлена: " + var2);
      }
   }

   private static void method03537(String var0) {
      try {
         NotificationManager.method08597(var0, field07860, NotificationType.INFO);
      } catch (Throwable var2) {
      }
   }
}
