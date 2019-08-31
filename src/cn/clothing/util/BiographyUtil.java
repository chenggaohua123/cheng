package cn.clothing.util;


import java.util.HashMap;
import java.util.Map;

public class BiographyUtil {

	private Map<String,Object> parametersMap;
	
	
	public BiographyUtil(){
		parametersMap=new HashMap<String, Object>();
	}


	public Map<String, Object> getParametersMap() {
		return parametersMap;
	}


	public void setParametersMap(Map<String, Object> parametersMap) {
		this.parametersMap = parametersMap;
	}


	
	
	
}
