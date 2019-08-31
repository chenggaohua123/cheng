package cn.clothing.dao.type;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.clothing.pojo.Type;

public interface TypeMapper {

	
	//获取所有有衣服
	public List<Type> getAllType() throws Exception;
	
	//查询指定id的类型
	public Type getTypeById(@Param(value="typeId")Integer typeId)throws Exception;
}
