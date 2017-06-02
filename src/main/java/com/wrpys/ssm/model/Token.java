package com.wrpys.ssm.model;

import java.util.Date;

public class Token {

  private String userId;

  private String token;

  private Date endTime;

  public Token() {

  }

  public Token(String userId) {
    this(userId, null);
  }

  public Token(String userId, String token) {
    this(userId, token, null);
  }

  public Token(String userId, String token, Date endTime) {
    this.userId = userId;
    this.token = token;
    this.endTime = endTime;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

}
