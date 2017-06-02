package com.wrpys.ssm.service;

import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.model.Feast;

public interface FeastService {

  void findFeast(PageInfo pageInfo, Feast feast);  

  Feast createFeast(Feast feast);  

  void deleteFeast(Feast feast);  

  void updateFeast(Feast feast);  
  
  Feast findFeastById(String feastId);
}
