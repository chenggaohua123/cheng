package cn.clothing.log;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;

import com.sun.istack.internal.logging.Logger;

public class ClothingServiceLogger implements ThrowsAdvice{

	private static Logger logger=Logger.getLogger(ClothingServiceLogger.class);
	private Date startDate;	//开始时间
	private Date endDate;//	结束时间
	
	public void before(JoinPoint jp){
		logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法入参:"+Arrays.toString(jp.getArgs()));
		startDate=new Date();
		String date=new SimpleDateFormat("yyyy-MM-DD hh:mm:ss").format(new Date());
		logger.info("开始时间："+date);
	}
	
	public void afterReturing(JoinPoint jp,Object result){
		endDate=new Date();
		logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"的方法。方法返回值:"+result);
		String date=new SimpleDateFormat("yyyy-MM-DD hh:mm:ss").format(new Date());
		logger.info("结束时间："+date);
		//logger.info("总共耗时:"+(endDate));
	}
	
	public void throwingLog(JoinPoint jp,Exception ex){
		System.out.println("throwingLog"+jp.getSignature().getName()+">>>>>>>");
		System.out.println("throwingLog："+ex.toString());
	}
	
	public void testMethod(){
		System.out.println("我是测试方法>>>>>>>>>>>>>>>>>>");
	}
	
	
}
