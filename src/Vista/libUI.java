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
	protected JMenuItem itemAddBook = new JMenuItem("Nuevo");
	protected JMenuItem itemListado = new JMenuItem("Mostrar");
	protected JMenuItem itemTema = new JMenuItem("A�adir tema");
	private JMenu jmenuLista;
	private JPanel white = new JPanel();
	private final JLabel lblLaLibreriaSin = getAddbook().addImage("/lib.png");
	protected infoLibros info;
	protected JButton editar = new JButton();
	private final JLabel lblBienvenido = new JLabel("BIENVENIDO");

	/**
	 * Create the frame.
	 */

	public libUI() {
		setBounds(100, 100, 950, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);
		setResizable(true);
		setVisible(true);

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		jmenuAlta = new JMenu("Gestion");
		jmenuLista = new JMenu("Tienda");
		menuBar.add(jmenuAlta);
		menuBar.add(jmenuLista);

		white.setLayout(new CardLayout(0, 0));
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		
		white.add(showBook, "name_81895743499600");
		lblLaLibreriaSin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaLibreriaSin.setFont(new Font("Tahoma", Font.PLAIN, 42));
		this.contentPane.add(showBook, "showbook");
		this.contentPane.add(addBook, "addbook");
		incluirItem(jmenuAlta, itemAddBook);
		incluirItem(jmenuLista, itemListado);
		incluirItem(jmenuAlta, itemTema);

	}

	private void incluirItem(JMenu menu, JMenuItem item) {
		item.setForeground(new Color(22, 85, 148));
		item.setBackground(Color.WHITE);
		menu.add(item);
	}

	public String[][] getData() {
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

	public JMenuItem getItemTema() {
		return itemTema;
	}
	
}
