package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public abstract class DefaultRailz<T> implements Railz<T> {

	protected Restz restz;
	protected String resourceName;
	protected String baseUrl;
	
	public DefaultRailz(String resourceName, String baseUrl) {
		if (baseUrl.endsWith("/")){
			throw new IllegalArgumentException("baseUrl cannot end with '/'");
		}
		this.resourceName = resourceName;
		this.restz = new HttpRequestRestz();
		this.baseUrl = baseUrl;
	}
	
	@Override
	public T find(Class<T> clazz, Object id) {
		T result = restz.get(baseUrl+"/"+resourceName+"/"+id+".json", clazz);
		return result;
	}

	@Override
	public void destroy(Object id) {
		restz.delete(baseUrl+"/"+resourceName+"/"+id+".json", new HashMap<String,Object>());
	}

	@Override
	public  List<T> getAll(Type clazz) {
		return restz.get(baseUrl+"/"+resourceName+".json", clazz);
	}

}
