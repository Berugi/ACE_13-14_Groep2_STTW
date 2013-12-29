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

public class WijzigQuizView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404581544561582423L;
	private JPanel contentPane;
	private JTextField txb_onderwerp;
	private JTextField txb_leerjaren;
	private JTextField txb_datumQuiz;
	private JTextField cmb_maxScore;
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
		setBounds(100, 100, 700, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGroepT = new JLabel("Groep T - 2013");
		lblGroepT.setBounds(5, 460, 679, 14);
		lblGroepT.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGroepT);
		
		JLabel lblKiesQuiz = new JLabel("Kies quiz:");
		lblKiesQuiz.setBounds(5, 29, 56, 14);
		contentPane.add(lblKiesQuiz);
		
		JComboBox cmb_kiesQuiz = new JComboBox();
		cmb_kiesQuiz.setBounds(71, 26, 165, 20);
		contentPane.add(cmb_kiesQuiz);
		
		JLabel lblOnderwerp = new JLabel("Onderwerp");
		lblOnderwerp.setBounds(5, 139, 64, 14);
		contentPane.add(lblOnderwerp);
		
		txb_onderwerp = new JTextField();
		txb_onderwerp.setBounds(91, 136, 145, 20);
		contentPane.add(txb_onderwerp);
		txb_onderwerp.setColumns(10);
		
		JLabel lblLeerjaren = new JLabel("Leerjaren");
		lblLeerjaren.setBounds(5, 175, 46, 14);
		contentPane.add(lblLeerjaren);
		
		txb_leerjaren = new JTextField();
		txb_leerjaren.setBounds(91, 172, 145, 20);
		contentPane.add(txb_leerjaren);
		txb_leerjaren.setColumns(10);
		
		JCheckBox chckbx_isTest = new JCheckBox("Is test?");
		chckbx_isTest.setBounds(81, 213, 97, 23);
		contentPane.add(chckbx_isTest);
		
		JCheckBox chckbx_Isuniekedeelname = new JCheckBox("isUniekeDeelname");
		chckbx_Isuniekedeelname.setBounds(81, 239, 122, 23);
		contentPane.add(chckbx_Isuniekedeelname);
		
		JComboBox cmb_auteurQuiz = new JComboBox();
		cmb_auteurQuiz.setBounds(91, 353, 145, 20);
		contentPane.add(cmb_auteurQuiz);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(5, 356, 46, 14);
		contentPane.add(lblAuteur);
		
		JLabel lblDatumRegistratie = new JLabel("Datum registratie");
		lblDatumRegistratie.setBounds(5, 387, 97, 14);
		contentPane.add(lblDatumRegistratie);
		
		txb_datumQuiz = new JTextField();
		txb_datumQuiz.setEditable(false);
		txb_datumQuiz.setBounds(91, 384, 145, 20);
		contentPane.add(txb_datumQuiz);
		txb_datumQuiz.setColumns(10);
		
		JLabel lblQuizstatus = new JLabel("Quizstatus");
		lblQuizstatus.setBounds(5, 73, 97, 14);
		contentPane.add(lblQuizstatus);
		
		JComboBox cmb_quizStatus = new JComboBox();
		cmb_quizStatus.setBounds(91, 70, 145, 20);
		contentPane.add(cmb_quizStatus);
		
		JLabel lblNewLabel = new JLabel("Kies opdracht:");
		lblNewLabel.setBounds(338, 73, 86, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnQuizgegevensOpslaan = new JButton("Quizgegevens opslaan");
		btnQuizgegevensOpslaan.setBounds(118, 426, 145, 23);
		contentPane.add(btnQuizgegevensOpslaan);
		
		cmb_opdrachten = new JComboBox();
		cmb_opdrachten.setBounds(464, 70, 191, 20);
		contentPane.add(cmb_opdrachten);
		
		JLabel lblMaxScore = new JLabel("Max score");
		lblMaxScore.setBounds(338, 124, 69, 14);
		contentPane.add(lblMaxScore);
		
		cmb_maxScore = new JTextField();
		cmb_maxScore.setBounds(569, 121, 86, 20);
		contentPane.add(cmb_maxScore);
		cmb_maxScore.setColumns(10);
		
		JLabel lblVraag = new JLabel("Vraag");
		lblVraag.setBounds(338, 152, 46, 14);
		contentPane.add(lblVraag);
		
		JTextField txb_vraag = new JTextField();
		txb_vraag.setBounds(420, 149, 235, 20);
		contentPane.add(txb_vraag);
		txb_vraag.setColumns(10);
		
		JLabel lblMaxAantalPogingen = new JLabel("Max aantal pogingen");
		lblMaxAantalPogingen.setBounds(338, 178, 113, 14);
		contentPane.add(lblMaxAantalPogingen);
		
		txb_maxAantalPogingen = new JTextField();
		txb_maxAantalPogingen.setBounds(599, 175, 56, 20);
		contentPane.add(txb_maxAantalPogingen);
		txb_maxAantalPogingen.setColumns(10);
		
		JLabel lblMaxAntwoordtijd = new JLabel("Max antwoordtijd");
		lblMaxAntwoordtijd.setBounds(338, 206, 97, 14);
		contentPane.add(lblMaxAntwoordtijd);
		
		txb_maxAntwoordtijd = new JTextField();
		txb_maxAntwoordtijd.setColumns(10);
		txb_maxAntwoordtijd.setBounds(599, 203, 56, 20);
		contentPane.add(txb_maxAntwoordtijd);
		
		JLabel lblJuisteAntwoord = new JLabel("Juiste antwoord");
		lblJuisteAntwoord.setBounds(338, 234, 97, 14);
		contentPane.add(lblJuisteAntwoord);
		
		txb_juisteAntwoord = new JTextField();
		txb_juisteAntwoord.setBounds(420, 231, 235, 20);
		contentPane.add(txb_juisteAntwoord);
		txb_juisteAntwoord.setColumns(10);
		
		JLabel lblHints = new JLabel("Hints");
		lblHints.setBounds(338, 259, 46, 14);
		contentPane.add(lblHints);
		
		txb_hints = new JTextField();
		txb_hints.setBounds(420, 256, 235, 81);
		contentPane.add(txb_hints);
		txb_hints.setColumns(10);
		
		JComboBox cmb_auteurOpdracht = new JComboBox();
		cmb_auteurOpdracht.setBounds(510, 348, 145, 20);
		contentPane.add(cmb_auteurOpdracht);
		
		JLabel label = new JLabel("Auteur");
		label.setBounds(424, 351, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Datum registratie");
		label_1.setBounds(424, 382, 97, 14);
		contentPane.add(label_1);
		
		txb_datumOpdracht = new JTextField();
		txb_datumOpdracht.setEditable(false);
		txb_datumOpdracht.setColumns(10);
		txb_datumOpdracht.setBounds(510, 379, 145, 20);
		contentPane.add(txb_datumOpdracht);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(338, 99, 69, 14);
		contentPane.add(lblCategorie);
		
		JComboBox cmb_opdrachtCategorie = new JComboBox();
		cmb_opdrachtCategorie.setBounds(510, 96, 145, 20);
		contentPane.add(cmb_opdrachtCategorie);
		
		JButton btnOpdrachtOpslaan = new JButton("Opdracht opslaan");
		btnOpdrachtOpslaan.setBounds(529, 426, 145, 23);
		contentPane.add(btnOpdrachtOpslaan);
	}
}
