package com.wufei.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wufei.dao.UserDao;
import com.wufei.model.User;


@Component
@Transactional
public class UserService {

	@Resource(name="userDao")  // 通过名称注入到bean里面  
    private UserDao userDao;  
  				
    public User login(User user) throws Exception{  
        return userDao.getUserByNameAndPassword(user);  
    }  
      
    public void addUser(User user) throws Exception{  
        userDao.addUser(user);  
    }
	
    public void deleteUser(int id) throws Exception{  
        boolean bool = userDao.deleteUser(id);  
        if (!bool) {  
            System.out.println("删除的记录不存在！");  
            throw new RuntimeException();  
        }  
    }
    
    public User getUserById(int id) throws Exception{  
        User user = userDao.getUserById(id);  
        if (user == null) {  
            return null;  
        }  
        return userDao.getUserById(id);  
    }
    
    public void updateUser(User user) throws Exception{  
        userDao.updateUser(user);  
    }
}
