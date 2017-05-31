package com.wrpys.ssm.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "pic")
public class PicCtr {
  Log logger = LogFactory.getLog(PicCtr.class);
  @RequestMapping("/hotel1")
  public void valicode(HttpServletResponse response) throws Exception {
    String classpath = Thread.currentThread().getContextClassLoader().getResource("").toString();
    logger.info("classpath: "+classpath);
//    String resourcepath = classpath.replace("/classes/", "/resources/");
//    File resources = new File(resourcepath);
//    if(!resources.exists()){
//      boolean succ = resources.mkdirs();
//    }
    String resourcepath = classpath+"resources/";
    File filePic = new File(resourcepath+"test.png");

    filePic.createNewFile();
    if (filePic.exists()) {
      FileInputStream is = new FileInputStream(filePic);
      int i = is.available(); // 得到文件大小
      byte data[] = new byte[i];
      is.read(data); // 读数据
      is.close();
      response.setContentType("image/png"); // 设置返回的文件类型
      OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
      toClient.write(data); // 输出数据
      toClient.close();
    }
  }
}
