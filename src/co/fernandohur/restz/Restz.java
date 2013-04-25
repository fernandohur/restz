package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.Map;

public interface Restz {
	
	/**
	 * 
	 * @param baseUrl the base url i.e. http://baseurl.com
	 * @param params the parameters i.e. name=bob&lastname=doe
	 * @return returns a get method object
	 */
	public <T> T get(String baseUrl, Type classType, Object... params);

	
	/**
	 * 
	 * @param baseUrl
	 * @param params the get params encoded as a hashmap
	 * @return returns a get method object
	 */
	public <T> T get(String baseUrl, Type classType, Map<String,Object> params);
	

	/**
	 * Posts to the specified url
	 * @param baseUrl the url to post
	 * @param params the params must be submitted in pairs. If for example you
	 * want a=b&b=c then params={a,b,b,c}
	 * @return a post method object
	 */
	public <T> T post(String baseUrl, Type classType, Object... params);
	
	public <T> T post(String baseUrl, Type classType, Map<String, Object> params);
	
	/**
	 * Put to the specified url
	 * @param baseUrl the url to put to
	 * @param params the params must be submitted in pairs. If for example you
	 * want a=b&b=c then params={a,b,b,c}
	 * @return a put method object
	 */
	public <T> T put(String baseUrl, Type classType, Object... params);
	
	/**
	 * Put to the specified url
	 * @param baseUrl the url to put to
	 * @param params the params must be submitted in pairs. If for example you
	 * want a=b&b=c then params={a,b,b,c}
	 * @return a put method object
	 */
	public <T> T put(String baseUrl, Type classType, Map<String, Object> params);
	
	public String delete(String url, Map<String,Object> params);
	
	
}
