package co.fernandohur.restz.parsers;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;

public class TypeHelper<T> implements Type{

	public Type getListType(){
		return new TypeToken<List<T>>(){}.getType();
	}
	
}
