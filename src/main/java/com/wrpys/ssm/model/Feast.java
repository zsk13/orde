package com.wrpys.ssm.model;

public class Feast {
  private String feastId;
  private String feastName;
  private String feastMenu;
  private String introduction;
  private Double price;
  private String hotelId;

  public String getFeastId() {
    return feastId;
  }

  public void setFeastId(String feastId) {
    this.feastId = feastId;
  }

  public String getFeastName() {
    return feastName;
  }

  public void setFeastName(String feastName) {
    this.feastName = feastName;
  }

  public String getFeastMenu() {
    return feastMenu;
  }

  public void setFeastMenu(String feastMenu) {
    this.feastMenu = feastMenu;
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getHotelId() {
    return hotelId;
  }

  public void setHotelId(String hotelId) {
    this.hotelId = hotelId;
  }

}
