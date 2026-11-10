// Original binary: sg/ec/LIYdegn2M0CwSS6A
package sg.ec;

// $VF: Compiled from s
public class ItemPhysics extends ClientModule {
   private final NumberSetting<Float> field09882;
   private final ToggleSetting field09883;
   private static final String field09884 = "Скорость вращения";
   private static final float field09885 = 10.0F;
   private static final float field09886 = 0.1F;
   private static final String field09887 = "Старое вращение";
   private static final String field09888 = "Item Physics";
   private static final String field09889 = "Предметы лежат на земле и крутятся при падении.";

   public boolean method04425() {
      return this.field09883.method05999();
   }

   public ItemPhysics() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field09882 = new NumberSetting<Float>(field09884)
         .method10835(0.0F)
         .method10838(field09885)
         .method10834(field09886)
         .method03017(1.0F)
         .method03023(this);
      this.field09883 = new ToggleSetting(field09887).method03017(false).method03023(this);
      this.method03935(field09888);
      this.method03931(field09889);
   }

   public float method04426() {
      return this.field09882.method03022();
   }

   public static ItemPhysics method04427() {
      return ModuleManager.INSTANCE.method05142(ItemPhysics.class);
   }

   public static boolean method04428() {
      ItemPhysics var0 = method04427();
      return var0 != null && var0.method03937();
   }
}
