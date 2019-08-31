package cn.clothing.thread;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TestThread_2 extends Thread {

	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		System.out.println("测试002"+name+"线程开始执行时间:"+new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("测试002"+name+"线程结束时间:"+new Date());
	}

	
}
