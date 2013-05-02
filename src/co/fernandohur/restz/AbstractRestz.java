package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import co.fernandohur.restz.parsers.JsonParser;



public abstract class AbstractRestz implements Restz {
	
	protected JsonParser parser;
	
	public Map<String, Object> toMap(Object... params){
		
		if (params.length % 2 != 0){
			for (int i = 0; i < params.length; i++) {
				Object object = params[i];
				System.out.println(object);
			}
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
		String json = get(baseUrl, toMap(params));
		return parser.parse(json, classType);
	}
	
	@Override
	public <T> T get(String baseUrl, Type classType, Map<String, Object> params)
			throws Exception {
		String json = get(baseUrl, params);
		return parser.parse(json, classType);
	}


	
	public <T> T post(String baseUrl, Type classType, Object... params) throws Exception {
		String json = post(baseUrl, toMap(params));
		return parser.parse(json, classType);
	}
	
	@Override
	public <T> T post(String baseUrl, Type classType, Map<String, Object> params)
			throws Exception {
		String json = post(baseUrl, params);
		return parser.parse(json, classType);
	}
	
	public <T> T put(String baseUrl, Type classType, Object... params) throws Exception {
		String json = put(baseUrl,toMap(params));
		return parser.parse(json, classType);
	}
	
	@Override
	public <T> T put(String baseUrl, Type classType, Map<String, Object> params)
			throws Exception {
		String json = put(baseUrl, params);
		return parser.parse(json, classType);
	}
	
	@Override
	public JsonParser getParser() {
		return parser;
	}
	
	@Override
	public void setParser(JsonParser parser) {
		this.parser = parser; 
	}

}
