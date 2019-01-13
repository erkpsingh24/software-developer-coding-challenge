package org.singh.karanpreet.carauction.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

import org.singh.karanpreet.carauction.model.AppUser;
import org.singh.karanpreet.carauction.service.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class AppUserController {

  @Resource(name = "appUserService")
  AppUserService appUserService;

  @GetMapping()
  public List<AppUser> getAppUsers() {
    return appUserService.getAppUsers();
  }

  @PostMapping()
  public Boolean addAppUser(@RequestBody AppUser user) {
    return !(appUserService.save(user) == null);
  }

  @GetMapping(value = "/{userId}")
  public AppUser getVehicleById(@PathVariable("userId") int id) {
    return appUserService.findById(id);
  }
}
