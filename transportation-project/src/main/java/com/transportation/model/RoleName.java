package com.transportation.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
  USER, ADMIN, SUPER_ADMIN, DRIVER;

  @Override
  public String getAuthority() {
    return name();
  }
}
