package persistence.interfaces;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IPersistenceStrategy {
	
	Object read(Object o) throws NotImplementedException;
	Object read(String property, String value) throws NotImplementedException;
	Object create(Object o) throws NotImplementedException;
	Object update(Object o) throws NotImplementedException;
	void delete(Object o) throws NotImplementedException;
	
}
