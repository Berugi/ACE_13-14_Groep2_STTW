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
 *
 */

public class QuizUI extends JFrame {
	private JButton rangschikButton;
	private JButton toevoegButton;
	private JButton verwijderButton;
	private JComboBox sorteerComboBox;
	private JCheckBox isUniekeDeelnameChkBox;
	private JCheckBox isTestChkBox;
	private JLabel lblOnderwerp;
	private JButton btnNewButton;
	private JTextField textField;
	private JLabel lblKlas;
	private JComboBox klasComboBox;
	private JLabel lblAuteur;
	private JLabel lblQuizStatus;
	private JComboBox auteurComboBox;
	
	public QuizUI() {
		super("Aanmaken nieuwe Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		
		super.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 116, 843, 422);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(141, 23, 117, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(141, 81, 117, 22);
		panel.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("^^^^^^^^^");
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton_1.setBounds(538, 81, 148, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(">>>");
		btnNewButton_2.setBounds(370, 143, 97, 40);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<<<");
		btnNewButton_3.setBounds(370, 186, 97, 40);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 843, 103);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		lblOnderwerp = new JLabel("Onderwerp :");
		lblOnderwerp.setBounds(12, 9, 73, 16);
		panel_1.add(lblOnderwerp);
		
		klasComboBox = new JComboBox();
		klasComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "1A", "2A", "3A", "4A", "5A", "6A"}));
		klasComboBox.setBounds(367, 6, 62, 22);
		panel_1.add(klasComboBox);
		
		textField = new JTextField();
		textField.setBounds(97, 6, 215, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblKlas = new JLabel("Klas : ");
		lblKlas.setBounds(324, 9, 36, 16);
		panel_1.add(lblKlas);
		
		auteurComboBox = new JComboBox(Leraar.values());
		auteurComboBox.setBounds(494, 6, 100, 22);
		panel_1.add(auteurComboBox);
		
		lblAuteur = new JLabel("Auteur : ");
		lblAuteur.setBounds(442, 9, 51, 16);
		panel_1.add(lblAuteur);
		
		btnNewButton = new JButton("Registreer nieuwe quiz");
		btnNewButton.setBounds(12, 56, 819, 34);
		panel_1.add(btnNewButton);
		
		lblQuizStatus = new JLabel("Quiz Status :");
		lblQuizStatus.setBounds(606, 9, 74, 16);
		panel_1.add(lblQuizStatus);
		
		JComboBox quizStatusComboBox = new JComboBox(QuizStatus.values());
		quizStatusComboBox.setBounds(692, 6, 125, 22);
		panel_1.add(quizStatusComboBox);
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
