// Original binary: hex/api/baritone/api/process/IExploreProcess
package hex.api.baritone.api.process;

import java.nio.file.Path;

// $VF: Compiled from s
public interface IExploreProcess extends IBaritoneProcess {
   void explore(int var1, int var2);

   void applyJsonFilter(Path var1, boolean var2) throws Exception;
}
