package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.Map;

import co.fernandohur.restz.net.HttpRequest;
import co.fernandohur.restz.parsers.GsonParser;
import co.fernandohur.restz.parsers.JsonParser;

import com.google.gson.Gson;

public class HttpRequestRestz extends AbstractRestz{

	public HttpRequestRestz(){
		setParser(new GsonParser(new Gson()));
	}
	
	public HttpRequestRestz(JsonParser parser) {
		this.parser = parser;
	}
	
	@Override
	public <T> T put(String baseUrl, Type classType, Map<String, Object> params) throws Exception {
		String content = put(baseUrl, params);
		return parser.parse(content, classType);
	}
	
	@Override
	public <T> T post(String baseUrl, Type classType, Map<String, Object> params) throws Exception {
		String content = post(baseUrl, params);
		return parser.parse(content, classType);
	}
	
	@Override
	public <T> T get(String baseUrl, Type classType, Map<String, Object> params) throws Exception {
		String content = get(baseUrl, params);
		return parser.parse(content, classType);
	}
	
	@Override
	public String delete(String url, Map<String, Object> params) {
		HttpRequest delete = HttpRequest.delete(url, params, true);
		return delete.body();
	}
	
	@Override
	public JsonParser getParser() {
		return parser;
	}

	@Override
	public String get(String baseUrl, Map<String, Object> params) {
		HttpRequest get = HttpRequest.get(baseUrl, params,true);
		return get.body();
	}

	@Override
	public String post(String baseUrl, Map<String, Object> params) {
		HttpRequest post = HttpRequest.post(baseUrl, params, true);
		return post.body();
	}

	@Override
	public String put(String baseUrl, Map<String, Object> params) {
		HttpRequest put = HttpRequest.put(baseUrl, toMap(params), true);
		return put.body();
	}
	
	@Override
	public void setParser(JsonParser parser) {
		this.parser = parser;
	}
	
}
