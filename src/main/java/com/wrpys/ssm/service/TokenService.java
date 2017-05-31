package com.wrpys.ssm.service;

import com.wrpys.ssm.model.Token;

public interface TokenService {

    public Token createToken(long userId);


    public boolean checkToken(Token model);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public Token getToken(String authentication);

    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public void deleteToken(long userId);

}
