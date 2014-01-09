package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Quiz;
import model.enums.Leraar;

import java.util.Observable;
import java.util.Observer;

public class CreatieQuizView extends JPanel implements Observer, ActionListener {
	
	private static final long serialVersionUID = -3041414196751715178L;
	private JTextField textFieldOnderwerp;
	private JTextField textField;
	private JLabel lblLeerjaren;
	private JCheckBox chkBox1eJaar;
	private JCheckBox chkBox2eJaar;
	private JCheckBox chkBox3eJaar;
	private JCheckBox chkBox4eJaar;
	private JCheckBox chkBox5eJaar;
	private JCheckBox chkBox6eJaar;
	private JCheckBox chkBoxIsTest;
	private JCheckBox chkBoxIsUniekeDeelname;
	private JComboBox<Leraar> comboBoxLeraar;
	private JLabel lblLeraar;
	private JLabel lblDatum;
	private JLabel lblQuizOpdrachten;
	private JButton btnOpslaan;
	private JButton btnWissen;
	private ActionListener listener;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatieQuizView frame = new CreatieQuizView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	*/
	//getters & setters
	public ActionListener getActionListener(){
		return listener;
	}
	
	public void setActionListener(ActionListener listener){
		this.listener = listener;
	}
	
	// Constructor
	public CreatieQuizView() {
		
		initialize();
		
	}
	
	private void initialize() {
		setLayout(null);
		
		JLabel lblOnderwerp = new JLabel("Onderwerp");
		lblOnderwerp.setBounds(10, 14, 86, 14);
		add(lblOnderwerp);
		
		textFieldOnderwerp = new JTextField();
		textFieldOnderwerp.setBounds(116, 11, 326, 20);
		add(textFieldOnderwerp);
		textFieldOnderwerp.setColumns(10);
		
		lblLeerjaren = new JLabel("Leerjaren");
		lblLeerjaren.setBounds(10, 39, 86, 14);
		add(lblLeerjaren);
		
		chkBox1eJaar = new JCheckBox("1e jaar");
		chkBox1eJaar.setBounds(116, 35, 70, 23);
		add(chkBox1eJaar);
		
		chkBox2eJaar = new JCheckBox("2e jaar");
		chkBox2eJaar.setBounds(244, 35, 70, 23);
		add(chkBox2eJaar);
		
		chkBox3eJaar = new JCheckBox("3e jaar");
		chkBox3eJaar.setBounds(372, 35, 70, 23);
		add(chkBox3eJaar);
		
		chkBox4eJaar = new JCheckBox("4e jaar");
		chkBox4eJaar.setBounds(116, 61, 70, 23);
		add(chkBox4eJaar);
		
		chkBox5eJaar = new JCheckBox("5e jaar");
		chkBox5eJaar.setBounds(244, 61, 70, 23);
		add(chkBox5eJaar);
		
		chkBox6eJaar = new JCheckBox("6e jaar");
		chkBox6eJaar.setBounds(372, 61, 70, 23);
		add(chkBox6eJaar);
		
		chkBoxIsTest = new JCheckBox("Is Test");
		chkBoxIsTest.setBounds(10, 102, 70, 23);
		add(chkBoxIsTest);
		
		chkBoxIsUniekeDeelname = new JCheckBox("Is Unieke Deelname");
		chkBoxIsUniekeDeelname.setBounds(116, 102, 145, 23);
		add(chkBoxIsUniekeDeelname);
		
		comboBoxLeraar = new JComboBox<Leraar>();
		comboBoxLeraar.setBounds(150, 132, 128, 20);
		comboBoxLeraar.setModel(new DefaultComboBoxModel<Leraar>(Leraar.values()));
		add(comboBoxLeraar);
		
		lblLeraar = new JLabel("Leraar");
		lblLeraar.setBounds(10, 135, 76, 14);
		add(lblLeraar);
		
		lblDatum = new JLabel("Datum (dd/MM/yyyy)");
		lblDatum.setBounds(10, 160, 130, 14);
		add(lblDatum);
		
		textField = new JTextField();
		textField.setBounds(150, 157, 164, 20);
		textField.setColumns(10);
		add(textField);
		
		lblQuizOpdrachten = new JLabel("Quiz Opdrachten");
		lblQuizOpdrachten.setBounds(10, 185, 97, 14);
		add(lblQuizOpdrachten);
		
		btnOpslaan = new JButton("Opslaan");
		btnOpslaan.setBounds(334, 349, 108, 23);
		btnOpslaan.setActionCommand("addQuiz");
		btnOpslaan.addActionListener(this);
		add(btnOpslaan);
		
		btnWissen = new JButton("Wissen");
		btnWissen.setBounds(217, 349, 108, 23);
		btnWissen.setActionCommand("deleteQuiz");
		btnWissen.addActionListener(this);
		add(btnWissen);
		setVisible(true);
	}
	

	public void actionPerformed (ActionEvent e) {
		
		if(e.getSource() == btnWissen)
			ingaveWissen();
		else if(e.getSource() == btnOpslaan)
			ingaveOpslaan();
		
	}
	private void ingaveWissen() {
		JOptionPane.showMessageDialog(null, "btnWissen werd geklikt");
	}
	
	private void ingaveOpslaan() {
		//JOptionPane.showMessageDialog(null, "btnOpslaan werd geklikt");
		
		Quiz q = valideer();
		if(q != null) {
			//CreatieQuizController controller = new CreatieQuizController();
			//controller.opslaan(q);
		}
		else {
			JOptionPane.showMessageDialog(null, "valideer method not yet implemented");
		}
	}
	
	private Quiz valideer() {
		
		//valideer alle ingaves hier
		//als alles ok is, return dan en Quiz object
		//ander null
		
		return null;
	}
	
	@Override
	public void update(Observable changedModel, Object arg1) {
			
		}
}
