package persistence;

import persistence.interfaces.ICSVSerializable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Concrete CSV Serializer class that can switch serializer strategy based on certain class types.
 * 
 * @author Wim Ombelets
 * @version 20131213-01 - initial commit
 * @version 20131214-01 - moved concrete method implementations here
 * @version 20131222-01 - removed dependency on abstract supertype
 *
 */
public class CSVSerializerContext {

	//data members
	private Character propertySeparator;
	private Character multiValueSeparator;
	private ICSVSerializable<Object> serializerStrategy;
	
	//getters & setters
	public Character getPropertySeparator() {
		return propertySeparator;
	}
	
	public void setPropertySeparator(Character propertySeparator) {
		this.propertySeparator = propertySeparator;
	}
	
	public Character getMultiValueSeparator() {
		return multiValueSeparator;
	}

	public void setMultiValueSeparator(Character multiValueSeparator) {
		this.multiValueSeparator = multiValueSeparator;
	}

	public void setSerializerStrategy(ICSVSerializable<Object> serializerStrategy) throws NotImplementedException {
		this.serializerStrategy = serializerStrategy;
	}
	
	//constructors
	
	/**
	 * Create a new CSVSerializer object and use the default property and multivalue separator characters.
	 */
	public CSVSerializerContext() {
		setPropertySeparator(';');
		setMultiValueSeparator(',');
	}
	
	/**
	 * Create a new CSVSerializer object and provide your own property and multivalue separator characters.
	 * 
	 * @param propertySeparator
	 * @param multiValueSeparator
	 */
	public CSVSerializerContext(Character propertySeparator, Character multiValueSeparator) {
		setPropertySeparator(propertySeparator);
		setMultiValueSeparator(multiValueSeparator);
	}
	
	//methods
	public String serialize(Object o) {
		return this.serializerStrategy.serialize(o);
	}

	public Object deserialize(String csvString) {
		return this.serializerStrategy.deserialize(csvString);
	}
	
}
