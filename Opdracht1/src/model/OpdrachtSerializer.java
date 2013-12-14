package model;

import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import persistence.interfaces.ICSVSerializable;
import utils.Datum;

/**
 * A concrete serializer / deserializer strategy for Opdracht objects.
 * 
 * @author Wim Ombelets
 * @version 20131213-01 - initial commit
 *
 */
public class OpdrachtSerializer implements ICSVSerializable<Object> {

	private Character ps;
	private Character mvs;
	
	public OpdrachtSerializer() { 
		CSVSerializer serializer = new CSVSerializer();
		ps = serializer.getPropertySeparator();
		mvs = serializer.getMultiValueSeparator();
	}
	
	public String serialize(Object obj) throws IllegalArgumentException {
		if(!(obj instanceof Opdracht)) {
			throw new IllegalArgumentException("Can only serialize objects of type Opdracht.");
		}
		
		Opdracht o = (Opdracht)obj;
		StringBuilder csvStringBuilder = new StringBuilder();
		
		csvStringBuilder.append(o.getVraag() + ps); 
		
		for(int i=0; i<o.getAntwoordHints().length; i++) {
			csvStringBuilder.append(o.getAntwoordHints()[i]);
			if(i != o.getAntwoordHints().length - 1)
				csvStringBuilder.append(mvs);
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

	public Opdracht deserialize(String csvString) throws IllegalArgumentException, NumberFormatException {
		Opdracht o = null;
		
		try {
			String[] values = csvString.split(ps.toString());
			String vraag = values[0];
			String[] antwoordHints = values[1].split(mvs.toString());
			String juisteAntwoord = values[2];
			int maxAantalPogingen;
			int maxAntwoordTijd;
			try {
				maxAantalPogingen = Integer.parseInt(values[3]);
				maxAntwoordTijd = Integer.parseInt(values[4]);
			}
			catch(NumberFormatException e) {
				throw e;
			}
			OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie.valueOf(values[5]);
			Leraar auteur = Leraar.valueOf(values[6]);
			Datum datumRegistratie = new Datum(values[7]);
			
			o = new Opdracht(vraag, antwoordHints, juisteAntwoord, maxAantalPogingen, maxAntwoordTijd, opdrachtCategorie, auteur, datumRegistratie);
		}
		catch(IllegalArgumentException e) {
			throw e;
		}
		
		return o;
	}
	
}