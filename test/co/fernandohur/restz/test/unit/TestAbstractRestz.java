package co.fernandohur.restz.test.unit;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import co.fernandohur.restz.AbstractRestz;
import co.fernandohur.restz.DefaultRestz;

public class TestAbstractRestz {

	@Test
	public void testToMap(){
		AbstractRestz res = new DefaultRestz();
		Map<String, Object> map = res.toMap("a","1","b",2);
		Assert.assertEquals(true, map.containsKey("a"));
		Assert.assertEquals(true, map.containsKey("b"));
		Assert.assertEquals(2, map.size());
		Assert.assertEquals(2, map.get("b"));
		Assert.assertEquals("1", map.get("a"));
		
		try {
			res.toMap("a");
			Assert.fail();
		} catch (IllegalArgumentException e) {
			// all is good :)
		}
	}
	
}
