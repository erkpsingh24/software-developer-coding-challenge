package org.singh.karanpreet.carauction.model.dto;

public class BidClient {

  Double bidAmount;
  int userId;

  public Double getBidAmount() {
    return bidAmount;
  }

  public void setBidAmount(Double bidAmount) {
    this.bidAmount = bidAmount;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public BidClient(Double bidAmount, int userId) {
    super();
    this.bidAmount = bidAmount;
    this.userId = userId;
  }

  public BidClient() {
    super();
    // TODO Auto-generated constructor stub
  }
}
