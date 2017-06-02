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
import com.wrpys.ssm.dao.HotelDao;
import com.wrpys.ssm.model.Hotel;
import com.wrpys.ssm.service.HotelService;
import com.wrpys.ssm.utils.RandomString;

@Service
public class HotelServiceImpl implements HotelService{
  Log logger = LogFactory.getLog(HotelServiceImpl.class);

  @Autowired
  private HotelDao hotelDao;

  public void findHotel(PageInfo pageInfo, Hotel hotel) {
    logger.info("findHotel pageInfo:" + JSON.toJSONString(pageInfo));
    Page<?> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
    pageInfo.setRows(hotelDao.findHotel(hotel));
    pageInfo.setTotal(page.getTotal());
  }

  public Hotel createHotel(Hotel hotel) {
    String hotelId = RandomString.getRandomString();
    hotel.setHotelId(hotelId);
    hotelDao.createHotel(hotel);
    return hotel;
  }

  public void deleteHotel(Hotel hotel) {
    hotelDao.deleteHotel(hotel);
  }

  public void updateHotel(Hotel hotel) {
    hotelDao.updateHotel(hotel);
  }

  public Hotel findHotelById(String hotelId) {
    Hotel hotel = new Hotel();
    hotel.setHotelId(hotelId);
    List<Hotel> hotels = hotelDao.findHotel(hotel);
    if(hotels==null||hotels.size()==0){
      return null;
    }else{
      return hotels.get(0);
    }
  }
}
