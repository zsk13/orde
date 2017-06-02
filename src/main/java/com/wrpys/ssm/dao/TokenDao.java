package com.wrpys.ssm.dao;

import com.wrpys.ssm.model.Token;

public interface TokenDao {
  Token findToken(Token token);
  
  void createToken(Token token);
  
  void deleteToken(Token token);
  
}
