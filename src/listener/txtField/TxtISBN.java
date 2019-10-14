package listener.txtField;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import Modelo.Libro;
import Vista.addBook;
import Vista.showBook;
import control.paraUI;

public class TxtISBN implements KeyListener {

	private paraUI ui;

	public TxtISBN(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String txtISBN = ui.getAddbook().getTxtISBN().getText();
		if (isLongitud(txtISBN.length()) &&  this.ui.getControl().compareISBN(txtISBN)) {
			this.ui.getAddbook().getBtnModificar().setEnabled(true);
			this.ui.getAddbook().getTxtISBN().setEnabled(false);
			fillTxt(txtISBN);
		} else {
			this.ui.getAddbook().getBtnModificar().setEnabled(false);
		}
	}

	private void fillTxt(String isbn) {
		if (ui.getControl().compareISBN(isbn)) {
			Libro libro = ui.getControl().getLibro(isbn);
			this.ui.getAddbook().getTxtTitulo().setText(libro.getTitulo());
			this.ui.getAddbook().getTxtAutor().setText(libro.getAutor());
			this.ui.getAddbook().getTxtNpag().setText(libro.getNumeroPag());
			this.ui.getAddbook().getTextPrecio().setText(libro.getPrecio());
			this.ui.getAddbook().getSpnCantidad().setValue(Integer.valueOf(libro.getCantidad()));
			
		}
	}

	private boolean  isLongitud(int txtISBN) {
		if (txtISBN == 13 && isNumeric(ui.getAddbook().getTxtISBN().getText()) || txtISBN == 0) {
			ui.getAddbook().getTxtISBN().setBackground(Color.white);
			return true;
		} else
			ui.getAddbook().getTxtISBN().setBackground(Color.red);
		return false;
	}
	

	private static boolean isWord(String word) {
		if (word.isEmpty()) {
			return false;
		}
		return Pattern.matches("[a-zA-Z]+", word);
	}

	public boolean isNumeric(String word) {
		try {
			Pattern.matches("[0-9]*", word);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void soloNumeros(Component component) {
		component.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')) {
					e.consume();
				}
			}
		});
	}
}
