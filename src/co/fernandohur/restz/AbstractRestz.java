package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.Map;

import co.fernandohur.restz.net.HttpRequest;

public abstract class AbstractRestz implements Restz {

	protected Map<String, Object> toMap(Object... params){
		return null;
	}
	
	@Override
	public <T> T get(String baseUrl, Type classType, Object... params) {
		return get(baseUrl, classType, toMap(params));
	}


	@Override
	public <T> T post(String baseUrl, Type classType, Object... params) {
		return post(baseUrl, classType, toMap(params));
	}


	@Override
	public <T> T put(String baseUrl, Type classType, Object... params) {
		return put(baseUrl, classType, toMap(params));
	}

}
