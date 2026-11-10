// Original binary: sg/ec/Q0NaEAyt2D7MQTHa
package sg.ec;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// $VF: Compiled from s
record McpToolHandler(String name, String description, JsonObject inputSchema, McpToolHandler.Nested153 handler) {
   JsonObject describe() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("name", this.name);
      var1.addProperty("description", this.description);
      var1.add("inputSchema", this.inputSchema);
      return var1;
   }

   // $VF: Compiled from s
   interface Nested153 {
      JsonElement method05130(JsonObject var1) throws Exception;
   }

   // $VF: Compiled from s
   static final class Nested154 extends RuntimeException {
      Nested154(String var1) {
         super(var1);
      }
   }
}
