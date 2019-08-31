package cn.clothing.dao.clothing;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.clothing.pojo.Clothing;
import cn.clothing.util.BiographyUtil;

public interface ClothingMapper {

	
	//通过id获取所有有衣服
	//public Map getAllClothing(@Param(value="typeId")Integer typeId) throws Exception;
	public List<Clothing> getAllClothing(@Param(value="typeId")Integer typeId) throws Exception;
	public List<Clothing> getClothingList(@Param(value="bu")BiographyUtil bu,@Param(value="rb")RowBounds rb)throws Exception;
	//获取所有衣服
	public List<Clothing> getClothing() throws Exception;
	//通过id获取衣服
	public Clothing getClothingById(@Param(value="id")Integer id)throws Exception;
	//添加衣服
	public void addClothing(Clothing clothing)throws Exception;
	
	
}
