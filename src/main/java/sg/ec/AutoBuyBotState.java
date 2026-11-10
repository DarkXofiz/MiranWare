// Original binary: sg/ec/2PyYNu76NH1l8ARq
package sg.ec;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.User;
import net.minecraft.core.UUIDUtil;

// $VF: Compiled from s
public final class AutoBuyBotState {
   private String field01015;
   private String field01016;
   private String field01017;
   private UUID field01018;
   private String field01019 = "";
   private AutoBuyBotStatus field01020 = AutoBuyBotStatus.AFK;
   private AutoBuyBotRole field01021 = AutoBuyBotRole.BUYER;
   private String field01022 = "";
   private int field01023 = RandomIdUtils.method04150();
   private int field01024 = -1;
   private final Set<Integer> field01025 = ConcurrentHashMap.newKeySet();
   private final String field01026;
   private static final String field01027 = "0";
   private static final String field01028 = "0";

   public void method00472(int var1) {
      this.field01025.remove(var1);
   }

   public void method00473(UUID var1) {
      this.field01018 = var1;
   }

   public boolean method00474(int var1) {
      return this.field01025.contains(var1);
   }

   public AutoBuyBotStatus method00475() {
      return this.field01020;
   }

   public static AutoBuyBotState method00476(User var0, String var1) {
      AutoBuyBotState var2 = new AutoBuyBotState(var0.getName(), var1, var0.getAccessToken());
      var2.method00473(var0.getProfileId());
      return var2;
   }

   public void method00477(String var1) {
      this.field01016 = var1;
   }

   public AutoBuyBotState(String var1, String var2, String var3) {
      this.field01015 = var1;
      this.field01016 = var2;
      this.field01017 = var3 == null ? "" : var3;
      this.field01026 = UUID.randomUUID().toString();
   }

   public void method00478(String var1) {
      this.field01017 = var1;
   }

   public String method00479() {
      return this.field01017;
   }

   public void method00480(AutoBuyBotRole var1) {
      this.field01021 = var1;
   }

   public UUID method00481() {
      return this.field01018;
   }

   public int method00482() {
      return this.field01024;
   }

   public void method00483(AutoBuyBotStatus var1) {
      this.field01020 = var1;
   }

   public User method00484() {
      return new User(this.field01015, this.method00494(), this.field01017.isEmpty() ? field01028 : this.field01017, Optional.empty(), Optional.empty());
   }

   public void method00485(String var1) {
      this.field01022 = var1;
   }

   public String method00486() {
      return this.field01016;
   }

   public int method00487() {
      return this.field01023;
   }

   public void method00488(int var1) {
      this.field01024 = var1 < 0 ? -1 : RandomIdUtils.method04147(var1);
   }

   public boolean method00489() {
      return !this.field01017.isEmpty() && !this.field01017.equals(field01027);
   }

   public String method00490() {
      return this.field01019;
   }

   public String method00491() {
      return this.field01015;
   }

   public String method00492() {
      return this.field01022;
   }

   public AutoBuyBotState(String var1, String var2) {
      this(var1, var2, "");
   }

   public void method00493(int var1) {
      this.field01023 = RandomIdUtils.method04147(var1);
   }

   public UUID method00494() {
      return this.field01018 != null ? this.field01018 : UUIDUtil.createOfflinePlayerUUID(this.field01015);
   }

   public void method00495(String var1) {
      this.field01019 = var1;
   }

   public void method00496(int var1) {
      if (var1 >= 0) {
         this.field01025.add(var1);
      }
   }

   public String method00497() {
      return this.field01026;
   }

   public AutoBuyBotRole method00498() {
      return this.field01021;
   }

   public void method00499(String var1) {
      this.field01015 = var1;
   }

   public Set<Integer> method00500() {
      return this.field01025;
   }
}
