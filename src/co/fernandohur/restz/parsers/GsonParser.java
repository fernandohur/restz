package co.fernandohur.restz.parsers;

import java.lang.reflect.Type;

import com.google.gson.Gson;



public class GsonParser implements JsonParser{

	private Gson gson;
	
	public GsonParser(Gson gson) {
		this.gson = gson;
	}
	
	@Override
	public <T> T parse(String json, Class<T> clazz) {
		return parse(json, clazz);
	}
	/**
	 * To obtain Type for a List of T's you can use 
	 * {@code new TypeToken<List<T>>(){}.getType() }
	 */
	@Override
	public <T> T parse(String json, Type type) {
		return gson.fromJson(json, type);
	}

	
}
