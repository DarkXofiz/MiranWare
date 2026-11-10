// Original binary: sg/ec/S3DMYPJZn6VKQhGc
package sg.ec;

import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class WayPoints extends ClientModule {
   private final KeyBindSetting field11725;
   private final ModeSetting field11726;
   private static final String field11727 = "Поставить метку";
   private static final String field11728 = "Ставить метку";
   private static final String field11729 = "Своя позиция";
   private static final String field11730 = "Прицел";
   private static final String field11731 = "Прицел";
   private static final String field11732 = "Way Points";
   private static final String field11733 = "Своя позиция";
   private static final String field11734 = "Прицел";
   private static final double field11735 = 100.0;

   public WayPoints() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field11725 = new KeyBindSetting(field11727).method03017(new KeyBinding()).method03023(this);
      this.field11726 = new ModeSetting(field11728).method05597(field11729, field11730).method03017(field11731).method03023(this);
      this.method03935(field11732);
   }

   @Subscribe
   private void method05394(MouseButtonEvent var1) {
      if (var1.method06919() != InputAction.RELEASE) {
         if (this.field11725.method03022().method05871() == var1.method06914()) {
            this.method05395();
         }
      }
   }

   private void method05395() {
      if (mc.player != null) {
         float var1 = 0.0F;
         float var2 = 0.0F;
         float var3 = 0.0F;
         switch ((String)this.field11726.method03022()) {
            case field11733:
               var1 = (float)mc.player.getX();
               var2 = (float)mc.player.getY();
               var3 = (float)mc.player.getZ();
               break;
            case field11734:
               Vec3 var6 = RaycastUtils.method09508(FreeLookController.method10131(), FreeLookController.method10134(), field11735);
               var1 = (float)var6.x();
               var2 = (float)var6.y();
               var3 = (float)var6.z();
         }

         GlobalWebSocketClient var9 = MiranWare.getInstance().getClient();
         if (var9 != null) {
            Party var10 = var9.getManager().method01805();
            if (var10 != null) {
               PartyMember var7 = var10.method10151(var1x -> var1x.method07566(var9.getClientPlayer()));
               if (var7 != null) {
                  MutableVector3f var8 = new MutableVector3f(var1, var2, var3);
                  var9.getManager().method01823(new WaypointSendC2SPacket(var7, var10, var8));
               }
            }
         }
      }
   }

   @Subscribe
   private void method05396(KeyInputEvent var1) {
      if (var1.method05884() != InputAction.RELEASE) {
         if (this.field11725.method03022().method05871() == var1.method05887()) {
            this.method05395();
         }
      }
   }
}
