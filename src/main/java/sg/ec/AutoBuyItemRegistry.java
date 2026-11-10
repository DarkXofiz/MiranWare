// Original binary: sg/ec/vA07cQluX5ln4uSN
package sg.ec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.world.item.Item;

// $VF: Compiled from s
public enum AutoBuyItemRegistry {
   INSTANCE;

   private final Map<AutoBuyServer, List<AutoBuyItem>> field24632 = new EnumMap<>(AutoBuyServer.class);
   private final Map<AutoBuyServer, List<AutoBuyItem>> field24633 = new EnumMap<>(AutoBuyServer.class);
   private final Map<AutoBuyServer, Map<Item, List<AutoBuyItem>>> field24634 = new EnumMap<>(AutoBuyServer.class);
   private AutoBuyServer field24635 = AutoBuyServer.HOLY_WORLD;
   private int field24636;
   private int field24637 = -1;
   private boolean field24638;
   private boolean field24639;

   AutoBuyItemRegistry() {
      for (AutoBuyServer var6 : AutoBuyServer.values()) {
         ArrayList var7 = new ArrayList();
         this.field24632.put(var6, var7);
         this.field24633.put(var6, Collections.unmodifiableList(var7));
      }
   }

   public void method10986(Runnable var1, Runnable var2) {
      if (!this.field24638) {
         this.field24638 = true;
         var1.run();
         var2.run();
         this.field24639 = false;
      }
   }

   public List<AutoBuyItem> method10987(AutoBuyServer var1) {
      return this.field24633.get(Objects.requireNonNull(var1, "server"));
   }

   public List<AutoBuyItem> method10988() {
      return this.method10987(this.field24635);
   }

   public void method10989(AutoBuyServer var1) {
      if (var1 != null && var1 != this.field24635) {
         this.field24635 = var1;
         this.method10994();
      }
   }

   public boolean method10990(AutoBuyItem var1) {
      Objects.requireNonNull(var1, "entry");
      var var2 = this.field24632.get(var1.method10687());
      if (var2.contains(var1)) {
         return false;
      }

      var2.add(var1);
      this.method10996();
      return true;
   }

   public boolean method10991(AutoBuyItem var1) {
      if (var1 != null && this.field24632.get(var1.method10687()).remove(var1)) {
         this.method10996();
         return true;
      } else {
         return false;
      }
   }

   public AutoBuyItem method10992(AutoBuyServer var1, String var2) {
      for (AutoBuyItem var4 : this.field24632.get(var1)) {
         if (var4.method10691().equals(var2)) {
            return var4;
         }
      }

      return null;
   }

   public List<AutoBuyItem> method10993(AutoBuyServer var1, Item var2) {
      if (var2 == null) {
         return List.of();
      }

      this.method10997();
      var var3 = this.field24634.get(var1).get(var2);
      return var3 == null ? List.of() : var3;
   }

   public void method10994() {
      this.field24639 = true;
   }

   public boolean method10995() {
      boolean var1 = this.field24639;
      this.field24639 = false;
      return var1;
   }

   private void method10996() {
      this.field24636++;
      this.method10994();
   }

   private void method10997() {
      if (this.field24637 != this.field24636) {
         this.field24634.clear();

         for (AutoBuyServer var4 : AutoBuyServer.values()) {
            HashMap<Item, List<AutoBuyItem>> var5 = new HashMap<>();

            for (AutoBuyItem var7 : this.field24632.get(var4)) {
               var5.computeIfAbsent(var7.method10693(), var0 -> new ArrayList<>()).add(var7);

               for (Item var9 : var7.method10725()) {
                  var5.computeIfAbsent(var9, var0 -> new ArrayList<>()).add(var7);
               }
            }

            this.field24634.put(var4, var5);
         }

         this.field24637 = this.field24636;
      }
   }

   public AutoBuyServer method10998() {
      return this.field24635;
   }

   public int method10999() {
      return this.field24636;
   }
}
