package co.fernandohur.restz;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public abstract class DefaultRailz implements Railz {

	private String resourceName;
	private Restz restz;
	private String baseUrl;
	private Gson gson;
	
	public DefaultRailz(String resourceName, String baseUrl) {
		this.resourceName = resourceName;
		this.restz = new HttpRequestRestz();
		this.baseUrl = baseUrl;
		gson = new Gson();
	}
	
	@Override
	public <T> T find(Class<T> clazz, Object id) {
		T result = restz.get(baseUrl+"/"+resourceName+"/"+id+".json", clazz);
		return result;
	}

	@Override
	public <T> T update(Object id, T newObject) {
		String json = gson.toJson(newObject);
		return restz.put(baseUrl+"/"+resourceName+"/"+id+".json",newObject.getClass(),id,json);
	}

	@Override
	public void destroy(Object id) {
		restz.delete(baseUrl+"/"+resourceName+"/"+id+".json", new HashMap<String,Object>());
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz) {
		return restz.get(baseUrl+"/"+resourceName+".json", clazz);
	}

}
