package com.wrpys.ssm.service;

import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.model.Order;
import com.wrpys.ssm.model.User;

public interface OrderService {

  void findOrder(PageInfo pageInfo, Order order);  

  Order createOrder(User user, Order order);  

  void deleteOrder(Order order);  

  void updateOrder(Order order);  
  
  Order findOrderById(String orderId);
}
