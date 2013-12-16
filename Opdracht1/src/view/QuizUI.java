package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;

import javax.swing.border.LineBorder;

import config.IniFileManager;

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
	private JTextField txtOnderwerp;
	private JLabel lblKlas;
	private JComboBox<String> comboBoxKlas;
	private JLabel lblAuteur;
	private JLabel lblQuizStatus;
	private JComboBox<Leraar> auteurComboBox;
	private JComboBox<QuizStatus> quizStatusComboBox;
	private JTable table;
	
	public QuizUI() {
		super(IniFileManager.getInstance().getProperty("apptitle") 
				+ " (ContextType: " + IniFileManager.getInstance().getProperty("persistencemethod") + ")" );
		setResizable(Boolean.parseBoolean(IniFileManager.getInstance().getProperty("appresizable")));
		int width = Integer.parseInt(IniFileManager.getInstance().getProperty("appwidth"));
		int height = Integer.parseInt(IniFileManager.getInstance().getProperty("appheight"));
		setSize(816, 547);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		
		super.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		bottomPanel.setBounds(0, 84, 843, 422);
		mainPanel.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JComboBox<?> cbOpdrachtCat = new JComboBox<Object>();
		cbOpdrachtCat.setBounds(229, 23, 117, 22);
		bottomPanel.add(cbOpdrachtCat);
		
		JComboBox<?> cbSorteerOpdr = new JComboBox<Object>();
		cbSorteerOpdr.setBounds(229, 58, 117, 22);
		bottomPanel.add(cbSorteerOpdr);
		
		JButton btnSorteer = new JButton("^^^^^^^^^");
		btnSorteer.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSorteer.setBounds(493, 70, 324, 27);
		bottomPanel.add(btnSorteer);
		
		JButton btnAdd = new JButton(">>>");
		btnAdd.setBounds(370, 143, 97, 40);
		bottomPanel.add(btnAdd);
		
		JButton btnRemove = new JButton("<<<");
		btnRemove.setBounds(370, 186, 97, 40);
		bottomPanel.add(btnRemove);
		
		JLabel lblCategorie = new JLabel("Toon opdrachten van categorie :");
		lblCategorie.setBounds(12, 26, 194, 16);
		bottomPanel.add(lblCategorie);
		
		JLabel lblAantalOpdrachten = new JLabel("Aantal toegevoegde opdrachten :");
		lblAantalOpdrachten.setBounds(493, 41, 201, 16);
		bottomPanel.add(lblAantalOpdrachten);
		
		JLabel lblSorteer = new JLabel("Sorteer opdrachten op :");
		lblSorteer.setBounds(12, 61, 148, 16);
		bottomPanel.add(lblSorteer);
		
		JList<?> listOpdrachten = new JList<Object>();
		listOpdrachten.setBounds(22, 143, 324, 253);
		bottomPanel.add(listOpdrachten);
		
		table = new JTable();
		table.setBounds(507, 278, 274, -121);
		bottomPanel.add(table);
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		topPanel.setBounds(0, 0, 843, 79);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		lblOnderwerp = new JLabel("Onderwerp :");
		lblOnderwerp.setBounds(12, 9, 73, 16);
		topPanel.add(lblOnderwerp);
		
		comboBoxKlas = new JComboBox<String>();
		//comboBoxKlas.setModel(new DefaultComboBoxModel(new String[] {"", "1A", "2A", "3A", "4A", "5A", "6A"}));
		comboBoxKlas.setBounds(367, 6, 62, 22);
		topPanel.add(comboBoxKlas);
		
		txtOnderwerp = new JTextField();
		txtOnderwerp.setBounds(97, 6, 215, 22);
		topPanel.add(txtOnderwerp);
		txtOnderwerp.setColumns(10);
		
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
		btnNewButton.setBounds(12, 38, 819, 34);
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
}
