package cn.clothing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.istack.internal.logging.Logger;

import cn.clothing.dao.type.TypeMapper;
import cn.clothing.pojo.Type;
import cn.clothing.service.TypeService;
@Service("typeService")
public class TypeServiceImpl implements TypeService {

	private static Logger logger=Logger.getLogger(TypeServiceImpl.class);
	
	@Resource
	private TypeMapper typeMapper;
	
	public List<Type> getAllType() throws Exception {
		List<Type> list=null;
		try {
			logger.info("进入getAllType方法>>>>>>>>>>>>>>>>>>>>>>>>");
			list=typeMapper.getAllType();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("getAllType方法异常",e);
		}
		return list;
		
	}

	@Override
	public Type getTypeById(Integer typeId) {
		try {
			return typeMapper.getTypeById(typeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
