package listener.txtField;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import Vista.addBook;
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
		int txtISBN = ui.getAddbook().getTxtISBN().getText().length();
		if (txtISBN == 13 && isNumeric(ui.getAddbook().getTxtISBN().getText()) || txtISBN == 0) {
			ui.getAddbook().getTxtISBN().setBackground(Color.white);

		} else
			ui.getAddbook().getTxtISBN().setBackground(Color.red);

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
