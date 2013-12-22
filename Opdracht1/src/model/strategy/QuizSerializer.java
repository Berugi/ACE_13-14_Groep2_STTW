package model.strategy;

import model.CSVSerializerContext;
import model.Quiz;
import model.enums.Leraar;
import model.interfaces.IQuizStatus;
import persistence.interfaces.ICSVSerializable;
import utils.Datum;

/**
 * A concrete serializer / deserializer strategy for Quiz objects.
 * 
 * @author Wim Ombelets
 * @version 20131213-01 - initial commit
 * @version 20131213-02 - added concrete implementations of serialize and deserialize
 *
 */
public class QuizSerializer implements ICSVSerializable<Object> {
	
	private Character ps;
	private Character mvs;
	
	public QuizSerializer() {
		CSVSerializerContext serializer = new CSVSerializerContext();
		ps = serializer.getPropertySeparator();
		mvs = serializer.getMultiValueSeparator();
	}
	
	public String serialize(Object o) throws IllegalArgumentException {
		if(!(o instanceof Quiz))
			throw new IllegalArgumentException("Can only serialize objects of type Quiz.");
		
		Quiz q = (Quiz)o;
		StringBuilder csvStringBuilder = new StringBuilder();
		csvStringBuilder.append(q.getOnderwerp() + ps);
		
		for(int i=0; i<q.getLeerjaren().length; i++) {
			csvStringBuilder.append(q.getLeerjaren()[i]);
			if(i != q.getLeerjaren().length -1)
				csvStringBuilder.append(mvs);
		}
		
		csvStringBuilder.append(q.getIsTest().toString() + ps
				+ q.getIsUniekeDeelname() + ps
				+ q.getAuteur().toString() + ps
				+ q.getDatumRegistratie().toString() + ps
				+ q.getQuizStatus().toString());		
		
		return csvStringBuilder.toString();
	}
	
	public Quiz deserialize(String csvString) throws IllegalArgumentException, NumberFormatException {
		
		Quiz q = null;
		try {
			String[] values = csvString.split(ps.toString());
			String onderwerp = values[0];
			String[] ljStrings = values[1].split(",");
			int[] leerjaren = new int[ljStrings.length];
			
			for(int i=0; i<ljStrings.length; i++) {
				try {
					leerjaren[i] = Integer.parseInt(ljStrings[1]);
				}
				catch(NumberFormatException e) {
					throw e;
				}
			}
			
			boolean isTest = Boolean.parseBoolean(values[2]);
			boolean isUniekeDeelname = Boolean.parseBoolean(values[3]);
			Leraar auteur = Leraar.valueOf(values[4]);
			Datum regDatum = new Datum(values[5]);
			
			//IQuizStatus geef ik momenteel door als INCONSTRUCTIE omdat ik nog niet goed zie hoe ik die moet hercreëren vanuit CSV - Wim (20131213)
			IQuizStatus status = new IQuizStatus() {
				public void zetQuizInOPENGESTELD(Quiz quizContext) {}
				public void zetQuizInINCONSTRUCTIE(Quiz quizContext) {}
				public void zetQuizInAFGEWERKT(Quiz quizContext) {}
				public void zetQuiqInLAATSTEKANS(Quiz quizContext) {}
			};
			status.zetQuizInINCONSTRUCTIE(q);
			
			q = new Quiz(onderwerp, leerjaren, isTest, isUniekeDeelname, auteur, regDatum, status);
		}
		catch(IllegalArgumentException e) {
			throw e;
		}
		
		return q;
	}
	
}
