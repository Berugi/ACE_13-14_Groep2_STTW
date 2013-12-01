package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;

import javax.swing.border.LineBorder;

/**
 * This class contains the GUI for the Quiz Application
 * @author Tom Vaes
 * @version 20131109-01 - initial version.
 * @version 20131201-01 - modified by Wim Ombelets - coupling of UI
 *
 */

public class QuizUI extends JFrame {
	
	private JButton rangschikButton;
	private JButton toevoegButton;
	private JButton verwijderButton;
	private JComboBox<?> sorteerComboBox;
	private JCheckBox isUniekeDeelnameChkBox;
	private JCheckBox isTestChkBox;
	private JLabel lblOnderwerp;
	private JButton btnNewButton;
	private JTextField textField;
	private JLabel lblKlas;
	private JComboBox<String> comboBoxKlas;
	private JLabel lblAuteur;
	private JLabel lblQuizStatus;
	private JComboBox<Leraar> auteurComboBox;
	private JComboBox<QuizStatus> quizStatusComboBox;
	
	public QuizUI() {
		super("Aanmaken nieuwe Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		
		super.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		bottomPanel.setBounds(0, 116, 843, 422);
		mainPanel.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JComboBox<?> comboBox = new JComboBox<Object>();
		comboBox.setBounds(229, 23, 117, 22);
		bottomPanel.add(comboBox);
		
		JComboBox<?> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(229, 81, 117, 22);
		bottomPanel.add(comboBox_1);
		
		JButton btnSorteer = new JButton("^^^^^^^^^");
		btnSorteer.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSorteer.setBounds(574, 90, 148, 40);
		bottomPanel.add(btnSorteer);
		
		JButton btnAdd = new JButton(">>>");
		btnAdd.setBounds(370, 143, 97, 40);
		bottomPanel.add(btnAdd);
		
		JButton btnRemove = new JButton("<<<");
		btnRemove.setBounds(370, 186, 97, 40);
		bottomPanel.add(btnRemove);
		
		JLabel lblCategorie = new JLabel("categorie :");
		lblCategorie.setBounds(12, 26, 117, 16);
		bottomPanel.add(lblCategorie);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(608, 41, 56, 16);
		bottomPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(12, 84, 56, 16);
		bottomPanel.add(lblNewLabel_1);
		
		JList<?> list = new JList<Object>();
		list.setBounds(22, 143, 324, 253);
		bottomPanel.add(list);
		
		JList<?> list_1 = new JList<Object>();
		list_1.setBounds(493, 143, 324, 266);
		bottomPanel.add(list_1);
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		topPanel.setBounds(0, 0, 843, 103);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		lblOnderwerp = new JLabel("Onderwerp :");
		lblOnderwerp.setBounds(12, 9, 73, 16);
		topPanel.add(lblOnderwerp);
		
		comboBoxKlas = new JComboBox<String>();
		//comboBoxKlas.setModel(new DefaultComboBoxModel(new String[] {"", "1A", "2A", "3A", "4A", "5A", "6A"}));
		comboBoxKlas.setBounds(367, 6, 62, 22);
		topPanel.add(comboBoxKlas);
		
		textField = new JTextField();
		textField.setBounds(97, 6, 215, 22);
		topPanel.add(textField);
		textField.setColumns(10);
		
		lblKlas = new JLabel("Klas : ");
		lblKlas.setBounds(324, 9, 36, 16);
		topPanel.add(lblKlas);
		
		auteurComboBox = new JComboBox(Leraar.values());
		auteurComboBox.setBounds(494, 6, 100, 22);
		topPanel.add(auteurComboBox);
		
		lblAuteur = new JLabel("Auteur : ");
		lblAuteur.setBounds(442, 9, 51, 16);
		topPanel.add(lblAuteur);
		
		btnNewButton = new JButton("Registreer nieuwe quiz");
		btnNewButton.setBounds(12, 56, 819, 34);
		topPanel.add(btnNewButton);
		
		lblQuizStatus = new JLabel("Quiz Status :");
		lblQuizStatus.setBounds(606, 9, 74, 16);
		topPanel.add(lblQuizStatus);
		
		quizStatusComboBox = new JComboBox(QuizStatus.values());
		quizStatusComboBox.setBounds(692, 6, 125, 22);
		topPanel.add(quizStatusComboBox);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
	}

	public static void main(String [] args){
	QuizUI testQuiz = new QuizUI();
	testQuiz.setSize(861,587);
    //testQuiz.setMinimumSize(new Dimension(520,600));
    testQuiz.setVisible(true);
	}
}
