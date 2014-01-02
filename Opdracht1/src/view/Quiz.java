package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;

import config.IniFileManager;

import javax.swing.DefaultComboBoxModel;

import persistence.enums.ContextType;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;

import controller.AfsluitController;

public class Quiz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz window = new Quiz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Quiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int width = Integer.parseInt(IniFileManager.getInstance().getProperty("appwidth"));
		int height = Integer.parseInt(IniFileManager.getInstance().getProperty("appheight"));
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setSize(1024, 768);
		//frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		

		//Titel
		JPanel pnlTitel = new JPanel();
		frame.getContentPane().add(pnlTitel, BorderLayout.NORTH);
		
		JLabel lblQuiz = new JLabel("Quiz");
		pnlTitel.add(lblQuiz);
		lblQuiz.setBackground(new Color(222, 184, 135));
		lblQuiz.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Cards
		final JPanel pnlMain = new JPanel();
		frame.getContentPane().add(pnlMain, BorderLayout.CENTER);
		final CardLayout cards = new CardLayout(3, 3);
		pnlMain.setLayout(cards);
		
		//beheer opdrachten
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
		
		//beheer quizen
		JPanel cardBeheerQuizen = new JPanel();
		pnlMain.add("quizen",cardBeheerQuizen);
		
		//deelnemen
		JPanel cardDeelnemen = new JPanel();
		pnlMain.add("deelnemen",cardDeelnemen);
		
		//Card Overzicht Scores
		JPanel cardOverzichtScores = new JPanel();
		pnlMain.add("scores",cardOverzichtScores);
		
		//Card QuizRapport	
		JPanel cardQuizRapport = new JPanel();
		pnlMain.add("rapport",cardQuizRapport);
		
		// Card QuizLijsten
		
		JPanel cardQuizLijsten = new JPanel();
		pnlMain.add("lijsten",cardQuizLijsten);
		
		//Card Instellingen
		
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
		
		//Card Stoppen
		JPanel cardStoppen = new JPanel();
		pnlMain.add("stoppen",cardStoppen);
		
		//Menu
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
				} catch (Exception e1) {
					// TODO Auto-generated catch block
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
}
