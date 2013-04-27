package co.fernandohur.restz;

import java.util.List;

public interface Railz {

	public <T> T find(Class<T> clazz, Object id);
	public <T> T create(T object);
	public <T> T update(Object id, T newObject);
	public void destroy(Object id);
	public <T> List<T> getAll(Class<T> clazz);
}
