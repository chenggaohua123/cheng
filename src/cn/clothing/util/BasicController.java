package cn.clothing.util;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service("bc")
public class BasicController {
	
	@Autowired
	private HttpServletRequest request;
	
	public BiographyUtil getBiographyUtil(){
		BiographyUtil bu=new BiographyUtil();
		Enumeration<String> enu=request.getParameterNames();
		while(enu.hasMoreElements()){
			String name=enu.nextElement();
			bu.getParametersMap().put(name, request.getParameter(name));
		}
		return bu;
		
	}
}
