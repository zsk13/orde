package com.wrpys.ssm.model;

import java.util.Date;

public class Order {
  private String orderId;
  private String hotelId;
  private String userId;
  private Integer state;
  private Date orderTime;
  private Date feastTime;
  private String contactTel;
  private String contactName;
  private Integer num;
  private String contractPicUrl;
  private String payPicUrl;
  private String feastId;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getHotelId() {
    return hotelId;
  }

  public void setHotelId(String hotelId) {
    this.hotelId = hotelId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Date getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(Date orderTime) {
    this.orderTime = orderTime;
  }

  public Date getFeastTime() {
    return feastTime;
  }

  public void setFeastTime(Date feastTime) {
    this.feastTime = feastTime;
  }

  public String getContactTel() {
    return contactTel;
  }

  public void setContactTel(String contactTel) {
    this.contactTel = contactTel;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public String getContractPicUrl() {
    return contractPicUrl;
  }

  public void setContractPicUrl(String contractPicUrl) {
    this.contractPicUrl = contractPicUrl;
  }

  public String getPayPicUrl() {
    return payPicUrl;
  }

  public void setPayPicUrl(String payPicUrl) {
    this.payPicUrl = payPicUrl;
  }

  public String getFeastId() {
    return feastId;
  }

  public void setFeastId(String feastId) {
    this.feastId = feastId;
  }


}
