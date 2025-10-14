package com.koo.emotion_diary.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
  private UserDTO user;

  public CustomUserDetails(UserDTO user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // Collection<GrantedAuthority> collection = new ArrayList<>();

    // collection.add(new GrantedAuthority() {

    // @Override
    // public String getAuthority() {
    // return user.getRole();
    // }

    // });
    // return collection;
    return null;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getId();
  }

}
