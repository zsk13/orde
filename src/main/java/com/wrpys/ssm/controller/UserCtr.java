package com.wrpys.ssm.controller;

import com.wrpys.ssm.common.Constants;
import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.common.ResultBean;
import com.wrpys.ssm.model.User;
import com.wrpys.ssm.service.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserCtr {

  Log logger = LogFactory.getLog(UserCtr.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value = "list", method = {RequestMethod.GET})
  @ResponseBody
  public PageInfo findUser(PageInfo pageInfo, User user) {
    pageInfo = new PageInfo(pageInfo);
    userService.findUser(pageInfo, user);
    return pageInfo;
  }

  @RequestMapping(value = "", method = {RequestMethod.POST})
  @ResponseBody
  public ResultBean create(User user) {
    ResultBean rb = new ResultBean();
    userService.createUser(user);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public ResultBean add(User user) {
    ResultBean rb = new ResultBean();
    userService.createUser(user);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public ResultBean delete(User user) {
    ResultBean rb = new ResultBean();
    userService.deleteUser(user);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(value = "batchDeleteUser", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public ResultBean batchDeleteUser(@RequestParam(value = "userIds") List<Integer> userIds) {
    ResultBean rb = new ResultBean();
    userService.batchDeleteUser(userIds);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public ResultBean update(User user) {
    ResultBean rb = new ResultBean();
    userService.updateUser(user);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

}
