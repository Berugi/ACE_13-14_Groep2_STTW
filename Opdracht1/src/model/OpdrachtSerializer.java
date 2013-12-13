package model;

import persistence.interfaces.ICSVSerializable;

public class OpdrachtSerializer implements ICSVSerializable<Object> {

	public OpdrachtSerializer() { }
	
	public String serialize(Object o) {
		//concrete samenstelling van CSV string ipv toString() natuurlijk...
		return ((Opdracht)o).toString();
	}

	public Opdracht deserialize(String csvString) {
		Opdracht o = new Opdracht();
		//concrete invulling van de properties waarden op basis van de CSV string.
		return o;
	}
	
}
