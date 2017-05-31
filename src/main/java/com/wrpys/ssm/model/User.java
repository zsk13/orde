package com.wrpys.ssm.model;

import com.alibaba.fastjson.annotation.JSONField;

public class User {  
  
    private Integer userId;  
  
    private String userName;  
    
    @JSONField(serialize=false) 
    private Integer age;  
  
    public Integer getUserId() {  
        return userId;  
    }  
  
    public void setUserId(Integer userId) {  
        this.userId = userId;  
    }  
  
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
    public Integer getAge() {  
        return age;  
    }  
  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
}  