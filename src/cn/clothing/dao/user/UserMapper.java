package cn.clothing.dao.user;

import org.apache.ibatis.annotations.Param;

import cn.clothing.pojo.User;

public interface UserMapper {

	//通过用户名密码获取用户
	public User getUser(@Param(value="id") String id,@Param(value="password") String password) throws Exception;
	
}
