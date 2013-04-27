package co.fernandohur.restz.test.unit;

import org.junit.Assert;
import org.junit.Test;

import co.fernandohur.restz.HttpRequestRestz;
import co.fernandohur.restz.Restz;


public class TestHttpRestz {


	private Restz restz;
	
	public TestHttpRestz() {
		restz = new HttpRequestRestz();
	}
	
	@Test
	public void testGetToFacebookShouldReturnUser(){
		
		FacebookUser user = restz.get("https://graph.facebook.com/4", FacebookUser.class);
		Assert.assertEquals("4", user.id);
		Assert.assertEquals("Mark Zuckerberg", user.name);
		Assert.assertEquals("zuck", user.username);
		Assert.assertEquals("male", user.gender);
	}
	
	@Test
	public void test(){
		
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
