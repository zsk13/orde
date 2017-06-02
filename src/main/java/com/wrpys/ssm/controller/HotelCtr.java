package com.wrpys.ssm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrpys.ssm.common.Constants;
import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.common.ResultBean;
import com.wrpys.ssm.model.Hotel;
import com.wrpys.ssm.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelCtr {

  Log logger = LogFactory.getLog(HotelCtr.class);

  @Autowired
  private HotelService hotelService;

  @RequestMapping(value = "list", method = {RequestMethod.GET})
  @ResponseBody
  public PageInfo findHotel(PageInfo pageInfo, Hotel hotel) {
    pageInfo = new PageInfo(pageInfo);
    hotelService.findHotel(pageInfo, hotel);
    return pageInfo;
  }
  
  @RequestMapping(method = {RequestMethod.GET})
  @ResponseBody
  public ResultBean findHotelById(@RequestParam(value = "hotelId")String hotelId) {
    ResultBean rb = new ResultBean();
    Hotel hotel = hotelService.findHotelById(hotelId);
    rb.setData(hotel);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }


  @RequestMapping(method = {RequestMethod.POST})
  @ResponseBody
  public ResultBean create(Hotel hotel) {
    ResultBean rb = new ResultBean();
    Hotel createdHotel = hotelService.createHotel(hotel);
    if(createdHotel==null){
      rb.setFlag(Constants.FAIL);
    }else{
      rb.setData(createdHotel);
      rb.setFlag(Constants.SUCCESS);
    }
    return rb;
  }

  @RequestMapping(method = {RequestMethod.DELETE})
  @ResponseBody
  public ResultBean delete(Hotel hotel) {
    ResultBean rb = new ResultBean();
    hotelService.deleteHotel(hotel);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(method = {RequestMethod.PUT})
  @ResponseBody
  public ResultBean update(Hotel hotel) {
    ResultBean rb = new ResultBean();
    hotelService.updateHotel(hotel);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

}
