package com.wrpys.ssm.dao;

import java.util.List;

import com.wrpys.ssm.model.Order;

public interface OrderDao {
  List<Order> findOrder(Order order);
  
  void createOrder(Order order);
  
  void deleteOrder(Order order);
  
  void updateOrder(Order order);
}
