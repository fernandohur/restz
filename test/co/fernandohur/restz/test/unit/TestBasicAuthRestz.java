package co.fernandohur.restz.test.unit;

import java.util.HashMap;

import junit.framework.Assert;
import main.java.fi.iki.elonen.MockHttpServer.Request;

import org.junit.Test;

import co.fernandohur.restz.BasicAuthRestz;
import co.fernandohur.restz.test.helpers.Base64Decoder;

public class TestBasicAuthRestz extends HasServerTest{

	private String username;
	private String password;
	
	public TestBasicAuthRestz() {
		super();
		username = "abcdefg";
		password = "1234asdf";
		restz = new BasicAuthRestz(username, password);
	}
	
	@Test
	public void testBasicAuthGet() throws Exception{
		
		enqueueUser();
		
		restz.get(getURL(), MockUser.class);
		
		Request req = mockServer.getRequest();
		String auth = req.getHeader().get("authorization");
		Assert.assertTrue(auth.startsWith("Basic "));
		String[] credentials = decodeAndGetCredentials(auth);
		
		assertCredentials(credentials);
	}
	
	@Test
	public void testBasicAuthPost() throws Exception{
		
		enqueueUser();
		
		restz.post(getURL(), MockUser.class);
		
		Request req = mockServer.getRequest();
		String auth = req.getHeader().get("authorization");
		Assert.assertTrue(auth.startsWith("Basic "));
		String[] credentials = decodeAndGetCredentials(auth);
		
		assertCredentials(credentials);
	}
	
	@Test
	public void testBasicAuthPut() throws Exception{
		
		enqueueUser();
		
		restz.put(getURL(), MockUser.class);
		
		Request req = mockServer.getRequest();
		String auth = req.getHeader().get("authorization");
		Assert.assertTrue(auth.startsWith("Basic "));
		String[] credentials = decodeAndGetCredentials(auth);
		
		assertCredentials(credentials);
	}
	
	@Test
	public void testBasicAuthDelete() throws Exception{
		
		enqueueUser();
		
		restz.delete(getURL(), new HashMap<String, Object>());
		
		Request req = mockServer.getRequest();
		String auth = req.getHeader().get("authorization");
		Assert.assertTrue(auth.startsWith("Basic "));
		String[] credentials = decodeAndGetCredentials(auth);
		
		assertCredentials(credentials);
	}
	
	

	private String[] decodeAndGetCredentials(String auth) {
		String authClean = auth.split("Basic ")[1].split("=")[0];
		
		String decoded = new String(Base64Decoder.decode(authClean));
		return decoded.split(":");
	}
	
	private void assertCredentials(String[] credentials){
		Assert.assertEquals(credentials.length, 2);
		Assert.assertEquals(credentials[0], username);
		Assert.assertEquals(credentials[1], password);
	}

	
	
}
