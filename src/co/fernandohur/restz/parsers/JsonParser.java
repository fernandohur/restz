package co.fernandohur.restz.parsers;

import java.lang.reflect.Type;

public interface JsonParser {

	public <T> T parse(String json, Type type);
}
