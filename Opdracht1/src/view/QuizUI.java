package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import model.baseclasses.Opdracht;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;

import javax.swing.border.LineBorder;

import config.IniFileManager;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

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
	private JComboBox<OpdrachtCategorie> opdrCategorieCb;
	private JComboBox<QuizStatus> quizStatusComboBox;
	private JTable table;
	private JList listOpdrachten;
	private JList listQuizen;
	
	//for test purposes
	private String[] Leerjaren = {"1","2","3","4","5","6"};
	private DefaultListModel testOpdracht = new DefaultListModel();
	private DefaultListModel testQuiz = new DefaultListModel();
	private String[] tableColumNames = {"Opdracht","Score"};
	private Object [] [] tableData = {{"Test1","1"},{"Test2","2"}};
	//private DefaultTableModel tableData;
	
	//to be placed in the controller.
	public static OpdrachtCatalogus opdrachtcatalogus = null;
	public static QuizCatalogus quizcatalogus = null;
	
	public QuizUI(QuizCatalogus quizcl, OpdrachtCatalogus opdrachtcl) {
		super(IniFileManager.getInstance().getProperty("apptitle") 
				+ " (ContextType: " + IniFileManager.getInstance().getProperty("persistencemethod") + ")" );
		setResizable(Boolean.parseBoolean(IniFileManager.getInstance().getProperty("appresizable")));
		int width = Integer.parseInt(IniFileManager.getInstance().getProperty("appwidth"));
		int height = Integer.parseInt(IniFileManager.getInstance().getProperty("appheight"));
		setSize(854, 676);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//to be placed in the controller.
		opdrachtcatalogus = opdrachtcl;
		quizcatalogus = quizcl;
		
		JPanel mainPanel = new JPanel();
		
		//testing - to be placed in the controller.
		for (Opdracht opdracht : opdrachtcatalogus.getCatalogus())
		{
			testOpdracht.addElement(opdracht.toString());
		}
		//testOpdracht.addElement("Opdracht 1");
		//testOpdracht.addElement("Opdracht 2");
		//testOpdracht.addElement("Opdracht 3");
		//testOpdracht.addElement("Opdracht 4");
		
		super.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		bottomPanel.setBounds(0, 217, 843, 422);
		mainPanel.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		opdrCategorieCb = new JComboBox(OpdrachtCategorie.values());
		opdrCategorieCb.setBounds(229, 23, 117, 22);
		bottomPanel.add(opdrCategorieCb);
		
		JComboBox<?> cbSorteerOpdr = new JComboBox<Object>();
		cbSorteerOpdr.setBounds(229, 58, 117, 22);
		bottomPanel.add(cbSorteerOpdr);
		
		rangschikButton = new JButton("^^^^^^^^^");
		rangschikButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		rangschikButton.setBounds(493, 70, 324, 27);
		bottomPanel.add(rangschikButton);
		
		toevoegButton = new JButton(">>>");
		toevoegButton.setEnabled(false);
		toevoegButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = listOpdrachten.getSelectedIndex();
				tableData.
				testOpdracht.remove(index);

			    int size = testOpdracht.getSize();

			    if (size == 0) { //Nobody's left, disable firing.
			    	toevoegButton.setEnabled(false);

			    } else { //Select an index.
			        if (index == testOpdracht.getSize()) {
			            //removed item in last position
			            index--;
			        }

			        listOpdrachten.setSelectedIndex(index);
			        listOpdrachten.ensureIndexIsVisible(index);
			    }
						}
					});
		toevoegButton.setBounds(370, 143, 97, 40);
		bottomPanel.add(toevoegButton);
		
		verwijderButton = new JButton("<<<");
		verwijderButton.setEnabled(false);
		verwijderButton.setBounds(370, 186, 97, 40);
		bottomPanel.add(verwijderButton);
		
		JLabel lblCategorie = new JLabel("Toon opdrachten van categorie :");
		lblCategorie.setBounds(12, 26, 194, 16);
		bottomPanel.add(lblCategorie);
		
		JLabel lblAantalOpdrachten = new JLabel("Aantal toegevoegde opdrachten :");
		lblAantalOpdrachten.setBounds(493, 41, 201, 16);
		bottomPanel.add(lblAantalOpdrachten);
		
		JLabel lblSorteer = new JLabel("Sorteer opdrachten op :");
		lblSorteer.setBounds(12, 61, 148, 16);
		bottomPanel.add(lblSorteer);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(12, 143);
		scrollPane.setSize(324, 266);
		bottomPanel.add(scrollPane);
				
		listOpdrachten = new JList(testOpdracht);
		scrollPane.setViewportView(listOpdrachten);
		listOpdrachten.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false)
				{
					if(listOpdrachten.getSelectedIndex() == -1)
					{//no selection
						toevoegButton.setEnabled(false);
					}
					else
					{//Selection
						toevoegButton.setEnabled(true);
					}
				}
			}
		});
		
		
		table = new JTable(tableData, tableColumNames);
		table.setBounds(507, 278, 274, -121);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane2 = new JScrollPane(table);
		scrollPane2.setLocation(493, 143);
		scrollPane2.setSize(338, 266);
		bottomPanel.add(scrollPane2);
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		topPanel.setBounds(0, 0, 843, 213);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		for (Quiz quiz : quizcatalogus.getCatalogus())
		{
			testQuiz.addElement(quiz.toString());
		}
		
		lblOnderwerp = new JLabel("Onderwerp :");
		lblOnderwerp.setBounds(12, 9, 73, 16);
		topPanel.add(lblOnderwerp);
		
		comboBoxKlas = new JComboBox(Leerjaren);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Quiz nieuweQuiz = new Quiz();
				
				//quizcatalogus.add(nieuweQuiz);
			}
		});
		
		lblQuizStatus = new JLabel("Quiz Status :");
		lblQuizStatus.setBounds(606, 9, 74, 16);
		topPanel.add(lblQuizStatus);
		
		quizStatusComboBox = new JComboBox(QuizStatus.values());
		quizStatusComboBox.setBounds(692, 6, 125, 22);
		topPanel.add(quizStatusComboBox);
		
		listQuizen = new JList(testQuiz);
		listQuizen.setBounds(66, 138, 724, -34);
		topPanel.add(listQuizen);
		
		JScrollPane scrollPane_1 = new JScrollPane(listQuizen);
		scrollPane_1.setBounds(12, 85, 819, 115);
		topPanel.add(scrollPane_1);
		
		
		
		

	}
}
