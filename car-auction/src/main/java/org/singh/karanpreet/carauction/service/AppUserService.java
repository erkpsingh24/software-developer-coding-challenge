package org.singh.karanpreet.carauction.service;

import java.util.List;

import org.singh.karanpreet.carauction.model.AppUser;

public interface AppUserService {
  public abstract List<AppUser> getAppUsers();

  public abstract AppUser save(AppUser appUser);

  public abstract AppUser findById(Integer id);

}
