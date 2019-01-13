package org.singh.karanpreet.carauction.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.singh.karanpreet.carauction.domain.AppUserRepository;
import org.singh.karanpreet.carauction.model.AppUser;
import org.singh.karanpreet.carauction.service.AppUserService;
import org.springframework.stereotype.Service;

@Service("appUserService")
public class AppUserServiceImpl implements AppUserService {
  @Resource(name = "appUserRepository")
  private AppUserRepository appUserRepository;

  @Override
  public List<AppUser> getAppUsers() {
    return appUserRepository.findAll();
  }

  @Override
  public AppUser save(AppUser appUser) {
    return appUserRepository.save(appUser);
  }

  @Override
  public AppUser findById(Integer id) {
    return appUserRepository.findById(id);
  }

}
