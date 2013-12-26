package view;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * This class is just a temporary testing ground for the model
 * and will be replaced at some point by a Swing UI
 * @author wim ombelets
 * @version 20131102-01 - initial commit
 * @version 20131103-01 - switch toegevoegd - Tom Scheepers
 * @version 20131201-01 - while toegevoegd - Tom Vaes
 */
public class QuizApplication {

	//data members
		private static String ingave;
		private static int choice;
		private static Scanner sc;
		
		//public static void main(String[] args) {
			// TODO Auto-generated method stub
		
		public QuizApplication() {
			choice =-1;
			Scanner sc = new Scanner(System.in);
			
			while (choice < 0)
			{
				
				System.out.print(showMenu());
				System.out.print("Maak je Keuze (0-7): ");

				ingave = sc.nextLine();
				try{
				choice = Integer.parseInt(ingave);
				}
				catch (IllegalArgumentException e){
					e.printStackTrace();
				}
				
				switch (choice)
				{
					case 0:
					{
						sc.close();
						System.out.println("Programma beeindigd!\n");
						System.exit(0);
					}
					case 1:
					{//Beheren van opdrachten
						choice = -1;
						System.out.print("Deze optie is nog niet geïmplementeerd !\n");
						break;
					}
					case 2:
					{//Beheren van quizzen/testen
						QuizUI testQuiz = new QuizUI();
						testQuiz.setSize(861,587);
					    //testQuiz.setMinimumSize(new Dimension(520,600));
					    testQuiz.setVisible(true);
					    choice = -1;
					    break;
					    
					}
					case 3:
					{//Deelnemem aan quiz
						choice = -1;
						System.out.print("Deze optie is nog niet geïmplementeerd !\n");
						break;
					}
					case 4:
					{//Overzicht scores
						choice = -1;
						System.out.print("Deze optie is nog niet geïmplementeerd !\n");
						break;
					}
					case 5:
					{//Quiz report
						choice = -1;
						System.out.print("Deze optie is nog niet geïmplementeerd !\n");
						break;
					}
					case 6:
					{//Q
						choice = -1;
						System.out.print("Deze optie is nog niet geïmplementeerd !\n");
						break;
					}
					case 7:
					{//Instellingen van de quiz applicatie
						choice = -1;
						System.out.print("Deze optie is nog niet geïmplementeerd !\n");
						break;
					}
					default:
					{//verkeerde optie
						choice = -1;
						System.out.print("Gelieve een nummer tussen 1 en 7 in te geven. 0 om te eindigen.");
						break;
					}
				}//end switch
			}//end while loop
		System.console().flush();
		}//end main
		
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
		
		private void quizSubMenu(){
			
		}
		
		
		private static String showSubMenuQuiz(){
			String subMenu = "Beheren van quizzen/testen (leraar)\n"
					+ "1. Aanmaken Quiz\n"
					+ "2. Verwijderen Quiz\n"
					+ "3. Quiz beheer\n\n"
					+ "0. Terug\n";
			
			return subMenu;
		}

	}
