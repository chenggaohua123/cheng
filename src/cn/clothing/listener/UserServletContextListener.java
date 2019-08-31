package cn.clothing.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.clothing.thread.TestThread_1;
import cn.clothing.thread.TestThread_2;
import cn.clothing.thread.TestThread_3;
import cn.clothing.thread.TestThread_4;
import cn.clothing.thread.TestThread_5;
import cn.clothing.thread.TestThread_6;
import cn.clothing.thread.TimeThread;

public class UserServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//System.out.println("进入contextInitialized>>>>>>>>>>>>>>>>>");
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//TimeThread timeThread=(TimeThread) context.getBean("timeThread");
		//TestThread_1 testThread1=(TestThread_1) context.getBean("testThread_1");
		//TestThread_2 testThread2=(TestThread_2) context.getBean("testThread_2");
		//TestThread_3 testThread3=(TestThread_3) context.getBean("testThread_3");
		//TestThread_4 testThread4=(TestThread_4) context.getBean("testThread_4");
		//TestThread_5 testThread5=(TestThread_5) context.getBean("testThread_5");
		//TestThread_6 testThread6=(TestThread_6) context.getBean("testThread_6");
		
		//ExecutorService executors=Executors.newFixedThreadPool(6);
		//executors=Executors.newScheduledThreadPool(6);
		//ScheduledExecutorService scheduledExecutorService=(ScheduledExecutorService) executors;
		//scheduledExecutorService.scheduleWithFixedDelay(command, 0, delay, unit)
		//scheduledExecutorService.scheduleAtFixedRate(timeThread, 0, 1, TimeUnit.SECONDS);
		//scheduledExecutorService.scheduleAtFixedRate(testThread1, 0, 1, TimeUnit.SECONDS);
		//scheduledExecutorService.scheduleAtFixedRate(testThread2, 0, 1, TimeUnit.SECONDS);
		//scheduledExecutorService.scheduleAtFixedRate(testThread3, 0, 1, TimeUnit.SECONDS);
		//scheduledExecutorService.scheduleAtFixedRate(testThread4, 0, 1, TimeUnit.SECONDS);
		//scheduledExecutorService.scheduleAtFixedRate(testThread5, 0, 1, TimeUnit.SECONDS);
		//scheduledExecutorService.scheduleAtFixedRate(testThread6, 0, 1, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		TimeThread timeThread=(TimeThread) context.getBean("timeThread");
		//ExecutorService executors=Executors.newFixedThreadPool(6);
		//executors=Executors.newScheduledThreadPool(6);
		ExecutorService executors=Executors.newSingleThreadExecutor();
		ScheduledExecutorService scheduledExecutorService=(ScheduledExecutorService) executors;
		scheduledExecutorService.scheduleAtFixedRate(timeThread, 0, 1, TimeUnit.SECONDS);
		
	}
}
