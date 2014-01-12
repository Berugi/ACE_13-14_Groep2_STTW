package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.ObservableOpdrachtCatalogus;
import model.Quiz;
import model.ObservableQuizCatalogus;
import model.baseclasses.Opdracht;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;
import model.baseclasses.Opdracht;
import model.OpdrachtTableModel;
import controller.CreatieQuizController;

import javax.swing.border.LineBorder;

import config.IniFileManager;
import controller.OpstartController;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.util.Observable;
import java.util.Observer;

import utils.Datum;
import actionevents.QuizActionEvent;

/**
 * This class contains the GUI for the Quiz Application
 * @author Tom Vaes
 * @version 20131109-01 - initial version.
 * @version 20131201-01 - modified by Wim Ombelets - coupling of UI
 * @version 20140109-01 - Tom Scheepers - adjusted for implementation in QuizApp
 * @version 20140110-01 - Tom Scheepers - MVC ActionEvent + use real data from quizcatalogus and opdrachtcatalogus
 *
 */

public class CreateQuizView extends JPanel implements Observer, ActionListener, ListSelectionListener {
	
	private JButton rangschikButton;
	private JButton toevoegButton;
	private JButton verwijderButton;
	private JComboBox<?> sorteerComboBox;
	private JCheckBox isUniekeDeelnameChkBox;
	private JCheckBox isTestChkBox;
	private JLabel lblOnderwerp;
	private JButton btnNewQuiz;
	private JTextField txtOnderwerp;
	private JLabel lblKlas;
	private JComboBox<String> comboBoxKlas;
	private JLabel lblAuteur;
	private JLabel lblQuizStatus;
	private JComboBox<Leraar> auteurComboBox;
	private JComboBox opdrCategorieCb;
	private JComboBox quizStatusComboBox;
	private JTable table;
	private JList listOpdrachten;
	private JList listQuizen;
	private ActionListener actionlistener;
	private ListSelectionListener listselectionlistener;
	private ObservableQuizCatalogus quizcl;
	private ObservableOpdrachtCatalogus opdrachtcl;
	private DefaultListModel<Opdracht> defaultListModelOpdracht;
	private DefaultListModel<Quiz> defaultListModelQuiz;
	private String[] Leerjaren = {"1","2","3","4","5","6"};
	private JCheckBox chckbxIsUniekeDeelname;
	private JCheckBox chckbxIsTest;
	private OpdrachtTableModel opdrachtTableModel;
	private JTable tblAlleOpdrachten;
	private TableColumnModel tcm;

	//getters & setters
	
	public ActionListener getActionListener() {
		return actionlistener;
	}

	public void setActionListener(ActionListener listener) {

		if (listener != null)
			this.actionlistener = listener;
	}
	
	public ListSelectionListener getListSelectionListener(){
		return listselectionlistener;
	}
	
	/**
	 * Create the panel.
	 */
	public CreateQuizView() {
		quizcl = OpstartController.getQuizCatalogus();
		opdrachtcl = OpstartController.getOpdrachtCatalogus();
		Initialize();
	}

	private void Initialize(){
		
		defaultListModelOpdracht = new DefaultListModel<Opdracht>();
		defaultListModelQuiz = new DefaultListModel<Quiz>();
		
		quizRefresh();
		opdrachtRefresh(null);
		
		setLayout(null);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 244, 843, 427);
		bottomPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(bottomPanel);
		bottomPanel.setLayout(null);
		
		opdrCategorieCb = new JComboBox(OpdrachtCategorie.values());
		opdrCategorieCb.setBounds(229, 23, 117, 22);
		opdrCategorieCb.addActionListener(this);
		bottomPanel.add(opdrCategorieCb);
		
		JComboBox<?> cbSorteerOpdr = new JComboBox<Object>();
		cbSorteerOpdr.setBounds(229, 58, 117, 22);
		bottomPanel.add(cbSorteerOpdr);
		
		rangschikButton = new JButton("^^^^^^^^^");
		rangschikButton.setBounds(493, 70, 324, 27);
		rangschikButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		bottomPanel.add(rangschikButton);
		
		toevoegButton = new JButton(">>>");
		toevoegButton.setBounds(370, 143, 97, 40);
		toevoegButton.setEnabled(false);
		toevoegButton.setActionCommand("addOpdracht");
		toevoegButton.addActionListener(this);
		bottomPanel.add(toevoegButton);
		
		verwijderButton = new JButton("<<<");
		verwijderButton.setBounds(370, 186, 97, 40);
		verwijderButton.setEnabled(false);
		verwijderButton.setActionCommand("deleteOpdracht");
		verwijderButton.addActionListener(this);
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
		scrollPane.setBounds(12, 143, 324, 266);
		bottomPanel.add(scrollPane);
				
		listOpdrachten = new JList(defaultListModelOpdracht);
		scrollPane.setViewportView(listOpdrachten);
		//listOpdrachten.addListSelectionListener(this);
		/*
		String[] opdrachtColumnNames={"Vraag","Categorie","Score"};
		table = new JTable(null, opdrachtColumnNames);
		table.setBounds(507, 278, 274, -121);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane2 = new JScrollPane(table);
		scrollPane2.setLocation(493, 143);
		scrollPane2.setSize(338, 266);
		bottomPanel.add(scrollPane2);
		*/
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 843, 241);
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(topPanel);
		topPanel.setLayout(null);
		
		lblOnderwerp = new JLabel("Onderwerp :");
		lblOnderwerp.setBounds(12, 9, 73, 16);
		topPanel.add(lblOnderwerp);
		
		txtOnderwerp = new JTextField();
		txtOnderwerp.setBounds(97, 6, 215, 22);
		topPanel.add(txtOnderwerp);
		txtOnderwerp.setColumns(10);
		
		lblKlas = new JLabel("Klas : ");
		lblKlas.setBounds(324, 9, 36, 16);
		topPanel.add(lblKlas);
		
		comboBoxKlas = new JComboBox(Leerjaren);
		comboBoxKlas.setBounds(367, 6, 62, 22);
		topPanel.add(comboBoxKlas);
		
		lblAuteur = new JLabel("Auteur : ");
		lblAuteur.setBounds(442, 9, 51, 16);
		topPanel.add(lblAuteur);
		
		auteurComboBox = new JComboBox(Leraar.values());
		auteurComboBox.setBounds(494, 6, 100, 22);
		topPanel.add(auteurComboBox);
		
		lblQuizStatus = new JLabel("Quiz Status :");
		lblQuizStatus.setBounds(606, 9, 74, 16);
		topPanel.add(lblQuizStatus);
		
		quizStatusComboBox = new JComboBox(QuizStatus.values());
		quizStatusComboBox.setBounds(692, 6, 125, 22);
		topPanel.add(quizStatusComboBox);
		
		isTestChkBox = new JCheckBox("is test");
		isTestChkBox.setBounds(355, 37, 73, 25);
		topPanel.add(isTestChkBox);
		
		isUniekeDeelnameChkBox = new JCheckBox("is unieke deelname");
		isUniekeDeelnameChkBox.setBounds(442, 37, 145, 25);
		topPanel.add(isUniekeDeelnameChkBox);
		
		btnNewQuiz = new JButton("Registreer nieuwe quiz");
		btnNewQuiz.setActionCommand("newQuiz");
		btnNewQuiz.setBounds(12, 70, 819, 34);
		topPanel.add(btnNewQuiz);
		btnNewQuiz.addActionListener(this);
		
		listQuizen = new JList(defaultListModelQuiz);
		
		JScrollPane scrollPane_1 = new JScrollPane(listQuizen);
		scrollPane_1.setBounds(12, 115, 819, 115);
		topPanel.add(scrollPane_1);
		/*
		opdrachtTableModel = new OpdrachtTableModel(opdrachtcl);
		tblAlleOpdrachten = new JTable(opdrachtTableModel);
		tblAlleOpdrachten.setBounds(500, 180, 300, 500);
		TableColumn column = null;
		tcm = tblAlleOpdrachten.getColumnModel();
		for (int i = 0; i < 6; i++) {
		    column = tblAlleOpdrachten.getColumnModel().getColumn(i);
		    if (i == 0) {
		    	column.setPreferredWidth(150);
		     } else {
		    	column.setPreferredWidth(50);
		    }
		}
		bottomPanel.add(tblAlleOpdrachten);
		*/
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == rangschikButton) {
			
		} 
		else if (e.getSource()==btnNewQuiz){
			int[] lj = {Integer.parseInt(Leerjaren[comboBoxKlas.getSelectedIndex()])};
			
			try {
				Quiz q = new Quiz(0,txtOnderwerp.getText(),lj,chckbxIsTest.isSelected(), chckbxIsUniekeDeelname.isSelected(),
						(Leraar)auteurComboBox.getSelectedItem(),new Datum(),(QuizStatus)quizStatusComboBox.getSelectedItem());
				actionlistener.actionPerformed(new QuizActionEvent(e.getSource(),e.getID(),e.getActionCommand(),q));
				
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*
			actionlistener.actionPerformed(new QuizActionEvent(e.getSource(), e.getID(), e.getActionCommand(),
					0,txtOnderwerp.getText(),lj,chckbxIsTest.isSelected(), chckbxIsUniekeDeelname.isSelected(),
					(Leraar)auteurComboBox.getSelectedItem(),new Datum(),(QuizStatus)quizStatusComboBox.getSelectedItem()));
			*/
		}
		else if (e.getSource()==toevoegButton){
			//toevoegen van opdrachten tot een quiz
		} 
		else if (e.getSource()==verwijderButton){
			//verwijderen van opdrachten van een quiz
		}
		else if (e.getSource()==opdrCategorieCb){
			// Filter opdrachten op categorie
			opdrachtRefresh((OpdrachtCategorie)opdrCategorieCb.getSelectedItem());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == listOpdrachten){
			
		}
		
	}
	@Override
	public void update(Observable changedModel, Object arg1) {
		
	}
	
	private void quizRefresh(){
		defaultListModelQuiz.removeAllElements();
		for (Quiz quiz: quizcl.getCatalogus()){
			defaultListModelQuiz.addElement(quiz);
		}
	}
	
	private void opdrachtRefresh(OpdrachtCategorie cat){
		defaultListModelOpdracht.removeAllElements();
		if (cat==null || cat.equals(OpdrachtCategorie.TBA)){
		for (Opdracht opdracht: opdrachtcl.getCatalogus()){
			defaultListModelOpdracht.addElement(opdracht);
		}}
		else{
			for (Opdracht opdracht: opdrachtcl.getCatalogus()){
				if (opdracht.getOpdrachtCategorie()==cat)
				defaultListModelOpdracht.addElement(opdracht);
			}
		}
		
	}
}
