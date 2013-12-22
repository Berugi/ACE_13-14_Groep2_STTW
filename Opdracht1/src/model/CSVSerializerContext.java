package model;

import persistence.interfaces.ICSVSerializable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import model.baseclasses.AbstractCSVSerializer;
import model.strategy.OpdrachtSerializer;
import model.strategy.QuizSerializer;
import model.baseclasses.OpdrachtBase;

/**
 * Concrete CSV Serializer class that can switch serializer strategy based on certain class types.
 * 
 * @author Wim Ombelets
 * @version 20131213-01 - initial commit
 * @version 20131214-01 - moved concrete method implementations here
 *
 */
public class CSVSerializerContext extends AbstractCSVSerializer {

	//data members
	private Character propertySeparator;
	private Character multiValueSeparator;
	private ICSVSerializable<Object> serializerStrategy;
	
	//getters & setters
	@Override
	public Character getPropertySeparator() {
		return propertySeparator;
	}

	@Override
	public void setPropertySeparator(Character propertySeparator) {
		this.propertySeparator = propertySeparator;
	}
	
	@Override
	public Character getMultiValueSeparator() {
		return multiValueSeparator;
	}

	@Override
	public void setMultiValueSeparator(Character multiValueSeparator) {
		this.multiValueSeparator = multiValueSeparator;
	}

	@Override
	public ICSVSerializable<Object> getSerializerStrategy() {
		return serializerStrategy;
	}

	@Override
	public void setSerializerStrategy(Object o) throws NotImplementedException {
		if (o instanceof Quiz) {
			this.serializerStrategy = new QuizSerializer();
		}
		else if(o instanceof OpdrachtBase) {
			this.serializerStrategy = new OpdrachtSerializer();
		}
		else throw new NotImplementedException();
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
	@Override
	public String serialize(Object o) {
		return getSerializerStrategy().serialize(o);
	}

	@Override
	public Object deserialize(String csvString) {
		return getSerializerStrategy().deserialize(csvString);
	}
	
}
