package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * 
 * @author Tom Scheepers
 *
 */

public class VerwijderQuizView extends JPanel {

	private JPanel contentPane;

	public VerwijderQuizView() {
		setLayout(new BorderLayout(0, 0));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		add(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JLabel lblQuizVerwijderen = new JLabel("Quiz verwijderen");
		lblQuizVerwijderen.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setLeftComponent(lblQuizVerwijderen);
		
		JPanel pnlVerwijderenContent = new JPanel();
		splitPane.setRightComponent(pnlVerwijderenContent);

	}
}
