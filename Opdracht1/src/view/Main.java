package view;

import java.util.Scanner;

public class Main {

	//data members
		private static String ingave;
		private static int choice;
		private static Scanner sc;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			choice =-1;
			
			while (choice < 0)
			{
				System.out.print(showMenu());
				System.out.print("Maak je Keuze (0-7): ");
				
				Scanner sc = new Scanner(System.in);
				
				ingave = sc.nextLine();
				try{
				choice = Integer.parseInt(ingave);
				}
				catch (IllegalArgumentException e){
					e.printStackTrace();
				}
				
				switch (choice)
				{
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
						choice = -1;
						
						//break;
					}
				}//end switch
				
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