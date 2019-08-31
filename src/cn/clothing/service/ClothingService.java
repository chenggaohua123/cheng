package cn.clothing.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;



import cn.clothing.pojo.Clothing;
import cn.clothing.util.BiographyUtil;

public interface ClothingService {

	
	public List<Clothing> getAllClothing(Integer typeId);
	
	//获取所有衣服
	public List<Clothing> getClothing();
	//通过id获取衣服
	public Clothing getClothingById(Integer id);
	//添加衣服
	public boolean addClothing(Clothing clothing);
	//
	public boolean addList(List<Clothing> list) throws Exception;
	
	public List<Clothing> getClothingListByPage(BiographyUtil bu,RowBounds rb);
}
