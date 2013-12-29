package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.enums.*;
import java.awt.Font;

public class WijzigQuizView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404581544561582423L;
	private JPanel contentPane;
	private JTextField txb_onderwerp;
	private JTextField txb_leerjaren;
	private JTextField txb_datumQuiz;
	private JTextField txb_maxScore;
	private JTextField txb_maxAantalPogingen;
	private JTextField txb_maxAntwoordtijd;
	private JTextField txb_juisteAntwoord;
	private JTextField txb_hints;
	private JTextField txb_datumOpdracht;
	private JComboBox cmb_opdrachten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WijzigQuizView frame = new WijzigQuizView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WijzigQuizView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGroepT = new JLabel("Groep T - 2013");
		lblGroepT.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGroepT.setBounds(5, 460, 785, 14);
		lblGroepT.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGroepT);
		
		JLabel lblKiesQuiz = new JLabel("Kies quiz:");
		lblKiesQuiz.setBounds(5, 29, 56, 14);
		contentPane.add(lblKiesQuiz);
		
		JComboBox cmb_kiesQuiz = new JComboBox();
		cmb_kiesQuiz.setBounds(80, 29, 214, 20);
		contentPane.add(cmb_kiesQuiz);
		
		JLabel lblOnderwerp = new JLabel("Onderwerp");
		lblOnderwerp.setBounds(5, 139, 64, 14);
		contentPane.add(lblOnderwerp);
		
		txb_onderwerp = new JTextField();
		txb_onderwerp.setBounds(80, 136, 145, 20);
		contentPane.add(txb_onderwerp);
		txb_onderwerp.setColumns(10);
		
		JLabel lblLeerjaren = new JLabel("Leerjaren");
		lblLeerjaren.setBounds(5, 175, 65, 14);
		contentPane.add(lblLeerjaren);
		
		txb_leerjaren = new JTextField();
		txb_leerjaren.setBounds(80, 172, 145, 20);
		contentPane.add(txb_leerjaren);
		txb_leerjaren.setColumns(10);
		
		JCheckBox chckbx_isTest = new JCheckBox("Is test?");
		chckbx_isTest.setBounds(80, 216, 97, 23);
		contentPane.add(chckbx_isTest);
		
		JCheckBox chckbx_Isuniekedeelname = new JCheckBox("isUniekeDeelname");
		chckbx_Isuniekedeelname.setBounds(80, 242, 122, 23);
		contentPane.add(chckbx_Isuniekedeelname);
		
		JComboBox cmb_auteurQuiz = new JComboBox(Leraar.values());
		cmb_auteurQuiz.setBounds(149, 356, 145, 20);
		contentPane.add(cmb_auteurQuiz);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(5, 356, 46, 14);
		contentPane.add(lblAuteur);
		
		JLabel lblDatumRegistratie = new JLabel("Datum registratie");
		lblDatumRegistratie.setBounds(5, 390, 134, 14);
		contentPane.add(lblDatumRegistratie);
		
		txb_datumQuiz = new JTextField();
		txb_datumQuiz.setEditable(false);
		txb_datumQuiz.setBounds(149, 387, 145, 20);
		contentPane.add(txb_datumQuiz);
		txb_datumQuiz.setColumns(10);
		
		JLabel lblQuizstatus = new JLabel("Quizstatus");
		lblQuizstatus.setBounds(5, 73, 97, 14);
		contentPane.add(lblQuizstatus);
		
		JComboBox cmb_quizStatus = new JComboBox(QuizStatus.values());
		cmb_quizStatus.setSelectedIndex(-1);
		cmb_quizStatus.setBounds(80, 70, 145, 20);
		contentPane.add(cmb_quizStatus);
		
		JLabel lblNewLabel = new JLabel("Kies opdracht:");
		lblNewLabel.setBounds(338, 73, 86, 14);
		contentPane.add(lblNewLabel);
		
		JButton btn_QuizgegevensOpslaan = new JButton("Quizgegevens opslaan");
		btn_QuizgegevensOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btn_QuizgegevensOpslaan.setBounds(80, 426, 145, 23);
		contentPane.add(btn_QuizgegevensOpslaan);
		
		cmb_opdrachten = new JComboBox();
		cmb_opdrachten.setBounds(505, 70, 191, 20);
		contentPane.add(cmb_opdrachten);
		
		JLabel lblMaxScore = new JLabel("Max score");
		lblMaxScore.setBounds(338, 124, 69, 14);
		contentPane.add(lblMaxScore);
		
		txb_maxScore = new JTextField();
		txb_maxScore.setBounds(505, 121, 86, 20);
		contentPane.add(txb_maxScore);
		txb_maxScore.setColumns(10);
		
		JLabel lblVraag = new JLabel("Vraag");
		lblVraag.setBounds(338, 152, 46, 14);
		contentPane.add(lblVraag);
		
		JTextField txb_vraag = new JTextField();
		txb_vraag.setBounds(505, 149, 235, 20);
		contentPane.add(txb_vraag);
		txb_vraag.setColumns(10);
		
		JLabel lblMaxAantalPogingen = new JLabel("Max aantal pogingen");
		lblMaxAantalPogingen.setBounds(338, 178, 165, 14);
		contentPane.add(lblMaxAantalPogingen);
		
		txb_maxAantalPogingen = new JTextField();
		txb_maxAantalPogingen.setBounds(505, 172, 56, 20);
		contentPane.add(txb_maxAantalPogingen);
		txb_maxAantalPogingen.setColumns(10);
		
		JLabel lblMaxAntwoordtijd = new JLabel("Max antwoordtijd");
		lblMaxAntwoordtijd.setBounds(338, 206, 165, 14);
		contentPane.add(lblMaxAntwoordtijd);
		
		txb_maxAntwoordtijd = new JTextField();
		txb_maxAntwoordtijd.setColumns(10);
		txb_maxAntwoordtijd.setBounds(505, 203, 56, 20);
		contentPane.add(txb_maxAntwoordtijd);
		
		JLabel lblJuisteAntwoord = new JLabel("Juiste antwoord");
		lblJuisteAntwoord.setBounds(338, 234, 97, 14);
		contentPane.add(lblJuisteAntwoord);
		
		txb_juisteAntwoord = new JTextField();
		txb_juisteAntwoord.setBounds(505, 231, 235, 20);
		contentPane.add(txb_juisteAntwoord);
		txb_juisteAntwoord.setColumns(10);
		
		JLabel lblHints = new JLabel("Hints");
		lblHints.setBounds(338, 259, 46, 14);
		contentPane.add(lblHints);
		
		txb_hints = new JTextField();
		txb_hints.setBounds(505, 256, 235, 81);
		contentPane.add(txb_hints);
		txb_hints.setColumns(10);
		
		JComboBox cmb_auteurOpdracht = new JComboBox(Leraar.values());
		cmb_auteurOpdracht.setBounds(595, 348, 145, 20);
		contentPane.add(cmb_auteurOpdracht);
		
		JLabel label = new JLabel("Auteur");
		label.setBounds(424, 351, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Datum registratie");
		label_1.setBounds(424, 382, 161, 14);
		contentPane.add(label_1);
		
		txb_datumOpdracht = new JTextField();
		txb_datumOpdracht.setEditable(false);
		txb_datumOpdracht.setColumns(10);
		txb_datumOpdracht.setBounds(595, 379, 145, 20);
		contentPane.add(txb_datumOpdracht);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(338, 99, 69, 14);
		contentPane.add(lblCategorie);
		
		JComboBox cmb_opdrachtCategorie = new JComboBox(OpdrachtCategorie.values());
		cmb_opdrachtCategorie.setBounds(505, 96, 145, 20);
		contentPane.add(cmb_opdrachtCategorie);
		
		JButton btn_OpdrachtOpslaan = new JButton("Opdracht opslaan");
		btn_OpdrachtOpslaan.setBounds(505, 426, 145, 23);
		contentPane.add(btn_OpdrachtOpslaan);
		
		JLabel lblWijzigQuiz = new JLabel("Wijzig quiz");
		lblWijzigQuiz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWijzigQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblWijzigQuiz.setBounds(5, 0, 785, 23);
		contentPane.add(lblWijzigQuiz);
		
		setUpComboBoxes();
	}
	
	private void setUpComboBoxes(){
		
	}
	
}
