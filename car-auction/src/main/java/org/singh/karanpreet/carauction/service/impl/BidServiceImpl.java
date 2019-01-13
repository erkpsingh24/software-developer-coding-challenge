package org.singh.karanpreet.carauction.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.singh.karanpreet.carauction.domain.BidRepository;
import org.singh.karanpreet.carauction.model.Bid;
import org.singh.karanpreet.carauction.service.BidService;
import org.springframework.stereotype.Service;

@Service("bidService")
public class BidServiceImpl implements BidService {
  @Resource(name = "bidRepository")
  private BidRepository bidRepository;

  @Override
  public List<Bid> getAllBidsForVehicle(Integer vehicleId) {
    return bidRepository.findByVehicleId(vehicleId);
  }

  @Override
  public Bid save(Bid bid) {
    return bidRepository.save(bid);
  }

  @Override
  public Bid getWinningBidForVehicle(int id) {
    return bidRepository.findFirstByVehicleIdOrderByBidAmountDesc(id);
  }

  //  @Override
  //  public Bid findById(Integer id) {
  //    // TODO Auto-generated method stub
  //    return null;
  //  }

}
