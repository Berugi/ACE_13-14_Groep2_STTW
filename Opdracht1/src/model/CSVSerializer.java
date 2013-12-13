package model;

import persistence.interfaces.ICSVSerializable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import model.baseclasses.AbstractCSVSerializer;

/**
 * Concrete CSV Serializer class that can switch serializer strategy based on certain class types.
 * 
 * @author Wim Ombelets
 * @version 20131213-01 - initial commit
 *
 */
public class CSVSerializer extends AbstractCSVSerializer {

	@Override
	public Character getPropertySeparator() {
		return super.getPropertySeparator();
	}

	@Override
	public void setPropertySeparator(Character propertySeparator) {
		super.setPropertySeparator(propertySeparator);
	}

	@Override
	public ICSVSerializable<Object> getSerializerStrategy() {
		return super.getSerializerStrategy();
	}

	@Override
	public void setSerializerStrategy(Object o) throws NotImplementedException {
		super.setSerializerStrategy(o);
	}

	@Override
	public String serialize(Object o) {
		return super.serialize(o);
	}

	@Override
	public Object deserialize(String csvString) {
		return super.deserialize(csvString);
	}

	
	
}
