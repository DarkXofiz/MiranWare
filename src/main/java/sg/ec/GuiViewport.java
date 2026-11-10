// Original binary: sg/ec/MJ3z2ntZtxRyhcMU
package sg.ec;

// $VF: Compiled from s
public interface GuiViewport {
   GuiViewport field10077 = new GuiViewport()   // $VF: Compiled from s
 {
      @Override
      public float method04537() {
         return DragManager.INSTANCE.method05205(MinecraftAccess.mc.getWindow());
      }

      @Override
      public float method04535() {
         return DragManager.INSTANCE.method05204(MinecraftAccess.mc.getWindow());
      }

      @Override
      public float method04536() {
         return 1.0F;
      }
   };
   GuiViewport field10078 = new GuiViewport()   // $VF: Compiled from s
 {
      @Override
      public float method04536() {
         return 1.0F;
      }

      @Override
      public float method04537() {
         return MinecraftAccess.mc.getWindow() == null ? 0.0F : GuiScaleUtils.method06754();
      }

      @Override
      public float method04535() {
         return MinecraftAccess.mc.getWindow() == null ? 0.0F : GuiScaleUtils.method06753();
      }
   };

   float method04535();

   float method04536();

   float method04537();
}
