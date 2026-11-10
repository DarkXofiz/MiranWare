// Original binary: hex/dscRPC/event/model/ReadyEvent
package hex.dscRPC.event.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// $VF: Compiled from s
public class ReadyEvent implements Event {
   @JsonProperty("v")
   private final int version;
   @JsonProperty("config")
   private final ReadyEvent.Configuration configuration;

   public int version() {
      return this.version;
   }

   @JsonCreator
   public ReadyEvent(@JsonProperty("v") int var1, @JsonProperty("config") ReadyEvent.Configuration var2) {
      this.version = var1;
      this.configuration = var2;
   }

   public ReadyEvent.Configuration configuration() {
      return this.configuration;
   }

   @Override
   public String toString() {
      return "ReadyEvent { version = " + this.version + ", configuration = " + this.configuration + " }";
   }

   // $VF: Compiled from s
   public static class Configuration {
      @JsonProperty("cdn_host")
      private final String contentDeliveryNetworkHost;
      @JsonProperty("api_endpoint")
      private final String apiEndpoint;
      @JsonProperty("environment")
      private final String environment;

      public String environment() {
         return this.environment;
      }

      @JsonCreator
      public Configuration(@JsonProperty("cdn_host") String var1, @JsonProperty("api_endpoint") String var2, @JsonProperty("environment") String var3) {
         this.contentDeliveryNetworkHost = var1;
         this.apiEndpoint = var2;
         this.environment = var3;
      }

      public String apiEndpoint() {
         return this.apiEndpoint;
      }

      @Override
      public String toString() {
         return "Configuration { contentDeliveryNetworkHost = \""
            + this.contentDeliveryNetworkHost
            + "\", apiEndpoint = \""
            + this.apiEndpoint
            + "\", environment = \""
            + this.environment
            + "\" }";
      }

      public String contentDeliveryNetworkHost() {
         return this.contentDeliveryNetworkHost;
      }
   }
}
