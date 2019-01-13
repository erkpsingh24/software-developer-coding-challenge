package org.singh.karanpreet.carauction.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.singh.karanpreet.carauction.model.Vehicle;
import org.singh.karanpreet.carauction.domain.VehicleRepository;
import org.singh.karanpreet.carauction.service.VehicleService;
import org.springframework.stereotype.Service;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {
  @Resource(name = "vehicleRepository")
  private VehicleRepository vehicleRepository;

  @Override
  public List<Vehicle> getVehicles() {
    return vehicleRepository.findAll();
  }

  @Override
  public Vehicle save(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  @Override
  public Vehicle findById(int id) {
    return vehicleRepository.findById(id);
  }

}
