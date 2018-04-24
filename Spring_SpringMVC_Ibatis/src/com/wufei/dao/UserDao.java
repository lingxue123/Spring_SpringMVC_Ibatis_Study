package com.wufei.dao;

import org.springframework.stereotype.Component;

import com.wufei.model.User;

@Component("userDao")
public class UserDao extends BaseDao {

	public boolean addUser(User user) throws Exception {
		User bean = (User) getSqlMapClientTemplate().insert("insertUser", user);
		return bean != null ? true : false;
	}

	public boolean deleteUser(int id) throws Exception {
		int result = getSqlMapClientTemplate().delete("deleteUser", id);
		return result > 0 ? true : false;
	}

	public boolean updateUser(User user) throws Exception {
		int result = getSqlMapClientTemplate().update("updateUser", user);
		return result > 0 ? true : false;
	}
	
	public User getUserById(int id) throws Exception{  
        return (User)getSqlMapClientTemplate().queryForObject("findUserByID", id);  
    }
	
	public User getUserByNameAndPassword(User user) throws Exception{  
        return (User)getSqlMapClientTemplate().queryForObject("findUserByNameAndPassword", user);  
    }
}
