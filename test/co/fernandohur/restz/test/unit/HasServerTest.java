package co.fernandohur.restz.test.unit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import main.java.fi.iki.elonen.MockHttpServer;
import main.java.fi.iki.elonen.NanoHTTPD.Response.Status;

import org.junit.After;
import org.junit.Before;

import co.fernandohur.restz.DefaultRestz;
import co.fernandohur.restz.Restz;

public abstract class HasServerTest {

	protected Restz restz;
	protected MockHttpServer mockServer;



	public HasServerTest() {
		restz = new DefaultRestz();
		mockServer = new MockHttpServer(12345);
	}

	@Before
	public void setup() throws IOException{
		mockServer.start();
	}

	@After
	public void after() throws IOException {
		mockServer.stop();
	}
	
	/**
	 * Use this method to get the url that should be used for getting, posting, etc.
	 * @return
	 * @throws MalformedURLException
	 * @throws UnknownHostException
	 */
	public String getURL(){
		return mockServer.getUrl();
	}
	
	/**
	 * Returns a Json array with 2 mock users
	 * @return
	 */
	public String getJsonMockUserList(){
		String json = "[{\"name\":\"carlos\",\"age\":21,\"money\":21.5},{\"name\":\"roberto\",\"age\":15,\"money\":99.9}]";
		return json;
	}
	/**
	 * Returns a json object with a mock user
	 * @return
	 */
	public String getJsonMockUser(){
		String json = "{\"name\":\"carlos\",\"age\":21,\"money\":21.5}";
		return json;
	}

	

	/**
	 * Enqueue a mock response with a 200 response code and the json obtained from getJsonMockUser()
	 */
	public void enqueueUser(){
		mockServer.enqueueResponse(Status.OK, "application/json", getJsonMockUser());
	}

	/**
	 * Enqueue a mock response with a 200 response code and the json obtained from getJsonMockUserList()
	 */
	public void enqueueList(){
		mockServer.enqueueResponse(Status.OK, "application/json", getJsonMockUserList());
	}
	
	class MockUser{
		String name;
		int age;
		double money;
	}
}
