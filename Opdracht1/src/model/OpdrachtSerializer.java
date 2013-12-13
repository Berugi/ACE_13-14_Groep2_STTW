package model;

import persistence.interfaces.ICSVSerializable;

/**
 * A concrete serializer / deserializer strategy for Opdracht objects.
 * 
 * @author Wim Ombelets
 * @version 20131213-01 - initial commit
 *
 */
public class OpdrachtSerializer implements ICSVSerializable<Object> {

	private Character ps;
	
	public OpdrachtSerializer() { 
		CSVSerializer serializer = new CSVSerializer();
		ps = serializer.getPropertySeparator();
	}
	
	public String serialize(Object obj) throws IllegalArgumentException {
		if(!(obj instanceof Opdracht)) {
			throw new IllegalArgumentException("Can only serialize objects of type Opdracht.");
		}
		
		Opdracht o = (Opdracht)obj;
		StringBuilder csvStringBuilder = new StringBuilder();
		
		//11;Wie vond het principe van de relativiteit uit?;Einstein;2;20;Natuurkunde;Pieter;2 december 2013;
		
		csvStringBuilder.append(o.getVraag() + ps); 
		
		for(int i=0; i<o.getAntwoordHints().length; i++) {
			csvStringBuilder.append(o.getAntwoordHints()[i]);
			if(i != o.getAntwoordHints().length - 1)
				csvStringBuilder.append(',');
		}
		
		csvStringBuilder.append(o.getJuisteAntwoord() + ps 
				+ o.getMaxAantalPogingen() + ps 
				+ o.getMaxAntwoordTijd() + ps
				+ o.getOpdrachtCategorie() + ps
				+ o.getAuteur().toString() + ps
				+ o.getDatumRegistratie().toString()
		);
		
		return csvStringBuilder.toString();
	}

	public Opdracht deserialize(String csvString) {
		Opdracht o = new Opdracht();
		//concrete invulling van de properties waarden op basis van de CSV string.
		return o;
	}
	
}
