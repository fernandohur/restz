package co.fernandohur.restz.test.unit;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import co.fernandohur.restz.AbstractRestz;
import co.fernandohur.restz.HttpRequestRestz;

public class TestAbstractRestz {

	@Test
	public void testToMap(){
		AbstractRestz res = new HttpRequestRestz();
		Map<String, Object> map = res.toMap("a","1","b",2);
		Assert.assertEquals(2, map.size());
		Assert.assertEquals(2, map.get("b"));
		Assert.assertEquals("1", map.get("a"));
	}
	
}
