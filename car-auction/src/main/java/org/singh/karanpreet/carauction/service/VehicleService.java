package org.singh.karanpreet.carauction.service;

import java.util.List;

import org.singh.karanpreet.carauction.model.Vehicle;

public interface VehicleService {

  public abstract List<Vehicle> getVehicles();

  public abstract Vehicle save(Vehicle vehicle);

  public abstract Vehicle findById(int id);
}
