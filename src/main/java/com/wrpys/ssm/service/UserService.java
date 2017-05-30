package com.wrpys.ssm.service;  
  
import com.wrpys.ssm.common.PageInfo;  
import com.wrpys.ssm.model.User;  
  
import java.util.List;  
  
public interface UserService {  
  
    void findUser(PageInfo pageInfo, User user);  
  
    void createUser(User user);  
  
    void deleteUser(User user);  
  
    void batchDeleteUser(List<Integer> userIds);  
  
    void updateUser(User user);  
  
}  