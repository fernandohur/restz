package co.fernandohur.restz.test.unit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.fernandohur.restz.HttpRequestRestz;
import co.fernandohur.restz.Restz;

import com.google.gson.reflect.TypeToken;
import com.google.mockwebserver.MockResponse;
import com.google.mockwebserver.MockWebServer;
import com.google.mockwebserver.RecordedRequest;


public class TestHttpRestz {


	private Restz restz;
	private MockWebServer mockServer;
	
	
	
	public TestHttpRestz() {
		restz = new HttpRequestRestz();
		mockServer = new MockWebServer();
	}
	
	@Before
	public void setup() throws IOException{
		mockServer.play(12345);
	}
	
	@After
	public void after() throws IOException {
		mockServer.shutdown();
	}
	
	@Test
	public void testGetToFacebookShouldReturnUser() throws Exception{
		
		FacebookUser user = restz.get("https://graph.facebook.com/4", FacebookUser.class);
		Assert.assertEquals("4", user.id);
		Assert.assertEquals("Mark Zuckerberg", user.name);
		Assert.assertEquals("zuck", user.username);
		Assert.assertEquals("male", user.gender);
	}
	
	@Test
	public void testGETasString() throws Exception{
		
		enqueueUser();
		
		Map<String,Object> params = new HashMap<String,Object>();
		Assert.assertTrue(params.size()%2==0);
		String responseUser = restz.get(mockServer.getUrl("/").toString(), params);
		Assert.assertEquals(getJsonMockUser(), responseUser);
		
		MockUser user = restz.getParser().parse(responseUser, MockUser.class);
		test(user, "GET", "", "".getBytes());
	
	}
	
	@Test
	public void testGETasMockUser1() throws Exception{
		
		enqueueUser();

		MockUser user = restz.get(mockServer.getUrl("/").toString(),MockUser.class, "id",2,"x","hola");
		test(user, "GET", "id=2&x=hola", "".getBytes());
		
	}
	
	@Test
	public void testGETasMockUser2() throws Exception{
		
		enqueueUser();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 2);
		map.put("x", "hola");
		
		MockUser user = restz.get(mockServer.getUrl("/").toString(),MockUser.class, map);
		test(user, "GET", "","".getBytes());
		
	}
	
	
	@Test
	public void testGetasMockUserList() throws Exception{
		enqueueList();
		enqueueList();
		enqueueList();
		List<MockUser> users = restz.get(getURL(),new TypeToken<List<MockUser>>(){}.getType());
		test(users, "GET", "", "".getBytes());
		
		users = restz.get(getURL(),new TypeToken<List<MockUser>>(){}.getType(),"a","b","c","d");
		test(users, "GET", "c=d&a=b", "".getBytes());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", 5);
		map.put("asd", "b");
		
		users = restz.get(getURL(),new TypeToken<List<MockUser>>(){}.getType(),map);
		test(users, "GET", "asd=b&a=5", "".getBytes());
	}
	
	
	
	public void testPOSTasString() throws Exception{
		String json = getJsonMockUser();
		mockServer.enqueue(new MockResponse().setResponseCode(200).setBody(json));
	}
	
	/**
	 * Tests a bunch of things:
	 * 1. Tests that the param user's attributes match with getJsonMockUser()'s attrs
	 * 2. Tests that the request's method received by the server matches the method param
	 * 3. Verifies that the request received by the server contains the params
	 * 4. Verifies that the request's body matches the body param
	 * @param user
	 * @param method
	 * @param params
	 * @param body
	 * @throws InterruptedException
	 */
	public void test(MockUser user, String method, String params, byte[] body) throws InterruptedException{
		Assert.assertEquals(user.money, 21.5,0.1);
		Assert.assertEquals(user.name, "carlos");
		Assert.assertEquals(user.age, 21);
		
		RecordedRequest request = mockServer.takeRequest();
		Assert.assertEquals(method,request.getMethod());
		Assert.assertArrayEquals(request.getBody(), body);
		Assert.assertTrue(request.getRequestLine().contains(params));
	}
	
	/**
	 * Similar to method test(MockUser, String,String,byte[]) but instead of single user test's for many users
	 * @param users
	 * @param method
	 * @param params
	 * @param body
	 * @throws InterruptedException
	 */
	public void test(List<MockUser> users, String method, String params, byte[] body) throws InterruptedException{
		Assert.assertEquals(2, users.size());
		for (MockUser u : users) {
			if (u.age==21){
				Assert.assertEquals(u.money, 21.5,0.1);
				Assert.assertEquals(u.name, "carlos");
				Assert.assertEquals(u.age, 21);
			}
			else if (u.age==15){
				Assert.assertEquals(u.money, 99.9,0.1);
				Assert.assertEquals(u.name, "roberto");
				Assert.assertEquals(u.age, 15);
			}
			else{
				Assert.fail("User with age "+u.age + " should not exist");
			}
		}
		
		RecordedRequest request = mockServer.takeRequest();
		Assert.assertEquals(method,request.getMethod());
		Assert.assertArrayEquals(request.getBody(), body);
		Assert.assertTrue(request.getRequestLine().contains(params));
	}
	
	String getJsonMockUserList(){
		String json = "[{\"name\":\"carlos\",\"age\":21,\"money\":21.5},{\"name\":\"roberto\",\"age\":15,\"money\":99.9}]";
		return json;
	}
	
	String getJsonMockUser(){
		String json = "{\"name\":\"carlos\",\"age\":21,\"money\":21.5}";
		return json;
	}
	
	String getURL() throws MalformedURLException, UnknownHostException{
		return mockServer.getUrl("/").toString();
	}
	
	public void enqueueUser(){
		mockServer.enqueue(new MockResponse().setResponseCode(200).setBody(getJsonMockUser()));
	}
	
	public void enqueueList(){
		mockServer.enqueue(new MockResponse().setResponseCode(200).setBody(getJsonMockUserList()));
	}
	
	
	class MockUser{
		String name;
		int age;
		double money;
	}
	
	class FacebookUser{
		String id;
		String name;
		String first_name;
		String last_name;
		String username;
		String gender;
		String locale;
	}
	
}
