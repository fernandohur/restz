package co.fernandohur.restz.parsers;

import java.lang.reflect.Type;

public interface JsonParser {

	/**
	 * 
	 * @param json a json string containing the resulting object's representation
	 * @param type The Type object containing the Class information
	 * @return the object parsed from a json string
	 * @throws Exception in case the returned json is an error instead of the expected object
	 */
	public <T> T parse(String json, Type type) throws Exception;
}
