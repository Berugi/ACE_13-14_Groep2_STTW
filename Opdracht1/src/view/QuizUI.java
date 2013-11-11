package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;

/**
 * This class contains the GUI for the Quiz Application
 * @author Tom Vaes
 * @version 20131109-01 - initial version.
 *
 */

public class QuizUI extends JFrame {
		
	private JLabel onderwerpLabel;
	private JLabel klasLabel;
	private JLabel auteurLabel;
	private JLabel quizStatusLabel;
	private JLabel opdrachtCategorieLabel;
	private JLabel sorteerLabel;
	private JLabel aantalOpdrachtenLabel;
	private JTextField OnderwepTextField;
	private JButton registreerButton;
	private JButton rangschikButton;
	private JButton toevoegButton;
	private JButton verwijderButton;
	private JComboBox klasComboBox;
	private JComboBox auteurComboBox;
	private JComboBox quizStatusComboBox;
	private JComboBox opdrachtCategorieComboBox;
	private JComboBox sorteerComboBox;
	private JCheckBox isUniekeDeelnameChkBox;
	private JCheckBox isTestChkBox;
	
	public QuizUI() {
		super("Aanmaken nieuwe Quiz");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		onderwerpLabel = new JLabel("Onderwerp : ");
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
		topPanel.add(onderwerpLabel,c);
		
		OnderwepTextField = new JTextField(50);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
	    c.gridy = 0;
		topPanel.add(OnderwepTextField,c);
		
		klasLabel = new JLabel("Klas : ");
		topPanel.add(klasLabel);
		
		klasComboBox = new JComboBox();
		topPanel.add(klasComboBox);
		
		auteurLabel = new JLabel("Auteur : ");
		topPanel.add(auteurLabel);
		
		auteurComboBox = new JComboBox(Leraar.values());
		topPanel.add(auteurComboBox);
		
		quizStatusLabel = new JLabel("Status : ");
		topPanel.add(quizStatusLabel);
		
		quizStatusComboBox = new JComboBox(QuizStatus.values());
		topPanel.add(quizStatusComboBox);
		
		registreerButton = new JButton("Registreer nieuwe quiz");
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 10;      //make this component tall
	    c.weightx = 0.0;
	    c.gridwidth = 8;
	    c.gridx = 0;
	    c.gridy = 1;
		topPanel.add(registreerButton,c);
		
		//label4 = 
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridBagLayout());
		
		opdrachtCategorieLabel = new JLabel("Toon opdrachten van categorie : ");
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
		bottomPanel.add(opdrachtCategorieLabel,c);
		
		opdrachtCategorieComboBox = new JComboBox(OpdrachtCategorie.values());
		bottomPanel.add(opdrachtCategorieComboBox);
		
		sorteerLabel = new JLabel("Sorteer opdrachten op : ");
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 1;
		bottomPanel.add(sorteerLabel,c);
		
		aantalOpdrachtenLabel = new JLabel("Aantal toegevoegde opdrachten :");
		bottomPanel.add(aantalOpdrachtenLabel);
		
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		
		super.setContentPane(mainPanel);
		
	}

	public static void main(String [] args){
	QuizUI testQuiz = new QuizUI();
	testQuiz.setSize(1080,400);
    //testQuiz.setMinimumSize(new Dimension(520,600));
    testQuiz.setVisible(true);
	}

}
