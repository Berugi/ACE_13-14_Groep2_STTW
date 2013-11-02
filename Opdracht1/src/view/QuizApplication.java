package view;

import java.util.Scanner;

/**
 * 
 * This class is just a temporary testing ground for the model
 * and will be replaced at some point by a Swing UI
 * @author wim ombelets
 * @version 20131102-01 - initial commit
 *
 */
public class QuizApplication {

	//data members
	private int choice;
	
	public static void main(String[] args) {
		//show the menu a first time
		showMenu();
		
		
	}

	private static String showMenu() {
		String menu = "*** QuizApplicatie ***\n"
				+ "1. Beheren van opdrachten (leraar)\n"
				+ "2. Beheren van quizzen/testen (leraar)\n"
				+ "3. Deelnemen aan quiz(leerling)\n"
				+ "4. Overzicht scores(leraar)\n"
				+ "5. Quiz rapport (deelnemer quiz)\n"
				+ "6. Quiz lijsten\n"
				+ "7. Instellingen van de quiz applicatie\n\n"
				+ "0. Stoppen\n";
		
		return menu;	
	}
}
