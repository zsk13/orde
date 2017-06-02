package com.wrpys.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wrpys.ssm.common.Constants;
import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.dao.OrderDao;
import com.wrpys.ssm.model.Feast;
import com.wrpys.ssm.model.Order;
import com.wrpys.ssm.model.User;
import com.wrpys.ssm.service.FeastService;
import com.wrpys.ssm.service.OrderService;
import com.wrpys.ssm.utils.RandomString;


@Service
public class OrderServiceImpl implements OrderService {
  Log logger = LogFactory.getLog(OrderServiceImpl.class);

  @Autowired
  private OrderDao orderDao;

  @Autowired
  private FeastService feastService;


  public void findOrder(PageInfo pageInfo, Order order) {
    logger.info("findOrder pageInfo:" + JSON.toJSONString(pageInfo));
    Page<?> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
    pageInfo.setRows(orderDao.findOrder(order));
    pageInfo.setTotal(page.getTotal());
  }

  public Order createOrder(User user, Order order) {
    String orderId = RandomString.getRandomString();
    order.setOrderId(orderId);
    String hotelId = order.getHotelId();
    if (hotelId == null || hotelId.equals("")) {
      Feast feast = feastService.findFeastById(order.getFeastId());
      if (feast == null) {
        //TODO
        return null;
      } else {
        hotelId = feast.getHotelId();
        order.setHotelId(hotelId);
      }
    }
    if (user == null) {
      //TODO
      return null;
    } else {
      order.setUserId(user.getUserId());
    }
    order.setState(Constants.RESERVESTATE);
    order.setOrderTime(new Date());

    orderDao.createOrder(order);
    return order;
  }

  public void deleteOrder(Order order) {
    orderDao.deleteOrder(order);
  }

  public void updateOrder(Order order) {
    orderDao.updateOrder(order);
  }

  public Order findOrderById(String orderId) {
    Order order = new Order();
    order.setOrderId(orderId);
    List<Order> orders = orderDao.findOrder(order);
    if (orders == null || orders.size() == 0) {
      return null;
    } else {
      return orders.get(0);
    }
  }
}
