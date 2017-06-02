package com.wrpys.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrpys.ssm.annotation.Authorization;
import com.wrpys.ssm.annotation.CurrentUser;
import com.wrpys.ssm.common.Constants;
import com.wrpys.ssm.common.ResultBean;
import com.wrpys.ssm.model.Token;
import com.wrpys.ssm.model.User;
import com.wrpys.ssm.service.TokenService;
import com.wrpys.ssm.service.UserService;

@Controller
@RequestMapping("/auth")
public class TokenCtr {
  @Autowired
  private TokenService tokenService;

  @Autowired
  private UserService userService;

  @RequestMapping(value = "login", method = {RequestMethod.POST})
  @ResponseBody
  public ResultBean login(@RequestParam String userId, @RequestParam String password) {
    Token token = userService.login(userId, password);
    ResultBean bean = new ResultBean();
    if(token == null){
      bean.setFlag(Constants.FAIL);
      bean.setMsg("login fail");
    }else{
      bean.setFlag(Constants.SUCCESS);
      bean.setData(token);
    }
    return bean;
  }

  @RequestMapping(value = "logout", method = RequestMethod.POST)
  @Authorization
  @ResponseBody
  public ResultBean logout(@CurrentUser User user) {
    ResultBean result = new ResultBean();
    if (user == null) {
      result.setFlag(Constants.FAIL);
    } else {
      tokenService.deleteToken(user.getUserId());
      result.setFlag(Constants.SUCCESS);
    }
    return result;
  }
}
