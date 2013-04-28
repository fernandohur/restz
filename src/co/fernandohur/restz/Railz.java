package co.fernandohur.restz;

import java.lang.reflect.Type;
import java.util.List;

public interface Railz<T> {

	public T find(Class<T> clazz, Object id);
	public T create(T object);
	public T update(Object id, T newObject);
	public void destroy(Object id);
	public List<T> getAll(Type clazz);
}
