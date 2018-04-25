package com.wufei.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wufei.model.User;
import com.wufei.service.UserService;

/*
 * 测试controller 
 */
public class TestUserController {

	private static Log log = LogFactory.getLog(TestUserController.class);
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
        UserService userService = (UserService)context.getBean("userService");
        
        User user = new User("xiaoming","222");
        try {
			userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
