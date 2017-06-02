package com.wrpys.ssm.service;

import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.model.Hotel;

public interface HotelService {

  void findHotel(PageInfo pageInfo, Hotel hotel);  

  Hotel createHotel(Hotel hotel);  

  void deleteHotel(Hotel hotel);

  void updateHotel(Hotel hotel);  
  
  Hotel findHotelById(String hotelId);
}
