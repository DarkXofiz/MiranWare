package ru.dreamix.protection.api.impl.profile.objects;

public enum RoleObject {
   DEFAULT, BETA, ADMIN;

   public boolean priorityHigherOrEquals(RoleObject other) {
      return this.ordinal() >= other.ordinal();
   }
}
