package view;

import java.util.Scanner;

/**
 * 
 * This class is just a temporary testing ground for the model
 * and will be replaced at some point by a Swing UI
 * @author wim ombelets
 * @version 20131102-01 - initial commit
 * @version 20131103-01 - switch toegevoegd - Tom Scheepers
 * 
 */
public class QuizApplication {

	//data members
	private static String ingave;
	private static int choice;
	private Scanner sc;
	
	public static void main(String[] args) {
		//show the menu a first time
		Scanner sc = new Scanner(System.in);
		showMenu();
		System.out.print("Keuze: ");
		ingave = sc.nextLine();
		try{
		choice = Integer.parseInt(ingave);
		}
		catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		switch (choice){
		case 1:
		{//Beheren van opdrachten
			break;
		}
		case 2:
		{//Beheren van quizzen/testen
			break;
		}
		case 3:
		{//Deelnemem aan quiz
			break;
		}
		case 4:
		{//Overzicht scores
			break;
		}
		case 5:
		{//Quiz report
			break;
		}
		case 6:
		{//Quiz lijsten
			break;
		}
		case 7:
		{//Instellingen van de quiz applicatie
			break;
		}
		default:
		{//verkeerde optie
			break;
		}
		}
		
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
				+ "0. Stoppen\n\n";
		
		return menu;	
	}
}
