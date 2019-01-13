package org.singh.karanpreet.carauction.domain;

import java.util.List;

import org.singh.karanpreet.carauction.model.Bid;
import org.springframework.data.repository.Repository;

public interface BidRepository extends Repository<Bid, Integer> {

  List<Bid> findByVehicleId(Integer vehicleId);

  List<Bid> findByUserId(Integer userId);

  Bid save(Bid bid);

  Bid findFirstByVehicleIdOrderByBidAmountDesc(int vehicleId);

}
