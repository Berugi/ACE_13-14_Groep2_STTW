package model;

import persistence.interfaces.ICSVSerializable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import model.baseclasses.AbstractCSVSerializer;

public class CSVSerializer extends AbstractCSVSerializer {

	@Override
	public Character getPropertySeparator() {
		// TODO Auto-generated method stub
		return super.getPropertySeparator();
	}

	@Override
	public void setPropertySeparator(Character propertySeparator) {
		// TODO Auto-generated method stub
		super.setPropertySeparator(propertySeparator);
	}

	@Override
	public ICSVSerializable<Object> getSerializerStrategy() {
		// TODO Auto-generated method stub
		return super.getSerializerStrategy();
	}

	@Override
	public void setSerializerStrategy(Object o) throws NotImplementedException {
		// TODO Auto-generated method stub
		super.setSerializerStrategy(o);
	}

	@Override
	public String serialize(Object o) {
		// TODO Auto-generated method stub
		return super.serialize(o);
	}

	@Override
	public Object deserialize(String csvString) {
		// TODO Auto-generated method stub
		return super.deserialize(csvString);
	}

	
	
}
