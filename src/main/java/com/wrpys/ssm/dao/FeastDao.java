package com.wrpys.ssm.dao;

import java.util.List;

import com.wrpys.ssm.model.Feast;

public interface FeastDao {
  List<Feast> findFeast(Feast feast);
  
  void createFeast(Feast feast);
  
  void deleteFeast(Feast feast);
  
  void updateFeast(Feast feast);
}
