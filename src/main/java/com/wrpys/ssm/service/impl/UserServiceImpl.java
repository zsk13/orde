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
import com.wrpys.ssm.dao.UserDao;
import com.wrpys.ssm.model.Token;
import com.wrpys.ssm.model.User;
import com.wrpys.ssm.service.TokenService;
import com.wrpys.ssm.service.UserService;
import com.wrpys.ssm.utils.EncryptInfo;

@Service
public class UserServiceImpl implements UserService {

  Log logger = LogFactory.getLog(UserServiceImpl.class);

  @Autowired
  private UserDao userDao;

  @Autowired
  private TokenService tokenService;

  public void findUser(PageInfo pageInfo, User user) {
    logger.info("findUser pageInfo:" + JSON.toJSONString(pageInfo));
    Page<?> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
    pageInfo.setRows(userDao.findUserByParams(user));
    pageInfo.setTotal(page.getTotal());
  }

  public void createUser(User user) {
    user.setPassword(EncryptInfo.getEncrypyInfo(user.getPassword()));
    userDao.createUser(user);
  }

  public void deleteUser(User user) {
    userDao.deleteUser(user);
  }

  public void batchDeleteUser(List<Integer> userIds) {
    userDao.batchDeleteUser(userIds);
  }

  public void updateUser(User user) {
    userDao.updateUser(user);
  }

  public Token login(String userId, String password) {
    User user = userDao.findUserByUserId(userId);
    if (user == null) {
      return null;
    } else {
      String newPass = EncryptInfo.getEncrypyInfo(password);
      if (newPass.equals(user.getPassword())) {
        Token token = tokenService.createToken(user.getUserId());
        //返回给客户端的token是userId和token拼接而成
        token.setToken(userId+"_"+token.getToken());
        return token;
      } else {
        return null;
      }
    }
  }

  public User findUserById(String userId) {
    User user = userDao.findUserByUserId(userId);
    return user;
  }

}
