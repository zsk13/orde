package com.wrpys.ssm.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.dao.FeastDao;
import com.wrpys.ssm.model.Feast;
import com.wrpys.ssm.service.FeastService;
import com.wrpys.ssm.utils.RandomString;

@Service
public class FeastServiceImpl implements FeastService{
  Log logger = LogFactory.getLog(FeastServiceImpl.class);

  @Autowired
  private FeastDao feastDao;

  public void findFeast(PageInfo pageInfo, Feast feast) {
    logger.info("findFeast pageInfo:" + JSON.toJSONString(pageInfo));
    Page<?> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
    pageInfo.setRows(feastDao.findFeast(feast));
    pageInfo.setTotal(page.getTotal());
  }

  public Feast createFeast(Feast feast) {
    String feastId = RandomString.getRandomString();
    feast.setFeastId(feastId);
    feastDao.createFeast(feast);
    return feast;
  }

  public void deleteFeast(Feast feast) {
    feastDao.deleteFeast(feast);
  }

  public void updateFeast(Feast feast) {
    feastDao.updateFeast(feast);
  }

  public Feast findFeastById(String feastId) {
    Feast feast = new Feast();
    feast.setFeastId(feastId);
    List<Feast> feasts = feastDao.findFeast(feast);
    if(feasts==null||feasts.size()==0){
      return null;
    }else{
      return feasts.get(0);
    }
  }
}
