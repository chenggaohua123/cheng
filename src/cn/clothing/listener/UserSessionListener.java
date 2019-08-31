package cn.clothing.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("进入UserSessionListener的sessionCreated>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("进入UserSessionListener的sessionDestroyed");
		
	}

	
}
