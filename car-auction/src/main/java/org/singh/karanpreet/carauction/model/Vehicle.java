package org.singh.karanpreet.carauction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle implements Auctionable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
  int id;

  String type;

  String name;

  public Vehicle(int id, String type, String name) {
    super();
    this.id = id;
    this.type = type;
    this.name = name;
  }

  public Vehicle() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
