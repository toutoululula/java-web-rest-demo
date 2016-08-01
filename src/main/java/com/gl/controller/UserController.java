package com.gl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.gl.domain.LoginModel;
import com.gl.domain.User;
import com.gl.page.Page;
import com.gl.page.PageList;
import com.gl.service.IUserService;


@Controller  
@RequestMapping("/user")  
public class UserController {  
   @Resource  
   private IUserService userService;
   @Autowired  
   @Qualifier(value="loginModel")
   private LoginModel loginModel;
   @Autowired  
   @Qualifier(value="PageList")
   private PageList pageList;
   private static Logger logger = Logger.getLogger(UserController.class);  
   /*@RequestMapping("/showUser")  
   public String toIndex(HttpServletRequest request,Model model){  
       int userId = Integer.parseInt(request.getParameter("id"));  
       User user = this.userService.getUserById(userId);  
       model.addAttribute("user", user); 
       logger.debug("userId");
       return "showUser";  
   }  */
   @RequestMapping(value="/showUser/{id:\\d+}",method=RequestMethod.GET)  
   public @ResponseBody User getUserById(@PathVariable("id") int id){  
       User user = this.userService.getUserById(id);  
       logger.debug(id);
       return user;  
   }  
   @RequestMapping(value="/showUser",method=RequestMethod.GET)  
   public @ResponseBody Page getAllUser(@RequestParam(value="sort",required = false)String sort ,@RequestParam("order")String order
		   ,@RequestParam("offset")int offset,@RequestParam("limit")int limit) {
	   String str=null;
	   if(null!=sort)str=sort+" "+order;
       List<User> users = this.userService.getAll(offset,limit,str);
       long total_number=new PageInfo<User>(users).getTotal();
       logger.debug("pageInfo"+total_number);
       logger.debug(users);
       logger.debug("hahahaha:"+order);
       return pageList.getPageList(users,total_number);
   }
   @RequestMapping(value="/doLogin",method=RequestMethod.POST)  
   public @ResponseBody LoginModel doLogin(@RequestBody User req_user){  
       List<User> users = this.userService.getAll(); 
       int users_size=users.size();
       boolean hasUser=false;
       if(users_size>0){
    	   for(User user:users){
    		   if(req_user.getUserName().equals(user.getUserName())){
    			 hasUser=true;
    			 if(req_user.getPassword().equals(user.getPassword())){
    				 loginModel.setSuccess(true);
    				 loginModel.setMsg("doLogin");
    				 return loginModel;
    			 }
    		   }
    	   }
       }
       loginModel.setSuccess(false);
       if(hasUser)loginModel.setMsg("password error");
    	   else loginModel.setMsg("user not exist");
       logger.debug(users);
       return loginModel;  
   }  
}  
