package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;

import config.IniFileManager;

import javax.swing.DefaultComboBoxModel;

import persistence.enums.ContextType;
import persistence.DataContext;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.geom.Dimension2D;
import java.awt.Toolkit;
import java.awt.Dimension;

import controller.*;
import model.ObservableOpdrachtCatalogus;
import model.ObservableQuizCatalogus;
import model.Quiz;
import model.baseclasses.Opdracht;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextPane;

import view.CreatieQuizView;

public class QuizApp {

	private JFrame frame;
	private static DataContext datacontext=null;
	private static ObservableOpdrachtCatalogus opdrachtcatalogus = null;
	private static ObservableQuizCatalogus quizcatalogus =  null;
	
	//for test purposes - aanmaken quiz
	private String[] Leerjaren = {"1","2","3","4","5","6"};
	private DefaultListModel testOpdracht = new DefaultListModel();
	private DefaultListModel testQuiz = new DefaultListModel();
	private String[] tableColumNames = {"Opdracht","Score"};
	private Object [] [] tableData = {{"Test1","1"},{"Test2","2"}};
	private JComboBox<OpdrachtCategorie> opdrCategorieCb;
	private JComboBox<QuizStatus> quizStatusComboBox;
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
	private JTable table;
	private JList listOpdrachten;
	private JList listQuizen;

	private static DataContext getDatacontext() {
		return datacontext;
	}

	private static void setDatacontext(DataContext datacontext) {
		QuizApp.datacontext = datacontext;
	}

	private static ObservableOpdrachtCatalogus getOpdrachtcatalogus() {
		return opdrachtcatalogus;
	}

	private static void setOpdrachtcatalogus(
			ObservableOpdrachtCatalogus opdrachtcatalogus) {
		QuizApp.opdrachtcatalogus = opdrachtcatalogus;
	}

	private static ObservableQuizCatalogus getQuizcatalogus() {
		return quizcatalogus;
	}

	private static void setQuizcatalogus(ObservableQuizCatalogus quizcatalogus) {
		QuizApp.quizcatalogus = quizcatalogus;
	}

	/**
	 * Opstarten van de applicatie. 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizApp window = new QuizApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public QuizApp(){
		OpstartController.Initialise(); // Initialiseert ook de andere controllers
		QuizApp.setDatacontext(OpstartController.getDataContext());
		QuizApp.setQuizcatalogus(OpstartController.getQuizCatalogus());
		QuizApp.setOpdrachtcatalogus(OpstartController.getOpdrachtCatalogus());
		this.initialize();
	}

	/**
	 * Initialisatie van het frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		int width = Integer.parseInt(IniFileManager.getInstance().getProperty("appwidth"));
		int height = Integer.parseInt(IniFileManager.getInstance().getProperty("appheight"));
		frame = new JFrame();
		//frame.setLocationRelativeTo(null);
		frame.setSize(1024, 768);
		QuizApp.centreWindow(frame);
		//frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		

		// ****** Titel ******
		JPanel pnlTitel = new JPanel();
		frame.getContentPane().add(pnlTitel, BorderLayout.NORTH);
		
		JLabel lblQuiz = new JLabel("Quiz");
		pnlTitel.add(lblQuiz);
		lblQuiz.setBackground(new Color(222, 184, 135));
		lblQuiz.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		
		// ****** Cards ******
		final JPanel pnlMain = new JPanel();
		frame.getContentPane().add(pnlMain, BorderLayout.CENTER);
		final CardLayout cards = new CardLayout(3, 3);
		pnlMain.setLayout(cards);
		
		// Card: opstart
		JPanel cardOpstart = new JPanel();
		cardOpstart.setLayout(null);
		JLabel lblQuizApplicatie = new JLabel("Quiz applicatie");
		lblQuizApplicatie.setFont(new Font("Calibri", Font.BOLD, 29));
		lblQuizApplicatie.setBounds(270, 25, 188, 25);
		cardOpstart.add(lblQuizApplicatie);
		JTextPane txtpnSanderVan = new JTextPane();
		txtpnSanderVan.setBackground(Color.LIGHT_GRAY);
		txtpnSanderVan.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtpnSanderVan.setEditable(false);
		txtpnSanderVan.setText("Sander Van Der Borght - Tom Scheepers - Tom Vaes - Wim Ombelets");
		txtpnSanderVan.setBounds(98, 173, 583, 44);
		cardOpstart.add(txtpnSanderVan);
		pnlMain.add("opstart",cardOpstart);
		
		// Card: beheer opdrachten
		JPanel cardBeheerOpdrachten = new JPanel();
		cardBeheerOpdrachten.setLayout(new BoxLayout(cardBeheerOpdrachten, BoxLayout.X_AXIS));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		cardBeheerOpdrachten.add(splitPane);
		JLabel lblBeheerOpdrachten = new JLabel("Beheer opdrachten");
		lblBeheerOpdrachten.setFont(new Font("Tahoma", Font.BOLD, 15));
		splitPane.setLeftComponent(lblBeheerOpdrachten);
		JPanel pnlBeheerOpdrachten = new JPanel();
		splitPane.setRightComponent(pnlBeheerOpdrachten);
		pnlMain.add("opdrachten",cardBeheerOpdrachten);
		
		// Card: beheer quizen
		JPanel cardBeheerQuizen = new JPanel();
		pnlMain.add("quizen",cardBeheerQuizen);
		
		// Card: deelnemen
		JPanel cardDeelnemen = new JPanel();
		pnlMain.add("deelnemen",cardDeelnemen);
		
		// Card: Overzicht Scores
		JPanel cardOverzichtScores = new JPanel();
		pnlMain.add("scores",cardOverzichtScores);
		
		// Card: QuizRapport	
		JPanel cardQuizRapport = new JPanel();
		pnlMain.add("rapport",cardQuizRapport);
		
		// Card: QuizLijsten
		
		JPanel cardQuizLijsten = new JPanel();
		pnlMain.add("lijsten",cardQuizLijsten);
		
		// Card: Instellingen
		
		final JPanel cardInstellingen = new JPanel();
		cardInstellingen.setLayout(null);		
		JLabel lblNewLabel = new JLabel("Persistence methode: ");
		lblNewLabel.setBounds(10, 10, 150, 25);
		cardInstellingen.add(lblNewLabel);	
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(ContextType.values()));
		comboBox.setBounds(150, 10, 150, 25);
		cardInstellingen.add(comboBox);
		pnlMain.add("instellingen",cardInstellingen);
		
		// Card: Stoppen
		
		JPanel cardStoppen = new JPanel();
		pnlMain.add("stoppen",cardStoppen);
		
		// Card: beheer quizen menu
		JPanel cardQuizbeheerMenu = new JPanel();
		JButton btnAanmakenVanEen = new JButton("Aanmaken van een quiz");
		btnAanmakenVanEen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cards.show(pnlMain, "quizAanmaken");
			}
		});
		JButton btnAanpassenVanEen = new JButton("Aanpassen van een quiz");
		JButton btnVerwijderenVanEen = new JButton("Verwijderen van een quiz");
		cardQuizbeheerMenu.setLayout(new GridLayout(0, 1, 0, 10));
		cardQuizbeheerMenu.add(btnAanmakenVanEen);
		cardQuizbeheerMenu.add(btnAanpassenVanEen);
		cardQuizbeheerMenu.add(btnVerwijderenVanEen);
		pnlMain.add("cardQuizBeheerMenu",cardQuizbeheerMenu);
		
		// ++++++ Tom Vaes +++++++
		
		// Card: Quiz aanmaken
		
		CreatieQuizView newQuiz = new CreatieQuizView();
		newQuiz.setVisible(true);
		pnlMain.add("quizAanmaken",newQuiz);
		
		cards.first(pnlMain);
		
		// ****** Menu ******
		JPanel pnlMenu = new JPanel();
		frame.getContentPane().add(pnlMenu, BorderLayout.WEST);
		pnlMenu.setLayout(new GridLayout(8, 0, 0, 0));
		
		JButton btnOpdrachten = new JButton("Beheer Opdrachten");	
		btnOpdrachten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cards.show(pnlMain, "opdrachten");
			}
		});
		JButton btnQuizen = new JButton("Beheer Quizen");	
		btnQuizen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnQuizen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cards.show(pnlMain, "cardQuizBeheerMenu");
			}
		});
		JButton btnDeelnemen = new JButton("Deelnemen aan quiz");
		JButton btnOverzichtScores = new JButton("Overzicht Scores");
		JButton btnQuizRapport = new JButton("Quiz rapport");
		JButton btnQuizLijsten = new JButton("Quiz Lijsten");
		JButton btnInstellingen = new JButton("Instellingen");
		btnInstellingen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cards.show(pnlMain, "instellingen");
			}
		});
		JButton btnStoppen = new JButton("Stoppen");
		btnStoppen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AfsluitController.Afsluiten();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		pnlMenu.add(btnOpdrachten);
		pnlMenu.add(btnQuizen);
		pnlMenu.add(btnDeelnemen);
		pnlMenu.add(btnOverzichtScores);
		pnlMenu.add(btnQuizRapport);
		pnlMenu.add(btnQuizLijsten);
		pnlMenu.add(btnInstellingen);
		pnlMenu.add(btnStoppen);
	}
	
	public static void centreWindow(JFrame frame) {
	    Dimension2D dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}
