package com.wrpys.ssm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrpys.ssm.annotation.Authorization;
import com.wrpys.ssm.annotation.CurrentUser;
import com.wrpys.ssm.common.Constants;
import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.common.ResultBean;
import com.wrpys.ssm.model.Order;
import com.wrpys.ssm.model.User;
import com.wrpys.ssm.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderCtr {

  Log logger = LogFactory.getLog(OrderCtr.class);

  @Autowired
  private OrderService orderService;

  @RequestMapping(value = "list", method = {RequestMethod.GET})
  @ResponseBody
  public PageInfo findOrder(PageInfo pageInfo, Order order) {
    pageInfo = new PageInfo(pageInfo);
    orderService.findOrder(pageInfo, order);
    return pageInfo;
  }
  
  @RequestMapping(method = {RequestMethod.GET})
  @ResponseBody
  public ResultBean findOrderById(@RequestParam(value = "orderId")String orderId) {
    ResultBean rb = new ResultBean();
    Order order = orderService.findOrderById(orderId);
    rb.setData(order);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }


  @RequestMapping(method = {RequestMethod.POST})
  @ResponseBody
  @Authorization
  public ResultBean create(@CurrentUser User user, Order order) {
    ResultBean rb = new ResultBean();
    
    Order createdOrder = orderService.createOrder(user, order);
    if(createdOrder==null){
      rb.setFlag(Constants.FAIL);
    }else{
      rb.setData(createdOrder);
      rb.setFlag(Constants.SUCCESS);
    }
    return rb;
  }

  @RequestMapping(method = {RequestMethod.DELETE})
  @ResponseBody
  public ResultBean delete(Order order) {
    ResultBean rb = new ResultBean();
    orderService.deleteOrder(order);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(method = {RequestMethod.PUT})
  @ResponseBody
  public ResultBean update(Order order) {
    ResultBean rb = new ResultBean();
    orderService.updateOrder(order);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

}
