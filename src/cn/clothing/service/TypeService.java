package cn.clothing.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.clothing.pojo.Type;

public interface TypeService {

	
	public List<Type> getAllType() throws Exception;
	//查询指定id的类型
	public Type getTypeById(Integer typeId);
}
