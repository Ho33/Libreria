package Vista;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class addLibro extends JDialog {

	private JPanel contentPanel = new JPanel();
	private addBook addbook = new addBook(Color.cyan);


	public addLibro() {
		setBounds(100, 100, 1200, 820);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new CardLayout(0, 0));
		contentPanel.add(addbook, "addbook");
		setContentPane(contentPanel);
		setResizable(true);
		setVisible(true);
		addbook.setVisible(true);
	}

	public addBook getAddbook() {
		return addbook;
	}
	
}
