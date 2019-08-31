package cn.clothing.thread;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.clothing.service.TypeService;
import cn.clothing.service.impl.TypeServiceImpl;

@Service
public class TimeThread extends Thread {

	@Resource
	private TypeService typeService;
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		System.out.println(name+"线程开始执行时间:"+new Date());
		
		try {
			typeService.getAllType();
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"线程结束时间:"+new Date());
	}
	
	
}
