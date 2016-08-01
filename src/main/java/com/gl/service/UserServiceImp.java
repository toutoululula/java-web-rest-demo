package com.gl.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gl.dao.IUserDao;
import com.gl.domain.User;


@Service("userService")  
public class UserServiceImp implements IUserService {  
	 @Resource  
   private IUserDao userDao;
   private static Logger logger = Logger.getLogger(UserServiceImp.class);
   public User getUserById(int userId) {  
       // TODO Auto-generated method stub  
       return this.userDao.selectByPrimaryKey(userId);  
   }
   public List<User> getAll(int page,int rows,String orderBy) {
	// TODO Auto-generated method stub
	   PageHelper.startPage(page, rows,orderBy);
	   List<User> li = this.userDao.selectAll();
	   logger.debug("li拦截器启动后调用："+li);
	   return li;
   }
public List<User> getAll() {
	// TODO Auto-generated method stub
	List<User> li = this.userDao.selectAll();
	return li;
}  
}
