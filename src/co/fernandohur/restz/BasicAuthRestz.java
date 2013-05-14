package co.fernandohur.restz;

import co.fernandohur.restz.net.HttpRequest;


public class BasicAuthRestz extends DefaultRestz{

	/**
	 * basic authentication username
	 */
	private String basicPassword;
	/**
	 * basic authentication password
	 */
	private String basicUsername;
	
	
	/**
	 * Initializes a Restz that automatically authenticates using the given creds on every request  
	 * @param username the basic username
	 * @param password the basic password
	 */
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
