package tests.model;

import model.ObservableOpdrachtCatalogus;
import model.ObservableQuizCatalogus;
import model.Quiz;
import model.baseclasses.Opdracht;

public class DataTest {
	
	public DataTest(ObservableQuizCatalogus qc, ObservableOpdrachtCatalogus oc){
		
		System.out.println("\nQuizen:\n");
		for(Quiz quiz: qc.quizen){
			System.out.println(quiz.toString());
		}

		System.out.println("\nOpdrachten:\n");
		for(Opdracht opdracht: oc.getCatalogus()){
			System.out.println(opdracht.toString());
		}
		
		System.out.println("\n\n");
	}

}
