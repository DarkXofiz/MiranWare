// Original binary: hex/api/baritone/BaritoneProvider
package hex.api.baritone;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.IBaritoneProvider;
import hex.api.baritone.api.cache.IWorldScanner;
import hex.api.baritone.api.command.ICommandSystem;
import hex.api.baritone.api.schematic.ISchematicSystem;
import hex.api.baritone.cache.FasterWorldScanner;
import hex.api.baritone.command.CommandSystem;
import hex.api.baritone.command.ExampleBaritoneControl;
import hex.api.baritone.utils.schematic.SchematicSystem;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.Minecraft;
import sg.ec.BotClient;

// $VF: Compiled from s
public final class BaritoneProvider implements IBaritoneProvider {
   private final List<IBaritone> all = new CopyOnWriteArrayList<>();
   private final List<IBaritone> allView = Collections.unmodifiableList(this.all);

   @Override
   public IBaritone getPrimaryBaritone() {
      return this.all.get(0);
   }

   @Override
   public ISchematicSystem getSchematicSystem() {
      return SchematicSystem.INSTANCE;
   }

   public synchronized IBaritone createBaritoneForBot(BotClient var1) {
      Baritone var2 = new Baritone(Minecraft.getInstance(), var1);
      this.all.add(var2);
      var2.registerBehavior(ExampleBaritoneControl::new);
      return var2;
   }

   @Override
   public synchronized boolean destroyBaritone(IBaritone var1) {
      return var1 != this.getPrimaryBaritone() && this.all.remove(var1);
   }

   public BaritoneProvider() {
      Baritone var1 = (Baritone)this.createBaritone(Minecraft.getInstance());
      var1.registerBehavior(ExampleBaritoneControl::new);
   }

   @Override
   public List<IBaritone> getAllBaritones() {
      return this.allView;
   }

   @Override
   public synchronized IBaritone createBaritone(Minecraft var1) {
      IBaritone var2 = this.getBaritoneForMinecraft(var1);
      if (var2 == null) {
         this.all.add(var2 = new Baritone(var1));
      }

      return var2;
   }

   @Override
   public IWorldScanner getWorldScanner() {
      return FasterWorldScanner.INSTANCE;
   }

   @Override
   public ICommandSystem getCommandSystem() {
      return CommandSystem.INSTANCE;
   }
}
