package co.fernandohur.restz;

import java.util.Map;

import co.fernandohur.restz.net.HttpRequest;

public class BasicHttpRequestor implements HttpRequestor {

	@Override
	public String get(String baseUrl, Map<String, Object> params)
			throws Exception {
		HttpRequest get = HttpRequest.get(baseUrl, params,true);
		return get.body();
	}

	@Override
	public String post(String baseUrl, Map<String, Object> params)
			throws Exception {
		HttpRequest post = HttpRequest.post(baseUrl, params,true);
		return post.body();
	}

	@Override
	public String put(String baseUrl, Map<String, Object> params)
			throws Exception {
		HttpRequest put = HttpRequest.put(baseUrl, params,true);
		return put.body();
	}

	@Override
	public String delete(String baseUrl, Map<String, Object> params)
			throws Exception {
		HttpRequest delete = HttpRequest.delete(baseUrl, params,true);
		return delete.body();
	}

}
