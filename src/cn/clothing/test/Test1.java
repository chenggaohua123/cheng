package cn.clothing.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.clothing.pojo.Clothing;
import cn.clothing.pojo.Type;
import cn.clothing.service.ClothingService;
import cn.clothing.service.TypeService;

public class Test1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		ClothingService clothingService=(ClothingService) context.getBean("clothingService");
		TypeService typeService=(TypeService) context.getBean("typeService");
		Type type= typeService.getTypeById(5);
		
		Clothing clothing=new Clothing();
		clothing.setTitle("测试008");
		clothing.setBrand("苹果");
		clothing.setCode("AACCJJ");
		clothing.setColor("黑色");
		clothing.setNumber(12);
		clothing.setOldprice(180.00);
		clothing.setDiscountprice(150.00);
		clothing.setSize("L");
		clothing.setTypePojo(type);
		clothing.setInsertTime(new Date());
		List<Clothing> list=new ArrayList<Clothing>();
		list.add(clothing);
		list.add(clothing);
		clothingService.addList(list);
	}

}
