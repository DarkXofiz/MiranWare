package ru.dreamix.protection.api.impl.profile;

import ru.dreamix.protection.api.impl.profile.objects.RoleObject;

public final class ProfileAPI {
   private static ProfileAPI instance;
   private final Model model;

   private ProfileAPI(Model model) {
      this.model = model;
   }

   public static void create(String name, int userIdentifier, RoleObject role) {
      instance = new ProfileAPI(new Model(name, userIdentifier, role));
   }

   public static ProfileAPI get() {
      return instance;
   }

   public Model getModel() {
      return this.model;
   }

   public record Model(String name, int userIdentifier, RoleObject role) {
      public String getName() {
         return this.name;
      }

      public int getUserIdentifier() {
         return this.userIdentifier;
      }

      public RoleObject getRole() {
         return this.role;
      }
   }
}
