package org.singh.karanpreet.carauction.domain;

import java.util.List;

import org.singh.karanpreet.carauction.model.Vehicle;
import org.springframework.data.repository.Repository;

public interface VehicleRepository extends Repository<Vehicle, Integer> {
  List<Vehicle> findAll();

  Vehicle save(Vehicle vehicle);

  Vehicle findById(int id);
}
