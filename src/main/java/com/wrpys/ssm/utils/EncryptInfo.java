package com.wrpys.ssm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class EncryptInfo {
  static Log logger = LogFactory.getLog(EncryptInfo.class);

  public static String getEncrypyInfo(String pass) {
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      md5.update(pass.getBytes());
      String newPass = new BigInteger(1, md5.digest()).toString(16);
      return newPass;
    } catch (Exception e) {
      logger.error("MD5 error: pass to be encode: " + pass);
      return null;
    }
  }
}
