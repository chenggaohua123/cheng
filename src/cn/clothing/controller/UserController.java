package cn.clothing.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.clothing.pojo.User;
import cn.clothing.service.UserService;
import cn.clothing.util.BasicController;

@Controller
public class UserController{

	@Resource
	private UserService userService;
	
	@RequestMapping("/login.html")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/dologin.html")
	public String dologin(@RequestParam(value="id") String id,
				@RequestParam(value="password") String password,
				HttpSession session,
				HttpServletRequest request,Model model){
		User user=null;
		user=userService.getUser(id, password);
		if(user!=null){
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(5);
			return "redirect:/frame.html";
		}else{
			request.setAttribute("message", "用户名或者密码不正确");
			return "redirect:/login.html";
		}
		
	}
	
	@RequestMapping("/frame.html")
	public String frame(){
		return "frame";
	}
	
}
