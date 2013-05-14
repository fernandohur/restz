package co.fernandohur.restz;

import java.util.Map;

import co.fernandohur.restz.net.HttpRequest;
import co.fernandohur.restz.parsers.GsonParser;
import co.fernandohur.restz.parsers.JsonParser;

import com.google.gson.Gson;

public class DefaultRestz extends AbstractRestz{

	public DefaultRestz(){
		setParser(new GsonParser(new Gson()));
	}
	
	public DefaultRestz(JsonParser parser) {
		this.parser = parser;
	}
	
	
	@Override
	public String delete(String url, Map<String, Object> params) {
		
		HttpRequest delete = HttpRequest.delete(url, params, true);
		delete = afterCreate(delete);
		return delete.body();
	}
	
	@Override
	public JsonParser getParser() {
		return parser;
	}

	@Override
	public String get(String baseUrl, Map<String, Object> params) {
		HttpRequest get = HttpRequest.get(baseUrl, params,true);
		get = afterCreate(get);
		return get.body();
	}

	@Override
	public String post(String baseUrl, Map<String, Object> params) {
		HttpRequest post = HttpRequest.post(baseUrl, params, true);
		post = afterCreate(post);
		return post.body();
	}

	@Override
	public String put(String baseUrl, Map<String, Object> params) {
		HttpRequest put = HttpRequest.put(baseUrl, params, true);
		put = afterCreate(put);
		return put.body();
	}
	
	/**
	 * This method should be overridden to add additional filters to every request, i.e. basic auth
	 * @param request
	 * @return
	 */
	public HttpRequest afterCreate(HttpRequest request){
		return request;
	}
	
	@Override
	public void setParser(JsonParser parser) {
		this.parser = parser;
	}
	
}
