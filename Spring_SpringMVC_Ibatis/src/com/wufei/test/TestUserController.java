package com.wufei.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wufei.model.User;
import com.wufei.service.UserService;

public class TestUserController {

	private static Log log = LogFactory.getLog(TestUserController.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
        UserService userService = (UserService)context.getBean("userService");
        
        User user = new User("wufei","123");
        try {
			userService.addUser(user);
			log.info("你已成功加入一条数据");
			System.out.println("你已成功加入一条数据");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
