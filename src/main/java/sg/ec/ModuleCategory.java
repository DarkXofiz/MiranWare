// Original binary: sg/ec/1Zi6g61ag2FTahGD
package sg.ec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// $VF: Compiled from s
public enum ModuleCategory {
   Combat("8", ModuleSubCategory.Combat, ModuleSubCategory.Utility, ModuleSubCategory.Other),
   Movement("1", ModuleSubCategory.Main, ModuleSubCategory.Other),
   Player("6", ModuleSubCategory.Main, ModuleSubCategory.Other),
   Render("4", ModuleSubCategory.World, ModuleSubCategory.Interface, ModuleSubCategory.Other),
   Misc("3", ModuleSubCategory.Servers, ModuleSubCategory.Utility, ModuleSubCategory.Other),
   Scripts("X", ModuleSubCategory.Main),
   AutoBuy("D"),
   Friends("7"),
   Configs("2"),
   Bots("K"),
   Themes("O");

   private final List<ModuleSubCategory> field00680 = new ArrayList<>();
   private final String field00681;

   ModuleCategory(String var3, ModuleSubCategory... var4) {
      this.field00681 = var3;
      this.field00680.addAll(Arrays.asList(var4));
   }

   public boolean method00304() {
      return !this.field00680.isEmpty();
   }

   public boolean method00305() {
      return this.method00304() || this == Configs;
   }

   public List<ModuleSubCategory> method00306() {
      return this.field00680;
   }

   public String method00307() {
      return this.field00681;
   }
}
