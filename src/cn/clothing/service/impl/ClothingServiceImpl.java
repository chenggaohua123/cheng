package cn.clothing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.sun.istack.internal.logging.Logger;

import cn.clothing.dao.clothing.ClothingMapper;
import cn.clothing.pojo.Clothing;
import cn.clothing.service.ClothingService;
import cn.clothing.util.BiographyUtil;
@Service("clothingService")
public class ClothingServiceImpl implements ClothingService {

	private static Logger logger=Logger.getLogger(ClothingServiceImpl.class);
	@Resource
	private ClothingMapper clothingMapper;
	@Autowired
	@Qualifier("txDefinition")
	private TransactionDefinition txDefinition; // transaction定义是哪个 
	@Autowired
	@Qualifier("txManager")
	private PlatformTransactionManager txManager; //具体使用的txmanager
	
	@Override
	public List<Clothing> getAllClothing(Integer typeId) {
		try {
			logger.info("进入getAllClothing方法>>>>>>>>>>>>>>>>>>>>>");
			return clothingMapper.getAllClothing(typeId);
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}
	
	public List<Clothing> getClothingListByPage(BiographyUtil bu,RowBounds rb){
		try {
			return clothingMapper.getClothingList(bu, rb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public List<Clothing> getClothing(){
		try {
			logger.info("进入getClothing方法>>>>>>>>>>>>>>>>>>>>>");
			return clothingMapper.getClothing();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Clothing getClothingById(Integer id) {
		try {
			logger.info("进入getClothingById方法>>>>>>>>>>>>>>>>>>>>>");
			return clothingMapper.getClothingById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean addClothing(Clothing clothing) {
		try {
			logger.info("进入addClothing方法>>>>>>>>>>>>>>>>>>>>>");
			 clothingMapper.addClothing(clothing);
			 return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addList(List<Clothing> list)   {
		//这里获取事务状态
		TransactionStatus txStatus = txManager.getTransaction(txDefinition);
		for(Clothing clothing:list){
			try {
				clothingMapper.addClothing(clothing);
				if(true){
					throw new RuntimeException("测试事务管理");
				}
				txManager.commit(txStatus);
			} catch (Exception e) {
				e.printStackTrace();
				txManager.rollback(txStatus);
				return false;
			}
			
		}
		return true;
	}

}
