package org.singh.karanpreet.carauction.domain;

import java.util.List;

import org.singh.karanpreet.carauction.model.AppUser;
import org.springframework.data.repository.Repository;

public interface AppUserRepository extends Repository<AppUser, Integer> {
  List<AppUser> findAll();

  AppUser save(AppUser vehicle);

  AppUser findById(int id);
}
