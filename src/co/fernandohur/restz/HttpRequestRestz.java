package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.Map;

import co.fernandohur.restz.net.HttpRequest;
import co.fernandohur.restz.parsers.JsonParser;

public class HttpRequestRestz extends AbstractRestz{

	private JsonParser parser;
	
	@Override
	public <T> T put(String baseUrl, Type classType, Map<String, Object> params) {
		HttpRequest put = HttpRequest.put(baseUrl, params, true);
		
		String content = put.body();
		return parser.parse(content, classType);
	}
	
	@Override
	public <T> T post(String baseUrl, Type classType, Map<String, Object> params) {
		HttpRequest post = HttpRequest.post(baseUrl, params, true);
		String content = post.body();
		return parser.parse(content, classType);
	}
	
	@Override
	public <T> T get(String baseUrl, Type classType, Map<String, Object> params) {
		HttpRequest get = HttpRequest.get(baseUrl, params, true);
		String content = get.body();
		return parser.parse(content, classType);
	}
	
	@Override
	public String delete(String url, Map<String, Object> params) {
		HttpRequest delete = HttpRequest.delete(url, params, true);
		return delete.body();
	}
	
}
