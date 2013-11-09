package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class contains the GUI for the Quiz Application
 * @author Tom Vaes
 * @version 20131109-01 - initial version.
 *
 */

public class QuizUI {
	
	//Variable naming to adapt
	private JLabel onderwerpLabel;
	private JLabel klasLabel;
	private JLabel auteurLabel;
	private JLabel label4;
	private JLabel label5;
	private JTextField OnderwepTextField;
	private JButton registreerButton;
	private JComboBox klasComboBox;
	private JComboBox auteurComboBox;
	
	public QuizUI(){
		super("Aanmaken nieuwe Quiz");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		//setLayout(new FlowLayout() );
		
		onderwerpLabel = new JLabel("Onderwerp : ");
		topPanel.add(onderwerpLabel);
		
		OnderwepTextField = new JTextField(50);
		topPanel.add(OnderwepTextField);
		
		klasLabel = new JLabel("Klas : ");
		topPanel.add(klasLabel);
		
		klasComboBox = new JComboBox();
		topPanel.add(klasComboBox);
		
		auteurLabel = new JLabel("Auteur : ");
		topPanel.add(auteurLabel);
		
		auteurComboBox = new JComboBox();
		topPanel.add(auteurComboBox);
				
		registreerButton = new JButton("Registreer nieuwe quiz");
		topPanel.add(registreerButton);
		//label4 = new JLabel("");
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
	}

	public static void main(String [] args){
	QuizUI testQuiz = new QuizUI();
	testQuiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	testQuiz.setSize(350,150);
	testQuiz.setVisible(true);
	}

}
