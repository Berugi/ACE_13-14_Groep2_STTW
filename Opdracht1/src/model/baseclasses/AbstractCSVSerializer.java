package model.baseclasses;

import persistence.interfaces.ICSVSerializable;

/**
 * Abstract representation of a CSV (de)serialization class that supports serialization strategy switching.
 * 
 * @author Wim Ombelets
 * @version 20131214-01 - initial commit
 *
 */
public abstract class AbstractCSVSerializer {	

	//getters & setters
	public abstract Character getPropertySeparator();

	public abstract void setPropertySeparator(Character propertySeparator);
	
	public abstract Character getMultiValueSeparator();

	public abstract void setMultiValueSeparator(Character multiValueSeparator);

	public abstract ICSVSerializable<Object> getSerializerStrategy();

	public abstract void setSerializerStrategy(Object o);
	
	//methods
	public abstract String serialize(Object o);
	
	public abstract Object deserialize(String csvString);
}
