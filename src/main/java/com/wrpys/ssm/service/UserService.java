package com.wrpys.ssm.service;  
  
import java.util.List;

import com.wrpys.ssm.common.PageInfo;
import com.wrpys.ssm.model.Token;
import com.wrpys.ssm.model.User;  
  
public interface UserService {  
  
    void findUser(PageInfo pageInfo, User user);  
  
    void createUser(User user);  
  
    void deleteUser(User user);  
  
    void batchDeleteUser(List<Integer> userIds);  
  
    void updateUser(User user);  
    
    User findUserById(String userId);
    
    Token login(String userName, String password);
    
    
}  