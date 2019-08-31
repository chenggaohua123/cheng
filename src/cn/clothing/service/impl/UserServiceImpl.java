package cn.clothing.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.clothing.dao.user.UserMapper;
import cn.clothing.pojo.User;
import cn.clothing.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUser(String id, String password) {
		try {
			logger.info("进入getUser方法>>>>>>>>>>>>>>>>>>>");
			return userMapper.getUser(id, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
