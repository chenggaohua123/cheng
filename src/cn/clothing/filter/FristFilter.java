package cn.clothing.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class FristFilter implements Filter{

	private static Logger logger=Logger.getLogger(FristFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"进入FristFilter的doFilter方法中>>>>>>>>>>>>>>>>>>>>>>>");
		filterChain.doFilter(request, response);
		
		logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"退出FristFilter的doFilter方法>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
