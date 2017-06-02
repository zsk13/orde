package com.wrpys.ssm.dao;

import java.util.List;

import com.wrpys.ssm.model.Hotel;

public interface HotelDao {
  List<Hotel> findHotel(Hotel hotel);
  
  void createHotel(Hotel hotel);
  
  void deleteHotel(Hotel hotel);
  
  void updateHotel(Hotel hotel);
}
