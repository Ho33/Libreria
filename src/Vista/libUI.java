package Vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class libUI extends JFrame {

	private JPanel contentPane;
	private JMenu jmenuAlta;
	protected addBook addBook = new addBook(Color.cyan);
	protected showBook showBook = new showBook();
	protected JMenuItem itemAddBook = new JMenuItem("addbook");
	protected JMenuItem itemListado = new JMenuItem("showbook");
	private JMenu jmenuLista;
	private JPanel white = new JPanel();
	private final JLabel lblLaLibreriaSin = getAddbook().addImage("/lib.png");
	protected infoLibros info;
	protected JButton editar = new JButton();
	
	/**
	 * Create the frame.
	 */

	public libUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);
		setResizable(true);
		setVisible(true);

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		jmenuAlta = new JMenu("Alta");
		jmenuLista = new JMenu("Vista");
		menuBar.add(jmenuAlta);
		menuBar.add(jmenuLista);

		this.contentPane.add(white, "white");
		white.setLayout(new GridLayout(0, 1, 0, 0));
		lblLaLibreriaSin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaLibreriaSin.setFont(new Font("Tahoma", Font.PLAIN, 42));
		white.add(lblLaLibreriaSin);
		this.contentPane.add(addBook, "addbook");
		this.contentPane.add(showBook, "showbook");
		incluirItem(jmenuAlta, itemAddBook);
		incluirItem(jmenuLista, itemListado);
		
		
	}

	private void incluirItem(JMenu menu, JMenuItem item) {
		item.setForeground(new Color(22, 85, 148));
		item.setBackground(Color.WHITE);
		menu.add(item);
	}
	
	public String[][] getData(){
		return showBook.getData();
	}
	public void rellenarLib(String[][] libro) {
		this.showBook.rellenarLibro(libro);
	}
	public void deselectedEverything() {
		addBook.disableField();
	}

	public String getCheckBoxTipe() {
		return addBook.getCheckBoxTipe();
	}
	public String getCheckBoxStatus() {
		return addBook.getCheckBoxStatus();
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JMenu getJmenuAlta() {
		return jmenuAlta;
	}

	public addBook getAddbook() {
		return addBook;
	}

	public JMenuItem getItemListado() {
		return itemListado;
	}

	public showBook getShowBook() {
		return showBook;
	}

	public void asociarPanel(String string) {
		((CardLayout) contentPane.getLayout()).show(contentPane, string);
	}

	public JMenu getJmenuLista() {
		return jmenuLista;
	}

	public JMenuItem getItemAddBook() {
		return itemAddBook;
	}

	public JButton getEditar() {
		return editar;
	}
	
	
}
