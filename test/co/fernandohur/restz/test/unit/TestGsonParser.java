package co.fernandohur.restz.test.unit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.fernandohur.restz.parsers.GsonParser;
import co.fernandohur.restz.parsers.JsonParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TestGsonParser {

	
	private Gson gson;
	JsonParser parser;
	
	public TestGsonParser() {
		gson = new Gson();
		parser = new GsonParser(gson);
	}
	
	@Test
	public void testParsingFromJsonAsSingleObjects(){
		
		
		
		String json = "{\"name\":\"fernando\", \"age\":20, \"money\":123.57 }";
		
		
		User u = parser.parse(json, User.class);
		
		Assert.assertEquals(u.name, "fernando");
		Assert.assertEquals(u.age, 20);
		Assert.assertEquals(u.money, 123.57, 0.5);
		
		json = "{\"name\":\"raul\", \"age\":203, \"money\":66.05}";

		u = parser.parse(json, User.class);
		
		Assert.assertEquals(u.name, "raul");
		Assert.assertEquals(u.age, 203);
		Assert.assertEquals(u.money, 66.05, 0.5);
		
	}
	
	@Test
	public void testParsingJsonArraysToJavaLists(){
				
		String json = "[{\"name\":\"fernando\", \"age\":20, \"money\":123.57 }]";
		List<User> users = parser.parse(json, new TypeToken<List<User>>(){}.getType());
		Assert.assertEquals(1, users.size());
		assertEquals(users.get(0), new User("fernando", 20, 123.57));
		
		json = "[]";
		List<User> users2 = parser.parse(json, new TypeToken<List<User>>(){}.getType());
		Assert.assertEquals(0, users2.size());
		
		json = "[{\"name\":\"fernando\", \"age\":20, \"money\":123.57 }, {\"name\":\"raul\", \"age\":22, \"money\":120.5 }]";
		List<User> users3 = parser.parse(json, new TypeToken<List<User>>(){}.getType());
		Assert.assertEquals(2, users3.size());
		assertEquals(users3.get(0), new User("fernando", 20, 123.57));
		assertEquals(users3.get(1), new User("raul", 22, 120.05));
		
	}

	
	class User{
		
		String name;
		int age;
		double money;
		
		public User(String name, int age, double money) {
			this.name = name;
			this.age = age;
			this.money = money;
		}
		
	}
	
	static void assertEquals(User u1, User u2){
		Assert.assertEquals(u1.name, u2.name);
		Assert.assertEquals(u1.age, u2.age);
		Assert.assertEquals(u1.money, u2.money,0.5);
	}
	
}








