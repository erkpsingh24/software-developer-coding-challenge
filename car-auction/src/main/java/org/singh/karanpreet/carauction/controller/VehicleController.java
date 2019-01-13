package org.singh.karanpreet.carauction.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.singh.karanpreet.carauction.model.Bid;
import org.singh.karanpreet.carauction.model.Vehicle;
import org.singh.karanpreet.carauction.model.dto.BidClient;
import org.singh.karanpreet.carauction.service.AppUserService;
import org.singh.karanpreet.carauction.service.BidService;
import org.singh.karanpreet.carauction.service.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

  @Resource(name = "vehicleService")
  VehicleService vehicleService;

  @Resource(name = "bidService")
  BidService bidService;

  @Resource(name = "appUserService")
  AppUserService appUserService;

  @GetMapping()
  public List<Vehicle> getVehicles() {
    return vehicleService.getVehicles();
  }

  @PostMapping()
  public Boolean addVehicle(@RequestBody Vehicle vehicle) {
    return !(vehicleService.save(vehicle) == null);
  }

  @GetMapping(value = "/{vehicleId}")
  public Vehicle getVehicleById(@PathVariable("vehicleId") int id) {
    return vehicleService.findById(id);
  }

  @PostMapping(value = "/{vehicleId}/bid")
  public Bid postBid(@PathVariable("vehicleId") int id, @RequestBody BidClient bidClient) {
    Bid bid = new Bid();
    bid.setUser(appUserService.findById(bidClient.getUserId()));
    bid.setBidAmount(bidClient.getBidAmount());
    bid.setVehicle(getVehicleById(id));
    bid.setBidTime(new Date());
    return bidService.save(bid);
  }

  @GetMapping(value = "/{vehicleId}/bids")
  public List<Bid> getAllBids(@PathVariable("vehicleId") int id) {
    return bidService.getAllBidsForVehicle(id);
  }

  @GetMapping(value = "/{vehicleId}/winningbid")
  public Bid getWinningBid(@PathVariable("vehicleId") int id) {
    return bidService.getWinningBidForVehicle(id);
  }
}
