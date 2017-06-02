package com.wrpys.ssm.utils;

import java.util.UUID;

public class RandomString {
  public static String getRandomString(){
    String str = UUID.randomUUID().toString().replace("-", "");
    return str;
  }
}
