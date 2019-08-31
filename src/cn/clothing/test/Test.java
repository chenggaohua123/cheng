package cn.clothing.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.clothing.controller.ClothingController;
import cn.clothing.dao.type.TypeMapper;
import cn.clothing.pojo.Clothing;
import cn.clothing.pojo.Type;
import cn.clothing.service.ClothingService;
import cn.clothing.service.ExceptionTest;
import cn.clothing.service.impl.ClothingServiceImpl;



public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		ClothingService clothingService=(ClothingService) context.getBean("clothingService");
		ExceptionTest exceptionTest=(ExceptionTest) context.getBean("exceptionTest");
		//Exception exception= (Exception) context.getBean("exception");
		/*TypeMapper typeMapper=(TypeMapper) context.getBean("typeMapper");
		
		ClothingController clothingController=(ClothingController) context.getBean("clothingController");
		Type type=(Type) context.getBean("Type");*/
		//exception.printStackTrace();
		exceptionTest.getTest();
		clothingService.getClothing();
		Writer fw=null;
		try {
			fw=new FileWriter(new File("f:/test.txt"));
			for (int i = 0; i < 10; i++) {
				fw.write(i+",");
			}
			fw.flush();
			
			if(1==1){
				throw new RuntimeException();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
