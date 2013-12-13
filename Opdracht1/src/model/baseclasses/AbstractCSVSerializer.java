package model.baseclasses;

import model.Opdracht;
import model.OpdrachtSerializer;
import model.Quiz;
import model.QuizSerializer;
import persistence.interfaces.ICSVSerializable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class AbstractCSVSerializer {

	//data members
	private Character propertySeparator;
	//private Character keyValueSeparator;
	private ICSVSerializable<Object> serializerStrategy;

	//getters & setters
	public Character getPropertySeparator() {
		return propertySeparator;
	}

	public void setPropertySeparator(Character propertySeparator) {
		this.propertySeparator = propertySeparator;
	}
	
	public ICSVSerializable<Object> getSerializerStrategy() {
		return serializerStrategy;
	}

	public void setSerializerStrategy(Object o) throws NotImplementedException {
		if (o instanceof Quiz) {
			this.serializerStrategy = new QuizSerializer();
		}
		else if(o instanceof Opdracht) {
			this.serializerStrategy = new OpdrachtSerializer();
		}
		else throw new NotImplementedException();
	}

	//constructor
	public AbstractCSVSerializer() {
		setPropertySeparator(';');
		//setKeyValueSeparator(':');
	}
	
	//methods
	public String serialize(Object o) {
		return getSerializerStrategy().serialize(o);
	}
	
	public Object deserialize(String csvString) {
		return getSerializerStrategy().deserialize(csvString);
	}
}
