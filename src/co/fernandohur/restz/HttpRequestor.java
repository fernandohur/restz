package co.fernandohur.restz;

import java.util.Map;

public interface HttpRequestor {

	public String get(String baseUrl, Map<String, Object> params) throws Exception;
	public String post(String baseUrl, Map<String, Object> params) throws Exception;
	public String put(String baseUrl, Map<String, Object> params) throws Exception;
	public String delete(String url, Map<String,Object> params) throws Exception;
}
