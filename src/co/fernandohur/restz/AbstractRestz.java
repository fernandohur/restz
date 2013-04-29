package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;



public abstract class AbstractRestz implements Restz {

	public Map<String, Object> toMap(Object... params){
		
		if (params.length % 2 != 0){
			throw new IllegalArgumentException("params should be a multiple of 2");
		}
		Map<String, Object> map = new HashMap<String,Object>();
		for (int i = 0; i < params.length-1; i+=2) {
			String name = params[i].toString();
			Object value = params[i+1];
			map.put(name, value);
		}
		
		return map;
	}
	
	public <T> T get(String baseUrl, Type classType, Object... params) throws Exception {
		return get(baseUrl, classType, toMap(params));
	}


	
	public <T> T post(String baseUrl, Type classType, Object... params) throws Exception {
		return post(baseUrl, classType, toMap(params));
	}


	
	public <T> T put(String baseUrl, Type classType, Object... params) throws Exception {
		return put(baseUrl, classType, toMap(params));
	}

}
