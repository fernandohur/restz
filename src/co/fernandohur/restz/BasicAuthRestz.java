package co.fernandohur.restz;

import co.fernandohur.restz.net.HttpRequest;


public class BasicAuthRestz extends DefaultRestz{

	private String basicPassword;
	private String basicUsername;
	
	
	
	public BasicAuthRestz(String username, String password) {
		setBasicAuth(username, password);
	}
	
	public void setBasicAuth(String username, String password) {
		this.basicPassword = password;
		this.basicUsername = username;
	}
	
	public String getBasicPassword() {
		return basicPassword;
	}
	
	public String getBasicUsername() {
		return basicUsername;
	}
	
	@Override
	public HttpRequest afterCreate(HttpRequest request) {
		return request.basic(basicUsername, basicPassword); 
	}
	
}
