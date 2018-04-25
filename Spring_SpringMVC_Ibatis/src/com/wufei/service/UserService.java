package com.wufei.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wufei.dao.UserDao;
import com.wufei.model.User;
import com.wufei.test.TestUserController;


@Component
@Transactional
public class UserService {

	@Resource(name="userDao")  // 通过名称注入到bean里面  
    private UserDao userDao;  
	private static Log log = LogFactory.getLog(UserService.class);
	
    public User login(User user) throws Exception{  
        return userDao.getUserByNameAndPassword(user);  
    }  
      
    public void addUser(User user) throws Exception{  
        userDao.addUser(user);
        log.info("已经成功加入一条记录,用户名userName=["+user.getUserName()+"]");
    }
	
    public void deleteUser(int id) throws Exception{  
        boolean bool = userDao.deleteUser(id);
        log.info("已经成功删除一条记录,用户id=["+id+"]");
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
        log.info("已经成功更新一条记录,用户名userName=[" + user.getUserName() + "]");
    }
}
