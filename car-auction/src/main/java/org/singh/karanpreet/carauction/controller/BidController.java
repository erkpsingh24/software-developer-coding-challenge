package org.singh.karanpreet.carauction.controller;

import javax.annotation.Resource;

import org.singh.karanpreet.carauction.service.BidService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class BidController {

  @Resource(name = "bidService")
  BidService bidService;
  //
  //  @PostMapping(value = "/{vehicleId}/bid")
  //  public Bid postBid(@RequestBody Bid bid) {
  //    return bidService.save(bid);
  //  }

}
