package co.fernandohur.restz.parsers;

import java.lang.reflect.Type;

import com.google.gson.Gson;



public class GsonParser implements JsonParser{

	private Gson gson;
	
	public GsonParser(Gson gson) {
		this.gson = gson;
	}
	
	/**
	 * To obtain Type for a List of T's you can use 
	 * {@code new TypeToken<List<T>>(){}.getType() }
	 * @throws Exception 
	 */
	@Override
	public <T> T parse(String json, Type type) throws Exception {
		String errorMessage = getError(json,type);
		if (errorMessage != null){
			throw new Exception(errorMessage);
		}
		return gson.fromJson(json, type);
	}

	public String getError(String json, Type type) {
		return null;
	}
	
	

}




