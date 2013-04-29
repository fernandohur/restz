package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.Map;

import co.fernandohur.restz.parsers.JsonParser;

public interface Restz {
	
	/**
	 * Makes a GET to the specified url with the given params
	 * @param baseUrl the base url of the HTTP request, i.e. http://graph.facebook.com
	 * @param classType the class type of the return object type
	 * @param params a list of params
	 * @return an object of the given classType
	 */
	public <T> T get(String baseUrl, Type classType, Object... params) throws Exception;

	
	/**
	 * Makes a GET to the specified baseUrl with the specified params
	 * @param baseUrl the base url of the HTTP request, i.e. http://graph.facebook.com
	 * @param classType the class type of the return object type
	 * @param params a list of params
	 * @return an object of the given classType
	 */
	public <T> T get(String baseUrl, Type classType, Map<String,Object> params) throws Exception;
	
	public String get(String baseUrl, Object... params) throws Exception;
	

	/**
	 * Makes a POST to the specified base url with the given params
	 * @param baseUrl the base url of the HTTP request, i.e. http://graph.facebook.com
	 * @param classType the class type of the return object type
	 * @param params a list of params
	 * @return an object of the given classType
	 */
	public <T> T post(String baseUrl, Type classType, Object... params) throws Exception;
	
	/**
	 * Makes a POST to the specified base url with the given params
	 * @param baseUrl the base url of the HTTP request, i.e. http://graph.facebook.com
	 * @param classType the class type of the return object type
	 * @param params a list of params
	 * @return an object of the given classType
	 */
	public <T> T post(String baseUrl, Type classType, Map<String, Object> params) throws Exception;
	
	public String post(String baseUrl, Object... params) throws Exception;
	
	/**
	 * Makes a PUT to the specified base url with the given params
	 * @param baseUrl the base url of the HTTP request, i.e. http://graph.facebook.com
	 * @param classType the class type of the return object type
	 * @param params a list of params
	 * @return an object of the given classType
	 */
	public <T> T put(String baseUrl, Type classType, Object... params) throws Exception;
	
	/**
	 * Makes a PUT to the specified base url with the given params
	 * @param baseUrl the base url of the HTTP request, i.e. http://graph.facebook.com
	 * @param classType the class type of the return object type
	 * @param params a list of params
	 * @return an object of the given classType
	 */
	public <T> T put(String baseUrl, Type classType, Map<String, Object> params) throws Exception;
	
	public String put(String baseUrl, Object... params) throws Exception;
	
	/**
	 * Makes a DELETE to the specified base url with the given params
	 * @param baseUrl the base url of the HTTP request, i.e. http://graph.facebook.com
	 * @param classType the class type of the return object type
	 * @param params a list of params
	 * @return an object of the given classType
	 */
	public String delete(String url, Map<String,Object> params) throws Exception;
	
	public JsonParser getParser();
	
}
