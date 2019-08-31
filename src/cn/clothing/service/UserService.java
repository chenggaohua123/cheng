package cn.clothing.service;


import cn.clothing.pojo.User;


public interface UserService {
	
	
	
	//通过用户名密码获取用户
	public User getUser(String id,String password);
}
