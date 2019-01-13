package org.singh.karanpreet.carauction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Bid {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_seq")
  int id;
  Date bidTime;

  @NotNull
  Double bidAmount;

  @ManyToOne
  @NotNull
  Vehicle vehicle;

  @ManyToOne
  @NotNull
  AppUser user;

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public AppUser getUser() {
    return user;
  }

  public void setUser(AppUser user) {
    this.user = user;
  }

  public Date getBidTime() {
    return bidTime;
  }

  public void setBidTime(Date bidTime) {
    this.bidTime = bidTime;
  }

  public Double getBidAmount() {
    return bidAmount;
  }

  public void setBidAmount(Double bidAmount) {
    this.bidAmount = bidAmount;
  }
}
