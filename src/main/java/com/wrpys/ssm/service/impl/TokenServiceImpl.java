package com.wrpys.ssm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrpys.ssm.common.Constants;
import com.wrpys.ssm.dao.TokenDao;
import com.wrpys.ssm.dao.UserDao;
import com.wrpys.ssm.model.Token;
import com.wrpys.ssm.service.TokenService;
import com.wrpys.ssm.utils.RandomString;

@Service
public class TokenServiceImpl implements TokenService{
  
  Log logger = LogFactory.getLog(TokenServiceImpl.class);
  @Autowired  
  private UserDao userDao;
  
  @Autowired  
  private TokenDao tokenDao;
  
//  @Autowired  
//  private TokenDao tokenDao;
  
  public Token createToken(String userId) {
    // 使用uuid作为源token
    String tokenStr = RandomString.getRandomString();
    
    long time = System.currentTimeMillis();
    long endTime = time + Constants.TOKEN_EXPIRES_TIME;
    Date date = new Date(endTime);
    Token token = new Token(userId, tokenStr, date);
    tokenDao.createToken(token);
    return token;
  }

  public Token getToken(String authentication) {
    if (authentication == null || authentication.length() == 0) {
      return null;
    }
    String[] param = authentication.split("_");
    if (param.length != 2) {
      logger.error("authentication split _ lengeh != 2 " + authentication);
      return null;
    }
    // 使用userId和源token简单拼接成的token，可以增加加密措施
    String userId = param[0];
    String token = param[1];
    return new Token(userId, token);
  }

  public boolean checkToken(Token token) {
    if (token == null) {
      return false;
    }else {
      Token storeToken = tokenDao.findToken(token);
      if(storeToken==null){
        return false;
      }else{
        Date endTime = storeToken.getEndTime();
        if(new Date().getTime()>endTime.getTime()){
          return false;
        }else{
          return true;
        }
      }
    }
  }

  public void deleteToken(String userId) {
    Token token = new Token(userId);
    tokenDao.deleteToken(token);
  }


}
