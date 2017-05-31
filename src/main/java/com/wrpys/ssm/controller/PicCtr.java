package com.wrpys.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
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
  public void valicode(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String path = request.getSession().getServletContext().getRealPath("/");
    path = path.substring(0, path.lastIndexOf("/"));
    logger.error("file path:  " + path);
    File filePic = new File(path + "pic/test.png");
    if (!filePic.exists()) {
      filePic.createNewFile();
    }
    logger.info("file path:  " + filePic.getAbsolutePath());
    logger.error("file path:  " + filePic.getAbsolutePath());
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
