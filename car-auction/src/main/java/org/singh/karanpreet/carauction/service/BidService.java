package org.singh.karanpreet.carauction.service;

import java.util.List;

import org.singh.karanpreet.carauction.model.Bid;

public interface BidService {
  public abstract List<Bid> getAllBidsForVehicle(Integer vehicleId);

  public abstract Bid save(Bid bid);

  public abstract Bid getWinningBidForVehicle(int id);

  //  public abstract Bid findById(Integer id);

}
