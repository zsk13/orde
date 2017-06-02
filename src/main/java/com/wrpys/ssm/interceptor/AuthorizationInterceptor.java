package com.wrpys.ssm.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wrpys.ssm.annotation.Authorization;
import com.wrpys.ssm.common.Constants;
import com.wrpys.ssm.model.Token;
import com.wrpys.ssm.service.TokenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，判断此次请求是否有权限
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  private TokenService service;

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 如果不是映射到方法直接通过
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();

    if (method.getAnnotation(Authorization.class) == null) {
      return true;
    }

    // 从header中得到token
    String authorization = request.getHeader(Constants.AUTHORIZATION);
    // 验证token
    Token model = service.getToken(authorization);
    if (service.checkToken(model)) {
      // 如果token验证成功，将token对应的用户id存在request中，便于之后注入
      request.setAttribute(Constants.CURRENT_USER_ID, model.getUserId());
      return true;
    } else {

      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return false;
    }
  }
}
