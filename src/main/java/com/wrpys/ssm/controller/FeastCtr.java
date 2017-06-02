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
import com.wrpys.ssm.model.Feast;
import com.wrpys.ssm.service.FeastService;

@Controller
@RequestMapping("/feast")
public class FeastCtr {

  Log logger = LogFactory.getLog(FeastCtr.class);

  @Autowired
  private FeastService feastService;

  @RequestMapping(value = "list", method = {RequestMethod.GET})
  @ResponseBody
  public PageInfo findFeast(PageInfo pageInfo, Feast feast) {
    pageInfo = new PageInfo(pageInfo);
    feastService.findFeast(pageInfo, feast);
    return pageInfo;
  }

  @RequestMapping(method = {RequestMethod.GET})
  @ResponseBody
  public ResultBean findFeastById(@RequestParam(value = "feastId") String feastId) {
    ResultBean rb = new ResultBean();
    Feast feast = feastService.findFeastById(feastId);
    if (feast == null) {
      rb.setFlag(Constants.FAIL);
    } else {
      rb.setData(feast);
      rb.setFlag(Constants.SUCCESS);
    }
    return rb;
  }


  @RequestMapping(method = {RequestMethod.POST})
  @ResponseBody
  public ResultBean create(Feast feast) {
    ResultBean rb = new ResultBean();
    feastService.createFeast(feast);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(method = {RequestMethod.DELETE})
  @ResponseBody
  public ResultBean delete(Feast feast) {
    ResultBean rb = new ResultBean();
    feastService.deleteFeast(feast);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(method = {RequestMethod.PUT})
  @ResponseBody
  public ResultBean update(Feast feast) {
    ResultBean rb = new ResultBean();
    feastService.updateFeast(feast);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

}
